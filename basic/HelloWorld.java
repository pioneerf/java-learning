/**
 * Java入门第一课：Hello World
 *
 * 这是最简单的Java程序，帮助你理解Java程序的基本结构。
 *
 * 关键概念：
 * 1. class - 类，Java程序的基本组织单位
 * 2. main方法 - 程序的入口点，JVM从这里开始执行
 * 3. System.out.println - 向控制台输出文本
 */

// public 表示这个类是公开的，可以被其他类访问
// class 关键字用于定义一个类
// 类名必须与文件名相同（HelloWorld）
public class HelloWorld {

    // main 方法是程序的入口点
    // public - 该方法可以被外部调用
    // static - 该方法属于类本身，不需要创建对象就能调用
    // void - 该方法没有返回值
    // String[] args - 命令行参数数组
    public static void main(String[] args) {

        // 打印文本到控制台，println会在末尾自动换行
        System.out.println("Hello, World!");
        System.out.println("你好，世界！");

        // 使用 print 不换行
        System.out.print("这是");
        System.out.print("不换行");
        System.out.print("的输出");
        System.out.println(); // 手动换行

        // 格式化输出 printf
        System.out.printf("我的名字是：%s，今年%d岁。","小明", 18);
        System.out.print(args);
    }
}