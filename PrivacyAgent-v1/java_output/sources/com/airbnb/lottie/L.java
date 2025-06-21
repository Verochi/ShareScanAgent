package com.airbnb.lottie;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class L {
    public static boolean DBG = false;
    public static final java.lang.String TAG = "LOTTIE";
    public static boolean a;
    public static java.lang.String[] b;
    public static long[] c;
    public static int d;
    public static int e;
    public static com.airbnb.lottie.network.LottieNetworkFetcher f;
    public static com.airbnb.lottie.network.LottieNetworkCacheProvider g;
    public static volatile com.airbnb.lottie.network.NetworkFetcher h;
    public static volatile com.airbnb.lottie.network.NetworkCache i;

    /* renamed from: com.airbnb.lottie.L$1, reason: invalid class name */
    public class AnonymousClass1 implements com.airbnb.lottie.network.LottieNetworkCacheProvider {
        public final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
        @androidx.annotation.NonNull
        public java.io.File getCacheDir() {
            return new java.io.File(this.a.getCacheDir(), "lottie_network_cache");
        }
    }

    public static void beginSection(java.lang.String str) {
        if (a) {
            int i2 = d;
            if (i2 == 20) {
                e++;
                return;
            }
            b[i2] = str;
            c[i2] = java.lang.System.nanoTime();
            androidx.core.os.TraceCompat.beginSection(str);
            d++;
        }
    }

    public static float endSection(java.lang.String str) {
        int i2 = e;
        if (i2 > 0) {
            e = i2 - 1;
            return 0.0f;
        }
        if (!a) {
            return 0.0f;
        }
        int i3 = d - 1;
        d = i3;
        if (i3 == -1) {
            throw new java.lang.IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(b[i3])) {
            androidx.core.os.TraceCompat.endSection();
            return (java.lang.System.nanoTime() - c[d]) / 1000000.0f;
        }
        throw new java.lang.IllegalStateException("Unbalanced trace call " + str + ". Expected " + b[d] + ".");
    }

    @androidx.annotation.NonNull
    public static com.airbnb.lottie.network.NetworkCache networkCache(@androidx.annotation.NonNull android.content.Context context) {
        com.airbnb.lottie.network.NetworkCache networkCache = i;
        if (networkCache == null) {
            synchronized (com.airbnb.lottie.network.NetworkCache.class) {
                networkCache = i;
                if (networkCache == null) {
                    com.airbnb.lottie.network.LottieNetworkCacheProvider lottieNetworkCacheProvider = g;
                    if (lottieNetworkCacheProvider == null) {
                        lottieNetworkCacheProvider = new com.airbnb.lottie.L.AnonymousClass1(context);
                    }
                    networkCache = new com.airbnb.lottie.network.NetworkCache(lottieNetworkCacheProvider);
                    i = networkCache;
                }
            }
        }
        return networkCache;
    }

    @androidx.annotation.NonNull
    public static com.airbnb.lottie.network.NetworkFetcher networkFetcher(@androidx.annotation.NonNull android.content.Context context) {
        com.airbnb.lottie.network.NetworkFetcher networkFetcher = h;
        if (networkFetcher == null) {
            synchronized (com.airbnb.lottie.network.NetworkFetcher.class) {
                networkFetcher = h;
                if (networkFetcher == null) {
                    com.airbnb.lottie.network.NetworkCache networkCache = networkCache(context);
                    com.airbnb.lottie.network.LottieNetworkFetcher lottieNetworkFetcher = f;
                    if (lottieNetworkFetcher == null) {
                        lottieNetworkFetcher = new com.airbnb.lottie.network.DefaultLottieNetworkFetcher();
                    }
                    networkFetcher = new com.airbnb.lottie.network.NetworkFetcher(networkCache, lottieNetworkFetcher);
                    h = networkFetcher;
                }
            }
        }
        return networkFetcher;
    }

    public static void setCacheProvider(com.airbnb.lottie.network.LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        g = lottieNetworkCacheProvider;
    }

    public static void setFetcher(com.airbnb.lottie.network.LottieNetworkFetcher lottieNetworkFetcher) {
        f = lottieNetworkFetcher;
    }

    public static void setTraceEnabled(boolean z) {
        if (a == z) {
            return;
        }
        a = z;
        if (z) {
            b = new java.lang.String[20];
            c = new long[20];
        }
    }
}
