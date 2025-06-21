package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
public class IntegerParser implements com.airbnb.lottie.parser.ValueParser<java.lang.Integer> {
    public static final com.airbnb.lottie.parser.IntegerParser INSTANCE = new com.airbnb.lottie.parser.IntegerParser();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public java.lang.Integer parse(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f) throws java.io.IOException {
        return java.lang.Integer.valueOf(java.lang.Math.round(com.airbnb.lottie.parser.JsonUtils.g(jsonReader) * f));
    }
}
