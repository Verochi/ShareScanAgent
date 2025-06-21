package com.aliyun.svideo.editor.draft;

/* loaded from: classes12.dex */
public class CloudDraftAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.editor.draft.CloudDraftAdapter.DraftViewHolder> implements android.view.View.OnClickListener {
    private java.util.List<com.aliyun.svideo.editor.draft.CloudDraftItem> mData = new java.util.ArrayList();

    /* renamed from: com.aliyun.svideo.editor.draft.CloudDraftAdapter$1, reason: invalid class name */
    public class AnonymousClass1 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog val$dialog;
        final /* synthetic */ com.aliyun.svideo.editor.draft.CloudDraftItem val$item;

        public AnonymousClass1(com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog, com.aliyun.svideo.editor.draft.CloudDraftItem cloudDraftItem) {
            this.val$dialog = alivcCircleLoadingDialog;
            this.val$item = cloudDraftItem;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            this.val$dialog.dismiss();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("delete_project>onFailure>");
            sb.append(str);
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            this.val$dialog.dismiss();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("delete_project>onSuccess>");
            sb.append(str);
            try {
                if (((com.aliyun.svideo.editor.draft.CloudDeleteDraftResult) new com.google.gson.Gson().fromJson(str, com.aliyun.svideo.editor.draft.CloudDeleteDraftResult.class)).code == 0) {
                    com.aliyun.svideo.editor.draft.CloudDraftAdapter.this.mData.remove(this.val$item);
                    com.aliyun.svideo.editor.draft.CloudDraftAdapter.this.notifyDataSetChanged();
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.draft.CloudDraftAdapter$2, reason: invalid class name */
    public class AnonymousClass2 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog val$dialog;
        final /* synthetic */ com.aliyun.svideo.editor.draft.CloudDraftItem val$item;
        final /* synthetic */ int val$position;
        final /* synthetic */ android.view.View val$v;

        public AnonymousClass2(com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog, android.view.View view, com.aliyun.svideo.editor.draft.CloudDraftItem cloudDraftItem, int i) {
            this.val$dialog = alivcCircleLoadingDialog;
            this.val$v = view;
            this.val$item = cloudDraftItem;
            this.val$position = i;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            this.val$dialog.dismiss();
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            try {
                java.io.File file = new java.io.File(this.val$v.getContext().getExternalFilesDir("svideo_res/cloud_draft"), this.val$item.mProjectId + java.io.File.separator + com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.PROJECT_FILENAME);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
                com.aliyun.common.utils.FileUtils.writeStringToFile(file, str, "utf-8");
                com.aliyun.svideo.editor.draft.CloudDraftAdapter.this.downloadDraft(this.val$dialog, this.val$v.getContext(), file, this.val$item, this.val$position);
            } catch (java.lang.Exception unused) {
                this.val$dialog.dismiss();
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.draft.CloudDraftAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideosdk.editor.draft.AliyunDraftResourceDownloader {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog val$dialog;
        final /* synthetic */ com.aliyun.svideo.editor.draft.CloudDraftItem val$item;
        final /* synthetic */ int val$position;

        /* renamed from: com.aliyun.svideo.editor.draft.CloudDraftAdapter$3$1, reason: invalid class name */
        public class AnonymousClass1 implements com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback {
            final /* synthetic */ java.util.List val$list;
            final /* synthetic */ java.lang.String val$url;

            public AnonymousClass1(java.util.List list, java.lang.String str) {
                this.val$list = list;
                this.val$url = str;
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
                    if (aliyunDraftResTask.getResModuleType() == com.aliyun.svideosdk.editor.resource.AliyunResModuleType.MV) {
                        try {
                            source.setId(android.net.Uri.parse(this.val$url).getQueryParameter("gid"));
                        } catch (java.lang.Exception unused) {
                        }
                    }
                    aliyunDraftResTask.onHandleCallback(source);
                }
            }
        }

        /* renamed from: com.aliyun.svideo.editor.draft.CloudDraftAdapter$3$2, reason: invalid class name */
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

        public AnonymousClass3(android.content.Context context, com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog, com.aliyun.svideo.editor.draft.CloudDraftItem cloudDraftItem, int i) {
            this.val$context = context;
            this.val$dialog = alivcCircleLoadingDialog;
            this.val$item = cloudDraftItem;
            this.val$position = i;
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftResourceHandle
        public void onFailure(java.lang.String str) {
            this.val$dialog.dismiss();
            android.widget.Toast.makeText(this.val$context, com.aliyun.svideo.editor.R.string.alivc_svideo_draft_restore_failed, 0).show();
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftResourceDownloader
        public void onHandleResourceTasks(java.lang.String str, java.util.List<com.aliyun.svideosdk.editor.draft.AliyunDraftResTask> list) {
            java.util.HashMap hashMap = new java.util.HashMap();
            for (com.aliyun.svideosdk.editor.draft.AliyunDraftResTask aliyunDraftResTask : list) {
                if (aliyunDraftResTask.getSource() == null || com.aliyun.common.utils.StringUtils.isEmpty(aliyunDraftResTask.getSource().getURL())) {
                    aliyunDraftResTask.onIgnore();
                } else if (hashMap.containsKey(aliyunDraftResTask.getSource().getURL())) {
                    ((java.util.List) hashMap.get(aliyunDraftResTask.getSource().getURL())).add(aliyunDraftResTask);
                } else {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    arrayList.add(aliyunDraftResTask);
                    hashMap.put(aliyunDraftResTask.getSource().getURL(), arrayList);
                }
            }
            for (java.util.Map.Entry entry : hashMap.entrySet()) {
                java.util.List list2 = (java.util.List) entry.getValue();
                try {
                    java.lang.String str2 = (java.lang.String) entry.getKey();
                    if (str2.startsWith(com.aliyun.svideo.editor.util.AlivcResUtil.SCHEME)) {
                        com.aliyun.svideo.editor.util.AlivcResUtil.loadRes(this.val$context, str2, new com.aliyun.svideo.editor.draft.CloudDraftAdapter.AnonymousClass3.AnonymousClass1(list2, str2));
                    } else {
                        java.lang.String substring = str2.substring(str2.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + 1);
                        if (list2 != null && list2.size() > 0 && ((com.aliyun.svideosdk.editor.draft.AliyunDraftResTask) list2.get(0)).getResModuleType() == com.aliyun.svideosdk.editor.resource.AliyunResModuleType.COVER) {
                            substring = "cover.jpeg";
                        }
                        com.aliyun.svideo.editor.util.AlivcResUtil.downloadRes(str2, new java.io.File(str, substring).getAbsolutePath(), new com.aliyun.svideo.editor.draft.CloudDraftAdapter.AnonymousClass3.AnonymousClass2(list2));
                    }
                } catch (java.lang.Exception unused) {
                    java.util.Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        ((com.aliyun.svideosdk.editor.draft.AliyunDraftResTask) it.next()).onIgnore();
                    }
                }
            }
        }

        @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftResourceDownloader
        public void onSuccess(com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft) {
            this.val$dialog.dismiss();
            this.val$item.isDownload = true;
            com.aliyun.svideosdk.editor.draft.AliyunDraftManager.getInstance(this.val$context).setProjectId(aliyunDraft.getId(), this.val$item.mProjectId);
            android.widget.Toast.makeText(this.val$context, com.aliyun.svideo.editor.R.string.alivc_svideo_draft_restore_success, 0).show();
            com.aliyun.svideo.editor.draft.CloudDraftAdapter.this.notifyItemChanged(this.val$position);
            android.content.Context context = this.val$context;
            if (context instanceof com.aliyun.svideo.editor.draft.DraftListActivity) {
                for (androidx.fragment.app.Fragment fragment : ((com.aliyun.svideo.editor.draft.DraftListActivity) context).getSupportFragmentManager().getFragments()) {
                    if (fragment instanceof com.aliyun.svideo.editor.draft.LocalDraftFragment) {
                        ((com.aliyun.svideo.editor.draft.LocalDraftFragment) fragment).loadData();
                    }
                }
            }
        }
    }

    public static class DraftViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public android.widget.ImageView ivCover;
        public android.widget.ImageView ivDownload;
        public android.widget.ImageView ivMore;
        public android.widget.TextView tvDuration;
        public android.widget.TextView tvSize;
        public android.widget.TextView tvTitle;
        public android.widget.TextView tvUpdate;

        public DraftViewHolder(android.view.View view) {
            super(view);
            this.ivCover = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_cover);
            this.ivDownload = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_download);
            this.tvTitle = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_title);
            this.tvUpdate = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_update);
            this.tvSize = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_size);
            this.tvDuration = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_duration);
            this.ivMore = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_more);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadDraft(com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog, android.content.Context context, java.io.File file, com.aliyun.svideo.editor.draft.CloudDraftItem cloudDraftItem, int i) {
        com.aliyun.svideosdk.editor.draft.AliyunDraftManager.getInstance(context).downloadDraft(file, new com.aliyun.svideo.editor.draft.CloudDraftAdapter.AnonymousClass3(context, alivcCircleLoadingDialog, cloudDraftItem, i));
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.editor.draft.CloudDraftAdapter.DraftViewHolder draftViewHolder, int i) {
        com.aliyun.svideo.editor.draft.CloudDraftItem cloudDraftItem = this.mData.get(i);
        draftViewHolder.tvTitle.setText(cloudDraftItem.mName);
        draftViewHolder.itemView.setTag(draftViewHolder);
        draftViewHolder.itemView.setOnClickListener(this);
        draftViewHolder.ivMore.setTag(draftViewHolder);
        draftViewHolder.ivMore.setOnClickListener(this);
        draftViewHolder.ivDownload.setOnClickListener(this);
        draftViewHolder.ivDownload.setTag(draftViewHolder);
        draftViewHolder.tvDuration.setText(com.aliyun.svideo.common.utils.DateTimeUtils.formatMs(cloudDraftItem.mDuration));
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
        draftViewHolder.tvUpdate.setText(((java.lang.Object) draftViewHolder.tvUpdate.getContext().getText(com.aliyun.svideo.editor.R.string.alivc_svideo_draft_backup_tips)) + " " + simpleDateFormat.format(new java.util.Date(cloudDraftItem.mBackupTime * 1000)));
        draftViewHolder.tvSize.setText(formatFileSize(cloudDraftItem.mFileSize));
        new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(draftViewHolder.ivCover.getContext(), cloudDraftItem.mCoverPath).into(draftViewHolder.ivCover);
        draftViewHolder.ivDownload.setVisibility(cloudDraftItem.isDownload ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        int adapterPosition = ((com.aliyun.svideo.editor.draft.CloudDraftAdapter.DraftViewHolder) view.getTag()).getAdapterPosition();
        com.aliyun.svideo.editor.draft.CloudDraftItem cloudDraftItem = this.mData.get(adapterPosition);
        int id = view.getId();
        if (id == com.aliyun.svideo.editor.R.id.iv_more) {
            ((com.aliyun.svideo.editor.draft.DraftListActivity) view.getContext()).showCloudMenu(this, view.getTag());
        }
        if (id == com.aliyun.svideo.editor.R.id.alivc_delete_btn) {
            com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog = new com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog(view.getContext(), 0);
            alivcCircleLoadingDialog.show();
            com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("project_id", cloudDraftItem.mProjectId);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            requestParams.setCustomRequestBody(okhttp3.RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jSONObject.toString()));
            com.aliyun.common.qupaiokhttp.HttpRequest.post(com.aliyun.svideo.editor.draft.DraftListActivity.SERVER_DELETE_URL, requestParams, new com.aliyun.svideo.editor.draft.CloudDraftAdapter.AnonymousClass1(alivcCircleLoadingDialog, cloudDraftItem));
        } else if (id == com.aliyun.svideo.editor.R.id.iv_download) {
            com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog2 = new com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog(view.getContext(), 0);
            alivcCircleLoadingDialog2.show();
            com.aliyun.common.qupaiokhttp.HttpRequest.get(cloudDraftItem.mProjectUrl, new com.aliyun.svideo.editor.draft.CloudDraftAdapter.AnonymousClass2(alivcCircleLoadingDialog2, view, cloudDraftItem, adapterPosition));
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.editor.draft.CloudDraftAdapter.DraftViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.draft.CloudDraftAdapter.DraftViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_cloud_draft_item, viewGroup, false));
    }

    public void setData(java.util.List<com.aliyun.svideo.editor.draft.CloudDraftItem> list) {
        this.mData.clear();
        this.mData.addAll(list);
        notifyDataSetChanged();
    }
}
