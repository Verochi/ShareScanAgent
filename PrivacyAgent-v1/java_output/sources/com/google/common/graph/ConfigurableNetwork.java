package com.google.common.graph;

/* loaded from: classes22.dex */
class ConfigurableNetwork<N, E> extends com.google.common.graph.AbstractNetwork<N, E> {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final com.google.common.graph.ElementOrder<N> d;
    public final com.google.common.graph.ElementOrder<E> e;
    protected final com.google.common.graph.MapIteratorCache<E, N> edgeToReferenceNode;
    protected final com.google.common.graph.MapIteratorCache<N, com.google.common.graph.NetworkConnections<N, E>> nodeConnections;

    public ConfigurableNetwork(com.google.common.graph.NetworkBuilder<? super N, ? super E> networkBuilder) {
        this(networkBuilder, networkBuilder.c.b(networkBuilder.d.or((com.google.common.base.Optional<java.lang.Integer>) 10).intValue()), networkBuilder.f.b(networkBuilder.g.or((com.google.common.base.Optional<java.lang.Integer>) 20).intValue()));
    }

    public ConfigurableNetwork(com.google.common.graph.NetworkBuilder<? super N, ? super E> networkBuilder, java.util.Map<N, com.google.common.graph.NetworkConnections<N, E>> map, java.util.Map<E, N> map2) {
        this.a = networkBuilder.a;
        this.b = networkBuilder.e;
        this.c = networkBuilder.b;
        this.d = (com.google.common.graph.ElementOrder<N>) networkBuilder.c.a();
        this.e = (com.google.common.graph.ElementOrder<E>) networkBuilder.f.a();
        this.nodeConnections = map instanceof java.util.TreeMap ? new com.google.common.graph.MapRetrievalCache<>(map) : new com.google.common.graph.MapIteratorCache<>(map);
        this.edgeToReferenceNode = new com.google.common.graph.MapIteratorCache<>(map2);
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<N> adjacentNodes(N n) {
        return checkedConnections(n).a();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.b;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.c;
    }

    public final com.google.common.graph.NetworkConnections<N, E> checkedConnections(N n) {
        com.google.common.graph.NetworkConnections<N, E> e = this.nodeConnections.e(n);
        if (e != null) {
            return e;
        }
        com.google.common.base.Preconditions.checkNotNull(n);
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Node %s is not an element of this graph.", n));
    }

    public final N checkedReferenceNode(E e) {
        N e2 = this.edgeToReferenceNode.e(e);
        if (e2 != null) {
            return e2;
        }
        com.google.common.base.Preconditions.checkNotNull(e);
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Edge %s is not an element of this graph.", e));
    }

    public final boolean containsEdge(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e) {
        return this.edgeToReferenceNode.d(e);
    }

    public final boolean containsNode(@org.checkerframework.checker.nullness.compatqual.NullableDecl N n) {
        return this.nodeConnections.d(n);
    }

    @Override // com.google.common.graph.Network
    public com.google.common.graph.ElementOrder<E> edgeOrder() {
        return this.e;
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<E> edges() {
        return this.edgeToReferenceNode.j();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public java.util.Set<E> edgesConnecting(N n, N n2) {
        com.google.common.graph.NetworkConnections<N, E> checkedConnections = checkedConnections(n);
        if (!this.c && n == n2) {
            return com.google.common.collect.ImmutableSet.of();
        }
        com.google.common.base.Preconditions.checkArgument(containsNode(n2), "Node %s is not an element of this graph.", n2);
        return checkedConnections.l(n2);
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<E> inEdges(N n) {
        return checkedConnections(n).e();
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<E> incidentEdges(N n) {
        return checkedConnections(n).k();
    }

    @Override // com.google.common.graph.Network
    public com.google.common.graph.EndpointPair<N> incidentNodes(E e) {
        N checkedReferenceNode = checkedReferenceNode(e);
        return com.google.common.graph.EndpointPair.a(this, checkedReferenceNode, this.nodeConnections.e(checkedReferenceNode).d(e));
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return this.a;
    }

    @Override // com.google.common.graph.Network
    public com.google.common.graph.ElementOrder<N> nodeOrder() {
        return this.d;
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<N> nodes() {
        return this.nodeConnections.j();
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<E> outEdges(N n) {
        return checkedConnections(n).g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ java.lang.Iterable predecessors(java.lang.Object obj) {
        return predecessors((com.google.common.graph.ConfigurableNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public java.util.Set<N> predecessors(N n) {
        return checkedConnections(n).c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ java.lang.Iterable successors(java.lang.Object obj) {
        return successors((com.google.common.graph.ConfigurableNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public java.util.Set<N> successors(N n) {
        return checkedConnections(n).b();
    }
}
