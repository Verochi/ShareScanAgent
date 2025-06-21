package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class u71 implements com.moji.register.DeviceIDManager.RegisterListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ u71(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public final void onRegistered(boolean z) {
        com.moji.mjweather.MainActivity.F(this.a, this.b, z);
    }
}
