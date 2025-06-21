package com.aliyun.svideo.editor.editor.thumblinebar;

/* loaded from: classes12.dex */
public class ThumbLineBar extends android.widget.FrameLayout {
    private static final java.lang.String KEY_DURATION = "duration";
    private static final java.lang.String KEY_NEED_CALLBACK = "need_callback";
    private static final java.lang.String KEY_RATE = "rate";
    private static java.lang.String TAG = "com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar";
    private static final int WHAT_THUMBNAIL_VIEW_AUTO_MOVE = 1;
    private static final int WHAT_TIMELINE_FINISH_SEEK = 3;
    private static final int WHAT_TIMELINE_ON_SEEK = 2;
    private com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.OnBarSeekListener mBarSeekListener;
    protected long mCurrDuration;
    private final java.lang.Object mCurrDurationLock;
    protected float mCurrScroll;
    protected long mDuration;
    private float mErrorDis;
    private int mIndicatorMargin;
    private boolean mIsTouching;
    protected com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener mLinePlayer;
    private com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.OnOperationEndListener mOnOperationEndListener;
    private com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.PlayThread mPlayThread;
    protected androidx.recyclerview.widget.RecyclerView mRecyclerView;
    protected int mScrollState;
    private final java.lang.Object mStateLock;
    protected com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineConfig mThumbLineConfig;
    private com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter mThumbRecyclerAdapter;
    protected float mTimelineBarViewWidth;
    private android.os.Handler mUIHandler;

