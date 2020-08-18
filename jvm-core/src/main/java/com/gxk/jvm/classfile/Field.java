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
  //表示字段的访问标记，是 public、private 还是 protected，是否是 static，是否是 final 等。
  public final int accessFlags;
  //字段名的索引值，指向常量池的的字符串常量。（这里为什么直接使用了字段名称而不是索引？）
  public final String name;
  //字段描述符
  public final Descriptor descriptor;
  //属性
  public final Attributes attributes;

  public Field(int accessFlags, String name, Descriptor descriptor, Attributes attributes) {
    this.accessFlags = accessFlags;
    this.name = name;
    this.descriptor = descriptor;
    this.attributes = attributes;
  }
}
