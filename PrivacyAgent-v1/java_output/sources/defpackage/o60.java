package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class o60 implements com.moji.swiperefreshlayout.SwipeRefreshLayout.OnRefreshListener {
    public final /* synthetic */ com.moji.mjweather.feed.dress.viewmodel.DressPresenter a;
    public final /* synthetic */ com.moji.mjweather.feed.dress.DressVideoActivity b;

    public /* synthetic */ o60(com.moji.mjweather.feed.dress.viewmodel.DressPresenter dressPresenter, com.moji.mjweather.feed.dress.DressVideoActivity dressVideoActivity) {
        this.a = dressPresenter;
        this.b = dressVideoActivity;
    }

    public final void onRefresh() {
        com.moji.mjweather.feed.dress.DressVideoActivity.b(this.a, this.b);
    }
}
