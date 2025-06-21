package com.aliyun.svideosdk.common.struct.project.json;

/* loaded from: classes12.dex */
public class ActionJsonDeserializer implements com.google.gson.JsonDeserializer<com.aliyun.svideosdk.common.struct.effect.ActionBase> {

    /* renamed from: com.aliyun.svideosdk.common.struct.project.json.ActionJsonDeserializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideosdk$common$struct$effect$ActionBase$Type;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.values().length];
            $SwitchMap$com$aliyun$svideosdk$common$struct$effect$ActionBase$Type = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.alpha.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$effect$ActionBase$Type[com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.scale.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$effect$ActionBase$Type[com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.translate.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$effect$ActionBase$Type[com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.rotate_repeat.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$effect$ActionBase$Type[com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.rotate_by.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$effect$ActionBase$Type[com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.rotate_to.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$effect$ActionBase$Type[com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.swipe.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$effect$ActionBase$Type[com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.custom.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$effect$ActionBase$Type[com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.action_set.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public com.aliyun.svideosdk.common.struct.effect.ActionBase deserialize(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type, com.google.gson.JsonDeserializationContext jsonDeserializationContext) throws com.google.gson.JsonParseException {
        try {
            switch (com.aliyun.svideosdk.common.struct.project.json.ActionJsonDeserializer.AnonymousClass1.$SwitchMap$com$aliyun$svideosdk$common$struct$effect$ActionBase$Type[com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.valueOf(jsonElement.getAsJsonObject().get("Type").getAsString()).ordinal()]) {
                case 1:
                    return (com.aliyun.svideosdk.common.struct.effect.ActionBase) com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl.mGson.fromJson(jsonElement, com.aliyun.svideosdk.common.struct.effect.ActionFade.class);
                case 2:
                    return (com.aliyun.svideosdk.common.struct.effect.ActionBase) com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl.mGson.fromJson(jsonElement, com.aliyun.svideosdk.common.struct.effect.ActionScale.class);
                case 3:
                    return (com.aliyun.svideosdk.common.struct.effect.ActionBase) com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl.mGson.fromJson(jsonElement, com.aliyun.svideosdk.common.struct.effect.ActionTranslate.class);
                case 4:
                    return (com.aliyun.svideosdk.common.struct.effect.ActionBase) com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl.mGson.fromJson(jsonElement, com.aliyun.svideosdk.common.struct.effect.ActionRotate.class);
                case 5:
                    return (com.aliyun.svideosdk.common.struct.effect.ActionBase) com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl.mGson.fromJson(jsonElement, com.aliyun.svideosdk.common.struct.effect.ActionRotateBy.class);
                case 6:
                    return (com.aliyun.svideosdk.common.struct.effect.ActionBase) com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl.mGson.fromJson(jsonElement, com.aliyun.svideosdk.common.struct.effect.ActionRotateTo.class);
                case 7:
                    return (com.aliyun.svideosdk.common.struct.effect.ActionBase) com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl.mGson.fromJson(jsonElement, com.aliyun.svideosdk.common.struct.effect.ActionWipe.class);
                case 8:
                    return (com.aliyun.svideosdk.common.struct.effect.ActionBase) com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl.mGson.fromJson(jsonElement, com.aliyun.svideosdk.common.struct.effect.ActionShader.class);
                case 9:
                    return (com.aliyun.svideosdk.common.struct.effect.ActionBase) com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl.mGson.fromJson(jsonElement, com.aliyun.svideosdk.common.struct.effect.ActionSet.class);
                default:
                    return null;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
