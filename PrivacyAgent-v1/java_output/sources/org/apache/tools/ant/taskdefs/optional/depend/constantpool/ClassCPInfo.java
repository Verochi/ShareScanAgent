package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public class ClassCPInfo extends org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry {
    public java.lang.String d;
    public int e;

    public ClassCPInfo() {
        super(7, 1);
    }

    public java.lang.String getClassName() {
        return this.d;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void read(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        this.e = dataInputStream.readUnsignedShort();
        this.d = "unresolved";
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void resolve(org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPool constantPool) {
        this.d = ((org.apache.tools.ant.taskdefs.optional.depend.constantpool.Utf8CPInfo) constantPool.getEntry(this.e)).getValue();
        super.resolve(constantPool);
    }

    public java.lang.String toString() {
        return "Class Constant Pool Entry for " + this.d + "[" + this.e + "]";
    }
}
