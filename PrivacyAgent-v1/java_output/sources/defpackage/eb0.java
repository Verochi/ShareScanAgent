package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class eb0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.setting.activity.FeedBackActivity n;

    public /* synthetic */ eb0(com.moji.mjweather.setting.activity.FeedBackActivity feedBackActivity) {
        this.n = feedBackActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.setting.activity.FeedBackActivity.b(this.n, (com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean) obj);
    }
}
