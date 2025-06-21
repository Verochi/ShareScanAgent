package com.google.android.exoplayer2.drm;

@androidx.annotation.RequiresApi(18)
/* loaded from: classes22.dex */
class DefaultDrmSession implements com.google.android.exoplayer2.drm.DrmSession {

    @androidx.annotation.Nullable
    public final java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> a;
    public final com.google.android.exoplayer2.drm.ExoMediaDrm b;
    public final com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager c;
    public final com.google.android.exoplayer2.drm.DefaultDrmSession.ReferenceCountListener d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final java.util.HashMap<java.lang.String, java.lang.String> h;
    public final com.google.android.exoplayer2.util.CopyOnWriteMultiset<com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher> i;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy j;
    public final com.google.android.exoplayer2.drm.MediaDrmCallback k;
    public final java.util.UUID l;
    public final com.google.android.exoplayer2.drm.DefaultDrmSession.ResponseHandler m;
    public int n;
    public int o;

    @androidx.annotation.Nullable
    public android.os.HandlerThread p;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DefaultDrmSession.RequestHandler q;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.ExoMediaCrypto r;

    /* renamed from: s, reason: collision with root package name */
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DrmSession.DrmSessionException f345s;

    @androidx.annotation.Nullable
    public byte[] t;
    public byte[] u;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest v;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest w;

    public interface ProvisioningManager {
        void onProvisionCompleted();

        void onProvisionError(java.lang.Exception exc);

        void provisionRequired(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession);
    }

    public interface ReferenceCountListener {
        void onReferenceCountDecremented(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession, int i);

