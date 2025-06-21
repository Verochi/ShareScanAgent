package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class uo0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.calender.ui.HotCalenderFragment n;

    public /* synthetic */ uo0(com.moji.newliveview.calender.ui.HotCalenderFragment hotCalenderFragment) {
        this.n = hotCalenderFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.calender.ui.HotCalenderFragment.a(this.n, (com.moji.http.snsforum.entity.CalenderHotListResult) obj);
    }
}
