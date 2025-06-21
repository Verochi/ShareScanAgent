package kotlinx.coroutines.android;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/android/AndroidDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "()V", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/android/HandlerContext;", "allFactories", "", "hintOnError", "", "kotlinx-coroutines-android"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class AndroidDispatcherFactory implements kotlinx.coroutines.internal.MainDispatcherFactory {
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public /* bridge */ /* synthetic */ kotlinx.coroutines.MainCoroutineDispatcher createDispatcher(java.util.List list) {
        return createDispatcher((java.util.List<? extends kotlinx.coroutines.internal.MainDispatcherFactory>) list);
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.android.HandlerContext createDispatcher(@org.jetbrains.annotations.NotNull java.util.List<? extends kotlinx.coroutines.internal.MainDispatcherFactory> allFactories) {
        return new kotlinx.coroutines.android.HandlerContext(kotlinx.coroutines.android.HandlerDispatcherKt.asHandler(android.os.Looper.getMainLooper(), true), null, 2, null);
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public int getLoadPriority() {
        return kotlinx.coroutines.internal.LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    @org.jetbrains.annotations.Nullable
    public java.lang.String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
}
