package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class t61 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.coolboot.CoolBootManager n;

    public /* synthetic */ t61(com.moji.mjweather.coolboot.CoolBootManager coolBootManager) {
        this.n = coolBootManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.notifyStarted();
    }
}
