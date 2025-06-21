package com.google.common.graph;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public abstract class AbstractValueGraph<N, V> extends com.google.common.graph.AbstractBaseGraph<N> implements com.google.common.graph.ValueGraph<N, V> {

    /* renamed from: com.google.common.graph.AbstractValueGraph$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.graph.AbstractGraph<N> {
        public AnonymousClass1() {
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public java.util.Set<N> adjacentNodes(N n) {
            return com.google.common.graph.AbstractValueGraph.this.adjacentNodes(n);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean allowsSelfLoops() {
            return com.google.common.graph.AbstractValueGraph.this.allowsSelfLoops();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int degree(N n) {
            return com.google.common.graph.AbstractValueGraph.this.degree(n);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public java.util.Set<com.google.common.graph.EndpointPair<N>> edges() {
            return com.google.common.graph.AbstractValueGraph.this.edges();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N n) {
            return com.google.common.graph.AbstractValueGraph.this.inDegree(n);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean isDirected() {
            return com.google.common.graph.AbstractValueGraph.this.isDirected();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public com.google.common.graph.ElementOrder<N> nodeOrder() {
            return com.google.common.graph.AbstractValueGraph.this.nodeOrder();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public java.util.Set<N> nodes() {
            return com.google.common.graph.AbstractValueGraph.this.nodes();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N n) {
            return com.google.common.graph.AbstractValueGraph.this.outDegree(n);
        }

        @Override // com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ java.lang.Iterable predecessors(java.lang.Object obj) {
            return predecessors((com.google.common.graph.AbstractValueGraph.AnonymousClass1) obj);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public java.util.Set<N> predecessors(N n) {
            return com.google.common.graph.AbstractValueGraph.this.predecessors((com.google.common.graph.AbstractValueGraph) n);
        }

        @Override // com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ java.lang.Iterable successors(java.lang.Object obj) {
            return successors((com.google.common.graph.AbstractValueGraph.AnonymousClass1) obj);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public java.util.Set<N> successors(N n) {
            return com.google.common.graph.AbstractValueGraph.this.successors((com.google.common.graph.AbstractValueGraph) n);
        }
    }

    /* renamed from: com.google.common.graph.AbstractValueGraph$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.common.base.Function<com.google.common.graph.EndpointPair<N>, V> {
        public final /* synthetic */ com.google.common.graph.ValueGraph n;

        public AnonymousClass2(com.google.common.graph.ValueGraph valueGraph) {
            this.n = valueGraph;
        }

        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public V apply(com.google.common.graph.EndpointPair<N> endpointPair) {
            return (V) this.n.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null);
        }
    }

    public static <N, V> java.util.Map<com.google.common.graph.EndpointPair<N>, V> a(com.google.common.graph.ValueGraph<N, V> valueGraph) {
        return com.google.common.collect.Maps.asMap(valueGraph.edges(), new com.google.common.graph.AbstractValueGraph.AnonymousClass2(valueGraph));
    }

    @Override // com.google.common.graph.ValueGraph
    public com.google.common.graph.Graph<N> asGraph() {
        return new com.google.common.graph.AbstractValueGraph.AnonymousClass1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int degree(java.lang.Object obj) {
        return super.degree(obj);
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ java.util.Set edges() {
        return super.edges();
    }

    @Override // com.google.common.graph.ValueGraph
    public final boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.common.graph.ValueGraph)) {
            return false;
        }
        com.google.common.graph.ValueGraph valueGraph = (com.google.common.graph.ValueGraph) obj;
        return isDirected() == valueGraph.isDirected() && nodes().equals(valueGraph.nodes()) && a(this).equals(a(valueGraph));
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(com.google.common.graph.EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(java.lang.Object obj, java.lang.Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }

    @Override // com.google.common.graph.ValueGraph
    public final int hashCode() {
        return a(this).hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int inDegree(java.lang.Object obj) {
        return super.inDegree(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ java.util.Set incidentEdges(java.lang.Object obj) {
        return super.incidentEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int outDegree(java.lang.Object obj) {
        return super.outDegree(obj);
    }

    public java.lang.String toString() {
        return "isDirected: " + isDirected() + ", allowsSelfLoops: " + allowsSelfLoops() + ", nodes: " + nodes() + ", edges: " + a(this);
    }
}
