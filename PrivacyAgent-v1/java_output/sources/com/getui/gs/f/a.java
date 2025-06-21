package com.getui.gs.f;

/* loaded from: classes22.dex */
public abstract class a implements com.getui.gs.f.c {
    final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);
    protected long b;

    /* renamed from: com.getui.gs.f.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.getui.gs.f.a.this.c()) {
                    int b = com.getui.gs.f.a.this.b();
                    int d = com.getui.gs.f.a.this.d();
                    int i = 0;
                    while (i < d) {
                        int i2 = i + b;
                        try {
                            com.getui.gs.f.a.this.a(i, java.lang.Math.min(i2, d) - 1);
                            com.getui.gs.f.a.this.b = java.lang.System.currentTimeMillis();
                            java.lang.Thread.sleep(new java.security.SecureRandom().nextInt(1000) + 500);
                        } catch (java.lang.Throwable th) {
                            java.lang.String format = java.lang.String.format("upload %s error", com.getui.gs.f.a.this);
                            com.getui.gs.h.a.c(format + th);
                            com.getui.gs.h.b.a(format, th);
                        }
                        i = i2;
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.getui.gs.f.c
    public final void a() {
        if (!com.getui.gtc.base.util.NetworkUtil.isNetWorkAvailable(com.getui.gs.a.d.a())) {
            com.getui.gs.h.a.a(java.lang.String.format("%s upload task is waiting for network", this));
        } else if (b() <= 0) {
            com.getui.gs.h.b.a.a.a.d(java.lang.String.format("%s upload task failed: invalid patch size %s", this, java.lang.Integer.valueOf(b())));
        } else {
            if (this.a.getAndSet(true)) {
                return;
            }
            com.getui.gs.h.c.b().execute(new com.getui.gs.f.a.AnonymousClass1());
        }
    }

    public abstract void a(int i, int i2) throws java.lang.Throwable;

    public int b() {
        return 1;
    }

    public boolean c() {
        return true;
    }

    public abstract int d();
}
