package com.huawei.hms.api;

/* loaded from: classes22.dex */
public class HuaweiApiClientImpl extends com.huawei.hms.api.HuaweiApiClient implements com.huawei.hms.support.api.client.InnerApiClient, android.content.ServiceConnection {
    public static final java.lang.String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private final android.content.Context b;
    private final java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private volatile com.huawei.hms.core.aidl.IAIDLInvoke f;
    private java.lang.String g;
    private java.lang.ref.WeakReference<android.app.Activity> h;
    private java.lang.ref.WeakReference<android.app.Activity> i;
    private java.util.List<com.huawei.hms.support.api.entity.auth.Scope> l;
    private java.util.List<com.huawei.hms.support.api.entity.auth.PermissionInfo> m;
    private java.util.Map<com.huawei.hms.api.Api<?>, com.huawei.hms.api.Api.ApiOptions> n;
    private com.huawei.hms.support.api.client.SubAppInfo o;

    /* renamed from: s, reason: collision with root package name */
    private final java.util.concurrent.locks.ReentrantLock f377s;
    private final java.util.concurrent.locks.Condition t;
    private com.huawei.hms.api.ConnectionResult u;
    private com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks v;
    private com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener w;
    private android.os.Handler x;
    private android.os.Handler y;
    private static final java.lang.Object z = new java.lang.Object();
    private static final java.lang.Object A = new java.lang.Object();
    private int a = -1;
    private boolean j = false;
    private java.util.concurrent.atomic.AtomicInteger k = new java.util.concurrent.atomic.AtomicInteger(1);
    private long p = 0;
    private int q = 0;
    private final java.lang.Object r = new java.lang.Object();

