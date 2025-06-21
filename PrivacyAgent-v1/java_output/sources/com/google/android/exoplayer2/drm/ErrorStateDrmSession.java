package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public final class ErrorStateDrmSession implements com.google.android.exoplayer2.drm.DrmSession {
    public final com.google.android.exoplayer2.drm.DrmSession.DrmSessionException a;

    public ErrorStateDrmSession(com.google.android.exoplayer2.drm.DrmSession.DrmSessionException drmSessionException) {
        this.a = (com.google.android.exoplayer2.drm.DrmSession.DrmSessionException) com.google.android.exoplayer2.util.Assertions.checkNotNull(drmSessionException);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void acquire(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DrmSession.DrmSessionException getError() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.ExoMediaCrypto getMediaCrypto() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @androidx.annotation.Nullable
    public byte[] getOfflineLicenseKeySetId() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @androidx.annotation.Nullable
    public java.util.Map<java.lang.String, java.lang.String> queryKeyStatus() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void release(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }
}
