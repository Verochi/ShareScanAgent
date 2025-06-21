package com.google.common.base;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Throwables {

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    @com.google.common.annotations.GwtIncompatible
    public static final java.lang.Object a;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    @com.google.common.annotations.GwtIncompatible
    public static final java.lang.reflect.Method b;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    @com.google.common.annotations.GwtIncompatible
    public static final java.lang.reflect.Method c;

    /* renamed from: com.google.common.base.Throwables$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.AbstractList<java.lang.StackTraceElement> {
        public final /* synthetic */ java.lang.Throwable n;

        public AnonymousClass1(java.lang.Throwable th) {
            this.n = th;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.StackTraceElement get(int i) {
            return (java.lang.StackTraceElement) com.google.common.base.Throwables.i(com.google.common.base.Throwables.b, com.google.common.base.Throwables.a, this.n, java.lang.Integer.valueOf(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return ((java.lang.Integer) com.google.common.base.Throwables.i(com.google.common.base.Throwables.c, com.google.common.base.Throwables.a, this.n)).intValue();
        }
    }

    static {
        java.lang.Object f = f();
        a = f;
        b = f == null ? null : e();
        c = f != null ? h() : null;
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    @com.google.common.annotations.GwtIncompatible
    public static java.lang.reflect.Method e() {
        return g("getStackTraceElement", java.lang.Throwable.class, java.lang.Integer.TYPE);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    @com.google.common.annotations.GwtIncompatible
    public static java.lang.Object f() {
        try {
            return java.lang.Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
        } catch (java.lang.ThreadDeath e) {
            throw e;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    @com.google.common.annotations.GwtIncompatible
    public static java.lang.reflect.Method g(java.lang.String str, java.lang.Class<?>... clsArr) throws java.lang.ThreadDeath {
        try {
            return java.lang.Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (java.lang.ThreadDeath e) {
            throw e;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    @com.google.common.annotations.Beta
    public static java.util.List<java.lang.Throwable> getCausalChain(java.lang.Throwable th) {
        com.google.common.base.Preconditions.checkNotNull(th);
        java.util.ArrayList arrayList = new java.util.ArrayList(4);
        arrayList.add(th);
        boolean z = false;
        java.lang.Throwable th2 = th;
        while (true) {
            th = th.getCause();
            if (th == null) {
                return java.util.Collections.unmodifiableList(arrayList);
            }
            arrayList.add(th);
            if (th == th2) {
                throw new java.lang.IllegalArgumentException("Loop in causal chain detected.", th);
            }
            if (z) {
                th2 = th2.getCause();
            }
            z = !z;
        }
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static <X extends java.lang.Throwable> X getCauseAs(java.lang.Throwable th, java.lang.Class<X> cls) {
        try {
            return cls.cast(th.getCause());
        } catch (java.lang.ClassCastException e) {
            e.initCause(th);
            throw e;
        }
    }

    public static java.lang.Throwable getRootCause(java.lang.Throwable th) {
        boolean z = false;
        java.lang.Throwable th2 = th;
        while (true) {
            java.lang.Throwable cause = th.getCause();
            if (cause == null) {
                return th;
            }
            if (cause == th2) {
                throw new java.lang.IllegalArgumentException("Loop in causal chain detected.", cause);
            }
            if (z) {
                th2 = th2.getCause();
            }
            z = !z;
            th = cause;
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.lang.String getStackTraceAsString(java.lang.Throwable th) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        th.printStackTrace(new java.io.PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    @com.google.common.annotations.GwtIncompatible
    public static java.lang.reflect.Method h() {
        try {
            java.lang.reflect.Method g = g("getStackTraceDepth", java.lang.Throwable.class);
            if (g == null) {
                return null;
            }
            g.invoke(f(), new java.lang.Throwable());
            return g;
        } catch (java.lang.IllegalAccessException | java.lang.UnsupportedOperationException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.lang.Object i(java.lang.reflect.Method method, java.lang.Object obj, java.lang.Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            throw propagate(e2.getCause());
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.util.List<java.lang.StackTraceElement> j(java.lang.Throwable th) {
        com.google.common.base.Preconditions.checkNotNull(th);
        return new com.google.common.base.Throwables.AnonymousClass1(th);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static java.util.List<java.lang.StackTraceElement> lazyStackTrace(java.lang.Throwable th) {
        return lazyStackTraceIsLazy() ? j(th) : java.util.Collections.unmodifiableList(java.util.Arrays.asList(th.getStackTrace()));
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static boolean lazyStackTraceIsLazy() {
        return (b == null || c == null) ? false : true;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.GwtIncompatible
    @java.lang.Deprecated
    public static java.lang.RuntimeException propagate(java.lang.Throwable th) {
        throwIfUnchecked(th);
        throw new java.lang.RuntimeException(th);
    }

    @com.google.common.annotations.GwtIncompatible
    @java.lang.Deprecated
    public static <X extends java.lang.Throwable> void propagateIfInstanceOf(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th, java.lang.Class<X> cls) throws java.lang.Throwable {
        if (th != null) {
            throwIfInstanceOf(th, cls);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    @java.lang.Deprecated
    public static void propagateIfPossible(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th) {
        if (th != null) {
            throwIfUnchecked(th);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static <X extends java.lang.Throwable> void propagateIfPossible(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th, java.lang.Class<X> cls) throws java.lang.Throwable {
        propagateIfInstanceOf(th, cls);
        propagateIfPossible(th);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <X1 extends java.lang.Throwable, X2 extends java.lang.Throwable> void propagateIfPossible(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th, java.lang.Class<X1> cls, java.lang.Class<X2> cls2) throws java.lang.Throwable, java.lang.Throwable {
        com.google.common.base.Preconditions.checkNotNull(cls2);
        propagateIfInstanceOf(th, cls);
        propagateIfPossible(th, cls2);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <X extends java.lang.Throwable> void throwIfInstanceOf(java.lang.Throwable th, java.lang.Class<X> cls) throws java.lang.Throwable {
        com.google.common.base.Preconditions.checkNotNull(th);
        if (cls.isInstance(th)) {
            throw cls.cast(th);
        }
    }

    public static void throwIfUnchecked(java.lang.Throwable th) {
        com.google.common.base.Preconditions.checkNotNull(th);
        if (th instanceof java.lang.RuntimeException) {
            throw ((java.lang.RuntimeException) th);
        }
        if (th instanceof java.lang.Error) {
            throw ((java.lang.Error) th);
        }
    }
}
