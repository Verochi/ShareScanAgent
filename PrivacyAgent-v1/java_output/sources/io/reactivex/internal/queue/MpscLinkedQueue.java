package io.reactivex.internal.queue;

/* loaded from: classes13.dex */
public final class MpscLinkedQueue<T> implements io.reactivex.internal.fuseable.SimplePlainQueue<T> {
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<T>> n = new java.util.concurrent.atomic.AtomicReference<>();
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<T>> t = new java.util.concurrent.atomic.AtomicReference<>();

    public static final class LinkedQueueNode<E> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        public LinkedQueueNode() {
        }

        public LinkedQueueNode(E e) {
            spValue(e);
        }

        public E getAndNullValue() {
            E lpValue = lpValue();
            spValue(null);
            return lpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<E> lvNext() {
            return get();
        }

        public void soNext(io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void spValue(E e) {
            this.value = e;
        }
    }

    public MpscLinkedQueue() {
        io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<T> linkedQueueNode = new io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<>();
        d(linkedQueueNode);
        e(linkedQueueNode);
    }

    public io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<T> a() {
        return this.t.get();
    }

    public io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<T> b() {
        return this.t.get();
    }

    public io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<T> c() {
        return this.n.get();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    public void d(io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<T> linkedQueueNode) {
        this.t.lazySet(linkedQueueNode);
    }

    public io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<T> e(io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<T> linkedQueueNode) {
        return this.n.getAndSet(linkedQueueNode);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t) {
        if (t == null) {
            throw new java.lang.NullPointerException("Null is not a valid element");
        }
        io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<T> linkedQueueNode = new io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<>(t);
        e(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t, T t2) {
        offer(t);
        offer(t2);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @io.reactivex.annotations.Nullable
    public T poll() {
        io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<T> lvNext;
        io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<T> a = a();
        io.reactivex.internal.queue.MpscLinkedQueue.LinkedQueueNode<T> lvNext2 = a.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            d(lvNext2);
            return andNullValue;
        }
        if (a == c()) {
            return null;
        }
        do {
            lvNext = a.lvNext();
        } while (lvNext == null);
        T andNullValue2 = lvNext.getAndNullValue();
        d(lvNext);
        return andNullValue2;
    }
}
