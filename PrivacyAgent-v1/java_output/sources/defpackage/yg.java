package defpackage;

/* loaded from: classes20.dex */
public final /* synthetic */ class yg implements android.view.View.OnTouchListener {
    public final /* synthetic */ com.moji.scrollview.ScrollViewMonitor n;

    public /* synthetic */ yg(com.moji.scrollview.ScrollViewMonitor scrollViewMonitor) {
        this.n = scrollViewMonitor;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        boolean l;
        l = moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity.l(this.n, view, motionEvent);
        return l;
    }
}
