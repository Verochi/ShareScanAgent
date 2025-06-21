package com.google.gson.internal;

/* loaded from: classes22.dex */
public final class ConstructorConstructor {
    private final com.google.gson.internal.reflect.ReflectionAccessor accessor = com.google.gson.internal.reflect.ReflectionAccessor.getInstance();
    private final java.util.Map<java.lang.reflect.Type, com.google.gson.InstanceCreator<?>> instanceCreators;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$1, reason: invalid class name */
    public class AnonymousClass1<T> implements com.google.gson.internal.ObjectConstructor<T> {
        final /* synthetic */ java.lang.reflect.Type val$type;
        final /* synthetic */ com.google.gson.InstanceCreator val$typeCreator;

        public AnonymousClass1(com.google.gson.InstanceCreator instanceCreator, java.lang.reflect.Type type) {
            this.val$typeCreator = instanceCreator;
            this.val$type = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) this.val$typeCreator.createInstance(this.val$type);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$10, reason: invalid class name */
    public class AnonymousClass10<T> implements com.google.gson.internal.ObjectConstructor<T> {
        public AnonymousClass10() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new java.util.concurrent.ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$11, reason: invalid class name */
    public class AnonymousClass11<T> implements com.google.gson.internal.ObjectConstructor<T> {
        public AnonymousClass11() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new java.util.TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$12, reason: invalid class name */
    public class AnonymousClass12<T> implements com.google.gson.internal.ObjectConstructor<T> {
        public AnonymousClass12() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new java.util.LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$13, reason: invalid class name */
    public class AnonymousClass13<T> implements com.google.gson.internal.ObjectConstructor<T> {
        public AnonymousClass13() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new com.google.gson.internal.LinkedTreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$14, reason: invalid class name */
    public class AnonymousClass14<T> implements com.google.gson.internal.ObjectConstructor<T> {
        private final com.google.gson.internal.UnsafeAllocator unsafeAllocator = com.google.gson.internal.UnsafeAllocator.create();
        final /* synthetic */ java.lang.Class val$rawType;
        final /* synthetic */ java.lang.reflect.Type val$type;

