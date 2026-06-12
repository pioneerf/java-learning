/**
 * Java基础：数组和字符串
 *
 * 数组用于存储多个同类型数据，String是Java中最常用的引用类型。
 */

import java.util.Arrays;

public class ArrayAndString {

    public static void main(String[] args) {

        // ========== 数组 ==========
        System.out.println("=== 数组 ===");

        // 方式1：声明并分配空间
        int[] arrays = new int[6];
        arrays[0] = 42;
        arrays[1] = 45;
        arrays[2] = 45;
        arrays[3] = 45;
        arrays[4] = 45;
        arrays[5] = 45;
        int[] scores = new int[5];  // 创建长度为5的int数组，默认值全为0
        scores[0] = 85;   // 索引从0开始
        scores[1] = 92;
        scores[2] = 78;
        scores[3] = 90;
        scores[4] = 88;
        // 数组长度可以通过 length 属性获取
        System.out.println("数组长度: " + scores.length);  // 5
        System.out.println("第一个元素: " + scores[0]);    // 85
        System.out.println("最后一个元素: " + scores[scores.length - 1]);  // 88

        // 方式2：直接初始化（声明时就赋值）
        int[] numbers = {10, 20, 30, 40, 50};
        String[] members = {"你","我","他"};
        System.out.println(members[0]);
        // 方式3：使用new并同时初始化
        int[] other = new int[]{1, 2, 3, 4, 5};

        // 遍历数组
        System.out.print("遍历数组: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();

        // 使用增强for遍历
        System.out.print("增强for遍历: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();

        // 使用 Arrays 工具类操作数组
        int[] copied = Arrays.copyOf(scores, scores.length);  // 复制数组
        Arrays.sort(scores);  // 排序
        System.out.println("排序后: " + Arrays.toString(scores));
        System.out.println("查找92的位置: " + Arrays.binarySearch(scores, 92));  // 二分搜索（需先排序）
        System.out.println("数组是否相等: " + Arrays.equals(numbers, other));  // false

        // ========== 二维数组 ==========
        System.out.println("\n=== 二维数组 ===");

        // 定义3行4列的二维数组
        int[][] matrix = new int[3][4];

        // 填充数据
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i * 10 + j;
            }
        }

        // 打印二维数组
        System.out.println("二维数组:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

        // 不规则二维数组
        int[][] triangle = new int[5][];  // 只指定行数
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];  // 每行长度不同
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] = j + 1;
            }
        }

        // ========== String 字符串 ==========
        System.out.println("\n=== 字符串 ===");

        // 创建字符串的几种方式
        String s1 = "Hello";                    // 字面量方式（常用）
        String s2 = new String("Hello");        // 使用new关键字
        String s3 = "Hello";                    // 字面量方式（与s1指向同一个对象）

        // 重要：== 比较引用，equals() 比较内容
        System.out.println("s1 == s2: " + (s1 == s2));          // false（不同对象）
        System.out.println("s1 == s3: " + (s1 == s3));          // true（同一个对象，字符串常量池）
        System.out.println("s1.equals(s2): " + s1.equals(s2));  // true（内容相同）

        // 常用字符串方法
        String str = "  Hello, Java World!  ";
        System.out.println("原始: '" + str + "'");
        System.out.println("长度: " + str.length());                        // 21
        System.out.println("去除首尾空格: '" + str.trim() + "'");          // "Hello, Java World!"
        System.out.println("转大写: " + str.toUpperCase());                 // "  HELLO, JAVA WORLD!  "
        System.out.println("转小写: " + str.toLowerCase());                 // "  hello, java world!  "
        System.out.println("是否包含'Java': " + str.contains("Java"));     // true
        System.out.println("替换: " + str.replace("Java", "Python"));     // "  Hello, Python World!  "
        System.out.println("第8个字符: " + str.charAt(8));                 // 'J'
        System.out.println("子串(8,12): " + str.substring(8, 12));         // "Java"（含8，不含12）

        // 字符串分割
        String csv = "apple,banana,orange,grape";
        String[] fruits = csv.split(",");
        System.out.println("分割结果: " + Arrays.toString(fruits));

        // 字符串拼接
        String part1 = "Hello";
        String part2 = "World";
        // + 号拼接（每次创建新对象，效率较低，适合少量拼接）
        String result1 = part1 + " " + part2 + "!";
        // 使用 concat 方法
        String result2 = part1.concat(" ").concat(part2).concat("!");
        // 使用 StringBuilder（频繁拼接时的推荐方式，效率高）
        StringBuilder sb = new StringBuilder();
        sb.append(part1).append(" ").append(part2).append("!");
        String result3 = sb.toString();

        System.out.println(result1 + " | " + result2 + " | " + result3);
    }
}