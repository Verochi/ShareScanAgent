package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class ShapeStrokeParser {
    public static com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("nm", "c", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "o", "lc", "lj", "ml", "hd", "d");
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options b = com.airbnb.lottie.parser.moshi.JsonReader.Options.of(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "v");

    public static com.airbnb.lottie.model.content.ShapeStroke a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String str = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2 = null;
        com.airbnb.lottie.model.animatable.AnimatableColorValue animatableColorValue = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue3 = null;
        com.airbnb.lottie.model.content.ShapeStroke.LineCapType lineCapType = null;
        com.airbnb.lottie.model.content.ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        boolean z = false;
        com.airbnb.lottie.model.animatable.AnimatableIntegerValue animatableIntegerValue = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(a)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    animatableColorValue = com.airbnb.lottie.parser.AnimatableValueParser.c(jsonReader, lottieComposition);
                    break;
                case 2:
                    animatableFloatValue3 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    break;
                case 3:
                    animatableIntegerValue = com.airbnb.lottie.parser.AnimatableValueParser.f(jsonReader, lottieComposition);
                    break;
                case 4:
                    lineCapType = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    break;
                case 5:
                    lineJoinType = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    break;
                case 6:
                    f = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    z = jsonReader.nextBoolean();
                    break;
                case 8:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        java.lang.String str2 = null;
                        animatableFloatValue = null;
                        while (jsonReader.hasNext()) {
                            int selectName = jsonReader.selectName(b);
                            if (selectName == 0) {
                                str2 = jsonReader.nextString();
                            } else if (selectName != 1) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            } else {
                                animatableFloatValue = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                            }
                        }
                        jsonReader.endObject();
                        str2.hashCode();
                        switch (str2) {
                            case "d":
                            case "g":
                                lottieComposition.setHasDashPattern(true);
                                arrayList.add(animatableFloatValue);
                                break;
                            case "o":
                                animatableFloatValue2 = animatableFloatValue;
                                break;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new com.airbnb.lottie.model.animatable.AnimatableIntegerValue(java.util.Collections.singletonList(new com.airbnb.lottie.value.Keyframe(100)));
        }
        return new com.airbnb.lottie.model.content.ShapeStroke(str, animatableFloatValue2, arrayList, animatableColorValue, animatableIntegerValue, animatableFloatValue3, lineCapType, lineJoinType, f, z);
    }
}
