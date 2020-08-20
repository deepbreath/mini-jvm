package com.gxk.jvm.classfile;

/**
 *
 * 常量池
 *
 */
public class ConstantPool {

  //用来存放常量信息数组
  public final ConstantInfo[] infos;

  //常量池大小
  public ConstantPool(int size) {
    this.infos = new ConstantInfo[size];
  }

}
