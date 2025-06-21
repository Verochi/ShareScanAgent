package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public abstract class s1 {
    public static com.zx.a.I8b7.s1 a(com.zx.a.I8b7.x0 x0Var, java.lang.String str) {
        java.nio.charset.Charset.forName("UTF-8");
        if (x0Var != null && x0Var.a() == null) {
            java.nio.charset.Charset.forName("UTF-8");
            x0Var = com.zx.a.I8b7.x0.b(x0Var + "; charset=utf-8");
        }
        return a(x0Var, str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }

    public static com.zx.a.I8b7.s1 a(com.zx.a.I8b7.x0 x0Var, byte[] bArr) {
        int length = bArr.length;
        long length2 = bArr.length;
        long j = length;
        if ((j | 0) < 0 || 0 > length2 || length2 - 0 < j) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        return new com.zx.a.I8b7.r1(x0Var, length, bArr, 0);
    }
}
