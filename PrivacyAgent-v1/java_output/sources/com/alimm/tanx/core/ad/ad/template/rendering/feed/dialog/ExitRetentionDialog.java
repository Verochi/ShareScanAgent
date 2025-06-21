package com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog;

/* loaded from: classes.dex */
public class ExitRetentionDialog extends com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_do implements android.view.View.OnClickListener, com.alimm.tanx.core.utils.NotConfused {
    private static java.lang.String TAG = "ExitRetentionDialog";
    private java.lang.String backImgUrl;
    private android.widget.Button btnContinue;
    private com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.ClickCallBack clickCallBack;
    private android.widget.ImageView ivBack;
    private android.widget.ImageView ivClose;
    private android.widget.TextView tvExit;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback {
        final /* synthetic */ com.alimm.tanx.core.image.util.ImageConfig tanxc_do;

        public AnonymousClass1(com.alimm.tanx.core.image.util.ImageConfig imageConfig) {
            this.tanxc_do = imageConfig;
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onFailure(java.lang.String str) {
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onSuccess(android.graphics.Bitmap bitmap) {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.this.ivBack.setImageBitmap(bitmap);
            com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.this.ivBack.setImageDrawable(new com.alimm.tanx.core.image.util.TanxDrawable(bitmap, this.tanxc_do.getImageConfig()));
        }
    }

    public interface ClickCallBack {
        void continueClick();

        void exitClick();
    }

    public ExitRetentionDialog(@androidx.annotation.NonNull android.content.Context context, int i) {
        super(context, i);
        this.backImgUrl = "https://gw.alicdn.com/imgextra/i3/O1CN01yRRocx28JI2PSwyrX_!!6000000007911-0-tps-1080-1320.jpg_q90.jpg";
        setContentView(com.alimm.tanx.core.R.layout.dialog_exit_retention);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        initView();
        initClick();
    }

    private void initClick() {
        this.ivClose.setOnClickListener(this);
        this.tvExit.setOnClickListener(this);
        this.btnContinue.setOnClickListener(this);
    }

    private void initView() {
        float f;
        this.ivClose = (android.widget.ImageView) findViewById(com.alimm.tanx.core.R.id.iv_close);
        this.tvExit = (android.widget.TextView) findViewById(com.alimm.tanx.core.R.id.tv_exit);
        this.ivBack = (android.widget.ImageView) findViewById(com.alimm.tanx.core.R.id.iv_back);
        this.btnContinue = (android.widget.Button) findViewById(com.alimm.tanx.core.R.id.btn_continue);
        try {
            f = this.ivBack.getResources().getDimension(com.alimm.tanx.core.R.dimen.error_pop_radius);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
            f = 30.0f;
        }
        com.alimm.tanx.core.image.util.ImageConfig build = com.alimm.tanx.core.image.ImageManager.with(this.ivBack.getContext()).url(this.backImgUrl).shapeMode(com.alimm.tanx.core.image.util.ShapeMode.RECT_ROUND).scaleMode(com.alimm.tanx.core.image.util.ScaleMode.FIT_CENTER).radius((int) f).build();
        com.alimm.tanx.core.image.ImageManager.getLoader().load(build, new com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.AnonymousClass1(build));
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.ClickCallBack clickCallBack;
        com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.ClickCallBack clickCallBack2;
        int id = view.getId();
        if (id == com.alimm.tanx.core.R.id.tv_exit && (clickCallBack2 = this.clickCallBack) != null) {
            clickCallBack2.exitClick();
        }
        if (id == com.alimm.tanx.core.R.id.btn_continue && (clickCallBack = this.clickCallBack) != null) {
            clickCallBack.continueClick();
        }
        dismiss();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setClickCallBack(com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.ClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }
}
