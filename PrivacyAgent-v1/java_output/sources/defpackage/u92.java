package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class u92 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.render.raintype.RainTypeBitmapRenderHandler n;
    public final /* synthetic */ com.moji.shorttime.data.model.RasterTiles t;

    public /* synthetic */ u92(com.moji.shorttime.ui.map.opengl.picture.render.raintype.RainTypeBitmapRenderHandler rainTypeBitmapRenderHandler, com.moji.shorttime.data.model.RasterTiles rasterTiles) {
        this.n = rainTypeBitmapRenderHandler;
        this.t = rasterTiles;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.render.raintype.RainTypeBitmapRenderHandler.a(this.n, this.t);
    }
}
