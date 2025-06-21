package com.aliyun.svideo.common.widget;

/* loaded from: classes.dex */
public class AlivcCircleLoadingDialog extends android.app.Dialog {
    private android.content.Context context;
    private final int mHeight;
    private android.widget.ImageView mImageView;

    public AlivcCircleLoadingDialog(android.content.Context context, int i) {
        super(context, com.aliyun.svideo.common.R.style.CustomDialogStyle);
        this.context = context;
        this.mHeight = i;
    }

    private void init() {
        android.view.View inflate = android.view.LayoutInflater.from(this.context).inflate(com.aliyun.svideo.common.R.layout.alivc_common_dialog_circle_progress, (android.view.ViewGroup) null, false);
        android.widget.ImageView imageView = (android.widget.ImageView) inflate.findViewById(com.aliyun.svideo.common.R.id.iv_dialog_progress);
        this.mImageView = imageView;
        imageView.setImageResource(com.aliyun.svideo.common.R.mipmap.alivc_common_icon_circle_progress);
        setAnimation();
        setContentView(inflate);
        android.view.Window window = getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        android.util.DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        attributes.width = displayMetrics.widthPixels;
        int i = this.mHeight;
        if (i == 0) {
            attributes.height = displayMetrics.heightPixels;
        } else {
            attributes.height = i;
        }
        attributes.gravity = 49;
        window.setAttributes(attributes);
        setCancelable(false);
    }

    private void setAnimation() {
        android.view.animation.RotateAnimation rotateAnimation = new android.view.animation.RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(800L);
        rotateAnimation.setInterpolator(new android.view.animation.LinearInterpolator());
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
        if (this.mImageView.getAnimation() == null) {
            this.mImageView.startAnimation(rotateAnimation);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        android.widget.ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.mImageView != null) {
            setAnimation();
        }
    }
}
