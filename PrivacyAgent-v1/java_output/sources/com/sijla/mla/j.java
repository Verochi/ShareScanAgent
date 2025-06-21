package com.sijla.mla;

/* loaded from: classes19.dex */
public final class j {
    private static java.util.HashSet<java.lang.String> a;
    private static java.util.HashMap<java.lang.String, java.lang.Class<?>> b;
    private static java.util.HashMap<java.lang.Class<?>, java.lang.String> c;
    private static com.sijla.mla.a<java.lang.String, java.lang.reflect.Method> d;
    private static com.sijla.mla.a<java.lang.String, java.lang.reflect.Constructor<?>> e;

    static {
        java.util.HashSet<java.lang.String> hashSet = new java.util.HashSet<>();
        a = hashSet;
        hashSet.add(com.sijla.mla.L2.s1549557450());
        a.add(com.sijla.mla.L2.s1906767854());
        a.add(com.sijla.mla.L2.s1019884280());
        a.add(com.sijla.mla.L2.s1019880591());
        a.add(com.sijla.mla.L2.s1558430518());
        b = new java.util.HashMap<>();
        c = new java.util.HashMap<>();
        d = new com.sijla.mla.a<>(25);
        e = new com.sijla.mla.a<>(5);
    }

    public static <T> T a(java.lang.Object obj, java.lang.String str) {
        try {
            return (T) b(obj, str);
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchFieldException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + obj.getClass() + ", fieldName: " + str, th);
        }
    }

    public static <T> T a(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        try {
            java.lang.Class<?> cls = obj.getClass();
            java.lang.String str2 = cls.getName() + "#" + str + "#" + objArr.length;
            java.lang.reflect.Method a2 = d.a(str2);
            java.lang.Class<?>[] a3 = a(objArr);
            if (a2 != null && !java.lang.reflect.Modifier.isStatic(a2.getModifiers()) && a(a2.getParameterTypes(), a3)) {
                a2.setAccessible(true);
                if (a2.getReturnType() != java.lang.Void.TYPE) {
                    return (T) a2.invoke(obj, objArr);
                }
                a2.invoke(obj, objArr);
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            while (cls != null) {
                arrayList.add(cls);
                cls = cls.getSuperclass();
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                for (java.lang.reflect.Method method : ((java.lang.Class) it.next()).getDeclaredMethods()) {
                    if (method.getName().equals(str) && !java.lang.reflect.Modifier.isStatic(method.getModifiers()) && a(method.getParameterTypes(), a3)) {
                        d.a(str2, method);
                        method.setAccessible(true);
                        if (method.getReturnType() != java.lang.Void.TYPE) {
                            return (T) method.invoke(obj, objArr);
                        }
                        method.invoke(obj, objArr);
                        return null;
                    }
                }
            }
            throw new java.lang.NoSuchMethodException("className: " + obj.getClass() + ", methodName: " + str + ", args: " + java.util.Arrays.toString(objArr));
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchMethodException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + obj.getClass() + ", methodName: " + str + ", args: " + java.util.Arrays.toString(objArr), th);
        }
    }

    public static <T> T a(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        try {
            java.lang.String str3 = str + "#" + str2 + "#" + objArr.length;
            java.lang.reflect.Method a2 = d.a(str3);
            java.lang.Class<?>[] a3 = a(objArr);
            if (a2 != null && java.lang.reflect.Modifier.isStatic(a2.getModifiers()) && a(a2.getParameterTypes(), a3)) {
                a2.setAccessible(true);
                if (a2.getReturnType() != java.lang.Void.TYPE) {
                    return (T) a2.invoke(null, objArr);
                }
                a2.invoke(null, objArr);
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Class<?> c2 = c(str); c2 != null; c2 = c2.getSuperclass()) {
                arrayList.add(c2);
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                for (java.lang.reflect.Method method : ((java.lang.Class) it.next()).getDeclaredMethods()) {
                    if (method.getName().equals(str2) && java.lang.reflect.Modifier.isStatic(method.getModifiers()) && a(method.getParameterTypes(), a3)) {
                        d.a(str3, method);
                        method.setAccessible(true);
                        if (method.getReturnType() != java.lang.Void.TYPE) {
                            return (T) method.invoke(null, objArr);
                        }
                        method.invoke(null, objArr);
                        return null;
                    }
                }
            }
            throw new java.lang.NoSuchMethodException("className: " + str + ", methodName: " + str2 + ", args: " + java.util.Arrays.toString(objArr));
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchMethodException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + str + ", methodName: " + str2 + ", args: " + java.util.Arrays.toString(objArr), th);
        }
    }

    public static java.lang.Object a(java.lang.String str, java.lang.Object... objArr) {
        try {
            if (str.startsWith("[")) {
                return b(str, objArr);
            }
            java.lang.String str2 = str + "#" + objArr.length;
            java.lang.reflect.Constructor<?> a2 = e.a(str2);
            java.lang.Class<?>[] a3 = a(objArr);
            if (a2 != null && a(a2.getParameterTypes(), a3)) {
                a2.setAccessible(true);
                return a2.newInstance(objArr);
            }
            for (java.lang.reflect.Constructor<?> constructor : c(str).getDeclaredConstructors()) {
                if (a(constructor.getParameterTypes(), a3)) {
                    e.a(str2, constructor);
                    constructor.setAccessible(true);
                    return constructor.newInstance(objArr);
                }
            }
            throw new java.lang.NoSuchMethodException("className: " + str + ", methodName: <init>, args: " + java.util.Arrays.toString(objArr));
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchMethodException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + str + ", methodName: <init>, args: " + java.util.Arrays.toString(objArr), th);
        }
    }

    public static java.lang.String a(java.lang.Class<?> cls) {
        java.lang.String str = c.get(cls);
        if (str != null) {
            return str;
        }
        java.lang.String simpleName = cls.getSimpleName();
        if (b.containsKey(simpleName)) {
            return null;
        }
        b.put(simpleName, cls);
        c.put(cls, simpleName);
        return simpleName;
    }

    public static java.lang.String a(java.lang.String str) {
        return a((java.lang.String) null, str);
    }

    public static synchronized java.lang.String a(java.lang.String str, java.lang.String str2) {
        synchronized (com.sijla.mla.j.class) {
            if (str2.endsWith(".*")) {
                a.add(str2.substring(0, str2.length() - 2));
                return "*";
            }
            java.lang.Class<?> cls = java.lang.Class.forName(str2);
            if (str == null) {
                str = cls.getSimpleName();
            }
            b.put(str, cls);
            c.put(cls, str);
            return str;
        }
    }

    public static void a(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        java.lang.reflect.Field field;
        int i;
        int byteValue;
        int byteValue2;
        int byteValue3;
        short byteValue4;
        try {
            java.lang.Object obj3 = null;
            if (!obj.getClass().isArray()) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (java.lang.Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                    arrayList.add(cls);
                }
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        field = ((java.lang.Class) it.next()).getDeclaredField(str);
                    } catch (java.lang.Throwable unused) {
                        field = null;
                    }
                    if (field != null && !java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                        field.setAccessible(true);
                        field.set(obj, obj2);
                        return;
                    }
                }
                throw new java.lang.NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + java.lang.String.valueOf(obj2));
            }
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i = java.lang.Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (java.lang.Throwable unused2) {
                    i = -1;
                }
                if (i != -1) {
                    java.lang.String name = obj.getClass().getName();
                    while (name.startsWith("[")) {
                        name = name.substring(1);
                    }
                    java.lang.Class<?> cls2 = obj2.getClass();
                    if (com.sijla.mla.L2.s34754().equals(name)) {
                        if (cls2 == java.lang.Byte.class) {
                            java.lang.reflect.Array.set(obj, i, obj2);
                            return;
                        }
                    } else if (com.sijla.mla.L2.s35281().equals(name)) {
                        if (cls2 == java.lang.Short.class) {
                            obj3 = obj2;
                        } else if (cls2 == java.lang.Byte.class) {
                            obj3 = java.lang.Short.valueOf(((java.lang.Byte) obj2).byteValue());
                        }
                        if (obj3 != null) {
                            java.lang.reflect.Array.set(obj, i, obj3);
                            return;
                        }
                    } else if (com.sijla.mla.L2.s34971().equals(name)) {
                        if (cls2 == java.lang.Integer.class) {
                            obj3 = obj2;
                        } else {
                            if (cls2 == java.lang.Short.class) {
                                byteValue4 = ((java.lang.Short) obj2).shortValue();
                            } else if (cls2 == java.lang.Byte.class) {
                                byteValue4 = ((java.lang.Byte) obj2).byteValue();
                            }
                            obj3 = java.lang.Integer.valueOf(byteValue4);
                        }
                        if (obj3 != null) {
                            java.lang.reflect.Array.set(obj, i, obj3);
                            return;
                        }
                    } else if (com.sijla.mla.L2.s35002().equals(name)) {
                        if (cls2 == java.lang.Long.class) {
                            obj3 = obj2;
                        } else {
                            if (cls2 == java.lang.Integer.class) {
                                byteValue3 = ((java.lang.Integer) obj2).intValue();
                            } else if (cls2 == java.lang.Short.class) {
                                byteValue3 = ((java.lang.Short) obj2).shortValue();
                            } else if (cls2 == java.lang.Byte.class) {
                                byteValue3 = ((java.lang.Byte) obj2).byteValue();
                            }
                            obj3 = java.lang.Long.valueOf(byteValue3);
                        }
                        if (obj3 != null) {
                            java.lang.reflect.Array.set(obj, i, obj3);
                            return;
                        }
                    } else if (com.sijla.mla.L2.s34878().equals(name)) {
                        if (cls2 == java.lang.Float.class) {
                            obj3 = obj2;
                        } else if (cls2 == java.lang.Long.class) {
                            obj3 = java.lang.Float.valueOf(((java.lang.Long) obj2).longValue());
                        } else {
                            if (cls2 == java.lang.Integer.class) {
                                byteValue2 = ((java.lang.Integer) obj2).intValue();
                            } else if (cls2 == java.lang.Short.class) {
                                byteValue2 = ((java.lang.Short) obj2).shortValue();
                            } else if (cls2 == java.lang.Byte.class) {
                                byteValue2 = ((java.lang.Byte) obj2).byteValue();
                            }
                            obj3 = java.lang.Float.valueOf(byteValue2);
                        }
                        if (obj3 != null) {
                            java.lang.reflect.Array.set(obj, i, obj3);
                            return;
                        }
                    } else if (com.sijla.mla.L2.s34816().equals(name)) {
                        if (cls2 == java.lang.Double.class) {
                            obj3 = obj2;
                        } else if (cls2 == java.lang.Float.class) {
                            obj3 = java.lang.Double.valueOf(((java.lang.Float) obj2).floatValue());
                        } else if (cls2 == java.lang.Long.class) {
                            obj3 = java.lang.Double.valueOf(((java.lang.Long) obj2).longValue());
                        } else {
                            if (cls2 == java.lang.Integer.class) {
                                byteValue = ((java.lang.Integer) obj2).intValue();
                            } else if (cls2 == java.lang.Short.class) {
                                byteValue = ((java.lang.Short) obj2).shortValue();
                            } else if (cls2 == java.lang.Byte.class) {
                                byteValue = ((java.lang.Byte) obj2).byteValue();
                            }
                            obj3 = java.lang.Double.valueOf(byteValue);
                        }
                        if (obj3 != null) {
                            java.lang.reflect.Array.set(obj, i, obj3);
                            return;
                        }
                    } else if (com.sijla.mla.L2.s35498().equals(name)) {
                        if (cls2 == java.lang.Boolean.class) {
                            java.lang.reflect.Array.set(obj, i, obj2);
                            return;
                        }
                    } else if (com.sijla.mla.L2.s34785().equals(name)) {
                        if (cls2 == java.lang.Character.class) {
                            java.lang.reflect.Array.set(obj, i, obj2);
                            return;
                        }
                    } else if (name.equals(cls2.getName())) {
                        java.lang.reflect.Array.set(obj, i, obj2);
                        return;
                    }
                }
            }
            throw new java.lang.NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + java.lang.String.valueOf(obj2));
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchFieldException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + java.lang.String.valueOf(obj2), th);
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        java.lang.reflect.Field field;
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Class<?> c2 = c(str); c2 != null; c2 = c2.getSuperclass()) {
                arrayList.add(c2);
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    field = ((java.lang.Class) it.next()).getDeclaredField(str2);
                } catch (java.lang.Throwable unused) {
                    field = null;
                }
                if (field != null && java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    field.set(null, obj);
                    return;
                }
            }
            throw new java.lang.NoSuchFieldException("className: " + str + ", fieldName: " + str2 + ", value: " + java.lang.String.valueOf(obj));
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchFieldException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + str + ", fieldName: " + str2 + ", value: " + java.lang.String.valueOf(obj), th);
        }
    }

    private static boolean a(java.lang.Class<?>[] clsArr, java.lang.Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= clsArr.length) {
                return true;
            }
            java.lang.Class<?> cls = clsArr2[i];
            if (cls != null) {
                java.lang.Class<?> cls2 = clsArr[i];
                if ((cls2 != java.lang.Byte.TYPE || cls != java.lang.Byte.class) && ((cls2 != java.lang.Short.TYPE || (cls != java.lang.Short.class && cls != java.lang.Byte.class && cls != java.lang.Character.class)) && ((cls2 != java.lang.Character.TYPE || (cls != java.lang.Character.class && cls != java.lang.Short.class && cls != java.lang.Byte.class)) && ((cls2 != java.lang.Integer.TYPE || (cls != java.lang.Integer.class && cls != java.lang.Short.class && cls != java.lang.Byte.class && cls != java.lang.Character.class)) && ((cls2 != java.lang.Long.TYPE || (cls != java.lang.Long.class && cls != java.lang.Integer.class && cls != java.lang.Short.class && cls != java.lang.Byte.class && cls != java.lang.Character.class)) && ((cls2 != java.lang.Float.TYPE || (cls != java.lang.Float.class && cls != java.lang.Long.class && cls != java.lang.Integer.class && cls != java.lang.Short.class && cls != java.lang.Byte.class && cls != java.lang.Character.class)) && ((cls2 != java.lang.Double.TYPE || (cls != java.lang.Double.class && cls != java.lang.Float.class && cls != java.lang.Long.class && cls != java.lang.Integer.class && cls != java.lang.Short.class && cls != java.lang.Byte.class && cls != java.lang.Character.class)) && (cls2 != java.lang.Boolean.TYPE || cls != java.lang.Boolean.class)))))))) {
                    z = false;
                }
                if (!z && !cls2.isAssignableFrom(cls)) {
                    return false;
                }
            }
            i++;
        }
    }

    private static java.lang.Class<?>[] a(java.lang.Object[] objArr) {
        java.lang.Class<?>[] clsArr = new java.lang.Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            java.lang.Object obj = objArr[i];
            clsArr[i] = obj == null ? null : obj.getClass();
        }
        return clsArr;
    }

    public static java.lang.Class<?> b(java.lang.String str) {
        java.lang.Class<?> c2 = c(str);
        if (c2 != null) {
            return c2;
        }
        try {
            c2 = java.lang.Class.forName(str);
            b.put(str, c2);
            return c2;
        } catch (java.lang.Throwable unused) {
            return c2;
        }
    }

    private static <T> T b(java.lang.Object obj, java.lang.String str) {
        java.lang.reflect.Field field;
        if (obj.getClass().isArray()) {
            return (T) c(obj, str);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            arrayList.add(cls);
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                field = ((java.lang.Class) it.next()).getDeclaredField(str);
            } catch (java.lang.Throwable unused) {
                field = null;
            }
            if (field != null && !java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                return (T) field.get(obj);
            }
        }
        throw new java.lang.NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    public static <T> T b(java.lang.String str, java.lang.String str2) {
        try {
            return (T) c(str, str2);
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchFieldException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + str + ", fieldName: " + str2, th);
        }
    }

    private static java.lang.Object b(java.lang.String str, java.lang.Object... objArr) {
        int i = 0;
        java.lang.String str2 = str;
        while (str2.startsWith("[")) {
            i++;
            str2 = str2.substring(1);
        }
        int[] iArr = null;
        if (i == objArr.length) {
            int[] iArr2 = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    iArr2[i2] = java.lang.Integer.parseInt(java.lang.String.valueOf(objArr[i2]));
                } catch (java.lang.Throwable unused) {
                }
            }
            iArr = iArr2;
        }
        if (iArr != null) {
            java.lang.Class<?> c2 = com.sijla.mla.L2.s34754().equals(str2) ? java.lang.Byte.TYPE : com.sijla.mla.L2.s35281().equals(str2) ? java.lang.Short.TYPE : com.sijla.mla.L2.s34971().equals(str2) ? java.lang.Integer.TYPE : com.sijla.mla.L2.s35002().equals(str2) ? java.lang.Long.TYPE : com.sijla.mla.L2.s34878().equals(str2) ? java.lang.Float.TYPE : com.sijla.mla.L2.s34816().equals(str2) ? java.lang.Double.TYPE : com.sijla.mla.L2.s35498().equals(str2) ? java.lang.Boolean.TYPE : com.sijla.mla.L2.s34785().equals(str2) ? java.lang.Character.TYPE : c(str2);
            if (c2 != null) {
                return java.lang.reflect.Array.newInstance(c2, iArr);
            }
        }
        throw new java.lang.NoSuchMethodException("className: " + str + ", methodName: <init>, args: " + java.util.Arrays.toString(objArr));
    }

    private static synchronized java.lang.Class<?> c(java.lang.String str) {
        java.lang.Class<?> cls;
        synchronized (com.sijla.mla.j.class) {
            cls = b.get(str);
            if (cls == null) {
                java.util.Iterator<java.lang.String> it = a.iterator();
                while (it.hasNext()) {
                    try {
                        a((java.lang.String) null, it.next() + com.sijla.mla.L2.s34134() + str);
                    } catch (java.lang.Throwable unused) {
                    }
                    cls = b.get(str);
                    if (cls != null) {
                        break;
                    }
                }
            }
        }
        return cls;
    }

    private static java.lang.Object c(java.lang.Object obj, java.lang.String str) {
        int i;
        if (com.sijla.mla.L2.s811526246().equals(str)) {
            return java.lang.Integer.valueOf(java.lang.reflect.Array.getLength(obj));
        }
        if (str.startsWith("[") && str.endsWith("]")) {
            try {
                i = java.lang.Integer.parseInt(str.substring(1, str.length() - 1));
            } catch (java.lang.Throwable unused) {
                i = -1;
            }
            if (i != -1) {
                return java.lang.reflect.Array.get(obj, i);
            }
        }
        throw new java.lang.NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    private static <T> T c(java.lang.String str, java.lang.String str2) {
        java.lang.reflect.Field field;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Class<?> c2 = c(str); c2 != null; c2 = c2.getSuperclass()) {
            arrayList.add(c2);
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                field = ((java.lang.Class) it.next()).getDeclaredField(str2);
            } catch (java.lang.Throwable unused) {
                field = null;
            }
            if (field != null && java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                return (T) field.get(null);
            }
        }
        throw new java.lang.NoSuchFieldException("className: " + str + ", fieldName: " + str2);
    }
}
