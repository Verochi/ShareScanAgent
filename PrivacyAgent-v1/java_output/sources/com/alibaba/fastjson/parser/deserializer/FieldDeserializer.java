package com.alibaba.fastjson.parser.deserializer;

/* loaded from: classes.dex */
public abstract class FieldDeserializer {
    public final java.lang.Class<?> clazz;
    protected long[] enumNameHashCodes;
    protected java.lang.Enum[] enums;
    public final com.alibaba.fastjson.util.FieldInfo fieldInfo;

    public FieldDeserializer(java.lang.Class<?> cls, com.alibaba.fastjson.util.FieldInfo fieldInfo, int i) {
        this.clazz = cls;
        this.fieldInfo = fieldInfo;
        if (fieldInfo == null) {
            return;
        }
        java.lang.Class<?> cls2 = fieldInfo.fieldClass;
        if (cls2.isEnum()) {
            java.lang.Enum[] enumArr = (java.lang.Enum[]) cls2.getEnumConstants();
            int length = enumArr.length;
            long[] jArr = new long[length];
            this.enumNameHashCodes = new long[enumArr.length];
            for (int i2 = 0; i2 < enumArr.length; i2++) {
                long j = -3750763034362895579L;
                for (int i3 = 0; i3 < enumArr[i2].name().length(); i3++) {
                    j = (j ^ r2.charAt(i3)) * 1099511628211L;
                }
                jArr[i2] = j;
                this.enumNameHashCodes[i2] = j;
            }
            java.util.Arrays.sort(this.enumNameHashCodes);
            this.enums = new java.lang.Enum[enumArr.length];
            for (int i4 = 0; i4 < this.enumNameHashCodes.length; i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    if (this.enumNameHashCodes[i4] == jArr[i5]) {
                        this.enums[i4] = enumArr[i5];
                        break;
                    }
                    i5++;
                }
            }
        }
    }

    public java.lang.Enum getEnumByHashCode(long j) {
        int binarySearch;
        if (this.enums != null && (binarySearch = java.util.Arrays.binarySearch(this.enumNameHashCodes, j)) >= 0) {
            return this.enums[binarySearch];
        }
        return null;
    }

    public abstract void parseField(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.Object obj, java.lang.reflect.Type type, java.util.Map<java.lang.String, java.lang.Object> map);

    public void setValue(java.lang.Object obj, double d) throws java.lang.IllegalAccessException {
        this.fieldInfo.field.setDouble(obj, d);
    }

    public void setValue(java.lang.Object obj, float f) throws java.lang.IllegalAccessException {
        this.fieldInfo.field.setFloat(obj, f);
    }

    public void setValue(java.lang.Object obj, int i) throws java.lang.IllegalAccessException {
        this.fieldInfo.field.setInt(obj, i);
    }

    public void setValue(java.lang.Object obj, long j) throws java.lang.IllegalAccessException {
        this.fieldInfo.field.setLong(obj, j);
    }

    public void setValue(java.lang.Object obj, java.lang.Object obj2) {
        if (obj2 == null && this.fieldInfo.fieldClass.isPrimitive()) {
            return;
        }
        com.alibaba.fastjson.util.FieldInfo fieldInfo = this.fieldInfo;
        java.lang.reflect.Field field = fieldInfo.field;
        java.lang.reflect.Method method = fieldInfo.method;
        try {
            if (fieldInfo.fieldAccess) {
                if (!fieldInfo.getOnly) {
                    field.set(obj, obj2);
                    return;
                }
                if (java.util.Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                    java.util.Map map = (java.util.Map) field.get(obj);
                    if (map != null) {
                        map.putAll((java.util.Map) obj2);
                        return;
                    }
                    return;
                }
                java.util.Collection collection = (java.util.Collection) field.get(obj);
                if (collection != null) {
                    collection.addAll((java.util.Collection) obj2);
                    return;
                }
                return;
            }
            if (!fieldInfo.getOnly) {
                method.invoke(obj, obj2);
                return;
            }
            if (java.util.Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                java.util.Map map2 = (java.util.Map) method.invoke(obj, new java.lang.Object[0]);
                if (map2 != null) {
                    map2.putAll((java.util.Map) obj2);
                    return;
                }
                return;
            }
            java.util.Collection collection2 = (java.util.Collection) method.invoke(obj, new java.lang.Object[0]);
            if (collection2 != null) {
                collection2.addAll((java.util.Collection) obj2);
            }
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONException("set property error, " + this.fieldInfo.name, e);
        }
    }
}
