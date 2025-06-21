package defpackage;

/* loaded from: classes13.dex */
public final /* synthetic */ class d10 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.register.DeviceIDManager.RegisterListener n;
    public final /* synthetic */ boolean t;

    public /* synthetic */ d10(com.moji.register.DeviceIDManager.RegisterListener registerListener, boolean z) {
        this.n = registerListener;
        this.t = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.register.DeviceIDManager.c(this.n, this.t);
    }
}
