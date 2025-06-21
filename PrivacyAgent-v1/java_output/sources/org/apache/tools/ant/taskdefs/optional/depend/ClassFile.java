package org.apache.tools.ant.taskdefs.optional.depend;

/* loaded from: classes25.dex */
public class ClassFile {
    public org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPool a;
    public java.lang.String b;

    public java.util.Vector<java.lang.String> getClassRefs() {
        java.util.Vector<java.lang.String> vector = new java.util.Vector<>();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry entry = this.a.getEntry(i);
            if (entry != null && entry.getTag() == 7) {
                org.apache.tools.ant.taskdefs.optional.depend.constantpool.ClassCPInfo classCPInfo = (org.apache.tools.ant.taskdefs.optional.depend.constantpool.ClassCPInfo) entry;
                if (!classCPInfo.getClassName().equals(this.b)) {
                    vector.add(org.apache.tools.ant.taskdefs.optional.depend.ClassFileUtils.convertSlashName(classCPInfo.getClassName()));
                }
            }
        }
        return vector;
    }

    public java.lang.String getFullClassName() {
        return org.apache.tools.ant.taskdefs.optional.depend.ClassFileUtils.convertSlashName(this.b);
    }

    public void read(java.io.InputStream inputStream) throws java.io.IOException, java.lang.ClassFormatError {
        java.io.DataInputStream dataInputStream = new java.io.DataInputStream(inputStream);
        if (dataInputStream.readInt() != -889275714) {
            throw new java.lang.ClassFormatError("No Magic Code Found - probably not a Java class file.");
        }
        dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPool constantPool = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPool();
        this.a = constantPool;
        constantPool.read(dataInputStream);
        this.a.resolve();
        dataInputStream.readUnsignedShort();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        this.b = ((org.apache.tools.ant.taskdefs.optional.depend.constantpool.ClassCPInfo) this.a.getEntry(readUnsignedShort)).getClassName();
    }
}
