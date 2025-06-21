package com.google.common.graph;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public interface ValueGraph<N, V> extends com.google.common.graph.BaseGraph<N> {
    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    java.util.Set<N> adjacentNodes(N n);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    boolean allowsSelfLoops();

    com.google.common.graph.Graph<N> asGraph();

    @Override // com.google.common.graph.BaseGraph
    int degree(N n);

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    V edgeValueOrDefault(com.google.common.graph.EndpointPair<N> endpointPair, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v);

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    V edgeValueOrDefault(N n, N n2, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v);

    @Override // com.google.common.graph.BaseGraph
    java.util.Set<com.google.common.graph.EndpointPair<N>> edges();

    boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    @Override // com.google.common.graph.BaseGraph
    boolean hasEdgeConnecting(com.google.common.graph.EndpointPair<N> endpointPair);

    @Override // com.google.common.graph.BaseGraph
    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    @Override // com.google.common.graph.BaseGraph
    int inDegree(N n);

    java.util.Set<com.google.common.graph.EndpointPair<N>> incidentEdges(N n);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    boolean isDirected();

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    com.google.common.graph.ElementOrder<N> nodeOrder();

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    java.util.Set<N> nodes();

    @Override // com.google.common.graph.BaseGraph
    int outDegree(N n);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    java.util.Set<N> predecessors(N n);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    java.util.Set<N> successors(N n);
}
