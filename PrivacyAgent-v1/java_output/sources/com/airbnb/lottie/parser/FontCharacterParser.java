package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class FontCharacterParser {
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of(com.aliyun.common.log.struct.AliyunLogKey.KEY_CROP_HEIGHT, com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, com.anythink.expressad.foundation.h.i.e, "fFamily", "data");
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options b = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("shapes");

    public static com.airbnb.lottie.model.FontCharacter a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        jsonReader.beginObject();
        double d = 0.0d;
        java.lang.String str = null;
        java.lang.String str2 = null;
        double d2 = 0.0d;
        char c = 0;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(a);
            if (selectName == 0) {
                c = jsonReader.nextString().charAt(0);
            } else if (selectName == 1) {
                d2 = jsonReader.nextDouble();
            } else if (selectName == 2) {
                d = jsonReader.nextDouble();
            } else if (selectName == 3) {
                str = jsonReader.nextString();
            } else if (selectName == 4) {
                str2 = jsonReader.nextString();
            } else if (selectName != 5) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if (jsonReader.selectName(b) != 0) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList.add((com.airbnb.lottie.model.content.ShapeGroup) com.airbnb.lottie.parser.ContentModelParser.a(jsonReader, lottieComposition));
                        }
                        jsonReader.endArray();
                    }
                }
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
        return new com.airbnb.lottie.model.FontCharacter(arrayList, c, d2, d, str, str2);
    }
}
