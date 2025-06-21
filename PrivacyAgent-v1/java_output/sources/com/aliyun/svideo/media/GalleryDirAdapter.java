package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class GalleryDirAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements android.view.View.OnClickListener {
    private int allFileCount;
    private java.util.List<com.aliyun.svideo.media.MediaDir> mediaDirs;
    private com.aliyun.svideo.media.GalleryDirAdapter.OnItemClickListener onItemClickListener;
    private com.aliyun.svideo.media.ThumbnailGenerator thumbnailGenerator;

    public interface OnItemClickListener {
        boolean onItemClick(com.aliyun.svideo.media.GalleryDirAdapter galleryDirAdapter, int i);
    }

    public GalleryDirAdapter(com.aliyun.svideo.media.ThumbnailGenerator thumbnailGenerator) {
        this.thumbnailGenerator = thumbnailGenerator;
    }

    public com.aliyun.svideo.media.MediaDir getItem(int i) {
        return this.mediaDirs.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mediaDirs.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.media.GalleryDirViewHolder galleryDirViewHolder = (com.aliyun.svideo.media.GalleryDirViewHolder) viewHolder;
        galleryDirViewHolder.setData(getItem(i));
        if (i == 0) {
            galleryDirViewHolder.setFileCountWhenCompletion(this.allFileCount);
        }
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        int adapterPosition = ((androidx.recyclerview.widget.RecyclerView.ViewHolder) view.getTag()).getAdapterPosition();
        if (this.onItemClickListener != null) {
            if (adapterPosition == -1) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            this.onItemClickListener.onItemClick(this, adapterPosition);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        com.aliyun.svideo.media.GalleryDirViewHolder galleryDirViewHolder = new com.aliyun.svideo.media.GalleryDirViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.media.R.layout.alivc_media_item_gallery_dir, (android.view.ViewGroup) null, false), this.thumbnailGenerator);
        galleryDirViewHolder.itemView.setOnClickListener(this);
        return galleryDirViewHolder;
    }

    public void setAllFileCount(int i) {
        this.allFileCount = i;
        notifyItemChanged(0);
    }

    public void setData(java.util.List<com.aliyun.svideo.media.MediaDir> list) {
        this.mediaDirs = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(com.aliyun.svideo.media.GalleryDirAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
