package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class w42 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.earlywarning.radar.map.opengl.picture.render.PrecipitationBitmapRenderHandler n;
    public final /* synthetic */ java.util.Map t;

    public /* synthetic */ w42(com.moji.earlywarning.radar.map.opengl.picture.render.PrecipitationBitmapRenderHandler precipitationBitmapRenderHandler, java.util.Map map) {
        this.n = precipitationBitmapRenderHandler;
        this.t = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.earlywarning.radar.map.opengl.picture.render.PrecipitationBitmapRenderHandler.g(this.n, this.t);
    }
}
