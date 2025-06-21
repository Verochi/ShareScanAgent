package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class r91 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.base.dialog.IDialog n;

    public /* synthetic */ r91(com.moji.base.dialog.IDialog iDialog) {
        this.n = iDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.base.dialog.MainPageDialogHelper.c(this.n);
    }
}
