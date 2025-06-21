package androidx.activity;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    @androidx.annotation.Nullable
    private final java.lang.Runnable mFallbackOnBackPressed;
    final java.util.ArrayDeque<androidx.activity.OnBackPressedCallback> mOnBackPressedCallbacks;

    public class LifecycleOnBackPressedCancellable implements androidx.lifecycle.LifecycleEventObserver, androidx.activity.Cancellable {

        @androidx.annotation.Nullable
        private androidx.activity.Cancellable mCurrentCancellable;
        private final androidx.lifecycle.Lifecycle mLifecycle;
        private final androidx.activity.OnBackPressedCallback mOnBackPressedCallback;

        public LifecycleOnBackPressedCancellable(@androidx.annotation.NonNull androidx.lifecycle.Lifecycle lifecycle, @androidx.annotation.NonNull androidx.activity.OnBackPressedCallback onBackPressedCallback) {
            this.mLifecycle = lifecycle;
            this.mOnBackPressedCallback = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.mLifecycle.removeObserver(this);
            this.mOnBackPressedCallback.removeCancellable(this);
            androidx.activity.Cancellable cancellable = this.mCurrentCancellable;
            if (cancellable != null) {
                cancellable.cancel();
                this.mCurrentCancellable = null;
            }
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
            if (event == androidx.lifecycle.Lifecycle.Event.ON_START) {
                this.mCurrentCancellable = androidx.activity.OnBackPressedDispatcher.this.addCancellableCallback(this.mOnBackPressedCallback);
                return;
            }
            if (event != androidx.lifecycle.Lifecycle.Event.ON_STOP) {
                if (event == androidx.lifecycle.Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.Cancellable cancellable = this.mCurrentCancellable;
                if (cancellable != null) {
                    cancellable.cancel();
                }
            }
        }
    }

    public class OnBackPressedCancellable implements androidx.activity.Cancellable {
        private final androidx.activity.OnBackPressedCallback mOnBackPressedCallback;

        public OnBackPressedCancellable(androidx.activity.OnBackPressedCallback onBackPressedCallback) {
            this.mOnBackPressedCallback = onBackPressedCallback;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            androidx.activity.OnBackPressedDispatcher.this.mOnBackPressedCallbacks.remove(this.mOnBackPressedCallback);
            this.mOnBackPressedCallback.removeCancellable(this);
        }
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(@androidx.annotation.Nullable java.lang.Runnable runnable) {
        this.mOnBackPressedCallbacks = new java.util.ArrayDeque<>();
        this.mFallbackOnBackPressed = runnable;
    }

    @androidx.annotation.MainThread
    public void addCallback(@androidx.annotation.NonNull androidx.activity.OnBackPressedCallback onBackPressedCallback) {
        addCancellableCallback(onBackPressedCallback);
    }

    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.MainThread
    public void addCallback(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.activity.OnBackPressedCallback onBackPressedCallback) {
        androidx.lifecycle.Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() == androidx.lifecycle.Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new androidx.activity.OnBackPressedDispatcher.LifecycleOnBackPressedCancellable(lifecycle, onBackPressedCallback));
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public androidx.activity.Cancellable addCancellableCallback(@androidx.annotation.NonNull androidx.activity.OnBackPressedCallback onBackPressedCallback) {
        this.mOnBackPressedCallbacks.add(onBackPressedCallback);
        androidx.activity.OnBackPressedDispatcher.OnBackPressedCancellable onBackPressedCancellable = new androidx.activity.OnBackPressedDispatcher.OnBackPressedCancellable(onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedCancellable);
        return onBackPressedCancellable;
    }

    @androidx.annotation.MainThread
    public boolean hasEnabledCallbacks() {
        java.util.Iterator<androidx.activity.OnBackPressedCallback> descendingIterator = this.mOnBackPressedCallbacks.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next().isEnabled()) {
                return true;
            }
        }
        return false;
    }

    @androidx.annotation.MainThread
    public void onBackPressed() {
        java.util.Iterator<androidx.activity.OnBackPressedCallback> descendingIterator = this.mOnBackPressedCallbacks.descendingIterator();
        while (descendingIterator.hasNext()) {
            androidx.activity.OnBackPressedCallback next = descendingIterator.next();
            if (next.isEnabled()) {
                next.handleOnBackPressed();
                return;
            }
        }
        java.lang.Runnable runnable = this.mFallbackOnBackPressed;
        if (runnable != null) {
            runnable.run();
        }
    }
}
