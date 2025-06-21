package com.google.android.exoplayer2.drm;

@androidx.annotation.RequiresApi(18)
/* loaded from: classes22.dex */
public final class DummyExoMediaDrm implements com.google.android.exoplayer2.drm.ExoMediaDrm {
    public static com.google.android.exoplayer2.drm.DummyExoMediaDrm getInstance() {
        return new com.google.android.exoplayer2.drm.DummyExoMediaDrm();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void acquire() {
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void closeSession(byte[] bArr) {
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public com.google.android.exoplayer2.drm.ExoMediaCrypto createMediaCrypto(byte[] bArr) {
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public java.lang.Class<com.google.android.exoplayer2.drm.UnsupportedMediaCrypto> getExoMediaCryptoType() {
        return com.google.android.exoplayer2.drm.UnsupportedMediaCrypto.class;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list, int i, @androidx.annotation.Nullable java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @androidx.annotation.Nullable
    public android.os.PersistableBundle getMetrics() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] getPropertyByteArray(java.lang.String str) {
        return com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public java.lang.String getPropertyString(java.lang.String str) {
        return "";
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] openSession() throws android.media.MediaDrmException {
        throw new android.media.MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @androidx.annotation.Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void provideProvisionResponse(byte[] bArr) {
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public java.util.Map<java.lang.String, java.lang.String> queryKeyStatus(byte[] bArr) {
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void release() {
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnEventListener(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener onEventListener) {
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnExpirationUpdateListener(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnKeyStatusChangeListener(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyByteArray(java.lang.String str, byte[] bArr) {
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyString(java.lang.String str, java.lang.String str2) {
    }
}
