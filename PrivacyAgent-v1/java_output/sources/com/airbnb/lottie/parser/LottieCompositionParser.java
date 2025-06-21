package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
public class LottieCompositionParser {
    public static com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "h", "ip", "op", com.anythink.expressad.video.dynview.a.a.U, "v", "layers", "assets", "fonts", "chars", "markers");

    public static void a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition, java.util.List<com.airbnb.lottie.model.layer.Layer> list, androidx.collection.LongSparseArray<com.airbnb.lottie.model.layer.Layer> longSparseArray) throws java.io.IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            com.airbnb.lottie.model.layer.Layer parse = com.airbnb.lottie.parser.LayerParser.parse(jsonReader, lottieComposition);
            if (parse.getLayerType() == com.airbnb.lottie.model.layer.Layer.LayerType.IMAGE) {
                i++;
            }
            list.add(parse);
            longSparseArray.put(parse.getId(), parse);
            if (i > 4) {
                com.airbnb.lottie.utils.Logger.warning("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    public static com.airbnb.lottie.LottieComposition parse(com.airbnb.lottie.parser.moshi.JsonReader jsonReader) throws java.io.IOException {
        java.util.HashMap hashMap;
        java.util.ArrayList arrayList;
        com.airbnb.lottie.parser.moshi.JsonReader jsonReader2 = jsonReader;
        float dpScale = com.airbnb.lottie.utils.Utils.dpScale();
        androidx.collection.LongSparseArray<com.airbnb.lottie.model.layer.Layer> longSparseArray = new androidx.collection.LongSparseArray<>();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.HashMap hashMap2 = new java.util.HashMap();
        java.util.HashMap hashMap3 = new java.util.HashMap();
        java.util.HashMap hashMap4 = new java.util.HashMap();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        androidx.collection.SparseArrayCompat<com.airbnb.lottie.model.FontCharacter> sparseArrayCompat = new androidx.collection.SparseArrayCompat<>();
        com.airbnb.lottie.LottieComposition lottieComposition = new com.airbnb.lottie.LottieComposition();
        jsonReader.beginObject();
        int i = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(a)) {
                case 0:
                    i = jsonReader.nextInt();
                    break;
                case 1:
                    i2 = jsonReader.nextInt();
                    break;
                case 2:
                    f = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f3 = (float) jsonReader.nextDouble();
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 5:
                    java.lang.String[] split = jsonReader.nextString().split("\\.");
                    if (!com.airbnb.lottie.utils.Utils.isAtLeastVersion(java.lang.Integer.parseInt(split[0]), java.lang.Integer.parseInt(split[1]), java.lang.Integer.parseInt(split[2]), 4, 4, 0)) {
                        lottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 6:
                    a(jsonReader2, lottieComposition, arrayList2, longSparseArray);
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    jsonReader.skipValue();
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
            }
            jsonReader2 = jsonReader;
        }
        lottieComposition.init(new android.graphics.Rect(0, 0, (int) (i * dpScale), (int) (i2 * dpScale)), f, f2, f3, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return lottieComposition;
    }
}
