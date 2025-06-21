package com.aliyun.svideo.common.widget;

/* loaded from: classes.dex */
public class CustomProgressDialog extends android.app.Dialog {
    private android.content.Context context;
    private int mCurrentProgress;
    private int mMaxProgress;
    private android.widget.TextView mMessage;
    private android.widget.TextView mProgress;
    private android.widget.ProgressBar mProgressBar;
    private java.lang.String mStringMessage;
    private java.lang.String mStringTitle;
    private android.widget.TextView mTitle;

    public CustomProgressDialog(android.content.Context context) {
        this(context, "", "");
    }

    public CustomProgressDialog(android.content.Context context, java.lang.String str, java.lang.String str2) {
        super(context, com.aliyun.svideo.common.R.style.CustomDialogStyle);
        this.context = context;
        this.mStringTitle = str;
        this.mStringMessage = str2;
    }

    private void init() {
        android.view.View inflate = android.view.LayoutInflater.from(this.context).inflate(com.aliyun.svideo.common.R.layout.alivc_common_dialog_progress, (android.view.ViewGroup) null, false);
        this.mTitle = (android.widget.TextView) inflate.findViewById(com.aliyun.svideo.common.R.id.tv_dialog_title);
        this.mMessage = (android.widget.TextView) inflate.findViewById(com.aliyun.svideo.common.R.id.tv_dialog_message);
        this.mProgressBar = (android.widget.ProgressBar) inflate.findViewById(com.aliyun.svideo.common.R.id.pb_dialog_progress);
        this.mProgress = (android.widget.TextView) inflate.findViewById(com.aliyun.svideo.common.R.id.tv_dialog_progress);
        java.lang.String str = this.mStringTitle;
        if (str != null) {
            this.mTitle.setText(str);
        }
        java.lang.String str2 = this.mStringMessage;
        if (str2 != null) {
            this.mMessage.setText(str2);
        }
        int i = this.mCurrentProgress;
        if (i != 0) {
            this.mProgressBar.setProgress(i);
        }
        int i2 = this.mMaxProgress;
        if (i2 != 0) {
            this.mProgressBar.setMax(i2);
        } else {
            this.mProgressBar.setMax(100);
        }
        setProgress(this.mCurrentProgress);
        setContentView(inflate);
        android.view.Window window = getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        android.util.DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        attributes.width = displayMetrics.widthPixels;
        attributes.height = displayMetrics.heightPixels;
        attributes.gravity = 49;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    public void setMaxProgress(int i) {
        this.mMaxProgress = i;
        android.widget.ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setMax(i);
        }
    }

    public void setMessage(java.lang.String str) {
        this.mStringMessage = str;
        android.widget.TextView textView = this.mMessage;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setProgress(int i) {
        this.mCurrentProgress = i;
        android.widget.ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setProgress(i);
            this.mProgress.setText(((this.mCurrentProgress * 100) / this.mMaxProgress) + "%");
        }
    }

    public void setTitle(java.lang.String str) {
        this.mStringTitle = str;
        android.widget.TextView textView = this.mTitle;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
