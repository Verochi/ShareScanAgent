package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class cg1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.personal.MemberLocationRemindActivity n;

    public /* synthetic */ cg1(com.moji.newmember.personal.MemberLocationRemindActivity memberLocationRemindActivity) {
        this.n = memberLocationRemindActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.personal.MemberLocationRemindActivity.g(this.n, (com.moji.requestcore.entity.MJBaseRespRc) obj);
    }
}
