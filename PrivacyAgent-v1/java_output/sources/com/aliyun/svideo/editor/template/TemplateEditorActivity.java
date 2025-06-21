package com.aliyun.svideo.editor.template;

/* loaded from: classes29.dex */
public class TemplateEditorActivity extends androidx.fragment.app.FragmentActivity implements android.view.View.OnClickListener {
    public static final java.lang.String KEY_PARAM_CONFIG = "project_json_path";
    private static final int REQUEST_MEDIA = 1001;
    private static final int TAB_TEXT = 1;
    private static final int TAB_VIDEO = 0;
    private com.aliyun.svideosdk.editor.template.AliyunTemplateEditor mAliyunTemplateEditor;
    private android.graphics.Point mPasterContainerPoint;
    private android.widget.ImageView mPlayView;
    private androidx.recyclerview.widget.RecyclerView mRecyclerView;
    private com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam mReplaceParam;
    private android.widget.SeekBar mSeekBar;
    private android.widget.FrameLayout mSurfaceLayout;
    private android.view.SurfaceView mSurfaceView;
    private com.aliyun.svideo.editor.template.TemplateEditorAdapter mTemplateEditorAdapter;
    private android.widget.TextView mTvDuration;
    private android.widget.TextView mTvEditorText;
    private android.widget.TextView mTvEditorVideo;
    private android.widget.TextView mTvTime;
    private android.view.View mVFocus;
    private java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> mVideoParamList = new java.util.ArrayList();
    private java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> mTextParamList = new java.util.ArrayList();
    private boolean isNeedResume = true;

    /* renamed from: com.aliyun.svideo.editor.template.TemplateEditorActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.template.TemplateEditorActivity.this.init();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateEditorActivity$2, reason: invalid class name */
    public class AnonymousClass2 extends com.aliyun.svideosdk.editor.EditorCallBack {

        /* renamed from: com.aliyun.svideo.editor.template.TemplateEditorActivity$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mPlayView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_play);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.template.TemplateEditorActivity$2$2, reason: invalid class name and collision with other inner class name */
        public class RunnableC00742 implements java.lang.Runnable {
            final /* synthetic */ long val$currentPlayTime;

