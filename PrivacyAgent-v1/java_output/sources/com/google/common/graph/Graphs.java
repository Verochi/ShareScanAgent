package com.google.common.graph;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class Graphs {

    public enum NodeVisitState {
        PENDING,
        COMPLETE
    }

    public static class TransposedGraph<N> extends com.google.common.graph.ForwardingGraph<N> {
        public final com.google.common.graph.Graph<N> a;

        public TransposedGraph(com.google.common.graph.Graph<N> graph) {
            this.a = graph;
        }

        @Override // com.google.common.graph.ForwardingGraph
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.graph.Graph<N> delegate() {
            return this.a;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(com.google.common.graph.EndpointPair<N> endpointPair) {
            return delegate().hasEdgeConnecting(com.google.common.graph.Graphs.g(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N n, N n2) {
            return delegate().hasEdgeConnecting(n2, n);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N n) {
            return delegate().outDegree(n);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N n) {
            return delegate().inDegree(n);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ java.lang.Iterable predecessors(java.lang.Object obj) {
            return predecessors((com.google.common.graph.Graphs.TransposedGraph<N>) obj);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public java.util.Set<N> predecessors(N n) {
            return delegate().successors((com.google.common.graph.Graph<N>) n);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ java.lang.Iterable successors(java.lang.Object obj) {
            return successors((com.google.common.graph.Graphs.TransposedGraph<N>) obj);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public java.util.Set<N> successors(N n) {
            return delegate().predecessors((com.google.common.graph.Graph<N>) n);
        }
    }

    public static class TransposedNetwork<N, E> extends com.google.common.graph.ForwardingNetwork<N, E> {
        public final com.google.common.graph.Network<N, E> a;

        public TransposedNetwork(com.google.common.graph.Network<N, E> network) {
            this.a = network;
        }

        @Override // com.google.common.graph.ForwardingNetwork
        public com.google.common.graph.Network<N, E> c() {
            return this.a;
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public E edgeConnectingOrNull(com.google.common.graph.EndpointPair<N> endpointPair) {
            return c().edgeConnectingOrNull(com.google.common.graph.Graphs.g(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public E edgeConnectingOrNull(N n, N n2) {
            return c().edgeConnectingOrNull(n2, n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public java.util.Set<E> edgesConnecting(com.google.common.graph.EndpointPair<N> endpointPair) {
            return c().edgesConnecting(com.google.common.graph.Graphs.g(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public java.util.Set<E> edgesConnecting(N n, N n2) {
            return c().edgesConnecting(n2, n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(com.google.common.graph.EndpointPair<N> endpointPair) {
            return c().hasEdgeConnecting(com.google.common.graph.Graphs.g(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(N n, N n2) {
            return c().hasEdgeConnecting(n2, n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int inDegree(N n) {
            return c().outDegree(n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public java.util.Set<E> inEdges(N n) {
            return c().outEdges(n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public com.google.common.graph.EndpointPair<N> incidentNodes(E e) {
            com.google.common.graph.EndpointPair<N> incidentNodes = c().incidentNodes(e);
            return com.google.common.graph.EndpointPair.a(this.a, incidentNodes.nodeV(), incidentNodes.nodeU());
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int outDegree(N n) {
            return c().inDegree(n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public java.util.Set<E> outEdges(N n) {
            return c().inEdges(n);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ java.lang.Iterable predecessors(java.lang.Object obj) {
            return predecessors((com.google.common.graph.Graphs.TransposedNetwork<N, E>) obj);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
        public java.util.Set<N> predecessors(N n) {
            return c().successors((com.google.common.graph.Network<N, E>) n);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ java.lang.Iterable successors(java.lang.Object obj) {
            return successors((com.google.common.graph.Graphs.TransposedNetwork<N, E>) obj);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
        public java.util.Set<N> successors(N n) {
            return c().predecessors((com.google.common.graph.Network<N, E>) n);
        }
    }

    public static class TransposedValueGraph<N, V> extends com.google.common.graph.ForwardingValueGraph<N, V> {
        public final com.google.common.graph.ValueGraph<N, V> a;

        public TransposedValueGraph(com.google.common.graph.ValueGraph<N, V> valueGraph) {
            this.a = valueGraph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph
        public com.google.common.graph.ValueGraph<N, V> b() {
            return this.a;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V edgeValueOrDefault(com.google.common.graph.EndpointPair<N> endpointPair, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            return b().edgeValueOrDefault(com.google.common.graph.Graphs.g(endpointPair), v);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V edgeValueOrDefault(N n, N n2, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            return b().edgeValueOrDefault(n2, n, v);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(com.google.common.graph.EndpointPair<N> endpointPair) {
            return b().hasEdgeConnecting(com.google.common.graph.Graphs.g(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N n, N n2) {
            return b().hasEdgeConnecting(n2, n);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N n) {
            return b().outDegree(n);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N n) {
            return b().inDegree(n);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ java.lang.Iterable predecessors(java.lang.Object obj) {
            return predecessors((com.google.common.graph.Graphs.TransposedValueGraph<N, V>) obj);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public java.util.Set<N> predecessors(N n) {
            return b().successors((com.google.common.graph.ValueGraph<N, V>) n);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ java.lang.Iterable successors(java.lang.Object obj) {
            return successors((com.google.common.graph.Graphs.TransposedValueGraph<N, V>) obj);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public java.util.Set<N> successors(N n) {
            return b().predecessors((com.google.common.graph.ValueGraph<N, V>) n);
        }
    }

    public static boolean a(com.google.common.graph.Graph<?> graph, java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return graph.isDirected() || !com.google.common.base.Objects.equal(obj2, obj);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static int b(int i) {
        com.google.common.base.Preconditions.checkArgument(i >= 0, "Not true that %s is non-negative.", i);
        return i;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static long c(long j) {
        com.google.common.base.Preconditions.checkArgument(j >= 0, "Not true that %s is non-negative.", j);
        return j;
    }

    public static <N> com.google.common.graph.MutableGraph<N> copyOf(com.google.common.graph.Graph<N> graph) {
        com.google.common.graph.MutableGraph<N> mutableGraph = (com.google.common.graph.MutableGraph<N>) com.google.common.graph.GraphBuilder.from(graph).expectedNodeCount(graph.nodes().size()).build();
        java.util.Iterator<N> it = graph.nodes().iterator();
        while (it.hasNext()) {
            mutableGraph.addNode(it.next());
        }
        for (com.google.common.graph.EndpointPair<N> endpointPair : graph.edges()) {
            mutableGraph.putEdge(endpointPair.nodeU(), endpointPair.nodeV());
        }
        return mutableGraph;
    }

    public static <N, E> com.google.common.graph.MutableNetwork<N, E> copyOf(com.google.common.graph.Network<N, E> network) {
        com.google.common.graph.MutableNetwork<N, E> mutableNetwork = (com.google.common.graph.MutableNetwork<N, E>) com.google.common.graph.NetworkBuilder.from(network).expectedNodeCount(network.nodes().size()).expectedEdgeCount(network.edges().size()).build();
        java.util.Iterator<N> it = network.nodes().iterator();
        while (it.hasNext()) {
            mutableNetwork.addNode(it.next());
        }
        for (E e : network.edges()) {
            com.google.common.graph.EndpointPair<N> incidentNodes = network.incidentNodes(e);
            mutableNetwork.addEdge(incidentNodes.nodeU(), incidentNodes.nodeV(), e);
        }
        return mutableNetwork;
    }

    public static <N, V> com.google.common.graph.MutableValueGraph<N, V> copyOf(com.google.common.graph.ValueGraph<N, V> valueGraph) {
        com.google.common.graph.MutableValueGraph<N, V> mutableValueGraph = (com.google.common.graph.MutableValueGraph<N, V>) com.google.common.graph.ValueGraphBuilder.from(valueGraph).expectedNodeCount(valueGraph.nodes().size()).build();
        java.util.Iterator<N> it = valueGraph.nodes().iterator();
        while (it.hasNext()) {
            mutableValueGraph.addNode(it.next());
        }
        for (com.google.common.graph.EndpointPair<N> endpointPair : valueGraph.edges()) {
            mutableValueGraph.putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), valueGraph.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null));
        }
        return mutableValueGraph;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static int d(int i) {
        com.google.common.base.Preconditions.checkArgument(i > 0, "Not true that %s is positive.", i);
        return i;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static long e(long j) {
        com.google.common.base.Preconditions.checkArgument(j > 0, "Not true that %s is positive.", j);
        return j;
    }

    public static <N> boolean f(com.google.common.graph.Graph<N> graph, java.util.Map<java.lang.Object, com.google.common.graph.Graphs.NodeVisitState> map, N n, @org.checkerframework.checker.nullness.compatqual.NullableDecl N n2) {
        com.google.common.graph.Graphs.NodeVisitState nodeVisitState = map.get(n);
        if (nodeVisitState == com.google.common.graph.Graphs.NodeVisitState.COMPLETE) {
            return false;
        }
        com.google.common.graph.Graphs.NodeVisitState nodeVisitState2 = com.google.common.graph.Graphs.NodeVisitState.PENDING;
        if (nodeVisitState == nodeVisitState2) {
            return true;
        }
        map.put(n, nodeVisitState2);
        for (N n3 : graph.successors((com.google.common.graph.Graph<N>) n)) {
            if (a(graph, n3, n2) && f(graph, map, n3, n)) {
                return true;
            }
        }
        map.put(n, com.google.common.graph.Graphs.NodeVisitState.COMPLETE);
        return false;
    }

    public static <N> com.google.common.graph.EndpointPair<N> g(com.google.common.graph.EndpointPair<N> endpointPair) {
        return endpointPair.isOrdered() ? com.google.common.graph.EndpointPair.ordered(endpointPair.target(), endpointPair.source()) : endpointPair;
    }

    public static <N> boolean hasCycle(com.google.common.graph.Graph<N> graph) {
        int size = graph.edges().size();
        if (size == 0) {
            return false;
        }
        if (!graph.isDirected() && size >= graph.nodes().size()) {
            return true;
        }
        java.util.HashMap newHashMapWithExpectedSize = com.google.common.collect.Maps.newHashMapWithExpectedSize(graph.nodes().size());
        java.util.Iterator<N> it = graph.nodes().iterator();
        while (it.hasNext()) {
            if (f(graph, newHashMapWithExpectedSize, it.next(), null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(com.google.common.graph.Network<?, ?> network) {
        if (network.isDirected() || !network.allowsParallelEdges() || network.edges().size() <= network.asGraph().edges().size()) {
            return hasCycle(network.asGraph());
        }
        return true;
    }

    public static <N> com.google.common.graph.MutableGraph<N> inducedSubgraph(com.google.common.graph.Graph<N> graph, java.lang.Iterable<? extends N> iterable) {
        com.google.common.graph.ConfigurableMutableGraph configurableMutableGraph = iterable instanceof java.util.Collection ? (com.google.common.graph.MutableGraph<N>) com.google.common.graph.GraphBuilder.from(graph).expectedNodeCount(((java.util.Collection) iterable).size()).build() : (com.google.common.graph.MutableGraph<N>) com.google.common.graph.GraphBuilder.from(graph).build();
        java.util.Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            configurableMutableGraph.addNode(it.next());
        }
        for (N n : configurableMutableGraph.nodes()) {
            for (N n2 : graph.successors((com.google.common.graph.Graph<N>) n)) {
                if (configurableMutableGraph.nodes().contains(n2)) {
                    configurableMutableGraph.putEdge(n, n2);
                }
            }
        }
        return configurableMutableGraph;
    }

    public static <N, E> com.google.common.graph.MutableNetwork<N, E> inducedSubgraph(com.google.common.graph.Network<N, E> network, java.lang.Iterable<? extends N> iterable) {
        com.google.common.graph.ConfigurableMutableNetwork configurableMutableNetwork = iterable instanceof java.util.Collection ? (com.google.common.graph.MutableNetwork<N, E>) com.google.common.graph.NetworkBuilder.from(network).expectedNodeCount(((java.util.Collection) iterable).size()).build() : (com.google.common.graph.MutableNetwork<N, E>) com.google.common.graph.NetworkBuilder.from(network).build();
        java.util.Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            configurableMutableNetwork.addNode(it.next());
        }
        for (E e : configurableMutableNetwork.nodes()) {
            for (E e2 : network.outEdges(e)) {
                N adjacentNode = network.incidentNodes(e2).adjacentNode(e);
                if (configurableMutableNetwork.nodes().contains(adjacentNode)) {
                    configurableMutableNetwork.addEdge(e, adjacentNode, e2);
                }
            }
        }
        return configurableMutableNetwork;
    }

    public static <N, V> com.google.common.graph.MutableValueGraph<N, V> inducedSubgraph(com.google.common.graph.ValueGraph<N, V> valueGraph, java.lang.Iterable<? extends N> iterable) {
        com.google.common.graph.ConfigurableMutableValueGraph configurableMutableValueGraph = iterable instanceof java.util.Collection ? (com.google.common.graph.MutableValueGraph<N, V>) com.google.common.graph.ValueGraphBuilder.from(valueGraph).expectedNodeCount(((java.util.Collection) iterable).size()).build() : (com.google.common.graph.MutableValueGraph<N, V>) com.google.common.graph.ValueGraphBuilder.from(valueGraph).build();
        java.util.Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            configurableMutableValueGraph.addNode(it.next());
        }
        for (N n : configurableMutableValueGraph.nodes()) {
            for (N n2 : valueGraph.successors((com.google.common.graph.ValueGraph<N, V>) n)) {
                if (configurableMutableValueGraph.nodes().contains(n2)) {
                    configurableMutableValueGraph.putEdgeValue(n, n2, valueGraph.edgeValueOrDefault(n, n2, null));
                }
            }
        }
        return configurableMutableValueGraph;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> java.util.Set<N> reachableNodes(com.google.common.graph.Graph<N> graph, N n) {
        com.google.common.base.Preconditions.checkArgument(graph.nodes().contains(n), "Node %s is not an element of this graph.", n);
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        linkedHashSet.add(n);
        arrayDeque.add(n);
        while (!arrayDeque.isEmpty()) {
            for (java.lang.Object obj : graph.successors((com.google.common.graph.Graph<N>) arrayDeque.remove())) {
                if (linkedHashSet.add(obj)) {
                    arrayDeque.add(obj);
                }
            }
        }
        return java.util.Collections.unmodifiableSet(linkedHashSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> com.google.common.graph.Graph<N> transitiveClosure(com.google.common.graph.Graph<N> graph) {
        com.google.common.graph.ConfigurableMutableGraph build = com.google.common.graph.GraphBuilder.from(graph).allowsSelfLoops(true).build();
        if (graph.isDirected()) {
            for (N n : graph.nodes()) {
                java.util.Iterator it = reachableNodes(graph, n).iterator();
                while (it.hasNext()) {
                    build.putEdge(n, it.next());
                }
            }
        } else {
            java.util.HashSet hashSet = new java.util.HashSet();
            for (N n2 : graph.nodes()) {
                if (!hashSet.contains(n2)) {
                    java.util.Set reachableNodes = reachableNodes(graph, n2);
                    hashSet.addAll(reachableNodes);
                    int i = 1;
                    for (java.lang.Object obj : reachableNodes) {
                        int i2 = i + 1;
                        java.util.Iterator it2 = com.google.common.collect.Iterables.limit(reachableNodes, i).iterator();
                        while (it2.hasNext()) {
                            build.putEdge(obj, it2.next());
                        }
                        i = i2;
                    }
                }
            }
        }
        return build;
    }

    public static <N> com.google.common.graph.Graph<N> transpose(com.google.common.graph.Graph<N> graph) {
        return !graph.isDirected() ? graph : graph instanceof com.google.common.graph.Graphs.TransposedGraph ? ((com.google.common.graph.Graphs.TransposedGraph) graph).a : new com.google.common.graph.Graphs.TransposedGraph(graph);
    }

    public static <N, E> com.google.common.graph.Network<N, E> transpose(com.google.common.graph.Network<N, E> network) {
        return !network.isDirected() ? network : network instanceof com.google.common.graph.Graphs.TransposedNetwork ? ((com.google.common.graph.Graphs.TransposedNetwork) network).a : new com.google.common.graph.Graphs.TransposedNetwork(network);
    }

    public static <N, V> com.google.common.graph.ValueGraph<N, V> transpose(com.google.common.graph.ValueGraph<N, V> valueGraph) {
        return !valueGraph.isDirected() ? valueGraph : valueGraph instanceof com.google.common.graph.Graphs.TransposedValueGraph ? ((com.google.common.graph.Graphs.TransposedValueGraph) valueGraph).a : new com.google.common.graph.Graphs.TransposedValueGraph(valueGraph);
    }
}
