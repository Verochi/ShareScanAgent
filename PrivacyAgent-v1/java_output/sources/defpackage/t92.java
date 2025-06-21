package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class t92 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.render.raintype.RainTypeBitmapRenderHandler n;
    public final /* synthetic */ int t;
    public final /* synthetic */ float u;

    public /* synthetic */ t92(com.moji.shorttime.ui.map.opengl.picture.render.raintype.RainTypeBitmapRenderHandler rainTypeBitmapRenderHandler, int i, float f) {
        this.n = rainTypeBitmapRenderHandler;
        this.t = i;
        this.u = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.render.raintype.RainTypeBitmapRenderHandler.b(this.n, this.t, this.u);
    }
}
