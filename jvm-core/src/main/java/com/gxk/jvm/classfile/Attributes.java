package com.gxk.jvm.classfile;

/**
 *属性
 */
public class Attributes {

  public final Attribute[] attributes;

  public Attributes(int size) {
    this.attributes = new Attribute[size];
  }
}
