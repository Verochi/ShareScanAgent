package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
public class DefaultJSONParser implements java.io.Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    public com.alibaba.fastjson.parser.ParserConfig config;
    protected com.alibaba.fastjson.parser.ParseContext contex;
    private com.alibaba.fastjson.parser.ParseContext[] contextArray;
    private int contextArrayIndex;
    private java.text.DateFormat dateFormat;
    private java.lang.String dateFormatPattern;
    protected java.util.List<com.alibaba.fastjson.parser.deserializer.ExtraProcessor> extraProcessors;
    protected java.util.List<com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider> extraTypeProviders;
    public com.alibaba.fastjson.parser.deserializer.FieldTypeResolver fieldTypeResolver;
    public final com.alibaba.fastjson.parser.JSONLexer lexer;
    public int resolveStatus;
    private java.util.List<com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask> resolveTaskList;
    public final com.alibaba.fastjson.parser.SymbolTable symbolTable;

    public static class ResolveTask {
        private final com.alibaba.fastjson.parser.ParseContext context;
        public com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer;
        public com.alibaba.fastjson.parser.ParseContext ownerContext;
        private final java.lang.String referenceValue;

        public ResolveTask(com.alibaba.fastjson.parser.ParseContext parseContext, java.lang.String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    public DefaultJSONParser(com.alibaba.fastjson.parser.JSONLexer jSONLexer) {
        this(jSONLexer, com.alibaba.fastjson.parser.ParserConfig.global);
    }

    public DefaultJSONParser(com.alibaba.fastjson.parser.JSONLexer jSONLexer, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        this.dateFormatPattern = com.alibaba.fastjson.JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.lexer = jSONLexer;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char c = jSONLexer.ch;
        char c2 = com.alibaba.fastjson.parser.JSONLexer.EOI;
        if (c == '{') {
            int i = jSONLexer.bp + 1;
            jSONLexer.bp = i;
            jSONLexer.ch = i < jSONLexer.len ? jSONLexer.text.charAt(i) : c2;
            jSONLexer.token = 12;
            return;
        }
        if (c != '[') {
            jSONLexer.nextToken();
            return;
        }
        int i2 = jSONLexer.bp + 1;
        jSONLexer.bp = i2;
        jSONLexer.ch = i2 < jSONLexer.len ? jSONLexer.text.charAt(i2) : c2;
        jSONLexer.token = 14;
    }

    public DefaultJSONParser(java.lang.String str) {
        this(str, com.alibaba.fastjson.parser.ParserConfig.global, com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE);
    }

    public DefaultJSONParser(java.lang.String str, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        this(new com.alibaba.fastjson.parser.JSONLexer(str, com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public DefaultJSONParser(java.lang.String str, com.alibaba.fastjson.parser.ParserConfig parserConfig, int i) {
        this(new com.alibaba.fastjson.parser.JSONLexer(str, i), parserConfig);
    }

    public DefaultJSONParser(char[] cArr, int i, com.alibaba.fastjson.parser.ParserConfig parserConfig, int i2) {
        this(new com.alibaba.fastjson.parser.JSONLexer(cArr, i, i2), parserConfig);
    }

    public final void accept(int i) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new com.alibaba.fastjson.JSONException("syntax error, expect " + com.alibaba.fastjson.parser.JSONToken.name(i) + ", actual " + com.alibaba.fastjson.parser.JSONToken.name(this.lexer.token));
    }

    public void addResolveTask(com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new java.util.ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(java.util.Collection collection) {
        if (collection instanceof java.util.List) {
            com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = new com.alibaba.fastjson.parser.ResolveFieldDeserializer(this, (java.util.List) collection, collection.size() - 1);
            lastResolveTask.ownerContext = this.contex;
            this.resolveStatus = 0;
            return;
        }
        com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask lastResolveTask2 = getLastResolveTask();
        lastResolveTask2.fieldDeserializer = new com.alibaba.fastjson.parser.ResolveFieldDeserializer(collection);
        lastResolveTask2.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    public void checkMapResolve(java.util.Map map, java.lang.Object obj) {
        com.alibaba.fastjson.parser.ResolveFieldDeserializer resolveFieldDeserializer = new com.alibaba.fastjson.parser.ResolveFieldDeserializer(map, obj);
        com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask lastResolveTask = getLastResolveTask();
        lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
        lastResolveTask.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            com.alibaba.fastjson.parser.JSONLexer jSONLexer = this.lexer;
            if (jSONLexer.token == 20) {
                jSONLexer.close();
                return;
            }
            throw new com.alibaba.fastjson.JSONException("not close json text, token : " + com.alibaba.fastjson.parser.JSONToken.name(this.lexer.token));
        } catch (java.lang.Throwable th) {
            this.lexer.close();
            throw th;
        }
    }

    public void config(com.alibaba.fastjson.parser.Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public java.lang.String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public java.text.DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(this.dateFormatPattern, this.lexer.locale);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.timeZone);
        }
        return this.dateFormat;
    }

    public java.util.List<com.alibaba.fastjson.parser.deserializer.ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new java.util.ArrayList(2);
        }
        return this.extraProcessors;
    }

    public java.util.List<com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new java.util.ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask getLastResolveTask() {
        return this.resolveTaskList.get(r0.size() - 1);
    }

    public void handleResovleTask(java.lang.Object obj) {
        java.util.List<com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask resolveTask = this.resolveTaskList.get(i);
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                com.alibaba.fastjson.parser.ParseContext parseContext = resolveTask.ownerContext;
                java.lang.Object obj2 = null;
                java.lang.Object obj3 = parseContext != null ? parseContext.object : null;
                java.lang.String str = resolveTask.referenceValue;
                if (str.startsWith("$")) {
                    for (int i2 = 0; i2 < this.contextArrayIndex; i2++) {
                        if (str.equals(this.contextArray[i2].toString())) {
                            obj2 = this.contextArray[i2].object;
                        }
                    }
                } else {
                    obj2 = resolveTask.context.object;
                }
                fieldDeserializer.setValue(obj3, obj2);
            }
        }
    }

    public java.lang.Object parse() {
        return parse(null);
    }

    public java.lang.Object parse(java.lang.Object obj) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token;
        if (i == 2) {
            java.lang.Number integerValue = jSONLexer.integerValue();
            this.lexer.nextToken();
            return integerValue;
        }
        if (i == 3) {
            java.lang.Number decimalValue = jSONLexer.decimalValue((jSONLexer.features & com.alibaba.fastjson.parser.Feature.UseBigDecimal.mask) != 0);
            this.lexer.nextToken();
            return decimalValue;
        }
        if (i == 4) {
            java.lang.String stringVal = jSONLexer.stringVal();
            this.lexer.nextToken(16);
            if ((this.lexer.features & com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat.mask) != 0) {
                com.alibaba.fastjson.parser.JSONLexer jSONLexer2 = new com.alibaba.fastjson.parser.JSONLexer(stringVal);
                try {
                    if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                        return jSONLexer2.calendar.getTime();
                    }
                } finally {
                    jSONLexer2.close();
                }
            }
            return stringVal;
        }
        if (i == 12) {
            return parseObject((jSONLexer.features & com.alibaba.fastjson.parser.Feature.OrderedField.mask) != 0 ? new com.alibaba.fastjson.JSONObject(new java.util.LinkedHashMap()) : new com.alibaba.fastjson.JSONObject(), obj, null);
        }
        if (i == 14) {
            com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
            parseArray(jSONArray, obj);
            return jSONArray;
        }
        switch (i) {
            case 6:
                jSONLexer.nextToken(16);
                return java.lang.Boolean.TRUE;
            case 7:
                jSONLexer.nextToken(16);
                return java.lang.Boolean.FALSE;
            case 8:
                break;
            case 9:
                jSONLexer.nextToken(18);
                com.alibaba.fastjson.parser.JSONLexer jSONLexer3 = this.lexer;
                if (jSONLexer3.token != 18) {
                    throw new com.alibaba.fastjson.JSONException("syntax error, " + this.lexer.info());
                }
                jSONLexer3.nextToken(10);
                accept(10);
                long longValue = this.lexer.integerValue().longValue();
                accept(2);
                accept(11);
                return new java.util.Date(longValue);
            default:
                switch (i) {
                    case 20:
                        if (jSONLexer.isBlankInput()) {
                            return null;
                        }
                        throw new com.alibaba.fastjson.JSONException("syntax error, " + this.lexer.info());
                    case 21:
                        jSONLexer.nextToken();
                        java.util.HashSet hashSet = new java.util.HashSet();
                        parseArray(hashSet, obj);
                        return hashSet;
                    case 22:
                        jSONLexer.nextToken();
                        java.util.TreeSet treeSet = new java.util.TreeSet();
                        parseArray(treeSet, obj);
                        return treeSet;
                    case 23:
                        break;
                    default:
                        throw new com.alibaba.fastjson.JSONException("syntax error, " + this.lexer.info());
                }
        }
        jSONLexer.nextToken();
        return null;
    }

    public <T> java.util.List<T> parseArray(java.lang.Class<T> cls) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        parseArray((java.lang.Class<?>) cls, (java.util.Collection) arrayList);
        return arrayList;
    }

    public void parseArray(java.lang.Class<?> cls, java.util.Collection collection) {
        parseArray((java.lang.reflect.Type) cls, collection);
    }

    public void parseArray(java.lang.reflect.Type type, java.util.Collection collection) {
        parseArray(type, collection, null);
    }

    public void parseArray(java.lang.reflect.Type type, java.util.Collection collection, java.lang.Object obj) {
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer;
        java.lang.String str;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token;
        if (i == 21 || i == 22) {
            jSONLexer.nextToken();
        }
        com.alibaba.fastjson.parser.JSONLexer jSONLexer2 = this.lexer;
        if (jSONLexer2.token != 14) {
            throw new com.alibaba.fastjson.JSONException("exepct '[', but " + com.alibaba.fastjson.parser.JSONToken.name(this.lexer.token) + ", " + this.lexer.info());
        }
        if (java.lang.Integer.TYPE == type) {
            deserializer = com.alibaba.fastjson.serializer.IntegerCodec.instance;
            jSONLexer2.nextToken(2);
        } else if (java.lang.String.class == type) {
            deserializer = com.alibaba.fastjson.serializer.StringCodec.instance;
            jSONLexer2.nextToken(4);
        } else {
            deserializer = this.config.getDeserializer(type);
            this.lexer.nextToken(12);
        }
        com.alibaba.fastjson.parser.ParseContext parseContext = this.contex;
        if (!this.lexer.disableCircularReferenceDetect) {
            setContext(parseContext, collection, obj);
        }
        int i2 = 0;
        while (true) {
            try {
                com.alibaba.fastjson.parser.JSONLexer jSONLexer3 = this.lexer;
                int i3 = jSONLexer3.token;
                if (i3 == 16) {
                    jSONLexer3.nextToken();
                } else {
                    if (i3 == 15) {
                        this.contex = parseContext;
                        jSONLexer3.nextToken(16);
                        return;
                    }
                    java.lang.Object obj2 = null;
                    java.lang.String obj3 = null;
                    if (java.lang.Integer.TYPE == type) {
                        collection.add(com.alibaba.fastjson.serializer.IntegerCodec.instance.deserialze(this, null, null));
                    } else if (java.lang.String.class == type) {
                        if (i3 == 4) {
                            str = jSONLexer3.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            java.lang.Object parse = parse();
                            if (parse != null) {
                                obj3 = parse.toString();
                            }
                            str = obj3;
                        }
                        collection.add(str);
                    } else {
                        if (i3 == 8) {
                            jSONLexer3.nextToken();
                        } else {
                            obj2 = deserializer.deserialze(this, type, java.lang.Integer.valueOf(i2));
                        }
                        collection.add(obj2);
                        if (this.resolveStatus == 1) {
                            checkListResolve(collection);
                        }
                    }
                    com.alibaba.fastjson.parser.JSONLexer jSONLexer4 = this.lexer;
                    if (jSONLexer4.token == 16) {
                        jSONLexer4.nextToken();
                    }
                    i2++;
                }
            } catch (java.lang.Throwable th) {
                this.contex = parseContext;
                throw th;
            }
        }
    }

    public final void parseArray(java.util.Collection collection) {
        parseArray(collection, (java.lang.Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x022f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01d7 A[Catch: all -> 0x0237, TryCatch #0 {all -> 0x0237, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004b, B:24:0x005d, B:28:0x007b, B:30:0x0081, B:32:0x008d, B:35:0x009f, B:37:0x00a8, B:42:0x00b0, B:43:0x0099, B:47:0x00b9, B:50:0x00cb, B:52:0x00d4, B:53:0x00d7, B:58:0x00c5, B:45:0x00e1, B:59:0x00e4, B:61:0x00ea, B:83:0x0119, B:85:0x01e5, B:87:0x01ec, B:88:0x01ef, B:90:0x01f5, B:92:0x01f9, B:98:0x0209, B:102:0x0215, B:105:0x0229, B:107:0x0223, B:108:0x022c, B:112:0x0121, B:117:0x012b, B:118:0x0138, B:120:0x0140, B:121:0x0148, B:122:0x0149, B:124:0x0156, B:125:0x0166, B:126:0x0161, B:127:0x016f, B:128:0x0177, B:129:0x0181, B:130:0x018b, B:132:0x01a3, B:134:0x01ae, B:135:0x01b4, B:136:0x01b9, B:138:0x01c6, B:139:0x01d1, B:140:0x01cc, B:141:0x01d7, B:142:0x0057, B:143:0x0064, B:144:0x0069, B:147:0x0074), top: B:10:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b A[Catch: all -> 0x0237, TryCatch #0 {all -> 0x0237, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004b, B:24:0x005d, B:28:0x007b, B:30:0x0081, B:32:0x008d, B:35:0x009f, B:37:0x00a8, B:42:0x00b0, B:43:0x0099, B:47:0x00b9, B:50:0x00cb, B:52:0x00d4, B:53:0x00d7, B:58:0x00c5, B:45:0x00e1, B:59:0x00e4, B:61:0x00ea, B:83:0x0119, B:85:0x01e5, B:87:0x01ec, B:88:0x01ef, B:90:0x01f5, B:92:0x01f9, B:98:0x0209, B:102:0x0215, B:105:0x0229, B:107:0x0223, B:108:0x022c, B:112:0x0121, B:117:0x012b, B:118:0x0138, B:120:0x0140, B:121:0x0148, B:122:0x0149, B:124:0x0156, B:125:0x0166, B:126:0x0161, B:127:0x016f, B:128:0x0177, B:129:0x0181, B:130:0x018b, B:132:0x01a3, B:134:0x01ae, B:135:0x01b4, B:136:0x01b9, B:138:0x01c6, B:139:0x01d1, B:140:0x01cc, B:141:0x01d7, B:142:0x0057, B:143:0x0064, B:144:0x0069, B:147:0x0074), top: B:10:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ea A[Catch: all -> 0x0237, LOOP:1: B:60:0x00e8->B:61:0x00ea, LOOP_END, TryCatch #0 {all -> 0x0237, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004b, B:24:0x005d, B:28:0x007b, B:30:0x0081, B:32:0x008d, B:35:0x009f, B:37:0x00a8, B:42:0x00b0, B:43:0x0099, B:47:0x00b9, B:50:0x00cb, B:52:0x00d4, B:53:0x00d7, B:58:0x00c5, B:45:0x00e1, B:59:0x00e4, B:61:0x00ea, B:83:0x0119, B:85:0x01e5, B:87:0x01ec, B:88:0x01ef, B:90:0x01f5, B:92:0x01f9, B:98:0x0209, B:102:0x0215, B:105:0x0229, B:107:0x0223, B:108:0x022c, B:112:0x0121, B:117:0x012b, B:118:0x0138, B:120:0x0140, B:121:0x0148, B:122:0x0149, B:124:0x0156, B:125:0x0166, B:126:0x0161, B:127:0x016f, B:128:0x0177, B:129:0x0181, B:130:0x018b, B:132:0x01a3, B:134:0x01ae, B:135:0x01b4, B:136:0x01b9, B:138:0x01c6, B:139:0x01d1, B:140:0x01cc, B:141:0x01d7, B:142:0x0057, B:143:0x0064, B:144:0x0069, B:147:0x0074), top: B:10:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ec A[Catch: all -> 0x0237, TryCatch #0 {all -> 0x0237, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004b, B:24:0x005d, B:28:0x007b, B:30:0x0081, B:32:0x008d, B:35:0x009f, B:37:0x00a8, B:42:0x00b0, B:43:0x0099, B:47:0x00b9, B:50:0x00cb, B:52:0x00d4, B:53:0x00d7, B:58:0x00c5, B:45:0x00e1, B:59:0x00e4, B:61:0x00ea, B:83:0x0119, B:85:0x01e5, B:87:0x01ec, B:88:0x01ef, B:90:0x01f5, B:92:0x01f9, B:98:0x0209, B:102:0x0215, B:105:0x0229, B:107:0x0223, B:108:0x022c, B:112:0x0121, B:117:0x012b, B:118:0x0138, B:120:0x0140, B:121:0x0148, B:122:0x0149, B:124:0x0156, B:125:0x0166, B:126:0x0161, B:127:0x016f, B:128:0x0177, B:129:0x0181, B:130:0x018b, B:132:0x01a3, B:134:0x01ae, B:135:0x01b4, B:136:0x01b9, B:138:0x01c6, B:139:0x01d1, B:140:0x01cc, B:141:0x01d7, B:142:0x0057, B:143:0x0064, B:144:0x0069, B:147:0x0074), top: B:10:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01f5 A[Catch: all -> 0x0237, TryCatch #0 {all -> 0x0237, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004b, B:24:0x005d, B:28:0x007b, B:30:0x0081, B:32:0x008d, B:35:0x009f, B:37:0x00a8, B:42:0x00b0, B:43:0x0099, B:47:0x00b9, B:50:0x00cb, B:52:0x00d4, B:53:0x00d7, B:58:0x00c5, B:45:0x00e1, B:59:0x00e4, B:61:0x00ea, B:83:0x0119, B:85:0x01e5, B:87:0x01ec, B:88:0x01ef, B:90:0x01f5, B:92:0x01f9, B:98:0x0209, B:102:0x0215, B:105:0x0229, B:107:0x0223, B:108:0x022c, B:112:0x0121, B:117:0x012b, B:118:0x0138, B:120:0x0140, B:121:0x0148, B:122:0x0149, B:124:0x0156, B:125:0x0166, B:126:0x0161, B:127:0x016f, B:128:0x0177, B:129:0x0181, B:130:0x018b, B:132:0x01a3, B:134:0x01ae, B:135:0x01b4, B:136:0x01b9, B:138:0x01c6, B:139:0x01d1, B:140:0x01cc, B:141:0x01d7, B:142:0x0057, B:143:0x0064, B:144:0x0069, B:147:0x0074), top: B:10:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void parseArray(java.util.Collection collection, java.lang.Object obj) {
        boolean z;
        int i;
        int i2;
        java.lang.Object integerValue;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer;
        java.lang.Object obj2;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer2 = this.lexer;
        int i3 = jSONLexer2.token;
        if (i3 == 21 || i3 == 22) {
            jSONLexer2.nextToken();
            i3 = this.lexer.token;
        }
        if (i3 != 14) {
            throw new com.alibaba.fastjson.JSONException("syntax error, expect [, actual " + com.alibaba.fastjson.parser.JSONToken.name(i3) + ", pos " + this.lexer.pos);
        }
        boolean z2 = this.lexer.disableCircularReferenceDetect;
        com.alibaba.fastjson.parser.ParseContext parseContext = this.contex;
        if (!z2) {
            setContext(parseContext, collection, obj);
        }
        try {
            com.alibaba.fastjson.parser.JSONLexer jSONLexer3 = this.lexer;
            char c = jSONLexer3.ch;
            if (c != '\"') {
                if (c == ']') {
                    jSONLexer3.next();
                    this.lexer.nextToken(16);
                    if (z2) {
                        return;
                    } else {
                        return;
                    }
                } else if (c == '{') {
                    int i4 = jSONLexer3.bp + 1;
                    jSONLexer3.bp = i4;
                    jSONLexer3.ch = i4 >= jSONLexer3.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer3.text.charAt(i4);
                    this.lexer.token = 12;
                } else {
                    jSONLexer3.nextToken(12);
                }
            } else if ((jSONLexer3.features & com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat.mask) == 0) {
                z = true;
                i = 0;
                while (true) {
                    if (z) {
                        com.alibaba.fastjson.parser.JSONLexer jSONLexer4 = this.lexer;
                        if (jSONLexer4.ch == '\"') {
                            java.lang.String scanStringValue = jSONLexer4.scanStringValue(kotlin.text.Typography.quote);
                            com.alibaba.fastjson.parser.JSONLexer jSONLexer5 = this.lexer;
                            char c2 = jSONLexer5.ch;
                            if (c2 == ',') {
                                int i5 = jSONLexer5.bp + 1;
                                jSONLexer5.bp = i5;
                                char charAt = i5 >= jSONLexer5.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer5.text.charAt(i5);
                                jSONLexer5.ch = charAt;
                                collection.add(scanStringValue);
                                if (this.resolveStatus == 1) {
                                    checkListResolve(collection);
                                }
                                if (charAt == '\"') {
                                    i++;
                                } else {
                                    this.lexer.nextToken();
                                    z = false;
                                }
                            } else {
                                if (c2 == ']') {
                                    int i6 = jSONLexer5.bp + 1;
                                    jSONLexer5.bp = i6;
                                    jSONLexer5.ch = i6 >= jSONLexer5.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer5.text.charAt(i6);
                                    collection.add(scanStringValue);
                                    if (this.resolveStatus == 1) {
                                        checkListResolve(collection);
                                    }
                                    this.lexer.nextToken(16);
                                    if (z2) {
                                        return;
                                    }
                                    this.contex = parseContext;
                                    return;
                                }
                                jSONLexer5.nextToken();
                            }
                        }
                    }
                    i2 = this.lexer.token;
                    while (i2 == 16) {
                        this.lexer.nextToken();
                        i2 = this.lexer.token;
                    }
                    if (i2 != 2) {
                        integerValue = this.lexer.integerValue();
                        this.lexer.nextToken(16);
                    } else if (i2 != 3) {
                        if (i2 == 4) {
                            java.lang.String stringVal = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                            obj2 = stringVal;
                            if ((this.lexer.features & com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat.mask) != 0) {
                                com.alibaba.fastjson.parser.JSONLexer jSONLexer6 = new com.alibaba.fastjson.parser.JSONLexer(stringVal);
                                java.lang.Object obj3 = stringVal;
                                if (jSONLexer6.scanISO8601DateIfMatch(true)) {
                                    obj3 = jSONLexer6.calendar.getTime();
                                }
                                jSONLexer6.close();
                                obj2 = obj3;
                            }
                        } else if (i2 == 6) {
                            java.lang.Boolean bool = java.lang.Boolean.TRUE;
                            this.lexer.nextToken(16);
                            obj2 = bool;
                        } else if (i2 != 7) {
                            obj2 = null;
                            obj2 = null;
                            if (i2 == 8) {
                                this.lexer.nextToken(4);
                            } else if (i2 == 12) {
                                obj2 = parseObject((this.lexer.features & com.alibaba.fastjson.parser.Feature.OrderedField.mask) != 0 ? new com.alibaba.fastjson.JSONObject(new java.util.LinkedHashMap()) : new com.alibaba.fastjson.JSONObject(), java.lang.Integer.valueOf(i), null);
                            } else {
                                if (i2 == 20) {
                                    throw new com.alibaba.fastjson.JSONException("unclosed jsonArray");
                                }
                                if (i2 == 23) {
                                    this.lexer.nextToken(4);
                                } else if (i2 == 14) {
                                    com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
                                    parseArray(jSONArray, java.lang.Integer.valueOf(i));
                                    obj2 = jSONArray;
                                } else {
                                    if (i2 == 15) {
                                        this.lexer.nextToken(16);
                                        if (z2) {
                                            return;
                                        }
                                        this.contex = parseContext;
                                        return;
                                    }
                                    obj2 = parse();
                                }
                            }
                        } else {
                            java.lang.Boolean bool2 = java.lang.Boolean.FALSE;
                            this.lexer.nextToken(16);
                            obj2 = bool2;
                        }
                        integerValue = obj2;
                    } else {
                        com.alibaba.fastjson.parser.JSONLexer jSONLexer7 = this.lexer;
                        integerValue = (jSONLexer7.features & com.alibaba.fastjson.parser.Feature.UseBigDecimal.mask) != 0 ? jSONLexer7.decimalValue(true) : jSONLexer7.decimalValue(false);
                        this.lexer.nextToken(16);
                    }
                    collection.add(integerValue);
                    if (this.resolveStatus == 1) {
                        checkListResolve(collection);
                    }
                    jSONLexer = this.lexer;
                    if (jSONLexer.token == 16) {
                        char c3 = jSONLexer.ch;
                        if (c3 == '\"') {
                            jSONLexer.pos = jSONLexer.bp;
                            jSONLexer.scanString();
                        } else if (c3 >= '0' && c3 <= '9') {
                            jSONLexer.pos = jSONLexer.bp;
                            jSONLexer.scanNumber();
                        } else if (c3 == '{') {
                            jSONLexer.token = 12;
                            int i7 = jSONLexer.bp + 1;
                            jSONLexer.bp = i7;
                            jSONLexer.ch = i7 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i7);
                        } else {
                            jSONLexer.nextToken();
                        }
                    }
                    i++;
                }
            } else {
                jSONLexer3.nextToken(4);
            }
            z = false;
            i = 0;
            while (true) {
                if (z) {
                }
                i2 = this.lexer.token;
                while (i2 == 16) {
                }
                if (i2 != 2) {
                }
                collection.add(integerValue);
                if (this.resolveStatus == 1) {
                }
                jSONLexer = this.lexer;
                if (jSONLexer.token == 16) {
                }
                i++;
            }
        } finally {
            if (!z2) {
                this.contex = parseContext;
            }
        }
    }

    public java.lang.Object[] parseArray(java.lang.reflect.Type[] typeArr) {
        java.lang.Object cast;
        java.lang.Class<?> cls;
        boolean z;
        int i;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = this.lexer;
        int i2 = jSONLexer.token;
        int i3 = 8;
        if (i2 == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (i2 != 14) {
            throw new com.alibaba.fastjson.JSONException("syntax error, " + this.lexer.info());
        }
        java.lang.Object[] objArr = new java.lang.Object[typeArr.length];
        if (typeArr.length == 0) {
            jSONLexer.nextToken(15);
            com.alibaba.fastjson.parser.JSONLexer jSONLexer2 = this.lexer;
            if (jSONLexer2.token == 15) {
                jSONLexer2.nextToken(16);
                return new java.lang.Object[0];
            }
            throw new com.alibaba.fastjson.JSONException("syntax error, " + this.lexer.info());
        }
        jSONLexer.nextToken(2);
        int i4 = 0;
        while (i4 < typeArr.length) {
            com.alibaba.fastjson.parser.JSONLexer jSONLexer3 = this.lexer;
            int i5 = jSONLexer3.token;
            if (i5 == i3) {
                jSONLexer3.nextToken(16);
                cast = null;
            } else {
                java.lang.reflect.Type type = typeArr[i4];
                if (type == java.lang.Integer.TYPE || type == java.lang.Integer.class) {
                    if (i5 == 2) {
                        cast = java.lang.Integer.valueOf(jSONLexer3.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        cast = com.alibaba.fastjson.util.TypeUtils.cast(parse(), type, this.config);
                    }
                } else if (type != java.lang.String.class) {
                    if (i4 == typeArr.length - 1 && (type instanceof java.lang.Class)) {
                        java.lang.Class cls2 = (java.lang.Class) type;
                        z = cls2.isArray();
                        cls = cls2.getComponentType();
                    } else {
                        cls = null;
                        z = false;
                    }
                    if (!z || this.lexer.token == 14) {
                        cast = this.config.getDeserializer(type).deserialze(this, type, null);
                    } else {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                        if (this.lexer.token != 15) {
                            while (true) {
                                arrayList.add(deserializer.deserialze(this, type, null));
                                com.alibaba.fastjson.parser.JSONLexer jSONLexer4 = this.lexer;
                                i = jSONLexer4.token;
                                if (i != 16) {
                                    break;
                                }
                                jSONLexer4.nextToken(12);
                            }
                            if (i != 15) {
                                throw new com.alibaba.fastjson.JSONException("syntax error, " + this.lexer.info());
                            }
                        }
                        cast = com.alibaba.fastjson.util.TypeUtils.cast(arrayList, type, this.config);
                    }
                } else if (i5 == 4) {
                    cast = jSONLexer3.stringVal();
                    this.lexer.nextToken(16);
                } else {
                    cast = com.alibaba.fastjson.util.TypeUtils.cast(parse(), type, this.config);
                }
            }
            objArr[i4] = cast;
            com.alibaba.fastjson.parser.JSONLexer jSONLexer5 = this.lexer;
            int i6 = jSONLexer5.token;
            if (i6 == 15) {
                break;
            }
            if (i6 != 16) {
                throw new com.alibaba.fastjson.JSONException("syntax error, " + this.lexer.info());
            }
            if (i4 == typeArr.length - 1) {
                jSONLexer5.nextToken(15);
            } else {
                jSONLexer5.nextToken(2);
            }
            i4++;
            i3 = 8;
        }
        com.alibaba.fastjson.parser.JSONLexer jSONLexer6 = this.lexer;
        if (jSONLexer6.token == 15) {
            jSONLexer6.nextToken(16);
            return objArr;
        }
        throw new com.alibaba.fastjson.JSONException("syntax error, " + this.lexer.info());
    }

    public java.lang.Object parseArrayWithType(java.lang.reflect.Type type) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken();
            return null;
        }
        java.lang.reflect.Type[] actualTypeArguments = ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            throw new com.alibaba.fastjson.JSONException("not support type " + type);
        }
        java.lang.reflect.Type type2 = actualTypeArguments[0];
        if (type2 instanceof java.lang.Class) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            parseArray((java.lang.Class<?>) type2, (java.util.Collection) arrayList);
            return arrayList;
        }
        if (type2 instanceof java.lang.reflect.WildcardType) {
            java.lang.reflect.WildcardType wildcardType = (java.lang.reflect.WildcardType) type2;
            java.lang.reflect.Type type3 = wildcardType.getUpperBounds()[0];
            if (!java.lang.Object.class.equals(type3)) {
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                parseArray((java.lang.Class<?>) type3, (java.util.Collection) arrayList2);
                return arrayList2;
            }
            if (wildcardType.getLowerBounds().length == 0) {
                return parse();
            }
            throw new com.alibaba.fastjson.JSONException("not support type : " + type);
        }
        if (type2 instanceof java.lang.reflect.TypeVariable) {
            java.lang.reflect.TypeVariable typeVariable = (java.lang.reflect.TypeVariable) type2;
            java.lang.reflect.Type[] bounds = typeVariable.getBounds();
            if (bounds.length != 1) {
                throw new com.alibaba.fastjson.JSONException("not support : " + typeVariable);
            }
            java.lang.reflect.Type type4 = bounds[0];
            if (type4 instanceof java.lang.Class) {
                java.util.ArrayList arrayList3 = new java.util.ArrayList();
                parseArray((java.lang.Class<?>) type4, (java.util.Collection) arrayList3);
                return arrayList3;
            }
        }
        if (type2 instanceof java.lang.reflect.ParameterizedType) {
            java.util.ArrayList arrayList4 = new java.util.ArrayList();
            parseArray((java.lang.reflect.ParameterizedType) type2, arrayList4);
            return arrayList4;
        }
        throw new com.alibaba.fastjson.JSONException("TODO : " + type);
    }

    public com.alibaba.fastjson.JSONObject parseObject() {
        return (com.alibaba.fastjson.JSONObject) parseObject((this.lexer.features & com.alibaba.fastjson.parser.Feature.OrderedField.mask) != 0 ? new com.alibaba.fastjson.JSONObject(new java.util.LinkedHashMap()) : new com.alibaba.fastjson.JSONObject(), null, com.alibaba.fastjson.JSONObject.class);
    }

    public <T> T parseObject(java.lang.Class<T> cls) {
        return (T) parseObject(cls, (java.lang.Object) null);
    }

    public <T> T parseObject(java.lang.reflect.Type type) {
        return (T) parseObject(type, (java.lang.Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parseObject(java.lang.reflect.Type type, java.lang.Object obj) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token;
        if (i == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                T t = (T) jSONLexer.bytesValue();
                this.lexer.nextToken();
                return t;
            }
            if (type == char[].class) {
                java.lang.String stringVal = jSONLexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (com.alibaba.fastjson.JSONException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new com.alibaba.fastjson.JSONException(e2.getMessage(), e2);
        }
    }

    public java.lang.Object parseObject(java.util.Map map) {
        return parseObject(map, null, null);
    }

    public final java.lang.Object parseObject(java.util.Map map, java.lang.Object obj) {
        return parseObject(map, obj, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0297, code lost:
    
        r2 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r2;
        r3 = r2.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r19, r8);
        r0 = r20.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02a9, code lost:
    
        if (r0.hasNext() == false) goto L464;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02ab, code lost:
    
        r4 = (java.util.Map.Entry) r0.next();
        r5 = r4.getKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02b7, code lost:
    
        if ((r5 instanceof java.lang.String) == false) goto L467;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02b9, code lost:
    
        r5 = r2.getFieldDeserializer((java.lang.String) r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02bf, code lost:
    
        if (r5 == null) goto L468;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02c1, code lost:
    
        r5.setValue(r3, r4.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02ca, code lost:
    
        if (r3 != null) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02ce, code lost:
    
        if (r8 != java.lang.Cloneable.class) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02d0, code lost:
    
        r3 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02dc, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r6) == false) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02de, code lost:
    
        r3 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02e3, code lost:
    
        r3 = r8.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02e7, code lost:
    
        if (r14 != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02e9, code lost:
    
        r19.contex = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02eb, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02c9, code lost:
    
        r3 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02ec, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02f4, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02f5, code lost:
    
        r19.resolveStatus = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02fa, code lost:
    
        if (r19.contex == null) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02fe, code lost:
    
        if ((r21 instanceof java.lang.Integer) != false) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0300, code lost:
    
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0307, code lost:
    
        if (r20.size() <= 0) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0309, code lost:
    
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r20, (java.lang.Class<java.lang.Object>) r8, r19.config);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0312, code lost:
    
        if (r14 != false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0314, code lost:
    
        r19.contex = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0316, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0317, code lost:
    
        r0 = r19.config.getDeserializer(r8);
        r2 = r0.deserialze(r19, r8, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0323, code lost:
    
        if ((r0 instanceof com.alibaba.fastjson.parser.MapDeserializer) == false) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0325, code lost:
    
        r19.resolveStatus = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0328, code lost:
    
        if (r14 != false) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x032a, code lost:
    
        r19.contex = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x032c, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0288, code lost:
    
        if (r4.token != 13) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x028a, code lost:
    
        r4.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x028d, code lost:
    
        r2 = r19.config.getDeserializer(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0295, code lost:
    
        if ((r2 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L169;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:217:0x040a A[Catch: all -> 0x06fd, TryCatch #2 {all -> 0x06fd, blocks: (B:19:0x0068, B:22:0x0072, B:26:0x007b, B:30:0x008e, B:32:0x0098, B:36:0x00a0, B:37:0x00be, B:41:0x01c6, B:44:0x01d9, B:60:0x01f8, B:62:0x0205, B:66:0x020e, B:68:0x0216, B:69:0x021f, B:71:0x0225, B:75:0x0232, B:80:0x023a, B:82:0x0248, B:90:0x0252, B:92:0x0258, B:94:0x0281, B:96:0x028a, B:98:0x028d, B:100:0x0297, B:101:0x02a5, B:103:0x02ab, B:106:0x02b9, B:109:0x02c1, B:118:0x02d0, B:119:0x02d6, B:121:0x02de, B:122:0x02e3, B:128:0x02ed, B:129:0x02f4, B:130:0x02f5, B:132:0x02fc, B:134:0x0300, B:135:0x0303, B:137:0x0309, B:141:0x0317, B:143:0x0325, B:147:0x025c, B:149:0x0264, B:151:0x026e, B:153:0x0278, B:166:0x0337, B:169:0x033f, B:171:0x0346, B:173:0x0355, B:175:0x035d, B:178:0x0362, B:180:0x0366, B:181:0x03b0, B:183:0x03b4, B:187:0x03be, B:188:0x03d6, B:191:0x0369, B:193:0x0371, B:195:0x0377, B:196:0x0383, B:199:0x038c, B:203:0x0392, B:206:0x0398, B:207:0x03a4, B:208:0x03d7, B:209:0x03f3, B:212:0x03f8, B:217:0x040a, B:219:0x0410, B:221:0x041c, B:222:0x0422, B:224:0x0427, B:225:0x05b2, B:229:0x05bc, B:232:0x05c5, B:235:0x05d8, B:236:0x05d2, B:240:0x05e0, B:243:0x05f3, B:245:0x05fc, B:248:0x060f, B:250:0x0657, B:254:0x0609, B:257:0x061a, B:260:0x062d, B:261:0x0627, B:264:0x0638, B:267:0x064b, B:268:0x0645, B:269:0x0652, B:270:0x05ed, B:271:0x0661, B:272:0x0679, B:273:0x042c, B:278:0x043d, B:283:0x044a, B:286:0x0461, B:288:0x046a, B:292:0x0477, B:293:0x047a, B:295:0x0484, B:296:0x048b, B:304:0x048f, B:301:0x049f, B:302:0x04b7, B:308:0x0488, B:310:0x045b, B:313:0x04bc, B:316:0x04cf, B:318:0x04e0, B:321:0x04f4, B:322:0x04fa, B:325:0x0500, B:326:0x0506, B:328:0x050e, B:330:0x051e, B:333:0x0526, B:334:0x0528, B:336:0x052d, B:338:0x0536, B:340:0x053f, B:341:0x0542, B:349:0x0548, B:351:0x054f, B:346:0x055c, B:347:0x0574, B:355:0x053a, B:359:0x04eb, B:360:0x04c9, B:363:0x0579, B:365:0x0586, B:368:0x0599, B:370:0x05a5, B:371:0x067a, B:373:0x068b, B:374:0x068f, B:383:0x0698, B:379:0x06b2, B:380:0x06ca, B:392:0x01d3, B:393:0x0201, B:453:0x00c6, B:456:0x00d7, B:460:0x00d1, B:398:0x00ea, B:400:0x00f4, B:401:0x00f7, B:405:0x00fc, B:406:0x0112, B:414:0x0125, B:416:0x012b, B:418:0x0130, B:420:0x013d, B:421:0x0141, B:425:0x0147, B:426:0x0161, B:427:0x0135, B:429:0x0162, B:430:0x017c, B:438:0x0186, B:441:0x0195, B:443:0x019b, B:444:0x01b9, B:445:0x01ba, B:447:0x06cb, B:448:0x06e3, B:450:0x06e4, B:451:0x06fc), top: B:18:0x0068, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05c5 A[Catch: all -> 0x06fd, TryCatch #2 {all -> 0x06fd, blocks: (B:19:0x0068, B:22:0x0072, B:26:0x007b, B:30:0x008e, B:32:0x0098, B:36:0x00a0, B:37:0x00be, B:41:0x01c6, B:44:0x01d9, B:60:0x01f8, B:62:0x0205, B:66:0x020e, B:68:0x0216, B:69:0x021f, B:71:0x0225, B:75:0x0232, B:80:0x023a, B:82:0x0248, B:90:0x0252, B:92:0x0258, B:94:0x0281, B:96:0x028a, B:98:0x028d, B:100:0x0297, B:101:0x02a5, B:103:0x02ab, B:106:0x02b9, B:109:0x02c1, B:118:0x02d0, B:119:0x02d6, B:121:0x02de, B:122:0x02e3, B:128:0x02ed, B:129:0x02f4, B:130:0x02f5, B:132:0x02fc, B:134:0x0300, B:135:0x0303, B:137:0x0309, B:141:0x0317, B:143:0x0325, B:147:0x025c, B:149:0x0264, B:151:0x026e, B:153:0x0278, B:166:0x0337, B:169:0x033f, B:171:0x0346, B:173:0x0355, B:175:0x035d, B:178:0x0362, B:180:0x0366, B:181:0x03b0, B:183:0x03b4, B:187:0x03be, B:188:0x03d6, B:191:0x0369, B:193:0x0371, B:195:0x0377, B:196:0x0383, B:199:0x038c, B:203:0x0392, B:206:0x0398, B:207:0x03a4, B:208:0x03d7, B:209:0x03f3, B:212:0x03f8, B:217:0x040a, B:219:0x0410, B:221:0x041c, B:222:0x0422, B:224:0x0427, B:225:0x05b2, B:229:0x05bc, B:232:0x05c5, B:235:0x05d8, B:236:0x05d2, B:240:0x05e0, B:243:0x05f3, B:245:0x05fc, B:248:0x060f, B:250:0x0657, B:254:0x0609, B:257:0x061a, B:260:0x062d, B:261:0x0627, B:264:0x0638, B:267:0x064b, B:268:0x0645, B:269:0x0652, B:270:0x05ed, B:271:0x0661, B:272:0x0679, B:273:0x042c, B:278:0x043d, B:283:0x044a, B:286:0x0461, B:288:0x046a, B:292:0x0477, B:293:0x047a, B:295:0x0484, B:296:0x048b, B:304:0x048f, B:301:0x049f, B:302:0x04b7, B:308:0x0488, B:310:0x045b, B:313:0x04bc, B:316:0x04cf, B:318:0x04e0, B:321:0x04f4, B:322:0x04fa, B:325:0x0500, B:326:0x0506, B:328:0x050e, B:330:0x051e, B:333:0x0526, B:334:0x0528, B:336:0x052d, B:338:0x0536, B:340:0x053f, B:341:0x0542, B:349:0x0548, B:351:0x054f, B:346:0x055c, B:347:0x0574, B:355:0x053a, B:359:0x04eb, B:360:0x04c9, B:363:0x0579, B:365:0x0586, B:368:0x0599, B:370:0x05a5, B:371:0x067a, B:373:0x068b, B:374:0x068f, B:383:0x0698, B:379:0x06b2, B:380:0x06ca, B:392:0x01d3, B:393:0x0201, B:453:0x00c6, B:456:0x00d7, B:460:0x00d1, B:398:0x00ea, B:400:0x00f4, B:401:0x00f7, B:405:0x00fc, B:406:0x0112, B:414:0x0125, B:416:0x012b, B:418:0x0130, B:420:0x013d, B:421:0x0141, B:425:0x0147, B:426:0x0161, B:427:0x0135, B:429:0x0162, B:430:0x017c, B:438:0x0186, B:441:0x0195, B:443:0x019b, B:444:0x01b9, B:445:0x01ba, B:447:0x06cb, B:448:0x06e3, B:450:0x06e4, B:451:0x06fc), top: B:18:0x0068, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x05dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x051e A[Catch: all -> 0x06fd, TryCatch #2 {all -> 0x06fd, blocks: (B:19:0x0068, B:22:0x0072, B:26:0x007b, B:30:0x008e, B:32:0x0098, B:36:0x00a0, B:37:0x00be, B:41:0x01c6, B:44:0x01d9, B:60:0x01f8, B:62:0x0205, B:66:0x020e, B:68:0x0216, B:69:0x021f, B:71:0x0225, B:75:0x0232, B:80:0x023a, B:82:0x0248, B:90:0x0252, B:92:0x0258, B:94:0x0281, B:96:0x028a, B:98:0x028d, B:100:0x0297, B:101:0x02a5, B:103:0x02ab, B:106:0x02b9, B:109:0x02c1, B:118:0x02d0, B:119:0x02d6, B:121:0x02de, B:122:0x02e3, B:128:0x02ed, B:129:0x02f4, B:130:0x02f5, B:132:0x02fc, B:134:0x0300, B:135:0x0303, B:137:0x0309, B:141:0x0317, B:143:0x0325, B:147:0x025c, B:149:0x0264, B:151:0x026e, B:153:0x0278, B:166:0x0337, B:169:0x033f, B:171:0x0346, B:173:0x0355, B:175:0x035d, B:178:0x0362, B:180:0x0366, B:181:0x03b0, B:183:0x03b4, B:187:0x03be, B:188:0x03d6, B:191:0x0369, B:193:0x0371, B:195:0x0377, B:196:0x0383, B:199:0x038c, B:203:0x0392, B:206:0x0398, B:207:0x03a4, B:208:0x03d7, B:209:0x03f3, B:212:0x03f8, B:217:0x040a, B:219:0x0410, B:221:0x041c, B:222:0x0422, B:224:0x0427, B:225:0x05b2, B:229:0x05bc, B:232:0x05c5, B:235:0x05d8, B:236:0x05d2, B:240:0x05e0, B:243:0x05f3, B:245:0x05fc, B:248:0x060f, B:250:0x0657, B:254:0x0609, B:257:0x061a, B:260:0x062d, B:261:0x0627, B:264:0x0638, B:267:0x064b, B:268:0x0645, B:269:0x0652, B:270:0x05ed, B:271:0x0661, B:272:0x0679, B:273:0x042c, B:278:0x043d, B:283:0x044a, B:286:0x0461, B:288:0x046a, B:292:0x0477, B:293:0x047a, B:295:0x0484, B:296:0x048b, B:304:0x048f, B:301:0x049f, B:302:0x04b7, B:308:0x0488, B:310:0x045b, B:313:0x04bc, B:316:0x04cf, B:318:0x04e0, B:321:0x04f4, B:322:0x04fa, B:325:0x0500, B:326:0x0506, B:328:0x050e, B:330:0x051e, B:333:0x0526, B:334:0x0528, B:336:0x052d, B:338:0x0536, B:340:0x053f, B:341:0x0542, B:349:0x0548, B:351:0x054f, B:346:0x055c, B:347:0x0574, B:355:0x053a, B:359:0x04eb, B:360:0x04c9, B:363:0x0579, B:365:0x0586, B:368:0x0599, B:370:0x05a5, B:371:0x067a, B:373:0x068b, B:374:0x068f, B:383:0x0698, B:379:0x06b2, B:380:0x06ca, B:392:0x01d3, B:393:0x0201, B:453:0x00c6, B:456:0x00d7, B:460:0x00d1, B:398:0x00ea, B:400:0x00f4, B:401:0x00f7, B:405:0x00fc, B:406:0x0112, B:414:0x0125, B:416:0x012b, B:418:0x0130, B:420:0x013d, B:421:0x0141, B:425:0x0147, B:426:0x0161, B:427:0x0135, B:429:0x0162, B:430:0x017c, B:438:0x0186, B:441:0x0195, B:443:0x019b, B:444:0x01b9, B:445:0x01ba, B:447:0x06cb, B:448:0x06e3, B:450:0x06e4, B:451:0x06fc), top: B:18:0x0068, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x052d A[Catch: all -> 0x06fd, TryCatch #2 {all -> 0x06fd, blocks: (B:19:0x0068, B:22:0x0072, B:26:0x007b, B:30:0x008e, B:32:0x0098, B:36:0x00a0, B:37:0x00be, B:41:0x01c6, B:44:0x01d9, B:60:0x01f8, B:62:0x0205, B:66:0x020e, B:68:0x0216, B:69:0x021f, B:71:0x0225, B:75:0x0232, B:80:0x023a, B:82:0x0248, B:90:0x0252, B:92:0x0258, B:94:0x0281, B:96:0x028a, B:98:0x028d, B:100:0x0297, B:101:0x02a5, B:103:0x02ab, B:106:0x02b9, B:109:0x02c1, B:118:0x02d0, B:119:0x02d6, B:121:0x02de, B:122:0x02e3, B:128:0x02ed, B:129:0x02f4, B:130:0x02f5, B:132:0x02fc, B:134:0x0300, B:135:0x0303, B:137:0x0309, B:141:0x0317, B:143:0x0325, B:147:0x025c, B:149:0x0264, B:151:0x026e, B:153:0x0278, B:166:0x0337, B:169:0x033f, B:171:0x0346, B:173:0x0355, B:175:0x035d, B:178:0x0362, B:180:0x0366, B:181:0x03b0, B:183:0x03b4, B:187:0x03be, B:188:0x03d6, B:191:0x0369, B:193:0x0371, B:195:0x0377, B:196:0x0383, B:199:0x038c, B:203:0x0392, B:206:0x0398, B:207:0x03a4, B:208:0x03d7, B:209:0x03f3, B:212:0x03f8, B:217:0x040a, B:219:0x0410, B:221:0x041c, B:222:0x0422, B:224:0x0427, B:225:0x05b2, B:229:0x05bc, B:232:0x05c5, B:235:0x05d8, B:236:0x05d2, B:240:0x05e0, B:243:0x05f3, B:245:0x05fc, B:248:0x060f, B:250:0x0657, B:254:0x0609, B:257:0x061a, B:260:0x062d, B:261:0x0627, B:264:0x0638, B:267:0x064b, B:268:0x0645, B:269:0x0652, B:270:0x05ed, B:271:0x0661, B:272:0x0679, B:273:0x042c, B:278:0x043d, B:283:0x044a, B:286:0x0461, B:288:0x046a, B:292:0x0477, B:293:0x047a, B:295:0x0484, B:296:0x048b, B:304:0x048f, B:301:0x049f, B:302:0x04b7, B:308:0x0488, B:310:0x045b, B:313:0x04bc, B:316:0x04cf, B:318:0x04e0, B:321:0x04f4, B:322:0x04fa, B:325:0x0500, B:326:0x0506, B:328:0x050e, B:330:0x051e, B:333:0x0526, B:334:0x0528, B:336:0x052d, B:338:0x0536, B:340:0x053f, B:341:0x0542, B:349:0x0548, B:351:0x054f, B:346:0x055c, B:347:0x0574, B:355:0x053a, B:359:0x04eb, B:360:0x04c9, B:363:0x0579, B:365:0x0586, B:368:0x0599, B:370:0x05a5, B:371:0x067a, B:373:0x068b, B:374:0x068f, B:383:0x0698, B:379:0x06b2, B:380:0x06ca, B:392:0x01d3, B:393:0x0201, B:453:0x00c6, B:456:0x00d7, B:460:0x00d1, B:398:0x00ea, B:400:0x00f4, B:401:0x00f7, B:405:0x00fc, B:406:0x0112, B:414:0x0125, B:416:0x012b, B:418:0x0130, B:420:0x013d, B:421:0x0141, B:425:0x0147, B:426:0x0161, B:427:0x0135, B:429:0x0162, B:430:0x017c, B:438:0x0186, B:441:0x0195, B:443:0x019b, B:444:0x01b9, B:445:0x01ba, B:447:0x06cb, B:448:0x06e3, B:450:0x06e4, B:451:0x06fc), top: B:18:0x0068, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0536 A[Catch: all -> 0x06fd, TryCatch #2 {all -> 0x06fd, blocks: (B:19:0x0068, B:22:0x0072, B:26:0x007b, B:30:0x008e, B:32:0x0098, B:36:0x00a0, B:37:0x00be, B:41:0x01c6, B:44:0x01d9, B:60:0x01f8, B:62:0x0205, B:66:0x020e, B:68:0x0216, B:69:0x021f, B:71:0x0225, B:75:0x0232, B:80:0x023a, B:82:0x0248, B:90:0x0252, B:92:0x0258, B:94:0x0281, B:96:0x028a, B:98:0x028d, B:100:0x0297, B:101:0x02a5, B:103:0x02ab, B:106:0x02b9, B:109:0x02c1, B:118:0x02d0, B:119:0x02d6, B:121:0x02de, B:122:0x02e3, B:128:0x02ed, B:129:0x02f4, B:130:0x02f5, B:132:0x02fc, B:134:0x0300, B:135:0x0303, B:137:0x0309, B:141:0x0317, B:143:0x0325, B:147:0x025c, B:149:0x0264, B:151:0x026e, B:153:0x0278, B:166:0x0337, B:169:0x033f, B:171:0x0346, B:173:0x0355, B:175:0x035d, B:178:0x0362, B:180:0x0366, B:181:0x03b0, B:183:0x03b4, B:187:0x03be, B:188:0x03d6, B:191:0x0369, B:193:0x0371, B:195:0x0377, B:196:0x0383, B:199:0x038c, B:203:0x0392, B:206:0x0398, B:207:0x03a4, B:208:0x03d7, B:209:0x03f3, B:212:0x03f8, B:217:0x040a, B:219:0x0410, B:221:0x041c, B:222:0x0422, B:224:0x0427, B:225:0x05b2, B:229:0x05bc, B:232:0x05c5, B:235:0x05d8, B:236:0x05d2, B:240:0x05e0, B:243:0x05f3, B:245:0x05fc, B:248:0x060f, B:250:0x0657, B:254:0x0609, B:257:0x061a, B:260:0x062d, B:261:0x0627, B:264:0x0638, B:267:0x064b, B:268:0x0645, B:269:0x0652, B:270:0x05ed, B:271:0x0661, B:272:0x0679, B:273:0x042c, B:278:0x043d, B:283:0x044a, B:286:0x0461, B:288:0x046a, B:292:0x0477, B:293:0x047a, B:295:0x0484, B:296:0x048b, B:304:0x048f, B:301:0x049f, B:302:0x04b7, B:308:0x0488, B:310:0x045b, B:313:0x04bc, B:316:0x04cf, B:318:0x04e0, B:321:0x04f4, B:322:0x04fa, B:325:0x0500, B:326:0x0506, B:328:0x050e, B:330:0x051e, B:333:0x0526, B:334:0x0528, B:336:0x052d, B:338:0x0536, B:340:0x053f, B:341:0x0542, B:349:0x0548, B:351:0x054f, B:346:0x055c, B:347:0x0574, B:355:0x053a, B:359:0x04eb, B:360:0x04c9, B:363:0x0579, B:365:0x0586, B:368:0x0599, B:370:0x05a5, B:371:0x067a, B:373:0x068b, B:374:0x068f, B:383:0x0698, B:379:0x06b2, B:380:0x06ca, B:392:0x01d3, B:393:0x0201, B:453:0x00c6, B:456:0x00d7, B:460:0x00d1, B:398:0x00ea, B:400:0x00f4, B:401:0x00f7, B:405:0x00fc, B:406:0x0112, B:414:0x0125, B:416:0x012b, B:418:0x0130, B:420:0x013d, B:421:0x0141, B:425:0x0147, B:426:0x0161, B:427:0x0135, B:429:0x0162, B:430:0x017c, B:438:0x0186, B:441:0x0195, B:443:0x019b, B:444:0x01b9, B:445:0x01ba, B:447:0x06cb, B:448:0x06e3, B:450:0x06e4, B:451:0x06fc), top: B:18:0x0068, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:340:0x053f A[Catch: all -> 0x06fd, TryCatch #2 {all -> 0x06fd, blocks: (B:19:0x0068, B:22:0x0072, B:26:0x007b, B:30:0x008e, B:32:0x0098, B:36:0x00a0, B:37:0x00be, B:41:0x01c6, B:44:0x01d9, B:60:0x01f8, B:62:0x0205, B:66:0x020e, B:68:0x0216, B:69:0x021f, B:71:0x0225, B:75:0x0232, B:80:0x023a, B:82:0x0248, B:90:0x0252, B:92:0x0258, B:94:0x0281, B:96:0x028a, B:98:0x028d, B:100:0x0297, B:101:0x02a5, B:103:0x02ab, B:106:0x02b9, B:109:0x02c1, B:118:0x02d0, B:119:0x02d6, B:121:0x02de, B:122:0x02e3, B:128:0x02ed, B:129:0x02f4, B:130:0x02f5, B:132:0x02fc, B:134:0x0300, B:135:0x0303, B:137:0x0309, B:141:0x0317, B:143:0x0325, B:147:0x025c, B:149:0x0264, B:151:0x026e, B:153:0x0278, B:166:0x0337, B:169:0x033f, B:171:0x0346, B:173:0x0355, B:175:0x035d, B:178:0x0362, B:180:0x0366, B:181:0x03b0, B:183:0x03b4, B:187:0x03be, B:188:0x03d6, B:191:0x0369, B:193:0x0371, B:195:0x0377, B:196:0x0383, B:199:0x038c, B:203:0x0392, B:206:0x0398, B:207:0x03a4, B:208:0x03d7, B:209:0x03f3, B:212:0x03f8, B:217:0x040a, B:219:0x0410, B:221:0x041c, B:222:0x0422, B:224:0x0427, B:225:0x05b2, B:229:0x05bc, B:232:0x05c5, B:235:0x05d8, B:236:0x05d2, B:240:0x05e0, B:243:0x05f3, B:245:0x05fc, B:248:0x060f, B:250:0x0657, B:254:0x0609, B:257:0x061a, B:260:0x062d, B:261:0x0627, B:264:0x0638, B:267:0x064b, B:268:0x0645, B:269:0x0652, B:270:0x05ed, B:271:0x0661, B:272:0x0679, B:273:0x042c, B:278:0x043d, B:283:0x044a, B:286:0x0461, B:288:0x046a, B:292:0x0477, B:293:0x047a, B:295:0x0484, B:296:0x048b, B:304:0x048f, B:301:0x049f, B:302:0x04b7, B:308:0x0488, B:310:0x045b, B:313:0x04bc, B:316:0x04cf, B:318:0x04e0, B:321:0x04f4, B:322:0x04fa, B:325:0x0500, B:326:0x0506, B:328:0x050e, B:330:0x051e, B:333:0x0526, B:334:0x0528, B:336:0x052d, B:338:0x0536, B:340:0x053f, B:341:0x0542, B:349:0x0548, B:351:0x054f, B:346:0x055c, B:347:0x0574, B:355:0x053a, B:359:0x04eb, B:360:0x04c9, B:363:0x0579, B:365:0x0586, B:368:0x0599, B:370:0x05a5, B:371:0x067a, B:373:0x068b, B:374:0x068f, B:383:0x0698, B:379:0x06b2, B:380:0x06ca, B:392:0x01d3, B:393:0x0201, B:453:0x00c6, B:456:0x00d7, B:460:0x00d1, B:398:0x00ea, B:400:0x00f4, B:401:0x00f7, B:405:0x00fc, B:406:0x0112, B:414:0x0125, B:416:0x012b, B:418:0x0130, B:420:0x013d, B:421:0x0141, B:425:0x0147, B:426:0x0161, B:427:0x0135, B:429:0x0162, B:430:0x017c, B:438:0x0186, B:441:0x0195, B:443:0x019b, B:444:0x01b9, B:445:0x01ba, B:447:0x06cb, B:448:0x06e3, B:450:0x06e4, B:451:0x06fc), top: B:18:0x0068, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0548 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x053a A[Catch: all -> 0x06fd, TryCatch #2 {all -> 0x06fd, blocks: (B:19:0x0068, B:22:0x0072, B:26:0x007b, B:30:0x008e, B:32:0x0098, B:36:0x00a0, B:37:0x00be, B:41:0x01c6, B:44:0x01d9, B:60:0x01f8, B:62:0x0205, B:66:0x020e, B:68:0x0216, B:69:0x021f, B:71:0x0225, B:75:0x0232, B:80:0x023a, B:82:0x0248, B:90:0x0252, B:92:0x0258, B:94:0x0281, B:96:0x028a, B:98:0x028d, B:100:0x0297, B:101:0x02a5, B:103:0x02ab, B:106:0x02b9, B:109:0x02c1, B:118:0x02d0, B:119:0x02d6, B:121:0x02de, B:122:0x02e3, B:128:0x02ed, B:129:0x02f4, B:130:0x02f5, B:132:0x02fc, B:134:0x0300, B:135:0x0303, B:137:0x0309, B:141:0x0317, B:143:0x0325, B:147:0x025c, B:149:0x0264, B:151:0x026e, B:153:0x0278, B:166:0x0337, B:169:0x033f, B:171:0x0346, B:173:0x0355, B:175:0x035d, B:178:0x0362, B:180:0x0366, B:181:0x03b0, B:183:0x03b4, B:187:0x03be, B:188:0x03d6, B:191:0x0369, B:193:0x0371, B:195:0x0377, B:196:0x0383, B:199:0x038c, B:203:0x0392, B:206:0x0398, B:207:0x03a4, B:208:0x03d7, B:209:0x03f3, B:212:0x03f8, B:217:0x040a, B:219:0x0410, B:221:0x041c, B:222:0x0422, B:224:0x0427, B:225:0x05b2, B:229:0x05bc, B:232:0x05c5, B:235:0x05d8, B:236:0x05d2, B:240:0x05e0, B:243:0x05f3, B:245:0x05fc, B:248:0x060f, B:250:0x0657, B:254:0x0609, B:257:0x061a, B:260:0x062d, B:261:0x0627, B:264:0x0638, B:267:0x064b, B:268:0x0645, B:269:0x0652, B:270:0x05ed, B:271:0x0661, B:272:0x0679, B:273:0x042c, B:278:0x043d, B:283:0x044a, B:286:0x0461, B:288:0x046a, B:292:0x0477, B:293:0x047a, B:295:0x0484, B:296:0x048b, B:304:0x048f, B:301:0x049f, B:302:0x04b7, B:308:0x0488, B:310:0x045b, B:313:0x04bc, B:316:0x04cf, B:318:0x04e0, B:321:0x04f4, B:322:0x04fa, B:325:0x0500, B:326:0x0506, B:328:0x050e, B:330:0x051e, B:333:0x0526, B:334:0x0528, B:336:0x052d, B:338:0x0536, B:340:0x053f, B:341:0x0542, B:349:0x0548, B:351:0x054f, B:346:0x055c, B:347:0x0574, B:355:0x053a, B:359:0x04eb, B:360:0x04c9, B:363:0x0579, B:365:0x0586, B:368:0x0599, B:370:0x05a5, B:371:0x067a, B:373:0x068b, B:374:0x068f, B:383:0x0698, B:379:0x06b2, B:380:0x06ca, B:392:0x01d3, B:393:0x0201, B:453:0x00c6, B:456:0x00d7, B:460:0x00d1, B:398:0x00ea, B:400:0x00f4, B:401:0x00f7, B:405:0x00fc, B:406:0x0112, B:414:0x0125, B:416:0x012b, B:418:0x0130, B:420:0x013d, B:421:0x0141, B:425:0x0147, B:426:0x0161, B:427:0x0135, B:429:0x0162, B:430:0x017c, B:438:0x0186, B:441:0x0195, B:443:0x019b, B:444:0x01b9, B:445:0x01ba, B:447:0x06cb, B:448:0x06e3, B:450:0x06e4, B:451:0x06fc), top: B:18:0x0068, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0201 A[Catch: all -> 0x06fd, TryCatch #2 {all -> 0x06fd, blocks: (B:19:0x0068, B:22:0x0072, B:26:0x007b, B:30:0x008e, B:32:0x0098, B:36:0x00a0, B:37:0x00be, B:41:0x01c6, B:44:0x01d9, B:60:0x01f8, B:62:0x0205, B:66:0x020e, B:68:0x0216, B:69:0x021f, B:71:0x0225, B:75:0x0232, B:80:0x023a, B:82:0x0248, B:90:0x0252, B:92:0x0258, B:94:0x0281, B:96:0x028a, B:98:0x028d, B:100:0x0297, B:101:0x02a5, B:103:0x02ab, B:106:0x02b9, B:109:0x02c1, B:118:0x02d0, B:119:0x02d6, B:121:0x02de, B:122:0x02e3, B:128:0x02ed, B:129:0x02f4, B:130:0x02f5, B:132:0x02fc, B:134:0x0300, B:135:0x0303, B:137:0x0309, B:141:0x0317, B:143:0x0325, B:147:0x025c, B:149:0x0264, B:151:0x026e, B:153:0x0278, B:166:0x0337, B:169:0x033f, B:171:0x0346, B:173:0x0355, B:175:0x035d, B:178:0x0362, B:180:0x0366, B:181:0x03b0, B:183:0x03b4, B:187:0x03be, B:188:0x03d6, B:191:0x0369, B:193:0x0371, B:195:0x0377, B:196:0x0383, B:199:0x038c, B:203:0x0392, B:206:0x0398, B:207:0x03a4, B:208:0x03d7, B:209:0x03f3, B:212:0x03f8, B:217:0x040a, B:219:0x0410, B:221:0x041c, B:222:0x0422, B:224:0x0427, B:225:0x05b2, B:229:0x05bc, B:232:0x05c5, B:235:0x05d8, B:236:0x05d2, B:240:0x05e0, B:243:0x05f3, B:245:0x05fc, B:248:0x060f, B:250:0x0657, B:254:0x0609, B:257:0x061a, B:260:0x062d, B:261:0x0627, B:264:0x0638, B:267:0x064b, B:268:0x0645, B:269:0x0652, B:270:0x05ed, B:271:0x0661, B:272:0x0679, B:273:0x042c, B:278:0x043d, B:283:0x044a, B:286:0x0461, B:288:0x046a, B:292:0x0477, B:293:0x047a, B:295:0x0484, B:296:0x048b, B:304:0x048f, B:301:0x049f, B:302:0x04b7, B:308:0x0488, B:310:0x045b, B:313:0x04bc, B:316:0x04cf, B:318:0x04e0, B:321:0x04f4, B:322:0x04fa, B:325:0x0500, B:326:0x0506, B:328:0x050e, B:330:0x051e, B:333:0x0526, B:334:0x0528, B:336:0x052d, B:338:0x0536, B:340:0x053f, B:341:0x0542, B:349:0x0548, B:351:0x054f, B:346:0x055c, B:347:0x0574, B:355:0x053a, B:359:0x04eb, B:360:0x04c9, B:363:0x0579, B:365:0x0586, B:368:0x0599, B:370:0x05a5, B:371:0x067a, B:373:0x068b, B:374:0x068f, B:383:0x0698, B:379:0x06b2, B:380:0x06ca, B:392:0x01d3, B:393:0x0201, B:453:0x00c6, B:456:0x00d7, B:460:0x00d1, B:398:0x00ea, B:400:0x00f4, B:401:0x00f7, B:405:0x00fc, B:406:0x0112, B:414:0x0125, B:416:0x012b, B:418:0x0130, B:420:0x013d, B:421:0x0141, B:425:0x0147, B:426:0x0161, B:427:0x0135, B:429:0x0162, B:430:0x017c, B:438:0x0186, B:441:0x0195, B:443:0x019b, B:444:0x01b9, B:445:0x01ba, B:447:0x06cb, B:448:0x06e3, B:450:0x06e4, B:451:0x06fc), top: B:18:0x0068, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c6 A[Catch: all -> 0x06fd, TryCatch #2 {all -> 0x06fd, blocks: (B:19:0x0068, B:22:0x0072, B:26:0x007b, B:30:0x008e, B:32:0x0098, B:36:0x00a0, B:37:0x00be, B:41:0x01c6, B:44:0x01d9, B:60:0x01f8, B:62:0x0205, B:66:0x020e, B:68:0x0216, B:69:0x021f, B:71:0x0225, B:75:0x0232, B:80:0x023a, B:82:0x0248, B:90:0x0252, B:92:0x0258, B:94:0x0281, B:96:0x028a, B:98:0x028d, B:100:0x0297, B:101:0x02a5, B:103:0x02ab, B:106:0x02b9, B:109:0x02c1, B:118:0x02d0, B:119:0x02d6, B:121:0x02de, B:122:0x02e3, B:128:0x02ed, B:129:0x02f4, B:130:0x02f5, B:132:0x02fc, B:134:0x0300, B:135:0x0303, B:137:0x0309, B:141:0x0317, B:143:0x0325, B:147:0x025c, B:149:0x0264, B:151:0x026e, B:153:0x0278, B:166:0x0337, B:169:0x033f, B:171:0x0346, B:173:0x0355, B:175:0x035d, B:178:0x0362, B:180:0x0366, B:181:0x03b0, B:183:0x03b4, B:187:0x03be, B:188:0x03d6, B:191:0x0369, B:193:0x0371, B:195:0x0377, B:196:0x0383, B:199:0x038c, B:203:0x0392, B:206:0x0398, B:207:0x03a4, B:208:0x03d7, B:209:0x03f3, B:212:0x03f8, B:217:0x040a, B:219:0x0410, B:221:0x041c, B:222:0x0422, B:224:0x0427, B:225:0x05b2, B:229:0x05bc, B:232:0x05c5, B:235:0x05d8, B:236:0x05d2, B:240:0x05e0, B:243:0x05f3, B:245:0x05fc, B:248:0x060f, B:250:0x0657, B:254:0x0609, B:257:0x061a, B:260:0x062d, B:261:0x0627, B:264:0x0638, B:267:0x064b, B:268:0x0645, B:269:0x0652, B:270:0x05ed, B:271:0x0661, B:272:0x0679, B:273:0x042c, B:278:0x043d, B:283:0x044a, B:286:0x0461, B:288:0x046a, B:292:0x0477, B:293:0x047a, B:295:0x0484, B:296:0x048b, B:304:0x048f, B:301:0x049f, B:302:0x04b7, B:308:0x0488, B:310:0x045b, B:313:0x04bc, B:316:0x04cf, B:318:0x04e0, B:321:0x04f4, B:322:0x04fa, B:325:0x0500, B:326:0x0506, B:328:0x050e, B:330:0x051e, B:333:0x0526, B:334:0x0528, B:336:0x052d, B:338:0x0536, B:340:0x053f, B:341:0x0542, B:349:0x0548, B:351:0x054f, B:346:0x055c, B:347:0x0574, B:355:0x053a, B:359:0x04eb, B:360:0x04c9, B:363:0x0579, B:365:0x0586, B:368:0x0599, B:370:0x05a5, B:371:0x067a, B:373:0x068b, B:374:0x068f, B:383:0x0698, B:379:0x06b2, B:380:0x06ca, B:392:0x01d3, B:393:0x0201, B:453:0x00c6, B:456:0x00d7, B:460:0x00d1, B:398:0x00ea, B:400:0x00f4, B:401:0x00f7, B:405:0x00fc, B:406:0x0112, B:414:0x0125, B:416:0x012b, B:418:0x0130, B:420:0x013d, B:421:0x0141, B:425:0x0147, B:426:0x0161, B:427:0x0135, B:429:0x0162, B:430:0x017c, B:438:0x0186, B:441:0x0195, B:443:0x019b, B:444:0x01b9, B:445:0x01ba, B:447:0x06cb, B:448:0x06e3, B:450:0x06e4, B:451:0x06fc), top: B:18:0x0068, inners: #0, #1 }] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r7v58, types: [java.util.Date] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object parseObject(java.util.Map map, java.lang.Object obj, java.lang.Class cls) {
        java.util.Map map2;
        boolean z;
        java.lang.Object parse;
        boolean z2;
        char c;
        char c2;
        java.lang.Object obj2;
        boolean z3;
        int i;
        char c3;
        java.lang.Object obj3;
        java.lang.Object obj4;
        boolean z4;
        java.lang.Object obj5;
        java.lang.Class<?> cls2;
        java.lang.Class cls3 = cls;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = this.lexer;
        int i2 = jSONLexer.token;
        if (i2 == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (i2 != 12 && i2 != 16) {
            throw new com.alibaba.fastjson.JSONException("syntax error, expect {, actual " + com.alibaba.fastjson.parser.JSONToken.name(i2) + ", " + jSONLexer.info());
        }
        if (map instanceof com.alibaba.fastjson.JSONObject) {
            map2 = ((com.alibaba.fastjson.JSONObject) map).getInnerMap();
            z = true;
        } else {
            map2 = map;
            z = false;
        }
        boolean z5 = (jSONLexer.features & com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat.mask) != 0;
        boolean z6 = jSONLexer.disableCircularReferenceDetect;
        com.alibaba.fastjson.parser.ParseContext parseContext = this.contex;
        boolean z7 = false;
        int i3 = 0;
        while (true) {
            try {
                char c4 = jSONLexer.ch;
                if (c4 != '\"' && c4 != '}') {
                    jSONLexer.skipWhitespace();
                    c4 = jSONLexer.ch;
                }
                while (c4 == ',') {
                    jSONLexer.next();
                    jSONLexer.skipWhitespace();
                    c4 = jSONLexer.ch;
                }
                char c5 = com.alibaba.fastjson.parser.JSONLexer.EOI;
                if (c4 == '\"') {
                    java.lang.String scanSymbol = jSONLexer.scanSymbol(this.symbolTable, kotlin.text.Typography.quote);
                    parse = scanSymbol;
                    if (jSONLexer.ch != ':') {
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.ch != ':') {
                            throw new com.alibaba.fastjson.JSONException("expect ':' at " + jSONLexer.pos + ", name " + ((java.lang.Object) scanSymbol));
                        }
                        parse = scanSymbol;
                    }
                } else {
                    if (c4 == '}') {
                        int i4 = jSONLexer.bp + 1;
                        jSONLexer.bp = i4;
                        if (i4 < jSONLexer.len) {
                            c5 = jSONLexer.text.charAt(i4);
                        }
                        jSONLexer.ch = c5;
                        jSONLexer.sp = 0;
                        jSONLexer.nextToken(16);
                        return map;
                    }
                    if (c4 == '\'') {
                        java.lang.String scanSymbol2 = jSONLexer.scanSymbol(this.symbolTable, '\'');
                        if (jSONLexer.ch != ':') {
                            jSONLexer.skipWhitespace();
                        }
                        if (jSONLexer.ch != ':') {
                            throw new com.alibaba.fastjson.JSONException("expect ':' at " + jSONLexer.pos);
                        }
                        parse = scanSymbol2;
                    } else {
                        if (c4 == 26) {
                            throw new com.alibaba.fastjson.JSONException("syntax error, " + jSONLexer.info());
                        }
                        if (c4 == ',') {
                            throw new com.alibaba.fastjson.JSONException("syntax error, " + jSONLexer.info());
                        }
                        if ((c4 < '0' || c4 > '9') && c4 != '-') {
                            if (c4 != '{' && c4 != '[') {
                                java.lang.String scanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(this.symbolTable);
                                jSONLexer.skipWhitespace();
                                char c6 = jSONLexer.ch;
                                parse = scanSymbolUnQuoted;
                                if (c6 != ':') {
                                    throw new com.alibaba.fastjson.JSONException("expect ':' at " + jSONLexer.bp + ", actual " + c6);
                                }
                                if (z) {
                                    parse = scanSymbolUnQuoted.toString();
                                }
                            }
                            jSONLexer.nextToken();
                            parse = parse();
                            z2 = true;
                            if (z2) {
                                int i5 = jSONLexer.bp + 1;
                                jSONLexer.bp = i5;
                                c = i5 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i5);
                                jSONLexer.ch = c;
                                while (c <= ' ') {
                                    if (c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != '\f') {
                                        if (c != '\b') {
                                            break;
                                        }
                                    }
                                    jSONLexer.next();
                                    c = jSONLexer.ch;
                                }
                            } else {
                                c = jSONLexer.ch;
                            }
                            jSONLexer.sp = 0;
                            if (i3 == 0 || parse != com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY || jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect)) {
                                if (i3 != 0 && parse == "$ref" && parseContext != null && !jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect)) {
                                    jSONLexer.nextToken(4);
                                    if (jSONLexer.token != 4) {
                                        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(jSONLexer.token));
                                    }
                                    java.lang.String stringVal = jSONLexer.stringVal();
                                    jSONLexer.nextToken(13);
                                    if ("@".equals(stringVal)) {
                                        com.alibaba.fastjson.parser.ParseContext parseContext2 = this.contex;
                                        obj4 = parseContext2.object;
                                        if (!(obj4 instanceof java.lang.Object[]) && !(obj4 instanceof java.util.Collection)) {
                                            com.alibaba.fastjson.parser.ParseContext parseContext3 = parseContext2.parent;
                                            if (parseContext3 != null) {
                                                obj3 = parseContext3.object;
                                            }
                                            obj3 = null;
                                        }
                                        obj3 = obj4;
                                    } else {
                                        if ("..".equals(stringVal)) {
                                            obj4 = parseContext.object;
                                            if (obj4 == null) {
                                                addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(parseContext, stringVal));
                                                this.resolveStatus = 1;
                                            }
                                            obj3 = obj4;
                                        } else if ("$".equals(stringVal)) {
                                            com.alibaba.fastjson.parser.ParseContext parseContext4 = parseContext;
                                            while (true) {
                                                com.alibaba.fastjson.parser.ParseContext parseContext5 = parseContext4.parent;
                                                if (parseContext5 == null) {
                                                    break;
                                                }
                                                parseContext4 = parseContext5;
                                            }
                                            java.lang.Object obj6 = parseContext4.object;
                                            if (obj6 != null) {
                                                obj3 = obj6;
                                            } else {
                                                addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(parseContext4, stringVal));
                                                this.resolveStatus = 1;
                                            }
                                        } else {
                                            addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(parseContext, stringVal));
                                            this.resolveStatus = 1;
                                        }
                                        obj3 = null;
                                    }
                                    if (jSONLexer.token == 13) {
                                        jSONLexer.nextToken(16);
                                        if (!z6) {
                                            this.contex = parseContext;
                                        }
                                        return obj3;
                                    }
                                    throw new com.alibaba.fastjson.JSONException("syntax error, " + jSONLexer.info());
                                }
                                if (!z6 || z7) {
                                    c2 = kotlin.text.Typography.quote;
                                } else {
                                    com.alibaba.fastjson.parser.ParseContext context = setContext(this.contex, map, obj);
                                    if (parseContext == null) {
                                        parseContext = context;
                                    }
                                    c2 = kotlin.text.Typography.quote;
                                    z7 = true;
                                }
                                if (c != c2) {
                                    java.lang.String scanStringValue = jSONLexer.scanStringValue(c2);
                                    java.lang.String str = scanStringValue;
                                    if (z5) {
                                        com.alibaba.fastjson.parser.JSONLexer jSONLexer2 = new com.alibaba.fastjson.parser.JSONLexer(scanStringValue);
                                        java.lang.String str2 = scanStringValue;
                                        if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                                            str2 = jSONLexer2.calendar.getTime();
                                        }
                                        jSONLexer2.close();
                                        str = str2;
                                    }
                                    if (map2 != null) {
                                        map2.put(parse, str);
                                    } else {
                                        map.put(parse, str);
                                    }
                                } else if ((c >= '0' && c <= '9') || c == '-') {
                                    map2.put(parse, jSONLexer.scanNumberValue());
                                } else if (c == '[') {
                                    jSONLexer.token = 14;
                                    int i6 = jSONLexer.bp + 1;
                                    jSONLexer.bp = i6;
                                    jSONLexer.ch = i6 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i6);
                                    java.util.ArrayList arrayList = new java.util.ArrayList();
                                    if (!(obj != null && obj.getClass() == java.lang.Integer.class)) {
                                        setContext(parseContext);
                                    }
                                    parseArray(arrayList, parse);
                                    com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray(arrayList);
                                    if (map2 != null) {
                                        map2.put(parse, jSONArray);
                                    } else {
                                        map.put(parse, jSONArray);
                                    }
                                    int i7 = jSONLexer.token;
                                    if (i7 == 13) {
                                        jSONLexer.nextToken(16);
                                        if (!z6) {
                                            this.contex = parseContext;
                                        }
                                        return map;
                                    }
                                    if (i7 != 16) {
                                        throw new com.alibaba.fastjson.JSONException("syntax error, " + jSONLexer.info());
                                    }
                                } else if (c == '{') {
                                    int i8 = jSONLexer.bp + 1;
                                    jSONLexer.bp = i8;
                                    jSONLexer.ch = i8 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i8);
                                    jSONLexer.token = 12;
                                    boolean z8 = obj instanceof java.lang.Integer;
                                    com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.parser.Feature.OrderedField.mask & jSONLexer.features) != 0 ? new com.alibaba.fastjson.JSONObject(new java.util.LinkedHashMap()) : new com.alibaba.fastjson.JSONObject();
                                    com.alibaba.fastjson.parser.ParseContext context2 = (z6 || z8) ? null : setContext(parseContext, jSONObject, parse);
                                    if (this.fieldTypeResolver != null) {
                                        java.lang.reflect.Type resolve = this.fieldTypeResolver.resolve(map, parse != null ? parse.toString() : null);
                                        if (resolve != null) {
                                            obj2 = this.config.getDeserializer(resolve).deserialze(this, resolve, parse);
                                            z3 = true;
                                            if (!z3) {
                                                obj2 = parseObject(jSONObject, parse);
                                            }
                                            if (context2 != null && jSONObject != obj2) {
                                                context2.object = map;
                                            }
                                            if (this.resolveStatus == 1) {
                                                checkMapResolve(map, parse.toString());
                                            }
                                            if (map2 == null) {
                                                map2.put(parse, obj2);
                                            } else {
                                                map.put(parse, obj2);
                                            }
                                            if (z8) {
                                                setContext(parseContext, obj2, parse);
                                            }
                                            i = jSONLexer.token;
                                            if (i != 13) {
                                                jSONLexer.nextToken(16);
                                                if (!z6) {
                                                    this.contex = parseContext;
                                                }
                                                if (!z6) {
                                                    this.contex = parseContext;
                                                }
                                                return map;
                                            }
                                            if (i != 16) {
                                                throw new com.alibaba.fastjson.JSONException("syntax error, " + jSONLexer.info());
                                            }
                                            i3++;
                                            cls3 = cls;
                                        }
                                    }
                                    obj2 = null;
                                    z3 = false;
                                    if (!z3) {
                                    }
                                    if (context2 != null) {
                                        context2.object = map;
                                    }
                                    if (this.resolveStatus == 1) {
                                    }
                                    if (map2 == null) {
                                    }
                                    if (z8) {
                                    }
                                    i = jSONLexer.token;
                                    if (i != 13) {
                                    }
                                } else if (c == 't') {
                                    if (jSONLexer.text.startsWith(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE, jSONLexer.bp)) {
                                        jSONLexer.bp += 3;
                                        jSONLexer.next();
                                        map.put(parse, java.lang.Boolean.TRUE);
                                    }
                                } else if (c != 'f') {
                                    jSONLexer.nextToken();
                                    java.lang.Object parse2 = parse();
                                    if (map.getClass() == com.alibaba.fastjson.JSONObject.class) {
                                        parse = parse.toString();
                                    }
                                    map.put(parse, parse2);
                                    int i9 = jSONLexer.token;
                                    if (i9 == 13) {
                                        jSONLexer.nextToken(16);
                                        if (!z6) {
                                            this.contex = parseContext;
                                        }
                                        return map;
                                    }
                                    if (i9 != 16) {
                                        throw new com.alibaba.fastjson.JSONException("syntax error, " + jSONLexer.info());
                                    }
                                    i3++;
                                    cls3 = cls;
                                } else if (jSONLexer.text.startsWith(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE, jSONLexer.bp)) {
                                    jSONLexer.bp += 4;
                                    jSONLexer.next();
                                    map.put(parse, java.lang.Boolean.FALSE);
                                }
                                c3 = jSONLexer.ch;
                                if (c3 != ',' && c3 != '}') {
                                    jSONLexer.skipWhitespace();
                                    c3 = jSONLexer.ch;
                                }
                                if (c3 == ',') {
                                    if (c3 != '}') {
                                        throw new com.alibaba.fastjson.JSONException("syntax error, " + jSONLexer.info());
                                    }
                                    int i10 = jSONLexer.bp + 1;
                                    jSONLexer.bp = i10;
                                    char charAt = i10 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i10);
                                    jSONLexer.ch = charAt;
                                    jSONLexer.sp = 0;
                                    if (charAt == ',') {
                                        int i11 = jSONLexer.bp + 1;
                                        jSONLexer.bp = i11;
                                        jSONLexer.ch = i11 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i11);
                                        jSONLexer.token = 16;
                                    } else if (charAt == '}') {
                                        int i12 = jSONLexer.bp + 1;
                                        jSONLexer.bp = i12;
                                        jSONLexer.ch = i12 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i12);
                                        jSONLexer.token = 13;
                                    } else if (charAt == ']') {
                                        int i13 = jSONLexer.bp + 1;
                                        jSONLexer.bp = i13;
                                        jSONLexer.ch = i13 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i13);
                                        jSONLexer.token = 15;
                                    } else {
                                        jSONLexer.nextToken();
                                    }
                                    if (!z6) {
                                        setContext(this.contex, map, obj);
                                    }
                                    if (!z6) {
                                        this.contex = parseContext;
                                    }
                                    return map;
                                }
                                int i14 = jSONLexer.bp + 1;
                                jSONLexer.bp = i14;
                                jSONLexer.ch = i14 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i14);
                            } else {
                                java.lang.String scanSymbol3 = jSONLexer.scanSymbol(this.symbolTable, kotlin.text.Typography.quote);
                                for (int i15 = 0; i15 < scanSymbol3.length(); i15++) {
                                    char charAt2 = scanSymbol3.charAt(i15);
                                    if (charAt2 >= '0' && charAt2 <= '9') {
                                    }
                                    z4 = false;
                                }
                                z4 = true;
                                if (z4) {
                                    obj5 = null;
                                    cls2 = null;
                                } else {
                                    obj5 = null;
                                    cls2 = this.config.checkAutoType(scanSymbol3, null, jSONLexer.features);
                                }
                                if (cls2 == null) {
                                    map.put(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY, scanSymbol3);
                                } else {
                                    if (cls3 == null || cls3 == java.lang.Object.class) {
                                        if (java.util.Map.class.isAssignableFrom(cls2) || java.lang.reflect.Modifier.isAbstract(cls2.getModifiers()) || java.lang.reflect.Modifier.isInterface(cls2.getModifiers())) {
                                            break;
                                        }
                                        map.put(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY, scanSymbol3);
                                    } else {
                                        if (cls3.isAssignableFrom(cls2)) {
                                            break;
                                        }
                                        map.put(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY, scanSymbol3);
                                    }
                                    i3++;
                                    cls3 = cls;
                                }
                            }
                            i3++;
                            cls3 = cls;
                        } else {
                            jSONLexer.sp = 0;
                            jSONLexer.scanNumber();
                            try {
                                java.lang.Object integerValue = jSONLexer.token == 2 ? jSONLexer.integerValue() : jSONLexer.decimalValue(true);
                                if (z) {
                                    integerValue = integerValue.toString();
                                }
                                if (jSONLexer.ch != ':') {
                                    throw new com.alibaba.fastjson.JSONException("parse number key error, " + jSONLexer.info());
                                }
                                parse = integerValue;
                            } catch (java.lang.NumberFormatException unused) {
                                throw new com.alibaba.fastjson.JSONException("parse number key error, " + jSONLexer.info());
                            }
                        }
                    }
                }
                z2 = false;
                if (z2) {
                }
                jSONLexer.sp = 0;
                if (i3 == 0) {
                }
                if (i3 != 0) {
                }
                if (z6) {
                }
                c2 = kotlin.text.Typography.quote;
                if (c != c2) {
                }
                c3 = jSONLexer.ch;
                if (c3 != ',') {
                    jSONLexer.skipWhitespace();
                    c3 = jSONLexer.ch;
                }
                if (c3 == ',') {
                }
            } finally {
                if (!z6) {
                    this.contex = parseContext;
                }
            }
        }
    }

    public void parseObject(java.lang.Object obj) {
        java.lang.Object deserialze;
        java.lang.Class<?> cls = obj.getClass();
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        com.alibaba.fastjson.parser.JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer ? (com.alibaba.fastjson.parser.JavaBeanDeserializer) deserializer : null;
        int i = this.lexer.token;
        if (i != 12 && i != 16) {
            throw new com.alibaba.fastjson.JSONException("syntax error, expect {, actual " + com.alibaba.fastjson.parser.JSONToken.name(i));
        }
        while (true) {
            java.lang.String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (scanSymbol == null) {
                com.alibaba.fastjson.parser.JSONLexer jSONLexer = this.lexer;
                int i2 = jSONLexer.token;
                if (i2 == 13) {
                    jSONLexer.nextToken(16);
                    return;
                } else if (i2 == 16) {
                    continue;
                }
            }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
            if (fieldDeserializer == null) {
                com.alibaba.fastjson.parser.JSONLexer jSONLexer2 = this.lexer;
                if ((jSONLexer2.features & com.alibaba.fastjson.parser.Feature.IgnoreNotMatch.mask) == 0) {
                    throw new com.alibaba.fastjson.JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
                jSONLexer2.nextTokenWithChar(':');
                parse();
                com.alibaba.fastjson.parser.JSONLexer jSONLexer3 = this.lexer;
                if (jSONLexer3.token == 13) {
                    jSONLexer3.nextToken();
                    return;
                }
            } else {
                com.alibaba.fastjson.util.FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                java.lang.Class<?> cls2 = fieldInfo.fieldClass;
                java.lang.reflect.Type type = fieldInfo.fieldType;
                if (cls2 == java.lang.Integer.TYPE) {
                    this.lexer.nextTokenWithChar(':');
                    deserialze = com.alibaba.fastjson.serializer.IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == java.lang.String.class) {
                    this.lexer.nextTokenWithChar(':');
                    deserialze = parseString();
                } else if (cls2 == java.lang.Long.TYPE) {
                    this.lexer.nextTokenWithChar(':');
                    deserialze = com.alibaba.fastjson.serializer.IntegerCodec.instance.deserialze(this, type, null);
                } else {
                    com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithChar(':');
                    deserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, deserialze);
                com.alibaba.fastjson.parser.JSONLexer jSONLexer4 = this.lexer;
                int i3 = jSONLexer4.token;
                if (i3 != 16 && i3 == 13) {
                    jSONLexer4.nextToken(16);
                    return;
                }
            }
        }
    }

    public java.lang.String parseString() {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token;
        if (i != 4) {
            if (i == 2) {
                java.lang.String numberString = jSONLexer.numberString();
                this.lexer.nextToken(16);
                return numberString;
            }
            java.lang.Object parse = parse();
            if (parse == null) {
                return null;
            }
            return parse.toString();
        }
        java.lang.String stringVal = jSONLexer.stringVal();
        com.alibaba.fastjson.parser.JSONLexer jSONLexer2 = this.lexer;
        char c = jSONLexer2.ch;
        char c2 = com.alibaba.fastjson.parser.JSONLexer.EOI;
        if (c == ',') {
            int i2 = jSONLexer2.bp + 1;
            jSONLexer2.bp = i2;
            if (i2 < jSONLexer2.len) {
                c2 = jSONLexer2.text.charAt(i2);
            }
            jSONLexer2.ch = c2;
            this.lexer.token = 16;
        } else if (c == ']') {
            int i3 = jSONLexer2.bp + 1;
            jSONLexer2.bp = i3;
            if (i3 < jSONLexer2.len) {
                c2 = jSONLexer2.text.charAt(i3);
            }
            jSONLexer2.ch = c2;
            this.lexer.token = 15;
        } else if (c == '}') {
            int i4 = jSONLexer2.bp + 1;
            jSONLexer2.bp = i4;
            if (i4 < jSONLexer2.len) {
                c2 = jSONLexer2.text.charAt(i4);
            }
            jSONLexer2.ch = c2;
            this.lexer.token = 13;
        } else {
            jSONLexer2.nextToken();
        }
        return stringVal;
    }

    public void popContext() {
        this.contex = this.contex.parent;
        com.alibaba.fastjson.parser.ParseContext[] parseContextArr = this.contextArray;
        int i = this.contextArrayIndex;
        parseContextArr[i - 1] = null;
        this.contextArrayIndex = i - 1;
    }

    public com.alibaba.fastjson.parser.ParseContext setContext(com.alibaba.fastjson.parser.ParseContext parseContext, java.lang.Object obj, java.lang.Object obj2) {
        if (this.lexer.disableCircularReferenceDetect) {
            return null;
        }
        this.contex = new com.alibaba.fastjson.parser.ParseContext(parseContext, obj, obj2);
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        com.alibaba.fastjson.parser.ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new com.alibaba.fastjson.parser.ParseContext[8];
        } else if (i >= parseContextArr.length) {
            com.alibaba.fastjson.parser.ParseContext[] parseContextArr2 = new com.alibaba.fastjson.parser.ParseContext[(parseContextArr.length * 3) / 2];
            java.lang.System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        com.alibaba.fastjson.parser.ParseContext[] parseContextArr3 = this.contextArray;
        com.alibaba.fastjson.parser.ParseContext parseContext2 = this.contex;
        parseContextArr3[i] = parseContext2;
        return parseContext2;
    }

    public void setContext(com.alibaba.fastjson.parser.ParseContext parseContext) {
        if (this.lexer.disableCircularReferenceDetect) {
            return;
        }
        this.contex = parseContext;
    }

    public void setDateFomrat(java.text.DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(java.lang.String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }
}
