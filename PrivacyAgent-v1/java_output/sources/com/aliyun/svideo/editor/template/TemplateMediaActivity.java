package com.aliyun.svideo.editor.template;

/* loaded from: classes29.dex */
public class TemplateMediaActivity extends android.app.Activity {
    public static final java.lang.String CLIP_DURATION = "Clip_Duration";
    public static final java.lang.String RESULT_PATH = "Result_Path";
    public static final java.lang.String TEMPLATE_PATH = "Template_Path";
    private com.aliyun.svideo.media.MutiMediaView mMutiMediaView;
    private java.lang.String mTemplatePath;
    private com.aliyun.svideosdk.common.struct.template.AliyunTemplate template;

    /* renamed from: com.aliyun.svideo.editor.template.TemplateMediaActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.media.MutiMediaView.OnTemplateActionListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.media.MutiMediaView.OnTemplateActionListener
        public void onBack() {
            com.aliyun.svideo.editor.template.TemplateMediaActivity.this.finish();
        }

        @Override // com.aliyun.svideo.media.MutiMediaView.OnTemplateActionListener
        public void onTemplateImport(java.util.List<com.aliyun.svideo.media.MediaInfo> list) {
            if (com.aliyun.svideo.common.utils.FastClickUtil.isFastClick()) {
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (com.aliyun.svideo.media.MediaInfo mediaInfo : list) {
                if (mediaInfo.mimeType.startsWith("video")) {
                    arrayList.add(new com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.Builder().source(mediaInfo.filePath).startTime(mediaInfo.startTime).endTime(mediaInfo.startTime + mediaInfo.duration).duration(mediaInfo.duration).build());
                } else if (mediaInfo.mimeType.startsWith("image")) {
                    arrayList.add(new com.aliyun.svideosdk.common.struct.common.AliyunImageClip.Builder().source(mediaInfo.filePath).duration(mediaInfo.duration).build());
                }
            }
            if (com.aliyun.svideo.editor.template.TemplateMediaActivity.this.template != null) {
                com.aliyun.svideosdk.common.struct.project.AliyunEditorProject createEditorProject = com.aliyun.svideo.editor.template.TemplateMediaActivity.this.template.createEditorProject(com.aliyun.svideo.editor.template.TemplateMediaActivity.this, arrayList);
                android.content.Intent intent = new android.content.Intent();
                intent.putExtra(com.aliyun.svideo.editor.template.TemplateMediaActivity.RESULT_PATH, createEditorProject.getProjectFile().getAbsolutePath());
                com.aliyun.svideo.editor.template.TemplateMediaActivity.this.setResult(-1, intent);
                com.aliyun.svideo.editor.template.TemplateMediaActivity.this.finish();
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateMediaActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.media.MutiMediaView.OnMediaClickListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.media.MutiMediaView.OnMediaClickListener
        public void onClick(com.aliyun.svideo.media.MediaInfo mediaInfo) {
            com.aliyun.svideo.media.MediaInfo mediaInfo2 = new com.aliyun.svideo.media.MediaInfo();
            mediaInfo2.addTime = mediaInfo.addTime;
            mediaInfo2.mimeType = mediaInfo.mimeType;
            if (!mediaInfo.mimeType.startsWith("image")) {
                mediaInfo2.duration = mediaInfo.duration;
            } else if (mediaInfo.filePath.endsWith("gif") || mediaInfo.filePath.endsWith("GIF")) {
                com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
                nativeParser.init(mediaInfo.filePath);
                try {
                    if (java.lang.Integer.parseInt(nativeParser.getValue(4)) > 1) {
                        try {
                            int parseInt = java.lang.Integer.parseInt(nativeParser.getValue(3)) / 1000;
                            mediaInfo2.mimeType = "video";
                            mediaInfo2.duration = parseInt;
                        } catch (java.lang.Exception unused) {
                            com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.template.TemplateMediaActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_error_tip_play_video_error);
                            nativeParser.release();
                            nativeParser.dispose();
                            return;
                        }
                    }
                    nativeParser.release();
                    nativeParser.dispose();
                } catch (java.lang.Exception unused2) {
                    com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.template.TemplateMediaActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_error_tip_play_video_error);
                    nativeParser.release();
                    nativeParser.dispose();
                    return;
                }
            }
            mediaInfo2.filePath = mediaInfo.filePath;
            mediaInfo2.fileUri = mediaInfo.fileUri;
            mediaInfo2.id = mediaInfo.id;
            mediaInfo2.isSquare = mediaInfo.isSquare;
            mediaInfo2.thumbnailPath = mediaInfo.thumbnailPath;
            mediaInfo2.thumbnailUri = mediaInfo.thumbnailUri;
            mediaInfo2.title = mediaInfo.title;
            mediaInfo2.type = mediaInfo.type;
            if (!com.aliyun.common.utils.StringUtils.isEmpty(com.aliyun.svideo.editor.template.TemplateMediaActivity.this.mTemplatePath)) {
                com.aliyun.svideo.editor.template.TemplateMediaActivity.this.mMutiMediaView.addSelectMedia(mediaInfo2);
                return;
            }
            android.content.Intent intent = new android.content.Intent();
            intent.putExtra("MediaInfo", mediaInfo2);
            com.aliyun.svideo.editor.template.TemplateMediaActivity.this.setResult(-1, intent);
            com.aliyun.svideo.editor.template.TemplateMediaActivity.this.finish();
        }
    }

    private void init() {
        this.mTemplatePath = getIntent().getStringExtra(TEMPLATE_PATH);
        com.aliyun.svideo.media.MutiMediaView mutiMediaView = (com.aliyun.svideo.media.MutiMediaView) findViewById(com.aliyun.svideo.editor.R.id.media_view);
        this.mMutiMediaView = mutiMediaView;
        mutiMediaView.setMode(0);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (com.aliyun.common.utils.StringUtils.isEmpty(this.mTemplatePath)) {
            long longExtra = getIntent().getLongExtra(CLIP_DURATION, -1L);
            if (longExtra == -1) {
                android.widget.Toast.makeText(this, "参数异常", 0).show();
                finish();
            }
            arrayList.add(java.lang.Long.valueOf(longExtra));
            this.mMutiMediaView.enableTemplateReplace(longExtra);
        } else {
            com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate = com.aliyun.svideosdk.editor.template.AliyunTemplateFactory.getAliyunTemplate(android.net.Uri.parse(this.mTemplatePath));
            this.template = aliyunTemplate;
            if (aliyunTemplate != null) {
                for (com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam : aliyunTemplate.getImportParams()) {
                    arrayList.add(java.lang.Long.valueOf((long) ((aliyunTemplateParam.getTimelineOut() - aliyunTemplateParam.getTimelineIn()) * 1000.0f)));
                }
            }
            this.mMutiMediaView.enableTemplateImportView(arrayList);
        }
        this.mMutiMediaView.setOnTemplateActionListener(new com.aliyun.svideo.editor.template.TemplateMediaActivity.AnonymousClass1());
        this.mMutiMediaView.setOnMediaClickListener(new com.aliyun.svideo.editor.template.TemplateMediaActivity.AnonymousClass2());
        this.mMutiMediaView.loadMedia();
    }

    @Override // android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.editor.R.layout.alivc_editor_media);
        init();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mMutiMediaView.onDestroy();
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
