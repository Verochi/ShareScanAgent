package com.alibaba.fastjson;

/* loaded from: classes.dex */
public class JSONWriter implements java.io.Closeable, java.io.Flushable {
    private com.alibaba.fastjson.JSONStreamContext context;
    private com.alibaba.fastjson.serializer.JSONSerializer serializer;
    private com.alibaba.fastjson.serializer.SerializeWriter writer;

    public JSONWriter(java.io.Writer writer) {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = new com.alibaba.fastjson.serializer.SerializeWriter(writer);
        this.writer = serializeWriter;
        this.serializer = new com.alibaba.fastjson.serializer.JSONSerializer(serializeWriter);
    }

    private void afterWriter() {
        int i;
        com.alibaba.fastjson.JSONStreamContext jSONStreamContext = this.context;
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

    private void beforeWrite() {
        com.alibaba.fastjson.JSONStreamContext jSONStreamContext = this.context;
        if (jSONStreamContext == null) {
            return;
        }
        int i = jSONStreamContext.state;
        if (i == 1002) {
            this.writer.write(58);
        } else if (i == 1003) {
            this.writer.write(44);
        } else {
            if (i != 1005) {
                return;
            }
            this.writer.write(44);
        }
    }

    private void beginStructure() {
        int i = this.context.state;
        switch (i) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.writer.write(58);
                return;
            case 1003:
            default:
                throw new com.alibaba.fastjson.JSONException("illegal state : " + i);
            case 1005:
                this.writer.write(44);
                return;
        }
    }

    private void endStructure() {
        com.alibaba.fastjson.JSONStreamContext jSONStreamContext = this.context.parent;
        this.context = jSONStreamContext;
        if (jSONStreamContext == null) {
            return;
        }
        int i = jSONStreamContext.state;
        int i2 = i != 1001 ? i != 1002 ? i != 1004 ? -1 : 1005 : 1003 : 1002;
        if (i2 != -1) {
            jSONStreamContext.state = i2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.writer.close();
    }

    public void config(com.alibaba.fastjson.serializer.SerializerFeature serializerFeature, boolean z) {
        this.writer.config(serializerFeature, z);
    }

    public void endArray() {
        this.writer.write(93);
        endStructure();
    }

    public void endObject() {
        this.writer.write(125);
        endStructure();
    }

    @Override // java.io.Flushable
    public void flush() throws java.io.IOException {
        this.writer.flush();
    }

    public void startArray() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new com.alibaba.fastjson.JSONStreamContext(this.context, 1004);
        this.writer.write(91);
    }

    public void startObject() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new com.alibaba.fastjson.JSONStreamContext(this.context, 1001);
        this.writer.write(123);
    }

    public void writeKey(java.lang.String str) {
        writeObject(str);
    }

    public void writeObject(java.lang.Object obj) {
        beforeWrite();
        this.serializer.write(obj);
        afterWriter();
    }

    public void writeObject(java.lang.String str) {
        beforeWrite();
        this.serializer.write(str);
        afterWriter();
    }

    public void writeValue(java.lang.Object obj) {
        writeObject(obj);
    }
}