    /* renamed from: com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            long j = message.getData().getLong("duration");
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mBarSeekListener.onThumbLineBarSeek(j);
                    return;
                } else {
                    if (i != 3) {
                        return;
                    }
                    com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mBarSeekListener.onThumbLineBarSeekFinish(j);
                    return;
                }
            }
            float f = message.getData().getFloat(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.KEY_RATE);
            boolean z = message.getData().getBoolean(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.KEY_NEED_CALLBACK);
            if (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mBarSeekListener != null && z && !com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mIsTouching) {
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mBarSeekListener.onThumbLineBarSeek(j);
            }
            com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.scroll(f);
            com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mLinePlayer.updateDuration(j);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnTouchListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            int actionMasked = androidx.core.view.MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 0) {
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mIsTouching = true;
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mIsTouching = false;
                if (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mOnOperationEndListener != null) {
                    com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mOnOperationEndListener.onEnd();
                }
            }
            return false;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
        public AnonymousClass3() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                android.os.Message obtainMessage = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mUIHandler.obtainMessage(3);
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putLong("duration", com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mCurrDuration);
                obtainMessage.setData(bundle);
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mUIHandler.sendMessage(obtainMessage);
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar thumbLineBar = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this;
                thumbLineBar.mLinePlayer.updateDuration(thumbLineBar.mCurrDuration);
                java.lang.String unused = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.TAG;
            } else if (i == 1) {
                java.lang.String unused2 = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.TAG;
            } else if (i == 2) {
                java.lang.String unused3 = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.TAG;
            }
            com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.onRecyclerViewScrollStateChanged(i);
            com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mScrollState = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar thumbLineBar = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this;
            float f = thumbLineBar.mCurrScroll + i;
            thumbLineBar.mCurrScroll = f;
            float timelineBarViewWidth = f / thumbLineBar.getTimelineBarViewWidth();
            long j = (long) (timelineBarViewWidth * r5.mDuration);
            if (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mBarSeekListener != null && (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mIsTouching || com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mScrollState == 2)) {
                android.os.Message obtainMessage = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mUIHandler.obtainMessage(2);
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putLong("duration", j);
                obtainMessage.setData(bundle);
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mUIHandler.sendMessage(obtainMessage);
            }
            com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar thumbLineBar2 = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this;
            thumbLineBar2.mCurrDuration = j;
            thumbLineBar2.mLinePlayer.updateDuration(j);
            com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.onRecyclerViewScroll(i, i2);
        }
    }

    public interface OnBarSeekListener {
        void onThumbLineBarSeek(long j);

        void onThumbLineBarSeekFinish(long j);
    }

    public interface OnOperationEndListener {
        void onEnd();
    }

    public class PlayThread extends java.lang.Thread {
        private static final byte STATE_PAUSING = 2;
        private static final byte STATE_PLAYING = 1;
        private static final byte STATE_STOPPING = 3;
        private long mLastDuration = -1;
        private volatile byte mState = 3;

        public PlayThread() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resumePlaying() {
            synchronized (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mStateLock) {
                this.mState = (byte) 1;
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mStateLock.notify();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startPlaying() {
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stopPlaying() {
            synchronized (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mStateLock) {
                this.mState = (byte) 3;
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mStateLock.notify();
            }
            try {
                join();
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
            com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mCurrDuration = 0L;
        }

        public void pause() {
            synchronized (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mStateLock) {
                if (this.mState == 1) {
                    this.mState = (byte) 2;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            synchronized (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mStateLock) {
                this.mState = (byte) 1;
                this.mLastDuration = -1L;
            }
            while (true) {
                synchronized (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mStateLock) {
                    if (this.mState == 2) {
                        try {
                            com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mStateLock.wait();
                            java.lang.String unused = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.TAG;
                        } catch (java.lang.InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (this.mState == 3) {
                        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mCurrDuration = 0L;
                        return;
                    }
                }
                synchronized (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mCurrDurationLock) {
                    com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar thumbLineBar = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this;
                    thumbLineBar.mCurrDuration = thumbLineBar.mLinePlayer.getCurrDuration();
                    java.lang.String unused2 = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.TAG;
                }
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar thumbLineBar2 = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this;
                long j = thumbLineBar2.mCurrDuration;
                if (j != this.mLastDuration) {
                    thumbLineBar2.seekTo(j, false);
                    this.mLastDuration = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.this.mCurrDuration;
                }
                try {
                    java.lang.Thread.sleep(50L);
                } catch (java.lang.InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public ThumbLineBar(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public ThumbLineBar(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThumbLineBar(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrDuration = 0L;
        this.mCurrDurationLock = new java.lang.Object();
        this.mIsTouching = false;
        this.mUIHandler = new com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.AnonymousClass1(android.os.Looper.getMainLooper());
        this.mStateLock = new java.lang.Object();
        initView();
    }

    private void initLayoutParams() {
        getLayoutParams().height = this.mThumbLineConfig.getThumbnailPoint().y + (this.mIndicatorMargin * 2);
    }

    private void initView() {
        int dp2px = com.moji.tool.DeviceTool.dp2px(3.0f);
        this.mIndicatorMargin = com.moji.tool.DeviceTool.dp2px(3.0f);
        this.mRecyclerView = new androidx.recyclerview.widget.RecyclerView(getContext());
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        int i = this.mIndicatorMargin;
        layoutParams.setMargins(0, i, 0, i);
        this.mRecyclerView.setLayoutParams(layoutParams);
        this.mRecyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        android.view.View cardView = new com.moji.cardView.CardView(getContext());
        cardView.setRadius(com.moji.tool.DeviceTool.dp2px(1.0f));
        cardView.setCardElevation(0.0f);
        cardView.setCardBackgroundColor(-12279556);
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(dp2px, -1);
        layoutParams2.gravity = 17;
        layoutParams2.leftMargin = com.moji.tool.DeviceTool.dp2px(1.5f);
        cardView.setLayoutParams(layoutParams2);
        addView(this.mRecyclerView);
        addView(cardView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scroll(float f) {
        float timelineBarViewWidth = (f * getTimelineBarViewWidth()) - this.mCurrScroll;
        float f2 = this.mErrorDis;
        if (f2 >= 1.0f) {
            timelineBarViewWidth += 1.0f;
            this.mErrorDis = f2 - 1.0f;
        }
        int i = (int) timelineBarViewWidth;
        this.mErrorDis = timelineBarViewWidth - i;
        this.mRecyclerView.scrollBy(i, 0);
    }

    private void setOnBarSeekListener(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.OnBarSeekListener onBarSeekListener) {
        this.mBarSeekListener = onBarSeekListener;
    }

    private void setThumbLinePlayer(com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener playerListener) {
        this.mLinePlayer = playerListener;
    }

    public float getTimelineBarViewWidth() {
        if (this.mRecyclerView.getAdapter() == null) {
            return 0.0f;
        }
        if (this.mTimelineBarViewWidth == 0.0f) {
            this.mTimelineBarViewWidth = this.mThumbLineConfig.getThumbnailCount() * this.mThumbLineConfig.getThumbnailPoint().x;
        }
        return this.mTimelineBarViewWidth;
    }

    public void hide() {
        setVisibility(8);
    }

    public boolean isScrolling() {
        return this.mScrollState != 0;
    }

    public boolean isTouching() {
        return this.mIsTouching;
    }

    public void onRecyclerViewScroll(int i, int i2) {
    }

    public void onRecyclerViewScrollStateChanged(int i) {
    }

    public void pause() {
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.PlayThread playThread = this.mPlayThread;
        if (playThread != null) {
            playThread.pause();
        }
    }

    public void restart() {
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.PlayThread playThread = this.mPlayThread;
        if (playThread == null || !playThread.isAlive()) {
            start();
        } else {
            this.mPlayThread.mLastDuration = -1L;
            this.mPlayThread.resumePlaying();
        }
    }

    public void resume() {
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.PlayThread playThread = this.mPlayThread;
        if (playThread != null) {
            playThread.resumePlaying();
        }
    }

    public void seekTo(long j, boolean z) {
        synchronized (this.mCurrDurationLock) {
            this.mCurrDuration = j;
        }
        android.os.Message obtainMessage = this.mUIHandler.obtainMessage(1);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putFloat(KEY_RATE, (j * 1.0f) / this.mDuration);
        bundle.putLong("duration", j);
        bundle.putBoolean(KEY_NEED_CALLBACK, z);
        obtainMessage.setData(bundle);
        this.mUIHandler.sendMessage(obtainMessage);
    }

    public void setOperationEndListener(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.OnOperationEndListener onOperationEndListener) {
        this.mOnOperationEndListener = onOperationEndListener;
    }

    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public void setup(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineConfig thumbLineConfig, com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.OnBarSeekListener onBarSeekListener, com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener playerListener) {
        this.mThumbLineConfig = thumbLineConfig;
        initLayoutParams();
        this.mDuration = playerListener.getDuration();
        if (this.mBarSeekListener == null) {
            setOnBarSeekListener(onBarSeekListener);
            setThumbLinePlayer(playerListener);
            this.mRecyclerView.setOnTouchListener(new com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.AnonymousClass2());
            this.mRecyclerView.addOnScrollListener(new com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.AnonymousClass3());
        }
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter thumbRecyclerAdapter = this.mThumbRecyclerAdapter;
        if (thumbRecyclerAdapter == null) {
            com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter thumbRecyclerAdapter2 = new com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter(this.mThumbLineConfig.getThumbnailCount(), (int) this.mLinePlayer.getDuration(), this.mThumbLineConfig.getThumbnailFetcher(), this.mThumbLineConfig.getScreenWidth(), this.mThumbLineConfig.getThumbnailPoint().x, this.mThumbLineConfig.getThumbnailPoint().y);
            this.mThumbRecyclerAdapter = thumbRecyclerAdapter2;
            this.mRecyclerView.setAdapter(thumbRecyclerAdapter2);
            this.mThumbRecyclerAdapter.cacheBitmaps();
        } else {
            thumbRecyclerAdapter.setData(this.mThumbLineConfig.getThumbnailCount(), (int) this.mLinePlayer.getDuration(), this.mThumbLineConfig.getThumbnailFetcher(), this.mThumbLineConfig.getScreenWidth(), this.mThumbLineConfig.getThumbnailPoint().x, this.mThumbLineConfig.getThumbnailPoint().y);
            this.mThumbRecyclerAdapter.notifyDataSetChanged();
        }
        restart();
    }

    public void show() {
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.PlayThread playThread = this.mPlayThread;
        if (playThread != null && playThread.mState != 1) {
            seekTo(this.mLinePlayer.getCurrDuration(), false);
        }
        setVisibility(0);
    }

    public void start() {
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.PlayThread playThread = new com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.PlayThread();
        this.mPlayThread = playThread;
        playThread.startPlaying();
    }

    public void stop() {
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.PlayThread playThread = this.mPlayThread;
        if (playThread != null) {
            playThread.stopPlaying();
            this.mPlayThread = null;
        }
    }
}
