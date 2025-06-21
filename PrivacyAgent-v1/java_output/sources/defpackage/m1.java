package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class m1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.AbstractBitmapRenderHandler n;
    public final /* synthetic */ int t;
    public final /* synthetic */ float u;

    public /* synthetic */ m1(com.moji.shorttime.ui.map.opengl.picture.AbstractBitmapRenderHandler abstractBitmapRenderHandler, int i, float f) {
        this.n = abstractBitmapRenderHandler;
        this.t = i;
        this.u = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.AbstractBitmapRenderHandler.b(this.n, this.t, this.u);
    }
}
