package com.gxk.jvm.classfile.cp;

import com.gxk.jvm.classfile.ConstantInfo;

/**
 *从 JDK 1.7 开始引入的三个常量之一
 *
 */
public class MethodType extends ConstantInfo {

  public final int descriptorIndex;

  public MethodType(int infoEnum, int descriptorIndex) {
    super(infoEnum);
    this.descriptorIndex = descriptorIndex;
  }
}
