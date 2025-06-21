package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class z82 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.earlywarning.radar.map.opengl.polygon.render.RainRenderHandler n;
    public final /* synthetic */ int t;
    public final /* synthetic */ float u;

    public /* synthetic */ z82(com.moji.earlywarning.radar.map.opengl.polygon.render.RainRenderHandler rainRenderHandler, int i, float f) {
        this.n = rainRenderHandler;
        this.t = i;
        this.u = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.earlywarning.radar.map.opengl.polygon.render.RainRenderHandler.b(this.n, this.t, this.u);
    }
}
