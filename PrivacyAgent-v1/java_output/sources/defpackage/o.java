package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class o implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.render.aqi.AQIRenderHandler n;
    public final /* synthetic */ int t;
    public final /* synthetic */ float u;

    public /* synthetic */ o(com.moji.shorttime.ui.map.opengl.picture.render.aqi.AQIRenderHandler aQIRenderHandler, int i, float f) {
        this.n = aQIRenderHandler;
        this.t = i;
        this.u = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.render.aqi.AQIRenderHandler.a(this.n, this.t, this.u);
    }
}
