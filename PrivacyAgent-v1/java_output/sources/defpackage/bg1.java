package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class bg1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.personal.MemberLocationRemindActivity n;

    public /* synthetic */ bg1(com.moji.newmember.personal.MemberLocationRemindActivity memberLocationRemindActivity) {
        this.n = memberLocationRemindActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.personal.MemberLocationRemindActivity.e(this.n, (com.moji.http.msc.entity.SubMemberListRes) obj);
    }
}
