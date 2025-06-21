package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class yn3 implements android.content.DialogInterface.OnDismissListener {
    public final /* synthetic */ com.moji.zodiac.ZodiacSwitchControl n;

    public /* synthetic */ yn3(com.moji.zodiac.ZodiacSwitchControl zodiacSwitchControl) {
        this.n = zodiacSwitchControl;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        com.moji.zodiac.ZodiacSwitchControl.a(this.n, dialogInterface);
    }
}
