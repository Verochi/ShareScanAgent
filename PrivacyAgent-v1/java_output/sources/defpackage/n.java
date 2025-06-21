package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class n implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.render.aqi.AQIRenderHandler n;
    public final /* synthetic */ com.moji.shorttime.data.model.RasterTiles t;

    public /* synthetic */ n(com.moji.shorttime.ui.map.opengl.picture.render.aqi.AQIRenderHandler aQIRenderHandler, com.moji.shorttime.data.model.RasterTiles rasterTiles) {
        this.n = aQIRenderHandler;
        this.t = rasterTiles;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.render.aqi.AQIRenderHandler.b(this.n, this.t);
    }
}
