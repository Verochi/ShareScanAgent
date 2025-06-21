package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class MoreObjects {

    public static final class ToStringHelper {
        public final java.lang.String a;
        public final com.google.common.base.MoreObjects.ToStringHelper.ValueHolder b;
        public com.google.common.base.MoreObjects.ToStringHelper.ValueHolder c;
        public boolean d;

        public static final class ValueHolder {

            @org.checkerframework.checker.nullness.compatqual.NullableDecl
            public java.lang.String a;

            @org.checkerframework.checker.nullness.compatqual.NullableDecl
            public java.lang.Object b;

            @org.checkerframework.checker.nullness.compatqual.NullableDecl
            public com.google.common.base.MoreObjects.ToStringHelper.ValueHolder c;

            public ValueHolder() {
            }

            public /* synthetic */ ValueHolder(com.google.common.base.MoreObjects.AnonymousClass1 anonymousClass1) {
                this();
            }
        }

        public ToStringHelper(java.lang.String str) {
            com.google.common.base.MoreObjects.ToStringHelper.ValueHolder valueHolder = new com.google.common.base.MoreObjects.ToStringHelper.ValueHolder(null);
            this.b = valueHolder;
            this.c = valueHolder;
            this.d = false;
            this.a = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str);
        }

        public /* synthetic */ ToStringHelper(java.lang.String str, com.google.common.base.MoreObjects.AnonymousClass1 anonymousClass1) {
            this(str);
        }

        public final com.google.common.base.MoreObjects.ToStringHelper.ValueHolder a() {
            com.google.common.base.MoreObjects.ToStringHelper.ValueHolder valueHolder = new com.google.common.base.MoreObjects.ToStringHelper.ValueHolder(null);
            this.c.c = valueHolder;
            this.c = valueHolder;
            return valueHolder;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper add(java.lang.String str, char c) {
            return c(str, java.lang.String.valueOf(c));
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper add(java.lang.String str, double d) {
            return c(str, java.lang.String.valueOf(d));
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper add(java.lang.String str, float f) {
            return c(str, java.lang.String.valueOf(f));
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper add(java.lang.String str, int i) {
            return c(str, java.lang.String.valueOf(i));
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper add(java.lang.String str, long j) {
            return c(str, java.lang.String.valueOf(j));
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper add(java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return c(str, obj);
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper add(java.lang.String str, boolean z) {
            return c(str, java.lang.String.valueOf(z));
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper addValue(char c) {
            return b(java.lang.String.valueOf(c));
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper addValue(double d) {
            return b(java.lang.String.valueOf(d));
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper addValue(float f) {
            return b(java.lang.String.valueOf(f));
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper addValue(int i) {
            return b(java.lang.String.valueOf(i));
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper addValue(long j) {
            return b(java.lang.String.valueOf(j));
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper addValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return b(obj);
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper addValue(boolean z) {
            return b(java.lang.String.valueOf(z));
        }

        public final com.google.common.base.MoreObjects.ToStringHelper b(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            a().b = obj;
            return this;
        }

        public final com.google.common.base.MoreObjects.ToStringHelper c(java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            com.google.common.base.MoreObjects.ToStringHelper.ValueHolder a = a();
            a.b = obj;
            a.a = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str);
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.base.MoreObjects.ToStringHelper omitNullValues() {
            this.d = true;
            return this;
        }

        public java.lang.String toString() {
            boolean z = this.d;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(32);
            sb.append(this.a);
            sb.append('{');
            java.lang.String str = "";
            for (com.google.common.base.MoreObjects.ToStringHelper.ValueHolder valueHolder = this.b.c; valueHolder != null; valueHolder = valueHolder.c) {
                java.lang.Object obj = valueHolder.b;
                if (!z || obj != null) {
                    sb.append(str);
                    java.lang.String str2 = valueHolder.a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append(com.alipay.sdk.m.n.a.h);
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        java.lang.String deepToString = java.util.Arrays.deepToString(new java.lang.Object[]{obj});
                        sb.append((java.lang.CharSequence) deepToString, 1, deepToString.length() - 1);
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static <T> T firstNonNull(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t2) {
        if (t != null) {
            return t;
        }
        if (t2 != null) {
            return t2;
        }
        throw new java.lang.NullPointerException("Both parameters are null");
    }

    public static com.google.common.base.MoreObjects.ToStringHelper toStringHelper(java.lang.Class<?> cls) {
        return new com.google.common.base.MoreObjects.ToStringHelper(cls.getSimpleName(), null);
    }

    public static com.google.common.base.MoreObjects.ToStringHelper toStringHelper(java.lang.Object obj) {
        return new com.google.common.base.MoreObjects.ToStringHelper(obj.getClass().getSimpleName(), null);
    }

    public static com.google.common.base.MoreObjects.ToStringHelper toStringHelper(java.lang.String str) {
        return new com.google.common.base.MoreObjects.ToStringHelper(str, null);
    }
}
