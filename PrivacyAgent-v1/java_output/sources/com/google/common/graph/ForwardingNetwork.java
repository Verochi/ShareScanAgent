package com.google.common.graph;

/* loaded from: classes22.dex */
abstract class ForwardingNetwork<N, E> extends com.google.common.graph.AbstractNetwork<N, E> {
    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public java.util.Set<E> adjacentEdges(E e) {
        return c().adjacentEdges(e);
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<N> adjacentNodes(N n) {
        return c().adjacentNodes(n);
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return c().allowsParallelEdges();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return c().allowsSelfLoops();
    }

    public abstract com.google.common.graph.Network<N, E> c();

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int degree(N n) {
        return c().degree(n);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public E edgeConnectingOrNull(com.google.common.graph.EndpointPair<N> endpointPair) {
        return c().edgeConnectingOrNull(endpointPair);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public E edgeConnectingOrNull(N n, N n2) {
        return c().edgeConnectingOrNull(n, n2);
    }

    @Override // com.google.common.graph.Network
    public com.google.common.graph.ElementOrder<E> edgeOrder() {
        return c().edgeOrder();
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<E> edges() {
        return c().edges();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public java.util.Set<E> edgesConnecting(com.google.common.graph.EndpointPair<N> endpointPair) {
        return c().edgesConnecting(endpointPair);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public java.util.Set<E> edgesConnecting(N n, N n2) {
        return c().edgesConnecting(n, n2);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean hasEdgeConnecting(com.google.common.graph.EndpointPair<N> endpointPair) {
        return c().hasEdgeConnecting(endpointPair);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean hasEdgeConnecting(N n, N n2) {
        return c().hasEdgeConnecting(n, n2);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int inDegree(N n) {
        return c().inDegree(n);
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<E> inEdges(N n) {
        return c().inEdges(n);
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<E> incidentEdges(N n) {
        return c().incidentEdges(n);
    }

    @Override // com.google.common.graph.Network
    public com.google.common.graph.EndpointPair<N> incidentNodes(E e) {
        return c().incidentNodes(e);
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return c().isDirected();
    }

    @Override // com.google.common.graph.Network
    public com.google.common.graph.ElementOrder<N> nodeOrder() {
        return c().nodeOrder();
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<N> nodes() {
        return c().nodes();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int outDegree(N n) {
        return c().outDegree(n);
    }

    @Override // com.google.common.graph.Network
    public java.util.Set<E> outEdges(N n) {
        return c().outEdges(n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ java.lang.Iterable predecessors(java.lang.Object obj) {
        return predecessors((com.google.common.graph.ForwardingNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public java.util.Set<N> predecessors(N n) {
        return c().predecessors((com.google.common.graph.Network<N, E>) n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ java.lang.Iterable successors(java.lang.Object obj) {
        return successors((com.google.common.graph.ForwardingNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public java.util.Set<N> successors(N n) {
        return c().successors((com.google.common.graph.Network<N, E>) n);
    }
}
