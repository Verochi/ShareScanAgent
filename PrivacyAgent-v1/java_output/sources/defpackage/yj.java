package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class yj implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.calender.ui.CalenderMothDayActivity n;

    public /* synthetic */ yj(com.moji.newliveview.calender.ui.CalenderMothDayActivity calenderMothDayActivity) {
        this.n = calenderMothDayActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.calender.ui.CalenderMothDayActivity.b(this.n, (com.moji.http.snsforum.entity.CalenderTimeDayListResult) obj);
    }
}
