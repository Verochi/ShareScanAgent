package com.airbnb.lottie;

/* loaded from: classes.dex */
public class Lottie {
    public static void initialize(@androidx.annotation.NonNull com.airbnb.lottie.LottieConfig lottieConfig) {
        com.airbnb.lottie.L.setFetcher(lottieConfig.a);
        com.airbnb.lottie.L.setCacheProvider(lottieConfig.b);
        com.airbnb.lottie.L.setTraceEnabled(lottieConfig.c);
    }
}
