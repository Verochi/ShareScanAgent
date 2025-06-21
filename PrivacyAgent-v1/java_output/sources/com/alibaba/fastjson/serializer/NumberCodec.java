package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public class NumberCodec implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.serializer.NumberCodec instance = new com.alibaba.fastjson.serializer.NumberCodec();
    private java.text.DecimalFormat decimalFormat;

    private NumberCodec() {
        this.decimalFormat = null;
    }

    public NumberCodec(java.lang.String str) {
        this(new java.text.DecimalFormat(str));
    }

    public NumberCodec(java.text.DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }

    /* JADX WARN: Type inference failed for: r8v16, types: [T, java.math.BigDecimal] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            if (type == java.lang.Double.TYPE || type == java.lang.Double.class) {
                java.lang.String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) java.lang.Double.valueOf(java.lang.Double.parseDouble(numberString));
            }
            if (type == java.lang.Float.TYPE || type == java.lang.Float.class) {
                java.lang.String numberString2 = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) java.lang.Float.valueOf(java.lang.Float.parseFloat(numberString2));
            }
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken(16);
            return (type == java.lang.Short.TYPE || type == java.lang.Short.class) ? (T) java.lang.Short.valueOf((short) longValue) : (type == java.lang.Byte.TYPE || type == java.lang.Byte.class) ? (T) java.lang.Byte.valueOf((byte) longValue) : (longValue < -2147483648L || longValue > 2147483647L) ? (T) java.lang.Long.valueOf(longValue) : (T) java.lang.Integer.valueOf((int) longValue);
        }
        if (i != 3) {
            java.lang.Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            return (type == java.lang.Double.TYPE || type == java.lang.Double.class) ? (T) com.alibaba.fastjson.util.TypeUtils.castToDouble(parse) : (type == java.lang.Float.TYPE || type == java.lang.Float.class) ? (T) com.alibaba.fastjson.util.TypeUtils.castToFloat(parse) : (type == java.lang.Short.TYPE || type == java.lang.Short.class) ? (T) com.alibaba.fastjson.util.TypeUtils.castToShort(parse) : (type == java.lang.Byte.TYPE || type == java.lang.Byte.class) ? (T) com.alibaba.fastjson.util.TypeUtils.castToByte(parse) : (T) com.alibaba.fastjson.util.TypeUtils.castToBigDecimal(parse);
        }
        if (type == java.lang.Double.TYPE || type == java.lang.Double.class) {
            java.lang.String numberString3 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) java.lang.Double.valueOf(java.lang.Double.parseDouble(numberString3));
        }
        if (type == java.lang.Float.TYPE || type == java.lang.Float.class) {
            java.lang.String numberString4 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) java.lang.Float.valueOf(java.lang.Float.parseFloat(numberString4));
        }
        ?? r8 = (T) jSONLexer.decimalValue();
        jSONLexer.nextToken(16);
        return (type == java.lang.Short.TYPE || type == java.lang.Short.class) ? (T) java.lang.Short.valueOf(r8.shortValueExact()) : (type == java.lang.Byte.TYPE || type == java.lang.Byte.class) ? (T) java.lang.Byte.valueOf(r8.byteValueExact()) : r8;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type) throws java.io.IOException {
        java.lang.String format;
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
        if (obj instanceof java.lang.Float) {
            float floatValue = ((java.lang.Float) obj).floatValue();
            if (java.lang.Float.isNaN(floatValue)) {
                serializeWriter.writeNull();
                return;
            }
            if (java.lang.Float.isInfinite(floatValue)) {
                serializeWriter.writeNull();
                return;
            }
            java.lang.String f = java.lang.Float.toString(floatValue);
            if (f.endsWith(".0")) {
                f = f.substring(0, f.length() - 2);
            }
            serializeWriter.write(f);
            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask) != 0) {
                serializeWriter.write(70);
                return;
            }
            return;
        }
        double doubleValue = ((java.lang.Double) obj).doubleValue();
        if (java.lang.Double.isNaN(doubleValue)) {
            serializeWriter.writeNull();
            return;
        }
        if (java.lang.Double.isInfinite(doubleValue)) {
            serializeWriter.writeNull();
            return;
        }
        java.text.DecimalFormat decimalFormat = this.decimalFormat;
        if (decimalFormat == null) {
            format = java.lang.Double.toString(doubleValue);
            if (format.endsWith(".0")) {
                format = format.substring(0, format.length() - 2);
            }
        } else {
            format = decimalFormat.format(doubleValue);
        }
        serializeWriter.append((java.lang.CharSequence) format);
        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask) != 0) {
            serializeWriter.write(68);
        }
    }
}
