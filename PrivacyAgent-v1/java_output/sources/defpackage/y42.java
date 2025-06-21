package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class y42 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.earlywarning.radar.map.opengl.picture.render.PrecipitationBitmapRenderHandler n;
    public final /* synthetic */ java.util.Date t;
    public final /* synthetic */ float u;

    public /* synthetic */ y42(com.moji.earlywarning.radar.map.opengl.picture.render.PrecipitationBitmapRenderHandler precipitationBitmapRenderHandler, java.util.Date date, float f) {
        this.n = precipitationBitmapRenderHandler;
        this.t = date;
        this.u = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.earlywarning.radar.map.opengl.picture.render.PrecipitationBitmapRenderHandler.h(this.n, this.t, this.u);
    }
}
