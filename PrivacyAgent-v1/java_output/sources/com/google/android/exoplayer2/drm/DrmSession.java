package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public interface DrmSession {
    public static final int STATE_ERROR = 1;
    public static final int STATE_OPENED = 3;
    public static final int STATE_OPENED_WITH_KEYS = 4;
    public static final int STATE_OPENING = 2;
    public static final int STATE_RELEASED = 0;

    public static class DrmSessionException extends java.io.IOException {
        public DrmSessionException(java.lang.Throwable th) {
            super(th);
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface State {
    }

    void acquire(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher);

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.drm.DrmSession.DrmSessionException getError();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.drm.ExoMediaCrypto getMediaCrypto();

    @androidx.annotation.Nullable
    byte[] getOfflineLicenseKeySetId();

    int getState();

    boolean playClearSamplesWithoutKeys();

    @androidx.annotation.Nullable
    java.util.Map<java.lang.String, java.lang.String> queryKeyStatus();

    void release(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher);
}
