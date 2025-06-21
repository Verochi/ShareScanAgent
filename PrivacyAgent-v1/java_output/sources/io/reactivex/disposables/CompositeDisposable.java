package io.reactivex.disposables;

/* loaded from: classes9.dex */
public final class CompositeDisposable implements io.reactivex.disposables.Disposable, io.reactivex.internal.disposables.DisposableContainer {
    public io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> n;
    public volatile boolean t;

    public CompositeDisposable() {
    }

    public CompositeDisposable(@io.reactivex.annotations.NonNull java.lang.Iterable<? extends io.reactivex.disposables.Disposable> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "disposables is null");
        this.n = new io.reactivex.internal.util.OpenHashSet<>();
        for (io.reactivex.disposables.Disposable disposable : iterable) {
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "A Disposable item in the disposables sequence is null");
            this.n.add(disposable);
        }
    }

    public CompositeDisposable(@io.reactivex.annotations.NonNull io.reactivex.disposables.Disposable... disposableArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposableArr, "disposables is null");
        this.n = new io.reactivex.internal.util.OpenHashSet<>(disposableArr.length + 1);
        for (io.reactivex.disposables.Disposable disposable : disposableArr) {
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "A Disposable in the disposables array is null");
            this.n.add(disposable);
        }
    }

    public void a(io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> openHashSet) {
        if (openHashSet == null) {
            return;
        }
        java.util.ArrayList arrayList = null;
        for (java.lang.Object obj : openHashSet.keys()) {
            if (obj instanceof io.reactivex.disposables.Disposable) {
                try {
                    ((io.reactivex.disposables.Disposable) obj).dispose();
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new io.reactivex.exceptions.CompositeException(arrayList);
            }
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow((java.lang.Throwable) arrayList.get(0));
        }
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean add(@io.reactivex.annotations.NonNull io.reactivex.disposables.Disposable disposable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "disposable is null");
        if (!this.t) {
            synchronized (this) {
                if (!this.t) {
                    io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> openHashSet = this.n;
                    if (openHashSet == null) {
                        openHashSet = new io.reactivex.internal.util.OpenHashSet<>();
                        this.n = openHashSet;
                    }
                    openHashSet.add(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    public boolean addAll(@io.reactivex.annotations.NonNull io.reactivex.disposables.Disposable... disposableArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposableArr, "disposables is null");
        if (!this.t) {
            synchronized (this) {
                if (!this.t) {
                    io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> openHashSet = this.n;
                    if (openHashSet == null) {
                        openHashSet = new io.reactivex.internal.util.OpenHashSet<>(disposableArr.length + 1);
                        this.n = openHashSet;
                    }
                    for (io.reactivex.disposables.Disposable disposable : disposableArr) {
                        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "A Disposable in the disposables array is null");
                        openHashSet.add(disposable);
                    }
                    return true;
                }
            }
        }
        for (io.reactivex.disposables.Disposable disposable2 : disposableArr) {
            disposable2.dispose();
        }
        return false;
    }

    public void clear() {
        if (this.t) {
            return;
        }
        synchronized (this) {
            if (this.t) {
                return;
            }
            io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> openHashSet = this.n;
            this.n = null;
            a(openHashSet);
        }
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean delete(@io.reactivex.annotations.NonNull io.reactivex.disposables.Disposable disposable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "disposables is null");
        if (this.t) {
            return false;
        }
        synchronized (this) {
            if (this.t) {
                return false;
            }
            io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> openHashSet = this.n;
            if (openHashSet != null && openHashSet.remove(disposable)) {
                return true;
            }
            return false;
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.t) {
            return;
        }
        synchronized (this) {
            if (this.t) {
                return;
            }
            this.t = true;
            io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> openHashSet = this.n;
            this.n = null;
            a(openHashSet);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.t;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean remove(@io.reactivex.annotations.NonNull io.reactivex.disposables.Disposable disposable) {
        if (!delete(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }

    public int size() {
        if (this.t) {
            return 0;
        }
        synchronized (this) {
            if (this.t) {
                return 0;
            }
            io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> openHashSet = this.n;
            return openHashSet != null ? openHashSet.size() : 0;
        }
    }
}
