package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class v8 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.map.opengl.picture.render.allergy.AllergyRenderHandler n;
    public final /* synthetic */ int t;
    public final /* synthetic */ float u;

    public /* synthetic */ v8(com.moji.shorttime.ui.map.opengl.picture.render.allergy.AllergyRenderHandler allergyRenderHandler, int i, float f) {
        this.n = allergyRenderHandler;
        this.t = i;
        this.u = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.map.opengl.picture.render.allergy.AllergyRenderHandler.b(this.n, this.t, this.u);
    }
}
