package com.gxk.jvm.classfile.attribute;

import com.gxk.jvm.classfile.Attribute;

/**
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
