package com.gxk.jvm.classfile.cp;

import com.gxk.jvm.classfile.ConstantInfo;

/**
 * 从 JDK 1.7 开始引入的三个常量之一
 * CONSTANT_MethodHandle_info    tag=15
 */
public class MethodHandle extends ConstantInfo {

  public final int referenceKind;
  public final int referenceIndex;

  public MethodHandle(int infoEnum, int referenceKind, int referenceIndex) {
    super(infoEnum);
    this.referenceKind = referenceKind;
    this.referenceIndex = referenceIndex;
  }
}
