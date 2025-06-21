package com.cicada.player.utils.media;

@com.cicada.player.utils.NativeUsed
/* loaded from: classes31.dex */
public class DrmSessionManager {
    private static final java.lang.String TAG = "DrmSessionManager";
    private static final java.lang.String WIDEVINE_FORMAT = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    private com.cicada.player.utils.media.DrmSessionManager.DrmSession drmSession = null;
    private long mNativeInstance;
    public static final java.util.UUID WIDEVINE_UUID = new java.util.UUID(-1301668207276963122L, -6645017420763422227L);
    public static int SESSION_STATE_ERROR = -1;
    public static int SESSION_STATE_IDLE = -2;
    public static int SESSION_STATE_OPENED = 0;
    public static int ERROR_CODE_NONE = 0;
    public static int ERROR_CODE_UNSUPPORT_SCHEME = 1;
    public static int ERROR_CODE_RESOURCE_BUSY = 2;
    public static int ERROR_CODE_KEY_RESPONSE_NULL = 3;
    public static int ERROR_CODE_PROVISION_RESPONSE_NULL = 4;
    public static int ERROR_CODE_DENIED_BY_SERVER = 5;
    public static int ERROR_CODE_RELEASED = 6;
    public static int ERROR_CODE_PROVISION_FAIL = 7;

    /* loaded from: classes22.dex */
    public static class DrmInfo {
        public java.lang.String keyFormat;
        public java.lang.String keyUrl;
        public java.lang.String licenseUrl;
        public java.lang.String mime;

        private DrmInfo() {
            this.licenseUrl = null;
            this.keyUrl = null;
            this.keyFormat = null;
            this.mime = null;
        }

        public /* synthetic */ DrmInfo(com.cicada.player.utils.media.DrmSessionManager.AnonymousClass1 anonymousClass1) {
            this();
        }

        private static boolean areEqual(java.lang.Object obj, java.lang.Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        public boolean isSame(com.cicada.player.utils.media.DrmSessionManager.DrmInfo drmInfo) {
            return drmInfo != null && areEqual(this.keyUrl, drmInfo.keyUrl) && areEqual(this.licenseUrl, drmInfo.licenseUrl) && areEqual(this.keyFormat, drmInfo.keyFormat);
        }
    }

    /* loaded from: classes22.dex */
    public class DrmSession {
        public com.cicada.player.utils.media.DrmSessionManager.DrmInfo drmInfo;
        public android.os.Handler requestHandler;
        private android.os.HandlerThread requestHandlerThread;
        public android.media.MediaDrm mediaDrm = null;
        public byte[] sessionId = null;
        public int state = com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_IDLE;
        private boolean hasProvideProvision = false;

