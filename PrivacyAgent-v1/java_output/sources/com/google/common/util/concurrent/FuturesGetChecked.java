package com.google.common.util.concurrent;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
final class FuturesGetChecked {
    public static final com.google.common.collect.Ordering<java.lang.reflect.Constructor<?>> a = com.google.common.collect.Ordering.natural().onResultOf(new com.google.common.util.concurrent.FuturesGetChecked.AnonymousClass1()).reverse();

    /* renamed from: com.google.common.util.concurrent.FuturesGetChecked$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.base.Function<java.lang.reflect.Constructor<?>, java.lang.Boolean> {
        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Boolean apply(java.lang.reflect.Constructor<?> constructor) {
            return java.lang.Boolean.valueOf(java.util.Arrays.asList(constructor.getParameterTypes()).contains(java.lang.String.class));
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public interface GetCheckedTypeValidator {
        void validateClass(java.lang.Class<? extends java.lang.Exception> cls);
    }

    @com.google.common.annotations.VisibleForTesting
    public static class GetCheckedTypeValidatorHolder {
        public static final java.lang.String a = com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidatorHolder.class.getName() + "$ClassValueValidator";
        public static final com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator b = a();

        @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
        public enum ClassValueValidator implements com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator {
            INSTANCE;

            private static final java.lang.ClassValue<java.lang.Boolean> isValidClass = new com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidatorHolder.ClassValueValidator.AnonymousClass1();

            /* renamed from: com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1, reason: invalid class name */
            public static class AnonymousClass1 extends java.lang.ClassValue<java.lang.Boolean> {
                @Override // java.lang.ClassValue
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public java.lang.Boolean computeValue(java.lang.Class<?> cls) {
                    com.google.common.util.concurrent.FuturesGetChecked.b(cls.asSubclass(java.lang.Exception.class));
                    return java.lang.Boolean.TRUE;
                }
            }

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void validateClass(java.lang.Class<? extends java.lang.Exception> cls) {
                isValidClass.get(cls);
            }
        }

        public enum WeakSetValidator implements com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator {
            INSTANCE;

            private static final java.util.Set<java.lang.ref.WeakReference<java.lang.Class<? extends java.lang.Exception>>> validClasses = new java.util.concurrent.CopyOnWriteArraySet();

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void validateClass(java.lang.Class<? extends java.lang.Exception> cls) {
                java.util.Iterator<java.lang.ref.WeakReference<java.lang.Class<? extends java.lang.Exception>>> it = validClasses.iterator();
                while (it.hasNext()) {
                    if (cls.equals(it.next().get())) {
                        return;
                    }
                }
                com.google.common.util.concurrent.FuturesGetChecked.b(cls);
                java.util.Set<java.lang.ref.WeakReference<java.lang.Class<? extends java.lang.Exception>>> set = validClasses;
                if (set.size() > 1000) {
                    set.clear();
                }
                set.add(new java.lang.ref.WeakReference<>(cls));
            }
        }

        public static com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator a() {
            try {
                return (com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator) java.lang.Class.forName(a).getEnumConstants()[0];
            } catch (java.lang.Throwable unused) {
                return com.google.common.util.concurrent.FuturesGetChecked.k();
            }
        }
    }

    public static com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator a() {
        return com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidatorHolder.b;
    }

    @com.google.common.annotations.VisibleForTesting
    public static void b(java.lang.Class<? extends java.lang.Exception> cls) {
        com.google.common.base.Preconditions.checkArgument(g(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        com.google.common.base.Preconditions.checkArgument(f(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    @com.google.common.annotations.VisibleForTesting
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <V, X extends java.lang.Exception> V c(com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator getCheckedTypeValidator, java.util.concurrent.Future<V> future, java.lang.Class<X> cls) throws java.lang.Exception {
        getCheckedTypeValidator.validateClass(cls);
        try {
            return future.get();
        } catch (java.lang.InterruptedException e) {
            java.lang.Thread.currentThread().interrupt();
            throw i(cls, e);
        } catch (java.util.concurrent.ExecutionException e2) {
            l(e2.getCause(), cls);
            throw new java.lang.AssertionError();
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <V, X extends java.lang.Exception> V d(java.util.concurrent.Future<V> future, java.lang.Class<X> cls) throws java.lang.Exception {
        return (V) c(a(), future, cls);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <V, X extends java.lang.Exception> V e(java.util.concurrent.Future<V> future, java.lang.Class<X> cls, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.Exception {
        a().validateClass(cls);
        try {
            return future.get(j, timeUnit);
        } catch (java.lang.InterruptedException e) {
            java.lang.Thread.currentThread().interrupt();
            throw i(cls, e);
        } catch (java.util.concurrent.ExecutionException e2) {
            l(e2.getCause(), cls);
            throw new java.lang.AssertionError();
        } catch (java.util.concurrent.TimeoutException e3) {
            throw i(cls, e3);
        }
    }

    public static boolean f(java.lang.Class<? extends java.lang.Exception> cls) {
        try {
            i(cls, new java.lang.Exception());
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static boolean g(java.lang.Class<? extends java.lang.Exception> cls) {
        return !java.lang.RuntimeException.class.isAssignableFrom(cls);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <X> X h(java.lang.reflect.Constructor<X> constructor, java.lang.Throwable th) {
        java.lang.Class<?>[] parameterTypes = constructor.getParameterTypes();
        java.lang.Object[] objArr = new java.lang.Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            java.lang.Class<?> cls = parameterTypes[i];
            if (cls.equals(java.lang.String.class)) {
                objArr[i] = th.toString();
            } else {
                if (!cls.equals(java.lang.Throwable.class)) {
                    return null;
                }
                objArr[i] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.InstantiationException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }

    public static <X extends java.lang.Exception> X i(java.lang.Class<X> cls, java.lang.Throwable th) {
        java.util.Iterator it = j(java.util.Arrays.asList(cls.getConstructors())).iterator();
        while (it.hasNext()) {
            X x = (X) h((java.lang.reflect.Constructor) it.next(), th);
            if (x != null) {
                if (x.getCause() == null) {
                    x.initCause(th);
                }
                return x;
            }
        }
        throw new java.lang.IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    public static <X extends java.lang.Exception> java.util.List<java.lang.reflect.Constructor<X>> j(java.util.List<java.lang.reflect.Constructor<X>> list) {
        return (java.util.List<java.lang.reflect.Constructor<X>>) a.sortedCopy(list);
    }

    @com.google.common.annotations.VisibleForTesting
    public static com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator k() {
        return com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
    }

    public static <X extends java.lang.Exception> void l(java.lang.Throwable th, java.lang.Class<X> cls) throws java.lang.Exception {
        if (th instanceof java.lang.Error) {
            throw new com.google.common.util.concurrent.ExecutionError((java.lang.Error) th);
        }
        if (!(th instanceof java.lang.RuntimeException)) {
            throw i(cls, th);
        }
        throw new com.google.common.util.concurrent.UncheckedExecutionException(th);
    }
}
