package com.gxk.jvm.classfile;

/**
 * 异常表结构
 */
public final class ExceptionTable {

  public final Exception[] exceptions;

  public ExceptionTable(Exception[] exceptions) {
    this.exceptions = exceptions;
  }

}
