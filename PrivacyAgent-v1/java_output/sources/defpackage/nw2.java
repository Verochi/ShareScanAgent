package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class nw2 implements com.moji.dialog.control.MJDialogMemberDiscountCutDownControl.JumpMemberPayCallback {
    public final /* synthetic */ com.moji.mjweather.tabmember.TabMemberFragment a;
    public final /* synthetic */ com.moji.http.member.entity.MemberDiscountDialogReq b;

    public /* synthetic */ nw2(com.moji.mjweather.tabmember.TabMemberFragment tabMemberFragment, com.moji.http.member.entity.MemberDiscountDialogReq memberDiscountDialogReq) {
        this.a = tabMemberFragment;
        this.b = memberDiscountDialogReq;
    }

    public final void jumpMemberPay() {
        com.moji.mjweather.tabmember.TabMemberFragment.loadMemberDiscountDialog.1.c(this.a, this.b);
    }
}
