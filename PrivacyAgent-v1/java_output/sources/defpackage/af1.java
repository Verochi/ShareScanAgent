package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class af1 implements com.moji.dialog.control.MJDialogMemberInWeatherSpecialControl.OnImgClickCallBack {
    public final /* synthetic */ com.moji.newmember.dialog.MemberDialogInTabMemberHelper a;
    public final /* synthetic */ com.moji.http.member.entity.MemberTutorialResult.Data.Novice b;

    public /* synthetic */ af1(com.moji.newmember.dialog.MemberDialogInTabMemberHelper memberDialogInTabMemberHelper, com.moji.http.member.entity.MemberTutorialResult.Data.Novice novice) {
        this.a = memberDialogInTabMemberHelper;
        this.b = novice;
    }

    public final void onImageClick() {
        com.moji.newmember.dialog.MemberDialogInTabMemberHelper.b(this.a, this.b);
    }
}
