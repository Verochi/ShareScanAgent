package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class ForwardingDeque<E> extends com.google.common.collect.ForwardingQueue<E> implements java.util.Deque<E> {
    @Override // java.util.Deque
    public void addFirst(E e) {
        delegate().addFirst(e);
    }

    @Override // java.util.Deque
    public void addLast(E e) {
        delegate().addLast(e);
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract java.util.Deque<E> delegate();

    @Override // java.util.Deque
    public java.util.Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.Deque
    public E getFirst() {
        return delegate().getFirst();
    }

    @Override // java.util.Deque
    public E getLast() {
        return delegate().getLast();
    }

    @Override // java.util.Deque
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean offerFirst(E e) {
        return delegate().offerFirst(e);
    }

    @Override // java.util.Deque
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean offerLast(E e) {
        return delegate().offerLast(e);
    }

    @Override // java.util.Deque
    public E peekFirst() {
        return delegate().peekFirst();
    }

    @Override // java.util.Deque
    public E peekLast() {
        return delegate().peekLast();
    }

    @Override // java.util.Deque
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.Deque
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public E pollLast() {
        return delegate().pollLast();
    }

    @Override // java.util.Deque
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public E pop() {
        return delegate().pop();
    }

    @Override // java.util.Deque
    public void push(E e) {
        delegate().push(e);
    }

    @Override // java.util.Deque
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public E removeFirst() {
        return delegate().removeFirst();
    }

    @Override // java.util.Deque
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean removeFirstOccurrence(java.lang.Object obj) {
        return delegate().removeFirstOccurrence(obj);
    }

    @Override // java.util.Deque
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public E removeLast() {
        return delegate().removeLast();
    }

    @Override // java.util.Deque
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean removeLastOccurrence(java.lang.Object obj) {
        return delegate().removeLastOccurrence(obj);
    }
}
