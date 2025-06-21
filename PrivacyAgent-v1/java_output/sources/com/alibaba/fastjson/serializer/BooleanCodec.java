package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public final class BooleanCodec implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.serializer.BooleanCodec instance = new com.alibaba.fastjson.serializer.BooleanCodec();

    private BooleanCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 6) {
            jSONLexer.nextToken(16);
            return (T) java.lang.Boolean.TRUE;
        }
        if (i == 7) {
            jSONLexer.nextToken(16);
            return (T) java.lang.Boolean.FALSE;
        }
        if (i == 2) {
            int intValue = jSONLexer.intValue();
            jSONLexer.nextToken(16);
            return intValue == 1 ? (T) java.lang.Boolean.TRUE : (T) java.lang.Boolean.FALSE;
        }
        java.lang.Object parse = defaultJSONParser.parse();
        if (parse == null) {
            return null;
        }
        return (T) com.alibaba.fastjson.util.TypeUtils.castToBoolean(parse);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        java.lang.Boolean bool = (java.lang.Boolean) obj;
        if (bool == null) {
            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse.mask) != 0) {
                serializeWriter.write(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        if (bool.booleanValue()) {
            serializeWriter.write(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        } else {
            serializeWriter.write(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
    }
}
