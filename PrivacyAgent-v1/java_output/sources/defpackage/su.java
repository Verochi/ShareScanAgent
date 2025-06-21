package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class su implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.dailydetails.DailyDetailFragment n;

    public /* synthetic */ su(com.moji.mjweather.dailydetails.DailyDetailFragment dailyDetailFragment) {
        this.n = dailyDetailFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.dailydetails.DailyDetailFragment.c(this.n, (com.moji.mjweather.dailydetails.viewmodel.RecyclerViewStatus) obj);
    }
}
