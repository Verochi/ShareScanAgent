package com.igexin.c.a.b.a.a;

/* loaded from: classes22.dex */
public abstract class a extends com.igexin.c.a.b.f {
    protected volatile boolean f;
    protected volatile int g;
    protected java.lang.String h;
    protected volatile boolean i;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.igexin.c.a.b.a.a.a$a, reason: collision with other inner class name */
    public static final class EnumC0368a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {1, 2, 3};

        private EnumC0368a(java.lang.String str, int i) {
        }

        private static int[] a() {
            return (int[]) d.clone();
        }
    }

    public a(int i, com.igexin.c.a.b.d dVar) {
        super(i, null, dVar);
        this.g = com.igexin.c.a.b.a.a.a.EnumC0368a.a;
        this.i = true;
    }

    public abstract void c_();

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
        super.d();
        this.o = true;
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
        java.lang.Thread thread = this.K;
        if (!thread.isAlive() || thread.isInterrupted()) {
            return;
        }
        thread.interrupt();
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }

    public final boolean g() {
        return this.g == com.igexin.c.a.b.a.a.a.EnumC0368a.c;
    }
}
