package com.gxk.jvm.classfile.cp;

import com.gxk.jvm.classfile.ConstantInfo;

/**
 *Long 类型常量
 */
public class LongCp extends ConstantInfo {

  public final long val;

  public LongCp(int infoEnum, long val) {
    super(infoEnum);
    this.val = val;
  }
}