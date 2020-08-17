package com.gxk.jvm.classfile.cp;

/**
 *类中接口方法的引用
 * 方法 = 方法所属的类 + 方法名 + 方法参数和返回值描述符
 */
public class InterfaceMethodDef extends MethodDef {

  public InterfaceMethodDef(int infoEnum, int classIndex, int nameAndTypeIndex) {
    super(infoEnum, classIndex, nameAndTypeIndex);
  }
}
