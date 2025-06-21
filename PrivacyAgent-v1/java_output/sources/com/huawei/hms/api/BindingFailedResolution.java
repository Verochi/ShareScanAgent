package com.huawei.hms.api;

/* loaded from: classes22.dex */
public class BindingFailedResolution implements com.huawei.hms.activity.IBridgeActivityDelegate, android.content.ServiceConnection {
    private static final java.lang.Object LOCK_CONNECT_TIMEOUT_HANDLER = new java.lang.Object();
    private static final int MSG_CONN_TIMEOUT = 2;
    private static final int MSG_SELF_DESTROY_TIMEOUT = 3;
    private static final int REQUEST_CODE = 2003;
    private static final java.lang.String TAG = "BindingFailedResolution";
    private com.huawei.hms.api.FailedBinderCallBack.BinderCallBack callBack;
    private android.app.Activity curActivity;
    private com.huawei.hms.api.BindingFailedResolution.d promptdlg;
    private boolean isStarting = true;
    private android.os.Handler mConnectTimeoutHandler = null;
    private android.os.Handler selfDestroyHandler = null;

    public class a implements android.os.Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            com.huawei.hms.api.BindingFailedResolution.this.finishBridgeActivity(8);
            return true;
        }
    }

    public class b implements android.os.Handler.Callback {
        public b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.api.BindingFailedResolution.TAG, "In connect, bind core try timeout");
            com.huawei.hms.api.BindingFailedResolution.this.fireStartResult(false);
            return true;
        }
    }

    public class c implements com.huawei.hms.ui.AbstractDialog.Callback {
        public c() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onCancel(com.huawei.hms.ui.AbstractDialog abstractDialog) {
            com.huawei.hms.api.BindingFailedResolution.this.promptdlg = null;
            com.huawei.hms.common.internal.BindResolveClients.getInstance().unRegisterAll();
            com.huawei.hms.api.BindingFailedResolution.this.finishBridgeActivity(8);
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onDoWork(com.huawei.hms.ui.AbstractDialog abstractDialog) {
            com.huawei.hms.api.BindingFailedResolution.this.promptdlg = null;
            com.huawei.hms.common.internal.BindResolveClients.getInstance().unRegisterAll();
            com.huawei.hms.api.BindingFailedResolution.this.finishBridgeActivity(8);
        }
    }

    public static class d extends com.huawei.hms.ui.AbstractPromptDialog {
        private d() {
        }

        public /* synthetic */ d(com.huawei.hms.api.BindingFailedResolution.a aVar) {
            this();
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public java.lang.String onGetMessageString(android.content.Context context) {
            return com.huawei.hms.utils.ResourceLoaderUtil.getString("hms_bindfaildlg_message", com.huawei.hms.utils.Util.getAppName(context, null), com.huawei.hms.utils.Util.getAppName(context, com.huawei.hms.utils.HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService()));
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public java.lang.String onGetPositiveButtonString(android.content.Context context) {
            return com.huawei.hms.utils.ResourceLoaderUtil.getString("hms_confirm");
        }
    }

    private void bindCoreService(boolean z) {
        android.app.Activity activity = getActivity();
        if (activity == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "In connect, bind core try fail");
            fireStartResult(false);
            noticeBindResult(z, 8);
            return;
        }
        android.content.Intent intent = new android.content.Intent(com.huawei.hms.utils.HMSPackageManager.getInstance(activity.getApplicationContext()).getServiceAction());
        intent.setPackage(com.huawei.hms.utils.HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService());
        synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
            if (activity.bindService(intent, this, 1)) {
                postConnDelayHandle();
                return;
            }
            com.huawei.hms.support.log.HMSLog.e(TAG, "In connect, bind core try fail");
            fireStartResult(false);
            noticeBindResult(z, 8);
        }
    }

    private void cancelConnDelayHandle() {
        synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
            android.os.Handler handler = this.mConnectTimeoutHandler;
            if (handler != null) {
                handler.removeMessages(2);
                this.mConnectTimeoutHandler = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishBridgeActivity(int i) {
        android.app.Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "finishBridgeActivity：" + i);
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(com.huawei.hms.activity.BridgeActivity.EXTRA_RESULT, i);
        activity.setResult(-1, intent);
        com.huawei.hms.utils.Util.unBindServiceCatchException(activity, this);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireStartResult(boolean z) {
        if (this.isStarting) {
            this.isStarting = false;
            onStartResult(z);
        }
    }

    private void noticeBindResult(boolean z, int i) {
        com.huawei.hms.api.FailedBinderCallBack.BinderCallBack binderCallBack;
        if (!z || (binderCallBack = this.callBack) == null) {
            return;
        }
        binderCallBack.binderCallBack(i);
    }

    private void postConnDelayHandle() {
        android.os.Handler handler = this.mConnectTimeoutHandler;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.mConnectTimeoutHandler = new android.os.Handler(android.os.Looper.getMainLooper(), new com.huawei.hms.api.BindingFailedResolution.b());
        }
        this.mConnectTimeoutHandler.sendEmptyMessageDelayed(2, 5000L);
    }

    private void selfDestroyHandle() {
        android.os.Handler handler = this.selfDestroyHandler;
        if (handler != null) {
            handler.removeMessages(3);
        } else {
            this.selfDestroyHandler = new android.os.Handler(android.os.Looper.getMainLooper(), new com.huawei.hms.api.BindingFailedResolution.a());
        }
        this.selfDestroyHandler.sendEmptyMessageDelayed(3, moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME);
    }

    private void showPromptdlg() {
        android.app.Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        com.huawei.hms.api.BindingFailedResolution.d dVar = this.promptdlg;
        if (dVar == null) {
            this.promptdlg = new com.huawei.hms.api.BindingFailedResolution.d(null);
        } else {
            dVar.dismiss();
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "showPromptdlg to resolve conn error");
        this.promptdlg.show(activity, new com.huawei.hms.api.BindingFailedResolution.c());
    }

    private void tryStartHmsActivity(android.app.Activity activity) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(com.huawei.hms.activity.BridgeActivity.EXTRA_IS_FULLSCREEN, com.huawei.hms.utils.UIUtil.isActivityFullscreen(activity));
        intent.setClassName(com.huawei.hms.utils.HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService(), com.huawei.hms.api.HuaweiApiAvailability.ACTIVITY_NAME);
        com.huawei.hms.support.log.HMSLog.i(TAG, "onBridgeActivityCreate：try to start HMS");
        try {
            activity.startActivityForResult(intent, getRequestCode());
        } catch (java.lang.Throwable th) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "ActivityNotFoundException：" + th.getMessage());
            android.os.Handler handler = this.selfDestroyHandler;
            if (handler != null) {
                handler.removeMessages(3);
                this.selfDestroyHandler = null;
            }
            bindCoreService(false);
        }
    }

    public android.app.Activity getActivity() {
        return this.curActivity;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 2003;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(android.app.Activity activity) {
        android.content.Intent intent = activity.getIntent();
        if (intent != null && intent.hasExtra(com.huawei.hms.api.FailedBinderCallBack.CALLER_ID)) {
            this.callBack = com.huawei.hms.api.FailedBinderCallBack.getInstance().getCallBack(java.lang.Long.valueOf(intent.getLongExtra(com.huawei.hms.api.FailedBinderCallBack.CALLER_ID, 0L)));
        }
        this.curActivity = activity;
        com.huawei.hms.api.a.b.a(activity);
        selfDestroyHandle();
        tryStartHmsActivity(activity);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        cancelConnDelayHandle();
        com.huawei.hms.api.a.b.b(this.curActivity);
        this.curActivity = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, android.content.Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "onBridgeActivityResult");
        android.os.Handler handler = this.selfDestroyHandler;
        if (handler != null) {
            handler.removeMessages(3);
            this.selfDestroyHandler = null;
        }
        bindCoreService(true);
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        if (this.promptdlg == null) {
            return;
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "re show prompt dialog");
        showPromptdlg();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, android.view.KeyEvent keyEvent) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "On key up when resolve conn error");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        cancelConnDelayHandle();
        fireStartResult(true);
        if (getActivity() == null) {
            return;
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "test connect success, try to reConnect and reply message");
        com.huawei.hms.common.internal.BindResolveClients.getInstance().notifyClientReconnect();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
    }

    public void onStartResult(boolean z) {
        if (getActivity() == null) {
            return;
        }
        if (z) {
            finishBridgeActivity(0);
        } else {
            showPromptdlg();
        }
    }
}
