package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public final class DateCodec implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.serializer.DateCodec instance = new com.alibaba.fastjson.serializer.DateCodec();

    private DateCodec() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [T, java.util.Calendar] */
    public <T> T cast(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj, java.lang.Object obj2, java.lang.String str) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof java.util.Date) {
            return obj2;
        }
        if (obj2 instanceof java.math.BigDecimal) {
            return (T) new java.util.Date(((java.math.BigDecimal) obj2).longValueExact());
        }
        if (obj2 instanceof java.lang.Number) {
            return (T) new java.util.Date(((java.lang.Number) obj2).longValue());
        }
        if (!(obj2 instanceof java.lang.String)) {
            throw new com.alibaba.fastjson.JSONException("parse error");
        }
        java.lang.String str2 = (java.lang.String) obj2;
        if (str2.length() == 0) {
            return null;
        }
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = new com.alibaba.fastjson.parser.JSONLexer(str2);
        try {
            if (jSONLexer.scanISO8601DateIfMatch(false)) {
                ?? r3 = (T) jSONLexer.calendar;
                return type == java.util.Calendar.class ? r3 : (T) r3.getTime();
            }
            jSONLexer.close();
            if ("0000-00-00".equals(str2) || "0000-00-00T00:00:00".equalsIgnoreCase(str2) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(str2)) {
                return null;
            }
            try {
                return (T) (str != null ? new java.text.SimpleDateFormat(str) : defaultJSONParser.getDateFormat()).parse(str2);
            } catch (java.text.ParseException unused) {
                return (T) new java.util.Date(java.lang.Long.parseLong(str2));
            }
        } finally {
            jSONLexer.close();
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v9, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r1v18, types: [T, java.util.Calendar] */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj, java.lang.String str) {
        java.lang.Object obj2;
        T t;
        java.lang.Object obj3;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            java.lang.Long valueOf = java.lang.Long.valueOf(jSONLexer.longValue());
            jSONLexer.nextToken(16);
            obj3 = valueOf;
        } else if (i == 4) {
            java.lang.String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            obj3 = stringVal;
            if ((jSONLexer.features & com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat.mask) != 0) {
                com.alibaba.fastjson.parser.JSONLexer jSONLexer2 = new com.alibaba.fastjson.parser.JSONLexer(stringVal);
                java.lang.Object obj4 = stringVal;
                if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                    ?? r1 = (T) jSONLexer2.calendar;
                    if (type == java.util.Calendar.class) {
                        jSONLexer2.close();
                        return r1;
                    }
                    obj4 = r1.getTime();
                }
                jSONLexer2.close();
                obj3 = obj4;
            }
        } else {
            if (i == 8) {
                jSONLexer.nextToken();
                obj2 = null;
                t = (T) cast(defaultJSONParser, type, obj, obj2, str);
                if (type != java.util.Calendar.class && !(t instanceof java.util.Calendar)) {
                    java.util.Date date = (java.util.Date) t;
                    if (date == null) {
                        return null;
                    }
                    ?? r13 = (T) java.util.Calendar.getInstance(jSONLexer.timeZone, jSONLexer.locale);
                    r13.setTime(date);
                    return r13;
                }
            }
            if (i == 12) {
                jSONLexer.nextToken();
                if (jSONLexer.token() != 4) {
                    throw new com.alibaba.fastjson.JSONException("syntax error");
                }
                if (com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal())) {
                    jSONLexer.nextToken();
                    defaultJSONParser.accept(17);
                    java.lang.Class<?> checkAutoType = defaultJSONParser.config.checkAutoType(jSONLexer.stringVal(), null, jSONLexer.features);
                    if (checkAutoType != null) {
                        type = checkAutoType;
                    }
                    defaultJSONParser.accept(4);
                    defaultJSONParser.accept(16);
                }
                jSONLexer.nextTokenWithChar(':');
                int i2 = jSONLexer.token();
                if (i2 != 2) {
                    throw new com.alibaba.fastjson.JSONException("syntax error : " + com.alibaba.fastjson.parser.JSONToken.name(i2));
                }
                long longValue = jSONLexer.longValue();
                jSONLexer.nextToken();
                java.lang.Long valueOf2 = java.lang.Long.valueOf(longValue);
                defaultJSONParser.accept(13);
                obj3 = valueOf2;
            } else if (defaultJSONParser.resolveStatus == 2) {
                defaultJSONParser.resolveStatus = 0;
                defaultJSONParser.accept(16);
                if (jSONLexer.token() != 4) {
                    throw new com.alibaba.fastjson.JSONException("syntax error");
                }
                if (!"val".equals(jSONLexer.stringVal())) {
                    throw new com.alibaba.fastjson.JSONException("syntax error");
                }
                jSONLexer.nextToken();
                defaultJSONParser.accept(17);
                java.lang.Object parse = defaultJSONParser.parse();
                defaultJSONParser.accept(13);
                obj3 = parse;
            } else {
                obj3 = defaultJSONParser.parse();
            }
        }
        obj2 = obj3;
        t = (T) cast(defaultJSONParser, type, obj, obj2, str);
        return type != java.util.Calendar.class ? t : t;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type) throws java.io.IOException {
        char[] charArray;
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask) != 0 && obj.getClass() != type) {
            if (obj.getClass() == java.util.Date.class) {
                serializeWriter.write("new Date(");
                serializeWriter.writeLong(((java.util.Date) obj).getTime());
                serializeWriter.write(41);
                return;
            }
            serializeWriter.write(123);
            serializeWriter.writeFieldName(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY, false);
            jSONSerializer.write(obj.getClass().getName());
            serializeWriter.write(44);
            serializeWriter.writeFieldName("val", false);
            serializeWriter.writeLong(((java.util.Date) obj).getTime());
            serializeWriter.write(125);
            return;
        }
        java.util.Date time = obj instanceof java.util.Calendar ? ((java.util.Calendar) obj).getTime() : (java.util.Date) obj;
        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteDateUseDateFormat.mask) != 0) {
            java.text.DateFormat dateFormat = jSONSerializer.getDateFormat();
            if (dateFormat == null) {
                dateFormat = new java.text.SimpleDateFormat(com.alibaba.fastjson.JSON.DEFFAULT_DATE_FORMAT, jSONSerializer.locale);
                dateFormat.setTimeZone(jSONSerializer.timeZone);
            }
            serializeWriter.writeString(dateFormat.format(time));
            return;
        }
        long time2 = time.getTime();
        int i = serializeWriter.features;
        if ((com.alibaba.fastjson.serializer.SerializerFeature.UseISO8601DateFormat.mask & i) == 0) {
            serializeWriter.writeLong(time2);
            return;
        }
        com.alibaba.fastjson.serializer.SerializerFeature serializerFeature = com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes;
        if ((i & serializerFeature.mask) != 0) {
            serializeWriter.write(39);
        } else {
            serializeWriter.write(34);
        }
        java.util.Calendar calendar = java.util.Calendar.getInstance(jSONSerializer.timeZone, jSONSerializer.locale);
        calendar.setTimeInMillis(time2);
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        int i7 = calendar.get(13);
        int i8 = calendar.get(14);
        if (i8 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i8, 23, charArray);
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i7, 19, charArray);
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i6, 16, charArray);
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i5, 13, charArray);
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i4, 10, charArray);
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i3, 7, charArray);
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i2, 4, charArray);
        } else if (i7 == 0 && i6 == 0 && i5 == 0) {
            charArray = "0000-00-00".toCharArray();
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i4, 10, charArray);
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i3, 7, charArray);
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i2, 4, charArray);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i7, 19, charArray);
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i6, 16, charArray);
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i5, 13, charArray);
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i4, 10, charArray);
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i3, 7, charArray);
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i2, 4, charArray);
        }
        serializeWriter.write(charArray);
        if ((serializeWriter.features & serializerFeature.mask) != 0) {
            serializeWriter.write(39);
        } else {
            serializeWriter.write(34);
        }
    }
}
