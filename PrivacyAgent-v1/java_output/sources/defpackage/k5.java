package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class k5 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjpersonalmodule.data.AdPersonalGridItem n;
    public final /* synthetic */ android.view.View t;

    public /* synthetic */ k5(com.moji.mjpersonalmodule.data.AdPersonalGridItem adPersonalGridItem, android.view.View view) {
        this.n = adPersonalGridItem;
        this.t = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjpersonalmodule.data.AdPersonalGridItem.a(this.n, this.t);
    }
}
