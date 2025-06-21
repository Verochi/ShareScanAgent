package com.google.common.eventbus;

/* loaded from: classes22.dex */
final class SubscriberRegistry {
    public static final com.google.common.cache.LoadingCache<java.lang.Class<?>, com.google.common.collect.ImmutableList<java.lang.reflect.Method>> c = com.google.common.cache.CacheBuilder.newBuilder().weakKeys().build(new com.google.common.eventbus.SubscriberRegistry.AnonymousClass1());
    public static final com.google.common.cache.LoadingCache<java.lang.Class<?>, com.google.common.collect.ImmutableSet<java.lang.Class<?>>> d = com.google.common.cache.CacheBuilder.newBuilder().weakKeys().build(new com.google.common.eventbus.SubscriberRegistry.AnonymousClass2());
    public final java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.util.concurrent.CopyOnWriteArraySet<com.google.common.eventbus.Subscriber>> a = com.google.common.collect.Maps.newConcurrentMap();

    @com.google.j2objc.annotations.Weak
    public final com.google.common.eventbus.EventBus b;

    /* renamed from: com.google.common.eventbus.SubscriberRegistry$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.google.common.cache.CacheLoader<java.lang.Class<?>, com.google.common.collect.ImmutableList<java.lang.reflect.Method>> {
        @Override // com.google.common.cache.CacheLoader
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.ImmutableList<java.lang.reflect.Method> load(java.lang.Class<?> cls) throws java.lang.Exception {
            return com.google.common.eventbus.SubscriberRegistry.e(cls);
        }
    }

    /* renamed from: com.google.common.eventbus.SubscriberRegistry$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.google.common.cache.CacheLoader<java.lang.Class<?>, com.google.common.collect.ImmutableSet<java.lang.Class<?>>> {
        @Override // com.google.common.cache.CacheLoader
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.ImmutableSet<java.lang.Class<?>> load(java.lang.Class<?> cls) {
            return com.google.common.collect.ImmutableSet.copyOf((java.util.Collection) com.google.common.reflect.TypeToken.of((java.lang.Class) cls).getTypes().rawTypes());
        }
    }

    public static final class MethodIdentifier {
        public final java.lang.String a;
        public final java.util.List<java.lang.Class<?>> b;

        public MethodIdentifier(java.lang.reflect.Method method) {
            this.a = method.getName();
            this.b = java.util.Arrays.asList(method.getParameterTypes());
        }

        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.eventbus.SubscriberRegistry.MethodIdentifier)) {
                return false;
            }
            com.google.common.eventbus.SubscriberRegistry.MethodIdentifier methodIdentifier = (com.google.common.eventbus.SubscriberRegistry.MethodIdentifier) obj;
            return this.a.equals(methodIdentifier.a) && this.b.equals(methodIdentifier.b);
        }

        public int hashCode() {
            return com.google.common.base.Objects.hashCode(this.a, this.b);
        }
    }

    public SubscriberRegistry(com.google.common.eventbus.EventBus eventBus) {
        this.b = (com.google.common.eventbus.EventBus) com.google.common.base.Preconditions.checkNotNull(eventBus);
    }

    @com.google.common.annotations.VisibleForTesting
    public static com.google.common.collect.ImmutableSet<java.lang.Class<?>> c(java.lang.Class<?> cls) {
        try {
            return d.getUnchecked(cls);
        } catch (com.google.common.util.concurrent.UncheckedExecutionException e) {
            throw com.google.common.base.Throwables.propagate(e.getCause());
        }
    }

    public static com.google.common.collect.ImmutableList<java.lang.reflect.Method> d(java.lang.Class<?> cls) {
        return c.getUnchecked(cls);
    }

    public static com.google.common.collect.ImmutableList<java.lang.reflect.Method> e(java.lang.Class<?> cls) {
        java.util.Set rawTypes = com.google.common.reflect.TypeToken.of((java.lang.Class) cls).getTypes().rawTypes();
        java.util.HashMap newHashMap = com.google.common.collect.Maps.newHashMap();
        java.util.Iterator it = rawTypes.iterator();
        while (it.hasNext()) {
            for (java.lang.reflect.Method method : ((java.lang.Class) it.next()).getDeclaredMethods()) {
                if (method.isAnnotationPresent(com.google.common.eventbus.Subscribe.class) && !method.isSynthetic()) {
                    java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
                    com.google.common.base.Preconditions.checkArgument(parameterTypes.length == 1, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", (java.lang.Object) method, parameterTypes.length);
                    com.google.common.eventbus.SubscriberRegistry.MethodIdentifier methodIdentifier = new com.google.common.eventbus.SubscriberRegistry.MethodIdentifier(method);
                    if (!newHashMap.containsKey(methodIdentifier)) {
                        newHashMap.put(methodIdentifier, method);
                    }
                }
            }
        }
        return com.google.common.collect.ImmutableList.copyOf(newHashMap.values());
    }

    public final com.google.common.collect.Multimap<java.lang.Class<?>, com.google.common.eventbus.Subscriber> b(java.lang.Object obj) {
        com.google.common.collect.HashMultimap create = com.google.common.collect.HashMultimap.create();
        com.google.common.collect.UnmodifiableIterator<java.lang.reflect.Method> it = d(obj.getClass()).iterator();
        while (it.hasNext()) {
            java.lang.reflect.Method next = it.next();
            create.put(next.getParameterTypes()[0], com.google.common.eventbus.Subscriber.d(this.b, obj, next));
        }
        return create;
    }

    public java.util.Iterator<com.google.common.eventbus.Subscriber> f(java.lang.Object obj) {
        com.google.common.collect.ImmutableSet<java.lang.Class<?>> c2 = c(obj.getClass());
        java.util.ArrayList newArrayListWithCapacity = com.google.common.collect.Lists.newArrayListWithCapacity(c2.size());
        com.google.common.collect.UnmodifiableIterator<java.lang.Class<?>> it = c2.iterator();
        while (it.hasNext()) {
            java.util.concurrent.CopyOnWriteArraySet<com.google.common.eventbus.Subscriber> copyOnWriteArraySet = this.a.get(it.next());
            if (copyOnWriteArraySet != null) {
                newArrayListWithCapacity.add(copyOnWriteArraySet.iterator());
            }
        }
        return com.google.common.collect.Iterators.concat(newArrayListWithCapacity.iterator());
    }

    public void g(java.lang.Object obj) {
        for (java.util.Map.Entry<java.lang.Class<?>, java.util.Collection<com.google.common.eventbus.Subscriber>> entry : b(obj).asMap().entrySet()) {
            java.lang.Class<?> key = entry.getKey();
            java.util.Collection<com.google.common.eventbus.Subscriber> value = entry.getValue();
            java.util.concurrent.CopyOnWriteArraySet<com.google.common.eventbus.Subscriber> copyOnWriteArraySet = this.a.get(key);
            if (copyOnWriteArraySet == null) {
                java.util.concurrent.CopyOnWriteArraySet<com.google.common.eventbus.Subscriber> copyOnWriteArraySet2 = new java.util.concurrent.CopyOnWriteArraySet<>();
                copyOnWriteArraySet = (java.util.concurrent.CopyOnWriteArraySet) com.google.common.base.MoreObjects.firstNonNull(this.a.putIfAbsent(key, copyOnWriteArraySet2), copyOnWriteArraySet2);
            }
            copyOnWriteArraySet.addAll(value);
        }
    }

    public void h(java.lang.Object obj) {
        for (java.util.Map.Entry<java.lang.Class<?>, java.util.Collection<com.google.common.eventbus.Subscriber>> entry : b(obj).asMap().entrySet()) {
            java.lang.Class<?> key = entry.getKey();
            java.util.Collection<com.google.common.eventbus.Subscriber> value = entry.getValue();
            java.util.concurrent.CopyOnWriteArraySet<com.google.common.eventbus.Subscriber> copyOnWriteArraySet = this.a.get(key);
            if (copyOnWriteArraySet == null || !copyOnWriteArraySet.removeAll(value)) {
                throw new java.lang.IllegalArgumentException("missing event subscriber for an annotated method. Is " + obj + " registered?");
            }
        }
    }
}
