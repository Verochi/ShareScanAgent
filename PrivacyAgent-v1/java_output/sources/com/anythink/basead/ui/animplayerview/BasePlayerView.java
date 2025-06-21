package com.anythink.basead.ui.animplayerview;

/* loaded from: classes12.dex */
public abstract class BasePlayerView extends android.widget.RelativeLayout {
    protected long h;
    protected long i;
    protected int j;
    protected int k;
    protected int l;
    protected boolean m;
    protected boolean n;
    protected boolean o;
    protected boolean p;
    protected boolean q;
    protected boolean r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f152s;
    protected java.lang.Thread t;
    protected android.os.Handler u;
    protected com.anythink.basead.ui.animplayerview.BasePlayerView.a v;
    protected com.anythink.core.common.f.l w;
    protected com.anythink.core.common.f.m x;

    public interface a {
        void a();

        void a(int i);

        void a(long j);

        void a(com.anythink.basead.c.e eVar);

        void b();

        void b(long j);

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    public BasePlayerView(android.content.Context context) {
        super(context);
        this.h = 5000L;
        this.i = -1L;
        this.q = false;
        this.r = false;
        this.f152s = false;
    }

    public BasePlayerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 5000L;
        this.i = -1L;
        this.q = false;
        this.r = false;
        this.f152s = false;
    }

    public BasePlayerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 5000L;
        this.i = -1L;
        this.q = false;
        this.r = false;
        this.f152s = false;
    }

    public void a(com.anythink.basead.c.e eVar) {
        com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar = this.v;
        if (aVar != null) {
            aVar.a(eVar);
        }
        this.v = null;
    }

    public abstract long getCurrentPosition();

    public abstract long getVideoLength();

    public abstract boolean hasVideo();

    public final void i() {
        this.v = null;
    }

    public void init(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, boolean z, java.util.List<android.graphics.Bitmap> list) {
        this.w = lVar;
        this.x = mVar;
    }

    public abstract boolean isMute();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void setListener(com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar);

    public abstract void setMute(boolean z);

    public abstract void start();

    public abstract void stop();
}
