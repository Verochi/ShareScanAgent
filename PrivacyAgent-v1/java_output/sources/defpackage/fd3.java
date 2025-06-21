package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class fd3 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ com.moji.mjweather.dailydetails.statistic.ViewFinder n;

    public /* synthetic */ fd3(com.moji.mjweather.dailydetails.statistic.ViewFinder viewFinder) {
        this.n = viewFinder;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        com.moji.mjweather.dailydetails.statistic.ViewFinder.a(this.n);
    }
}
