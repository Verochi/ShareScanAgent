package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class GradientStrokeParser {
    public static com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("nm", "g", "o", "t", "s", "e", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "lc", "lj", "ml", "hd", "d");
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options b = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("p", "k");
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options c = com.airbnb.lottie.parser.moshi.JsonReader.Options.of(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "v");

    public static com.airbnb.lottie.model.content.GradientStroke a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        java.lang.String str;
        com.airbnb.lottie.model.animatable.AnimatableGradientColorValue animatableGradientColorValue;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String str2 = null;
        com.airbnb.lottie.model.content.GradientType gradientType = null;
        com.airbnb.lottie.model.animatable.AnimatableGradientColorValue animatableGradientColorValue2 = null;
        com.airbnb.lottie.model.animatable.AnimatablePointValue animatablePointValue = null;
        com.airbnb.lottie.model.animatable.AnimatablePointValue animatablePointValue2 = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue = null;
        com.airbnb.lottie.model.content.ShapeStroke.LineCapType lineCapType = null;
        com.airbnb.lottie.model.content.ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2 = null;
        boolean z = false;
        com.airbnb.lottie.model.animatable.AnimatableIntegerValue animatableIntegerValue = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(a)) {
                case 0:
                    str2 = jsonReader.nextString();
                    continue;
                case 1:
                    str = str2;
                    jsonReader.beginObject();
                    int i = -1;
                    while (jsonReader.hasNext()) {
                        int selectName = jsonReader.selectName(b);
                        if (selectName != 0) {
                            animatableGradientColorValue = animatableGradientColorValue2;
                            if (selectName != 1) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            } else {
                                animatableGradientColorValue2 = com.airbnb.lottie.parser.AnimatableValueParser.e(jsonReader, lottieComposition, i);
                            }
                        } else {
                            animatableGradientColorValue = animatableGradientColorValue2;
                            i = jsonReader.nextInt();
                        }
                        animatableGradientColorValue2 = animatableGradientColorValue;
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    animatableIntegerValue = com.airbnb.lottie.parser.AnimatableValueParser.f(jsonReader, lottieComposition);
                    continue;
                case 3:
                    str = str2;
                    gradientType = jsonReader.nextInt() == 1 ? com.airbnb.lottie.model.content.GradientType.LINEAR : com.airbnb.lottie.model.content.GradientType.RADIAL;
                    break;
                case 4:
                    animatablePointValue = com.airbnb.lottie.parser.AnimatableValueParser.g(jsonReader, lottieComposition);
                    continue;
                case 5:
                    animatablePointValue2 = com.airbnb.lottie.parser.AnimatableValueParser.g(jsonReader, lottieComposition);
                    continue;
                case 6:
                    animatableFloatValue = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    continue;
                case 7:
                    str = str2;
                    lineCapType = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    break;
                case 8:
                    str = str2;
                    lineJoinType = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    break;
                case 9:
                    str = str2;
                    f = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    z = jsonReader.nextBoolean();
                    continue;
                case 11:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        java.lang.String str3 = null;
                        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue3 = null;
                        while (jsonReader.hasNext()) {
                            int selectName2 = jsonReader.selectName(c);
                            if (selectName2 != 0) {
                                com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue4 = animatableFloatValue2;
                                if (selectName2 != 1) {
                                    jsonReader.skipName();
                                    jsonReader.skipValue();
                                } else {
                                    animatableFloatValue3 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                                }
                                animatableFloatValue2 = animatableFloatValue4;
                            } else {
                                str3 = jsonReader.nextString();
                            }
                        }
                        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue5 = animatableFloatValue2;
                        jsonReader.endObject();
                        if (str3.equals("o")) {
                            animatableFloatValue2 = animatableFloatValue3;
                        } else {
                            if (str3.equals("d") || str3.equals("g")) {
                                lottieComposition.setHasDashPattern(true);
                                arrayList.add(animatableFloatValue3);
                            }
                            animatableFloatValue2 = animatableFloatValue5;
                        }
                    }
                    com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue6 = animatableFloatValue2;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    animatableFloatValue2 = animatableFloatValue6;
                    continue;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
            }
            str2 = str;
        }
        java.lang.String str4 = str2;
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new com.airbnb.lottie.model.animatable.AnimatableIntegerValue(java.util.Collections.singletonList(new com.airbnb.lottie.value.Keyframe(100)));
        }
        return new com.airbnb.lottie.model.content.GradientStroke(str4, gradientType, animatableGradientColorValue2, animatableIntegerValue, animatablePointValue, animatablePointValue2, animatableFloatValue, lineCapType, lineJoinType, f, arrayList, animatableFloatValue2, z);
    }
}
