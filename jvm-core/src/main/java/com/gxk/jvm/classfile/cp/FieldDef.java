package com.gxk.jvm.classfile.cp;

import com.gxk.jvm.classfile.ConstantInfo;

/**
 * 字段属性结构
 * CONSTANT_Fieldref_info  tag=9
 */
public class FieldDef extends ConstantInfo {

  public final int classIndex;
  public final int nameAndTypeIndex;

  public FieldDef(int infoEnum, int classIndex, int nameAndTypeIndex) {
    //tag 9
    super(infoEnum);
    //索引值
    this.classIndex = classIndex;
    //字段或者方法索引值
    this.nameAndTypeIndex = nameAndTypeIndex;
  }
}
