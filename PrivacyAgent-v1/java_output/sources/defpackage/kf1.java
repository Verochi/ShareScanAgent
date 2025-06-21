package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class kf1 implements com.moji.dialog.control.MJDialogMemberInWeatherOnlyPicControl.OnPicClickCallBack {
    public final /* synthetic */ com.moji.newmember.dialog.MemberDialogInWeatherHelper a;
    public final /* synthetic */ com.moji.http.member.entity.MemberTutorialResult.Data.Novice b;

    public /* synthetic */ kf1(com.moji.newmember.dialog.MemberDialogInWeatherHelper memberDialogInWeatherHelper, com.moji.http.member.entity.MemberTutorialResult.Data.Novice novice) {
        this.a = memberDialogInWeatherHelper;
        this.b = novice;
    }

    public final void onPicClick() {
        com.moji.newmember.dialog.MemberDialogInWeatherHelper.b(this.a, this.b);
    }
}
