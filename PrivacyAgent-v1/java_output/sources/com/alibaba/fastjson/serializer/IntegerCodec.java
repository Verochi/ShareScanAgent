package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public final class IntegerCodec implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static com.alibaba.fastjson.serializer.IntegerCodec instance = new com.alibaba.fastjson.serializer.IntegerCodec();

    private IntegerCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        T t;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (i == 2) {
            if (type == java.lang.Long.TYPE || type == java.lang.Long.class) {
                t = (T) java.lang.Long.valueOf(jSONLexer.longValue());
            } else {
                try {
                    t = (T) java.lang.Integer.valueOf(jSONLexer.intValue());
                } catch (java.lang.NumberFormatException e) {
                    throw new com.alibaba.fastjson.JSONException("int value overflow, field : " + obj, e);
                }
            }
            jSONLexer.nextToken(16);
            return t;
        }
        if (i == 3) {
            java.math.BigDecimal decimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return (type == java.lang.Long.TYPE || type == java.lang.Long.class) ? (T) java.lang.Long.valueOf(decimalValue.longValueExact()) : (T) java.lang.Integer.valueOf(decimalValue.intValueExact());
        }
        T t2 = (T) defaultJSONParser.parse();
        try {
            if (type != java.lang.Long.TYPE && type != java.lang.Long.class) {
                t2 = (T) com.alibaba.fastjson.util.TypeUtils.castToInt(t2);
                return t2;
            }
            t2 = (T) com.alibaba.fastjson.util.TypeUtils.castToLong(t2);
            return t2;
        } catch (java.lang.Exception e2) {
            throw new com.alibaba.fastjson.JSONException("cast error, field : " + obj + ", value " + t2, e2);
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        java.lang.Number number = (java.lang.Number) obj;
        if (number == null) {
            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        if (obj instanceof java.lang.Long) {
            serializeWriter.writeLong(number.longValue());
        } else {
            serializeWriter.writeInt(number.intValue());
        }
        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask) != 0) {
            java.lang.Class<?> cls = number.getClass();
            if (cls == java.lang.Byte.class) {
                serializeWriter.write(66);
                return;
            }
            if (cls == java.lang.Short.class) {
                serializeWriter.write(83);
                return;
            }
            if (cls == java.lang.Long.class) {
                long longValue = number.longValue();
                if (longValue > 2147483647L || longValue < -2147483648L || type == java.lang.Long.class) {
                    return;
                }
                serializeWriter.write(76);
            }
        }
    }
}
