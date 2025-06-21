package com.google.common.cache;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class CacheBuilderSpec {
    public static final com.google.common.base.Splitter o = com.google.common.base.Splitter.on(',').trimResults();
    public static final com.google.common.base.Splitter p = com.google.common.base.Splitter.on(com.alipay.sdk.m.n.a.h).trimResults();
    public static final com.google.common.collect.ImmutableMap<java.lang.String, com.google.common.cache.CacheBuilderSpec.ValueParser> q;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public java.lang.Integer a;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public java.lang.Long b;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public java.lang.Long c;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public java.lang.Integer d;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public com.google.common.cache.LocalCache.Strength e;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public com.google.common.cache.LocalCache.Strength f;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public java.lang.Boolean g;

    @com.google.common.annotations.VisibleForTesting
    public long h;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public java.util.concurrent.TimeUnit i;

    @com.google.common.annotations.VisibleForTesting
    public long j;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public java.util.concurrent.TimeUnit k;

    @com.google.common.annotations.VisibleForTesting
    public long l;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public java.util.concurrent.TimeUnit m;
    public final java.lang.String n;

    /* renamed from: com.google.common.cache.CacheBuilderSpec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.common.cache.LocalCache.Strength.values().length];
            a = iArr;
            try {
                iArr[com.google.common.cache.LocalCache.Strength.WEAK.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.google.common.cache.LocalCache.Strength.SOFT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public static class AccessDurationParser extends com.google.common.cache.CacheBuilderSpec.DurationParser {
        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        public void b(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, long j, java.util.concurrent.TimeUnit timeUnit) {
            com.google.common.base.Preconditions.checkArgument(cacheBuilderSpec.k == null, "expireAfterAccess already set");
            cacheBuilderSpec.j = j;
            cacheBuilderSpec.k = timeUnit;
        }
    }

    public static class ConcurrencyLevelParser extends com.google.common.cache.CacheBuilderSpec.IntegerParser {
        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        public void b(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, int i) {
            java.lang.Integer num = cacheBuilderSpec.d;
            com.google.common.base.Preconditions.checkArgument(num == null, "concurrency level was already set to ", num);
            cacheBuilderSpec.d = java.lang.Integer.valueOf(i);
        }
    }

    public static abstract class DurationParser implements com.google.common.cache.CacheBuilderSpec.ValueParser {
        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, java.lang.String str, java.lang.String str2) {
            java.util.concurrent.TimeUnit timeUnit;
            com.google.common.base.Preconditions.checkArgument((str2 == null || str2.isEmpty()) ? false : true, "value of key %s omitted", str);
            try {
                char charAt = str2.charAt(str2.length() - 1);
                if (charAt == 'd') {
                    timeUnit = java.util.concurrent.TimeUnit.DAYS;
                } else if (charAt == 'h') {
                    timeUnit = java.util.concurrent.TimeUnit.HOURS;
                } else if (charAt == 'm') {
                    timeUnit = java.util.concurrent.TimeUnit.MINUTES;
                } else {
                    if (charAt != 's') {
                        throw new java.lang.IllegalArgumentException(com.google.common.cache.CacheBuilderSpec.c("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", str, str2));
                    }
                    timeUnit = java.util.concurrent.TimeUnit.SECONDS;
                }
                b(cacheBuilderSpec, java.lang.Long.parseLong(str2.substring(0, str2.length() - 1)), timeUnit);
            } catch (java.lang.NumberFormatException unused) {
                throw new java.lang.IllegalArgumentException(com.google.common.cache.CacheBuilderSpec.c("key %s value set to %s, must be integer", str, str2));
            }
        }

        public abstract void b(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, long j, java.util.concurrent.TimeUnit timeUnit);
    }

    public static class InitialCapacityParser extends com.google.common.cache.CacheBuilderSpec.IntegerParser {
        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        public void b(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, int i) {
            java.lang.Integer num = cacheBuilderSpec.a;
            com.google.common.base.Preconditions.checkArgument(num == null, "initial capacity was already set to ", num);
            cacheBuilderSpec.a = java.lang.Integer.valueOf(i);
        }
    }

    public static abstract class IntegerParser implements com.google.common.cache.CacheBuilderSpec.ValueParser {
        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, java.lang.String str, java.lang.String str2) {
            com.google.common.base.Preconditions.checkArgument((str2 == null || str2.isEmpty()) ? false : true, "value of key %s omitted", str);
            try {
                b(cacheBuilderSpec, java.lang.Integer.parseInt(str2));
            } catch (java.lang.NumberFormatException e) {
                throw new java.lang.IllegalArgumentException(com.google.common.cache.CacheBuilderSpec.c("key %s value set to %s, must be integer", str, str2), e);
            }
        }

        public abstract void b(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, int i);
    }

    public static class KeyStrengthParser implements com.google.common.cache.CacheBuilderSpec.ValueParser {
        public final com.google.common.cache.LocalCache.Strength a;

        public KeyStrengthParser(com.google.common.cache.LocalCache.Strength strength) {
            this.a = strength;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str2) {
            com.google.common.base.Preconditions.checkArgument(str2 == null, "key %s does not take values", str);
            com.google.common.cache.LocalCache.Strength strength = cacheBuilderSpec.e;
            com.google.common.base.Preconditions.checkArgument(strength == null, "%s was already set to %s", str, strength);
            cacheBuilderSpec.e = this.a;
        }
    }

    public static abstract class LongParser implements com.google.common.cache.CacheBuilderSpec.ValueParser {
        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, java.lang.String str, java.lang.String str2) {
            com.google.common.base.Preconditions.checkArgument((str2 == null || str2.isEmpty()) ? false : true, "value of key %s omitted", str);
            try {
                b(cacheBuilderSpec, java.lang.Long.parseLong(str2));
            } catch (java.lang.NumberFormatException e) {
                throw new java.lang.IllegalArgumentException(com.google.common.cache.CacheBuilderSpec.c("key %s value set to %s, must be integer", str, str2), e);
            }
        }

        public abstract void b(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, long j);
    }

    public static class MaximumSizeParser extends com.google.common.cache.CacheBuilderSpec.LongParser {
        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        public void b(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, long j) {
            java.lang.Long l = cacheBuilderSpec.b;
            com.google.common.base.Preconditions.checkArgument(l == null, "maximum size was already set to ", l);
            java.lang.Long l2 = cacheBuilderSpec.c;
            com.google.common.base.Preconditions.checkArgument(l2 == null, "maximum weight was already set to ", l2);
            cacheBuilderSpec.b = java.lang.Long.valueOf(j);
        }
    }

    public static class MaximumWeightParser extends com.google.common.cache.CacheBuilderSpec.LongParser {
        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        public void b(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, long j) {
            java.lang.Long l = cacheBuilderSpec.c;
            com.google.common.base.Preconditions.checkArgument(l == null, "maximum weight was already set to ", l);
            java.lang.Long l2 = cacheBuilderSpec.b;
            com.google.common.base.Preconditions.checkArgument(l2 == null, "maximum size was already set to ", l2);
            cacheBuilderSpec.c = java.lang.Long.valueOf(j);
        }
    }

    public static class RecordStatsParser implements com.google.common.cache.CacheBuilderSpec.ValueParser {
        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str2) {
            com.google.common.base.Preconditions.checkArgument(str2 == null, "recordStats does not take values");
            com.google.common.base.Preconditions.checkArgument(cacheBuilderSpec.g == null, "recordStats already set");
            cacheBuilderSpec.g = java.lang.Boolean.TRUE;
        }
    }

    public static class RefreshDurationParser extends com.google.common.cache.CacheBuilderSpec.DurationParser {
        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        public void b(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, long j, java.util.concurrent.TimeUnit timeUnit) {
            com.google.common.base.Preconditions.checkArgument(cacheBuilderSpec.m == null, "refreshAfterWrite already set");
            cacheBuilderSpec.l = j;
            cacheBuilderSpec.m = timeUnit;
        }
    }

    public interface ValueParser {
        void a(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str2);
    }

    public static class ValueStrengthParser implements com.google.common.cache.CacheBuilderSpec.ValueParser {
        public final com.google.common.cache.LocalCache.Strength a;

        public ValueStrengthParser(com.google.common.cache.LocalCache.Strength strength) {
            this.a = strength;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str2) {
            com.google.common.base.Preconditions.checkArgument(str2 == null, "key %s does not take values", str);
            com.google.common.cache.LocalCache.Strength strength = cacheBuilderSpec.f;
            com.google.common.base.Preconditions.checkArgument(strength == null, "%s was already set to %s", str, strength);
            cacheBuilderSpec.f = this.a;
        }
    }

    public static class WriteDurationParser extends com.google.common.cache.CacheBuilderSpec.DurationParser {
        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        public void b(com.google.common.cache.CacheBuilderSpec cacheBuilderSpec, long j, java.util.concurrent.TimeUnit timeUnit) {
            com.google.common.base.Preconditions.checkArgument(cacheBuilderSpec.i == null, "expireAfterWrite already set");
            cacheBuilderSpec.h = j;
            cacheBuilderSpec.i = timeUnit;
        }
    }

    static {
        com.google.common.collect.ImmutableMap.Builder put = com.google.common.collect.ImmutableMap.builder().put("initialCapacity", new com.google.common.cache.CacheBuilderSpec.InitialCapacityParser()).put("maximumSize", new com.google.common.cache.CacheBuilderSpec.MaximumSizeParser()).put("maximumWeight", new com.google.common.cache.CacheBuilderSpec.MaximumWeightParser()).put("concurrencyLevel", new com.google.common.cache.CacheBuilderSpec.ConcurrencyLevelParser());
        com.google.common.cache.LocalCache.Strength strength = com.google.common.cache.LocalCache.Strength.WEAK;
        q = put.put("weakKeys", new com.google.common.cache.CacheBuilderSpec.KeyStrengthParser(strength)).put("softValues", new com.google.common.cache.CacheBuilderSpec.ValueStrengthParser(com.google.common.cache.LocalCache.Strength.SOFT)).put("weakValues", new com.google.common.cache.CacheBuilderSpec.ValueStrengthParser(strength)).put("recordStats", new com.google.common.cache.CacheBuilderSpec.RecordStatsParser()).put("expireAfterAccess", new com.google.common.cache.CacheBuilderSpec.AccessDurationParser()).put("expireAfterWrite", new com.google.common.cache.CacheBuilderSpec.WriteDurationParser()).put("refreshAfterWrite", new com.google.common.cache.CacheBuilderSpec.RefreshDurationParser()).put("refreshInterval", new com.google.common.cache.CacheBuilderSpec.RefreshDurationParser()).build();
    }

    public CacheBuilderSpec(java.lang.String str) {
        this.n = str;
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static java.lang.Long b(long j, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.concurrent.TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return java.lang.Long.valueOf(timeUnit.toNanos(j));
    }

    public static java.lang.String c(java.lang.String str, java.lang.Object... objArr) {
        return java.lang.String.format(java.util.Locale.ROOT, str, objArr);
    }

    public static com.google.common.cache.CacheBuilderSpec disableCaching() {
        return parse("maximumSize=0");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.google.common.cache.CacheBuilderSpec parse(java.lang.String str) {
        com.google.common.cache.CacheBuilderSpec cacheBuilderSpec = new com.google.common.cache.CacheBuilderSpec(str);
        if (!str.isEmpty()) {
            for (java.lang.String str2 : o.split(str)) {
                com.google.common.collect.ImmutableList copyOf = com.google.common.collect.ImmutableList.copyOf(p.split(str2));
                com.google.common.base.Preconditions.checkArgument(!copyOf.isEmpty(), "blank key-value pair");
                com.google.common.base.Preconditions.checkArgument(copyOf.size() <= 2, "key-value pair %s with more than one equals sign", str2);
                java.lang.String str3 = (java.lang.String) copyOf.get(0);
                com.google.common.cache.CacheBuilderSpec.ValueParser valueParser = q.get(str3);
                com.google.common.base.Preconditions.checkArgument(valueParser != null, "unknown key %s", str3);
                valueParser.a(cacheBuilderSpec, str3, copyOf.size() == 1 ? null : (java.lang.String) copyOf.get(1));
            }
        }
        return cacheBuilderSpec;
    }

    public com.google.common.cache.CacheBuilder<java.lang.Object, java.lang.Object> d() {
        com.google.common.cache.CacheBuilder<java.lang.Object, java.lang.Object> newBuilder = com.google.common.cache.CacheBuilder.newBuilder();
        java.lang.Integer num = this.a;
        if (num != null) {
            newBuilder.initialCapacity(num.intValue());
        }
        java.lang.Long l = this.b;
        if (l != null) {
            newBuilder.maximumSize(l.longValue());
        }
        java.lang.Long l2 = this.c;
        if (l2 != null) {
            newBuilder.maximumWeight(l2.longValue());
        }
        java.lang.Integer num2 = this.d;
        if (num2 != null) {
            newBuilder.concurrencyLevel(num2.intValue());
        }
        com.google.common.cache.LocalCache.Strength strength = this.e;
        if (strength != null) {
            if (com.google.common.cache.CacheBuilderSpec.AnonymousClass1.a[strength.ordinal()] != 1) {
                throw new java.lang.AssertionError();
            }
            newBuilder.weakKeys();
        }
        com.google.common.cache.LocalCache.Strength strength2 = this.f;
        if (strength2 != null) {
            int i = com.google.common.cache.CacheBuilderSpec.AnonymousClass1.a[strength2.ordinal()];
            if (i == 1) {
                newBuilder.weakValues();
            } else {
                if (i != 2) {
                    throw new java.lang.AssertionError();
                }
                newBuilder.softValues();
            }
        }
        java.lang.Boolean bool = this.g;
        if (bool != null && bool.booleanValue()) {
            newBuilder.recordStats();
        }
        java.util.concurrent.TimeUnit timeUnit = this.i;
        if (timeUnit != null) {
            newBuilder.expireAfterWrite(this.h, timeUnit);
        }
        java.util.concurrent.TimeUnit timeUnit2 = this.k;
        if (timeUnit2 != null) {
            newBuilder.expireAfterAccess(this.j, timeUnit2);
        }
        java.util.concurrent.TimeUnit timeUnit3 = this.m;
        if (timeUnit3 != null) {
            newBuilder.refreshAfterWrite(this.l, timeUnit3);
        }
        return newBuilder;
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.common.cache.CacheBuilderSpec)) {
            return false;
        }
        com.google.common.cache.CacheBuilderSpec cacheBuilderSpec = (com.google.common.cache.CacheBuilderSpec) obj;
        return com.google.common.base.Objects.equal(this.a, cacheBuilderSpec.a) && com.google.common.base.Objects.equal(this.b, cacheBuilderSpec.b) && com.google.common.base.Objects.equal(this.c, cacheBuilderSpec.c) && com.google.common.base.Objects.equal(this.d, cacheBuilderSpec.d) && com.google.common.base.Objects.equal(this.e, cacheBuilderSpec.e) && com.google.common.base.Objects.equal(this.f, cacheBuilderSpec.f) && com.google.common.base.Objects.equal(this.g, cacheBuilderSpec.g) && com.google.common.base.Objects.equal(b(this.h, this.i), b(cacheBuilderSpec.h, cacheBuilderSpec.i)) && com.google.common.base.Objects.equal(b(this.j, this.k), b(cacheBuilderSpec.j, cacheBuilderSpec.k)) && com.google.common.base.Objects.equal(b(this.l, this.m), b(cacheBuilderSpec.l, cacheBuilderSpec.m));
    }

    public int hashCode() {
        return com.google.common.base.Objects.hashCode(this.a, this.b, this.c, this.d, this.e, this.f, this.g, b(this.h, this.i), b(this.j, this.k), b(this.l, this.m));
    }

    public java.lang.String toParsableString() {
        return this.n;
    }

    public java.lang.String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this).addValue(toParsableString()).toString();
    }
}
