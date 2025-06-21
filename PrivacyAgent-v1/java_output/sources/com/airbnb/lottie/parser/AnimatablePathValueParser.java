package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
public class AnimatablePathValueParser {
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("k", "x", "y");

    public static com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        jsonReader.beginObject();
        com.airbnb.lottie.model.animatable.AnimatablePathValue animatablePathValue = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2 = null;
        boolean z = false;
        while (jsonReader.peek() != com.airbnb.lottie.parser.moshi.JsonReader.Token.END_OBJECT) {
            int selectName = jsonReader.selectName(a);
            if (selectName == 0) {
                animatablePathValue = parse(jsonReader, lottieComposition);
            } else if (selectName != 1) {
                if (selectName != 2) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.STRING) {
                    jsonReader.skipValue();
                    z = true;
                } else {
                    animatableFloatValue2 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                }
            } else if (jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.STRING) {
                jsonReader.skipValue();
                z = true;
            } else {
                animatableFloatValue = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        if (z) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
        }
        return animatablePathValue != null ? animatablePathValue : new com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue(animatableFloatValue, animatableFloatValue2);
    }

    public static com.airbnb.lottie.model.animatable.AnimatablePathValue parse(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(com.airbnb.lottie.parser.PathKeyframeParser.a(jsonReader, lottieComposition));
            }
            jsonReader.endArray();
            com.airbnb.lottie.parser.KeyframesParser.b(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.value.Keyframe(com.airbnb.lottie.parser.JsonUtils.e(jsonReader, com.airbnb.lottie.utils.Utils.dpScale())));
        }
        return new com.airbnb.lottie.model.animatable.AnimatablePathValue(arrayList);
    }
}
