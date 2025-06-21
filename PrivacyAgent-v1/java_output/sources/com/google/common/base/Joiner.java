package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public class Joiner {
    public final java.lang.String a;

    /* renamed from: com.google.common.base.Joiner$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.base.Joiner {
        public final /* synthetic */ java.lang.String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(com.google.common.base.Joiner joiner, java.lang.String str) {
            super(joiner, null);
            this.b = str;
        }

        @Override // com.google.common.base.Joiner
        public java.lang.CharSequence c(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return obj == null ? this.b : com.google.common.base.Joiner.this.c(obj);
        }

        @Override // com.google.common.base.Joiner
        public com.google.common.base.Joiner skipNulls() {
            throw new java.lang.UnsupportedOperationException("already specified useForNull");
        }

        @Override // com.google.common.base.Joiner
        public com.google.common.base.Joiner useForNull(java.lang.String str) {
            throw new java.lang.UnsupportedOperationException("already specified useForNull");
        }
    }

    /* renamed from: com.google.common.base.Joiner$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.base.Joiner {
        public AnonymousClass2(com.google.common.base.Joiner joiner) {
            super(joiner, null);
        }

        @Override // com.google.common.base.Joiner
        public <A extends java.lang.Appendable> A appendTo(A a, java.util.Iterator<?> it) throws java.io.IOException {
            com.google.common.base.Preconditions.checkNotNull(a, "appendable");
            com.google.common.base.Preconditions.checkNotNull(it, "parts");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                java.lang.Object next = it.next();
                if (next != null) {
                    a.append(com.google.common.base.Joiner.this.c(next));
                    break;
                }
            }
            while (it.hasNext()) {
                java.lang.Object next2 = it.next();
                if (next2 != null) {
                    a.append(com.google.common.base.Joiner.this.a);
                    a.append(com.google.common.base.Joiner.this.c(next2));
                }
            }
            return a;
        }

        @Override // com.google.common.base.Joiner
        public com.google.common.base.Joiner useForNull(java.lang.String str) {
            throw new java.lang.UnsupportedOperationException("already specified skipNulls");
        }

        @Override // com.google.common.base.Joiner
        public com.google.common.base.Joiner.MapJoiner withKeyValueSeparator(java.lang.String str) {
            throw new java.lang.UnsupportedOperationException("can't use .skipNulls() with maps");
        }
    }

    /* renamed from: com.google.common.base.Joiner$3, reason: invalid class name */
    public static class AnonymousClass3 extends java.util.AbstractList<java.lang.Object> {
        public final /* synthetic */ java.lang.Object[] n;
        public final /* synthetic */ java.lang.Object t;
        public final /* synthetic */ java.lang.Object u;

        public AnonymousClass3(java.lang.Object[] objArr, java.lang.Object obj, java.lang.Object obj2) {
            this.n = objArr;
            this.t = obj;
            this.u = obj2;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.lang.Object get(int i) {
            return i != 0 ? i != 1 ? this.n[i - 2] : this.u : this.t;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.n.length + 2;
        }
    }

    public static final class MapJoiner {
        public final com.google.common.base.Joiner a;
        public final java.lang.String b;

        public MapJoiner(com.google.common.base.Joiner joiner, java.lang.String str) {
            this.a = joiner;
            this.b = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str);
        }

        public /* synthetic */ MapJoiner(com.google.common.base.Joiner joiner, java.lang.String str, com.google.common.base.Joiner.AnonymousClass1 anonymousClass1) {
            this(joiner, str);
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @com.google.common.annotations.Beta
        public <A extends java.lang.Appendable> A appendTo(A a, java.lang.Iterable<? extends java.util.Map.Entry<?, ?>> iterable) throws java.io.IOException {
            return (A) appendTo((com.google.common.base.Joiner.MapJoiner) a, iterable.iterator());
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @com.google.common.annotations.Beta
        public <A extends java.lang.Appendable> A appendTo(A a, java.util.Iterator<? extends java.util.Map.Entry<?, ?>> it) throws java.io.IOException {
            com.google.common.base.Preconditions.checkNotNull(a);
            if (it.hasNext()) {
                java.util.Map.Entry<?, ?> next = it.next();
                a.append(this.a.c(next.getKey()));
                a.append(this.b);
                a.append(this.a.c(next.getValue()));
                while (it.hasNext()) {
                    a.append(this.a.a);
                    java.util.Map.Entry<?, ?> next2 = it.next();
                    a.append(this.a.c(next2.getKey()));
                    a.append(this.b);
                    a.append(this.a.c(next2.getValue()));
                }
            }
            return a;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public <A extends java.lang.Appendable> A appendTo(A a, java.util.Map<?, ?> map) throws java.io.IOException {
            return (A) appendTo((com.google.common.base.Joiner.MapJoiner) a, (java.lang.Iterable<? extends java.util.Map.Entry<?, ?>>) map.entrySet());
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @com.google.common.annotations.Beta
        public java.lang.StringBuilder appendTo(java.lang.StringBuilder sb, java.lang.Iterable<? extends java.util.Map.Entry<?, ?>> iterable) {
            return appendTo(sb, iterable.iterator());
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @com.google.common.annotations.Beta
        public java.lang.StringBuilder appendTo(java.lang.StringBuilder sb, java.util.Iterator<? extends java.util.Map.Entry<?, ?>> it) {
            try {
                appendTo((com.google.common.base.Joiner.MapJoiner) sb, it);
                return sb;
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public java.lang.StringBuilder appendTo(java.lang.StringBuilder sb, java.util.Map<?, ?> map) {
            return appendTo(sb, (java.lang.Iterable<? extends java.util.Map.Entry<?, ?>>) map.entrySet());
        }

        @com.google.common.annotations.Beta
        public java.lang.String join(java.lang.Iterable<? extends java.util.Map.Entry<?, ?>> iterable) {
            return join(iterable.iterator());
        }

        @com.google.common.annotations.Beta
        public java.lang.String join(java.util.Iterator<? extends java.util.Map.Entry<?, ?>> it) {
            return appendTo(new java.lang.StringBuilder(), it).toString();
        }

        public java.lang.String join(java.util.Map<?, ?> map) {
            return join(map.entrySet());
        }

        public com.google.common.base.Joiner.MapJoiner useForNull(java.lang.String str) {
            return new com.google.common.base.Joiner.MapJoiner(this.a.useForNull(str), this.b);
        }
    }

    public Joiner(com.google.common.base.Joiner joiner) {
        this.a = joiner.a;
    }

    public /* synthetic */ Joiner(com.google.common.base.Joiner joiner, com.google.common.base.Joiner.AnonymousClass1 anonymousClass1) {
        this(joiner);
    }

    public Joiner(java.lang.String str) {
        this.a = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str);
    }

    public static java.lang.Iterable<java.lang.Object> b(java.lang.Object obj, java.lang.Object obj2, java.lang.Object[] objArr) {
        com.google.common.base.Preconditions.checkNotNull(objArr);
        return new com.google.common.base.Joiner.AnonymousClass3(objArr, obj, obj2);
    }

    public static com.google.common.base.Joiner on(char c) {
        return new com.google.common.base.Joiner(java.lang.String.valueOf(c));
    }

    public static com.google.common.base.Joiner on(java.lang.String str) {
        return new com.google.common.base.Joiner(str);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public <A extends java.lang.Appendable> A appendTo(A a, java.lang.Iterable<?> iterable) throws java.io.IOException {
        return (A) appendTo((com.google.common.base.Joiner) a, iterable.iterator());
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final <A extends java.lang.Appendable> A appendTo(A a, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2, java.lang.Object... objArr) throws java.io.IOException {
        return (A) appendTo((com.google.common.base.Joiner) a, b(obj, obj2, objArr));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public <A extends java.lang.Appendable> A appendTo(A a, java.util.Iterator<?> it) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(a);
        if (it.hasNext()) {
            a.append(c(it.next()));
            while (it.hasNext()) {
                a.append(this.a);
                a.append(c(it.next()));
            }
        }
        return a;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final <A extends java.lang.Appendable> A appendTo(A a, java.lang.Object[] objArr) throws java.io.IOException {
        return (A) appendTo((com.google.common.base.Joiner) a, (java.lang.Iterable<?>) java.util.Arrays.asList(objArr));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final java.lang.StringBuilder appendTo(java.lang.StringBuilder sb, java.lang.Iterable<?> iterable) {
        return appendTo(sb, iterable.iterator());
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final java.lang.StringBuilder appendTo(java.lang.StringBuilder sb, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2, java.lang.Object... objArr) {
        return appendTo(sb, b(obj, obj2, objArr));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final java.lang.StringBuilder appendTo(java.lang.StringBuilder sb, java.util.Iterator<?> it) {
        try {
            appendTo((com.google.common.base.Joiner) sb, it);
            return sb;
        } catch (java.io.IOException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final java.lang.StringBuilder appendTo(java.lang.StringBuilder sb, java.lang.Object[] objArr) {
        return appendTo(sb, (java.lang.Iterable<?>) java.util.Arrays.asList(objArr));
    }

    public java.lang.CharSequence c(java.lang.Object obj) {
        com.google.common.base.Preconditions.checkNotNull(obj);
        return obj instanceof java.lang.CharSequence ? (java.lang.CharSequence) obj : obj.toString();
    }

    public final java.lang.String join(java.lang.Iterable<?> iterable) {
        return join(iterable.iterator());
    }

    public final java.lang.String join(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2, java.lang.Object... objArr) {
        return join(b(obj, obj2, objArr));
    }

    public final java.lang.String join(java.util.Iterator<?> it) {
        return appendTo(new java.lang.StringBuilder(), it).toString();
    }

    public final java.lang.String join(java.lang.Object[] objArr) {
        return join(java.util.Arrays.asList(objArr));
    }

    public com.google.common.base.Joiner skipNulls() {
        return new com.google.common.base.Joiner.AnonymousClass2(this);
    }

    public com.google.common.base.Joiner useForNull(java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(str);
        return new com.google.common.base.Joiner.AnonymousClass1(this, str);
    }

    public com.google.common.base.Joiner.MapJoiner withKeyValueSeparator(char c) {
        return withKeyValueSeparator(java.lang.String.valueOf(c));
    }

    public com.google.common.base.Joiner.MapJoiner withKeyValueSeparator(java.lang.String str) {
        return new com.google.common.base.Joiner.MapJoiner(this, str, null);
    }
}
