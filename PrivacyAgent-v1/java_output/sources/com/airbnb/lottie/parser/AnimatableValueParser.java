package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
public class AnimatableValueParser {
    public static <T> java.util.List<com.airbnb.lottie.value.Keyframe<T>> a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f, com.airbnb.lottie.LottieComposition lottieComposition, com.airbnb.lottie.parser.ValueParser<T> valueParser) throws java.io.IOException {
        return com.airbnb.lottie.parser.KeyframesParser.a(jsonReader, lottieComposition, f, valueParser, false);
    }

    public static <T> java.util.List<com.airbnb.lottie.value.Keyframe<T>> b(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition, com.airbnb.lottie.parser.ValueParser<T> valueParser) throws java.io.IOException {
        return com.airbnb.lottie.parser.KeyframesParser.a(jsonReader, lottieComposition, 1.0f, valueParser, false);
    }

    public static com.airbnb.lottie.model.animatable.AnimatableColorValue c(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        return new com.airbnb.lottie.model.animatable.AnimatableColorValue(b(jsonReader, lottieComposition, com.airbnb.lottie.parser.ColorParser.INSTANCE));
    }

    public static com.airbnb.lottie.model.animatable.AnimatableTextFrame d(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        return new com.airbnb.lottie.model.animatable.AnimatableTextFrame(b(jsonReader, lottieComposition, com.airbnb.lottie.parser.DocumentDataParser.INSTANCE));
    }

    public static com.airbnb.lottie.model.animatable.AnimatableGradientColorValue e(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition, int i) throws java.io.IOException {
        return new com.airbnb.lottie.model.animatable.AnimatableGradientColorValue(b(jsonReader, lottieComposition, new com.airbnb.lottie.parser.GradientColorParser(i)));
    }

    public static com.airbnb.lottie.model.animatable.AnimatableIntegerValue f(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        return new com.airbnb.lottie.model.animatable.AnimatableIntegerValue(b(jsonReader, lottieComposition, com.airbnb.lottie.parser.IntegerParser.INSTANCE));
    }

    public static com.airbnb.lottie.model.animatable.AnimatablePointValue g(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        return new com.airbnb.lottie.model.animatable.AnimatablePointValue(com.airbnb.lottie.parser.KeyframesParser.a(jsonReader, lottieComposition, com.airbnb.lottie.utils.Utils.dpScale(), com.airbnb.lottie.parser.PointFParser.INSTANCE, true));
    }

    public static com.airbnb.lottie.model.animatable.AnimatableScaleValue h(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        return new com.airbnb.lottie.model.animatable.AnimatableScaleValue((java.util.List<com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.value.ScaleXY>>) b(jsonReader, lottieComposition, com.airbnb.lottie.parser.ScaleXYParser.INSTANCE));
    }

    public static com.airbnb.lottie.model.animatable.AnimatableShapeValue i(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        return new com.airbnb.lottie.model.animatable.AnimatableShapeValue(a(jsonReader, com.airbnb.lottie.utils.Utils.dpScale(), lottieComposition, com.airbnb.lottie.parser.ShapeDataParser.INSTANCE));
    }

    public static com.airbnb.lottie.model.animatable.AnimatableFloatValue parseFloat(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        return parseFloat(jsonReader, lottieComposition, true);
    }

    public static com.airbnb.lottie.model.animatable.AnimatableFloatValue parseFloat(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition, boolean z) throws java.io.IOException {
        return new com.airbnb.lottie.model.animatable.AnimatableFloatValue(a(jsonReader, z ? com.airbnb.lottie.utils.Utils.dpScale() : 1.0f, lottieComposition, com.airbnb.lottie.parser.FloatParser.INSTANCE));
    }
}
