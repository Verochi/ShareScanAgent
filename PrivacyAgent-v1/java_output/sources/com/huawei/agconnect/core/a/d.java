package com.huawei.agconnect.core.a;

/* loaded from: classes22.dex */
public final class d {
    public static java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> c = new java.util.HashMap();
    public static java.util.Map<java.lang.Class<?>, java.lang.Object> d = new java.util.HashMap();
    public java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> a = new java.util.HashMap();
    public java.util.Map<java.lang.Class<?>, java.lang.Object> b = new java.util.HashMap();

    public d(java.util.List<com.huawei.agconnect.core.Service> list, android.content.Context context) {
        a(list, context);
    }

    public static java.lang.reflect.Constructor b(java.lang.Class cls, java.lang.Class... clsArr) {
        boolean z = false;
        for (java.lang.reflect.Constructor<?> constructor : cls.getDeclaredConstructors()) {
            java.lang.Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i = 0; i < clsArr.length; i++) {
                    z = parameterTypes[i] == clsArr[i];
                }
                if (z) {
                    return constructor;
                }
            }
        }
        return null;
    }

    public final java.lang.Object a(com.huawei.agconnect.AGConnectInstance aGConnectInstance, com.huawei.agconnect.core.Service service) {
        java.lang.StringBuilder sb;
        if (service.getInstance() != null) {
            return service.getInstance();
        }
        java.lang.Class<?> type = service.getType();
        if (type == null) {
            return null;
        }
        try {
            java.lang.reflect.Constructor b = b(type, android.content.Context.class, com.huawei.agconnect.AGConnectInstance.class);
            if (b != null) {
                return b.newInstance(aGConnectInstance.getContext(), aGConnectInstance);
            }
            java.lang.reflect.Constructor b2 = b(type, android.content.Context.class);
            return b2 != null ? b2.newInstance(aGConnectInstance.getContext()) : type.newInstance();
        } catch (java.lang.IllegalAccessException e) {
            e = e;
            sb = new java.lang.StringBuilder();
            sb.append("Instantiate service exception ");
            sb.append(e.getLocalizedMessage());
            return null;
        } catch (java.lang.InstantiationException e2) {
            e = e2;
            sb = new java.lang.StringBuilder();
            sb.append("Instantiate service exception ");
            sb.append(e.getLocalizedMessage());
            return null;
        } catch (java.lang.reflect.InvocationTargetException e3) {
            e = e3;
            sb = new java.lang.StringBuilder();
            sb.append("Instantiate service exception ");
            sb.append(e.getLocalizedMessage());
            return null;
        }
    }

    public <T> T a(com.huawei.agconnect.AGConnectInstance aGConnectInstance, java.lang.Class<?> cls) {
        T t;
        com.huawei.agconnect.core.Service service = this.a.get(cls);
        if (service == null && (service = c.get(cls)) != null) {
            return (T) d.get(cls);
        }
        if (service == null) {
            return null;
        }
        if (service.isSingleton() && (t = (T) this.b.get(cls)) != null) {
            return t;
        }
        T t2 = (T) a(aGConnectInstance, service);
        if (t2 != null && service.isSingleton()) {
            this.b.put(cls, t2);
        }
        return t2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005b A[Catch: InvocationTargetException -> 0x0076, InstantiationException -> 0x007a, IllegalAccessException -> 0x007e, TryCatch #2 {IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076, blocks: (B:22:0x0049, B:26:0x005b, B:27:0x006c, B:30:0x0064), top: B:21:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064 A[Catch: InvocationTargetException -> 0x0076, InstantiationException -> 0x007a, IllegalAccessException -> 0x007e, TryCatch #2 {IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076, blocks: (B:22:0x0049, B:26:0x005b, B:27:0x006c, B:30:0x0064), top: B:21:0x0049 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(java.util.List<com.huawei.agconnect.core.Service> list, android.content.Context context) {
        java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> map;
        java.lang.String str;
        if (list == null) {
            return;
        }
        for (com.huawei.agconnect.core.Service service : list) {
            if (service.isSharedInstance()) {
                if (!c.containsKey(service.getInterface())) {
                    map = c;
                }
                if (service.isAutoCreated() && service.getType() != null && !d.containsKey(service.getInterface())) {
                    try {
                        java.lang.reflect.Constructor b = b(service.getType(), android.content.Context.class);
                        d.put(service.getInterface(), b == null ? b.newInstance(context) : service.getType().newInstance());
                    } catch (java.lang.IllegalAccessException e) {
                        e = e;
                        str = "AccessException";
                        c(str, e);
                    } catch (java.lang.InstantiationException e2) {
                        e = e2;
                        str = "InstantiationException";
                        c(str, e);
                    } catch (java.lang.reflect.InvocationTargetException e3) {
                        e = e3;
                        str = "TargetException";
                        c(str, e);
                    }
                }
            } else {
                map = this.a;
            }
            map.put(service.getInterface(), service);
            if (service.isAutoCreated()) {
                java.lang.reflect.Constructor b2 = b(service.getType(), android.content.Context.class);
                d.put(service.getInterface(), b2 == null ? b2.newInstance(context) : service.getType().newInstance());
            }
        }
    }

    public final void c(java.lang.String str, java.lang.Exception exc) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Instantiate shared service ");
        sb.append(str);
        sb.append(exc.getLocalizedMessage());
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("cause message:");
        sb2.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
    }
}
