package com.aliyun.svideosdk.common.struct.project.json;

/* loaded from: classes12.dex */
public class EffectJsonDeserializer implements com.google.gson.JsonDeserializer<com.aliyun.svideosdk.common.struct.project.Effect> {

    /* renamed from: com.aliyun.svideosdk.common.struct.project.json.EffectJsonDeserializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideosdk$common$struct$project$Effect$Type;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.struct.project.Effect.Type.values().length];
            $SwitchMap$com$aliyun$svideosdk$common$struct$project$Effect$Type = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.struct.project.Effect.Type.blur_background.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$Effect$Type[com.aliyun.svideosdk.common.struct.project.Effect.Type.running_display_mode.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$Effect$Type[com.aliyun.svideosdk.common.struct.project.Effect.Type.transition.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$Effect$Type[com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_effect.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$Effect$Type[com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_fade.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    private com.aliyun.svideosdk.common.struct.project.Effect deserializeTransition(com.google.gson.JsonElement jsonElement, int i, com.google.gson.JsonDeserializationContext jsonDeserializationContext) {
        try {
            if (i == 0) {
                return (com.aliyun.svideosdk.common.struct.project.Effect) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.effect.TransitionShutter.class);
            }
            if (i == 1) {
                return (com.aliyun.svideosdk.common.struct.project.Effect) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.effect.TransitionTranslate.class);
            }
            if (i == 2) {
                return (com.aliyun.svideosdk.common.struct.project.Effect) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.effect.TransitionCircle.class);
            }
            if (i == 3) {
                return (com.aliyun.svideosdk.common.struct.project.Effect) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.effect.TransitionFiveStar.class);
            }
            if (i == 4) {
                return (com.aliyun.svideosdk.common.struct.project.Effect) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.effect.TransitionFade.class);
            }
            if (i != 5) {
                return null;
            }
            return (com.aliyun.svideosdk.common.struct.project.Effect) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.effect.TransitionBase.class);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public com.aliyun.svideosdk.common.struct.project.Effect deserialize(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type, com.google.gson.JsonDeserializationContext jsonDeserializationContext) throws com.google.gson.JsonParseException {
        try {
            com.google.gson.JsonObject asJsonObject = jsonElement.getAsJsonObject();
            int i = com.aliyun.svideosdk.common.struct.project.json.EffectJsonDeserializer.AnonymousClass1.$SwitchMap$com$aliyun$svideosdk$common$struct$project$Effect$Type[com.aliyun.svideosdk.common.struct.project.Effect.Type.valueOf(asJsonObject.get("Type").getAsString()).ordinal()];
            if (i == 1) {
                return (com.aliyun.svideosdk.common.struct.project.Effect) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.effect.BlurBackground.class);
            }
            if (i == 2) {
                return (com.aliyun.svideosdk.common.struct.project.Effect) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.RunningDisplayMode.class);
            }
            if (i == 3) {
                return deserializeTransition(jsonElement, asJsonObject.get("TransitionType").getAsInt(), jsonDeserializationContext);
            }
            if (i == 4) {
                return (com.aliyun.svideosdk.common.struct.project.Effect) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.AudioEffect.class);
            }
            if (i != 5) {
                return null;
            }
            return (com.aliyun.svideosdk.common.struct.project.Effect) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.AudioFade.class);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
