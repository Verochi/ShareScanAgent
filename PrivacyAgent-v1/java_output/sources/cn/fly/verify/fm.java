package cn.fly.verify;

/* loaded from: classes.dex */
public class fm {

    public interface a {
        java.lang.Object a();
    }

    /* JADX WARN: Type inference failed for: r9v11, types: [T, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r9v9, types: [T, java.util.Map] */
    private static <T> T a(java.lang.Object obj, java.lang.Class<T> cls, java.lang.reflect.Type[] typeArr) throws java.lang.Throwable {
        java.lang.reflect.Field field;
        java.lang.reflect.Type type;
        java.lang.reflect.Type type2;
        java.lang.Object obj2;
        java.lang.Object obj3;
        java.lang.Object obj4;
        int i = 0;
        if (cls.isPrimitive() || java.lang.Number.class.isAssignableFrom(cls) || cls.equals(java.lang.Character.class)) {
            return (cls.equals(java.lang.Boolean.TYPE) || cls.equals(java.lang.Boolean.class)) ? (T) java.lang.Boolean.valueOf(cn.fly.verify.bj.a("004j2ekeh9g").equals(java.lang.String.valueOf(obj))) : (cls.equals(java.lang.Character.TYPE) || cls.equals(java.lang.Character.class)) ? (T) java.lang.Character.valueOf(java.lang.String.valueOf(obj).charAt(0)) : (cls.equals(java.lang.Byte.TYPE) || cls.equals(java.lang.Byte.class)) ? (T) java.lang.Byte.valueOf(java.lang.String.valueOf(obj)) : (cls.equals(java.lang.Short.TYPE) || cls.equals(java.lang.Short.class)) ? (T) java.lang.Short.valueOf(java.lang.String.valueOf(obj)) : (cls.equals(java.lang.Integer.TYPE) || cls.equals(java.lang.Integer.class)) ? (T) java.lang.Integer.valueOf(java.lang.String.valueOf(obj)) : (cls.equals(java.lang.Long.TYPE) || cls.equals(java.lang.Long.class)) ? (T) java.lang.Long.valueOf(java.lang.String.valueOf(obj)) : (cls.equals(java.lang.Float.TYPE) || cls.equals(java.lang.Float.class)) ? (T) java.lang.Float.valueOf(java.lang.String.valueOf(obj)) : (T) java.lang.Double.valueOf(java.lang.String.valueOf(obj));
        }
        if (cn.fly.verify.fm.a.class.isAssignableFrom(cls)) {
            try {
                return (T) cn.fly.verify.fp.a(cn.fly.verify.fp.a(cls.getName()), cn.fly.verify.bj.a("007 ee_eh0eh^g_hhfg"), obj);
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }
        if (cls.equals(java.lang.String.class) || cls.equals(java.lang.Boolean.class)) {
            return obj;
        }
        if (cls.isEnum()) {
            return (T) java.lang.Enum.valueOf(cls, java.lang.String.valueOf(((java.util.HashMap) obj).get(cn.fly.verify.bj.a("004gf*eheg"))));
        }
        if (cls.isArray()) {
            java.util.ArrayList arrayList = (java.util.ArrayList) obj;
            java.lang.Class<?> componentType = cls.getComponentType();
            T t = (T) java.lang.reflect.Array.newInstance(componentType, arrayList.size());
            int size = arrayList.size();
            while (i < size) {
                java.lang.reflect.Array.set(t, i, a(arrayList.get(i), componentType, null));
                i++;
            }
            return t;
        }
        if (java.util.Collection.class.isAssignableFrom(cls)) {
            ?? r9 = (T) ((java.util.Collection) cls.newInstance());
            java.lang.reflect.Type type3 = (typeArr == null || typeArr.length <= 0) ? null : typeArr[0];
            java.util.ArrayList arrayList2 = (java.util.ArrayList) obj;
            int size2 = arrayList2.size();
            while (i < size2) {
                if (type3 != null && (type3 instanceof java.lang.Class) && !type3.equals(java.lang.Object.class)) {
                    obj4 = a(arrayList2.get(i), (java.lang.Class) type3, null);
                } else if (type3 == null || !(type3 instanceof java.lang.reflect.ParameterizedType)) {
                    obj4 = arrayList2.get(i);
                } else {
                    java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type3;
                    obj4 = a(arrayList2.get(i), (java.lang.Class) parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
                }
                r9.add(obj4);
                i++;
            }
            return r9;
        }
        if (!java.util.Map.class.isAssignableFrom(cls)) {
            java.util.ArrayList arrayList3 = new java.util.ArrayList();
            for (java.lang.Class<T> cls2 = cls; !cls2.equals(java.lang.Object.class); cls2 = cls2.getSuperclass()) {
                arrayList3.add(cls2);
            }
            java.util.HashMap hashMap = (java.util.HashMap) obj;
            java.util.HashMap hashMap2 = new java.util.HashMap();
            for (java.lang.String str : hashMap.keySet()) {
                if (hashMap.get(str) != null) {
                    java.util.Iterator it = arrayList3.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            try {
                                field = ((java.lang.Class) it.next()).getDeclaredField(str);
                            } catch (java.lang.Throwable unused2) {
                                field = null;
                            }
                            if (field != null) {
                                hashMap2.put(str, field);
                                break;
                            }
                        }
                    }
                }
            }
            T t2 = (T) cn.fly.verify.fp.a(cn.fly.verify.fp.a((java.lang.Class<?>) cls), new java.lang.Object[0]);
            for (java.lang.String str2 : hashMap2.keySet()) {
                java.lang.Object obj5 = hashMap.get(str2);
                java.lang.reflect.Field field2 = (java.lang.reflect.Field) hashMap2.get(str2);
                java.lang.Class<?> type4 = field2.getType();
                java.lang.reflect.Type genericType = field2.getGenericType();
                java.lang.reflect.Type[] actualTypeArguments = genericType instanceof java.lang.reflect.ParameterizedType ? ((java.lang.reflect.ParameterizedType) genericType).getActualTypeArguments() : null;
                field2.setAccessible(true);
                field2.set(t2, a(obj5, type4, actualTypeArguments));
            }
            return t2;
        }
        ?? r92 = (T) ((java.util.Map) cls.newInstance());
        if (typeArr == null || typeArr.length <= 1) {
            type = null;
            type2 = null;
        } else {
            type2 = typeArr[0];
            type = typeArr[1];
        }
        java.util.HashMap hashMap3 = (java.util.HashMap) obj;
        for (java.lang.Object obj6 : hashMap3.keySet()) {
            if (type2 != null && (type2 instanceof java.lang.Class) && !type.equals(java.lang.Object.class)) {
                obj2 = a(obj6, (java.lang.Class) type2, null);
            } else if (type2 == null || !(type2 instanceof java.lang.reflect.ParameterizedType)) {
                obj2 = obj6;
            } else {
                java.lang.reflect.ParameterizedType parameterizedType2 = (java.lang.reflect.ParameterizedType) type2;
                obj2 = a(obj6, (java.lang.Class) parameterizedType2.getRawType(), parameterizedType2.getActualTypeArguments());
            }
            if (type != null && (type instanceof java.lang.Class) && !type.equals(java.lang.Object.class)) {
                obj3 = a(hashMap3.get(obj6), (java.lang.Class) type, null);
            } else if (type == null || !(type instanceof java.lang.reflect.ParameterizedType)) {
                obj3 = hashMap3.get(obj6);
            } else {
                java.lang.reflect.ParameterizedType parameterizedType3 = (java.lang.reflect.ParameterizedType) type;
                obj3 = a(hashMap3.get(obj6), (java.lang.Class) parameterizedType3.getRawType(), parameterizedType3.getActualTypeArguments());
            }
            r92.put(obj2, obj3);
        }
        return r92;
    }

