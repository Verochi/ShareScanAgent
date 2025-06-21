package com.google.common.graph;

@com.google.errorprone.annotations.Immutable(containerOf = {"N"})
@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public abstract class EndpointPair<N> implements java.lang.Iterable<N> {
    public final N n;
    public final N t;

    public static final class Ordered<N> extends com.google.common.graph.EndpointPair<N> {
        public Ordered(N n, N n2) {
            super(n, n2, null);
        }

        public /* synthetic */ Ordered(java.lang.Object obj, java.lang.Object obj2, com.google.common.graph.EndpointPair.AnonymousClass1 anonymousClass1) {
            this(obj, obj2);
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.google.common.graph.EndpointPair)) {
                return false;
            }
            com.google.common.graph.EndpointPair endpointPair = (com.google.common.graph.EndpointPair) obj;
            return isOrdered() == endpointPair.isOrdered() && source().equals(endpointPair.source()) && target().equals(endpointPair.target());
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return com.google.common.base.Objects.hashCode(source(), target());
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return true;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ java.util.Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            return nodeU();
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            return nodeV();
        }

        public java.lang.String toString() {
            return "<" + source() + " -> " + target() + ">";
        }
    }

    public static final class Unordered<N> extends com.google.common.graph.EndpointPair<N> {
        public Unordered(N n, N n2) {
            super(n, n2, null);
        }

        public /* synthetic */ Unordered(java.lang.Object obj, java.lang.Object obj2, com.google.common.graph.EndpointPair.AnonymousClass1 anonymousClass1) {
            this(obj, obj2);
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.google.common.graph.EndpointPair)) {
                return false;
            }
            com.google.common.graph.EndpointPair endpointPair = (com.google.common.graph.EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            return nodeU().equals(endpointPair.nodeU()) ? nodeV().equals(endpointPair.nodeV()) : nodeU().equals(endpointPair.nodeV()) && nodeV().equals(endpointPair.nodeU());
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return nodeU().hashCode() + nodeV().hashCode();
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return false;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ java.util.Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            throw new java.lang.UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            throw new java.lang.UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public java.lang.String toString() {
            return "[" + nodeU() + ", " + nodeV() + "]";
        }
    }

    public EndpointPair(N n, N n2) {
        this.n = (N) com.google.common.base.Preconditions.checkNotNull(n);
        this.t = (N) com.google.common.base.Preconditions.checkNotNull(n2);
    }

    public /* synthetic */ EndpointPair(java.lang.Object obj, java.lang.Object obj2, com.google.common.graph.EndpointPair.AnonymousClass1 anonymousClass1) {
        this(obj, obj2);
    }

    public static <N> com.google.common.graph.EndpointPair<N> a(com.google.common.graph.Network<?, ?> network, N n, N n2) {
        return network.isDirected() ? ordered(n, n2) : unordered(n, n2);
    }

    public static <N> com.google.common.graph.EndpointPair<N> ordered(N n, N n2) {
        return new com.google.common.graph.EndpointPair.Ordered(n, n2, null);
    }

    public static <N> com.google.common.graph.EndpointPair<N> unordered(N n, N n2) {
        return new com.google.common.graph.EndpointPair.Unordered(n2, n, null);
    }

    public final N adjacentNode(java.lang.Object obj) {
        if (obj.equals(this.n)) {
            return this.t;
        }
        if (obj.equals(this.t)) {
            return this.n;
        }
        throw new java.lang.IllegalArgumentException("EndpointPair " + this + " does not contain node " + obj);
    }

    public abstract boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    @Override // java.lang.Iterable
    public final com.google.common.collect.UnmodifiableIterator<N> iterator() {
        return com.google.common.collect.Iterators.forArray(this.n, this.t);
    }

    public final N nodeU() {
        return this.n;
    }

    public final N nodeV() {
        return this.t;
    }

    public abstract N source();

    public abstract N target();
}
