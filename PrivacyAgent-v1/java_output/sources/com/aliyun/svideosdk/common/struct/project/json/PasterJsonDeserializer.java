package com.aliyun.svideosdk.common.struct.project.json;

/* loaded from: classes12.dex */
public class PasterJsonDeserializer implements com.google.gson.JsonDeserializer<com.aliyun.svideosdk.common.struct.project.PasterTrack> {

    /* renamed from: com.aliyun.svideosdk.common.struct.project.json.PasterJsonDeserializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideosdk$common$struct$project$PasterTrack$Type;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.values().length];
            $SwitchMap$com$aliyun$svideosdk$common$struct$project$PasterTrack$Type = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.photo.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$PasterTrack$Type[com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.gif.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$PasterTrack$Type[com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.subtitle.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$PasterTrack$Type[com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.bubble_caption.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$PasterTrack$Type[com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.caption.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$project$PasterTrack$Type[com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.roll_captions.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public com.aliyun.svideosdk.common.struct.project.PasterTrack deserialize(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type, com.google.gson.JsonDeserializationContext jsonDeserializationContext) throws com.google.gson.JsonParseException {
        try {
            switch (com.aliyun.svideosdk.common.struct.project.json.PasterJsonDeserializer.AnonymousClass1.$SwitchMap$com$aliyun$svideosdk$common$struct$project$PasterTrack$Type[com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.valueOf(jsonElement.getAsJsonObject().get("Type").getAsString()).ordinal()]) {
                case 1:
                    return (com.aliyun.svideosdk.common.struct.project.PasterTrack) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack.class);
                case 2:
                    return (com.aliyun.svideosdk.common.struct.project.PasterTrack) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.GifPasterTrack.class);
                case 3:
                    return (com.aliyun.svideosdk.common.struct.project.PasterTrack) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.SubTitleTrack.class);
                case 4:
                    return (com.aliyun.svideosdk.common.struct.project.PasterTrack) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack.class);
                case 5:
                    return (com.aliyun.svideosdk.common.struct.project.PasterTrack) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.CaptionTrack.class);
                case 6:
                    return (com.aliyun.svideosdk.common.struct.project.PasterTrack) jsonDeserializationContext.deserialize(jsonElement, com.aliyun.svideosdk.common.struct.project.RollCaptionTrack.class);
                default:
                    return null;
            }
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
