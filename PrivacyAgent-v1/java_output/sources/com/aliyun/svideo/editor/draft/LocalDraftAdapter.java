package com.aliyun.svideo.editor.draft;

/* loaded from: classes12.dex */
public class LocalDraftAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.editor.draft.LocalDraftAdapter.DraftViewHolder> implements android.view.View.OnClickListener {
    private boolean isTemplateDraft;
    private java.util.List<com.aliyun.svideosdk.editor.draft.AliyunDraft> mData = new java.util.ArrayList();

    /* renamed from: com.aliyun.svideo.editor.draft.LocalDraftAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.draft.DraftRenameDialogFragment.OnRenameListener {
        final /* synthetic */ com.aliyun.svideosdk.editor.draft.AliyunDraft val$item;
        final /* synthetic */ android.view.View val$v;

        public AnonymousClass1(com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, android.view.View view) {
            this.val$item = aliyunDraft;
            this.val$v = view;
        }

        @Override // com.aliyun.svideo.editor.draft.DraftRenameDialogFragment.OnRenameListener
        public void onRename(java.lang.String str) {
            this.val$item.setName(str);
            com.aliyun.svideo.editor.draft.LocalDraftAdapter.this.getAliyunDraftManager(this.val$v.getContext()).rename(this.val$item.getId(), str);
            com.aliyun.svideo.editor.draft.LocalDraftAdapter.this.notifyDataSetChanged();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.draft.LocalDraftAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideosdk.editor.draft.AliyunDraftResourceLoader {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog val$dialog;
        final /* synthetic */ com.aliyun.svideosdk.editor.draft.AliyunDraft val$item;
        final /* synthetic */ android.view.View val$v;

        /* renamed from: com.aliyun.svideo.editor.draft.LocalDraftAdapter$2$1, reason: invalid class name */
        public class AnonymousClass1 implements com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback {
            final /* synthetic */ java.util.List val$list;

            public AnonymousClass1(java.util.List list) {
                this.val$list = list;
            }

            @Override // com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback
            public void onFailure(java.lang.String str, java.lang.String str2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("loadRes>Failure>type>");
                sb.append(str);
                sb.append(">msg>");
                sb.append(str2);
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

        /* renamed from: com.aliyun.svideo.editor.draft.LocalDraftAdapter$2$2, reason: invalid class name and collision with other inner class name */
        public class C00592 implements com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback {
            final /* synthetic */ java.util.List val$list;

            public C00592(java.util.List list) {
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

        public AnonymousClass2(android.content.Context context, com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog, android.view.View view) {
            this.val$context = context;
            this.val$item = aliyunDraft;
            this.val$dialog = alivcCircleLoadingDialog;
            this.val$v = view;
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftResourceHandle
        public void onFailure(java.lang.String str) {
            this.val$dialog.dismiss();
            android.widget.Toast.makeText(this.val$v.getContext(), com.aliyun.svideo.editor.R.string.alivc_svideo_draft_preload_failed, 0).show();
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
                            com.aliyun.svideo.editor.util.AlivcResUtil.loadRes(this.val$context, str, new com.aliyun.svideo.editor.draft.LocalDraftAdapter.AnonymousClass2.AnonymousClass1(list2));
                        } else {
                            java.lang.String substring = str.substring(str.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + 1);
                            if (list2 != null && list2.size() > 0 && ((com.aliyun.svideosdk.editor.draft.AliyunDraftResTask) list2.get(0)).getResModuleType() == com.aliyun.svideosdk.editor.resource.AliyunResModuleType.COVER) {
                                substring = "cover.jpeg";
                            }
                            com.aliyun.svideo.editor.util.AlivcResUtil.downloadRes(str, new java.io.File(this.val$item.getEditorProjectUri(), substring).getAbsolutePath(), new com.aliyun.svideo.editor.draft.LocalDraftAdapter.AnonymousClass2.C00592(list2));
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
            if (!com.aliyun.svideo.editor.draft.LocalDraftAdapter.this.isTemplateDraft) {
                com.aliyun.svideo.editor.editor.EditorActivity.startEdit(this.val$v.getContext(), this.val$item);
                return;
            }
            android.content.Intent intent = new android.content.Intent(this.val$v.getContext(), (java.lang.Class<?>) com.aliyun.svideo.editor.template.TemplateEditorActivity.class);
            intent.putExtra("project_json_path", this.val$item.getEditorProjectUri());
            this.val$v.getContext().startActivity(intent);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.draft.LocalDraftAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideosdk.editor.draft.AliyunDraftResourceUploader {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog val$dialog;
        final /* synthetic */ com.aliyun.svideosdk.editor.draft.AliyunDraft val$item;
        final /* synthetic */ int val$position;

        public AnonymousClass3(android.content.Context context, com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog, int i) {
            this.val$context = context;
            this.val$item = aliyunDraft;
            this.val$dialog = alivcCircleLoadingDialog;
            this.val$position = i;
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftResourceHandle
        public void onFailure(java.lang.String str) {
            this.val$dialog.dismiss();
            android.widget.Toast.makeText(this.val$context, com.aliyun.svideo.editor.R.string.alivc_svideo_draft_backup_failed, 0).show();
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftResourceUploader
        public void onHandleResourceTasks(java.util.List<com.aliyun.svideosdk.editor.draft.AliyunDraftResTask> list) {
            java.util.HashMap hashMap = new java.util.HashMap();
            for (com.aliyun.svideosdk.editor.draft.AliyunDraftResTask aliyunDraftResTask : list) {
                if (aliyunDraftResTask.getSource() == null) {
                    aliyunDraftResTask.onIgnore();
                } else {
                    java.lang.String url = aliyunDraftResTask.getSource().getURL();
                    if (!com.aliyun.common.utils.StringUtils.isEmpty(url) && url.startsWith(com.aliyun.svideo.editor.util.AlivcResUtil.SCHEME)) {
                        aliyunDraftResTask.onIgnore();
                    } else if (hashMap.containsKey(aliyunDraftResTask.getSource().getPath())) {
                        ((java.util.List) hashMap.get(aliyunDraftResTask.getSource().getPath())).add(aliyunDraftResTask);
                    } else {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        arrayList.add(aliyunDraftResTask);
                        hashMap.put(aliyunDraftResTask.getSource().getPath(), arrayList);
                    }
                }
            }
            for (java.util.Map.Entry entry : hashMap.entrySet()) {
                try {
                    com.aliyun.svideo.editor.draft.LocalDraftAdapter.this.uploadFile(this.val$context, (java.lang.String) entry.getKey(), (java.util.List) entry.getValue());
                } catch (java.lang.Exception unused) {
                    java.util.Iterator it = ((java.util.List) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        ((com.aliyun.svideosdk.editor.draft.AliyunDraftResTask) it.next()).onIgnore();
                    }
                }
            }
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftResourceUploader
        public void onSuccess(java.lang.String str, java.lang.String str2) {
            com.aliyun.svideo.editor.draft.LocalDraftAdapter.this.uploadDraftConfig(this.val$dialog, new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(new java.util.Date(this.val$item.getUpdateTime())), this.val$context, this.val$item, str, str2, this.val$position);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.draft.LocalDraftAdapter$4, reason: invalid class name */
    public class AnonymousClass4 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ java.lang.String val$path;
        final /* synthetic */ java.util.List val$tasks;

        public AnonymousClass4(java.util.List list, android.content.Context context, java.lang.String str) {
            this.val$tasks = list;
            this.val$context = context;
            this.val$path = str;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            java.util.Iterator it = this.val$tasks.iterator();
            while (it.hasNext()) {
                ((com.aliyun.svideosdk.editor.draft.AliyunDraftResTask) it.next()).onIgnore();
            }
            android.widget.Toast.makeText(this.val$context, ((java.lang.Object) this.val$context.getText(com.aliyun.svideo.editor.R.string.alivc_svideo_draft_backup_exception)) + "：" + str, 0).show();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("uploadFile>onFailure>");
            sb.append(str);
            sb.append(">");
            sb.append(this.val$path);
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("uploadFile>onSuccess>");
            sb.append(str);
            try {
                com.aliyun.svideo.editor.draft.CloudUploadResResult cloudUploadResResult = (com.aliyun.svideo.editor.draft.CloudUploadResResult) new com.google.gson.Gson().fromJson(str, com.aliyun.svideo.editor.draft.CloudUploadResResult.class);
                if (cloudUploadResResult.code == 0) {
                    for (com.aliyun.svideosdk.editor.draft.AliyunDraftResTask aliyunDraftResTask : this.val$tasks) {
                        com.aliyun.svideosdk.common.struct.project.Source source = aliyunDraftResTask.getSource();
                        source.setURL(cloudUploadResResult.data);
                        aliyunDraftResTask.onHandleCallback(source);
                    }
                }
            } catch (java.lang.Exception unused) {
                java.util.Iterator it = this.val$tasks.iterator();
                while (it.hasNext()) {
                    ((com.aliyun.svideosdk.editor.draft.AliyunDraftResTask) it.next()).onIgnore();
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.draft.LocalDraftAdapter$5, reason: invalid class name */
    public class AnonymousClass5 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog val$dialog;
        final /* synthetic */ com.aliyun.svideosdk.editor.draft.AliyunDraft val$item;
        final /* synthetic */ int val$position;

        public AnonymousClass5(com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog, android.content.Context context, com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, int i) {
            this.val$dialog = alivcCircleLoadingDialog;
            this.val$context = context;
            this.val$item = aliyunDraft;
            this.val$position = i;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            this.val$dialog.dismiss();
            android.widget.Toast.makeText(this.val$context, ((java.lang.Object) this.val$context.getText(com.aliyun.svideo.editor.R.string.alivc_svideo_draft_backup_failed)) + "：" + str, 0).show();
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            this.val$dialog.dismiss();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("uploadDraftConfig>onSuccess>");
            sb.append(str);
            try {
                com.aliyun.svideo.editor.draft.CloudUploadDraftResult cloudUploadDraftResult = (com.aliyun.svideo.editor.draft.CloudUploadDraftResult) new com.google.gson.Gson().fromJson(str, com.aliyun.svideo.editor.draft.CloudUploadDraftResult.class);
                if (cloudUploadDraftResult.code == 0) {
                    com.aliyun.svideosdk.editor.draft.AliyunDraftManager.getInstance(this.val$context).setProjectId(this.val$item.getId(), cloudUploadDraftResult.data.mProjectId);
                    this.val$item.setProjectId(cloudUploadDraftResult.data.mProjectId);
                    com.aliyun.svideo.editor.draft.LocalDraftAdapter.this.notifyItemChanged(this.val$position);
                    com.aliyun.svideo.editor.draft.LocalDraftAdapter.this.notifyCloudDraftFragment(this.val$context);
                    android.widget.Toast.makeText(this.val$context, com.aliyun.svideo.editor.R.string.alivc_svideo_draft_backup_success, 0).show();
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static class DraftViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public android.widget.ImageView ivBackup;
        public android.widget.ImageView ivCover;
        public android.widget.ImageView ivMore;
        public android.widget.TextView tvDuration;
        public android.widget.TextView tvSize;
        public android.widget.TextView tvTitle;
        public android.widget.TextView tvUpdate;

        public DraftViewHolder(android.view.View view) {
            super(view);
            this.ivCover = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_cover);
            this.ivBackup = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_backup);
            this.tvTitle = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_title);
            this.tvUpdate = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_update);
            this.tvSize = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_size);
            this.tvDuration = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_duration);
            this.ivMore = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_more);
        }
    }

    public LocalDraftAdapter(boolean z) {
        this.isTemplateDraft = z;
    }

    private java.lang.String formatFileSize(long j) {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.00");
        if (j == 0) {
            return "0B";
        }
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        }
        if (j < 1048576) {
            return decimalFormat.format(j / 1024.0d) + "KB";
        }
        if (j < 1073741824) {
            return decimalFormat.format(j / 1048576.0d) + "MB";
        }
        return decimalFormat.format(j / 1.073741824E9d) + "GB";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.svideosdk.editor.draft.AliyunDraftManager getAliyunDraftManager(android.content.Context context) {
        return this.isTemplateDraft ? com.aliyun.svideosdk.editor.draft.AliyunTemplateDraftManager.getInstance(context) : com.aliyun.svideosdk.editor.draft.AliyunDraftManager.getInstance(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCloudDraftFragment(android.content.Context context) {
        if (context instanceof com.aliyun.svideo.editor.draft.DraftListActivity) {
            for (androidx.fragment.app.Fragment fragment : ((com.aliyun.svideo.editor.draft.DraftListActivity) context).getSupportFragmentManager().getFragments()) {
                if (fragment instanceof com.aliyun.svideo.editor.draft.CloudDraftFragment) {
                    ((com.aliyun.svideo.editor.draft.CloudDraftFragment) fragment).loadData();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadDraftConfig(com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog, java.lang.String str, android.content.Context context, com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, java.lang.String str2, java.lang.String str3, int i) {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart(com.aliyun.auth.common.AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER, str3);
        requestParams.addFormDataPart("file", new java.io.File(str2));
        requestParams.addFormDataPart("name", aliyunDraft.getName());
        requestParams.addFormDataPart(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_FILE_SIZE, aliyunDraft.getFileSize());
        requestParams.addFormDataPart("duration", aliyunDraft.getDuration());
        requestParams.addFormDataPart("modified_time", str);
        com.aliyun.common.qupaiokhttp.HttpRequest.post(com.aliyun.svideo.editor.draft.DraftListActivity.SERVER_ADD_PROJECT_URL, requestParams, new com.aliyun.svideo.editor.draft.LocalDraftAdapter.AnonymousClass5(alivcCircleLoadingDialog, context, aliyunDraft, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFile(android.content.Context context, java.lang.String str, java.util.List<com.aliyun.svideosdk.editor.draft.AliyunDraftResTask> list) {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart("file", new java.io.File(str));
        com.aliyun.common.qupaiokhttp.HttpRequest.post(com.aliyun.svideo.editor.draft.DraftListActivity.SERVER_UPLOAD_URL, requestParams, new com.aliyun.svideo.editor.draft.LocalDraftAdapter.AnonymousClass4(list, context, str));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.editor.draft.LocalDraftAdapter.DraftViewHolder draftViewHolder, int i) {
        com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft = this.mData.get(i);
        draftViewHolder.tvTitle.setText(aliyunDraft.getName());
        draftViewHolder.itemView.setTag(draftViewHolder);
        draftViewHolder.itemView.setOnClickListener(this);
        draftViewHolder.ivMore.setTag(draftViewHolder);
        draftViewHolder.ivMore.setOnClickListener(this);
        draftViewHolder.tvDuration.setText(com.aliyun.svideo.common.utils.DateTimeUtils.formatMs(aliyunDraft.getDuration()));
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
        draftViewHolder.tvUpdate.setText(((java.lang.Object) draftViewHolder.tvUpdate.getContext().getText(com.aliyun.svideo.editor.R.string.alivc_svideo_draft_update_tips)) + " " + simpleDateFormat.format(new java.util.Date(aliyunDraft.getUpdateTime())));
        draftViewHolder.tvSize.setText(formatFileSize(aliyunDraft.getFileSize()));
        new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(draftViewHolder.ivCover.getContext(), aliyunDraft.getCoverPath(), new com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder().skipDiskCacheCache().skipMemoryCache().build()).into(draftViewHolder.ivCover);
        draftViewHolder.ivBackup.setVisibility(com.aliyun.common.utils.StringUtils.isEmpty(aliyunDraft.getProjectId()) ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        int adapterPosition = ((com.aliyun.svideo.editor.draft.LocalDraftAdapter.DraftViewHolder) view.getTag()).getAdapterPosition();
        com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft = this.mData.get(adapterPosition);
        int id = view.getId();
        if (id == com.aliyun.svideo.editor.R.id.iv_more) {
            ((com.aliyun.svideo.editor.draft.DraftListActivity) view.getContext()).showMenu(this.isTemplateDraft, this, view.getTag());
        } else if (id == com.aliyun.svideo.editor.R.id.alivc_rename_btn) {
            ((com.aliyun.svideo.editor.draft.DraftListActivity) view.getContext()).showRenameDialog(aliyunDraft.getName(), new com.aliyun.svideo.editor.draft.LocalDraftAdapter.AnonymousClass1(aliyunDraft, view));
        } else if (id == com.aliyun.svideo.editor.R.id.alivc_update_cover_btn) {
            ((com.aliyun.svideo.editor.draft.DraftListActivity) view.getContext()).updateCover(this, aliyunDraft);
        } else if (id == com.aliyun.svideo.editor.R.id.alivc_copy_btn) {
            this.mData.add(adapterPosition, getAliyunDraftManager(view.getContext()).copy(aliyunDraft.getId()));
            notifyDataSetChanged();
        } else if (id == com.aliyun.svideo.editor.R.id.alivc_delete_btn) {
            getAliyunDraftManager(view.getContext()).deleteDraft(aliyunDraft.getId());
            this.mData.remove(aliyunDraft);
            notifyDataSetChanged();
            if (!com.aliyun.common.utils.StringUtils.isEmpty(aliyunDraft.getProjectId())) {
                notifyCloudDraftFragment(view.getContext());
            }
        } else if (id == com.aliyun.svideo.editor.R.id.alivc_backup_btn) {
            uploadDraft(view.getContext(), aliyunDraft, adapterPosition);
        } else {
            android.content.Context context = view.getContext();
            com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog = new com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog(context, 0);
            alivcCircleLoadingDialog.show();
            getAliyunDraftManager(view.getContext()).preLoadDraft(aliyunDraft, new com.aliyun.svideo.editor.draft.LocalDraftAdapter.AnonymousClass2(context, aliyunDraft, alivcCircleLoadingDialog, view));
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.editor.draft.LocalDraftAdapter.DraftViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.draft.LocalDraftAdapter.DraftViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_draft_item, viewGroup, false));
    }

    public void setData(java.util.List<com.aliyun.svideosdk.editor.draft.AliyunDraft> list) {
        this.mData.clear();
        this.mData.addAll(list);
        notifyDataSetChanged();
    }

    public void uploadDraft(android.content.Context context, com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, int i) {
        com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog = new com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog(context, 0);
        alivcCircleLoadingDialog.show();
        com.aliyun.svideosdk.editor.draft.AliyunDraftManager.getInstance(context).uploadDraft(aliyunDraft, new com.aliyun.svideo.editor.draft.LocalDraftAdapter.AnonymousClass3(context, aliyunDraft, alivcCircleLoadingDialog, i));
    }
}
