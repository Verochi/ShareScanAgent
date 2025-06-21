package com.aliyun.svideo.editor.template;

/* loaded from: classes29.dex */
public class TemplateListActivity extends android.app.Activity implements android.view.View.OnClickListener {
    public static final int MEDIA_REQUEST_CODE = 6677;
    public static final int REQUEST_CODE = 5566;
    private java.util.concurrent.ExecutorService executorService;
    private androidx.recyclerview.widget.RecyclerView mRecyclerView;
    private com.aliyun.svideo.editor.template.TemplateAdapter mTemplateAdapter;

    /* renamed from: com.aliyun.svideo.editor.template.TemplateListActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.util.EditorCommon.CopyCallback {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.util.EditorCommon.CopyCallback
        public void onFileCopy(java.lang.String str) {
            com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.editor.template.TemplateListActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_toast_template_loading);
            com.aliyun.svideo.editor.template.TemplateListActivity.this.onImportTemplate(str);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateListActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.util.EditorCommon.copyAll(com.aliyun.svideo.editor.template.TemplateListActivity.this, new android.widget.FrameLayout(com.aliyun.svideo.editor.template.TemplateListActivity.this));
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateListActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.editor.template.TemplateManager.TemplateListCallback {
        public AnonymousClass3() {
        }

        @Override // com.aliyun.svideo.editor.template.TemplateManager.TemplateListCallback
        public void onFailure(java.lang.String str) {
            if (com.aliyun.svideo.editor.template.TemplateListActivity.this.isDestroyed() || com.aliyun.svideo.editor.template.TemplateListActivity.this.isFinishing()) {
                return;
            }
            android.widget.Toast.makeText(com.aliyun.svideo.editor.template.TemplateListActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_template_list_loading_exception, 0).show();
        }

        @Override // com.aliyun.svideo.editor.template.TemplateManager.TemplateListCallback
        public void onSuccess(java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplate> list) {
            if (com.aliyun.svideo.editor.template.TemplateListActivity.this.isDestroyed() || com.aliyun.svideo.editor.template.TemplateListActivity.this.isFinishing()) {
                return;
            }
            com.aliyun.svideo.editor.template.TemplateListActivity.this.mTemplateAdapter.setData(list);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateListActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        final /* synthetic */ com.google.android.material.bottomsheet.BottomSheetDialog val$bottomSheetDialog;
        final /* synthetic */ android.view.View.OnClickListener val$onClickListener;
        final /* synthetic */ java.lang.Object val$tag;

