package com.google.common.graph;

/* loaded from: classes22.dex */
interface BaseGraph<N> extends com.google.common.graph.SuccessorsFunction<N>, com.google.common.graph.PredecessorsFunction<N> {
    java.util.Set<N> adjacentNodes(N n);

    boolean allowsSelfLoops();

    int degree(N n);

    java.util.Set<com.google.common.graph.EndpointPair<N>> edges();

    boolean hasEdgeConnecting(com.google.common.graph.EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n, N n2);

    int inDegree(N n);

    boolean isDirected();

    com.google.common.graph.ElementOrder<N> nodeOrder();

    java.util.Set<N> nodes();

    int outDegree(N n);

    java.util.Set<N> predecessors(N n);

    @Override // com.google.common.graph.SuccessorsFunction
    java.util.Set<N> successors(N n);
}
