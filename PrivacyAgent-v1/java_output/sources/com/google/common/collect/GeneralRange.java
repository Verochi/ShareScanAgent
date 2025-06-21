package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
final class GeneralRange<T> implements java.io.Serializable {
    private final java.util.Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final com.google.common.collect.BoundType lowerBoundType;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    private final T lowerEndpoint;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.collect.GeneralRange<T> reverse;
    private final com.google.common.collect.BoundType upperBoundType;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    private final T upperEndpoint;

    /* JADX WARN: Multi-variable type inference failed */
    private GeneralRange(java.util.Comparator<? super T> comparator, boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t, com.google.common.collect.BoundType boundType, boolean z2, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t2, com.google.common.collect.BoundType boundType2) {
        this.comparator = (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator);
        this.hasLowerBound = z;
        this.hasUpperBound = z2;
        this.lowerEndpoint = t;
        this.lowerBoundType = (com.google.common.collect.BoundType) com.google.common.base.Preconditions.checkNotNull(boundType);
        this.upperEndpoint = t2;
        this.upperBoundType = (com.google.common.collect.BoundType) com.google.common.base.Preconditions.checkNotNull(boundType2);
        if (z) {
            comparator.compare(t, t);
        }
        if (z2) {
            comparator.compare(t2, t2);
        }
        if (z && z2) {
            int compare = comparator.compare(t, t2);
            com.google.common.base.Preconditions.checkArgument(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (compare == 0) {
                com.google.common.collect.BoundType boundType3 = com.google.common.collect.BoundType.OPEN;
                com.google.common.base.Preconditions.checkArgument((boundType != boundType3) | (boundType2 != boundType3));
            }
        }
    }

    public static <T> com.google.common.collect.GeneralRange<T> all(java.util.Comparator<? super T> comparator) {
        com.google.common.collect.BoundType boundType = com.google.common.collect.BoundType.OPEN;
        return new com.google.common.collect.GeneralRange<>(comparator, false, null, boundType, false, null, boundType);
    }

    public static <T> com.google.common.collect.GeneralRange<T> downTo(java.util.Comparator<? super T> comparator, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t, com.google.common.collect.BoundType boundType) {
        return new com.google.common.collect.GeneralRange<>(comparator, true, t, boundType, false, null, com.google.common.collect.BoundType.OPEN);
    }

    public static <T extends java.lang.Comparable> com.google.common.collect.GeneralRange<T> from(com.google.common.collect.Range<T> range) {
        return new com.google.common.collect.GeneralRange<>(com.google.common.collect.Ordering.natural(), range.hasLowerBound(), range.hasLowerBound() ? range.lowerEndpoint() : null, range.hasLowerBound() ? range.lowerBoundType() : com.google.common.collect.BoundType.OPEN, range.hasUpperBound(), range.hasUpperBound() ? range.upperEndpoint() : null, range.hasUpperBound() ? range.upperBoundType() : com.google.common.collect.BoundType.OPEN);
    }

    public static <T> com.google.common.collect.GeneralRange<T> range(java.util.Comparator<? super T> comparator, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t, com.google.common.collect.BoundType boundType, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t2, com.google.common.collect.BoundType boundType2) {
        return new com.google.common.collect.GeneralRange<>(comparator, true, t, boundType, true, t2, boundType2);
    }

    public static <T> com.google.common.collect.GeneralRange<T> upTo(java.util.Comparator<? super T> comparator, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t, com.google.common.collect.BoundType boundType) {
        return new com.google.common.collect.GeneralRange<>(comparator, false, null, com.google.common.collect.BoundType.OPEN, true, t, boundType);
    }

    public java.util.Comparator<? super T> comparator() {
        return this.comparator;
    }

    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return (tooLow(t) || tooHigh(t)) ? false : true;
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!(obj instanceof com.google.common.collect.GeneralRange)) {
            return false;
        }
        com.google.common.collect.GeneralRange generalRange = (com.google.common.collect.GeneralRange) obj;
        return this.comparator.equals(generalRange.comparator) && this.hasLowerBound == generalRange.hasLowerBound && this.hasUpperBound == generalRange.hasUpperBound && getLowerBoundType().equals(generalRange.getLowerBoundType()) && getUpperBoundType().equals(generalRange.getUpperBoundType()) && com.google.common.base.Objects.equal(getLowerEndpoint(), generalRange.getLowerEndpoint()) && com.google.common.base.Objects.equal(getUpperEndpoint(), generalRange.getUpperEndpoint());
    }

    public com.google.common.collect.BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    public T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    public com.google.common.collect.BoundType getUpperBoundType() {
        return this.upperBoundType;
    }

    public T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    public int hashCode() {
        return com.google.common.base.Objects.hashCode(this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType());
    }

    public com.google.common.collect.GeneralRange<T> intersect(com.google.common.collect.GeneralRange<T> generalRange) {
        int compare;
        int compare2;
        T t;
        com.google.common.collect.BoundType boundType;
        com.google.common.collect.BoundType boundType2;
        int compare3;
        com.google.common.collect.BoundType boundType3;
        com.google.common.base.Preconditions.checkNotNull(generalRange);
        com.google.common.base.Preconditions.checkArgument(this.comparator.equals(generalRange.comparator));
        boolean z = this.hasLowerBound;
        T lowerEndpoint = getLowerEndpoint();
        com.google.common.collect.BoundType lowerBoundType = getLowerBoundType();
        if (!hasLowerBound()) {
            z = generalRange.hasLowerBound;
            lowerEndpoint = generalRange.getLowerEndpoint();
            lowerBoundType = generalRange.getLowerBoundType();
        } else if (generalRange.hasLowerBound() && ((compare = this.comparator.compare(getLowerEndpoint(), generalRange.getLowerEndpoint())) < 0 || (compare == 0 && generalRange.getLowerBoundType() == com.google.common.collect.BoundType.OPEN))) {
            lowerEndpoint = generalRange.getLowerEndpoint();
            lowerBoundType = generalRange.getLowerBoundType();
        }
        boolean z2 = z;
        boolean z3 = this.hasUpperBound;
        T upperEndpoint = getUpperEndpoint();
        com.google.common.collect.BoundType upperBoundType = getUpperBoundType();
        if (!hasUpperBound()) {
            z3 = generalRange.hasUpperBound;
            upperEndpoint = generalRange.getUpperEndpoint();
            upperBoundType = generalRange.getUpperBoundType();
        } else if (generalRange.hasUpperBound() && ((compare2 = this.comparator.compare(getUpperEndpoint(), generalRange.getUpperEndpoint())) > 0 || (compare2 == 0 && generalRange.getUpperBoundType() == com.google.common.collect.BoundType.OPEN))) {
            upperEndpoint = generalRange.getUpperEndpoint();
            upperBoundType = generalRange.getUpperBoundType();
        }
        boolean z4 = z3;
        T t2 = upperEndpoint;
        if (z2 && z4 && ((compare3 = this.comparator.compare(lowerEndpoint, t2)) > 0 || (compare3 == 0 && lowerBoundType == (boundType3 = com.google.common.collect.BoundType.OPEN) && upperBoundType == boundType3))) {
            boundType = com.google.common.collect.BoundType.OPEN;
            boundType2 = com.google.common.collect.BoundType.CLOSED;
            t = t2;
        } else {
            t = lowerEndpoint;
            boundType = lowerBoundType;
            boundType2 = upperBoundType;
        }
        return new com.google.common.collect.GeneralRange<>(this.comparator, z2, t, boundType, z4, t2, boundType2);
    }

    public boolean isEmpty() {
        return (hasUpperBound() && tooLow(getUpperEndpoint())) || (hasLowerBound() && tooHigh(getLowerEndpoint()));
    }

    public com.google.common.collect.GeneralRange<T> reverse() {
        com.google.common.collect.GeneralRange<T> generalRange = this.reverse;
        if (generalRange != null) {
            return generalRange;
        }
        com.google.common.collect.GeneralRange<T> generalRange2 = new com.google.common.collect.GeneralRange<>(com.google.common.collect.Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        generalRange2.reverse = this;
        this.reverse = generalRange2;
        return generalRange2;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.comparator);
        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        com.google.common.collect.BoundType boundType = this.lowerBoundType;
        com.google.common.collect.BoundType boundType2 = com.google.common.collect.BoundType.CLOSED;
        sb.append(boundType == boundType2 ? '[' : '(');
        sb.append(this.hasLowerBound ? this.lowerEndpoint : "-∞");
        sb.append(',');
        sb.append(this.hasUpperBound ? this.upperEndpoint : "∞");
        sb.append(this.upperBoundType == boundType2 ? ']' : ')');
        return sb.toString();
    }

    public boolean tooHigh(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        if (!hasUpperBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getUpperEndpoint());
        return ((compare == 0) & (getUpperBoundType() == com.google.common.collect.BoundType.OPEN)) | (compare > 0);
    }

    public boolean tooLow(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        if (!hasLowerBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getLowerEndpoint());
        return ((compare == 0) & (getLowerBoundType() == com.google.common.collect.BoundType.OPEN)) | (compare < 0);
    }
}
