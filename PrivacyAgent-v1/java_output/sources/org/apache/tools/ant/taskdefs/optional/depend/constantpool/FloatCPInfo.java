package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public class FloatCPInfo extends org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantCPInfo {
    public FloatCPInfo() {
        super(4, 1);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void read(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        setValue(new java.lang.Float(dataInputStream.readFloat()));
    }

    public java.lang.String toString() {
        return "Float Constant Pool Entry: " + getValue();
    }
}
