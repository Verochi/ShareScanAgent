package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class ContentModelParser {
    public static com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of(com.alipay.sdk.m.s.a.f86s, "d");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00b6, code lost:
    
        if (r2.equals("gf") == false) goto L16;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.airbnb.lottie.model.content.ContentModel a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        com.airbnb.lottie.model.content.ContentModel contentModel;
        java.lang.String str;
        jsonReader.beginObject();
        char c = 2;
        int i = 2;
        while (true) {
            contentModel = null;
            if (!jsonReader.hasNext()) {
                str = null;
                break;
            }
            int selectName = jsonReader.selectName(a);
            if (selectName == 0) {
                str = jsonReader.nextString();
                break;
            }
            if (selectName != 1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                i = jsonReader.nextInt();
            }
        }
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3270:
                if (str.equals("fl")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3295:
                break;
            case 3307:
                if (str.equals("gr")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3308:
                if (str.equals("gs")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3488:
                if (str.equals("mm")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 3633:
                if (str.equals(com.anythink.core.common.h.c.R)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 3646:
                if (str.equals("rp")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 3669:
                if (str.equals(com.anythink.expressad.foundation.d.d.t)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3679:
                if (str.equals("sr")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3705:
                if (str.equals("tm")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 3710:
                if (str.equals("tr")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                contentModel = com.airbnb.lottie.parser.CircleShapeParser.a(jsonReader, lottieComposition, i);
                break;
            case 1:
                contentModel = com.airbnb.lottie.parser.ShapeFillParser.a(jsonReader, lottieComposition);
                break;
            case 2:
                contentModel = com.airbnb.lottie.parser.GradientFillParser.a(jsonReader, lottieComposition);
                break;
            case 3:
                contentModel = com.airbnb.lottie.parser.ShapeGroupParser.a(jsonReader, lottieComposition);
                break;
            case 4:
                contentModel = com.airbnb.lottie.parser.GradientStrokeParser.a(jsonReader, lottieComposition);
                break;
            case 5:
                contentModel = com.airbnb.lottie.parser.MergePathsParser.a(jsonReader);
                lottieComposition.addWarning("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                contentModel = com.airbnb.lottie.parser.RectangleShapeParser.a(jsonReader, lottieComposition);
                break;
            case 7:
                contentModel = com.airbnb.lottie.parser.RepeaterParser.a(jsonReader, lottieComposition);
                break;
            case '\b':
                contentModel = com.airbnb.lottie.parser.ShapePathParser.a(jsonReader, lottieComposition);
                break;
            case '\t':
                contentModel = com.airbnb.lottie.parser.PolystarShapeParser.a(jsonReader, lottieComposition);
                break;
            case '\n':
                contentModel = com.airbnb.lottie.parser.ShapeStrokeParser.a(jsonReader, lottieComposition);
                break;
            case 11:
                contentModel = com.airbnb.lottie.parser.ShapeTrimPathParser.a(jsonReader, lottieComposition);
                break;
            case '\f':
                contentModel = com.airbnb.lottie.parser.AnimatableTransformParser.parse(jsonReader, lottieComposition);
                break;
            default:
                com.airbnb.lottie.utils.Logger.warning("Unknown shape type " + str);
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return contentModel;
    }
}
