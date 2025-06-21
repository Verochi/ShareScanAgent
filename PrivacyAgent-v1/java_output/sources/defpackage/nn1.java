package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class nn1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.moredays.MoreDaysActivity n;

    public /* synthetic */ nn1(com.moji.mjweather.moredays.MoreDaysActivity moreDaysActivity) {
        this.n = moreDaysActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.moredays.MoreDaysActivity.c(this.n, (kotlin.Pair) obj);
    }
}
