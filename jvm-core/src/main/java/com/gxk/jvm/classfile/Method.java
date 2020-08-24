package com.gxk.jvm.classfile;

import com.gxk.jvm.classfile.attribute.Code;
import com.gxk.jvm.classfile.attribute.LineNumberTable;


/**
 * 方法结构
 *
 * method_info {
 *     u2             access_flags;
 *     u2             name_index;
 *     u2             descriptor_index;
 *     u2             attributes_count;
 *     attribute_info attributes[attributes_count];
 *     }
 *
 *  比如方法Object foo(int i, double d, Thread t)的描述符为(IDLjava/lang/Thread;)Ljava/lang/Object;，
 *  其中 "I" 表示第一个参数 i 的参数类型 int，"D" 表示第二个参数 d 的类型 double，
 *  "Ljava/lang/Thread;"表示第三个参数 t 的类型 Thread，"Ljava/lang/Object;" 表示返回值类型 Object
 *
 */
public class Method {
  //表示方法的访问标记，是 public、private 还是 protected，是否是 static，是否是 final 等。
  public final int accessFlags;
  //name_index：方法名的索引值，指向常量池的的字符串常量 CONSTANT_Utf8_info 。 这里直接设置为方法名称
  public final String name;
  //descriptor_index：方法描述符的索引，指向常量池的字符串常量 CONSTANT_Utf8_info
  public final Descriptor descriptor;
  // attributes_count、attribute_info：表示方法相关属性的个数和属性集合，
  // 包含了很多有用的信息，比如方法内部的字节码就是存放在 Code 属性中。
  public final Attributes attributes;

  public Method(int accessFlags, String name, Descriptor descriptor, Attributes attributes) {
    this.accessFlags = accessFlags;
    this.name = name;
    this.descriptor = descriptor;
    this.attributes = attributes;
  }

  public Code getCode() {
    for (Attribute attribute : attributes.attributes) {
      if (attribute instanceof Code) {
        return ((Code) attribute);
      }
    }
    return null;
  }

  public LineNumberTable getLineNumber() {
    if (this.getCode() == null) {
      return null;
    }
    for (Attribute attribute : this.getCode().attributes.attributes) {
      if (attribute instanceof LineNumberTable) {
        return ((LineNumberTable) attribute);
      }
    }
    return null;
  }
}
