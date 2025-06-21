package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public interface DrmSessionManager {
    public static final com.google.android.exoplayer2.drm.DrmSessionManager DUMMY = new com.google.android.exoplayer2.drm.DrmSessionManager.AnonymousClass1();

    /* renamed from: com.google.android.exoplayer2.drm.DrmSessionManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.exoplayer2.drm.DrmSessionManager {
        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.drm.DrmSession acquireSession(android.os.Looper looper, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.Format format) {
            if (format.drmInitData == null) {
                return null;
            }
            return new com.google.android.exoplayer2.drm.ErrorStateDrmSession(new com.google.android.exoplayer2.drm.DrmSession.DrmSessionException(new com.google.android.exoplayer2.drm.UnsupportedDrmException(1)));
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        @androidx.annotation.Nullable
        public java.lang.Class<com.google.android.exoplayer2.drm.UnsupportedMediaCrypto> getExoMediaCryptoType(com.google.android.exoplayer2.Format format) {
            if (format.drmInitData != null) {
                return com.google.android.exoplayer2.drm.UnsupportedMediaCrypto.class;
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        public /* synthetic */ void prepare() {
            defpackage.z60.a(this);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        public /* synthetic */ void release() {
            defpackage.z60.b(this);
        }
    }

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.drm.DrmSession acquireSession(android.os.Looper looper, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.Format format);

    @androidx.annotation.Nullable
    java.lang.Class<? extends com.google.android.exoplayer2.drm.ExoMediaCrypto> getExoMediaCryptoType(com.google.android.exoplayer2.Format format);

    void prepare();

    void release();
}
