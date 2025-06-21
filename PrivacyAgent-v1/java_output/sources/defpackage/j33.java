package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class j33 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.base.databinding.PrivacyTipsDialogLayoutBinding n;
    public final /* synthetic */ com.moji.base.tourist.TouristModeManager.DialogActionClickListener t;
    public final /* synthetic */ com.moji.dialog.MJDialog u;

    public /* synthetic */ j33(com.moji.base.databinding.PrivacyTipsDialogLayoutBinding privacyTipsDialogLayoutBinding, com.moji.base.tourist.TouristModeManager.DialogActionClickListener dialogActionClickListener, com.moji.dialog.MJDialog mJDialog) {
        this.n = privacyTipsDialogLayoutBinding;
        this.t = dialogActionClickListener;
        this.u = mJDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.base.tourist.TouristModeManager.c(this.n, this.t, this.u, view);
    }
}
