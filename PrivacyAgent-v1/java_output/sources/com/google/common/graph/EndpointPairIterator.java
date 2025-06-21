package com.google.common.graph;

/* loaded from: classes22.dex */
abstract class EndpointPairIterator<N> extends com.google.common.collect.AbstractIterator<com.google.common.graph.EndpointPair<N>> {
    public final com.google.common.graph.BaseGraph<N> u;
    public final java.util.Iterator<N> v;
    public N w;
    public java.util.Iterator<N> x;

    public static final class Directed<N> extends com.google.common.graph.EndpointPairIterator<N> {
        public Directed(com.google.common.graph.BaseGraph<N> baseGraph) {
            super(baseGraph, null);
        }

        public /* synthetic */ Directed(com.google.common.graph.BaseGraph baseGraph, com.google.common.graph.EndpointPairIterator.AnonymousClass1 anonymousClass1) {
            this(baseGraph);
        }

        @Override // com.google.common.collect.AbstractIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.google.common.graph.EndpointPair<N> computeNext() {
            while (!this.x.hasNext()) {
                if (!b()) {
                    return endOfData();
                }
            }
            return com.google.common.graph.EndpointPair.ordered(this.w, this.x.next());
        }
    }

    public static final class Undirected<N> extends com.google.common.graph.EndpointPairIterator<N> {
        public java.util.Set<N> y;

        public Undirected(com.google.common.graph.BaseGraph<N> baseGraph) {
            super(baseGraph, null);
            this.y = com.google.common.collect.Sets.newHashSetWithExpectedSize(baseGraph.nodes().size());
        }

        public /* synthetic */ Undirected(com.google.common.graph.BaseGraph baseGraph, com.google.common.graph.EndpointPairIterator.AnonymousClass1 anonymousClass1) {
            this(baseGraph);
        }

        @Override // com.google.common.collect.AbstractIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.google.common.graph.EndpointPair<N> computeNext() {
            while (true) {
                if (this.x.hasNext()) {
                    N next = this.x.next();
                    if (!this.y.contains(next)) {
                        return com.google.common.graph.EndpointPair.unordered(this.w, next);
                    }
                } else {
                    this.y.add(this.w);
                    if (!b()) {
                        this.y = null;
                        return endOfData();
                    }
                }
            }
        }
    }

    public EndpointPairIterator(com.google.common.graph.BaseGraph<N> baseGraph) {
        this.w = null;
        this.x = com.google.common.collect.ImmutableSet.of().iterator();
        this.u = baseGraph;
        this.v = baseGraph.nodes().iterator();
    }

    public /* synthetic */ EndpointPairIterator(com.google.common.graph.BaseGraph baseGraph, com.google.common.graph.EndpointPairIterator.AnonymousClass1 anonymousClass1) {
        this(baseGraph);
    }

    public static <N> com.google.common.graph.EndpointPairIterator<N> c(com.google.common.graph.BaseGraph<N> baseGraph) {
        return baseGraph.isDirected() ? new com.google.common.graph.EndpointPairIterator.Directed(baseGraph, null) : new com.google.common.graph.EndpointPairIterator.Undirected(baseGraph, null);
    }

    public final boolean b() {
        com.google.common.base.Preconditions.checkState(!this.x.hasNext());
        if (!this.v.hasNext()) {
            return false;
        }
        N next = this.v.next();
        this.w = next;
        this.x = this.u.successors((com.google.common.graph.BaseGraph<N>) next).iterator();
        return true;
    }
}
