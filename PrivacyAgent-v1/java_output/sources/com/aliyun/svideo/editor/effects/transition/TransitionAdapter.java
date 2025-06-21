package com.aliyun.svideo.editor.effects.transition;

/* loaded from: classes12.dex */
public class TransitionAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.effects.transition.TransitionAdapter";
    private android.content.Context mContext;
    private com.aliyun.svideo.editor.effects.transition.TransitionAdapter.OnSelectListener mOnSelectListener;
    private com.aliyun.svideo.editor.effects.transition.TransitionEffectCache mTransitionCache;
    private java.util.ArrayList<java.lang.Long> mStartTimes = new java.util.ArrayList<>();
    private int mSelectPosition = -1;
    private com.aliyun.svideosdk.common.AliyunIThumbnailFetcher mThumbnailFetcher = com.aliyun.svideosdk.common.impl.AliyunThumbnailFetcherFactory.createThumbnailFetcher();

    /* renamed from: com.aliyun.svideo.editor.effects.transition.TransitionAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion {
        final /* synthetic */ androidx.recyclerview.widget.RecyclerView.ViewHolder val$holder;

        public AnonymousClass1(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
            this.val$holder = viewHolder;
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onError(int i) {
            java.lang.String unused = com.aliyun.svideo.editor.effects.transition.TransitionAdapter.TAG;
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onThumbnailReady(android.graphics.Bitmap bitmap, long j, int i) {
            ((com.aliyun.svideo.editor.effects.transition.TransitionAdapter.TransitionViewHolder) this.val$holder).mThumbnail.setImageBitmap(bitmap);
        }
    }

    public interface OnSelectListener {
        void onSelect(android.widget.ImageView imageView, int i, boolean z);
    }

    public class TransitionViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.ImageView mThumbnail;
        android.widget.ImageView mTransition;

        /* renamed from: com.aliyun.svideo.editor.effects.transition.TransitionAdapter$TransitionViewHolder$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.editor.effects.transition.TransitionAdapter val$this$0;

            public AnonymousClass1(com.aliyun.svideo.editor.effects.transition.TransitionAdapter transitionAdapter) {
                this.val$this$0 = transitionAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                com.aliyun.svideo.editor.effects.transition.TransitionAdapter.TransitionViewHolder transitionViewHolder = com.aliyun.svideo.editor.effects.transition.TransitionAdapter.TransitionViewHolder.this;
                com.aliyun.svideo.editor.effects.transition.TransitionAdapter.this.mSelectPosition = transitionViewHolder.getAdapterPosition();
                if (com.aliyun.svideo.editor.effects.transition.TransitionAdapter.this.mOnSelectListener != null) {
                    com.aliyun.svideo.editor.effects.transition.TransitionAdapter.OnSelectListener onSelectListener = com.aliyun.svideo.editor.effects.transition.TransitionAdapter.this.mOnSelectListener;
                    com.aliyun.svideo.editor.effects.transition.TransitionAdapter.TransitionViewHolder transitionViewHolder2 = com.aliyun.svideo.editor.effects.transition.TransitionAdapter.TransitionViewHolder.this;
                    onSelectListener.onSelect(transitionViewHolder2.mTransition, com.aliyun.svideo.editor.effects.transition.TransitionAdapter.this.mSelectPosition, true);
                }
                com.aliyun.svideo.editor.effects.transition.TransitionAdapter.this.notifyDataSetChanged();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public TransitionViewHolder(android.view.View view) {
            super(view);
            this.mThumbnail = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_thumbnail);
            android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_transition);
            this.mTransition = imageView;
            imageView.setOnClickListener(new com.aliyun.svideo.editor.effects.transition.TransitionAdapter.TransitionViewHolder.AnonymousClass1(com.aliyun.svideo.editor.effects.transition.TransitionAdapter.this));
        }
    }

    public TransitionAdapter(android.content.Context context, com.aliyun.svideo.editor.effects.transition.TransitionEffectCache transitionEffectCache) {
        this.mContext = context;
        this.mTransitionCache = transitionEffectCache;
        long j = 0;
        for (com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip : this.mTransitionCache.getAliyunSourcePartManager().getAllClips()) {
            if (aliyunClip.getMediaType() == com.aliyun.svideosdk.common.struct.common.MediaType.ANY_IMAGE_TYPE) {
                this.mThumbnailFetcher.addImageSource(aliyunClip.getSource(), 100L, 0L);
            } else if (aliyunClip.getMediaType() == com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE) {
                this.mThumbnailFetcher.addVideoSource(aliyunClip.getSource(), 0L, 100L, 0L);
            }
            this.mStartTimes.add(java.lang.Long.valueOf(j));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("startTime is ");
            sb.append(j);
            j = this.mThumbnailFetcher.getTotalDuration();
        }
        this.mThumbnailFetcher.setParameters((int) context.getResources().getDimension(com.aliyun.svideo.editor.R.dimen.alivc_svideo_effect_transition_thumb_width), (int) context.getResources().getDimension(com.aliyun.svideo.editor.R.dimen.alivc_svideo_effect_transition_thumb_height), com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.CropMode.Mediate, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mTransitionCache.getCount();
    }

    public int getSelectPosition() {
        return this.mSelectPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.transition.TransitionAdapter.TransitionViewHolder transitionViewHolder = (com.aliyun.svideo.editor.effects.transition.TransitionAdapter.TransitionViewHolder) viewHolder;
        long[] jArr = {this.mStartTimes.get(i).longValue() + 1};
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("request time is ");
        sb.append(jArr[0]);
        if (i == 0) {
            int dip2px = com.aliyun.common.utils.DensityUtil.dip2px(this.mContext, 15.0f);
            viewHolder.itemView.setPadding(dip2px, dip2px, dip2px, dip2px);
        }
        this.mThumbnailFetcher.requestThumbnailImage(jArr, new com.aliyun.svideo.editor.effects.transition.TransitionAdapter.AnonymousClass1(viewHolder));
        if (i < this.mTransitionCache.getCount() - 1) {
            transitionViewHolder.mTransition.setVisibility(0);
        } else {
            transitionViewHolder.mTransition.setVisibility(8);
        }
        com.aliyun.svideo.editor.effects.transition.TransitionAdapter.OnSelectListener onSelectListener = this.mOnSelectListener;
        if (onSelectListener != null) {
            onSelectListener.onSelect(transitionViewHolder.mTransition, i, this.mSelectPosition == -1);
            if (this.mSelectPosition == -1) {
                this.mSelectPosition = 0;
            }
        }
        if (this.mSelectPosition == i) {
            transitionViewHolder.mTransition.setSelected(true);
        } else {
            transitionViewHolder.mTransition.setSelected(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i, java.util.List<java.lang.Object> list) {
        if (list == null || list.size() == 0) {
            super.onBindViewHolder(viewHolder, i, list);
            return;
        }
        com.aliyun.svideo.editor.effects.transition.TransitionAdapter.TransitionViewHolder transitionViewHolder = (com.aliyun.svideo.editor.effects.transition.TransitionAdapter.TransitionViewHolder) viewHolder;
        java.util.Iterator<java.lang.Object> it = list.iterator();
        while (it.hasNext()) {
            if (com.aliyun.svideo.editor.effects.transition.TransitionChooserView.TRANSITION_PAYLOAD.equals(it.next())) {
                this.mOnSelectListener.onSelect(transitionViewHolder.mTransition, i, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.transition.TransitionAdapter.TransitionViewHolder(((com.aliyun.svideo.editor.editor.EditorActivity) this.mContext).getLayoutInflater().inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_transition, (android.view.ViewGroup) null));
    }

    public void release() {
        this.mThumbnailFetcher.release();
    }

    public void setOnSelectListener(com.aliyun.svideo.editor.effects.transition.TransitionAdapter.OnSelectListener onSelectListener) {
        this.mOnSelectListener = onSelectListener;
    }
}
