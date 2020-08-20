package com.gxk.jvm.classfile.cp;

import com.gxk.jvm.classfile.ConstantInfo;

/**
 * 结构用来表示字段或者方法，格式有下面三部分组成：
 * CONSTANT_NameAndType_info    tag=12
 */
public class NameAndType extends ConstantInfo {

  public final int nameIndex;
  public final int descriptionIndex;

  public NameAndType(int infoEnum, int nameIndex, int descriptionIndex) {
    //tag 值 12
    super(infoEnum);
    //指向常量池中 CONSTANT_Utf8_info,存储的是字段名或者方法名
    this.nameIndex = nameIndex;
    //指向常量池中的 CONSTANT_Utf8_info，存储的是字段描述符或者方法描述符。可以理解成描述方法的行参类型
    this.descriptionIndex = descriptionIndex;
  }
}
