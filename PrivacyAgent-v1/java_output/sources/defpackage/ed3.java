package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ed3 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ com.moji.mjweather.moredays.statistic.ViewFinder n;

    public /* synthetic */ ed3(com.moji.mjweather.moredays.statistic.ViewFinder viewFinder) {
        this.n = viewFinder;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        com.moji.mjweather.moredays.statistic.ViewFinder.a(this.n);
    }
}
