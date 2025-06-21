package com.aliyun.svideosdk.common.struct.project.json;

/* loaded from: classes12.dex */
public class ListJsonDeserializer implements com.google.gson.JsonDeserializer<java.util.List<?>> {
    @Override // com.google.gson.JsonDeserializer
    public java.util.List<?> deserialize(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type, com.google.gson.JsonDeserializationContext jsonDeserializationContext) throws com.google.gson.JsonParseException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.google.gson.JsonArray asJsonArray = jsonElement.getAsJsonArray();
        java.lang.reflect.Type type2 = ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0];
        java.util.Iterator<com.google.gson.JsonElement> it = asJsonArray.iterator();
        while (it.hasNext()) {
            java.lang.Object deserialize = jsonDeserializationContext.deserialize(it.next(), type2);
            if (deserialize != null) {
                arrayList.add(deserialize);
            }
        }
        return arrayList;
    }
}
