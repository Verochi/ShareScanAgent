package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class ee1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.personal.MemberAddLocationNotificationActivity n;

    public /* synthetic */ ee1(com.moji.newmember.personal.MemberAddLocationNotificationActivity memberAddLocationNotificationActivity) {
        this.n = memberAddLocationNotificationActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.personal.MemberAddLocationNotificationActivity.c(this.n, (com.moji.http.msc.entity.SubMemberListRes) obj);
    }
}