        public AnonymousClass4(java.lang.Object obj, android.view.View.OnClickListener onClickListener, com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog) {
            this.val$tag = obj;
            this.val$onClickListener = onClickListener;
            this.val$bottomSheetDialog = bottomSheetDialog;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            view.setTag(this.val$tag);
            this.val$onClickListener.onClick(view);
            this.val$bottomSheetDialog.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateListActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.svideo.editor.template.TemplateManager.ImportCallback {
        final /* synthetic */ com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog val$dialog;

        /* renamed from: com.aliyun.svideo.editor.template.TemplateListActivity$5$1, reason: invalid class name */
        public class AnonymousClass1 implements com.aliyun.svideo.editor.template.TemplateSourceHandleCallback {
            final /* synthetic */ com.aliyun.svideosdk.common.struct.template.AliyunTemplate val$template;

            /* renamed from: com.aliyun.svideo.editor.template.TemplateListActivity$5$1$1, reason: invalid class name and collision with other inner class name */
            public class C00751 implements com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback {
                final /* synthetic */ com.aliyun.svideo.editor.template.TemplateResTask val$resTask;

                public C00751(com.aliyun.svideo.editor.template.TemplateResTask templateResTask) {
                    this.val$resTask = templateResTask;
                }

                @Override // com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback
                public void onFailure(java.lang.String str, java.lang.String str2) {
                    com.aliyun.svideo.editor.template.TemplateResTask templateResTask = this.val$resTask;
                    templateResTask.onHandleCallback(templateResTask.getSource());
                }

                @Override // com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback
                public void onSuccess(java.lang.String str) {
                    this.val$resTask.getSource().setPath(str);
                    com.aliyun.svideo.editor.template.TemplateResTask templateResTask = this.val$resTask;
                    templateResTask.onHandleCallback(templateResTask.getSource());
                }
            }

            /* renamed from: com.aliyun.svideo.editor.template.TemplateListActivity$5$1$2, reason: invalid class name */
            public class AnonymousClass2 implements com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback {
                final /* synthetic */ com.aliyun.svideo.editor.template.TemplateResTask val$resTask;

                public AnonymousClass2(com.aliyun.svideo.editor.template.TemplateResTask templateResTask) {
                    this.val$resTask = templateResTask;
                }

                @Override // com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback
                public void onFailure(java.lang.String str, java.lang.String str2) {
                    com.aliyun.svideo.editor.template.TemplateResTask templateResTask = this.val$resTask;
                    templateResTask.onHandleCallback(templateResTask.getSource());
                }

                @Override // com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback
                public void onSuccess(java.lang.String str) {
                    this.val$resTask.getSource().setPath(str);
                    com.aliyun.svideo.editor.template.TemplateResTask templateResTask = this.val$resTask;
                    templateResTask.onHandleCallback(templateResTask.getSource());
                }
            }

            public AnonymousClass1(com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate) {
                this.val$template = aliyunTemplate;
            }

            @Override // com.aliyun.svideo.editor.template.TemplateSourceHandleCallback
            public void onFailure(java.lang.String str) {
                com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass5.this.val$dialog.dismiss();
                android.widget.Toast.makeText(com.aliyun.svideo.editor.template.TemplateListActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_template_list_import_failed, 0).show();
            }

            @Override // com.aliyun.svideo.editor.template.TemplateSourceHandleCallback
            public void onHandleResourceTasks(java.lang.String str, java.util.List<com.aliyun.svideo.editor.template.TemplateResTask> list) {
                for (com.aliyun.svideo.editor.template.TemplateResTask templateResTask : list) {
                    java.lang.String url = templateResTask.getSource().getURL();
                    if (url.startsWith(com.aliyun.svideo.editor.util.AlivcResUtil.SCHEME)) {
                        com.aliyun.svideo.editor.util.AlivcResUtil.loadRes(com.aliyun.svideo.editor.template.TemplateListActivity.this.getApplicationContext(), url, str, new com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass5.AnonymousClass1.C00751(templateResTask));
                    } else {
                        com.aliyun.svideo.editor.util.AlivcResUtil.downloadRes(url, new java.io.File(str, url.substring(url.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + 1)).getAbsolutePath(), new com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass5.AnonymousClass1.AnonymousClass2(templateResTask));
                    }
                }
            }

            @Override // com.aliyun.svideo.editor.template.TemplateSourceHandleCallback
            public void onSuccess() {
                com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass5.this.val$dialog.dismiss();
                com.aliyun.svideo.editor.template.TemplateListActivity.this.loadTemplateDraftResource(new java.io.File(this.val$template.getPath()).getParentFile().getPath(), this.val$template.getProject().getPath());
            }
        }

        public AnonymousClass5(com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog) {
            this.val$dialog = alivcCircleLoadingDialog;
        }

        @Override // com.aliyun.svideo.editor.template.TemplateManager.ImportCallback
        public void onFailure(java.lang.String str) {
            this.val$dialog.dismiss();
            android.widget.Toast.makeText(com.aliyun.svideo.editor.template.TemplateListActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_template_list_import_failed, 0).show();
        }

        @Override // com.aliyun.svideo.editor.template.TemplateManager.ImportCallback
        public void onSuccess(com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate) {
            com.aliyun.svideo.editor.template.TemplateManager.getInstance(com.aliyun.svideo.editor.template.TemplateListActivity.this.getApplicationContext()).loadTemplateSource(aliyunTemplate, new com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass5.AnonymousClass1(aliyunTemplate));
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateListActivity$6, reason: invalid class name */
    public class AnonymousClass6 implements com.aliyun.svideosdk.editor.draft.AliyunDraftResourceLoader {
        final /* synthetic */ com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog val$dialog;
        final /* synthetic */ java.lang.String val$dir;

        /* renamed from: com.aliyun.svideo.editor.template.TemplateListActivity$6$1, reason: invalid class name */
        public class AnonymousClass1 implements com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback {
            final /* synthetic */ java.util.List val$list;

            public AnonymousClass1(java.util.List list) {
                this.val$list = list;
            }

            @Override // com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback
            public void onFailure(java.lang.String str, java.lang.String str2) {
                java.util.Iterator it = this.val$list.iterator();
                while (it.hasNext()) {
                    ((com.aliyun.svideosdk.editor.draft.AliyunDraftResTask) it.next()).onIgnore();
                }
            }

            @Override // com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback
            public void onSuccess(java.lang.String str) {
                for (com.aliyun.svideosdk.editor.draft.AliyunDraftResTask aliyunDraftResTask : this.val$list) {
                    com.aliyun.svideosdk.common.struct.project.Source source = aliyunDraftResTask.getSource();
                    source.setPath(str);
                    aliyunDraftResTask.onHandleCallback(source);
                }
            }
        }

        /* renamed from: com.aliyun.svideo.editor.template.TemplateListActivity$6$2, reason: invalid class name */
        public class AnonymousClass2 implements com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback {
            final /* synthetic */ java.util.List val$list;

            public AnonymousClass2(java.util.List list) {
                this.val$list = list;
            }

            @Override // com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback
            public void onFailure(java.lang.String str, java.lang.String str2) {
                java.util.Iterator it = this.val$list.iterator();
                while (it.hasNext()) {
                    ((com.aliyun.svideosdk.editor.resource.AliyunResTask) it.next()).onIgnore();
                }
            }

            @Override // com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback
            public void onSuccess(java.lang.String str) {
                for (com.aliyun.svideosdk.editor.resource.AliyunResTask aliyunResTask : this.val$list) {
                    com.aliyun.svideosdk.common.struct.project.Source source = aliyunResTask.getSource();
                    source.setPath(str);
                    aliyunResTask.onHandleCallback(source);
                }
            }
        }

        public AnonymousClass6(java.lang.String str, com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog) {
            this.val$dir = str;
            this.val$dialog = alivcCircleLoadingDialog;
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftResourceHandle
        public void onFailure(java.lang.String str) {
            this.val$dialog.dismiss();
            android.widget.Toast.makeText(com.aliyun.svideo.editor.template.TemplateListActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_template_list_import_failed, 0).show();
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftResourceLoader
        public void onHandleResourceTasks(java.util.List<com.aliyun.svideosdk.editor.draft.AliyunDraftResTask> list) {
            java.util.HashMap hashMap = new java.util.HashMap();
            for (com.aliyun.svideosdk.editor.draft.AliyunDraftResTask aliyunDraftResTask : list) {
                if (aliyunDraftResTask.getSource() == null || com.aliyun.common.utils.StringUtils.isEmpty(aliyunDraftResTask.getSource().getURL())) {
                    if (aliyunDraftResTask.getResModuleType() == com.aliyun.svideosdk.editor.resource.AliyunResModuleType.MAIN_VIDEO) {
                        aliyunDraftResTask.getSource().setPath(com.aliyun.svideo.editor.util.EditorCommon.SD_DIR + "svideo_res/image/aliyun_svideo_failed.jpg");
                        aliyunDraftResTask.onHandleCallback(aliyunDraftResTask.getSource());
                    } else if (aliyunDraftResTask.getResModuleType() == com.aliyun.svideosdk.editor.resource.AliyunResModuleType.TRANSITION) {
                        aliyunDraftResTask.onRemove();
                    } else {
                        aliyunDraftResTask.onIgnore();
                    }
                } else if (hashMap.containsKey(aliyunDraftResTask.getSource().getURL())) {
                    ((java.util.List) hashMap.get(aliyunDraftResTask.getSource().getURL())).add(aliyunDraftResTask);
                } else {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    arrayList.add(aliyunDraftResTask);
                    hashMap.put(aliyunDraftResTask.getSource().getURL(), arrayList);
                }
                for (java.util.Map.Entry entry : hashMap.entrySet()) {
                    java.util.List list2 = (java.util.List) entry.getValue();
                    try {
                        java.lang.String str = (java.lang.String) entry.getKey();
                        if (str.startsWith(com.aliyun.svideo.editor.util.AlivcResUtil.SCHEME)) {
                            com.aliyun.svideo.editor.util.AlivcResUtil.loadRes(com.aliyun.svideo.editor.template.TemplateListActivity.this.getApplicationContext(), str, this.val$dir, new com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass6.AnonymousClass1(list2));
                        } else {
                            java.lang.String substring = str.substring(str.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + 1);
                            if (list2 != null && list2.size() > 0 && ((com.aliyun.svideosdk.editor.draft.AliyunDraftResTask) list2.get(0)).getResModuleType() == com.aliyun.svideosdk.editor.resource.AliyunResModuleType.COVER) {
                                substring = "cover.jpeg";
                            }
                            com.aliyun.svideo.editor.util.AlivcResUtil.downloadRes(str, new java.io.File(this.val$dir, substring).getAbsolutePath(), new com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass6.AnonymousClass2(list2));
                        }
                    } catch (java.lang.Exception unused) {
                        java.util.Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            ((com.aliyun.svideosdk.editor.draft.AliyunDraftResTask) it.next()).onIgnore();
                        }
                    }
                }
            }
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftResourceLoader
        public void onSuccess() {
            this.val$dialog.dismiss();
            com.aliyun.svideo.editor.template.TemplateListActivity.this.initData();
            android.widget.Toast.makeText(com.aliyun.svideo.editor.template.TemplateListActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_template_list_import_success, 0).show();
        }
    }

    private void copyAssets() {
        this.executorService.execute(new com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass2());
    }

    private java.lang.String getRealPathFromURI(android.net.Uri uri) {
        int columnIndex;
        int columnIndex2;
        java.lang.String str = null;
        if (uri == null) {
            return null;
        }
        java.lang.String scheme = uri.getScheme();
        if (scheme == null) {
            str = uri.getPath();
        } else if ("file".equals(scheme)) {
            str = uri.getPath();
        } else if ("content".equals(scheme)) {
            android.database.Cursor query = getContentResolver().query(uri, new java.lang.String[]{"_data"}, null, null, null);
            if (query != null) {
                if (query.moveToFirst() && (columnIndex2 = query.getColumnIndex("_data")) > -1) {
                    str = query.getString(columnIndex2);
                }
                query.close();
            }
            if (str == null) {
                android.database.Cursor query2 = getContentResolver().query(uri, new java.lang.String[]{"document_id"}, null, null, null);
                if (query2 != null) {
                    if (query2.moveToFirst() && (columnIndex = query2.getColumnIndex("document_id")) > -1) {
                        str = query2.getString(columnIndex);
                    }
                    query2.close();
                }
                if (str != null) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("data = ");
                    sb.append(str);
                    str = str.replace("raw:/", "").replace("primary:", "storage/emulated/0/");
                    if (str.contains("storage/emulated")) {
                        str = str.substring(str.indexOf("storage/emulated"));
                    }
                }
            }
        }
        if (str == null && uri.toString().contains("storage/emulated")) {
            str = uri.toString().substring(uri.toString().indexOf("storage/emulated"));
            try {
                str = java.net.URLDecoder.decode(str, "utf-8");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("return data = ");
        sb2.append(str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        com.aliyun.svideo.editor.template.TemplateManager.getInstance(getApplicationContext()).getTemplateListByAsync(new com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadTemplateDraftResource(java.lang.String str, java.lang.String str2) {
        com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog = new com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog(this, 0);
        alivcCircleLoadingDialog.show();
        com.aliyun.svideosdk.editor.draft.AliyunDraftManager aliyunTemplateDraftManager = com.aliyun.svideosdk.editor.draft.AliyunTemplateDraftManager.getInstance(getApplicationContext());
        aliyunTemplateDraftManager.preLoadDraft(aliyunTemplateDraftManager.getDraftByPath(str2), new com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass6(str, alivcCircleLoadingDialog));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onImportTemplate(java.lang.String str) {
        com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog = new com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog(this, 0);
        alivcCircleLoadingDialog.show();
        com.aliyun.svideo.editor.template.TemplateManager.getInstance(getApplicationContext()).importTemplateZip(new java.io.File(str), new com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass5(alivcCircleLoadingDialog));
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 5566) {
                onImportTemplate(getRealPathFromURI(intent.getData()));
            } else if (i == 6677) {
                java.lang.String stringExtra = intent.getStringExtra(com.aliyun.svideo.editor.template.TemplateMediaActivity.RESULT_PATH);
                android.content.Intent intent2 = new android.content.Intent(this, (java.lang.Class<?>) com.aliyun.svideo.editor.template.TemplateEditorActivity.class);
                intent2.putExtra("project_json_path", stringExtra);
                startActivity(intent2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (view.getId() == com.aliyun.svideo.editor.R.id.iv_left) {
            finish();
        } else if (view.getId() == com.aliyun.svideo.editor.R.id.tv_right) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.GET_CONTENT");
            intent.setType("application/zip");
            intent.addCategory("android.intent.category.OPENABLE");
            startActivityForResult(intent, REQUEST_CODE);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.executorService = com.aliyun.svideo.editor.util.ThreadUtil.newDynamicSingleThreadedExecutor(new com.aliyun.svideo.editor.view.AlivcEditView.AlivcEditThread());
        setContentView(com.aliyun.svideo.editor.R.layout.aliyun_svideo_activity_template_list);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_center);
        textView.setText(com.aliyun.svideo.editor.R.string.alivc_editor_template_list);
        textView.setVisibility(0);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_left);
        imageView.setOnClickListener(this);
        imageView.setVisibility(0);
        imageView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_back);
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_right);
        textView2.setOnClickListener(this);
        textView2.setVisibility(0);
        textView2.setText(com.aliyun.svideo.editor.R.string.alivc_editor_template_list_import);
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.recycler_view);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(recyclerView.getContext(), 1, false));
        this.mRecyclerView.addItemDecoration(new androidx.recyclerview.widget.DividerItemDecoration(this.mRecyclerView.getContext(), 1));
        com.aliyun.svideo.editor.template.TemplateAdapter templateAdapter = new com.aliyun.svideo.editor.template.TemplateAdapter();
        this.mTemplateAdapter = templateAdapter;
        this.mRecyclerView.setAdapter(templateAdapter);
        if (com.aliyun.svideo.common.utils.PermissionUtils.checkPermissionsGroup(this, com.aliyun.svideo.common.utils.PermissionUtils.PERMISSION_STORAGE)) {
            com.aliyun.svideo.editor.util.EditorCommon.copySelf(this, "template", new com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass1());
            copyAssets();
        }
        initData();
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void showMenu(android.view.View.OnClickListener onClickListener, java.lang.Object obj) {
        com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(this);
        com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass4 anonymousClass4 = new com.aliyun.svideo.editor.template.TemplateListActivity.AnonymousClass4(obj, onClickListener, bottomSheetDialog);
        android.view.View inflate = android.view.View.inflate(this, com.aliyun.svideo.editor.R.layout.alivc_editor_template_bottom_sheet, null);
        inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_export_btn).setOnClickListener(anonymousClass4);
        inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_delete_btn).setOnClickListener(anonymousClass4);
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.show();
    }
}
