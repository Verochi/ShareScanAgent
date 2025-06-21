package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
class ConsumingQueueIterator<T> extends com.google.common.collect.AbstractIterator<T> {
    public final java.util.Queue<T> u;

    public ConsumingQueueIterator(java.util.Queue<T> queue) {
        this.u = (java.util.Queue) com.google.common.base.Preconditions.checkNotNull(queue);
    }

    @Override // com.google.common.collect.AbstractIterator
    public T computeNext() {
        return this.u.isEmpty() ? endOfData() : this.u.remove();
    }
}
