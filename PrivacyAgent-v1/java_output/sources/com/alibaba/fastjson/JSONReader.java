package com.alibaba.fastjson;

/* loaded from: classes.dex */
public class JSONReader implements java.io.Closeable {
    private com.alibaba.fastjson.JSONStreamContext context;
    private final com.alibaba.fastjson.parser.DefaultJSONParser parser;
    private java.io.Reader reader;

    public JSONReader(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser) {
        this.parser = defaultJSONParser;
    }

    public JSONReader(com.alibaba.fastjson.parser.JSONLexer jSONLexer) {
        this(new com.alibaba.fastjson.parser.DefaultJSONParser(jSONLexer));
    }

    public JSONReader(java.io.Reader reader) {
        this(new com.alibaba.fastjson.parser.JSONLexer(readAll(reader)));
        this.reader = reader;
    }

    private void endStructure() {
        int i;
        com.alibaba.fastjson.JSONStreamContext jSONStreamContext = this.context.parent;
        this.context = jSONStreamContext;
        if (jSONStreamContext == null) {
            return;
        }
        switch (jSONStreamContext.state) {
            case 1001:
            case 1003:
                i = 1002;
                break;
            case 1002:
                i = 1003;
                break;
            case 1004:
                i = 1005;
                break;
            default:
                i = -1;
                break;
        }
        if (i != -1) {
            jSONStreamContext.state = i;
        }
    }

    private void readAfter() {
        com.alibaba.fastjson.JSONStreamContext jSONStreamContext = this.context;
        int i = jSONStreamContext.state;
        int i2 = 1002;
        switch (i) {
            case 1001:
            case 1003:
                break;
            case 1002:
                i2 = 1003;
                break;
            case 1004:
                i2 = 1005;
                break;
            case 1005:
                i2 = -1;
                break;
            default:
                throw new com.alibaba.fastjson.JSONException("illegal state : " + i);
        }
        if (i2 != -1) {
            jSONStreamContext.state = i2;
        }
    }

    public static java.lang.String readAll(java.io.Reader reader) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int read = reader.read(cArr, 0, 2048);
                if (read < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONException("read string from reader error", e);
        }
    }

    private void readBefore() {
        int i = this.context.state;
        switch (i) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.parser.accept(17);
                return;
            case 1003:
            case 1005:
                this.parser.accept(16);
                return;
            default:
                throw new com.alibaba.fastjson.JSONException("illegal state : " + i);
        }
    }

    private void startStructure() {
        switch (this.context.state) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.parser.accept(17);
                return;
            case 1003:
            case 1005:
                this.parser.accept(16);
                return;
            default:
                throw new com.alibaba.fastjson.JSONException("illegal state : " + this.context.state);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.parser.lexer.close();
        java.io.Reader reader = this.reader;
        if (reader != null) {
            try {
                reader.close();
            } catch (java.io.IOException e) {
                throw new com.alibaba.fastjson.JSONException("closed reader error", e);
            }
        }
    }

    public void config(com.alibaba.fastjson.parser.Feature feature, boolean z) {
        this.parser.config(feature, z);
    }

    public void endArray() {
        this.parser.accept(15);
        endStructure();
    }

    public void endObject() {
        this.parser.accept(13);
        endStructure();
    }

    public boolean hasNext() {
        if (this.context == null) {
            throw new com.alibaba.fastjson.JSONException(com.anythink.expressad.foundation.g.b.b.a);
        }
        int i = this.parser.lexer.token();
        int i2 = this.context.state;
        switch (i2) {
            case 1001:
            case 1003:
                return i != 13;
            case 1002:
            default:
                throw new com.alibaba.fastjson.JSONException("illegal state : " + i2);
            case 1004:
            case 1005:
                return i != 15;
        }
    }

    public int peek() {
        return this.parser.lexer.token();
    }

    public java.lang.Integer readInteger() {
        java.lang.Object parse;
        if (this.context == null) {
            parse = this.parser.parse();
        } else {
            readBefore();
            parse = this.parser.parse();
            readAfter();
        }
        return com.alibaba.fastjson.util.TypeUtils.castToInt(parse);
    }

    public java.lang.Long readLong() {
        java.lang.Object parse;
        if (this.context == null) {
            parse = this.parser.parse();
        } else {
            readBefore();
            parse = this.parser.parse();
            readAfter();
        }
        return com.alibaba.fastjson.util.TypeUtils.castToLong(parse);
    }

    public java.lang.Object readObject() {
        if (this.context == null) {
            return this.parser.parse();
        }
        readBefore();
        java.lang.Object parse = this.parser.parse();
        readAfter();
        return parse;
    }

    public <T> T readObject(com.alibaba.fastjson.TypeReference<T> typeReference) {
        return (T) readObject(typeReference.type);
    }

    public <T> T readObject(java.lang.Class<T> cls) {
        if (this.context == null) {
            return (T) this.parser.parseObject((java.lang.Class) cls);
        }
        readBefore();
        T t = (T) this.parser.parseObject((java.lang.Class) cls);
        readAfter();
        return t;
    }

    public <T> T readObject(java.lang.reflect.Type type) {
        if (this.context == null) {
            return (T) this.parser.parseObject(type);
        }
        readBefore();
        T t = (T) this.parser.parseObject(type);
        readAfter();
        return t;
    }

    public java.lang.Object readObject(java.util.Map map) {
        if (this.context == null) {
            return this.parser.parseObject(map);
        }
        readBefore();
        java.lang.Object parseObject = this.parser.parseObject(map);
        readAfter();
        return parseObject;
    }

    public void readObject(java.lang.Object obj) {
        if (this.context == null) {
            this.parser.parseObject(obj);
            return;
        }
        readBefore();
        this.parser.parseObject(obj);
        readAfter();
    }

    public java.lang.String readString() {
        java.lang.Object parse;
        if (this.context == null) {
            parse = this.parser.parse();
        } else {
            readBefore();
            parse = this.parser.parse();
            readAfter();
        }
        return com.alibaba.fastjson.util.TypeUtils.castToString(parse);
    }

    public void startArray() {
        if (this.context == null) {
            this.context = new com.alibaba.fastjson.JSONStreamContext(null, 1004);
        } else {
            startStructure();
            this.context = new com.alibaba.fastjson.JSONStreamContext(this.context, 1004);
        }
        this.parser.accept(14);
    }

    public void startObject() {
        if (this.context == null) {
            this.context = new com.alibaba.fastjson.JSONStreamContext(null, 1001);
        } else {
            startStructure();
            this.context = new com.alibaba.fastjson.JSONStreamContext(this.context, 1001);
        }
        this.parser.accept(12);
    }
}
