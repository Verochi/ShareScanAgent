package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class e03 implements com.alimm.tanx.core.bridge.Callback {
    public final /* synthetic */ com.alimm.tanx.core.bridge.TanxJsBridge a;
    public final /* synthetic */ java.lang.String b;

    public /* synthetic */ e03(com.alimm.tanx.core.bridge.TanxJsBridge tanxJsBridge, java.lang.String str) {
        this.a = tanxJsBridge;
        this.b = str;
    }

    @Override // com.alimm.tanx.core.bridge.Callback
    public final void call(boolean z, java.util.AbstractMap abstractMap) {
        this.a.lambda$flush$2(this.b, z, abstractMap);
    }
}
