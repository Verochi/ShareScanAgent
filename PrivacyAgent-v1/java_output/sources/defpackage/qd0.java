package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class qd0 implements android.content.DialogInterface.OnDismissListener {
    public final /* synthetic */ com.moji.mjfishing.FishingMainActivity n;

    public /* synthetic */ qd0(com.moji.mjfishing.FishingMainActivity fishingMainActivity) {
        this.n = fishingMainActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        com.moji.mjfishing.FishingMainActivity.e(this.n, dialogInterface);
    }
}
