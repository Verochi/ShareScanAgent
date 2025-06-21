package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
class EnumSerializer implements com.alibaba.fastjson.serializer.ObjectSerializer {
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString.mask) == 0) {
            serializeWriter.writeInt(((java.lang.Enum) obj).ordinal());
            return;
        }
        java.lang.String str = ((java.lang.Enum) obj).toString();
        if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask) != 0) {
            serializeWriter.writeStringWithSingleQuote(str);
        } else {
            serializeWriter.writeStringWithDoubleQuote(str, (char) 0, false);
        }
    }
}
