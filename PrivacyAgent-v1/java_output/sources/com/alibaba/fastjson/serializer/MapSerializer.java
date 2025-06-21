package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public final class MapSerializer implements com.alibaba.fastjson.serializer.ObjectSerializer {
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type) throws java.io.IOException {
        boolean z;
        java.lang.Object processKey;
        java.lang.Object processValue;
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        java.util.Map<java.lang.String, java.lang.Object> map = (java.util.Map) obj;
        java.lang.Class<?> cls = map.getClass();
        boolean z2 = (cls == com.alibaba.fastjson.JSONObject.class || cls == java.util.HashMap.class || cls == java.util.LinkedHashMap.class) && map.containsKey(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY);
        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.SortField.mask) != 0) {
            if (map instanceof com.alibaba.fastjson.JSONObject) {
                map = ((com.alibaba.fastjson.JSONObject) map).getInnerMap();
            }
            if (!(map instanceof java.util.SortedMap) && !(map instanceof java.util.LinkedHashMap)) {
                try {
                    map = new java.util.TreeMap(map);
                } catch (java.lang.Exception unused) {
                }
            }
        }
        java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> identityHashMap = jSONSerializer.references;
        if (identityHashMap != null && identityHashMap.containsKey(obj)) {
            jSONSerializer.writeReference(obj);
            return;
        }
        com.alibaba.fastjson.serializer.SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.write(123);
            jSONSerializer.incrementIndent();
            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask) == 0 || z2) {
                z = true;
            } else {
                serializeWriter.writeFieldName(jSONSerializer.config.typeKey, false);
                serializeWriter.writeString(obj.getClass().getName());
                z = false;
            }
            java.lang.Class<?> cls2 = null;
            com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer = null;
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
                java.lang.Object value = entry.getValue();
                java.lang.String key = entry.getKey();
                if (jSONSerializer.applyName(obj, key) && jSONSerializer.apply(obj, key, value) && ((processValue = com.alibaba.fastjson.serializer.JSONSerializer.processValue(jSONSerializer, obj, (processKey = jSONSerializer.processKey(obj, key, value)), value)) != null || (serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask) != 0)) {
                    if (processKey instanceof java.lang.String) {
                        java.lang.String str = (java.lang.String) processKey;
                        if (!z) {
                            serializeWriter.write(44);
                        }
                        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat.mask) != 0) {
                            jSONSerializer.println();
                        }
                        serializeWriter.writeFieldName(str, true);
                    } else {
                        if (!z) {
                            serializeWriter.write(44);
                        }
                        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringKeyAsString.mask) == 0 || (processKey instanceof java.lang.Enum)) {
                            jSONSerializer.write(processKey);
                        } else {
                            jSONSerializer.write(com.alibaba.fastjson.JSON.toJSONString(processKey));
                        }
                        serializeWriter.write(58);
                    }
                    if (processValue == null) {
                        serializeWriter.writeNull();
                    } else {
                        java.lang.Class<?> cls3 = processValue.getClass();
                        if (cls3 == cls2) {
                            objectSerializer.write(jSONSerializer, processValue, processKey, null);
                        } else {
                            com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer2 = jSONSerializer.config.get(cls3);
                            objectSerializer2.write(jSONSerializer, processValue, processKey, null);
                            objectSerializer = objectSerializer2;
                            cls2 = cls3;
                        }
                    }
                    z = false;
                }
            }
            jSONSerializer.context = serialContext;
            jSONSerializer.decrementIdent();
            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat.mask) != 0 && map.size() > 0) {
                jSONSerializer.println();
            }
            serializeWriter.write(125);
        } catch (java.lang.Throwable th) {
            jSONSerializer.context = serialContext;
            throw th;
        }
    }
}
