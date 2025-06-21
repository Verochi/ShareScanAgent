package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public class StringCPInfo extends org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantCPInfo {
    public int e;

    public StringCPInfo() {
        super(8, 1);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void read(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        this.e = dataInputStream.readUnsignedShort();
        setValue("unresolved");
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void resolve(org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPool constantPool) {
        setValue(((org.apache.tools.ant.taskdefs.optional.depend.constantpool.Utf8CPInfo) constantPool.getEntry(this.e)).getValue());
        super.resolve(constantPool);
    }

    public java.lang.String toString() {
        return "String Constant Pool Entry for " + getValue() + "[" + this.e + "]";
    }
}
