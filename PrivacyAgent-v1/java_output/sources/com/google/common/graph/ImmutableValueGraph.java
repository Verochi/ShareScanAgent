package com.google.common.graph;

@com.google.errorprone.annotations.Immutable(containerOf = {"N", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED})
@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class ImmutableValueGraph<N, V> extends com.google.common.graph.ConfigurableValueGraph<N, V> {

    /* renamed from: com.google.common.graph.ImmutableValueGraph$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.base.Function<N, V> {
        public final /* synthetic */ com.google.common.graph.ValueGraph n;
        public final /* synthetic */ java.lang.Object t;

        public AnonymousClass1(com.google.common.graph.ValueGraph valueGraph, java.lang.Object obj) {
            this.n = valueGraph;
            this.t = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Function
        public V apply(N n) {
            return (V) this.n.edgeValueOrDefault(this.t, n, null);
        }
    }

    public ImmutableValueGraph(com.google.common.graph.ValueGraph<N, V> valueGraph) {
        super(com.google.common.graph.ValueGraphBuilder.from(valueGraph), c(valueGraph), valueGraph.edges().size());
    }

    public static <N, V> com.google.common.graph.GraphConnections<N, V> b(com.google.common.graph.ValueGraph<N, V> valueGraph, N n) {
        com.google.common.graph.ImmutableValueGraph.AnonymousClass1 anonymousClass1 = new com.google.common.graph.ImmutableValueGraph.AnonymousClass1(valueGraph, n);
        return valueGraph.isDirected() ? com.google.common.graph.DirectedGraphConnections.q(valueGraph.predecessors((com.google.common.graph.ValueGraph<N, V>) n), com.google.common.collect.Maps.asMap(valueGraph.successors((com.google.common.graph.ValueGraph<N, V>) n), anonymousClass1)) : com.google.common.graph.UndirectedGraphConnections.j(com.google.common.collect.Maps.asMap(valueGraph.adjacentNodes(n), anonymousClass1));
    }

    public static <N, V> com.google.common.collect.ImmutableMap<N, com.google.common.graph.GraphConnections<N, V>> c(com.google.common.graph.ValueGraph<N, V> valueGraph) {
        com.google.common.collect.ImmutableMap.Builder builder = com.google.common.collect.ImmutableMap.builder();
        for (N n : valueGraph.nodes()) {
            builder.put(n, b(valueGraph, n));
        }
        return builder.build();
    }

    @java.lang.Deprecated
    public static <N, V> com.google.common.graph.ImmutableValueGraph<N, V> copyOf(com.google.common.graph.ImmutableValueGraph<N, V> immutableValueGraph) {
        return (com.google.common.graph.ImmutableValueGraph) com.google.common.base.Preconditions.checkNotNull(immutableValueGraph);
    }

    public static <N, V> com.google.common.graph.ImmutableValueGraph<N, V> copyOf(com.google.common.graph.ValueGraph<N, V> valueGraph) {
        return valueGraph instanceof com.google.common.graph.ImmutableValueGraph ? (com.google.common.graph.ImmutableValueGraph) valueGraph : new com.google.common.graph.ImmutableValueGraph<>(valueGraph);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ java.util.Set adjacentNodes(java.lang.Object obj) {
        return super.adjacentNodes(obj);
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.ValueGraph
    public com.google.common.graph.ImmutableGraph<N> asGraph() {
        return new com.google.common.graph.ImmutableGraph<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.ValueGraph
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public /* bridge */ /* synthetic */ java.lang.Object edgeValueOrDefault(com.google.common.graph.EndpointPair endpointPair, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.edgeValueOrDefault(endpointPair, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.ValueGraph
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public /* bridge */ /* synthetic */ java.lang.Object edgeValueOrDefault(java.lang.Object obj, java.lang.Object obj2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj3) {
        return super.edgeValueOrDefault(obj, obj2, obj3);
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(com.google.common.graph.EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(java.lang.Object obj, java.lang.Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ com.google.common.graph.ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ java.util.Set nodes() {
        return super.nodes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ java.util.Set predecessors(java.lang.Object obj) {
        return super.predecessors((com.google.common.graph.ImmutableValueGraph<N, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ java.util.Set successors(java.lang.Object obj) {
        return super.successors((com.google.common.graph.ImmutableValueGraph<N, V>) obj);
    }
}
