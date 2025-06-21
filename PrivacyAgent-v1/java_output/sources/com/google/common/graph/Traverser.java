package com.google.common.graph;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public abstract class Traverser<N> {

    public static final class GraphTraverser<N> extends com.google.common.graph.Traverser<N> {
        public final com.google.common.graph.SuccessorsFunction<N> a;

        /* renamed from: com.google.common.graph.Traverser$GraphTraverser$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Iterable<N> {
            public final /* synthetic */ java.lang.Iterable n;

            public AnonymousClass1(java.lang.Iterable iterable) {
                this.n = iterable;
            }

            @Override // java.lang.Iterable
            public java.util.Iterator<N> iterator() {
                return new com.google.common.graph.Traverser.GraphTraverser.BreadthFirstIterator(this.n);
            }
        }

        /* renamed from: com.google.common.graph.Traverser$GraphTraverser$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Iterable<N> {
            public final /* synthetic */ java.lang.Iterable n;

            public AnonymousClass2(java.lang.Iterable iterable) {
                this.n = iterable;
            }

            @Override // java.lang.Iterable
            public java.util.Iterator<N> iterator() {
                return new com.google.common.graph.Traverser.GraphTraverser.DepthFirstIterator(this.n, com.google.common.graph.Traverser.Order.PREORDER);
            }
        }

        /* renamed from: com.google.common.graph.Traverser$GraphTraverser$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Iterable<N> {
            public final /* synthetic */ java.lang.Iterable n;

            public AnonymousClass3(java.lang.Iterable iterable) {
                this.n = iterable;
            }

            @Override // java.lang.Iterable
            public java.util.Iterator<N> iterator() {
                return new com.google.common.graph.Traverser.GraphTraverser.DepthFirstIterator(this.n, com.google.common.graph.Traverser.Order.POSTORDER);
            }
        }

        public final class BreadthFirstIterator extends com.google.common.collect.UnmodifiableIterator<N> {
            public final java.util.Queue<N> n = new java.util.ArrayDeque();
            public final java.util.Set<N> t = new java.util.HashSet();

            public BreadthFirstIterator(java.lang.Iterable<? extends N> iterable) {
                for (N n : iterable) {
                    if (this.t.add(n)) {
                        this.n.add(n);
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.n.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N remove = this.n.remove();
                for (N n : com.google.common.graph.Traverser.GraphTraverser.this.a.successors(remove)) {
                    if (this.t.add(n)) {
                        this.n.add(n);
                    }
                }
                return remove;
            }
        }

        public final class DepthFirstIterator extends com.google.common.collect.AbstractIterator<N> {
            public final java.util.Deque<com.google.common.graph.Traverser.GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors> u;
            public final java.util.Set<N> v;
            public final com.google.common.graph.Traverser.Order w;

            public final class NodeAndSuccessors {

                @org.checkerframework.checker.nullness.compatqual.NullableDecl
                public final N a;
                public final java.util.Iterator<? extends N> b;

                public NodeAndSuccessors(@org.checkerframework.checker.nullness.compatqual.NullableDecl N n, java.lang.Iterable<? extends N> iterable) {
                    this.a = n;
                    this.b = iterable.iterator();
                }
            }

            public DepthFirstIterator(java.lang.Iterable<? extends N> iterable, com.google.common.graph.Traverser.Order order) {
                java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
                this.u = arrayDeque;
                this.v = new java.util.HashSet();
                arrayDeque.push(new com.google.common.graph.Traverser.GraphTraverser.DepthFirstIterator.NodeAndSuccessors(null, iterable));
                this.w = order;
            }

            public com.google.common.graph.Traverser.GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors b(N n) {
                return new com.google.common.graph.Traverser.GraphTraverser.DepthFirstIterator.NodeAndSuccessors(n, com.google.common.graph.Traverser.GraphTraverser.this.a.successors(n));
            }

            @Override // com.google.common.collect.AbstractIterator
            public N computeNext() {
                N n;
                while (!this.u.isEmpty()) {
                    com.google.common.graph.Traverser.GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors first = this.u.getFirst();
                    boolean add = this.v.add(first.a);
                    boolean z = true;
                    boolean z2 = !first.b.hasNext();
                    if ((!add || this.w != com.google.common.graph.Traverser.Order.PREORDER) && (!z2 || this.w != com.google.common.graph.Traverser.Order.POSTORDER)) {
                        z = false;
                    }
                    if (z2) {
                        this.u.pop();
                    } else {
                        N next = first.b.next();
                        if (!this.v.contains(next)) {
                            this.u.push(b(next));
                        }
                    }
                    if (z && (n = first.a) != null) {
                        return n;
                    }
                }
                return (N) endOfData();
            }
        }

        public GraphTraverser(com.google.common.graph.SuccessorsFunction<N> successorsFunction) {
            super(null);
            this.a = (com.google.common.graph.SuccessorsFunction) com.google.common.base.Preconditions.checkNotNull(successorsFunction);
        }

        public final void b(N n) {
            this.a.successors(n);
        }

        @Override // com.google.common.graph.Traverser
        public java.lang.Iterable<N> breadthFirst(java.lang.Iterable<? extends N> iterable) {
            com.google.common.base.Preconditions.checkNotNull(iterable);
            if (com.google.common.collect.Iterables.isEmpty(iterable)) {
                return com.google.common.collect.ImmutableSet.of();
            }
            java.util.Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            return new com.google.common.graph.Traverser.GraphTraverser.AnonymousClass1(iterable);
        }

        @Override // com.google.common.graph.Traverser
        public java.lang.Iterable<N> breadthFirst(N n) {
            com.google.common.base.Preconditions.checkNotNull(n);
            return breadthFirst((java.lang.Iterable) com.google.common.collect.ImmutableSet.of(n));
        }

        @Override // com.google.common.graph.Traverser
        public java.lang.Iterable<N> depthFirstPostOrder(java.lang.Iterable<? extends N> iterable) {
            com.google.common.base.Preconditions.checkNotNull(iterable);
            if (com.google.common.collect.Iterables.isEmpty(iterable)) {
                return com.google.common.collect.ImmutableSet.of();
            }
            java.util.Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            return new com.google.common.graph.Traverser.GraphTraverser.AnonymousClass3(iterable);
        }

        @Override // com.google.common.graph.Traverser
        public java.lang.Iterable<N> depthFirstPostOrder(N n) {
            com.google.common.base.Preconditions.checkNotNull(n);
            return depthFirstPostOrder((java.lang.Iterable) com.google.common.collect.ImmutableSet.of(n));
        }

        @Override // com.google.common.graph.Traverser
        public java.lang.Iterable<N> depthFirstPreOrder(java.lang.Iterable<? extends N> iterable) {
            com.google.common.base.Preconditions.checkNotNull(iterable);
            if (com.google.common.collect.Iterables.isEmpty(iterable)) {
                return com.google.common.collect.ImmutableSet.of();
            }
            java.util.Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            return new com.google.common.graph.Traverser.GraphTraverser.AnonymousClass2(iterable);
        }

        @Override // com.google.common.graph.Traverser
        public java.lang.Iterable<N> depthFirstPreOrder(N n) {
            com.google.common.base.Preconditions.checkNotNull(n);
            return depthFirstPreOrder((java.lang.Iterable) com.google.common.collect.ImmutableSet.of(n));
        }
    }

    public enum Order {
        PREORDER,
        POSTORDER
    }

    public static final class TreeTraverser<N> extends com.google.common.graph.Traverser<N> {
        public final com.google.common.graph.SuccessorsFunction<N> a;

        /* renamed from: com.google.common.graph.Traverser$TreeTraverser$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Iterable<N> {
            public final /* synthetic */ java.lang.Iterable n;

            public AnonymousClass1(java.lang.Iterable iterable) {
                this.n = iterable;
            }

            @Override // java.lang.Iterable
            public java.util.Iterator<N> iterator() {
                return new com.google.common.graph.Traverser.TreeTraverser.BreadthFirstIterator(this.n);
            }
        }

        /* renamed from: com.google.common.graph.Traverser$TreeTraverser$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Iterable<N> {
            public final /* synthetic */ java.lang.Iterable n;

            public AnonymousClass2(java.lang.Iterable iterable) {
                this.n = iterable;
            }

            @Override // java.lang.Iterable
            public java.util.Iterator<N> iterator() {
                return new com.google.common.graph.Traverser.TreeTraverser.DepthFirstPreOrderIterator(this.n);
            }
        }

        /* renamed from: com.google.common.graph.Traverser$TreeTraverser$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Iterable<N> {
            public final /* synthetic */ java.lang.Iterable n;

            public AnonymousClass3(java.lang.Iterable iterable) {
                this.n = iterable;
            }

            @Override // java.lang.Iterable
            public java.util.Iterator<N> iterator() {
                return new com.google.common.graph.Traverser.TreeTraverser.DepthFirstPostOrderIterator(this.n);
            }
        }

        public final class BreadthFirstIterator extends com.google.common.collect.UnmodifiableIterator<N> {
            public final java.util.Queue<N> n = new java.util.ArrayDeque();

            public BreadthFirstIterator(java.lang.Iterable<? extends N> iterable) {
                java.util.Iterator<? extends N> it = iterable.iterator();
                while (it.hasNext()) {
                    this.n.add(it.next());
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.n.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N remove = this.n.remove();
                com.google.common.collect.Iterables.addAll(this.n, com.google.common.graph.Traverser.TreeTraverser.this.a.successors(remove));
                return remove;
            }
        }

        public final class DepthFirstPostOrderIterator extends com.google.common.collect.AbstractIterator<N> {
            public final java.util.ArrayDeque<com.google.common.graph.Traverser.TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> u;

            public final class NodeAndChildren {

                @org.checkerframework.checker.nullness.compatqual.NullableDecl
                public final N a;
                public final java.util.Iterator<? extends N> b;

                public NodeAndChildren(@org.checkerframework.checker.nullness.compatqual.NullableDecl N n, java.lang.Iterable<? extends N> iterable) {
                    this.a = n;
                    this.b = iterable.iterator();
                }
            }

            public DepthFirstPostOrderIterator(java.lang.Iterable<? extends N> iterable) {
                java.util.ArrayDeque<com.google.common.graph.Traverser.TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> arrayDeque = new java.util.ArrayDeque<>();
                this.u = arrayDeque;
                arrayDeque.addLast(new com.google.common.graph.Traverser.TreeTraverser.DepthFirstPostOrderIterator.NodeAndChildren(null, iterable));
            }

            public com.google.common.graph.Traverser.TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren b(N n) {
                return new com.google.common.graph.Traverser.TreeTraverser.DepthFirstPostOrderIterator.NodeAndChildren(n, com.google.common.graph.Traverser.TreeTraverser.this.a.successors(n));
            }

            @Override // com.google.common.collect.AbstractIterator
            public N computeNext() {
                while (!this.u.isEmpty()) {
                    com.google.common.graph.Traverser.TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren last = this.u.getLast();
                    if (last.b.hasNext()) {
                        this.u.addLast(b(last.b.next()));
                    } else {
                        this.u.removeLast();
                        N n = last.a;
                        if (n != null) {
                            return n;
                        }
                    }
                }
                return (N) endOfData();
            }
        }

        public final class DepthFirstPreOrderIterator extends com.google.common.collect.UnmodifiableIterator<N> {
            public final java.util.Deque<java.util.Iterator<? extends N>> n;

            public DepthFirstPreOrderIterator(java.lang.Iterable<? extends N> iterable) {
                java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
                this.n = arrayDeque;
                arrayDeque.addLast(iterable.iterator());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.n.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                java.util.Iterator<? extends N> last = this.n.getLast();
                N n = (N) com.google.common.base.Preconditions.checkNotNull(last.next());
                if (!last.hasNext()) {
                    this.n.removeLast();
                }
                java.util.Iterator<? extends N> it = com.google.common.graph.Traverser.TreeTraverser.this.a.successors(n).iterator();
                if (it.hasNext()) {
                    this.n.addLast(it);
                }
                return n;
            }
        }

        public TreeTraverser(com.google.common.graph.SuccessorsFunction<N> successorsFunction) {
            super(null);
            this.a = (com.google.common.graph.SuccessorsFunction) com.google.common.base.Preconditions.checkNotNull(successorsFunction);
        }

        public final void b(N n) {
            this.a.successors(n);
        }

        @Override // com.google.common.graph.Traverser
        public java.lang.Iterable<N> breadthFirst(java.lang.Iterable<? extends N> iterable) {
            com.google.common.base.Preconditions.checkNotNull(iterable);
            if (com.google.common.collect.Iterables.isEmpty(iterable)) {
                return com.google.common.collect.ImmutableSet.of();
            }
            java.util.Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            return new com.google.common.graph.Traverser.TreeTraverser.AnonymousClass1(iterable);
        }

        @Override // com.google.common.graph.Traverser
        public java.lang.Iterable<N> breadthFirst(N n) {
            com.google.common.base.Preconditions.checkNotNull(n);
            return breadthFirst((java.lang.Iterable) com.google.common.collect.ImmutableSet.of(n));
        }

        @Override // com.google.common.graph.Traverser
        public java.lang.Iterable<N> depthFirstPostOrder(java.lang.Iterable<? extends N> iterable) {
            com.google.common.base.Preconditions.checkNotNull(iterable);
            if (com.google.common.collect.Iterables.isEmpty(iterable)) {
                return com.google.common.collect.ImmutableSet.of();
            }
            java.util.Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            return new com.google.common.graph.Traverser.TreeTraverser.AnonymousClass3(iterable);
        }

        @Override // com.google.common.graph.Traverser
        public java.lang.Iterable<N> depthFirstPostOrder(N n) {
            com.google.common.base.Preconditions.checkNotNull(n);
            return depthFirstPostOrder((java.lang.Iterable) com.google.common.collect.ImmutableSet.of(n));
        }

        @Override // com.google.common.graph.Traverser
        public java.lang.Iterable<N> depthFirstPreOrder(java.lang.Iterable<? extends N> iterable) {
            com.google.common.base.Preconditions.checkNotNull(iterable);
            if (com.google.common.collect.Iterables.isEmpty(iterable)) {
                return com.google.common.collect.ImmutableSet.of();
            }
            java.util.Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            return new com.google.common.graph.Traverser.TreeTraverser.AnonymousClass2(iterable);
        }

        @Override // com.google.common.graph.Traverser
        public java.lang.Iterable<N> depthFirstPreOrder(N n) {
            com.google.common.base.Preconditions.checkNotNull(n);
            return depthFirstPreOrder((java.lang.Iterable) com.google.common.collect.ImmutableSet.of(n));
        }
    }

    public Traverser() {
    }

    public /* synthetic */ Traverser(com.google.common.graph.Traverser.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static <N> com.google.common.graph.Traverser<N> forGraph(com.google.common.graph.SuccessorsFunction<N> successorsFunction) {
        com.google.common.base.Preconditions.checkNotNull(successorsFunction);
        return new com.google.common.graph.Traverser.GraphTraverser(successorsFunction);
    }

    public static <N> com.google.common.graph.Traverser<N> forTree(com.google.common.graph.SuccessorsFunction<N> successorsFunction) {
        com.google.common.base.Preconditions.checkNotNull(successorsFunction);
        if (successorsFunction instanceof com.google.common.graph.BaseGraph) {
            com.google.common.base.Preconditions.checkArgument(((com.google.common.graph.BaseGraph) successorsFunction).isDirected(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof com.google.common.graph.Network) {
            com.google.common.base.Preconditions.checkArgument(((com.google.common.graph.Network) successorsFunction).isDirected(), "Undirected networks can never be trees.");
        }
        return new com.google.common.graph.Traverser.TreeTraverser(successorsFunction);
    }

    public abstract java.lang.Iterable<N> breadthFirst(java.lang.Iterable<? extends N> iterable);

    public abstract java.lang.Iterable<N> breadthFirst(N n);

    public abstract java.lang.Iterable<N> depthFirstPostOrder(java.lang.Iterable<? extends N> iterable);

    public abstract java.lang.Iterable<N> depthFirstPostOrder(N n);

    public abstract java.lang.Iterable<N> depthFirstPreOrder(java.lang.Iterable<? extends N> iterable);

    public abstract java.lang.Iterable<N> depthFirstPreOrder(N n);
}
