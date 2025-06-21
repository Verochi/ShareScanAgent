package com.aliyun.svideo.editor.template;

/* loaded from: classes12.dex */
public class TemplateInputAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.editor.template.TemplateInputAdapter.TemplateInputViewHolder> implements android.view.View.OnClickListener {
    private java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> mData = new java.util.ArrayList();

    /* renamed from: com.aliyun.svideo.editor.template.TemplateInputAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam val$item;
        final /* synthetic */ int val$position;

        public AnonymousClass1(com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam, int i) {
            this.val$item = aliyunTemplateParam;
            this.val$position = i;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
            this.val$item.setLock(!z);
            com.aliyun.svideo.editor.template.TemplateInputAdapter.this.notifyItemChanged(this.val$position);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }
    }

    public static class TemplateInputViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public android.widget.CheckBox cbItem;
        public android.widget.ImageView ivCover;
        public android.widget.TextView tvDuration;
        public android.widget.TextView tvIndex;

        public TemplateInputViewHolder(android.view.View view) {
            super(view);
            this.ivCover = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_cover);
            this.tvDuration = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_duration);
            this.cbItem = (android.widget.CheckBox) view.findViewById(com.aliyun.svideo.editor.R.id.cb_item);
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
    public void onBindViewHolder(com.aliyun.svideo.editor.template.TemplateInputAdapter.TemplateInputViewHolder templateInputViewHolder, @android.annotation.SuppressLint({"RecyclerView"}) int i) {
        com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam = this.mData.get(i);
        templateInputViewHolder.cbItem.setOnCheckedChangeListener(null);
        templateInputViewHolder.cbItem.setChecked(!aliyunTemplateParam.isLock());
        templateInputViewHolder.cbItem.setOnCheckedChangeListener(new com.aliyun.svideo.editor.template.TemplateInputAdapter.AnonymousClass1(aliyunTemplateParam, i));
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.##");
        templateInputViewHolder.tvDuration.setText(decimalFormat.format(aliyunTemplateParam.getTimelineOut() - aliyunTemplateParam.getTimelineIn()) + androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH);
        templateInputViewHolder.tvIndex.setText(java.lang.String.valueOf(i + 1));
        if (aliyunTemplateParam instanceof com.aliyun.svideosdk.common.struct.template.AliyunTemplateImageParam) {
            templateInputViewHolder.ivCover.setVisibility(0);
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(templateInputViewHolder.ivCover.getContext(), ((com.aliyun.svideosdk.common.struct.template.AliyunTemplateImageParam) aliyunTemplateParam).getSource().getPath()).into(templateInputViewHolder.ivCover);
        } else if (aliyunTemplateParam instanceof com.aliyun.svideosdk.common.struct.template.AliyunTemplateTextParam) {
            templateInputViewHolder.ivCover.setImageResource(com.aliyun.svideo.editor.R.color.alivc_edit_template_item_bg);
            templateInputViewHolder.tvDuration.setText(((com.aliyun.svideosdk.common.struct.template.AliyunTemplateTextParam) aliyunTemplateParam).getText());
        }
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        this.mData.get(((com.aliyun.svideo.editor.template.TemplateInputAdapter.TemplateInputViewHolder) view.getTag()).getAdapterPosition());
        view.getId();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.editor.template.TemplateInputAdapter.TemplateInputViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.template.TemplateInputAdapter.TemplateInputViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_template_input_item, viewGroup, false));
    }

    public void setData(java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> list) {
        this.mData.clear();
        this.mData.addAll(list);
        notifyDataSetChanged();
    }
}
