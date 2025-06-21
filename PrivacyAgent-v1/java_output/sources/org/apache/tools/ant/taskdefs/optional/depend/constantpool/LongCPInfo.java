package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public class LongCPInfo extends org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantCPInfo {
    public LongCPInfo() {
        super(5, 2);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void read(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        setValue(new java.lang.Long(dataInputStream.readLong()));
    }

    public java.lang.String toString() {
        return "Long Constant Pool Entry: " + getValue();
    }
}
