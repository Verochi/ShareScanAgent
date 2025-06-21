package defpackage;

/* loaded from: classes29.dex */
public final /* synthetic */ class a92 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.polygon.render.RainRenderHandler n;
    public final /* synthetic */ int t;
    public final /* synthetic */ float u;

    public /* synthetic */ a92(com.moji.shorttime.ui.map.opengl.polygon.render.RainRenderHandler rainRenderHandler, int i, float f) {
        this.n = rainRenderHandler;
        this.t = i;
        this.u = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.polygon.render.RainRenderHandler.a(this.n, this.t, this.u);
    }
}
