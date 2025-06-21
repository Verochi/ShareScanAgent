package defpackage;

/* loaded from: classes29.dex */
public final /* synthetic */ class c10 implements cn.shuzilm.core.Listener {
    public final /* synthetic */ com.moji.preferences.ProcessPrefer a;

    public /* synthetic */ c10(com.moji.preferences.ProcessPrefer processPrefer) {
        this.a = processPrefer;
    }

    @Override // cn.shuzilm.core.Listener
    public final void handler(java.lang.String str) {
        com.moji.register.DeviceIDManager.a(this.a, str);
    }
}
