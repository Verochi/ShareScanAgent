package cn.fly.verify;

/* loaded from: classes.dex */
public class an {
    private static java.util.Random a = new java.util.Random();
    private static cn.fly.verify.fn b = new cn.fly.verify.fn(1024);
    private static java.math.BigInteger c = new java.math.BigInteger("d008219b14c84872559aaf9e69d1348175289c186912da64b2393bab376bb0d6b471220cb29cbc9875b148b593eb9d7c4c359549a1aff22f6de9d18d22f0b6cb", 16);
    private static java.math.BigInteger d = new java.math.BigInteger("1f228b2b8fbb7317674db20bab1d4b0f0ddb3e1f3a93177f1821c026ffd7c6b782be720a308ab69bf6c631c3c0c4d68bf9d92ddaaf712a032d591ba1c296df13332a23e37b281e5fd9b93ab016dd3efc5de45e264ed692ac63ac40013f507cd272b7aeeb85be9fe2f31f11b8c55d904b5331932c70c7cf3f2b05cb802f6b89a7", 16);

    public static java.lang.String a(java.lang.String str) throws java.lang.Throwable {
        return c(a(), str);
    }

    public static byte[] a() throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
        a.setSeed(java.lang.System.currentTimeMillis());
        dataOutputStream.writeLong(a.nextLong());
        dataOutputStream.writeLong(a.nextLong());
        dataOutputStream.flush();
        dataOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static java.lang.String[] a(byte[] bArr, java.lang.String str) throws java.lang.Throwable {
        return new java.lang.String[]{cn.fly.verify.as.a(bArr), c(bArr, str)};
    }

    public static java.lang.String b(byte[] bArr, java.lang.String str) {
        java.lang.String str2 = "";
        try {
            new java.io.DataOutputStream(new java.io.ByteArrayOutputStream());
            java.io.DataInputStream dataInputStream = new java.io.DataInputStream(new java.io.ByteArrayInputStream(android.util.Base64.decode(str, 2)));
            while (dataInputStream.available() > 0) {
                int readInt = dataInputStream.readInt();
                dataInputStream.readFully(new byte[readInt], 0, readInt);
                int readInt2 = dataInputStream.readInt();
                byte[] bArr2 = new byte[readInt2];
                dataInputStream.readFully(bArr2, 0, readInt2);
                str2 = new java.lang.String(cn.fly.verify.fi.b(bArr, bArr2));
            }
        } catch (java.lang.Throwable unused) {
        }
        return str2;
    }

    private static java.lang.String c(byte[] bArr, java.lang.String str) throws java.lang.Throwable {
        byte[] bytes = str.getBytes("utf-8");
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
        byte[] a2 = b.a(bArr, c, d);
        dataOutputStream.writeInt(a2.length);
        dataOutputStream.write(a2);
        byte[] a3 = cn.fly.verify.fi.a(bArr, bytes);
        dataOutputStream.writeInt(a3.length);
        dataOutputStream.write(a3);
        dataOutputStream.flush();
        dataOutputStream.close();
        return android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }
}
