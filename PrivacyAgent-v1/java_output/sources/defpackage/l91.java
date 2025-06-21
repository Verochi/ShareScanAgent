package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class l91 implements android.view.View.OnTouchListener {
    public final /* synthetic */ com.moji.mjweather.MainFragment n;
    public final /* synthetic */ com.moji.mjweather.main.MainTabCLickInterceptor t;
    public final /* synthetic */ com.moji.mjweather.TAB_TYPE u;

    public /* synthetic */ l91(com.moji.mjweather.MainFragment mainFragment, com.moji.mjweather.main.MainTabCLickInterceptor mainTabCLickInterceptor, com.moji.mjweather.TAB_TYPE tab_type) {
        this.n = mainFragment;
        this.t = mainTabCLickInterceptor;
        this.u = tab_type;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        return com.moji.mjweather.MainFragment.a(this.n, this.t, this.u, view, motionEvent);
    }
}
