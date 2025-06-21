package androidx.lifecycle;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements androidx.lifecycle.LifecycleEventObserver {
    private final androidx.lifecycle.GeneratedAdapter[] mGeneratedAdapters;

    public CompositeGeneratedAdaptersObserver(androidx.lifecycle.GeneratedAdapter[] generatedAdapterArr) {
        this.mGeneratedAdapters = generatedAdapterArr;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
        androidx.lifecycle.MethodCallsLogger methodCallsLogger = new androidx.lifecycle.MethodCallsLogger();
        for (androidx.lifecycle.GeneratedAdapter generatedAdapter : this.mGeneratedAdapters) {
            generatedAdapter.callMethods(lifecycleOwner, event, false, methodCallsLogger);
        }
        for (androidx.lifecycle.GeneratedAdapter generatedAdapter2 : this.mGeneratedAdapters) {
            generatedAdapter2.callMethods(lifecycleOwner, event, true, methodCallsLogger);
        }
    }
}
