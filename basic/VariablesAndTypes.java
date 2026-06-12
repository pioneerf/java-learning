/**
 * Java基础：变量和数据类型
 *
 * Java是强类型语言，每个变量都必须声明其数据类型。
 * 本示例展示Java中的基本数据类型和变量使用。
 */

public class VariablesAndTypes {

    public static void main(String[] args) {

        // ========== 基本数据类型（8种） ==========

        // 1. byte（字节型）：1字节，范围 -128 ~ 127
        byte myByte = 100;
        System.out.println("byte: " + myByte);

        // 2. short（短整型）：2字节，范围 -32768 ~ 32767
        short myShort = 32000;
        System.out.println("short: " + myShort);

        // 3. int（整型）：4字节，最常用的整数类型
        int myInt = 1000000;
        System.out.println("int: " + myInt);

        // 4. long（长整型）：8字节，数值后要加 L 或 l
        long myLong = 10000000000L;  // 不加L会编译错误，因为数字超过了int范围
        System.out.println("long: " + myLong);

        // 5. float（单精度浮点型）：4字节，数值后要加 F 或 f
        float myFloat = 3.14F;  // 不加F默认为double类型
        System.out.println("float: " + myFloat);

        // 6. double（双精度浮点型）：8字节，默认小数类型
        double myDouble = 3.14159265358979;
        System.out.println("double: " + myDouble);

        // 7. char（字符型）：2字节，使用单引号
        char myChar = 'A';
        char myChineseChar = '中';
        char myUnicodeChar = '中';  // Unicode编码，'中'的编码是4E2D
        System.out.println("char: " + myChar);
        System.out.println("中文字符: " + myChineseChar);
        System.out.println("Unicode字符: " + myUnicodeChar);

        // 8. boolean（布尔型）：只有 true 和 false
        boolean isJavaFun = true;
        boolean isHard = false;
        System.out.println("Java有趣吗？ " + isJavaFun);
        System.out.println("Java难吗？ " + isHard);

        // ========== 引用数据类型 ==========

        // String（字符串）：引用类型，不是基本类型，但使用非常频繁
        String greeting = "你好，Java！";
        System.out.println(greeting);

        // ========== 类型转换 ==========

        // 自动类型转换（小范围 -> 大范围，自动完成）
        int intVal = 100;
        long longVal = intVal;  // int 自动转为 long，没问题
        double doubleVal = intVal;  // int 自动转为 double
        System.out.println("自动转换: " + longVal + ", " + doubleVal);

        // 强制类型转换（大范围 -> 小范围，需要强制转换，可能丢失精度）
        double pi = 3.14159;
        int piInt = (int) pi;  // 小数部分被截断，结果为3
        System.out.println("强制转换后: " + piInt);

        // ========== 常量 ==========
        // final 关键字定义常量，赋值后不能被修改
        final double PI = 3.1415926;
        // PI = 3.14;  // 这行会报错！常量不能二次赋值
        System.out.println("常量PI = " + PI);
    }
}