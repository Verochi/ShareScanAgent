package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class qe1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.personal.MemberAppointedPlaceRemindActivity n;

    public /* synthetic */ qe1(com.moji.newmember.personal.MemberAppointedPlaceRemindActivity memberAppointedPlaceRemindActivity) {
        this.n = memberAppointedPlaceRemindActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.personal.MemberAppointedPlaceRemindActivity.f(this.n, (com.moji.http.msc.entity.SubMemberListRes) obj);
    }
}
