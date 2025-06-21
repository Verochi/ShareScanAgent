package com.aliyun.svideosdk.common.struct.project.json;

/* loaded from: classes12.dex */
public class FilterJsonDeserializer implements com.google.gson.JsonDeserializer<com.aliyun.svideosdk.common.struct.project.EffectTrack> {

    /* renamed from: com.aliyun.svideosdk.common.struct.project.json.FilterJsonDeserializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideosdk$common$struct$project$EffectTrack$Type;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.values().length];
            $SwitchMap$com$aliyun$svideosdk$common$struct$project$EffectTrack$Type = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.time_effect.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$EffectTrack$Type[com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.mv.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$EffectTrack$Type[com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.filter.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$EffectTrack$Type[com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.animation_filter.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$EffectTrack$Type[com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.lut_filter.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public com.aliyun.svideosdk.common.struct.project.EffectTrack deserialize(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type, com.google.gson.JsonDeserializationContext jsonDeserializationContext) throws com.google.gson.JsonParseException {
        int i;
        com.google.gson.JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (!asJsonObject.has("Type")) {
            return null;
        }
        try {
            i = com.aliyun.svideosdk.common.struct.project.json.FilterJsonDeserializer.AnonymousClass1.$SwitchMap$com$aliyun$svideosdk$common$struct$project$EffectTrack$Type[com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.valueOf(asJsonObject.get("Type").getAsString()).ordinal()];
        } catch (java.lang.Exception unused) {
        }
        if (i == 1) {
            return (com.aliyun.svideosdk.common.struct.project.EffectTrack) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.TimeFilter.class);
        }
        if (i == 2) {
            return (com.aliyun.svideosdk.common.struct.project.EffectTrack) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.MVFilter.class);
        }
        if (i == 3 || i == 4 || i == 5) {
            return (com.aliyun.svideosdk.common.struct.project.EffectTrack) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.Filter.class);
        }
        return null;
    }
}
