package com.google.common.graph;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class NetworkBuilder<N, E> extends com.google.common.graph.AbstractGraphBuilder<N> {
    public boolean e;
    public com.google.common.graph.ElementOrder<? super E> f;
    public com.google.common.base.Optional<java.lang.Integer> g;

    public NetworkBuilder(boolean z) {
        super(z);
        this.e = false;
        this.f = com.google.common.graph.ElementOrder.insertion();
        this.g = com.google.common.base.Optional.absent();
    }

    public static com.google.common.graph.NetworkBuilder<java.lang.Object, java.lang.Object> directed() {
        return new com.google.common.graph.NetworkBuilder<>(true);
    }

    public static <N, E> com.google.common.graph.NetworkBuilder<N, E> from(com.google.common.graph.Network<N, E> network) {
        return new com.google.common.graph.NetworkBuilder(network.isDirected()).allowsParallelEdges(network.allowsParallelEdges()).allowsSelfLoops(network.allowsSelfLoops()).nodeOrder(network.nodeOrder()).edgeOrder(network.edgeOrder());
    }

    public static com.google.common.graph.NetworkBuilder<java.lang.Object, java.lang.Object> undirected() {
        return new com.google.common.graph.NetworkBuilder<>(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N1 extends N, E1 extends E> com.google.common.graph.NetworkBuilder<N1, E1> a() {
        return this;
    }

    public com.google.common.graph.NetworkBuilder<N, E> allowsParallelEdges(boolean z) {
        this.e = z;
        return this;
    }

    public com.google.common.graph.NetworkBuilder<N, E> allowsSelfLoops(boolean z) {
        this.b = z;
        return this;
    }

    public <N1 extends N, E1 extends E> com.google.common.graph.MutableNetwork<N1, E1> build() {
        return new com.google.common.graph.ConfigurableMutableNetwork(this);
    }

    public <E1 extends E> com.google.common.graph.NetworkBuilder<N, E1> edgeOrder(com.google.common.graph.ElementOrder<E1> elementOrder) {
        com.google.common.graph.NetworkBuilder<N, E1> networkBuilder = (com.google.common.graph.NetworkBuilder<N, E1>) a();
        networkBuilder.f = (com.google.common.graph.ElementOrder) com.google.common.base.Preconditions.checkNotNull(elementOrder);
        return networkBuilder;
    }

    public com.google.common.graph.NetworkBuilder<N, E> expectedEdgeCount(int i) {
        this.g = com.google.common.base.Optional.of(java.lang.Integer.valueOf(com.google.common.graph.Graphs.b(i)));
        return this;
    }

    public com.google.common.graph.NetworkBuilder<N, E> expectedNodeCount(int i) {
        this.d = com.google.common.base.Optional.of(java.lang.Integer.valueOf(com.google.common.graph.Graphs.b(i)));
        return this;
    }

    public <N1 extends N> com.google.common.graph.NetworkBuilder<N1, E> nodeOrder(com.google.common.graph.ElementOrder<N1> elementOrder) {
        com.google.common.graph.NetworkBuilder<N1, E> networkBuilder = (com.google.common.graph.NetworkBuilder<N1, E>) a();
        networkBuilder.c = (com.google.common.graph.ElementOrder) com.google.common.base.Preconditions.checkNotNull(elementOrder);
        return networkBuilder;
    }
}
