package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class ye1 implements com.moji.dialog.control.MJDialogMemberInMainWeatherControl.OnCloseCallback {
    public final /* synthetic */ com.moji.newmember.dialog.MemberDialogInTabMemberHelper a;
    public final /* synthetic */ com.moji.http.member.entity.MemberTutorialResult.Data.Novice b;

    public /* synthetic */ ye1(com.moji.newmember.dialog.MemberDialogInTabMemberHelper memberDialogInTabMemberHelper, com.moji.http.member.entity.MemberTutorialResult.Data.Novice novice) {
        this.a = memberDialogInTabMemberHelper;
        this.b = novice;
    }

    public final void onClose() {
        com.moji.newmember.dialog.MemberDialogInTabMemberHelper.h(this.a, this.b);
    }
}
