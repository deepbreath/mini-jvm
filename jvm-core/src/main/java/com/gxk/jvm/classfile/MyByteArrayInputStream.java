package com.gxk.jvm.classfile;

import java.io.ByteArrayInputStream;

/**
 * 用来读取 CONSTANT_Utf8_info 常量或 Class 文件字节
 */
public class MyByteArrayInputStream extends ByteArrayInputStream {

  public MyByteArrayInputStream(byte[] buf) {
    super(buf);
  }

  public int getPosition() {
    return this.pos;
  }

}
