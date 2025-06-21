package com.huawei.agconnect.core;

/* loaded from: classes22.dex */
public class Service {
    public final java.lang.Class<?> a;
    public final java.lang.Class<?> b;
    public final java.lang.Object c;
    public boolean d;
    public boolean e;
    public boolean f;

    public static class Builder {
        public java.lang.Class<?> a;
        public java.lang.Class<?> b;
        public java.lang.Object c;
        public boolean d;
        public boolean e;
        public boolean f;

        public com.huawei.agconnect.core.Service build() {
            java.lang.Class<?> cls = this.a;
            if (cls == null) {
                throw new java.lang.IllegalArgumentException("the interface parameter cannot be NULL");
            }
            java.lang.Class<?> cls2 = this.b;
            if (cls2 == null) {
                java.lang.Object obj = this.c;
                if (obj == null) {
                    throw new java.lang.IllegalArgumentException("the clazz or object parameter must set one");
                }
                com.huawei.agconnect.core.Service service = new com.huawei.agconnect.core.Service(cls, obj, (com.huawei.agconnect.core.Service.AnonymousClass1) null);
                service.d = this.d;
                return service;
            }
            if (cls2.isInterface() || !java.lang.reflect.Modifier.isPublic(this.b.getModifiers())) {
                throw new java.lang.IllegalArgumentException("the clazz parameter cant be interface type or not public");
            }
            com.huawei.agconnect.core.Service service2 = new com.huawei.agconnect.core.Service((java.lang.Class) this.a, (java.lang.Class) this.b, (com.huawei.agconnect.core.Service.AnonymousClass1) null);
            service2.d = this.d;
            service2.e = this.e;
            service2.f = this.f;
            return service2;
        }

        public com.huawei.agconnect.core.Service.Builder isAutoCreated(boolean z) {
            this.f = z;
            return this;
        }

        public com.huawei.agconnect.core.Service.Builder isSharedInstance(boolean z) {
            this.e = z;
            return this;
        }

        public com.huawei.agconnect.core.Service.Builder isSingleton(boolean z) {
            this.d = z;
            return this;
        }

        public com.huawei.agconnect.core.Service.Builder setClass(java.lang.Class<?> cls) {
            this.b = cls;
            return this;
        }

        public com.huawei.agconnect.core.Service.Builder setInterface(java.lang.Class<?> cls) {
            this.a = cls;
            return this;
        }

        public com.huawei.agconnect.core.Service.Builder setObject(java.lang.Object obj) {
            this.c = obj;
            return this;
        }
    }

    public Service(java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        this.a = cls;
        this.b = cls2;
        this.c = null;
    }

    public /* synthetic */ Service(java.lang.Class cls, java.lang.Class cls2, com.huawei.agconnect.core.Service.AnonymousClass1 anonymousClass1) {
        this((java.lang.Class<?>) cls, (java.lang.Class<?>) cls2);
    }

    public Service(java.lang.Class<?> cls, java.lang.Object obj) {
        this.a = cls;
        this.b = null;
        this.c = obj;
    }

    public /* synthetic */ Service(java.lang.Class cls, java.lang.Object obj, com.huawei.agconnect.core.Service.AnonymousClass1 anonymousClass1) {
        this((java.lang.Class<?>) cls, obj);
    }

    public static com.huawei.agconnect.core.Service.Builder builder(java.lang.Class<?> cls) {
        return new com.huawei.agconnect.core.Service.Builder().setInterface(cls).setClass(cls).isSingleton(cls.isAnnotationPresent(com.huawei.agconnect.annotation.Singleton.class)).isSharedInstance(cls.isAnnotationPresent(com.huawei.agconnect.annotation.SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(com.huawei.agconnect.annotation.AutoCreated.class));
    }

    public static com.huawei.agconnect.core.Service.Builder builder(java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        return new com.huawei.agconnect.core.Service.Builder().setInterface(cls).setClass(cls2).isSingleton(cls2.isAnnotationPresent(com.huawei.agconnect.annotation.Singleton.class)).isSharedInstance(cls2.isAnnotationPresent(com.huawei.agconnect.annotation.SharedInstance.class)).isAutoCreated(cls2.isAnnotationPresent(com.huawei.agconnect.annotation.AutoCreated.class));
    }

    public static com.huawei.agconnect.core.Service.Builder builder(java.lang.Class<?> cls, java.lang.Object obj) {
        return new com.huawei.agconnect.core.Service.Builder().setInterface(cls).setObject(obj).isSingleton(true).isSharedInstance(cls.isAnnotationPresent(com.huawei.agconnect.annotation.SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(com.huawei.agconnect.annotation.AutoCreated.class));
    }

    public java.lang.Object getInstance() {
        return this.c;
    }

    public java.lang.Class<?> getInterface() {
        return this.a;
    }

    public java.lang.Class<?> getType() {
        return this.b;
    }

    public boolean isAutoCreated() {
        return this.f;
    }

    public boolean isSharedInstance() {
        return this.e;
    }

    public boolean isSingleton() {
        return this.d;
    }
}
