package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public interface MediaDrmCallback {
    byte[] executeKeyRequest(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest keyRequest) throws com.google.android.exoplayer2.drm.MediaDrmCallbackException;

    byte[] executeProvisionRequest(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest provisionRequest) throws com.google.android.exoplayer2.drm.MediaDrmCallbackException;
}
