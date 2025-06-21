package com.huawei.hms.adapter;

/* loaded from: classes22.dex */
public class BinderAdapter implements android.content.ServiceConnection {
    private static final int BINDER_SYSTEM_ERROR = -1;
    private static final int DELAY_MILLIS = 1800000;
    private static final java.lang.String TAG = "BinderAdapter";
    private com.huawei.hms.adapter.BinderAdapter.BinderCallBack callback;
    private final java.lang.String mAction;
    private android.content.Context mContext;
    private final java.lang.String mService;
    private android.os.IBinder serviceBinder;
    private final java.lang.Object LOCK_CONNECT_TIMEOUT_HANDLER = new java.lang.Object();
    private boolean bindFail = false;
    private android.os.Handler mBinderTimeoutHandler = null;
    private android.os.Handler delayDisconnectHandler = null;

    /* renamed from: com.huawei.hms.adapter.BinderAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Handler.Callback {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message == null || message.what != com.huawei.hms.adapter.BinderAdapter.this.getConnTimeOut()) {
                return false;
            }
            com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.adapter.BinderAdapter.TAG, "In connect, bind core service time out");
            com.huawei.hms.adapter.BinderAdapter.this.binderServiceFailed();
            return true;
        }
    }

    /* renamed from: com.huawei.hms.adapter.BinderAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements android.os.Handler.Callback {
        public AnonymousClass2() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message == null || message.what != com.huawei.hms.adapter.BinderAdapter.this.getMsgDelayDisconnect()) {
                return false;
            }
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.adapter.BinderAdapter.TAG, "The serviceConnection has been bind for 60s, need to unbind.");
            com.huawei.hms.adapter.BinderAdapter.this.unBind();
            com.huawei.hms.adapter.BinderAdapter.BinderCallBack callBack = com.huawei.hms.adapter.BinderAdapter.this.getCallBack();
            if (callBack == null) {
                return true;
            }
            callBack.onTimedDisconnected();
            return true;
        }
    }

    public interface BinderCallBack {
        void onBinderFailed(int i);

        void onBinderFailed(int i, android.content.Intent intent);

        void onNullBinding(android.content.ComponentName componentName);

        void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

        void onServiceDisconnected(android.content.ComponentName componentName);

        void onTimedDisconnected();
    }

    public BinderAdapter(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.mContext = context;
        this.mAction = str;
        this.mService = str2;
    }

    private void bindCoreService() {
        if (android.text.TextUtils.isEmpty(this.mAction) || android.text.TextUtils.isEmpty(this.mService)) {
            getBindFailPendingIntent();
        }
        android.content.Intent intent = new android.content.Intent(this.mAction);
        intent.setPackage(this.mService);
        synchronized (this.LOCK_CONNECT_TIMEOUT_HANDLER) {
            if (this.mContext.bindService(intent, this, 1)) {
                postConnDelayHandle();
            } else {
                this.bindFail = true;
                getBindFailPendingIntent();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void binderServiceFailed() {
        com.huawei.hms.adapter.BinderAdapter.BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onBinderFailed(-1);
        }
    }

    private void cancelConnDelayHandle() {
        synchronized (this.LOCK_CONNECT_TIMEOUT_HANDLER) {
            android.os.Handler handler = this.mBinderTimeoutHandler;
            if (handler != null) {
                handler.removeMessages(getConnTimeOut());
                this.mBinderTimeoutHandler = null;
            }
        }
    }

    private void delayedUnbind() {
        android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper(), new com.huawei.hms.adapter.BinderAdapter.AnonymousClass2());
        this.delayDisconnectHandler = handler;
        handler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
    }

    private void getBindFailPendingIntent() {
        com.huawei.hms.support.log.HMSLog.e(TAG, "In connect, bind core service fail");
        android.content.ComponentName componentName = new android.content.ComponentName(this.mContext.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(componentName);
        intent.putExtra(com.huawei.hms.activity.BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, com.huawei.hms.api.BindingFailedResolution.class.getName());
        com.huawei.hms.adapter.BinderAdapter.BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onBinderFailed(-1, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.huawei.hms.adapter.BinderAdapter.BinderCallBack getCallBack() {
        return this.callback;
    }

    private void postConnDelayHandle() {
        android.os.Handler handler = this.mBinderTimeoutHandler;
        if (handler != null) {
            handler.removeMessages(getConnTimeOut());
        } else {
            this.mBinderTimeoutHandler = new android.os.Handler(android.os.Looper.getMainLooper(), new com.huawei.hms.adapter.BinderAdapter.AnonymousClass1());
        }
        this.mBinderTimeoutHandler.sendEmptyMessageDelayed(getConnTimeOut(), 10000L);
    }

    private void removeDelayDisconnectTask() {
        com.huawei.hms.support.log.HMSLog.d(TAG, "removeDelayDisconnectTask.");
        synchronized (com.huawei.hms.adapter.BinderAdapter.class) {
            android.os.Handler handler = this.delayDisconnectHandler;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
            }
        }
    }

    public void binder(com.huawei.hms.adapter.BinderAdapter.BinderCallBack binderCallBack) {
        if (binderCallBack == null) {
            return;
        }
        this.callback = binderCallBack;
        bindCoreService();
    }

    public int getConnTimeOut() {
        return 0;
    }

    public int getMsgDelayDisconnect() {
        return 0;
    }

    public android.os.IBinder getServiceBinder() {
        return this.serviceBinder;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(android.content.ComponentName componentName) {
        com.huawei.hms.support.log.HMSLog.e(TAG, "Enter onNullBinding, than unBind.");
        if (this.bindFail) {
            this.bindFail = false;
            return;
        }
        unBind();
        cancelConnDelayHandle();
        com.huawei.hms.adapter.BinderAdapter.BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onNullBinding(componentName);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "BinderAdapter Enter onServiceConnected.");
        this.serviceBinder = iBinder;
        cancelConnDelayHandle();
        com.huawei.hms.adapter.BinderAdapter.BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onServiceConnected(componentName, iBinder);
        }
        delayedUnbind();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "Enter onServiceDisconnected.");
        com.huawei.hms.adapter.BinderAdapter.BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onServiceDisconnected(componentName);
        }
        removeDelayDisconnectTask();
    }

    public void unBind() {
        com.huawei.hms.utils.Util.unBindServiceCatchException(this.mContext, this);
    }

    public void updateDelayTask() {
        com.huawei.hms.support.log.HMSLog.d(TAG, "updateDelayTask.");
        synchronized (com.huawei.hms.adapter.BinderAdapter.class) {
            android.os.Handler handler = this.delayDisconnectHandler;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
                this.delayDisconnectHandler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
            }
        }
    }
}
