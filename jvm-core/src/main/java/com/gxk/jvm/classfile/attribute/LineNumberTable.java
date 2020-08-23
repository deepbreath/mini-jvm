package com.gxk.jvm.classfile.attribute;

import com.gxk.jvm.classfile.Attribute;

/**
 * 用于 Debug 时候获取源 Class 文件的时候当前代码在哪一行
 *  结构如下
 *  LineNumberTable_attribute {
 *    u2 attribute_name_index;
 *    u4 attribute_length;
 *    u2 line_number_table_length;
 *    {   u2 start_pc;
 *      u2 line_number;
 *    } line_number_table[line_number_table_length];
 *  }
 */
public class LineNumberTable extends Attribute {

  public final Line[] lines;

  public LineNumberTable(Line[] lines) {
    this.lines = lines;
  }

  public static class Line {

    public final int startPc;
    public final int lineNumber;

    public Line(int startPc, int lineNumber) {
      this.startPc = startPc;
      this.lineNumber = lineNumber;
    }
  }
}
