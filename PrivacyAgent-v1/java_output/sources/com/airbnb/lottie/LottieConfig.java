package com.airbnb.lottie;

/* loaded from: classes.dex */
public class LottieConfig {

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.network.LottieNetworkFetcher a;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.network.LottieNetworkCacheProvider b;
    public final boolean c;

    public static final class Builder {

        @androidx.annotation.Nullable
        public com.airbnb.lottie.network.LottieNetworkFetcher a;

        @androidx.annotation.Nullable
        public com.airbnb.lottie.network.LottieNetworkCacheProvider b;
        public boolean c = false;

        /* renamed from: com.airbnb.lottie.LottieConfig$Builder$1, reason: invalid class name */
        public class AnonymousClass1 implements com.airbnb.lottie.network.LottieNetworkCacheProvider {
            public final /* synthetic */ java.io.File a;

            public AnonymousClass1(java.io.File file) {
                this.a = file;
            }

            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
            @androidx.annotation.NonNull
            public java.io.File getCacheDir() {
                if (this.a.isDirectory()) {
                    return this.a;
                }
                throw new java.lang.IllegalArgumentException("cache file must be a directory");
            }
        }

        /* renamed from: com.airbnb.lottie.LottieConfig$Builder$2, reason: invalid class name */
        public class AnonymousClass2 implements com.airbnb.lottie.network.LottieNetworkCacheProvider {
            public final /* synthetic */ com.airbnb.lottie.network.LottieNetworkCacheProvider a;

            public AnonymousClass2(com.airbnb.lottie.network.LottieNetworkCacheProvider lottieNetworkCacheProvider) {
                this.a = lottieNetworkCacheProvider;
            }

            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
            @androidx.annotation.NonNull
            public java.io.File getCacheDir() {
                java.io.File cacheDir = this.a.getCacheDir();
                if (cacheDir.isDirectory()) {
                    return cacheDir;
                }
                throw new java.lang.IllegalArgumentException("cache file must be a directory");
            }
        }

        @androidx.annotation.NonNull
        public com.airbnb.lottie.LottieConfig build() {
            return new com.airbnb.lottie.LottieConfig(this.a, this.b, this.c, null);
        }

        @androidx.annotation.NonNull
        public com.airbnb.lottie.LottieConfig.Builder setEnableSystraceMarkers(boolean z) {
            this.c = z;
            return this;
        }

        @androidx.annotation.NonNull
        public com.airbnb.lottie.LottieConfig.Builder setNetworkCacheDir(@androidx.annotation.NonNull java.io.File file) {
            if (this.b != null) {
                throw new java.lang.IllegalStateException("There is already a cache provider!");
            }
            this.b = new com.airbnb.lottie.LottieConfig.Builder.AnonymousClass1(file);
            return this;
        }

        @androidx.annotation.NonNull
        public com.airbnb.lottie.LottieConfig.Builder setNetworkCacheProvider(@androidx.annotation.NonNull com.airbnb.lottie.network.LottieNetworkCacheProvider lottieNetworkCacheProvider) {
            if (this.b != null) {
                throw new java.lang.IllegalStateException("There is already a cache provider!");
            }
            this.b = new com.airbnb.lottie.LottieConfig.Builder.AnonymousClass2(lottieNetworkCacheProvider);
            return this;
        }

        @androidx.annotation.NonNull
        public com.airbnb.lottie.LottieConfig.Builder setNetworkFetcher(@androidx.annotation.NonNull com.airbnb.lottie.network.LottieNetworkFetcher lottieNetworkFetcher) {
            this.a = lottieNetworkFetcher;
            return this;
        }
    }

    public LottieConfig(@androidx.annotation.Nullable com.airbnb.lottie.network.LottieNetworkFetcher lottieNetworkFetcher, @androidx.annotation.Nullable com.airbnb.lottie.network.LottieNetworkCacheProvider lottieNetworkCacheProvider, boolean z) {
        this.a = lottieNetworkFetcher;
        this.b = lottieNetworkCacheProvider;
        this.c = z;
    }

    public /* synthetic */ LottieConfig(com.airbnb.lottie.network.LottieNetworkFetcher lottieNetworkFetcher, com.airbnb.lottie.network.LottieNetworkCacheProvider lottieNetworkCacheProvider, boolean z, com.airbnb.lottie.LottieConfig.AnonymousClass1 anonymousClass1) {
        this(lottieNetworkFetcher, lottieNetworkCacheProvider, z);
    }
}
