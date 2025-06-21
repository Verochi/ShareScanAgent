package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class m implements android.content.ServiceConnection {
    public android.os.Messenger a;
    public android.os.Bundle b;
    public java.lang.ref.WeakReference<android.content.Context> c;

    public void a(android.content.Context context, android.os.Bundle bundle) {
        com.hihonor.push.sdk.common.logger.Logger.i("MessengerSrvConnection", "bind service start.");
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction(com.hihonor.push.sdk.common.constants.PushReceiverConstants.ACTION_NAME);
            android.content.Context applicationContext = context.getApplicationContext();
            this.c = new java.lang.ref.WeakReference<>(applicationContext);
            this.b = bundle;
            if (applicationContext.bindService(intent, this, 1)) {
                com.hihonor.push.sdk.common.logger.Logger.i("MessengerSrvConnection", "bind service successful.");
            } else {
                com.hihonor.push.sdk.common.logger.Logger.e("MessengerSrvConnection", "bind service failure.");
            }
        } catch (java.lang.Exception e) {
            com.hihonor.push.sdk.common.logger.Logger.e("MessengerSrvConnection", "bind service failure.Exception is ".concat(java.lang.String.valueOf(e)));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        com.hihonor.push.sdk.common.logger.Logger.i("MessengerSrvConnection", "onServiceConnected , start message send.");
        this.a = new android.os.Messenger(iBinder);
        android.os.Message obtain = android.os.Message.obtain();
        obtain.setData(this.b);
        try {
            this.a.send(obtain);
        } catch (java.lang.Exception e) {
            com.hihonor.push.sdk.common.logger.Logger.e("MessengerSrvConnection", "message send failed, e :".concat(java.lang.String.valueOf(e)));
        }
        com.hihonor.push.sdk.common.logger.Logger.i("MessengerSrvConnection", "start unbind service");
        try {
            this.c.get().unbindService(this);
        } catch (java.lang.Exception unused) {
            com.hihonor.push.sdk.common.logger.Logger.e("MessengerSrvConnection", "unbind service failure.");
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        com.hihonor.push.sdk.common.logger.Logger.i("MessengerSrvConnection", "onDisconnected");
        this.c = null;
        this.a = null;
        this.b = null;
    }
}
