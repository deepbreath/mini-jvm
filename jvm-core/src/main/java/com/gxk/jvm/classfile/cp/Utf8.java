package com.gxk.jvm.classfile.cp;

import com.gxk.jvm.classfile.ConstantInfo;
import com.gxk.jvm.classfile.MyByteArrayInputStream;

/**
 *  存储的是经过 MUTF-8(modified UTF-8) 编码的字符串
 *  这里的常量结构不明白
 * {
 *     u1 tag
 *     u2 length
 *     u1 byte[length]
 * }
 */
public class Utf8 extends ConstantInfo {

  public final byte[] bytes;

  public Utf8(int infoEnum, byte[] bytes) {
    super(infoEnum);
    this.bytes = bytes;
  }

  public final String getString() {

    MyByteArrayInputStream is = new MyByteArrayInputStream(bytes);
    StringBuilder sb = new StringBuilder();
    while (is.available() > 0) {
      int b = is.read();
      if (b > 0) {
        sb.append((char) b);
      } else {
        int b2 = is.read();
        if ((b2 & 0xf0) != 0xe0) {
          sb.append((char) ((b & 0x1F) << 6 | b2 & 0x3F));
        } else {
          int b3 = is.read();
          sb.append((char) ((b & 0x0F) << 12 | (b2 & 0x3F) << 6 | b3 & 0x3F));
        }
      }
    }
    return sb.toString();
  }
}
