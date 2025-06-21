package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
final class ResolveFieldDeserializer extends com.alibaba.fastjson.parser.deserializer.FieldDeserializer {
    private final java.util.Collection collection;
    private final int index;
    private final java.lang.Object key;
    private final java.util.List list;
    private final java.util.Map map;
    private final com.alibaba.fastjson.parser.DefaultJSONParser parser;

    public ResolveFieldDeserializer(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.util.List list, int i) {
        super(null, null, 0);
        this.parser = defaultJSONParser;
        this.index = i;
        this.list = list;
        this.key = null;
        this.map = null;
        this.collection = null;
    }

    public ResolveFieldDeserializer(java.util.Collection collection) {
        super(null, null, 0);
        this.parser = null;
        this.index = -1;
        this.list = null;
        this.key = null;
        this.map = null;
        this.collection = collection;
    }

    public ResolveFieldDeserializer(java.util.Map map, java.lang.Object obj) {
        super(null, null, 0);
        this.parser = null;
        this.index = -1;
        this.list = null;
        this.key = obj;
        this.map = map;
        this.collection = null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.Object obj, java.lang.reflect.Type type, java.util.Map<java.lang.String, java.lang.Object> map) {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void setValue(java.lang.Object obj, java.lang.Object obj2) {
        com.alibaba.fastjson.JSONArray jSONArray;
        java.lang.Object relatedArray;
        java.util.Map map = this.map;
        if (map != null) {
            map.put(this.key, obj2);
            return;
        }
        java.util.Collection collection = this.collection;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        this.list.set(this.index, obj2);
        java.util.List list = this.list;
        if (!(list instanceof com.alibaba.fastjson.JSONArray) || (relatedArray = (jSONArray = (com.alibaba.fastjson.JSONArray) list).getRelatedArray()) == null || java.lang.reflect.Array.getLength(relatedArray) <= this.index) {
            return;
        }
        if (jSONArray.getComponentType() != null) {
            obj2 = com.alibaba.fastjson.util.TypeUtils.cast(obj2, jSONArray.getComponentType(), this.parser.config);
        }
        java.lang.reflect.Array.set(relatedArray, this.index, obj2);
    }
}
