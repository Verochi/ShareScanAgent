package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
final class ArraySerializer implements com.alibaba.fastjson.serializer.ObjectSerializer {
    private final com.alibaba.fastjson.serializer.ObjectSerializer compObjectSerializer;
    private final java.lang.Class<?> componentType;

    public ArraySerializer(java.lang.Class<?> cls, com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer) {
        this.componentType = cls;
        this.compObjectSerializer = objectSerializer;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type) throws java.io.IOException {
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
        int i = 0;
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            serializeWriter.write(91);
            while (i < zArr.length) {
                if (i != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.write(zArr[i]);
                i++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof byte[]) {
            serializeWriter.writeByteArray((byte[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            serializeWriter.writeString(new java.lang.String((char[]) obj));
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length = dArr.length - 1;
            if (length == -1) {
                serializeWriter.append((java.lang.CharSequence) "[]");
                return;
            }
            serializeWriter.write(91);
            while (i < length) {
                double d = dArr[i];
                if (java.lang.Double.isNaN(d)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((java.lang.CharSequence) java.lang.Double.toString(d));
                }
                serializeWriter.write(44);
                i++;
            }
            double d2 = dArr[length];
            if (java.lang.Double.isNaN(d2)) {
                serializeWriter.writeNull();
            } else {
                serializeWriter.append((java.lang.CharSequence) java.lang.Double.toString(d2));
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length2 = fArr.length - 1;
            if (length2 == -1) {
                serializeWriter.append((java.lang.CharSequence) "[]");
                return;
            }
            serializeWriter.write(91);
            while (i < length2) {
                float f = fArr[i];
                if (java.lang.Float.isNaN(f)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((java.lang.CharSequence) java.lang.Float.toString(f));
                }
                serializeWriter.write(44);
                i++;
            }
            float f2 = fArr[length2];
            if (java.lang.Float.isNaN(f2)) {
                serializeWriter.writeNull();
            } else {
                serializeWriter.append((java.lang.CharSequence) java.lang.Float.toString(f2));
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            serializeWriter.write(91);
            while (i < iArr.length) {
                if (i != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(iArr[i]);
                i++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            serializeWriter.write(91);
            while (i < jArr.length) {
                if (i != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeLong(jArr[i]);
                i++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            serializeWriter.write(91);
            while (i < sArr.length) {
                if (i != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(sArr[i]);
                i++;
            }
            serializeWriter.write(93);
            return;
        }
        java.lang.Object[] objArr = (java.lang.Object[]) obj;
        int length3 = objArr.length;
        com.alibaba.fastjson.serializer.SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.write(91);
            while (i < length3) {
                if (i != 0) {
                    serializeWriter.write(44);
                }
                java.lang.Object obj3 = objArr[i];
                if (obj3 == null) {
                    if (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty) && (obj instanceof java.lang.String[])) {
                        serializeWriter.writeString("");
                    } else {
                        serializeWriter.append((java.lang.CharSequence) com.igexin.push.core.b.m);
                    }
                } else if (obj3.getClass() == this.componentType) {
                    this.compObjectSerializer.write(jSONSerializer, obj3, java.lang.Integer.valueOf(i), null);
                } else {
                    jSONSerializer.config.get(obj3.getClass()).write(jSONSerializer, obj3, java.lang.Integer.valueOf(i), null);
                }
                i++;
            }
            serializeWriter.write(93);
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
