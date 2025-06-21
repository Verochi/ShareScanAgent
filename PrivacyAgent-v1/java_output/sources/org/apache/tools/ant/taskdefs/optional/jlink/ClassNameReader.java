package org.apache.tools.ant.taskdefs.optional.jlink;

/* loaded from: classes25.dex */
public class ClassNameReader {
    public static java.lang.String getClassName(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.DataInputStream dataInputStream = new java.io.DataInputStream(inputStream);
        if (dataInputStream.readInt() != -889275714) {
            return null;
        }
        dataInputStream.readInt();
        java.lang.Object[] objArr = new org.apache.tools.ant.taskdefs.optional.jlink.ConstantPool(dataInputStream).b;
        dataInputStream.readUnsignedShort();
        return (java.lang.String) objArr[((java.lang.Integer) objArr[dataInputStream.readUnsignedShort()]).intValue()];
    }
}
