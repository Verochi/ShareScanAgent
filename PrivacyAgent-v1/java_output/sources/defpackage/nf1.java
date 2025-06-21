package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class nf1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.member_control.MemberDialogManager n;
    public final /* synthetic */ com.moji.shorttime.ui.member_control.MemberDialogManager.HideCallback t;

    public /* synthetic */ nf1(com.moji.shorttime.ui.member_control.MemberDialogManager memberDialogManager, com.moji.shorttime.ui.member_control.MemberDialogManager.HideCallback hideCallback) {
        this.n = memberDialogManager;
        this.t = hideCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.member_control.MemberDialogManager.c(this.n, this.t);
    }
}
