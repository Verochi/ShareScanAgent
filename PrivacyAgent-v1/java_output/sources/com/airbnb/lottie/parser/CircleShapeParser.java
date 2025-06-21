package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class CircleShapeParser {
    public static com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("nm", "p", "s", "hd", "d");

    public static com.airbnb.lottie.model.content.CircleShape a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition, int i) throws java.io.IOException {
        boolean z = i == 3;
        java.lang.String str = null;
        com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> animatableValue = null;
        com.airbnb.lottie.model.animatable.AnimatablePointValue animatablePointValue = null;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(a);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableValue = com.airbnb.lottie.parser.AnimatablePathValueParser.a(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatablePointValue = com.airbnb.lottie.parser.AnimatableValueParser.g(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                z2 = jsonReader.nextBoolean();
            } else if (selectName != 4) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextInt() == 3;
            }
        }
        return new com.airbnb.lottie.model.content.CircleShape(str, animatableValue, animatablePointValue, z, z2);
    }
}
