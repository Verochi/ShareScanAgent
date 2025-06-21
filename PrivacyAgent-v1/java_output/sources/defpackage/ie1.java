package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class ie1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.personal.MemberAppointedPlaceNotifDetailsActivity n;

    public /* synthetic */ ie1(com.moji.newmember.personal.MemberAppointedPlaceNotifDetailsActivity memberAppointedPlaceNotifDetailsActivity) {
        this.n = memberAppointedPlaceNotifDetailsActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.personal.MemberAppointedPlaceNotifDetailsActivity.c(this.n, (com.moji.requestcore.entity.MJBaseRespRc) obj);
    }
}
