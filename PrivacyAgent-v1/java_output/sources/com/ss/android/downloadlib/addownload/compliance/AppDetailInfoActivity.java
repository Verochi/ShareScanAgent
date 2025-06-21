package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: classes19.dex */
public class AppDetailInfoActivity extends android.app.Activity {
    private java.util.List<android.util.Pair<java.lang.String, java.lang.String>> bt;
    private long kz;
    private android.widget.LinearLayout t;
    private androidx.recyclerview.widget.RecyclerView v;
    private android.widget.ImageView vw;
    private android.widget.TextView wg;
    private long yl;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.ss.android.downloadlib.addownload.compliance.bt.vw("lp_app_detail_click_close", com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.this.kz);
            com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.ss.android.downloadlib.addownload.compliance.bt.vw("lp_app_detail_click_download", com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.this.kz);
            com.ss.android.downloadlib.addownload.compliance.wg.vw().wg(com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.this.kz);
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.this);
            com.ss.android.socialbase.appdownloader.t.vw(com.ss.android.downloadlib.addownload.compliance.wg.vw().wg());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class vw extends androidx.recyclerview.widget.RecyclerView.Adapter<java.lang.Object> {
        private vw() {
        }

        public /* synthetic */ vw(com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity appDetailInfoActivity, com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static void vw(android.app.Activity activity, long j) {
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean vw() {
        this.yl = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.wg.wg vw2 = com.ss.android.downloadlib.addownload.compliance.t.vw().vw(this.yl);
        if (vw2 == null) {
            return false;
        }
        this.kz = vw2.wg;
        this.bt = vw2.o;
        return true;
    }

    private void wg() {
        this.vw = (android.widget.ImageView) findViewById(com.bytedance.sdk.openadsdk.R.id.iv_detail_back);
        this.wg = (android.widget.TextView) findViewById(com.bytedance.sdk.openadsdk.R.id.tv_empty);
        this.v = (androidx.recyclerview.widget.RecyclerView) findViewById(com.bytedance.sdk.openadsdk.R.id.permission_list);
        this.t = (android.widget.LinearLayout) findViewById(com.bytedance.sdk.openadsdk.R.id.ll_download);
        if (this.bt.isEmpty()) {
            this.v.setVisibility(8);
            this.wg.setVisibility(0);
        } else {
            androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = new androidx.recyclerview.widget.LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.v.setLayoutManager(linearLayoutManager);
            this.v.setAdapter(new com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.vw(this, null));
        }
        this.vw.setOnClickListener(new com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.AnonymousClass1());
        this.t.setOnClickListener(new com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.AnonymousClass2());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.ss.android.downloadlib.addownload.compliance.bt.vw("lp_app_detail_click_close", this.kz);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.R.layout.ttdownloader_activity_app_detail_info);
        if (vw()) {
            wg();
        } else {
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
