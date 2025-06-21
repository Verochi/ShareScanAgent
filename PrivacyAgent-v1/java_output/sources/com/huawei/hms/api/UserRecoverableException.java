package com.huawei.hms.api;

/* loaded from: classes22.dex */
public class UserRecoverableException extends java.lang.Exception {
    private final android.content.Intent mIntent;

    public UserRecoverableException(java.lang.String str, android.content.Intent intent) {
        super(str);
        this.mIntent = intent;
    }

    public android.content.Intent getIntent() {
        return new android.content.Intent(this.mIntent);
    }
}
