package com.google.common.graph;

/* loaded from: classes22.dex */
abstract class AbstractBaseGraph<N> implements com.google.common.graph.BaseGraph<N> {

    /* renamed from: com.google.common.graph.AbstractBaseGraph$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.AbstractSet<com.google.common.graph.EndpointPair<N>> {
        public AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.UnmodifiableIterator<com.google.common.graph.EndpointPair<N>> iterator() {
            return com.google.common.graph.EndpointPairIterator.c(com.google.common.graph.AbstractBaseGraph.this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.graph.EndpointPair)) {
                return false;
            }
            com.google.common.graph.EndpointPair<?> endpointPair = (com.google.common.graph.EndpointPair) obj;
            return com.google.common.graph.AbstractBaseGraph.this.isOrderingCompatible(endpointPair) && com.google.common.graph.AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) && com.google.common.graph.AbstractBaseGraph.this.successors((com.google.common.graph.AbstractBaseGraph) endpointPair.nodeU()).contains(endpointPair.nodeV());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.primitives.Ints.saturatedCast(com.google.common.graph.AbstractBaseGraph.this.edgeCount());
        }
    }

    public static abstract class IncidentEdgeSet<N> extends java.util.AbstractSet<com.google.common.graph.EndpointPair<N>> {
        public final N n;
        public final com.google.common.graph.BaseGraph<N> t;

        public static final class Directed<N> extends com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet<N> {

            /* renamed from: com.google.common.graph.AbstractBaseGraph$IncidentEdgeSet$Directed$1, reason: invalid class name */
            public class AnonymousClass1 implements com.google.common.base.Function<N, com.google.common.graph.EndpointPair<N>> {
                public AnonymousClass1() {
                }

                @Override // com.google.common.base.Function
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public com.google.common.graph.EndpointPair<N> apply(N n) {
                    return com.google.common.graph.EndpointPair.ordered(n, com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.this.n);
                }
            }

            /* renamed from: com.google.common.graph.AbstractBaseGraph$IncidentEdgeSet$Directed$2, reason: invalid class name */
            public class AnonymousClass2 implements com.google.common.base.Function<N, com.google.common.graph.EndpointPair<N>> {
                public AnonymousClass2() {
                }

                @Override // com.google.common.base.Function
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public com.google.common.graph.EndpointPair<N> apply(N n) {
                    return com.google.common.graph.EndpointPair.ordered(com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.this.n, n);
                }
            }

            public Directed(com.google.common.graph.BaseGraph<N> baseGraph, N n) {
                super(baseGraph, n, null);
            }

