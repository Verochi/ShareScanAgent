package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class SelectedMediaViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener {
    private static java.lang.String sDurationFormat;
    private com.aliyun.svideo.media.SelectedMediaViewHolder.OnItemCallback mCallback;
    private android.widget.ImageView mIvDelete;
    private android.widget.ImageView mIvPhoto;
    private com.aliyun.svideo.media.MediaImageLoader mMediaImageLoader;
    private android.widget.TextView mTvDuration;
    private int position;

    public interface OnItemCallback {
        void onItemDelete(com.aliyun.svideo.media.SelectedMediaViewHolder selectedMediaViewHolder, int i);

        void onPhotoClick(com.aliyun.svideo.media.SelectedMediaViewHolder selectedMediaViewHolder, int i);
    }

    public SelectedMediaViewHolder(android.view.View view, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.widget.TextView textView, com.aliyun.svideo.media.MediaImageLoader mediaImageLoader) {
        super(view);
        this.mIvPhoto = imageView;
        this.mIvDelete = imageView2;
        this.mTvDuration = textView;
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        this.mMediaImageLoader = mediaImageLoader;
        if (sDurationFormat == null) {
            sDurationFormat = view.getResources().getString(com.aliyun.svideo.media.R.string.alivc_media_video_duration);
        }
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.aliyun.svideo.media.SelectedMediaViewHolder.OnItemCallback onItemCallback = this.mCallback;
        if (onItemCallback != null) {
            if (view == this.mIvPhoto) {
                onItemCallback.onPhotoClick(this, this.position);
            } else if (view == this.mIvDelete) {
                onItemCallback.onItemDelete(this, this.position);
            }
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setCallback(com.aliyun.svideo.media.SelectedMediaViewHolder.OnItemCallback onItemCallback) {
        this.mCallback = onItemCallback;
    }

    public void updateData(int i, com.aliyun.svideo.media.MediaInfo mediaInfo) {
        this.position = i;
        if (mediaInfo != null) {
            this.mMediaImageLoader.displayImage(mediaInfo, this.mIvPhoto);
            int round = java.lang.Math.round(mediaInfo.duration / 1000.0f);
            this.mTvDuration.setText(java.lang.String.format(sDurationFormat, java.lang.Integer.valueOf(round / com.anythink.expressad.d.a.b.ck), java.lang.Integer.valueOf((round % com.anythink.expressad.d.a.b.ck) / 60), java.lang.Integer.valueOf(round % 60)));
        }
    }

    public void updatePosition(int i) {
        this.position = i;
    }
}
