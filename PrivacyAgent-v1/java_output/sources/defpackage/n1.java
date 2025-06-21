package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class n1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.earlywarning.radar.map.opengl.picture.AbstractBitmapRenderHandler n;
    public final /* synthetic */ int t;
    public final /* synthetic */ float u;

    public /* synthetic */ n1(com.moji.earlywarning.radar.map.opengl.picture.AbstractBitmapRenderHandler abstractBitmapRenderHandler, int i, float f) {
        this.n = abstractBitmapRenderHandler;
        this.t = i;
        this.u = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.earlywarning.radar.map.opengl.picture.AbstractBitmapRenderHandler.a(this.n, this.t, this.u);
    }
}
