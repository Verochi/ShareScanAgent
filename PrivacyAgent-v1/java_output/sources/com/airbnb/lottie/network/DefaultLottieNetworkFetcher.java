package com.airbnb.lottie.network;

/* loaded from: classes.dex */
public class DefaultLottieNetworkFetcher implements com.airbnb.lottie.network.LottieNetworkFetcher {
    @Override // com.airbnb.lottie.network.LottieNetworkFetcher
    @androidx.annotation.NonNull
    public com.airbnb.lottie.network.LottieFetchResult fetchSync(@androidx.annotation.NonNull java.lang.String str) throws java.io.IOException {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new com.airbnb.lottie.network.DefaultLottieFetchResult(httpURLConnection);
    }
}
