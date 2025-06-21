package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class j23 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.dailydetail.TideDetailActivity n;
    public final /* synthetic */ android.widget.RelativeLayout t;
    public final /* synthetic */ com.moji.base.curve.Day15Hour24HorizontalScrollView u;
    public final /* synthetic */ android.widget.ImageView v;
    public final /* synthetic */ int w;

    public /* synthetic */ j23(com.moji.mjweather.dailydetail.TideDetailActivity tideDetailActivity, android.widget.RelativeLayout relativeLayout, com.moji.base.curve.Day15Hour24HorizontalScrollView day15Hour24HorizontalScrollView, android.widget.ImageView imageView, int i) {
        this.n = tideDetailActivity;
        this.t = relativeLayout;
        this.u = day15Hour24HorizontalScrollView;
        this.v = imageView;
        this.w = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.dailydetail.TideDetailActivity.c(this.n, this.t, this.u, this.v, this.w, view);
    }
}
