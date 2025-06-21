package com.huawei.hms.support.api.client;

/* loaded from: classes22.dex */
public class BundleResult {
    private int a;
    private android.os.Bundle b;

    public BundleResult(int i, android.os.Bundle bundle) {
        this.a = i;
        this.b = bundle;
    }

    public int getResultCode() {
        return this.a;
    }

    public android.os.Bundle getRspBody() {
        return this.b;
    }

    public void setResultCode(int i) {
        this.a = i;
    }

    public void setRspBody(android.os.Bundle bundle) {
        this.b = bundle;
    }
}
