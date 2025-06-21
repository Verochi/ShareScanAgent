package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class uu implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.dailydetails.DailyDetailFragment n;

    public /* synthetic */ uu(com.moji.mjweather.dailydetails.DailyDetailFragment dailyDetailFragment) {
        this.n = dailyDetailFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.dailydetails.DailyDetailFragment.e(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
