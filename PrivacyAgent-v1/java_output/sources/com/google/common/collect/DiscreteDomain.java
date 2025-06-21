package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class DiscreteDomain<C extends java.lang.Comparable> {
    final boolean supportsFastOffset;

    public static final class BigIntegerDomain extends com.google.common.collect.DiscreteDomain<java.math.BigInteger> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private static final com.google.common.collect.DiscreteDomain.BigIntegerDomain INSTANCE = new com.google.common.collect.DiscreteDomain.BigIntegerDomain();
        private static final java.math.BigInteger MIN_LONG = java.math.BigInteger.valueOf(Long.MIN_VALUE);
        private static final java.math.BigInteger MAX_LONG = java.math.BigInteger.valueOf(Long.MAX_VALUE);

        public BigIntegerDomain() {
            super(true, null);
        }

        private java.lang.Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public long distance(java.math.BigInteger bigInteger, java.math.BigInteger bigInteger2) {
            return bigInteger2.subtract(bigInteger).max(MIN_LONG).min(MAX_LONG).longValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public java.math.BigInteger next(java.math.BigInteger bigInteger) {
            return bigInteger.add(java.math.BigInteger.ONE);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public java.math.BigInteger offset(java.math.BigInteger bigInteger, long j) {
            com.google.common.collect.CollectPreconditions.c(j, "distance");
            return bigInteger.add(java.math.BigInteger.valueOf(j));
        }

        @Override // com.google.common.collect.DiscreteDomain
        public java.math.BigInteger previous(java.math.BigInteger bigInteger) {
            return bigInteger.subtract(java.math.BigInteger.ONE);
        }

        public java.lang.String toString() {
            return "DiscreteDomain.bigIntegers()";
        }
    }

    public static final class IntegerDomain extends com.google.common.collect.DiscreteDomain<java.lang.Integer> implements java.io.Serializable {
        private static final com.google.common.collect.DiscreteDomain.IntegerDomain INSTANCE = new com.google.common.collect.DiscreteDomain.IntegerDomain();
        private static final long serialVersionUID = 0;

        public IntegerDomain() {
            super(true, null);
        }

        private java.lang.Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public long distance(java.lang.Integer num, java.lang.Integer num2) {
            return num2.intValue() - num.intValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public java.lang.Integer maxValue() {
            return Integer.MAX_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public java.lang.Integer minValue() {
            return Integer.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public java.lang.Integer next(java.lang.Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MAX_VALUE) {
                return null;
            }
            return java.lang.Integer.valueOf(intValue + 1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public java.lang.Integer offset(java.lang.Integer num, long j) {
            com.google.common.collect.CollectPreconditions.c(j, "distance");
            return java.lang.Integer.valueOf(com.google.common.primitives.Ints.checkedCast(num.longValue() + j));
        }

        @Override // com.google.common.collect.DiscreteDomain
        public java.lang.Integer previous(java.lang.Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MIN_VALUE) {
                return null;
            }
            return java.lang.Integer.valueOf(intValue - 1);
        }

        public java.lang.String toString() {
            return "DiscreteDomain.integers()";
        }
    }

    public static final class LongDomain extends com.google.common.collect.DiscreteDomain<java.lang.Long> implements java.io.Serializable {
        private static final com.google.common.collect.DiscreteDomain.LongDomain INSTANCE = new com.google.common.collect.DiscreteDomain.LongDomain();
        private static final long serialVersionUID = 0;

        public LongDomain() {
            super(true, null);
        }

        private java.lang.Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public long distance(java.lang.Long l, java.lang.Long l2) {
            long longValue = l2.longValue() - l.longValue();
            if (l2.longValue() > l.longValue() && longValue < 0) {
                return Long.MAX_VALUE;
            }
            if (l2.longValue() >= l.longValue() || longValue <= 0) {
                return longValue;
            }
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public java.lang.Long maxValue() {
            return Long.MAX_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public java.lang.Long minValue() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public java.lang.Long next(java.lang.Long l) {
            long longValue = l.longValue();
            if (longValue == Long.MAX_VALUE) {
                return null;
            }
            return java.lang.Long.valueOf(longValue + 1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public java.lang.Long offset(java.lang.Long l, long j) {
            com.google.common.collect.CollectPreconditions.c(j, "distance");
            long longValue = l.longValue() + j;
            if (longValue < 0) {
                com.google.common.base.Preconditions.checkArgument(l.longValue() < 0, "overflow");
            }
            return java.lang.Long.valueOf(longValue);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public java.lang.Long previous(java.lang.Long l) {
            long longValue = l.longValue();
            if (longValue == Long.MIN_VALUE) {
                return null;
            }
            return java.lang.Long.valueOf(longValue - 1);
        }

        public java.lang.String toString() {
            return "DiscreteDomain.longs()";
        }
    }

    public DiscreteDomain() {
        this(false);
    }

    private DiscreteDomain(boolean z) {
        this.supportsFastOffset = z;
    }

    public /* synthetic */ DiscreteDomain(boolean z, com.google.common.collect.DiscreteDomain.AnonymousClass1 anonymousClass1) {
        this(z);
    }

    public static com.google.common.collect.DiscreteDomain<java.math.BigInteger> bigIntegers() {
        return com.google.common.collect.DiscreteDomain.BigIntegerDomain.INSTANCE;
    }

    public static com.google.common.collect.DiscreteDomain<java.lang.Integer> integers() {
        return com.google.common.collect.DiscreteDomain.IntegerDomain.INSTANCE;
    }

    public static com.google.common.collect.DiscreteDomain<java.lang.Long> longs() {
        return com.google.common.collect.DiscreteDomain.LongDomain.INSTANCE;
    }

    public abstract long distance(C c, C c2);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public C maxValue() {
        throw new java.util.NoSuchElementException();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public C minValue() {
        throw new java.util.NoSuchElementException();
    }

    public abstract C next(C c);

    public C offset(C c, long j) {
        com.google.common.collect.CollectPreconditions.c(j, "distance");
        for (long j2 = 0; j2 < j; j2++) {
            c = next(c);
        }
        return c;
    }

    public abstract C previous(C c);
}
