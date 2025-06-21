package com.meizu.cloud.pushsdk.c.g;

/* loaded from: classes23.dex */
public class e implements java.io.Serializable, java.lang.Comparable<com.meizu.cloud.pushsdk.c.g.e> {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
    public static final com.meizu.cloud.pushsdk.c.g.e b = a(new byte[0]);
    private static final long serialVersionUID = 1;
    final byte[] c;
    transient int d;
    transient java.lang.String e;

    public e(byte[] bArr) {
        this.c = bArr;
    }

    public static com.meizu.cloud.pushsdk.c.g.e a(java.io.InputStream inputStream, int i) throws java.io.IOException {
        if (inputStream == null) {
            throw new java.lang.IllegalArgumentException("in == null");
        }
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + i);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                throw new java.io.EOFException();
            }
            i2 += read;
        }
        return new com.meizu.cloud.pushsdk.c.g.e(bArr);
    }

    public static com.meizu.cloud.pushsdk.c.g.e a(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("s == null");
        }
        com.meizu.cloud.pushsdk.c.g.e eVar = new com.meizu.cloud.pushsdk.c.g.e(str.getBytes(com.meizu.cloud.pushsdk.c.g.o.a));
        eVar.e = str;
        return eVar;
    }

    public static com.meizu.cloud.pushsdk.c.g.e a(byte... bArr) {
        if (bArr != null) {
            return new com.meizu.cloud.pushsdk.c.g.e((byte[]) bArr.clone());
        }
        throw new java.lang.IllegalArgumentException("data == null");
    }

    private com.meizu.cloud.pushsdk.c.g.e b(java.lang.String str) {
        try {
            return a(java.security.MessageDigest.getInstance(str).digest(this.c));
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException {
        com.meizu.cloud.pushsdk.c.g.e a2 = a(objectInputStream, objectInputStream.readInt());
        try {
            java.lang.reflect.Field declaredField = com.meizu.cloud.pushsdk.c.g.e.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            declaredField.set(this, a2.c);
        } catch (java.lang.IllegalAccessException unused) {
            throw new java.lang.AssertionError();
        } catch (java.lang.NoSuchFieldException unused2) {
            throw new java.lang.AssertionError();
        }
    }

    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.writeInt(this.c.length);
        objectOutputStream.write(this.c);
    }

    public byte a(int i) {
        return this.c[i];
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.meizu.cloud.pushsdk.c.g.e eVar) {
        int d = d();
        int d2 = eVar.d();
        int min = java.lang.Math.min(d, d2);
        for (int i = 0; i < min; i++) {
            int a2 = a(i) & 255;
            int a3 = eVar.a(i) & 255;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (d == d2) {
            return 0;
        }
        return d < d2 ? -1 : 1;
    }

    public java.lang.String a() {
        java.lang.String str = this.e;
        if (str != null) {
            return str;
        }
        java.lang.String str2 = new java.lang.String(this.c, com.meizu.cloud.pushsdk.c.g.o.a);
        this.e = str2;
        return str2;
    }

    public void a(com.meizu.cloud.pushsdk.c.g.b bVar) {
        byte[] bArr = this.c;
        bVar.c(bArr, 0, bArr.length);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.c;
        return i <= bArr2.length - i3 && i2 <= bArr.length - i3 && com.meizu.cloud.pushsdk.c.g.o.a(bArr2, i, bArr, i2, i3);
    }

    public com.meizu.cloud.pushsdk.c.g.e b() {
        return b("MD5");
    }

    public java.lang.String c() {
        byte[] bArr = this.c;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new java.lang.String(cArr);
    }

    public int d() {
        return this.c.length;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.meizu.cloud.pushsdk.c.g.e) {
            com.meizu.cloud.pushsdk.c.g.e eVar = (com.meizu.cloud.pushsdk.c.g.e) obj;
            int d = eVar.d();
            byte[] bArr = this.c;
            if (d == bArr.length && eVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = java.util.Arrays.hashCode(this.c);
        this.d = hashCode;
        return hashCode;
    }

    public java.lang.String toString() {
        byte[] bArr = this.c;
        return bArr.length == 0 ? "ByteString[size=0]" : bArr.length <= 16 ? java.lang.String.format("ByteString[size=%s data=%s]", java.lang.Integer.valueOf(bArr.length), c()) : java.lang.String.format("ByteString[size=%s md5=%s]", java.lang.Integer.valueOf(bArr.length), b().c());
    }
}
