package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class dg1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.personal.MemberLocationRemindActivity n;

    public /* synthetic */ dg1(com.moji.newmember.personal.MemberLocationRemindActivity memberLocationRemindActivity) {
        this.n = memberLocationRemindActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.personal.MemberLocationRemindActivity.c(this.n, (com.moji.requestcore.entity.MJBaseRespRc) obj);
    }
}
