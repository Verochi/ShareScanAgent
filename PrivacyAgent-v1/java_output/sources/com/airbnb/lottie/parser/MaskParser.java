package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class MaskParser {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
    
        if (r0.equals("s") == false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.airbnb.lottie.model.content.Mask a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        char c;
        jsonReader.beginObject();
        com.airbnb.lottie.model.content.Mask.MaskMode maskMode = null;
        com.airbnb.lottie.model.animatable.AnimatableShapeValue animatableShapeValue = null;
        com.airbnb.lottie.model.animatable.AnimatableIntegerValue animatableIntegerValue = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            java.lang.String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 3;
            switch (nextName.hashCode()) {
                case 111:
                    if (nextName.equals("o")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3588:
                    if (nextName.equals(com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.PRIORITY_VALID_TIME)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 104433:
                    if (nextName.equals("inv")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3357091:
                    if (nextName.equals("mode")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    animatableIntegerValue = com.airbnb.lottie.parser.AnimatableValueParser.f(jsonReader, lottieComposition);
                    break;
                case 1:
                    animatableShapeValue = com.airbnb.lottie.parser.AnimatableValueParser.i(jsonReader, lottieComposition);
                    break;
                case 2:
                    z = jsonReader.nextBoolean();
                    break;
                case 3:
                    java.lang.String nextString = jsonReader.nextString();
                    nextString.hashCode();
                    switch (nextString.hashCode()) {
                        case 97:
                            if (nextString.equals("a")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 105:
                            if (nextString.equals("i")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 110:
                            if (nextString.equals(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT)) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 115:
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            maskMode = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_ADD;
                            break;
                        case 1:
                            lottieComposition.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_INTERSECT;
                            break;
                        case 2:
                            maskMode = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_NONE;
                            break;
                        case 3:
                            maskMode = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            com.airbnb.lottie.utils.Logger.warning("Unknown mask mode " + nextName + ". Defaulting to Add.");
                            maskMode = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_ADD;
                            break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.airbnb.lottie.model.content.Mask(maskMode, animatableShapeValue, animatableIntegerValue, z);
    }
}
