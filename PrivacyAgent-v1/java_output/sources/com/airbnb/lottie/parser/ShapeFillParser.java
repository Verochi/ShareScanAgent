package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class ShapeFillParser {
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("nm", "c", "o", "fillEnabled", "r", "hd");

    public static com.airbnb.lottie.model.content.ShapeFill a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        com.airbnb.lottie.model.animatable.AnimatableIntegerValue animatableIntegerValue = null;
        java.lang.String str = null;
        com.airbnb.lottie.model.animatable.AnimatableColorValue animatableColorValue = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(a);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableColorValue = com.airbnb.lottie.parser.AnimatableValueParser.c(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatableIntegerValue = com.airbnb.lottie.parser.AnimatableValueParser.f(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                z = jsonReader.nextBoolean();
            } else if (selectName == 4) {
                i = jsonReader.nextInt();
            } else if (selectName != 5) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                z2 = jsonReader.nextBoolean();
            }
        }
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new com.airbnb.lottie.model.animatable.AnimatableIntegerValue(java.util.Collections.singletonList(new com.airbnb.lottie.value.Keyframe(100)));
        }
        return new com.airbnb.lottie.model.content.ShapeFill(str, z, i == 1 ? android.graphics.Path.FillType.WINDING : android.graphics.Path.FillType.EVEN_ODD, animatableColorValue, animatableIntegerValue, z2);
    }
}
