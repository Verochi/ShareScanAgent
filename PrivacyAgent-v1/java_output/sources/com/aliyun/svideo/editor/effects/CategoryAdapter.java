package com.aliyun.svideo.editor.effects;

/* loaded from: classes12.dex */
public class CategoryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements android.view.View.OnClickListener {
    private static final int VIEW_TYPE_SELECTED = 1;
    private static final int VIEW_TYPE_UNSELECTED = 2;
    private android.content.Context mContext;
    private boolean mIsShowFontCategory;
    private com.aliyun.svideo.editor.effects.control.OnItemClickListener mItemClick;
    private com.aliyun.svideo.editor.effects.CategoryAdapter.OnMoreClickListener mMoreClickListener;
    private java.util.ArrayList<com.aliyun.svideo.base.Form.ResourceForm> data = new java.util.ArrayList<>();
    private int mSelectedPosition = 0;

    public static class CategoryViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        com.aliyun.svideo.base.widget.CircularImageView mImage;
        android.widget.TextView mName;

        public CategoryViewHolder(android.view.View view) {
            super(view);
            this.mImage = (com.aliyun.svideo.base.widget.CircularImageView) view.findViewById(com.aliyun.svideo.editor.R.id.category_image_source);
            this.mName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_category_name_source);
        }
    }

    public interface OnMoreClickListener {
        void onMoreClick();
    }

    public CategoryAdapter(android.content.Context context) {
        this.mContext = context;
    }

    public void addShowFontCategory() {
        this.mIsShowFontCategory = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size() - 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == this.mSelectedPosition ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.CategoryAdapter.CategoryViewHolder categoryViewHolder = (com.aliyun.svideo.editor.effects.CategoryAdapter.CategoryViewHolder) viewHolder;
        com.aliyun.svideo.base.Form.ResourceForm resourceForm = this.data.get(i);
        int itemViewType = getItemViewType(i);
        if (i == 0 && this.mIsShowFontCategory) {
            categoryViewHolder.mName.setVisibility(0);
            categoryViewHolder.mImage.setVisibility(8);
            categoryViewHolder.mName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_system_font);
        } else if (!resourceForm.isMore()) {
            categoryViewHolder.mImage.setVisibility(8);
            categoryViewHolder.mName.setVisibility(0);
            java.lang.String name = resourceForm.getName();
            if (!com.aliyun.svideo.common.utils.LanguageUtils.isCHEN(this.mContext) && resourceForm.getNameEn() != null) {
                name = resourceForm.getNameEn();
            }
            categoryViewHolder.mName.setText(name);
        }
        categoryViewHolder.itemView.setTag(viewHolder);
        categoryViewHolder.itemView.setOnClickListener(this);
        if (itemViewType == 1) {
            categoryViewHolder.itemView.setSelected(true);
        } else {
            if (itemViewType != 2) {
                return;
            }
            categoryViewHolder.itemView.setSelected(false);
        }
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.aliyun.svideo.editor.effects.CategoryAdapter.CategoryViewHolder categoryViewHolder = (com.aliyun.svideo.editor.effects.CategoryAdapter.CategoryViewHolder) view.getTag();
        if (!this.data.get(categoryViewHolder.getAdapterPosition()).isMore() && this.mItemClick != null) {
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
            effectInfo.isCategory = true;
            int i = this.mSelectedPosition;
            this.mSelectedPosition = categoryViewHolder.getAdapterPosition();
            notifyItemChanged(i);
            notifyItemChanged(this.mSelectedPosition);
            this.mItemClick.onItemClick(effectInfo, categoryViewHolder.getAdapterPosition());
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.CategoryAdapter.CategoryViewHolder(android.view.LayoutInflater.from(this.mContext).inflate(com.aliyun.svideo.editor.R.layout.moji_editor_item_category, viewGroup, false));
    }

    public void selectPosition(int i) {
        int i2 = this.mSelectedPosition;
        this.mSelectedPosition = i;
        notifyItemChanged(i);
        notifyItemChanged(i2);
    }

    public void setData(java.util.ArrayList<com.aliyun.svideo.base.Form.ResourceForm> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.data = arrayList;
        if (this.mIsShowFontCategory) {
            this.data.add(0, new com.aliyun.svideo.base.Form.ResourceForm());
        }
        notifyDataSetChanged();
    }

    public void setMoreClickListener(com.aliyun.svideo.editor.effects.CategoryAdapter.OnMoreClickListener onMoreClickListener) {
        this.mMoreClickListener = onMoreClickListener;
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.control.OnItemClickListener onItemClickListener) {
        this.mItemClick = onItemClickListener;
    }
}
