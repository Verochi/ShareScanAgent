package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class hf1 implements com.moji.dialog.control.MJDialogMemberInWeatherSpecialControl.OnBtnClickCallBack {
    public final /* synthetic */ kotlin.jvm.internal.Ref.BooleanRef a;
    public final /* synthetic */ com.moji.newmember.dialog.MemberDialogInWeatherHelper b;
    public final /* synthetic */ com.moji.http.member.entity.MemberTutorialResult.Data.Novice c;

    public /* synthetic */ hf1(kotlin.jvm.internal.Ref.BooleanRef booleanRef, com.moji.newmember.dialog.MemberDialogInWeatherHelper memberDialogInWeatherHelper, com.moji.http.member.entity.MemberTutorialResult.Data.Novice novice) {
        this.a = booleanRef;
        this.b = memberDialogInWeatherHelper;
        this.c = novice;
    }

    public final void onBtnClick() {
        com.moji.newmember.dialog.MemberDialogInWeatherHelper.i(this.a, this.b, this.c);
    }
}
