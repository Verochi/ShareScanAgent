package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class if1 implements com.moji.dialog.control.MJDialogMemberInWeatherSpecialControl.OnImgClickCallBack {
    public final /* synthetic */ com.moji.newmember.dialog.MemberDialogInWeatherHelper a;
    public final /* synthetic */ com.moji.http.member.entity.MemberTutorialResult.Data.Novice b;

    public /* synthetic */ if1(com.moji.newmember.dialog.MemberDialogInWeatherHelper memberDialogInWeatherHelper, com.moji.http.member.entity.MemberTutorialResult.Data.Novice novice) {
        this.a = memberDialogInWeatherHelper;
        this.b = novice;
    }

    public final void onImageClick() {
        com.moji.newmember.dialog.MemberDialogInWeatherHelper.a(this.a, this.b);
    }
}
