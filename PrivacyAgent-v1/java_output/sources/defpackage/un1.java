package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class un1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.moredays.MoreDaysFragment n;

    public /* synthetic */ un1(com.moji.mjweather.moredays.MoreDaysFragment moreDaysFragment) {
        this.n = moreDaysFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.moredays.MoreDaysFragment.e(this.n, (java.util.List) obj);
    }
}
