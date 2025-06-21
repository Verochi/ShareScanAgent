package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
public class AnimatableTextPropertiesParser {
    public static com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("a");
    public static com.airbnb.lottie.parser.moshi.JsonReader.Options b = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("fc", "sc", "sw", "t");

    public static com.airbnb.lottie.model.animatable.AnimatableTextProperties a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        jsonReader.beginObject();
        com.airbnb.lottie.model.animatable.AnimatableColorValue animatableColorValue = null;
        com.airbnb.lottie.model.animatable.AnimatableColorValue animatableColorValue2 = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(b);
            if (selectName == 0) {
                animatableColorValue = com.airbnb.lottie.parser.AnimatableValueParser.c(jsonReader, lottieComposition);
            } else if (selectName == 1) {
                animatableColorValue2 = com.airbnb.lottie.parser.AnimatableValueParser.c(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatableFloatValue = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            } else if (selectName != 3) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                animatableFloatValue2 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        return new com.airbnb.lottie.model.animatable.AnimatableTextProperties(animatableColorValue, animatableColorValue2, animatableFloatValue, animatableFloatValue2);
    }

    public static com.airbnb.lottie.model.animatable.AnimatableTextProperties parse(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        jsonReader.beginObject();
        com.airbnb.lottie.model.animatable.AnimatableTextProperties animatableTextProperties = null;
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(a) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                animatableTextProperties = a(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        return animatableTextProperties == null ? new com.airbnb.lottie.model.animatable.AnimatableTextProperties(null, null, null, null) : animatableTextProperties;
    }
}
