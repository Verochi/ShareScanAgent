package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public interface ExoMediaDrm {
    public static final int EVENT_KEY_EXPIRED = 3;
    public static final int EVENT_KEY_REQUIRED = 2;
    public static final int EVENT_PROVISION_REQUIRED = 1;
    public static final int KEY_TYPE_OFFLINE = 2;
    public static final int KEY_TYPE_RELEASE = 3;
    public static final int KEY_TYPE_STREAMING = 1;

    public static final class AppManagedProvider implements com.google.android.exoplayer2.drm.ExoMediaDrm.Provider {
        public final com.google.android.exoplayer2.drm.ExoMediaDrm a;

        public AppManagedProvider(com.google.android.exoplayer2.drm.ExoMediaDrm exoMediaDrm) {
            this.a = exoMediaDrm;
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.Provider
        public com.google.android.exoplayer2.drm.ExoMediaDrm acquireExoMediaDrm(java.util.UUID uuid) {
            this.a.acquire();
            return this.a;
        }
    }

    public static final class KeyRequest {
        public final byte[] a;
        public final java.lang.String b;

        public KeyRequest(byte[] bArr, java.lang.String str) {
            this.a = bArr;
            this.b = str;
        }

        public byte[] getData() {
            return this.a;
        }

        public java.lang.String getLicenseServerUrl() {
            return this.b;
        }
    }

    public static final class KeyStatus {
        public final int a;
        public final byte[] b;

        public KeyStatus(int i, byte[] bArr) {
            this.a = i;
            this.b = bArr;
        }

        public byte[] getKeyId() {
            return this.b;
        }

        public int getStatusCode() {
            return this.a;
        }
    }

    public interface OnEventListener {
        void onEvent(com.google.android.exoplayer2.drm.ExoMediaDrm exoMediaDrm, @androidx.annotation.Nullable byte[] bArr, int i, int i2, @androidx.annotation.Nullable byte[] bArr2);
    }

    public interface OnExpirationUpdateListener {
        void onExpirationUpdate(com.google.android.exoplayer2.drm.ExoMediaDrm exoMediaDrm, byte[] bArr, long j);
    }

    public interface OnKeyStatusChangeListener {
        void onKeyStatusChange(com.google.android.exoplayer2.drm.ExoMediaDrm exoMediaDrm, byte[] bArr, java.util.List<com.google.android.exoplayer2.drm.ExoMediaDrm.KeyStatus> list, boolean z);
    }

    public interface Provider {
        com.google.android.exoplayer2.drm.ExoMediaDrm acquireExoMediaDrm(java.util.UUID uuid);
    }

    public static final class ProvisionRequest {
        public final byte[] a;
        public final java.lang.String b;

        public ProvisionRequest(byte[] bArr, java.lang.String str) {
            this.a = bArr;
            this.b = str;
        }

        public byte[] getData() {
            return this.a;
        }

        public java.lang.String getDefaultUrl() {
            return this.b;
        }
    }

    void acquire();

    void closeSession(byte[] bArr);

    com.google.android.exoplayer2.drm.ExoMediaCrypto createMediaCrypto(byte[] bArr) throws android.media.MediaCryptoException;

    java.lang.Class<? extends com.google.android.exoplayer2.drm.ExoMediaCrypto> getExoMediaCryptoType();

    com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list, int i, @androidx.annotation.Nullable java.util.HashMap<java.lang.String, java.lang.String> hashMap) throws android.media.NotProvisionedException;

    @androidx.annotation.Nullable
    android.os.PersistableBundle getMetrics();

    byte[] getPropertyByteArray(java.lang.String str);

    java.lang.String getPropertyString(java.lang.String str);

    com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest getProvisionRequest();

    byte[] openSession() throws android.media.MediaDrmException;

    @androidx.annotation.Nullable
    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws android.media.NotProvisionedException, android.media.DeniedByServerException;

    void provideProvisionResponse(byte[] bArr) throws android.media.DeniedByServerException;

    java.util.Map<java.lang.String, java.lang.String> queryKeyStatus(byte[] bArr);

    void release();

    void restoreKeys(byte[] bArr, byte[] bArr2);

    void setOnEventListener(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener onEventListener);

    void setOnExpirationUpdateListener(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener);

    void setOnKeyStatusChangeListener(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener);

    void setPropertyByteArray(java.lang.String str, byte[] bArr);

    void setPropertyString(java.lang.String str, java.lang.String str2);
}
