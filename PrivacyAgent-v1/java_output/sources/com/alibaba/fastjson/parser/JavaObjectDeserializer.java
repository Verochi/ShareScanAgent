package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
class JavaObjectDeserializer implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.parser.JavaObjectDeserializer instance = new com.alibaba.fastjson.parser.JavaObjectDeserializer();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        if (!(type instanceof java.lang.reflect.GenericArrayType)) {
            return (T) defaultJSONParser.parse(obj);
        }
        java.lang.reflect.Type genericComponentType = ((java.lang.reflect.GenericArrayType) type).getGenericComponentType();
        if (genericComponentType instanceof java.lang.reflect.TypeVariable) {
            genericComponentType = ((java.lang.reflect.TypeVariable) genericComponentType).getBounds()[0];
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        defaultJSONParser.parseArray(genericComponentType, arrayList);
        if (!(genericComponentType instanceof java.lang.Class)) {
            return (T) arrayList.toArray();
        }
        T t = (T) ((java.lang.Object[]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) genericComponentType, arrayList.size()));
        arrayList.toArray((java.lang.Object[]) t);
        return t;
    }
}
