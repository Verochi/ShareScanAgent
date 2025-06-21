package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
class HonorImpl implements com.tanx.onlyid.api.IOAID {
    public final android.content.Context b;
    public com.tanx.onlyid.api.IGetter f;
    public com.tanx.onlyid.api.impl.HonorImpl.HiHonorServiceConnection g;
    public java.lang.String a = "HonorImpl";
    public final android.os.Handler c = new android.os.Handler(android.os.Looper.getMainLooper());
    public java.lang.String d = "com.hihonor.id";
    public java.lang.String e = "com.hihonor.id.HnOaIdService";
    public long h = java.lang.System.currentTimeMillis();

    /* renamed from: com.tanx.onlyid.api.impl.HonorImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tanx.onlyid.api.impl.HonorImpl.this.m();
        }
    }

    /* renamed from: com.tanx.onlyid.api.impl.HonorImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.String n;

        public AnonymousClass2(java.lang.String str) {
            this.n = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.tanx.onlyid.api.impl.HonorImpl.this.f != null) {
                com.tanx.onlyid.api.impl.HonorImpl.this.f.oaidSucc(this.n);
                java.lang.String unused = com.tanx.onlyid.api.impl.HonorImpl.this.a;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("耗时：");
                sb.append(java.lang.System.currentTimeMillis() - com.tanx.onlyid.api.impl.HonorImpl.this.h);
            } else {
                java.lang.String unused2 = com.tanx.onlyid.api.impl.HonorImpl.this.a;
            }
            com.tanx.onlyid.api.impl.HonorImpl honorImpl = com.tanx.onlyid.api.impl.HonorImpl.this;
            honorImpl.n(honorImpl.g);
        }
    }

    /* renamed from: com.tanx.onlyid.api.impl.HonorImpl$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.Exception n;

        public AnonymousClass3(java.lang.Exception exc) {
            this.n = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.tanx.onlyid.api.impl.HonorImpl.this.f != null) {
                com.tanx.onlyid.api.impl.HonorImpl.this.f.oaidError(this.n);
            } else {
                java.lang.String unused = com.tanx.onlyid.api.impl.HonorImpl.this.a;
            }
            com.tanx.onlyid.api.impl.HonorImpl honorImpl = com.tanx.onlyid.api.impl.HonorImpl.this;
            honorImpl.n(honorImpl.g);
        }
    }

    public class HiHonorServiceConnection implements android.content.ServiceConnection {
        public java.lang.String n = "HiHonorServiceConnection";

        public HiHonorServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                com.hihonor.cloudservice.oaid.IOAIDService asInterface = com.hihonor.cloudservice.oaid.IOAIDService.Stub.asInterface(iBinder);
                asInterface.getOAID(com.tanx.onlyid.api.impl.HonorImpl.this.new OAIDCallBack());
                asInterface.isOAIDTrackingLimited(com.tanx.onlyid.api.impl.HonorImpl.this.new OAIDLimitCallback());
            } catch (java.lang.Exception e) {
                com.tanx.onlyid.api.impl.HonorImpl.this.k(e);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("onServiceConnected error:");
                sb.append(e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.tanx.onlyid.api.impl.HonorImpl.this.g = null;
        }
    }

    public class OAIDCallBack extends com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub {
        public OAIDCallBack() {
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
        public void basicTypes(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException {
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
        public void handleResult(int i, android.os.Bundle bundle) throws android.os.RemoteException {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("OAIDCallBack handleResult retCode=");
            sb.append(i);
            sb.append(" retInfo=");
            sb.append(bundle);
            if (i != 0 || bundle == null) {
                return;
            }
            com.tanx.onlyid.api.impl.HonorImpl.this.l(bundle.getString("oa_id_flag"));
        }
    }

    public class OAIDLimitCallback extends com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub {
        public OAIDLimitCallback() {
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
        public void basicTypes(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException {
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
        public void handleResult(int i, android.os.Bundle bundle) throws android.os.RemoteException {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("OAIDCallBack handleResult retCode=");
            sb.append(i);
            sb.append(" retInfo=");
            sb.append(bundle);
            if (i == 0 && bundle != null && bundle.getBoolean(com.tanx.onlyid.core.hihonor.OAIDKeys.KEY_OA_ID_LIMIT_STATE)) {
                com.tanx.onlyid.api.impl.HonorImpl.this.k(new com.tanx.onlyid.api.OAIDException("用户启用了oaid限制获取开关"));
                com.tanx.onlyid.api.impl.HonorImpl honorImpl = com.tanx.onlyid.api.impl.HonorImpl.this;
                honorImpl.n(honorImpl.g);
            }
        }
    }

    public HonorImpl(android.content.Context context) {
        this.b = context;
    }

    private void bindService(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction(this.e);
        intent.setPackage(this.d);
        com.tanx.onlyid.api.impl.HonorImpl.HiHonorServiceConnection hiHonorServiceConnection = this.g;
        if (hiHonorServiceConnection != null) {
            boolean bindService = context.bindService(intent, hiHonorServiceConnection, 1);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("bind service failed: ");
            sb.append(bindService);
        }
    }

    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        if (this.b == null || iGetter == null) {
            return;
        }
        this.f = iGetter;
        java.util.concurrent.Executors.newSingleThreadExecutor().execute(new com.tanx.onlyid.api.impl.HonorImpl.AnonymousClass1());
    }

    public final boolean j(android.content.Context context) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        android.content.Intent intent = new android.content.Intent(this.e);
        intent.setPackage(this.d);
        if ((packageManager != null ? packageManager.queryIntentServices(intent, 0) : null) != null) {
            return !r3.isEmpty();
        }
        return false;
    }

    public final void k(java.lang.Exception exc) {
        this.c.post(new com.tanx.onlyid.api.impl.HonorImpl.AnonymousClass3(exc));
    }

    public final void l(java.lang.String str) {
        this.c.post(new com.tanx.onlyid.api.impl.HonorImpl.AnonymousClass2(str));
    }

    public final void m() {
        try {
            if (this.g == null) {
                this.g = new com.tanx.onlyid.api.impl.HonorImpl.HiHonorServiceConnection();
            }
            n(this.g);
            bindService(this.b);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("bind service exception: ");
            sb.append(e.getMessage());
            com.tanx.onlyid.api.OAIDLog.print(e);
            k(new com.tanx.onlyid.api.OAIDException(e));
        }
    }

    public final void n(android.content.ServiceConnection serviceConnection) {
        try {
            android.content.Context context = this.b;
            if (context == null || serviceConnection == null) {
                return;
            }
            context.unbindService(serviceConnection);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // com.tanx.onlyid.api.IOAID
    public boolean supported() {
        android.content.Context context = this.b;
        if (context == null) {
            return false;
        }
        return j(context);
    }
}
