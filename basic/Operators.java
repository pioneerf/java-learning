/**
 * Java基础：运算符
 *
 * 展示Java中的各种运算符及其用法。
 */

public class Operators {

    public static void main(String[] args) {

        int a = 10, b = 3;

        // ========== 算术运算符 ==========
        System.out.println("=== 算术运算符 ===");
        System.out.println("a + b = " + (a + b));  // 加法: 13
        System.out.println("a - b = " + (a - b));  // 减法: 7
        System.out.println("a * b = " + (a * b));  // 乘法: 30
        System.out.println("a / b = " + (a / b));  // 除法（整数除法取整）: 3
        System.out.println("a %% b = " + (a % b));  // 取模（求余数）: 1

        // 浮点数除法
        double x = 10.0, y = 3.0;
        System.out.println("10.0 / 3.0 = " + (x / y));  // 3.3333333333333335

        // ========== 关系（比较）运算符 ==========返回boolean值
        System.out.println("\n=== 关系运算符 ===");
        System.out.println("a == b: " + (a == b));  // 相等判断: false
        System.out.println("a != b: " + (a != b));  // 不等判断: true
        System.out.println("a > b: " + (a > b));    // 大于: true
        System.out.println("a < b: " + (a < b));    // 小于: false
        System.out.println("a >= b: " + (a >= b));  // 大于等于: true
        System.out.println("a <= b: " + (a <= b));  // 小于等于: false

        // ========== 逻辑运算符 ==========
        System.out.println("\n=== 逻辑运算符 ===");
        boolean t = true, f = false;
        System.out.println("t && f: " + (t && f));  // 逻辑与（AND），两者都true才为true: false
        System.out.println("t || f: " + (t || f));  // 逻辑或（OR），一个true就为true: true
        System.out.println("!t: " + (!t));           // 逻辑非（NOT），取反: false

        // 短路特性：&& 左边为false时，右边不会执行
        int n = 5;
        //boolean result = (n > 10) && (n++ > 0);  // n > 10 为 false，n++ 不会执行  
        System.out.println("短路特性后 n 的值: " + n);  // 仍然是 5

        // ========== 赋值运算符 ==========
        System.out.println("\n=== 赋值运算符 ===");
        int c = 5;
        c += 3;  // 等价于 c = c + 3
        System.out.println("c += 3: " + c);  // 8
        c -= 2;  // 等价于 c = c - 2
        System.out.println("c -= 2: " + c);  // 6
        c *= 4;  // 等价于 c = c * 4
        System.out.println("c *= 4: " + c);  // 24
        c /= 3;  // 等价于 c = c / 3
        System.out.println("c /= 3: " + c);  // 8
        c %= 5;  // 等价于 c = c % 5
        System.out.println("c %%= 5: " + c);  // 3

        // ========== 自增自减运算符 ==========
        System.out.println("\n=== 自增/自减运算符 ===");
        int i = 5;
        System.out.println("i++:");
        System.out.println("  i++ 的值: " + (i++));  // 先取值再自增，输出 5
        System.out.println("  执行后 i: " + i);        // 6

        i = 5;
        System.out.println("++i:");
        System.out.println("  ++i 的值: " + (++i));  // 先自增再取值，输出 6
        System.out.println("  执行后 i: " + i);        // 6

        // ========== 三元运算符 ==========
        System.out.println("\n=== 三元运算符 ===");
        // 语法：条件 ? 值1 : 值2
        // 如果条件为true，返回值1，否则返回值2
        int score = 85;
        String grade = score >= 60 ? "及格" : "不及格";
        System.out.println("成绩 " + score + " 分: " + grade);  // 及格

        // 三元运算符可以嵌套（但不建议过度使用，影响可读性）
        String level = score >= 90 ? "优秀" : score >= 80 ? "良好" : score >= 60 ? "及格" : "不及格";
        System.out.println("等级: " + level);
    }
}