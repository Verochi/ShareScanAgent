package com.aliyun.svideo.editor.publish;

/* loaded from: classes29.dex */
public class PublishActivity extends android.app.Activity implements android.view.View.OnClickListener {
    public static final java.lang.String KEY_PARAM_CONFIG = "project_json_path";
    public static final java.lang.String KEY_PARAM_THUMBNAIL = "svideo_thumbnail";
    public static final java.lang.String KEY_PARAM_VIDEO_HEIGHT = "key_param_video_height";
    public static final java.lang.String KEY_PARAM_VIDEO_RATIO = "key_param_video_ratio";
    public static final java.lang.String KEY_PARAM_VIDEO_WIDTH = "key_param_video_width";
    public static final java.lang.String KEY_RESULT_COVER = "result_cover";
    public static final int REQUEST_CODE = 2021;
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.publish.PublishActivity";
    private com.aliyun.svideosdk.common.AliyunIThumbnailFetcher aliyunIThumbnailFetcher;
    private java.lang.String config;
    private android.view.View mActionBar;
    private android.os.AsyncTask<java.lang.String, java.lang.Void, android.graphics.Bitmap> mAsyncTaskOnCreate;
    private android.os.AsyncTask<java.lang.String, java.lang.Void, android.graphics.Bitmap> mAsyncTaskResult;
    private com.aliyun.svideosdk.editor.AliyunIVodCompose mCompose;
    private boolean mComposeCompleted;
    private android.view.View mComposeIndiate;
    private android.widget.TextView mComposeProgress;
    private android.view.View mComposeProgressView;
    private android.widget.TextView mComposeStatusText;
    private android.widget.TextView mComposeStatusTip;
    private android.widget.ImageView mCoverBlur;
    private android.widget.ImageView mCoverImage;
    private android.view.View mCoverSelect;
    private boolean mIsUpdateCover;
    private android.widget.ImageView mIvLeft;
    private android.widget.ProgressBar mProgress;
    private android.widget.TextView mPublish;
    private android.widget.TextView mTemplateBuild;
    private java.lang.String mThumbnailPath;
    private android.widget.EditText mVideoDesc;
    private int videoHeight;
    private int videoWidth;
    private java.lang.String mOutputPath = "";
    private final com.aliyun.svideosdk.editor.AliyunIComposeCallBack mCallback = new com.aliyun.svideo.editor.publish.PublishActivity.AnonymousClass4();
    private final com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion mThumbnailCallback = new com.aliyun.svideo.editor.publish.PublishActivity.AnonymousClass5();
    private java.lang.Runnable composeProgressRunnable = new com.aliyun.svideo.editor.publish.PublishActivity.AnonymousClass6();

