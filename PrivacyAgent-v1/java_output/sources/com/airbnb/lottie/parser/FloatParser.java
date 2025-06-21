package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
public class FloatParser implements com.airbnb.lottie.parser.ValueParser<java.lang.Float> {
    public static final com.airbnb.lottie.parser.FloatParser INSTANCE = new com.airbnb.lottie.parser.FloatParser();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public java.lang.Float parse(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f) throws java.io.IOException {
        return java.lang.Float.valueOf(com.airbnb.lottie.parser.JsonUtils.g(jsonReader) * f);
    }
}
