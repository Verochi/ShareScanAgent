package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class u8 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.render.allergy.AllergyRenderHandler n;
    public final /* synthetic */ com.moji.shorttime.data.model.RasterTiles t;

    public /* synthetic */ u8(com.moji.shorttime.ui.map.opengl.picture.render.allergy.AllergyRenderHandler allergyRenderHandler, com.moji.shorttime.data.model.RasterTiles rasterTiles) {
        this.n = allergyRenderHandler;
        this.t = rasterTiles;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.render.allergy.AllergyRenderHandler.a(this.n, this.t);
    }
}
