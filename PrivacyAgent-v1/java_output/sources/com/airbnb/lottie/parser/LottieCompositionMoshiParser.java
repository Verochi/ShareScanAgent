package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
public class LottieCompositionMoshiParser {
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "h", "ip", "op", com.anythink.expressad.video.dynview.a.a.U, "v", "layers", "assets", "fonts", "chars", "markers");
    public static com.airbnb.lottie.parser.moshi.JsonReader.Options b = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("id", "layers", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "h", "p", com.umeng.analytics.pro.bo.aN);
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options c = com.airbnb.lottie.parser.moshi.JsonReader.Options.of(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST);
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options d = com.airbnb.lottie.parser.moshi.JsonReader.Options.of(com.aliyun.common.log.struct.AliyunLogKey.KEY_CROP_MODE, "tm", "dr");

    public static void a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition, java.util.Map<java.lang.String, java.util.List<com.airbnb.lottie.model.layer.Layer>> map, java.util.Map<java.lang.String, com.airbnb.lottie.LottieImageAsset> map2) throws java.io.IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            androidx.collection.LongSparseArray longSparseArray = new androidx.collection.LongSparseArray();
            jsonReader.beginObject();
            java.lang.String str = null;
            java.lang.String str2 = null;
            java.lang.String str3 = null;
            int i = 0;
            int i2 = 0;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(b);
                if (selectName == 0) {
                    str = jsonReader.nextString();
                } else if (selectName == 1) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.airbnb.lottie.model.layer.Layer parse = com.airbnb.lottie.parser.LayerParser.parse(jsonReader, lottieComposition);
                        longSparseArray.put(parse.getId(), parse);
                        arrayList.add(parse);
                    }
                    jsonReader.endArray();
                } else if (selectName == 2) {
                    i = jsonReader.nextInt();
                } else if (selectName == 3) {
                    i2 = jsonReader.nextInt();
                } else if (selectName == 4) {
                    str2 = jsonReader.nextString();
                } else if (selectName != 5) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    str3 = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                com.airbnb.lottie.LottieImageAsset lottieImageAsset = new com.airbnb.lottie.LottieImageAsset(i, i2, str, str2, str3);
                map2.put(lottieImageAsset.getId(), lottieImageAsset);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.endArray();
    }

    public static void b(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition, androidx.collection.SparseArrayCompat<com.airbnb.lottie.model.FontCharacter> sparseArrayCompat) throws java.io.IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.airbnb.lottie.model.FontCharacter a2 = com.airbnb.lottie.parser.FontCharacterParser.a(jsonReader, lottieComposition);
            sparseArrayCompat.put(a2.hashCode(), a2);
        }
        jsonReader.endArray();
    }

    public static void c(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, java.util.Map<java.lang.String, com.airbnb.lottie.model.Font> map) throws java.io.IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(c) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.airbnb.lottie.model.Font a2 = com.airbnb.lottie.parser.FontParser.a(jsonReader);
                    map.put(a2.getName(), a2);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }

    public static void d(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition, java.util.List<com.airbnb.lottie.model.layer.Layer> list, androidx.collection.LongSparseArray<com.airbnb.lottie.model.layer.Layer> longSparseArray) throws java.io.IOException {
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

    public static void e(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition, java.util.List<com.airbnb.lottie.model.Marker> list) throws java.io.IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float f = 0.0f;
            java.lang.String str = null;
            float f2 = 0.0f;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(d);
                if (selectName == 0) {
                    str = jsonReader.nextString();
                } else if (selectName == 1) {
                    f = (float) jsonReader.nextDouble();
                } else if (selectName != 2) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    f2 = (float) jsonReader.nextDouble();
                }
            }
            jsonReader.endObject();
            list.add(new com.airbnb.lottie.model.Marker(str, f, f2));
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
                    d(jsonReader2, lottieComposition, arrayList2, longSparseArray);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 7:
                    a(jsonReader2, lottieComposition, hashMap2, hashMap3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 8:
                    c(jsonReader2, hashMap4);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 9:
                    b(jsonReader2, lottieComposition, sparseArrayCompat);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                case 10:
                    e(jsonReader2, lottieComposition, arrayList3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    arrayList3 = arrayList;
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    jsonReader.skipName();
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