    public class a implements android.os.Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service time out");
            if (com.huawei.hms.api.HuaweiApiClientImpl.this.k.get() == 5) {
                com.huawei.hms.api.HuaweiApiClientImpl.this.c(1);
                com.huawei.hms.api.HuaweiApiClientImpl.this.b();
            }
            return true;
        }
    }

    public class b implements android.os.Handler.Callback {
        public b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiClientImpl", "In connect, process time out");
            if (com.huawei.hms.api.HuaweiApiClientImpl.this.k.get() == 2) {
                com.huawei.hms.api.HuaweiApiClientImpl.this.c(1);
                com.huawei.hms.api.HuaweiApiClientImpl.this.b();
            }
            return true;
        }
    }

    public class c extends com.huawei.hms.core.aidl.IAIDLCallback.Stub {
        final /* synthetic */ com.huawei.hms.support.api.client.ResultCallback a;

        public c(com.huawei.hms.api.HuaweiApiClientImpl huaweiApiClientImpl, com.huawei.hms.support.api.client.ResultCallback resultCallback) {
            this.a = resultCallback;
        }

        @Override // com.huawei.hms.core.aidl.IAIDLCallback
        public void call(com.huawei.hms.core.aidl.DataBuffer dataBuffer) {
            if (dataBuffer == null) {
                com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
                this.a.onResult(new com.huawei.hms.support.api.client.BundleResult(-1, null));
                return;
            }
            com.huawei.hms.core.aidl.MessageCodec find = com.huawei.hms.core.aidl.CodecLookup.find(dataBuffer.getProtocol());
            com.huawei.hms.core.aidl.ResponseHeader responseHeader = new com.huawei.hms.core.aidl.ResponseHeader();
            find.decode(dataBuffer.header, responseHeader);
            com.huawei.hms.support.api.client.BundleResult bundleResult = new com.huawei.hms.support.api.client.BundleResult(responseHeader.getStatusCode(), dataBuffer.getBody());
            com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
            this.a.onResult(bundleResult);
        }
    }

    public static class d extends com.huawei.hms.support.api.PendingResultImpl<com.huawei.hms.support.api.client.Status, com.huawei.hms.core.aidl.IMessageEntity> {
        public d(com.huawei.hms.support.api.client.ApiClient apiClient, java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public com.huawei.hms.support.api.client.Status onComplete(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
            return new com.huawei.hms.support.api.client.Status(0);
        }
    }

    public class e implements com.huawei.hms.support.api.client.ResultCallback<com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.ConnectResp>> {

        public class a implements java.lang.Runnable {
            final /* synthetic */ com.huawei.hms.support.api.ResolveResult a;

            public a(com.huawei.hms.support.api.ResolveResult resolveResult) {
                this.a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.huawei.hms.api.HuaweiApiClientImpl.this.a((com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.ConnectResp>) this.a);
            }
        }

        private e() {
        }

        public /* synthetic */ e(com.huawei.hms.api.HuaweiApiClientImpl huaweiApiClientImpl, com.huawei.hms.api.HuaweiApiClientImpl.a aVar) {
            this();
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.ConnectResp> resolveResult) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.huawei.hms.api.HuaweiApiClientImpl.e.a(resolveResult));
        }
    }

    public class f implements com.huawei.hms.support.api.client.ResultCallback<com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.DisconnectResp>> {

        public class a implements java.lang.Runnable {
            final /* synthetic */ com.huawei.hms.support.api.ResolveResult a;

            public a(com.huawei.hms.support.api.ResolveResult resolveResult) {
                this.a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.huawei.hms.api.HuaweiApiClientImpl.this.b((com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.DisconnectResp>) this.a);
            }
        }

        private f() {
        }

        public /* synthetic */ f(com.huawei.hms.api.HuaweiApiClientImpl huaweiApiClientImpl, com.huawei.hms.api.HuaweiApiClientImpl.a aVar) {
            this();
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.DisconnectResp> resolveResult) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.huawei.hms.api.HuaweiApiClientImpl.f.a(resolveResult));
        }
    }

    public class g implements com.huawei.hms.support.api.client.ResultCallback<com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.JosGetNoticeResp>> {
        private g() {
        }

        public /* synthetic */ g(com.huawei.hms.api.HuaweiApiClientImpl huaweiApiClientImpl, com.huawei.hms.api.HuaweiApiClientImpl.a aVar) {
            this();
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.JosGetNoticeResp> resolveResult) {
            com.huawei.hms.support.api.entity.core.JosGetNoticeResp value;
            android.content.Intent noticeIntent;
            if (resolveResult == null || !resolveResult.getStatus().isSuccess() || (noticeIntent = (value = resolveResult.getValue()).getNoticeIntent()) == null || value.getStatusCode() != 0) {
                return;
            }
            com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "get notice has intent.");
            android.app.Activity validActivity = com.huawei.hms.utils.Util.getValidActivity((android.app.Activity) com.huawei.hms.api.HuaweiApiClientImpl.this.h.get(), com.huawei.hms.api.HuaweiApiClientImpl.this.getTopActivity());
            if (validActivity == null) {
                com.huawei.hms.support.log.HMSLog.e("HuaweiApiClientImpl", "showNotice no valid activity!");
            } else {
                com.huawei.hms.api.HuaweiApiClientImpl.this.j = true;
                validActivity.startActivity(noticeIntent);
            }
        }
    }

    public HuaweiApiClientImpl(android.content.Context context) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        this.f377s = reentrantLock;
        this.t = reentrantLock.newCondition();
        this.x = null;
        this.y = null;
        this.b = context;
        java.lang.String appId = com.huawei.hms.utils.Util.getAppId(context);
        this.c = appId;
        this.d = appId;
        this.e = com.huawei.hms.utils.Util.getCpId(context);
    }

    private void a() {
        android.content.Intent intent = new android.content.Intent(com.huawei.hms.utils.HMSPackageManager.getInstance(this.b).getServiceAction());
        com.huawei.hms.utils.HMSPackageManager.getInstance(this.b).refreshForMultiService();
        intent.setPackage(com.huawei.hms.utils.HMSPackageManager.getInstance(this.b).getHMSPackageNameForMultiService());
        synchronized (z) {
            if (this.b.bindService(intent, this, 1)) {
                h();
                return;
            }
            c(1);
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
            b();
        }
    }

    private void a(int i) {
        if (i == 2) {
            synchronized (z) {
                android.os.Handler handler = this.x;
                if (handler != null) {
                    handler.removeMessages(i);
                    this.x = null;
                }
            }
        }
        if (i == 3) {
            synchronized (A) {
                android.os.Handler handler2 = this.y;
                if (handler2 != null) {
                    handler2.removeMessages(i);
                    this.y = null;
                }
            }
        }
        synchronized (z) {
            android.os.Handler handler3 = this.x;
            if (handler3 != null) {
                handler3.removeMessages(2);
                this.x = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.ConnectResp> resolveResult) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult");
        if (this.f == null || this.k.get() != 2) {
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiClientImpl", "Invalid onConnectionResult");
            return;
        }
        a(3);
        com.huawei.hms.support.api.entity.core.ConnectResp value = resolveResult.getValue();
        if (value != null) {
            this.g = value.sessionId;
        }
        com.huawei.hms.support.api.client.SubAppInfo subAppInfo = this.o;
        android.app.PendingIntent pendingIntent = null;
        java.lang.String subAppID = subAppInfo == null ? null : subAppInfo.getSubAppID();
        if (!android.text.TextUtils.isEmpty(subAppID)) {
            this.d = subAppID;
        }
        int statusCode = resolveResult.getStatus().getStatusCode();
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + statusCode);
        if (com.huawei.hms.support.api.client.Status.SUCCESS.equals(resolveResult.getStatus())) {
            c(resolveResult);
            return;
        }
        if (resolveResult.getStatus() != null && resolveResult.getStatus().getStatusCode() == 1001) {
            n();
            c(1);
            com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnectionSuspended(3);
                return;
            }
            return;
        }
        n();
        c(1);
        if (this.w != null) {
            java.lang.ref.WeakReference<android.app.Activity> weakReference = this.h;
            if (weakReference != null && weakReference.get() != null) {
                pendingIntent = com.huawei.hms.api.HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), statusCode);
            }
            com.huawei.hms.api.ConnectionResult connectionResult = new com.huawei.hms.api.ConnectionResult(statusCode, pendingIntent);
            this.w.onConnectionFailed(connectionResult);
            this.u = connectionResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        n();
        if (this.w != null) {
            int i = com.huawei.hms.utils.UIUtil.isBackground(this.b) ? 7 : 6;
            java.lang.ref.WeakReference<android.app.Activity> weakReference = this.h;
            com.huawei.hms.api.ConnectionResult connectionResult = new com.huawei.hms.api.ConnectionResult(i, (weakReference == null || weakReference.get() == null) ? null : com.huawei.hms.api.HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), i));
            this.w.onConnectionFailed(connectionResult);
            this.u = connectionResult;
        }
    }

    private void b(int i) {
        android.app.PendingIntent pendingIntent;
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.h;
        if (weakReference == null || weakReference.get() == null) {
            pendingIntent = null;
        } else {
            pendingIntent = com.huawei.hms.api.HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), i);
            com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "connect 2.0 fail: " + i);
        }
        com.huawei.hms.api.ConnectionResult connectionResult = new com.huawei.hms.api.ConnectionResult(i, pendingIntent);
        this.w.onConnectionFailed(connectionResult);
        this.u = connectionResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.DisconnectResp> resolveResult) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + resolveResult.getStatus().getStatusCode());
        n();
        c(1);
    }

    private com.huawei.hms.support.api.entity.core.ConnectInfo c() {
        java.lang.String packageSignature = new com.huawei.hms.utils.PackageManagerHelper(this.b).getPackageSignature(this.b.getPackageName());
        if (packageSignature == null) {
            packageSignature = "";
        }
        com.huawei.hms.support.api.client.SubAppInfo subAppInfo = this.o;
        return new com.huawei.hms.support.api.entity.core.ConnectInfo(getApiNameList(), this.l, packageSignature, subAppInfo == null ? null : subAppInfo.getSubAppID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        this.k.set(i);
        if (i == 1 || i == 3 || i == 2) {
            this.f377s.lock();
            try {
                this.t.signalAll();
            } finally {
                this.f377s.unlock();
            }
        }
    }

    private void c(com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.ConnectResp> resolveResult) {
        if (resolveResult.getValue() != null) {
            com.huawei.hms.api.ProtocolNegotiate.getInstance().negotiate(resolveResult.getValue().protocolVersion);
        }
        c(3);
        this.u = null;
        com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnected();
        }
        if (this.h != null) {
            m();
        }
        for (java.util.Map.Entry<com.huawei.hms.api.Api<?>, com.huawei.hms.api.Api.ApiOptions> entry : getApiMap().entrySet()) {
            if (entry.getKey().getmConnetctPostList() != null && !entry.getKey().getmConnetctPostList().isEmpty()) {
                com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
                for (com.huawei.hms.common.api.ConnectionPostProcessor connectionPostProcessor : entry.getKey().getmConnetctPostList()) {
                    com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
                    connectionPostProcessor.run(this, this.h);
                }
            }
        }
    }

    private com.huawei.hms.support.api.entity.core.DisconnectInfo d() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Map<com.huawei.hms.api.Api<?>, com.huawei.hms.api.Api.ApiOptions> map = this.n;
        if (map != null) {
            java.util.Iterator<com.huawei.hms.api.Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getApiName());
            }
        }
        return new com.huawei.hms.support.api.entity.core.DisconnectInfo(this.l, arrayList);
    }

    private int e() {
        int hmsVersion = com.huawei.hms.utils.Util.getHmsVersion(this.b);
        if (hmsVersion != 0 && hmsVersion >= 20503000) {
            return hmsVersion;
        }
        int f2 = f();
        if (g()) {
            if (f2 < 20503000) {
                return 20503000;
            }
            return f2;
        }
        if (f2 < 20600000) {
            return 20600000;
        }
        return f2;
    }

    private int f() {
        java.lang.Integer num;
        int intValue;
        java.util.Map<com.huawei.hms.api.Api<?>, com.huawei.hms.api.Api.ApiOptions> apiMap = getApiMap();
        int i = 0;
        if (apiMap == null) {
            return 0;
        }
        java.util.Iterator<com.huawei.hms.api.Api<?>> it = apiMap.keySet().iterator();
        while (it.hasNext()) {
            java.lang.String apiName = it.next().getApiName();
            if (!android.text.TextUtils.isEmpty(apiName) && (num = com.huawei.hms.api.HuaweiApiAvailability.getApiMap().get(apiName)) != null && (intValue = num.intValue()) > i) {
                i = intValue;
            }
        }
        return i;
    }

    private boolean g() {
        java.util.Map<com.huawei.hms.api.Api<?>, com.huawei.hms.api.Api.ApiOptions> map = this.n;
        if (map == null) {
            return false;
        }
        java.util.Iterator<com.huawei.hms.api.Api<?>> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (com.huawei.hms.api.HuaweiApiAvailability.HMS_API_NAME_GAME.equals(it.next().getApiName())) {
                return true;
            }
        }
        return false;
    }

    private void h() {
        android.os.Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.x = new android.os.Handler(android.os.Looper.getMainLooper(), new com.huawei.hms.api.HuaweiApiClientImpl.a());
        }
        this.x.sendEmptyMessageDelayed(2, 5000L);
    }

    private void i() {
        synchronized (A) {
            android.os.Handler handler = this.y;
            if (handler != null) {
                handler.removeMessages(3);
            } else {
                this.y = new android.os.Handler(android.os.Looper.getMainLooper(), new com.huawei.hms.api.HuaweiApiClientImpl.b());
            }
            com.huawei.hms.support.log.HMSLog.d("HuaweiApiClientImpl", "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : " + this.y.sendEmptyMessageDelayed(3, 3000L));
        }
    }

    private void j() {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        com.huawei.hms.support.api.core.ConnectService.connect(this, c()).setResultCallback(new com.huawei.hms.api.HuaweiApiClientImpl.e(this, null));
    }

    private void k() {
        com.huawei.hms.support.api.core.ConnectService.disconnect(this, d()).setResultCallback(new com.huawei.hms.api.HuaweiApiClientImpl.f(this, null));
    }

    private void l() {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
        com.huawei.hms.support.api.core.ConnectService.forceConnect(this, c()).setResultCallback(new com.huawei.hms.api.HuaweiApiClientImpl.e(this, null));
    }

    private void m() {
        if (this.j) {
            com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Connect notice has been shown.");
        } else if (com.huawei.hms.api.HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.b) == 0) {
            com.huawei.hms.support.api.core.ConnectService.getNotice(this, 0, "6.5.0.300").setResultCallback(new com.huawei.hms.api.HuaweiApiClientImpl.g(this, null));
        }
    }

    private void n() {
        com.huawei.hms.utils.Util.unBindServiceCatchException(this.b, this);
        this.f = null;
    }

    public int asyncRequest(android.os.Bundle bundle, java.lang.String str, int i, com.huawei.hms.support.api.client.ResultCallback<com.huawei.hms.support.api.client.BundleResult> resultCallback) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Enter asyncRequest.");
        if (resultCallback == null || str == null || bundle == null) {
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiClientImpl", "arguments is invalid.");
            return com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.ARGUMENTS_INVALID;
        }
        if (!innerIsConnected()) {
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiClientImpl", "client is unConnect.");
            return com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.CLIENT_API_INVALID;
        }
        com.huawei.hms.core.aidl.DataBuffer dataBuffer = new com.huawei.hms.core.aidl.DataBuffer(str, i);
        com.huawei.hms.core.aidl.MessageCodec find = com.huawei.hms.core.aidl.CodecLookup.find(dataBuffer.getProtocol());
        dataBuffer.addBody(bundle);
        com.huawei.hms.core.aidl.RequestHeader requestHeader = new com.huawei.hms.core.aidl.RequestHeader(getAppID(), getPackageName(), 60500300, getSessionId());
        requestHeader.setApiNameList(getApiNameList());
        dataBuffer.header = find.encode(requestHeader, new android.os.Bundle());
        try {
            getService().asyncCall(dataBuffer, new com.huawei.hms.api.HuaweiApiClientImpl.c(this, resultCallback));
            return 0;
        } catch (android.os.RemoteException e2) {
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiClientImpl", "remote exception:" + e2.getMessage());
            return com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.INTERNAL_ERROR;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void checkUpdate(android.app.Activity activity, com.huawei.hms.api.CheckUpdatelistener checkUpdatelistener) {
        if (checkUpdatelistener == null) {
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiClientImpl", "listener is null!");
        } else {
            checkUpdatelistener.onResult(-1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(int i) {
        connect((android.app.Activity) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(android.app.Activity activity) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 60500300 ======");
        int i = this.k.get();
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i);
        if (i == 3 || i == 5 || i == 2 || i == 4) {
            return;
        }
        if (activity != null) {
            this.h = new java.lang.ref.WeakReference<>(activity);
            this.i = new java.lang.ref.WeakReference<>(activity);
        }
        this.d = android.text.TextUtils.isEmpty(this.c) ? com.huawei.hms.utils.Util.getAppId(this.b) : this.c;
        int e2 = e();
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "connect minVersion:" + e2);
        com.huawei.hms.api.HuaweiApiAvailability.setServicesVersionCode(e2);
        int isHuaweiMobileServicesAvailable = com.huawei.hms.api.HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.b, e2);
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + isHuaweiMobileServicesAvailable);
        this.q = com.huawei.hms.utils.HMSPackageManager.getInstance(this.b).getHmsMultiServiceVersion();
        if (isHuaweiMobileServicesAvailable != 0) {
            if (this.w != null) {
                b(isHuaweiMobileServicesAvailable);
                return;
            }
            return;
        }
        c(5);
        if (this.f == null) {
            a();
            return;
        }
        c(2);
        j();
        i();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connectForeground() {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 60500300 ======");
        int i = this.k.get();
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Enter forceConnect, Connection Status: " + i);
        if (i == 3 || i == 5 || i == 2 || i == 4) {
            return;
        }
        this.d = android.text.TextUtils.isEmpty(this.c) ? com.huawei.hms.utils.Util.getAppId(this.b) : this.c;
        l();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disableLifeCycleManagement(android.app.Activity activity) {
        if (this.a < 0) {
            throw new java.lang.IllegalStateException("disableLifeCycleManagement failed");
        }
        com.huawei.hms.common.internal.AutoLifecycleFragment.getInstance(activity).stopAutoManage(this.a);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.client.Status> discardAndReconnect() {
        return new com.huawei.hms.api.HuaweiApiClientImpl.d(this, null, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disconnect() {
        int i = this.k.get();
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i);
        if (i == 2) {
            c(4);
            return;
        }
        if (i == 3) {
            c(4);
            k();
        } else {
            if (i != 5) {
                return;
            }
            a(2);
            c(4);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public java.util.Map<com.huawei.hms.api.Api<?>, com.huawei.hms.api.Api.ApiOptions> getApiMap() {
        return this.n;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public java.util.List<java.lang.String> getApiNameList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Map<com.huawei.hms.api.Api<?>, com.huawei.hms.api.Api.ApiOptions> map = this.n;
        if (map != null) {
            java.util.Iterator<com.huawei.hms.api.Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getApiName());
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public java.lang.String getAppID() {
        return this.d;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public com.huawei.hms.api.ConnectionResult getConnectionResult(com.huawei.hms.api.Api<?> api) {
        if (isConnected()) {
            this.u = null;
            return new com.huawei.hms.api.ConnectionResult(0, (android.app.PendingIntent) null);
        }
        com.huawei.hms.api.ConnectionResult connectionResult = this.u;
        return connectionResult != null ? connectionResult : new com.huawei.hms.api.ConnectionResult(13, (android.app.PendingIntent) null);
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public android.content.Context getContext() {
        return this.b;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public java.lang.String getCpID() {
        return this.e;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public java.lang.String getPackageName() {
        return this.b.getPackageName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public java.util.List<com.huawei.hms.support.api.entity.auth.PermissionInfo> getPermissionInfos() {
        return this.m;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public java.util.List<com.huawei.hms.support.api.entity.auth.Scope> getScopes() {
        return this.l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public com.huawei.hms.core.aidl.IAIDLInvoke getService() {
        return this.f;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public java.lang.String getSessionId() {
        return this.g;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public final com.huawei.hms.support.api.client.SubAppInfo getSubAppInfo() {
        return this.o;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public android.app.Activity getTopActivity() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.i;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public java.lang.String getTransportName() {
        return com.huawei.hms.api.IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectedApi(com.huawei.hms.api.Api<?> api) {
        return isConnected();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionFailureListener(com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        com.huawei.hms.utils.Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.r) {
            return this.w == onConnectionFailedListener;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionSuccessListener(com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        com.huawei.hms.utils.Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.r) {
            return this.v == connectionCallbacks;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public com.huawei.hms.api.ConnectionResult holdUpConnect() {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException("blockingConnect must not be called on the UI thread");
        }
        this.f377s.lock();
        try {
            connect((android.app.Activity) null);
            while (isConnecting()) {
                this.t.await();
            }
            if (isConnected()) {
                this.u = null;
                return new com.huawei.hms.api.ConnectionResult(0, (android.app.PendingIntent) null);
            }
            com.huawei.hms.api.ConnectionResult connectionResult = this.u;
            return connectionResult != null ? connectionResult : new com.huawei.hms.api.ConnectionResult(13, (android.app.PendingIntent) null);
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
            return new com.huawei.hms.api.ConnectionResult(15, (android.app.PendingIntent) null);
        } finally {
            this.f377s.unlock();
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public com.huawei.hms.api.ConnectionResult holdUpConnect(long j, java.util.concurrent.TimeUnit timeUnit) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException("blockingConnect must not be called on the UI thread");
        }
        this.f377s.lock();
        try {
            connect((android.app.Activity) null);
            long nanos = timeUnit.toNanos(j);
            while (isConnecting()) {
                if (nanos <= 0) {
                    disconnect();
                    return new com.huawei.hms.api.ConnectionResult(14, (android.app.PendingIntent) null);
                }
                nanos = this.t.awaitNanos(nanos);
            }
            if (isConnected()) {
                this.u = null;
                return new com.huawei.hms.api.ConnectionResult(0, (android.app.PendingIntent) null);
            }
            com.huawei.hms.api.ConnectionResult connectionResult = this.u;
            return connectionResult != null ? connectionResult : new com.huawei.hms.api.ConnectionResult(13, (android.app.PendingIntent) null);
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
            return new com.huawei.hms.api.ConnectionResult(15, (android.app.PendingIntent) null);
        } finally {
            this.f377s.unlock();
        }
    }

    @Override // com.huawei.hms.support.api.client.InnerApiClient
    public boolean innerIsConnected() {
        return this.k.get() == 3 || this.k.get() == 4;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient, com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        if (this.q == 0) {
            this.q = com.huawei.hms.utils.HMSPackageManager.getInstance(this.b).getHmsMultiServiceVersion();
        }
        if (this.q >= 20504000) {
            return innerIsConnected();
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis() - this.p;
        if (currentTimeMillis > 0 && currentTimeMillis < 300000) {
            return innerIsConnected();
        }
        if (!innerIsConnected()) {
            return false;
        }
        com.huawei.hms.support.api.client.Status status = com.huawei.hms.support.api.core.ConnectService.checkconnect(this, new com.huawei.hms.support.api.entity.core.CheckConnectInfo()).awaitOnAnyThread(2000L, java.util.concurrent.TimeUnit.MILLISECONDS).getStatus();
        if (status.isSuccess()) {
            this.p = java.lang.System.currentTimeMillis();
            return true;
        }
        int statusCode = status.getStatusCode();
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "isConnected is false, statuscode:" + statusCode);
        if (statusCode == 907135004) {
            return false;
        }
        n();
        c(1);
        this.p = java.lang.System.currentTimeMillis();
        return false;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean isConnecting() {
        int i = this.k.get();
        return i == 2 || i == 5;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onPause(android.app.Activity activity) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "onPause");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onResume(android.app.Activity activity) {
        if (activity != null) {
            com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "onResume");
            this.i = new java.lang.ref.WeakReference<>(activity);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "HuaweiApiClientImpl Enter onServiceConnected.");
        a(2);
        this.f = com.huawei.hms.core.aidl.IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f != null) {
            if (this.k.get() == 5) {
                c(2);
                j();
                i();
                return;
            } else {
                if (this.k.get() != 3) {
                    n();
                    return;
                }
                return;
            }
        }
        com.huawei.hms.support.log.HMSLog.e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
        n();
        c(1);
        if (this.w != null) {
            java.lang.ref.WeakReference<android.app.Activity> weakReference = this.h;
            com.huawei.hms.api.ConnectionResult connectionResult = new com.huawei.hms.api.ConnectionResult(10, (weakReference == null || weakReference.get() == null) ? null : com.huawei.hms.api.HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), 10));
            this.w.onConnectionFailed(connectionResult);
            this.u = connectionResult;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.f = null;
        c(1);
        com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnectionSuspended(1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void print(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void reconnect() {
        disconnect();
        connect((android.app.Activity) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionFailureListener(com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        com.huawei.hms.utils.Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.r) {
            if (this.w != onConnectionFailedListener) {
                com.huawei.hms.support.log.HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
            } else {
                this.w = null;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionSuccessListener(com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        com.huawei.hms.utils.Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.r) {
            if (this.v != connectionCallbacks) {
                com.huawei.hms.support.log.HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
            } else {
                this.v = null;
            }
        }
    }

    public void setApiMap(java.util.Map<com.huawei.hms.api.Api<?>, com.huawei.hms.api.Api.ApiOptions> map) {
        this.n = map;
    }

    public void setAutoLifecycleClientId(int i) {
        this.a = i;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionCallbacks(com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        this.v = connectionCallbacks;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionFailedListener(com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.w = onConnectionFailedListener;
    }

    public void setHasShowNotice(boolean z2) {
        this.j = z2;
    }

    public void setPermissionInfos(java.util.List<com.huawei.hms.support.api.entity.auth.PermissionInfo> list) {
        this.m = list;
    }

    public void setScopes(java.util.List<com.huawei.hms.support.api.entity.auth.Scope> list) {
        this.l = list;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean setSubAppInfo(com.huawei.hms.support.api.client.SubAppInfo subAppInfo) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiClientImpl", "Enter setSubAppInfo");
        if (subAppInfo == null) {
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiClientImpl", "subAppInfo is null");
            return false;
        }
        java.lang.String subAppID = subAppInfo.getSubAppID();
        if (android.text.TextUtils.isEmpty(subAppID)) {
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiClientImpl", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(android.text.TextUtils.isEmpty(this.c) ? com.huawei.hms.utils.Util.getAppId(this.b) : this.c)) {
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiClientImpl", "subAppId is host appid");
            return false;
        }
        this.o = new com.huawei.hms.support.api.client.SubAppInfo(subAppInfo);
        return true;
    }
}
