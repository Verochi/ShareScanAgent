package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class jh1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.pay.MemberPayActivity n;

    public /* synthetic */ jh1(com.moji.newmember.pay.MemberPayActivity memberPayActivity) {
        this.n = memberPayActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.pay.MemberPayActivity.j(this.n, (com.moji.http.member.entity.MemberAlertDialogResult) obj);
    }
}
