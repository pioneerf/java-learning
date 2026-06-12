/**
 * Java基础：方法（函数）
 *
 * 方法是组合在一起执行特定操作的语句块，是代码复用的基本单位。
 */

public class Methods {

    public static void main(String[] args) {

        // 调用方法
        System.out.println("=== 方法调用 ===");

        // 调用无返回值的方法
        printSeparator();

        // 调用带参数的方法
        greet("小明");
        greet("小红");

        // 调用有返回值的方法
        int sum = add(10, 20);
        System.out.println("10 + 20 = " + sum);

        // 调用多参数的方法
        double avg = calculateAverage(85, 92, 78, 90, 88);
        System.out.println("平均分: " + avg);

        // 使用方法重载（同名不同参）
        System.out.println("\n=== 方法重载 ===");
        System.out.println(add(1, 2));          // 调用两个int参数
        System.out.println(add(1, 2, 3));       // 调用三个int参数
        System.out.println(add(1.5, 2.7));      // 调用两个double参数

        // 值传递和引用传递
        System.out.println("\n=== 参数传递 ===");
        int num = 10;
        System.out.println("调用前: " + num);
        modifyPrimitive(num);
        System.out.println("调用后（基本类型不受影响）: " + num);

        int[] arr = {1, 2, 3};
        System.out.println("调用前数组: " + java.util.Arrays.toString(arr));
        modifyArray(arr);
        System.out.println("调用后数组（数组内容被改变）: " + java.util.Arrays.toString(arr));

        // 递归调用
        System.out.println("\n=== 递归 ===");
        System.out.println("5的阶乘: " + factorial(5));  // 5! = 5×4×3×2×1 = 120
        System.out.println("斐波那契数列第6项: " + fibonacci(6));  // 0,1,1,2,3,5,8,... 第6项是5
    }

    /**
     * 无返回值方法（void），打印分隔线
     */
    public static void printSeparator() {
        System.out.println("================================");
    }

    /**
     * 带参数的方法
     * @param name 要问候的名字
     */
    public static void greet(String name) {
        System.out.println("你好，" + name + "！");
    }

    /**
     * 有返回值的方法（返回 int 类型）
     * @param a 第一个加数
     * @param b 第二个加数
     * @return 两数之和
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * 计算不定数量数字的平均值（可变参数）
     * @param values 可变参数，用 ... 表示，可以传入任意多个参数
     * @return 平均值
     */
    public static double calculateAverage(int... values) {
        // int... 等价于 int[]，但调用时可以直接传多个值
        if (values.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        return (double) sum / values.length;
    }

    // ========== 方法重载（Overloading） ==========
    // 方法名相同，但参数列表不同（类型、个数、顺序不同）

    /** 两个int相加 */
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    /** 两个double相加（重载版本） */
    public static double add(double a, double b) {
        return a + b;
    }

    // ========== 值传递和引用传递 ==========

    /**
     * Java是值传递：
     * - 基本类型：传递的是值的副本，方法内修改不影响原变量
     * - 引用类型：传递的是引用（地址）的副本，方法内修改对象的属性会影响原对象
     */
    public static void modifyPrimitive(int x) {
        x = 100;  // 修改的是副本，不影响原变量
    }

    public static void modifyArray(int[] array) {
        array[0] = 99;  // 修改的是数组中的元素，原数组会被改变
    }

    // ========== 递归方法 ==========
    // 递归：方法调用自身，必须有一个终止条件

    /**
     * 计算阶乘（递归实现）
     * 终止条件：n == 1 时返回 1
     * 递归公式：n! = n * (n-1)!
     */
    public static int factorial(int n) {
        if (n == 1) {          // 终止条件（基准情况）
            return 1;
        }
        return n * factorial(n - 1);  // 递归调用
    }
    // 执行过程：
    // factorial(5) = 5 * factorial(4)
    //             = 5 * 4 * factorial(3)
    //             = 5 * 4 * 3 * factorial(2)
    //             = 5 * 4 * 3 * 2 * factorial(1)
    //             = 5 * 4 * 3 * 2 * 1 = 120

    /**
     * 计算斐波那契数列（递归实现）
     * 斐波那契数列：0, 1, 1, 2, 3, 5, 8, 13, ...
     * 终止条件：n <= 1 时返回 n
     * 递归公式：fib(n) = fib(n-1) + fib(n-2)
     */
    public static int fibonacci(int n) {
        if (n <= 1) {           // 终止条件
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);  // 递归调用
    }
}