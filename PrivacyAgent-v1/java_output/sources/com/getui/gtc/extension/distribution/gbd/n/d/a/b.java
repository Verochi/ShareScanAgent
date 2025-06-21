package com.getui.gtc.extension.distribution.gbd.n.d.a;

/* loaded from: classes22.dex */
public final class b<E> extends java.util.LinkedList<E> {

    public class a<E> implements java.util.Iterator<E> {
        private final java.util.ListIterator<E> b;

        private a(int i) {
            this.b = com.getui.gtc.extension.distribution.gbd.n.d.a.b.this.listIterator(i);
        }

        public /* synthetic */ a(com.getui.gtc.extension.distribution.gbd.n.d.a.b bVar, int i, byte b) {
            this(i);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.b.hasPrevious();
        }

        @Override // java.util.Iterator
        public final E next() {
            return this.b.previous();
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.b.remove();
        }
    }

    @Override // java.util.LinkedList, java.util.Deque
    public final java.util.Iterator<E> descendingIterator() {
        return new com.getui.gtc.extension.distribution.gbd.n.d.a.b.a(this, size(), (byte) 0);
    }

    @Override // java.util.LinkedList, java.util.Deque
    public final E peekLast() {
        if (size() == 0) {
            return null;
        }
        return getLast();
    }

    @Override // java.util.LinkedList, java.util.Deque
    public final E pollLast() {
        if (size() == 0) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.LinkedList, java.util.Deque
    public final void push(E e) {
        addFirst(e);
    }
}
