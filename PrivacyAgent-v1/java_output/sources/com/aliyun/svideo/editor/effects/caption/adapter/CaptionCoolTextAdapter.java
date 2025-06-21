package com.aliyun.svideo.editor.effects.caption.adapter;

/* loaded from: classes12.dex */
public class CaptionCoolTextAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private java.util.List<java.lang.String> mFontEffectList;
    private com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener mOnCaptionChooserStateChangeListener;
    private int mCurrentSelectIndex = 0;
    private final com.aliyun.svideo.common.utils.image.ImageLoaderImpl imageLoader = new com.aliyun.svideo.common.utils.image.ImageLoaderImpl();

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.CaptionCoolTextAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ java.lang.String val$dir;
        final /* synthetic */ int val$finalPosition;

        public AnonymousClass1(int i, java.lang.String str) {
            this.val$finalPosition = i;
            this.val$dir = str;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionCoolTextAdapter.this.notifySelectedView(this.val$finalPosition) && com.aliyun.svideo.editor.effects.caption.adapter.CaptionCoolTextAdapter.this.mOnCaptionChooserStateChangeListener != null) {
                com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(this.val$dir);
                if (!com.aliyun.common.utils.StringUtils.isEmpty(this.val$dir)) {
                    java.lang.String path = source.getPath();
                    java.lang.String str = java.io.File.separator;
                    if (path.contains(str)) {
                        java.lang.String str2 = this.val$dir;
                        source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getAppResUri(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_CAPTION, str2.substring(str2.lastIndexOf(str) + 1)));
                    }
                }
                com.aliyun.svideo.editor.effects.caption.adapter.CaptionCoolTextAdapter.this.mOnCaptionChooserStateChangeListener.onFontEffectTemplateChanged(source);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class CaptionViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.ImageView mImage;
        android.view.View selectedview;

        public CaptionViewHolder(android.view.View view) {
            super(view);
            this.mImage = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_image_view);
            this.selectedview = view.findViewById(com.aliyun.svideo.editor.R.id.selected_view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifySelectedView(int i) {
        int i2 = this.mCurrentSelectIndex;
        if (i == i2) {
            return false;
        }
        this.mCurrentSelectIndex = i;
        notifyItemChanged(i2);
        notifyItemChanged(this.mCurrentSelectIndex);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        java.util.List<java.lang.String> list = this.mFontEffectList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionCoolTextAdapter.CaptionViewHolder captionViewHolder = (com.aliyun.svideo.editor.effects.caption.adapter.CaptionCoolTextAdapter.CaptionViewHolder) viewHolder;
        int adapterPosition = captionViewHolder.getAdapterPosition();
        java.lang.String str = this.mFontEffectList.get(adapterPosition);
        if (str == null) {
            this.imageLoader.loadImage(captionViewHolder.mImage.getContext().getApplicationContext(), com.aliyun.svideo.editor.R.mipmap.alivc_svideo_caption_style_clear).into(captionViewHolder.mImage);
        } else {
            this.imageLoader.loadImage(captionViewHolder.mImage.getContext().getApplicationContext(), str + java.io.File.separator + com.aliyun.svideo.editor.contant.CaptionConfig.COOL_TEXT_FILE_ICON_NAME).into(captionViewHolder.mImage);
        }
        if (adapterPosition == this.mCurrentSelectIndex) {
            captionViewHolder.selectedview.setVisibility(0);
        } else {
            captionViewHolder.selectedview.setVisibility(8);
        }
        captionViewHolder.itemView.setOnClickListener(new com.aliyun.svideo.editor.effects.caption.adapter.CaptionCoolTextAdapter.AnonymousClass1(adapterPosition, str));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.caption.adapter.CaptionCoolTextAdapter.CaptionViewHolder(i == 0 ? android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_bubble_index_item_paster, viewGroup, false) : android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_bubble_item_paster, viewGroup, false));
    }

    public void setData(java.util.List<java.lang.String> list) {
        if (list == null) {
            return;
        }
        this.mFontEffectList = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        this.mOnCaptionChooserStateChangeListener = onCaptionChooserStateChangeListener;
    }

    public void setSelectPosition(int i) {
        java.util.List<java.lang.String> list = this.mFontEffectList;
        if (list == null || list.size() <= i) {
            return;
        }
        notifySelectedView(i);
    }
}
