package com.bytedance.pangle.fragment;

/* loaded from: classes12.dex */
final class a {
    private static java.lang.Class a(java.lang.String str) {
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    private static java.lang.reflect.Field a(java.lang.Class cls, java.lang.String str) {
        try {
            java.lang.reflect.Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (java.lang.NoSuchFieldException unused) {
            return null;
        }
    }

    public static void a(java.lang.Class cls) {
        try {
            if (androidx.fragment.app.Fragment.class.getName().contains("support")) {
                ((androidx.collection.SimpleArrayMap) a(androidx.fragment.app.Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            java.lang.reflect.Field a = a(androidx.fragment.app.Fragment.class, "sClassMap");
            if (a != null) {
                ((androidx.collection.SimpleArrayMap) a.get(null)).put(cls.getName(), cls);
                return;
            }
            java.lang.Class a2 = a("androidx.fragment.app.FragmentFactory");
            if (a2 == null) {
                return;
            }
            java.lang.reflect.Field a3 = a(a2, "sClassMap");
            if (a3 != null) {
                ((androidx.collection.SimpleArrayMap) a3.get(null)).put(cls.getName(), cls);
                return;
            }
            java.lang.reflect.Field a4 = a(a2, "sClassCacheMap");
            if (a4 != null) {
                androidx.collection.SimpleArrayMap simpleArrayMap = (androidx.collection.SimpleArrayMap) a4.get(null);
                androidx.collection.SimpleArrayMap simpleArrayMap2 = new androidx.collection.SimpleArrayMap();
                simpleArrayMap2.put(cls.getName(), cls);
                simpleArrayMap.put(cls.getClassLoader(), simpleArrayMap2);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
