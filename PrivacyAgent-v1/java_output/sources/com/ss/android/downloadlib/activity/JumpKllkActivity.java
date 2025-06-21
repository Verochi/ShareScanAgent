package com.ss.android.downloadlib.activity;

/* loaded from: classes19.dex */
public class JumpKllkActivity extends com.ss.android.downloadlib.activity.TTDelegateActivity {
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
    }

    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    public void vw() {
        android.content.Intent intent = getIntent();
        if (getIntent() == null) {
            com.ss.android.downloadlib.yl.t.vw().vw("handleIntent is null");
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
            return;
        }
        java.lang.String stringExtra = intent.getStringExtra("p");
        long longExtra = intent.getLongExtra("id", 0L);
        if (android.text.TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            com.ss.android.downloadlib.yl.t.vw().vw("getPackage or id is null");
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
        }
        boolean booleanExtra = intent.getBooleanExtra("dl", false);
        java.lang.String stringExtra2 = intent.getStringExtra("bk");
        if (booleanExtra && (!android.text.TextUtils.isEmpty(stringExtra2))) {
            com.ss.android.downloadlib.bt.o.vw((android.content.Context) this, stringExtra, longExtra, stringExtra2, true);
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
            return;
        }
        int optInt = com.ss.android.downloadlib.addownload.z.x().optInt("ab", 0);
        com.ss.android.downloadlib.bt.o.vw(this, stringExtra, longExtra, optInt == 1);
        if (optInt != 1) {
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
        }
    }
}
