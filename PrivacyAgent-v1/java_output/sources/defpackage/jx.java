package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class jx implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mj40dayforecast.fragment.Days40CalenderFragment n;

    public /* synthetic */ jx(com.moji.mj40dayforecast.fragment.Days40CalenderFragment days40CalenderFragment) {
        this.n = days40CalenderFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mj40dayforecast.fragment.Days40CalenderFragment.c(this.n, (com.moji.mj40dayforecast.data.SelectedDay) obj);
    }
}
