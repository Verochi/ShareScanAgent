package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class GalleryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements android.view.View.OnClickListener {
    private static final int TYPE_ITEM_MEDIA = 1;
    private java.util.List<com.aliyun.svideo.media.MediaInfo> medias;
    private com.aliyun.svideo.media.GalleryAdapter.OnItemClickListener onItemClickListener;
    private com.aliyun.svideo.media.ThumbnailGenerator thumbnailGenerator;
    private long mMinDuration = -1;
    private int activeAdapterPosition = 0;

    public interface OnItemClickListener {
        boolean onItemClick(com.aliyun.svideo.media.GalleryAdapter galleryAdapter, int i);
    }

    public GalleryAdapter(com.aliyun.svideo.media.ThumbnailGenerator thumbnailGenerator) {
        this.thumbnailGenerator = thumbnailGenerator;
    }

    private void setActiveAdapterItem(int i) {
        if (this.activeAdapterPosition == i) {
            return;
        }
        this.activeAdapterPosition = i;
        notifyItemChanged(i);
    }

    public int findDataPosition(int i) {
        for (int i2 = 0; i2 < this.medias.size(); i2++) {
            if (this.medias.get(i2).id == i) {
                return i2;
            }
        }
        return -1;
    }

    public int getActiveAdapterPosition() {
        return this.activeAdapterPosition;
    }

    public com.aliyun.svideo.media.MediaInfo getItem(int i) {
        if (this.medias.size() <= 0 || i < 0) {
            return null;
        }
        return this.medias.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.medias.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ((com.aliyun.svideo.media.GalleryItemViewHolder) viewHolder).onBind(getItem(i), this.activeAdapterPosition == i, this.mMinDuration);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        int adapterPosition = ((androidx.recyclerview.widget.RecyclerView.ViewHolder) view.getTag()).getAdapterPosition();
        if (this.mMinDuration != -1) {
            if (this.medias.get(adapterPosition).type == 0 && r1.duration < this.mMinDuration) {
                android.widget.Toast.makeText(view.getContext(), com.aliyun.svideo.media.R.string.alivc_media_video_short_error, 0).show();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
        }
        com.aliyun.svideo.media.GalleryAdapter.OnItemClickListener onItemClickListener = this.onItemClickListener;
        if (onItemClickListener != null && !onItemClickListener.onItemClick(this, adapterPosition)) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            setActiveAdapterItem(adapterPosition);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        com.aliyun.svideo.media.GalleryItemViewHolder galleryItemViewHolder = new com.aliyun.svideo.media.GalleryItemViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.media.R.layout.alivc_media_item_gallery_media, viewGroup, false), this.thumbnailGenerator);
        galleryItemViewHolder.itemView.setOnClickListener(this);
        return galleryItemViewHolder;
    }

    public int setActiveDataItem(int i) {
        int findDataPosition = findDataPosition(i);
        setActiveAdapterItem(findDataPosition);
        return findDataPosition;
    }

    public int setActiveDataItem(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        return setActiveDataItem(mediaInfo == null ? -1 : mediaInfo.id);
    }

    public void setData(java.util.List<com.aliyun.svideo.media.MediaInfo> list) {
        this.medias = list;
        notifyDataSetChanged();
    }

    public void setMinDuration(long j) {
        this.mMinDuration = j;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(com.aliyun.svideo.media.GalleryAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
