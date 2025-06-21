package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
public class ScaleXYParser implements com.airbnb.lottie.parser.ValueParser<com.airbnb.lottie.value.ScaleXY> {
    public static final com.airbnb.lottie.parser.ScaleXYParser INSTANCE = new com.airbnb.lottie.parser.ScaleXYParser();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public com.airbnb.lottie.value.ScaleXY parse(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f) throws java.io.IOException {
        boolean z = jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.airbnb.lottie.value.ScaleXY((nextDouble / 100.0f) * f, (nextDouble2 / 100.0f) * f);
    }
}
