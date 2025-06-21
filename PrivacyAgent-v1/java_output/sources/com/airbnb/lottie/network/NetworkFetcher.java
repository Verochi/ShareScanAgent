package com.airbnb.lottie.network;

/* loaded from: classes.dex */
public class NetworkFetcher {

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.network.NetworkCache a;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.network.LottieNetworkFetcher b;

    public NetworkFetcher(@androidx.annotation.NonNull com.airbnb.lottie.network.NetworkCache networkCache, @androidx.annotation.NonNull com.airbnb.lottie.network.LottieNetworkFetcher lottieNetworkFetcher) {
        this.a = networkCache;
        this.b = lottieNetworkFetcher;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    public final com.airbnb.lottie.LottieComposition a(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        android.util.Pair<com.airbnb.lottie.network.FileExtension, java.io.InputStream> a;
        if (str2 == null || (a = this.a.a(str)) == null) {
            return null;
        }
        com.airbnb.lottie.network.FileExtension fileExtension = (com.airbnb.lottie.network.FileExtension) a.first;
        java.io.InputStream inputStream = (java.io.InputStream) a.second;
        com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromZipStreamSync = fileExtension == com.airbnb.lottie.network.FileExtension.ZIP ? com.airbnb.lottie.LottieCompositionFactory.fromZipStreamSync(new java.util.zip.ZipInputStream(inputStream), str) : com.airbnb.lottie.LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
        if (fromZipStreamSync.getValue() != null) {
            return fromZipStreamSync.getValue();
        }
        return null;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.WorkerThread
    public final com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> b(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        com.airbnb.lottie.utils.Logger.debug("Fetching " + str);
        java.io.Closeable closeable = null;
        try {
            try {
                com.airbnb.lottie.network.LottieFetchResult fetchSync = this.b.fetchSync(str);
                if (!fetchSync.isSuccessful()) {
                    com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> lottieResult = new com.airbnb.lottie.LottieResult<>(new java.lang.IllegalArgumentException(fetchSync.error()));
                    try {
                        fetchSync.close();
                    } catch (java.io.IOException e) {
                        com.airbnb.lottie.utils.Logger.warning("LottieFetchResult close failed ", e);
                    }
                    return lottieResult;
                }
                com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> c = c(str, fetchSync.bodyByteStream(), fetchSync.contentType(), str2);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(c.getValue() != null);
                com.airbnb.lottie.utils.Logger.debug(sb.toString());
                try {
                    fetchSync.close();
                } catch (java.io.IOException e2) {
                    com.airbnb.lottie.utils.Logger.warning("LottieFetchResult close failed ", e2);
                }
                return c;
            } catch (java.lang.Exception e3) {
                com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> lottieResult2 = new com.airbnb.lottie.LottieResult<>(e3);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (java.io.IOException e4) {
                        com.airbnb.lottie.utils.Logger.warning("LottieFetchResult close failed ", e4);
                    }
                }
                return lottieResult2;
            }
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (java.io.IOException e5) {
                    com.airbnb.lottie.utils.Logger.warning("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> c(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3) throws java.io.IOException {
        com.airbnb.lottie.network.FileExtension fileExtension;
        com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> e;
        if (str2 == null) {
            str2 = com.baidu.mobads.sdk.internal.am.d;
        }
        if (str2.contains("application/zip") || str.split("\\?")[0].endsWith(".lottie")) {
            com.airbnb.lottie.utils.Logger.debug("Handling zip response.");
            fileExtension = com.airbnb.lottie.network.FileExtension.ZIP;
            e = e(str, inputStream, str3);
        } else {
            com.airbnb.lottie.utils.Logger.debug("Received json response.");
            fileExtension = com.airbnb.lottie.network.FileExtension.JSON;
            e = d(str, inputStream, str3);
        }
        if (str3 != null && e.getValue() != null) {
            this.a.e(str, fileExtension);
        }
        return e;
    }

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> d(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.Nullable java.lang.String str2) throws java.io.IOException {
        return str2 == null ? com.airbnb.lottie.LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null) : com.airbnb.lottie.LottieCompositionFactory.fromJsonInputStreamSync(new java.io.FileInputStream(new java.io.File(this.a.f(str, inputStream, com.airbnb.lottie.network.FileExtension.JSON).getAbsolutePath())), str);
    }

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> e(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.Nullable java.lang.String str2) throws java.io.IOException {
        return str2 == null ? com.airbnb.lottie.LottieCompositionFactory.fromZipStreamSync(new java.util.zip.ZipInputStream(inputStream), null) : com.airbnb.lottie.LottieCompositionFactory.fromZipStreamSync(new java.util.zip.ZipInputStream(new java.io.FileInputStream(this.a.f(str, inputStream, com.airbnb.lottie.network.FileExtension.ZIP))), str);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.WorkerThread
    public com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fetchSync(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        com.airbnb.lottie.LottieComposition a = a(str, str2);
        if (a != null) {
            return new com.airbnb.lottie.LottieResult<>(a);
        }
        com.airbnb.lottie.utils.Logger.debug("Animation for " + str + " not found in cache. Fetching from network.");
        return b(str, str2);
    }
}
