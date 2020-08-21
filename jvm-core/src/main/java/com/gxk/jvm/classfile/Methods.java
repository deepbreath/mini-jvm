package com.gxk.jvm.classfile;

/**
 * 方法索引
 */
public class Methods {
  //方法集合
  public final Method[] methods;
  //方法数量
  public Methods(int methodCount) {
    this.methods = new Method[methodCount];
  }
}
