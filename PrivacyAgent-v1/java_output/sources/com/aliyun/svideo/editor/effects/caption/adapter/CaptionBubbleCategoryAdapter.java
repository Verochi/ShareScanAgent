package com.aliyun.svideo.editor.effects.caption.adapter;

/* loaded from: classes12.dex */
public class CaptionBubbleCategoryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_SELECTED = 1;
    private static final int VIEW_TYPE_UNSELECTED = 2;
    private com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.OnItemClickListener mItemClick;
    private java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> mData = new java.util.ArrayList();
    private int mSelectedPosition = 0;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ androidx.recyclerview.widget.RecyclerView.ViewHolder val$holder;

        public AnonymousClass1(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
            this.val$holder = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            int adapterPosition = this.val$holder.getAdapterPosition();
            com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = (com.aliyun.svideo.downloader.FileDownloaderModel) com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.this.mData.get(adapterPosition);
            if (fileDownloaderModel == null) {
                if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.this.mItemClick != null) {
                    com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.this.mItemClick.onItemClick(fileDownloaderModel);
                }
            } else if (fileDownloaderModel.getCategory() == -1) {
                if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.this.mItemClick != null) {
                    com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.this.mItemClick.onMoreClick();
                }
            } else if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.this.mItemClick != null) {
                com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.this.mItemClick.onItemClick(fileDownloaderModel);
            }
            com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.this.selectPosition(adapterPosition);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class CategoryViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        com.aliyun.svideo.base.widget.CircularImageView mImage;
        android.widget.TextView mName;

        public CategoryViewHolder(android.view.View view) {
            super(view);
            this.mImage = (com.aliyun.svideo.base.widget.CircularImageView) view.findViewById(com.aliyun.svideo.editor.R.id.category_image_source);
            this.mName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_category_name_source);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel);

        void onMoreClick();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list = this.mData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == this.mSelectedPosition ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.CategoryViewHolder categoryViewHolder = (com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.CategoryViewHolder) viewHolder;
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = this.mData.get(i);
        int itemViewType = viewHolder.getItemViewType();
        if (fileDownloaderModel == null) {
            categoryViewHolder.mName.setVisibility(8);
            categoryViewHolder.mImage.setVisibility(0);
            categoryViewHolder.mImage.setImageResource(com.aliyun.svideo.editor.R.mipmap.alivc_svideo_caption_style_clear);
        } else if (fileDownloaderModel.getCategory() == -1) {
            categoryViewHolder.mName.setVisibility(8);
            categoryViewHolder.mImage.setVisibility(0);
            categoryViewHolder.mImage.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_more);
        } else {
            categoryViewHolder.mImage.setVisibility(8);
            categoryViewHolder.mName.setVisibility(0);
            java.lang.String name = fileDownloaderModel.getName();
            if (!com.aliyun.svideo.common.utils.LanguageUtils.isCHEN(categoryViewHolder.mName.getContext()) && fileDownloaderModel.getNameEn() != null) {
                name = fileDownloaderModel.getNameEn();
            }
            categoryViewHolder.mName.setText(name);
        }
        categoryViewHolder.itemView.setOnClickListener(new com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.AnonymousClass1(viewHolder));
        if (itemViewType == 1) {
            categoryViewHolder.itemView.setSelected(true);
        } else {
            if (itemViewType != 2) {
                return;
            }
            categoryViewHolder.itemView.setSelected(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.CategoryViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_category, viewGroup, false));
    }

    public void selectPosition(int i) {
        notifyItemChanged(this.mSelectedPosition);
        this.mSelectedPosition = i;
        notifyItemChanged(i);
    }

    public void setData(java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
        if (list == null) {
            return;
        }
        this.mData.clear();
        this.mData.addAll(list);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.OnItemClickListener onItemClickListener) {
        this.mItemClick = onItemClickListener;
    }
}