    public static <T> T a(java.lang.String str, java.lang.Class<T> cls) {
        java.util.HashMap a2 = a(str);
        java.lang.Object obj = a2;
        if (str.startsWith("[")) {
            obj = a2;
            if (str.endsWith("]")) {
                obj = a2.get(cn.fly.verify.bj.a("008;fgYe>emGgh<ejgi.j"));
            }
        }
        try {
            java.lang.reflect.Type genericSuperclass = cls.getGenericSuperclass();
            return (T) a(obj, cls, genericSuperclass instanceof java.lang.reflect.ParameterizedType ? ((java.lang.reflect.ParameterizedType) genericSuperclass).getActualTypeArguments() : null);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return null;
        }
    }

    public static java.lang.String a(java.lang.Object obj) {
        java.lang.Object obj2;
        try {
            obj2 = d(obj);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            obj2 = null;
        }
        if (obj2 == null) {
            return "";
        }
        if (!(obj2 instanceof java.util.ArrayList)) {
            return a((java.util.HashMap) obj2);
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(cn.fly.verify.bj.a("004hIejgi;j"), obj2);
        return a(hashMap).substring(8, r2.length() - 1).trim();
    }

    public static <T> java.lang.String a(java.util.HashMap<java.lang.String, T> hashMap) {
        try {
            org.json.JSONObject b = b((java.util.HashMap) hashMap);
            return b == null ? "" : b.toString();
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return "";
        }
    }

    private static java.util.ArrayList<java.lang.Object> a(org.json.JSONArray jSONArray) throws java.lang.Throwable {
        java.util.ArrayList<java.lang.Object> arrayList = new java.util.ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            java.lang.Object opt = jSONArray.opt(i);
            if (opt instanceof org.json.JSONObject) {
                opt = a((org.json.JSONObject) opt);
            } else if (opt instanceof org.json.JSONArray) {
                opt = a((org.json.JSONArray) opt);
            }
            arrayList.add(opt);
        }
        return arrayList;
    }

