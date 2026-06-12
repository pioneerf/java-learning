/**
 * 面向对象：继承（Inheritance）
 *
 * 继承是OOP三大特性之一，核心思想：
 * - 子类（派生类）继承父类（基类、超类）的属性和方法
 * - 子类可以扩展新的属性和方法
 * - 子类可以重写（override）父类的方法
 * - Java中使用 extends 关键字
 * - Java是单继承：一个子类只能有一个直接父类
 */

// ========== 父类（基类） ==========

/**
 * 动物类（父类）
 */
class Animal {

    protected String name;     // protected：子类可以访问
    protected int age;

    // 构造方法
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 普通方法
    public void eat() {
        System.out.println(name + "正在吃东西...");
    }

    public void sleep() {
        System.out.println(name + "正在睡觉...");
    }

    // 准备被重写的方法
    public void makeSound() {
        System.out.println("动物发出声音...");
    }

    public void displayInfo() {
        System.out.println("名字：" + name + "，年龄：" + age + "岁");
    }
}


// ========== 子类（派生类） ==========

/**
 * 狗类（继承自动物类）
 */
class Dog extends Animal {

    // 子类独有的属性
    private String breed;  // 品种

    // 构造方法：使用 super 调用父类构造方法
    public Dog(String name, int age, String breed) {
        super(name, age);   // 调用父类的构造方法，必须写在第一行
        this.breed = breed;
    }

    // 重写（Override）父类的方法
    @Override  // 注解，告诉编译器这是重写（可省略，但建议写上）
    public void makeSound() {
        System.out.println(name + "汪汪叫！");
    }

    // 子类扩展的新方法
    public void wagTail() {
        System.out.println(name + "摇尾巴表示开心~");
    }

    public void guard() {
        System.out.println(name + "在看家护院！");
    }

    // 重写 displayInfo，添加品种信息
    @Override
    public void displayInfo() {
        super.displayInfo();  // 调用父类的方法（复用）
        System.out.println("品种：" + breed);
    }
}

/**
 * 猫类（继承自动物类）
 */
class Cat extends Animal {

    private String color;  // 毛色

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println(name + "喵喵叫~");
    }

    // 子类扩展的新方法
    public void climb() {
        System.out.println(name + "正在爬树！");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("毛色：" + color);
    }
}

/**
 * 测试继承
 */
public class Inheritance {

    public static void main(String[] args) {

        System.out.println("===== 继承示例 =====\n");

        // 创建父类对象
        Animal animal = new Animal("动物", 1);
        animal.eat();
        animal.sleep();
        animal.makeSound();  // 输出：动物发出声音...
        System.out.println();

        // 创建子类对象
        Dog dog = new Dog("旺财", 3, "金毛");
        dog.eat();          // 继承自父类
        dog.sleep();        // 继承自父类
        dog.makeSound();    // 重写了！输出：旺财汪汪叫！
        dog.wagTail();      // 子类自己的方法
        dog.guard();        // 子类自己的方法
        System.out.println();

        Cat cat = new Cat("咪咪", 2, "橘色");
        cat.eat();          // 继承自父类
        cat.sleep();        // 继承自父类
        cat.makeSound();    // 重写了！输出：咪咪喵喵叫~
        cat.climb();        // 子类自己的方法
        System.out.println();

        // 多态：父类引用指向子类对象
        System.out.println("===== 多态 =====");
        Animal pet1 = new Dog("来福", 4, "哈士奇");
        Animal pet2 = new Cat("花花", 1, "黑白");

        // 编译时看左边的类型（Animal），运行时看右边的类型（Dog/Cat）
        pet1.makeSound();  // 实际调用的是狗的声音
        pet2.makeSound();  // 实际调用的是猫的声音

        // pet1.wagTail();  // 编译错误！Animal类型没有wagTail方法
        // 如果需要调用子类特有的方法，需要向下转型
        if (pet1 instanceof Dog) {  // instanceof 判断对象是否是某个类型
            Dog realDog = (Dog) pet1;  // 强制类型转换
            realDog.wagTail();
        }

        System.out.println();

        // 显示信息（测试super调用）
        dog.displayInfo();
        System.out.println();
        cat.displayInfo();

        // ===== 继承的层次 =====
        System.out.println("\n===== 继承的关键点 =====");
        System.out.println("1. Java单继承：一个子类只能有一个直接父类");
        System.out.println("2. 多层继承：A→B→C（C继承B，B继承A）是允许的");
        System.out.println("3. super关键字：调用父类的构造方法或成员");
        System.out.println("4. @Override注解：标注重写的方法（推荐使用）");
        System.out.println("5. 子类可以继承父类所有非private的成员");
        System.out.println("6. 构造方法不能被继承！");
    }
}