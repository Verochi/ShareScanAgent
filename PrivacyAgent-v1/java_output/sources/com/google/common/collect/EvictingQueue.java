package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class EvictingQueue<E> extends com.google.common.collect.ForwardingQueue<E> implements java.io.Serializable {
    private static final long serialVersionUID = 0;
    private final java.util.Queue<E> delegate;

    @com.google.common.annotations.VisibleForTesting
    final int maxSize;

    private EvictingQueue(int i) {
        com.google.common.base.Preconditions.checkArgument(i >= 0, "maxSize (%s) must >= 0", i);
        this.delegate = new java.util.ArrayDeque(i);
        this.maxSize = i;
    }

    public static <E> com.google.common.collect.EvictingQueue<E> create(int i) {
        return new com.google.common.collect.EvictingQueue<>(i);
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean add(E e) {
        com.google.common.base.Preconditions.checkNotNull(e);
        if (this.maxSize == 0) {
            return true;
        }
        if (size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(e);
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean addAll(java.util.Collection<? extends E> collection) {
        int size = collection.size();
        if (size < this.maxSize) {
            return standardAddAll(collection);
        }
        clear();
        return com.google.common.collect.Iterables.addAll(this, com.google.common.collect.Iterables.skip(collection, size - this.maxSize));
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean contains(java.lang.Object obj) {
        return delegate().contains(com.google.common.base.Preconditions.checkNotNull(obj));
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public java.util.Queue<E> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.ForwardingQueue, java.util.Queue
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean offer(E e) {
        return add(e);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean remove(java.lang.Object obj) {
        return delegate().remove(com.google.common.base.Preconditions.checkNotNull(obj));
    }
}