    public static <T> java.util.HashMap<java.lang.String, T> a(java.lang.String str) {
        if (str == null || str.isEmpty()) {
            return new java.util.HashMap<>();
        }
        try {
            if (str.startsWith("[") && str.endsWith("]")) {
                str = "{\"fakelist\":" + str + com.alipay.sdk.m.u.i.d;
            }
            return a(new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(str);
            cn.fly.verify.ed.a().b(th);
            return new java.util.HashMap<>();
        }
    }

    private static <T> java.util.HashMap<java.lang.String, T> a(org.json.JSONObject jSONObject) throws java.lang.Throwable {
        com.aliyun.svideo.editor.contant.EditorConstants.AnonymousClass1 anonymousClass1 = (java.util.HashMap<java.lang.String, T>) new java.util.HashMap();
        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            java.lang.String next = keys.next();
            java.lang.Object opt = jSONObject.opt(next);
            if (org.json.JSONObject.NULL.equals(opt)) {
                opt = null;
            }
            if (opt != null) {
                if (opt instanceof org.json.JSONObject) {
                    opt = a((org.json.JSONObject) opt);
                } else if (opt instanceof org.json.JSONArray) {
                    opt = a((org.json.JSONArray) opt);
                }
                anonymousClass1.put(next, opt);
            }
        }
        return anonymousClass1;
    }

    private static org.json.JSONArray a(java.util.ArrayList<java.lang.Object> arrayList) throws java.lang.Throwable {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<java.lang.Object> it = arrayList.iterator();
        while (it.hasNext()) {
            java.lang.Object next = it.next();
            if (next instanceof java.util.HashMap) {
                next = b((java.util.HashMap) next);
            } else if (next instanceof java.util.ArrayList) {
                next = a((java.util.ArrayList<java.lang.Object>) next);
            }
            jSONArray.put(next);
        }
        return jSONArray;
    }

    private static <T> org.json.JSONObject b(java.util.HashMap<java.lang.String, T> hashMap) throws java.lang.Throwable {
        java.util.ArrayList<?> c;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        for (java.util.Map.Entry<java.lang.String, T> entry : hashMap.entrySet()) {
            java.lang.Object value = entry.getValue();
            if (value instanceof java.util.HashMap) {
                value = b((java.util.HashMap) value);
            } else {
                if (value instanceof java.util.ArrayList) {
                    c = (java.util.ArrayList) value;
                } else if (b(value)) {
                    c = c(value);
                }
                value = a((java.util.ArrayList<java.lang.Object>) c);
            }
            jSONObject.put(entry.getKey(), value);
        }
        return jSONObject;
    }

    private static boolean b(java.lang.Object obj) {
        return (obj instanceof byte[]) || (obj instanceof short[]) || (obj instanceof int[]) || (obj instanceof long[]) || (obj instanceof float[]) || (obj instanceof double[]) || (obj instanceof char[]) || (obj instanceof boolean[]) || (obj instanceof java.lang.String[]);
    }

