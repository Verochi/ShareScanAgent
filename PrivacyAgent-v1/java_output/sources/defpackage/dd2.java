package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class dd2 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ kotlin.jvm.internal.Ref.IntRef a;
    public final /* synthetic */ com.moji.sakura.SakuraSearchActivity b;
    public final /* synthetic */ kotlin.jvm.internal.Ref.IntRef c;

    public /* synthetic */ dd2(kotlin.jvm.internal.Ref.IntRef intRef, com.moji.sakura.SakuraSearchActivity sakuraSearchActivity, kotlin.jvm.internal.Ref.IntRef intRef2) {
        this.a = intRef;
        this.b = sakuraSearchActivity;
        this.c = intRef2;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.sakura.SakuraSearchActivity.b(this.a, this.b, this.c, mJDialog, eTypeAction);
    }
}
