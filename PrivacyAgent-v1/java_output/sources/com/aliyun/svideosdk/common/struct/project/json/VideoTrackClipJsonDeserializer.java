package com.aliyun.svideosdk.common.struct.project.json;

/* loaded from: classes12.dex */
public class VideoTrackClipJsonDeserializer implements com.google.gson.JsonDeserializer<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public com.aliyun.svideosdk.common.struct.project.VideoTrackClip deserialize(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type, com.google.gson.JsonDeserializationContext jsonDeserializationContext) throws com.google.gson.JsonParseException {
        com.google.gson.JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (!asJsonObject.has("ClassType")) {
            return (com.aliyun.svideosdk.common.struct.project.VideoTrackClip) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip.class);
        }
        try {
            return "pip".equalsIgnoreCase(asJsonObject.get("ClassType").getAsString()) ? (com.aliyun.svideosdk.common.struct.project.VideoTrackClip) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip.class) : (com.aliyun.svideosdk.common.struct.project.VideoTrackClip) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip.class);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
