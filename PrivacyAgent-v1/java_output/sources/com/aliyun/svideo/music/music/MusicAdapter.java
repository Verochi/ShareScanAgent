package com.aliyun.svideo.music.music;

/* loaded from: classes12.dex */
public class MusicAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter {
    private static final java.lang.String TAG = "MusicAdapter";
    private static final int VIEW_TYPE_DOWNLOADING = 3;
    private static final int VIEW_TYPE_LOCAL = 1;
    private static final int VIEW_TYPE_NO = 0;
    private static final int VIEW_TYPE_REMOTE = 2;
    private int mCachePosition;
    private int mCacheStartTime;
    private int[] mScrollX;
    private com.aliyun.svideo.music.music.MusicAdapter.OnMusicSeek onMusicSeek;
    private java.util.List<com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean>> dataList = new java.util.ArrayList();
    private int mStreamDuration = 10000;
    private int mSelectIndex = 0;
    private java.util.ArrayList<com.aliyun.svideo.base.http.MusicFileBean> mLoadingMusic = new java.util.ArrayList<>();

    /* renamed from: com.aliyun.svideo.music.music.MusicAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.music.widget.MusicHorizontalScrollView.ScrollViewListener {
        final /* synthetic */ androidx.recyclerview.widget.RecyclerView.ViewHolder val$holder;
        final /* synthetic */ com.aliyun.svideo.base.http.MusicFileBean val$musicFileBean;
        final /* synthetic */ int val$position;

        public AnonymousClass1(int i, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, com.aliyun.svideo.base.http.MusicFileBean musicFileBean) {
            this.val$position = i;
            this.val$holder = viewHolder;
            this.val$musicFileBean = musicFileBean;
        }

        @Override // com.aliyun.svideo.music.widget.MusicHorizontalScrollView.ScrollViewListener
        public void onScrollChanged(android.widget.HorizontalScrollView horizontalScrollView, int i, int i2, int i3, int i4) {
            if (this.val$position < com.aliyun.svideo.music.music.MusicAdapter.this.mScrollX.length) {
                com.aliyun.svideo.music.music.MusicAdapter.this.mScrollX[this.val$position] = i;
                com.aliyun.svideo.music.music.MusicAdapter.this.setDurationTxt((com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder) this.val$holder, i, this.val$musicFileBean.duration);
            }
        }

