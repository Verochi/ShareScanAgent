package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class lf1 implements com.moji.dialog.control.MJDialogMemberInWeatherOnlyPicControl.OnCloseCallback {
    public final /* synthetic */ com.moji.newmember.dialog.MemberDialogInWeatherHelper a;
    public final /* synthetic */ com.moji.http.member.entity.MemberTutorialResult.Data.Novice b;

    public /* synthetic */ lf1(com.moji.newmember.dialog.MemberDialogInWeatherHelper memberDialogInWeatherHelper, com.moji.http.member.entity.MemberTutorialResult.Data.Novice novice) {
        this.a = memberDialogInWeatherHelper;
        this.b = novice;
    }

    public final void onClose() {
        com.moji.newmember.dialog.MemberDialogInWeatherHelper.h(this.a, this.b);
    }
}
