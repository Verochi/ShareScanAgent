package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class b70 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.appupdate.DynamicConfigManager n;
    public final /* synthetic */ java.lang.String[] t;

    public /* synthetic */ b70(com.moji.appupdate.DynamicConfigManager dynamicConfigManager, java.lang.String[] strArr) {
        this.n = dynamicConfigManager;
        this.t = strArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.appupdate.DynamicConfigManager.a(this.n, this.t);
    }
}
