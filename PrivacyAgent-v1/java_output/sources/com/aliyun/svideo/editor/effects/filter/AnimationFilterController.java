package com.aliyun.svideo.editor.effects.filter;

/* loaded from: classes12.dex */
public class AnimationFilterController {
    private static final java.lang.String KEY_DURATION = "duration";
    private static final java.lang.String KEY_OVERLAY_COLOR = "color";
    private static final java.lang.String KEY_START_TIME = "start_time";
    private static final int MESSAGE_ADD_OVERLAY = 0;
    private static final int MESSAGE_CLEAR_ALL_ANIMATION_FILTER = 4;
    private static final int MESSAGE_REMOVE_OVERLAY = 2;
    private static final int MESSAGE_RESTORE_ANIMATION_FILTER = 5;
    private static final int MESSAGE_STOP_TO_UPDATE_OVERLAY = 3;
    private static final int MESSAGE_UPDATE_PROGRESS = 1;
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.effects.filter.AnimationFilterController";
    private java.util.Stack<com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter> mAddedFilterTemp;
    private java.util.Stack<com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay> mAddedOverlayTemp;
    private com.aliyun.svideosdk.editor.AliyunIEditor mAliyunIEditor;
    private android.content.Context mContext;
    private com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay mCurrOverlay;
    private com.aliyun.svideo.editor.effects.filter.AnimationFilterController.OverlayView mCurrOverlayView;
    private com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar mThumbLineBar;
    private long mLastStartTimeInMills = 0;
    private boolean mInvert = false;
    private java.util.Stack<com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter> mAddedFilter = new java.util.Stack<>();
    private java.util.Stack<com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay> mAddedOverlay = new java.util.Stack<>();
    private android.os.Handler mOverlayHandler = new com.aliyun.svideo.editor.effects.filter.AnimationFilterController.TimelineBarOverlayHandler(android.os.Looper.getMainLooper());
    private int mOverlayColor = 0;
    private int colorIndex = 0;

    public class OverlayView implements com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView {
        public android.content.Context mContext;
        private android.view.View mHeadView;
        private android.view.View mMiddleView;
        private android.view.ViewGroup mRootView;
        private android.view.View mTailView;

