package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class MediaSourceDrmHelper {

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.HttpDataSource.Factory a;

    @androidx.annotation.Nullable
    public java.lang.String b;

    public com.google.android.exoplayer2.drm.DrmSessionManager create(com.google.android.exoplayer2.MediaItem mediaItem) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties);
        com.google.android.exoplayer2.MediaItem.DrmConfiguration drmConfiguration = mediaItem.playbackProperties.drmConfiguration;
        if (drmConfiguration == null || drmConfiguration.licenseUri == null || com.google.android.exoplayer2.util.Util.SDK_INT < 18) {
            return defpackage.z60.c();
        }
        com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory = this.a;
        if (factory == null) {
            java.lang.String str = this.b;
            if (str == null) {
                str = com.google.android.exoplayer2.ExoPlayerLibraryInfo.DEFAULT_USER_AGENT;
            }
            factory = new com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory(str);
        }
        com.google.android.exoplayer2.drm.HttpMediaDrmCallback httpMediaDrmCallback = new com.google.android.exoplayer2.drm.HttpMediaDrmCallback(((android.net.Uri) com.google.android.exoplayer2.util.Util.castNonNull(drmConfiguration.licenseUri)).toString(), drmConfiguration.forceDefaultLicenseUri, factory);
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : drmConfiguration.requestHeaders.entrySet()) {
            httpMediaDrmCallback.setKeyRequestProperty(entry.getKey(), entry.getValue());
        }
        com.google.android.exoplayer2.drm.DefaultDrmSessionManager build = new com.google.android.exoplayer2.drm.DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(drmConfiguration.uuid, com.google.android.exoplayer2.drm.FrameworkMediaDrm.DEFAULT_PROVIDER).setMultiSession(drmConfiguration.multiSession).setPlayClearSamplesWithoutKeys(drmConfiguration.playClearContentWithoutKey).setUseDrmSessionsForClearContent(com.google.common.primitives.Ints.toArray(drmConfiguration.sessionForClearTypes)).build(httpMediaDrmCallback);
        build.setMode(0, drmConfiguration.getKeySetId());
        return build;
    }

    public void setDrmHttpDataSourceFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory) {
        this.a = factory;
    }

    public void setDrmUserAgent(@androidx.annotation.Nullable java.lang.String str) {
        this.b = str;
    }
}
