package com.anythink.expressad.video.dynview.i.c;

/* loaded from: classes12.dex */
public final class b {
    private static final long a = 1000;
    private long b = 0;
    private long c;
    private com.anythink.expressad.video.dynview.i.c.a d;
    private com.anythink.expressad.video.dynview.i.c.b.a e;

    public static class a extends android.os.CountDownTimer {
        private com.anythink.expressad.video.dynview.i.c.a a;

        public a(long j, long j2) {
            super(j, j2);
        }

        public final void a(com.anythink.expressad.video.dynview.i.c.a aVar) {
            this.a = aVar;
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            com.anythink.expressad.video.dynview.i.c.a aVar = this.a;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j) {
            com.anythink.expressad.video.dynview.i.c.a aVar = this.a;
            if (aVar != null) {
                aVar.a(j);
            }
        }
    }

    private void d() {
        com.anythink.expressad.video.dynview.i.c.b.a aVar = this.e;
        if (aVar != null) {
            aVar.cancel();
            this.e = null;
        }
        if (this.c <= 0) {
            this.c = this.b + 1000;
        }
        com.anythink.expressad.video.dynview.i.c.b.a aVar2 = new com.anythink.expressad.video.dynview.i.c.b.a(this.b, this.c);
        this.e = aVar2;
        aVar2.a(this.d);
    }

    public final com.anythink.expressad.video.dynview.i.c.b a() {
        this.c = 1000L;
        return this;
    }

    public final com.anythink.expressad.video.dynview.i.c.b a(long j) {
        this.b = j;
        return this;
    }

    public final com.anythink.expressad.video.dynview.i.c.b a(com.anythink.expressad.video.dynview.i.c.a aVar) {
        this.d = aVar;
        return this;
    }

    public final void a(long j, com.anythink.expressad.video.dynview.i.c.a aVar) {
        this.b = j;
        this.d = aVar;
        d();
        com.anythink.expressad.video.dynview.i.c.b.a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.start();
        }
    }

    public final void b() {
        if (this.e == null) {
            d();
        }
        this.e.start();
    }

    public final void c() {
        com.anythink.expressad.video.dynview.i.c.b.a aVar = this.e;
        if (aVar != null) {
            aVar.cancel();
            this.e = null;
        }
    }
}
