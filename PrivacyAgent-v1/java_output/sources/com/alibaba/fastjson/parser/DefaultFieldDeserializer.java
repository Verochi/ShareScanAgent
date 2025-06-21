package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
public class DefaultFieldDeserializer extends com.alibaba.fastjson.parser.deserializer.FieldDeserializer {
    protected com.alibaba.fastjson.parser.deserializer.ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(com.alibaba.fastjson.parser.ParserConfig parserConfig, java.lang.Class<?> cls, com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        super(cls, fieldInfo, 2);
    }

    public com.alibaba.fastjson.parser.deserializer.ObjectDeserializer getFieldValueDeserilizer(com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        if (this.fieldValueDeserilizer == null) {
            com.alibaba.fastjson.util.FieldInfo fieldInfo = this.fieldInfo;
            this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
        }
        return this.fieldValueDeserilizer;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseField(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.Object obj, java.lang.reflect.Type type, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object deserialze;
        java.lang.Class<?> cls;
        if (this.fieldValueDeserilizer == null) {
            com.alibaba.fastjson.parser.ParserConfig parserConfig = defaultJSONParser.config;
            com.alibaba.fastjson.util.FieldInfo fieldInfo = this.fieldInfo;
            this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
        }
        java.lang.reflect.Type type2 = this.fieldInfo.fieldType;
        boolean z = type instanceof java.lang.reflect.ParameterizedType;
        if (z) {
            com.alibaba.fastjson.parser.ParseContext parseContext = defaultJSONParser.contex;
            if (parseContext != null) {
                parseContext.type = type;
            }
            type2 = com.alibaba.fastjson.util.FieldInfo.getFieldType(this.clazz, type, type2);
            this.fieldValueDeserilizer = defaultJSONParser.config.getDeserializer(type2);
        }
        if ((type2 instanceof java.lang.reflect.ParameterizedType) && z) {
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type2;
            java.lang.reflect.ParameterizedType parameterizedType2 = (java.lang.reflect.ParameterizedType) type;
            java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            java.lang.reflect.Type rawType = parameterizedType2.getRawType();
            if ((rawType instanceof java.lang.Class) && com.alibaba.fastjson.util.TypeUtils.getArgument(actualTypeArguments, ((java.lang.Class) rawType).getTypeParameters(), parameterizedType2.getActualTypeArguments())) {
                type2 = new com.alibaba.fastjson.util.ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
            }
        }
        com.alibaba.fastjson.util.FieldInfo fieldInfo2 = this.fieldInfo;
        java.lang.String str = fieldInfo2.format;
        if (str != null) {
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
            if (objectDeserializer instanceof com.alibaba.fastjson.serializer.DateCodec) {
                deserialze = ((com.alibaba.fastjson.serializer.DateCodec) objectDeserializer).deserialze(defaultJSONParser, type2, fieldInfo2.name, str);
                if (defaultJSONParser.resolveStatus != 1) {
                    com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask lastResolveTask = defaultJSONParser.getLastResolveTask();
                    lastResolveTask.fieldDeserializer = this;
                    lastResolveTask.ownerContext = defaultJSONParser.contex;
                    defaultJSONParser.resolveStatus = 0;
                    return;
                }
                if (obj == null) {
                    map.put(this.fieldInfo.name, deserialze);
                    return;
                }
                if (deserialze == null && ((cls = this.fieldInfo.fieldClass) == java.lang.Byte.TYPE || cls == java.lang.Short.TYPE || cls == java.lang.Float.TYPE || cls == java.lang.Double.TYPE)) {
                    return;
                }
                setValue(obj, deserialze);
                return;
            }
        }
        deserialze = this.fieldValueDeserilizer.deserialze(defaultJSONParser, type2, fieldInfo2.name);
        if (defaultJSONParser.resolveStatus != 1) {
        }
    }
}
