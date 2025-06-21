package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class q implements java.lang.Runnable {
    public final /* synthetic */ java.util.ArrayList n;
    public final /* synthetic */ com.moji.titlebar.MJTitleBar t;
    public final /* synthetic */ com.moji.share.MJThirdShareManager u;

    public /* synthetic */ q(java.util.ArrayList arrayList, com.moji.titlebar.MJTitleBar mJTitleBar, com.moji.share.MJThirdShareManager mJThirdShareManager) {
        this.n = arrayList;
        this.t = mJTitleBar;
        this.u = mJThirdShareManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.aqi.viewmodel.AQIViewModel.b(this.n, this.t, this.u);
    }
}
