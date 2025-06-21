package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public class DialogRedirectImpl extends com.huawei.hms.common.internal.DialogRedirect {
    private final android.app.Activity activity;
    private final android.content.Intent intent;
    private final int requestCode;

    public DialogRedirectImpl(android.content.Intent intent, android.app.Activity activity, int i) {
        this.intent = intent;
        this.activity = activity;
        this.requestCode = i;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        android.content.Intent intent = this.intent;
        if (intent != null) {
            this.activity.startActivityForResult(intent, this.requestCode);
        }
    }
}
