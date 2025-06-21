package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
class SubscriberMethodFinder {
    public static final java.util.Map<java.lang.Class<?>, java.util.List<org.greenrobot.eventbus.SubscriberMethod>> d = new java.util.concurrent.ConcurrentHashMap();
    public static final org.greenrobot.eventbus.SubscriberMethodFinder.FindState[] e = new org.greenrobot.eventbus.SubscriberMethodFinder.FindState[4];
    public java.util.List<org.greenrobot.eventbus.meta.SubscriberInfoIndex> a;
    public final boolean b;
    public final boolean c;

    public static class FindState {
        public final java.util.List<org.greenrobot.eventbus.SubscriberMethod> a = new java.util.ArrayList();
        public final java.util.Map<java.lang.Class, java.lang.Object> b = new java.util.HashMap();
        public final java.util.Map<java.lang.String, java.lang.Class> c = new java.util.HashMap();
        public final java.lang.StringBuilder d = new java.lang.StringBuilder(128);
        public java.lang.Class<?> e;
        public java.lang.Class<?> f;
        public boolean g;
        public org.greenrobot.eventbus.meta.SubscriberInfo h;

        public boolean a(java.lang.reflect.Method method, java.lang.Class<?> cls) {
            java.lang.Object put = this.b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof java.lang.reflect.Method) {
                if (!b((java.lang.reflect.Method) put, cls)) {
                    throw new java.lang.IllegalStateException();
                }
                this.b.put(cls, this);
            }
            return b(method, cls);
        }

        public final boolean b(java.lang.reflect.Method method, java.lang.Class<?> cls) {
            this.d.setLength(0);
            this.d.append(method.getName());
            java.lang.StringBuilder sb = this.d;
            sb.append(kotlin.text.Typography.greater);
            sb.append(cls.getName());
            java.lang.String sb2 = this.d.toString();
            java.lang.Class<?> declaringClass = method.getDeclaringClass();
            java.lang.Class put = this.c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.c.put(sb2, put);
            return false;
        }

        public void c(java.lang.Class<?> cls) {
            this.f = cls;
            this.e = cls;
            this.g = false;
            this.h = null;
        }

