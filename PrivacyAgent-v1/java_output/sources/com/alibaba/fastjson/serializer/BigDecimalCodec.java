package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public class BigDecimalCodec implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.serializer.BigDecimalCodec instance = new com.alibaba.fastjson.serializer.BigDecimalCodec();

    private BigDecimalCodec() {
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.math.BigDecimal] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            if (type == java.math.BigInteger.class) {
                java.lang.String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) new java.math.BigInteger(numberString, 10);
            }
            T t = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return t;
        }
        if (i != 3) {
            java.lang.Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            return type == java.math.BigInteger.class ? (T) com.alibaba.fastjson.util.TypeUtils.castToBigInteger(parse) : (T) com.alibaba.fastjson.util.TypeUtils.castToBigDecimal(parse);
        }
        ?? r5 = (T) jSONLexer.decimalValue();
        jSONLexer.nextToken(16);
        if (type != java.math.BigInteger.class) {
            return r5;
        }
        int scale = r5.scale();
        if (scale < -100 || scale > 100) {
            throw new java.lang.NumberFormatException();
        }
        return (T) r5.toBigInteger();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        if (obj instanceof java.math.BigInteger) {
            serializeWriter.write(((java.math.BigInteger) obj).toString());
            return;
        }
        java.math.BigDecimal bigDecimal = (java.math.BigDecimal) obj;
        serializeWriter.write(bigDecimal.toString());
        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask) == 0 || type == java.math.BigDecimal.class || bigDecimal.scale() != 0) {
            return;
        }
        serializeWriter.write(46);
    }
}
