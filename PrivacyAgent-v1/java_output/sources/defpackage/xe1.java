package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class xe1 implements com.moji.dialog.control.MJDialogMemberInMainWeatherControl.OnImgClickCallBack {
    public final /* synthetic */ com.moji.newmember.dialog.MemberDialogInTabMemberHelper a;
    public final /* synthetic */ com.moji.http.member.entity.MemberTutorialResult.Data.Novice b;

    public /* synthetic */ xe1(com.moji.newmember.dialog.MemberDialogInTabMemberHelper memberDialogInTabMemberHelper, com.moji.http.member.entity.MemberTutorialResult.Data.Novice novice) {
        this.a = memberDialogInTabMemberHelper;
        this.b = novice;
    }

    public final void onImageClick() {
        com.moji.newmember.dialog.MemberDialogInTabMemberHelper.a(this.a, this.b);
    }
}
