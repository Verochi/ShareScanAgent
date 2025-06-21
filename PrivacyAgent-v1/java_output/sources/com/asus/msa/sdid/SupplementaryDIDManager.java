package com.asus.msa.sdid;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class SupplementaryDIDManager {
    public static boolean DEBUG = false;
    public static final java.lang.String TAG = "SupplementaryDIDManager";
    public android.content.Context mContext;
    public com.asus.msa.SupplementaryDID.IDidAidlInterface mDidService;
    public com.asus.msa.sdid.IDIDBinderStatusListener mListener;
    public boolean isBinded = false;
    public android.content.ServiceConnection mServiceConnection = new com.asus.msa.sdid.SupplementaryDIDManager.AnonymousClass1();

    /* renamed from: com.asus.msa.sdid.SupplementaryDIDManager$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            boolean unused = com.asus.msa.sdid.SupplementaryDIDManager.DEBUG;
            com.asus.msa.sdid.SupplementaryDIDManager.this.mDidService = com.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.a(iBinder);
            com.asus.msa.sdid.SupplementaryDIDManager.this.notifyAllListeners(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.asus.msa.sdid.SupplementaryDIDManager.this.notifyAllListeners(false);
        }
    }

    public SupplementaryDIDManager(android.content.Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAllListeners(boolean z) {
        try {
            if (z) {
                this.mListener.a(this.mDidService);
            } else {
                this.mListener.b();
            }
        } catch (java.lang.Exception e) {
            if (DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("notify did bind status error :");
                sb.append(e.getMessage());
            }
        }
    }

    public void deInit() {
        try {
            if (!this.isBinded || this.mServiceConnection == null || this.mContext == null) {
                return;
            }
            boolean z = DEBUG;
            this.isBinded = false;
            this.mContext.unbindService(this.mServiceConnection);
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void init(com.asus.msa.sdid.IDIDBinderStatusListener iDIDBinderStatusListener) {
        try {
            this.mListener = iDIDBinderStatusListener;
            android.content.Intent intent = new android.content.Intent("com.asus.msa.action.ACCESS_DID");
            android.content.ComponentName componentName = new android.content.ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            android.content.Intent intent2 = new android.content.Intent(intent);
            intent2.setComponent(componentName);
            boolean z = DEBUG;
            this.isBinded = this.mContext.bindService(intent2, this.mServiceConnection, 1);
        } catch (java.lang.Exception unused) {
            notifyAllListeners(false);
        }
    }

    public void showLog(boolean z) {
        DEBUG = z;
    }
}
