package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class on1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.moredays.MoreDaysActivity n;

    public /* synthetic */ on1(com.moji.mjweather.moredays.MoreDaysActivity moreDaysActivity) {
        this.n = moreDaysActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.moredays.MoreDaysActivity.d(this.n, (java.util.List) obj);
    }
}
