package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class y82 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.polygon.render.RainRenderHandler n;
    public final /* synthetic */ java.util.Map t;

    public /* synthetic */ y82(com.moji.shorttime.ui.map.opengl.polygon.render.RainRenderHandler rainRenderHandler, java.util.Map map) {
        this.n = rainRenderHandler;
        this.t = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.polygon.render.RainRenderHandler.b(this.n, this.t);
    }
}
