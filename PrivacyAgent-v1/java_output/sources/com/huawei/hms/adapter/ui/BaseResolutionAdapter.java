package com.huawei.hms.adapter.ui;

/* loaded from: classes22.dex */
public class BaseResolutionAdapter implements com.huawei.hms.activity.IBridgeActivityDelegate {
    public java.lang.ref.WeakReference<android.app.Activity> a;
    public java.lang.String b = "";

    public final void a() {
        android.app.Activity b = b();
        if (b == null || b.isFinishing()) {
            return;
        }
        b.finish();
    }

    public final android.app.Activity b() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void c() {
        com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyResolutionResult(null, this.b);
        a();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(android.app.Activity activity) {
        this.a = new java.lang.ref.WeakReference<>(activity);
        android.content.Intent intent = activity.getIntent();
        if (intent == null) {
            c();
            return;
        }
        android.os.Bundle extras = intent.getExtras();
        this.b = intent.getStringExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.TRANSACTION_ID);
        if (extras == null) {
            c();
            return;
        }
        android.os.Parcelable parcelable = extras.getParcelable("resolution");
        if (parcelable == null) {
            c();
            return;
        }
        if (parcelable instanceof android.content.Intent) {
            try {
                activity.startActivityForResult((android.content.Intent) parcelable, 1001);
                return;
            } catch (android.content.ActivityNotFoundException unused) {
                c();
                com.huawei.hms.support.log.HMSLog.e("BaseResolutionAdapter", "ActivityNotFoundException:exception");
                return;
            }
        }
        if (parcelable instanceof android.app.PendingIntent) {
            try {
                activity.startIntentSenderForResult(((android.app.PendingIntent) parcelable).getIntentSender(), 1001, null, 0, 0, 0);
            } catch (android.content.IntentSender.SendIntentException unused2) {
                c();
                com.huawei.hms.support.log.HMSLog.e("BaseResolutionAdapter", "SendIntentException:exception");
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        com.huawei.hms.support.log.HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, android.content.Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        com.huawei.hms.support.log.HMSLog.i("BaseResolutionAdapter", "onBridgeActivityResult, resultCode: " + i2);
        if (i2 == 1001 || i2 == 1002) {
            if (intent == null) {
                intent = new android.content.Intent();
            }
            intent.putExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, i2);
        }
        if (i2 == -1 || intent.hasExtra(com.huawei.hms.update.kpms.KpmsConstant.KIT_UPDATE_RESULT) || intent.hasExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyResolutionResult(intent, this.b);
        } else {
            com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyResolutionResult(null, this.b);
        }
        a();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        com.huawei.hms.support.log.HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, android.view.KeyEvent keyEvent) {
        com.huawei.hms.support.log.HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
    }
}
