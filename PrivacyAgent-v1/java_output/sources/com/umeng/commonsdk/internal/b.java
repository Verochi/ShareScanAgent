package com.umeng.commonsdk.internal;

/* loaded from: classes19.dex */
public class b {
    private static com.umeng.commonsdk.internal.b b;
    private android.content.Context a;
    private com.umeng.commonsdk.internal.c c;

    private b(android.content.Context context) {
        this.a = context;
        this.c = new com.umeng.commonsdk.internal.c(context);
    }

    public static synchronized com.umeng.commonsdk.internal.b a(android.content.Context context) {
        com.umeng.commonsdk.internal.b bVar;
        synchronized (com.umeng.commonsdk.internal.b.class) {
            if (b == null) {
                b = new com.umeng.commonsdk.internal.b(context.getApplicationContext());
            }
            bVar = b;
        }
        return bVar;
    }

    public com.umeng.commonsdk.internal.c a() {
        return this.c;
    }
}
