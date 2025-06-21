package com.google.android.exoplayer2.drm;

@androidx.annotation.RequiresApi(18)
/* loaded from: classes22.dex */
public class DefaultDrmSessionManager implements com.google.android.exoplayer2.drm.DrmSessionManager {
    public static final long DEFAULT_SESSION_KEEPALIVE_MS = 300000;
    public static final int INITIAL_DRM_REQUEST_RETRY_COUNT = 3;
    public static final int MODE_DOWNLOAD = 2;
    public static final int MODE_PLAYBACK = 0;
    public static final int MODE_QUERY = 1;
    public static final int MODE_RELEASE = 3;
    public static final java.lang.String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
    public final java.util.UUID a;
    public final com.google.android.exoplayer2.drm.ExoMediaDrm.Provider b;
    public final com.google.android.exoplayer2.drm.MediaDrmCallback c;
    public final java.util.HashMap<java.lang.String, java.lang.String> d;
    public final boolean e;
    public final int[] f;
    public final boolean g;
    public final com.google.android.exoplayer2.drm.DefaultDrmSessionManager.ProvisioningManagerImpl h;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy i;
    public final com.google.android.exoplayer2.drm.DefaultDrmSessionManager.ReferenceCountListenerImpl j;
    public final long k;
    public final java.util.List<com.google.android.exoplayer2.drm.DefaultDrmSession> l;
    public final java.util.List<com.google.android.exoplayer2.drm.DefaultDrmSession> m;
    public final java.util.Set<com.google.android.exoplayer2.drm.DefaultDrmSession> n;
    public int o;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.ExoMediaDrm p;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DefaultDrmSession q;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DefaultDrmSession r;

    /* renamed from: s, reason: collision with root package name */
    @androidx.annotation.Nullable
    public android.os.Looper f346s;
    public android.os.Handler t;
    public int u;

    @androidx.annotation.Nullable
    public byte[] v;

    @androidx.annotation.Nullable
    public volatile com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MediaDrmHandler w;

    public static final class Builder {
        public boolean d;
        public boolean f;
        public final java.util.HashMap<java.lang.String, java.lang.String> a = new java.util.HashMap<>();
        public java.util.UUID b = com.google.android.exoplayer2.C.WIDEVINE_UUID;
        public com.google.android.exoplayer2.drm.ExoMediaDrm.Provider c = com.google.android.exoplayer2.drm.FrameworkMediaDrm.DEFAULT_PROVIDER;
        public com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy g = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
        public int[] e = new int[0];
        public long h = 300000;

        public com.google.android.exoplayer2.drm.DefaultDrmSessionManager build(com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback) {
            return new com.google.android.exoplayer2.drm.DefaultDrmSessionManager(this.b, this.c, mediaDrmCallback, this.a, this.d, this.e, this.f, this.g, this.h, null);
        }

        public com.google.android.exoplayer2.drm.DefaultDrmSessionManager.Builder setKeyRequestParameters(@androidx.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map) {
            this.a.clear();
            if (map != null) {
                this.a.putAll(map);
            }
            return this;
        }

        public com.google.android.exoplayer2.drm.DefaultDrmSessionManager.Builder setLoadErrorHandlingPolicy(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.g = (com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy) com.google.android.exoplayer2.util.Assertions.checkNotNull(loadErrorHandlingPolicy);
            return this;
        }

        public com.google.android.exoplayer2.drm.DefaultDrmSessionManager.Builder setMultiSession(boolean z) {
            this.d = z;
            return this;
        }

        public com.google.android.exoplayer2.drm.DefaultDrmSessionManager.Builder setPlayClearSamplesWithoutKeys(boolean z) {
            this.f = z;
            return this;
        }

        public com.google.android.exoplayer2.drm.DefaultDrmSessionManager.Builder setSessionKeepaliveMs(long j) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(j > 0 || j == -9223372036854775807L);
            this.h = j;
            return this;
        }

