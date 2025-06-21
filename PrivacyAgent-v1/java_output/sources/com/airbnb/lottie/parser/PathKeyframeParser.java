package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class PathKeyframeParser {
    public static com.airbnb.lottie.animation.keyframe.PathKeyframe a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        return new com.airbnb.lottie.animation.keyframe.PathKeyframe(lottieComposition, com.airbnb.lottie.parser.KeyframeParser.c(jsonReader, lottieComposition, com.airbnb.lottie.utils.Utils.dpScale(), com.airbnb.lottie.parser.PathParser.INSTANCE, jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT, false));
    }
}
