package com.aliyun.svideo.editor.template;

/* loaded from: classes29.dex */
public class TemplateBuilderActivity extends androidx.fragment.app.FragmentActivity implements android.view.View.OnClickListener {
    public static final java.lang.String KEY_PARAM_CONFIG = "project_json_path";
    public static final java.lang.String KEY_PARAM_OUTPUT_PATH = "OutputPath";
    private boolean isNeedResume = true;
    private com.aliyun.svideosdk.editor.template.AliyunTemplateBuilder mAliyunTemplateBuilder;
    private java.lang.String mOutputPath;
    private android.widget.ImageView mPlayView;
    private androidx.recyclerview.widget.RecyclerView mRecyclerView;
    private android.widget.SeekBar mSeekBar;
    private android.widget.FrameLayout mSurfaceLayout;
    private android.view.SurfaceView mSurfaceView;
    private com.aliyun.svideo.editor.template.TemplateInputAdapter mTemplateInputAdapter;
    private android.widget.TextView mTvDuration;
    private android.widget.TextView mTvTime;

    /* renamed from: com.aliyun.svideo.editor.template.TemplateBuilderActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.init();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateBuilderActivity$2, reason: invalid class name */
    public class AnonymousClass2 extends com.aliyun.svideosdk.editor.EditorCallBack {

        /* renamed from: com.aliyun.svideo.editor.template.TemplateBuilderActivity$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mPlayView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_play);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.template.TemplateBuilderActivity$2$2, reason: invalid class name and collision with other inner class name */
        public class RunnableC00732 implements java.lang.Runnable {
            final /* synthetic */ long val$currentPlayTime;

