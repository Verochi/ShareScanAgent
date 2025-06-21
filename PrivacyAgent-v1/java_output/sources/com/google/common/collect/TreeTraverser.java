package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class TreeTraverser<T> {

    /* renamed from: com.google.common.collect.TreeTraverser$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.google.common.collect.TreeTraverser<T> {
        public final /* synthetic */ com.google.common.base.Function a;

        public AnonymousClass1(com.google.common.base.Function function) {
            this.a = function;
        }

        @Override // com.google.common.collect.TreeTraverser
        public java.lang.Iterable<T> children(T t) {
            return (java.lang.Iterable) this.a.apply(t);
        }
    }

    /* renamed from: com.google.common.collect.TreeTraverser$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.collect.FluentIterable<T> {
        public final /* synthetic */ java.lang.Object t;

        public AnonymousClass2(java.lang.Object obj) {
            this.t = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.UnmodifiableIterator<T> iterator() {
            return com.google.common.collect.TreeTraverser.this.b(this.t);
        }
    }

    /* renamed from: com.google.common.collect.TreeTraverser$3, reason: invalid class name */
    public class AnonymousClass3 extends com.google.common.collect.FluentIterable<T> {
        public final /* synthetic */ java.lang.Object t;

        public AnonymousClass3(java.lang.Object obj) {
            this.t = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.UnmodifiableIterator<T> iterator() {
            return com.google.common.collect.TreeTraverser.this.a(this.t);
        }
    }

    /* renamed from: com.google.common.collect.TreeTraverser$4, reason: invalid class name */
    public class AnonymousClass4 extends com.google.common.collect.FluentIterable<T> {
        public final /* synthetic */ java.lang.Object t;

        public AnonymousClass4(java.lang.Object obj) {
            this.t = obj;
        }

        @Override // java.lang.Iterable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.UnmodifiableIterator<T> iterator() {
            return new com.google.common.collect.TreeTraverser.BreadthFirstIterator(this.t);
        }
    }

    public final class BreadthFirstIterator extends com.google.common.collect.UnmodifiableIterator<T> implements com.google.common.collect.PeekingIterator<T> {
        public final java.util.Queue<T> n;

        public BreadthFirstIterator(T t) {
            java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
            this.n = arrayDeque;
            arrayDeque.add(t);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.n.isEmpty();
        }

        @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
        public T next() {
            T remove = this.n.remove();
            com.google.common.collect.Iterables.addAll(this.n, com.google.common.collect.TreeTraverser.this.children(remove));
            return remove;
        }

        @Override // com.google.common.collect.PeekingIterator
        public T peek() {
            return this.n.element();
        }
    }

    public final class PostOrderIterator extends com.google.common.collect.AbstractIterator<T> {
        public final java.util.ArrayDeque<com.google.common.collect.TreeTraverser.PostOrderNode<T>> u;

        public PostOrderIterator(T t) {
            java.util.ArrayDeque<com.google.common.collect.TreeTraverser.PostOrderNode<T>> arrayDeque = new java.util.ArrayDeque<>();
            this.u = arrayDeque;
            arrayDeque.addLast(b(t));
        }

        public final com.google.common.collect.TreeTraverser.PostOrderNode<T> b(T t) {
            return new com.google.common.collect.TreeTraverser.PostOrderNode<>(t, com.google.common.collect.TreeTraverser.this.children(t).iterator());
        }

        @Override // com.google.common.collect.AbstractIterator
        public T computeNext() {
            while (!this.u.isEmpty()) {
                com.google.common.collect.TreeTraverser.PostOrderNode<T> last = this.u.getLast();
                if (!last.b.hasNext()) {
                    this.u.removeLast();
                    return last.a;
                }
                this.u.addLast(b(last.b.next()));
            }
            return endOfData();
        }
    }

    public static final class PostOrderNode<T> {
        public final T a;
        public final java.util.Iterator<T> b;

        public PostOrderNode(T t, java.util.Iterator<T> it) {
            this.a = (T) com.google.common.base.Preconditions.checkNotNull(t);
            this.b = (java.util.Iterator) com.google.common.base.Preconditions.checkNotNull(it);
        }
    }

    public final class PreOrderIterator extends com.google.common.collect.UnmodifiableIterator<T> {
        public final java.util.Deque<java.util.Iterator<T>> n;

        public PreOrderIterator(T t) {
            java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
            this.n = arrayDeque;
            arrayDeque.addLast(com.google.common.collect.Iterators.singletonIterator(com.google.common.base.Preconditions.checkNotNull(t)));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.n.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            java.util.Iterator<T> last = this.n.getLast();
            T t = (T) com.google.common.base.Preconditions.checkNotNull(last.next());
            if (!last.hasNext()) {
                this.n.removeLast();
            }
            java.util.Iterator<T> it = com.google.common.collect.TreeTraverser.this.children(t).iterator();
            if (it.hasNext()) {
                this.n.addLast(it);
            }
            return t;
        }
    }

    @java.lang.Deprecated
    public static <T> com.google.common.collect.TreeTraverser<T> using(com.google.common.base.Function<T, ? extends java.lang.Iterable<T>> function) {
        com.google.common.base.Preconditions.checkNotNull(function);
        return new com.google.common.collect.TreeTraverser.AnonymousClass1(function);
    }

    public com.google.common.collect.UnmodifiableIterator<T> a(T t) {
        return new com.google.common.collect.TreeTraverser.PostOrderIterator(t);
    }

    public com.google.common.collect.UnmodifiableIterator<T> b(T t) {
        return new com.google.common.collect.TreeTraverser.PreOrderIterator(t);
    }

    @java.lang.Deprecated
    public final com.google.common.collect.FluentIterable<T> breadthFirstTraversal(T t) {
        com.google.common.base.Preconditions.checkNotNull(t);
        return new com.google.common.collect.TreeTraverser.AnonymousClass4(t);
    }

    public abstract java.lang.Iterable<T> children(T t);

    @java.lang.Deprecated
    public final com.google.common.collect.FluentIterable<T> postOrderTraversal(T t) {
        com.google.common.base.Preconditions.checkNotNull(t);
        return new com.google.common.collect.TreeTraverser.AnonymousClass3(t);
    }

    @java.lang.Deprecated
    public final com.google.common.collect.FluentIterable<T> preOrderTraversal(T t) {
        com.google.common.base.Preconditions.checkNotNull(t);
        return new com.google.common.collect.TreeTraverser.AnonymousClass2(t);
    }
}
