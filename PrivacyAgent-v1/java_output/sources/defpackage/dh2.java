package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class dh2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.ShortTimeFragmentV2 n;
    public final /* synthetic */ android.content.res.Configuration t;

    public /* synthetic */ dh2(com.moji.shorttime.ui.ShortTimeFragmentV2 shortTimeFragmentV2, android.content.res.Configuration configuration) {
        this.n = shortTimeFragmentV2;
        this.t = configuration;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.ShortTimeFragmentV2.d(this.n, this.t);
    }
}
