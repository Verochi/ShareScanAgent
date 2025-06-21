package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class FontParser {
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("fFamily", "fName", "fStyle", "ascent");

    public static com.airbnb.lottie.model.Font a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader) throws java.io.IOException {
        jsonReader.beginObject();
        java.lang.String str = null;
        java.lang.String str2 = null;
        java.lang.String str3 = null;
        float f = 0.0f;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(a);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                str2 = jsonReader.nextString();
            } else if (selectName == 2) {
                str3 = jsonReader.nextString();
            } else if (selectName != 3) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                f = (float) jsonReader.nextDouble();
            }
        }
        jsonReader.endObject();
        return new com.airbnb.lottie.model.Font(str, str2, str3, f);
    }
}
