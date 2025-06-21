package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class cf1 implements com.moji.dialog.control.MJDialogMemberInWeatherOnlyPicControl.OnPicClickCallBack {
    public final /* synthetic */ com.moji.newmember.dialog.MemberDialogInTabMemberHelper a;
    public final /* synthetic */ com.moji.http.member.entity.MemberTutorialResult.Data.Novice b;

    public /* synthetic */ cf1(com.moji.newmember.dialog.MemberDialogInTabMemberHelper memberDialogInTabMemberHelper, com.moji.http.member.entity.MemberTutorialResult.Data.Novice novice) {
        this.a = memberDialogInTabMemberHelper;
        this.b = novice;
    }

    public final void onPicClick() {
        com.moji.newmember.dialog.MemberDialogInTabMemberHelper.d(this.a, this.b);
    }
}
