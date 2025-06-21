package androidx.lifecycle;

/* loaded from: classes.dex */
public class MediatorLiveData<T> extends androidx.lifecycle.MutableLiveData<T> {
    private androidx.arch.core.internal.SafeIterableMap<androidx.lifecycle.LiveData<?>, androidx.lifecycle.MediatorLiveData.Source<?>> mSources = new androidx.arch.core.internal.SafeIterableMap<>();

    public static class Source<V> implements androidx.lifecycle.Observer<V> {
        final androidx.lifecycle.LiveData<V> mLiveData;
        final androidx.lifecycle.Observer<? super V> mObserver;
        int mVersion = -1;

        public Source(androidx.lifecycle.LiveData<V> liveData, androidx.lifecycle.Observer<? super V> observer) {
            this.mLiveData = liveData;
            this.mObserver = observer;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@androidx.annotation.Nullable V v) {
            if (this.mVersion != this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mObserver.onChanged(v);
            }
        }

        public void plug() {
            this.mLiveData.observeForever(this);
        }

        public void unplug() {
            this.mLiveData.removeObserver(this);
        }
    }

    @androidx.annotation.MainThread
    public <S> void addSource(@androidx.annotation.NonNull androidx.lifecycle.LiveData<S> liveData, @androidx.annotation.NonNull androidx.lifecycle.Observer<? super S> observer) {
        androidx.lifecycle.MediatorLiveData.Source<?> source = new androidx.lifecycle.MediatorLiveData.Source<>(liveData, observer);
        androidx.lifecycle.MediatorLiveData.Source<?> putIfAbsent = this.mSources.putIfAbsent(liveData, source);
        if (putIfAbsent != null && putIfAbsent.mObserver != observer) {
            throw new java.lang.IllegalArgumentException("This source was already added with the different observer");
        }
        if (putIfAbsent == null && hasActiveObservers()) {
            source.plug();
        }
    }

    @Override // androidx.lifecycle.LiveData
    @androidx.annotation.CallSuper
    public void onActive() {
        java.util.Iterator<java.util.Map.Entry<androidx.lifecycle.LiveData<?>, androidx.lifecycle.MediatorLiveData.Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().plug();
        }
    }

    @Override // androidx.lifecycle.LiveData
    @androidx.annotation.CallSuper
    public void onInactive() {
        java.util.Iterator<java.util.Map.Entry<androidx.lifecycle.LiveData<?>, androidx.lifecycle.MediatorLiveData.Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().unplug();
        }
    }

    @androidx.annotation.MainThread
    public <S> void removeSource(@androidx.annotation.NonNull androidx.lifecycle.LiveData<S> liveData) {
        androidx.lifecycle.MediatorLiveData.Source<?> remove = this.mSources.remove(liveData);
        if (remove != null) {
            remove.unplug();
        }
    }
}
