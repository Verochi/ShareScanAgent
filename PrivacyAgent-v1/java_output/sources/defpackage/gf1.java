package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class gf1 implements com.moji.dialog.control.MJDialogMemberInMainWeatherControl.OnCloseCallback {
    public final /* synthetic */ com.moji.newmember.dialog.MemberDialogInWeatherHelper a;
    public final /* synthetic */ com.moji.http.member.entity.MemberTutorialResult.Data.Novice b;

    public /* synthetic */ gf1(com.moji.newmember.dialog.MemberDialogInWeatherHelper memberDialogInWeatherHelper, com.moji.http.member.entity.MemberTutorialResult.Data.Novice novice) {
        this.a = memberDialogInWeatherHelper;
        this.b = novice;
    }

    public final void onClose() {
        com.moji.newmember.dialog.MemberDialogInWeatherHelper.e(this.a, this.b);
    }
}
