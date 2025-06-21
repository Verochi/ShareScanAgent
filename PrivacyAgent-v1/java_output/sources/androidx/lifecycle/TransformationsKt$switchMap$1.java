package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00018\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00018\u0001\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000H\n"}, d2 = {"X", "Y", "kotlin.jvm.PlatformType", "it", "Landroidx/lifecycle/LiveData;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TransformationsKt$switchMap$1<I, O> implements androidx.arch.core.util.Function {
    final /* synthetic */ kotlin.jvm.functions.Function1<X, androidx.lifecycle.LiveData<Y>> $transform;

    /* JADX WARN: Multi-variable type inference failed */
    public TransformationsKt$switchMap$1(kotlin.jvm.functions.Function1<? super X, ? extends androidx.lifecycle.LiveData<Y>> function1) {
        this.$transform = function1;
    }

    @Override // androidx.arch.core.util.Function
    public final androidx.lifecycle.LiveData<Y> apply(X x) {
        return (androidx.lifecycle.LiveData) this.$transform.invoke(x);
    }

    @Override // androidx.arch.core.util.Function
    public /* bridge */ /* synthetic */ java.lang.Object apply(java.lang.Object obj) {
        return apply((androidx.lifecycle.TransformationsKt$switchMap$1<I, O>) obj);
    }
}
