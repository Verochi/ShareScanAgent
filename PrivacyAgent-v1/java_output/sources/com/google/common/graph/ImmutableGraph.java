package com.google.common.graph;

@com.google.errorprone.annotations.Immutable(containerOf = {"N"})
@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public class ImmutableGraph<N> extends com.google.common.graph.ForwardingGraph<N> {
    public final com.google.common.graph.BaseGraph<N> a;

    public ImmutableGraph(com.google.common.graph.BaseGraph<N> baseGraph) {
        this.a = baseGraph;
    }

    public static <N> com.google.common.graph.GraphConnections<N, com.google.common.graph.GraphConstants.Presence> a(com.google.common.graph.Graph<N> graph, N n) {
        com.google.common.base.Function constant = com.google.common.base.Functions.constant(com.google.common.graph.GraphConstants.Presence.EDGE_EXISTS);
        return graph.isDirected() ? com.google.common.graph.DirectedGraphConnections.q(graph.predecessors((com.google.common.graph.Graph<N>) n), com.google.common.collect.Maps.asMap(graph.successors((com.google.common.graph.Graph<N>) n), constant)) : com.google.common.graph.UndirectedGraphConnections.j(com.google.common.collect.Maps.asMap(graph.adjacentNodes(n), constant));
    }

    public static <N> com.google.common.collect.ImmutableMap<N, com.google.common.graph.GraphConnections<N, com.google.common.graph.GraphConstants.Presence>> b(com.google.common.graph.Graph<N> graph) {
        com.google.common.collect.ImmutableMap.Builder builder = com.google.common.collect.ImmutableMap.builder();
        for (N n : graph.nodes()) {
            builder.put(n, a(graph, n));
        }
        return builder.build();
    }

    public static <N> com.google.common.graph.ImmutableGraph<N> copyOf(com.google.common.graph.Graph<N> graph) {
        return graph instanceof com.google.common.graph.ImmutableGraph ? (com.google.common.graph.ImmutableGraph) graph : new com.google.common.graph.ImmutableGraph<>(new com.google.common.graph.ConfigurableValueGraph(com.google.common.graph.GraphBuilder.from(graph), b(graph), graph.edges().size()));
    }

    @java.lang.Deprecated
    public static <N> com.google.common.graph.ImmutableGraph<N> copyOf(com.google.common.graph.ImmutableGraph<N> immutableGraph) {
        return (com.google.common.graph.ImmutableGraph) com.google.common.base.Preconditions.checkNotNull(immutableGraph);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ java.util.Set adjacentNodes(java.lang.Object obj) {
        return super.adjacentNodes(obj);
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int degree(java.lang.Object obj) {
        return super.degree(obj);
    }

    @Override // com.google.common.graph.ForwardingGraph
    public com.google.common.graph.BaseGraph<N> delegate() {
        return this.a;
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(com.google.common.graph.EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(java.lang.Object obj, java.lang.Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int inDegree(java.lang.Object obj) {
        return super.inDegree(obj);
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ com.google.common.graph.ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ java.util.Set nodes() {
        return super.nodes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int outDegree(java.lang.Object obj) {
        return super.outDegree(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ java.util.Set predecessors(java.lang.Object obj) {
        return super.predecessors((com.google.common.graph.ImmutableGraph<N>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ java.util.Set successors(java.lang.Object obj) {
        return super.successors((com.google.common.graph.ImmutableGraph<N>) obj);
    }
}
