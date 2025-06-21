package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class Cut<C extends java.lang.Comparable> implements java.lang.Comparable<com.google.common.collect.Cut<C>>, java.io.Serializable {
    private static final long serialVersionUID = 0;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    final C endpoint;

    /* renamed from: com.google.common.collect.Cut$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.common.collect.BoundType.values().length];
            a = iArr;
            try {
                iArr[com.google.common.collect.BoundType.CLOSED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.google.common.collect.BoundType.OPEN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public static final class AboveAll extends com.google.common.collect.Cut<java.lang.Comparable<?>> {
        private static final com.google.common.collect.Cut.AboveAll INSTANCE = new com.google.common.collect.Cut.AboveAll();
        private static final long serialVersionUID = 0;

        private AboveAll() {
            super(null);
        }

        private java.lang.Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public int compareTo(com.google.common.collect.Cut<java.lang.Comparable<?>> cut) {
            return cut == this ? 0 : 1;
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(java.lang.StringBuilder sb) {
            throw new java.lang.AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(java.lang.StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // com.google.common.collect.Cut
        public java.lang.Comparable<?> endpoint() {
            throw new java.lang.IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        public java.lang.Comparable<?> greatestValueBelow(com.google.common.collect.DiscreteDomain<java.lang.Comparable<?>> discreteDomain) {
            return discreteDomain.maxValue();
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return java.lang.System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(java.lang.Comparable<?> comparable) {
            return false;
        }

        @Override // com.google.common.collect.Cut
        public java.lang.Comparable<?> leastValueAbove(com.google.common.collect.DiscreteDomain<java.lang.Comparable<?>> discreteDomain) {
            throw new java.lang.AssertionError();
        }

        public java.lang.String toString() {
            return "+∞";
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.BoundType typeAsLowerBound() {
            throw new java.lang.AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.BoundType typeAsUpperBound() {
            throw new java.lang.IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.Cut<java.lang.Comparable<?>> withLowerBoundType(com.google.common.collect.BoundType boundType, com.google.common.collect.DiscreteDomain<java.lang.Comparable<?>> discreteDomain) {
            throw new java.lang.AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.Cut<java.lang.Comparable<?>> withUpperBoundType(com.google.common.collect.BoundType boundType, com.google.common.collect.DiscreteDomain<java.lang.Comparable<?>> discreteDomain) {
            throw new java.lang.IllegalStateException();
        }
    }

    public static final class AboveValue<C extends java.lang.Comparable> extends com.google.common.collect.Cut<C> {
        private static final long serialVersionUID = 0;

        public AboveValue(C c) {
            super((java.lang.Comparable) com.google.common.base.Preconditions.checkNotNull(c));
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.Cut<C> canonical(com.google.common.collect.DiscreteDomain<C> discreteDomain) {
            C leastValueAbove = leastValueAbove(discreteDomain);
            return leastValueAbove != null ? com.google.common.collect.Cut.belowValue(leastValueAbove) : com.google.common.collect.Cut.aboveAll();
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(java.lang.Object obj) {
            return super.compareTo((com.google.common.collect.Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(java.lang.StringBuilder sb) {
            sb.append('(');
            sb.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(java.lang.StringBuilder sb) {
            sb.append(this.endpoint);
            sb.append(']');
        }

        @Override // com.google.common.collect.Cut
        public C greatestValueBelow(com.google.common.collect.DiscreteDomain<C> discreteDomain) {
            return this.endpoint;
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(C c) {
            return com.google.common.collect.Range.compareOrThrow(this.endpoint, c) < 0;
        }

        @Override // com.google.common.collect.Cut
        public C leastValueAbove(com.google.common.collect.DiscreteDomain<C> discreteDomain) {
            return discreteDomain.next(this.endpoint);
        }

        public java.lang.String toString() {
            return net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + this.endpoint + "\\";
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.BoundType typeAsLowerBound() {
            return com.google.common.collect.BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.BoundType typeAsUpperBound() {
            return com.google.common.collect.BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.Cut<C> withLowerBoundType(com.google.common.collect.BoundType boundType, com.google.common.collect.DiscreteDomain<C> discreteDomain) {
            int i = com.google.common.collect.Cut.AnonymousClass1.a[boundType.ordinal()];
            if (i == 1) {
                C next = discreteDomain.next(this.endpoint);
                return next == null ? com.google.common.collect.Cut.belowAll() : com.google.common.collect.Cut.belowValue(next);
            }
            if (i == 2) {
                return this;
            }
            throw new java.lang.AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.Cut<C> withUpperBoundType(com.google.common.collect.BoundType boundType, com.google.common.collect.DiscreteDomain<C> discreteDomain) {
            int i = com.google.common.collect.Cut.AnonymousClass1.a[boundType.ordinal()];
            if (i == 1) {
                return this;
            }
            if (i != 2) {
                throw new java.lang.AssertionError();
            }
            C next = discreteDomain.next(this.endpoint);
            return next == null ? com.google.common.collect.Cut.aboveAll() : com.google.common.collect.Cut.belowValue(next);
        }
    }

    public static final class BelowAll extends com.google.common.collect.Cut<java.lang.Comparable<?>> {
        private static final com.google.common.collect.Cut.BelowAll INSTANCE = new com.google.common.collect.Cut.BelowAll();
        private static final long serialVersionUID = 0;

        private BelowAll() {
            super(null);
        }

        private java.lang.Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.Cut<java.lang.Comparable<?>> canonical(com.google.common.collect.DiscreteDomain<java.lang.Comparable<?>> discreteDomain) {
            try {
                return com.google.common.collect.Cut.belowValue(discreteDomain.minValue());
            } catch (java.util.NoSuchElementException unused) {
                return this;
            }
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public int compareTo(com.google.common.collect.Cut<java.lang.Comparable<?>> cut) {
            return cut == this ? 0 : -1;
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(java.lang.StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(java.lang.StringBuilder sb) {
            throw new java.lang.AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public java.lang.Comparable<?> endpoint() {
            throw new java.lang.IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        public java.lang.Comparable<?> greatestValueBelow(com.google.common.collect.DiscreteDomain<java.lang.Comparable<?>> discreteDomain) {
            throw new java.lang.AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return java.lang.System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(java.lang.Comparable<?> comparable) {
            return true;
        }

        @Override // com.google.common.collect.Cut
        public java.lang.Comparable<?> leastValueAbove(com.google.common.collect.DiscreteDomain<java.lang.Comparable<?>> discreteDomain) {
            return discreteDomain.minValue();
        }

        public java.lang.String toString() {
            return "-∞";
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.BoundType typeAsLowerBound() {
            throw new java.lang.IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.BoundType typeAsUpperBound() {
            throw new java.lang.AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.Cut<java.lang.Comparable<?>> withLowerBoundType(com.google.common.collect.BoundType boundType, com.google.common.collect.DiscreteDomain<java.lang.Comparable<?>> discreteDomain) {
            throw new java.lang.IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.Cut<java.lang.Comparable<?>> withUpperBoundType(com.google.common.collect.BoundType boundType, com.google.common.collect.DiscreteDomain<java.lang.Comparable<?>> discreteDomain) {
            throw new java.lang.AssertionError("this statement should be unreachable");
        }
    }

    public static final class BelowValue<C extends java.lang.Comparable> extends com.google.common.collect.Cut<C> {
        private static final long serialVersionUID = 0;

        public BelowValue(C c) {
            super((java.lang.Comparable) com.google.common.base.Preconditions.checkNotNull(c));
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(java.lang.Object obj) {
            return super.compareTo((com.google.common.collect.Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(java.lang.StringBuilder sb) {
            sb.append('[');
            sb.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(java.lang.StringBuilder sb) {
            sb.append(this.endpoint);
            sb.append(')');
        }

        @Override // com.google.common.collect.Cut
        public C greatestValueBelow(com.google.common.collect.DiscreteDomain<C> discreteDomain) {
            return discreteDomain.previous(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(C c) {
            return com.google.common.collect.Range.compareOrThrow(this.endpoint, c) <= 0;
        }

        @Override // com.google.common.collect.Cut
        public C leastValueAbove(com.google.common.collect.DiscreteDomain<C> discreteDomain) {
            return this.endpoint;
        }

        public java.lang.String toString() {
            return "\\" + this.endpoint + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.BoundType typeAsLowerBound() {
            return com.google.common.collect.BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.BoundType typeAsUpperBound() {
            return com.google.common.collect.BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.Cut<C> withLowerBoundType(com.google.common.collect.BoundType boundType, com.google.common.collect.DiscreteDomain<C> discreteDomain) {
            int i = com.google.common.collect.Cut.AnonymousClass1.a[boundType.ordinal()];
            if (i == 1) {
                return this;
            }
            if (i != 2) {
                throw new java.lang.AssertionError();
            }
            C previous = discreteDomain.previous(this.endpoint);
            return previous == null ? com.google.common.collect.Cut.belowAll() : new com.google.common.collect.Cut.AboveValue(previous);
        }

        @Override // com.google.common.collect.Cut
        public com.google.common.collect.Cut<C> withUpperBoundType(com.google.common.collect.BoundType boundType, com.google.common.collect.DiscreteDomain<C> discreteDomain) {
            int i = com.google.common.collect.Cut.AnonymousClass1.a[boundType.ordinal()];
            if (i == 1) {
                C previous = discreteDomain.previous(this.endpoint);
                return previous == null ? com.google.common.collect.Cut.aboveAll() : new com.google.common.collect.Cut.AboveValue(previous);
            }
            if (i == 2) {
                return this;
            }
            throw new java.lang.AssertionError();
        }
    }

    public Cut(@org.checkerframework.checker.nullness.compatqual.NullableDecl C c) {
        this.endpoint = c;
    }

    public static <C extends java.lang.Comparable> com.google.common.collect.Cut<C> aboveAll() {
        return com.google.common.collect.Cut.AboveAll.INSTANCE;
    }

    public static <C extends java.lang.Comparable> com.google.common.collect.Cut<C> aboveValue(C c) {
        return new com.google.common.collect.Cut.AboveValue(c);
    }

    public static <C extends java.lang.Comparable> com.google.common.collect.Cut<C> belowAll() {
        return com.google.common.collect.Cut.BelowAll.INSTANCE;
    }

    public static <C extends java.lang.Comparable> com.google.common.collect.Cut<C> belowValue(C c) {
        return new com.google.common.collect.Cut.BelowValue(c);
    }

    public com.google.common.collect.Cut<C> canonical(com.google.common.collect.DiscreteDomain<C> discreteDomain) {
        return this;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.common.collect.Cut<C> cut) {
        if (cut == belowAll()) {
            return 1;
        }
        if (cut == aboveAll()) {
            return -1;
        }
        int compareOrThrow = com.google.common.collect.Range.compareOrThrow(this.endpoint, cut.endpoint);
        return compareOrThrow != 0 ? compareOrThrow : com.google.common.primitives.Booleans.compare(this instanceof com.google.common.collect.Cut.AboveValue, cut instanceof com.google.common.collect.Cut.AboveValue);
    }

    public abstract void describeAsLowerBound(java.lang.StringBuilder sb);

    public abstract void describeAsUpperBound(java.lang.StringBuilder sb);

    public C endpoint() {
        return this.endpoint;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.google.common.collect.Cut)) {
            return false;
        }
        try {
            return compareTo((com.google.common.collect.Cut) obj) == 0;
        } catch (java.lang.ClassCastException unused) {
            return false;
        }
    }

    public abstract C greatestValueBelow(com.google.common.collect.DiscreteDomain<C> discreteDomain);

    public abstract int hashCode();

    public abstract boolean isLessThan(C c);

    public abstract C leastValueAbove(com.google.common.collect.DiscreteDomain<C> discreteDomain);

    public abstract com.google.common.collect.BoundType typeAsLowerBound();

    public abstract com.google.common.collect.BoundType typeAsUpperBound();

    public abstract com.google.common.collect.Cut<C> withLowerBoundType(com.google.common.collect.BoundType boundType, com.google.common.collect.DiscreteDomain<C> discreteDomain);

    public abstract com.google.common.collect.Cut<C> withUpperBoundType(com.google.common.collect.BoundType boundType, com.google.common.collect.DiscreteDomain<C> discreteDomain);
}
