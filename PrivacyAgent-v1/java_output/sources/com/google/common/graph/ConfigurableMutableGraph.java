package com.google.common.graph;

/* loaded from: classes22.dex */
final class ConfigurableMutableGraph<N> extends com.google.common.graph.ForwardingGraph<N> implements com.google.common.graph.MutableGraph<N> {
    public final com.google.common.graph.MutableValueGraph<N, com.google.common.graph.GraphConstants.Presence> a;

    public ConfigurableMutableGraph(com.google.common.graph.AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this.a = new com.google.common.graph.ConfigurableMutableValueGraph(abstractGraphBuilder);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean addNode(N n) {
        return this.a.addNode(n);
    }

    @Override // com.google.common.graph.ForwardingGraph
    public com.google.common.graph.BaseGraph<N> delegate() {
        return this.a;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(com.google.common.graph.EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(N n, N n2) {
        return this.a.putEdgeValue(n, n2, com.google.common.graph.GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(com.google.common.graph.EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(N n, N n2) {
        return this.a.removeEdge(n, n2) != null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeNode(N n) {
        return this.a.removeNode(n);
    }
}
