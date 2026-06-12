/**
 * Java基础：异常处理（Exception Handling）
 *
 * 异常是程序运行中出现的非正常情况。Java通过 try-catch-finally 处理异常。
 *
 * 异常分类：
 * - 检查型异常（Checked Exception）：必须处理，如 IOException
 * - 非检查型异常（Unchecked Exception / RuntimeException）：可以不处理，如 NullPointerException
 * - Error：严重错误，一般无法处理，如 OutOfMemoryError
 */

import java.io.*;
import java.util.*;

public class ExceptionDemo {

    public static void main(String[] args) {

        System.out.println("===== 异常处理示例 =====\n");

        // ========== try-catch 基本结构 ==========
        System.out.println("--- try-catch 基本使用 ---");

        try {
            // 可能抛出异常的代码
            int result = 10 / 0;  // 这会抛出 ArithmeticException（除以0）
            System.out.println("这行不会执行");
        } catch (ArithmeticException e) {
            // 捕获并处理异常
            System.out.println("捕获到异常: " + e.getMessage());
            // e.printStackTrace();  // 打印完整的异常堆栈（调试时很有用）
        }
        // 程序继续执行
        System.out.println("异常处理后继续执行");

        // ========== 多个catch ==========
        System.out.println("\n--- 多个catch块 ---");

        String[] strs = {"123", "abc", null};

        for (String s : strs) {
            try {
                // 尝试将字符串转为整数
                int num = Integer.parseInt(s);
                System.out.println("转换成功: " + num);

                // 尝试访问null字符串的长度（会抛NullPointerException）
                System.out.println("长度: " + s.length());  // 注意这里不会执行null的情况

            } catch (NumberFormatException e) {
                // 捕获数字格式异常
                System.out.println("数字格式错误: '" + s + "' 不是有效数字");
            } catch (NullPointerException e) {
                // 捕获空指针异常
                System.out.println("空指针异常: 字符串为null");
            } finally {
                // finally 块总是会执行（即使有return也会执行）
                System.out.println("  finally执行完成");
            }
        }

        // ========== finally 块 ==========
        System.out.println("\n--- finally 的用途 ---");

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.println("finally用于释放资源（如关闭文件、数据库连接等）");
            // 故意抛出一个异常
            if (true) {
                throw new RuntimeException("模拟异常");
            }
        } catch (RuntimeException e) {
            System.out.println("捕获: " + e.getMessage());
        } finally {
            // 不管是否发生异常，finally都会执行
            // 通常在这里关闭资源
            if (scanner != null) {
                scanner.close();  // 关闭扫描器
                System.out.println("资源已关闭");
            }
        }

        // ========== try-with-resources (Java 7+) ==========
        System.out.println("\n--- try-with-resources (自动关闭资源) ---");

        // 实现了 AutoCloseable 接口的资源可以自动关闭
        // 不需要显式写 finally 来关闭
        try (BufferedReader reader = new BufferedReader(new StringReader("Hello\nWorld"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("读取: " + line);
            }
            // reader 会自动关闭，不需要 finally
        } catch (IOException e) {
            System.out.println("IO异常: " + e.getMessage());
        }

        // ========== throw 和 throws ==========
        System.out.println("\n--- throw 和 throws ---");

        try {
            validateAge(-5);  // 传入无效年龄
        } catch (IllegalArgumentException e) {
            System.out.println("校验失败: " + e.getMessage());
        }

        try {
            readFile("不存在的文件.txt");
        } catch (IOException e) {
            System.out.println("文件读取失败: " + e.getMessage());
        }

        // ========== 自定义异常 ==========
        System.out.println("\n--- 自定义异常 ---");

        try {
            withdrawMoney(100, 50);  // 余额不足
        } catch (InsufficientBalanceException e) {
            System.out.println("业务异常: " + e.getMessage());
            System.out.println("当前余额: " + e.getBalance() + "，需要: " + e.getRequired());
        }

        // ========== 异常处理最佳实践 ==========
        System.out.println("\n===== 异常处理最佳实践 =====");
        System.out.println("1. 不要捕获 Exception 或 Throwable，要捕获具体的异常类型");
        System.out.println("2. 不要吞噬异常（空的catch块）");
        System.out.println("3. 使用 try-with-resources 自动关闭资源");
        System.out.println("4. 异常信息要包含足够的上下文");
        System.out.println("5. 不要用异常控制正常的程序流程");
        System.out.println("6. 在合适层次处理异常，不要什么都抛到最上层");
    }

    /**
     * 使用 throw 主动抛出异常（方法内部）
     */
    public static void validateAge(int age) {
        if (age < 0) {
            // throw：在方法内部主动抛出异常
            throw new IllegalArgumentException("年龄不能为负数，输入: " + age);
        }
        if (age > 150) {
            throw new IllegalArgumentException("年龄不合法，输入: " + age);
        }
        System.out.println("年龄 " + age + " 合法");
    }

    /**
     * 使用 throws 声明可能抛出的异常（让调用者处理）
     * throws 告诉编译器：这个方法可能抛出 IOException
     */
    public static void readFile(String filename) throws IOException {
        // 检查型异常必须处理或声明抛出
        FileReader file = new FileReader(filename);  // 可能抛出 FileNotFoundException
        BufferedReader reader = new BufferedReader(file);
        String line = reader.readLine();  // 可能抛出 IOException
        System.out.println("文件内容: " + line);
        reader.close();
    }

    /**
     * 模拟取款业务
     */
    public static void withdrawMoney(double balance, double amount) {
        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }
        System.out.println("取款成功!");
    }
}


// ========== 自定义异常类 ==========

/**
 * 自定义异常：余额不足异常
 * 继承 RuntimeException（非检查型）或 Exception（检查型）
 */
class InsufficientBalanceException extends RuntimeException {

    private double balance;   // 当前余额
    private double required;  // 所需金额

    public InsufficientBalanceException(double balance, double required) {
        // 调用父类构造方法，传入错误信息
        super("余额不足！当前余额: " + balance + "，需要: " + required);
        this.balance = balance;
        this.required = required;
    }

    // 自定义异常可以添加额外信息
    public double getBalance() {
        return balance;
    }

    public double getRequired() {
        return required;
    }
}