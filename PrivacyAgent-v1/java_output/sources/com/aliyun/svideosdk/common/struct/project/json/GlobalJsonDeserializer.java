package com.aliyun.svideosdk.common.struct.project.json;

/* loaded from: classes12.dex */
public class GlobalJsonDeserializer implements com.google.gson.JsonDeserializer<com.aliyun.svideosdk.common.struct.project.GlobalTrack> {

    /* renamed from: com.aliyun.svideosdk.common.struct.project.json.GlobalJsonDeserializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideosdk$common$struct$project$GlobalTrack$Type;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.values().length];
            $SwitchMap$com$aliyun$svideosdk$common$struct$project$GlobalTrack$Type = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.paint.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$GlobalTrack$Type[com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.watermark.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$GlobalTrack$Type[com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.tail_watermark.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public com.aliyun.svideosdk.common.struct.project.GlobalTrack deserialize(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type, com.google.gson.JsonDeserializationContext jsonDeserializationContext) throws com.google.gson.JsonParseException {
        try {
            int i = com.aliyun.svideosdk.common.struct.project.json.GlobalJsonDeserializer.AnonymousClass1.$SwitchMap$com$aliyun$svideosdk$common$struct$project$GlobalTrack$Type[com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.valueOf(jsonElement.getAsJsonObject().get("Type").getAsString()).ordinal()];
            if (i == 1) {
                return (com.aliyun.svideosdk.common.struct.project.GlobalTrack) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.PaintTrack.class);
            }
            if (i == 2) {
                return (com.aliyun.svideosdk.common.struct.project.GlobalTrack) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.WaterMark.class);
            }
            if (i != 3) {
                return null;
            }
            return (com.aliyun.svideosdk.common.struct.project.GlobalTrack) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.TailWaterMark.class);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
