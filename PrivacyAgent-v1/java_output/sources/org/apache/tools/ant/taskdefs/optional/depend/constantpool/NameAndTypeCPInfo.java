package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public class NameAndTypeCPInfo extends org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry {
    public java.lang.String d;
    public java.lang.String e;
    public int f;
    public int g;

    public NameAndTypeCPInfo() {
        super(12, 1);
    }

    public java.lang.String getName() {
        return this.d;
    }

    public java.lang.String getType() {
        return this.e;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void read(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        this.f = dataInputStream.readUnsignedShort();
        this.g = dataInputStream.readUnsignedShort();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void resolve(org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPool constantPool) {
        this.d = ((org.apache.tools.ant.taskdefs.optional.depend.constantpool.Utf8CPInfo) constantPool.getEntry(this.f)).getValue();
        this.e = ((org.apache.tools.ant.taskdefs.optional.depend.constantpool.Utf8CPInfo) constantPool.getEntry(this.g)).getValue();
        super.resolve(constantPool);
    }

    public java.lang.String toString() {
        if (isResolved()) {
            return "Name = " + this.d + ", type = " + this.e;
        }
        return "Name index = " + this.f + ", descriptor index = " + this.g;
    }
}
