package com.gxk.jvm.classfile;

/**
 * 方法索引
 */
public class Methods {

  public final Method[] methods;
  public Methods(int methodCount) {
    this.methods = new Method[methodCount];
  }
}
