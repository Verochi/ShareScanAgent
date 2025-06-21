package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class v42 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.render.rain48h.PrecipitationBitmapRenderHandler n;
    public final /* synthetic */ java.util.Date t;
    public final /* synthetic */ float u;

    public /* synthetic */ v42(com.moji.shorttime.ui.map.opengl.picture.render.rain48h.PrecipitationBitmapRenderHandler precipitationBitmapRenderHandler, java.util.Date date, float f) {
        this.n = precipitationBitmapRenderHandler;
        this.t = date;
        this.u = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.render.rain48h.PrecipitationBitmapRenderHandler.g(this.n, this.t, this.u);
    }
}
