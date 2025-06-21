package com.airbnb.lottie.network;

/* loaded from: classes.dex */
public interface LottieNetworkFetcher {
    @androidx.annotation.NonNull
    @androidx.annotation.WorkerThread
    com.airbnb.lottie.network.LottieFetchResult fetchSync(@androidx.annotation.NonNull java.lang.String str) throws java.io.IOException;
}
