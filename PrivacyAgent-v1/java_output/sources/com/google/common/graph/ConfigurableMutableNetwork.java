package com.google.common.graph;

/* loaded from: classes22.dex */
final class ConfigurableMutableNetwork<N, E> extends com.google.common.graph.ConfigurableNetwork<N, E> implements com.google.common.graph.MutableNetwork<N, E> {
    public ConfigurableMutableNetwork(com.google.common.graph.NetworkBuilder<? super N, ? super E> networkBuilder) {
        super(networkBuilder);
    }

    @Override // com.google.common.graph.MutableNetwork
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean addEdge(com.google.common.graph.EndpointPair<N> endpointPair, E e) {
        validateEndpoints(endpointPair);
        return addEdge(endpointPair.nodeU(), endpointPair.nodeV(), e);
    }

    @Override // com.google.common.graph.MutableNetwork
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean addEdge(N n, N n2, E e) {
        com.google.common.base.Preconditions.checkNotNull(n, "nodeU");
        com.google.common.base.Preconditions.checkNotNull(n2, "nodeV");
        com.google.common.base.Preconditions.checkNotNull(e, "edge");
        if (containsEdge(e)) {
            com.google.common.graph.EndpointPair<N> incidentNodes = incidentNodes(e);
            com.google.common.graph.EndpointPair a = com.google.common.graph.EndpointPair.a(this, n, n2);
            com.google.common.base.Preconditions.checkArgument(incidentNodes.equals(a), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", e, incidentNodes, a);
            return false;
        }
        com.google.common.graph.NetworkConnections<N, E> e2 = this.nodeConnections.e(n);
        if (!allowsParallelEdges()) {
            com.google.common.base.Preconditions.checkArgument(e2 == null || !e2.b().contains(n2), "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", n, n2);
        }
        boolean equals = n.equals(n2);
        if (!allowsSelfLoops()) {
            com.google.common.base.Preconditions.checkArgument(!equals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n);
        }
        if (e2 == null) {
            e2 = c(n);
        }
        e2.i(e, n2);
        com.google.common.graph.NetworkConnections<N, E> e3 = this.nodeConnections.e(n2);
        if (e3 == null) {
            e3 = c(n2);
        }
        e3.j(e, n, equals);
        this.edgeToReferenceNode.h(e, n);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean addNode(N n) {
        com.google.common.base.Preconditions.checkNotNull(n, "node");
        if (containsNode(n)) {
            return false;
        }
        c(n);
        return true;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final com.google.common.graph.NetworkConnections<N, E> c(N n) {
        com.google.common.graph.NetworkConnections<N, E> d = d();
        com.google.common.base.Preconditions.checkState(this.nodeConnections.h(n, d) == null);
        return d;
    }

    public final com.google.common.graph.NetworkConnections<N, E> d() {
        return isDirected() ? allowsParallelEdges() ? com.google.common.graph.DirectedMultiNetworkConnections.p() : com.google.common.graph.DirectedNetworkConnections.n() : allowsParallelEdges() ? com.google.common.graph.UndirectedMultiNetworkConnections.p() : com.google.common.graph.UndirectedNetworkConnections.m();
    }

    @Override // com.google.common.graph.MutableNetwork
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean removeEdge(E e) {
        com.google.common.base.Preconditions.checkNotNull(e, "edge");
        N e2 = this.edgeToReferenceNode.e(e);
        boolean z = false;
        if (e2 == null) {
            return false;
        }
        com.google.common.graph.NetworkConnections<N, E> e3 = this.nodeConnections.e(e2);
        N d = e3.d(e);
        com.google.common.graph.NetworkConnections<N, E> e4 = this.nodeConnections.e(d);
        e3.f(e);
        if (allowsSelfLoops() && e2.equals(d)) {
            z = true;
        }
        e4.h(e, z);
        this.edgeToReferenceNode.i(e);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean removeNode(N n) {
        com.google.common.base.Preconditions.checkNotNull(n, "node");
        com.google.common.graph.NetworkConnections<N, E> e = this.nodeConnections.e(n);
        if (e == null) {
            return false;
        }
        com.google.common.collect.UnmodifiableIterator<E> it = com.google.common.collect.ImmutableList.copyOf((java.util.Collection) e.k()).iterator();
        while (it.hasNext()) {
            removeEdge(it.next());
        }
        this.nodeConnections.i(n);
        return true;
    }
}
