package com.anythink.basead.ui.guidetoclickv2;

/* loaded from: classes12.dex */
public abstract class BaseG2CV2View extends android.widget.RelativeLayout {
    protected com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.b a;
    protected com.anythink.basead.ui.b.b.a b;
    private long c;
    private long d;
    private java.lang.Runnable e;
    private boolean f;
    private boolean g;

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View baseG2CV2View = com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.this;
            if (baseG2CV2View.a == null || baseG2CV2View.f || !com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.this.canStartNextAnim()) {
                return;
            }
            com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.b(com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.this);
            com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.this.a.a();
            com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.this.b();
        }
    }

    public class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;

        private a() {
        }
    }

    public interface b {
        void a();

        void b();
    }

    public BaseG2CV2View(android.content.Context context) {
        this(context, null);
    }

    public BaseG2CV2View(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseG2CV2View(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 5000L;
        this.g = false;
    }

    public static /* synthetic */ boolean b(com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View baseG2CV2View) {
        baseG2CV2View.f = true;
        return true;
    }

    public void a() {
    }

    public abstract void a(int i, int i2);

    public void b() {
    }

    public boolean canStartNextAnim() {
        return true;
    }

    public void init(long j, int i, int i2, com.anythink.basead.ui.b.b.a aVar, com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.b bVar) {
        this.c = j;
        this.b = aVar;
        this.a = bVar;
        this.f = false;
        this.e = new com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.AnonymousClass1();
        a(i, i2);
    }

    public void pauseAnimPlay() {
        if (this.g) {
            this.g = false;
            long j = this.c;
            if (j > 0) {
                this.c = java.lang.Math.max(j - (android.os.SystemClock.elapsedRealtime() - this.d), 0L);
            }
            com.anythink.core.common.b.o.a().d(this.e);
            b();
        }
    }

    public void release() {
    }

    public void resumeAnimPlay() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.d = android.os.SystemClock.elapsedRealtime();
        if (this.c <= 0) {
            this.a.a();
        } else {
            a();
            com.anythink.core.common.b.o.a().a(this.e, this.c);
        }
    }
}
