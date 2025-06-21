package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class vu implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.dailydetails.DailyDetailFragment n;

    public /* synthetic */ vu(com.moji.mjweather.dailydetails.DailyDetailFragment dailyDetailFragment) {
        this.n = dailyDetailFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.dailydetails.DailyDetailFragment.d(this.n, (java.util.List) obj);
    }
}