            public RunnableC00732(long j) {
                this.val$currentPlayTime = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mTvTime.setText(com.aliyun.svideo.common.utils.DateTimeUtils.formatMs(this.val$currentPlayTime / 1000));
                com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mSeekBar.setProgress((int) (this.val$currentPlayTime / 1000));
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
            com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mTvTime.post(new com.aliyun.svideo.editor.template.TemplateBuilderActivity.AnonymousClass2.AnonymousClass1());
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onError(int i) {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onPlayProgress(long j, long j2) {
            com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mTvTime.post(new com.aliyun.svideo.editor.template.TemplateBuilderActivity.AnonymousClass2.RunnableC00732(j));
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onTextureRender(int i, int i2, int i3) {
            return 0;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateBuilderActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements android.widget.SeekBar.OnSeekBarChangeListener {
        public AnonymousClass3() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
            if (z) {
                com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mAliyunTemplateBuilder.seek(i * 1000);
                com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mPlayView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_play);
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

    /* renamed from: com.aliyun.svideo.editor.template.TemplateBuilderActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mAliyunTemplateBuilder.isPlaying()) {
                com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mAliyunTemplateBuilder.pause();
                com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mPlayView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_play);
            } else {
                com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mAliyunTemplateBuilder.play();
                com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mPlayView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_pause);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateBuilderActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.svideo.editor.template.TemplateTitleDialogFragment.OnTitleListener {
        final /* synthetic */ android.view.View val$view;

        /* renamed from: com.aliyun.svideo.editor.template.TemplateBuilderActivity$5$1, reason: invalid class name */
        public class AnonymousClass1 implements com.aliyun.svideosdk.editor.template.AliyunTemplateSourceHandleCallback {
            final /* synthetic */ com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog val$dialog;

            public AnonymousClass1(com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog) {
                this.val$dialog = alivcCircleLoadingDialog;
            }

            @Override // com.aliyun.svideosdk.editor.template.AliyunTemplateSourceHandleCallback
            public void onFailure(java.lang.String str) {
                this.val$dialog.dismiss();
            }

            @Override // com.aliyun.svideosdk.editor.template.AliyunTemplateSourceHandleCallback
            public void onHandleResourceTasks(java.lang.String str, java.util.List<com.aliyun.svideosdk.editor.resource.AliyunResTask> list) {
                java.util.HashMap hashMap = new java.util.HashMap();
                for (com.aliyun.svideosdk.editor.resource.AliyunResTask aliyunResTask : list) {
                    if (aliyunResTask.getSource() == null || aliyunResTask.getSource().getPath() == null) {
                        aliyunResTask.onIgnore();
                    } else {
                        java.lang.String url = aliyunResTask.getSource().getURL();
                        if (!com.aliyun.common.utils.StringUtils.isEmpty(url) && url.startsWith(com.aliyun.svideo.editor.util.AlivcResUtil.SCHEME)) {
                            aliyunResTask.onIgnore();
                        } else if (hashMap.containsKey(aliyunResTask.getSource().getPath())) {
                            ((java.util.List) hashMap.get(aliyunResTask.getSource().getPath())).add(aliyunResTask);
                        } else {
                            java.util.ArrayList arrayList = new java.util.ArrayList();
                            arrayList.add(aliyunResTask);
                            hashMap.put(aliyunResTask.getSource().getPath(), arrayList);
                        }
                    }
                }
                for (java.util.Map.Entry entry : hashMap.entrySet()) {
                    try {
                        java.lang.String str2 = (java.lang.String) entry.getKey();
                        if (str2 != null) {
                            java.io.File file = new java.io.File(str2);
                            java.io.File file2 = new java.io.File(str, file.getName());
                            if (!str2.contains(str)) {
                                com.aliyun.common.utils.FileUtils.copyFile(file, file2);
                            }
                            for (com.aliyun.svideosdk.editor.resource.AliyunResTask aliyunResTask2 : (java.util.List) entry.getValue()) {
                                com.aliyun.svideosdk.common.struct.project.Source source = aliyunResTask2.getSource();
                                source.setPath(file2.getPath());
                                source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getRelationResUri(file.getName()));
                                aliyunResTask2.onHandleCallback(source);
                            }
                        }
                    } catch (java.lang.Exception unused) {
                        java.util.Iterator it = ((java.util.List) entry.getValue()).iterator();
                        while (it.hasNext()) {
                            ((com.aliyun.svideosdk.editor.resource.AliyunResTask) it.next()).onIgnore();
                        }
                    }
                }
            }

            @Override // com.aliyun.svideosdk.editor.template.AliyunTemplateSourceHandleCallback
            public void onSuccess() {
                this.val$dialog.dismiss();
                com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.finish();
            }
        }

        public AnonymousClass5(android.view.View view) {
            this.val$view = view;
        }

        @Override // com.aliyun.svideo.editor.template.TemplateTitleDialogFragment.OnTitleListener
        public void onTitle(java.lang.String str) {
            if (com.aliyun.common.utils.StringUtils.isEmpty(str)) {
                return;
            }
            java.io.File externalFilesDir = com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.getExternalFilesDir(null);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(externalFilesDir.getAbsolutePath());
            java.lang.String str2 = java.io.File.separator;
            sb.append(str2);
            sb.append(com.aliyun.svideo.editor.template.TemplateManager.TEMPLATE_LIST_DIR);
            sb.append(str2);
            sb.append(java.lang.System.currentTimeMillis());
            java.io.File file = new java.io.File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                java.io.File file2 = new java.io.File(com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mOutputPath);
                java.io.File file3 = new java.io.File(file, file2.getName());
                com.aliyun.common.utils.FileUtils.copyFile(file2, file3);
                com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(file3.getPath());
                source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getRelationResUri(file2.getName()));
                java.io.File file4 = new java.io.File(com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mAliyunTemplateBuilder.getEditorProject().getCover().getPath());
                java.io.File file5 = new java.io.File(file, file4.getName());
                com.aliyun.common.utils.FileUtils.copyFile(file4, file5);
                com.aliyun.svideosdk.common.struct.project.Source source2 = new com.aliyun.svideosdk.common.struct.project.Source(file5.getPath());
                source2.setURL(com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mAliyunTemplateBuilder.getEditorProject().getCover().getURL());
                if (com.aliyun.common.utils.StringUtils.isEmpty(source2.getURL())) {
                    source2.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getRelationResUri(file4.getName()));
                }
                com.aliyun.svideosdk.common.struct.project.Source source3 = new com.aliyun.svideosdk.common.struct.project.Source(new java.io.File(file, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.PROJECT_FILENAME).getPath());
                source3.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getRelationResUri(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.PROJECT_FILENAME));
                com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog = new com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog(this.val$view.getContext(), 0);
                alivcCircleLoadingDialog.show();
                com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mAliyunTemplateBuilder.build(file, str, source, source2, source3, com.aliyun.svideo.editor.template.TemplateBuilderActivity.this.mTemplateInputAdapter.getData(), new com.aliyun.svideo.editor.template.TemplateBuilderActivity.AnonymousClass5.AnonymousClass1(alivcCircleLoadingDialog));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        this.mOutputPath = getIntent().getStringExtra(KEY_PARAM_OUTPUT_PATH);
        this.mAliyunTemplateBuilder = com.aliyun.svideosdk.editor.template.AliyunTemplateFactory.createAliyunTemplateBuilder(android.net.Uri.parse(getIntent().getStringExtra("project_json_path")));
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mSurfaceLayout.getLayoutParams();
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int outputWidth = this.mAliyunTemplateBuilder.getEditorProject().getConfig().getOutputWidth();
        int outputHeight = this.mAliyunTemplateBuilder.getEditorProject().getConfig().getOutputHeight();
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
        this.mAliyunTemplateBuilder.setPlayerCallBack(new com.aliyun.svideo.editor.template.TemplateBuilderActivity.AnonymousClass2());
        this.mSeekBar.setOnSeekBarChangeListener(new com.aliyun.svideo.editor.template.TemplateBuilderActivity.AnonymousClass3());
        this.mPlayView.setOnClickListener(new com.aliyun.svideo.editor.template.TemplateBuilderActivity.AnonymousClass4());
        this.mRecyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this, 0, false));
        if (this.mAliyunTemplateBuilder.init(this.mSurfaceView, layoutParams.width, layoutParams.height) != 0) {
            com.aliyun.common.utils.ToastUtil.showToast(getApplicationContext(), com.aliyun.svideo.editor.R.string.alivc_editor_toast_no_authorization);
            finish();
            return;
        }
        this.mTvDuration.setText(com.aliyun.svideo.common.utils.DateTimeUtils.formatMs(this.mAliyunTemplateBuilder.getDuration() / 1000));
        this.mSeekBar.setMax((int) (this.mAliyunTemplateBuilder.getDuration() / 1000));
        this.mAliyunTemplateBuilder.play();
        this.mPlayView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_pause);
        java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> allParams = this.mAliyunTemplateBuilder.getAllParams();
        com.aliyun.svideo.editor.template.TemplateInputAdapter templateInputAdapter = new com.aliyun.svideo.editor.template.TemplateInputAdapter();
        this.mTemplateInputAdapter = templateInputAdapter;
        templateInputAdapter.setData(allParams);
        this.mRecyclerView.setAdapter(this.mTemplateInputAdapter);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (view.getId() == com.aliyun.svideo.editor.R.id.iv_left) {
            finish();
        } else if (view.getId() == com.aliyun.svideo.editor.R.id.tv_right && this.mAliyunTemplateBuilder != null) {
            com.aliyun.svideo.editor.template.TemplateTitleDialogFragment templateTitleDialogFragment = new com.aliyun.svideo.editor.template.TemplateTitleDialogFragment();
            templateTitleDialogFragment.setOnTitleListener(new com.aliyun.svideo.editor.template.TemplateBuilderActivity.AnonymousClass5(view));
            templateTitleDialogFragment.show(getSupportFragmentManager(), com.aliyun.svideo.editor.draft.CloudDraftConfigDialogFragment.class.getSimpleName());
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.editor.R.layout.aliyun_svideo_activity_template_builder);
        this.mSurfaceLayout = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.layout_surface);
        this.mSurfaceView = (android.view.SurfaceView) findViewById(com.aliyun.svideo.editor.R.id.surface_view);
        this.mPlayView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.aliyun_template_btn_play);
        this.mTvTime = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.aliyun_template_tv_time);
        this.mSeekBar = (android.widget.SeekBar) findViewById(com.aliyun.svideo.editor.R.id.aliyun_template_play_seekbar);
        this.mTvDuration = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.aliyun_template_tv_duration);
        this.mRecyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.recycler_view);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_center);
        textView.setText(com.aliyun.svideo.editor.R.string.alivc_editor_template_build_title);
        textView.setVisibility(0);
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_right);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_left);
        imageView.setOnClickListener(this);
        imageView.setVisibility(0);
        imageView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_back);
        textView2.setText(com.aliyun.svideo.editor.R.string.alivc_editor_template_build_btn);
        textView2.setVisibility(0);
        textView2.setOnClickListener(this);
        this.mSurfaceLayout.post(new com.aliyun.svideo.editor.template.TemplateBuilderActivity.AnonymousClass1());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.aliyun.svideosdk.editor.template.AliyunTemplateBuilder aliyunTemplateBuilder = this.mAliyunTemplateBuilder;
        if (aliyunTemplateBuilder != null) {
            aliyunTemplateBuilder.onDestroy();
            this.mAliyunTemplateBuilder = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.aliyun.svideosdk.editor.template.AliyunTemplateBuilder aliyunTemplateBuilder = this.mAliyunTemplateBuilder;
        if (aliyunTemplateBuilder != null) {
            boolean isPlaying = aliyunTemplateBuilder.isPlaying();
            this.isNeedResume = isPlaying;
            if (isPlaying) {
                this.mAliyunTemplateBuilder.pause();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.aliyun.svideosdk.editor.template.AliyunTemplateBuilder aliyunTemplateBuilder = this.mAliyunTemplateBuilder;
        if (aliyunTemplateBuilder == null || !this.isNeedResume) {
            return;
        }
        aliyunTemplateBuilder.play();
    }
}
