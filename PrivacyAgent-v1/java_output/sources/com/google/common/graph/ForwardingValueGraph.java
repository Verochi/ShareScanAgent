package com.google.common.graph;

/* loaded from: classes22.dex */
abstract class ForwardingValueGraph<N, V> extends com.google.common.graph.AbstractValueGraph<N, V> {
    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public java.util.Set<N> adjacentNodes(N n) {
        return b().adjacentNodes(n);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return b().allowsSelfLoops();
    }

    public abstract com.google.common.graph.ValueGraph<N, V> b();

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int degree(N n) {
        return b().degree(n);
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    public long edgeCount() {
        return b().edges().size();
    }

    @Override // com.google.common.graph.ValueGraph
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V edgeValueOrDefault(com.google.common.graph.EndpointPair<N> endpointPair, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return b().edgeValueOrDefault(endpointPair, v);
    }

    @Override // com.google.common.graph.ValueGraph
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V edgeValueOrDefault(N n, N n2, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return b().edgeValueOrDefault(n, n2, v);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(com.google.common.graph.EndpointPair<N> endpointPair) {
        return b().hasEdgeConnecting(endpointPair);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n, N n2) {
        return b().hasEdgeConnecting(n, n2);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int inDegree(N n) {
        return b().inDegree(n);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean isDirected() {
        return b().isDirected();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public com.google.common.graph.ElementOrder<N> nodeOrder() {
        return b().nodeOrder();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public java.util.Set<N> nodes() {
        return b().nodes();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int outDegree(N n) {
        return b().outDegree(n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ java.lang.Iterable predecessors(java.lang.Object obj) {
        return predecessors((com.google.common.graph.ForwardingValueGraph<N, V>) obj);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    public java.util.Set<N> predecessors(N n) {
        return b().predecessors((com.google.common.graph.ValueGraph<N, V>) n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ java.lang.Iterable successors(java.lang.Object obj) {
        return successors((com.google.common.graph.ForwardingValueGraph<N, V>) obj);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    public java.util.Set<N> successors(N n) {
        return b().successors((com.google.common.graph.ValueGraph<N, V>) n);
    }
}
