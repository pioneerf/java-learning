/**
 * Java基础：流程控制
 *
 * 展示条件判断和循环结构的使用。
 */

public class ControlFlow {

    public static void main(String[] args) {

        // ========== if-else 条件判断 ==========
        System.out.println("=== if-else 条件判断 ===");

        int age = 20;

        if (age < 12) {
            System.out.println("儿童");
        } else if (age < 18) {
            System.out.println("青少年");
        } else if (age < 60) {
            System.out.println("成年人");
        } else {
            System.out.println("老年人");
        }
        // 输出: 成年人

        // 简写形式（只有一行代码时可以省略花括号，但建议始终写上）
        if (age >= 18) {System.out.println("已成年");}

        // ========== switch 选择语句 ==========
        System.out.println("\n=== switch 语句 ===");

        int dayOfWeek = 3;
        String dayName;

        // 传统 switch 写法
        /*switch (dayOfWeek) {
            case 1:
                dayName = "星期一";
                break;  // break 用于跳出 switch，不加会继续执行下一个 case（穿透）
            case 2:
                dayName = "星期二";
                break;
            case 3:
                dayName = "星期三";
                break;
            case 4:
                dayName = "星期四";
                break;
            case 5:
                dayName = "星期五";
                break;
            case 6:
            case 7:
                dayName = "周末";
                break;
            default:   // 所有 case 都不匹配时执行
                dayName = "无效的星期";
        }
        System.out.println("今天是: " + dayName);  */
        // 星期三

        switch (dayOfWeek) {
            case 1:
                dayName = "星期一";
                break;
            case 2:
                dayName = "星期二";
                break;
            case 3:
                dayName = "星期三"; 
                break;
            default:
                dayName = "无效的星期";
                break;
        }
        System.out.println("今天是：" + dayName);
        // Java 14+ 箭头 switch（更简洁）
        String season = switch (dayOfWeek) {
            case 1, 2, 3, 4, 5 -> "工作日";  // 箭头语法，不需要 break
            case 6, 7 -> "周末";
            default -> "未知";
        };
        System.out.println("今天类型: " + season);

        // ========== for 循环 ==========
        System.out.println("\n=== for 循环 ===");

        // 经典 for 循环：初始化; 条件; 迭代
        System.out.print("for循环 1到5: ");
        for (int i = 2; i <= 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();  // 输出: 1 2 3 4 5

        // 理解 for 循环的执行顺序
        // 1. 初始化：int i = 1（执行一次）
        // 2. 条件判断：i <= 5
        // 3. 如果条件为true，执行循环体
        // 4. 迭代：i++
        // 5. 回到步骤2

        // 倒序循环
        System.out.print("倒序循环: ");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // ========== while 循环 ==========
        System.out.println("\n=== while 循环 ===");

        // while 循环：先判断条件，条件为true才执行
        int count = 1;
        while (count <= 5) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();  // 输出: 1 2 3 4 5

        // ========== do-while 循环 ==========
        System.out.println("\n=== do-while 循环 ===");

        // do-while：先执行一次，再判断条件
        // 至少会执行一次
        int num = 5;
        do {
            System.out.print(num + " ");
            num++;
        } while (num <= 1);
        System.out.println();  // 输出: 1 2 3 4 5

        // do-while 至少执行一次的特点
        int value = 10;
        do {
            System.out.println("即使条件不满足，也执行了一次。value=" + value);
            value++;
        } while (value < 5);
        // 输出: 即使条件不满足，也执行了一次。value=10

        // ========== break 和 continue ==========
        System.out.println("\n=== break 和 continue ===");

        // break：立即跳出整个循环
        System.out.print("break 示例（遇到3就停止）: ");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                break;  // 当 i==3 时跳出循环
            }
            System.out.print(i + " ");
        }
        System.out.println();  // 输出: 1 2

        // continue：跳过本次循环的剩余部分，进入下一次循环
        System.out.print("continue 示例（跳过3）: ");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;  // 当 i==3 时跳过，不打印3
            }
            System.out.print(i + " ");
        }
        System.out.println();  // 输出: 1 2 4 5

        // ========== 增强for循环（for-each） ==========
        System.out.println("\n=== 增强for循环 ===");

        int[] numbers = {10, 20, 30, 40, 50};
        // 用于遍历数组或集合，无需索引
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();  // 输出: 10 20 30 40 50

        // ========== 嵌套循环 ==========
        System.out.println("\n=== 嵌套循环（打印乘法表） ===");

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            System.out.println();  // 每行结束后换行
        }
    }
}