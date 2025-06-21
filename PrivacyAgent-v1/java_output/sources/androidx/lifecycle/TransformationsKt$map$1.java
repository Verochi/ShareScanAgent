package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000H\n"}, d2 = {"X", "Y", "kotlin.jvm.PlatformType", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TransformationsKt$map$1<I, O> implements androidx.arch.core.util.Function {
    final /* synthetic */ kotlin.jvm.functions.Function1<X, Y> $transform;

    /* JADX WARN: Multi-variable type inference failed */
    public TransformationsKt$map$1(kotlin.jvm.functions.Function1<? super X, ? extends Y> function1) {
        this.$transform = function1;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [Y, java.lang.Object] */
    @Override // androidx.arch.core.util.Function
    public final Y apply(X x) {
        return this.$transform.invoke(x);
    }
}
