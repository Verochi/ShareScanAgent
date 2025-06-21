package com.alipay.sdk.m.l0;

/* loaded from: classes.dex */
public class e {

    public static class b {
        public int[] a;
        public int b;
        public int c;

        public b() {
            this.a = new int[256];
        }

        public /* synthetic */ b(com.alipay.sdk.m.l0.e.a aVar) {
            this();
        }
    }

    public static com.alipay.sdk.m.l0.e.b a(java.lang.String str) {
        if (str == null) {
            return null;
        }
        com.alipay.sdk.m.l0.e.b bVar = new com.alipay.sdk.m.l0.e.b(null);
        for (int i = 0; i < 256; i++) {
            bVar.a[i] = i;
        }
        bVar.b = 0;
        bVar.c = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            try {
                char charAt = str.charAt(i2);
                int[] iArr = bVar.a;
                int i5 = iArr[i4];
                i3 = ((charAt + i5) + i3) % 256;
                iArr[i4] = iArr[i3];
                iArr[i3] = i5;
                i2 = (i2 + 1) % str.length();
            } catch (java.lang.Exception unused) {
                return null;
            }
        }
        return bVar;
    }

    public static byte[] a(byte[] bArr) {
        com.alipay.sdk.m.l0.e.b a2;
        if (bArr == null || (a2 = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return a(bArr, a2);
    }

    public static byte[] a(byte[] bArr, com.alipay.sdk.m.l0.e.b bVar) {
        if (bArr == null || bVar == null) {
            return null;
        }
        int i = bVar.b;
        int i2 = bVar.c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) % 256;
            int[] iArr = bVar.a;
            int i4 = iArr[i];
            i2 = (i2 + i4) % 256;
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            int i5 = (iArr[i] + i4) % 256;
            bArr[i3] = (byte) (iArr[i5] ^ bArr[i3]);
        }
        bVar.b = i;
        bVar.c = i2;
        return bArr;
    }
}
