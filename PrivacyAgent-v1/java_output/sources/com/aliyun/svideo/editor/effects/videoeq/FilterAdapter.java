package com.aliyun.svideo.editor.effects.videoeq;

/* loaded from: classes12.dex */
public class FilterAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements android.view.View.OnClickListener {
    private static final int[] ICONS = {com.aliyun.svideo.editor.R.drawable.alivc_svideo_augmentation_brightness, com.aliyun.svideo.editor.R.drawable.alivc_svideo_augmentation_contrast, com.aliyun.svideo.editor.R.drawable.alivc_svideo_augmentation_saturation, com.aliyun.svideo.editor.R.drawable.alivc_svideo_augmentation_sharpness, com.aliyun.svideo.editor.R.drawable.alivc_svideo_augmentation_vignette};
    private android.content.Context mContext;
    private com.aliyun.svideo.editor.effects.videoeq.FilterAdapter.OnItemClickListener mItemClick;
    private com.aliyun.svideo.editor.effects.videoeq.FilterAdapter.FilterViewHolder mSelectedHolder;
    private int mSelectedPos = 0;
    private java.util.List<java.lang.String> mNameList = new java.util.ArrayList();

    public static class FilterViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.FrameLayout frameLayout;
        com.aliyun.svideo.base.widget.CircularImageView mImage;
        android.widget.TextView mName;

        public FilterViewHolder(android.view.View view) {
            super(view);
            this.mImage = (com.aliyun.svideo.base.widget.CircularImageView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_image_view);
            this.mName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_name);
        }
    }

    public interface OnItemClickListener {
        boolean onItemClick(com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType videoAugmentationType, int i);
    }

    public FilterAdapter(android.content.Context context) {
        this.mContext = context;
    }

    private com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType getEqType(int i) {
        if (i == 1) {
            return com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.BRIGHTNESS;
        }
        if (i == 2) {
            return com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.CONTRAST;
        }
        if (i == 3) {
            return com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.SATURATION;
        }
        if (i == 4) {
            return com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.SHARPNESS;
        }
        if (i != 5) {
            return null;
        }
        return com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.VIGNETTE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mNameList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.videoeq.FilterAdapter.FilterViewHolder filterViewHolder = (com.aliyun.svideo.editor.effects.videoeq.FilterAdapter.FilterViewHolder) viewHolder;
        java.lang.String string = this.mContext.getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_reset);
        java.lang.String str = this.mNameList.get(i);
        if (str == null || "".equals(str)) {
            filterViewHolder.mImage.setImageResource(com.aliyun.svideo.editor.R.drawable.alivc_svideo_effect_none);
        } else {
            if (filterViewHolder != null) {
                filterViewHolder.mImage.setImageResource(ICONS[i - 1]);
            }
            string = str;
        }
        if (this.mSelectedPos > this.mNameList.size()) {
            this.mSelectedPos = 0;
        }
        if (this.mSelectedPos == i) {
            filterViewHolder.mImage.setBackgroundResource(com.aliyun.svideo.editor.R.drawable.alivc_svideo_augmentation_select);
            this.mSelectedHolder = filterViewHolder;
        } else {
            filterViewHolder.mImage.setBackgroundResource(com.aliyun.svideo.editor.R.drawable.alivc_svideo_augmentation_default);
        }
        filterViewHolder.mName.setText(string);
        filterViewHolder.itemView.setTag(viewHolder);
        filterViewHolder.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.aliyun.svideo.editor.effects.videoeq.FilterAdapter.FilterViewHolder filterViewHolder;
        int adapterPosition;
        com.aliyun.svideo.base.widget.CircularImageView circularImageView;
        if (this.mItemClick != null && this.mSelectedPos != (adapterPosition = (filterViewHolder = (com.aliyun.svideo.editor.effects.videoeq.FilterAdapter.FilterViewHolder) view.getTag()).getAdapterPosition())) {
            com.aliyun.svideo.editor.effects.videoeq.FilterAdapter.FilterViewHolder filterViewHolder2 = this.mSelectedHolder;
            if (filterViewHolder2 != null && (circularImageView = filterViewHolder2.mImage) != null) {
                circularImageView.setBackgroundResource(com.aliyun.svideo.editor.R.drawable.alivc_svideo_augmentation_default);
            }
            filterViewHolder.mImage.setBackgroundResource(com.aliyun.svideo.editor.R.drawable.alivc_svideo_augmentation_select);
            this.mSelectedPos = adapterPosition;
            this.mSelectedHolder = filterViewHolder;
            this.mItemClick.onItemClick(getEqType(adapterPosition), adapterPosition);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        android.view.View inflate = android.view.LayoutInflater.from(this.mContext).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_effect, viewGroup, false);
        com.aliyun.svideo.editor.effects.videoeq.FilterAdapter.FilterViewHolder filterViewHolder = new com.aliyun.svideo.editor.effects.videoeq.FilterAdapter.FilterViewHolder(inflate);
        filterViewHolder.frameLayout = (android.widget.FrameLayout) inflate.findViewById(com.aliyun.svideo.editor.R.id.resource_image);
        return filterViewHolder;
    }

    public void setDataList(java.util.List<java.lang.String> list) {
        this.mNameList.clear();
        this.mNameList.add(null);
        this.mNameList.addAll(list);
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.videoeq.FilterAdapter.OnItemClickListener onItemClickListener) {
        this.mItemClick = onItemClickListener;
    }

    public void setSelectedPos(int i) {
        this.mSelectedPos = i;
    }
}
