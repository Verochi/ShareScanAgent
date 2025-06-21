package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class RectangleShapeParser {
    public static com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("nm", "p", "s", "r", "hd");

    public static com.airbnb.lottie.model.content.RectangleShape a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        java.lang.String str = null;
        com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> animatableValue = null;
        com.airbnb.lottie.model.animatable.AnimatablePointValue animatablePointValue = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(a);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableValue = com.airbnb.lottie.parser.AnimatablePathValueParser.a(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatablePointValue = com.airbnb.lottie.parser.AnimatableValueParser.g(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                animatableFloatValue = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            } else if (selectName != 4) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new com.airbnb.lottie.model.content.RectangleShape(str, animatableValue, animatablePointValue, animatableFloatValue, z);
    }
}
