package com.gxk.jvm.classfile;

/**
 * 字段信息结构如下
 * field_info {
 *     u2             access_flags;
 *     u2             name_index;
 *     u2             descriptor_index;
 *     u2             attributes_count;
 *     attribute_info attributes[attributes_count];
 *     }
 *
 */
public class Field {
  /**
   *
   *表示字段的访问标记，是 public、private 还是 protected，是否是 static，是否是 final 等。
   * 访问标记名         十六进制值    十进制             描述
   * ACC_PUBLIC         0x0001          1                声明为 public
   * ACC_PRIVATE        0x0002          2                声明为 private
   * ACC_PROTECTED      0x0004          4                声明为 protected
   * ACC_STATIC         0x0008          8                声明为 static
   * ACC_FINAL          0x0010         10                声明为 final
   * ACC_VOLATILE       0x0040         64                声明为 volatile，解决内存可见性的问题
   * ACC_TRANSIENT      0x0080        128                声明为 transient，被transient 修饰的字段默认不会被序列化
   * ACC_SYNTHETIC      0x1000       4096                表示这个字段是由编译器自动生成，而不是用户代码编译产生
   * ACC_ENUM           0x4000      16384                表示这是一个枚举类型的变量
   *
   */
  public final int accessFlags;

  //字段名的索引值，指向常量池的的字符串常量。（这里为什么直接使用了字段名称而不是索引？）
  public final String name;
  /**
   * 当定义一个 int 类型的变量时，类文件中存储的类型并不是字符串的int，而是使用了更精简的 I 来表示。
   *
   * 引用类型使用 "L;" 的方式来表示为了防止多个连续的引用类型描述符出现混淆，引用类型描述符最后都加上了一个;作为分隔。
   *
   * 比如字符串类型 String 的描述符为 "Ljava/lang/String;"，
   *
   * JVM 使用一个前置的[来表示数组类型，如int[]类型描述符为[I，字符串数组String[]的描述符为[Ljava/lang/String;。
   *
   * 多维数组描述符只是多加了几个[而已，比如 Object[][][] 类型描述符为[[[Ljava/lang/Object;
   *
   * 描述符          类型
   * B              byte 类型
   * C              char 类型
   * D            double 类型
   * F             float 类型
   * I               int 类型
   * J              long 类型
   * S             short 类型
   * Z              bool 类型
   * L ClassName ;  引用类型，"L" + 对象类型的全限定名 + ";"
   * [              一维数组
   */
  public final Descriptor descriptor;
  //属性集合
  public final Attributes attributes;

  public Field(int accessFlags, String name, Descriptor descriptor, Attributes attributes) {
    this.accessFlags = accessFlags;
    this.name = name;
    this.descriptor = descriptor;
    this.attributes = attributes;
  }
}
