/**
 * 集合框架：Map（映射/字典）
 *
 * Map 存储键值对（Key-Value），键不可重复，值可以重复。
 * 常用实现类：
 * - HashMap：基于哈希表，无序，性能最好（最常用）
 * - LinkedHashMap：按插入顺序或访问顺序排序
 * - TreeMap：按键的自然顺序排序
 * - Hashtable：线程安全的HashMap（不推荐使用）
 */

import java.util.*;

public class MapDemo {

    public static void main(String[] args) {

        // ========== HashMap ==========
        System.out.println("=== HashMap（键值对存储） ===");

        // 创建Map：键是String（学号），值是Integer（成绩）
        Map<String, Integer> scoreMap = new HashMap<>();

        // 添加键值对（put）
        scoreMap.put("2024001", 85);
        scoreMap.put("2024002", 92);
        scoreMap.put("2024003", 78);
        scoreMap.put("2024004", 90);
        scoreMap.put("2024005", 88);

        System.out.println("成绩Map: " + scoreMap);

        // 添加重复键（会覆盖旧值）
        scoreMap.put("2024001", 95);  // 覆盖了85
        System.out.println("修改后: " + scoreMap);  // 2024001变成了95

        // 获取值（get）
        System.out.println("学号2024001的成绩: " + scoreMap.get("2024001"));  // 95

        // 获取不存在的键返回null
        System.out.println("不存在的学号: " + scoreMap.get("9999999"));  // null

        // getOrDefault：获取值，如果不存在则返回默认值
        System.out.println("安全的获取: " + scoreMap.getOrDefault("9999999", 0));  // 0

        // 判断是否包含某个键或值
        System.out.println("是否包含学号2024002？ " + scoreMap.containsKey("2024002"));  // true
        System.out.println("是否有成绩90？ " + scoreMap.containsValue(90));               // true

        // 删除
        scoreMap.remove("2024005");
        System.out.println("删除后: " + scoreMap);

        // 获取大小
        System.out.println("学生人数: " + scoreMap.size());  // 4

        // 清空所有（再检查是否为空）
        // scoreMap.clear();

        // ========== 遍历Map ==========
        System.out.println("\n=== 遍历Map的几种方式 ===");

        // 重新填充数据
        scoreMap.put("2024005", 88);
        scoreMap.put("2024006", 76);

        // 方式1：遍历 EntrySet（最常用，同时获取键和值）
        System.out.println("--- 方式1: entrySet ---");
        for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
            System.out.println("学号: " + entry.getKey() + " -> 成绩: " + entry.getValue());
        }

        // 方式2：遍历 KeySet（只需要键时）
        System.out.println("\n--- 方式2: keySet ---");
        for (String studentId : scoreMap.keySet()) {
            System.out.println("学号: " + studentId + " -> 成绩: " + scoreMap.get(studentId));
        }

        // 方式3：遍历 Values（只需要值时）
        System.out.println("\n--- 方式3: values ---");
        for (Integer score : scoreMap.values()) {
            System.out.print(score + " ");
        }
        System.out.println();

        // 方式4：Java 8+ forEach + Lambda
        System.out.println("\n--- 方式4: Lambda ---");
        scoreMap.forEach((studentId, score) -> {
            System.out.println(studentId + " 的成绩是 " + score);
        });

        // ========== LinkedHashMap ==========
        System.out.println("\n=== LinkedHashMap（保持插入顺序） ===");

        Map<String, String> orderedMap = new LinkedHashMap<>();
        orderedMap.put("001", "张三");
        orderedMap.put("002", "李四");
        orderedMap.put("003", "王五");

        System.out.println("LinkedHashMap（保持顺序）: " + orderedMap);
        // 输出: {001=张三, 002=李四, 003=王五}
        // HashMap 的顺序则不确定

        // ========== TreeMap ==========
        System.out.println("\n=== TreeMap（按键排序） ===");

        Map<String, String> sortedMap = new TreeMap<>();
        sortedMap.put("B", "Banana");
        sortedMap.put("A", "Apple");
        sortedMap.put("C", "Cherry");
        sortedMap.put("E", "Elderberry");
        sortedMap.put("D", "Date");

        System.out.println("TreeMap（按键排序）: " + sortedMap);
        // 输出: {A=Apple, B=Banana, C=Cherry, D=Date, E=Elderberry}

        // TreeMap 特有方法
        TreeMap<String, String> treeMap = (TreeMap<String, String>) sortedMap;
        System.out.println("第一个键: " + treeMap.firstKey());       // A
        System.out.println("最后一个键: " + treeMap.lastKey());      // E
        System.out.println("小于C的子Map: " + treeMap.headMap("C")); // {A=Apple, B=Banana}
        System.out.println("大于等于C的子Map: " + treeMap.tailMap("C")); // {C=Cherry, D=Date, E=Elderberry}

        // ========== 实用场景 ==========
        System.out.println("\n===== Map实用场景 =====");

        // 统计单词出现次数
        String text = "apple banana apple orange banana apple";
        String[] words = text.split(" ");

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            // 如果已存在则+1，否则设为1
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("单词统计: " + wordCount);
        // 输出: {banana=2, orange=1, apple=3}

        // ========== 常用Map选择总结 ==========
        System.out.println("\n===== 如何选择Map实现 =====");
        System.out.println("绝大多数情况用 HashMap（最快的查找）");
        System.out.println("需要保持插入顺序用 LinkedHashMap");
        System.out.println("需要对键排序用 TreeMap");
        System.out.println("需要线程安全用 ConcurrentHashMap（不要用Hashtable）");
    }
}