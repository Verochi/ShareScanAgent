package com.google.common.base;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Predicates {

    public static class AndPredicate<T> implements com.google.common.base.Predicate<T>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.util.List<? extends com.google.common.base.Predicate<? super T>> components;

        private AndPredicate(java.util.List<? extends com.google.common.base.Predicate<? super T>> list) {
            this.components = list;
        }

        public /* synthetic */ AndPredicate(java.util.List list, com.google.common.base.Predicates.AnonymousClass1 anonymousClass1) {
            this(list);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (!this.components.get(i).apply(t)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.base.Predicates.AndPredicate) {
                return this.components.equals(((com.google.common.base.Predicates.AndPredicate) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        public java.lang.String toString() {
            return com.google.common.base.Predicates.e("and", this.components);
        }
    }

    public static class CompositionPredicate<A, B> implements com.google.common.base.Predicate<A>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.base.Function<A, ? extends B> f;
        final com.google.common.base.Predicate<B> p;

        private CompositionPredicate(com.google.common.base.Predicate<B> predicate, com.google.common.base.Function<A, ? extends B> function) {
            this.p = (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate);
            this.f = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function);
        }

        public /* synthetic */ CompositionPredicate(com.google.common.base.Predicate predicate, com.google.common.base.Function function, com.google.common.base.Predicates.AnonymousClass1 anonymousClass1) {
            this(predicate, function);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl A a) {
            return this.p.apply(this.f.apply(a));
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.base.Predicates.CompositionPredicate)) {
                return false;
            }
            com.google.common.base.Predicates.CompositionPredicate compositionPredicate = (com.google.common.base.Predicates.CompositionPredicate) obj;
            return this.f.equals(compositionPredicate.f) && this.p.equals(compositionPredicate.p);
        }

        public int hashCode() {
            return this.f.hashCode() ^ this.p.hashCode();
        }

        public java.lang.String toString() {
            return this.p + "(" + this.f + ")";
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class ContainsPatternFromStringPredicate extends com.google.common.base.Predicates.ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        public ContainsPatternFromStringPredicate(java.lang.String str) {
            super(com.google.common.base.Platform.a(str));
        }

        @Override // com.google.common.base.Predicates.ContainsPatternPredicate
        public java.lang.String toString() {
            return "Predicates.containsPattern(" + this.pattern.pattern() + ")";
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class ContainsPatternPredicate implements com.google.common.base.Predicate<java.lang.CharSequence>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.base.CommonPattern pattern;

        public ContainsPatternPredicate(com.google.common.base.CommonPattern commonPattern) {
            this.pattern = (com.google.common.base.CommonPattern) com.google.common.base.Preconditions.checkNotNull(commonPattern);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(java.lang.CharSequence charSequence) {
            return this.pattern.matcher(charSequence).b();
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.base.Predicates.ContainsPatternPredicate)) {
                return false;
            }
            com.google.common.base.Predicates.ContainsPatternPredicate containsPatternPredicate = (com.google.common.base.Predicates.ContainsPatternPredicate) obj;
            return com.google.common.base.Objects.equal(this.pattern.pattern(), containsPatternPredicate.pattern.pattern()) && this.pattern.flags() == containsPatternPredicate.pattern.flags();
        }

        public int hashCode() {
            return com.google.common.base.Objects.hashCode(this.pattern.pattern(), java.lang.Integer.valueOf(this.pattern.flags()));
        }

        public java.lang.String toString() {
            return "Predicates.contains(" + com.google.common.base.MoreObjects.toStringHelper(this.pattern).add(org.apache.tools.ant.types.selectors.DateSelector.PATTERN_KEY, this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString() + ")";
        }
    }

    public static class InPredicate<T> implements com.google.common.base.Predicate<T>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.util.Collection<?> target;

        private InPredicate(java.util.Collection<?> collection) {
            this.target = (java.util.Collection) com.google.common.base.Preconditions.checkNotNull(collection);
        }

        public /* synthetic */ InPredicate(java.util.Collection collection, com.google.common.base.Predicates.AnonymousClass1 anonymousClass1) {
            this(collection);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
            try {
                return this.target.contains(t);
            } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.base.Predicates.InPredicate) {
                return this.target.equals(((com.google.common.base.Predicates.InPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public java.lang.String toString() {
            return "Predicates.in(" + this.target + ")";
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class InstanceOfPredicate implements com.google.common.base.Predicate<java.lang.Object>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.lang.Class<?> clazz;

        private InstanceOfPredicate(java.lang.Class<?> cls) {
            this.clazz = (java.lang.Class) com.google.common.base.Preconditions.checkNotNull(cls);
        }

        public /* synthetic */ InstanceOfPredicate(java.lang.Class cls, com.google.common.base.Predicates.AnonymousClass1 anonymousClass1) {
            this(cls);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.clazz.isInstance(obj);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return (obj instanceof com.google.common.base.Predicates.InstanceOfPredicate) && this.clazz == ((com.google.common.base.Predicates.InstanceOfPredicate) obj).clazz;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public java.lang.String toString() {
            return "Predicates.instanceOf(" + this.clazz.getName() + ")";
        }
    }

    public static class IsEqualToPredicate<T> implements com.google.common.base.Predicate<T>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final T target;

        private IsEqualToPredicate(T t) {
            this.target = t;
        }

        public /* synthetic */ IsEqualToPredicate(java.lang.Object obj, com.google.common.base.Predicates.AnonymousClass1 anonymousClass1) {
            this(obj);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T t) {
            return this.target.equals(t);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.base.Predicates.IsEqualToPredicate) {
                return this.target.equals(((com.google.common.base.Predicates.IsEqualToPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public java.lang.String toString() {
            return "Predicates.equalTo(" + this.target + ")";
        }
    }

    public static class NotPredicate<T> implements com.google.common.base.Predicate<T>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.base.Predicate<T> predicate;

        public NotPredicate(com.google.common.base.Predicate<T> predicate) {
            this.predicate = (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
            return !this.predicate.apply(t);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.base.Predicates.NotPredicate) {
                return this.predicate.equals(((com.google.common.base.Predicates.NotPredicate) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        public java.lang.String toString() {
            return "Predicates.not(" + this.predicate + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class ObjectPredicate implements com.google.common.base.Predicate<java.lang.Object> {
        private static final /* synthetic */ com.google.common.base.Predicates.ObjectPredicate[] $VALUES;
        public static final com.google.common.base.Predicates.ObjectPredicate ALWAYS_FALSE;
        public static final com.google.common.base.Predicates.ObjectPredicate ALWAYS_TRUE;
        public static final com.google.common.base.Predicates.ObjectPredicate IS_NULL;
        public static final com.google.common.base.Predicates.ObjectPredicate NOT_NULL;

        /* renamed from: com.google.common.base.Predicates$ObjectPredicate$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.base.Predicates.ObjectPredicate {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public java.lang.String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        /* renamed from: com.google.common.base.Predicates$ObjectPredicate$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.base.Predicates.ObjectPredicate {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public java.lang.String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        /* renamed from: com.google.common.base.Predicates$ObjectPredicate$3, reason: invalid class name */
        public enum AnonymousClass3 extends com.google.common.base.Predicates.ObjectPredicate {
            public AnonymousClass3(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public java.lang.String toString() {
                return "Predicates.isNull()";
            }
        }

        /* renamed from: com.google.common.base.Predicates$ObjectPredicate$4, reason: invalid class name */
        public enum AnonymousClass4 extends com.google.common.base.Predicates.ObjectPredicate {
            public AnonymousClass4(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public java.lang.String toString() {
                return "Predicates.notNull()";
            }
        }

        static {
            com.google.common.base.Predicates.ObjectPredicate.AnonymousClass1 anonymousClass1 = new com.google.common.base.Predicates.ObjectPredicate.AnonymousClass1("ALWAYS_TRUE", 0);
            ALWAYS_TRUE = anonymousClass1;
            com.google.common.base.Predicates.ObjectPredicate.AnonymousClass2 anonymousClass2 = new com.google.common.base.Predicates.ObjectPredicate.AnonymousClass2("ALWAYS_FALSE", 1);
            ALWAYS_FALSE = anonymousClass2;
            com.google.common.base.Predicates.ObjectPredicate.AnonymousClass3 anonymousClass3 = new com.google.common.base.Predicates.ObjectPredicate.AnonymousClass3("IS_NULL", 2);
            IS_NULL = anonymousClass3;
            com.google.common.base.Predicates.ObjectPredicate.AnonymousClass4 anonymousClass4 = new com.google.common.base.Predicates.ObjectPredicate.AnonymousClass4("NOT_NULL", 3);
            NOT_NULL = anonymousClass4;
            $VALUES = new com.google.common.base.Predicates.ObjectPredicate[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4};
        }

        private ObjectPredicate(java.lang.String str, int i) {
        }

        public /* synthetic */ ObjectPredicate(java.lang.String str, int i, com.google.common.base.Predicates.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static com.google.common.base.Predicates.ObjectPredicate valueOf(java.lang.String str) {
            return (com.google.common.base.Predicates.ObjectPredicate) java.lang.Enum.valueOf(com.google.common.base.Predicates.ObjectPredicate.class, str);
        }

        public static com.google.common.base.Predicates.ObjectPredicate[] values() {
            return (com.google.common.base.Predicates.ObjectPredicate[]) $VALUES.clone();
        }

        public <T> com.google.common.base.Predicate<T> withNarrowedType() {
            return this;
        }
    }

    public static class OrPredicate<T> implements com.google.common.base.Predicate<T>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.util.List<? extends com.google.common.base.Predicate<? super T>> components;

        private OrPredicate(java.util.List<? extends com.google.common.base.Predicate<? super T>> list) {
            this.components = list;
        }

        public /* synthetic */ OrPredicate(java.util.List list, com.google.common.base.Predicates.AnonymousClass1 anonymousClass1) {
            this(list);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (this.components.get(i).apply(t)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.base.Predicates.OrPredicate) {
                return this.components.equals(((com.google.common.base.Predicates.OrPredicate) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        public java.lang.String toString() {
            return com.google.common.base.Predicates.e("or", this.components);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class SubtypeOfPredicate implements com.google.common.base.Predicate<java.lang.Class<?>>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.lang.Class<?> clazz;

        private SubtypeOfPredicate(java.lang.Class<?> cls) {
            this.clazz = (java.lang.Class) com.google.common.base.Preconditions.checkNotNull(cls);
        }

        public /* synthetic */ SubtypeOfPredicate(java.lang.Class cls, com.google.common.base.Predicates.AnonymousClass1 anonymousClass1) {
            this(cls);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(java.lang.Class<?> cls) {
            return this.clazz.isAssignableFrom(cls);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return (obj instanceof com.google.common.base.Predicates.SubtypeOfPredicate) && this.clazz == ((com.google.common.base.Predicates.SubtypeOfPredicate) obj).clazz;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public java.lang.String toString() {
            return "Predicates.subtypeOf(" + this.clazz.getName() + ")";
        }
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <T> com.google.common.base.Predicate<T> alwaysFalse() {
        return com.google.common.base.Predicates.ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <T> com.google.common.base.Predicate<T> alwaysTrue() {
        return com.google.common.base.Predicates.ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <T> com.google.common.base.Predicate<T> and(com.google.common.base.Predicate<? super T> predicate, com.google.common.base.Predicate<? super T> predicate2) {
        return new com.google.common.base.Predicates.AndPredicate(b((com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate), (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate2)), null);
    }

    public static <T> com.google.common.base.Predicate<T> and(java.lang.Iterable<? extends com.google.common.base.Predicate<? super T>> iterable) {
        return new com.google.common.base.Predicates.AndPredicate(c(iterable), null);
    }

    @java.lang.SafeVarargs
    public static <T> com.google.common.base.Predicate<T> and(com.google.common.base.Predicate<? super T>... predicateArr) {
        return new com.google.common.base.Predicates.AndPredicate(d(predicateArr), null);
    }

    public static <T> java.util.List<com.google.common.base.Predicate<? super T>> b(com.google.common.base.Predicate<? super T> predicate, com.google.common.base.Predicate<? super T> predicate2) {
        return java.util.Arrays.asList(predicate, predicate2);
    }

    public static <T> java.util.List<T> c(java.lang.Iterable<T> iterable) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(com.google.common.base.Preconditions.checkNotNull(it.next()));
        }
        return arrayList;
    }

    public static <A, B> com.google.common.base.Predicate<A> compose(com.google.common.base.Predicate<B> predicate, com.google.common.base.Function<A, ? extends B> function) {
        return new com.google.common.base.Predicates.CompositionPredicate(predicate, function, null);
    }

    @com.google.common.annotations.GwtIncompatible("java.util.regex.Pattern")
    public static com.google.common.base.Predicate<java.lang.CharSequence> contains(java.util.regex.Pattern pattern) {
        return new com.google.common.base.Predicates.ContainsPatternPredicate(new com.google.common.base.JdkPattern(pattern));
    }

    @com.google.common.annotations.GwtIncompatible
    public static com.google.common.base.Predicate<java.lang.CharSequence> containsPattern(java.lang.String str) {
        return new com.google.common.base.Predicates.ContainsPatternFromStringPredicate(str);
    }

    public static <T> java.util.List<T> d(T... tArr) {
        return c(java.util.Arrays.asList(tArr));
    }

    public static java.lang.String e(java.lang.String str, java.lang.Iterable<?> iterable) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z = true;
        for (java.lang.Object obj : iterable) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    public static <T> com.google.common.base.Predicate<T> equalTo(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return t == null ? isNull() : new com.google.common.base.Predicates.IsEqualToPredicate(t, null);
    }

    public static <T> com.google.common.base.Predicate<T> in(java.util.Collection<? extends T> collection) {
        return new com.google.common.base.Predicates.InPredicate(collection, null);
    }

    @com.google.common.annotations.GwtIncompatible
    public static com.google.common.base.Predicate<java.lang.Object> instanceOf(java.lang.Class<?> cls) {
        return new com.google.common.base.Predicates.InstanceOfPredicate(cls, null);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <T> com.google.common.base.Predicate<T> isNull() {
        return com.google.common.base.Predicates.ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> com.google.common.base.Predicate<T> not(com.google.common.base.Predicate<T> predicate) {
        return new com.google.common.base.Predicates.NotPredicate(predicate);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <T> com.google.common.base.Predicate<T> notNull() {
        return com.google.common.base.Predicates.ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    public static <T> com.google.common.base.Predicate<T> or(com.google.common.base.Predicate<? super T> predicate, com.google.common.base.Predicate<? super T> predicate2) {
        return new com.google.common.base.Predicates.OrPredicate(b((com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate), (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate2)), null);
    }

    public static <T> com.google.common.base.Predicate<T> or(java.lang.Iterable<? extends com.google.common.base.Predicate<? super T>> iterable) {
        return new com.google.common.base.Predicates.OrPredicate(c(iterable), null);
    }

    @java.lang.SafeVarargs
    public static <T> com.google.common.base.Predicate<T> or(com.google.common.base.Predicate<? super T>... predicateArr) {
        return new com.google.common.base.Predicates.OrPredicate(d(predicateArr), null);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static com.google.common.base.Predicate<java.lang.Class<?>> subtypeOf(java.lang.Class<?> cls) {
        return new com.google.common.base.Predicates.SubtypeOfPredicate(cls, null);
    }
}
