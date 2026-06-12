/**
 * IO基础：文件读写操作
 *
 * Java中的IO操作主要通过流（Stream）来实现：
 * - 字节流（InputStream/OutputStream）：处理二进制数据
 * - 字符流（Reader/Writer）：处理文本数据（自动处理编码）
 * - 缓冲流（Buffered）：提高性能
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class FileIO {

    public static void main(String[] args) {

        System.out.println("===== 文件IO操作示例 =====\n");

        String filePath = "test_output.txt";

        // ===== 1. 写入文件 =====
        System.out.println("=== 写入文件 ===");

        // 方式1：FileWriter（字符流，适合文本）
        try (FileWriter writer = new FileWriter(filePath, StandardCharsets.UTF_8)) {
            writer.write("Hello, Java IO!\n");
            writer.write("这是第一行文本\n");
            writer.write("这是第二行文本\n");
            System.out.println("FileWriter 写入完成");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 方式2：BufferedWriter（带缓冲，性能更好）
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            // true 表示追加模式（append），而不是覆盖
            bw.write("这是追加的第三行文本\n");
            bw.write("BufferedWriter 性能更好\n");
            System.out.println("BufferedWriter 追加写入完成");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 方式3：Files工具类（Java 7+，最简洁）
        try {
            Files.writeString(Paths.get(filePath), "Files工具类写入\n",
                    StandardOpenOption.APPEND);  // 追加模式
            System.out.println("Files.writeString 追加写入完成");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ===== 2. 读取文件 =====
        System.out.println("\n=== 读取文件 ===");

        // 方式1：FileReader + BufferedReader（经典方式）
        System.out.println("--- FileReader + BufferedReader ---");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 方式2：Files.readAllLines（最简单）
        System.out.println("\n--- Files.readAllLines ---");
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            for (int i = 0; i < lines.size(); i++) {
                System.out.println("  行" + (i + 1) + ": " + lines.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 方式3：Files.readString（一次性读取全部内容）
        System.out.println("\n--- Files.readString ---");
        try {
            String content = Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
            System.out.println("  全部内容:\n" + content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ===== 3. 字节流读写（处理二进制文件，如图片） =====
        System.out.println("\n=== 字节流示例 ===");

        // 写入二进制数据
        String binaryFile = "binary_test.dat";
        try (FileOutputStream fos = new FileOutputStream(binaryFile);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            byte[] data = {0x48, 0x65, 0x6C, 0x6C, 0x6F};  // "Hello"的二进制
            bos.write(data);
            System.out.println("二进制数据写入完成");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读取二进制数据
        try (FileInputStream fis = new FileInputStream(binaryFile);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            byte[] buffer = new byte[1024];  // 缓冲区
            int bytesRead = bis.read(buffer);  // 返回实际读取的字节数

            System.out.print("读取到 " + bytesRead + " 字节: ");
            for (int i = 0; i < bytesRead; i++) {
                System.out.printf("%02X ", buffer[i]);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ===== 4. 文件和目录操作 =====
        System.out.println("\n=== 文件和目录操作 ===");

        File file = new File(filePath);
        System.out.println("文件名: " + file.getName());
        System.out.println("绝对路径: " + file.getAbsolutePath());
        System.out.println("文件大小: " + file.length() + " 字节");
        System.out.println("最后修改: " + new java.util.Date(file.lastModified()));
        System.out.println("是否可读: " + file.canRead());
        System.out.println("是否可写: " + file.canWrite());
        System.out.println("是否是目录: " + file.isDirectory());  // false

        // 目录操作
        File dir = new File("my_directory");
        if (!dir.exists()) {
            dir.mkdir();  // 创建单级目录
            System.out.println("目录已创建: " + dir.getName());
        }

        // 列出目录中的文件
        File currentDir = new File(".");  // 当前目录
        System.out.println("\n当前目录的文件:");
        String[] fileList = currentDir.list();
        if (fileList != null) {
            for (String f : fileList) {
                System.out.println("  " + f);
            }
        }

        // 清理创建的文件
        new File(binaryFile).delete();
        // new File(filePath).delete();  // 可以取消注释来删除测试文件
    }
}