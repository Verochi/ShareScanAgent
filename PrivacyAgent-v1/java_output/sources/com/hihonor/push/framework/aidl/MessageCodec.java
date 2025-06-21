package com.hihonor.push.framework.aidl;

/* loaded from: classes22.dex */
public class MessageCodec {
    private static final java.lang.String BUNDLE_NEXT = "_next_item_";
    private static final java.lang.String BUNDLE_VALUE = "_value_";
    public static final java.lang.String PACKED_TYPE = "_packed_type_";
    private static final java.lang.String TAG = "MessageCodec";
    public static final int VAL_ENTITY = 0;
    public static final int VAL_LIST = 1;
    public static final int VAL_NULL = -1;

    private MessageCodec() {
    }

    public static android.os.Bundle formMessageEntity(com.hihonor.push.framework.aidl.IMessageEntity iMessageEntity, android.os.Bundle bundle) {
        if (iMessageEntity != null && bundle != null) {
            for (java.lang.Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
                for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
                    if (field.isAnnotationPresent(com.hihonor.push.framework.aidl.annotation.Packed.class)) {
                        try {
                            formMessageField(iMessageEntity, field, bundle);
                        } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException unused) {
                            new java.lang.StringBuilder("encode, get value of the field exception, field name: ").append(field.getName());
                        }
                    }
                }
            }
        }
        return bundle;
    }

    private static void formMessageField(com.hihonor.push.framework.aidl.IMessageEntity iMessageEntity, java.lang.reflect.Field field, android.os.Bundle bundle) {
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        put(field.getName(), field.get(iMessageEntity), bundle);
        field.setAccessible(isAccessible);
    }

    private static java.lang.Object newInstance(java.lang.reflect.Field field, android.os.Bundle bundle) {
        java.lang.String name = field.getName();
        java.lang.Object obj = bundle.get(name);
        if (obj instanceof android.os.Bundle) {
            try {
                android.os.Bundle bundle2 = (android.os.Bundle) obj;
                int i = bundle2.getInt(PACKED_TYPE, -1);
                if (i == 1) {
                    return parseGenericType(field.getGenericType(), bundle2);
                }
                if (i == 0) {
                    return parseMessageEntity((android.os.Bundle) obj, (com.hihonor.push.framework.aidl.IMessageEntity) field.getType().newInstance());
                }
            } catch (java.lang.Exception unused) {
                "decode, read value of the field exception, field name: ".concat(java.lang.String.valueOf(name));
                return null;
            }
        }
        return obj;
    }

    private static java.util.List<java.lang.Object> parseGenericType(java.lang.reflect.Type type, android.os.Bundle bundle) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (true) {
            bundle = bundle.getBundle(BUNDLE_NEXT);
            if (bundle == null) {
                return arrayList;
            }
            java.lang.Object obj = bundle.get(BUNDLE_VALUE);
            if (!obj.getClass().isPrimitive() && !(obj instanceof java.io.Serializable)) {
                if (obj instanceof android.os.Bundle) {
                    android.os.Bundle bundle2 = (android.os.Bundle) obj;
                    int i = bundle2.getInt(PACKED_TYPE, -1);
                    if (i == 1) {
                        throw new java.lang.InstantiationException("Nested List can not be supported");
                    }
                    if (i != 0) {
                        throw new java.lang.InstantiationException("Unknown type can not be supported");
                    }
                    obj = parseMessageEntity(bundle2, (com.hihonor.push.framework.aidl.IMessageEntity) ((java.lang.Class) ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0]).newInstance());
                } else {
                    continue;
                }
            }
            arrayList.add(obj);
        }
    }

    public static com.hihonor.push.framework.aidl.IMessageEntity parseMessageEntity(android.os.Bundle bundle, com.hihonor.push.framework.aidl.IMessageEntity iMessageEntity) {
        if (bundle != null && iMessageEntity != null) {
            bundle.setClassLoader(iMessageEntity.getClass().getClassLoader());
            for (java.lang.Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
                for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
                    if (field.isAnnotationPresent(com.hihonor.push.framework.aidl.annotation.Packed.class)) {
                        try {
                            parseMessageField(iMessageEntity, field, bundle);
                        } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException unused) {
                            new java.lang.StringBuilder("decode, set value of the field exception, field name:").append(field.getName());
                        }
                    }
                }
            }
        }
        return iMessageEntity;
    }

    private static void parseMessageField(com.hihonor.push.framework.aidl.IMessageEntity iMessageEntity, java.lang.reflect.Field field, android.os.Bundle bundle) {
        java.lang.Object newInstance = newInstance(field, bundle);
        if (newInstance != null) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            field.set(iMessageEntity, newInstance);
            field.setAccessible(isAccessible);
        }
    }

    private static void put(java.lang.String str, java.lang.Object obj, android.os.Bundle bundle) {
        if (obj == null || putGenericType(str, obj, bundle)) {
            return;
        }
        if (obj instanceof java.lang.CharSequence) {
            bundle.putCharSequence(str, (java.lang.CharSequence) obj);
            return;
        }
        if (obj instanceof android.os.Parcelable) {
            bundle.putParcelable(str, (android.os.Parcelable) obj);
            return;
        }
        if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
            return;
        }
        if (obj instanceof java.util.List) {
            putList(str, (java.util.List) obj, bundle);
            return;
        }
        if (obj instanceof java.io.Serializable) {
            bundle.putSerializable(str, (java.io.Serializable) obj);
        } else {
            if (!(obj instanceof com.hihonor.push.framework.aidl.IMessageEntity)) {
                "cannot support type, ".concat(java.lang.String.valueOf(str));
                return;
            }
            android.os.Bundle formMessageEntity = formMessageEntity((com.hihonor.push.framework.aidl.IMessageEntity) obj, new android.os.Bundle());
            formMessageEntity.putInt(PACKED_TYPE, 0);
            bundle.putBundle(str, formMessageEntity);
        }
    }

    private static boolean putGenericType(java.lang.String str, java.lang.Object obj, android.os.Bundle bundle) {
        if (obj instanceof java.lang.String) {
            bundle.putString(str, (java.lang.String) obj);
            return true;
        }
        if (obj instanceof java.lang.Integer) {
            bundle.putInt(str, ((java.lang.Integer) obj).intValue());
            return true;
        }
        if (obj instanceof java.lang.Short) {
            bundle.putShort(str, ((java.lang.Short) obj).shortValue());
            return true;
        }
        if (obj instanceof java.lang.Long) {
            bundle.putLong(str, ((java.lang.Long) obj).longValue());
            return true;
        }
        if (obj instanceof java.lang.Float) {
            bundle.putFloat(str, ((java.lang.Float) obj).floatValue());
            return true;
        }
        if (obj instanceof java.lang.Double) {
            bundle.putDouble(str, ((java.lang.Double) obj).doubleValue());
            return true;
        }
        if (!(obj instanceof java.lang.Boolean)) {
            return false;
        }
        bundle.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
        return true;
    }

    private static void putList(java.lang.String str, java.util.List list, android.os.Bundle bundle) {
        android.os.Bundle bundle2 = null;
        for (java.lang.Object obj : list) {
            if (bundle2 == null) {
                bundle2 = new android.os.Bundle();
                bundle.putBundle(str, bundle2);
                bundle2.putInt(PACKED_TYPE, 1);
            }
            bundle2 = putNext(BUNDLE_VALUE, bundle2, obj);
        }
    }

    private static android.os.Bundle putNext(java.lang.String str, android.os.Bundle bundle, java.lang.Object obj) {
        android.os.Bundle bundle2 = new android.os.Bundle();
        put(str, obj, bundle2);
        bundle.putBundle(BUNDLE_NEXT, bundle2);
        return bundle2;
    }
}