            public /* synthetic */ Directed(com.google.common.graph.BaseGraph baseGraph, java.lang.Object obj, com.google.common.graph.AbstractBaseGraph.AnonymousClass1 anonymousClass1) {
                this(baseGraph, obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.UnmodifiableIterator<com.google.common.graph.EndpointPair<N>> iterator() {
                return com.google.common.collect.Iterators.unmodifiableIterator(com.google.common.collect.Iterators.concat(com.google.common.collect.Iterators.transform(this.t.predecessors((com.google.common.graph.BaseGraph<N>) this.n).iterator(), new com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.AnonymousClass1()), com.google.common.collect.Iterators.transform(com.google.common.collect.Sets.difference(this.t.successors((com.google.common.graph.BaseGraph<N>) this.n), com.google.common.collect.ImmutableSet.of(this.n)).iterator(), new com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.AnonymousClass2())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
                if (!(obj instanceof com.google.common.graph.EndpointPair)) {
                    return false;
                }
                com.google.common.graph.EndpointPair endpointPair = (com.google.common.graph.EndpointPair) obj;
                if (!endpointPair.isOrdered()) {
                    return false;
                }
                java.lang.Object source = endpointPair.source();
                java.lang.Object target = endpointPair.target();
                return (this.n.equals(source) && this.t.successors((com.google.common.graph.BaseGraph<N>) this.n).contains(target)) || (this.n.equals(target) && this.t.predecessors((com.google.common.graph.BaseGraph<N>) this.n).contains(source));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return (this.t.inDegree(this.n) + this.t.outDegree(this.n)) - (this.t.successors((com.google.common.graph.BaseGraph<N>) this.n).contains(this.n) ? 1 : 0);
            }
        }

        public static final class Undirected<N> extends com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet<N> {

            /* renamed from: com.google.common.graph.AbstractBaseGraph$IncidentEdgeSet$Undirected$1, reason: invalid class name */
            public class AnonymousClass1 implements com.google.common.base.Function<N, com.google.common.graph.EndpointPair<N>> {
                public AnonymousClass1() {
                }

                @Override // com.google.common.base.Function
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public com.google.common.graph.EndpointPair<N> apply(N n) {
                    return com.google.common.graph.EndpointPair.unordered(com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Undirected.this.n, n);
                }
            }

            public Undirected(com.google.common.graph.BaseGraph<N> baseGraph, N n) {
                super(baseGraph, n, null);
            }

            public /* synthetic */ Undirected(com.google.common.graph.BaseGraph baseGraph, java.lang.Object obj, com.google.common.graph.AbstractBaseGraph.AnonymousClass1 anonymousClass1) {
                this(baseGraph, obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.UnmodifiableIterator<com.google.common.graph.EndpointPair<N>> iterator() {
                return com.google.common.collect.Iterators.unmodifiableIterator(com.google.common.collect.Iterators.transform(this.t.adjacentNodes(this.n).iterator(), new com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Undirected.AnonymousClass1()));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
                if (!(obj instanceof com.google.common.graph.EndpointPair)) {
                    return false;
                }
                com.google.common.graph.EndpointPair endpointPair = (com.google.common.graph.EndpointPair) obj;
                if (endpointPair.isOrdered()) {
                    return false;
                }
                java.util.Set<N> adjacentNodes = this.t.adjacentNodes(this.n);
                java.lang.Object nodeU = endpointPair.nodeU();
                java.lang.Object nodeV = endpointPair.nodeV();
                return (this.n.equals(nodeV) && adjacentNodes.contains(nodeU)) || (this.n.equals(nodeU) && adjacentNodes.contains(nodeV));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.t.adjacentNodes(this.n).size();
            }
        }

        public IncidentEdgeSet(com.google.common.graph.BaseGraph<N> baseGraph, N n) {
            this.t = baseGraph;
            this.n = n;
        }

        public /* synthetic */ IncidentEdgeSet(com.google.common.graph.BaseGraph baseGraph, java.lang.Object obj, com.google.common.graph.AbstractBaseGraph.AnonymousClass1 anonymousClass1) {
            this(baseGraph, obj);
        }

        public static <N> com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet<N> a(com.google.common.graph.BaseGraph<N> baseGraph, N n) {
            return baseGraph.isDirected() ? new com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed(baseGraph, n, null) : new com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Undirected(baseGraph, n, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    @Override // com.google.common.graph.BaseGraph
    public int degree(N n) {
        if (isDirected()) {
            return com.google.common.math.IntMath.saturatedAdd(predecessors((com.google.common.graph.AbstractBaseGraph<N>) n).size(), successors((com.google.common.graph.AbstractBaseGraph<N>) n).size());
        }
        java.util.Set<N> adjacentNodes = adjacentNodes(n);
        return com.google.common.math.IntMath.saturatedAdd(adjacentNodes.size(), (allowsSelfLoops() && adjacentNodes.contains(n)) ? 1 : 0);
    }

    public long edgeCount() {
        long j = 0;
        while (nodes().iterator().hasNext()) {
            j += degree(r0.next());
        }
        com.google.common.base.Preconditions.checkState((1 & j) == 0);
        return j >>> 1;
    }

    @Override // com.google.common.graph.BaseGraph
    public java.util.Set<com.google.common.graph.EndpointPair<N>> edges() {
        return new com.google.common.graph.AbstractBaseGraph.AnonymousClass1();
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(com.google.common.graph.EndpointPair<N> endpointPair) {
        com.google.common.base.Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        N nodeU = endpointPair.nodeU();
        return nodes().contains(nodeU) && successors((com.google.common.graph.AbstractBaseGraph<N>) nodeU).contains(endpointPair.nodeV());
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n, N n2) {
        com.google.common.base.Preconditions.checkNotNull(n);
        com.google.common.base.Preconditions.checkNotNull(n2);
        return nodes().contains(n) && successors((com.google.common.graph.AbstractBaseGraph<N>) n).contains(n2);
    }

    @Override // com.google.common.graph.BaseGraph
    public int inDegree(N n) {
        return isDirected() ? predecessors((com.google.common.graph.AbstractBaseGraph<N>) n).size() : degree(n);
    }

    public java.util.Set<com.google.common.graph.EndpointPair<N>> incidentEdges(N n) {
        com.google.common.base.Preconditions.checkNotNull(n);
        com.google.common.base.Preconditions.checkArgument(nodes().contains(n), "Node %s is not an element of this graph.", n);
        return com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.a(this, n);
    }

    public final boolean isOrderingCompatible(com.google.common.graph.EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() || !isDirected();
    }

    @Override // com.google.common.graph.BaseGraph
    public int outDegree(N n) {
        return isDirected() ? successors((com.google.common.graph.AbstractBaseGraph<N>) n).size() : degree(n);
    }

    public final void validateEndpoints(com.google.common.graph.EndpointPair<?> endpointPair) {
        com.google.common.base.Preconditions.checkNotNull(endpointPair);
        com.google.common.base.Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }
}
