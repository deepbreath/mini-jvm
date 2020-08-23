package com.gxk.jvm.classfile;

/**
 *
 * 属性表结构
 * 在方法表之后的结构是 class 文件的最后一步部分属性表。
 * 属性出现的地方比较广泛，不止出现在字段和方法中，在顶层的 class 文件中也会出现。
 * 相比于常量池只有 14 种固定的类型，属性表是的类型是更加灵活的，
 * 不同的虚拟机实现厂商可以自定义自己的属性
 *
 */
public class Attributes {
  //属性表集合
  public final Attribute[] attributes;
  //数量
  public Attributes(int size) {
    this.attributes = new Attribute[size];
  }
}
