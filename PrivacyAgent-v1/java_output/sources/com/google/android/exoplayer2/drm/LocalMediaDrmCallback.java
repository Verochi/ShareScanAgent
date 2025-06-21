package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public final class LocalMediaDrmCallback implements com.google.android.exoplayer2.drm.MediaDrmCallback {
    public final byte[] a;

    public LocalMediaDrmCallback(byte[] bArr) {
        this.a = (byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest keyRequest) {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest provisionRequest) {
        throw new java.lang.UnsupportedOperationException();
    }
}
