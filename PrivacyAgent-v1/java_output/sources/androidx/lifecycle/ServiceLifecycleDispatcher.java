package androidx.lifecycle;

/* loaded from: classes.dex */
public class ServiceLifecycleDispatcher {
    private final android.os.Handler mHandler = new android.os.Handler();
    private androidx.lifecycle.ServiceLifecycleDispatcher.DispatchRunnable mLastDispatchRunnable;
    private final androidx.lifecycle.LifecycleRegistry mRegistry;

    public static class DispatchRunnable implements java.lang.Runnable {
        final androidx.lifecycle.Lifecycle.Event mEvent;
        private final androidx.lifecycle.LifecycleRegistry mRegistry;
        private boolean mWasExecuted = false;

        public DispatchRunnable(@androidx.annotation.NonNull androidx.lifecycle.LifecycleRegistry lifecycleRegistry, androidx.lifecycle.Lifecycle.Event event) {
            this.mRegistry = lifecycleRegistry;
            this.mEvent = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mWasExecuted) {
                return;
            }
            this.mRegistry.handleLifecycleEvent(this.mEvent);
            this.mWasExecuted = true;
        }
    }

    public ServiceLifecycleDispatcher(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        this.mRegistry = new androidx.lifecycle.LifecycleRegistry(lifecycleOwner);
    }

    private void postDispatchRunnable(androidx.lifecycle.Lifecycle.Event event) {
        androidx.lifecycle.ServiceLifecycleDispatcher.DispatchRunnable dispatchRunnable = this.mLastDispatchRunnable;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        androidx.lifecycle.ServiceLifecycleDispatcher.DispatchRunnable dispatchRunnable2 = new androidx.lifecycle.ServiceLifecycleDispatcher.DispatchRunnable(this.mRegistry, event);
        this.mLastDispatchRunnable = dispatchRunnable2;
        this.mHandler.postAtFrontOfQueue(dispatchRunnable2);
    }

    @androidx.annotation.NonNull
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return this.mRegistry;
    }

    public void onServicePreSuperOnBind() {
        postDispatchRunnable(androidx.lifecycle.Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnCreate() {
        postDispatchRunnable(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
    }

    public void onServicePreSuperOnDestroy() {
        postDispatchRunnable(androidx.lifecycle.Lifecycle.Event.ON_STOP);
        postDispatchRunnable(androidx.lifecycle.Lifecycle.Event.ON_DESTROY);
    }

    public void onServicePreSuperOnStart() {
        postDispatchRunnable(androidx.lifecycle.Lifecycle.Event.ON_START);
    }
}