        public OverlayView(android.content.Context context, boolean z) {
            this.mContext = context;
            this.mRootView = null;
            if (z) {
                this.mRootView = (android.view.ViewGroup) android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_timeline_invert_overlay, (android.view.ViewGroup) null, false);
            } else {
                this.mRootView = (android.view.ViewGroup) android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_timeline_overlay, (android.view.ViewGroup) null, false);
            }
            this.mMiddleView = this.mRootView.findViewById(com.aliyun.svideo.editor.R.id.middle_view);
            this.mHeadView = this.mRootView.findViewById(com.aliyun.svideo.editor.R.id.head_view);
            this.mTailView = this.mRootView.findViewById(com.aliyun.svideo.editor.R.id.tail_view);
            this.mHeadView.setVisibility(4);
            android.view.ViewGroup.LayoutParams layoutParams = this.mHeadView.getLayoutParams();
            android.view.ViewGroup.LayoutParams layoutParams2 = this.mTailView.getLayoutParams();
            layoutParams.width = 1;
            layoutParams.height = 1;
            layoutParams2.width = 1;
            layoutParams2.height = 1;
            this.mTailView.setVisibility(4);
            this.mHeadView.setLayoutParams(layoutParams);
            this.mTailView.setLayoutParams(layoutParams2);
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView
        public android.view.ViewGroup getContainer() {
            return this.mRootView;
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView
        public android.view.View getHeadView() {
            return this.mRootView.findViewById(com.aliyun.svideo.editor.R.id.head_view);
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView
        public android.view.View getMiddleView() {
            return this.mMiddleView;
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView
        public android.view.View getTailView() {
            return this.mRootView.findViewById(com.aliyun.svideo.editor.R.id.tail_view);
        }
    }

    public class TimelineBarOverlayHandler extends android.os.Handler {
        public TimelineBarOverlayHandler(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            if (com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mThumbLineBar == null) {
                return;
            }
            long abs = java.lang.Math.abs(com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAliyunIEditor.getPlayerController().getCurrentStreamPosition() - com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mLastStartTimeInMills);
            int i = message.what;
            if (i == 0) {
                com.aliyun.svideo.editor.effects.filter.AnimationFilterController animationFilterController = com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this;
                animationFilterController.mCurrOverlayView = animationFilterController.new OverlayView(animationFilterController.mContext, com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mInvert);
                com.aliyun.svideo.editor.effects.filter.AnimationFilterController animationFilterController2 = com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this;
                animationFilterController2.mCurrOverlay = animationFilterController2.mThumbLineBar.addOverlay(com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mLastStartTimeInMills, abs, com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mCurrOverlayView, 0L, com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mInvert, com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER_EFFECT);
                com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mCurrOverlay.updateMiddleViewColor(com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mOverlayColor);
                obtainMessage(1).sendToTarget();
                if (com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp == null) {
                    com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp = new java.util.Stack();
                    com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp.addAll(com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlay);
                }
                com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp.push(com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mCurrOverlay);
                return;
            }
            if (i == 1) {
                if (com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mCurrOverlay != null) {
                    com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mCurrOverlay.updateDuration(abs);
                }
                obtainMessage(1).sendToTarget();
                return;
            }
            if (i == 2) {
                if (com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp == null) {
                    com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp = new java.util.Stack();
                    com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp.addAll(com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlay);
                }
                if (com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp.empty()) {
                    return;
                }
                java.lang.Object obj = message.obj;
                if (obj instanceof java.util.List) {
                    java.util.List list = (java.util.List) obj;
                    for (int size = list.size() - 1; size >= 0; size--) {
                        int indexOf = com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedFilterTemp.indexOf((com.aliyun.svideosdk.common.struct.effect.EffectFilter) list.get(size));
                        if (indexOf != -1) {
                            com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mThumbLineBar.removeOverlay((com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay) com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp.get(indexOf));
                            com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp.remove(indexOf);
                            com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedFilterTemp.remove(indexOf);
                        }
                    }
                } else {
                    com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay) com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp.pop();
                    com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mThumbLineBar.removeOverlay(thumbLineOverlay);
                    com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mThumbLineBar.seekTo(thumbLineOverlay.startTime, false);
                    com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mCurrOverlay = null;
                    com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mCurrOverlayView = null;
                    if (!com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp.empty()) {
                        com.aliyun.svideo.editor.effects.filter.AnimationFilterController animationFilterController3 = com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this;
                        animationFilterController3.mCurrOverlay = (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay) animationFilterController3.mAddedOverlayTemp.peek();
                        com.aliyun.svideo.editor.effects.filter.AnimationFilterController animationFilterController4 = com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this;
                        animationFilterController4.mCurrOverlayView = (com.aliyun.svideo.editor.effects.filter.AnimationFilterController.OverlayView) animationFilterController4.mCurrOverlay.getThumbLineOverlayView();
                    }
                }
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(2);
                return;
            }
            if (i == 3) {
                removeMessages(1);
                java.lang.String unused = com.aliyun.svideo.editor.effects.filter.AnimationFilterController.TAG;
                return;
            }
            if (i == 4) {
                com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mCurrOverlayView = null;
                com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mLastStartTimeInMills = 0L;
                com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mCurrOverlay = null;
                if (com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp != null) {
                    java.util.Iterator it = com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp.iterator();
                    while (it.hasNext()) {
                        com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mThumbLineBar.removeOverlay((com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay) it.next());
                    }
                    com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp.clear();
                    com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlayTemp = null;
                }
                for (int i2 = 0; i2 < com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedFilter.size(); i2++) {
                    com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAliyunIEditor.addAnimationFilter((com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter) com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedFilter.get(i2));
                    com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay2 = (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay) com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlay.get(i2);
                    com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mThumbLineBar.addOverlay(thumbLineOverlay2.startTime, thumbLineOverlay2.mDuration, thumbLineOverlay2.getThumbLineOverlayView(), 0L, com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mInvert, com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER_EFFECT).updateMiddleViewColor(thumbLineOverlay2.middleViewColor);
                }
                return;
            }
            if (i != 5) {
                java.lang.String unused2 = com.aliyun.svideo.editor.effects.filter.AnimationFilterController.TAG;
                return;
            }
            com.aliyun.svideo.editor.effects.filter.AnimationFilterController animationFilterController5 = com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this;
            animationFilterController5.mCurrOverlayView = animationFilterController5.new OverlayView(animationFilterController5.mContext, com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mInvert);
            android.os.Bundle data = message.getData();
            com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mLastStartTimeInMills = data.getLong("start_time");
            com.aliyun.svideo.editor.effects.filter.AnimationFilterController animationFilterController6 = com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this;
            animationFilterController6.mCurrOverlay = animationFilterController6.mThumbLineBar.addOverlay(com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mLastStartTimeInMills, data.getLong("duration"), com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mCurrOverlayView, 0L, com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mInvert, com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER_EFFECT);
            com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mCurrOverlay.getOverlayView().setVisibility(4);
            com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mCurrOverlay.updateMiddleViewColor(data.getInt("color"));
            java.lang.String unused3 = com.aliyun.svideo.editor.effects.filter.AnimationFilterController.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("handleMessage: RESTORE ,startTime :");
            sb.append(com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mLastStartTimeInMills);
            sb.append(" ,endTime :");
            sb.append(com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mLastStartTimeInMills + (data.getLong("duration") * 1000));
            com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mAddedOverlay.push(com.aliyun.svideo.editor.effects.filter.AnimationFilterController.this.mCurrOverlay);
        }
    }

    public AnimationFilterController(android.content.Context context, com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor) {
        this.mAliyunIEditor = aliyunIEditor;
        com.aliyun.svideo.editor.msg.Dispatcher.getInstance().register(this);
        this.mContext = context;
    }

    private void selectOverlayColor() {
        int i = this.colorIndex;
        int i2 = i % 5;
        this.mOverlayColor = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? com.aliyun.svideo.editor.R.color.alivc_edit_animation_filter_color1 : com.aliyun.svideo.editor.R.color.alivc_edit_animation_filter_color5 : com.aliyun.svideo.editor.R.color.alivc_edit_animation_filter_color4 : com.aliyun.svideo.editor.R.color.alivc_edit_animation_filter_color3 : com.aliyun.svideo.editor.R.color.alivc_edit_animation_filter_color2 : com.aliyun.svideo.editor.R.color.alivc_edit_animation_filter_color1;
        this.colorIndex = i + 1;
    }

    public void destroyController() {
        this.mOverlayHandler.sendEmptyMessage(3);
        this.mContext = null;
        com.aliyun.svideo.editor.msg.Dispatcher.getInstance().unRegister(this);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onEventAnimationFilterClickUp(com.aliyun.svideo.editor.msg.body.LongClickUpAnimationFilter longClickUpAnimationFilter) {
        java.util.Stack<com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter> stack = this.mAddedFilterTemp;
        if (stack == null || stack.empty()) {
            return;
        }
        com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter trackEffectFilter = this.mAddedFilterTemp.get(r0.size() - 1);
        this.mAliyunIEditor.removeAnimationFilter(trackEffectFilter);
        trackEffectFilter.setDuration(java.lang.Math.abs(this.mAliyunIEditor.getPlayerController().getCurrentStreamPosition() - trackEffectFilter.getStartTime()), java.util.concurrent.TimeUnit.MILLISECONDS);
        trackEffectFilter.setEffectConfig(longClickUpAnimationFilter.getEffectConfig());
        this.mAliyunIEditor.addAnimationFilter(trackEffectFilter);
        this.mOverlayHandler.sendEmptyMessage(3);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onEventAnimationFilterDelete(com.aliyun.svideo.editor.msg.body.DeleteLastAnimationFilter deleteLastAnimationFilter) {
        if (this.mAddedFilterTemp == null) {
            java.util.Stack<com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter> stack = new java.util.Stack<>();
            this.mAddedFilterTemp = stack;
            stack.addAll(this.mAddedFilter);
        }
        if (this.mAddedFilterTemp.empty()) {
            return;
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(deleteLastAnimationFilter.getResourcePath())) {
            com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter pop = this.mAddedFilterTemp.pop();
            this.mAliyunIEditor.removeAnimationFilter(pop);
            if (this.mAliyunIEditor.isPlaying()) {
                this.mAliyunIEditor.seek(pop.getStartTime(), java.util.concurrent.TimeUnit.MILLISECONDS);
                this.mAliyunIEditor.resume();
            } else {
                this.mAliyunIEditor.seek(pop.getStartTime(), java.util.concurrent.TimeUnit.MILLISECONDS);
            }
            this.mOverlayHandler.sendEmptyMessage(2);
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < this.mAddedFilterTemp.size(); i++) {
            com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter trackEffectFilter = this.mAddedFilterTemp.get(i);
            if (trackEffectFilter.getSource().getPath().contains(deleteLastAnimationFilter.getResourcePath())) {
                this.mAliyunIEditor.removeAnimationFilter(trackEffectFilter);
                arrayList.add(trackEffectFilter);
            }
        }
        android.os.Message message = new android.os.Message();
        message.what = 2;
        message.obj = arrayList;
        this.mOverlayHandler.sendMessage(message);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onEventAnimationFilterLongClick(com.aliyun.svideo.editor.msg.body.LongClickAnimationFilter longClickAnimationFilter) {
        if (this.mAliyunIEditor.getTimeEffect() == com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_INVERT) {
            this.mInvert = true;
        } else {
            this.mInvert = false;
        }
        com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = longClickAnimationFilter.getEffectInfo();
        this.mLastStartTimeInMills = java.util.concurrent.TimeUnit.MICROSECONDS.toMillis(effectInfo.streamStartTime);
        com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder effectConfig = new com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder().source(effectInfo.getSource()).effectConfig(longClickAnimationFilter.getEffectConfig());
        long j = this.mLastStartTimeInMills;
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter build = effectConfig.startTime(j, timeUnit).duration(2147483647L, timeUnit).build();
        this.mAliyunIEditor.addAnimationFilter(build);
        selectOverlayColor();
        this.mOverlayHandler.sendEmptyMessage(0);
        if (this.mAddedFilterTemp == null) {
            java.util.Stack<com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter> stack = new java.util.Stack<>();
            this.mAddedFilterTemp = stack;
            stack.addAll(this.mAddedFilter);
        }
        this.mAddedFilterTemp.push(build);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onEventCheckFilterIsDelete(com.aliyun.svideo.editor.msg.body.CheckDeleteFilter checkDeleteFilter) {
        if (this.mAddedFilterTemp == null) {
            java.util.Stack<com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter> stack = new java.util.Stack<>();
            this.mAddedFilterTemp = stack;
            stack.addAll(this.mAddedFilter);
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        if (!this.mAddedFilterTemp.empty()) {
            java.util.Iterator<com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter> it = this.mAddedFilterTemp.iterator();
            while (it.hasNext()) {
                com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter next = it.next();
                if (!new java.io.File(next.getSource().getPath()).exists()) {
                    hashSet.add(next.getSource().getPath());
                }
            }
        }
        if (hashSet.size() > 0) {
            java.util.Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                onEventAnimationFilterDelete(new com.aliyun.svideo.editor.msg.body.DeleteLastAnimationFilter((java.lang.String) it2.next()));
            }
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onEventClearAnimationFilter(com.aliyun.svideo.editor.msg.body.ClearAnimationFilter clearAnimationFilter) {
        java.util.Stack<com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter> stack = this.mAddedFilterTemp;
        if (stack != null) {
            stack.clear();
            this.mAddedFilterTemp = null;
            this.mAliyunIEditor.clearAllAnimationFilter();
            this.mOverlayHandler.sendEmptyMessage(4);
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onEventConfirmAnimationFilter(com.aliyun.svideo.editor.msg.body.ConfirmAnimationFilter confirmAnimationFilter) {
        if (this.mAddedFilterTemp == null || this.mAddedOverlayTemp == null) {
            return;
        }
        this.mAddedOverlay.clear();
        this.mAddedFilter.clear();
        this.mAddedOverlay.addAll(this.mAddedOverlayTemp);
        this.mAddedFilter.addAll(this.mAddedFilterTemp);
        this.mAddedFilterTemp.clear();
        this.mAddedOverlayTemp.clear();
        this.mAddedOverlayTemp = null;
        this.mAddedFilterTemp = null;
    }

    public void restoreAnimationFilters(java.util.List<com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        java.util.Stack<com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter> stack = this.mAddedFilterTemp;
        if (stack != null) {
            stack.clear();
            this.mAddedFilterTemp = null;
        }
        this.mAddedFilter.clear();
        java.util.Iterator<com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay> it = this.mAddedOverlay.iterator();
        while (it.hasNext()) {
            this.mThumbLineBar.removeOverlay(it.next());
        }
        this.mAddedOverlay.clear();
        for (com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter trackEffectFilter : list) {
            if (trackEffectFilter.getStartTime() < this.mAliyunIEditor.getPlayerController().getStreamDuration()) {
                this.mAddedFilter.push(trackEffectFilter);
                selectOverlayColor();
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putInt("color", this.mOverlayColor);
                bundle.putLong("start_time", trackEffectFilter.getStartTime());
                bundle.putLong("duration", trackEffectFilter.getDuration());
                android.os.Message obtainMessage = this.mOverlayHandler.obtainMessage(5);
                obtainMessage.setData(bundle);
                this.mOverlayHandler.sendMessage(obtainMessage);
            }
        }
    }

    public void setThumbLineBar(com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar) {
        this.mThumbLineBar = overlayThumbLineBar;
    }
}
