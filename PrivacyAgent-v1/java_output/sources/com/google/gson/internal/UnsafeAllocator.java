package com.google.gson.internal;

/* loaded from: classes22.dex */
public abstract class UnsafeAllocator {

    /* renamed from: com.google.gson.internal.UnsafeAllocator$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.gson.internal.UnsafeAllocator {
        final /* synthetic */ java.lang.reflect.Method val$allocateInstance;
        final /* synthetic */ java.lang.Object val$unsafe;

        public AnonymousClass1(java.lang.reflect.Method method, java.lang.Object obj) {
            this.val$allocateInstance = method;
            this.val$unsafe = obj;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(java.lang.Class<T> cls) throws java.lang.Exception {
            com.google.gson.internal.UnsafeAllocator.assertInstantiable(cls);
            return (T) this.val$allocateInstance.invoke(this.val$unsafe, cls);
        }
    }

    /* renamed from: com.google.gson.internal.UnsafeAllocator$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.gson.internal.UnsafeAllocator {
        final /* synthetic */ int val$constructorId;
        final /* synthetic */ java.lang.reflect.Method val$newInstance;

        public AnonymousClass2(java.lang.reflect.Method method, int i) {
            this.val$newInstance = method;
            this.val$constructorId = i;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(java.lang.Class<T> cls) throws java.lang.Exception {
            com.google.gson.internal.UnsafeAllocator.assertInstantiable(cls);
            return (T) this.val$newInstance.invoke(null, cls, java.lang.Integer.valueOf(this.val$constructorId));
        }
    }

    /* renamed from: com.google.gson.internal.UnsafeAllocator$3, reason: invalid class name */
    public class AnonymousClass3 extends com.google.gson.internal.UnsafeAllocator {
        final /* synthetic */ java.lang.reflect.Method val$newInstance;

        public AnonymousClass3(java.lang.reflect.Method method) {
            this.val$newInstance = method;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(java.lang.Class<T> cls) throws java.lang.Exception {
            com.google.gson.internal.UnsafeAllocator.assertInstantiable(cls);
            return (T) this.val$newInstance.invoke(null, cls, java.lang.Object.class);
        }
    }

    /* renamed from: com.google.gson.internal.UnsafeAllocator$4, reason: invalid class name */
    public class AnonymousClass4 extends com.google.gson.internal.UnsafeAllocator {
        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(java.lang.Class<T> cls) {
            throw new java.lang.UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public static void assertInstantiable(java.lang.Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (java.lang.reflect.Modifier.isInterface(modifiers)) {
            throw new java.lang.UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
        if (java.lang.reflect.Modifier.isAbstract(modifiers)) {
            throw new java.lang.UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public static com.google.gson.internal.UnsafeAllocator create() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("sun.misc.Unsafe");
            java.lang.reflect.Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new com.google.gson.internal.UnsafeAllocator.AnonymousClass1(cls.getMethod("allocateInstance", java.lang.Class.class), declaredField.get(null));
        } catch (java.lang.Exception unused) {
            try {
                try {
                    java.lang.reflect.Method declaredMethod = java.io.ObjectStreamClass.class.getDeclaredMethod("getConstructorId", java.lang.Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((java.lang.Integer) declaredMethod.invoke(null, java.lang.Object.class)).intValue();
                    java.lang.reflect.Method declaredMethod2 = java.io.ObjectStreamClass.class.getDeclaredMethod("newInstance", java.lang.Class.class, java.lang.Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new com.google.gson.internal.UnsafeAllocator.AnonymousClass2(declaredMethod2, intValue);
                } catch (java.lang.Exception unused2) {
                    java.lang.reflect.Method declaredMethod3 = java.io.ObjectInputStream.class.getDeclaredMethod("newInstance", java.lang.Class.class, java.lang.Class.class);
                    declaredMethod3.setAccessible(true);
                    return new com.google.gson.internal.UnsafeAllocator.AnonymousClass3(declaredMethod3);
                }
            } catch (java.lang.Exception unused3) {
                return new com.google.gson.internal.UnsafeAllocator.AnonymousClass4();
            }
        }
    }

    public abstract <T> T newInstance(java.lang.Class<T> cls) throws java.lang.Exception;
}
