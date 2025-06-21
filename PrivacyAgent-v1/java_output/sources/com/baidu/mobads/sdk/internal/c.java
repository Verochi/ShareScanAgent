package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class c {
    private static volatile com.baidu.mobads.sdk.internal.c a;

    public interface a {
        public static final java.lang.String a = "remote_adserv";
        public static final java.lang.String b = "remote_novel";
    }

    private c() {
    }

    public static com.baidu.mobads.sdk.internal.c a() {
        if (a == null) {
            synchronized (com.baidu.mobads.sdk.internal.c.class) {
                if (a == null) {
                    a = new com.baidu.mobads.sdk.internal.c();
                }
            }
        }
        return a;
    }

    public com.baidu.mobads.sdk.internal.ar a(java.lang.String str) {
        return new com.baidu.mobads.sdk.internal.ar(str);
    }
}
