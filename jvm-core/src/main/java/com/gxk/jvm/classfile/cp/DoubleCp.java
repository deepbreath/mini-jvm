package com.gxk.jvm.classfile.cp;

import com.gxk.jvm.classfile.ConstantInfo;

/**
 * 双浮点常量池
 * CONSTANT_Double_info  tag=6
 */
public class DoubleCp extends ConstantInfo {

  public final double val;

  public DoubleCp(int infoEnum, double val) {
    //tag 6
    super(infoEnum);
    //值
    this.val = val;
  }
}