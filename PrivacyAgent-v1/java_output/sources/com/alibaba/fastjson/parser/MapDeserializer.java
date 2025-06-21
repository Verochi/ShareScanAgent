package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
class MapDeserializer implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static com.alibaba.fastjson.parser.MapDeserializer instance = new com.alibaba.fastjson.parser.MapDeserializer();

    public static java.lang.Object parseMap(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.util.Map<java.lang.Object, java.lang.Object> map, java.lang.reflect.Type type, java.lang.reflect.Type type2, java.lang.Object obj) {
        java.lang.Object obj2;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token;
        int i2 = 16;
        if (i != 12 && i != 16) {
            throw new com.alibaba.fastjson.JSONException("syntax error, expect {, actual " + com.alibaba.fastjson.parser.JSONToken.name(i));
        }
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = defaultJSONParser.config.getDeserializer(type);
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer2 = defaultJSONParser.config.getDeserializer(type2);
        jSONLexer.nextToken();
        com.alibaba.fastjson.parser.ParseContext parseContext = defaultJSONParser.contex;
        while (true) {
            try {
                int i3 = jSONLexer.token;
                if (i3 == 13) {
                    jSONLexer.nextToken(i2);
                    return map;
                }
                if (i3 == 4 && jSONLexer.sp == 4 && jSONLexer.text.startsWith("$ref", jSONLexer.np + 1) && !jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextTokenWithChar(':');
                    if (jSONLexer.token != 4) {
                        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(i3));
                    }
                    java.lang.String stringVal = jSONLexer.stringVal();
                    if ("..".equals(stringVal)) {
                        obj2 = parseContext.parent.object;
                    } else if ("$".equals(stringVal)) {
                        com.alibaba.fastjson.parser.ParseContext parseContext2 = parseContext;
                        while (true) {
                            com.alibaba.fastjson.parser.ParseContext parseContext3 = parseContext2.parent;
                            if (parseContext3 == null) {
                                break;
                            }
                            parseContext2 = parseContext3;
                        }
                        obj2 = parseContext2.object;
                    } else {
                        defaultJSONParser.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(parseContext, stringVal));
                        defaultJSONParser.resolveStatus = 1;
                        obj2 = null;
                    }
                    jSONLexer.nextToken(13);
                    if (jSONLexer.token != 13) {
                        throw new com.alibaba.fastjson.JSONException("illegal ref");
                    }
                    jSONLexer.nextToken(16);
                    return obj2;
                }
                if (map.size() == 0 && i3 == 4 && com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextTokenWithChar(':');
                    jSONLexer.nextToken(16);
                    if (jSONLexer.token == 13) {
                        jSONLexer.nextToken();
                        return map;
                    }
                    jSONLexer.nextToken();
                }
                java.lang.Object deserialze = deserializer.deserialze(defaultJSONParser, type, null);
                if (jSONLexer.token != 17) {
                    throw new com.alibaba.fastjson.JSONException("syntax error, expect :, actual " + jSONLexer.token);
                }
                jSONLexer.nextToken();
                java.lang.Object deserialze2 = deserializer2.deserialze(defaultJSONParser, type2, deserialze);
                if (defaultJSONParser.resolveStatus == 1) {
                    defaultJSONParser.checkMapResolve(map, deserialze);
                }
                map.put(deserialze, deserialze2);
                if (jSONLexer.token == 16) {
                    jSONLexer.nextToken();
                }
                i2 = 16;
            } finally {
                defaultJSONParser.setContext(parseContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0127, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.Map parseMap(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.reflect.Type type, java.lang.Object obj) {
        java.lang.String scanSymbolUnQuoted;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token != 12) {
            throw new com.alibaba.fastjson.JSONException("syntax error, expect {, actual " + jSONLexer.token);
        }
        com.alibaba.fastjson.parser.ParseContext parseContext = defaultJSONParser.contex;
        while (true) {
            try {
                jSONLexer.skipWhitespace();
                char c = jSONLexer.ch;
                while (c == ',') {
                    jSONLexer.next();
                    jSONLexer.skipWhitespace();
                    c = jSONLexer.ch;
                }
                if (c == '\"') {
                    scanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.symbolTable, kotlin.text.Typography.quote);
                    jSONLexer.skipWhitespace();
                    if (jSONLexer.ch != ':') {
                        throw new com.alibaba.fastjson.JSONException("syntax error, " + jSONLexer.info());
                    }
                } else {
                    if (c == '}') {
                        jSONLexer.next();
                        jSONLexer.sp = 0;
                        jSONLexer.nextToken(16);
                        return map;
                    }
                    if (c == '\'') {
                        scanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.symbolTable, '\'');
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.ch != ':') {
                            throw new com.alibaba.fastjson.JSONException("syntax error, " + jSONLexer.info());
                        }
                    } else {
                        scanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(defaultJSONParser.symbolTable);
                        jSONLexer.skipWhitespace();
                        char c2 = jSONLexer.ch;
                        if (c2 != ':') {
                            throw new com.alibaba.fastjson.JSONException("expect ':' at " + jSONLexer.pos + ", actual " + c2);
                        }
                    }
                }
                jSONLexer.next();
                jSONLexer.skipWhitespace();
                jSONLexer.sp = 0;
                java.lang.Object obj2 = null;
                if (scanSymbolUnQuoted != com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY || jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextToken();
                    defaultJSONParser.setContext(parseContext);
                    if (jSONLexer.token == 8) {
                        jSONLexer.nextToken();
                    } else {
                        obj2 = defaultJSONParser.parseObject(type, scanSymbolUnQuoted);
                    }
                    map.put(scanSymbolUnQuoted, obj2);
                    if (defaultJSONParser.resolveStatus == 1) {
                        defaultJSONParser.checkMapResolve(map, scanSymbolUnQuoted);
                    }
                    defaultJSONParser.setContext(parseContext, obj2, scanSymbolUnQuoted);
                    int i = jSONLexer.token;
                    if (i == 20 || i == 15) {
                        break;
                    }
                    if (i == 13) {
                        jSONLexer.nextToken();
                        return map;
                    }
                } else {
                    java.lang.Class<?> checkAutoType = defaultJSONParser.config.checkAutoType(jSONLexer.scanSymbol(defaultJSONParser.symbolTable, kotlin.text.Typography.quote), null, jSONLexer.features);
                    if (checkAutoType != map.getClass()) {
                        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = defaultJSONParser.config.getDeserializer(checkAutoType);
                        jSONLexer.nextToken(16);
                        defaultJSONParser.resolveStatus = 2;
                        if (parseContext != null && !(obj instanceof java.lang.Integer)) {
                            defaultJSONParser.popContext();
                        }
                        return (java.util.Map) deserializer.deserialze(defaultJSONParser, checkAutoType, obj);
                    }
                    jSONLexer.nextToken(16);
                    if (jSONLexer.token == 13) {
                        jSONLexer.nextToken(16);
                        return map;
                    }
                }
            } finally {
                defaultJSONParser.setContext(parseContext);
            }
        }
    }

    public java.util.Map<?, ?> createMap(java.lang.reflect.Type type) {
        if (type == java.util.Properties.class) {
            return new java.util.Properties();
        }
        if (type == java.util.Hashtable.class) {
            return new java.util.Hashtable();
        }
        if (type == java.util.IdentityHashMap.class) {
            return new java.util.IdentityHashMap();
        }
        if (type == java.util.SortedMap.class || type == java.util.TreeMap.class) {
            return new java.util.TreeMap();
        }
        if (type == java.util.concurrent.ConcurrentMap.class || type == java.util.concurrent.ConcurrentHashMap.class) {
            return new java.util.concurrent.ConcurrentHashMap();
        }
        if (type == java.util.Map.class || type == java.util.HashMap.class) {
            return new java.util.HashMap();
        }
        if (type == java.util.LinkedHashMap.class) {
            return new java.util.LinkedHashMap();
        }
        if (type == com.alibaba.fastjson.JSONObject.class) {
            return new com.alibaba.fastjson.JSONObject();
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
            java.lang.reflect.Type rawType = parameterizedType.getRawType();
            return java.util.EnumMap.class.equals(rawType) ? new java.util.EnumMap((java.lang.Class) parameterizedType.getActualTypeArguments()[0]) : createMap(rawType);
        }
        java.lang.Class cls = (java.lang.Class) type;
        if (cls.isInterface()) {
            throw new com.alibaba.fastjson.JSONException("unsupport type " + type);
        }
        try {
            return (java.util.Map) cls.newInstance();
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONException("unsupport type " + type, e);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        if (type == com.alibaba.fastjson.JSONObject.class && defaultJSONParser.fieldTypeResolver == null) {
            return (T) defaultJSONParser.parseObject();
        }
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        java.util.Map<?, ?> createMap = createMap(type);
        com.alibaba.fastjson.parser.ParseContext parseContext = defaultJSONParser.contex;
        try {
            defaultJSONParser.setContext(parseContext, createMap, obj);
            if (!(type instanceof java.lang.reflect.ParameterizedType)) {
                return (T) defaultJSONParser.parseObject(createMap, obj, java.util.Map.class);
            }
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
            java.lang.reflect.Type type2 = parameterizedType.getActualTypeArguments()[0];
            java.lang.reflect.Type type3 = parameterizedType.getActualTypeArguments()[1];
            return java.lang.String.class == type2 ? (T) parseMap(defaultJSONParser, createMap, type3, obj) : (T) parseMap(defaultJSONParser, createMap, type2, type3, obj);
        } finally {
            defaultJSONParser.setContext(parseContext);
        }
    }
}
