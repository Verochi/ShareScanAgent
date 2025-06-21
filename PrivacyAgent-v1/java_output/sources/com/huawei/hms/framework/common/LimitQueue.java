package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class LimitQueue<E> extends java.util.concurrent.ConcurrentLinkedQueue<E> {
    private static final java.lang.String TAG = "LimitQueue";
    private static final long serialVersionUID = -4636313759149307798L;
    private boolean deduplication;
    private int limit;

    public LimitQueue(int i) {
        this.deduplication = false;
        this.limit = i;
    }

    public LimitQueue(int i, boolean z) {
        this.limit = i;
        this.deduplication = z;
    }

    public LimitQueue(java.util.Collection<? extends E> collection, boolean z) {
        this(collection.size(), z);
        addAll(collection);
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        if (this.deduplication) {
            super.remove(e);
        }
        if (super.size() >= this.limit) {
            super.poll();
        }
        return super.add(e);
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(java.util.Collection<? extends E> collection) {
        if (collection.size() > this.limit) {
            return false;
        }
        if (this.deduplication) {
            super.removeAll(collection);
        }
        for (int size = (collection.size() + super.size()) - this.limit; size > 0; size--) {
            super.poll();
        }
        return super.addAll(collection);
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        super.clear();
    }

    public E get(int i) {
        java.util.Iterator<E> it = iterator();
        E e = null;
        for (int i2 = 0; i2 <= i && it.hasNext(); i2++) {
            e = it.next();
        }
        return e;
    }

    public int getLimit() {
        return this.limit;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public boolean offer(E e) {
        if (this.deduplication) {
            super.remove(e);
        }
        if (super.size() >= this.limit) {
            super.poll();
        }
        return super.offer(e);
    }

    public E peekLast() {
        java.util.Iterator<E> it = iterator();
        E e = null;
        while (it.hasNext()) {
            e = it.next();
        }
        return e;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public E poll() {
        return (E) super.poll();
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        try {
            return (E) super.remove();
        } catch (java.util.NoSuchElementException unused) {
            com.huawei.hms.framework.common.Logger.w(TAG, "remove failed, limitQueue is empty");
            return null;
        }
    }
}
