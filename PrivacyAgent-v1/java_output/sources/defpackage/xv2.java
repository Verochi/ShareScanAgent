package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class xv2 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.mjweather.tabmember.TabMemberFragment a;
    public final /* synthetic */ com.moji.http.member.entity.MemberTabResultNew.UserInfo b;

    public /* synthetic */ xv2(com.moji.mjweather.tabmember.TabMemberFragment tabMemberFragment, com.moji.http.member.entity.MemberTabResultNew.UserInfo userInfo) {
        this.a = tabMemberFragment;
        this.b = userInfo;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.mjweather.tabmember.TabMemberFragment.l(this.a, this.b, mJDialog, eTypeAction);
    }
}
