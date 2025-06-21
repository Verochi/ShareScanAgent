package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class la0 implements com.google.common.base.Supplier {
    public final /* synthetic */ java.util.concurrent.atomic.AtomicBoolean n;

    public /* synthetic */ la0(java.util.concurrent.atomic.AtomicBoolean atomicBoolean) {
        this.n = atomicBoolean;
    }

    @Override // com.google.common.base.Supplier
    public final java.lang.Object get() {
        return java.lang.Boolean.valueOf(this.n.get());
    }
}
