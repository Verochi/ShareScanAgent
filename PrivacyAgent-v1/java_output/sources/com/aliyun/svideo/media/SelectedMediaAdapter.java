package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class SelectedMediaAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.media.SelectedMediaViewHolder> {
    private long mCurrDuration;
    private java.util.List<com.aliyun.svideo.media.MediaInfo> mDataList = new java.util.ArrayList();
    private com.aliyun.svideo.media.MediaImageLoader mImageLoader;
    private com.aliyun.svideo.media.SelectedMediaAdapter.OnItemViewCallback mItemViewCallback;
    private long mMaxDuration;

    /* renamed from: com.aliyun.svideo.media.SelectedMediaAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.media.SelectedMediaViewHolder.OnItemCallback {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.media.SelectedMediaViewHolder.OnItemCallback
        public void onItemDelete(com.aliyun.svideo.media.SelectedMediaViewHolder selectedMediaViewHolder, int i) {
            if (i >= com.aliyun.svideo.media.SelectedMediaAdapter.this.mDataList.size() || i < 0) {
                return;
            }
            if (com.aliyun.svideo.media.SelectedMediaAdapter.this.mItemViewCallback != null) {
                com.aliyun.svideo.media.SelectedMediaAdapter.this.mItemViewCallback.onItemDeleteClick((com.aliyun.svideo.media.MediaInfo) com.aliyun.svideo.media.SelectedMediaAdapter.this.mDataList.get(i));
            }
            com.aliyun.svideo.media.SelectedMediaAdapter.this.removeIndex(i);
        }

        @Override // com.aliyun.svideo.media.SelectedMediaViewHolder.OnItemCallback
        public void onPhotoClick(com.aliyun.svideo.media.SelectedMediaViewHolder selectedMediaViewHolder, int i) {
            if (i >= com.aliyun.svideo.media.SelectedMediaAdapter.this.mDataList.size() || i < 0 || com.aliyun.svideo.media.SelectedMediaAdapter.this.mItemViewCallback == null) {
                return;
            }
            com.aliyun.svideo.media.SelectedMediaAdapter.this.mItemViewCallback.onItemPhotoClick((com.aliyun.svideo.media.MediaInfo) com.aliyun.svideo.media.SelectedMediaAdapter.this.mDataList.get(i), i);
        }
    }

    public interface OnItemViewCallback {
        void onDurationChange(long j, boolean z);

        void onItemDeleteClick(com.aliyun.svideo.media.MediaInfo mediaInfo);

        void onItemPhotoClick(com.aliyun.svideo.media.MediaInfo mediaInfo, int i);
    }

    public SelectedMediaAdapter(com.aliyun.svideo.media.MediaImageLoader mediaImageLoader, long j) {
        this.mImageLoader = mediaImageLoader;
        this.mMaxDuration = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeIndex(int i) {
        com.aliyun.svideo.media.MediaInfo mediaInfo;
        if (i >= this.mDataList.size() || i < 0 || (mediaInfo = this.mDataList.get(i)) == null) {
            return;
        }
        this.mCurrDuration -= mediaInfo.duration;
        this.mDataList.remove(i);
        notifyDataSetChanged();
        com.aliyun.svideo.media.SelectedMediaAdapter.OnItemViewCallback onItemViewCallback = this.mItemViewCallback;
        if (onItemViewCallback != null) {
            long j = this.mCurrDuration;
            if (j > this.mMaxDuration) {
                onItemViewCallback.onDurationChange(j, true);
            } else {
                onItemViewCallback.onDurationChange(j, false);
            }
        }
    }

    public void addMedia(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        this.mDataList.add(mediaInfo);
        notifyDataSetChanged();
        long j = this.mCurrDuration + mediaInfo.duration;
        this.mCurrDuration = j;
        com.aliyun.svideo.media.SelectedMediaAdapter.OnItemViewCallback onItemViewCallback = this.mItemViewCallback;
        if (onItemViewCallback != null) {
            if (j > this.mMaxDuration) {
                onItemViewCallback.onDurationChange(j, true);
            } else {
                onItemViewCallback.onDurationChange(j, false);
            }
        }
    }

    public void addOnlyFirstMedia(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        long j = mediaInfo.duration;
        this.mCurrDuration = j;
        com.aliyun.svideo.media.SelectedMediaAdapter.OnItemViewCallback onItemViewCallback = this.mItemViewCallback;
        if (onItemViewCallback != null) {
            if (j > this.mMaxDuration) {
                onItemViewCallback.onDurationChange(j, true);
            } else {
                onItemViewCallback.onDurationChange(j, false);
            }
        }
        if (this.mDataList.size() > 0) {
            this.mDataList.clear();
            this.mDataList.add(mediaInfo);
        } else {
            this.mDataList.add(mediaInfo);
        }
        notifyDataSetChanged();
    }

    public void changeDurationPosition(int i, long j) {
        com.aliyun.svideo.media.MediaInfo mediaInfo;
        if (i >= this.mDataList.size() || i < 0 || (mediaInfo = this.mDataList.get(i)) == null) {
            return;
        }
        long j2 = (this.mCurrDuration - mediaInfo.duration) + j;
        this.mCurrDuration = j2;
        com.aliyun.svideo.media.SelectedMediaAdapter.OnItemViewCallback onItemViewCallback = this.mItemViewCallback;
        if (onItemViewCallback != null) {
            if (j2 > this.mMaxDuration) {
                onItemViewCallback.onDurationChange(j2, true);
            } else {
                onItemViewCallback.onDurationChange(j2, false);
            }
        }
        notifyItemChanged(i);
    }

    public boolean contains(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        return this.mDataList.contains(mediaInfo);
    }

    public java.util.List<com.aliyun.svideo.media.MediaInfo> getAdapterData() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<com.aliyun.svideo.media.MediaInfo> list = this.mDataList;
        if (list != null && list.size() > 0) {
            arrayList.addAll(this.mDataList);
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        java.util.List<com.aliyun.svideo.media.MediaInfo> list = this.mDataList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public com.aliyun.svideo.media.MediaInfo getOnlyOneMedia() {
        java.util.List<com.aliyun.svideo.media.MediaInfo> list = this.mDataList;
        com.aliyun.svideo.media.MediaInfo mediaInfo = null;
        if (list != null && list.size() > 0) {
            java.util.Iterator<com.aliyun.svideo.media.MediaInfo> it = this.mDataList.iterator();
            while (it.hasNext() && (mediaInfo = it.next()) == null) {
            }
        }
        return mediaInfo;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.media.SelectedMediaViewHolder selectedMediaViewHolder, int i) {
        com.aliyun.svideo.media.MediaInfo mediaInfo;
        java.util.List<com.aliyun.svideo.media.MediaInfo> list = this.mDataList;
        if (list == null || i >= list.size() || (mediaInfo = this.mDataList.get(i)) == null) {
            return;
        }
        selectedMediaViewHolder.updateData(i, mediaInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.media.SelectedMediaViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        android.view.View inflate = android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.media.R.layout.alivc_media_item_video_selected, viewGroup, false);
        com.aliyun.svideo.media.SelectedMediaViewHolder selectedMediaViewHolder = new com.aliyun.svideo.media.SelectedMediaViewHolder(inflate, (android.widget.ImageView) inflate.findViewById(com.aliyun.svideo.media.R.id.iv_photo), (android.widget.ImageView) inflate.findViewById(com.aliyun.svideo.media.R.id.iv_delete), (android.widget.TextView) inflate.findViewById(com.aliyun.svideo.media.R.id.tv_duration), this.mImageLoader);
        selectedMediaViewHolder.setCallback(new com.aliyun.svideo.media.SelectedMediaAdapter.AnonymousClass1());
        return selectedMediaViewHolder;
    }

    public void setItemViewCallback(com.aliyun.svideo.media.SelectedMediaAdapter.OnItemViewCallback onItemViewCallback) {
        this.mItemViewCallback = onItemViewCallback;
    }

    public void swap(int i, int i2) {
        java.util.Collections.swap(this.mDataList, i, i2);
        notifyItemMoved(i, i2);
    }

    public void swap(com.aliyun.svideo.media.SelectedMediaViewHolder selectedMediaViewHolder, com.aliyun.svideo.media.SelectedMediaViewHolder selectedMediaViewHolder2) {
        int adapterPosition = selectedMediaViewHolder.getAdapterPosition();
        int adapterPosition2 = selectedMediaViewHolder2.getAdapterPosition();
        java.util.Collections.swap(this.mDataList, adapterPosition, adapterPosition2);
        selectedMediaViewHolder.updatePosition(adapterPosition2);
        selectedMediaViewHolder2.updatePosition(adapterPosition);
        notifyItemMoved(adapterPosition, adapterPosition2);
    }
}
