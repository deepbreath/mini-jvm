package com.gxk.jvm.classfile.attribute;

import com.gxk.jvm.classfile.Attribute;

/**
 * 目前没有使用
 * ConstantValue 属性只会出现字段 field_info 中，
 * 表示静态变量的初始值，它的结构如下：
 *  ConstantValue_attribute {
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u2 constantvalue_index;
 *  }
 *  其中 attribute_name_index 是指向常量池中值为 "ConstantValue" 的常量项，
 *  ConstantValue 属性的 attribute_length 值恒定为 2，
 *  constantvalue_index 指向常量池中具体的常量值索引，
 *  根据变量的类型不同 constantvalue_index 指向不同的常量项。
 */
public class ConstantValue extends Attribute {

  public final Object val;

  public ConstantValue(Object val) {
    this.val = val;
  }
}
