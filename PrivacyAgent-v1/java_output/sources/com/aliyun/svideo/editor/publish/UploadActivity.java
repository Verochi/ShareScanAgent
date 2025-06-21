package com.aliyun.svideo.editor.publish;

/* loaded from: classes29.dex */
public class UploadActivity extends android.app.Activity {
    private static final java.lang.String ACTIVITIY_ACTION_MAIN = "com.aliyun.alivcsolution.MainActivity";
    public static final java.lang.String KEY_PARAM_VIDEO_RATIO = "key_param_video_ratio";
    public static final java.lang.String KEY_UPLOAD_DESC = "video_desc";
    public static final java.lang.String KEY_UPLOAD_THUMBNAIL = "video_thumbnail";
    public static final java.lang.String KEY_UPLOAD_VIDEO = "video_path";
    private static final java.lang.String TAG = "UploadActivity";
    private long imageSize;
    private com.aliyun.svideosdk.editor.impl.AliyunVodCompose mComposeClient;
    private java.lang.String mDesc;
    private java.lang.String mImageUrl;
    private boolean mIsUpload;
    private android.widget.ImageView mIvLeft;
    private android.media.MediaPlayer mMediaPlayer;
    private android.view.Surface mPlayerSurface;
    private android.widget.ProgressBar mProgress;
    private android.widget.TextView mProgressText;
    private float mRatio;
    private android.view.TextureView mTextureView;
    private java.lang.String mThumbnailPath;
    private android.widget.TextView mTitle;
    private android.widget.TextView mVideoDesc;
    private java.lang.String mVideoPath;
    private com.aliyun.svideo.common.utils.NetWatchdogUtils mWatchdog;
    private java.lang.String videoId;
    private long videoSize;
    private boolean isBackground = true;
    private final com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunIVodUploadCallBack mUploadCallback = new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass5();
    private final android.view.TextureView.SurfaceTextureListener mlistener = new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass7();
    private final android.media.MediaPlayer.OnPreparedListener mOnPreparedListener = new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass10();

    /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.common.utils.NetWatchdogUtils.NetChangeListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.common.utils.NetWatchdogUtils.NetChangeListener
        public void on4GToWifi() {
            java.lang.String unused = com.aliyun.svideo.editor.publish.UploadActivity.TAG;
        }

        @Override // com.aliyun.svideo.common.utils.NetWatchdogUtils.NetChangeListener
        public void onNetUnConnected() {
            java.lang.String unused = com.aliyun.svideo.editor.publish.UploadActivity.TAG;
        }

        @Override // com.aliyun.svideo.common.utils.NetWatchdogUtils.NetChangeListener
        public void onReNetConnected(boolean z) {
            com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState state = com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient.getState();
            java.lang.String unused = com.aliyun.svideo.editor.publish.UploadActivity.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onReNetConnected state : ");
            sb.append(state);
            if (com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient != null) {
                if (state == com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState.STATE_IDLE || state == null) {
                    com.aliyun.svideo.editor.publish.UploadActivity.this.startImageUpload();
                }
            }
        }

