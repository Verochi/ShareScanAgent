package com.google.common.graph;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class GraphBuilder<N> extends com.google.common.graph.AbstractGraphBuilder<N> {
    public GraphBuilder(boolean z) {
        super(z);
    }

    public static com.google.common.graph.GraphBuilder<java.lang.Object> directed() {
        return new com.google.common.graph.GraphBuilder<>(true);
    }

    public static <N> com.google.common.graph.GraphBuilder<N> from(com.google.common.graph.Graph<N> graph) {
        return (com.google.common.graph.GraphBuilder<N>) new com.google.common.graph.GraphBuilder(graph.isDirected()).allowsSelfLoops(graph.allowsSelfLoops()).nodeOrder(graph.nodeOrder());
    }

    public static com.google.common.graph.GraphBuilder<java.lang.Object> undirected() {
        return new com.google.common.graph.GraphBuilder<>(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N1 extends N> com.google.common.graph.GraphBuilder<N1> a() {
        return this;
    }

    public com.google.common.graph.GraphBuilder<N> allowsSelfLoops(boolean z) {
        this.b = z;
        return this;
    }

    public <N1 extends N> com.google.common.graph.MutableGraph<N1> build() {
        return new com.google.common.graph.ConfigurableMutableGraph(this);
    }

    public com.google.common.graph.GraphBuilder<N> expectedNodeCount(int i) {
        this.d = com.google.common.base.Optional.of(java.lang.Integer.valueOf(com.google.common.graph.Graphs.b(i)));
        return this;
    }

    public <N1 extends N> com.google.common.graph.GraphBuilder<N1> nodeOrder(com.google.common.graph.ElementOrder<N1> elementOrder) {
        com.google.common.graph.GraphBuilder<N1> a = a();
        a.c = (com.google.common.graph.ElementOrder) com.google.common.base.Preconditions.checkNotNull(elementOrder);
        return a;
    }
}
