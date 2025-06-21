package io.reactivex.subjects;

/* loaded from: classes14.dex */
public abstract class Subject<T> extends io.reactivex.Observable<T> implements io.reactivex.Observer<T> {
    @io.reactivex.annotations.Nullable
    public abstract java.lang.Throwable getThrowable();

    public abstract boolean hasComplete();

    public abstract boolean hasObservers();

    public abstract boolean hasThrowable();

    @io.reactivex.annotations.NonNull
    public final io.reactivex.subjects.Subject<T> toSerialized() {
        return this instanceof io.reactivex.subjects.SerializedSubject ? this : new io.reactivex.subjects.SerializedSubject(this);
    }
}
