package com.bytedance.pangle.util;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public class FieldUtils {
    private static java.util.Map<java.lang.String, java.lang.reflect.Field> sFieldCache = new java.util.HashMap();

    public static java.lang.reflect.Field getField(java.lang.Class<?> cls, java.lang.String str) {
        java.lang.reflect.Field field;
        java.lang.String key = getKey(cls, str);
        synchronized (sFieldCache) {
            field = sFieldCache.get(key);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        while (cls != null) {
            try {
                java.lang.reflect.Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                synchronized (sFieldCache) {
                    continue;
                    sFieldCache.put(key, declaredField);
                }
                return declaredField;
            } catch (java.lang.NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static java.lang.String getKey(java.lang.Class<?> cls, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(cls.toString());
        sb.append("#");
        sb.append(str);
        sb.append("#");
        sb.append(cls.getClassLoader() != null ? java.lang.Integer.valueOf(cls.getClassLoader().hashCode()) : "");
        return sb.toString();
    }

    public static java.lang.Object readField(java.lang.Object obj, java.lang.String str) {
        java.lang.reflect.Field field = getField(obj.getClass(), str);
        if (field != null) {
            return readField(field, obj);
        }
        return null;
    }

    public static java.lang.Object readField(java.lang.reflect.Field field, java.lang.Object obj) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static java.lang.Object readStaticField(java.lang.Class<?> cls, java.lang.String str) {
        java.lang.reflect.Field field = getField(cls, str);
        if (field != null) {
            return readStaticField(field);
        }
        return null;
    }

    public static java.lang.Object readStaticField(java.lang.reflect.Field field) {
        return readField(field, (java.lang.Object) null);
    }

    public static void writeField(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        java.lang.reflect.Field field = getField(obj.getClass(), str);
        if (field != null) {
            writeField(field, obj, obj2);
        }
    }

    public static void writeField(java.lang.reflect.Field field, java.lang.Object obj, java.lang.Object obj2) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        field.set(obj, obj2);
    }

    public static void writeStaticField(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj) {
        java.lang.reflect.Field field = getField(cls, str);
        if (field != null) {
            writeStaticField(field, obj);
        }
    }

    public static void writeStaticField(java.lang.reflect.Field field, java.lang.Object obj) {
        writeField(field, (java.lang.Object) null, obj);
    }
}
