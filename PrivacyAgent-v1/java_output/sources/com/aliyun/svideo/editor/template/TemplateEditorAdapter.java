package com.aliyun.svideo.editor.template;

/* loaded from: classes12.dex */
public class TemplateEditorAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.editor.template.TemplateEditorAdapter.TemplateEditorViewHolder> implements android.view.View.OnClickListener {
    private com.aliyun.svideo.editor.template.TemplateEditorAdapter.OnItemClickCallback mOnItemClickCallback;
    private java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> mData = new java.util.ArrayList();
    private java.lang.String mSelectNode = "";

    public interface OnItemClickCallback {
        void onEdit(com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam);

        void onSelect(com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam);
    }

    public static class TemplateEditorViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public android.widget.ImageView ivCover;
        public android.widget.ImageView ivLock;
        public android.view.View layoutItem;
        public android.widget.TextView tvDuration;
        public android.widget.TextView tvEdit;
        public android.widget.TextView tvIndex;

        public TemplateEditorViewHolder(android.view.View view) {
            super(view);
            this.layoutItem = view.findViewById(com.aliyun.svideo.editor.R.id.layout_item);
            this.ivCover = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_cover);
            this.tvDuration = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_duration);
            this.tvEdit = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_edit);
            this.ivLock = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_lock);
            this.tvIndex = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_index);
        }
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> getData() {
        return this.mData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.editor.template.TemplateEditorAdapter.TemplateEditorViewHolder templateEditorViewHolder, @android.annotation.SuppressLint({"RecyclerView"}) int i) {
        com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam = this.mData.get(i);
        if (this.mSelectNode.equals(aliyunTemplateParam.getNodeKey())) {
            templateEditorViewHolder.tvDuration.setVisibility(8);
            templateEditorViewHolder.tvEdit.setVisibility(0);
        } else {
            java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.##");
            templateEditorViewHolder.tvDuration.setText(decimalFormat.format(aliyunTemplateParam.getTimelineOut() - aliyunTemplateParam.getTimelineIn()) + androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH);
            templateEditorViewHolder.tvDuration.setVisibility(0);
            templateEditorViewHolder.tvEdit.setVisibility(8);
        }
        if (aliyunTemplateParam.isLock()) {
            templateEditorViewHolder.ivLock.setVisibility(0);
        } else {
            templateEditorViewHolder.ivLock.setVisibility(8);
        }
        templateEditorViewHolder.tvIndex.setText(java.lang.String.valueOf(i + 1));
        if (aliyunTemplateParam instanceof com.aliyun.svideosdk.common.struct.template.AliyunTemplateImageParam) {
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(templateEditorViewHolder.ivCover.getContext(), ((com.aliyun.svideosdk.common.struct.template.AliyunTemplateImageParam) aliyunTemplateParam).getSource().getPath()).into(templateEditorViewHolder.ivCover);
        } else if (aliyunTemplateParam instanceof com.aliyun.svideosdk.common.struct.template.AliyunTemplateTextParam) {
            templateEditorViewHolder.ivCover.setImageResource(com.aliyun.svideo.editor.R.color.alivc_edit_template_item_bg);
            templateEditorViewHolder.tvDuration.setText(((com.aliyun.svideosdk.common.struct.template.AliyunTemplateTextParam) aliyunTemplateParam).getText());
        }
        templateEditorViewHolder.layoutItem.setTag(templateEditorViewHolder);
        templateEditorViewHolder.layoutItem.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (view.getId() == com.aliyun.svideo.editor.R.id.layout_item) {
            com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam = this.mData.get(((com.aliyun.svideo.editor.template.TemplateEditorAdapter.TemplateEditorViewHolder) view.getTag()).getAdapterPosition());
            if (!this.mSelectNode.equals(aliyunTemplateParam.getNodeKey())) {
                this.mSelectNode = aliyunTemplateParam.getNodeKey();
                com.aliyun.svideo.editor.template.TemplateEditorAdapter.OnItemClickCallback onItemClickCallback = this.mOnItemClickCallback;
                if (onItemClickCallback != null) {
                    onItemClickCallback.onSelect(aliyunTemplateParam);
                }
                notifyDataSetChanged();
            } else if (this.mOnItemClickCallback != null && !aliyunTemplateParam.isLock()) {
                this.mOnItemClickCallback.onEdit(aliyunTemplateParam);
            }
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.editor.template.TemplateEditorAdapter.TemplateEditorViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.template.TemplateEditorAdapter.TemplateEditorViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_template_editor_item, viewGroup, false));
    }

    public void setData(java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> list) {
        this.mData.clear();
        this.mData.addAll(list);
        notifyDataSetChanged();
    }

    public void setOnItemClickCallback(com.aliyun.svideo.editor.template.TemplateEditorAdapter.OnItemClickCallback onItemClickCallback) {
        this.mOnItemClickCallback = onItemClickCallback;
    }
}
