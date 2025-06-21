package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class tg1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.personal.MemberNotificationDetailsActivity n;

    public /* synthetic */ tg1(com.moji.newmember.personal.MemberNotificationDetailsActivity memberNotificationDetailsActivity) {
        this.n = memberNotificationDetailsActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.personal.MemberNotificationDetailsActivity.b(this.n, (com.moji.requestcore.entity.MJBaseRespRc) obj);
    }
}
