package cn.fly.verify;

/* loaded from: classes.dex */
public class fn {
    private int a;

    public fn(int i) {
        this.a = i;
    }

    private byte[] a(byte[] bArr, int i) throws java.lang.Throwable {
        if (bArr.length > i - 1) {
            throw new java.lang.Throwable("Message too large");
        }
        byte[] bArr2 = new byte[i];
        bArr2[0] = 1;
        int length = bArr.length;
        bArr2[1] = (byte) (length >> 24);
        bArr2[2] = (byte) (length >> 16);
        bArr2[3] = (byte) (length >> 8);
        bArr2[4] = (byte) length;
        java.lang.System.arraycopy(bArr, 0, bArr2, i - length, length);
        return bArr2;
    }

    private byte[] a(byte[] bArr, int i, int i2, java.math.BigInteger bigInteger, java.math.BigInteger bigInteger2, int i3) throws java.lang.Throwable {
        if (bArr.length != i2 || i != 0) {
            byte[] bArr2 = new byte[i2];
            java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
            bArr = bArr2;
        }
        java.math.BigInteger bigInteger3 = new java.math.BigInteger(a(bArr, i3));
        if (bigInteger3.compareTo(bigInteger2) <= 0) {
            return bigInteger3.modPow(bigInteger, bigInteger2).toByteArray();
        }
        throw new java.lang.Throwable("the message must be smaller than the modulue");
    }

    public byte[] a(byte[] bArr, java.math.BigInteger bigInteger, java.math.BigInteger bigInteger2) throws java.lang.Throwable {
        int i = this.a / 8;
        int i2 = i - 11;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.DataOutputStream dataOutputStream = null;
        try {
            java.io.DataOutputStream dataOutputStream2 = new java.io.DataOutputStream(byteArrayOutputStream);
            int i3 = 0;
            while (bArr.length > i3) {
                try {
                    int min = java.lang.Math.min(bArr.length - i3, i2);
                    byte[] a = a(bArr, i3, min, bigInteger, bigInteger2, i);
                    dataOutputStream2.writeInt(a.length);
                    dataOutputStream2.write(a);
                    i3 += min;
                } catch (java.lang.Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    cn.fly.verify.dw.a(dataOutputStream, byteArrayOutputStream);
                    throw th;
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            cn.fly.verify.dw.a(dataOutputStream2, byteArrayOutputStream);
            return byteArray;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
