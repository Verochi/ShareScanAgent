package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
public class LayerParser {
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("nm", "ind", "refId", com.alipay.sdk.m.s.a.f86s, "parent", "sw", com.anythink.expressad.foundation.d.d.t, "sc", com.bytedance.sdk.openadsdk.mediation.MediationConstant.ADN_KS, "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "h", "ip", "op", "tm", "cl", "hd");
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options b = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("d", "a");
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options c = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("nm");

    /* renamed from: com.airbnb.lottie.parser.LayerParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.airbnb.lottie.model.layer.Layer.MatteType.values().length];
            a = iArr;
            try {
                iArr[com.airbnb.lottie.model.layer.Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.airbnb.lottie.model.layer.Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public static com.airbnb.lottie.model.layer.Layer parse(com.airbnb.lottie.LottieComposition lottieComposition) {
        android.graphics.Rect bounds = lottieComposition.getBounds();
        return new com.airbnb.lottie.model.layer.Layer(java.util.Collections.emptyList(), lottieComposition, "__container", -1L, com.airbnb.lottie.model.layer.Layer.LayerType.PRE_COMP, -1L, null, java.util.Collections.emptyList(), new com.airbnb.lottie.model.animatable.AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, java.util.Collections.emptyList(), com.airbnb.lottie.model.layer.Layer.MatteType.NONE, null, false);
    }

    public static com.airbnb.lottie.model.layer.Layer parse(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        java.util.ArrayList arrayList;
        java.util.ArrayList arrayList2;
        com.airbnb.lottie.model.layer.Layer.MatteType matteType = com.airbnb.lottie.model.layer.Layer.MatteType.NONE;
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        jsonReader.beginObject();
        java.lang.Float valueOf = java.lang.Float.valueOf(1.0f);
        java.lang.Float valueOf2 = java.lang.Float.valueOf(0.0f);
        com.airbnb.lottie.model.layer.Layer.MatteType matteType2 = matteType;
        java.lang.String str = "UNSET";
        java.lang.String str2 = null;
        com.airbnb.lottie.model.animatable.AnimatableTransform animatableTransform = null;
        com.airbnb.lottie.model.animatable.AnimatableTextFrame animatableTextFrame = null;
        com.airbnb.lottie.model.animatable.AnimatableTextProperties animatableTextProperties = null;
        com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue = null;
        long j = 0;
        long j2 = -1;
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        float f3 = 1.0f;
        float f4 = 0.0f;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        java.lang.String str3 = null;
        com.airbnb.lottie.model.layer.Layer.LayerType layerType = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(a)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    j = jsonReader.nextInt();
                    break;
                case 2:
                    str2 = jsonReader.nextString();
                    break;
                case 3:
                    int nextInt = jsonReader.nextInt();
                    layerType = com.airbnb.lottie.model.layer.Layer.LayerType.UNKNOWN;
                    if (nextInt >= layerType.ordinal()) {
                        break;
                    } else {
                        layerType = com.airbnb.lottie.model.layer.Layer.LayerType.values()[nextInt];
                        break;
                    }
                case 4:
                    j2 = jsonReader.nextInt();
                    break;
                case 5:
                    i = (int) (jsonReader.nextInt() * com.airbnb.lottie.utils.Utils.dpScale());
                    break;
                case 6:
                    i2 = (int) (jsonReader.nextInt() * com.airbnb.lottie.utils.Utils.dpScale());
                    break;
                case 7:
                    i3 = android.graphics.Color.parseColor(jsonReader.nextString());
                    break;
                case 8:
                    animatableTransform = com.airbnb.lottie.parser.AnimatableTransformParser.parse(jsonReader, lottieComposition);
                    break;
                case 9:
                    int nextInt2 = jsonReader.nextInt();
                    if (nextInt2 < com.airbnb.lottie.model.layer.Layer.MatteType.values().length) {
                        matteType2 = com.airbnb.lottie.model.layer.Layer.MatteType.values()[nextInt2];
                        int i6 = com.airbnb.lottie.parser.LayerParser.AnonymousClass1.a[matteType2.ordinal()];
                        if (i6 == 1) {
                            lottieComposition.addWarning("Unsupported matte type: Luma");
                        } else if (i6 == 2) {
                            lottieComposition.addWarning("Unsupported matte type: Luma Inverted");
                        }
                        lottieComposition.incrementMatteOrMaskCount(1);
                        break;
                    } else {
                        lottieComposition.addWarning("Unsupported matte type: " + nextInt2);
                        break;
                    }
                case 10:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList3.add(com.airbnb.lottie.parser.MaskParser.a(jsonReader, lottieComposition));
                    }
                    lottieComposition.incrementMatteOrMaskCount(arrayList3.size());
                    jsonReader.endArray();
                    break;
                case 11:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.airbnb.lottie.model.content.ContentModel a2 = com.airbnb.lottie.parser.ContentModelParser.a(jsonReader, lottieComposition);
                        if (a2 != null) {
                            arrayList4.add(a2);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case 12:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        int selectName = jsonReader.selectName(b);
                        if (selectName == 0) {
                            animatableTextFrame = com.airbnb.lottie.parser.AnimatableValueParser.d(jsonReader, lottieComposition);
                        } else if (selectName != 1) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                animatableTextProperties = com.airbnb.lottie.parser.AnimatableTextPropertiesParser.parse(jsonReader, lottieComposition);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 13:
                    jsonReader.beginArray();
                    java.util.ArrayList arrayList5 = new java.util.ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            if (jsonReader.selectName(c) != 0) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            } else {
                                arrayList5.add(jsonReader.nextString());
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    lottieComposition.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f3 = (float) jsonReader.nextDouble();
                    break;
                case 15:
                    f4 = (float) jsonReader.nextDouble();
                    break;
                case 16:
                    i4 = (int) (jsonReader.nextInt() * com.airbnb.lottie.utils.Utils.dpScale());
                    break;
                case 17:
                    i5 = (int) (jsonReader.nextInt() * com.airbnb.lottie.utils.Utils.dpScale());
                    break;
                case 18:
                    f = (float) jsonReader.nextDouble();
                    break;
                case 19:
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case 20:
                    animatableFloatValue = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 21:
                    str3 = jsonReader.nextString();
                    break;
                case 22:
                    z = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        float f5 = f / f3;
        float f6 = f2 / f3;
        java.util.ArrayList arrayList6 = new java.util.ArrayList();
        if (f5 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new com.airbnb.lottie.value.Keyframe(lottieComposition, valueOf2, valueOf2, null, 0.0f, java.lang.Float.valueOf(f5)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f6 <= 0.0f) {
            f6 = lottieComposition.getEndFrame();
        }
        arrayList2.add(new com.airbnb.lottie.value.Keyframe(lottieComposition, valueOf, valueOf, null, f5, java.lang.Float.valueOf(f6)));
        arrayList2.add(new com.airbnb.lottie.value.Keyframe(lottieComposition, valueOf2, valueOf2, null, f6, java.lang.Float.valueOf(Float.MAX_VALUE)));
        if (str.endsWith(".ai") || com.anythink.expressad.d.a.b.cZ.equals(str3)) {
            lottieComposition.addWarning("Convert your Illustrator layers to shape layers.");
        }
        return new com.airbnb.lottie.model.layer.Layer(arrayList4, lottieComposition, str, j, layerType, j2, str2, arrayList, animatableTransform, i, i2, i3, f3, f4, i4, i5, animatableTextFrame, animatableTextProperties, arrayList2, matteType2, animatableFloatValue, z);
    }
}
