package com.gxk.jvm.classfile.cp;

import com.gxk.jvm.classfile.ConstantInfo;

/**
 *Long 类型常量
 * CONSTANT_Long_info    tag=5
 */
public class LongCp extends ConstantInfo {

  public final long val;

  public LongCp(int infoEnum, long val) {
    //tag
    super(infoEnum);
    //val
    this.val = val;
  }
}