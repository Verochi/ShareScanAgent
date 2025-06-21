package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
class MergePathsParser {
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("nm", "mm", "hd");

    public static com.airbnb.lottie.model.content.MergePaths a(com.airbnb.lottie.parser.moshi.JsonReader jsonReader) throws java.io.IOException {
        java.lang.String str = null;
        com.airbnb.lottie.model.content.MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(a);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                mergePathsMode = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.forId(jsonReader.nextInt());
            } else if (selectName != 2) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new com.airbnb.lottie.model.content.MergePaths(str, mergePathsMode, z);
    }
}
