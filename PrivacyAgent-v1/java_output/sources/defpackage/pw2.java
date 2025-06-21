package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class pw2 implements com.moji.dialog.control.MJDialogMemberDiscountNoCutDownControl.JumpMemberPayNoCutdownCallBack {
    public final /* synthetic */ com.moji.mjweather.tabmember.TabMemberFragment a;
    public final /* synthetic */ com.moji.http.member.entity.MemberDiscountDialogReq b;

    public /* synthetic */ pw2(com.moji.mjweather.tabmember.TabMemberFragment tabMemberFragment, com.moji.http.member.entity.MemberDiscountDialogReq memberDiscountDialogReq) {
        this.a = tabMemberFragment;
        this.b = memberDiscountDialogReq;
    }

    public final void jumpMember() {
        com.moji.mjweather.tabmember.TabMemberFragment.loadMemberDiscountDialog.1.d(this.a, this.b);
    }
}
