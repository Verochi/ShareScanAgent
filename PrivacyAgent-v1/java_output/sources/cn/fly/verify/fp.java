package cn.fly.verify;

/* loaded from: classes.dex */
public class fp {
    private static java.util.HashSet<java.lang.String> a;
    private static java.util.HashMap<java.lang.String, java.lang.Class<?>> b;
    private static java.util.HashMap<java.lang.Class<?>, java.lang.String> c;
    private static java.util.LinkedHashMap<java.lang.String, java.lang.reflect.Method> d;
    private static java.util.LinkedHashMap<java.lang.String, java.lang.reflect.Constructor<?>> e;

    /* renamed from: cn.fly.verify.fp$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.LinkedHashMap<java.lang.String, java.lang.reflect.Method> {
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(java.util.Map.Entry<java.lang.String, java.lang.reflect.Method> entry) {
            return size() > 10;
        }
    }

    /* renamed from: cn.fly.verify.fp$2, reason: invalid class name */
    public class AnonymousClass2 extends java.util.LinkedHashMap<java.lang.String, java.lang.reflect.Constructor<?>> {
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(java.util.Map.Entry<java.lang.String, java.lang.reflect.Constructor<?>> entry) {
            return size() > 10;
        }
    }

    public interface a<ArgType, RetType> {
        RetType a(ArgType argtype);
    }

    static {
        java.util.HashSet<java.lang.String> hashSet = new java.util.HashSet<>();
        a = hashSet;
        hashSet.add(cn.fly.verify.ds.b("009)gf6c>cc_c]ec^fcdFdd"));
        a.add(cn.fly.verify.ds.b("007=gfXcBcc$c^ecchdc"));
        a.add(cn.fly.verify.ds.b("008)gfBc4cc]cYec2d]chdc"));
        a.add("java.net");
        a.add(cn.fly.verify.ds.b("009>gf=cCccQcBeccfAh!ch!f"));
        java.util.HashMap<java.lang.String, java.lang.Class<?>> hashMap = new java.util.HashMap<>();
        b = hashMap;
        hashMap.put(cn.fly.verify.ds.b("006Ycbdccfed1fe"), java.lang.Double.TYPE);
        b.put(cn.fly.verify.ds.b("005Dde(fEdcKch"), java.lang.Float.TYPE);
        b.put("long", java.lang.Long.TYPE);
        b.put(cn.fly.verify.ds.b("003<ch6dh"), java.lang.Integer.TYPE);
        b.put("short", java.lang.Short.TYPE);
        b.put("byte", java.lang.Byte.TYPE);
        b.put(cn.fly.verify.ds.b("004bgcLci"), java.lang.Character.TYPE);
        b.put("boolean", java.lang.Boolean.TYPE);
        b.put("Object", java.lang.Object.class);
        b.put("String", java.lang.String.class);
        b.put("Thread", java.lang.Thread.class);
        b.put(cn.fly.verify.ds.b("008:fhcfWddc_edPfe"), java.lang.Runnable.class);
        b.put(cn.fly.verify.ds.b("0065dicjegKhe3ce"), java.lang.System.class);
        b.put(cn.fly.verify.ds.b("006ScbdccfedYfe"), java.lang.Double.class);
        b.put("Float", java.lang.Float.class);
        b.put("Long", java.lang.Long.class);
        b.put("Integer", java.lang.Integer.class);
        b.put(cn.fly.verify.ds.b("005Idi1g;dcci9h"), java.lang.Short.class);
        b.put("Byte", java.lang.Byte.class);
        b.put(cn.fly.verify.ds.b("009$fjKgcIciBcbheWci"), java.lang.Character.class);
        b.put("Boolean", java.lang.Boolean.class);
        c = new java.util.HashMap<>();
        for (java.util.Map.Entry<java.lang.String, java.lang.Class<?>> entry : b.entrySet()) {
            c.put(entry.getValue(), entry.getKey());
        }
        d = new cn.fly.verify.fp.AnonymousClass1();
        e = new cn.fly.verify.fp.AnonymousClass2();
    }

