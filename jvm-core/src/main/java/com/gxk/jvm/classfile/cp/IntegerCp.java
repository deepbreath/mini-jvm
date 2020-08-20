package com.gxk.jvm.classfile.cp;

import com.gxk.jvm.classfile.ConstantInfo;

/**
 * 整数常量
 * CONSTANT_Integer_info  tag=3
 */
public class IntegerCp extends ConstantInfo {

  public final int val;

  public IntegerCp(int infoEnum, int val) {
    //tag
    super(infoEnum);
    //val
    this.val = val;
  }
}