    /* renamed from: com.aliyun.svideo.editor.publish.PublishActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) com.aliyun.svideo.editor.publish.PublishActivity.this.getApplication().getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(com.aliyun.svideo.editor.publish.PublishActivity.this.mVideoDesc.getWindowToken(), 0);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.PublishActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.text.TextWatcher {
        private int end;
        private int start;

        public AnonymousClass2() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(android.text.Editable editable) {
            this.start = com.aliyun.svideo.editor.publish.PublishActivity.this.mVideoDesc.getSelectionStart();
            this.end = com.aliyun.svideo.editor.publish.PublishActivity.this.mVideoDesc.getSelectionEnd();
            if (com.aliyun.svideo.editor.publish.PublishActivity.this.count(editable.toString()) <= 20 || this.start <= 0) {
                return;
            }
            editable.delete(this.start - 1, this.end);
            com.aliyun.svideo.editor.publish.PublishActivity.this.mVideoDesc.setText(editable);
            com.aliyun.svideo.editor.publish.PublishActivity.this.mVideoDesc.setSelection(editable.length());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.PublishActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements android.content.DialogInterface.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            if (com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeCompleted) {
                com.aliyun.svideo.editor.publish.PublishActivity.this.finish();
            } else {
                if (com.aliyun.svideo.editor.publish.PublishActivity.this.mCompose != null) {
                    com.aliyun.svideo.editor.publish.PublishActivity.this.mCompose.cancelCompose();
                }
                com.aliyun.svideo.editor.publish.PublishActivity.this.finish();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.PublishActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements com.aliyun.svideosdk.editor.AliyunIComposeCallBack {

        /* renamed from: com.aliyun.svideo.editor.publish.PublishActivity$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeProgress.setVisibility(8);
                com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeIndiate.setVisibility(0);
                com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeIndiate.setActivated(false);
                com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeStatusTip.setText(com.aliyun.svideo.editor.R.string.alivc_editor_publish_tip_retry);
                com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeStatusText.setText(com.aliyun.svideo.editor.R.string.alivc_editor_publish_compose_failed);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.publish.PublishActivity$4$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ int val$progress;

            public AnonymousClass2(int i) {
                this.val$progress = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeProgress.setText(this.val$progress + "%");
                com.aliyun.svideo.editor.publish.PublishActivity.this.mProgress.setProgress(this.val$progress);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.publish.PublishActivity$4$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.publish.PublishActivity publishActivity = com.aliyun.svideo.editor.publish.PublishActivity.this;
                com.aliyun.svideo.common.utils.UriUtils.saveVideoToMediaStore(publishActivity, publishActivity.mOutputPath);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.publish.PublishActivity$4$4, reason: invalid class name and collision with other inner class name */
        public class RunnableC00704 implements java.lang.Runnable {
            public RunnableC00704() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.svideo.editor.publish.PublishActivity.this.mCompose != null) {
                    com.aliyun.svideo.editor.publish.PublishActivity.this.mCompose.release();
                    com.aliyun.svideo.editor.publish.PublishActivity.this.mCompose = null;
                }
                try {
                    com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = (com.aliyun.svideosdk.common.struct.project.AliyunEditorProject) new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl().readValue(new java.io.File(com.aliyun.svideo.editor.publish.PublishActivity.this.config), com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.class);
                    if (aliyunEditorProject.getTemplate() == null || com.aliyun.common.utils.StringUtils.isEmpty(aliyunEditorProject.getTemplate().getPath())) {
                        com.aliyun.svideo.editor.publish.PublishActivity.this.mTemplateBuild.setVisibility(0);
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public AnonymousClass4() {
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIComposeCallBack
        public void onComposeCompleted() {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.publish.PublishActivity.AnonymousClass4.AnonymousClass3());
            } else {
                android.media.MediaScannerConnection.scanFile(com.aliyun.svideo.editor.publish.PublishActivity.this.getApplicationContext(), new java.lang.String[]{com.aliyun.svideo.editor.publish.PublishActivity.this.mOutputPath}, new java.lang.String[]{"video/mp4"}, null);
            }
            com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeCompleted = true;
            com.aliyun.svideo.editor.publish.PublishActivity.this.aliyunIThumbnailFetcher.addVideoSource(com.aliyun.svideo.editor.publish.PublishActivity.this.mOutputPath, 0L, 2147483647L, 0L);
            com.aliyun.svideo.editor.publish.PublishActivity.this.aliyunIThumbnailFetcher.setParameters(com.aliyun.svideo.editor.publish.PublishActivity.this.videoWidth, com.aliyun.svideo.editor.publish.PublishActivity.this.videoHeight, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.CropMode.Mediate, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE, 8);
            com.aliyun.svideo.editor.publish.PublishActivity.this.requestThumbnailImage(0);
            com.aliyun.svideo.editor.publish.PublishActivity.this.runOnUiThread(new com.aliyun.svideo.editor.publish.PublishActivity.AnonymousClass4.RunnableC00704());
            com.aliyun.svideo.base.utils.VideoInfoUtils.printVideoInfo(com.aliyun.svideo.editor.publish.PublishActivity.this.mOutputPath);
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIComposeCallBack
        public void onComposeError(int i) {
            com.aliyun.svideo.editor.publish.PublishActivity.this.runOnUiThread(new com.aliyun.svideo.editor.publish.PublishActivity.AnonymousClass4.AnonymousClass1());
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIComposeCallBack
        public void onComposeProgress(int i) {
            com.aliyun.svideo.editor.publish.PublishActivity.this.runOnUiThread(new com.aliyun.svideo.editor.publish.PublishActivity.AnonymousClass4.AnonymousClass2(i));
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.PublishActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion {
        private int vecIndex = 1;
        private int mInterval = 100;

        public AnonymousClass5() {
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onError(int i) {
            java.lang.String unused = com.aliyun.svideo.editor.publish.PublishActivity.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("fetcher onError ");
            sb.append(i);
            com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.publish.PublishActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_cover_fetch_cover_error);
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onThumbnailReady(android.graphics.Bitmap bitmap, long j, int i) {
            if (bitmap == null || bitmap.isRecycled()) {
                int i2 = this.vecIndex + this.mInterval;
                this.vecIndex = i2;
                com.aliyun.svideo.editor.publish.PublishActivity.this.requestThumbnailImage(i2);
                return;
            }
            com.aliyun.svideo.editor.publish.PublishActivity.this.mCoverImage.setVisibility(0);
            com.aliyun.svideo.editor.publish.PublishActivity.this.initThumbnail(bitmap);
            com.aliyun.svideo.editor.publish.PublishActivity.this.mPublish.setEnabled(com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeCompleted);
            com.aliyun.svideo.editor.publish.PublishActivity.this.mProgress.setVisibility(8);
            com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeProgress.setVisibility(8);
            com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeIndiate.setVisibility(0);
            com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeIndiate.setActivated(true);
            com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeStatusTip.setVisibility(8);
            com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeStatusText.setText(com.aliyun.svideo.editor.R.string.alivc_editor_publish_compose_success);
            com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeProgressView.postDelayed(com.aliyun.svideo.editor.publish.PublishActivity.this.composeProgressRunnable, 2000L);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.PublishActivity$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeProgressView != null) {
                com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeProgressView.setVisibility(8);
            }
            if (com.aliyun.svideo.editor.publish.PublishActivity.this.mCoverSelect != null) {
                com.aliyun.svideo.editor.publish.PublishActivity.this.mCoverSelect.setVisibility(0);
                com.aliyun.svideo.editor.publish.PublishActivity.this.mCoverSelect.setEnabled(com.aliyun.svideo.editor.publish.PublishActivity.this.mComposeCompleted);
            }
        }
    }

    public static class MyAsyncTask extends android.os.AsyncTask<java.lang.String, java.lang.Void, android.graphics.Bitmap> {
        private float maxWidth;
        private java.lang.ref.WeakReference<com.aliyun.svideo.editor.publish.PublishActivity> ref;

        public MyAsyncTask(com.aliyun.svideo.editor.publish.PublishActivity publishActivity) {
            this.ref = new java.lang.ref.WeakReference<>(publishActivity);
            this.maxWidth = (int) android.util.TypedValue.applyDimension(1, 240.0f, publishActivity.getResources().getDisplayMetrics());
        }

        @Override // android.os.AsyncTask
        public android.graphics.Bitmap doInBackground(java.lang.String... strArr) {
            com.aliyun.svideo.editor.publish.PublishActivity publishActivity;
            java.lang.ref.WeakReference<com.aliyun.svideo.editor.publish.PublishActivity> weakReference = this.ref;
            if (weakReference == null || (publishActivity = weakReference.get()) == null) {
                return null;
            }
            java.lang.String str = strArr[0];
            if (android.text.TextUtils.isEmpty(str) || !new java.io.File(str).exists()) {
                return null;
            }
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(str, options);
            float f = options.outWidth;
            float f2 = options.outHeight;
            float f3 = f > f2 ? f / this.maxWidth : f2 / this.maxWidth;
            boolean z = f3 != 1.0f;
            options.inJustDecodeBounds = false;
            android.graphics.Bitmap decodeFile = android.graphics.BitmapFactory.decodeFile(str, options);
            return (decodeFile == null || !z) ? decodeFile : publishActivity.scaleBitmap(decodeFile, f3);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(android.graphics.Bitmap bitmap) {
            java.lang.ref.WeakReference<com.aliyun.svideo.editor.publish.PublishActivity> weakReference;
            super.onPostExecute((com.aliyun.svideo.editor.publish.PublishActivity.MyAsyncTask) bitmap);
            if (bitmap == null || (weakReference = this.ref) == null || weakReference.get() == null) {
                return;
            }
            this.ref.get().initThumbnail(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int count(java.lang.String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            int charCount = java.lang.Character.charCount(codePointAt);
            if (codePointAt != 10) {
                if (isChinese(str.substring(i, i + charCount))) {
                    i3++;
                } else {
                    i2++;
                }
            }
            i += charCount;
        }
        int i4 = i2 % 2;
        int i5 = i2 / 2;
        if (i4 != 0) {
            i5++;
        }
        return i3 + i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initThumbnail(android.graphics.Bitmap bitmap) {
        int width;
        int height;
        this.mCoverBlur.setImageBitmap(bitmap);
        android.view.ViewParent parent = this.mCoverBlur.getParent();
        if (parent instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) parent;
            width = (viewGroup.getWidth() * 2) / 5;
            height = (viewGroup.getHeight() * 3) / 5;
        } else {
            width = (this.mCoverBlur.getWidth() * 2) / 5;
            height = (this.mCoverBlur.getHeight() * 3) / 5;
        }
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mCoverImage.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.mCoverImage.setLayoutParams(layoutParams);
        this.mCoverImage.setImageBitmap(bitmap);
    }

    private void initView() {
        android.view.View findViewById = findViewById(com.aliyun.svideo.editor.R.id.action_bar);
        this.mActionBar = findViewById;
        findViewById.setBackgroundColor(getResources().getColor(com.aliyun.svideo.editor.R.color.alivc_common_theme_primary_alpha_50));
        this.mPublish = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_right);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_left);
        this.mIvLeft = imageView;
        imageView.setOnClickListener(this);
        this.mIvLeft.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_back);
        this.mPublish.setText(com.aliyun.svideo.editor.R.string.alivc_editor_publish_tittle);
        this.mIvLeft.setVisibility(0);
        this.mPublish.setVisibility(0);
        this.mProgress = (android.widget.ProgressBar) findViewById(com.aliyun.svideo.editor.R.id.publish_progress);
        this.mComposeProgressView = findViewById(com.aliyun.svideo.editor.R.id.compose_progress_view);
        this.mCoverBlur = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.publish_cover_blur);
        this.mCoverImage = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.publish_cover_image);
        this.mVideoDesc = (android.widget.EditText) findViewById(com.aliyun.svideo.editor.R.id.publish_desc);
        this.mComposeIndiate = findViewById(com.aliyun.svideo.editor.R.id.image_compose_indicator);
        this.mPublish.setEnabled(this.mComposeCompleted);
        this.mPublish.setOnClickListener(this);
        android.view.View findViewById2 = findViewById(com.aliyun.svideo.editor.R.id.publish_cover_select);
        this.mCoverSelect = findViewById2;
        findViewById2.setEnabled(this.mComposeCompleted);
        this.mCoverSelect.setOnClickListener(this);
        this.mComposeProgress = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.compose_progress_text);
        this.mComposeStatusText = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.compose_status_text);
        this.mComposeStatusTip = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.compose_status_tip);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.btn_template_build);
        this.mTemplateBuild = textView;
        textView.setOnClickListener(this);
        this.mTemplateBuild.setVisibility(8);
        this.mVideoDesc.addTextChangedListener(new com.aliyun.svideo.editor.publish.PublishActivity.AnonymousClass2());
    }

    private boolean isChinese(char c) {
        java.lang.Character.UnicodeBlock of = java.lang.Character.UnicodeBlock.of(c);
        return of == java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || of == java.lang.Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == java.lang.Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || of == java.lang.Character.UnicodeBlock.GENERAL_PUNCTUATION;
    }

    private boolean isChinese(java.lang.String str) {
        for (char c : str.toCharArray()) {
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestThumbnailImage(int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("requestThumbnailImage");
        sb.append(i);
        this.aliyunIThumbnailFetcher.requestThumbnailImage(new long[]{i}, this.mThumbnailCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.Bitmap scaleBitmap(android.graphics.Bitmap bitmap, float f) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        float f2 = 1.0f / f;
        matrix.setScale(f2, f2);
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        bitmap.recycle();
        return createBitmap;
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.mIsUpdateCover && !com.aliyun.common.utils.StringUtils.isEmpty(this.mThumbnailPath)) {
            android.content.Intent intent = new android.content.Intent();
            intent.putExtra(KEY_RESULT_COVER, this.mThumbnailPath);
            setResult(-1, intent);
        }
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 && i2 == -1) {
            this.mIsUpdateCover = true;
            this.mThumbnailPath = intent.getStringExtra(com.aliyun.svideo.editor.publish.CoverEditActivity.KEY_PARAM_RESULT);
            this.mAsyncTaskResult = new com.aliyun.svideo.editor.publish.PublishActivity.MyAsyncTask(this).execute(this.mThumbnailPath);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mComposeCompleted) {
            super.onBackPressed();
        } else {
            new android.app.AlertDialog.Builder(this).setTitle(com.aliyun.svideo.editor.R.string.alivc_editor_publish_dialog_cancel_content_tip).setNegativeButton(com.aliyun.svideo.editor.R.string.alivc_editor_publish_goback, new com.aliyun.svideo.editor.publish.PublishActivity.AnonymousClass3()).setPositiveButton(com.aliyun.svideo.editor.R.string.alivc_editor_publish_continue, (android.content.DialogInterface.OnClickListener) null).create().show();
        }
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        android.widget.TextView textView = this.mPublish;
        if (view == textView) {
            textView.setEnabled(false);
            java.lang.String tagClassName = com.aliyun.svideo.base.AliyunSvideoActionConfig.getInstance().getAction().getTagClassName(com.aliyun.svideo.base.ActionInfo.SVideoAction.EDITOR_TARGET_CLASSNAME);
            android.content.Intent intent = new android.content.Intent();
            intent.setClassName(this, tagClassName);
            intent.putExtra(com.aliyun.svideo.editor.publish.UploadActivity.KEY_UPLOAD_THUMBNAIL, this.mThumbnailPath);
            intent.putExtra("key_param_video_ratio", getIntent().getFloatExtra("key_param_video_ratio", 0.0f));
            if (!android.text.TextUtils.isEmpty(this.mVideoDesc.getText())) {
                intent.putExtra(com.aliyun.svideo.editor.publish.UploadActivity.KEY_UPLOAD_DESC, this.mVideoDesc.getText().toString());
            }
            intent.putExtra("video_path", this.mOutputPath);
            startActivity(intent);
        } else if (view == this.mCoverSelect) {
            android.content.Intent intent2 = new android.content.Intent(this, (java.lang.Class<?>) com.aliyun.svideo.editor.publish.CoverEditActivity.class);
            intent2.putExtra(com.aliyun.svideo.editor.publish.CoverEditActivity.KEY_PARAM_VIDEO, this.mOutputPath);
            startActivityForResult(intent2, 0);
        } else if (view == this.mIvLeft) {
            onBackPressed();
        } else if (view == this.mTemplateBuild) {
            android.content.Intent intent3 = new android.content.Intent(this, (java.lang.Class<?>) com.aliyun.svideo.editor.template.TemplateBuilderActivity.class);
            intent3.putExtra("project_json_path", this.config);
            intent3.putExtra(com.aliyun.svideo.editor.template.TemplateBuilderActivity.KEY_PARAM_OUTPUT_PATH, this.mOutputPath);
            startActivity(intent3);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_publish);
        initView();
        this.config = getIntent().getStringExtra("project_json_path");
        this.mThumbnailPath = getIntent().getStringExtra(KEY_PARAM_THUMBNAIL);
        this.videoWidth = getIntent().getIntExtra(KEY_PARAM_VIDEO_WIDTH, 0);
        this.videoHeight = getIntent().getIntExtra(KEY_PARAM_VIDEO_HEIGHT, 0);
        this.aliyunIThumbnailFetcher = com.aliyun.svideosdk.common.impl.AliyunThumbnailFetcherFactory.createThumbnailFetcher();
        com.aliyun.svideosdk.editor.impl.AliyunVodCompose aliyunVodCompose = com.aliyun.svideo.editor.publish.ComposeFactory.INSTANCE.getAliyunVodCompose();
        this.mCompose = aliyunVodCompose;
        aliyunVodCompose.init(getApplicationContext());
        java.lang.String str = com.aliyun.svideo.base.Constants.SDCardConstants.getDir(this) + com.aliyun.svideo.common.utils.DateTimeUtils.getDateTimeFromMillisecond(java.lang.Long.valueOf(java.lang.System.currentTimeMillis())) + com.aliyun.svideo.base.Constants.SDCardConstants.COMPOSE_SUFFIX;
        this.mOutputPath = str;
        if (this.mCompose.compose(this.config, str, this.mCallback) != 0) {
            return;
        }
        ((android.view.View) this.mActionBar.getParent()).setOnClickListener(new com.aliyun.svideo.editor.publish.PublishActivity.AnonymousClass1());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aliyunIThumbnailFetcher.release();
        com.aliyun.svideosdk.editor.AliyunIVodCompose aliyunIVodCompose = this.mCompose;
        if (aliyunIVodCompose != null) {
            aliyunIVodCompose.release();
            this.mCompose = null;
        }
        android.view.View view = this.mComposeProgressView;
        if (view != null) {
            view.removeCallbacks(this.composeProgressRunnable);
        }
        android.os.AsyncTask<java.lang.String, java.lang.Void, android.graphics.Bitmap> asyncTask = this.mAsyncTaskOnCreate;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.mAsyncTaskOnCreate = null;
        }
        android.os.AsyncTask<java.lang.String, java.lang.Void, android.graphics.Bitmap> asyncTask2 = this.mAsyncTaskResult;
        if (asyncTask2 != null) {
            asyncTask2.cancel(true);
            this.mAsyncTaskResult = null;
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
        com.aliyun.svideosdk.editor.AliyunIVodCompose aliyunIVodCompose = this.mCompose;
        if (aliyunIVodCompose != null) {
            aliyunIVodCompose.pauseCompose();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.aliyun.svideosdk.editor.AliyunIVodCompose aliyunIVodCompose = this.mCompose;
        if (aliyunIVodCompose != null) {
            aliyunIVodCompose.resumeCompose();
        }
    }
}
