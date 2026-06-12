/**
 * 面向对象：接口（Interface）
 *
 * 接口用 interface 关键字定义：
 * 1. 接口中的方法默认是 public abstract（可以省略）
 * 2. 接口中的变量默认是 public static final（常量）
 * 3. 类通过 implements 关键字实现接口
 * 4. 一个类可以实现多个接口（弥补Java单继承的限制）
 * 5. 接口不能有构造方法，不能实例化
 *
 * 接口定义了"能做什么"的能力契约，而不是"是什么"。
 */

// ========== 接口定义 ==========

/**
 * 飞行能力接口
 */
interface Flyable {

    // 接口中的变量默认是 public static final（常量）
    int MAX_SPEED = 1000;  // 最大飞行速度（km/h）

    // 抽象方法（默认 public abstract）
    void fly();
    void land();

    // Java 8+：默认方法（default method），有方法体，实现类可以重写也可以不重写
    default void takeOff() {
        System.out.println("正在起飞...");
    }

    // Java 8+：静态方法，通过接口名直接调用
    static boolean isWithinSpeedLimit(double speed) {
        return speed <= MAX_SPEED;
    }
}

/**
 * 游泳能力接口
 */
interface Swimmable {

    void swim();

    default void dive() {
        System.out.println("正在潜水...");
    }
}

/**
 * 奔跑能力接口
 */
interface Runnable {
    void run();
}


// ========== 实现接口的类 ==========

/**
 * 鸟类：实现飞行接口
 */
class Bird implements Flyable {

    private String name;

    public Bird(String name) {
        this.name = name;
    }

    // 实现接口的所有抽象方法
    @Override
    public void fly() {
        System.out.println(name + "扑动翅膀飞翔");
    }

    @Override
    public void land() {
        System.out.println(name + "降落在树枝上");
    }
}

/**
 * 飞机类：实现飞行接口
 */
class Airplane implements Flyable {

    private String model;

    public Airplane(String model) {
        this.model = model;
    }

    @Override
    public void fly() {
        System.out.println(model + "喷气引擎推动飞行");
    }

    @Override
    public void land() {
        System.out.println(model + "在跑道降落");
    }

    // 重写默认方法
    @Override
    public void takeOff() {
        System.out.println(model + "在跑道加速起飞");
    }
}

/**
 * 鸭子类：同时实现多个接口
 */
class Duck implements Flyable, Swimmable, Runnable {

    private String name;

    public Duck(String name) {
        this.name = name;
    }

    // 实现 Flyable 接口
    @Override
    public void fly() {
        System.out.println(name + "摇摇晃晃地飞");
    }

    @Override
    public void land() {
        System.out.println(name + "降落在水面上");
    }

    // 实现 Swimmable 接口
    @Override
    public void swim() {
        System.out.println(name + "在水面上游泳");
    }

    @Override
    public void dive() {
        System.out.println(name + "一头扎进水里");
    }

    // 实现 Runnable 接口
    @Override
    public void run() {
        System.out.println(name + "在陆地上摇摇摆摆地跑");
    }
}

/**
 * 鱼类：实现游泳接口
 */
class Fish implements Swimmable {

    private String name;

    public Fish(String name) {
        this.name = name;
    }

    @Override
    public void swim() {
        System.out.println(name + "摆动尾巴游泳");
    }

    @Override
    public void dive() {
        System.out.println(name + "游向深水区");
    }
}


/**
 * 测试接口
 */
public class InterfaceDemo {

    public static void main(String[] args) {

        System.out.println("===== 接口示例 =====\n");

        // ===== 接口引用 =====
        System.out.println("--- 飞行能力测试 ---");
        Flyable[] flyingThings = new Flyable[3];
        flyingThings[0] = new Bird("麻雀");
        flyingThings[1] = new Airplane("波音747");
        flyingThings[2] = new Duck("唐老鸭");

        for (Flyable thing : flyingThings) {
            thing.takeOff();  // 默认方法或重写的方法
            thing.fly();
            thing.land();
            System.out.println();
        }

        // ===== 接口静态方法 =====
        System.out.println("--- 接口静态方法 ---");
        System.out.println("速度800km/h是否在限制内？" + Flyable.isWithinSpeedLimit(800));  // true
        System.out.println("速度1200km/h是否在限制内？" + Flyable.isWithinSpeedLimit(1200)); // false
        System.out.println();

        // ===== 多接口实现 =====
        System.out.println("--- 多接口实现（鸭子） ---");
        Duck duck = new Duck("唐老鸭");

        // 通过不同接口引用使用不同能力
        Flyable asFlying = duck;
        Swimmable asSwimming = duck;
        Runnable asRunning = duck;

        asFlying.fly();      // 飞
        asSwimming.swim();   // 游
        asRunning.run();     // 跑
        System.out.println();

        // ===== 接口与多态 =====
        System.out.println("--- 多态：统一处理不同接口类型 ---");
        Swimmable[] swimmers = {new Duck("野鸭"), new Fish("金鱼")};
        for (Swimmable s : swimmers) {
            s.swim();
            s.dive();
            System.out.println();
        }

        // ===== 接口 vs 抽象类 =====
        System.out.println("===== 接口 vs 抽象类 =====");
        System.out.println("接口：");
        System.out.println("  1. 定义"能做什么"（能力契约）");
        System.out.println("  2. 多实现：一个类可以实现多个接口");
        System.out.println("  3. 所有方法默认 public abstract");
        System.out.println("  4. 变量只能是 public static final 常量");
        System.out.println("  5. 没有构造方法");
        System.out.println();
        System.out.println("抽象类：");
        System.out.println("  1. 定义"是什么"（类型层次）");
        System.out.println("  2. 单继承：一个类只能继承一个抽象类");
        System.out.println("  3. 可以有抽象方法也可以有普通方法");
        System.out.println("  4. 可以有各种成员变量");
        System.out.println("  5. 可以有构造方法");

        System.out.println("\n===== 核心建议 =====");
        System.out.println("倾向于使用接口而不是抽象类来定义行为契约");
        System.out.println("接口 + 组合 比 抽象类 + 继承 更灵活");
    }
}