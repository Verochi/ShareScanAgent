package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
interface ValueParser<V> {
    V parse(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f) throws java.io.IOException;
}
