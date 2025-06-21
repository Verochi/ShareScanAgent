package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public class Utf8CPInfo extends org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry {
    public java.lang.String d;

    public Utf8CPInfo() {
        super(1, 1);
    }

    public java.lang.String getValue() {
        return this.d;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void read(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        this.d = dataInputStream.readUTF();
    }

    public java.lang.String toString() {
        return "UTF8 Value = " + this.d;
    }
}
