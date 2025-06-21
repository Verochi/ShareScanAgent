package com.aliyun.svideo.editor.template;

/* loaded from: classes12.dex */
public class TemplateAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.editor.template.TemplateAdapter.TemplateViewHolder> implements android.view.View.OnClickListener {
    private java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplate> mData = new java.util.ArrayList();

    /* renamed from: com.aliyun.svideo.editor.template.TemplateAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.template.TemplateManager.ExportCallback {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog val$dialog;

        public AnonymousClass1(com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog, android.content.Context context) {
            this.val$dialog = alivcCircleLoadingDialog;
            this.val$context = context;
        }

        @Override // com.aliyun.svideo.editor.template.TemplateManager.ExportCallback
        public void onFailure(java.lang.String str) {
            this.val$dialog.dismiss();
            android.widget.Toast.makeText(this.val$context, com.aliyun.svideo.editor.R.string.alivc_editor_template_list_export_failed, 0).show();
        }

        @Override // com.aliyun.svideo.editor.template.TemplateManager.ExportCallback
        public void onSuccess(java.lang.String str) {
            this.val$dialog.dismiss();
            android.widget.Toast.makeText(this.val$context, ((java.lang.Object) this.val$context.getText(com.aliyun.svideo.editor.R.string.alivc_editor_template_list_export_success)) + "：" + str, 0).show();
        }
    }

    public static class TemplateViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public android.widget.ImageView ivCover;
        public android.widget.ImageView ivMore;
        public android.widget.TextView tvTitle;

        public TemplateViewHolder(android.view.View view) {
            super(view);
            this.ivCover = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_cover);
            this.tvTitle = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_title);
            this.ivMore = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_more);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.editor.template.TemplateAdapter.TemplateViewHolder templateViewHolder, int i) {
        com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate = this.mData.get(i);
        templateViewHolder.tvTitle.setText(aliyunTemplate.getTitle());
        templateViewHolder.ivMore.setTag(templateViewHolder);
        templateViewHolder.ivMore.setOnClickListener(this);
        templateViewHolder.itemView.setTag(templateViewHolder);
        templateViewHolder.itemView.setOnClickListener(this);
        new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(templateViewHolder.ivCover.getContext(), aliyunTemplate.getCover().getPath(), new com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder().skipDiskCacheCache().skipMemoryCache().build()).into(templateViewHolder.ivCover);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.aliyun.svideo.editor.template.TemplateAdapter.TemplateViewHolder templateViewHolder = (com.aliyun.svideo.editor.template.TemplateAdapter.TemplateViewHolder) view.getTag();
        com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate = this.mData.get(templateViewHolder.getAdapterPosition());
        if (view.getId() == com.aliyun.svideo.editor.R.id.iv_more) {
            ((com.aliyun.svideo.editor.template.TemplateListActivity) view.getContext()).showMenu(this, templateViewHolder);
        } else if (view.getId() == com.aliyun.svideo.editor.R.id.alivc_export_btn) {
            android.content.Context context = view.getContext();
            com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog alivcCircleLoadingDialog = new com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog(context, 0);
            alivcCircleLoadingDialog.show();
            com.aliyun.svideo.editor.template.TemplateManager.getInstance(context).exportTemplateZip(aliyunTemplate, new com.aliyun.svideo.editor.template.TemplateAdapter.AnonymousClass1(alivcCircleLoadingDialog, context));
        } else if (view.getId() == com.aliyun.svideo.editor.R.id.alivc_delete_btn) {
            java.io.File file = new java.io.File(aliyunTemplate.getPath());
            if (file.exists()) {
                com.aliyun.common.utils.FileUtils.deleteDirectory(file.getParentFile());
            }
            this.mData.remove(aliyunTemplate);
            notifyDataSetChanged();
        } else {
            android.content.Intent intent = new android.content.Intent(view.getContext(), (java.lang.Class<?>) com.aliyun.svideo.editor.template.TemplateMediaActivity.class);
            intent.putExtra(com.aliyun.svideo.editor.template.TemplateMediaActivity.TEMPLATE_PATH, aliyunTemplate.getPath());
            ((com.aliyun.svideo.editor.template.TemplateListActivity) view.getContext()).startActivityForResult(intent, com.aliyun.svideo.editor.template.TemplateListActivity.MEDIA_REQUEST_CODE);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.editor.template.TemplateAdapter.TemplateViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.template.TemplateAdapter.TemplateViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_template_item, viewGroup, false));
    }

    public void setData(java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplate> list) {
        this.mData.clear();
        this.mData.addAll(list);
        notifyDataSetChanged();
    }
}
