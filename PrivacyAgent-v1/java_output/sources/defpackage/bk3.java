package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class bk3 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.render.wind.WindRenderHandler n;
    public final /* synthetic */ int t;
    public final /* synthetic */ float u;

    public /* synthetic */ bk3(com.moji.shorttime.ui.map.opengl.picture.render.wind.WindRenderHandler windRenderHandler, int i, float f) {
        this.n = windRenderHandler;
        this.t = i;
        this.u = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.render.wind.WindRenderHandler.a(this.n, this.t, this.u);
    }
}
