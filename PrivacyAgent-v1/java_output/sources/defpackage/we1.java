package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class we1 implements com.moji.dialog.control.MJDialogMemberInMainWeatherControl.OnBtnClickCallBack {
    public final /* synthetic */ kotlin.jvm.internal.Ref.BooleanRef a;
    public final /* synthetic */ com.moji.newmember.dialog.MemberDialogInTabMemberHelper b;
    public final /* synthetic */ com.moji.http.member.entity.MemberTutorialResult.Data.Novice c;

    public /* synthetic */ we1(kotlin.jvm.internal.Ref.BooleanRef booleanRef, com.moji.newmember.dialog.MemberDialogInTabMemberHelper memberDialogInTabMemberHelper, com.moji.http.member.entity.MemberTutorialResult.Data.Novice novice) {
        this.a = booleanRef;
        this.b = memberDialogInTabMemberHelper;
        this.c = novice;
    }

    public final void onBtnClick() {
        com.moji.newmember.dialog.MemberDialogInTabMemberHelper.g(this.a, this.b, this.c);
    }
}
