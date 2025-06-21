package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class kh1 implements android.content.DialogInterface.OnDismissListener {
    public final /* synthetic */ com.moji.newmember.pay.MemberPayActivity n;

    public /* synthetic */ kh1(com.moji.newmember.pay.MemberPayActivity memberPayActivity) {
        this.n = memberPayActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        com.moji.newmember.pay.MemberPayActivity.f(this.n, dialogInterface);
    }
}
