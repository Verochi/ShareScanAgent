package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ca1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.MainRadarView A;
    public final /* synthetic */ com.moji.mjweather.weather.view.MainShortViewFor10 B;
    public final /* synthetic */ com.moji.mjweather.weather.view.MainShortViewAnimHelper n;
    public final /* synthetic */ boolean t;
    public final /* synthetic */ android.view.View u;
    public final /* synthetic */ int v;
    public final /* synthetic */ int w;
    public final /* synthetic */ android.view.View x;
    public final /* synthetic */ int y;
    public final /* synthetic */ double z;

    public /* synthetic */ ca1(com.moji.mjweather.weather.view.MainShortViewAnimHelper mainShortViewAnimHelper, boolean z, android.view.View view, int i, int i2, android.view.View view2, int i3, double d, com.moji.mjweather.weather.view.MainRadarView mainRadarView, com.moji.mjweather.weather.view.MainShortViewFor10 mainShortViewFor10) {
        this.n = mainShortViewAnimHelper;
        this.t = z;
        this.u = view;
        this.v = i;
        this.w = i2;
        this.x = view2;
        this.y = i3;
        this.z = d;
        this.A = mainRadarView;
        this.B = mainShortViewFor10;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.view.MainShortViewAnimHelper.a(this.n, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, valueAnimator);
    }
}
