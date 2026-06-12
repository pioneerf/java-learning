/**
 * 集合框架：List（列表）
 *
 * List 是有序可重复的集合，常用实现类：
 * - ArrayList：底层用数组，查询快，增删慢（尾部增删也快）
 * - LinkedList：底层用链表，增删快，查询慢
 * - Vector：线程安全的ArrayList（不常用）
 */

import java.util.*;

public class ListDemo {

    public static void main(String[] args) {

        // ========== ArrayList ==========
        System.out.println("=== ArrayList ===");

        // 创建ArrayList（默认容量10）
        List<String> fruits = new ArrayList<>();  // 泛型：<String>表示只能存放String对象

        // 添加元素
        fruits.add("苹果");        // 添加到末尾
        fruits.add("香蕉");
        fruits.add("橙子");
        fruits.add(1, "葡萄");    // 在索引1处插入

        System.out.println("水果列表: " + fruits);  // [苹果, 葡萄, 香蕉, 橙子]

        // 获取元素
        System.out.println("第一个水果: " + fruits.get(0));      // 苹果
        System.out.println("最后一个水果: " + fruits.get(fruits.size() - 1));  // 橙子

        // 删除元素
        fruits.remove("葡萄");    // 按对象删除
        fruits.remove(2);          // 按索引删除（删除了"橙子"）
        System.out.println("删除后: " + fruits);  // [苹果, 香蕉]

        // 修改元素
        fruits.set(0, "苹果(红富士)");
        System.out.println("修改后: " + fruits);  // [苹果(红富士), 香蕉]

        // 判断是否存在
        System.out.println("是否包含香蕉？ " + fruits.contains("香蕉"));  // true

        // 获取索引
        System.out.println("香蕉的索引: " + fruits.indexOf("香蕉"));  // 1

        // 其他操作
        System.out.println("列表大小: " + fruits.size());           // 2
        System.out.println("是否为空: " + fruits.isEmpty());        // false

        // 遍历List的方式
        System.out.println("\n--- 遍历方式 ---");

        // 方式1：for循环 + 索引
        System.out.print("方式1 (for+索引): ");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.print(fruits.get(i) + " ");
        }
        System.out.println();

        // 方式2：增强for循环（最常用）
        System.out.print("方式2 (增强for): ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // 方式3：迭代器
        System.out.print("方式3 (迭代器): ");
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 方式4：Java 8+ forEach + Lambda
        System.out.print("方式4 (Lambda): ");
        fruits.forEach(fruit -> System.out.print(fruit + " "));
        System.out.println();

        // ========== LinkedList ==========
        System.out.println("\n=== LinkedList ===");

        // LinkedList 实现了 List 和 Deque（双端队列）
        LinkedList<String> list = new LinkedList<>();

        // List 操作
        list.add("A");
        list.add("B");
        list.add("C");

        // Deque 特有操作（作为栈/队列使用）
        list.addFirst("开头");   // 在头部添加
        list.addLast("结尾");    // 在尾部添加
        System.out.println("LinkedList: " + list);  // [开头, A, B, C, 结尾]

        System.out.println("获取首元素: " + list.getFirst());  // 开头
        System.out.println("获取尾元素: " + list.getLast());   // 结尾

        list.removeFirst();  // 移除首个
        list.removeLast();   // 移除末尾
        System.out.println("移除首尾后: " + list);  // [A, B, C]

        // ========== ArrayList 和 LinkedList 的性能对比 ==========
        System.out.println("\n===== 何时用ArrayList vs LinkedList =====");
        System.out.println("ArrayList: 查询多、尾部增删多的场景（绝大多数情况用这个）");
        System.out.println("LinkedList: 频繁在头部/中间增删的场景、作为队列/栈使用");

        // ========== List的排序 ==========
        System.out.println("\n=== List排序 ===");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(3);

        System.out.println("排序前: " + numbers);

        // 自然排序（升序）
        Collections.sort(numbers);
        System.out.println("升序: " + numbers);  // [1, 2, 3, 5, 8]

        // 降序
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("降序: " + numbers);  // [8, 5, 3, 2, 1]

        // 自定义排序（Comparator）
        Collections.sort(numbers, (a, b) -> b - a);  // Lambda表达式实现降序
        System.out.println("Lambda降序: " + numbers);

        // 翻转
        Collections.reverse(numbers);
        System.out.println("翻转: " + numbers);  // [1, 2, 3, 5, 8]
    }
}