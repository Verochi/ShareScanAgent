package com.huawei.hms.core.aidl;

/* loaded from: classes22.dex */
public class MessageCodec {
    protected static final int VAL_ENTITY = 0;
    protected static final int VAL_LIST = 1;
    protected static final int VAL_NULL = -1;
    protected static final java.lang.String VAL_TYPE = "_val_type_";

    private android.os.Bundle a(java.lang.String str, android.os.Bundle bundle, java.lang.Object obj) {
        android.os.Bundle bundle2 = new android.os.Bundle();
        writeValue(str, obj, bundle2);
        bundle.putBundle("_next_item_", bundle2);
        return bundle2;
    }

    private java.lang.Object a(java.lang.reflect.Field field, android.os.Bundle bundle) {
        java.lang.String name = field.getName();
        java.lang.Object obj = bundle.get(name);
        if (obj instanceof android.os.Bundle) {
            try {
                android.os.Bundle bundle2 = (android.os.Bundle) obj;
                int i = bundle2.getInt(VAL_TYPE, -1);
                if (i == 1) {
                    return readList(field.getGenericType(), bundle2);
                }
                if (i == 0) {
                    return decode((android.os.Bundle) obj, (com.huawei.hms.core.aidl.IMessageEntity) field.getType().newInstance());
                }
            } catch (java.lang.Exception unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("decode, read value of the field exception, field name: ");
                sb.append(name);
                return null;
            }
        }
        return obj;
    }

    private void a(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.reflect.Field field, android.os.Bundle bundle) throws java.lang.IllegalAccessException {
        java.lang.Object a = a(field, bundle);
        if (a != null) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            field.set(iMessageEntity, a);
            field.setAccessible(isAccessible);
        }
    }

    private boolean a(java.lang.String str, java.lang.Object obj, android.os.Bundle bundle) {
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

    private void b(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.reflect.Field field, android.os.Bundle bundle) throws java.lang.IllegalAccessException {
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        writeValue(field.getName(), field.get(iMessageEntity), bundle);
        field.setAccessible(isAccessible);
    }

    public com.huawei.hms.core.aidl.IMessageEntity decode(android.os.Bundle bundle, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
        if (bundle == null) {
            return iMessageEntity;
        }
        bundle.setClassLoader(getClass().getClassLoader());
        for (java.lang.Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(com.huawei.hms.core.aidl.annotation.Packed.class)) {
                    try {
                        a(iMessageEntity, field, bundle);
                    } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException unused) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("decode, set value of the field exception, field name:");
                        sb.append(field.getName());
                    }
                }
            }
        }
        return iMessageEntity;
    }

    public android.os.Bundle encode(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, android.os.Bundle bundle) {
        for (java.lang.Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(com.huawei.hms.core.aidl.annotation.Packed.class)) {
                    try {
                        b(iMessageEntity, field, bundle);
                    } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException unused) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("encode, get value of the field exception, field name: ");
                        sb.append(field.getName());
                    }
                }
            }
        }
        return bundle;
    }

    public java.util.List<java.lang.Object> readList(java.lang.reflect.Type type, android.os.Bundle bundle) throws java.lang.InstantiationException, java.lang.IllegalAccessException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (android.os.Bundle bundle2 = bundle.getBundle("_next_item_"); bundle2 != null; bundle2 = bundle2.getBundle("_next_item_")) {
            java.lang.Object obj = bundle2.get("_value_");
            if (obj.getClass().isPrimitive() || (obj instanceof java.lang.String) || (obj instanceof java.io.Serializable)) {
                arrayList.add(obj);
            } else if (obj instanceof android.os.Bundle) {
                android.os.Bundle bundle3 = (android.os.Bundle) obj;
                int i = bundle3.getInt(VAL_TYPE, -1);
                if (i == 1) {
                    throw new java.lang.InstantiationException("Nested List can not be supported");
                }
                if (i != 0) {
                    throw new java.lang.InstantiationException("Unknown type can not be supported");
                }
                arrayList.add(decode(bundle3, (com.huawei.hms.core.aidl.IMessageEntity) ((java.lang.Class) ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
            } else {
                continue;
            }
        }
        return arrayList;
    }

    public void writeList(java.lang.String str, java.util.List list, android.os.Bundle bundle) {
        android.os.Bundle bundle2 = null;
        for (java.lang.Object obj : list) {
            if (bundle2 == null) {
                bundle2 = new android.os.Bundle();
                bundle.putBundle(str, bundle2);
                bundle2.putInt(VAL_TYPE, 1);
            }
            bundle2 = a("_value_", bundle2, obj);
        }
    }

    public void writeValue(java.lang.String str, java.lang.Object obj, android.os.Bundle bundle) {
        if (obj == null || a(str, obj, bundle)) {
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
            writeList(str, (java.util.List) obj, bundle);
            return;
        }
        if (obj instanceof java.io.Serializable) {
            bundle.putSerializable(str, (java.io.Serializable) obj);
            return;
        }
        if (obj instanceof com.huawei.hms.core.aidl.IMessageEntity) {
            android.os.Bundle encode = encode((com.huawei.hms.core.aidl.IMessageEntity) obj, new android.os.Bundle());
            encode.putInt(VAL_TYPE, 0);
            bundle.putBundle(str, encode);
        } else {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("cannot support type, ");
            sb.append(str);
        }
    }
}
