package com.ss.android.socialbase.appdownloader.view;

/* loaded from: classes19.dex */
public class JumpUnknownSourceActivity extends android.app.Activity {

    @androidx.annotation.Nullable
    private android.content.Intent t;
    private int v;
    private com.ss.android.socialbase.appdownloader.t.z vw;
    private android.content.Intent wg;
    private org.json.JSONObject yl;

    /* renamed from: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.DialogInterface.OnCancelListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(android.content.DialogInterface dialogInterface) {
            if (com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.t != null) {
                com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity jumpUnknownSourceActivity = com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this;
                com.ss.android.socialbase.appdownloader.wg.vw((android.content.Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.t, true);
            }
            com.ss.android.socialbase.appdownloader.wg.wg(com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.v, com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.yl);
            com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.finish();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.content.DialogInterface.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            if (com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.t != null) {
                com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity jumpUnknownSourceActivity = com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this;
                com.ss.android.socialbase.appdownloader.wg.vw((android.content.Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.t, true);
            }
            com.ss.android.socialbase.appdownloader.wg.wg(com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.v, com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.yl);
            com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements android.content.DialogInterface.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity jumpUnknownSourceActivity = com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this;
            if (com.ss.android.socialbase.appdownloader.wg.vw(jumpUnknownSourceActivity, jumpUnknownSourceActivity.t, com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.v, com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.yl)) {
                com.ss.android.socialbase.appdownloader.wg.t(com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.v, com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.yl);
            } else {
                com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity jumpUnknownSourceActivity2 = com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this;
                com.ss.android.socialbase.appdownloader.wg.vw((android.content.Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.t, true);
            }
            com.ss.android.socialbase.appdownloader.wg.vw(com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.v, com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.yl);
            com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    private void vw() {
        android.view.Window window = getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void wg() {
        if (this.vw != null || this.wg == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.t.t vw = com.ss.android.socialbase.appdownloader.v.es().vw();
            com.ss.android.socialbase.appdownloader.t.vl vw2 = vw != null ? vw.vw(this) : null;
            if (vw2 == null) {
                vw2 = new com.ss.android.socialbase.appdownloader.v.vw(this);
            }
            int vw3 = com.ss.android.socialbase.appdownloader.x.vw(this, "tt_appdownloader_tip");
            int vw4 = com.ss.android.socialbase.appdownloader.x.vw(this, "tt_appdownloader_label_ok");
            int vw5 = com.ss.android.socialbase.appdownloader.x.vw(this, "tt_appdownloader_label_cancel");
            java.lang.String optString = this.yl.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNOWN_SOURCE_TIPS);
            if (android.text.TextUtils.isEmpty(optString)) {
                optString = getString(com.ss.android.socialbase.appdownloader.x.vw(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            vw2.vw(vw3).vw(optString).vw(vw4, new com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.AnonymousClass3()).wg(vw5, new com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.AnonymousClass2()).vw(new com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.AnonymousClass1()).vw(false);
            this.vw = vw2.vw();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        vw();
        com.ss.android.socialbase.appdownloader.o.vw().vw(this);
    }

    @Override // android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
        super.onNewIntent(intent);
        setIntent(intent);
        com.ss.android.socialbase.appdownloader.o.vw().vw(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        android.content.Intent intent = getIntent();
        this.wg = intent;
        if (intent != null) {
            this.t = (android.content.Intent) intent.getParcelableExtra(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            this.v = intent.getIntExtra("id", -1);
            try {
                this.yl = new org.json.JSONObject(intent.getStringExtra("config"));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        if (this.yl == null) {
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
            return;
        }
        wg();
        com.ss.android.socialbase.appdownloader.t.z zVar = this.vw;
        if (zVar != null && !zVar.wg()) {
            this.vw.vw();
        } else if (this.vw == null) {
            finish();
        }
    }
}
