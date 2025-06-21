package com.aliyun.svideo.common.widget;

/* loaded from: classes.dex */
public class TipDialog extends android.app.Dialog {

    public static class Builder {
        public static final int TYPE_DEFAILD = 0;
        public static final int TYPE_FAIL = 4;
        public static final int TYPE_IMG_ONLY = 5;
        public static final int TYPE_LOADING = 2;
        public static final int TYPE_MESSAGE_ONLY = 1;
        public static final int TYPE_SUCCESS = 3;
        private int iconId;
        private android.content.Context mContext;
        private java.lang.String message = "";
        private int type = 0;

        public Builder(android.content.Context context) {
            this.mContext = context;
        }

        private void addImageView(android.view.ViewGroup viewGroup, int i) {
            android.widget.ImageView imageView = new android.widget.ImageView(this.mContext);
            imageView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
            imageView.setImageDrawable(androidx.core.content.ContextCompat.getDrawable(this.mContext, i));
            viewGroup.addView(imageView);
        }

        private void addLoadingView(android.view.ViewGroup viewGroup) {
            com.aliyun.svideo.common.widget.QMUILoadingView qMUILoadingView = new com.aliyun.svideo.common.widget.QMUILoadingView(this.mContext);
            qMUILoadingView.setColor(-1);
            qMUILoadingView.setSize(com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 32.0f));
            qMUILoadingView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
            viewGroup.addView(qMUILoadingView);
        }

        private void addTextView(android.view.ViewGroup viewGroup) {
            addTextView(viewGroup, this.message);
        }

        private void addTextView(android.view.ViewGroup viewGroup, java.lang.String str) {
            android.widget.TextView textView = new android.widget.TextView(this.mContext);
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 12.0f);
            textView.setLayoutParams(layoutParams);
            textView.setEllipsize(android.text.TextUtils.TruncateAt.END);
            textView.setGravity(17);
            textView.setMaxLines(2);
            textView.setTextColor(androidx.core.content.ContextCompat.getColor(this.mContext, com.aliyun.svideo.common.R.color.alivc_common_white));
            textView.setTextSize(2, 14.0f);
            textView.setText(str);
            viewGroup.addView(textView);
        }

        public com.aliyun.svideo.common.widget.TipDialog create() {
            com.aliyun.svideo.common.widget.TipDialog tipDialog = new com.aliyun.svideo.common.widget.TipDialog(this.mContext);
            tipDialog.setCancelable(true);
            tipDialog.setContentView(com.aliyun.svideo.common.R.layout.alivc_common_dialog_tip);
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) tipDialog.findViewById(com.aliyun.svideo.common.R.id.contentWrap);
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) viewGroup.getLayoutParams();
            int i = this.type;
            if (i == 0) {
                layoutParams.width = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 300.0f);
                layoutParams.height = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 180.0f);
                viewGroup.setLayoutParams(layoutParams);
                int i2 = this.iconId;
                if (i2 != 0) {
                    addImageView(viewGroup, i2);
                }
                if (!android.text.TextUtils.isEmpty(this.message)) {
                    addTextView(viewGroup);
                }
            } else if (i == 1) {
                viewGroup.setBackgroundResource(com.aliyun.svideo.common.R.drawable.alivc_dialog_bg_translucent);
                layoutParams.width = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 150.0f);
                layoutParams.height = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 90.0f);
                viewGroup.setLayoutParams(layoutParams);
                addTextView(viewGroup);
            } else if (i == 2) {
                viewGroup.setBackgroundResource(com.aliyun.svideo.common.R.drawable.alivc_dialog_bg_translucent);
                layoutParams.width = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 150.0f);
                layoutParams.height = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 90.0f);
                viewGroup.setLayoutParams(layoutParams);
                addLoadingView(viewGroup);
                if (android.text.TextUtils.isEmpty(this.message)) {
                    addTextView(viewGroup, this.mContext.getResources().getString(com.aliyun.svideo.common.R.string.alivc_common_loading));
                } else {
                    addTextView(viewGroup);
                }
            } else if (i == 3) {
                layoutParams.width = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 300.0f);
                layoutParams.height = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 180.0f);
                viewGroup.setLayoutParams(layoutParams);
                addImageView(viewGroup, com.aliyun.svideo.common.R.mipmap.icon_delete_tips);
                if (android.text.TextUtils.isEmpty(this.message)) {
                    addTextView(viewGroup, this.mContext.getResources().getString(com.aliyun.svideo.common.R.string.alivc_common_operate_success));
                } else {
                    addTextView(viewGroup);
                }
            } else if (i == 4) {
                layoutParams.width = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 300.0f);
                layoutParams.height = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 180.0f);
                viewGroup.setLayoutParams(layoutParams);
                addImageView(viewGroup, com.aliyun.svideo.common.R.mipmap.icon_delete_tips);
                if (android.text.TextUtils.isEmpty(this.message)) {
                    addTextView(viewGroup, this.mContext.getResources().getString(com.aliyun.svideo.common.R.string.alivc_common_operate_success));
                } else {
                    addTextView(viewGroup);
                }
            } else if (i != 5) {
                layoutParams.width = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 300.0f);
                layoutParams.height = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 180.0f);
                viewGroup.setLayoutParams(layoutParams);
                int i3 = this.iconId;
                if (i3 != 0) {
                    addImageView(viewGroup, i3);
                }
                if (!android.text.TextUtils.isEmpty(this.message)) {
                    addTextView(viewGroup);
                }
            } else {
                viewGroup.setBackgroundResource(com.aliyun.svideo.common.R.drawable.alivc_dialog_bg_translucent);
                layoutParams.width = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 150.0f);
                layoutParams.height = com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 90.0f);
                viewGroup.setLayoutParams(layoutParams);
                addImageView(viewGroup, this.iconId);
            }
            return tipDialog;
        }

        public com.aliyun.svideo.common.widget.TipDialog.Builder setIconId(int i) {
            this.iconId = i;
            return this;
        }

        public com.aliyun.svideo.common.widget.TipDialog.Builder setMessage(java.lang.String str) {
            this.message = str;
            return this;
        }

        public com.aliyun.svideo.common.widget.TipDialog.Builder setType(int i) {
            this.type = i;
            return this;
        }
    }

    public TipDialog(android.content.Context context) {
        this(context, com.aliyun.svideo.common.R.style.TipDialog);
    }

    public TipDialog(android.content.Context context, int i) {
        super(context, i);
        setCanceledOnTouchOutside(false);
    }
}
