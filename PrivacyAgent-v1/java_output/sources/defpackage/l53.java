package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class l53 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.view.TyphoonForecastSourcesViewH n;
    public final /* synthetic */ com.moji.shorttime.ui.view.TyphoonForecastSourcesViewH.OnSizeCallBack t;

    public /* synthetic */ l53(com.moji.shorttime.ui.view.TyphoonForecastSourcesViewH typhoonForecastSourcesViewH, com.moji.shorttime.ui.view.TyphoonForecastSourcesViewH.OnSizeCallBack onSizeCallBack) {
        this.n = typhoonForecastSourcesViewH;
        this.t = onSizeCallBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.view.TyphoonForecastSourcesViewH.a(this.n, this.t);
    }
}
