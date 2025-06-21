package io.reactivex.internal.disposables;

/* loaded from: classes9.dex */
public final class ListCompositeDisposable implements io.reactivex.disposables.Disposable, io.reactivex.internal.disposables.DisposableContainer {
    public java.util.List<io.reactivex.disposables.Disposable> n;
    public volatile boolean t;

    public ListCompositeDisposable() {
    }

    public ListCompositeDisposable(java.lang.Iterable<? extends io.reactivex.disposables.Disposable> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "resources is null");
        this.n = new java.util.LinkedList();
        for (io.reactivex.disposables.Disposable disposable : iterable) {
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "Disposable item is null");
            this.n.add(disposable);
        }
    }

    public ListCompositeDisposable(io.reactivex.disposables.Disposable... disposableArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposableArr, "resources is null");
        this.n = new java.util.LinkedList();
        for (io.reactivex.disposables.Disposable disposable : disposableArr) {
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "Disposable item is null");
            this.n.add(disposable);
        }
    }

    public void a(java.util.List<io.reactivex.disposables.Disposable> list) {
        if (list == null) {
            return;
        }
        java.util.Iterator<io.reactivex.disposables.Disposable> it = list.iterator();
        java.util.ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                it.next().dispose();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                }
                arrayList.add(th);
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
    public boolean add(io.reactivex.disposables.Disposable disposable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "d is null");
        if (!this.t) {
            synchronized (this) {
                if (!this.t) {
                    java.util.List list = this.n;
                    if (list == null) {
                        list = new java.util.LinkedList();
                        this.n = list;
                    }
                    list.add(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    public boolean addAll(io.reactivex.disposables.Disposable... disposableArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposableArr, "ds is null");
        if (!this.t) {
            synchronized (this) {
                if (!this.t) {
                    java.util.List list = this.n;
                    if (list == null) {
                        list = new java.util.LinkedList();
                        this.n = list;
                    }
                    for (io.reactivex.disposables.Disposable disposable : disposableArr) {
                        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "d is null");
                        list.add(disposable);
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
            java.util.List<io.reactivex.disposables.Disposable> list = this.n;
            this.n = null;
            a(list);
        }
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean delete(io.reactivex.disposables.Disposable disposable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "Disposable item is null");
        if (this.t) {
            return false;
        }
        synchronized (this) {
            if (this.t) {
                return false;
            }
            java.util.List<io.reactivex.disposables.Disposable> list = this.n;
            if (list != null && list.remove(disposable)) {
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
            java.util.List<io.reactivex.disposables.Disposable> list = this.n;
            this.n = null;
            a(list);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.t;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean remove(io.reactivex.disposables.Disposable disposable) {
        if (!delete(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }
}
