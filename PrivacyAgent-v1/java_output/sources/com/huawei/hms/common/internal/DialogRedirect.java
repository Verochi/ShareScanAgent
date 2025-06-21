package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public abstract class DialogRedirect implements android.content.DialogInterface.OnClickListener {
    public static com.huawei.hms.common.internal.DialogRedirect getInstance(android.app.Activity activity, android.content.Intent intent, int i) {
        return new com.huawei.hms.common.internal.DialogRedirectImpl(intent, activity, i);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        try {
            try {
                redirect();
            } catch (java.lang.Throwable unused) {
                com.huawei.hms.support.log.HMSLog.e("DialogRedirect", "Failed to start resolution intent");
            }
        } finally {
            dialogInterface.dismiss();
        }
    }

    public abstract void redirect();
}
