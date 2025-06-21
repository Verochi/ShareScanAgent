package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
public class ThrowableDeserializer extends com.alibaba.fastjson.parser.JavaBeanDeserializer {
    public ThrowableDeserializer(com.alibaba.fastjson.parser.ParserConfig parserConfig, java.lang.Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00f2, code lost:
    
        if (r2 != null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f4, code lost:
    
        r3 = (T) new java.lang.Exception(r13, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0184, code lost:
    
        if (r14 == null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0186, code lost:
    
        ((java.lang.Throwable) r3).setStackTrace(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0189, code lost:
    
        if (r11 == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x018b, code lost:
    
        if (r2 == null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x018f, code lost:
    
        if (r2 != r18.clazz) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0191, code lost:
    
        r5 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01a2, code lost:
    
        if (r5 == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01a4, code lost:
    
        r0 = r11.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01b0, code lost:
    
        if (r0.hasNext() == false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01b2, code lost:
    
        r2 = (java.util.Map.Entry) r0.next();
        r4 = (java.lang.String) r2.getKey();
        r2 = r2.getValue();
        r4 = r5.getFieldDeserializer(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01c6, code lost:
    
        if (r4 == null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01c8, code lost:
    
        r4.setValue(r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0193, code lost:
    
        r0 = r19.config.getDeserializer(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x019b, code lost:
    
        if ((r0 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x019d, code lost:
    
        r5 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01a1, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01cc, code lost:
    
        return (T) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fb, code lost:
    
        r3 = r2.getConstructors();
        r4 = r3.length;
        r8 = r6;
        r9 = r8;
        r15 = r9;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0105, code lost:
    
        if (r5 >= r4) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0107, code lost:
    
        r16 = r3[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x010e, code lost:
    
        if (r16.getParameterTypes().length != 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0110, code lost:
    
        r20 = r3;
        r15 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0149, code lost:
    
        r5 = r5 + 1;
        r3 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011a, code lost:
    
        r20 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x011e, code lost:
    
        if (r16.getParameterTypes().length != 1) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0128, code lost:
    
        if (r16.getParameterTypes()[0] != java.lang.String.class) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x012a, code lost:
    
        r9 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0133, code lost:
    
        if (r16.getParameterTypes().length != 2) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x013c, code lost:
    
        if (r16.getParameterTypes()[0] != java.lang.String.class) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0145, code lost:
    
        if (r16.getParameterTypes()[1] != java.lang.Throwable.class) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0147, code lost:
    
        r8 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x014f, code lost:
    
        if (r8 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0151, code lost:
    
        r3 = (T) ((java.lang.Throwable) r8.newInstance(r13, r12));
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x017d, code lost:
    
        if (r3 != null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x017f, code lost:
    
        r3 = (T) new java.lang.Exception(r13, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0161, code lost:
    
        if (r9 == null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0163, code lost:
    
        r3 = (java.lang.Throwable) r9.newInstance(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0170, code lost:
    
        if (r15 == null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0172, code lost:
    
        r3 = (java.lang.Throwable) r15.newInstance(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x017c, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01cd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d5, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0058 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        java.lang.Class<?> cls;
        java.lang.reflect.Constructor<?> constructor;
        java.lang.String stringVal;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token;
        if (i == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (defaultJSONParser.resolveStatus == 2) {
            defaultJSONParser.resolveStatus = 0;
        } else if (i != 12) {
            throw new com.alibaba.fastjson.JSONException("syntax error");
        }
        if (type == null || !(type instanceof java.lang.Class)) {
            cls = null;
        } else {
            cls = (java.lang.Class) type;
            if (!java.lang.Throwable.class.isAssignableFrom(cls)) {
                throw new com.alibaba.fastjson.JSONException("target class is not Throwable");
            }
        }
        java.util.HashMap hashMap = null;
        java.lang.Throwable th = null;
        java.lang.String str = null;
        java.lang.StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            java.lang.String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
            if (scanSymbol == null) {
                int i2 = jSONLexer.token;
                if (i2 == 13) {
                    jSONLexer.nextToken(16);
                    constructor = null;
                    break;
                }
                if (i2 == 16) {
                    continue;
                }
            }
            jSONLexer.nextTokenWithChar(':');
            if (com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY.equals(scanSymbol)) {
                if (jSONLexer.token != 4) {
                    throw new com.alibaba.fastjson.JSONException("syntax error");
                }
                if (!java.lang.Throwable.class.isAssignableFrom(com.alibaba.fastjson.util.TypeUtils.loadClass(jSONLexer.stringVal(), defaultJSONParser.config.defaultClassLoader, false))) {
                    throw new com.alibaba.fastjson.JSONException("target class is not Throwable");
                }
                cls = this.clazz;
                jSONLexer.nextToken(16);
            } else if ("message".equals(scanSymbol)) {
                int i3 = jSONLexer.token;
                if (i3 == 8) {
                    stringVal = null;
                } else {
                    if (i3 != 4) {
                        throw new com.alibaba.fastjson.JSONException("syntax error");
                    }
                    stringVal = jSONLexer.stringVal();
                }
                jSONLexer.nextToken();
                str = stringVal;
            } else {
                if ("cause".equals(scanSymbol)) {
                    constructor = null;
                    th = (java.lang.Throwable) deserialze(defaultJSONParser, null, "cause");
                } else {
                    constructor = null;
                    if ("stackTrace".equals(scanSymbol)) {
                        stackTraceElementArr = (java.lang.StackTraceElement[]) defaultJSONParser.parseObject((java.lang.Class) java.lang.StackTraceElement[].class);
                    } else {
                        if (hashMap == null) {
                            hashMap = new java.util.HashMap();
                        }
                        hashMap.put(scanSymbol, defaultJSONParser.parse());
                    }
                }
                if (jSONLexer.token != 13) {
                    jSONLexer.nextToken(16);
                    break;
                }
            }
            constructor = null;
            if (jSONLexer.token != 13) {
            }
        }
    }
}
