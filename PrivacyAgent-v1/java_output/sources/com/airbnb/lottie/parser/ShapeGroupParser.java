package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class ShapeGroupParser {
    public static com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("nm", "hd", "it");

    public static com.airbnb.lottie.model.content.ShapeGroup a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.LottieComposition lottieComposition) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String str = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(a);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                z = jsonReader.nextBoolean();
            } else if (selectName != 2) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.airbnb.lottie.model.content.ContentModel a2 = com.airbnb.lottie.parser.ContentModelParser.a(jsonReader, lottieComposition);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                jsonReader.endArray();
            }
        }
        return new com.airbnb.lottie.model.content.ShapeGroup(str, arrayList, z);
    }
}
