package com.igexin.assist.control.meizu;

/* loaded from: classes22.dex */
public class c {
    private static final java.util.HashMap<java.lang.String, java.lang.reflect.Method> a = new java.util.HashMap<>();
    private final com.igexin.assist.control.meizu.A b;
    private final java.lang.String c;
    private java.lang.Class<?>[] d;

    public class a {
        private a() {
        }
    }

    public c(com.igexin.assist.control.meizu.A a2, java.lang.String str, java.lang.Class<?>... clsArr) {
        this.b = a2;
        this.c = str;
        this.d = clsArr;
    }

    private java.lang.Class<?> a(java.lang.Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? java.lang.Boolean.TYPE == cls ? java.lang.Boolean.class : java.lang.Integer.TYPE == cls ? java.lang.Integer.class : java.lang.Long.TYPE == cls ? java.lang.Long.class : java.lang.Short.TYPE == cls ? java.lang.Short.class : java.lang.Byte.TYPE == cls ? java.lang.Byte.class : java.lang.Double.TYPE == cls ? java.lang.Double.class : java.lang.Float.TYPE == cls ? java.lang.Float.class : java.lang.Character.TYPE == cls ? java.lang.Character.class : java.lang.Void.TYPE == cls ? java.lang.Void.class : cls : cls;
    }

    private java.lang.reflect.Method a() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        java.lang.Class<?> a2 = this.b.a();
        int i = 0;
        for (java.lang.reflect.Method method : a2.getMethods()) {
            if (a(method, this.c, this.d)) {
                return method;
            }
        }
        java.lang.reflect.Method[] declaredMethods = a2.getDeclaredMethods();
        int length = declaredMethods.length;
        while (i < length) {
            if (!a(declaredMethods[i], this.c, this.d)) {
                i++;
            }
        }
        throw new java.lang.NoSuchMethodException("No similar method " + this.c + " with params " + java.util.Arrays.toString(this.d) + " could be found on type " + a2);
    }

    private boolean a(java.lang.reflect.Method method, java.lang.String str, java.lang.Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(java.lang.Class<?>[] clsArr, java.lang.Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != com.igexin.assist.control.meizu.c.a.class && !a(clsArr[i]).isAssignableFrom(a(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    private java.lang.String b() throws java.lang.ClassNotFoundException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.b.a().getName());
        sb.append(this.c);
        for (java.lang.Class<?> cls : this.d) {
            sb.append(cls.getName());
        }
        return sb.toString();
    }

    public <T> com.igexin.assist.control.meizu.d<T> a(java.lang.Object... objArr) {
        try {
            return a(this.b.a(), objArr);
        } catch (java.lang.ClassNotFoundException unused) {
            return new com.igexin.assist.control.meizu.d<>();
        }
    }

    public <T> com.igexin.assist.control.meizu.d<T> aa(java.lang.Object obj, java.lang.Object... objArr) {
        com.igexin.assist.control.meizu.d<T> dVar = new com.igexin.assist.control.meizu.d<>();
        try {
            java.lang.String b = b();
            java.lang.reflect.Method method = a.get(b);
            if (method == null) {
                if (this.d.length == objArr.length) {
                    method = this.b.a().getMethod(this.c, this.d);
                } else {
                    if (objArr.length > 0) {
                        this.d = new java.lang.Class[objArr.length];
                        for (int i = 0; i < objArr.length; i++) {
                            this.d[i] = objArr[i].getClass();
                        }
                    }
                    method = a();
                }
                a.put(b, method);
            }
            method.setAccessible(true);
            dVar.b = objArr.length == 0 ? (T) method.invoke(this, obj) : (T) method.invoke(this, obj, objArr);
            dVar.a = true;
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("ReflectMethod", "invoke", e);
        }
        return dVar;
    }
}
