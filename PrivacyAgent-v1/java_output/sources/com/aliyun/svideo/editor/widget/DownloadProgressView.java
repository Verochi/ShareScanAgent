package com.aliyun.svideo.editor.widget;

/* loaded from: classes12.dex */
public class DownloadProgressView extends android.widget.FrameLayout {
    private static final int VIEW_TYPE_DOWNLOADING = 3;
    private static final int VIEW_TYPE_LOCAL = 1;
    private static final int VIEW_TYPE_REMOTE = 2;
    private android.widget.ImageView downloadFinish;
    private android.widget.ProgressBar downloadProgress;
    private com.aliyun.svideo.editor.widget.DownloadProgressView.OnDownloadBtnClickListener onDownloadBtnClickListener;
    private android.widget.TextView tvDownloadState;

    /* renamed from: com.aliyun.svideo.editor.widget.DownloadProgressView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.widget.DownloadProgressView.this.onDownloadBtnClickListener != null) {
                com.aliyun.svideo.editor.widget.DownloadProgressView.this.onDownloadBtnClickListener.onClick();
                com.aliyun.svideo.editor.widget.DownloadProgressView.this.downloadProgress.setProgress(0);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface OnDownloadBtnClickListener {
        void onClick();
    }

    public DownloadProgressView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public DownloadProgressView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
        android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_download_progress, (android.view.ViewGroup) this, true);
        this.downloadProgress = (android.widget.ProgressBar) inflate.findViewById(com.aliyun.svideo.editor.R.id.download_progress_bg);
        this.tvDownloadState = (android.widget.TextView) inflate.findViewById(com.aliyun.svideo.editor.R.id.tv_download_state);
        this.downloadFinish = (android.widget.ImageView) inflate.findViewById(com.aliyun.svideo.editor.R.id.iv_download_finish);
        setOnClickListener(new com.aliyun.svideo.editor.widget.DownloadProgressView.AnonymousClass1());
    }

    public void setDownloadState(int i) {
        if (i == 1) {
            this.tvDownloadState.setText("");
            this.downloadFinish.setVisibility(0);
            this.downloadFinish.setImageResource(com.aliyun.svideo.editor.R.mipmap.alivc_icon_download_finish);
        } else {
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.tvDownloadState.setText(getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_more_downloading));
                this.downloadFinish.setVisibility(4);
                return;
            }
            this.tvDownloadState.setText(getResources().getString(com.aliyun.svideo.editor.R.string.alivc_common_download));
            this.downloadProgress.setProgress(Integer.MAX_VALUE);
            this.downloadFinish.setVisibility(4);
            this.tvDownloadState.setBackgroundResource(com.aliyun.svideo.editor.R.drawable.alivc_svideo_shape_effect_download_normal);
        }
    }

    public void setOnDownloadBtnClickListener(com.aliyun.svideo.editor.widget.DownloadProgressView.OnDownloadBtnClickListener onDownloadBtnClickListener) {
        this.onDownloadBtnClickListener = onDownloadBtnClickListener;
    }

    public synchronized void updateProgress(int i) {
        this.downloadProgress.setProgress(i);
    }
}
