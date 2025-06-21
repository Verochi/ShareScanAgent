package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public abstract class a {
    private boolean a;
    private final com.anythink.core.common.m.a b = com.anythink.core.common.m.d.a();
    private final com.anythink.core.common.m.b c = new com.anythink.core.common.o.a.AnonymousClass1();

    /* renamed from: com.anythink.core.common.o.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.m.b {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this) {
                if (!com.anythink.core.common.o.a.this.a) {
                    com.anythink.core.common.o.a.b(com.anythink.core.common.o.a.this);
                    com.anythink.core.common.o.a.this.b();
                }
            }
        }
    }

    public static /* synthetic */ boolean b(com.anythink.core.common.o.a aVar) {
        aVar.a = true;
        return true;
    }

    private boolean c() {
        return this.a;
    }

    public final synchronized void a() {
        this.b.b(this.c);
    }

    public final synchronized void a(long j) {
        this.b.a(this.c, j, false);
    }

    public abstract void b();
}
