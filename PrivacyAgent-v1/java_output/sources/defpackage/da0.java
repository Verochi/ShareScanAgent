package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class da0 implements okhttp3.EventListener.Factory {
    public final /* synthetic */ okhttp3.EventListener a;

    public /* synthetic */ da0(okhttp3.EventListener eventListener) {
        this.a = eventListener;
    }

    @Override // okhttp3.EventListener.Factory
    public final okhttp3.EventListener create(okhttp3.Call call) {
        okhttp3.EventListener lambda$factory$0;
        lambda$factory$0 = okhttp3.EventListener.lambda$factory$0(this.a, call);
        return lambda$factory$0;
    }
}
