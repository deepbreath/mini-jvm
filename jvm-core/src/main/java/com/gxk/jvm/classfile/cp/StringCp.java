package com.gxk.jvm.classfile.cp;

import com.gxk.jvm.classfile.ConstantInfo;

/**
 * CONSTANT_String_info
 * 用来表示 java.lang.String 类型的常量对象
 */
public class StringCp extends ConstantInfo {

  public final int stringIndex;

  public StringCp(int infoEnum, int stringIndex) {
    super(infoEnum);
    this.stringIndex = stringIndex;
  }
}
