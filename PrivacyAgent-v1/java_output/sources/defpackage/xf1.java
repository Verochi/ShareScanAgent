package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class xf1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.member.MemberExCodeActivity n;

    public /* synthetic */ xf1(com.moji.member.MemberExCodeActivity memberExCodeActivity) {
        this.n = memberExCodeActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.member.MemberExCodeActivity.d(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
