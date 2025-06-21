package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class MapMaker {
    public boolean a;
    public int b = -1;
    public int c = -1;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public com.google.common.collect.MapMakerInternalMap.Strength d;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public com.google.common.collect.MapMakerInternalMap.Strength e;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public com.google.common.base.Equivalence<java.lang.Object> f;

    public enum Dummy {
        VALUE
    }

    public int a() {
        int i = this.c;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public int b() {
        int i = this.b;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public com.google.common.base.Equivalence<java.lang.Object> c() {
        return (com.google.common.base.Equivalence) com.google.common.base.MoreObjects.firstNonNull(this.f, d().defaultEquivalence());
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public com.google.common.collect.MapMaker concurrencyLevel(int i) {
        int i2 = this.c;
        com.google.common.base.Preconditions.checkState(i2 == -1, "concurrency level was already set to %s", i2);
        com.google.common.base.Preconditions.checkArgument(i > 0);
        this.c = i;
        return this;
    }

    public com.google.common.collect.MapMakerInternalMap.Strength d() {
        return (com.google.common.collect.MapMakerInternalMap.Strength) com.google.common.base.MoreObjects.firstNonNull(this.d, com.google.common.collect.MapMakerInternalMap.Strength.STRONG);
    }

    public com.google.common.collect.MapMakerInternalMap.Strength e() {
        return (com.google.common.collect.MapMakerInternalMap.Strength) com.google.common.base.MoreObjects.firstNonNull(this.e, com.google.common.collect.MapMakerInternalMap.Strength.STRONG);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.MapMaker f(com.google.common.base.Equivalence<java.lang.Object> equivalence) {
        com.google.common.base.Equivalence<java.lang.Object> equivalence2 = this.f;
        com.google.common.base.Preconditions.checkState(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f = (com.google.common.base.Equivalence) com.google.common.base.Preconditions.checkNotNull(equivalence);
        this.a = true;
        return this;
    }

    public com.google.common.collect.MapMaker g(com.google.common.collect.MapMakerInternalMap.Strength strength) {
        com.google.common.collect.MapMakerInternalMap.Strength strength2 = this.d;
        com.google.common.base.Preconditions.checkState(strength2 == null, "Key strength was already set to %s", strength2);
        this.d = (com.google.common.collect.MapMakerInternalMap.Strength) com.google.common.base.Preconditions.checkNotNull(strength);
        if (strength != com.google.common.collect.MapMakerInternalMap.Strength.STRONG) {
            this.a = true;
        }
        return this;
    }

    public com.google.common.collect.MapMaker h(com.google.common.collect.MapMakerInternalMap.Strength strength) {
        com.google.common.collect.MapMakerInternalMap.Strength strength2 = this.e;
        com.google.common.base.Preconditions.checkState(strength2 == null, "Value strength was already set to %s", strength2);
        this.e = (com.google.common.collect.MapMakerInternalMap.Strength) com.google.common.base.Preconditions.checkNotNull(strength);
        if (strength != com.google.common.collect.MapMakerInternalMap.Strength.STRONG) {
            this.a = true;
        }
        return this;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public com.google.common.collect.MapMaker initialCapacity(int i) {
        int i2 = this.b;
        com.google.common.base.Preconditions.checkState(i2 == -1, "initial capacity was already set to %s", i2);
        com.google.common.base.Preconditions.checkArgument(i >= 0);
        this.b = i;
        return this;
    }

    public <K, V> java.util.concurrent.ConcurrentMap<K, V> makeMap() {
        return !this.a ? new java.util.concurrent.ConcurrentHashMap(b(), 0.75f, a()) : com.google.common.collect.MapMakerInternalMap.create(this);
    }

    public java.lang.String toString() {
        com.google.common.base.MoreObjects.ToStringHelper stringHelper = com.google.common.base.MoreObjects.toStringHelper(this);
        int i = this.b;
        if (i != -1) {
            stringHelper.add("initialCapacity", i);
        }
        int i2 = this.c;
        if (i2 != -1) {
            stringHelper.add("concurrencyLevel", i2);
        }
        com.google.common.collect.MapMakerInternalMap.Strength strength = this.d;
        if (strength != null) {
            stringHelper.add("keyStrength", com.google.common.base.Ascii.toLowerCase(strength.toString()));
        }
        com.google.common.collect.MapMakerInternalMap.Strength strength2 = this.e;
        if (strength2 != null) {
            stringHelper.add("valueStrength", com.google.common.base.Ascii.toLowerCase(strength2.toString()));
        }
        if (this.f != null) {
            stringHelper.addValue("keyEquivalence");
        }
        return stringHelper.toString();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.MapMaker weakKeys() {
        return g(com.google.common.collect.MapMakerInternalMap.Strength.WEAK);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.MapMaker weakValues() {
        return h(com.google.common.collect.MapMakerInternalMap.Strength.WEAK);
    }
}
