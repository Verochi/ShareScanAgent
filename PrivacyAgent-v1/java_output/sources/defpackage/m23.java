package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class m23 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.calender.ui.TimeCalenderFragment n;

    public /* synthetic */ m23(com.moji.newliveview.calender.ui.TimeCalenderFragment timeCalenderFragment) {
        this.n = timeCalenderFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.calender.ui.TimeCalenderFragment.a(this.n, (com.moji.http.snsforum.entity.CalenderTimeListResult) obj);
    }
}
