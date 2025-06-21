package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
public class PathParser implements com.airbnb.lottie.parser.ValueParser<android.graphics.PointF> {
    public static final com.airbnb.lottie.parser.PathParser INSTANCE = new com.airbnb.lottie.parser.PathParser();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public android.graphics.PointF parse(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f) throws java.io.IOException {
        return com.airbnb.lottie.parser.JsonUtils.e(jsonReader, f);
    }
}
