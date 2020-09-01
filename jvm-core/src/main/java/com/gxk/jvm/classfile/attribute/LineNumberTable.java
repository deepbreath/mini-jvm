package com.gxk.jvm.classfile.attribute;

import com.gxk.jvm.classfile.Attribute;

/**
 * 用于 Debug 时候获取源 Class 文件的时候当前代码在哪一行
 * LineNumberTable 用来存放源码行号和字节码偏移量之间的对应关系，
 * 这 LineNumberTable 属于调试信息，不是类文件运行的必需的属性，
 * 默认情况下都会生成。如果没有这两个属性，那么在调试时没有办法在源码中设置断点，
 * 也没有办法在代码抛出异常的时候在错误堆栈中显示出错的行号信息。
 * 
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
