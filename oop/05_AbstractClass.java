/**
 * 面向对象：抽象类（Abstract Class）
 *
 * 抽象类用 abstract 关键字修饰：
 * 1. 不能直接实例化（不能 new）
 * 2. 可以包含抽象方法（只有声明，没有实现体）
 * 3. 也可以包含普通方法（有完整实现）
 * 4. 子类必须实现所有抽象方法（除非子类也是抽象类）
 *
 * 抽象类用于定义"是什么"的关系，强制子类遵循某种契约。
 */

// ========== 抽象类 ==========

/**
 * 形状抽象类
 */
abstract class Shape {

    protected String color;
    protected String name;

    // 抽象类可以有构造方法（子类通过super调用）
    public Shape(String color, String name) {
        this.color = color;
        this.name = name;
    }

    // ===== 抽象方法（没有方法体，子类必须实现） =====

    /** 计算面积（抽象方法） */
    public abstract double calculateArea();

    /** 计算周长（抽象方法） */
    public abstract double calculatePerimeter();

    // ===== 普通方法（有实现体） =====

    /** 显示信息 */
    public void displayInfo() {
        System.out.println("形状：" + name);
        System.out.println("颜色：" + color);
        System.out.println("面积：" + String.format("%.2f", calculateArea()));
        System.out.println("周长：" + String.format("%.2f", calculatePerimeter()));
    }

    /** 绘制形状 */
    public void draw() {
        System.out.println("绘制一个" + color + "色的" + name);
    }
}


// ========== 具体子类 ==========

/**
 * 圆形类
 */
class Circle extends Shape {

    private double radius;  // 半径

    public Circle(String color, double radius) {
        super(color, "圆形");  // 调用抽象类的构造方法
        this.radius = radius;
    }

    // 必须实现抽象方法
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;  // πr²
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;  // 2πr
    }
}

/**
 * 矩形类
 */
class Rectangle extends Shape {

    private double width;   // 宽
    private double height;  // 高

    public Rectangle(String color, double width, double height) {
        super(color, "矩形");
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;  // 长×宽
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);  // 2×(长+宽)
    }
}

/**
 * 三角形类
 */
class Triangle extends Shape {

    private double sideA, sideB, sideC;  // 三边长

    public Triangle(String color, double sideA, double sideB, double sideC) {
        super(color, "三角形");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculateArea() {
        // 海伦公式：√[p(p-a)(p-b)(p-c)]
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
}


/**
 * 测试抽象类
 */
public class AbstractClass {

    public static void main(String[] args) {

        System.out.println("===== 抽象类示例 =====\n");

        // Shape s = new Shape("红", "形状");  // 错误！抽象类不能实例化

        // 创建具体子类的对象（多态）
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("红色", 5.0);
        shapes[1] = new Rectangle("蓝色", 4.0, 6.0);
        shapes[2] = new Triangle("绿色", 3.0, 4.0, 5.0);

        // 多态调用
        for (Shape shape : shapes) {
            shape.draw();
            shape.displayInfo();
            System.out.println();
        }

        // ===== 抽象类的特点总结 =====
        System.out.println("===== 抽象类的关键特点 =====");
        System.out.println("1. 用 abstract 关键字修饰类");
        System.out.println("2. 不能直接 new 创建实例");
        System.out.println("3. 可以同时有抽象方法和普通方法");
        System.out.println("4. 可以有构造方法、成员变量");
        System.out.println("5. 子类必须实现所有抽象方法（除非子类也是抽象类）");
        System.out.println("6. 抽象方法只有声明没有实现体（没有{}）");

        System.out.println("\n===== 何时使用抽象类？ =====");
        System.out.println("当多个类有共同的属性和行为，但某些行为需要各自实现时");
        System.out.println("例如：各种形状都有颜色和名称，但计算面积的方法各不相同");
    }
}