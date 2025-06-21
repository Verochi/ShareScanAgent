package com.igexin.push.g;

/* loaded from: classes23.dex */
public class a implements com.igexin.push.g.b.c {
    private static final long b = 360000;
    private static com.igexin.push.g.a c = null;
    private static java.lang.String d = "CheckCondition";
    private long a = 0;

    public static com.igexin.push.g.a a() {
        if (c == null) {
            synchronized (com.igexin.push.g.a.class) {
                if (c == null) {
                    c = new com.igexin.push.g.a();
                }
            }
        }
        return c;
    }

    private static boolean d() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        long j = com.igexin.push.core.e.S;
        if (j <= 0) {
            com.igexin.push.core.e.S = currentTimeMillis - 60000;
            return true;
        }
        if (currentTimeMillis - j <= 60000) {
            return false;
        }
        com.igexin.push.core.e.S = currentTimeMillis;
        return true;
    }

    @Override // com.igexin.push.g.b.c
    public final void a(long j) {
        this.a = j;
    }

    public final void a(boolean z) {
        if (!z || d()) {
            b();
        }
    }

    @Override // com.igexin.push.g.b.c
    public final void b() {
        com.igexin.c.a.c.a.b("CheckConditionTask", "CheckConditionTask start to run check condition status...");
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = com.igexin.push.core.b.S;
        com.igexin.push.core.d.a.a.a(obtain);
    }

    @Override // com.igexin.push.g.b.c
    public final boolean c() {
        return java.lang.System.currentTimeMillis() - this.a > b;
    }
}