    public static <T> T a(java.lang.Object obj, java.lang.String str) throws java.lang.Throwable {
        try {
            return (T) b(obj, str);
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchFieldException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + obj.getClass() + ", fieldName: " + str, th);
        }
    }

    public static <T> T a(java.lang.Object obj, java.lang.String str, T t) {
        try {
            return (T) a(obj, str);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return t;
        }
    }

    public static <T> T a(java.lang.Object obj, java.lang.String str, T t, java.lang.Object... objArr) {
        try {
            return (T) a(obj, str, objArr);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return t;
        }
    }

    public static <T> T a(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) throws java.lang.Throwable {
        try {
            return (T) a((java.lang.String) null, obj, str, objArr);
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchMethodException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + obj.getClass() + ", methodName: " + str, th);
        }
    }

    public static <T> T a(java.lang.Object obj, java.lang.String str, java.lang.Object[] objArr, java.lang.Class<?>[] clsArr) throws java.lang.Throwable {
        return (T) a((java.lang.String) null, obj, str, objArr, clsArr);
    }

    public static <T> T a(java.lang.Object obj, java.lang.String str, java.lang.Object[] objArr, java.lang.Class<?>[] clsArr, T t) {
        try {
            return (T) a(obj, str, objArr, clsArr);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return t;
        }
    }

    private static <T> T a(java.lang.String str, java.lang.Object obj, java.lang.String str2, java.lang.Object... objArr) throws java.lang.Throwable {
        java.lang.Class<?>[] a2;
        java.lang.Class<?> b2 = obj == null ? b(str) : obj.getClass();
        boolean z = false;
        if (str2.equals(cn.fly.verify.ds.b("009$dd.eh(gbGehg2dccb")) && objArr != null && objArr.length == 2) {
            a2 = new java.lang.Class[]{java.lang.String.class, java.lang.Class[].class};
            if (objArr[1] == java.lang.String.class) {
                objArr[1] = new java.lang.Class[]{java.lang.String.class};
            }
        } else {
            a2 = (str2.equals("getDeviceId") && objArr != null && objArr.length == 1) ? new java.lang.Class[]{java.lang.Integer.TYPE} : (str2.equals(cn.fly.verify.ds.b("006ZchSdNccdcck e")) && objArr != null && objArr.length == 2) ? new java.lang.Class[]{java.lang.Object.class, java.lang.Object[].class} : (str2.equals(cn.fly.verify.ds.b("013XegAeh_dk5bbeBegegchedKfe")) && objArr != null && objArr.length == 1) ? new java.lang.Class[]{java.lang.Boolean.TYPE} : a(objArr);
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        int length = a2.length;
        for (int i = 0; i < length; i++) {
            java.lang.Class<?> cls = a2[i];
            stringBuffer.append(cls == null ? "" : cls.getName());
        }
        java.lang.String str3 = b2.getName() + "#" + str2 + "#" + objArr.length + stringBuffer.toString();
        java.lang.reflect.Method method = d.get(str3);
        if (method != null) {
            boolean isStatic = java.lang.reflect.Modifier.isStatic(method.getModifiers());
            if (obj == null) {
                z = isStatic;
            } else if (!isStatic) {
                z = true;
            }
            if (z && a(method.getParameterTypes(), a2)) {
                method.setAccessible(true);
                try {
                    if (method.getReturnType() != java.lang.Void.TYPE) {
                        return (T) method.invoke(obj, objArr);
                    }
                    method.invoke(obj, objArr);
                    return null;
                } catch (java.lang.reflect.InvocationTargetException e2) {
                    throw e2;
                }
            }
        }
        while (b2 != null) {
            try {
                java.lang.reflect.Method declaredMethod = b2.getDeclaredMethod(str2, a2);
                d.put(str3, declaredMethod);
                declaredMethod.setAccessible(true);
                if (declaredMethod.getReturnType() != java.lang.Void.TYPE) {
                    return (T) declaredMethod.invoke(obj, objArr);
                }
                declaredMethod.invoke(obj, objArr);
                return null;
            } catch (java.lang.reflect.InvocationTargetException e3) {
                throw e3;
            } catch (java.lang.Throwable unused) {
                b2 = b2.getSuperclass();
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("className: ");
        java.lang.Object obj2 = str;
        if (obj != null) {
            obj2 = obj.getClass();
        }
        sb.append(obj2);
        sb.append(", methodName: ");
        sb.append(str2);
        throw new java.lang.NoSuchMethodException(sb.toString());
    }

    private static <T> T a(java.lang.String str, java.lang.Object obj, java.lang.String str2, java.lang.Object[] objArr, java.lang.Class<?>[] clsArr) throws java.lang.Throwable {
        if (objArr == null) {
            objArr = new java.lang.Object[0];
        }
        if (clsArr == null) {
            clsArr = new java.lang.Class[0];
        }
        java.lang.Class<?> b2 = obj == null ? b(str) : obj.getClass();
        java.lang.String str3 = b2.getName() + "#" + str2 + "#" + objArr.length;
        java.lang.reflect.Method method = d.get(str3);
        if (method != null) {
            method.setAccessible(true);
            try {
                if (method.getReturnType() != java.lang.Void.TYPE) {
                    return (T) method.invoke(obj, objArr);
                }
                method.invoke(obj, objArr);
                return null;
            } catch (java.lang.reflect.InvocationTargetException e2) {
                throw e2;
            }
        }
        while (b2 != null) {
            try {
                java.lang.reflect.Method declaredMethod = b2.getDeclaredMethod(str2, clsArr);
                d.put(str3, declaredMethod);
                declaredMethod.setAccessible(true);
                if (declaredMethod.getReturnType() != java.lang.Void.TYPE) {
                    return (T) declaredMethod.invoke(obj, objArr);
                }
                declaredMethod.invoke(obj, objArr);
                return null;
            } catch (java.lang.reflect.InvocationTargetException e3) {
                throw e3;
            } catch (java.lang.Throwable unused) {
                b2 = b2.getSuperclass();
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("className: ");
        java.lang.Object obj2 = str;
        if (obj != null) {
            obj2 = obj.getClass();
        }
        sb.append(obj2);
        sb.append(", methodName: ");
        sb.append(str2);
        throw new java.lang.NoSuchMethodException(sb.toString());
    }

    public static <T> T a(java.lang.String str, java.lang.String str2, T t, java.lang.Object... objArr) {
        try {
            return (T) a(str, str2, objArr);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return t;
        }
    }

    public static <T> T a(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) throws java.lang.Throwable {
        try {
            return (T) a(str, (java.lang.Object) null, str2, objArr);
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchMethodException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + str + ", methodName: " + str2, th);
        }
    }

    public static <T> T a(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr, java.lang.Class<?>[] clsArr) throws java.lang.Throwable {
        return (T) a(str, (java.lang.Object) null, str2, objArr, clsArr);
    }

    public static java.lang.Object a(java.lang.String str, java.lang.Object... objArr) throws java.lang.Throwable {
        try {
            return b(str, objArr);
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchMethodException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + str + ", methodName: <init>", th);
        }
    }

    public static java.lang.String a(java.lang.Class<?> cls) throws java.lang.Throwable {
        java.lang.String str = c.get(cls);
        if (str == null) {
            str = cls.getSimpleName();
            if (b.containsKey(str)) {
                c.remove(b.get(str));
            }
            b.put(str, cls);
            c.put(cls, str);
        }
        return str;
    }

    public static java.lang.String a(java.lang.String str) throws java.lang.Throwable {
        return b((java.lang.String) null, str);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            return a(str);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return str2;
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.Object obj) throws java.lang.Throwable {
        try {
            b(str, str2, obj);
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchFieldException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + str + ", fieldName: " + str2 + ", value: " + java.lang.String.valueOf(obj), th);
        }
    }

    private static boolean a(java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        return (cls == java.lang.Byte.TYPE && cls2 == java.lang.Byte.class) || (cls == java.lang.Short.TYPE && (cls2 == java.lang.Short.class || cls2 == java.lang.Byte.class || cls2 == java.lang.Character.class)) || ((cls == java.lang.Character.TYPE && (cls2 == java.lang.Character.class || cls2 == java.lang.Short.class || cls2 == java.lang.Byte.class)) || ((cls == java.lang.Integer.TYPE && (cls2 == java.lang.Integer.class || cls2 == java.lang.Short.class || cls2 == java.lang.Byte.class || cls2 == java.lang.Character.class)) || ((cls == java.lang.Long.TYPE && (cls2 == java.lang.Long.class || cls2 == java.lang.Integer.class || cls2 == java.lang.Short.class || cls2 == java.lang.Byte.class || cls2 == java.lang.Character.class)) || ((cls == java.lang.Float.TYPE && (cls2 == java.lang.Float.class || cls2 == java.lang.Long.class || cls2 == java.lang.Integer.class || cls2 == java.lang.Short.class || cls2 == java.lang.Byte.class || cls2 == java.lang.Character.class)) || ((cls == java.lang.Double.TYPE && (cls2 == java.lang.Double.class || cls2 == java.lang.Float.class || cls2 == java.lang.Long.class || cls2 == java.lang.Integer.class || cls2 == java.lang.Short.class || cls2 == java.lang.Byte.class || cls2 == java.lang.Character.class)) || (cls == java.lang.Boolean.TYPE && cls2 == java.lang.Boolean.class))))));
    }

    private static boolean a(java.lang.Class<?>[] clsArr, java.lang.Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            java.lang.Class<?> cls = clsArr2[i];
            if (cls != null && !a(clsArr[i], cls) && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                return false;
            }
        }
        return true;
    }

    private static java.lang.Class<?>[] a(java.lang.Object[] objArr) {
        java.lang.Class<?>[] clsArr = new java.lang.Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            java.lang.Object obj = objArr[i];
            if (obj instanceof android.content.BroadcastReceiver) {
                clsArr[i] = android.content.BroadcastReceiver.class;
            } else {
                clsArr[i] = obj == null ? null : obj.getClass();
            }
        }
        return clsArr;
    }

    private static synchronized java.lang.Class<?> b(java.lang.String str) {
        java.lang.Class<?> cls;
        synchronized (cn.fly.verify.fp.class) {
            cls = b.get(str);
            if (cls == null) {
                java.util.Iterator<java.lang.String> it = a.iterator();
                while (it.hasNext()) {
                    try {
                        a(it.next() + "." + str);
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

    private static <T> T b(java.lang.Object obj, java.lang.String str) throws java.lang.Throwable {
        java.lang.reflect.Field field;
        if ((obj instanceof java.util.List) || obj.getClass().isArray()) {
            return (T) c(obj, str);
        }
        if (obj instanceof java.util.Map) {
            return (T) ((java.util.Map) obj).get(str);
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

    private static java.lang.Object b(java.lang.String str, java.lang.Object... objArr) throws java.lang.Throwable {
        boolean z;
        if (str.startsWith("[")) {
            return c(str, objArr);
        }
        java.lang.Class<?> b2 = b(str);
        java.lang.String str2 = b2.getName() + "#" + objArr.length;
        java.lang.reflect.Constructor<?> constructor = e.get(str2);
        java.lang.Class<?>[] a2 = a(objArr);
        if (constructor != null && a(constructor.getParameterTypes(), a2)) {
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        }
        java.lang.reflect.Constructor<?>[] declaredConstructors = b2.getDeclaredConstructors();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (java.lang.reflect.Constructor<?> constructor2 : declaredConstructors) {
            java.lang.Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if (a(parameterTypes, a2)) {
                e.put(str2, constructor2);
                constructor2.setAccessible(true);
                return constructor2.newInstance(objArr);
            }
            if (parameterTypes.length > 0 && parameterTypes[parameterTypes.length - 1].isArray() && a2.length >= parameterTypes.length - 1) {
                arrayList.add(constructor2);
                arrayList2.add(parameterTypes);
            }
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            java.lang.Class[] clsArr = (java.lang.Class[]) arrayList2.get(i);
            java.lang.Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
            if (b((java.lang.Class<?>[]) clsArr, a2)) {
                java.lang.Object[] objArr2 = new java.lang.Object[objArr.length + 1];
                java.lang.System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                objArr2[objArr.length] = java.lang.reflect.Array.newInstance(componentType, 0);
                java.lang.reflect.Constructor constructor3 = (java.lang.reflect.Constructor) arrayList.get(i);
                constructor3.setAccessible(true);
                return constructor3.newInstance(objArr);
            }
            int length = clsArr.length - 1;
            while (true) {
                if (length >= a2.length) {
                    z = true;
                    break;
                }
                if (!a2[length].equals(componentType)) {
                    z = false;
                    break;
                }
                length++;
            }
            if (z) {
                int length2 = (a2.length - clsArr.length) + 1;
                java.lang.Object newInstance = java.lang.reflect.Array.newInstance(componentType, length2);
                for (int i2 = 0; i2 < length2; i2++) {
                    java.lang.reflect.Array.set(newInstance, i2, objArr[(clsArr.length - 1) + i2]);
                }
                java.lang.Object[] objArr3 = new java.lang.Object[objArr.length + 1];
                java.lang.System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
                objArr3[objArr.length] = newInstance;
                java.lang.reflect.Constructor constructor4 = (java.lang.reflect.Constructor) arrayList.get(i);
                constructor4.setAccessible(true);
                return constructor4.newInstance(objArr);
            }
        }
        throw new java.lang.NoSuchMethodException("className: " + str + ", methodName: <init>");
    }

    public static synchronized java.lang.String b(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        synchronized (cn.fly.verify.fp.class) {
            if (str2.endsWith(".*")) {
                a.add(str2.substring(0, str2.length() - 2));
                return "*";
            }
            java.lang.Class<?> cls = java.lang.Class.forName(str2);
            if (str == null) {
                str = cls.getSimpleName();
            }
            if (b.containsKey(str)) {
                c.remove(b.get(str));
            }
            b.put(str, cls);
            c.put(cls, str);
            return str;
        }
    }

    public static void b(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) throws java.lang.Throwable {
        try {
            c(obj, str, obj2);
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchFieldException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + java.lang.String.valueOf(obj2), th);
        }
    }

    private static void b(java.lang.String str, java.lang.String str2, java.lang.Object obj) throws java.lang.Throwable {
        java.lang.reflect.Field field;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Class<?> b2 = b(str); b2 != null; b2 = b2.getSuperclass()) {
            arrayList.add(b2);
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
    }

    private static boolean b(java.lang.Class<?>[] clsArr, java.lang.Class<?>[] clsArr2) {
        boolean z;
        if (clsArr.length - clsArr2.length != 1) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= clsArr2.length) {
                z = true;
                break;
            }
            java.lang.Class<?> cls = clsArr2[i];
            if (cls != null && !a(clsArr[i], cls) && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                z = false;
                break;
            }
            i++;
        }
        return z && clsArr[clsArr.length - 1].isArray();
    }

    private static java.lang.Object c(java.lang.Object obj, java.lang.String str) throws java.lang.Throwable {
        int i;
        int i2;
        if (obj instanceof java.util.List) {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i2 = java.lang.Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (java.lang.Throwable unused) {
                    i2 = -1;
                }
                if (i2 != -1) {
                    return ((java.util.List) obj).get(i2);
                }
            }
        } else {
            if (cn.fly.verify.ds.b("006fedYdd9hg").equals(str)) {
                return java.lang.Integer.valueOf(java.lang.reflect.Array.getLength(obj));
            }
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i = java.lang.Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (java.lang.Throwable unused2) {
                    i = -1;
                }
                if (i != -1) {
                    return java.lang.reflect.Array.get(obj, i);
                }
            }
        }
        throw new java.lang.NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    public static <T> T c(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        try {
            return (T) d(str, str2);
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.NoSuchFieldException) {
                throw th;
            }
            throw new java.lang.Throwable("className: " + str + ", fieldName: " + str2, th);
        }
    }

    private static java.lang.Object c(java.lang.String str, java.lang.Object... objArr) throws java.lang.Throwable {
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
            java.lang.Class<?> b2 = "B".equals(str2) ? java.lang.Byte.TYPE : androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH.equals(str2) ? java.lang.Short.TYPE : "I".equals(str2) ? java.lang.Integer.TYPE : "J".equals(str2) ? java.lang.Long.TYPE : "F".equals(str2) ? java.lang.Float.TYPE : "D".equals(str2) ? java.lang.Double.TYPE : "Z".equals(str2) ? java.lang.Boolean.TYPE : "C".equals(str2) ? java.lang.Character.TYPE : b(str2);
            if (b2 != null) {
                return java.lang.reflect.Array.newInstance(b2, iArr);
            }
        }
        throw new java.lang.NoSuchMethodException("className: [" + str + ", methodName: <init>");
    }

    private static void c(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) throws java.lang.Throwable {
        java.lang.reflect.Field field;
        if ((obj instanceof java.util.List) || obj.getClass().isArray()) {
            d(obj, str, obj2);
            return;
        }
        if (obj instanceof java.util.Map) {
            ((java.util.Map) obj).put(str, obj2);
            return;
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
                field.set(obj, obj2);
                return;
            }
        }
        throw new java.lang.NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + java.lang.String.valueOf(obj2));
    }

    private static <T> T d(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.lang.reflect.Field field;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Class<?> b2 = b(str); b2 != null; b2 = b2.getSuperclass()) {
            arrayList.add(b2);
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

    private static void d(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) throws java.lang.Throwable {
        int i;
        int byteValue;
        double d2;
        int byteValue2;
        float f;
        int byteValue3;
        short byteValue4;
        int i2;
        if (obj instanceof java.util.List) {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i2 = java.lang.Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (java.lang.Throwable unused) {
                    i2 = -1;
                }
                if (i2 != -1) {
                    ((java.util.List) obj).set(i2, obj2);
                    return;
                }
            }
        } else if (str.startsWith("[") && str.endsWith("]")) {
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
                java.lang.Class<?> cls = obj2.getClass();
                if (!"B".equals(name)) {
                    java.lang.Object obj3 = null;
                    if (androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH.equals(name)) {
                        if (cls == java.lang.Short.class) {
                            obj3 = obj2;
                        } else if (cls == java.lang.Byte.class) {
                            obj3 = java.lang.Short.valueOf(((java.lang.Byte) obj2).byteValue());
                        }
                        if (obj3 != null) {
                            java.lang.reflect.Array.set(obj, i, obj3);
                            return;
                        }
                    } else if ("I".equals(name)) {
                        if (cls == java.lang.Integer.class) {
                            obj3 = obj2;
                        } else {
                            if (cls == java.lang.Short.class) {
                                byteValue4 = ((java.lang.Short) obj2).shortValue();
                            } else if (cls == java.lang.Byte.class) {
                                byteValue4 = ((java.lang.Byte) obj2).byteValue();
                            }
                            obj3 = java.lang.Integer.valueOf(byteValue4);
                        }
                        if (obj3 != null) {
                            java.lang.reflect.Array.set(obj, i, obj3);
                            return;
                        }
                    } else if ("J".equals(name)) {
                        if (cls == java.lang.Long.class) {
                            obj3 = obj2;
                        } else {
                            if (cls == java.lang.Integer.class) {
                                byteValue3 = ((java.lang.Integer) obj2).intValue();
                            } else if (cls == java.lang.Short.class) {
                                byteValue3 = ((java.lang.Short) obj2).shortValue();
                            } else if (cls == java.lang.Byte.class) {
                                byteValue3 = ((java.lang.Byte) obj2).byteValue();
                            }
                            obj3 = java.lang.Long.valueOf(byteValue3);
                        }
                        if (obj3 != null) {
                            java.lang.reflect.Array.set(obj, i, obj3);
                            return;
                        }
                    } else if ("F".equals(name)) {
                        if (cls == java.lang.Float.class) {
                            obj3 = obj2;
                        } else {
                            if (cls == java.lang.Long.class) {
                                f = ((java.lang.Long) obj2).longValue();
                            } else {
                                if (cls == java.lang.Integer.class) {
                                    byteValue2 = ((java.lang.Integer) obj2).intValue();
                                } else if (cls == java.lang.Short.class) {
                                    byteValue2 = ((java.lang.Short) obj2).shortValue();
                                } else if (cls == java.lang.Byte.class) {
                                    byteValue2 = ((java.lang.Byte) obj2).byteValue();
                                }
                                f = byteValue2;
                            }
                            obj3 = java.lang.Float.valueOf(f);
                        }
                        if (obj3 != null) {
                            java.lang.reflect.Array.set(obj, i, obj3);
                            return;
                        }
                    } else if ("D".equals(name)) {
                        if (cls == java.lang.Double.class) {
                            obj3 = obj2;
                        } else {
                            if (cls == java.lang.Float.class) {
                                d2 = ((java.lang.Float) obj2).floatValue();
                            } else if (cls == java.lang.Long.class) {
                                d2 = ((java.lang.Long) obj2).longValue();
                            } else {
                                if (cls == java.lang.Integer.class) {
                                    byteValue = ((java.lang.Integer) obj2).intValue();
                                } else if (cls == java.lang.Short.class) {
                                    byteValue = ((java.lang.Short) obj2).shortValue();
                                } else if (cls == java.lang.Byte.class) {
                                    byteValue = ((java.lang.Byte) obj2).byteValue();
                                }
                                d2 = byteValue;
                            }
                            obj3 = java.lang.Double.valueOf(d2);
                        }
                        if (obj3 != null) {
                            java.lang.reflect.Array.set(obj, i, obj3);
                            return;
                        }
                    } else if ("Z".equals(name)) {
                        if (cls == java.lang.Boolean.class) {
                            java.lang.reflect.Array.set(obj, i, obj2);
                            return;
                        }
                    } else if ("C".equals(name)) {
                        if (cls == java.lang.Character.class) {
                            java.lang.reflect.Array.set(obj, i, obj2);
                            return;
                        }
                    } else if (name.equals(cls.getName())) {
                        java.lang.reflect.Array.set(obj, i, obj2);
                        return;
                    }
                } else if (cls == java.lang.Byte.class) {
                    java.lang.reflect.Array.set(obj, i, obj2);
                    return;
                }
            }
        }
        throw new java.lang.NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + java.lang.String.valueOf(obj2));
    }
}