        void onReferenceCountIncremented(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession, int i);
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    public class RequestHandler extends android.os.Handler {
        public RequestHandler(android.os.Looper looper) {
            super(looper);
        }

        public final boolean a(android.os.Message message, com.google.android.exoplayer2.drm.MediaDrmCallbackException mediaDrmCallbackException) {
            com.google.android.exoplayer2.drm.DefaultDrmSession.RequestTask requestTask = (com.google.android.exoplayer2.drm.DefaultDrmSession.RequestTask) message.obj;
            if (!requestTask.b) {
                return false;
            }
            int i = requestTask.e + 1;
            requestTask.e = i;
            if (i > com.google.android.exoplayer2.drm.DefaultDrmSession.this.j.getMinimumLoadableRetryCount(3)) {
                return false;
            }
            long retryDelayMsFor = com.google.android.exoplayer2.drm.DefaultDrmSession.this.j.getRetryDelayMsFor(new com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo(new com.google.android.exoplayer2.source.LoadEventInfo(requestTask.a, mediaDrmCallbackException.dataSpec, mediaDrmCallbackException.uriAfterRedirects, mediaDrmCallbackException.responseHeaders, android.os.SystemClock.elapsedRealtime(), android.os.SystemClock.elapsedRealtime() - requestTask.c, mediaDrmCallbackException.bytesLoaded), new com.google.android.exoplayer2.source.MediaLoadData(3), mediaDrmCallbackException.getCause() instanceof java.io.IOException ? (java.io.IOException) mediaDrmCallbackException.getCause() : new com.google.android.exoplayer2.drm.DefaultDrmSession.UnexpectedDrmSessionException(mediaDrmCallbackException.getCause()), requestTask.e));
            if (retryDelayMsFor == -9223372036854775807L) {
                return false;
            }
            sendMessageDelayed(android.os.Message.obtain(message), retryDelayMsFor);
            return true;
        }

        public void b(int i, java.lang.Object obj, boolean z) {
            obtainMessage(i, new com.google.android.exoplayer2.drm.DefaultDrmSession.RequestTask(com.google.android.exoplayer2.source.LoadEventInfo.getNewId(), z, android.os.SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            java.lang.Throwable th;
            com.google.android.exoplayer2.drm.DefaultDrmSession.RequestTask requestTask = (com.google.android.exoplayer2.drm.DefaultDrmSession.RequestTask) message.obj;
            try {
                int i = message.what;
                if (i == 0) {
                    com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession = com.google.android.exoplayer2.drm.DefaultDrmSession.this;
                    th = defaultDrmSession.k.executeProvisionRequest(defaultDrmSession.l, (com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest) requestTask.d);
                } else {
                    if (i != 1) {
                        throw new java.lang.RuntimeException();
                    }
                    com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this;
                    th = defaultDrmSession2.k.executeKeyRequest(defaultDrmSession2.l, (com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest) requestTask.d);
                }
            } catch (com.google.android.exoplayer2.drm.MediaDrmCallbackException e) {
                boolean a = a(message, e);
                th = e;
                if (a) {
                    return;
                }
            } catch (java.lang.Exception e2) {
                com.google.android.exoplayer2.util.Log.w("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
                th = e2;
            }
            com.google.android.exoplayer2.drm.DefaultDrmSession.this.j.onLoadTaskConcluded(requestTask.a);
            com.google.android.exoplayer2.drm.DefaultDrmSession.this.m.obtainMessage(message.what, android.util.Pair.create(requestTask.d, th)).sendToTarget();
        }
    }

    public static final class RequestTask {
        public final long a;
        public final boolean b;
        public final long c;
        public final java.lang.Object d;
        public int e;

        public RequestTask(long j, boolean z, long j2, java.lang.Object obj) {
            this.a = j;
            this.b = z;
            this.c = j2;
            this.d = obj;
        }
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    public class ResponseHandler extends android.os.Handler {
        public ResponseHandler(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            android.util.Pair pair = (android.util.Pair) message.obj;
            java.lang.Object obj = pair.first;
            java.lang.Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                com.google.android.exoplayer2.drm.DefaultDrmSession.this.r(obj, obj2);
            } else {
                if (i != 1) {
                    return;
                }
                com.google.android.exoplayer2.drm.DefaultDrmSession.this.l(obj, obj2);
            }
        }
    }

    public static final class UnexpectedDrmSessionException extends java.io.IOException {
        public UnexpectedDrmSessionException(@androidx.annotation.Nullable java.lang.Throwable th) {
            super(th);
        }
    }

    public DefaultDrmSession(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm exoMediaDrm, com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager provisioningManager, com.google.android.exoplayer2.drm.DefaultDrmSession.ReferenceCountListener referenceCountListener, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list, int i, boolean z, boolean z2, @androidx.annotation.Nullable byte[] bArr, java.util.HashMap<java.lang.String, java.lang.String> hashMap, com.google.android.exoplayer2.drm.MediaDrmCallback mediaDrmCallback, android.os.Looper looper, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        if (i == 1 || i == 3) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr);
        }
        this.l = uuid;
        this.c = provisioningManager;
        this.d = referenceCountListener;
        this.b = exoMediaDrm;
        this.e = i;
        this.f = z;
        this.g = z2;
        if (bArr != null) {
            this.u = bArr;
            this.a = null;
        } else {
            this.a = java.util.Collections.unmodifiableList((java.util.List) com.google.android.exoplayer2.util.Assertions.checkNotNull(list));
        }
        this.h = hashMap;
        this.k = mediaDrmCallback;
        this.i = new com.google.android.exoplayer2.util.CopyOnWriteMultiset<>();
        this.j = loadErrorHandlingPolicy;
        this.n = 2;
        this.m = new com.google.android.exoplayer2.drm.DefaultDrmSession.ResponseHandler(looper);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void acquire(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.o >= 0);
        if (eventDispatcher != null) {
            this.i.add(eventDispatcher);
        }
        int i = this.o + 1;
        this.o = i;
        if (i == 1) {
            com.google.android.exoplayer2.util.Assertions.checkState(this.n == 2);
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("ExoPlayer:DrmRequestHandler");
            this.p = handlerThread;
            handlerThread.start();
            this.q = new com.google.android.exoplayer2.drm.DefaultDrmSession.RequestHandler(this.p.getLooper());
            if (s(true)) {
                f(true);
            }
        } else if (eventDispatcher != null && i()) {
            eventDispatcher.drmSessionAcquired();
        }
        this.d.onReferenceCountIncremented(this, this.o);
    }

    public final void e(com.google.android.exoplayer2.util.Consumer<com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher> consumer) {
        java.util.Iterator<com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher> it = this.i.elementSet().iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"sessionId"})
    public final void f(boolean z) {
        if (this.g) {
            return;
        }
        byte[] bArr = (byte[]) com.google.android.exoplayer2.util.Util.castNonNull(this.t);
        int i = this.e;
        if (i != 0 && i != 1) {
            if (i == 2) {
                if (this.u == null || v()) {
                    t(bArr, 2, z);
                    return;
                }
                return;
            }
            if (i != 3) {
                return;
            }
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.u);
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.t);
            if (v()) {
                t(this.u, 3, z);
                return;
            }
            return;
        }
        if (this.u == null) {
            t(bArr, 1, z);
            return;
        }
        if (this.n == 4 || v()) {
            long g = g();
            if (this.e != 0 || g > 60) {
                if (g <= 0) {
                    k(new com.google.android.exoplayer2.drm.KeysExpiredException());
                    return;
                } else {
                    this.n = 4;
                    e(new defpackage.nz());
                    return;
                }
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(88);
            sb.append("Offline license has expired or will expire soon. Remaining seconds: ");
            sb.append(g);
            com.google.android.exoplayer2.util.Log.d("DefaultDrmSession", sb.toString());
            t(bArr, 2, z);
        }
    }

