package com.tencent.connect.auth;

/* loaded from: classes19.dex */
public class b {
    public static com.tencent.connect.auth.b a = null;
    static final /* synthetic */ boolean d = true;
    private static int e;
    public java.util.HashMap<java.lang.String, com.tencent.connect.auth.b.a> b = new java.util.HashMap<>();
    public final java.lang.String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static class a {
        public com.tencent.tauth.IUiListener a;
        public com.tencent.connect.auth.a b;
        public java.lang.String c;
    }

    public static com.tencent.connect.auth.b a() {
        if (a == null) {
            a = new com.tencent.connect.auth.b();
        }
        return a;
    }

    public static int b() {
        int i = e + 1;
        e = i;
        return i;
    }

    public java.lang.String a(com.tencent.connect.auth.b.a aVar) {
        int b = b();
        try {
            this.b.put("" + b, aVar);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return "" + b;
    }

    public java.lang.String c() {
        int ceil = (int) java.lang.Math.ceil((java.lang.Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < ceil; i++) {
            stringBuffer.append(charArray[(int) (java.lang.Math.random() * length)]);
        }
        return stringBuffer.toString();
    }
}
