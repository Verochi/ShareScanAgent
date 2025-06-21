package com.huawei.hms.support.api.push;

/* loaded from: classes30.dex */
public class TransActivity extends android.app.Activity {
    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.huawei.android.hms.push.R.layout.hwpush_trans_activity);
        getWindow().addFlags(67108864);
        com.huawei.hms.push.i.a(this, getIntent());
        finish();
    }
}