        @Override // com.aliyun.svideo.music.widget.MusicHorizontalScrollView.ScrollViewListener
        public void onScrollStop() {
            if (com.aliyun.svideo.music.music.MusicAdapter.this.onMusicSeek == null || this.val$position >= com.aliyun.svideo.music.music.MusicAdapter.this.mScrollX.length) {
                return;
            }
            com.aliyun.svideo.music.music.MusicAdapter.this.onMusicSeek.onSeekStop((int) ((com.aliyun.svideo.music.music.MusicAdapter.this.mScrollX[this.val$position] / ((com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder) this.val$holder).musicWave.getMusicLayoutWidth()) * this.val$musicFileBean.duration));
        }
    }

    /* renamed from: com.aliyun.svideo.music.music.MusicAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ androidx.recyclerview.widget.RecyclerView.ViewHolder val$holder;
        final /* synthetic */ int val$position;

        public AnonymousClass2(int i, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
            this.val$position = i;
            this.val$holder = viewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$position < com.aliyun.svideo.music.music.MusicAdapter.this.mScrollX.length) {
                ((com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder) this.val$holder).scrollBar.scrollTo(com.aliyun.svideo.music.music.MusicAdapter.this.mScrollX[this.val$position], 0);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.music.music.MusicAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ androidx.recyclerview.widget.RecyclerView.ViewHolder val$holder;
        final /* synthetic */ int val$position;

        public AnonymousClass3(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
            this.val$holder = viewHolder;
            this.val$position = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder) this.val$holder).scrollBar.scrollTo(com.aliyun.svideo.music.music.MusicAdapter.this.mScrollX[this.val$position], 0);
            java.lang.String unused = com.aliyun.svideo.music.music.MusicAdapter.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("position : ");
            sb.append(this.val$position);
            sb.append(" ,scrollBar.scrollTo : ");
            sb.append(com.aliyun.svideo.music.music.MusicAdapter.this.mScrollX[this.val$position]);
        }
    }

    public class MusicViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private com.aliyun.svideo.music.widget.CircleProgressBar downloadProgress;
        private com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean> mData;
        public android.widget.ImageView mLocalIcon;
        private int mPosition;
        public android.widget.TextView musicEndTxt;
        public android.widget.LinearLayout musicInfoLayout;
        public android.widget.TextView musicName;
        public android.widget.LinearLayout musicNameLayout;
        public android.widget.TextView musicSinger;
        public android.widget.TextView musicStartTxt;
        public com.aliyun.svideo.music.widget.MusicWaveView musicWave;
        public com.aliyun.svideo.music.widget.MusicHorizontalScrollView scrollBar;

        /* renamed from: com.aliyun.svideo.music.music.MusicAdapter$MusicViewHolder$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.music.music.MusicAdapter val$this$0;

            public AnonymousClass1(com.aliyun.svideo.music.music.MusicAdapter musicAdapter) {
                this.val$this$0 = musicAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                if (com.aliyun.svideo.music.music.MusicAdapter.this.mSelectIndex != com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder.this.mPosition) {
                    if (com.aliyun.svideo.music.music.MusicAdapter.this.onMusicSeek != null) {
                        com.aliyun.svideo.music.music.MusicAdapter.this.onMusicSeek.onSelectMusic(com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder.this.mPosition, com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder.this.mData);
                    }
                    com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder musicViewHolder = com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder.this;
                    com.aliyun.svideo.music.music.MusicAdapter.this.mSelectIndex = musicViewHolder.mPosition;
                    if (com.aliyun.svideo.music.music.MusicAdapter.this.mSelectIndex < com.aliyun.svideo.music.music.MusicAdapter.this.mScrollX.length) {
                        com.aliyun.svideo.music.music.MusicAdapter.this.mScrollX[com.aliyun.svideo.music.music.MusicAdapter.this.mSelectIndex] = 0;
                        com.aliyun.svideo.music.music.MusicAdapter.this.notifyDataSetChanged();
                    }
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public MusicViewHolder(android.view.View view) {
            super(view);
            this.musicName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.music.R.id.aliyun_music_name);
            this.musicSinger = (android.widget.TextView) view.findViewById(com.aliyun.svideo.music.R.id.aliyun_music_artist);
            this.musicWave = (com.aliyun.svideo.music.widget.MusicWaveView) view.findViewById(com.aliyun.svideo.music.R.id.aliyun_wave_view);
            this.musicInfoLayout = (android.widget.LinearLayout) view.findViewById(com.aliyun.svideo.music.R.id.aliyun_music_info_layout);
            this.musicNameLayout = (android.widget.LinearLayout) view.findViewById(com.aliyun.svideo.music.R.id.aliyun_music_name_layout);
            this.scrollBar = (com.aliyun.svideo.music.widget.MusicHorizontalScrollView) view.findViewById(com.aliyun.svideo.music.R.id.aliyun_scroll_bar);
            this.musicStartTxt = (android.widget.TextView) view.findViewById(com.aliyun.svideo.music.R.id.aliyun_music_start_txt);
            this.musicEndTxt = (android.widget.TextView) view.findViewById(com.aliyun.svideo.music.R.id.aliyun_music_end_txt);
            this.mLocalIcon = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.music.R.id.alivc_record_local_iv);
            com.aliyun.svideo.music.widget.CircleProgressBar circleProgressBar = (com.aliyun.svideo.music.widget.CircleProgressBar) view.findViewById(com.aliyun.svideo.music.R.id.download_progress);
            this.downloadProgress = circleProgressBar;
            circleProgressBar.isFilled(true);
            com.aliyun.svideo.music.music.MusicAdapter.this.setDurationTxt(this, 0, 0);
            view.setOnClickListener(new com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder.AnonymousClass1(com.aliyun.svideo.music.music.MusicAdapter.this));
        }

        public void updateData(int i, com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean> effectBody) {
            this.mData = effectBody;
            this.mPosition = i;
            com.aliyun.svideo.base.http.MusicFileBean data = effectBody.getData();
            this.musicName.setText(data.title);
            java.lang.String str = data.artist;
            if (str == null || str.isEmpty()) {
                this.musicSinger.setVisibility(8);
                return;
            }
            this.musicSinger.setVisibility(0);
            this.musicSinger.setText("- " + data.artist);
        }
    }

    public interface OnItemClickListener {
        void onLocalItemClick(int i, com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideosdk.common.struct.form.IMVForm> effectBody);

        void onRemoteItemClick(int i, com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideosdk.common.struct.form.IMVForm> effectBody);
    }

    public interface OnMusicSeek {
        void onSeekStop(long j);

        void onSelectMusic(int i, com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean> effectBody);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationTxt(com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder musicViewHolder, int i, int i2) {
        int musicLayoutWidth = (int) ((i / musicViewHolder.musicWave.getMusicLayoutWidth()) * i2);
        int i3 = this.mStreamDuration + musicLayoutWidth;
        int i4 = musicLayoutWidth / 1000;
        musicViewHolder.musicStartTxt.setText(java.lang.String.format("%1$02d:%2$02d", java.lang.Integer.valueOf(i4 / 60), java.lang.Integer.valueOf(i4 % 60)));
        int i5 = i3 / 1000;
        musicViewHolder.musicEndTxt.setText(java.lang.String.format("%1$02d:%2$02d", java.lang.Integer.valueOf(i5 / 60), java.lang.Integer.valueOf(i5 % 60)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i <= 0 || i >= this.dataList.size()) {
            return 0;
        }
        com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean> effectBody = this.dataList.get(i);
        if (effectBody.isLocal()) {
            return 1;
        }
        return effectBody.isLoading() ? 3 : 2;
    }

    public int getSelectIndex() {
        return this.mSelectIndex;
    }

    public synchronized void notifyDownloadingComplete(com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder musicViewHolder, com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean> effectBody, int i) {
        effectBody.setLocal(true);
        effectBody.setLoading(false);
        this.mLoadingMusic.remove(effectBody.getData());
        notifyItemChanged(i);
        if (musicViewHolder != null && musicViewHolder.downloadProgress != null) {
            musicViewHolder.downloadProgress.setProgress(0);
        }
    }

    public void notifyDownloadingStart(com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean> effectBody) {
        if (this.mLoadingMusic.contains(effectBody.getData())) {
            return;
        }
        this.mLoadingMusic.add(effectBody.getData());
        effectBody.setLoading(true);
    }

    public void notifySelectPosition(int i, int i2) {
        this.mCacheStartTime = i;
        this.mCachePosition = i2;
        this.mSelectIndex = i2;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder musicViewHolder = (com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder) viewHolder;
        musicViewHolder.updateData(i, this.dataList.get(i));
        int itemViewType = getItemViewType(i);
        com.aliyun.svideo.base.http.MusicFileBean data = this.dataList.get(i).getData();
        if (itemViewType == 0) {
            musicViewHolder.musicName.setText(com.aliyun.svideo.music.R.string.alivc_music_empty_music);
            musicViewHolder.mLocalIcon.setVisibility(8);
            musicViewHolder.musicSinger.setVisibility(8);
            musicViewHolder.musicInfoLayout.setVisibility(8);
            musicViewHolder.scrollBar.setScrollViewListener(null);
            if (this.mSelectIndex == 0) {
                musicViewHolder.musicName.setSelected(true);
                musicViewHolder.musicSinger.setSelected(true);
                return;
            } else {
                musicViewHolder.musicName.setSelected(false);
                musicViewHolder.musicSinger.setSelected(false);
                return;
            }
        }
        if (itemViewType != 1) {
            if (itemViewType == 2) {
                musicViewHolder.mLocalIcon.setVisibility(8);
                musicViewHolder.downloadProgress.setVisibility(8);
                musicViewHolder.musicInfoLayout.setVisibility(8);
                musicViewHolder.scrollBar.setScrollViewListener(null);
                musicViewHolder.musicName.setSelected(false);
                musicViewHolder.musicSinger.setSelected(false);
                if (this.mSelectIndex == i) {
                    musicViewHolder.musicName.setSelected(true);
                    musicViewHolder.musicSinger.setSelected(true);
                    return;
                } else {
                    musicViewHolder.musicName.setSelected(false);
                    musicViewHolder.musicSinger.setSelected(false);
                    return;
                }
            }
            if (itemViewType != 3) {
                return;
            }
            musicViewHolder.mLocalIcon.setVisibility(8);
            musicViewHolder.downloadProgress.setVisibility(0);
            musicViewHolder.musicInfoLayout.setVisibility(8);
            musicViewHolder.scrollBar.setScrollViewListener(null);
            musicViewHolder.musicName.setSelected(false);
            musicViewHolder.musicSinger.setSelected(false);
            if (this.mSelectIndex == i) {
                musicViewHolder.musicName.setSelected(true);
                musicViewHolder.musicSinger.setSelected(true);
                return;
            } else {
                musicViewHolder.musicName.setSelected(false);
                musicViewHolder.musicSinger.setSelected(false);
                return;
            }
        }
        musicViewHolder.downloadProgress.setVisibility(8);
        if (i != this.mSelectIndex) {
            musicViewHolder.mLocalIcon.setVisibility(8);
            musicViewHolder.musicInfoLayout.setVisibility(8);
            musicViewHolder.scrollBar.setScrollViewListener(null);
            musicViewHolder.musicName.setSelected(false);
            musicViewHolder.musicSinger.setSelected(false);
            return;
        }
        musicViewHolder.mLocalIcon.setVisibility(0);
        musicViewHolder.musicName.setSelected(true);
        musicViewHolder.musicSinger.setSelected(true);
        musicViewHolder.musicName.setText(data.getTitle());
        java.lang.String str = data.artist;
        if (str == null || str.isEmpty()) {
            musicViewHolder.musicSinger.setVisibility(8);
        } else {
            musicViewHolder.musicSinger.setVisibility(0);
            musicViewHolder.musicSinger.setText(data.artist);
        }
        musicViewHolder.musicInfoLayout.setVisibility(0);
        musicViewHolder.musicWave.setDisplayTime(this.mStreamDuration);
        musicViewHolder.musicWave.setTotalTime(data.duration);
        musicViewHolder.musicWave.layout();
        musicViewHolder.musicWave.setVisibility(0);
        musicViewHolder.scrollBar.setScrollViewListener(new com.aliyun.svideo.music.music.MusicAdapter.AnonymousClass1(i, viewHolder, data));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("position : ");
        sb.append(i);
        sb.append(" ,mScrollX : ");
        sb.append(this.mScrollX[i]);
        if (i != 0 && this.mCachePosition == i && data.duration != 0) {
            this.mScrollX[i] = (this.mCacheStartTime * musicViewHolder.musicWave.getMusicLayoutWidth()) / data.duration;
            musicViewHolder.scrollBar.post(new com.aliyun.svideo.music.music.MusicAdapter.AnonymousClass2(i, viewHolder));
            return;
        }
        int[] iArr = this.mScrollX;
        if (iArr.length <= i || iArr[i] == 0) {
            musicViewHolder.scrollBar.scrollTo(0, 0);
        } else {
            musicViewHolder.scrollBar.post(new com.aliyun.svideo.music.music.MusicAdapter.AnonymousClass3(viewHolder, i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.music.R.layout.alivc_music_item_music, viewGroup, false));
    }

    public void setData(java.util.ArrayList<com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean>> arrayList, int i) {
        this.dataList.clear();
        this.dataList.addAll(arrayList);
        this.dataList.add(0, new com.aliyun.svideo.music.music.EffectBody<>(new com.aliyun.svideo.base.http.MusicFileBean(), true));
        this.mScrollX = new int[this.dataList.size()];
        this.mSelectIndex = i;
        com.aliyun.svideo.music.music.MusicAdapter.OnMusicSeek onMusicSeek = this.onMusicSeek;
        if (onMusicSeek != null) {
            onMusicSeek.onSelectMusic(i, this.dataList.get(i));
        }
        notifyDataSetChanged();
    }

    public void setOnMusicSeekListener(com.aliyun.svideo.music.music.MusicAdapter.OnMusicSeek onMusicSeek) {
        this.onMusicSeek = onMusicSeek;
    }

    public void setStreamDuration(int i) {
        this.mStreamDuration = i;
    }

    public void updateProcess(com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder musicViewHolder, int i, int i2) {
        if (musicViewHolder == null || musicViewHolder.mPosition != i2) {
            return;
        }
        musicViewHolder.mLocalIcon.setVisibility(8);
        musicViewHolder.downloadProgress.setVisibility(0);
        musicViewHolder.downloadProgress.setProgress(i);
    }
}
