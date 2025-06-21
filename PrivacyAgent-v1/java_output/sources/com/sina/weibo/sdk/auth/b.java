package com.sina.weibo.sdk.auth;

/* loaded from: classes19.dex */
public final class b {
    private java.util.Map<java.lang.String, com.sina.weibo.sdk.auth.WbAuthListener> i;

    public static class a {
        private static final com.sina.weibo.sdk.auth.b j = new com.sina.weibo.sdk.auth.b((byte) 0);
    }

    private b() {
        this.i = new java.util.HashMap();
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static synchronized com.sina.weibo.sdk.auth.b f() {
        com.sina.weibo.sdk.auth.b bVar;
        synchronized (com.sina.weibo.sdk.auth.b.class) {
            bVar = com.sina.weibo.sdk.auth.b.a.j;
        }
        return bVar;
    }

    public final synchronized com.sina.weibo.sdk.auth.WbAuthListener a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return this.i.get(str);
    }

    public final synchronized void a(java.lang.String str, com.sina.weibo.sdk.auth.WbAuthListener wbAuthListener) {
        if (!android.text.TextUtils.isEmpty(str) && wbAuthListener != null) {
            this.i.put(str, wbAuthListener);
        }
    }

    public final synchronized void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.i.remove(str);
    }
}
