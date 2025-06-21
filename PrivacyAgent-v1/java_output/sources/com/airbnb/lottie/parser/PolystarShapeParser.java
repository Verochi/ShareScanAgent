package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class PolystarShapeParser {
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("nm", "sy", com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.PRIORITY_VALID_TIME, "p", "r", "or", "os", "ir", "is", "hd");

    public static com.airbnb.lottie.model.content.PolystarShape a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        java.lang.String str = null;
        com.airbnb.lottie.model.content.PolystarShape.Type type = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue = null;
        com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> animatableValue = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2 = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue3 = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue4 = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue5 = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue6 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(a)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    type = com.airbnb.lottie.model.content.PolystarShape.Type.forValue(jsonReader.nextInt());
                    break;
                case 2:
                    animatableFloatValue = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 3:
                    animatableValue = com.airbnb.lottie.parser.AnimatablePathValueParser.a(jsonReader, lottieComposition);
                    break;
                case 4:
                    animatableFloatValue2 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 5:
                    animatableFloatValue4 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    break;
                case 6:
                    animatableFloatValue6 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 7:
                    animatableFloatValue3 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    break;
                case 8:
                    animatableFloatValue5 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 9:
                    z = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.model.content.PolystarShape(str, type, animatableFloatValue, animatableValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4, animatableFloatValue5, animatableFloatValue6, z);
    }
}
