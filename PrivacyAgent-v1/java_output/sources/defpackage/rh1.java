package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class rh1 implements com.moji.dialog.control.MJDialogMemberPayUnKnowResultControl.RequestResultCallback {
    public final /* synthetic */ com.moji.newmember.pay.MemberPayActivity a;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef b;
    public final /* synthetic */ java.lang.String c;

    public /* synthetic */ rh1(com.moji.newmember.pay.MemberPayActivity memberPayActivity, kotlin.jvm.internal.Ref.ObjectRef objectRef, java.lang.String str) {
        this.a = memberPayActivity;
        this.b = objectRef;
        this.c = str;
    }

    public final void requestResult() {
        com.moji.newmember.pay.MemberPayActivity.e(this.a, this.b, this.c);
    }
}
