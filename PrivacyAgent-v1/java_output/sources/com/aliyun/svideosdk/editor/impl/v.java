package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
class v<E> {
    private final android.util.SparseArray<E> a;
    private final java.lang.Object b = this;

    public v(android.util.SparseArray<E> sparseArray) {
        this.a = sparseArray;
    }

    public int a(E e) {
        synchronized (this.b) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                if (e == null) {
                    if (this.a.valueAt(i) == null) {
                        return i;
                    }
                } else if (e.equals(this.a.valueAt(i))) {
                    return i;
                }
            }
            return -1;
        }
    }

    public void a() {
        synchronized (this.b) {
            this.a.clear();
        }
    }

    public void a(int i) {
        synchronized (this.b) {
            this.a.delete(i);
        }
    }

    public void a(int i, E e) {
        synchronized (this.b) {
            this.a.put(i, e);
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public android.util.SparseArray<E> clone() {
        android.util.SparseArray<E> clone;
        synchronized (this.b) {
            clone = this.a.clone();
        }
        return clone;
    }

    public E b(int i) {
        E e;
        synchronized (this.b) {
            e = this.a.get(i);
        }
        return e;
    }

    public int c() {
        int size;
        synchronized (this.b) {
            size = this.a.size();
        }
        return size;
    }

    public int c(int i) {
        int indexOfKey;
        synchronized (this.b) {
            indexOfKey = this.a.indexOfKey(i);
        }
        return indexOfKey;
    }

    public int d(int i) {
        int keyAt;
        synchronized (this.b) {
            keyAt = this.a.keyAt(i);
        }
        return keyAt;
    }

    public void e(int i) {
        synchronized (this.b) {
            this.a.removeAt(i);
        }
    }

    public E f(int i) {
        E valueAt;
        synchronized (this.b) {
            valueAt = this.a.valueAt(i);
        }
        return valueAt;
    }
}
