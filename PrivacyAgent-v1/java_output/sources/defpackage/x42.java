package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class x42 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.render.rain48h.PrecipitationBitmapRenderHandler n;
    public final /* synthetic */ java.util.List t;
    public final /* synthetic */ java.util.Map u;

    public /* synthetic */ x42(com.moji.shorttime.ui.map.opengl.picture.render.rain48h.PrecipitationBitmapRenderHandler precipitationBitmapRenderHandler, java.util.List list, java.util.Map map) {
        this.n = precipitationBitmapRenderHandler;
        this.t = list;
        this.u = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.render.rain48h.PrecipitationBitmapRenderHandler.i(this.n, this.t, this.u);
    }
}
