package com.google.common.graph;

/* loaded from: classes22.dex */
class ConfigurableValueGraph<N, V> extends com.google.common.graph.AbstractValueGraph<N, V> {
    public final boolean a;
    public final boolean b;
    public final com.google.common.graph.ElementOrder<N> c;
    protected long edgeCount;
    protected final com.google.common.graph.MapIteratorCache<N, com.google.common.graph.GraphConnections<N, V>> nodeConnections;

    public ConfigurableValueGraph(com.google.common.graph.AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.c.b(abstractGraphBuilder.d.or((com.google.common.base.Optional<java.lang.Integer>) 10).intValue()), 0L);
    }

    public ConfigurableValueGraph(com.google.common.graph.AbstractGraphBuilder<? super N> abstractGraphBuilder, java.util.Map<N, com.google.common.graph.GraphConnections<N, V>> map, long j) {
        this.a = abstractGraphBuilder.a;
        this.b = abstractGraphBuilder.b;
        this.c = (com.google.common.graph.ElementOrder<N>) abstractGraphBuilder.c.a();
        this.nodeConnections = map instanceof java.util.TreeMap ? new com.google.common.graph.MapRetrievalCache<>(map) : new com.google.common.graph.MapIteratorCache<>(map);
        this.edgeCount = com.google.common.graph.Graphs.c(j);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public java.util.Set<N> adjacentNodes(N n) {
        return checkedConnections(n).a();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return this.b;
    }

    public final com.google.common.graph.GraphConnections<N, V> checkedConnections(N n) {
        com.google.common.graph.GraphConnections<N, V> e = this.nodeConnections.e(n);
        if (e != null) {
            return e;
        }
        com.google.common.base.Preconditions.checkNotNull(n);
        throw new java.lang.IllegalArgumentException("Node " + n + " is not an element of this graph.");
    }

    public final boolean containsNode(@org.checkerframework.checker.nullness.compatqual.NullableDecl N n) {
        return this.nodeConnections.d(n);
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    public long edgeCount() {
        return this.edgeCount;
    }

    @Override // com.google.common.graph.ValueGraph
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V edgeValueOrDefault(com.google.common.graph.EndpointPair<N> endpointPair, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        validateEndpoints(endpointPair);
        return edgeValueOrDefault_internal(endpointPair.nodeU(), endpointPair.nodeV(), v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ValueGraph
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V edgeValueOrDefault(N n, N n2, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return (V) edgeValueOrDefault_internal(com.google.common.base.Preconditions.checkNotNull(n), com.google.common.base.Preconditions.checkNotNull(n2), v);
    }

    public final V edgeValueOrDefault_internal(N n, N n2, V v) {
        com.google.common.graph.GraphConnections<N, V> e = this.nodeConnections.e(n);
        V e2 = e == null ? null : e.e(n2);
        return e2 == null ? v : e2;
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(com.google.common.graph.EndpointPair<N> endpointPair) {
        com.google.common.base.Preconditions.checkNotNull(endpointPair);
        return isOrderingCompatible(endpointPair) && hasEdgeConnecting_internal(endpointPair.nodeU(), endpointPair.nodeV());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n, N n2) {
        return hasEdgeConnecting_internal(com.google.common.base.Preconditions.checkNotNull(n), com.google.common.base.Preconditions.checkNotNull(n2));
    }

    public final boolean hasEdgeConnecting_internal(N n, N n2) {
        com.google.common.graph.GraphConnections<N, V> e = this.nodeConnections.e(n);
        return e != null && e.b().contains(n2);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean isDirected() {
        return this.a;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public com.google.common.graph.ElementOrder<N> nodeOrder() {
        return this.c;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public java.util.Set<N> nodes() {
        return this.nodeConnections.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ java.lang.Iterable predecessors(java.lang.Object obj) {
        return predecessors((com.google.common.graph.ConfigurableValueGraph<N, V>) obj);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    public java.util.Set<N> predecessors(N n) {
        return checkedConnections(n).c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ java.lang.Iterable successors(java.lang.Object obj) {
        return successors((com.google.common.graph.ConfigurableValueGraph<N, V>) obj);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    public java.util.Set<N> successors(N n) {
        return checkedConnections(n).b();
    }
}
