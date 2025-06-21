package com.google.android.exoplayer2.source.ads;

/* loaded from: classes22.dex */
public interface AdsLoader {

    public interface AdViewProvider {
        java.util.List<com.google.android.exoplayer2.source.ads.AdsLoader.OverlayInfo> getAdOverlayInfos();

        @java.lang.Deprecated
        android.view.View[] getAdOverlayViews();

        @androidx.annotation.Nullable
        android.view.ViewGroup getAdViewGroup();
    }

    public interface EventListener {
        void onAdClicked();

        void onAdLoadError(com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException adLoadException, com.google.android.exoplayer2.upstream.DataSpec dataSpec);

        void onAdPlaybackState(com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState);

        void onAdTapped();
    }

    public static final class OverlayInfo {
        public static final int PURPOSE_CLOSE_AD = 1;
        public static final int PURPOSE_CONTROLS = 0;
        public static final int PURPOSE_NOT_VISIBLE = 3;
        public static final int PURPOSE_OTHER = 2;
        public final int purpose;

        @androidx.annotation.Nullable
        public final java.lang.String reasonDetail;
        public final android.view.View view;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface Purpose {
        }

        public OverlayInfo(android.view.View view, int i) {
            this(view, i, null);
        }

        public OverlayInfo(android.view.View view, int i, @androidx.annotation.Nullable java.lang.String str) {
            this.view = view;
            this.purpose = i;
            this.reasonDetail = str;
        }
    }

    void handlePrepareComplete(int i, int i2);

    void handlePrepareError(int i, int i2, java.io.IOException iOException);

    void release();

    void setAdTagDataSpec(com.google.android.exoplayer2.upstream.DataSpec dataSpec);

    void setPlayer(@androidx.annotation.Nullable com.google.android.exoplayer2.Player player);

    void setSupportedContentTypes(int... iArr);

    void start(com.google.android.exoplayer2.source.ads.AdsLoader.EventListener eventListener, com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider adViewProvider);

    void stop();
}
