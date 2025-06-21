package com.google.common.graph;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class ValueGraphBuilder<N, V> extends com.google.common.graph.AbstractGraphBuilder<N> {
    public ValueGraphBuilder(boolean z) {
        super(z);
    }

    public static com.google.common.graph.ValueGraphBuilder<java.lang.Object, java.lang.Object> directed() {
        return new com.google.common.graph.ValueGraphBuilder<>(true);
    }

    public static <N, V> com.google.common.graph.ValueGraphBuilder<N, V> from(com.google.common.graph.ValueGraph<N, V> valueGraph) {
        return (com.google.common.graph.ValueGraphBuilder<N, V>) new com.google.common.graph.ValueGraphBuilder(valueGraph.isDirected()).allowsSelfLoops(valueGraph.allowsSelfLoops()).nodeOrder(valueGraph.nodeOrder());
    }

    public static com.google.common.graph.ValueGraphBuilder<java.lang.Object, java.lang.Object> undirected() {
        return new com.google.common.graph.ValueGraphBuilder<>(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N1 extends N, V1 extends V> com.google.common.graph.ValueGraphBuilder<N1, V1> a() {
        return this;
    }

    public com.google.common.graph.ValueGraphBuilder<N, V> allowsSelfLoops(boolean z) {
        this.b = z;
        return this;
    }

    public <N1 extends N, V1 extends V> com.google.common.graph.MutableValueGraph<N1, V1> build() {
        return new com.google.common.graph.ConfigurableMutableValueGraph(this);
    }

    public com.google.common.graph.ValueGraphBuilder<N, V> expectedNodeCount(int i) {
        this.d = com.google.common.base.Optional.of(java.lang.Integer.valueOf(com.google.common.graph.Graphs.b(i)));
        return this;
    }

    public <N1 extends N> com.google.common.graph.ValueGraphBuilder<N1, V> nodeOrder(com.google.common.graph.ElementOrder<N1> elementOrder) {
        com.google.common.graph.ValueGraphBuilder<N1, V> valueGraphBuilder = (com.google.common.graph.ValueGraphBuilder<N1, V>) a();
        valueGraphBuilder.c = (com.google.common.graph.ElementOrder) com.google.common.base.Preconditions.checkNotNull(elementOrder);
        return valueGraphBuilder;
    }
}
