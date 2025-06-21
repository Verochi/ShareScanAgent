package com.ss.android.downloadlib.addownload.vw;

/* loaded from: classes19.dex */
public class yl extends android.app.Dialog {
    private boolean bt;
    private java.lang.String es;
    private com.ss.android.downloadlib.addownload.vw.t kz;
    private boolean o;
    private android.widget.TextView t;
    private java.lang.String u;
    private android.widget.TextView v;
    private java.lang.String vl;
    private android.widget.TextView vw;
    private android.widget.TextView wg;
    private android.app.Activity x;
    private com.ss.android.downloadlib.addownload.vw.v yl;
    private java.lang.String z;

    /* renamed from: com.ss.android.downloadlib.addownload.vw.yl$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.ss.android.downloadlib.addownload.vw.yl.this.yl();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.vw.yl$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.ss.android.downloadlib.addownload.vw.yl.this.kz();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.vw.yl$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.ss.android.downloadlib.addownload.vw.yl.this.delete();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class vw {
        private com.ss.android.downloadlib.addownload.vw.v bt;
        private boolean kz;
        private com.ss.android.downloadlib.addownload.vw.t o;
        private java.lang.String t;
        private java.lang.String v;
        private android.app.Activity vw;
        private java.lang.String wg;
        private java.lang.String yl;

        public vw(android.app.Activity activity) {
            this.vw = activity;
        }

        public com.ss.android.downloadlib.addownload.vw.yl.vw t(java.lang.String str) {
            this.v = str;
            return this;
        }

        public com.ss.android.downloadlib.addownload.vw.yl.vw v(java.lang.String str) {
            this.yl = str;
            return this;
        }

        public com.ss.android.downloadlib.addownload.vw.yl.vw vw(com.ss.android.downloadlib.addownload.vw.t tVar) {
            this.o = tVar;
            return this;
        }

        public com.ss.android.downloadlib.addownload.vw.yl.vw vw(com.ss.android.downloadlib.addownload.vw.v vVar) {
            this.bt = vVar;
            return this;
        }

        public com.ss.android.downloadlib.addownload.vw.yl.vw vw(java.lang.String str) {
            this.wg = str;
            return this;
        }

        public com.ss.android.downloadlib.addownload.vw.yl.vw vw(boolean z) {
            this.kz = z;
            return this;
        }

        public com.ss.android.downloadlib.addownload.vw.yl vw() {
            return new com.ss.android.downloadlib.addownload.vw.yl(this.vw, this.wg, this.t, this.v, this.yl, this.kz, this.bt, this.o);
        }

        public com.ss.android.downloadlib.addownload.vw.yl.vw wg(java.lang.String str) {
            this.t = str;
            return this;
        }
    }

    public yl(@androidx.annotation.NonNull android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, boolean z, @androidx.annotation.NonNull com.ss.android.downloadlib.addownload.vw.v vVar, com.ss.android.downloadlib.addownload.vw.t tVar) {
        super(activity, com.bytedance.sdk.openadsdk.R.style.ttdownloader_translucent_dialog);
        this.x = activity;
        this.yl = vVar;
        this.es = str;
        this.z = str2;
        this.vl = str3;
        this.u = str4;
        this.kz = tVar;
        setCanceledOnTouchOutside(z);
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.o = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz() {
        dismiss();
    }

    private void v() {
        setContentView(android.view.LayoutInflater.from(this.x.getApplicationContext()).inflate(vw(), (android.view.ViewGroup) null));
        this.vw = (android.widget.TextView) findViewById(wg());
        this.wg = (android.widget.TextView) findViewById(t());
        this.t = (android.widget.TextView) findViewById(com.bytedance.sdk.openadsdk.R.id.message_tv);
        this.v = (android.widget.TextView) findViewById(com.bytedance.sdk.openadsdk.R.id.delete_tv);
        if (!android.text.TextUtils.isEmpty(this.z)) {
            this.vw.setText(this.z);
        }
        if (!android.text.TextUtils.isEmpty(this.vl)) {
            this.wg.setText(this.vl);
        }
        if (android.text.TextUtils.isEmpty(this.u)) {
            this.v.setVisibility(8);
        } else {
            this.v.setText(this.u);
        }
        if (!android.text.TextUtils.isEmpty(this.es)) {
            this.t.setText(this.es);
        }
        this.vw.setOnClickListener(new com.ss.android.downloadlib.addownload.vw.yl.AnonymousClass1());
        this.wg.setOnClickListener(new com.ss.android.downloadlib.addownload.vw.yl.AnonymousClass2());
        this.v.setOnClickListener(new com.ss.android.downloadlib.addownload.vw.yl.AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl() {
        this.bt = true;
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.x.isFinishing()) {
            this.x.finish();
        }
        if (this.bt) {
            this.yl.vw();
        } else if (this.o) {
            this.kz.delete();
        } else {
            this.yl.wg();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@androidx.annotation.NonNull android.view.KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int t() {
        return com.bytedance.sdk.openadsdk.R.id.cancel_tv;
    }

    public int vw() {
        return com.bytedance.sdk.openadsdk.R.layout.ttdownloader_dialog_select_operation;
    }

    public int wg() {
        return com.bytedance.sdk.openadsdk.R.id.confirm_tv;
    }
}
