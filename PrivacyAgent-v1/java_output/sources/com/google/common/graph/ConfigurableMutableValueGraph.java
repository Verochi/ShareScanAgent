package com.google.common.graph;

/* loaded from: classes22.dex */
final class ConfigurableMutableValueGraph<N, V> extends com.google.common.graph.ConfigurableValueGraph<N, V> implements com.google.common.graph.MutableValueGraph<N, V> {
    public ConfigurableMutableValueGraph(com.google.common.graph.AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        super(abstractGraphBuilder);
    }

    @Override // com.google.common.graph.MutableValueGraph
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean addNode(N n) {
        com.google.common.base.Preconditions.checkNotNull(n, "node");
        if (containsNode(n)) {
            return false;
        }
        b(n);
        return true;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final com.google.common.graph.GraphConnections<N, V> b(N n) {
        com.google.common.graph.GraphConnections<N, V> c = c();
        com.google.common.base.Preconditions.checkState(this.nodeConnections.h(n, c) == null);
        return c;
    }

    public final com.google.common.graph.GraphConnections<N, V> c() {
        return isDirected() ? com.google.common.graph.DirectedGraphConnections.p() : com.google.common.graph.UndirectedGraphConnections.i();
    }

    @Override // com.google.common.graph.MutableValueGraph
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V putEdgeValue(com.google.common.graph.EndpointPair<N> endpointPair, V v) {
        validateEndpoints(endpointPair);
        return putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), v);
    }

    @Override // com.google.common.graph.MutableValueGraph
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V putEdgeValue(N n, N n2, V v) {
        com.google.common.base.Preconditions.checkNotNull(n, "nodeU");
        com.google.common.base.Preconditions.checkNotNull(n2, "nodeV");
        com.google.common.base.Preconditions.checkNotNull(v, "value");
        if (!allowsSelfLoops()) {
            com.google.common.base.Preconditions.checkArgument(!n.equals(n2), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n);
        }
        com.google.common.graph.GraphConnections<N, V> e = this.nodeConnections.e(n);
        if (e == null) {
            e = b(n);
        }
        V h = e.h(n2, v);
        com.google.common.graph.GraphConnections<N, V> e2 = this.nodeConnections.e(n2);
        if (e2 == null) {
            e2 = b(n2);
        }
        e2.d(n, v);
        if (h == null) {
            long j = this.edgeCount + 1;
            this.edgeCount = j;
            com.google.common.graph.Graphs.e(j);
        }
        return h;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V removeEdge(com.google.common.graph.EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableValueGraph
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V removeEdge(N n, N n2) {
        com.google.common.base.Preconditions.checkNotNull(n, "nodeU");
        com.google.common.base.Preconditions.checkNotNull(n2, "nodeV");
        com.google.common.graph.GraphConnections<N, V> e = this.nodeConnections.e(n);
        com.google.common.graph.GraphConnections<N, V> e2 = this.nodeConnections.e(n2);
        if (e == null || e2 == null) {
            return null;
        }
        V f = e.f(n2);
        if (f != null) {
            e2.g(n);
            long j = this.edgeCount - 1;
            this.edgeCount = j;
            com.google.common.graph.Graphs.c(j);
        }
        return f;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean removeNode(N n) {
        com.google.common.base.Preconditions.checkNotNull(n, "node");
        com.google.common.graph.GraphConnections<N, V> e = this.nodeConnections.e(n);
        if (e == null) {
            return false;
        }
        if (allowsSelfLoops() && e.f(n) != null) {
            e.g(n);
            this.edgeCount--;
        }
        java.util.Iterator<N> it = e.b().iterator();
        while (it.hasNext()) {
            this.nodeConnections.g(it.next()).g(n);
            this.edgeCount--;
        }
        if (isDirected()) {
            java.util.Iterator<N> it2 = e.c().iterator();
            while (it2.hasNext()) {
                com.google.common.base.Preconditions.checkState(this.nodeConnections.g(it2.next()).f(n) != null);
                this.edgeCount--;
            }
        }
        this.nodeConnections.i(n);
        com.google.common.graph.Graphs.c(this.edgeCount);
        return true;
    }
}
