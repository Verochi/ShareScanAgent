package com.sensorsdata.analytics.android.sdk.dialog;

/* loaded from: classes19.dex */
public class SensorsDataLoadingDialog extends android.app.Dialog {
    private android.widget.RelativeLayout mLoadingLayout;

    public SensorsDataLoadingDialog(android.content.Context context) {
        super(context);
    }

    private void initAnim() {
        android.view.animation.RotateAnimation rotateAnimation = new android.view.animation.RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(1200L);
        rotateAnimation.setInterpolator(new android.view.animation.LinearInterpolator());
        this.mLoadingLayout.setAnimation(rotateAnimation);
    }

    private void initView() {
        this.mLoadingLayout = (android.widget.RelativeLayout) findViewById(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_rotate_layout);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.sensorsdata.analytics.android.sdk.R.id.sensorsdata_analytics_loading_image1);
        android.widget.ImageView imageView2 = (android.widget.ImageView) findViewById(com.sensorsdata.analytics.android.sdk.R.id.sensorsdata_analytics_loading_image2);
        android.widget.ImageView imageView3 = (android.widget.ImageView) findViewById(com.sensorsdata.analytics.android.sdk.R.id.sensorsdata_analytics_loading_image3);
        android.widget.ImageView imageView4 = (android.widget.ImageView) findViewById(com.sensorsdata.analytics.android.sdk.R.id.sensorsdata_analytics_loading_image4);
        setCircleBackground(imageView, "#00C48E");
        setCircleBackground(imageView2, "#33D0A5");
        setCircleBackground(imageView3, "#CCF3E8");
        setCircleBackground(imageView4, "#80E1C6");
        initAnim();
    }

    private void setCircleBackground(android.view.View view, java.lang.String str) {
        android.graphics.drawable.ShapeDrawable shapeDrawable = new android.graphics.drawable.ShapeDrawable(new android.graphics.drawable.shapes.OvalShape());
        shapeDrawable.getPaint().setColor(android.graphics.Color.parseColor(str));
        shapeDrawable.getPaint().setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        view.setBackground(shapeDrawable);
    }

    @Override // android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(com.sensorsdata.analytics.android.sdk.R.layout.sensors_analytics_dialog_loading);
        android.view.Window window = getWindow();
        setCancelable(false);
        if (window != null) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.dip2px(getContext(), 98.0f);
            attributes.width = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.dip2px(getContext(), 88.0f);
            window.setAttributes(attributes);
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(-1);
            gradientDrawable.setCornerRadius(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.dip2px(getContext(), 7.0f));
            window.setBackgroundDrawable(gradientDrawable);
        }
        initView();
    }
}
