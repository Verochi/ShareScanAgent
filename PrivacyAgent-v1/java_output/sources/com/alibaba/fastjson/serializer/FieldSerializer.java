package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public final class FieldSerializer implements java.lang.Comparable<com.alibaba.fastjson.serializer.FieldSerializer> {
    protected final int features;
    public final com.alibaba.fastjson.util.FieldInfo fieldInfo;
    protected final java.lang.String format;
    protected char[] name_chars;
    private com.alibaba.fastjson.serializer.FieldSerializer.RuntimeSerializerInfo runtimeInfo;
    protected final boolean writeNull;

    public static class RuntimeSerializerInfo {
        com.alibaba.fastjson.serializer.ObjectSerializer fieldSerializer;
        java.lang.Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer, java.lang.Class<?> cls) {
            this.fieldSerializer = objectSerializer;
            this.runtimeFieldClass = cls;
        }
    }

    public FieldSerializer(com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        boolean z;
        this.fieldInfo = fieldInfo;
        com.alibaba.fastjson.annotation.JSONField annotation = fieldInfo.getAnnotation();
        if (annotation != null) {
            z = false;
            for (com.alibaba.fastjson.serializer.SerializerFeature serializerFeature : annotation.serialzeFeatures()) {
                if (serializerFeature == com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue) {
                    z = true;
                }
            }
            java.lang.String trim = annotation.format().trim();
            r3 = trim.length() != 0 ? trim : null;
            this.features = com.alibaba.fastjson.serializer.SerializerFeature.of(annotation.serialzeFeatures());
        } else {
            this.features = 0;
            z = false;
        }
        this.writeNull = z;
        this.format = r3;
        java.lang.String str = fieldInfo.name;
        int length = str.length();
        this.name_chars = new char[length + 3];
        str.getChars(0, str.length(), this.name_chars, 1);
        char[] cArr = this.name_chars;
        cArr[0] = kotlin.text.Typography.quote;
        cArr[length + 1] = kotlin.text.Typography.quote;
        cArr[length + 2] = ':';
    }

    @Override // java.lang.Comparable
    public int compareTo(com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer) {
        return this.fieldInfo.compareTo(fieldSerializer.fieldInfo);
    }

    public java.lang.Object getPropertyValue(java.lang.Object obj) throws java.lang.Exception {
        try {
            return this.fieldInfo.get(obj);
        } catch (java.lang.Exception e) {
            com.alibaba.fastjson.util.FieldInfo fieldInfo = this.fieldInfo;
            java.lang.reflect.Member member = fieldInfo.method;
            if (member == null) {
                member = fieldInfo.field;
            }
            throw new com.alibaba.fastjson.JSONException("get property error。 " + (member.getDeclaringClass().getName() + "." + member.getName()), e);
        }
    }

    public void writePrefix(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        int i = serializeWriter.features;
        if ((com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames.mask & i) == 0) {
            serializeWriter.writeFieldName(this.fieldInfo.name, true);
        } else if ((i & com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask) != 0) {
            serializeWriter.writeFieldName(this.fieldInfo.name, true);
        } else {
            char[] cArr = this.name_chars;
            serializeWriter.write(cArr, 0, cArr.length);
        }
    }

    public void writeValue(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj) throws java.lang.Exception {
        java.lang.String str = this.format;
        if (str != null) {
            jSONSerializer.writeWithFormat(obj, str);
            return;
        }
        if (this.runtimeInfo == null) {
            java.lang.Class<?> cls = obj == null ? this.fieldInfo.fieldClass : obj.getClass();
            this.runtimeInfo = new com.alibaba.fastjson.serializer.FieldSerializer.RuntimeSerializerInfo(jSONSerializer.config.get(cls), cls);
        }
        com.alibaba.fastjson.serializer.FieldSerializer.RuntimeSerializerInfo runtimeSerializerInfo = this.runtimeInfo;
        if (obj != null) {
            java.lang.Class<?> cls2 = obj.getClass();
            if (cls2 == runtimeSerializerInfo.runtimeFieldClass) {
                com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer = runtimeSerializerInfo.fieldSerializer;
                com.alibaba.fastjson.util.FieldInfo fieldInfo = this.fieldInfo;
                objectSerializer.write(jSONSerializer, obj, fieldInfo.name, fieldInfo.fieldType);
                return;
            } else {
                com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer2 = jSONSerializer.config.get(cls2);
                com.alibaba.fastjson.util.FieldInfo fieldInfo2 = this.fieldInfo;
                objectSerializer2.write(jSONSerializer, obj, fieldInfo2.name, fieldInfo2.fieldType);
                return;
            }
        }
        if ((this.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero.mask) != 0 && java.lang.Number.class.isAssignableFrom(runtimeSerializerInfo.runtimeFieldClass)) {
            jSONSerializer.out.write(48);
            return;
        }
        int i = this.features;
        if ((com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse.mask & i) != 0 && java.lang.Boolean.class == runtimeSerializerInfo.runtimeFieldClass) {
            jSONSerializer.out.write(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        } else if ((i & com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty.mask) == 0 || !java.util.Collection.class.isAssignableFrom(runtimeSerializerInfo.runtimeFieldClass)) {
            runtimeSerializerInfo.fieldSerializer.write(jSONSerializer, null, this.fieldInfo.name, runtimeSerializerInfo.runtimeFieldClass);
        } else {
            jSONSerializer.out.write("[]");
        }
    }
}
