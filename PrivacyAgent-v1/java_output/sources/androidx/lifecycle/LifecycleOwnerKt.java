package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleScope", "(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class LifecycleOwnerKt {
    @org.jetbrains.annotations.NotNull
    public static final androidx.lifecycle.LifecycleCoroutineScope getLifecycleScope(@org.jetbrains.annotations.NotNull androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        androidx.lifecycle.Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        return androidx.lifecycle.LifecycleKt.getCoroutineScope(lifecycle);
    }
}