    public final long g() {
        if (!com.google.android.exoplayer2.C.WIDEVINE_UUID.equals(this.l)) {
            return Long.MAX_VALUE;
        }
        android.util.Pair pair = (android.util.Pair) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.drm.WidevineUtil.getLicenseDurationRemainingSec(this));
        return java.lang.Math.min(((java.lang.Long) pair.first).longValue(), ((java.lang.Long) pair.second).longValue());
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.drm.DrmSession.DrmSessionException getError() {
        if (this.n == 1) {
            return this.f345s;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.drm.ExoMediaCrypto getMediaCrypto() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @androidx.annotation.Nullable
    public byte[] getOfflineLicenseKeySetId() {
        return this.u;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.n;
    }

    public boolean h(byte[] bArr) {
        return java.util.Arrays.equals(this.t, bArr);
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    public final boolean i() {
        int i = this.n;
        return i == 3 || i == 4;
    }

    public final void k(java.lang.Exception exc) {
        this.f345s = new com.google.android.exoplayer2.drm.DrmSession.DrmSessionException(exc);
        e(new com.google.android.exoplayer2.drm.a(exc));
        if (this.n != 4) {
            this.n = 1;
        }
    }

    public final void l(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == this.v && i()) {
            this.v = null;
            if (obj2 instanceof java.lang.Exception) {
                m((java.lang.Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.e == 3) {
                    this.b.provideKeyResponse((byte[]) com.google.android.exoplayer2.util.Util.castNonNull(this.u), bArr);
                    e(new defpackage.lz());
                    return;
                }
                byte[] provideKeyResponse = this.b.provideKeyResponse(this.t, bArr);
                int i = this.e;
                if ((i == 2 || (i == 0 && this.u != null)) && provideKeyResponse != null && provideKeyResponse.length != 0) {
                    this.u = provideKeyResponse;
                }
                this.n = 4;
                e(new defpackage.mz());
            } catch (java.lang.Exception e) {
                m(e);
            }
        }
    }

    public final void m(java.lang.Exception exc) {
        if (exc instanceof android.media.NotProvisionedException) {
            this.c.provisionRequired(this);
        } else {
            k(exc);
        }
    }

    public final void n() {
        if (this.e == 0 && this.n == 4) {
            com.google.android.exoplayer2.util.Util.castNonNull(this.t);
            f(false);
        }
    }

    public void o(int i) {
        if (i != 2) {
            return;
        }
        n();
    }

    public void p() {
        if (s(false)) {
            f(true);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return this.f;
    }

    public void q(java.lang.Exception exc) {
        k(exc);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @androidx.annotation.Nullable
    public java.util.Map<java.lang.String, java.lang.String> queryKeyStatus() {
        byte[] bArr = this.t;
        if (bArr == null) {
            return null;
        }
        return this.b.queryKeyStatus(bArr);
    }

    public final void r(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == this.w) {
            if (this.n == 2 || i()) {
                this.w = null;
                if (obj2 instanceof java.lang.Exception) {
                    this.c.onProvisionError((java.lang.Exception) obj2);
                    return;
                }
                try {
                    this.b.provideProvisionResponse((byte[]) obj2);
                    this.c.onProvisionCompleted();
                } catch (java.lang.Exception e) {
                    this.c.onProvisionError(e);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void release(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.o > 0);
        int i = this.o - 1;
        this.o = i;
        if (i == 0) {
            this.n = 0;
            ((com.google.android.exoplayer2.drm.DefaultDrmSession.ResponseHandler) com.google.android.exoplayer2.util.Util.castNonNull(this.m)).removeCallbacksAndMessages(null);
            ((com.google.android.exoplayer2.drm.DefaultDrmSession.RequestHandler) com.google.android.exoplayer2.util.Util.castNonNull(this.q)).removeCallbacksAndMessages(null);
            this.q = null;
            ((android.os.HandlerThread) com.google.android.exoplayer2.util.Util.castNonNull(this.p)).quit();
            this.p = null;
            this.r = null;
            this.f345s = null;
            this.v = null;
            this.w = null;
            byte[] bArr = this.t;
            if (bArr != null) {
                this.b.closeSession(bArr);
                this.t = null;
            }
            e(new defpackage.oz());
        }
        if (eventDispatcher != null) {
            if (i()) {
                eventDispatcher.drmSessionReleased();
            }
            this.i.remove(eventDispatcher);
        }
        this.d.onReferenceCountDecremented(this, this.o);
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    public final boolean s(boolean z) {
        if (i()) {
            return true;
        }
        try {
            byte[] openSession = this.b.openSession();
            this.t = openSession;
            this.r = this.b.createMediaCrypto(openSession);
            e(new defpackage.kz());
            this.n = 3;
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.t);
            return true;
        } catch (android.media.NotProvisionedException e) {
            if (z) {
                this.c.provisionRequired(this);
                return false;
            }
            k(e);
            return false;
        } catch (java.lang.Exception e2) {
            k(e2);
            return false;
        }
    }

    public final void t(byte[] bArr, int i, boolean z) {
        try {
            this.v = this.b.getKeyRequest(bArr, this.a, i, this.h);
            ((com.google.android.exoplayer2.drm.DefaultDrmSession.RequestHandler) com.google.android.exoplayer2.util.Util.castNonNull(this.q)).b(1, com.google.android.exoplayer2.util.Assertions.checkNotNull(this.v), z);
        } catch (java.lang.Exception e) {
            m(e);
        }
    }

    public void u() {
        this.w = this.b.getProvisionRequest();
        ((com.google.android.exoplayer2.drm.DefaultDrmSession.RequestHandler) com.google.android.exoplayer2.util.Util.castNonNull(this.q)).b(0, com.google.android.exoplayer2.util.Assertions.checkNotNull(this.w), true);
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    public final boolean v() {
        try {
            this.b.restoreKeys(this.t, this.u);
            return true;
        } catch (java.lang.Exception e) {
            com.google.android.exoplayer2.util.Log.e("DefaultDrmSession", "Error trying to restore keys.", e);
            k(e);
            return false;
        }
    }
}
