package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public class CollectionCodec implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.serializer.CollectionCodec instance = new com.alibaba.fastjson.serializer.CollectionCodec();

    private CollectionCodec() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, com.alibaba.fastjson.JSONArray, java.util.Collection] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        java.util.Collection collection;
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        }
        if (type == com.alibaba.fastjson.JSONArray.class) {
            ?? r4 = (T) new com.alibaba.fastjson.JSONArray();
            defaultJSONParser.parseArray((java.util.Collection) r4);
            return r4;
        }
        java.lang.reflect.Type type2 = type;
        while (!(type2 instanceof java.lang.Class)) {
            if (!(type2 instanceof java.lang.reflect.ParameterizedType)) {
                throw new com.alibaba.fastjson.JSONException("TODO");
            }
            type2 = ((java.lang.reflect.ParameterizedType) type2).getRawType();
        }
        java.lang.Class cls = (java.lang.Class) type2;
        if (cls == java.util.AbstractCollection.class || cls == java.util.Collection.class) {
            collection = (T) new java.util.ArrayList();
        } else if (cls.isAssignableFrom(java.util.HashSet.class)) {
            collection = (T) new java.util.HashSet();
        } else if (cls.isAssignableFrom(java.util.LinkedHashSet.class)) {
            collection = (T) new java.util.LinkedHashSet();
        } else if (cls.isAssignableFrom(java.util.TreeSet.class)) {
            collection = (T) new java.util.TreeSet();
        } else if (cls.isAssignableFrom(java.util.ArrayList.class)) {
            collection = (T) new java.util.ArrayList();
        } else if (cls.isAssignableFrom(java.util.EnumSet.class)) {
            collection = (T) java.util.EnumSet.noneOf((java.lang.Class) (type instanceof java.lang.reflect.ParameterizedType ? ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0] : java.lang.Object.class));
        } else {
            try {
                collection = (T) ((java.util.Collection) cls.newInstance());
            } catch (java.lang.Exception unused) {
                throw new com.alibaba.fastjson.JSONException("create instane error, class " + cls.getName());
            }
        }
        defaultJSONParser.parseArray(com.alibaba.fastjson.util.TypeUtils.getCollectionItemType(type), collection, obj);
        return (T) collection;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                serializeWriter.write("[]");
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        int i = serializeWriter.features;
        com.alibaba.fastjson.serializer.SerializerFeature serializerFeature = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName;
        java.lang.reflect.Type collectionItemType = (i & serializerFeature.mask) != 0 ? com.alibaba.fastjson.util.TypeUtils.getCollectionItemType(type) : null;
        java.util.Collection collection = (java.util.Collection) obj;
        com.alibaba.fastjson.serializer.SerialContext serialContext = jSONSerializer.context;
        int i2 = 0;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        if ((serializeWriter.features & serializerFeature.mask) != 0) {
            if (java.util.HashSet.class == collection.getClass()) {
                serializeWriter.append((java.lang.CharSequence) "Set");
            } else if (java.util.TreeSet.class == collection.getClass()) {
                serializeWriter.append((java.lang.CharSequence) "TreeSet");
            }
        }
        try {
            serializeWriter.write(91);
            for (java.lang.Object obj3 : collection) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    serializeWriter.write(44);
                }
                if (obj3 == null) {
                    serializeWriter.writeNull();
                } else {
                    java.lang.Class<?> cls = obj3.getClass();
                    if (cls == java.lang.Integer.class) {
                        serializeWriter.writeInt(((java.lang.Integer) obj3).intValue());
                    } else if (cls == java.lang.Long.class) {
                        serializeWriter.writeLong(((java.lang.Long) obj3).longValue());
                        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask) != 0) {
                            serializeWriter.write(76);
                        }
                    } else {
                        jSONSerializer.config.get(cls).write(jSONSerializer, obj3, java.lang.Integer.valueOf(i3 - 1), collectionItemType);
                    }
                }
                i2 = i3;
            }
            serializeWriter.write(93);
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
