package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class hd2 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.sakura.SakuraSearchActivity a;
    public final /* synthetic */ kotlin.jvm.internal.Ref.IntRef b;

    public /* synthetic */ hd2(com.moji.sakura.SakuraSearchActivity sakuraSearchActivity, kotlin.jvm.internal.Ref.IntRef intRef) {
        this.a = sakuraSearchActivity;
        this.b = intRef;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.sakura.SakuraSearchActivity.h(this.a, this.b, mJDialog, eTypeAction);
    }
}
