package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class ShapePathParser {
    public static com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("nm", "ind", com.bytedance.sdk.openadsdk.mediation.MediationConstant.ADN_KS, "hd");

    public static com.airbnb.lottie.model.content.ShapePath a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        java.lang.String str = null;
        com.airbnb.lottie.model.animatable.AnimatableShapeValue animatableShapeValue = null;
        int i = 0;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(a);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                i = jsonReader.nextInt();
            } else if (selectName == 2) {
                animatableShapeValue = com.airbnb.lottie.parser.AnimatableValueParser.i(jsonReader, lottieComposition);
            } else if (selectName != 3) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new com.airbnb.lottie.model.content.ShapePath(str, i, animatableShapeValue, z);
    }
}