        public void d() {
            if (this.g) {
                this.f = null;
                return;
            }
            java.lang.Class<? super java.lang.Object> superclass = this.f.getSuperclass();
            this.f = superclass;
            java.lang.String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.f = null;
            }
        }

        public void e() {
            this.a.clear();
            this.b.clear();
            this.c.clear();
            this.d.setLength(0);
            this.e = null;
            this.f = null;
            this.g = false;
            this.h = null;
        }
    }

    public SubscriberMethodFinder(java.util.List<org.greenrobot.eventbus.meta.SubscriberInfoIndex> list, boolean z, boolean z2) {
        this.a = list;
        this.b = z;
        this.c = z2;
    }

    public static void a() {
        d.clear();
    }

    public java.util.List<org.greenrobot.eventbus.SubscriberMethod> b(java.lang.Class<?> cls) {
        java.util.Map<java.lang.Class<?>, java.util.List<org.greenrobot.eventbus.SubscriberMethod>> map = d;
        java.util.List<org.greenrobot.eventbus.SubscriberMethod> list = map.get(cls);
        if (list != null) {
            return list;
        }
        java.util.List<org.greenrobot.eventbus.SubscriberMethod> d2 = this.c ? d(cls) : c(cls);
        if (!d2.isEmpty()) {
            map.put(cls, d2);
            return d2;
        }
        throw new org.greenrobot.eventbus.EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    public final java.util.List<org.greenrobot.eventbus.SubscriberMethod> c(java.lang.Class<?> cls) {
        org.greenrobot.eventbus.SubscriberMethodFinder.FindState h = h();
        h.c(cls);
        while (h.f != null) {
            org.greenrobot.eventbus.meta.SubscriberInfo g = g(h);
            h.h = g;
            if (g != null) {
                for (org.greenrobot.eventbus.SubscriberMethod subscriberMethod : g.getSubscriberMethods()) {
                    if (h.a(subscriberMethod.a, subscriberMethod.c)) {
                        h.a.add(subscriberMethod);
                    }
                }
            } else {
                e(h);
            }
            h.d();
        }
        return f(h);
    }

    public final java.util.List<org.greenrobot.eventbus.SubscriberMethod> d(java.lang.Class<?> cls) {
        org.greenrobot.eventbus.SubscriberMethodFinder.FindState h = h();
        h.c(cls);
        while (h.f != null) {
            e(h);
            h.d();
        }
        return f(h);
    }

    public final void e(org.greenrobot.eventbus.SubscriberMethodFinder.FindState findState) {
        java.lang.reflect.Method[] methods;
        try {
            try {
                methods = findState.f.getDeclaredMethods();
            } catch (java.lang.Throwable unused) {
                methods = findState.f.getMethods();
                findState.g = true;
            }
            for (java.lang.reflect.Method method : methods) {
                int modifiers = method.getModifiers();
                if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                    java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        org.greenrobot.eventbus.Subscribe subscribe = (org.greenrobot.eventbus.Subscribe) method.getAnnotation(org.greenrobot.eventbus.Subscribe.class);
                        if (subscribe != null) {
                            java.lang.Class<?> cls = parameterTypes[0];
                            if (findState.a(method, cls)) {
                                findState.a.add(new org.greenrobot.eventbus.SubscriberMethod(method, cls, subscribe.threadMode(), subscribe.priority(), subscribe.sticky()));
                            }
                        }
                    } else if (this.b && method.isAnnotationPresent(org.greenrobot.eventbus.Subscribe.class)) {
                        throw new org.greenrobot.eventbus.EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                    }
                } else if (this.b && method.isAnnotationPresent(org.greenrobot.eventbus.Subscribe.class)) {
                    throw new org.greenrobot.eventbus.EventBusException((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
                }
            }
        } catch (java.lang.LinkageError e2) {
            java.lang.String str = "Could not inspect methods of " + findState.f.getName();
            throw new org.greenrobot.eventbus.EventBusException(this.c ? str + ". Please consider using EventBus annotation processor to avoid reflection." : str + ". Please make this class visible to EventBus annotation processor to avoid reflection.", e2);
        }
    }

    public final java.util.List<org.greenrobot.eventbus.SubscriberMethod> f(org.greenrobot.eventbus.SubscriberMethodFinder.FindState findState) {
        java.util.ArrayList arrayList = new java.util.ArrayList(findState.a);
        findState.e();
        synchronized (e) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                org.greenrobot.eventbus.SubscriberMethodFinder.FindState[] findStateArr = e;
                if (findStateArr[i] == null) {
                    findStateArr[i] = findState;
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    public final org.greenrobot.eventbus.meta.SubscriberInfo g(org.greenrobot.eventbus.SubscriberMethodFinder.FindState findState) {
        org.greenrobot.eventbus.meta.SubscriberInfo subscriberInfo = findState.h;
        if (subscriberInfo != null && subscriberInfo.getSuperSubscriberInfo() != null) {
            org.greenrobot.eventbus.meta.SubscriberInfo superSubscriberInfo = findState.h.getSuperSubscriberInfo();
            if (findState.f == superSubscriberInfo.getSubscriberClass()) {
                return superSubscriberInfo;
            }
        }
        java.util.List<org.greenrobot.eventbus.meta.SubscriberInfoIndex> list = this.a;
        if (list == null) {
            return null;
        }
        java.util.Iterator<org.greenrobot.eventbus.meta.SubscriberInfoIndex> it = list.iterator();
        while (it.hasNext()) {
            org.greenrobot.eventbus.meta.SubscriberInfo subscriberInfo2 = it.next().getSubscriberInfo(findState.f);
            if (subscriberInfo2 != null) {
                return subscriberInfo2;
            }
        }
        return null;
    }

    public final org.greenrobot.eventbus.SubscriberMethodFinder.FindState h() {
        synchronized (e) {
            for (int i = 0; i < 4; i++) {
                org.greenrobot.eventbus.SubscriberMethodFinder.FindState[] findStateArr = e;
                org.greenrobot.eventbus.SubscriberMethodFinder.FindState findState = findStateArr[i];
                if (findState != null) {
                    findStateArr[i] = null;
                    return findState;
                }
            }
            return new org.greenrobot.eventbus.SubscriberMethodFinder.FindState();
        }
    }
}
