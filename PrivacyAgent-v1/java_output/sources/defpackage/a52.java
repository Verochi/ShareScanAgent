package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class a52 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.earlywarning.radar.map.opengl.picture.render.PrecipitationBitmapRenderHandler n;
    public final /* synthetic */ java.util.List t;
    public final /* synthetic */ java.util.Map u;

    public /* synthetic */ a52(com.moji.earlywarning.radar.map.opengl.picture.render.PrecipitationBitmapRenderHandler precipitationBitmapRenderHandler, java.util.List list, java.util.Map map) {
        this.n = precipitationBitmapRenderHandler;
        this.t = list;
        this.u = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.earlywarning.radar.map.opengl.picture.render.PrecipitationBitmapRenderHandler.i(this.n, this.t, this.u);
    }
}
