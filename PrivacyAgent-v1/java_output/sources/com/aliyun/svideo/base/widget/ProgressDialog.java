package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class ProgressDialog extends android.app.Dialog {
    public static final int STYLE_HORIZONTAL = 1;
    public static final int STYLE_SPINNER = 0;
    private boolean mHasStarted;
    private int mIncrementBy;
    private int mIncrementSecondaryBy;
    private boolean mIndeterminate;
    private android.graphics.drawable.Drawable mIndeterminateDrawable;
    private int mMax;
    private java.lang.CharSequence mMessage;
    private android.widget.TextView mMessageView;
    private android.widget.ProgressBar mProgress;
    private android.graphics.drawable.Drawable mProgressDrawable;
    private android.widget.TextView mProgressNumber;
    private java.lang.String mProgressNumberFormat;
    private android.widget.TextView mProgressPercent;
    private java.text.NumberFormat mProgressPercentFormat;
    private int mProgressStyle;
    private int mProgressVal;
    private int mSecondaryProgressVal;
    private android.os.Handler mViewUpdateHandler;

    /* renamed from: com.aliyun.svideo.base.widget.ProgressDialog$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            int progress = com.aliyun.svideo.base.widget.ProgressDialog.this.mProgress.getProgress();
            if (progress == 0) {
                progress = com.aliyun.svideo.base.widget.ProgressDialog.this.mProgressVal;
            }
            int max = com.aliyun.svideo.base.widget.ProgressDialog.this.mProgress.getMax();
            if (com.aliyun.svideo.base.widget.ProgressDialog.this.mProgressNumber != null) {
                if (com.aliyun.svideo.base.widget.ProgressDialog.this.mProgressNumberFormat != null) {
                    com.aliyun.svideo.base.widget.ProgressDialog.this.mProgressNumber.setText(java.lang.String.format(com.aliyun.svideo.base.widget.ProgressDialog.this.mProgressNumberFormat, java.lang.Integer.valueOf(progress), java.lang.Integer.valueOf(max)));
                } else {
                    com.aliyun.svideo.base.widget.ProgressDialog.this.mProgressNumber.setText("");
                }
            }
            if (com.aliyun.svideo.base.widget.ProgressDialog.this.mProgressPercent != null) {
                if (com.aliyun.svideo.base.widget.ProgressDialog.this.mProgressPercentFormat == null) {
                    com.aliyun.svideo.base.widget.ProgressDialog.this.mProgressPercent.setText("");
                    return;
                }
                android.text.SpannableString spannableString = new android.text.SpannableString(com.aliyun.svideo.base.widget.ProgressDialog.this.mProgressPercentFormat.format(progress / max));
                spannableString.setSpan(new android.text.style.StyleSpan(1), 0, spannableString.length(), 33);
                com.aliyun.svideo.base.widget.ProgressDialog.this.mProgressPercent.setText(spannableString);
            }
        }
    }

    public ProgressDialog(android.content.Context context) {
        super(context);
        this.mProgressStyle = 1;
        initFormats();
    }

    public ProgressDialog(android.content.Context context, int i) {
        super(context, i);
        this.mProgressStyle = 1;
        initFormats();
    }

    private void initFormats() {
        this.mProgressNumberFormat = "%1d/%2d";
        java.text.NumberFormat percentInstance = java.text.NumberFormat.getPercentInstance();
        this.mProgressPercentFormat = percentInstance;
        percentInstance.setMaximumFractionDigits(0);
    }

    private void onProgressChanged() {
        android.os.Handler handler = this.mViewUpdateHandler;
        if (handler == null || handler.hasMessages(0)) {
            return;
        }
        this.mViewUpdateHandler.sendEmptyMessage(0);
    }

    public static com.aliyun.svideo.base.widget.ProgressDialog show(android.content.Context context, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        return show(context, charSequence, charSequence2, false);
    }

    public static com.aliyun.svideo.base.widget.ProgressDialog show(android.content.Context context, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z) {
        return show(context, charSequence, charSequence2, z, false, null);
    }

    public static com.aliyun.svideo.base.widget.ProgressDialog show(android.content.Context context, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z, boolean z2) {
        return show(context, charSequence, charSequence2, z, z2, null);
    }

    public static com.aliyun.svideo.base.widget.ProgressDialog show(android.content.Context context, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z, boolean z2, android.content.DialogInterface.OnCancelListener onCancelListener) {
        com.aliyun.svideo.base.widget.ProgressDialog progressDialog = new com.aliyun.svideo.base.widget.ProgressDialog(context);
        progressDialog.requestWindowFeature(1);
        progressDialog.setTitle(charSequence);
        progressDialog.setMessage(charSequence2);
        progressDialog.setIndeterminate(z);
        progressDialog.setCancelable(z2);
        progressDialog.setOnCancelListener(onCancelListener);
        progressDialog.show();
        return progressDialog;
    }

    public int getMax() {
        android.widget.ProgressBar progressBar = this.mProgress;
        return progressBar != null ? progressBar.getMax() : this.mMax;
    }

    public int getProgress() {
        android.widget.ProgressBar progressBar = this.mProgress;
        return progressBar != null ? progressBar.getProgress() : this.mProgressVal;
    }

    public int getSecondaryProgress() {
        android.widget.ProgressBar progressBar = this.mProgress;
        return progressBar != null ? progressBar.getSecondaryProgress() : this.mSecondaryProgressVal;
    }

    public void incrementProgressBy(int i) {
        android.widget.ProgressBar progressBar = this.mProgress;
        if (progressBar == null) {
            this.mIncrementBy += i;
        } else {
            progressBar.incrementProgressBy(i);
            onProgressChanged();
        }
    }

    public void incrementSecondaryProgressBy(int i) {
        android.widget.ProgressBar progressBar = this.mProgress;
        if (progressBar == null) {
            this.mIncrementSecondaryBy += i;
        } else {
            progressBar.incrementSecondaryProgressBy(i);
            onProgressChanged();
        }
    }

    public boolean isIndeterminate() {
        android.widget.ProgressBar progressBar = this.mProgress;
        return progressBar != null ? progressBar.isIndeterminate() : this.mIndeterminate;
    }

    @Override // android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        android.content.Context context = getContext();
        android.view.LayoutInflater from = android.view.LayoutInflater.from(getContext());
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes((android.util.AttributeSet) null, com.aliyun.svideo.base.R.styleable.QuViewAlertDialog);
        this.mViewUpdateHandler = new com.aliyun.svideo.base.widget.ProgressDialog.AnonymousClass1();
        android.view.View inflate = this.mProgressStyle == 1 ? from.inflate(obtainStyledAttributes.getResourceId(com.aliyun.svideo.base.R.styleable.QuViewAlertDialog_horizontalProgressLayout, com.aliyun.svideo.base.R.layout.aliyun_video_alert_dialog_progress), (android.view.ViewGroup) null) : from.inflate(obtainStyledAttributes.getResourceId(com.aliyun.svideo.base.R.styleable.QuViewAlertDialog_progressLayout, com.aliyun.svideo.base.R.layout.aliyun_svideo_progress_dialog), (android.view.ViewGroup) null);
        this.mProgressNumber = (android.widget.TextView) inflate.findViewById(com.aliyun.svideo.base.R.id.aliyun_progress_number);
        this.mProgressPercent = (android.widget.TextView) inflate.findViewById(com.aliyun.svideo.base.R.id.aliyun_progress_percent);
        this.mMessageView = (android.widget.TextView) inflate.findViewById(android.R.id.message);
        this.mProgress = (android.widget.ProgressBar) inflate.findViewById(android.R.id.progress);
        setContentView(inflate);
        obtainStyledAttributes.recycle();
        int i = this.mMax;
        if (i > 0) {
            setMax(i);
        }
        int i2 = this.mProgressVal;
        if (i2 > 0) {
            setProgress(i2);
        }
        int i3 = this.mSecondaryProgressVal;
        if (i3 > 0) {
            setSecondaryProgress(i3);
        }
        int i4 = this.mIncrementBy;
        if (i4 > 0) {
            incrementProgressBy(i4);
        }
        int i5 = this.mIncrementSecondaryBy;
        if (i5 > 0) {
            incrementSecondaryProgressBy(i5);
        }
        android.graphics.drawable.Drawable drawable = this.mProgressDrawable;
        if (drawable != null) {
            setProgressDrawable(drawable);
        }
        android.graphics.drawable.Drawable drawable2 = this.mIndeterminateDrawable;
        if (drawable2 != null) {
            setIndeterminateDrawable(drawable2);
        }
        java.lang.CharSequence charSequence = this.mMessage;
        if (charSequence != null) {
            setMessage(charSequence);
        }
        setIndeterminate(this.mIndeterminate);
        onProgressChanged();
        super.onCreate(bundle);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.mHasStarted = true;
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        this.mHasStarted = false;
    }

    public void setIndeterminate(boolean z) {
        android.widget.ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            progressBar.setIndeterminate(z);
        } else {
            this.mIndeterminate = z;
        }
    }

    public void setIndeterminateDrawable(android.graphics.drawable.Drawable drawable) {
        android.widget.ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            progressBar.setIndeterminateDrawable(drawable);
        } else {
            this.mIndeterminateDrawable = drawable;
        }
    }

    public void setMax(int i) {
        android.widget.ProgressBar progressBar = this.mProgress;
        if (progressBar == null) {
            this.mMax = i;
        } else {
            progressBar.setMax(i);
            onProgressChanged();
        }
    }

    public void setMessage(java.lang.CharSequence charSequence) {
        android.widget.TextView textView;
        if (this.mProgress == null) {
            this.mMessage = charSequence;
        } else {
            if (this.mProgressStyle == 1 || (textView = this.mMessageView) == null) {
                return;
            }
            textView.setText(charSequence);
        }
    }

    public void setProgress(int i) {
        if (this.mHasStarted) {
            this.mProgress.setProgress(i);
            onProgressChanged();
        }
        this.mProgressVal = i;
    }

    public void setProgressDrawable(android.graphics.drawable.Drawable drawable) {
        android.widget.ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            progressBar.setProgressDrawable(drawable);
        } else {
            this.mProgressDrawable = drawable;
        }
    }

    public void setProgressNumberFormat(java.lang.String str) {
        this.mProgressNumberFormat = str;
        onProgressChanged();
    }

    public void setProgressPercentFormat(java.text.NumberFormat numberFormat) {
        this.mProgressPercentFormat = numberFormat;
        onProgressChanged();
    }

    public void setProgressStyle(int i) {
        this.mProgressStyle = i;
    }

    public void setSecondaryProgress(int i) {
        android.widget.ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            progressBar.setSecondaryProgress(i);
            onProgressChanged();
        }
        this.mSecondaryProgressVal = i;
    }
}
