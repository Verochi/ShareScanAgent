package org.apache.tools.ant.taskdefs.optional.jlink;

/* loaded from: classes25.dex */
class ConstantPool {
    public byte[] a;
    public java.lang.Object[] b;

    public ConstantPool(java.io.DataInput dataInput) throws java.io.IOException {
        int readUnsignedShort = dataInput.readUnsignedShort();
        this.a = new byte[readUnsignedShort];
        this.b = new java.lang.Object[readUnsignedShort];
        int i = 1;
        while (i < readUnsignedShort) {
            byte readByte = dataInput.readByte();
            this.a[i] = readByte;
            switch (readByte) {
                case 1:
                    this.b[i] = dataInput.readUTF();
                    continue;
                case 3:
                    this.b[i] = new java.lang.Integer(dataInput.readInt());
                    continue;
                case 4:
                    this.b[i] = new java.lang.Float(dataInput.readFloat());
                    continue;
                case 5:
                    this.b[i] = new java.lang.Long(dataInput.readLong());
                    break;
                case 6:
                    this.b[i] = new java.lang.Double(dataInput.readDouble());
                    break;
                case 7:
                case 8:
                    this.b[i] = new java.lang.Integer(dataInput.readUnsignedShort());
                    continue;
                case 9:
                case 10:
                case 11:
                case 12:
                    this.b[i] = new java.lang.Integer(dataInput.readInt());
                    continue;
            }
            i++;
            i++;
        }
    }
}
