package com.google.common.graph;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public abstract class AbstractNetwork<N, E> implements com.google.common.graph.Network<N, E> {

    /* renamed from: com.google.common.graph.AbstractNetwork$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.graph.AbstractGraph<N> {

        /* renamed from: com.google.common.graph.AbstractNetwork$1$1, reason: invalid class name and collision with other inner class name */
        public class C03501 extends java.util.AbstractSet<com.google.common.graph.EndpointPair<N>> {

            /* renamed from: com.google.common.graph.AbstractNetwork$1$1$1, reason: invalid class name and collision with other inner class name */
            public class C03511 implements com.google.common.base.Function<E, com.google.common.graph.EndpointPair<N>> {
                public C03511() {
                }

                @Override // com.google.common.base.Function
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public com.google.common.graph.EndpointPair<N> apply(E e) {
                    return com.google.common.graph.AbstractNetwork.this.incidentNodes(e);
                }
            }

            public C03501() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
                if (!(obj instanceof com.google.common.graph.EndpointPair)) {
                    return false;
                }
                com.google.common.graph.EndpointPair<?> endpointPair = (com.google.common.graph.EndpointPair) obj;
                return com.google.common.graph.AbstractNetwork.AnonymousClass1.this.isOrderingCompatible(endpointPair) && com.google.common.graph.AbstractNetwork.AnonymousClass1.this.nodes().contains(endpointPair.nodeU()) && com.google.common.graph.AbstractNetwork.AnonymousClass1.this.successors((com.google.common.graph.AbstractNetwork.AnonymousClass1) endpointPair.nodeU()).contains(endpointPair.nodeV());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<com.google.common.graph.EndpointPair<N>> iterator() {
                return com.google.common.collect.Iterators.transform(com.google.common.graph.AbstractNetwork.this.edges().iterator(), new com.google.common.graph.AbstractNetwork.AnonymousClass1.C03501.C03511());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return com.google.common.graph.AbstractNetwork.this.edges().size();
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public java.util.Set<N> adjacentNodes(N n) {
            return com.google.common.graph.AbstractNetwork.this.adjacentNodes(n);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean allowsSelfLoops() {
            return com.google.common.graph.AbstractNetwork.this.allowsSelfLoops();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public java.util.Set<com.google.common.graph.EndpointPair<N>> edges() {
            return com.google.common.graph.AbstractNetwork.this.allowsParallelEdges() ? super.edges() : new com.google.common.graph.AbstractNetwork.AnonymousClass1.C03501();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean isDirected() {
            return com.google.common.graph.AbstractNetwork.this.isDirected();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public com.google.common.graph.ElementOrder<N> nodeOrder() {
            return com.google.common.graph.AbstractNetwork.this.nodeOrder();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public java.util.Set<N> nodes() {
            return com.google.common.graph.AbstractNetwork.this.nodes();
        }

        @Override // com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ java.lang.Iterable predecessors(java.lang.Object obj) {
            return predecessors((com.google.common.graph.AbstractNetwork.AnonymousClass1) obj);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public java.util.Set<N> predecessors(N n) {
            return com.google.common.graph.AbstractNetwork.this.predecessors((com.google.common.graph.AbstractNetwork) n);
        }

        @Override // com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ java.lang.Iterable successors(java.lang.Object obj) {
            return successors((com.google.common.graph.AbstractNetwork.AnonymousClass1) obj);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public java.util.Set<N> successors(N n) {
            return com.google.common.graph.AbstractNetwork.this.successors((com.google.common.graph.AbstractNetwork) n);
        }
    }

    /* renamed from: com.google.common.graph.AbstractNetwork$2, reason: invalid class name */
    public class AnonymousClass2 implements com.google.common.base.Predicate<E> {
        public final /* synthetic */ java.lang.Object n;
        public final /* synthetic */ java.lang.Object t;

        public AnonymousClass2(java.lang.Object obj, java.lang.Object obj2) {
            this.n = obj;
            this.t = obj2;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(E e) {
            return com.google.common.graph.AbstractNetwork.this.incidentNodes(e).adjacentNode(this.n).equals(this.t);
        }
    }

    /* renamed from: com.google.common.graph.AbstractNetwork$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.google.common.base.Function<E, com.google.common.graph.EndpointPair<N>> {
        public final /* synthetic */ com.google.common.graph.Network n;

        public AnonymousClass3(com.google.common.graph.Network network) {
            this.n = network;
        }

        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.graph.EndpointPair<N> apply(E e) {
            return this.n.incidentNodes(e);
        }
    }

    public static <N, E> java.util.Map<E, com.google.common.graph.EndpointPair<N>> b(com.google.common.graph.Network<N, E> network) {
        return com.google.common.collect.Maps.asMap(network.edges(), new com.google.common.graph.AbstractNetwork.AnonymousClass3(network));
    }

    public final com.google.common.base.Predicate<E> a(N n, N n2) {
        return new com.google.common.graph.AbstractNetwork.AnonymousClass2(n, n2);
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<E> adjacentEdges(E e) {
        com.google.common.graph.EndpointPair<N> incidentNodes = incidentNodes(e);
        return com.google.common.collect.Sets.difference(com.google.common.collect.Sets.union(incidentEdges(incidentNodes.nodeU()), incidentEdges(incidentNodes.nodeV())), com.google.common.collect.ImmutableSet.of((java.lang.Object) e));
    }

    @Override // com.google.common.graph.Network
    public com.google.common.graph.Graph<N> asGraph() {
        return new com.google.common.graph.AbstractNetwork.AnonymousClass1();
    }

    @Override // com.google.common.graph.Network
    public int degree(N n) {
        return isDirected() ? com.google.common.math.IntMath.saturatedAdd(inEdges(n).size(), outEdges(n).size()) : com.google.common.math.IntMath.saturatedAdd(incidentEdges(n).size(), edgesConnecting(n, n).size());
    }

    @Override // com.google.common.graph.Network
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public E edgeConnectingOrNull(com.google.common.graph.EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgeConnectingOrNull(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.Network
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public E edgeConnectingOrNull(N n, N n2) {
        java.util.Set<E> edgesConnecting = edgesConnecting(n, n2);
        int size = edgesConnecting.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return edgesConnecting.iterator().next();
        }
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", n, n2));
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<E> edgesConnecting(com.google.common.graph.EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgesConnecting(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<E> edgesConnecting(N n, N n2) {
        java.util.Set<E> outEdges = outEdges(n);
        java.util.Set<E> inEdges = inEdges(n2);
        return outEdges.size() <= inEdges.size() ? java.util.Collections.unmodifiableSet(com.google.common.collect.Sets.filter(outEdges, a(n, n2))) : java.util.Collections.unmodifiableSet(com.google.common.collect.Sets.filter(inEdges, a(n2, n)));
    }

    @Override // com.google.common.graph.Network
    public final boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.common.graph.Network)) {
            return false;
        }
        com.google.common.graph.Network network = (com.google.common.graph.Network) obj;
        return isDirected() == network.isDirected() && nodes().equals(network.nodes()) && b(this).equals(b(network));
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(com.google.common.graph.EndpointPair<N> endpointPair) {
        com.google.common.base.Preconditions.checkNotNull(endpointPair);
        if (isOrderingCompatible(endpointPair)) {
            return !edgesConnecting(endpointPair.nodeU(), endpointPair.nodeV()).isEmpty();
        }
        return false;
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(N n, N n2) {
        return !edgesConnecting(n, n2).isEmpty();
    }

    @Override // com.google.common.graph.Network
    public final int hashCode() {
        return b(this).hashCode();
    }

    @Override // com.google.common.graph.Network
    public int inDegree(N n) {
        return isDirected() ? inEdges(n).size() : degree(n);
    }

    public final boolean isOrderingCompatible(com.google.common.graph.EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() || !isDirected();
    }

    @Override // com.google.common.graph.Network
    public int outDegree(N n) {
        return isDirected() ? outEdges(n).size() : degree(n);
    }

    public java.lang.String toString() {
        return "isDirected: " + isDirected() + ", allowsParallelEdges: " + allowsParallelEdges() + ", allowsSelfLoops: " + allowsSelfLoops() + ", nodes: " + nodes() + ", edges: " + b(this);
    }

    public final void validateEndpoints(com.google.common.graph.EndpointPair<?> endpointPair) {
        com.google.common.base.Preconditions.checkNotNull(endpointPair);
        com.google.common.base.Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }
}
