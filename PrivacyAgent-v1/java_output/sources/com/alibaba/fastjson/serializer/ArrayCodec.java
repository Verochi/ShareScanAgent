package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public final class ArrayCodec implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.serializer.ArrayCodec instance = new com.alibaba.fastjson.serializer.ArrayCodec();

    private ArrayCodec() {
    }

    private <T> T toObjectArray(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.Class<?> cls, com.alibaba.fastjson.JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        T t = (T) java.lang.reflect.Array.newInstance(cls, size);
        for (int i = 0; i < size; i++) {
            java.lang.Object obj = jSONArray.get(i);
            if (obj == jSONArray) {
                java.lang.reflect.Array.set(t, i, t);
            } else {
                if (!cls.isArray()) {
                    obj = com.alibaba.fastjson.util.TypeUtils.cast(obj, (java.lang.Class<java.lang.Object>) cls, defaultJSONParser.config);
                } else if (!cls.isInstance(obj)) {
                    obj = toObjectArray(defaultJSONParser, cls, (com.alibaba.fastjson.JSONArray) obj);
                }
                java.lang.reflect.Array.set(t, i, obj);
            }
        }
        jSONArray.setRelatedArray(t);
        jSONArray.setComponentType(cls);
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (type != char[].class) {
            if (i == 4) {
                T t = (T) jSONLexer.bytesValue();
                jSONLexer.nextToken(16);
                return t;
            }
            java.lang.Class<?> componentType = ((java.lang.Class) type).getComponentType();
            com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
            defaultJSONParser.parseArray(componentType, jSONArray, obj);
            return (T) toObjectArray(defaultJSONParser, componentType, jSONArray);
        }
        if (i == 4) {
            java.lang.String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            return (T) stringVal.toCharArray();
        }
        if (i != 2) {
            return (T) com.alibaba.fastjson.JSON.toJSONString(defaultJSONParser.parse()).toCharArray();
        }
        java.lang.Number integerValue = jSONLexer.integerValue();
        jSONLexer.nextToken(16);
        return (T) integerValue.toString().toCharArray();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        java.lang.Object[] objArr = (java.lang.Object[]) obj;
        if (obj == null) {
            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                serializeWriter.write("[]");
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        int length = objArr.length;
        int i = length - 1;
        if (i == -1) {
            serializeWriter.append((java.lang.CharSequence) "[]");
            return;
        }
        com.alibaba.fastjson.serializer.SerialContext serialContext = jSONSerializer.context;
        int i2 = 0;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.write(91);
            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat.mask) != 0) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
                while (i2 < length) {
                    if (i2 != 0) {
                        serializeWriter.write(44);
                        jSONSerializer.println();
                    }
                    jSONSerializer.write(objArr[i2]);
                    i2++;
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter.write(93);
                return;
            }
            java.lang.Class<?> cls = null;
            com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer = null;
            while (i2 < i) {
                java.lang.Object obj3 = objArr[i2];
                if (obj3 == null) {
                    serializeWriter.append((java.lang.CharSequence) "null,");
                } else {
                    java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> identityHashMap = jSONSerializer.references;
                    if (identityHashMap == null || !identityHashMap.containsKey(obj3)) {
                        java.lang.Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            objectSerializer.write(jSONSerializer, obj3, null, null);
                        } else {
                            objectSerializer = jSONSerializer.config.get(cls2);
                            objectSerializer.write(jSONSerializer, obj3, null, null);
                            cls = cls2;
                        }
                    } else {
                        jSONSerializer.writeReference(obj3);
                    }
                    serializeWriter.write(44);
                }
                i2++;
            }
            java.lang.Object obj4 = objArr[i];
            if (obj4 == null) {
                serializeWriter.append((java.lang.CharSequence) "null]");
            } else {
                java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> identityHashMap2 = jSONSerializer.references;
                if (identityHashMap2 == null || !identityHashMap2.containsKey(obj4)) {
                    jSONSerializer.writeWithFieldName(obj4, java.lang.Integer.valueOf(i));
                } else {
                    jSONSerializer.writeReference(obj4);
                }
                serializeWriter.write(93);
            }
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
