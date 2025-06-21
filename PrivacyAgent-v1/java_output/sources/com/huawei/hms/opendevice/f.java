package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class f implements java.lang.Runnable {
    public android.content.Context a;

    public f(android.content.Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.String str;
        android.os.Bundle bundle;
        try {
            int internalCode = com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS.getInternalCode();
            com.huawei.hms.common.ApiException apiException = null;
            try {
                str = com.huawei.hms.aaid.HmsInstanceId.getInstance(this.a).getToken(com.huawei.hms.utils.Util.getAppId(this.a), null);
            } catch (com.huawei.hms.common.ApiException e) {
                e = e;
                str = null;
            }
            try {
                try {
                    com.huawei.hms.support.log.HMSLog.i("AutoInit", "Push init succeed");
                    if (android.text.TextUtils.isEmpty(str)) {
                        return;
                    }
                } catch (com.huawei.hms.common.ApiException e2) {
                    e = e2;
                    apiException = e;
                    internalCode = apiException.getStatusCode();
                    com.huawei.hms.support.log.HMSLog.e("AutoInit", "new Push init failed");
                    bundle = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128).metaData;
                    if (bundle != null) {
                    }
                    com.huawei.hms.support.log.HMSLog.i("AutoInit", "push kit sdk not exists");
                    return;
                }
                bundle = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128).metaData;
                if (bundle != null || bundle.getString("com.huawei.hms.client.service.name:push") == null) {
                    com.huawei.hms.support.log.HMSLog.i("AutoInit", "push kit sdk not exists");
                    return;
                }
                android.content.Intent intent = new android.content.Intent("com.huawei.push.action.MESSAGING_EVENT");
                intent.setPackage(this.a.getPackageName());
                android.os.Bundle bundle2 = new android.os.Bundle();
                bundle2.putString("message_type", "new_token");
                bundle2.putString(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN, str);
                bundle2.putInt("error", internalCode);
                if (apiException != null) {
                    bundle2.putSerializable("exception_key", apiException);
                }
                if (new com.huawei.hms.opendevice.h().a(this.a, bundle2, intent)) {
                    return;
                }
                com.huawei.hms.support.log.HMSLog.e("AutoInit", "start service failed");
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                com.huawei.hms.support.log.HMSLog.i("AutoInit", "push kit sdk not exists");
            }
        } catch (java.lang.Exception e3) {
            com.huawei.hms.support.log.HMSLog.e("AutoInit", "Push init failed", e3);
        }
    }
}