        /* renamed from: com.cicada.player.utils.media.DrmSessionManager$DrmSession$1, reason: invalid class name */
        public class AnonymousClass1 extends android.os.Handler {
            final /* synthetic */ com.cicada.player.utils.media.DrmSessionManager val$this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(android.os.Looper looper, com.cicada.player.utils.media.DrmSessionManager drmSessionManager) {
                super(looper);
                this.val$this$0 = drmSessionManager;
            }

            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                int i = message.what;
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        try {
                            com.cicada.player.utils.media.DrmSessionManager.DrmSession.this.requestKey();
                        } catch (android.media.NotProvisionedException unused) {
                        }
                    }
                    super.handleMessage(message);
                }
                com.cicada.player.utils.media.DrmSessionManager.DrmSession.this.requestProvision();
                super.handleMessage(message);
            }
        }

        /* renamed from: com.cicada.player.utils.media.DrmSessionManager$DrmSession$2, reason: invalid class name */
        public class AnonymousClass2 implements android.media.MediaDrm.OnEventListener {
            public AnonymousClass2() {
            }

            @Override // android.media.MediaDrm.OnEventListener
            public void onEvent(android.media.MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                com.cicada.player.utils.Logger.d(com.cicada.player.utils.media.DrmSessionManager.TAG, " drm Event = " + i + " , extra = " + i2 + " , sessionId =  " + bArr);
                com.cicada.player.utils.media.DrmSessionManager.DrmSession.this.sendRequest(i, bArr);
            }
        }

        public DrmSession(com.cicada.player.utils.media.DrmSessionManager.DrmInfo drmInfo) {
            this.drmInfo = null;
            this.requestHandlerThread = null;
            this.requestHandler = null;
            this.drmInfo = drmInfo;
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("DrmRequestHanderThread");
            this.requestHandlerThread = handlerThread;
            handlerThread.start();
            this.requestHandler = new com.cicada.player.utils.media.DrmSessionManager.DrmSession.AnonymousClass1(this.requestHandlerThread.getLooper(), com.cicada.player.utils.media.DrmSessionManager.this);
        }

        private void changeState(int i, int i2) {
            this.state = i;
            com.cicada.player.utils.Logger.d(com.cicada.player.utils.media.DrmSessionManager.TAG, "changeState " + i);
            com.cicada.player.utils.media.DrmSessionManager drmSessionManager = com.cicada.player.utils.media.DrmSessionManager.this;
            drmSessionManager.native_changeState(drmSessionManager.mNativeInstance, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestKey() throws android.media.NotProvisionedException {
            com.cicada.player.utils.Logger.d(com.cicada.player.utils.media.DrmSessionManager.TAG, "requestKey state = " + this.state);
            if (this.state == com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_ERROR) {
                return;
            }
            try {
                java.lang.String str = this.drmInfo.keyUrl;
                android.media.MediaDrm.KeyRequest keyRequest = this.mediaDrm.getKeyRequest(this.sessionId, android.util.Base64.decode(str.substring(str.indexOf(44)), 0), this.drmInfo.mime, 1, null);
                com.cicada.player.utils.media.DrmSessionManager drmSessionManager = com.cicada.player.utils.media.DrmSessionManager.this;
                byte[] native_requestKey = drmSessionManager.native_requestKey(drmSessionManager.mNativeInstance, keyRequest.getDefaultUrl(), keyRequest.getData());
                com.cicada.player.utils.Logger.v(com.cicada.player.utils.media.DrmSessionManager.TAG, "requestKey result = " + new java.lang.String(native_requestKey));
                if (native_requestKey != null) {
                    this.mediaDrm.provideKeyResponse(this.sessionId, native_requestKey);
                    changeState(com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_OPENED, com.cicada.player.utils.media.DrmSessionManager.ERROR_CODE_NONE);
                    return;
                }
                com.cicada.player.utils.Logger.e(com.cicada.player.utils.media.DrmSessionManager.TAG, "requestKey fail: data = null , url : " + keyRequest.getDefaultUrl());
                changeState(com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_ERROR, com.cicada.player.utils.media.DrmSessionManager.ERROR_CODE_KEY_RESPONSE_NULL);
            } catch (java.lang.Exception e) {
                com.cicada.player.utils.Logger.e(com.cicada.player.utils.media.DrmSessionManager.TAG, "requestKey fail: " + e.getMessage());
                changeState(com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_ERROR, com.cicada.player.utils.media.DrmSessionManager.ERROR_CODE_DENIED_BY_SERVER);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestProvision() {
            com.cicada.player.utils.Logger.d(com.cicada.player.utils.media.DrmSessionManager.TAG, "requestProvision  state = " + this.state);
            if (this.hasProvideProvision) {
                return;
            }
            android.media.MediaDrm.ProvisionRequest provisionRequest = this.mediaDrm.getProvisionRequest();
            com.cicada.player.utils.media.DrmSessionManager drmSessionManager = com.cicada.player.utils.media.DrmSessionManager.this;
            byte[] native_requestProvision = drmSessionManager.native_requestProvision(drmSessionManager.mNativeInstance, provisionRequest.getDefaultUrl(), provisionRequest.getData());
            if (native_requestProvision == null) {
                com.cicada.player.utils.Logger.e(com.cicada.player.utils.media.DrmSessionManager.TAG, "requestProvision fail: data = null , url : " + provisionRequest.getDefaultUrl());
                changeState(com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_ERROR, com.cicada.player.utils.media.DrmSessionManager.ERROR_CODE_PROVISION_RESPONSE_NULL);
                return;
            }
            com.cicada.player.utils.Logger.d(com.cicada.player.utils.media.DrmSessionManager.TAG, "requestProvision : data =  " + new java.lang.String(native_requestProvision));
            try {
                this.mediaDrm.provideProvisionResponse(native_requestProvision);
                this.hasProvideProvision = true;
                if (this.state == com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_IDLE) {
                    prepare(false);
                }
            } catch (java.lang.Exception e) {
                com.cicada.player.utils.Logger.e(com.cicada.player.utils.media.DrmSessionManager.TAG, "requestProvision fail: " + e.getMessage());
                changeState(com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_ERROR, com.cicada.player.utils.media.DrmSessionManager.ERROR_CODE_PROVISION_FAIL);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendRequest(int i, byte[] bArr) {
            this.requestHandler.sendMessage(this.requestHandler.obtainMessage(i, bArr));
        }

        @android.annotation.SuppressLint({"WrongConstant"})
        public boolean isForceInsecureDecoder() {
            return false;
        }

        public boolean prepare(boolean z) {
            int i;
            int i2;
            if (this.mediaDrm == null) {
                try {
                    if (!com.cicada.player.utils.media.DrmSessionManager.WIDEVINE_FORMAT.equals(this.drmInfo.keyFormat)) {
                        com.cicada.player.utils.Logger.e(com.cicada.player.utils.media.DrmSessionManager.TAG, " prepare fail : not support format :" + this.drmInfo.keyFormat);
                        changeState(com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_ERROR, com.cicada.player.utils.media.DrmSessionManager.ERROR_CODE_UNSUPPORT_SCHEME);
                        return false;
                    }
                    android.media.MediaDrm mediaDrm = new android.media.MediaDrm(com.cicada.player.utils.media.DrmSessionManager.WIDEVINE_UUID);
                    this.mediaDrm = mediaDrm;
                    mediaDrm.setOnEventListener(new com.cicada.player.utils.media.DrmSessionManager.DrmSession.AnonymousClass2());
                } catch (android.media.UnsupportedSchemeException e) {
                    com.cicada.player.utils.Logger.e(com.cicada.player.utils.media.DrmSessionManager.TAG, " prepare fail : " + e.getMessage());
                    i = com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_ERROR;
                    i2 = com.cicada.player.utils.media.DrmSessionManager.ERROR_CODE_UNSUPPORT_SCHEME;
                    changeState(i, i2);
                    return false;
                }
            }
            try {
                this.sessionId = this.mediaDrm.openSession();
                com.cicada.player.utils.media.DrmSessionManager drmSessionManager = com.cicada.player.utils.media.DrmSessionManager.this;
                drmSessionManager.native_updateSessionId(drmSessionManager.mNativeInstance, this.sessionId);
                changeState(com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_IDLE, com.cicada.player.utils.media.DrmSessionManager.ERROR_CODE_NONE);
                sendRequest(2, this.sessionId);
                return true;
            } catch (android.media.NotProvisionedException e2) {
                com.cicada.player.utils.Logger.e(com.cicada.player.utils.media.DrmSessionManager.TAG, " prepare NotProvisionedException : " + e2.getMessage());
                if (z) {
                    sendRequest(1, null);
                } else {
                    changeState(com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_ERROR, com.cicada.player.utils.media.DrmSessionManager.ERROR_CODE_PROVISION_FAIL);
                }
                return false;
            } catch (java.lang.Exception e3) {
                com.cicada.player.utils.Logger.e(com.cicada.player.utils.media.DrmSessionManager.TAG, " prepare fail : " + e3.getMessage());
                i = com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_ERROR;
                i2 = com.cicada.player.utils.media.DrmSessionManager.ERROR_CODE_RESOURCE_BUSY;
                changeState(i, i2);
                return false;
            }
        }

        public boolean release() {
            changeState(com.cicada.player.utils.media.DrmSessionManager.SESSION_STATE_ERROR, com.cicada.player.utils.media.DrmSessionManager.ERROR_CODE_RELEASED);
            this.requestHandlerThread.quit();
            android.media.MediaDrm mediaDrm = this.mediaDrm;
            if (mediaDrm == null) {
                return true;
            }
            try {
                byte[] bArr = this.sessionId;
                if (bArr != null) {
                    mediaDrm.closeSession(bArr);
                }
            } catch (java.lang.Exception e) {
                com.cicada.player.utils.Logger.e(com.cicada.player.utils.media.DrmSessionManager.TAG, " closeSession fail : " + e.getMessage());
            }
            try {
                this.mediaDrm.release();
            } catch (java.lang.Exception e2) {
                com.cicada.player.utils.Logger.e(com.cicada.player.utils.media.DrmSessionManager.TAG, " release fail : " + e2.getMessage());
            }
            this.mediaDrm = null;
            return true;
        }
    }

    public DrmSessionManager(long j) {
        this.mNativeInstance = j;
    }

    private void requireSessionInner(com.cicada.player.utils.media.DrmSessionManager.DrmInfo drmInfo) {
        if (this.drmSession == null) {
            com.cicada.player.utils.media.DrmSessionManager.DrmSession drmSession = new com.cicada.player.utils.media.DrmSessionManager.DrmSession(drmInfo);
            this.drmSession = drmSession;
            drmSession.prepare(true);
        }
    }

    @com.cicada.player.utils.NativeUsed
    @android.annotation.SuppressLint({"ObsoleteSdkInt"})
    public static boolean supportDrm(java.lang.String str) {
        return !WIDEVINE_FORMAT.equals(str) || android.media.MediaDrm.isCryptoSchemeSupported(WIDEVINE_UUID);
    }

    @com.cicada.player.utils.NativeUsed
    public boolean isForceInsecureDecoder() {
        com.cicada.player.utils.media.DrmSessionManager.DrmSession drmSession = this.drmSession;
        if (drmSession != null) {
            return drmSession.isForceInsecureDecoder();
        }
        return false;
    }

    public native void native_changeState(long j, int i, int i2);

    public native byte[] native_requestKey(long j, java.lang.String str, byte[] bArr);

    public native byte[] native_requestProvision(long j, java.lang.String str, byte[] bArr);

    public native void native_updateSessionId(long j, byte[] bArr);

    @com.cicada.player.utils.NativeUsed
    public synchronized void releaseSession() {
        com.cicada.player.utils.Logger.d(TAG, "releaseSession");
        com.cicada.player.utils.media.DrmSessionManager.DrmSession drmSession = this.drmSession;
        if (drmSession != null) {
            drmSession.release();
            this.drmSession = null;
        }
    }

    @com.cicada.player.utils.NativeUsed
    public synchronized void requireSession(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.cicada.player.utils.Logger.d(TAG, "requireSessionInner info = " + str2);
        com.cicada.player.utils.media.DrmSessionManager.DrmInfo drmInfo = new com.cicada.player.utils.media.DrmSessionManager.DrmInfo(null);
        drmInfo.licenseUrl = str4;
        drmInfo.keyFormat = str2;
        drmInfo.keyUrl = str;
        drmInfo.mime = str3;
        requireSessionInner(drmInfo);
    }
}