    private static java.util.ArrayList<?> c(java.lang.Object obj) {
        int i = 0;
        if (obj instanceof byte[]) {
            java.util.ArrayList<?> arrayList = new java.util.ArrayList<>();
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            while (i < length) {
                arrayList.add(java.lang.Byte.valueOf(bArr[i]));
                i++;
            }
            return arrayList;
        }
        if (obj instanceof short[]) {
            java.util.ArrayList<?> arrayList2 = new java.util.ArrayList<>();
            short[] sArr = (short[]) obj;
            int length2 = sArr.length;
            while (i < length2) {
                arrayList2.add(java.lang.Short.valueOf(sArr[i]));
                i++;
            }
            return arrayList2;
        }
        if (obj instanceof int[]) {
            java.util.ArrayList<?> arrayList3 = new java.util.ArrayList<>();
            int[] iArr = (int[]) obj;
            int length3 = iArr.length;
            while (i < length3) {
                arrayList3.add(java.lang.Integer.valueOf(iArr[i]));
                i++;
            }
            return arrayList3;
        }
        if (obj instanceof long[]) {
            java.util.ArrayList<?> arrayList4 = new java.util.ArrayList<>();
            long[] jArr = (long[]) obj;
            int length4 = jArr.length;
            while (i < length4) {
                arrayList4.add(java.lang.Long.valueOf(jArr[i]));
                i++;
            }
            return arrayList4;
        }
        if (obj instanceof float[]) {
            java.util.ArrayList<?> arrayList5 = new java.util.ArrayList<>();
            float[] fArr = (float[]) obj;
            int length5 = fArr.length;
            while (i < length5) {
                arrayList5.add(java.lang.Float.valueOf(fArr[i]));
                i++;
            }
            return arrayList5;
        }
        if (obj instanceof double[]) {
            java.util.ArrayList<?> arrayList6 = new java.util.ArrayList<>();
            double[] dArr = (double[]) obj;
            int length6 = dArr.length;
            while (i < length6) {
                arrayList6.add(java.lang.Double.valueOf(dArr[i]));
                i++;
            }
            return arrayList6;
        }
        if (obj instanceof char[]) {
            java.util.ArrayList<?> arrayList7 = new java.util.ArrayList<>();
            char[] cArr = (char[]) obj;
            int length7 = cArr.length;
            while (i < length7) {
                arrayList7.add(java.lang.Character.valueOf(cArr[i]));
                i++;
            }
            return arrayList7;
        }
        if (!(obj instanceof boolean[])) {
            if (obj instanceof java.lang.String[]) {
                return new java.util.ArrayList<>(java.util.Arrays.asList((java.lang.String[]) obj));
            }
            return null;
        }
        java.util.ArrayList<?> arrayList8 = new java.util.ArrayList<>();
        boolean[] zArr = (boolean[]) obj;
        int length8 = zArr.length;
        while (i < length8) {
            arrayList8.add(java.lang.Boolean.valueOf(zArr[i]));
            i++;
        }
        return arrayList8;
    }

    private static java.lang.Object d(java.lang.Object obj) throws java.lang.Throwable {
        if (obj == null || obj.getClass().isPrimitive() || (obj instanceof java.lang.String) || (obj instanceof java.lang.Number) || (obj instanceof java.lang.Character) || (obj instanceof java.lang.Boolean)) {
            return obj;
        }
        if (obj instanceof cn.fly.verify.fm.a) {
            return d(((cn.fly.verify.fm.a) obj).a());
        }
        if (obj instanceof java.lang.Enum) {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(cn.fly.verify.bj.a("004gfJeheg"), ((java.lang.Enum) obj).name());
            return hashMap;
        }
        if (obj.getClass().isArray()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int length = java.lang.reflect.Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                arrayList.add(d(java.lang.reflect.Array.get(obj, i)));
            }
            return arrayList;
        }
        if (obj instanceof java.util.Collection) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            java.util.Iterator it = ((java.util.Collection) obj).iterator();
            while (it.hasNext()) {
                arrayList2.add(d(it.next()));
            }
            return arrayList2;
        }
        if (obj instanceof java.util.Map) {
            java.util.HashMap hashMap2 = new java.util.HashMap();
            for (java.util.Map.Entry entry : ((java.util.Map) obj).entrySet()) {
                java.lang.Object key = entry.getKey();
                if (key instanceof java.lang.String) {
                    hashMap2.put((java.lang.String) key, d(entry.getValue()));
                }
            }
            return hashMap2;
        }
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        for (java.lang.Class<?> cls = obj.getClass(); !cls.equals(java.lang.Object.class); cls = cls.getSuperclass()) {
            arrayList3.add(0, cls);
        }
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        java.util.Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            for (java.lang.reflect.Field field : ((java.lang.Class) it2.next()).getDeclaredFields()) {
                if (!java.lang.reflect.Modifier.isStatic(field.getModifiers()) && !field.getName().contains("$")) {
                    arrayList4.add(field);
                }
            }
        }
        java.util.HashMap hashMap3 = new java.util.HashMap();
        java.util.Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            java.lang.reflect.Field field2 = (java.lang.reflect.Field) it3.next();
            field2.setAccessible(true);
            hashMap3.put(field2.getName(), d(field2.get(obj)));
        }
        return hashMap3;
    }
}
