package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public final class MiscCodec implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.serializer.MiscCodec instance = new com.alibaba.fastjson.serializer.MiscCodec();

    private MiscCodec() {
    }

    /* JADX WARN: Type inference failed for: r8v8, types: [T, java.text.DateFormat, java.text.SimpleDateFormat] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        java.lang.Object parse;
        if (type == java.lang.StackTraceElement.class) {
            return (T) parseStackTraceElement(defaultJSONParser);
        }
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (defaultJSONParser.resolveStatus == 2) {
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
            parse = defaultJSONParser.parse();
            defaultJSONParser.accept(13);
        } else {
            parse = defaultJSONParser.parse();
        }
        if (parse == null) {
            return null;
        }
        if (!(parse instanceof java.lang.String)) {
            if (parse instanceof com.alibaba.fastjson.JSONObject) {
                com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) parse;
                if (type == java.util.Currency.class) {
                    java.lang.String string = jSONObject.getString("currency");
                    if (string != null) {
                        return (T) java.util.Currency.getInstance(string);
                    }
                    java.lang.String string2 = jSONObject.getString("currencyCode");
                    if (string2 != null) {
                        return (T) java.util.Currency.getInstance(string2);
                    }
                }
                if (type == java.util.Map.Entry.class) {
                    return (T) jSONObject.entrySet().iterator().next();
                }
            }
            throw new com.alibaba.fastjson.JSONException("except string value");
        }
        java.lang.String str = (java.lang.String) parse;
        if (str.length() == 0) {
            return null;
        }
        if (type == java.util.UUID.class) {
            return (T) java.util.UUID.fromString(str);
        }
        if (type == java.lang.Class.class) {
            return (T) com.alibaba.fastjson.util.TypeUtils.loadClass(str, defaultJSONParser.config.defaultClassLoader, false);
        }
        if (type == java.util.Locale.class) {
            java.lang.String[] split = str.split("_");
            return split.length == 1 ? (T) new java.util.Locale(split[0]) : split.length == 2 ? (T) new java.util.Locale(split[0], split[1]) : (T) new java.util.Locale(split[0], split[1], split[2]);
        }
        if (type == java.net.URI.class) {
            return (T) java.net.URI.create(str);
        }
        if (type == java.net.URL.class) {
            try {
                return (T) new java.net.URL(str);
            } catch (java.net.MalformedURLException e) {
                throw new com.alibaba.fastjson.JSONException("create url error", e);
            }
        }
        if (type == java.util.regex.Pattern.class) {
            return (T) java.util.regex.Pattern.compile(str);
        }
        if (type == java.nio.charset.Charset.class) {
            return (T) java.nio.charset.Charset.forName(str);
        }
        if (type == java.util.Currency.class) {
            return (T) java.util.Currency.getInstance(str);
        }
        if (type == java.text.SimpleDateFormat.class) {
            ?? r8 = (T) new java.text.SimpleDateFormat(str, defaultJSONParser.lexer.locale);
            r8.setTimeZone(defaultJSONParser.lexer.timeZone);
            return r8;
        }
        if (type == java.lang.Character.TYPE || type == java.lang.Character.class) {
            return (T) com.alibaba.fastjson.util.TypeUtils.castToChar(str);
        }
        if (!(type instanceof java.lang.Class) || !"android.net.Uri".equals(((java.lang.Class) type).getName())) {
            return (T) java.util.TimeZone.getTimeZone(str);
        }
        try {
            return (T) java.lang.Class.forName("android.net.Uri").getMethod("parse", java.lang.String.class).invoke(null, str);
        } catch (java.lang.Exception e2) {
            throw new com.alibaba.fastjson.JSONException("parse android.net.Uri error.", e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0166, code lost:
    
        return (T) new java.lang.StackTraceElement(r5, r7, r8, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T parseStackTraceElement(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new com.alibaba.fastjson.JSONException("syntax error: " + com.alibaba.fastjson.parser.JSONToken.name(jSONLexer.token()));
        }
        java.lang.String str = null;
        java.lang.String str2 = null;
        java.lang.String str3 = null;
        int i = 0;
        while (true) {
            java.lang.String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
            if (scanSymbol == null) {
                if (jSONLexer.token() == 13) {
                    jSONLexer.nextToken(16);
                    break;
                }
                if (jSONLexer.token() == 16) {
                    continue;
                }
            }
            jSONLexer.nextTokenWithChar(':');
            if (com.vivo.push.PushClientConstants.TAG_CLASS_NAME.equals(scanSymbol)) {
                if (jSONLexer.token() == 8) {
                    str = null;
                } else {
                    if (jSONLexer.token() != 4) {
                        throw new com.alibaba.fastjson.JSONException("syntax error");
                    }
                    str = jSONLexer.stringVal();
                }
            } else if ("methodName".equals(scanSymbol)) {
                if (jSONLexer.token() == 8) {
                    str2 = null;
                } else {
                    if (jSONLexer.token() != 4) {
                        throw new com.alibaba.fastjson.JSONException("syntax error");
                    }
                    str2 = jSONLexer.stringVal();
                }
            } else if (com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FILE_NAME.equals(scanSymbol)) {
                if (jSONLexer.token() == 8) {
                    str3 = null;
                } else {
                    if (jSONLexer.token() != 4) {
                        throw new com.alibaba.fastjson.JSONException("syntax error");
                    }
                    str3 = jSONLexer.stringVal();
                }
            } else if ("lineNumber".equals(scanSymbol)) {
                if (jSONLexer.token() == 8) {
                    i = 0;
                } else {
                    if (jSONLexer.token() != 2) {
                        throw new com.alibaba.fastjson.JSONException("syntax error");
                    }
                    i = jSONLexer.intValue();
                }
            } else if ("nativeMethod".equals(scanSymbol)) {
                if (jSONLexer.token() == 8) {
                    jSONLexer.nextToken(16);
                } else if (jSONLexer.token() == 6) {
                    jSONLexer.nextToken(16);
                } else {
                    if (jSONLexer.token() != 7) {
                        throw new com.alibaba.fastjson.JSONException("syntax error");
                    }
                    jSONLexer.nextToken(16);
                }
            } else {
                if (scanSymbol != com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY) {
                    throw new com.alibaba.fastjson.JSONException("syntax error : " + scanSymbol);
                }
                if (jSONLexer.token() == 4) {
                    java.lang.String stringVal = jSONLexer.stringVal();
                    if (!stringVal.equals("java.lang.StackTraceElement")) {
                        throw new com.alibaba.fastjson.JSONException("syntax error : " + stringVal);
                    }
                } else if (jSONLexer.token() != 8) {
                    throw new com.alibaba.fastjson.JSONException("syntax error");
                }
            }
            if (jSONLexer.token() == 13) {
                jSONLexer.nextToken(16);
                break;
            }
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if (type == java.lang.Character.TYPE || type == java.lang.Character.class) {
                jSONSerializer.write("");
                return;
            } else if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty.mask) == 0 || !java.util.Enumeration.class.isAssignableFrom(com.alibaba.fastjson.util.TypeUtils.getClass(type))) {
                serializeWriter.writeNull();
                return;
            } else {
                serializeWriter.write("[]");
                return;
            }
        }
        if (obj instanceof java.util.regex.Pattern) {
            jSONSerializer.write(((java.util.regex.Pattern) obj).pattern());
            return;
        }
        if (obj instanceof java.util.TimeZone) {
            jSONSerializer.write(((java.util.TimeZone) obj).getID());
            return;
        }
        if (obj instanceof java.util.Currency) {
            jSONSerializer.write(((java.util.Currency) obj).getCurrencyCode());
            return;
        }
        if (obj instanceof java.lang.Class) {
            jSONSerializer.write(((java.lang.Class) obj).getName());
            return;
        }
        if (obj instanceof java.lang.Character) {
            java.lang.Character ch = (java.lang.Character) obj;
            if (ch.charValue() == 0) {
                jSONSerializer.write("\u0000");
                return;
            } else {
                jSONSerializer.write(ch.toString());
                return;
            }
        }
        int i = 0;
        if (obj instanceof java.text.SimpleDateFormat) {
            java.lang.String pattern = ((java.text.SimpleDateFormat) obj).toPattern();
            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask) == 0 || obj.getClass() == type) {
                serializeWriter.writeString(pattern);
                return;
            }
            serializeWriter.write(123);
            serializeWriter.writeFieldName(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY, false);
            jSONSerializer.write(obj.getClass().getName());
            serializeWriter.write(44);
            serializeWriter.writeFieldName("val", false);
            serializeWriter.writeString(pattern);
            serializeWriter.write(125);
            return;
        }
        if (obj instanceof com.alibaba.fastjson.JSONStreamAware) {
            ((com.alibaba.fastjson.JSONStreamAware) obj).writeJSONString(serializeWriter);
            return;
        }
        if (obj instanceof com.alibaba.fastjson.JSONAware) {
            serializeWriter.write(((com.alibaba.fastjson.JSONAware) obj).toJSONString());
            return;
        }
        if (obj instanceof com.alibaba.fastjson.serializer.JSONSerializable) {
            ((com.alibaba.fastjson.serializer.JSONSerializable) obj).write(jSONSerializer, obj2, type);
            return;
        }
        if (!(obj instanceof java.util.Enumeration)) {
            jSONSerializer.write(obj.toString());
            return;
        }
        java.lang.reflect.Type type2 = ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask) == 0 || !(type instanceof java.lang.reflect.ParameterizedType)) ? null : ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0];
        java.util.Enumeration enumeration = (java.util.Enumeration) obj;
        com.alibaba.fastjson.serializer.SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.write(91);
            while (enumeration.hasMoreElements()) {
                java.lang.Object nextElement = enumeration.nextElement();
                int i2 = i + 1;
                if (i != 0) {
                    serializeWriter.write(44);
                }
                if (nextElement == null) {
                    serializeWriter.writeNull();
                } else {
                    jSONSerializer.config.get(nextElement.getClass()).write(jSONSerializer, nextElement, java.lang.Integer.valueOf(i2 - 1), type2);
                }
                i = i2;
            }
            serializeWriter.write(93);
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
