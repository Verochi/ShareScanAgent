package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: classes19.dex */
public class vw extends android.app.Dialog {
    private com.ss.android.downloadlib.guide.install.ClipImageView bt;
    private final long es;
    private android.widget.TextView kz;
    private android.widget.LinearLayout o;
    private android.widget.TextView t;
    private android.widget.TextView v;
    private final com.ss.android.downloadlib.addownload.wg.wg vl;
    private android.widget.TextView vw;
    private android.widget.TextView wg;
    private android.app.Activity x;
    private android.widget.TextView yl;
    private long z;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.vw$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.DialogInterface.OnCancelListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(android.content.DialogInterface dialogInterface) {
            com.ss.android.downloadlib.addownload.compliance.bt.vw("lp_app_dialog_cancel", com.ss.android.downloadlib.addownload.compliance.vw.this.z);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.vw$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.downloadlib.addownload.compliance.v.vw {
        public AnonymousClass2() {
        }

        @Override // com.ss.android.downloadlib.addownload.compliance.v.vw
        public void vw(android.graphics.Bitmap bitmap) {
            if (bitmap != null) {
                com.ss.android.downloadlib.addownload.compliance.vw.this.bt.setImageBitmap(bitmap);
            } else {
                com.ss.android.downloadlib.addownload.compliance.bt.vw(8, com.ss.android.downloadlib.addownload.compliance.vw.this.z);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.vw$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.ss.android.downloadlib.addownload.compliance.wg.vw().vw(com.ss.android.downloadlib.addownload.compliance.vw.this.x);
            com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.vw(com.ss.android.downloadlib.addownload.compliance.vw.this.x, com.ss.android.downloadlib.addownload.compliance.vw.this.es);
            com.ss.android.downloadlib.addownload.compliance.bt.vw("lp_app_dialog_click_detail", com.ss.android.downloadlib.addownload.compliance.vw.this.z);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.vw$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.ss.android.downloadlib.addownload.compliance.wg.vw().vw(com.ss.android.downloadlib.addownload.compliance.vw.this.x);
            com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.vw(com.ss.android.downloadlib.addownload.compliance.vw.this.x, com.ss.android.downloadlib.addownload.compliance.vw.this.es);
            com.ss.android.downloadlib.addownload.compliance.bt.vw("lp_app_dialog_click_privacy", com.ss.android.downloadlib.addownload.compliance.vw.this.z);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.vw$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.ss.android.downloadlib.addownload.compliance.vw.this.dismiss();
            com.ss.android.downloadlib.addownload.compliance.bt.vw("lp_app_dialog_click_giveup", com.ss.android.downloadlib.addownload.compliance.vw.this.z);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.vw$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.ss.android.downloadlib.addownload.compliance.bt.vw("lp_app_dialog_click_download", com.ss.android.downloadlib.addownload.compliance.vw.this.z);
            com.ss.android.downloadlib.addownload.compliance.wg.vw().wg(com.ss.android.downloadlib.addownload.compliance.vw.this.z);
            com.ss.android.downloadlib.addownload.compliance.vw.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public vw(@androidx.annotation.NonNull android.app.Activity activity, long j) {
        super(activity);
        this.x = activity;
        this.es = j;
        this.vl = com.ss.android.downloadlib.addownload.compliance.t.vw().get(java.lang.Long.valueOf(j));
    }

    private void vw() {
        this.vw = (android.widget.TextView) findViewById(com.bytedance.sdk.openadsdk.R.id.tv_app_name);
        this.wg = (android.widget.TextView) findViewById(com.bytedance.sdk.openadsdk.R.id.tv_app_version);
        this.t = (android.widget.TextView) findViewById(com.bytedance.sdk.openadsdk.R.id.tv_app_developer);
        this.v = (android.widget.TextView) findViewById(com.bytedance.sdk.openadsdk.R.id.tv_app_detail);
        this.yl = (android.widget.TextView) findViewById(com.bytedance.sdk.openadsdk.R.id.tv_app_privacy);
        this.kz = (android.widget.TextView) findViewById(com.bytedance.sdk.openadsdk.R.id.tv_give_up);
        this.bt = (com.ss.android.downloadlib.guide.install.ClipImageView) findViewById(com.bytedance.sdk.openadsdk.R.id.iv_app_icon);
        this.o = (android.widget.LinearLayout) findViewById(com.bytedance.sdk.openadsdk.R.id.ll_download);
        this.vw.setText(com.ss.android.downloadlib.bt.vl.vw(this.vl.yl, "--"));
        this.wg.setText("版本号：" + com.ss.android.downloadlib.bt.vl.vw(this.vl.kz, "--"));
        this.t.setText("开发者：" + com.ss.android.downloadlib.bt.vl.vw(this.vl.bt, "应用信息正在完善中"));
        this.bt.setRoundRadius(com.ss.android.downloadlib.bt.vl.vw(com.ss.android.downloadlib.addownload.z.getContext(), 8.0f));
        this.bt.setBackgroundColor(android.graphics.Color.parseColor("#EBEBEB"));
        com.ss.android.downloadlib.addownload.compliance.v.vw().vw(this.es, new com.ss.android.downloadlib.addownload.compliance.vw.AnonymousClass2());
        this.v.setOnClickListener(new com.ss.android.downloadlib.addownload.compliance.vw.AnonymousClass3());
        this.yl.setOnClickListener(new com.ss.android.downloadlib.addownload.compliance.vw.AnonymousClass4());
        this.kz.setOnClickListener(new com.ss.android.downloadlib.addownload.compliance.vw.AnonymousClass5());
        this.o.setOnClickListener(new com.ss.android.downloadlib.addownload.compliance.vw.AnonymousClass6());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.t.vw(this.x);
    }

    @Override // android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (this.vl == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(com.bytedance.sdk.openadsdk.R.layout.ttdownloader_dialog_appinfo);
        android.view.Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(com.bytedance.sdk.openadsdk.R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.z = this.vl.wg;
        vw();
        com.ss.android.downloadlib.addownload.compliance.bt.wg("lp_app_dialog_show", this.z);
        setOnCancelListener(new com.ss.android.downloadlib.addownload.compliance.vw.AnonymousClass1());
    }
}
