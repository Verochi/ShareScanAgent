package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class o1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.AbstractBitmapRenderHandler n;
    public final /* synthetic */ com.moji.shorttime.data.model.RasterTiles t;

    public /* synthetic */ o1(com.moji.shorttime.ui.map.opengl.picture.AbstractBitmapRenderHandler abstractBitmapRenderHandler, com.moji.shorttime.data.model.RasterTiles rasterTiles) {
        this.n = abstractBitmapRenderHandler;
        this.t = rasterTiles;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.AbstractBitmapRenderHandler.a(this.n, this.t);
    }
}
