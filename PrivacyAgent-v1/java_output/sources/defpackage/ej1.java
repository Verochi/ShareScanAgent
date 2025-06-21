package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class ej1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.personal.MemberRemindActivityV2 n;

    public /* synthetic */ ej1(com.moji.newmember.personal.MemberRemindActivityV2 memberRemindActivityV2) {
        this.n = memberRemindActivityV2;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.personal.MemberRemindActivityV2.k(this.n, (java.lang.Boolean) obj);
    }
}