        public AnonymousClass14(java.lang.Class cls, java.lang.reflect.Type type) {
            this.val$rawType = cls;
            this.val$type = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            try {
                return (T) this.unsafeAllocator.newInstance(this.val$rawType);
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException("Unable to invoke no-args constructor for " + this.val$type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$2, reason: invalid class name */
    public class AnonymousClass2<T> implements com.google.gson.internal.ObjectConstructor<T> {
        final /* synthetic */ com.google.gson.InstanceCreator val$rawTypeCreator;
        final /* synthetic */ java.lang.reflect.Type val$type;

        public AnonymousClass2(com.google.gson.InstanceCreator instanceCreator, java.lang.reflect.Type type) {
            this.val$rawTypeCreator = instanceCreator;
            this.val$type = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) this.val$rawTypeCreator.createInstance(this.val$type);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$3, reason: invalid class name */
    public class AnonymousClass3<T> implements com.google.gson.internal.ObjectConstructor<T> {
        final /* synthetic */ java.lang.reflect.Constructor val$constructor;

        public AnonymousClass3(java.lang.reflect.Constructor constructor) {
            this.val$constructor = constructor;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            try {
                return (T) this.val$constructor.newInstance(null);
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.AssertionError(e);
            } catch (java.lang.InstantiationException e2) {
                throw new java.lang.RuntimeException("Failed to invoke " + this.val$constructor + " with no args", e2);
            } catch (java.lang.reflect.InvocationTargetException e3) {
                throw new java.lang.RuntimeException("Failed to invoke " + this.val$constructor + " with no args", e3.getTargetException());
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$4, reason: invalid class name */
    public class AnonymousClass4<T> implements com.google.gson.internal.ObjectConstructor<T> {
        public AnonymousClass4() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new java.util.TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$5, reason: invalid class name */
    public class AnonymousClass5<T> implements com.google.gson.internal.ObjectConstructor<T> {
        final /* synthetic */ java.lang.reflect.Type val$type;

        public AnonymousClass5(java.lang.reflect.Type type) {
            this.val$type = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            java.lang.reflect.Type type = this.val$type;
            if (!(type instanceof java.lang.reflect.ParameterizedType)) {
                throw new com.google.gson.JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
            }
            java.lang.reflect.Type type2 = ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof java.lang.Class) {
                return (T) java.util.EnumSet.noneOf((java.lang.Class) type2);
            }
            throw new com.google.gson.JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$6, reason: invalid class name */
    public class AnonymousClass6<T> implements com.google.gson.internal.ObjectConstructor<T> {
        public AnonymousClass6() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new java.util.LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$7, reason: invalid class name */
    public class AnonymousClass7<T> implements com.google.gson.internal.ObjectConstructor<T> {
        public AnonymousClass7() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new java.util.ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$8, reason: invalid class name */
    public class AnonymousClass8<T> implements com.google.gson.internal.ObjectConstructor<T> {
        public AnonymousClass8() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new java.util.ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$9, reason: invalid class name */
    public class AnonymousClass9<T> implements com.google.gson.internal.ObjectConstructor<T> {
        public AnonymousClass9() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new java.util.concurrent.ConcurrentSkipListMap();
        }
    }

    public ConstructorConstructor(java.util.Map<java.lang.reflect.Type, com.google.gson.InstanceCreator<?>> map) {
        this.instanceCreators = map;
    }

    private <T> com.google.gson.internal.ObjectConstructor<T> newDefaultConstructor(java.lang.Class<? super T> cls) {
        try {
            java.lang.reflect.Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new java.lang.Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.accessor.makeAccessible(declaredConstructor);
            }
            return new com.google.gson.internal.ConstructorConstructor.AnonymousClass3(declaredConstructor);
        } catch (java.lang.NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> com.google.gson.internal.ObjectConstructor<T> newDefaultImplementationConstructor(java.lang.reflect.Type type, java.lang.Class<? super T> cls) {
        if (java.util.Collection.class.isAssignableFrom(cls)) {
            return java.util.SortedSet.class.isAssignableFrom(cls) ? new com.google.gson.internal.ConstructorConstructor.AnonymousClass4() : java.util.EnumSet.class.isAssignableFrom(cls) ? new com.google.gson.internal.ConstructorConstructor.AnonymousClass5(type) : java.util.Set.class.isAssignableFrom(cls) ? new com.google.gson.internal.ConstructorConstructor.AnonymousClass6() : java.util.Queue.class.isAssignableFrom(cls) ? new com.google.gson.internal.ConstructorConstructor.AnonymousClass7() : new com.google.gson.internal.ConstructorConstructor.AnonymousClass8();
        }
        if (java.util.Map.class.isAssignableFrom(cls)) {
            return java.util.concurrent.ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new com.google.gson.internal.ConstructorConstructor.AnonymousClass9() : java.util.concurrent.ConcurrentMap.class.isAssignableFrom(cls) ? new com.google.gson.internal.ConstructorConstructor.AnonymousClass10() : java.util.SortedMap.class.isAssignableFrom(cls) ? new com.google.gson.internal.ConstructorConstructor.AnonymousClass11() : (!(type instanceof java.lang.reflect.ParameterizedType) || java.lang.String.class.isAssignableFrom(com.google.gson.reflect.TypeToken.get(((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new com.google.gson.internal.ConstructorConstructor.AnonymousClass13() : new com.google.gson.internal.ConstructorConstructor.AnonymousClass12();
        }
        return null;
    }

    private <T> com.google.gson.internal.ObjectConstructor<T> newUnsafeAllocator(java.lang.reflect.Type type, java.lang.Class<? super T> cls) {
        return new com.google.gson.internal.ConstructorConstructor.AnonymousClass14(cls, type);
    }

    public <T> com.google.gson.internal.ObjectConstructor<T> get(com.google.gson.reflect.TypeToken<T> typeToken) {
        java.lang.reflect.Type type = typeToken.getType();
        java.lang.Class<? super T> rawType = typeToken.getRawType();
        com.google.gson.InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new com.google.gson.internal.ConstructorConstructor.AnonymousClass1(instanceCreator, type);
        }
        com.google.gson.InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new com.google.gson.internal.ConstructorConstructor.AnonymousClass2(instanceCreator2, type);
        }
        com.google.gson.internal.ObjectConstructor<T> newDefaultConstructor = newDefaultConstructor(rawType);
        if (newDefaultConstructor != null) {
            return newDefaultConstructor;
        }
        com.google.gson.internal.ObjectConstructor<T> newDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        return newDefaultImplementationConstructor != null ? newDefaultImplementationConstructor : newUnsafeAllocator(type, rawType);
    }

    public java.lang.String toString() {
        return this.instanceCreators.toString();
    }
}
