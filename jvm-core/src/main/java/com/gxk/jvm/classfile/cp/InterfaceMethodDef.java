package com.gxk.jvm.classfile.cp;

/**
 * 类中接口方法 继承方法
 * CONSTANT_InterfaceMethodref_info  tag=11
 */
public class InterfaceMethodDef extends MethodDef {

  public InterfaceMethodDef(int infoEnum, int classIndex, int nameAndTypeIndex) {
    super(infoEnum, classIndex, nameAndTypeIndex);
  }
}
