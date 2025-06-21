package com.aliyun.svideo.common.widget;

/* loaded from: classes.dex */
public class AlivcCustomAlertDialog extends android.app.Dialog {
    private android.widget.ImageView ivDialogIcon;
    private com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.OnDialogClickListener mDialogClickListener;
    private android.widget.TextView tvCancel;
    private android.widget.TextView tvConfirm;
    private android.widget.TextView tvDialogMessage;

    /* renamed from: com.aliyun.svideo.common.widget.AlivcCustomAlertDialog$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.this.dismiss();
            if (com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.this.mDialogClickListener != null) {
                com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.this.mDialogClickListener.onConfirm();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.common.widget.AlivcCustomAlertDialog$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.this.dismiss();
            if (com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.this.mDialogClickListener != null) {
                com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.this.mDialogClickListener.onCancel();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class Builder {
        private java.lang.String cancel;
        private java.lang.String confirm;
        private com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.OnDialogClickListener dialogClickListener;
        private android.content.Context mContext;
        private java.lang.String message;
        private int iconId = com.aliyun.svideo.common.R.mipmap.icon_delete_tips;
        private boolean noIcon = false;
        private com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.CustomDialogType customDialogType = com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.CustomDialogType.Alert;

        public Builder(android.content.Context context) {
            this.mContext = context;
            this.message = context.getResources().getString(com.aliyun.svideo.common.R.string.alivc_common_note);
            this.confirm = context.getResources().getString(com.aliyun.svideo.common.R.string.alivc_common_confirm);
            this.cancel = context.getResources().getString(com.aliyun.svideo.common.R.string.alivc_common_cancel);
        }

        public com.aliyun.svideo.common.widget.AlivcCustomAlertDialog create() {
            com.aliyun.svideo.common.widget.AlivcCustomAlertDialog alivcCustomAlertDialog = new com.aliyun.svideo.common.widget.AlivcCustomAlertDialog(this.mContext);
            alivcCustomAlertDialog.setContentView(com.aliyun.svideo.common.R.layout.alivc_common_dialog_alert_custom);
            alivcCustomAlertDialog.initView();
            alivcCustomAlertDialog.tvDialogMessage.setText(this.message);
            alivcCustomAlertDialog.tvCancel.setText(this.cancel);
            alivcCustomAlertDialog.tvConfirm.setText(this.confirm);
            alivcCustomAlertDialog.mDialogClickListener = this.dialogClickListener;
            alivcCustomAlertDialog.setDialogType(this.customDialogType);
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) alivcCustomAlertDialog.findViewById(com.aliyun.svideo.common.R.id.contentWrap);
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) viewGroup.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(com.aliyun.svideo.common.R.dimen.alivc_common_alert_dialog_w);
            if (this.noIcon) {
                alivcCustomAlertDialog.ivDialogIcon.setVisibility(8);
                layoutParams.height = this.mContext.getResources().getDimensionPixelSize(com.aliyun.svideo.common.R.dimen.alivc_common_alert_dialog_h_no_icon);
            } else {
                alivcCustomAlertDialog.ivDialogIcon.setVisibility(0);
                alivcCustomAlertDialog.ivDialogIcon.setImageResource(this.iconId);
                layoutParams.height = this.mContext.getResources().getDimensionPixelSize(com.aliyun.svideo.common.R.dimen.alivc_common_alert_dialog_h);
            }
            viewGroup.setLayoutParams(layoutParams);
            return alivcCustomAlertDialog;
        }

        public com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.Builder setCustomDialogType(com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.CustomDialogType customDialogType) {
            this.customDialogType = customDialogType;
            return this;
        }

        public com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.Builder setDialogClickListener(java.lang.String str, java.lang.String str2, com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.OnDialogClickListener onDialogClickListener) {
            if (!android.text.TextUtils.isEmpty(str)) {
                this.confirm = str;
            }
            if (!android.text.TextUtils.isEmpty(str2)) {
                this.cancel = str2;
            }
            this.dialogClickListener = onDialogClickListener;
            return this;
        }

        public com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.Builder setIconId(int i) {
            this.iconId = i;
            return this;
        }

        public com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.Builder setMessage(java.lang.String str) {
            this.message = str;
            return this;
        }

        public com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.Builder setNoIcon(boolean z) {
            this.noIcon = z;
            return this;
        }
    }

    public enum CustomDialogType {
        Alert,
        Confirm
    }

    public interface OnDialogClickListener {
        void onCancel();

        void onConfirm();
    }

    public AlivcCustomAlertDialog(@androidx.annotation.NonNull android.content.Context context) {
        this(context, com.aliyun.svideo.common.R.style.TipDialog);
    }

    public AlivcCustomAlertDialog(@androidx.annotation.NonNull android.content.Context context, int i) {
        super(context, i);
    }

    public AlivcCustomAlertDialog(@androidx.annotation.NonNull android.content.Context context, boolean z, @androidx.annotation.Nullable android.content.DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        this.ivDialogIcon = (android.widget.ImageView) findViewById(com.aliyun.svideo.common.R.id.iv_dialog_icon);
        this.tvDialogMessage = (android.widget.TextView) findViewById(com.aliyun.svideo.common.R.id.tv_dialog_message);
        this.tvCancel = (android.widget.TextView) findViewById(com.aliyun.svideo.common.R.id.tv_cancel);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.aliyun.svideo.common.R.id.tv_confirm);
        this.tvConfirm = textView;
        textView.setOnClickListener(new com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.AnonymousClass1());
        this.tvCancel.setOnClickListener(new com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialogType(com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.CustomDialogType customDialogType) {
        if (customDialogType == com.aliyun.svideo.common.widget.AlivcCustomAlertDialog.CustomDialogType.Confirm) {
            this.tvCancel.setVisibility(8);
        } else {
            this.tvCancel.setVisibility(0);
        }
    }
}
