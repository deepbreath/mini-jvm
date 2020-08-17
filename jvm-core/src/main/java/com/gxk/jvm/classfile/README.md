#Classfile   
第一步纵观 Classfile 全局：  
- 打开 ClassFile 文件，里面包含每个属性的注释信息  
- cp 文件夹保存着 常量池信息 
  - Java 虚拟机目前一共定义了 14 种常量类型，这些常量名都以 "CONSTANT" 开头，以 "info" 结尾
- attribute 文件夹