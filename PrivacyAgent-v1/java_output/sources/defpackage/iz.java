package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class iz implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.render.DefaultBitmapRenderHandler n;
    public final /* synthetic */ com.moji.shorttime.ui.RadarType t;

    public /* synthetic */ iz(com.moji.shorttime.ui.map.opengl.picture.render.DefaultBitmapRenderHandler defaultBitmapRenderHandler, com.moji.shorttime.ui.RadarType radarType) {
        this.n = defaultBitmapRenderHandler;
        this.t = radarType;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.render.DefaultBitmapRenderHandler.g(this.n, this.t);
    }
}