        @Override // com.aliyun.svideo.common.utils.NetWatchdogUtils.NetChangeListener
        public void onWifiTo4G() {
            java.lang.String unused = com.aliyun.svideo.editor.publish.UploadActivity.TAG;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$10, reason: invalid class name */
    public class AnonymousClass10 implements android.media.MediaPlayer.OnPreparedListener {
        public AnonymousClass10() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(android.media.MediaPlayer mediaPlayer) {
            mediaPlayer.start();
            int videoWidth = mediaPlayer.getVideoWidth();
            int videoHeight = mediaPlayer.getVideoHeight();
            if (com.aliyun.svideo.editor.publish.UploadActivity.this.mRatio == 0.0f) {
                com.aliyun.svideo.editor.publish.UploadActivity.this.setTextureViewParams(videoWidth / videoHeight);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.publish.UploadActivity.this.onBackPressed();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$3, reason: invalid class name */
    public class AnonymousClass3 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {

        /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.publish.UploadActivity uploadActivity = com.aliyun.svideo.editor.publish.UploadActivity.this;
                com.aliyun.common.utils.ToastUtil.showToast(uploadActivity, uploadActivity.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_publish_upload_param_error));
            }
        }

        /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$3$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.editor.publish.UploadActivity.this, "Get image upload auth info failed");
            }
        }

        /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$3$3, reason: invalid class name and collision with other inner class name */
        public class RunnableC00713 implements java.lang.Runnable {
            public RunnableC00713() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.editor.publish.UploadActivity.this, "Get image upload auth info failed");
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Get image upload auth info failed, errorCode:");
            sb.append(i);
            sb.append(", msg:");
            sb.append(str);
            com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass3.RunnableC00713());
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass3) str);
            java.lang.String unused = com.aliyun.svideo.editor.publish.UploadActivity.TAG;
            com.aliyun.svideo.editor.publish.VodImageUploadAuth imageTokenInfo = com.aliyun.svideo.editor.publish.VodImageUploadAuth.getImageTokenInfo(str);
            if (imageTokenInfo == null || com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient == null) {
                com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass3.AnonymousClass2());
                return;
            }
            if (com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient.uploadImageWithVod(com.aliyun.svideo.editor.publish.UploadActivity.this.mThumbnailPath, imageTokenInfo.getUploadAddress(), imageTokenInfo.getUploadAuth(), com.aliyun.svideo.editor.publish.UploadActivity.this.mUploadCallback) < 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("上传参数错误 video path : ");
                sb.append(com.aliyun.svideo.editor.publish.UploadActivity.this.mVideoPath);
                sb.append(" thumbnailk : ");
                sb.append(com.aliyun.svideo.editor.publish.UploadActivity.this.mThumbnailPath);
                com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass3.AnonymousClass1());
                return;
            }
            com.aliyun.svideo.editor.publish.UploadActivity.this.mIsUpload = true;
            com.aliyun.svideo.editor.publish.ImageUploadCallbackBean imageUploadCallbackBean = (com.aliyun.svideo.editor.publish.ImageUploadCallbackBean) new com.google.gson.Gson().fromJson(str, com.aliyun.svideo.editor.publish.ImageUploadCallbackBean.class);
            if (imageUploadCallbackBean == null || !com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(imageUploadCallbackBean.getCode())) {
                return;
            }
            com.aliyun.svideo.editor.publish.UploadActivity.this.mImageUrl = imageUploadCallbackBean.getData().getImageURL();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$4, reason: invalid class name */
    public class AnonymousClass4 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {

        /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.publish.UploadActivity uploadActivity = com.aliyun.svideo.editor.publish.UploadActivity.this;
                com.aliyun.common.utils.ToastUtil.showToast(uploadActivity, uploadActivity.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_publish_upload_param_error));
            }
        }

        /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$4$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.editor.publish.UploadActivity.this, "Get video upload auth failed");
            }
        }

        /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$4$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.editor.publish.UploadActivity.this, "Get video upload auth failed");
            }
        }

        public AnonymousClass4() {
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Get video upload auth failed, errorCode:");
            sb.append(i);
            sb.append(", msg:");
            sb.append(str);
            com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass4.AnonymousClass3());
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass4) str);
            com.aliyun.svideo.editor.publish.VodVideoUploadAuth videoTokenInfo = com.aliyun.svideo.editor.publish.VodVideoUploadAuth.getVideoTokenInfo(str);
            if (videoTokenInfo == null || com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient == null) {
                com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass4.AnonymousClass2());
                return;
            }
            com.aliyun.svideo.editor.publish.UploadActivity.this.videoId = videoTokenInfo.getVideoId().toString();
            if (com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient.uploadVideoWithVod(com.aliyun.svideo.editor.publish.UploadActivity.this.mVideoPath, videoTokenInfo.getUploadAddress(), videoTokenInfo.getUploadAuth(), com.aliyun.svideo.editor.publish.UploadActivity.this.mUploadCallback) >= 0) {
                com.aliyun.svideo.editor.publish.UploadActivity.this.mIsUpload = true;
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("上传参数错误 video path : ");
            sb.append(com.aliyun.svideo.editor.publish.UploadActivity.this.mVideoPath);
            sb.append(" thumbnailk : ");
            sb.append(com.aliyun.svideo.editor.publish.UploadActivity.this.mThumbnailPath);
            com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass4.AnonymousClass1());
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunIVodUploadCallBack {

        /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$5$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {

            /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$5$1$1, reason: invalid class name and collision with other inner class name */
            public class RunnableC00721 implements java.lang.Runnable {
                public RunnableC00721() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.aliyun.svideo.editor.publish.UploadActivity.this.mProgressText.setVisibility(8);
                }
            }

            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient != null && com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient.getState() == com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState.STATE_IMAGE_UPLOADING) {
                    com.aliyun.svideo.editor.publish.UploadActivity.this.startVideoUpload();
                    return;
                }
                com.aliyun.svideo.editor.publish.UploadActivity.this.mProgress.setVisibility(8);
                com.aliyun.svideo.editor.publish.UploadActivity.this.mProgressText.setCompoundDrawablesWithIntrinsicBounds(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_composite_success, 0, 0, 0);
                com.aliyun.svideo.editor.publish.UploadActivity.this.mProgressText.setText(com.aliyun.svideo.editor.R.string.alivc_editor_publish_upload_success);
                com.aliyun.svideo.editor.publish.UploadActivity.this.mProgressText.postDelayed(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass5.AnonymousClass1.RunnableC00721(), 2000L);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$5$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {

            /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$5$2$1, reason: invalid class name */
            public class AnonymousClass1 implements java.lang.Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.aliyun.svideo.editor.publish.UploadActivity.this.mProgressText.setVisibility(8);
                }
            }

            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.publish.UploadActivity.this.mProgress.setProgress(0);
                com.aliyun.svideo.editor.publish.UploadActivity.this.mProgressText.setText(com.aliyun.svideo.editor.R.string.alivc_editor_publish_upload_failed);
                com.aliyun.svideo.editor.publish.UploadActivity.this.mProgressText.postDelayed(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass5.AnonymousClass2.AnonymousClass1(), 2000L);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$5$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ long val$totalSize;
            final /* synthetic */ long val$uploadedSize;

            public AnonymousClass3(long j, long j2) {
                this.val$uploadedSize = j;
                this.val$totalSize = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                long j;
                if (com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient == null) {
                    return;
                }
                if (com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient.getState() == com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState.STATE_IMAGE_UPLOADING) {
                    j = (this.val$uploadedSize * 100) / (this.val$totalSize + com.aliyun.svideo.editor.publish.UploadActivity.this.videoSize);
                } else {
                    if (com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient.getState() != com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState.STATE_VIDEO_UPLOADING) {
                        i = 0;
                        com.aliyun.svideo.editor.publish.UploadActivity.this.mProgress.setProgress(i);
                        com.aliyun.svideo.editor.publish.UploadActivity.this.mProgressText.setText(java.lang.String.format(com.aliyun.svideo.editor.publish.UploadActivity.this.getString(com.aliyun.svideo.editor.R.string.alivc_editor_publish_uploading), java.lang.Integer.valueOf(i)));
                    }
                    j = ((this.val$uploadedSize + com.aliyun.svideo.editor.publish.UploadActivity.this.imageSize) * 100) / (this.val$totalSize + com.aliyun.svideo.editor.publish.UploadActivity.this.imageSize);
                }
                i = (int) j;
                com.aliyun.svideo.editor.publish.UploadActivity.this.mProgress.setProgress(i);
                com.aliyun.svideo.editor.publish.UploadActivity.this.mProgressText.setText(java.lang.String.format(com.aliyun.svideo.editor.publish.UploadActivity.this.getString(com.aliyun.svideo.editor.R.string.alivc_editor_publish_uploading), java.lang.Integer.valueOf(i)));
            }
        }

        public AnonymousClass5() {
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack
        public void onUploadFailed(java.lang.String str, java.lang.String str2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onUploadFailed, errorCode:");
            sb.append(str);
            sb.append(", msg:");
            sb.append(str2);
            com.aliyun.svideo.editor.publish.UploadActivity.this.runOnUiThread(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass5.AnonymousClass2());
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack
        public void onUploadProgress(long j, long j2) {
            com.aliyun.svideo.editor.publish.UploadActivity.this.runOnUiThread(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass5.AnonymousClass3(j, j2));
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack
        public void onUploadRetry(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack
        public void onUploadRetryResume() {
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack
        public void onUploadSucceed() {
            com.aliyun.svideo.editor.publish.UploadActivity.this.runOnUiThread(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass5.AnonymousClass1());
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack
        public void onUploadTokenExpired() {
            if (com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient == null) {
                return;
            }
            if (com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient.getState() == com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState.STATE_IMAGE_UPLOADING) {
                com.aliyun.svideo.editor.publish.UploadActivity.this.startImageUpload();
            } else if (com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient.getState() == com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState.STATE_VIDEO_UPLOADING) {
                com.aliyun.svideo.editor.publish.UploadActivity uploadActivity = com.aliyun.svideo.editor.publish.UploadActivity.this;
                uploadActivity.refreshVideoUpload(uploadActivity.videoId);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$6, reason: invalid class name */
    public class AnonymousClass6 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {

        /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$6$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.publish.UploadActivity uploadActivity = com.aliyun.svideo.editor.publish.UploadActivity.this;
                com.aliyun.common.utils.ToastUtil.showToast(uploadActivity, uploadActivity.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_publish_upload_param_error));
            }
        }

        /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$6$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.editor.publish.UploadActivity.this, "Get video upload auth failed");
            }
        }

        public AnonymousClass6() {
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass6) str);
            com.aliyun.svideo.editor.publish.RefreshVodVideoUploadAuth reVideoTokenInfo = com.aliyun.svideo.editor.publish.RefreshVodVideoUploadAuth.getReVideoTokenInfo(str);
            if (reVideoTokenInfo == null || com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient == null) {
                com.aliyun.svideo.editor.publish.UploadActivity.this.runOnUiThread(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass6.AnonymousClass2());
                return;
            }
            if (com.aliyun.svideo.editor.publish.UploadActivity.this.mComposeClient.refreshWithUploadAuth(reVideoTokenInfo.getUploadAuth()) >= 0) {
                com.aliyun.svideo.editor.publish.UploadActivity.this.mIsUpload = true;
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("上传参数错误 video path : ");
            sb.append(com.aliyun.svideo.editor.publish.UploadActivity.this.mVideoPath);
            sb.append(" thumbnailk : ");
            sb.append(com.aliyun.svideo.editor.publish.UploadActivity.this.mThumbnailPath);
            com.aliyun.svideo.editor.publish.UploadActivity.this.runOnUiThread(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass6.AnonymousClass1());
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.TextureView.SurfaceTextureListener {
        public AnonymousClass7() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            com.aliyun.svideo.editor.publish.UploadActivity.this.initVideoPlayer();
            com.aliyun.svideo.editor.publish.UploadActivity.this.mPlayerSurface = new android.view.Surface(surfaceTexture);
            try {
                com.aliyun.svideo.editor.publish.UploadActivity.this.mMediaPlayer.setDataSource(com.aliyun.svideo.editor.publish.UploadActivity.this.mVideoPath);
                com.aliyun.svideo.editor.publish.UploadActivity.this.mMediaPlayer.setSurface(com.aliyun.svideo.editor.publish.UploadActivity.this.mPlayerSurface);
                com.aliyun.svideo.editor.publish.UploadActivity.this.mMediaPlayer.prepareAsync();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
            com.aliyun.svideo.editor.publish.UploadActivity.this.mMediaPlayer.stop();
            com.aliyun.svideo.editor.publish.UploadActivity.this.mMediaPlayer.release();
            com.aliyun.svideo.editor.publish.UploadActivity.this.mMediaPlayer = null;
            if (com.aliyun.svideo.editor.publish.UploadActivity.this.mPlayerSurface == null) {
                return false;
            }
            com.aliyun.svideo.editor.publish.UploadActivity.this.mPlayerSurface.release();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$8, reason: invalid class name */
    public class AnonymousClass8 implements android.media.MediaPlayer.OnPreparedListener {
        public AnonymousClass8() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(android.media.MediaPlayer mediaPlayer) {
            if (com.aliyun.svideo.editor.publish.UploadActivity.this.isBackground) {
                return;
            }
            com.aliyun.svideo.editor.publish.UploadActivity.this.mMediaPlayer.start();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.UploadActivity$9, reason: invalid class name */
    public class AnonymousClass9 implements android.media.MediaPlayer.OnCompletionListener {
        public AnonymousClass9() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(android.media.MediaPlayer mediaPlayer) {
            com.aliyun.svideo.editor.publish.UploadActivity.this.mMediaPlayer.reset();
            try {
                com.aliyun.svideo.editor.publish.UploadActivity.this.mMediaPlayer.setDataSource(com.aliyun.svideo.editor.publish.UploadActivity.this.mVideoPath);
                com.aliyun.svideo.editor.publish.UploadActivity.this.mMediaPlayer.prepare();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initNetWatchdog() {
        com.aliyun.svideo.common.utils.NetWatchdogUtils netWatchdogUtils = new com.aliyun.svideo.common.utils.NetWatchdogUtils(this);
        this.mWatchdog = netWatchdogUtils;
        netWatchdogUtils.startWatch();
        this.mWatchdog.setNetChangeListener(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initVideoPlayer() {
        if (this.mMediaPlayer != null) {
            return;
        }
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        this.mMediaPlayer = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
        this.mMediaPlayer.setScreenOnWhilePlaying(true);
        this.mMediaPlayer.setOnPreparedListener(this.mOnPreparedListener);
        this.mMediaPlayer.setLooping(false);
        this.mMediaPlayer.setOnPreparedListener(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass8());
        this.mMediaPlayer.setOnCompletionListener(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass9());
    }

    private void initView() {
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_center);
        this.mTitle = textView;
        textView.setVisibility(0);
        this.mTitle.setText(com.aliyun.svideo.editor.R.string.alivc_editor_publish_my_video);
        this.mVideoDesc = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.video_desc);
        this.mTextureView = (android.view.TextureView) findViewById(com.aliyun.svideo.editor.R.id.texture);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_left);
        this.mIvLeft = imageView;
        imageView.setVisibility(0);
        this.mIvLeft.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_crop_icon_cancel);
        this.mProgress = (android.widget.ProgressBar) findViewById(com.aliyun.svideo.editor.R.id.upload_progress);
        this.mIvLeft.setOnClickListener(new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass2());
        this.mProgressText = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.progress_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshVideoUpload(java.lang.String str) {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart("videoId", str);
        com.aliyun.common.qupaiokhttp.HttpRequest.get("https://alivc-demo.aliyuncs.com/demo/refreshVideoUploadAuth?", requestParams, new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass6());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextureViewParams(float f) {
        int i = getResources().getDisplayMetrics().widthPixels;
        this.mTextureView.getLayoutParams().width = i;
        this.mTextureView.getLayoutParams().height = (int) (i / f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startImageUpload() {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart("imageType", "default");
        com.aliyun.common.qupaiokhttp.HttpRequest.get("https://alivc-demo.aliyuncs.com/demo/getImageUploadAuth", requestParams, new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideoUpload() {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart("title", android.text.TextUtils.isEmpty(this.mVideoDesc.getText().toString().trim()) ? "test video" : this.mVideoDesc.getText().toString().trim());
        requestParams.addFormDataPart(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FILE_NAME, this.mVideoPath.toString());
        java.lang.String str = this.mImageUrl;
        if (str == null) {
            str = "";
        }
        requestParams.addFormDataPart("coverURL", str);
        com.aliyun.common.qupaiokhttp.HttpRequest.get("https://alivc-demo.aliyuncs.com/demo/getVideoUploadAuth?", requestParams, new com.aliyun.svideo.editor.publish.UploadActivity.AnonymousClass4());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.aliyun.svideo.base.Constants.SDCardConstants.clearCacheDir(getApplicationContext());
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(this, ACTIVITIY_ACTION_MAIN);
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_upload);
        getWindow().addFlags(128);
        this.isBackground = false;
        initView();
        this.mVideoPath = getIntent().getStringExtra("video_path");
        this.mThumbnailPath = getIntent().getStringExtra(KEY_UPLOAD_THUMBNAIL);
        this.mRatio = getIntent().getFloatExtra("key_param_video_ratio", 0.0f);
        java.lang.String stringExtra = getIntent().getStringExtra(KEY_UPLOAD_DESC);
        this.mDesc = stringExtra;
        this.mVideoDesc.setText(stringExtra);
        this.mTextureView.setSurfaceTextureListener(this.mlistener);
        float f = this.mRatio;
        if (f != 0.0f) {
            setTextureViewParams(f);
        }
        com.aliyun.svideosdk.editor.impl.AliyunVodCompose aliyunVodCompose = com.aliyun.svideo.editor.publish.ComposeFactory.INSTANCE.getAliyunVodCompose();
        this.mComposeClient = aliyunVodCompose;
        aliyunVodCompose.init(this);
        this.videoSize = new java.io.File(this.mVideoPath).length();
        this.imageSize = new java.io.File(this.mThumbnailPath).length();
        initNetWatchdog();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.aliyun.svideosdk.editor.impl.AliyunVodCompose aliyunVodCompose = this.mComposeClient;
        if (aliyunVodCompose != null) {
            aliyunVodCompose.release();
            this.mComposeClient = null;
        }
        com.aliyun.svideo.common.utils.NetWatchdogUtils netWatchdogUtils = this.mWatchdog;
        if (netWatchdogUtils != null) {
            netWatchdogUtils.stopWatch();
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.isBackground = true;
        android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.isBackground = false;
        android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mIsUpload) {
            this.mComposeClient.resumeUpload();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mIsUpload) {
            this.mComposeClient.pauseUpload();
        }
    }
}
