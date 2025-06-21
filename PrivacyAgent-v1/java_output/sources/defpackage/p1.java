package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class p1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.earlywarning.radar.map.opengl.picture.AbstractBitmapRenderHandler n;
    public final /* synthetic */ com.moji.earlywarning.radar.model.RasterTiles t;

    public /* synthetic */ p1(com.moji.earlywarning.radar.map.opengl.picture.AbstractBitmapRenderHandler abstractBitmapRenderHandler, com.moji.earlywarning.radar.model.RasterTiles rasterTiles) {
        this.n = abstractBitmapRenderHandler;
        this.t = rasterTiles;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.earlywarning.radar.map.opengl.picture.AbstractBitmapRenderHandler.b(this.n, this.t);
    }
}
