/**
 * 面向对象：封装（Encapsulation）
 *
 * 封装是OOP三大特性之一，核心思想：
 * 1. 将数据（属性）和方法（行为）捆绑在类中
 * 2. 隐藏内部实现细节，对外提供公共访问方法
 * 3. 通过访问修饰符控制访问权限
 *
 * 访问修饰符（从最严格到最宽松）：
 * private   - 仅本类内部可访问
 * 默认     - 本包内可访问（不加任何修饰符）
 * protected - 本包 + 子类可访问
 * public    - 任何地方都可访问
 */

/**
 * 封装的银行账户类
 */
class BankAccount {

    // ===== 私有属性（外部不能直接访问） =====
    private String accountNumber;  // 账号
    private String ownerName;      // 户主姓名
    private double balance;        // 余额
    private String password;       // 密码
    private static final double MIN_BALANCE = 0.0;  // 最低余额（常 量）

    // ===== 构造方法 =====
    public BankAccount(String accountNumber, String ownerName, String password) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.password = password;
        this.balance = 0.0;  // 初始余额为0
    }

    // ===== 公开的getter和setter方法 =====

    // getter - 获取属性值（只读，不提供修改方法）
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    /**
     * 获取余额（只读，不直接暴露setter）
     * 余额只能通过存款/取款操作来改变
     */
    public double getBalance() {
        return balance;
    }

    // ===== 业务方法 =====

    /**
     * 存款
     * @param amount 存款金额
     * @param password 密码验证
     * @return 是否成功
     */
    public boolean deposit(double amount, String password) {
        // 业务逻辑验证
        if (amount <= 0) {
            System.out.println("存款金额必须大于0！");
            return false;
        }
        if (!this.password.equals(password)) {
            System.out.println("密码错误！");
            return false;
        }

        balance += amount;
        System.out.println("存款成功！存入" + amount + "元，当前余额：" + balance + "元");
        return true;
    }

    /**
     * 取款
     * @param amount 取款金额
     * @param password 密码验证
     * @return 是否成功
     */
    public boolean withdraw(double amount, String password) {
        // 多重验证，隐藏内部逻辑
        if (amount <= 0) {
            System.out.println("取款金额必须大于0！");
            return false;
        }
        if (!this.password.equals(password)) {
            System.out.println("密码错误！");
            return false;
        }
        if (amount > balance) {
            System.out.println("余额不足！当前余额：" + balance + "元，试图取款：" + amount + "元");
            return false;
        }

        balance -= amount;
        System.out.println("取款成功！取出" + amount + "元，当前余额：" + balance + "元");
        return true;
    }

    /**
     * 修改密码
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 是否成功
     */
    public boolean changePassword(String oldPassword, String newPassword) {
        if (!this.password.equals(oldPassword)) {
            System.out.println("原密码错误！");
            return false;
        }
        if (newPassword == null || newPassword.length() < 6) {
            System.out.println("新密码长度不能少于6位！");
            return false;
        }

        this.password = newPassword;
        System.out.println("密码修改成功！");
        return true;
    }

    /**
     * 显示账户信息（隐藏敏感信息）
     */
    public void displayInfo() {
        System.out.println("===== 账户信息 =====");
        System.out.println("账号：" + accountNumber);
        System.out.println("户主：" + ownerName);
        System.out.println("余额：" + balance + "元");
        System.out.println("密码：******");  // 隐藏密码
        System.out.println("===================");
    }

    // ===== 包级私有的辅助方法（默认访问权限） =====
    // 这些方法只能在同一个包内使用

    /**
     * 内部转账（仅供银行内部使用）
     */
    boolean internalTransfer(BankAccount target, double amount) {
        if (amount <= 0 || amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        target.balance += amount;
        return true;
    }
}


/**
 * 测试封装
 */
public class Encapsulation {

    public static void main(String[] args) {

        System.out.println("===== 封装示例 =====\n");

        // 创建账户
        BankAccount account = new BankAccount("6222021234567890", "张三", "123456");

        // 可以访问公开信息
        System.out.println("户主：" + account.getOwnerName());
        System.out.println("账号：" + account.getAccountNumber());
        System.out.println("当前余额：" + account.getBalance() + "元");

        // 不能直接访问私有属性（下面这行编译会报错）
        // account.balance = 100000;  // 错误！balance是private的
        // account.password = "123";  // 错误！password是private的

        System.out.println();

        // 通过公开方法操作
        account.deposit(5000, "123456");   // 存款
        account.withdraw(1000, "123456");  // 取款
        account.withdraw(5000, "123456");  // 尝试超额取款（会失败）
        account.withdraw(2000, "wrong");   // 密码错误（会失败）

        System.out.println();
        account.changePassword("123456", "654321");  // 修改密码

        System.out.println();
        account.displayInfo();  // 查看账户摘要

        // ===== 封装的优点 =====
        System.out.println("\n===== 封装的好处 =====");
        System.out.println("1. 数据安全 - 防止外部直接修改敏感数据（余额、密码）");
        System.out.println("2. 业务逻辑封装 - 存款/取款时自动进行合法性验证");
        System.out.println("3. 隐藏实现细节 - 外部只需调用方法，无需关心内部实现");
        System.out.println("4. 便于修改 - 改变内部实现不影响外部调用代码");
    }
}