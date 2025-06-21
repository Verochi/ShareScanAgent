package com.google.android.exoplayer2;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public final class ExoPlayerFactory {
    @java.lang.Deprecated
    public static com.google.android.exoplayer2.ExoPlayer newInstance(android.content.Context context, com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector) {
        return newInstance(context, rendererArr, trackSelector, new com.google.android.exoplayer2.DefaultLoadControl());
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.ExoPlayer newInstance(android.content.Context context, com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl) {
        return newInstance(context, rendererArr, trackSelector, loadControl, com.google.android.exoplayer2.util.Util.getCurrentOrMainLooper());
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.ExoPlayer newInstance(android.content.Context context, com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, android.os.Looper looper) {
        return newInstance(context, rendererArr, trackSelector, loadControl, com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.getSingletonInstance(context), looper);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.ExoPlayer newInstance(android.content.Context context, com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, android.os.Looper looper) {
        return new com.google.android.exoplayer2.ExoPlayerImpl(rendererArr, trackSelector, new com.google.android.exoplayer2.source.DefaultMediaSourceFactory(context), loadControl, bandwidthMeter, null, true, com.google.android.exoplayer2.SeekParameters.DEFAULT, false, com.google.android.exoplayer2.util.Clock.DEFAULT, looper);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context) {
        return newSimpleInstance(context, new com.google.android.exoplayer2.trackselection.DefaultTrackSelector(context));
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector) {
        return newSimpleInstance(context, renderersFactory, trackSelector, new com.google.android.exoplayer2.DefaultLoadControl());
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, com.google.android.exoplayer2.util.Util.getCurrentOrMainLooper());
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, android.os.Looper looper) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, new com.google.android.exoplayer2.analytics.AnalyticsCollector(com.google.android.exoplayer2.util.Clock.DEFAULT), looper);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, analyticsCollector, com.google.android.exoplayer2.util.Util.getCurrentOrMainLooper());
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector, android.os.Looper looper) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.getSingletonInstance(context), analyticsCollector, looper);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
        return newSimpleInstance(context, renderersFactory, trackSelector, loadControl, bandwidthMeter, new com.google.android.exoplayer2.analytics.AnalyticsCollector(com.google.android.exoplayer2.util.Clock.DEFAULT), com.google.android.exoplayer2.util.Util.getCurrentOrMainLooper());
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector, android.os.Looper looper) {
        return new com.google.android.exoplayer2.SimpleExoPlayer(context, renderersFactory, trackSelector, new com.google.android.exoplayer2.source.DefaultMediaSourceFactory(context), loadControl, bandwidthMeter, analyticsCollector, true, com.google.android.exoplayer2.util.Clock.DEFAULT, looper);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector) {
        return newSimpleInstance(context, new com.google.android.exoplayer2.DefaultRenderersFactory(context), trackSelector);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl) {
        return newSimpleInstance(context, new com.google.android.exoplayer2.DefaultRenderersFactory(context), trackSelector, loadControl);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, int i) {
        return newSimpleInstance(context, new com.google.android.exoplayer2.DefaultRenderersFactory(context).setExtensionRendererMode(i), trackSelector, loadControl);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.SimpleExoPlayer newSimpleInstance(android.content.Context context, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, int i, long j) {
        return newSimpleInstance(context, new com.google.android.exoplayer2.DefaultRenderersFactory(context).setExtensionRendererMode(i).setAllowedVideoJoiningTimeMs(j), trackSelector, loadControl);
    }
}
