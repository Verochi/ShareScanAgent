package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public final class ListSerializer implements com.alibaba.fastjson.serializer.ObjectSerializer {
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        int i = 1;
        boolean z = (serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask) != 0;
        java.lang.reflect.Type collectionItemType = z ? com.alibaba.fastjson.util.TypeUtils.getCollectionItemType(type) : null;
        if (obj == null) {
            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                serializeWriter.write("[]");
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        java.util.List list = (java.util.List) obj;
        int size = list.size();
        if (size == 0) {
            serializeWriter.append((java.lang.CharSequence) "[]");
            return;
        }
        com.alibaba.fastjson.serializer.SerialContext serialContext = jSONSerializer.context;
        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
            jSONSerializer.context = new com.alibaba.fastjson.serializer.SerialContext(serialContext, obj, obj2, 0);
            if (jSONSerializer.references == null) {
                jSONSerializer.references = new java.util.IdentityHashMap<>();
            }
            jSONSerializer.references.put(obj, jSONSerializer.context);
        }
        try {
            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat.mask) != 0) {
                serializeWriter.write(91);
                jSONSerializer.incrementIndent();
                for (int i2 = 0; i2 < size; i2++) {
                    java.lang.Object obj3 = list.get(i2);
                    if (i2 != 0) {
                        serializeWriter.write(44);
                    }
                    jSONSerializer.println();
                    if (obj3 != null) {
                        java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> identityHashMap = jSONSerializer.references;
                        if (identityHashMap == null || !identityHashMap.containsKey(obj3)) {
                            com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer = jSONSerializer.config.get(obj3.getClass());
                            jSONSerializer.context = new com.alibaba.fastjson.serializer.SerialContext(serialContext, obj, obj2, 0);
                            objectSerializer.write(jSONSerializer, obj3, java.lang.Integer.valueOf(i2), collectionItemType);
                        } else {
                            jSONSerializer.writeReference(obj3);
                        }
                    } else {
                        jSONSerializer.out.writeNull();
                    }
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter.write(93);
                return;
            }
            int i3 = serializeWriter.count + 1;
            if (i3 > serializeWriter.buf.length) {
                if (serializeWriter.writer == null) {
                    serializeWriter.expandCapacity(i3);
                } else {
                    serializeWriter.flush();
                    i3 = 1;
                }
            }
            serializeWriter.buf[serializeWriter.count] = '[';
            serializeWriter.count = i3;
            for (int i4 = 0; i4 < list.size(); i4++) {
                java.lang.Object obj4 = list.get(i4);
                if (i4 != 0) {
                    int i5 = serializeWriter.count + 1;
                    if (i5 > serializeWriter.buf.length) {
                        if (serializeWriter.writer == null) {
                            serializeWriter.expandCapacity(i5);
                        } else {
                            serializeWriter.flush();
                            i5 = 1;
                        }
                    }
                    serializeWriter.buf[serializeWriter.count] = ',';
                    serializeWriter.count = i5;
                }
                if (obj4 == null) {
                    serializeWriter.append((java.lang.CharSequence) com.igexin.push.core.b.m);
                } else {
                    java.lang.Class<?> cls = obj4.getClass();
                    if (cls == java.lang.Integer.class) {
                        serializeWriter.writeInt(((java.lang.Integer) obj4).intValue());
                    } else if (cls == java.lang.Long.class) {
                        long longValue = ((java.lang.Long) obj4).longValue();
                        if (z) {
                            serializeWriter.writeLong(longValue);
                            serializeWriter.write(76);
                        } else {
                            serializeWriter.writeLong(longValue);
                        }
                    } else if (cls == java.lang.String.class) {
                        java.lang.String str = (java.lang.String) obj4;
                        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask) != 0) {
                            serializeWriter.writeStringWithSingleQuote(str);
                        } else {
                            serializeWriter.writeStringWithDoubleQuote(str, (char) 0, true);
                        }
                    } else {
                        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
                            jSONSerializer.context = new com.alibaba.fastjson.serializer.SerialContext(serialContext, obj, obj2, 0);
                        }
                        java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> identityHashMap2 = jSONSerializer.references;
                        if (identityHashMap2 == null || !identityHashMap2.containsKey(obj4)) {
                            jSONSerializer.config.get(obj4.getClass()).write(jSONSerializer, obj4, java.lang.Integer.valueOf(i4), collectionItemType);
                        } else {
                            jSONSerializer.writeReference(obj4);
                        }
                    }
                }
            }
            int i6 = serializeWriter.count + 1;
            if (i6 > serializeWriter.buf.length) {
                if (serializeWriter.writer != null) {
                    serializeWriter.flush();
                    serializeWriter.buf[serializeWriter.count] = ']';
                    serializeWriter.count = i;
                }
                serializeWriter.expandCapacity(i6);
            }
            i = i6;
            serializeWriter.buf[serializeWriter.count] = ']';
            serializeWriter.count = i;
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
