package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B/\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0012\u0010\f\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/ViewModelLazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Lazy;", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "factoryProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "cached", "Landroidx/lifecycle/ViewModel;", "value", "getValue", "()Landroidx/lifecycle/ViewModel;", "isInitialized", "", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ViewModelLazy<VM extends androidx.lifecycle.ViewModel> implements kotlin.Lazy<VM> {

    @org.jetbrains.annotations.Nullable
    private VM cached;

    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function0<androidx.lifecycle.ViewModelProvider.Factory> factoryProducer;

    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function0<androidx.lifecycle.ViewModelStore> storeProducer;

    @org.jetbrains.annotations.NotNull
    private final kotlin.reflect.KClass<VM> viewModelClass;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(@org.jetbrains.annotations.NotNull kotlin.reflect.KClass<VM> viewModelClass, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends androidx.lifecycle.ViewModelStore> storeProducer, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends androidx.lifecycle.ViewModelProvider.Factory> factoryProducer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storeProducer, "storeProducer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(factoryProducer, "factoryProducer");
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
    }

    @Override // kotlin.Lazy
    @org.jetbrains.annotations.NotNull
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) new androidx.lifecycle.ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke()).get(kotlin.jvm.JvmClassMappingKt.getJavaClass((kotlin.reflect.KClass) this.viewModelClass));
        this.cached = vm2;
        return vm2;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.cached != null;
    }
}
