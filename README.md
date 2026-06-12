# Java 入门学习代码示例 🚀

## 学习顺序建议

### 📘 第一阶段：基础语法

| 文件 | 学习内容 |
|------|---------|
| `basic/01_HelloWorld.java` | 第一个程序，基本输出 |
| `basic/02_VariablesAndTypes.java` | 8种基本数据类型，类型转换，常量 |
| `basic/03_Operators.java` | 算术、关系、逻辑、赋值、三元运算符 |
| `basic/04_ControlFlow.java` | if-else, switch, for, while, do-while, break, continue |
| `basic/05_ArrayAndString.java` | 一维/二维数组，String常用方法 |
| `basic/06_Methods.java` | 方法定义和调用，重载，递归，值传递 |
| `basic/07_ExceptionDemo.java` | try-catch-finally, 自定义异常 |

### 📗 第二阶段：面向对象（OOP）

| 文件 | 学习内容 |
|------|---------|
| `oop/01_ClassAndObject.java` | 类、对象、构造方法、static |
| `oop/02_Encapsulation.java` | 封装、访问修饰符、getter/setter |
| `oop/03_Inheritance.java` | 继承、super、方法重写(Override) |
| `oop/04_Polymorphism.java` | 多态、instanceof、向上/向下转型 |
| `oop/05_AbstractClass.java` | 抽象类、抽象方法 |
| `oop/06_Interface.java` | 接口、多实现、default方法 |

### 📙 第三阶段：集合框架

| 文件 | 学习内容 |
|------|---------|
| `collections/01_ListDemo.java` | ArrayList, LinkedList, 遍历, 排序 |
| `collections/02_SetDemo.java` | HashSet, LinkedHashSet, TreeSet, 去重 |
| `collections/03_MapDemo.java` | HashMap, LinkedHashMap, TreeMap, 遍历 |

### 📕 第四阶段：IO操作

| 文件 | 学习内容 |
|------|---------|
| `io/01_FileIO.java` | 文件读写，字节流/字符流，Files工具类 |

## 如何运行

```bash
# 1. 进入示例目录
cd java-examples

# 2. 编译 Java 文件（需要安装 JDK）
javac basic/01_HelloWorld.java

# 3. 运行
java -cp basic HelloWorld
```

> **注意**：部分文件依赖于同目录下的其他类（如 `Encapsulation` 依赖于 `BankAccount`），需要一起编译：
> ```bash
> javac oop/02_Encapsulation.java
> java -cp oop Encapsulation
> ```

## 推荐的学习方法

1. **先读注释再看代码** - 每个文件开头有概述，先理解"学什么"
2. **动手修改代码** - 改几个数字、换几个字符串，看输出变化
3. **跟着顺序学习** - 建议按上表的顺序逐个文件学习
4. **多写多练** - 看完一个知识点后，自己写一个小程序实践

## 需要什么环境

- **JDK 8+**（建议 JDK 17 或 21，最新长期支持版）
- 任何文本编辑器（VS Code、记事本、IDEA 等）
- 命令行终端

