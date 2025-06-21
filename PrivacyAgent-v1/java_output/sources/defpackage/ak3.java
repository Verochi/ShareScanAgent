package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ak3 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.render.wind.WindRenderHandler n;
    public final /* synthetic */ com.moji.shorttime.data.model.RasterTiles t;

    public /* synthetic */ ak3(com.moji.shorttime.ui.map.opengl.picture.render.wind.WindRenderHandler windRenderHandler, com.moji.shorttime.data.model.RasterTiles rasterTiles) {
        this.n = windRenderHandler;
        this.t = rasterTiles;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.render.wind.WindRenderHandler.b(this.n, this.t);
    }
}
