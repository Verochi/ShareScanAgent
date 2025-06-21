package androidx.databinding;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
interface ObservableReference<T> {
    void addListener(T t);

    androidx.databinding.WeakListener<T> getListener();

    void removeListener(T t);

    void setLifecycleOwner(androidx.lifecycle.LifecycleOwner lifecycleOwner);
}
