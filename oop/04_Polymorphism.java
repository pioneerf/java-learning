/**
 * 面向对象：多态（Polymorphism）
 *
 * 多态是OOP三大特性之一，核心思想：
 * - 同一类型的引用，在不同情况下表现不同的行为
 * - 多态的三个必要条件：
 *   1. 继承（或实现接口）
 *   2. 方法重写（Override）
 *   3. 父类引用指向子类对象
 */

// ========== 定义员工体系 ==========

/**
 * 员工类（父类）
 */
class Employee {

    protected String name;
    protected double baseSalary;  // 基本工资

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // 计算薪水（将被重写）
    public double calculateSalary() {
        return baseSalary;
    }

    // 工作（将被重写）
    public void work() {
        System.out.println(name + "正在工作...");
    }

    public void displayInfo() {
        System.out.println("姓名：" + name + "，本月工资：" + calculateSalary() + "元");
    }
}

/**
 * 经理类（子类）
 */
class Manager extends Employee {

    private double bonus;  // 奖金
    private int teamSize;  // 团队人数

    public Manager(String name, double baseSalary, double bonus, int teamSize) {
        super(name, baseSalary);
        this.bonus = bonus;
        this.teamSize = teamSize;
    }

    @Override
    public double calculateSalary() {
        // 经理工资 = 基本工资 + 奖金
        return baseSalary + bonus;
    }

    @Override
    public void work() {
        System.out.println("经理" + name + "在管理" + teamSize + "人的团队");
    }
}

/**
 * 程序员类（子类）
 */
class Programmer extends Employee {

    private int overtimeHours;  // 加班小时数
    private static final double OVERTIME_RATE = 50;  // 加班费率（元/小时）

    public Programmer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateSalary() {
        // 程序员工资 = 基本工资 + 加班费
        return baseSalary + overtimeHours * OVERTIME_RATE;
    }

    @Override
    public void work() {
        System.out.println("程序员" + name + "在写代码，加班" + overtimeHours + "小时");
    }

    // 程序员特有方法
    public void debug() {
        System.out.println(name + "在调试程序...");
    }
}

/**
 * 实习生类（子类）
 */
class Intern extends Employee {

    public Intern(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        // 实习生工资打八折
        return baseSalary * 0.8;
    }

    @Override
    public void work() {
        System.out.println("实习生" + name + "在学习并协助工作");
    }
}


/**
 * 测试多态
 */
public class Polymorphism {

    public static void main(String[] args) {

        System.out.println("===== 多态示例 =====\n");

        // ===== 多态：同一个父类引用，指向不同子类对象 =====

        // 创建员工数组（父类类型）
        Employee[] employees = new Employee[4];
        employees[0] = new Manager("张三", 8000, 5000, 10);    // 经理
        employees[1] = new Programmer("李四", 6000, 30);       // 程序员
        employees[2] = new Intern("王五", 3000);               // 实习生
        employees[3] = new Programmer("赵六", 6500, 20);       // 另一个程序员

        // 多态调用：同一个方法名，不同子类有不同行为
        System.out.println("--- 计算所有人的工资（多态） ---");
        for (Employee emp : employees) {
            emp.work();                    // 调用重写后的work方法
            emp.displayInfo();             // 调用重写后的薪水计算方法
            System.out.println();
        }

        // ===== 多态的用途：方法的参数多态 =====
        System.out.println("--- 方法参数多态 ---");

        // 定义一个方法，接受Employee类型参数（可以是任何子类）
        printEmployeeInfo(employees[0]);  // 传入Manager
        printEmployeeInfo(employees[1]);  // 传入Programmer
        printEmployeeInfo(employees[2]);  // 传入Intern

        // ===== instanceof 和类型转换 =====
        System.out.println("\n--- instanceof 类型判断 ---");

        for (Employee emp : employees) {
            if (emp instanceof Programmer) {
                // 向下转型（Downcasting）：将父类引用转回子类引用
                Programmer p = (Programmer) emp;
                p.debug();  // 调用Programmer特有的方法
            }
        }

        // ===== 多态的好处 =====
        System.out.println("\n===== 多态的好处 =====");
        System.out.println("1. 可扩展性：新增员工类型不需要修改现有代码");
        System.out.println("2. 统一处理：可以用同一个数组或集合管理不同类型的对象");
        System.out.println("3. 代码复用：父类定义通用行为，子类实现具体细节");
        System.out.println("4. 接口编程：面向抽象编程，降低耦合度");
    }

    /**
     * 多态方法：接受任何Employee类型（或其子类）
     * 不需要为每种员工类型编写单独的方法
     */
    public static void printEmployeeInfo(Employee emp) {
        System.out.println("--- 员工信息摘要 ---");
        System.out.println("职位类型：" + emp.getClass().getSimpleName());  // 获取实际类型名
        emp.work();
        System.out.println("工资：" + emp.calculateSalary() + "元");
    }
}