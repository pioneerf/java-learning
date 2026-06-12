/**
 * 集合框架：Set（集合）
 *
 * Set 是无序不可重复的集合，常用实现类：
 * - HashSet：基于哈希表，无序，性能最好（最常用）
 * - LinkedHashSet：按插入顺序排序
 * - TreeSet：按元素大小（自然顺序）排序
 */

import java.util.*;

public class SetDemo {

    public static void main(String[] args) {

        // ========== HashSet ==========
        System.out.println("=== HashSet（无序、去重） ===");

        Set<String> names = new HashSet<>();

        // 添加元素
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("张三");  // 重复元素！不会添加成功
        names.add("赵六");

        System.out.println("HashSet: " + names);  // 无序，且只有1个张三
        System.out.println("大小: " + names.size());  // 4（去重了）

        // 判断是否包含
        System.out.println("是否包含张三？ " + names.contains("张三"));  // true

        // 删除
        names.remove("赵六");
        System.out.println("删除赵六后: " + names);

        // 遍历
        System.out.print("遍历names: ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();

        // ========== LinkedHashSet ==========
        System.out.println("\n=== LinkedHashSet（按插入顺序） ===");

        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("北京");
        linkedSet.add("上海");
        linkedSet.add("广州");
        linkedSet.add("深圳");

        System.out.println("LinkedHashSet: " + linkedSet);  // [北京, 上海, 广州, 深圳]（保持插入顺序）

        // ========== TreeSet ==========
        System.out.println("\n=== TreeSet（自动排序） ===");

        Set<Integer> scores = new TreeSet<>();
        scores.add(85);
        scores.add(92);
        scores.add(60);
        scores.add(78);
        scores.add(95);
        scores.add(60);  // 重复，不会添加

        System.out.println("TreeSet（自动升序）: " + scores);  // [60, 78, 85, 92, 95]

        // TreeSet 特有方法
        TreeSet<Integer> treeScores = (TreeSet<Integer>) scores;
        System.out.println("第一个（最小）: " + treeScores.first());  // 60
        System.out.println("最后一个（最大）: " + treeScores.last());  // 95
        System.out.println("小于85的: " + treeScores.headSet(85));    // [60, 78]
        System.out.println("大于等于85的: " + treeScores.tailSet(85)); // [85, 92, 95]

        // ========== Set的常用场景 ==========
        System.out.println("\n===== Set的应用：去重 =====");

        // 去除List中的重复元素
        List<String> listWithDuplicates = Arrays.asList("A", "B", "A", "C", "B", "D");
        System.out.println("原始列表: " + listWithDuplicates);  // [A, B, A, C, B, D]

        // 利用HashSet去重
        Set<String> uniqueSet = new HashSet<>(listWithDuplicates);
        System.out.println("去重后: " + uniqueSet);  // [A, B, C, D]（无序）

        // 去重且保持顺序
        Set<String> uniqueOrdered = new LinkedHashSet<>(listWithDuplicates);
        System.out.println("去重且保持顺序: " + uniqueOrdered);  // [A, B, C, D]（按第一次出现的顺序）

        // 去重并排序
        Set<String> uniqueSorted = new TreeSet<>(listWithDuplicates);
        System.out.println("去重并排序: " + uniqueSorted);  // [A, B, C, D]（字母序）

        // ========== 注意事项 ==========
        System.out.println("\n===== 使用Set的注意事项 ==== ");
        System.out.println("1. HashSet 要求元素正确实现 hashCode() 和 equals() 方法");
        System.out.println("2. TreeSet 要求元素实现 Comparable 接口，或在构造时提供 Comparator");
        System.out.println("3. 自定义对象放入Set时，一定要正确重写hashCode和equals！");
        System.out.println("4. HashSet 几乎总是最好的选择，除非需要排序（用TreeSet）或保持顺序（用LinkedHashSet）");
    }
}