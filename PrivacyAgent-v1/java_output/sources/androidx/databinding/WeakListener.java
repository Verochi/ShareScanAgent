package androidx.databinding;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
class WeakListener<T> extends java.lang.ref.WeakReference<androidx.databinding.ViewDataBinding> {
    protected final int mLocalFieldId;
    private final androidx.databinding.ObservableReference<T> mObservable;
    private T mTarget;

    public WeakListener(androidx.databinding.ViewDataBinding viewDataBinding, int i, androidx.databinding.ObservableReference<T> observableReference, java.lang.ref.ReferenceQueue<androidx.databinding.ViewDataBinding> referenceQueue) {
        super(viewDataBinding, referenceQueue);
        this.mLocalFieldId = i;
        this.mObservable = observableReference;
    }

    @androidx.annotation.Nullable
    public androidx.databinding.ViewDataBinding getBinder() {
        androidx.databinding.ViewDataBinding viewDataBinding = (androidx.databinding.ViewDataBinding) get();
        if (viewDataBinding == null) {
            unregister();
        }
        return viewDataBinding;
    }

    public T getTarget() {
        return this.mTarget;
    }

    public void setLifecycleOwner(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        this.mObservable.setLifecycleOwner(lifecycleOwner);
    }

    public void setTarget(T t) {
        unregister();
        this.mTarget = t;
        if (t != null) {
            this.mObservable.addListener(t);
        }
    }

    public boolean unregister() {
        boolean z;
        T t = this.mTarget;
        if (t != null) {
            this.mObservable.removeListener(t);
            z = true;
        } else {
            z = false;
        }
        this.mTarget = null;
        return z;
    }
}
