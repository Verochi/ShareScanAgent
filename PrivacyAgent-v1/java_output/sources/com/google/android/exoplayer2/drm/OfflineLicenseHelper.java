package com.google.android.exoplayer2.drm;

@androidx.annotation.RequiresApi(18)
/* loaded from: classes22.dex */
public final class OfflineLicenseHelper {
    public static final com.google.android.exoplayer2.Format e = new com.google.android.exoplayer2.Format.Builder().setDrmInitData(new com.google.android.exoplayer2.drm.DrmInitData(new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[0])).build();
    public final android.os.ConditionVariable a;
    public final com.google.android.exoplayer2.drm.DefaultDrmSessionManager b;
    public final android.os.HandlerThread c;
    public final com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher d;

    /* renamed from: com.google.android.exoplayer2.drm.OfflineLicenseHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.exoplayer2.drm.DrmSessionEventListener {
        public AnonymousClass1() {
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysLoaded(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            com.google.android.exoplayer2.drm.OfflineLicenseHelper.this.a.open();
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysRemoved(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            com.google.android.exoplayer2.drm.OfflineLicenseHelper.this.a.open();
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysRestored(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            com.google.android.exoplayer2.drm.OfflineLicenseHelper.this.a.open();
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public /* synthetic */ void onDrmSessionAcquired(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            defpackage.s60.d(this, i, mediaPeriodId);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionManagerError(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, java.lang.Exception exc) {
            com.google.android.exoplayer2.drm.OfflineLicenseHelper.this.a.open();
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public /* synthetic */ void onDrmSessionReleased(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            defpackage.s60.f(this, i, mediaPeriodId);
        }
    }

    public OfflineLicenseHelper(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.b = defaultDrmSessionManager;
        this.d = eventDispatcher;
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("ExoPlayer:OfflineLicenseHelper");
        this.c = handlerThread;
        handlerThread.start();
        this.a = new android.os.ConditionVariable();
        eventDispatcher.addEventListener(new android.os.Handler(handlerThread.getLooper()), new com.google.android.exoplayer2.drm.OfflineLicenseHelper.AnonymousClass1());
    }

    @java.lang.Deprecated
    public OfflineLicenseHelper(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.Provider provider, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, @androidx.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this(new com.google.android.exoplayer2.drm.DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(uuid, provider).setKeyRequestParameters(map).build(mediaDrmCallback), eventDispatcher);
    }

    public static com.google.android.exoplayer2.drm.OfflineLicenseHelper newWidevineInstance(java.lang.String str, com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return newWidevineInstance(str, false, factory, eventDispatcher);
    }

    public static com.google.android.exoplayer2.drm.OfflineLicenseHelper newWidevineInstance(java.lang.String str, boolean z, com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return newWidevineInstance(str, z, factory, null, eventDispatcher);
    }

    public static com.google.android.exoplayer2.drm.OfflineLicenseHelper newWidevineInstance(java.lang.String str, boolean z, com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory, @androidx.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new com.google.android.exoplayer2.drm.OfflineLicenseHelper(new com.google.android.exoplayer2.drm.DefaultDrmSessionManager.Builder().setKeyRequestParameters(map).build(new com.google.android.exoplayer2.drm.HttpMediaDrmCallback(str, z, factory)), eventDispatcher);
    }

    public final byte[] b(int i, @androidx.annotation.Nullable byte[] bArr, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.drm.DrmSession.DrmSessionException {
        this.b.prepare();
        com.google.android.exoplayer2.drm.DrmSession c = c(i, bArr, format);
        com.google.android.exoplayer2.drm.DrmSession.DrmSessionException error = c.getError();
        byte[] offlineLicenseKeySetId = c.getOfflineLicenseKeySetId();
        c.release(this.d);
        this.b.release();
        if (error == null) {
            return (byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(offlineLicenseKeySetId);
        }
        throw error;
    }

    public final com.google.android.exoplayer2.drm.DrmSession c(int i, @androidx.annotation.Nullable byte[] bArr, com.google.android.exoplayer2.Format format) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(format.drmInitData);
        this.b.setMode(i, bArr);
        this.a.close();
        com.google.android.exoplayer2.drm.DrmSession acquireSession = this.b.acquireSession(this.c.getLooper(), this.d, format);
        this.a.block();
        return (com.google.android.exoplayer2.drm.DrmSession) com.google.android.exoplayer2.util.Assertions.checkNotNull(acquireSession);
    }

    public synchronized byte[] downloadLicense(com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.drm.DrmSession.DrmSessionException {
        com.google.android.exoplayer2.util.Assertions.checkArgument(format.drmInitData != null);
        return b(2, null, format);
    }

    public synchronized android.util.Pair<java.lang.Long, java.lang.Long> getLicenseDurationRemainingSec(byte[] bArr) throws com.google.android.exoplayer2.drm.DrmSession.DrmSessionException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr);
        this.b.prepare();
        com.google.android.exoplayer2.drm.DrmSession c = c(1, bArr, e);
        com.google.android.exoplayer2.drm.DrmSession.DrmSessionException error = c.getError();
        android.util.Pair<java.lang.Long, java.lang.Long> licenseDurationRemainingSec = com.google.android.exoplayer2.drm.WidevineUtil.getLicenseDurationRemainingSec(c);
        c.release(this.d);
        this.b.release();
        if (error == null) {
            return (android.util.Pair) com.google.android.exoplayer2.util.Assertions.checkNotNull(licenseDurationRemainingSec);
        }
        if (!(error.getCause() instanceof com.google.android.exoplayer2.drm.KeysExpiredException)) {
            throw error;
        }
        return android.util.Pair.create(0L, 0L);
    }

    public void release() {
        this.c.quit();
    }

    public synchronized void releaseLicense(byte[] bArr) throws com.google.android.exoplayer2.drm.DrmSession.DrmSessionException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr);
        b(3, bArr, e);
    }

    public synchronized byte[] renewLicense(byte[] bArr) throws com.google.android.exoplayer2.drm.DrmSession.DrmSessionException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr);
        return b(2, bArr, e);
    }
}
