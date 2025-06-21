package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
public class JavaBeanDeserializer implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    private final java.util.Map<java.lang.String, com.alibaba.fastjson.parser.deserializer.FieldDeserializer> alterNameFieldDeserializers;
    public final com.alibaba.fastjson.parser.JavaBeanInfo beanInfo;
    protected final java.lang.Class<?> clazz;
    private java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Object> extraFieldDeserializers;
    private final com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] fieldDeserializers;
    private transient long[] smartMatchHashArray;
    private transient int[] smartMatchHashArrayMapping;
    private final com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(com.alibaba.fastjson.parser.ParserConfig parserConfig, java.lang.Class<?> cls, java.lang.reflect.Type type) {
        this(parserConfig, cls, type, com.alibaba.fastjson.parser.JavaBeanInfo.build(cls, cls.getModifiers(), type, false, true, true, true, parserConfig.propertyNamingStrategy));
    }

    public JavaBeanDeserializer(com.alibaba.fastjson.parser.ParserConfig parserConfig, java.lang.Class<?> cls, java.lang.reflect.Type type, com.alibaba.fastjson.parser.JavaBeanInfo javaBeanInfo) {
        this.clazz = cls;
        this.beanInfo = javaBeanInfo;
        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new com.alibaba.fastjson.parser.deserializer.FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        java.util.HashMap hashMap = null;
        for (int i = 0; i < length; i++) {
            com.alibaba.fastjson.util.FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, cls, fieldInfo);
            this.sortedFieldDeserializers[i] = createFieldDeserializer;
            for (java.lang.String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new java.util.HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new com.alibaba.fastjson.parser.deserializer.FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0307, code lost:
    
        r10.nextTokenWithChar(':');
        r0 = r10.token;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x030d, code lost:
    
        if (r0 != 4) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x030f, code lost:
    
        r0 = r10.stringVal();
        r1 = "@".equals(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0319, code lost:
    
        if (r1 == 0) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x031b, code lost:
    
        r1 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x031f, code lost:
    
        r2 = (T) r1.object;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0377, code lost:
    
        r10.nextToken(13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x037c, code lost:
    
        if (r10.token != 13) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x037e, code lost:
    
        r10.nextToken(16);
        r41.setContext(r1, r2, r43);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0386, code lost:
    
        r3 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0388, code lost:
    
        if (r3 == null) goto L268;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x038a, code lost:
    
        r3.object = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x038c, code lost:
    
        r41.setContext(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x038f, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0390, code lost:
    
        r3 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0399, code lost:
    
        throw new com.alibaba.fastjson.JSONException("illegal ref");
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x039a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x039f, code lost:
    
        r11 = r1;
        r10 = r2;
        r12 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x07a6, code lost:
    
        r12.object = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x039c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x039d, code lost:
    
        r3 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0328, code lost:
    
        r1 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0330, code lost:
    
        if ("..".equals(r0) == false) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0332, code lost:
    
        r2 = r1.parent;
        r3 = r2.object;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0336, code lost:
    
        if (r3 == null) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0338, code lost:
    
        r31 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0346, code lost:
    
        r2 = (T) r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x033b, code lost:
    
        r41.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r2, r0));
        r41.resolveStatus = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x034f, code lost:
    
        if ("$".equals(r0) == false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0351, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0352, code lost:
    
        r3 = r2.parent;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0354, code lost:
    
        if (r3 == null) goto L627;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0356, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0358, code lost:
    
        r3 = r2.object;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x035a, code lost:
    
        if (r3 == null) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x035d, code lost:
    
        r41.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r2, r0));
        r41.resolveStatus = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0369, code lost:
    
        r41.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r1, r0));
        r41.resolveStatus = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03a6, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x03a7, code lost:
    
        r3 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03ca, code lost:
    
        r11 = r1;
        r12 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0321, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0322, code lost:
    
        r11 = r1;
        r12 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03aa, code lost:
    
        r3 = r20;
        r1 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03c8, code lost:
    
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03c9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0793, code lost:
    
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r0.token));
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0676, code lost:
    
        r31 = r10;
        r0 = r21;
        r1 = r37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x067c, code lost:
    
        if (r31 != null) goto L523;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0752, code lost:
    
        r3 = (T) r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0754, code lost:
    
        if (r1 == null) goto L526;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0756, code lost:
    
        r1.object = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0758, code lost:
    
        r41.setContext(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x075b, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x067e, code lost:
    
        if (r0 != null) goto L482;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0680, code lost:
    
        r2 = (T) createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r41, r42);
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0684, code lost:
    
        if (r1 != null) goto L478;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0690, code lost:
    
        if (r1 == null) goto L480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0692, code lost:
    
        r1.object = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0694, code lost:
    
        r41.setContext(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0697, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0686, code lost:
    
        r1 = r41.setContext(r11, r2, r43);
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x068b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x068c, code lost:
    
        r12 = r1;
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0698, code lost:
    
        r2 = r7.beanInfo.creatorConstructorParameters;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x069c, code lost:
    
        if (r2 == null) goto L485;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x069e, code lost:
    
        r3 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x06a3, code lost:
    
        r4 = new java.lang.Object[r3];
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x06a6, code lost:
    
        if (r6 >= r3) goto L628;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x06a8, code lost:
    
        r5 = r7.fieldDeserializers[r6].fieldInfo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x06ae, code lost:
    
        if (r2 == null) goto L491;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x06b0, code lost:
    
        r9 = r0.remove(r5.name);
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x06bd, code lost:
    
        if (r9 != null) goto L630;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x06bf, code lost:
    
        r9 = com.alibaba.fastjson.util.TypeUtils.defaultValue(r5.fieldClass);
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x06c5, code lost:
    
        r4[r6] = r9;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x06b7, code lost:
    
        r9 = r0.get(r5.name);
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x06ca, code lost:
    
        r3 = r7.beanInfo;
        r5 = r3.creatorConstructor;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x06ce, code lost:
    
        if (r5 == null) goto L512;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0723, code lost:
    
        r0 = r3.factoryMethod;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0725, code lost:
    
        if (r0 == null) goto L523;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0728, code lost:
    
        r31 = r0.invoke(null, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x072d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x074d, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create factory method error, " + r7.beanInfo.factoryMethod.toString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x06d0, code lost:
    
        r3 = (T) r5.newInstance(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x06d4, code lost:
    
        if (r2 == null) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x06d6, code lost:
    
        r0 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x06e2, code lost:
    
        if (r0.hasNext() == false) goto L631;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x06e4, code lost:
    
        r2 = r0.next();
        r4 = r7.getFieldDeserializer(r2.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x06f4, code lost:
    
        if (r4 == null) goto L634;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x06f6, code lost:
    
        r4.setValue(r3, r2.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x06fe, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x06ff, code lost:
    
        r12 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0702, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x0722, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error, " + r7.beanInfo.creatorConstructor.toGenericString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x06a0, code lost:
    
        r3 = r7.fieldDeserializers.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x074e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x074f, code lost:
    
        r12 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x0414, code lost:
    
        r10.nextToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x0417, code lost:
    
        r7 = r40;
        r11 = r1;
        r0 = r21;
        r1 = r37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x02e4, code lost:
    
        r10.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:468:0x02e9, code lost:
    
        r37 = r20;
        r1 = r29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:131:0x07a6  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04db A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x066e  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060 A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #14 {all -> 0x0040, blocks: (B:17:0x0030, B:19:0x0035, B:25:0x004b, B:27:0x0051, B:32:0x0060, B:39:0x006f, B:44:0x007b, B:46:0x0085, B:49:0x008c, B:51:0x00a1, B:52:0x00a9, B:53:0x00b2, B:58:0x00b8), top: B:15:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x03f4 A[Catch: all -> 0x04aa, TRY_LEAVE, TryCatch #5 {all -> 0x04aa, blocks: (B:398:0x03ec, B:400:0x03f4, B:416:0x0436), top: B:397:0x03ec }] */
    /* JADX WARN: Removed duplicated region for block: B:451:0x049a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:474:0x04ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:603:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02d0  */
    /* JADX WARN: Type inference failed for: r0v71, types: [com.alibaba.fastjson.parser.deserializer.ObjectDeserializer] */
    /* JADX WARN: Type inference failed for: r1v47, types: [boolean] */
    /* JADX WARN: Type inference failed for: r41v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj, java.lang.Object obj2) {
        java.lang.Object obj3;
        com.alibaba.fastjson.parser.ParseContext parseContext;
        java.lang.Class<?> cls;
        com.alibaba.fastjson.util.FieldInfo fieldInfo;
        java.lang.Class<?> cls2;
        com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer;
        com.alibaba.fastjson.util.FieldInfo fieldInfo2;
        int i;
        com.alibaba.fastjson.util.FieldInfo fieldInfo3;
        java.lang.Class<?> cls3;
        java.lang.Object obj4;
        com.alibaba.fastjson.parser.ParseContext parseContext2;
        double d;
        int i2;
        float f;
        boolean z;
        boolean z2;
        java.lang.Object obj5;
        com.alibaba.fastjson.parser.ParseContext parseContext3;
        com.alibaba.fastjson.parser.ParseContext parseContext4;
        long j;
        float f2;
        com.alibaba.fastjson.util.FieldInfo fieldInfo4;
        int i3;
        java.lang.String str;
        T t;
        java.lang.String str2;
        java.lang.String str3;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer;
        java.util.HashMap hashMap;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer2;
        int i4;
        java.lang.String str4;
        int i5;
        int i6;
        com.alibaba.fastjson.parser.ParseContext parseContext5;
        java.lang.Object valueOf;
        com.alibaba.fastjson.parser.ParseContext parseContext6;
        java.lang.String stringVal;
        java.lang.Class<?> cls4;
        T t2;
        com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer2;
        java.lang.Object valueOf2;
        java.lang.Enum r1;
        boolean z3;
        boolean z4;
        boolean z5;
        com.alibaba.fastjson.parser.JavaBeanDeserializer javaBeanDeserializer = this;
        java.lang.reflect.Type type2 = type;
        if (type2 == com.alibaba.fastjson.JSON.class || type2 == com.alibaba.fastjson.JSONObject.class) {
            return (T) defaultJSONParser.parse();
        }
        com.alibaba.fastjson.parser.JSONLexer jSONLexer3 = defaultJSONParser.lexer;
        int i7 = jSONLexer3.token;
        com.alibaba.fastjson.parser.ParseContext parseContext7 = null;
        if (i7 == 8) {
            jSONLexer3.nextToken(16);
            return null;
        }
        boolean z6 = jSONLexer3.disableCircularReferenceDetect;
        com.alibaba.fastjson.parser.ParseContext parseContext8 = defaultJSONParser.contex;
        if (obj2 != null && parseContext8 != null) {
            parseContext8 = parseContext8.parent;
        }
        com.alibaba.fastjson.parser.ParseContext parseContext9 = parseContext8;
        try {
            if (i7 == 13) {
                jSONLexer3.nextToken(16);
                T t3 = obj2 == null ? (T) createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) defaultJSONParser, type) : (T) obj2;
                defaultJSONParser.setContext(parseContext9);
                return t3;
            }
            int i8 = 0;
            if (i7 == 14) {
                if (!javaBeanDeserializer.beanInfo.supportBeanToArray && (jSONLexer3.features & com.alibaba.fastjson.parser.Feature.SupportArrayToBean.mask) == 0) {
                    z5 = false;
                    if (z5) {
                        T t4 = (T) deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                        defaultJSONParser.setContext(parseContext9);
                        return t4;
                    }
                }
                z5 = true;
                if (z5) {
                }
            }
            if (i7 != 12 && i7 != 16) {
                if (jSONLexer3.isBlankInput()) {
                    defaultJSONParser.setContext(parseContext9);
                    return null;
                }
                if (i7 == 4 && jSONLexer3.stringVal().length() == 0) {
                    jSONLexer3.nextToken();
                    defaultJSONParser.setContext(parseContext9);
                    return null;
                }
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                stringBuffer.append("syntax error, expect {, actual ");
                stringBuffer.append(jSONLexer3.info());
                if (obj instanceof java.lang.String) {
                    stringBuffer.append(", fieldName ");
                    stringBuffer.append(obj);
                }
                throw new com.alibaba.fastjson.JSONException(stringBuffer.toString());
            }
            try {
                if (defaultJSONParser.resolveStatus == 2) {
                    defaultJSONParser.resolveStatus = 0;
                }
                java.lang.String str5 = javaBeanDeserializer.beanInfo.typeKey;
                int length = javaBeanDeserializer.sortedFieldDeserializers.length;
                java.lang.Object obj6 = obj2;
                com.alibaba.fastjson.parser.ParseContext parseContext10 = null;
                java.util.HashMap hashMap2 = null;
                long j2 = 0;
                while (true) {
                    if (j2 != 0) {
                        try {
                            com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializerByHash = javaBeanDeserializer.getFieldDeserializerByHash(j2);
                            if (fieldDeserializerByHash != null) {
                                fieldInfo = fieldDeserializerByHash.fieldInfo;
                                cls = fieldInfo.fieldClass;
                            } else {
                                cls = null;
                                fieldInfo = null;
                            }
                            cls2 = cls;
                            fieldDeserializer = fieldDeserializerByHash;
                            fieldInfo2 = fieldInfo;
                            j2 = 0;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            obj3 = obj6;
                            parseContext = parseContext9;
                            parseContext7 = parseContext10;
                            if (parseContext7 != null) {
                            }
                            defaultJSONParser.setContext(parseContext);
                            throw th;
                        }
                    } else {
                        fieldDeserializer = null;
                        fieldInfo2 = null;
                        cls2 = null;
                    }
                    if (fieldDeserializer == null) {
                        if (i8 < length) {
                            fieldDeserializer = javaBeanDeserializer.sortedFieldDeserializers[i8];
                            fieldInfo3 = fieldDeserializer.fieldInfo;
                            i = i8 + 1;
                            cls3 = fieldInfo3.fieldClass;
                            int i9 = length;
                            int i10 = i;
                            long j3 = j2;
                            double d2 = 0.0d;
                            if (fieldDeserializer == null) {
                                parseContext2 = parseContext9;
                                try {
                                    long j4 = fieldInfo3.nameHashCode;
                                    obj4 = obj6;
                                    try {
                                        if (cls3 != java.lang.Integer.TYPE && cls3 != java.lang.Integer.class) {
                                            if (cls3 != java.lang.Long.TYPE && cls3 != java.lang.Long.class) {
                                                if (cls3 == java.lang.String.class) {
                                                    valueOf2 = jSONLexer3.scanFieldString(j4);
                                                    int i11 = jSONLexer3.matchStat;
                                                    if (i11 <= 0) {
                                                        if (i11 == -2) {
                                                            j2 = jSONLexer3.fieldHash;
                                                            javaBeanDeserializer = this;
                                                            i8 = i10;
                                                            length = i9;
                                                            parseContext9 = parseContext2;
                                                            obj6 = obj4;
                                                        }
                                                        obj5 = valueOf2;
                                                        d = 0.0d;
                                                        f = 0.0f;
                                                        i2 = 0;
                                                        z = false;
                                                        z2 = false;
                                                        j = 0;
                                                        if (z) {
                                                            fieldInfo4 = fieldInfo3;
                                                            try {
                                                                str = jSONLexer3.scanSymbol(defaultJSONParser.symbolTable);
                                                                if (str == null) {
                                                                    i3 = i2;
                                                                    int i12 = jSONLexer3.token;
                                                                    f2 = f;
                                                                    if (i12 == 13) {
                                                                        break;
                                                                    }
                                                                    if (i12 == 16) {
                                                                        parseContext3 = parseContext10;
                                                                        parseContext4 = parseContext2;
                                                                        javaBeanDeserializer = this;
                                                                        i8 = i10;
                                                                        parseContext9 = parseContext4;
                                                                        length = i9;
                                                                        j2 = j3;
                                                                        obj6 = obj4;
                                                                        parseContext10 = parseContext3;
                                                                    }
                                                                } else {
                                                                    f2 = f;
                                                                    i3 = i2;
                                                                }
                                                                if ("$ref" == str && parseContext2 != null) {
                                                                    try {
                                                                        break;
                                                                    } catch (java.lang.Throwable th2) {
                                                                        th = th2;
                                                                        parseContext7 = parseContext10;
                                                                        parseContext = parseContext2;
                                                                        obj3 = obj4;
                                                                        if (parseContext7 != null) {
                                                                        }
                                                                        defaultJSONParser.setContext(parseContext);
                                                                        throw th;
                                                                    }
                                                                }
                                                                parseContext3 = parseContext10;
                                                                parseContext4 = parseContext2;
                                                                if (str5 != null) {
                                                                    try {
                                                                        if (str5.equals(str)) {
                                                                            try {
                                                                                jSONLexer3.nextTokenWithChar(':');
                                                                                if (jSONLexer3.token == 4) {
                                                                                    t = (T) obj4;
                                                                                    parseContext6 = parseContext3;
                                                                                    try {
                                                                                        throw new com.alibaba.fastjson.JSONException("syntax error");
                                                                                    } catch (java.lang.Throwable th3) {
                                                                                        th = th3;
                                                                                        parseContext = parseContext4;
                                                                                        parseContext7 = parseContext6;
                                                                                        obj3 = t;
                                                                                        if (parseContext7 != null) {
                                                                                        }
                                                                                        defaultJSONParser.setContext(parseContext);
                                                                                        throw th;
                                                                                    }
                                                                                }
                                                                                stringVal = jSONLexer3.stringVal();
                                                                                jSONLexer3.nextToken(16);
                                                                                if (!(type2 instanceof java.lang.Class) || !stringVal.equals(((java.lang.Class) type2).getName())) {
                                                                                    break;
                                                                                }
                                                                                if (jSONLexer3.token == 13) {
                                                                                    break;
                                                                                }
                                                                                javaBeanDeserializer = this;
                                                                                i8 = i10;
                                                                                parseContext9 = parseContext4;
                                                                                length = i9;
                                                                                j2 = j3;
                                                                                obj6 = obj4;
                                                                                parseContext10 = parseContext3;
                                                                            } catch (java.lang.Throwable th4) {
                                                                                th = th4;
                                                                            }
                                                                        }
                                                                    } catch (java.lang.Throwable th5) {
                                                                        th = th5;
                                                                        parseContext = parseContext4;
                                                                        obj3 = obj4;
                                                                        parseContext7 = parseContext3;
                                                                        if (parseContext7 != null) {
                                                                        }
                                                                        defaultJSONParser.setContext(parseContext);
                                                                        throw th;
                                                                    }
                                                                }
                                                                if (com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY == str) {
                                                                    jSONLexer3.nextTokenWithChar(':');
                                                                    if (jSONLexer3.token == 4) {
                                                                    }
                                                                } else {
                                                                    javaBeanDeserializer = this;
                                                                }
                                                            } catch (java.lang.Throwable th6) {
                                                                th = th6;
                                                                parseContext3 = parseContext10;
                                                                parseContext = parseContext2;
                                                                obj3 = obj4;
                                                                parseContext7 = parseContext3;
                                                                if (parseContext7 != null) {
                                                                }
                                                                defaultJSONParser.setContext(parseContext);
                                                                throw th;
                                                            }
                                                        } else {
                                                            f2 = f;
                                                            fieldInfo4 = fieldInfo3;
                                                            i3 = i2;
                                                            parseContext3 = parseContext10;
                                                            parseContext4 = parseContext2;
                                                            javaBeanDeserializer = this;
                                                            str = null;
                                                        }
                                                        if (obj4 == null || hashMap2 != null) {
                                                            str2 = str5;
                                                            str3 = str;
                                                            jSONLexer = jSONLexer3;
                                                            hashMap = hashMap2;
                                                            obj3 = obj4;
                                                        } else {
                                                            str2 = str5;
                                                            try {
                                                                java.lang.Object createInstance = createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) defaultJSONParser, type);
                                                                if (createInstance == null) {
                                                                    str3 = str;
                                                                    try {
                                                                        jSONLexer = jSONLexer3;
                                                                        hashMap2 = new java.util.HashMap(javaBeanDeserializer.fieldDeserializers.length);
                                                                    } catch (java.lang.Throwable th7) {
                                                                        th = th7;
                                                                        parseContext = parseContext4;
                                                                        obj3 = createInstance;
                                                                        parseContext7 = parseContext3;
                                                                        if (parseContext7 != null) {
                                                                        }
                                                                        defaultJSONParser.setContext(parseContext);
                                                                        throw th;
                                                                    }
                                                                } else {
                                                                    str3 = str;
                                                                    jSONLexer = jSONLexer3;
                                                                }
                                                                if (z6) {
                                                                    obj3 = createInstance;
                                                                } else {
                                                                    obj3 = createInstance;
                                                                    parseContext3 = defaultJSONParser.setContext(parseContext4, createInstance, obj);
                                                                }
                                                                hashMap = hashMap2;
                                                            } catch (java.lang.Throwable th8) {
                                                                th = th8;
                                                                parseContext = parseContext4;
                                                                obj3 = obj4;
                                                                parseContext7 = parseContext3;
                                                                if (parseContext7 != null) {
                                                                }
                                                                defaultJSONParser.setContext(parseContext);
                                                                throw th;
                                                            }
                                                        }
                                                        if (z) {
                                                            parseContext = parseContext4;
                                                            jSONLexer2 = jSONLexer;
                                                            i4 = i9;
                                                            str4 = str2;
                                                            hashMap2 = hashMap;
                                                            i5 = 1;
                                                            if (parseField(defaultJSONParser, str3, obj3, type, hashMap2)) {
                                                                if (jSONLexer2.token == 17) {
                                                                    throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token ':'");
                                                                }
                                                                i6 = jSONLexer2.token;
                                                                if (i6 != 16) {
                                                                }
                                                            } else {
                                                                if (jSONLexer2.token == 13) {
                                                                    jSONLexer2.nextToken();
                                                                    break;
                                                                }
                                                                i8 = i10;
                                                                obj6 = obj3;
                                                                parseContext9 = parseContext;
                                                                length = i4;
                                                                str5 = str4;
                                                                j2 = j3;
                                                                parseContext10 = parseContext3;
                                                                jSONLexer3 = jSONLexer2;
                                                                type2 = type;
                                                            }
                                                        } else {
                                                            if (z2) {
                                                                if (obj3 == null) {
                                                                    if (cls3 != java.lang.Integer.TYPE && cls3 != java.lang.Integer.class) {
                                                                        if (cls3 != java.lang.Long.TYPE && cls3 != java.lang.Long.class) {
                                                                            if (cls3 != java.lang.Float.TYPE && cls3 != java.lang.Float.class) {
                                                                                if (cls3 != java.lang.Double.TYPE && cls3 != java.lang.Double.class) {
                                                                                    valueOf = obj5;
                                                                                    hashMap.put(fieldInfo4.name, valueOf);
                                                                                    parseContext5 = parseContext4;
                                                                                }
                                                                                valueOf = new java.lang.Double(d);
                                                                                hashMap.put(fieldInfo4.name, valueOf);
                                                                                parseContext5 = parseContext4;
                                                                            }
                                                                            valueOf = new java.lang.Float(f2);
                                                                            hashMap.put(fieldInfo4.name, valueOf);
                                                                            parseContext5 = parseContext4;
                                                                        }
                                                                        valueOf = java.lang.Long.valueOf(j);
                                                                        hashMap.put(fieldInfo4.name, valueOf);
                                                                        parseContext5 = parseContext4;
                                                                    }
                                                                    valueOf = java.lang.Integer.valueOf(i3);
                                                                    hashMap.put(fieldInfo4.name, valueOf);
                                                                    parseContext5 = parseContext4;
                                                                } else {
                                                                    parseContext5 = parseContext4;
                                                                    double d3 = d;
                                                                    com.alibaba.fastjson.util.FieldInfo fieldInfo5 = fieldInfo4;
                                                                    float f3 = f2;
                                                                    if (obj5 == null) {
                                                                        try {
                                                                            try {
                                                                                java.lang.Class<?> cls5 = java.lang.Integer.TYPE;
                                                                                if (cls3 != cls5 && cls3 != java.lang.Integer.class) {
                                                                                    java.lang.Class<?> cls6 = java.lang.Long.TYPE;
                                                                                    if (cls3 != cls6 && cls3 != java.lang.Long.class) {
                                                                                        java.lang.Class<?> cls7 = java.lang.Float.TYPE;
                                                                                        if (cls3 != cls7 && cls3 != java.lang.Float.class) {
                                                                                            java.lang.Class<?> cls8 = java.lang.Double.TYPE;
                                                                                            if (cls3 != cls8 && cls3 != java.lang.Double.class) {
                                                                                                fieldDeserializer.setValue(obj3, obj5);
                                                                                            }
                                                                                            if (fieldInfo5.fieldAccess && cls3 == cls8) {
                                                                                                fieldDeserializer.setValue(obj3, d3);
                                                                                            } else {
                                                                                                fieldDeserializer.setValue(obj3, new java.lang.Double(d3));
                                                                                            }
                                                                                        }
                                                                                        if (fieldInfo5.fieldAccess && cls3 == cls7) {
                                                                                            fieldDeserializer.setValue(obj3, f3);
                                                                                        } else {
                                                                                            fieldDeserializer.setValue(obj3, new java.lang.Float(f3));
                                                                                        }
                                                                                    }
                                                                                    if (fieldInfo5.fieldAccess && cls3 == cls6) {
                                                                                        fieldDeserializer.setValue(obj3, j);
                                                                                    } else {
                                                                                        fieldDeserializer.setValue(obj3, java.lang.Long.valueOf(j));
                                                                                    }
                                                                                }
                                                                                if (fieldInfo5.fieldAccess && cls3 == cls5) {
                                                                                    fieldDeserializer.setValue(obj3, i3);
                                                                                } else {
                                                                                    fieldDeserializer.setValue(obj3, java.lang.Integer.valueOf(i3));
                                                                                }
                                                                            } catch (java.lang.Throwable th9) {
                                                                                th = th9;
                                                                                parseContext = parseContext5;
                                                                                parseContext7 = parseContext3;
                                                                                if (parseContext7 != null) {
                                                                                }
                                                                                defaultJSONParser.setContext(parseContext);
                                                                                throw th;
                                                                            }
                                                                        } catch (java.lang.IllegalAccessException e) {
                                                                            throw new com.alibaba.fastjson.JSONException("set property error, " + fieldInfo5.name, e);
                                                                        }
                                                                    } else {
                                                                        fieldDeserializer.setValue(obj3, obj5);
                                                                    }
                                                                }
                                                                jSONLexer2 = jSONLexer;
                                                                parseContext = parseContext5;
                                                                if (jSONLexer2.matchStat == 4) {
                                                                    hashMap2 = hashMap;
                                                                    break;
                                                                }
                                                                str4 = str2;
                                                                i4 = i9;
                                                                i5 = 1;
                                                                hashMap2 = hashMap;
                                                            } else {
                                                                try {
                                                                    fieldDeserializer.parseField(defaultJSONParser, obj3, type2, hashMap);
                                                                    parseContext = parseContext4;
                                                                    hashMap2 = hashMap;
                                                                    str4 = str2;
                                                                    i4 = i9;
                                                                    jSONLexer2 = jSONLexer;
                                                                    i5 = 1;
                                                                } catch (java.lang.Throwable th10) {
                                                                    th = th10;
                                                                    parseContext = parseContext4;
                                                                    parseContext7 = parseContext3;
                                                                    if (parseContext7 != null) {
                                                                    }
                                                                    defaultJSONParser.setContext(parseContext);
                                                                    throw th;
                                                                }
                                                            }
                                                            try {
                                                                i6 = jSONLexer2.token;
                                                                if (i6 != 16) {
                                                                    i8 = i10;
                                                                    obj6 = obj3;
                                                                    parseContext9 = parseContext;
                                                                    length = i4;
                                                                    str5 = str4;
                                                                    j2 = j3;
                                                                    parseContext10 = parseContext3;
                                                                    jSONLexer3 = jSONLexer2;
                                                                    type2 = type;
                                                                } else {
                                                                    if (i6 == 13) {
                                                                        jSONLexer2.nextToken(16);
                                                                        break;
                                                                    }
                                                                    if (i6 == 18 || i6 == i5) {
                                                                        break;
                                                                    }
                                                                    i8 = i10;
                                                                    obj6 = obj3;
                                                                    parseContext9 = parseContext;
                                                                    length = i4;
                                                                    str5 = str4;
                                                                    j2 = j3;
                                                                    parseContext10 = parseContext3;
                                                                    jSONLexer3 = jSONLexer2;
                                                                    type2 = type;
                                                                }
                                                            } catch (java.lang.Throwable th11) {
                                                                th = th11;
                                                                parseContext7 = parseContext3;
                                                                if (parseContext7 != null) {
                                                                }
                                                                defaultJSONParser.setContext(parseContext);
                                                                throw th;
                                                            }
                                                        }
                                                    }
                                                    obj5 = valueOf2;
                                                    d = 0.0d;
                                                    f = 0.0f;
                                                    i2 = 0;
                                                    z = true;
                                                    z2 = true;
                                                    j = 0;
                                                    if (z) {
                                                    }
                                                    if (obj4 == null) {
                                                    }
                                                    str2 = str5;
                                                    str3 = str;
                                                    jSONLexer = jSONLexer3;
                                                    hashMap = hashMap2;
                                                    obj3 = obj4;
                                                    if (z) {
                                                    }
                                                } else if (cls3 == java.util.Date.class) {
                                                    valueOf2 = jSONLexer3.scanFieldDate(j4);
                                                    int i13 = jSONLexer3.matchStat;
                                                    if (i13 > 0) {
                                                        obj5 = valueOf2;
                                                        d = 0.0d;
                                                        f = 0.0f;
                                                        i2 = 0;
                                                        z = true;
                                                        z2 = true;
                                                        j = 0;
                                                        if (z) {
                                                        }
                                                        if (obj4 == null) {
                                                        }
                                                        str2 = str5;
                                                        str3 = str;
                                                        jSONLexer = jSONLexer3;
                                                        hashMap = hashMap2;
                                                        obj3 = obj4;
                                                        if (z) {
                                                        }
                                                    } else {
                                                        if (i13 == -2) {
                                                            j2 = jSONLexer3.fieldHash;
                                                            javaBeanDeserializer = this;
                                                            i8 = i10;
                                                            length = i9;
                                                            parseContext9 = parseContext2;
                                                            obj6 = obj4;
                                                        }
                                                        obj5 = valueOf2;
                                                        d = 0.0d;
                                                        f = 0.0f;
                                                        i2 = 0;
                                                        z = false;
                                                        z2 = false;
                                                        j = 0;
                                                        if (z) {
                                                        }
                                                        if (obj4 == null) {
                                                        }
                                                        str2 = str5;
                                                        str3 = str;
                                                        jSONLexer = jSONLexer3;
                                                        hashMap = hashMap2;
                                                        obj3 = obj4;
                                                        if (z) {
                                                        }
                                                    }
                                                } else {
                                                    if (cls3 != java.lang.Boolean.TYPE && cls3 != java.lang.Boolean.class) {
                                                        if (cls3 != java.lang.Float.TYPE && cls3 != java.lang.Float.class) {
                                                            if (cls3 != java.lang.Double.TYPE && cls3 != java.lang.Double.class) {
                                                                if (fieldInfo3.isEnum && (defaultJSONParser.config.getDeserializer(cls3) instanceof com.alibaba.fastjson.parser.EnumDeserializer)) {
                                                                    long scanFieldSymbol = jSONLexer3.scanFieldSymbol(j4);
                                                                    int i14 = jSONLexer3.matchStat;
                                                                    if (i14 > 0) {
                                                                        r1 = fieldDeserializer.getEnumByHashCode(scanFieldSymbol);
                                                                        z3 = true;
                                                                        z4 = true;
                                                                    } else if (i14 == -2) {
                                                                        j2 = jSONLexer3.fieldHash;
                                                                    } else {
                                                                        r1 = null;
                                                                        z3 = false;
                                                                        z4 = false;
                                                                    }
                                                                    obj5 = r1;
                                                                    z2 = z4;
                                                                    d = 0.0d;
                                                                    f = 0.0f;
                                                                    z = z3;
                                                                    j = 0;
                                                                    i2 = 0;
                                                                    if (z) {
                                                                    }
                                                                    if (obj4 == null) {
                                                                    }
                                                                    str2 = str5;
                                                                    str3 = str;
                                                                    jSONLexer = jSONLexer3;
                                                                    hashMap = hashMap2;
                                                                    obj3 = obj4;
                                                                    if (z) {
                                                                    }
                                                                } else if (cls3 == int[].class) {
                                                                    valueOf2 = jSONLexer3.scanFieldIntArray(j4);
                                                                    int i15 = jSONLexer3.matchStat;
                                                                    if (i15 > 0) {
                                                                        obj5 = valueOf2;
                                                                        d = 0.0d;
                                                                        f = 0.0f;
                                                                        i2 = 0;
                                                                        z = true;
                                                                        z2 = true;
                                                                        j = 0;
                                                                        if (z) {
                                                                        }
                                                                        if (obj4 == null) {
                                                                        }
                                                                        str2 = str5;
                                                                        str3 = str;
                                                                        jSONLexer = jSONLexer3;
                                                                        hashMap = hashMap2;
                                                                        obj3 = obj4;
                                                                        if (z) {
                                                                        }
                                                                    } else {
                                                                        if (i15 == -2) {
                                                                            j2 = jSONLexer3.fieldHash;
                                                                        }
                                                                        obj5 = valueOf2;
                                                                        d = 0.0d;
                                                                        f = 0.0f;
                                                                        i2 = 0;
                                                                        z = false;
                                                                        z2 = false;
                                                                        j = 0;
                                                                        if (z) {
                                                                        }
                                                                        if (obj4 == null) {
                                                                        }
                                                                        str2 = str5;
                                                                        str3 = str;
                                                                        jSONLexer = jSONLexer3;
                                                                        hashMap = hashMap2;
                                                                        obj3 = obj4;
                                                                        if (z) {
                                                                        }
                                                                    }
                                                                } else if (cls3 == float[].class) {
                                                                    valueOf2 = jSONLexer3.scanFieldFloatArray(j4);
                                                                    int i16 = jSONLexer3.matchStat;
                                                                    if (i16 > 0) {
                                                                        obj5 = valueOf2;
                                                                        d = 0.0d;
                                                                        f = 0.0f;
                                                                        i2 = 0;
                                                                        z = true;
                                                                        z2 = true;
                                                                        j = 0;
                                                                        if (z) {
                                                                        }
                                                                        if (obj4 == null) {
                                                                        }
                                                                        str2 = str5;
                                                                        str3 = str;
                                                                        jSONLexer = jSONLexer3;
                                                                        hashMap = hashMap2;
                                                                        obj3 = obj4;
                                                                        if (z) {
                                                                        }
                                                                    } else {
                                                                        if (i16 == -2) {
                                                                            j2 = jSONLexer3.fieldHash;
                                                                        }
                                                                        obj5 = valueOf2;
                                                                        d = 0.0d;
                                                                        f = 0.0f;
                                                                        i2 = 0;
                                                                        z = false;
                                                                        z2 = false;
                                                                        j = 0;
                                                                        if (z) {
                                                                        }
                                                                        if (obj4 == null) {
                                                                        }
                                                                        str2 = str5;
                                                                        str3 = str;
                                                                        jSONLexer = jSONLexer3;
                                                                        hashMap = hashMap2;
                                                                        obj3 = obj4;
                                                                        if (z) {
                                                                        }
                                                                    }
                                                                } else if (cls3 == double[].class) {
                                                                    valueOf2 = jSONLexer3.scanFieldDoubleArray(j4);
                                                                    int i17 = jSONLexer3.matchStat;
                                                                    if (i17 > 0) {
                                                                        obj5 = valueOf2;
                                                                        d = 0.0d;
                                                                        f = 0.0f;
                                                                        i2 = 0;
                                                                        z = true;
                                                                        z2 = true;
                                                                        j = 0;
                                                                        if (z) {
                                                                        }
                                                                        if (obj4 == null) {
                                                                        }
                                                                        str2 = str5;
                                                                        str3 = str;
                                                                        jSONLexer = jSONLexer3;
                                                                        hashMap = hashMap2;
                                                                        obj3 = obj4;
                                                                        if (z) {
                                                                        }
                                                                    } else {
                                                                        if (i17 == -2) {
                                                                            j2 = jSONLexer3.fieldHash;
                                                                        }
                                                                        obj5 = valueOf2;
                                                                        d = 0.0d;
                                                                        f = 0.0f;
                                                                        i2 = 0;
                                                                        z = false;
                                                                        z2 = false;
                                                                        j = 0;
                                                                        if (z) {
                                                                        }
                                                                        if (obj4 == null) {
                                                                        }
                                                                        str2 = str5;
                                                                        str3 = str;
                                                                        jSONLexer = jSONLexer3;
                                                                        hashMap = hashMap2;
                                                                        obj3 = obj4;
                                                                        if (z) {
                                                                        }
                                                                    }
                                                                } else if (cls3 == float[][].class) {
                                                                    valueOf2 = jSONLexer3.scanFieldFloatArray2(j4);
                                                                    int i18 = jSONLexer3.matchStat;
                                                                    if (i18 > 0) {
                                                                        obj5 = valueOf2;
                                                                        d = 0.0d;
                                                                        f = 0.0f;
                                                                        i2 = 0;
                                                                        z = true;
                                                                        z2 = true;
                                                                        j = 0;
                                                                        if (z) {
                                                                        }
                                                                        if (obj4 == null) {
                                                                        }
                                                                        str2 = str5;
                                                                        str3 = str;
                                                                        jSONLexer = jSONLexer3;
                                                                        hashMap = hashMap2;
                                                                        obj3 = obj4;
                                                                        if (z) {
                                                                        }
                                                                    } else {
                                                                        if (i18 == -2) {
                                                                            j2 = jSONLexer3.fieldHash;
                                                                        }
                                                                        obj5 = valueOf2;
                                                                        d = 0.0d;
                                                                        f = 0.0f;
                                                                        i2 = 0;
                                                                        z = false;
                                                                        z2 = false;
                                                                        j = 0;
                                                                        if (z) {
                                                                        }
                                                                        if (obj4 == null) {
                                                                        }
                                                                        str2 = str5;
                                                                        str3 = str;
                                                                        jSONLexer = jSONLexer3;
                                                                        hashMap = hashMap2;
                                                                        obj3 = obj4;
                                                                        if (z) {
                                                                        }
                                                                    }
                                                                } else if (cls3 == double[][].class) {
                                                                    valueOf2 = jSONLexer3.scanFieldDoubleArray2(j4);
                                                                    int i19 = jSONLexer3.matchStat;
                                                                    if (i19 > 0) {
                                                                        obj5 = valueOf2;
                                                                        d = 0.0d;
                                                                        f = 0.0f;
                                                                        i2 = 0;
                                                                        z = true;
                                                                        z2 = true;
                                                                        j = 0;
                                                                        if (z) {
                                                                        }
                                                                        if (obj4 == null) {
                                                                        }
                                                                        str2 = str5;
                                                                        str3 = str;
                                                                        jSONLexer = jSONLexer3;
                                                                        hashMap = hashMap2;
                                                                        obj3 = obj4;
                                                                        if (z) {
                                                                        }
                                                                    } else {
                                                                        if (i19 == -2) {
                                                                            j2 = jSONLexer3.fieldHash;
                                                                        }
                                                                        obj5 = valueOf2;
                                                                        d = 0.0d;
                                                                        f = 0.0f;
                                                                        i2 = 0;
                                                                        z = false;
                                                                        z2 = false;
                                                                        j = 0;
                                                                        if (z) {
                                                                        }
                                                                        if (obj4 == null) {
                                                                        }
                                                                        str2 = str5;
                                                                        str3 = str;
                                                                        jSONLexer = jSONLexer3;
                                                                        hashMap = hashMap2;
                                                                        obj3 = obj4;
                                                                        if (z) {
                                                                        }
                                                                    }
                                                                } else if (jSONLexer3.matchField(fieldInfo3.nameHashCode)) {
                                                                    d = 0.0d;
                                                                    f = 0.0f;
                                                                    i2 = 0;
                                                                    z = true;
                                                                    z2 = false;
                                                                    obj5 = null;
                                                                    j = 0;
                                                                    if (z) {
                                                                    }
                                                                    if (obj4 == null) {
                                                                    }
                                                                    str2 = str5;
                                                                    str3 = str;
                                                                    jSONLexer = jSONLexer3;
                                                                    hashMap = hashMap2;
                                                                    obj3 = obj4;
                                                                    if (z) {
                                                                    }
                                                                } else {
                                                                    parseContext3 = parseContext10;
                                                                    parseContext4 = parseContext2;
                                                                    javaBeanDeserializer = this;
                                                                    i8 = i10;
                                                                    parseContext9 = parseContext4;
                                                                    length = i9;
                                                                    j2 = j3;
                                                                    obj6 = obj4;
                                                                    parseContext10 = parseContext3;
                                                                }
                                                                javaBeanDeserializer = this;
                                                                i8 = i10;
                                                                length = i9;
                                                                parseContext9 = parseContext2;
                                                                obj6 = obj4;
                                                            }
                                                            d2 = jSONLexer3.scanFieldDouble(j4);
                                                            int i20 = jSONLexer3.matchStat;
                                                            if (i20 > 0) {
                                                                d = d2;
                                                                f = 0.0f;
                                                                i2 = 0;
                                                                z = true;
                                                                z2 = true;
                                                                obj5 = null;
                                                                j = 0;
                                                                if (z) {
                                                                }
                                                                if (obj4 == null) {
                                                                }
                                                                str2 = str5;
                                                                str3 = str;
                                                                jSONLexer = jSONLexer3;
                                                                hashMap = hashMap2;
                                                                obj3 = obj4;
                                                                if (z) {
                                                                }
                                                            } else if (i20 == -2) {
                                                                j2 = jSONLexer3.fieldHash;
                                                                javaBeanDeserializer = this;
                                                                i8 = i10;
                                                                length = i9;
                                                                parseContext9 = parseContext2;
                                                                obj6 = obj4;
                                                            }
                                                        }
                                                        float scanFieldFloat = jSONLexer3.scanFieldFloat(j4);
                                                        int i21 = jSONLexer3.matchStat;
                                                        if (i21 > 0) {
                                                            f = scanFieldFloat;
                                                            d = 0.0d;
                                                            i2 = 0;
                                                            z = true;
                                                            z2 = true;
                                                            obj5 = null;
                                                            j = 0;
                                                            if (z) {
                                                            }
                                                            if (obj4 == null) {
                                                            }
                                                            str2 = str5;
                                                            str3 = str;
                                                            jSONLexer = jSONLexer3;
                                                            hashMap = hashMap2;
                                                            obj3 = obj4;
                                                            if (z) {
                                                            }
                                                        } else if (i21 == -2) {
                                                            j2 = jSONLexer3.fieldHash;
                                                            javaBeanDeserializer = this;
                                                            i8 = i10;
                                                            length = i9;
                                                            parseContext9 = parseContext2;
                                                            obj6 = obj4;
                                                        } else {
                                                            f = scanFieldFloat;
                                                            d = 0.0d;
                                                            i2 = 0;
                                                            z = false;
                                                            z2 = false;
                                                            obj5 = null;
                                                            j = 0;
                                                            if (z) {
                                                            }
                                                            if (obj4 == null) {
                                                            }
                                                            str2 = str5;
                                                            str3 = str;
                                                            jSONLexer = jSONLexer3;
                                                            hashMap = hashMap2;
                                                            obj3 = obj4;
                                                            if (z) {
                                                            }
                                                        }
                                                    }
                                                    valueOf2 = java.lang.Boolean.valueOf(jSONLexer3.scanFieldBoolean(j4));
                                                    int i22 = jSONLexer3.matchStat;
                                                    if (i22 > 0) {
                                                        obj5 = valueOf2;
                                                        d = 0.0d;
                                                        f = 0.0f;
                                                        i2 = 0;
                                                        z = true;
                                                        z2 = true;
                                                        j = 0;
                                                        if (z) {
                                                        }
                                                        if (obj4 == null) {
                                                        }
                                                        str2 = str5;
                                                        str3 = str;
                                                        jSONLexer = jSONLexer3;
                                                        hashMap = hashMap2;
                                                        obj3 = obj4;
                                                        if (z) {
                                                        }
                                                    } else {
                                                        if (i22 == -2) {
                                                            j2 = jSONLexer3.fieldHash;
                                                            javaBeanDeserializer = this;
                                                            i8 = i10;
                                                            length = i9;
                                                            parseContext9 = parseContext2;
                                                            obj6 = obj4;
                                                        }
                                                        obj5 = valueOf2;
                                                        d = 0.0d;
                                                        f = 0.0f;
                                                        i2 = 0;
                                                        z = false;
                                                        z2 = false;
                                                        j = 0;
                                                        if (z) {
                                                        }
                                                        if (obj4 == null) {
                                                        }
                                                        str2 = str5;
                                                        str3 = str;
                                                        jSONLexer = jSONLexer3;
                                                        hashMap = hashMap2;
                                                        obj3 = obj4;
                                                        if (z) {
                                                        }
                                                    }
                                                }
                                            }
                                            long scanFieldLong = jSONLexer3.scanFieldLong(j4);
                                            int i23 = jSONLexer3.matchStat;
                                            if (i23 > 0) {
                                                d = 0.0d;
                                                f = 0.0f;
                                                i2 = 0;
                                                obj5 = null;
                                                j = scanFieldLong;
                                                z = true;
                                                z2 = true;
                                            } else if (i23 == -2) {
                                                j2 = jSONLexer3.fieldHash;
                                                javaBeanDeserializer = this;
                                                i8 = i10;
                                                length = i9;
                                                parseContext9 = parseContext2;
                                                obj6 = obj4;
                                            } else {
                                                d = 0.0d;
                                                f = 0.0f;
                                                i2 = 0;
                                                obj5 = null;
                                                j = scanFieldLong;
                                                z = false;
                                                z2 = false;
                                            }
                                            if (z) {
                                            }
                                            if (obj4 == null) {
                                            }
                                            str2 = str5;
                                            str3 = str;
                                            jSONLexer = jSONLexer3;
                                            hashMap = hashMap2;
                                            obj3 = obj4;
                                            if (z) {
                                            }
                                        }
                                        int scanFieldInt = jSONLexer3.scanFieldInt(j4);
                                        int i24 = jSONLexer3.matchStat;
                                        if (i24 > 0) {
                                            i2 = scanFieldInt;
                                            d = 0.0d;
                                            f = 0.0f;
                                            z = true;
                                            z2 = true;
                                            obj5 = null;
                                            j = 0;
                                            if (z) {
                                            }
                                            if (obj4 == null) {
                                            }
                                            str2 = str5;
                                            str3 = str;
                                            jSONLexer = jSONLexer3;
                                            hashMap = hashMap2;
                                            obj3 = obj4;
                                            if (z) {
                                            }
                                        } else if (i24 == -2) {
                                            j2 = jSONLexer3.fieldHash;
                                            javaBeanDeserializer = this;
                                            i8 = i10;
                                            length = i9;
                                            parseContext9 = parseContext2;
                                            obj6 = obj4;
                                        } else {
                                            i2 = scanFieldInt;
                                            d = 0.0d;
                                            f = 0.0f;
                                            z = false;
                                            z2 = false;
                                            obj5 = null;
                                            j = 0;
                                            if (z) {
                                            }
                                            if (obj4 == null) {
                                            }
                                            str2 = str5;
                                            str3 = str;
                                            jSONLexer = jSONLexer3;
                                            hashMap = hashMap2;
                                            obj3 = obj4;
                                            if (z) {
                                            }
                                        }
                                    } catch (java.lang.Throwable th12) {
                                        th = th12;
                                        parseContext7 = parseContext10;
                                        parseContext = parseContext2;
                                        obj3 = obj4;
                                        if (parseContext7 != null) {
                                        }
                                        defaultJSONParser.setContext(parseContext);
                                        throw th;
                                    }
                                } catch (java.lang.Throwable th13) {
                                    th = th13;
                                    obj4 = obj6;
                                    parseContext7 = parseContext10;
                                    parseContext = parseContext2;
                                    obj3 = obj4;
                                    if (parseContext7 != null) {
                                    }
                                    defaultJSONParser.setContext(parseContext);
                                    throw th;
                                }
                            } else {
                                obj4 = obj6;
                                parseContext2 = parseContext9;
                            }
                            d = d2;
                            f = 0.0f;
                            i2 = 0;
                            z = false;
                            z2 = false;
                            obj5 = null;
                            j = 0;
                            if (z) {
                            }
                            if (obj4 == null) {
                            }
                            str2 = str5;
                            str3 = str;
                            jSONLexer = jSONLexer3;
                            hashMap = hashMap2;
                            obj3 = obj4;
                            if (z) {
                            }
                        } else {
                            i8++;
                        }
                    }
                    i = i8;
                    fieldInfo3 = fieldInfo2;
                    cls3 = cls2;
                    int i92 = length;
                    int i102 = i;
                    long j32 = j2;
                    double d22 = 0.0d;
                    if (fieldDeserializer == null) {
                    }
                    d = d22;
                    f = 0.0f;
                    i2 = 0;
                    z = false;
                    z2 = false;
                    obj5 = null;
                    j = 0;
                    if (z) {
                    }
                    if (obj4 == null) {
                    }
                    str2 = str5;
                    str3 = str;
                    jSONLexer = jSONLexer3;
                    hashMap = hashMap2;
                    obj3 = obj4;
                    if (z) {
                    }
                }
                try {
                    com.alibaba.fastjson.parser.JavaBeanDeserializer seeAlso = getSeeAlso(defaultJSONParser.config, this.beanInfo, stringVal);
                    if (seeAlso == null) {
                        java.lang.Class<?> checkAutoType = defaultJSONParser.config.checkAutoType(stringVal, this.clazz, jSONLexer3.features);
                        java.lang.Class<?> cls9 = com.alibaba.fastjson.util.TypeUtils.getClass(type);
                        if (cls9 != null && (checkAutoType == null || !cls9.isAssignableFrom(checkAutoType))) {
                            throw new com.alibaba.fastjson.JSONException("type not match");
                        }
                        seeAlso = defaultJSONParser.config.getDeserializer(checkAutoType);
                        cls4 = checkAutoType;
                    } else {
                        cls4 = null;
                    }
                    if (seeAlso instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) {
                        com.alibaba.fastjson.parser.JavaBeanDeserializer javaBeanDeserializer2 = seeAlso;
                        t2 = (T) javaBeanDeserializer2.deserialze(defaultJSONParser, cls4, obj, null);
                        if (str5 != null && (fieldDeserializer2 = javaBeanDeserializer2.getFieldDeserializer(str5)) != null) {
                            fieldDeserializer2.setValue(t2, stringVal);
                        }
                    } else {
                        t2 = (T) seeAlso.deserialze(defaultJSONParser, cls4, obj);
                    }
                    if (parseContext3 != null) {
                        parseContext3.object = obj4;
                    }
                    defaultJSONParser.setContext(parseContext4);
                    return t2;
                } catch (java.lang.Throwable th14) {
                    th = th14;
                    t = (T) obj4;
                    parseContext6 = parseContext3;
                    parseContext = parseContext4;
                    parseContext7 = parseContext6;
                    obj3 = t;
                    if (parseContext7 != null) {
                    }
                    defaultJSONParser.setContext(parseContext);
                    throw th;
                }
            } catch (java.lang.Throwable th15) {
                th = th15;
                parseContext = parseContext9;
                obj3 = obj2;
            }
        } catch (java.lang.Throwable th16) {
            th = th16;
            obj3 = obj2;
            parseContext = parseContext9;
        }
    }

    private <T> T deserialzeArrayMapping(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj, java.lang.Object obj2) {
        java.lang.Enum r8;
        java.lang.String str;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        T t = (T) createInstance(defaultJSONParser, type);
        int length = this.sortedFieldDeserializers.length;
        int i = 0;
        while (i < length) {
            char c = i == length + (-1) ? ']' : ',';
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
            com.alibaba.fastjson.util.FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
            java.lang.Class<?> cls = fieldInfo.fieldClass;
            try {
                if (cls == java.lang.Integer.TYPE) {
                    int scanLongValue = (int) jSONLexer.scanLongValue();
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.setInt(t, scanLongValue);
                    } else {
                        fieldDeserializer.setValue(t, new java.lang.Integer(scanLongValue));
                    }
                    char c2 = jSONLexer.ch;
                    if (c2 == ',') {
                        int i2 = jSONLexer.bp + 1;
                        jSONLexer.bp = i2;
                        jSONLexer.ch = i2 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i2);
                        jSONLexer.token = 16;
                    } else if (c2 == ']') {
                        int i3 = jSONLexer.bp + 1;
                        jSONLexer.bp = i3;
                        jSONLexer.ch = i3 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i3);
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else if (cls == java.lang.String.class) {
                    char c3 = jSONLexer.ch;
                    if (c3 == '\"') {
                        str = jSONLexer.scanStringValue(kotlin.text.Typography.quote);
                    } else {
                        if (c3 != 'n' || !jSONLexer.text.startsWith(com.igexin.push.core.b.m, jSONLexer.bp)) {
                            throw new com.alibaba.fastjson.JSONException("not match string. feild : " + obj);
                        }
                        int i4 = jSONLexer.bp + 4;
                        jSONLexer.bp = i4;
                        jSONLexer.ch = i4 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i4);
                        str = null;
                    }
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.set(t, str);
                    } else {
                        fieldDeserializer.setValue(t, str);
                    }
                    char c4 = jSONLexer.ch;
                    if (c4 == ',') {
                        int i5 = jSONLexer.bp + 1;
                        jSONLexer.bp = i5;
                        jSONLexer.ch = i5 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i5);
                        jSONLexer.token = 16;
                    } else if (c4 == ']') {
                        int i6 = jSONLexer.bp + 1;
                        jSONLexer.bp = i6;
                        jSONLexer.ch = i6 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i6);
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else {
                    if (cls == java.lang.Long.TYPE) {
                        long scanLongValue2 = jSONLexer.scanLongValue();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setLong(t, scanLongValue2);
                        } else {
                            fieldDeserializer.setValue(t, new java.lang.Long(scanLongValue2));
                        }
                        char c5 = jSONLexer.ch;
                        if (c5 == ',') {
                            int i7 = jSONLexer.bp + 1;
                            jSONLexer.bp = i7;
                            jSONLexer.ch = i7 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i7);
                            jSONLexer.token = 16;
                        } else if (c5 == ']') {
                            int i8 = jSONLexer.bp + 1;
                            jSONLexer.bp = i8;
                            jSONLexer.ch = i8 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i8);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == java.lang.Boolean.TYPE) {
                        boolean scanBoolean = jSONLexer.scanBoolean();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setBoolean(t, scanBoolean);
                        } else {
                            fieldDeserializer.setValue(t, java.lang.Boolean.valueOf(scanBoolean));
                        }
                        char c6 = jSONLexer.ch;
                        if (c6 == ',') {
                            int i9 = jSONLexer.bp + 1;
                            jSONLexer.bp = i9;
                            jSONLexer.ch = i9 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i9);
                            jSONLexer.token = 16;
                        } else if (c6 == ']') {
                            int i10 = jSONLexer.bp + 1;
                            jSONLexer.bp = i10;
                            jSONLexer.ch = i10 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i10);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls.isEnum()) {
                        char c7 = jSONLexer.ch;
                        if (c7 == '\"') {
                            java.lang.String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
                            r8 = scanSymbol == null ? null : java.lang.Enum.valueOf(cls, scanSymbol);
                        } else {
                            if (c7 < '0' || c7 > '9') {
                                throw new com.alibaba.fastjson.JSONException("illegal enum." + jSONLexer.info());
                            }
                            r8 = ((com.alibaba.fastjson.parser.EnumDeserializer) ((com.alibaba.fastjson.parser.DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.config)).ordinalEnums[(int) jSONLexer.scanLongValue()];
                        }
                        fieldDeserializer.setValue(t, r8);
                        char c8 = jSONLexer.ch;
                        if (c8 == ',') {
                            int i11 = jSONLexer.bp + 1;
                            jSONLexer.bp = i11;
                            jSONLexer.ch = i11 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i11);
                            jSONLexer.token = 16;
                        } else if (c8 == ']') {
                            int i12 = jSONLexer.bp + 1;
                            jSONLexer.bp = i12;
                            jSONLexer.ch = i12 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i12);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == java.util.Date.class && jSONLexer.ch == '1') {
                        fieldDeserializer.setValue(t, new java.util.Date(jSONLexer.scanLongValue()));
                        char c9 = jSONLexer.ch;
                        if (c9 == ',') {
                            int i13 = jSONLexer.bp + 1;
                            jSONLexer.bp = i13;
                            jSONLexer.ch = i13 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i13);
                            jSONLexer.token = 16;
                        } else if (c9 == ']') {
                            int i14 = jSONLexer.bp + 1;
                            jSONLexer.bp = i14;
                            jSONLexer.ch = i14 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i14);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else {
                        char c10 = jSONLexer.ch;
                        if (c10 == '[') {
                            int i15 = jSONLexer.bp + 1;
                            jSONLexer.bp = i15;
                            jSONLexer.ch = i15 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i15);
                            jSONLexer.token = 14;
                        } else if (c10 == '{') {
                            int i16 = jSONLexer.bp + 1;
                            jSONLexer.bp = i16;
                            jSONLexer.ch = i16 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i16);
                            jSONLexer.token = 12;
                        } else {
                            jSONLexer.nextToken();
                        }
                        fieldDeserializer.parseField(defaultJSONParser, t, fieldInfo.fieldType, null);
                        if (c == ']') {
                            if (jSONLexer.token != 15) {
                                throw new com.alibaba.fastjson.JSONException("syntax error");
                            }
                        } else if (c == ',' && jSONLexer.token != 16) {
                            throw new com.alibaba.fastjson.JSONException("syntax error");
                        }
                    }
                    i++;
                }
                i++;
            } catch (java.lang.IllegalAccessException e) {
                throw new com.alibaba.fastjson.JSONException("set " + fieldInfo.name + "error", e);
            }
        }
        if (jSONLexer.ch == ',') {
            int i17 = jSONLexer.bp + 1;
            jSONLexer.bp = i17;
            jSONLexer.ch = i17 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i17);
            jSONLexer.token = 16;
        } else {
            jSONLexer.nextToken();
        }
        return t;
    }

    private boolean parseField(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.String str, java.lang.Object obj, java.lang.reflect.Type type, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer = getFieldDeserializer(str);
        if (fieldDeserializer == null) {
            fieldDeserializer = smartMatch(str);
        }
        int i = com.alibaba.fastjson.parser.Feature.SupportNonPublicField.mask;
        if (fieldDeserializer == null && ((defaultJSONParser.lexer.features & i) != 0 || (i & this.beanInfo.parserFeatures) != 0)) {
            if (this.extraFieldDeserializers == null) {
                java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap(1, 0.75f, 1);
                for (java.lang.Class<?> cls = this.clazz; cls != null && cls != java.lang.Object.class; cls = cls.getSuperclass()) {
                    for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
                        java.lang.String name = field.getName();
                        if (getFieldDeserializer(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                concurrentHashMap.put(name, field);
                            }
                        }
                    }
                }
                this.extraFieldDeserializers = concurrentHashMap;
            }
            java.lang.Object obj2 = this.extraFieldDeserializers.get(str);
            if (obj2 != null) {
                if (obj2 instanceof com.alibaba.fastjson.parser.deserializer.FieldDeserializer) {
                    fieldDeserializer = (com.alibaba.fastjson.parser.deserializer.FieldDeserializer) obj2;
                } else {
                    java.lang.reflect.Field field2 = (java.lang.reflect.Field) obj2;
                    field2.setAccessible(true);
                    fieldDeserializer = new com.alibaba.fastjson.parser.DefaultFieldDeserializer(defaultJSONParser.config, this.clazz, new com.alibaba.fastjson.util.FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0));
                    this.extraFieldDeserializers.put(str, fieldDeserializer);
                }
            }
        }
        if (fieldDeserializer == null) {
            parseExtra(defaultJSONParser, obj, str);
            return false;
        }
        jSONLexer.nextTokenWithChar(':');
        fieldDeserializer.parseField(defaultJSONParser, obj, type, map);
        return true;
    }

    private com.alibaba.fastjson.parser.deserializer.FieldDeserializer smartMatch(java.lang.String str) {
        boolean z;
        long fnv_64_lower = com.alibaba.fastjson.util.TypeUtils.fnv_64_lower(str);
        int i = 0;
        if (this.smartMatchHashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            int i2 = 0;
            while (true) {
                com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i2 >= fieldDeserializerArr.length) {
                    break;
                }
                jArr[i2] = com.alibaba.fastjson.util.TypeUtils.fnv_64_lower(fieldDeserializerArr[i2].fieldInfo.name);
                i2++;
            }
            java.util.Arrays.sort(jArr);
            this.smartMatchHashArray = jArr;
        }
        int binarySearch = java.util.Arrays.binarySearch(this.smartMatchHashArray, fnv_64_lower);
        if (binarySearch < 0) {
            z = str.startsWith("is");
            if (z) {
                binarySearch = java.util.Arrays.binarySearch(this.smartMatchHashArray, com.alibaba.fastjson.util.TypeUtils.fnv_64_lower(str.substring(2)));
            }
        } else {
            z = false;
        }
        if (binarySearch < 0) {
            return null;
        }
        if (this.smartMatchHashArrayMapping == null) {
            int[] iArr = new int[this.smartMatchHashArray.length];
            java.util.Arrays.fill(iArr, -1);
            while (true) {
                com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i >= fieldDeserializerArr2.length) {
                    break;
                }
                int binarySearch2 = java.util.Arrays.binarySearch(this.smartMatchHashArray, com.alibaba.fastjson.util.TypeUtils.fnv_64_lower(fieldDeserializerArr2[i].fieldInfo.name));
                if (binarySearch2 >= 0) {
                    iArr[binarySearch2] = i;
                }
                i++;
            }
            this.smartMatchHashArrayMapping = iArr;
        }
        int i3 = this.smartMatchHashArrayMapping[binarySearch];
        if (i3 == -1) {
            return null;
        }
        com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i3];
        java.lang.Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
        if (!z || cls == java.lang.Boolean.TYPE || cls == java.lang.Boolean.class) {
            return fieldDeserializer;
        }
        return null;
    }

    public java.lang.Object createInstance(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type) {
        if ((type instanceof java.lang.Class) && this.clazz.isInterface()) {
            return java.lang.reflect.Proxy.newProxyInstance(java.lang.Thread.currentThread().getContextClassLoader(), new java.lang.Class[]{(java.lang.Class) type}, new com.alibaba.fastjson.JSONObject((defaultJSONParser.lexer.features & com.alibaba.fastjson.parser.Feature.OrderedField.mask) != 0));
        }
        com.alibaba.fastjson.parser.JavaBeanInfo javaBeanInfo = this.beanInfo;
        java.lang.reflect.Constructor<?> constructor = javaBeanInfo.defaultConstructor;
        if (constructor == null && javaBeanInfo.factoryMethod == null) {
            return null;
        }
        java.lang.reflect.Method method = javaBeanInfo.factoryMethod;
        if (method != null && javaBeanInfo.defaultConstructorParameterSize > 0) {
            return null;
        }
        try {
            java.lang.Object newInstance = javaBeanInfo.defaultConstructorParameterSize == 0 ? constructor != null ? constructor.newInstance(new java.lang.Object[0]) : method.invoke(null, new java.lang.Object[0]) : constructor.newInstance(defaultJSONParser.contex.object);
            if (defaultJSONParser != null && (defaultJSONParser.lexer.features & com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask) != 0) {
                for (com.alibaba.fastjson.util.FieldInfo fieldInfo : this.beanInfo.fields) {
                    if (fieldInfo.fieldClass == java.lang.String.class) {
                        fieldInfo.set(newInstance, "");
                    }
                }
            }
            return newInstance;
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONException("create instance error, class " + this.clazz.getName(), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.Object createInstance(java.util.Map<java.lang.String, java.lang.Object> map, com.alibaba.fastjson.parser.ParserConfig parserConfig) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        java.lang.String str;
        java.lang.Object cast;
        com.alibaba.fastjson.parser.JavaBeanInfo javaBeanInfo = this.beanInfo;
        if (javaBeanInfo.creatorConstructor != null) {
            com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr = javaBeanInfo.fields;
            int length = fieldInfoArr.length;
            java.lang.Object[] objArr = new java.lang.Object[length];
            for (int i = 0; i < length; i++) {
                com.alibaba.fastjson.util.FieldInfo fieldInfo = fieldInfoArr[i];
                java.lang.Object obj = map.get(fieldInfo.name);
                if (obj == null) {
                    obj = com.alibaba.fastjson.util.TypeUtils.defaultValue(fieldInfo.fieldClass);
                }
                objArr[i] = obj;
            }
            java.lang.reflect.Constructor<?> constructor = this.beanInfo.creatorConstructor;
            if (constructor == null) {
                return null;
            }
            try {
                return constructor.newInstance(objArr);
            } catch (java.lang.Exception e) {
                throw new com.alibaba.fastjson.JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e);
            }
        }
        java.lang.Object createInstance = createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) null, this.clazz);
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer = getFieldDeserializer(entry.getKey());
            if (fieldDeserializer != null) {
                java.lang.Object value = entry.getValue();
                if (value == null) {
                    java.lang.Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                    if (cls == java.lang.Integer.TYPE) {
                        value = 0;
                    } else if (cls == java.lang.Long.TYPE) {
                        value = 0L;
                    } else if (cls == java.lang.Short.TYPE) {
                        value = (short) 0;
                    } else if (cls == java.lang.Byte.TYPE) {
                        value = (byte) 0;
                    } else if (cls == java.lang.Float.TYPE) {
                        value = java.lang.Float.valueOf(0.0f);
                    } else if (cls == java.lang.Double.TYPE) {
                        value = java.lang.Double.valueOf(0.0d);
                    } else if (cls == java.lang.Character.TYPE) {
                        value = '0';
                    } else if (cls == java.lang.Boolean.TYPE) {
                        value = java.lang.Boolean.FALSE;
                    }
                }
                com.alibaba.fastjson.util.FieldInfo fieldInfo2 = fieldDeserializer.fieldInfo;
                java.lang.reflect.Method method = fieldInfo2.method;
                if (method != null) {
                    method.invoke(createInstance, com.alibaba.fastjson.util.TypeUtils.cast(value, method.getGenericParameterTypes()[0], parserConfig));
                } else {
                    java.lang.reflect.Field field = fieldInfo2.field;
                    java.lang.reflect.Type type = fieldInfo2.fieldType;
                    if (type == java.lang.Boolean.TYPE) {
                        if (value == java.lang.Boolean.FALSE) {
                            field.setBoolean(createInstance, false);
                        } else if (value == java.lang.Boolean.TRUE) {
                            field.setBoolean(createInstance, true);
                        } else {
                            str = fieldDeserializer.fieldInfo.format;
                            if (str == null && type == java.util.Date.class && (value instanceof java.lang.String)) {
                                try {
                                    cast = new java.text.SimpleDateFormat(str).parse((java.lang.String) value);
                                } catch (java.text.ParseException unused) {
                                    cast = null;
                                }
                            } else {
                                cast = !(type instanceof java.lang.reflect.ParameterizedType) ? com.alibaba.fastjson.util.TypeUtils.cast(value, (java.lang.reflect.ParameterizedType) type, parserConfig) : com.alibaba.fastjson.util.TypeUtils.cast(value, type, parserConfig);
                            }
                            field.set(createInstance, cast);
                        }
                    } else if (type == java.lang.Integer.TYPE) {
                        if (value instanceof java.lang.Number) {
                            field.setInt(createInstance, ((java.lang.Number) value).intValue());
                        } else {
                            str = fieldDeserializer.fieldInfo.format;
                            if (str == null) {
                            }
                            if (!(type instanceof java.lang.reflect.ParameterizedType)) {
                            }
                            field.set(createInstance, cast);
                        }
                    } else if (type == java.lang.Long.TYPE) {
                        if (value instanceof java.lang.Number) {
                            field.setLong(createInstance, ((java.lang.Number) value).longValue());
                        } else {
                            str = fieldDeserializer.fieldInfo.format;
                            if (str == null) {
                            }
                            if (!(type instanceof java.lang.reflect.ParameterizedType)) {
                            }
                            field.set(createInstance, cast);
                        }
                    } else if (type == java.lang.Float.TYPE) {
                        if (value instanceof java.lang.Number) {
                            field.setFloat(createInstance, ((java.lang.Number) value).floatValue());
                        } else if (value instanceof java.lang.String) {
                            java.lang.String str2 = (java.lang.String) value;
                            field.setFloat(createInstance, str2.length() <= 10 ? com.alibaba.fastjson.util.TypeUtils.parseFloat(str2) : java.lang.Float.parseFloat(str2));
                        } else {
                            str = fieldDeserializer.fieldInfo.format;
                            if (str == null) {
                            }
                            if (!(type instanceof java.lang.reflect.ParameterizedType)) {
                            }
                            field.set(createInstance, cast);
                        }
                    } else if (type != java.lang.Double.TYPE) {
                        if (value != null && type == value.getClass()) {
                            field.set(createInstance, value);
                        }
                        str = fieldDeserializer.fieldInfo.format;
                        if (str == null) {
                        }
                        if (!(type instanceof java.lang.reflect.ParameterizedType)) {
                        }
                        field.set(createInstance, cast);
                    } else if (value instanceof java.lang.Number) {
                        field.setDouble(createInstance, ((java.lang.Number) value).doubleValue());
                    } else if (value instanceof java.lang.String) {
                        java.lang.String str3 = (java.lang.String) value;
                        field.setDouble(createInstance, str3.length() <= 10 ? com.alibaba.fastjson.util.TypeUtils.parseDouble(str3) : java.lang.Double.parseDouble(str3));
                    } else {
                        str = fieldDeserializer.fieldInfo.format;
                        if (str == null) {
                        }
                        if (!(type instanceof java.lang.reflect.ParameterizedType)) {
                        }
                        field.set(createInstance, cast);
                    }
                }
            }
        }
        return createInstance;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    public com.alibaba.fastjson.parser.deserializer.FieldDeserializer getFieldDeserializer(java.lang.String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        if (!this.beanInfo.ordered) {
            int length = this.sortedFieldDeserializers.length - 1;
            int i2 = 0;
            while (i2 <= length) {
                int i3 = (i2 + length) >>> 1;
                int compareTo = this.sortedFieldDeserializers[i3].fieldInfo.name.compareTo(str);
                if (compareTo < 0) {
                    i2 = i3 + 1;
                } else {
                    if (compareTo <= 0) {
                        return this.sortedFieldDeserializers[i3];
                    }
                    length = i3 - 1;
                }
            }
            java.util.Map<java.lang.String, com.alibaba.fastjson.parser.deserializer.FieldDeserializer> map = this.alterNameFieldDeserializers;
            if (map != null) {
                return map.get(str);
            }
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i4 = 0;
                while (true) {
                    com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i4 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i4] = com.alibaba.fastjson.util.TypeUtils.fnv_64_lower(fieldDeserializerArr[i4].fieldInfo.name);
                    i4++;
                }
                java.util.Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = java.util.Arrays.binarySearch(this.smartMatchHashArray, com.alibaba.fastjson.util.TypeUtils.fnv_64_lower(str));
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    int[] iArr = new int[this.smartMatchHashArray.length];
                    java.util.Arrays.fill(iArr, -1);
                    while (true) {
                        com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = java.util.Arrays.binarySearch(this.smartMatchHashArray, com.alibaba.fastjson.util.TypeUtils.fnv_64_lower(fieldDeserializerArr2[i].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            iArr[binarySearch2] = i;
                        }
                        i++;
                    }
                    this.smartMatchHashArrayMapping = iArr;
                }
                int i5 = this.smartMatchHashArrayMapping[binarySearch];
                if (i5 != -1) {
                    return this.sortedFieldDeserializers[i5];
                }
            }
            return smartMatch(str);
        }
        while (true) {
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] fieldDeserializerArr3 = this.sortedFieldDeserializers;
            if (i >= fieldDeserializerArr3.length) {
                return null;
            }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer = fieldDeserializerArr3[i];
            if (fieldDeserializer.fieldInfo.name.equalsIgnoreCase(str)) {
                return fieldDeserializer;
            }
            i++;
        }
    }

    public com.alibaba.fastjson.parser.deserializer.FieldDeserializer getFieldDeserializerByHash(long j) {
        int i = 0;
        while (true) {
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
            if (i >= fieldDeserializerArr.length) {
                return null;
            }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer = fieldDeserializerArr[i];
            if (fieldDeserializer.fieldInfo.nameHashCode == j) {
                return fieldDeserializer;
            }
            i++;
        }
    }

    public com.alibaba.fastjson.parser.JavaBeanDeserializer getSeeAlso(com.alibaba.fastjson.parser.ParserConfig parserConfig, com.alibaba.fastjson.parser.JavaBeanInfo javaBeanInfo, java.lang.String str) {
        com.alibaba.fastjson.annotation.JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (java.lang.Class<?> cls : jSONType.seeAlso()) {
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) {
                com.alibaba.fastjson.parser.JavaBeanDeserializer javaBeanDeserializer = (com.alibaba.fastjson.parser.JavaBeanDeserializer) deserializer;
                com.alibaba.fastjson.parser.JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                com.alibaba.fastjson.parser.JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    public void parseExtra(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.Object obj, java.lang.String str) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if ((jSONLexer.features & com.alibaba.fastjson.parser.Feature.IgnoreNotMatch.mask) == 0) {
            throw new com.alibaba.fastjson.JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
        }
        jSONLexer.nextTokenWithChar(':');
        java.util.List<com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider> list = defaultJSONParser.extraTypeProviders;
        java.lang.reflect.Type type = null;
        if (list != null) {
            java.util.Iterator<com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider> it = list.iterator();
            while (it.hasNext()) {
                type = it.next().getExtraType(obj, str);
            }
        }
        java.lang.Object parse = type == null ? defaultJSONParser.parse() : defaultJSONParser.parseObject(type);
        if (obj instanceof com.alibaba.fastjson.parser.deserializer.ExtraProcessable) {
            ((com.alibaba.fastjson.parser.deserializer.ExtraProcessable) obj).processExtra(str, parse);
            return;
        }
        java.util.List<com.alibaba.fastjson.parser.deserializer.ExtraProcessor> list2 = defaultJSONParser.extraProcessors;
        if (list2 != null) {
            java.util.Iterator<com.alibaba.fastjson.parser.deserializer.ExtraProcessor> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().processExtra(obj, str, parse);
            }
        }
    }
}