        public com.google.android.exoplayer2.drm.DefaultDrmSessionManager.Builder setUseDrmSessionsForClearContent(int... iArr) {
            for (int i : iArr) {
                boolean z = true;
                if (i != 2 && i != 1) {
                    z = false;
                }
                com.google.android.exoplayer2.util.Assertions.checkArgument(z);
            }
            this.e = (int[]) iArr.clone();
            return this;
        }

        public com.google.android.exoplayer2.drm.DefaultDrmSessionManager.Builder setUuidAndExoMediaDrmProvider(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.Provider provider) {
            this.b = (java.util.UUID) com.google.android.exoplayer2.util.Assertions.checkNotNull(uuid);
            this.c = (com.google.android.exoplayer2.drm.ExoMediaDrm.Provider) com.google.android.exoplayer2.util.Assertions.checkNotNull(provider);
            return this;
        }
    }

    public class MediaDrmEventListener implements com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener {
        public MediaDrmEventListener() {
        }

        public /* synthetic */ MediaDrmEventListener(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager, com.google.android.exoplayer2.drm.DefaultDrmSessionManager.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener
        public void onEvent(com.google.android.exoplayer2.drm.ExoMediaDrm exoMediaDrm, @androidx.annotation.Nullable byte[] bArr, int i, int i2, @androidx.annotation.Nullable byte[] bArr2) {
            ((com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MediaDrmHandler) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.w)).obtainMessage(i, bArr).sendToTarget();
        }
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    public class MediaDrmHandler extends android.os.Handler {
        public MediaDrmHandler(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession : com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.l) {
                if (defaultDrmSession.h(bArr)) {
                    defaultDrmSession.o(message.what);
                    return;
                }
            }
        }
    }

    public static final class MissingSchemeDataException extends java.lang.Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private MissingSchemeDataException(java.util.UUID uuid) {
            super(r1.toString());
            java.lang.String valueOf = java.lang.String.valueOf(uuid);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 29);
            sb.append("Media does not support uuid: ");
            sb.append(valueOf);
        }

        public /* synthetic */ MissingSchemeDataException(java.util.UUID uuid, com.google.android.exoplayer2.drm.DefaultDrmSessionManager.AnonymousClass1 anonymousClass1) {
            this(uuid);
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public class ProvisioningManagerImpl implements com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager {
        public ProvisioningManagerImpl() {
        }

        public /* synthetic */ ProvisioningManagerImpl(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager, com.google.android.exoplayer2.drm.DefaultDrmSessionManager.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
        public void onProvisionCompleted() {
            java.util.Iterator it = com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.m.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.drm.DefaultDrmSession) it.next()).p();
            }
            com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.m.clear();
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
        public void onProvisionError(java.lang.Exception exc) {
            java.util.Iterator it = com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.m.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.drm.DefaultDrmSession) it.next()).q(exc);
            }
            com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.m.clear();
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
        public void provisionRequired(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession) {
            if (com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.m.contains(defaultDrmSession)) {
                return;
            }
            com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.m.add(defaultDrmSession);
            if (com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.m.size() == 1) {
                defaultDrmSession.u();
            }
        }
    }

    public class ReferenceCountListenerImpl implements com.google.android.exoplayer2.drm.DefaultDrmSession.ReferenceCountListener {
        public ReferenceCountListenerImpl() {
        }

        public /* synthetic */ ReferenceCountListenerImpl(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager, com.google.android.exoplayer2.drm.DefaultDrmSessionManager.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ReferenceCountListener
        public void onReferenceCountDecremented(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession, int i) {
            if (i == 1 && com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.k != -9223372036854775807L) {
                com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.n.add(defaultDrmSession);
                ((android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.t)).postAtTime(new com.google.android.exoplayer2.drm.b(defaultDrmSession), defaultDrmSession, android.os.SystemClock.uptimeMillis() + com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.k);
                return;
            }
            if (i == 0) {
                com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.l.remove(defaultDrmSession);
                if (com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.q == defaultDrmSession) {
                    com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.q = null;
                }
                if (com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.r == defaultDrmSession) {
                    com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.r = null;
                }
                if (com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.m.size() > 1 && com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.m.get(0) == defaultDrmSession) {
                    ((com.google.android.exoplayer2.drm.DefaultDrmSession) com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.m.get(1)).u();
                }
                com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.m.remove(defaultDrmSession);
                if (com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.k != -9223372036854775807L) {
                    ((android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.t)).removeCallbacksAndMessages(defaultDrmSession);
                    com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.n.remove(defaultDrmSession);
                }
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ReferenceCountListener
        public void onReferenceCountIncremented(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession, int i) {
            if (com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.k != -9223372036854775807L) {
                com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.n.remove(defaultDrmSession);
                ((android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.drm.DefaultDrmSessionManager.this.t)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }
    }

    public DefaultDrmSessionManager(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.Provider provider, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.util.HashMap<java.lang.String, java.lang.String> hashMap, boolean z, int[] iArr, boolean z2, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(uuid);
        com.google.android.exoplayer2.util.Assertions.checkArgument(!com.google.android.exoplayer2.C.COMMON_PSSH_UUID.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.a = uuid;
        this.b = provider;
        this.c = mediaDrmCallback;
        this.d = hashMap;
        this.e = z;
        this.f = iArr;
        this.g = z2;
        this.i = loadErrorHandlingPolicy;
        this.h = new com.google.android.exoplayer2.drm.DefaultDrmSessionManager.ProvisioningManagerImpl(this, null);
        this.j = new com.google.android.exoplayer2.drm.DefaultDrmSessionManager.ReferenceCountListenerImpl(this, null);
        this.u = 0;
        this.l = new java.util.ArrayList();
        this.m = new java.util.ArrayList();
        this.n = com.google.common.collect.Sets.newIdentityHashSet();
        this.k = j;
    }

    public /* synthetic */ DefaultDrmSessionManager(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.Provider provider, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, java.util.HashMap hashMap, boolean z, int[] iArr, boolean z2, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j, com.google.android.exoplayer2.drm.DefaultDrmSessionManager.AnonymousClass1 anonymousClass1) {
        this(uuid, provider, mediaDrmCallback, hashMap, z, iArr, z2, loadErrorHandlingPolicy, j);
    }

    @java.lang.Deprecated
    public DefaultDrmSessionManager(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm exoMediaDrm, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, @androidx.annotation.Nullable java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        this(uuid, exoMediaDrm, mediaDrmCallback, hashMap == null ? new java.util.HashMap<>() : hashMap, false, 3);
    }

    @java.lang.Deprecated
    public DefaultDrmSessionManager(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm exoMediaDrm, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, @androidx.annotation.Nullable java.util.HashMap<java.lang.String, java.lang.String> hashMap, boolean z) {
        this(uuid, exoMediaDrm, mediaDrmCallback, hashMap == null ? new java.util.HashMap<>() : hashMap, z, 3);
    }

    @java.lang.Deprecated
    public DefaultDrmSessionManager(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm exoMediaDrm, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, @androidx.annotation.Nullable java.util.HashMap<java.lang.String, java.lang.String> hashMap, boolean z, int i) {
        this(uuid, new com.google.android.exoplayer2.drm.ExoMediaDrm.AppManagedProvider(exoMediaDrm), mediaDrmCallback, hashMap == null ? new java.util.HashMap<>() : hashMap, z, new int[0], false, new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i), 300000L);
    }

    public static java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> m(com.google.android.exoplayer2.drm.DrmInitData drmInitData, java.util.UUID uuid, boolean z) {
        java.util.ArrayList arrayList = new java.util.ArrayList(drmInitData.schemeDataCount);
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData = drmInitData.get(i);
            if ((schemeData.matches(uuid) || (com.google.android.exoplayer2.C.CLEARKEY_UUID.equals(uuid) && schemeData.matches(com.google.android.exoplayer2.C.COMMON_PSSH_UUID))) && (schemeData.data != null || z)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DrmSession acquireSession(android.os.Looper looper, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.Format format) {
        java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list;
        n(looper);
        p(looper);
        com.google.android.exoplayer2.drm.DrmInitData drmInitData = format.drmInitData;
        if (drmInitData == null) {
            return o(com.google.android.exoplayer2.util.MimeTypes.getTrackType(format.sampleMimeType));
        }
        com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession = null;
        if (this.v == null) {
            list = m((com.google.android.exoplayer2.drm.DrmInitData) com.google.android.exoplayer2.util.Assertions.checkNotNull(drmInitData), this.a, false);
            if (list.isEmpty()) {
                com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MissingSchemeDataException missingSchemeDataException = new com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MissingSchemeDataException(this.a, null);
                if (eventDispatcher != null) {
                    eventDispatcher.drmSessionManagerError(missingSchemeDataException);
                }
                return new com.google.android.exoplayer2.drm.ErrorStateDrmSession(new com.google.android.exoplayer2.drm.DrmSession.DrmSessionException(missingSchemeDataException));
            }
        } else {
            list = null;
        }
        if (this.e) {
            java.util.Iterator<com.google.android.exoplayer2.drm.DefaultDrmSession> it = this.l.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.google.android.exoplayer2.drm.DefaultDrmSession next = it.next();
                if (com.google.android.exoplayer2.util.Util.areEqual(next.a, list)) {
                    defaultDrmSession = next;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.r;
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = l(list, false, eventDispatcher);
            if (!this.e) {
                this.r = defaultDrmSession;
            }
            this.l.add(defaultDrmSession);
        } else {
            defaultDrmSession.acquire(eventDispatcher);
        }
        return defaultDrmSession;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    @androidx.annotation.Nullable
    public java.lang.Class<? extends com.google.android.exoplayer2.drm.ExoMediaCrypto> getExoMediaCryptoType(com.google.android.exoplayer2.Format format) {
        java.lang.Class<? extends com.google.android.exoplayer2.drm.ExoMediaCrypto> exoMediaCryptoType = ((com.google.android.exoplayer2.drm.ExoMediaDrm) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.p)).getExoMediaCryptoType();
        com.google.android.exoplayer2.drm.DrmInitData drmInitData = format.drmInitData;
        if (drmInitData != null) {
            return j(drmInitData) ? exoMediaCryptoType : com.google.android.exoplayer2.drm.UnsupportedMediaCrypto.class;
        }
        if (com.google.android.exoplayer2.util.Util.linearSearch(this.f, com.google.android.exoplayer2.util.MimeTypes.getTrackType(format.sampleMimeType)) != -1) {
            return exoMediaCryptoType;
        }
        return null;
    }

    public final boolean j(com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        if (this.v != null) {
            return true;
        }
        if (m(drmInitData, this.a, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(com.google.android.exoplayer2.C.COMMON_PSSH_UUID)) {
                return false;
            }
            java.lang.String valueOf = java.lang.String.valueOf(this.a);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 72);
            sb.append("DrmInitData only contains common PSSH SchemeData. Assuming support for: ");
            sb.append(valueOf);
            com.google.android.exoplayer2.util.Log.w("DefaultDrmSessionMgr", sb.toString());
        }
        java.lang.String str = drmInitData.schemeType;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return "cbcs".equals(str) ? com.google.android.exoplayer2.util.Util.SDK_INT >= 25 : ("cbc1".equals(str) || "cens".equals(str)) ? false : true;
    }

    public final com.google.android.exoplayer2.drm.DefaultDrmSession k(@androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list, boolean z, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.p);
        com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession = new com.google.android.exoplayer2.drm.DefaultDrmSession(this.a, this.p, this.h, this.j, list, this.u, this.g | z, z, this.v, this.d, this.c, (android.os.Looper) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.f346s), this.i);
        defaultDrmSession.acquire(eventDispatcher);
        if (this.k != -9223372036854775807L) {
            defaultDrmSession.acquire(null);
        }
        return defaultDrmSession;
    }

    public final com.google.android.exoplayer2.drm.DefaultDrmSession l(@androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list, boolean z, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher) {
        com.google.android.exoplayer2.drm.DefaultDrmSession k = k(list, z, eventDispatcher);
        if (k.getState() != 1) {
            return k;
        }
        if ((com.google.android.exoplayer2.util.Util.SDK_INT >= 19 && !(((com.google.android.exoplayer2.drm.DrmSession.DrmSessionException) com.google.android.exoplayer2.util.Assertions.checkNotNull(k.getError())).getCause() instanceof android.media.ResourceBusyException)) || this.n.isEmpty()) {
            return k;
        }
        com.google.common.collect.UnmodifiableIterator it = com.google.common.collect.ImmutableList.copyOf((java.util.Collection) this.n).iterator();
        while (it.hasNext()) {
            ((com.google.android.exoplayer2.drm.DrmSession) it.next()).release(null);
        }
        k.release(eventDispatcher);
        if (this.k != -9223372036854775807L) {
            k.release(null);
        }
        return k(list, z, eventDispatcher);
    }

    public final void n(android.os.Looper looper) {
        android.os.Looper looper2 = this.f346s;
        if (looper2 != null) {
            com.google.android.exoplayer2.util.Assertions.checkState(looper2 == looper);
        } else {
            this.f346s = looper;
            this.t = new android.os.Handler(looper);
        }
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.drm.DrmSession o(int i) {
        com.google.android.exoplayer2.drm.ExoMediaDrm exoMediaDrm = (com.google.android.exoplayer2.drm.ExoMediaDrm) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.p);
        if ((com.google.android.exoplayer2.drm.FrameworkMediaCrypto.class.equals(exoMediaDrm.getExoMediaCryptoType()) && com.google.android.exoplayer2.drm.FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) || com.google.android.exoplayer2.util.Util.linearSearch(this.f, i) == -1 || com.google.android.exoplayer2.drm.UnsupportedMediaCrypto.class.equals(exoMediaDrm.getExoMediaCryptoType())) {
            return null;
        }
        com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession = this.q;
        if (defaultDrmSession == null) {
            com.google.android.exoplayer2.drm.DefaultDrmSession l = l(com.google.common.collect.ImmutableList.of(), true, null);
            this.l.add(l);
            this.q = l;
        } else {
            defaultDrmSession.acquire(null);
        }
        return this.q;
    }

    public final void p(android.os.Looper looper) {
        if (this.w == null) {
            this.w = new com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MediaDrmHandler(looper);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final void prepare() {
        int i = this.o;
        this.o = i + 1;
        if (i != 0) {
            return;
        }
        com.google.android.exoplayer2.util.Assertions.checkState(this.p == null);
        com.google.android.exoplayer2.drm.ExoMediaDrm acquireExoMediaDrm = this.b.acquireExoMediaDrm(this.a);
        this.p = acquireExoMediaDrm;
        acquireExoMediaDrm.setOnEventListener(new com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MediaDrmEventListener(this, null));
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final void release() {
        int i = this.o - 1;
        this.o = i;
        if (i != 0) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.l);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((com.google.android.exoplayer2.drm.DefaultDrmSession) arrayList.get(i2)).release(null);
        }
        ((com.google.android.exoplayer2.drm.ExoMediaDrm) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.p)).release();
        this.p = null;
    }

    public void setMode(int i, @androidx.annotation.Nullable byte[] bArr) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.l.isEmpty());
        if (i == 1 || i == 3) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr);
        }
        this.u = i;
        this.v = bArr;
    }
}
