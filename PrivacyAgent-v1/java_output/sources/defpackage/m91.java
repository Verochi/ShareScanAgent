package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class m91 implements android.view.View.OnTouchListener {
    public final /* synthetic */ com.moji.mjweather.main.MainTabCLickInterceptor n;
    public final /* synthetic */ com.moji.mjweather.TAB_TYPE t;

    public /* synthetic */ m91(com.moji.mjweather.main.MainTabCLickInterceptor mainTabCLickInterceptor, com.moji.mjweather.TAB_TYPE tab_type) {
        this.n = mainTabCLickInterceptor;
        this.t = tab_type;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        return com.moji.mjweather.MainFragment.d(this.n, this.t, view, motionEvent);
    }
}
