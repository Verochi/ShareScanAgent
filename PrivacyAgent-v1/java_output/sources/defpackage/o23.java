package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class o23 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.calender.ui.TimeCalenderRootFragment n;

    public /* synthetic */ o23(com.moji.newliveview.calender.ui.TimeCalenderRootFragment timeCalenderRootFragment) {
        this.n = timeCalenderRootFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.calender.ui.TimeCalenderRootFragment.a(this.n, (com.moji.http.snsforum.entity.CalenderTimeListResult) obj);
    }
}
