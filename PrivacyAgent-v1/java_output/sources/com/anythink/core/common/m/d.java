package com.anythink.core.common.m;

/* loaded from: classes12.dex */
public class d implements com.anythink.core.common.m.a {
    private static final java.lang.String a = "TimeOutHandlerImpl";
    private static volatile com.anythink.core.common.m.d b;
    private final android.os.Handler d = com.anythink.core.common.o.b.b.a().a(12);
    private final android.os.Handler c = new android.os.Handler(android.os.Looper.getMainLooper());

    private d() {
    }

    private android.os.Handler a(boolean z) {
        return z ? this.c : this.d;
    }

    public static com.anythink.core.common.m.a a() {
        if (b == null) {
            synchronized (com.anythink.core.common.m.d.class) {
                if (b == null) {
                    b = new com.anythink.core.common.m.d();
                }
            }
        }
        return b;
    }

    @Override // com.anythink.core.common.m.a
    public final void a(com.anythink.core.common.m.b bVar) {
        a(bVar, 3000L, true);
    }

    @Override // com.anythink.core.common.m.a
    public final void a(com.anythink.core.common.m.b bVar, long j, boolean z) {
        android.os.Handler a2 = a(z);
        if (a2 == null) {
            return;
        }
        a2.postDelayed(bVar, j);
    }

    @Override // com.anythink.core.common.m.a
    public final void b(com.anythink.core.common.m.b bVar) {
        android.os.Handler handler = this.c;
        if (handler != null && bVar != null) {
            handler.removeCallbacks(bVar);
        }
        android.os.Handler handler2 = this.d;
        if (handler2 == null || bVar == null) {
            return;
        }
        handler2.removeCallbacks(bVar);
    }
}
