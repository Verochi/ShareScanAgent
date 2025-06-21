package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class b92 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.earlywarning.radar.map.opengl.polygon.render.RainRenderHandler n;
    public final /* synthetic */ java.util.Map t;

    public /* synthetic */ b92(com.moji.earlywarning.radar.map.opengl.polygon.render.RainRenderHandler rainRenderHandler, java.util.Map map) {
        this.n = rainRenderHandler;
        this.t = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.earlywarning.radar.map.opengl.polygon.render.RainRenderHandler.a(this.n, this.t);
    }
}
