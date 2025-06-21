package com.bytedance.pangle.res.a;

/* loaded from: classes.dex */
public final class d {
    private static <T> T a(T t) {
        t.getClass();
        return t;
    }

    public static void a(java.io.InputStream inputStream, byte[] bArr, int i, int i2) {
        a(inputStream);
        a(bArr);
        int i3 = 0;
        if (i2 < 0) {
            throw new java.lang.IndexOutOfBoundsException(java.lang.String.format("len (%s) cannot be negative", java.lang.Integer.valueOf(i2)));
        }
        int i4 = i + i2;
        int length = bArr.length;
        if (i < 0 || i4 < i || i4 > length) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(i);
            sb.append(i4);
            sb.append(length);
            throw new java.lang.IndexOutOfBoundsException(sb.toString());
        }
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read == -1) {
                break;
            } else {
                i3 += read;
            }
        }
        if (i3 == i2) {
            return;
        }
        throw new java.io.EOFException("reached end of stream after reading " + i3 + " bytes; " + i2 + " bytes expected");
    }
}