            public RunnableC00742(long j) {
                this.val$currentPlayTime = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mTvTime.setText(com.aliyun.svideo.common.utils.DateTimeUtils.formatMs(this.val$currentPlayTime / 1000));
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mSeekBar.setProgress((int) (this.val$currentPlayTime / 1000));
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onCustomRender(int i, int i2, int i3) {
            return 0;
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onDataReady() {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onEnd(int i) {
            com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mTvTime.post(new com.aliyun.svideo.editor.template.TemplateEditorActivity.AnonymousClass2.AnonymousClass1());
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onError(int i) {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onPlayProgress(long j, long j2) {
            com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mTvTime.post(new com.aliyun.svideo.editor.template.TemplateEditorActivity.AnonymousClass2.RunnableC00742(j));
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onTextureRender(int i, int i2, int i3) {
            return 0;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateEditorActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements android.widget.SeekBar.OnSeekBarChangeListener {
        public AnonymousClass3() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
            if (z) {
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mAliyunTemplateEditor.seek(i * 1000);
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mPlayView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_play);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateEditorActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mAliyunTemplateEditor.isPlaying()) {
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mAliyunTemplateEditor.pause();
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mPlayView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_play);
            } else {
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mAliyunTemplateEditor.play();
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mPlayView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_pause);
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setVisibility(8);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateEditorActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.svideo.editor.template.TemplateEditorAdapter.OnItemClickCallback {

        /* renamed from: com.aliyun.svideo.editor.template.TemplateEditorActivity$5$1, reason: invalid class name */
        public class AnonymousClass1 implements com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.OnResultListener {
            final /* synthetic */ com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam val$param;

            public AnonymousClass1(com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam) {
                this.val$param = aliyunTemplateParam;
            }

            @Override // com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.OnResultListener
            public void onResult(java.lang.String str) {
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mAliyunTemplateEditor.updateCaption((com.aliyun.svideosdk.common.struct.template.AliyunTemplateTextParam) this.val$param, str);
                ((com.aliyun.svideosdk.common.struct.template.AliyunTemplateTextParam) this.val$param).setText(str);
                com.aliyun.svideo.editor.template.TemplateEditorActivity.AnonymousClass5.this.onSelect(this.val$param);
            }
        }

        public AnonymousClass5() {
        }

        @Override // com.aliyun.svideo.editor.template.TemplateEditorAdapter.OnItemClickCallback
        public void onEdit(com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam) {
            if (aliyunTemplateParam.getTarget() instanceof com.aliyun.svideosdk.common.struct.project.CaptionTrack) {
                com.aliyun.svideosdk.common.struct.project.CaptionTrack captionTrack = (com.aliyun.svideosdk.common.struct.project.CaptionTrack) aliyunTemplateParam.getTarget();
                com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment templateTextEditDialogFragment = new com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment();
                templateTextEditDialogFragment.setText(captionTrack.getText());
                templateTextEditDialogFragment.setOnResultListener(new com.aliyun.svideo.editor.template.TemplateEditorActivity.AnonymousClass5.AnonymousClass1(aliyunTemplateParam));
                templateTextEditDialogFragment.show(com.aliyun.svideo.editor.template.TemplateEditorActivity.this.getSupportFragmentManager(), com.aliyun.svideo.editor.template.TemplateTextEditDialogFragment.class.getSimpleName());
                return;
            }
            if (aliyunTemplateParam.getTarget() instanceof com.aliyun.svideosdk.common.struct.project.VideoTrackClip) {
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mReplaceParam = aliyunTemplateParam;
                android.content.Intent intent = new android.content.Intent(com.aliyun.svideo.editor.template.TemplateEditorActivity.this, (java.lang.Class<?>) com.aliyun.svideo.editor.template.TemplateMediaActivity.class);
                com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip = (com.aliyun.svideosdk.common.struct.project.VideoTrackClip) aliyunTemplateParam.getTarget();
                intent.putExtra(com.aliyun.svideo.editor.template.TemplateMediaActivity.CLIP_DURATION, (long) ((videoTrackClip.getTimelineOut() - videoTrackClip.getTimelineIn()) * 1000.0f));
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.startActivityForResult(intent, 1001);
            }
        }

        @Override // com.aliyun.svideo.editor.template.TemplateEditorAdapter.OnItemClickCallback
        public void onSelect(com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam) {
            if (aliyunTemplateParam.getTarget() instanceof com.aliyun.svideosdk.common.struct.project.VideoTrackClip) {
                com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip = (com.aliyun.svideosdk.common.struct.project.VideoTrackClip) aliyunTemplateParam.getTarget();
                if (aliyunTemplateParam.getTarget() instanceof com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip) {
                    com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mAliyunTemplateEditor.seek((long) (videoTrackClip.getTimelineIn() * 1000000.0f));
                    com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip pipVideoTrackClip = (com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip) aliyunTemplateParam.getTarget();
                    int width = com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mSurfaceView.getWidth();
                    int height = com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mSurfaceView.getHeight();
                    float width2 = pipVideoTrackClip.getWidth();
                    float f = width;
                    float f2 = (width2 * 1.0f) / f;
                    float height2 = pipVideoTrackClip.getHeight();
                    float f3 = height;
                    float f4 = (height2 * 1.0f) / f3;
                    android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.getLayoutParams();
                    if (f2 > f4) {
                        int scale = (int) (pipVideoTrackClip.getScale() * f);
                        layoutParams.width = scale;
                        layoutParams.height = (int) (((scale * 1.0f) * height2) / width2);
                    } else {
                        int scale2 = (int) (pipVideoTrackClip.getScale() * f3);
                        layoutParams.height = scale2;
                        layoutParams.width = (int) (((scale2 * 1.0f) * width2) / height2);
                    }
                    com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setLayoutParams(layoutParams);
                    int centerX = (int) (pipVideoTrackClip.getCenterX() * f);
                    int centerY = (int) (pipVideoTrackClip.getCenterY() * f3);
                    com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setTranslationX(centerX - (layoutParams.width / 2));
                    com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setTranslationY(centerY - (layoutParams.height / 2));
                    if (pipVideoTrackClip.getRotation() != -1) {
                        com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setRotation((float) java.lang.Math.toDegrees(pipVideoTrackClip.getRotation()));
                    }
                } else {
                    int indexOf = com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mAliyunTemplateEditor.getEditorProject().getTimeline().getPrimaryTrack().getVideoTrackClips().indexOf(videoTrackClip);
                    if (indexOf > -1) {
                        com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mAliyunTemplateEditor.seek(com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mAliyunTemplateEditor.getMainClipStartTime(indexOf));
                    }
                    android.widget.FrameLayout.LayoutParams layoutParams2 = (android.widget.FrameLayout.LayoutParams) com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.getLayoutParams();
                    layoutParams2.width = com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mSurfaceView.getWidth();
                    layoutParams2.height = com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mSurfaceView.getHeight();
                    com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setLayoutParams(layoutParams2);
                    com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setTranslationX(0.0f);
                    com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setTranslationY(0.0f);
                    com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setRotation(0.0f);
                }
            } else if (aliyunTemplateParam.getTarget() instanceof com.aliyun.svideosdk.common.struct.project.CaptionTrack) {
                int width3 = com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mSurfaceView.getWidth();
                int height3 = com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mSurfaceView.getHeight();
                com.aliyun.svideosdk.common.struct.project.CaptionTrack captionTrack = (com.aliyun.svideosdk.common.struct.project.CaptionTrack) aliyunTemplateParam.getTarget();
                captionTrack.updateInfo();
                float scale3 = captionTrack.getScale();
                float f5 = width3;
                int width4 = (int) (captionTrack.getWidth() * f5 * scale3);
                float f6 = height3;
                int height4 = (int) (captionTrack.getHeight() * f6 * scale3);
                int x = (int) (captionTrack.getX() * f5);
                int y = (int) (captionTrack.getY() * f6);
                android.widget.FrameLayout.LayoutParams layoutParams3 = (android.widget.FrameLayout.LayoutParams) com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.getLayoutParams();
                layoutParams3.width = width4;
                layoutParams3.height = height4;
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setLayoutParams(layoutParams3);
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setRotation((float) java.lang.Math.toDegrees(-captionTrack.getRotation()));
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setTranslationX(x - (width4 / 2));
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setTranslationY(y - (height4 / 2));
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.postInvalidate();
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mAliyunTemplateEditor.getEditorProject().getConfig().getOutputWidth();
                com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mAliyunTemplateEditor.seek((long) (captionTrack.getTimelineIn() * 1000000.0f));
            }
            com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mPlayView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_play);
            com.aliyun.svideo.editor.template.TemplateEditorActivity.this.mVFocus.setVisibility(0);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateEditorActivity$6, reason: invalid class name */
    public class AnonymousClass6 implements com.aliyun.svideosdk.editor.draft.AliyunDraftResourceDownloader {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog val$dialog;
        final /* synthetic */ java.lang.String val$srcFileDir;

        public AnonymousClass6(java.lang.String str, com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog, android.content.Context context) {
            this.val$srcFileDir = str;
            this.val$dialog = alivcCircleLoadingDialog;
            this.val$context = context;
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftResourceHandle
        public void onFailure(java.lang.String str) {
            this.val$dialog.dismiss();
            android.widget.Toast.makeText(this.val$context, com.aliyun.svideo.editor.R.string.alivc_editor_template_editor_draft_failed, 0).show();
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftResourceDownloader
        public void onHandleResourceTasks(java.lang.String str, java.util.List<com.aliyun.svideosdk.editor.draft.AliyunDraftResTask> list) {
            java.util.HashMap hashMap = new java.util.HashMap();
            for (com.aliyun.svideosdk.editor.draft.AliyunDraftResTask aliyunDraftResTask : list) {
                if (aliyunDraftResTask.getSource() != null && com.aliyun.common.utils.StringUtils.isEmpty(aliyunDraftResTask.getSource().getPath())) {
                    aliyunDraftResTask.onIgnore();
                } else if (hashMap.containsKey(aliyunDraftResTask.getSource().getPath())) {
                    ((java.util.List) hashMap.get(aliyunDraftResTask.getSource().getPath())).add(aliyunDraftResTask);
                } else {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    arrayList.add(aliyunDraftResTask);
                    hashMap.put(aliyunDraftResTask.getSource().getPath(), arrayList);
                }
            }
            for (java.util.Map.Entry entry : hashMap.entrySet()) {
                java.util.List<com.aliyun.svideosdk.editor.draft.AliyunDraftResTask> list2 = (java.util.List) entry.getValue();
                try {
                    java.io.File file = new java.io.File((java.lang.String) entry.getKey());
                    if (file.getParentFile().getAbsolutePath().equals(this.val$srcFileDir)) {
                        java.io.File file2 = new java.io.File(str, file.getName());
                        com.aliyun.common.utils.FileUtils.copyFile(file, file2);
                        for (com.aliyun.svideosdk.editor.draft.AliyunDraftResTask aliyunDraftResTask2 : list2) {
                            com.aliyun.svideosdk.common.struct.project.Source source = aliyunDraftResTask2.getSource();
                            source.setPath(file2.getAbsolutePath());
                            aliyunDraftResTask2.onHandleCallback(source);
                        }
                    } else {
                        java.util.Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            ((com.aliyun.svideosdk.editor.draft.AliyunDraftResTask) it.next()).onIgnore();
                        }
                    }
                } catch (java.lang.Exception unused) {
                    java.util.Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        ((com.aliyun.svideosdk.editor.draft.AliyunDraftResTask) it2.next()).onIgnore();
                    }
                }
            }
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftResourceDownloader
        public void onSuccess(com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft) {
            this.val$dialog.dismiss();
            com.aliyun.svideo.editor.editor.EditorActivity.startEdit(this.val$context, aliyunDraft);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        try {
            this.mAliyunTemplateEditor = com.aliyun.svideosdk.editor.template.AliyunTemplateFactory.createAliyunTemplateEditor(android.net.Uri.parse(getIntent().getStringExtra("project_json_path")));
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mSurfaceLayout.getLayoutParams();
            android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int outputWidth = this.mAliyunTemplateEditor.getEditorProject().getConfig().getOutputWidth();
            int outputHeight = this.mAliyunTemplateEditor.getEditorProject().getConfig().getOutputHeight();
            int height = this.mSurfaceLayout.getHeight();
            int i = displayMetrics.widthPixels;
            float f = outputHeight;
            float f2 = outputWidth;
            int round = java.lang.Math.round((i * f) / f2);
            if (round > height) {
                i = java.lang.Math.round((height * f2) / f);
            } else {
                height = round;
            }
            layoutParams.width = i;
            layoutParams.height = height;
            this.mSurfaceLayout.setLayoutParams(layoutParams);
            this.mPasterContainerPoint = new android.graphics.Point(i, height);
            this.mAliyunTemplateEditor.setPlayerCallBack(new com.aliyun.svideo.editor.template.TemplateEditorActivity.AnonymousClass2());
            this.mSeekBar.setOnSeekBarChangeListener(new com.aliyun.svideo.editor.template.TemplateEditorActivity.AnonymousClass3());
            this.mPlayView.setOnClickListener(new com.aliyun.svideo.editor.template.TemplateEditorActivity.AnonymousClass4());
            this.mRecyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this, 0, false));
            if (this.mAliyunTemplateEditor.init(this.mSurfaceView, layoutParams.width, layoutParams.height) != 0) {
                com.aliyun.common.utils.ToastUtil.showToast(getApplicationContext(), com.aliyun.svideo.editor.R.string.alivc_editor_toast_no_authorization);
                finish();
                return;
            }
            this.mTvDuration.setText(com.aliyun.svideo.common.utils.DateTimeUtils.formatMs(this.mAliyunTemplateEditor.getDuration() / 1000));
            this.mSeekBar.setMax((int) (this.mAliyunTemplateEditor.getDuration() / 1000));
            this.mAliyunTemplateEditor.play();
            this.mPlayView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_pause);
            for (com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam : this.mAliyunTemplateEditor.getAllParams()) {
                if (aliyunTemplateParam.getType() == com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam.Type.video) {
                    this.mVideoParamList.add(aliyunTemplateParam);
                } else if (aliyunTemplateParam.getType() == com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam.Type.text) {
                    this.mTextParamList.add(aliyunTemplateParam);
                }
            }
            if (this.mTextParamList.isEmpty()) {
                this.mTvEditorText.setVisibility(8);
            }
            com.aliyun.svideo.editor.template.TemplateEditorAdapter templateEditorAdapter = new com.aliyun.svideo.editor.template.TemplateEditorAdapter();
            this.mTemplateEditorAdapter = templateEditorAdapter;
            templateEditorAdapter.setOnItemClickCallback(new com.aliyun.svideo.editor.template.TemplateEditorActivity.AnonymousClass5());
            onTabChanged(0);
            this.mRecyclerView.setAdapter(this.mTemplateEditorAdapter);
        } catch (java.lang.Exception unused) {
            android.widget.Toast.makeText(getApplicationContext(), com.aliyun.svideo.editor.R.string.alivc_editor_template_editor_load_failed, 0).show();
            finish();
        }
    }

    private void jumpToNextActivity() {
        com.aliyun.svideo.editor.bean.AlivcEditOutputParam alivcEditOutputParam = new com.aliyun.svideo.editor.bean.AlivcEditOutputParam();
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject editorProject = this.mAliyunTemplateEditor.getEditorProject();
        alivcEditOutputParam.setConfigPath(editorProject.getProjectFile().getAbsolutePath());
        alivcEditOutputParam.setOutputVideoHeight(editorProject.getConfig().getOutputHeight());
        alivcEditOutputParam.setOutputVideoWidth(editorProject.getConfig().getOutputWidth());
        android.graphics.Point point = this.mPasterContainerPoint;
        alivcEditOutputParam.setVideoRatio(point.x / point.y);
        alivcEditOutputParam.setVideoParam(new com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder().frameRate(editorProject.getConfig().getFps()).gop(editorProject.getConfig().getGop()).crf(editorProject.getConfig().getCrf()).videoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality.values()[editorProject.getConfig().getVideoQuality()]).scaleMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.valueOf(editorProject.getConfig().getDisplayMode())).scaleRate(editorProject.getConfig().getScale()).outputWidth(editorProject.getConfig().getOutputWidth()).outputHeight(editorProject.getConfig().getOutputHeight()).videoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.getInstanceByValue(editorProject.getConfig().getVideoCodec())).build());
        if (editorProject.getCover() == null || com.aliyun.common.utils.StringUtils.isEmpty(editorProject.getCover().getPath()) || !com.aliyun.common.utils.FileUtils.isFileExists(editorProject.getCover().getPath())) {
            alivcEditOutputParam.setThumbnailPath(com.aliyun.svideo.base.Constants.SDCardConstants.getDir(getApplicationContext()) + java.io.File.separator + "thumbnail.jpg");
        } else {
            alivcEditOutputParam.setThumbnailPath(editorProject.getCover().getPath());
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(this, com.aliyun.svideo.editor.editor.EditorActivity.NEXT_ACTIVITY_CLASS_NAME);
        intent.putExtra(com.aliyun.svideo.editor.publish.PublishActivity.KEY_PARAM_THUMBNAIL, alivcEditOutputParam.getThumbnailPath());
        intent.putExtra("project_json_path", alivcEditOutputParam.getConfigPath());
        intent.putExtra(com.aliyun.svideo.editor.publish.PublishActivity.KEY_PARAM_VIDEO_WIDTH, alivcEditOutputParam.getOutputVideoWidth());
        intent.putExtra(com.aliyun.svideo.editor.publish.PublishActivity.KEY_PARAM_VIDEO_HEIGHT, alivcEditOutputParam.getOutputVideoHeight());
        intent.putExtra("key_param_video_ratio", alivcEditOutputParam.getVideoRatio());
        intent.putExtra("videoParam", alivcEditOutputParam.getVideoParam());
        startActivityForResult(intent, 2021);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1001 != i || this.mReplaceParam == null) {
            return;
        }
        if (i2 == -1) {
            com.aliyun.svideo.media.MediaInfo mediaInfo = (com.aliyun.svideo.media.MediaInfo) intent.getParcelableExtra("MediaInfo");
            long timelineOut = (long) ((this.mReplaceParam.getTimelineOut() - this.mReplaceParam.getTimelineIn()) * 1000.0f);
            com.aliyun.svideosdk.common.struct.common.AliyunClip build = mediaInfo.mimeType.startsWith("video") ? new com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.Builder().source(mediaInfo.filePath).startTime(mediaInfo.startTime).endTime(mediaInfo.startTime + timelineOut).duration(mediaInfo.duration).build() : mediaInfo.mimeType.startsWith("image") ? new com.aliyun.svideosdk.common.struct.common.AliyunImageClip.Builder().source(mediaInfo.filePath).duration(timelineOut).build() : null;
            this.mAliyunTemplateEditor.updateMediaClip((com.aliyun.svideosdk.common.struct.template.AliyunTemplateVideoParam) this.mReplaceParam, build);
            ((com.aliyun.svideosdk.common.struct.template.AliyunTemplateVideoParam) this.mReplaceParam).setSource(new com.aliyun.svideosdk.common.struct.project.Source(build.getSource()));
            this.mTemplateEditorAdapter.notifyDataSetChanged();
        }
        this.mReplaceParam = null;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (view.getId() == com.aliyun.svideo.editor.R.id.iv_left) {
            finish();
        } else if (view.getId() == com.aliyun.svideo.editor.R.id.tv_right) {
            jumpToNextActivity();
        } else if (view.getId() == com.aliyun.svideo.editor.R.id.tv_editor_video) {
            if (!view.isSelected()) {
                onTabChanged(0);
            }
        } else if (view.getId() == com.aliyun.svideo.editor.R.id.tv_editor_text) {
            if (!view.isSelected()) {
                onTabChanged(1);
            }
        } else if (view.getId() == com.aliyun.svideo.editor.R.id.tv_draft) {
            android.content.Context context = view.getContext();
            com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog = new com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog(context, 0);
            alivcCircleLoadingDialog.show();
            com.aliyun.svideosdk.editor.draft.AliyunDraftManager.getInstance(context).downloadDraft(this.mAliyunTemplateEditor.getEditorProject().getProjectFile(), new com.aliyun.svideo.editor.template.TemplateEditorActivity.AnonymousClass6(this.mAliyunTemplateEditor.getEditorProject().getProjectDir().getAbsolutePath(), alivcCircleLoadingDialog, context));
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.editor.R.layout.aliyun_svideo_activity_template_editor);
        this.mSurfaceLayout = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.layout_surface);
        this.mSurfaceView = (android.view.SurfaceView) findViewById(com.aliyun.svideo.editor.R.id.surface_view);
        this.mPlayView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.aliyun_template_btn_play);
        this.mTvTime = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.aliyun_template_tv_time);
        this.mSeekBar = (android.widget.SeekBar) findViewById(com.aliyun.svideo.editor.R.id.aliyun_template_play_seekbar);
        this.mTvDuration = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.aliyun_template_tv_duration);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_editor_video);
        this.mTvEditorVideo = textView;
        textView.setOnClickListener(this);
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_editor_text);
        this.mTvEditorText = textView2;
        textView2.setOnClickListener(this);
        findViewById(com.aliyun.svideo.editor.R.id.tv_draft).setOnClickListener(this);
        this.mRecyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.recycler_view);
        this.mVFocus = findViewById(com.aliyun.svideo.editor.R.id.v_focus);
        android.widget.TextView textView3 = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_right);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_left);
        imageView.setOnClickListener(this);
        imageView.setVisibility(0);
        imageView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_back);
        textView3.setText(com.aliyun.svideo.editor.R.string.alivc_base_svideo_next);
        textView3.setVisibility(0);
        textView3.setOnClickListener(this);
        this.mSurfaceLayout.post(new com.aliyun.svideo.editor.template.TemplateEditorActivity.AnonymousClass1());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.aliyun.svideosdk.editor.template.AliyunTemplateEditor aliyunTemplateEditor = this.mAliyunTemplateEditor;
        if (aliyunTemplateEditor != null) {
            aliyunTemplateEditor.onDestroy();
            this.mAliyunTemplateEditor = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.aliyun.svideosdk.editor.template.AliyunTemplateEditor aliyunTemplateEditor = this.mAliyunTemplateEditor;
        if (aliyunTemplateEditor != null) {
            boolean isPlaying = aliyunTemplateEditor.isPlaying();
            this.isNeedResume = isPlaying;
            if (isPlaying) {
                this.mAliyunTemplateEditor.pause();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.aliyun.svideosdk.editor.template.AliyunTemplateEditor aliyunTemplateEditor = this.mAliyunTemplateEditor;
        if (aliyunTemplateEditor == null || !this.isNeedResume) {
            return;
        }
        aliyunTemplateEditor.play();
    }

    public void onTabChanged(int i) {
        if (i == 0) {
            this.mTvEditorVideo.setSelected(true);
            this.mTvEditorText.setSelected(false);
            this.mTemplateEditorAdapter.setData(this.mVideoParamList);
        } else if (1 == i) {
            this.mTvEditorVideo.setSelected(false);
            this.mTvEditorText.setSelected(true);
            this.mTemplateEditorAdapter.setData(this.mTextParamList);
        }
    }
}
