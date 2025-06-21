package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
public class AnimatableTransformParser {
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options b = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("k");

    public static boolean a(com.airbnb.lottie.model.animatable.AnimatablePathValue animatablePathValue) {
        return animatablePathValue == null || (animatablePathValue.isStatic() && animatablePathValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f));
    }

    public static boolean b(com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> animatableValue) {
        return animatableValue == null || (!(animatableValue instanceof com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue) && animatableValue.isStatic() && animatableValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.isStatic() && ((java.lang.Float) ((com.airbnb.lottie.value.Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(com.airbnb.lottie.model.animatable.AnimatableScaleValue animatableScaleValue) {
        return animatableScaleValue == null || (animatableScaleValue.isStatic() && ((com.airbnb.lottie.value.ScaleXY) ((com.airbnb.lottie.value.Keyframe) animatableScaleValue.getKeyframes().get(0)).startValue).equals(1.0f, 1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean e(com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.isStatic() && ((java.lang.Float) ((com.airbnb.lottie.value.Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean f(com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.isStatic() && ((java.lang.Float) ((com.airbnb.lottie.value.Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.airbnb.lottie.model.animatable.AnimatableTransform parse(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        com.airbnb.lottie.model.animatable.AnimatableFloatValue parseFloat;
        boolean z = false;
        boolean z2 = jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT;
        if (z2) {
            jsonReader.beginObject();
        }
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue = null;
        com.airbnb.lottie.model.animatable.AnimatablePathValue animatablePathValue = null;
        com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> animatableValue = null;
        com.airbnb.lottie.model.animatable.AnimatableScaleValue animatableScaleValue = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2 = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue3 = null;
        com.airbnb.lottie.model.animatable.AnimatableIntegerValue animatableIntegerValue = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue4 = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue5 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(a)) {
                case 0:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.selectName(b) != 0) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            animatablePathValue = com.airbnb.lottie.parser.AnimatablePathValueParser.parse(jsonReader, lottieComposition);
                        }
                    }
                    jsonReader.endObject();
                    z = false;
                    break;
                case 1:
                    animatableValue = com.airbnb.lottie.parser.AnimatablePathValueParser.a(jsonReader, lottieComposition);
                    z = false;
                    break;
                case 2:
                    animatableScaleValue = com.airbnb.lottie.parser.AnimatableValueParser.h(jsonReader, lottieComposition);
                    z = false;
                    break;
                case 3:
                    lottieComposition.addWarning("Lottie doesn't support 3D layers.");
                    parseFloat = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z);
                    if (!parseFloat.getKeyframes().isEmpty()) {
                        parseFloat.getKeyframes().add(new com.airbnb.lottie.value.Keyframe(lottieComposition, java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(0.0f), null, 0.0f, java.lang.Float.valueOf(lottieComposition.getEndFrame())));
                    } else if (((com.airbnb.lottie.value.Keyframe) parseFloat.getKeyframes().get(0)).startValue == 0) {
                        parseFloat.getKeyframes().set(0, new com.airbnb.lottie.value.Keyframe(lottieComposition, java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(0.0f), null, 0.0f, java.lang.Float.valueOf(lottieComposition.getEndFrame())));
                        animatableFloatValue = parseFloat;
                        z = false;
                        break;
                    }
                    animatableFloatValue = parseFloat;
                    z = false;
                case 4:
                    parseFloat = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z);
                    if (!parseFloat.getKeyframes().isEmpty()) {
                    }
                    animatableFloatValue = parseFloat;
                    z = false;
                    break;
                case 5:
                    animatableIntegerValue = com.airbnb.lottie.parser.AnimatableValueParser.f(jsonReader, lottieComposition);
                    break;
                case 6:
                    animatableFloatValue4 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z);
                    break;
                case 7:
                    animatableFloatValue5 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z);
                    break;
                case 8:
                    animatableFloatValue2 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z);
                    break;
                case 9:
                    animatableFloatValue3 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z);
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    z = false;
                    break;
            }
        }
        if (z2) {
            jsonReader.endObject();
        }
        com.airbnb.lottie.model.animatable.AnimatablePathValue animatablePathValue2 = a(animatablePathValue) ? null : animatablePathValue;
        com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> animatableValue2 = b(animatableValue) ? null : animatableValue;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue6 = c(animatableFloatValue) ? null : animatableFloatValue;
        if (d(animatableScaleValue)) {
            animatableScaleValue = null;
        }
        return new com.airbnb.lottie.model.animatable.AnimatableTransform(animatablePathValue2, animatableValue2, animatableScaleValue, animatableFloatValue6, animatableIntegerValue, animatableFloatValue4, animatableFloatValue5, f(animatableFloatValue2) ? null : animatableFloatValue2, e(animatableFloatValue3) ? null : animatableFloatValue3);
    }
}
