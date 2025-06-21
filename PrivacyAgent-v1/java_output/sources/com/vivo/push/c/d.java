package com.vivo.push.c;

/* loaded from: classes19.dex */
public class d {
    private static volatile com.vivo.push.c.d d;
    private com.vivo.push.c.b a;
    private com.vivo.push.c.c b;
    private android.content.Context c;

    private d(android.content.Context context) {
        if (this.a == null) {
            this.c = com.vivo.push.util.ContextDelegate.getContext(context.getApplicationContext());
            this.a = new com.vivo.push.c.e(this.c);
        }
        if (this.b == null) {
            this.b = new com.vivo.push.c.a();
        }
    }

    public static com.vivo.push.c.d a(android.content.Context context) {
        if (d == null) {
            synchronized (com.vivo.push.c.d.class) {
                if (d == null && context != null) {
                    d = new com.vivo.push.c.d(context);
                }
            }
        }
        return d;
    }

    public final com.vivo.push.c.b a() {
        return this.a;
    }
}
