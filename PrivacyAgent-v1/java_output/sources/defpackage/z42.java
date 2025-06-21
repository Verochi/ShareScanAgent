package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class z42 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.render.rain48h.PrecipitationBitmapRenderHandler n;
    public final /* synthetic */ java.util.Map t;

    public /* synthetic */ z42(com.moji.shorttime.ui.map.opengl.picture.render.rain48h.PrecipitationBitmapRenderHandler precipitationBitmapRenderHandler, java.util.Map map) {
        this.n = precipitationBitmapRenderHandler;
        this.t = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.render.rain48h.PrecipitationBitmapRenderHandler.h(this.n, this.t);
    }
}
