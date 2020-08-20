package com.gxk.jvm.classfile.cp;

import com.gxk.jvm.classfile.ConstantInfo;

/**
 * CONSTANT_Class_info 结构用来表示类或接口
 *
 */
public class ClassCp extends ConstantInfo {

  public final int nameIndex;

  public ClassCp(int infoEnum, int nameIndex) {
    //tag 7
    super(infoEnum);
    //指向类型为 CONSTANT_Utf8_info 常量，这个字符串存储的是类或接口的全限定名。
    this.nameIndex = nameIndex;
  }
}
