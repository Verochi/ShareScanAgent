package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class bs implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjpersonalmodule.data.ConcernPersonalGridItem n;
    public final /* synthetic */ android.view.View t;

    public /* synthetic */ bs(com.moji.mjpersonalmodule.data.ConcernPersonalGridItem concernPersonalGridItem, android.view.View view) {
        this.n = concernPersonalGridItem;
        this.t = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjpersonalmodule.data.ConcernPersonalGridItem.a(this.n, this.t);
    }
}
