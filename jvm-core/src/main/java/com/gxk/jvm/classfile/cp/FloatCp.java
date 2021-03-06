package com.gxk.jvm.classfile.cp;

import com.gxk.jvm.classfile.ConstantInfo;

/**
 * 浮点常量
 */
public class FloatCp extends ConstantInfo {

  public final float val;

  public FloatCp(int infoEnum, float val) {
    //tag
    super(infoEnum);
    //val
    this.val = val;
  }
}