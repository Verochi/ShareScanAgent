package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class ji1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.order.MemberProductDialogActivity n;

    public /* synthetic */ ji1(com.moji.newmember.order.MemberProductDialogActivity memberProductDialogActivity) {
        this.n = memberProductDialogActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.order.MemberProductDialogActivity.k(this.n, (com.moji.http.member.entity.PricesResult) obj);
    }
}
