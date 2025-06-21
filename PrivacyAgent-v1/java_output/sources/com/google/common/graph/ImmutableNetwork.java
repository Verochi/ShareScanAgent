package com.google.common.graph;

@com.google.errorprone.annotations.Immutable(containerOf = {"N", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST})
@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class ImmutableNetwork<N, E> extends com.google.common.graph.ConfigurableNetwork<N, E> {

    /* renamed from: com.google.common.graph.ImmutableNetwork$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.base.Function<E, N> {
        public final /* synthetic */ com.google.common.graph.Network n;

        public AnonymousClass1(com.google.common.graph.Network network) {
            this.n = network;
        }

        @Override // com.google.common.base.Function
        public N apply(E e) {
            return this.n.incidentNodes(e).source();
        }
    }

    /* renamed from: com.google.common.graph.ImmutableNetwork$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.common.base.Function<E, N> {
        public final /* synthetic */ com.google.common.graph.Network n;

        public AnonymousClass2(com.google.common.graph.Network network) {
            this.n = network;
        }

        @Override // com.google.common.base.Function
        public N apply(E e) {
            return this.n.incidentNodes(e).target();
        }
    }

    /* renamed from: com.google.common.graph.ImmutableNetwork$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.google.common.base.Function<E, N> {
        public final /* synthetic */ com.google.common.graph.Network n;
        public final /* synthetic */ java.lang.Object t;

        public AnonymousClass3(com.google.common.graph.Network network, java.lang.Object obj) {
            this.n = network;
            this.t = obj;
        }

        @Override // com.google.common.base.Function
        public N apply(E e) {
            return this.n.incidentNodes(e).adjacentNode(this.t);
        }
    }

    public ImmutableNetwork(com.google.common.graph.Network<N, E> network) {
        super(com.google.common.graph.NetworkBuilder.from(network), f(network), e(network));
    }

    public static <N, E> com.google.common.base.Function<E, N> c(com.google.common.graph.Network<N, E> network, N n) {
        return new com.google.common.graph.ImmutableNetwork.AnonymousClass3(network, n);
    }

    @java.lang.Deprecated
    public static <N, E> com.google.common.graph.ImmutableNetwork<N, E> copyOf(com.google.common.graph.ImmutableNetwork<N, E> immutableNetwork) {
        return (com.google.common.graph.ImmutableNetwork) com.google.common.base.Preconditions.checkNotNull(immutableNetwork);
    }

    public static <N, E> com.google.common.graph.ImmutableNetwork<N, E> copyOf(com.google.common.graph.Network<N, E> network) {
        return network instanceof com.google.common.graph.ImmutableNetwork ? (com.google.common.graph.ImmutableNetwork) network : new com.google.common.graph.ImmutableNetwork<>(network);
    }

    public static <N, E> com.google.common.graph.NetworkConnections<N, E> d(com.google.common.graph.Network<N, E> network, N n) {
        if (!network.isDirected()) {
            java.util.Map asMap = com.google.common.collect.Maps.asMap(network.incidentEdges(n), c(network, n));
            return network.allowsParallelEdges() ? com.google.common.graph.UndirectedMultiNetworkConnections.q(asMap) : com.google.common.graph.UndirectedNetworkConnections.n(asMap);
        }
        java.util.Map asMap2 = com.google.common.collect.Maps.asMap(network.inEdges(n), g(network));
        java.util.Map asMap3 = com.google.common.collect.Maps.asMap(network.outEdges(n), h(network));
        int size = network.edgesConnecting(n, n).size();
        return network.allowsParallelEdges() ? com.google.common.graph.DirectedMultiNetworkConnections.q(asMap2, asMap3, size) : com.google.common.graph.DirectedNetworkConnections.o(asMap2, asMap3, size);
    }

    public static <N, E> java.util.Map<E, N> e(com.google.common.graph.Network<N, E> network) {
        com.google.common.collect.ImmutableMap.Builder builder = com.google.common.collect.ImmutableMap.builder();
        for (E e : network.edges()) {
            builder.put(e, network.incidentNodes(e).nodeU());
        }
        return builder.build();
    }

    public static <N, E> java.util.Map<N, com.google.common.graph.NetworkConnections<N, E>> f(com.google.common.graph.Network<N, E> network) {
        com.google.common.collect.ImmutableMap.Builder builder = com.google.common.collect.ImmutableMap.builder();
        for (N n : network.nodes()) {
            builder.put(n, d(network, n));
        }
        return builder.build();
    }

    public static <N, E> com.google.common.base.Function<E, N> g(com.google.common.graph.Network<N, E> network) {
        return new com.google.common.graph.ImmutableNetwork.AnonymousClass1(network);
    }

    public static <N, E> com.google.common.base.Function<E, N> h(com.google.common.graph.Network<N, E> network) {
        return new com.google.common.graph.ImmutableNetwork.AnonymousClass2(network);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ java.util.Set adjacentNodes(java.lang.Object obj) {
        return super.adjacentNodes(obj);
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsParallelEdges() {
        return super.allowsParallelEdges();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public com.google.common.graph.ImmutableGraph<N> asGraph() {
        return new com.google.common.graph.ImmutableGraph<>(super.asGraph());
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ com.google.common.graph.ElementOrder edgeOrder() {
        return super.edgeOrder();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ java.util.Set edges() {
        return super.edges();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ java.util.Set edgesConnecting(java.lang.Object obj, java.lang.Object obj2) {
        return super.edgesConnecting(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ java.util.Set inEdges(java.lang.Object obj) {
        return super.inEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ java.util.Set incidentEdges(java.lang.Object obj) {
        return super.incidentEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ com.google.common.graph.EndpointPair incidentNodes(java.lang.Object obj) {
        return super.incidentNodes(obj);
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ com.google.common.graph.ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ java.util.Set nodes() {
        return super.nodes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ java.util.Set outEdges(java.lang.Object obj) {
        return super.outEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ java.util.Set predecessors(java.lang.Object obj) {
        return super.predecessors((com.google.common.graph.ImmutableNetwork<N, E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ java.util.Set successors(java.lang.Object obj) {
        return super.successors((com.google.common.graph.ImmutableNetwork<N, E>) obj);
    }
}
