package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"JOB_KEY", "", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/ViewModel;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;", "lifecycle-viewmodel-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ViewModelKt {

    @org.jetbrains.annotations.NotNull
    private static final java.lang.String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineScope getViewModelScope(@org.jetbrains.annotations.NotNull androidx.lifecycle.ViewModel viewModel) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewModel, "<this>");
        kotlinx.coroutines.CoroutineScope coroutineScope = (kotlinx.coroutines.CoroutineScope) viewModel.getTag(JOB_KEY);
        if (coroutineScope != null) {
            return coroutineScope;
        }
        java.lang.Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new androidx.lifecycle.CloseableCoroutineScope(kotlinx.coroutines.SupervisorKt.SupervisorJob$default((kotlinx.coroutines.Job) null, 1, (java.lang.Object) null).plus(kotlinx.coroutines.Dispatchers.getMain().getImmediate())));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (kotlinx.coroutines.CoroutineScope) tagIfAbsent;
    }
}
