package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class at {
    private static volatile java.util.Map<java.lang.String, com.baidu.mobads.sdk.internal.at> c = new java.util.HashMap();
    private java.lang.Class<?> a;
    private java.lang.reflect.Method[] b;

    private at(android.content.Context context, java.lang.String str) {
        this.b = null;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str, true, com.baidu.mobads.sdk.internal.bs.a(context));
            this.a = cls;
            this.b = cls.getMethods();
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().a(th);
        }
    }

    public static com.baidu.mobads.sdk.internal.at a(android.content.Context context, java.lang.String str) {
        if (!c.containsKey(str) || c.get(str).a == null) {
            synchronized (com.baidu.mobads.sdk.internal.at.class) {
                if (!c.containsKey(str) || c.get(str).a == null) {
                    c.put(str, new com.baidu.mobads.sdk.internal.at(context, str));
                }
            }
        }
        return c.get(str);
    }

    private java.lang.reflect.Method a(java.lang.String str) {
        java.lang.reflect.Method[] methodArr = this.b;
        if (methodArr == null) {
            return null;
        }
        for (java.lang.reflect.Method method : methodArr) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    public java.lang.Object a(java.lang.Class<?>[] clsArr, java.lang.Object... objArr) {
        java.lang.reflect.Constructor<?> constructor;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    constructor = this.a.getConstructor(clsArr);
                    return constructor.newInstance(objArr);
                }
            } catch (java.lang.Throwable th) {
                com.baidu.mobads.sdk.internal.bt.a().a(th);
                return null;
            }
        }
        constructor = this.a.getConstructor(new java.lang.Class[0]);
        return constructor.newInstance(objArr);
    }

    public void a(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        try {
            java.lang.reflect.Method a = a(str);
            if (a != null) {
                if (objArr != null && objArr.length != 0) {
                    a.invoke(obj, objArr);
                }
                a.invoke(obj, new java.lang.Object[0]);
            }
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().a(th);
        }
    }

    public java.lang.Object b(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        try {
            java.lang.reflect.Method a = a(str);
            if (a == null) {
                return null;
            }
            if (objArr != null && objArr.length != 0) {
                return a.invoke(obj, objArr);
            }
            return a.invoke(obj, new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #0 {all -> 0x001f, blocks: (B:2:0x0000, B:5:0x0008, B:8:0x000c, B:9:0x0018, B:11:0x001c, B:16:0x0011), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String c(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        java.lang.Object invoke;
        try {
            java.lang.reflect.Method a = a(str);
            if (a == null) {
                return null;
            }
            if (objArr != null && objArr.length != 0) {
                invoke = a.invoke(obj, objArr);
                if (invoke instanceof java.lang.String) {
                    return null;
                }
                return (java.lang.String) invoke;
            }
            invoke = a.invoke(obj, new java.lang.Object[0]);
            if (invoke instanceof java.lang.String) {
            }
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().a(th);
            return null;
        }
    }
}
