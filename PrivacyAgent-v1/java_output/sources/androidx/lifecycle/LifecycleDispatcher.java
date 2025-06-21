package androidx.lifecycle;

/* loaded from: classes.dex */
class LifecycleDispatcher {
    private static java.util.concurrent.atomic.AtomicBoolean sInitialized = new java.util.concurrent.atomic.AtomicBoolean(false);

    @androidx.annotation.VisibleForTesting
    public static class DispatcherActivityCallback extends androidx.lifecycle.EmptyActivityLifecycleCallbacks {
        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
            androidx.lifecycle.ReportFragment.injectIfNeededIn(activity);
        }

        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
        }
    }

    private LifecycleDispatcher() {
    }

    public static void init(android.content.Context context) {
        if (sInitialized.getAndSet(true)) {
            return;
        }
        ((android.app.Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new androidx.lifecycle.LifecycleDispatcher.DispatcherActivityCallback());
    }
}
