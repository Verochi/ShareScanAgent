package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class sc implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.personal.AstronomyAlertRemindActivity n;

    public /* synthetic */ sc(com.moji.newmember.personal.AstronomyAlertRemindActivity astronomyAlertRemindActivity) {
        this.n = astronomyAlertRemindActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.personal.AstronomyAlertRemindActivity.b(this.n, (com.moji.http.msc.entity.SubMemberScenicAreaListRes) obj);
    }
}
