package com.gxk.jvm.classfile.attribute;

import com.gxk.jvm.classfile.Attribute;

/**
 *   确认源文件是从哪个 Class 文件中编译出来的
 *   SourceFile_attribute {
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u2 sourcefile_index;
 *   }
 */
public class SourceFile extends Attribute {

  public final String name;

  public SourceFile(String name) {
    this.name = name;
  }
}
