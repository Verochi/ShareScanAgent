package com.aliyun.svideo.editor.view;

/* loaded from: classes12.dex */
public class AlivcEditView extends android.widget.RelativeLayout implements android.view.View.OnClickListener, com.aliyun.svideo.editor.effects.control.OnEffectChangeListener, com.aliyun.svideo.editor.effects.control.OnTabChangeListener, com.aliyun.svideo.editor.view.IAlivcEditView, com.aliyun.svideosdk.editor.OnAnimationFilterRestoredListener {
    private static final int ADD_TRANSITION = 1;
    public static final int REQ_CODE_GET_MEDIA = 101;
    private static final int REVERT_TRANSITION = 2;
    private static final int SAVE_COVER = 3;
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.view.AlivcEditView";
    public static final int USE_ANIMATION_REMAIN_TIME = 300;
    private static boolean sIsDeleteTransitionSource;
    private final java.lang.String PATH_THUMBNAIL;
    private com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate;
    private com.aliyun.svideo.editor.view.AlivcEditView.AlivcEditHandler alivcEditHandler;
    private android.animation.ObjectAnimator animatorX;
    private java.util.concurrent.ExecutorService executorService;
    private boolean hasCaptureCover;
    private boolean hasTailAnimation;
    private boolean hasWaterMark;
    private boolean isMixRecord;
    private boolean isNeedResume;
    private boolean isReplaceMusic;
    private boolean isTakeFrame;
    private boolean isTakeFrameSelected;
    private com.aliyun.svideosdk.common.struct.effect.TrackAudioStream lastMusicBean;
    private android.widget.RelativeLayout mActionBar;
    private com.aliyun.svideosdk.editor.AliyunIEditor mAliyunIEditor;
    private com.aliyun.svideosdk.editor.AliyunPasterController mAliyunPasterController;
    private com.aliyun.svideosdk.editor.AliyunRollCaptionComposer mAliyunRollCaptionComposer;
    private com.aliyun.svideo.editor.effects.filter.AnimationFilterController mAnimationFilterController;
    private android.widget.LinearLayout mBarLinear;
    private com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.OnBarSeekListener mBarSeekListener;
    private android.widget.LinearLayout mBottomLinear;
    private boolean mCanAddAnimation;
    public com.aliyun.svideosdk.editor.AliyunICanvasController mCanvasController;
    private com.aliyun.svideo.editor.editor.AliyunBasePasterController mCurrentEditEffect;
    java.lang.StringBuilder mDurationText;
    private com.aliyun.svideosdk.editor.EditorCallBack mEditorCallback;
    private com.aliyun.svideo.editor.effects.control.EditorService mEditorService;
    private android.widget.FrameLayout mGlSurfaceContainer;
    private boolean mHasDeNoise;
    private boolean mHasRecordMusic;
    private boolean mHorizontalFlip;
    private boolean mIsDestroyed;
    private boolean mIsStop;
    private boolean mIsTranscoding;
    private boolean mIsTransitioning;
    private android.widget.ImageView mIvLeft;
    private com.aliyun.svideo.editor.effects.control.EffectInfo mLastMVEffect;
    private com.aliyun.svideo.editor.effects.control.EffectInfo mLastSoundEffect;
    private com.aliyun.svideo.editor.effects.control.OnEffectActionLister mOnEffectActionLister;
    private com.aliyun.svideo.editor.view.AlivcEditView.OnFinishListener mOnFinishListener;
    private final com.aliyun.svideosdk.editor.OnPasterRestored mOnPasterRestoreListener;
    private com.aliyun.svideo.editor.effects.transition.TransitionChooserView.OnPreviewListener mOnTransitionPreviewListener;
    public android.widget.FrameLayout mPasterContainer;
    private android.graphics.Point mPasterContainerPoint;
    private java.util.List<com.aliyun.svideo.editor.bean.PasterRestoreBean> mPasterEffectCachetList;
    private com.aliyun.svideosdk.editor.AliyunPasterManager mPasterManager;
    private com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl mPasterUICompoundCaptionImpl;
    private android.widget.RelativeLayout mPlayContainer;
    private android.widget.ImageView mPlayImage;
    private com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener mPlayerListener;
    private android.view.View mRoot;
    private int mScreenHeight;
    private int mScreenWidth;
    private com.aliyun.svideo.editor.util.AlivcSnapshot mSnapshop;
    private android.view.View mSurfaceView;
    private com.aliyun.svideo.editor.effects.control.TabGroup mTabGroup;
    private com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar mThumbLineBar;
    private com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView mThumbLineOverlayView;
    private com.aliyun.svideosdk.common.AliyunIThumbnailFetcher mThumbnailFetcher;
    private com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay mTimeEffectOverlay;
    private android.widget.ProgressBar mTransCodeProgress;
    private android.widget.FrameLayout mTransCodeTip;
    private com.aliyun.svideosdk.crop.AliyunICrop mTranscoder;
    private com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog mTransitionAnimation;
    private java.util.LinkedHashMap<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo> mTransitionCache;
    private java.util.LinkedHashMap<java.lang.Integer, java.util.List<com.aliyun.svideo.editor.bean.AlivcTransBean>> mTransitionParamsCache;
    private android.widget.TextView mTvCurrTime;
    private android.widget.TextView mTvRight;
    private android.net.Uri mUri;
    private boolean mUseAnimationFilter;
    private boolean mUseInvert;
    private com.aliyun.svideosdk.common.struct.common.AliyunVideoParam mVideoParam;
    private com.aliyun.svideo.editor.viewoperate.ViewOperator mViewOperate;
    private com.aliyun.svideo.editor.effects.control.ViewStack mViewStack;
    private int mVolume;
    private boolean mWaitForReady;
    private android.graphics.Bitmap mWatermarkBitmap;
    private com.aliyun.svideo.editor.guide.customView.MultiLamp multiLamp;
    private android.widget.ProgressBar playProgress;
    private java.util.Set<com.aliyun.svideo.editor.effects.caption.listener.OnVideoUpdateDurationListener> playerListenerSet;
    private android.widget.FrameLayout resCopy;
    private android.widget.Toast showToast;
    private java.util.ArrayList<com.aliyun.svideo.editor.guide.model.Target> targets;
    private android.graphics.PointF tempPointF;

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.guide.customView.MultiLamp.Callback {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.guide.customView.MultiLamp.Callback
        public void onTutorialFinished() {
            com.aliyun.svideo.editor.view.AlivcEditView.this.playingResume();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        public AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int outputWidth = com.aliyun.svideo.editor.view.AlivcEditView.this.mVideoParam.getOutputWidth();
            int outputHeight = com.aliyun.svideo.editor.view.AlivcEditView.this.mVideoParam.getOutputHeight();
            int dip2px = com.aliyun.svideo.common.utils.DensityUtils.dip2px(com.aliyun.svideo.editor.view.AlivcEditView.this.getContext(), 30.0f);
            int dip2px2 = com.aliyun.svideo.common.utils.DensityUtils.dip2px(com.aliyun.svideo.editor.view.AlivcEditView.this.getContext(), 30.0f);
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mWatermarkBitmap != null && !com.aliyun.svideo.editor.view.AlivcEditView.this.mWatermarkBitmap.isRecycled()) {
                dip2px = com.aliyun.svideo.editor.view.AlivcEditView.this.mWatermarkBitmap.getWidth();
                dip2px2 = com.aliyun.svideo.editor.view.AlivcEditView.this.mWatermarkBitmap.getHeight();
            }
            float dimensionPixelSize = (((double) (((float) outputHeight) / ((float) outputWidth))) > 1.5d ? (((dip2px2 / 2) + com.aliyun.svideo.editor.view.AlivcEditView.this.getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.alivc_svideo_title_height)) / 1.5f) / com.aliyun.svideo.editor.view.AlivcEditView.this.mSurfaceView.getHeight() : ((dip2px2 / 1.5f) / com.aliyun.svideo.editor.view.AlivcEditView.this.mSurfaceView.getHeight()) / 2.0f) + 0.0f;
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.hasWaterMark) {
                float f = dip2px;
                com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.applyWaterMark(com.aliyun.svideo.editor.view.AlivcEditView.this.getContext().getExternalFilesDir("") + "/AliyunEditorDemo/tail/logo.png", ((f * 0.5f) * 0.8f) / com.aliyun.svideo.editor.view.AlivcEditView.this.mSurfaceView.getWidth(), ((dip2px2 * 0.5f) * 0.8f) / com.aliyun.svideo.editor.view.AlivcEditView.this.mSurfaceView.getHeight(), ((f / 1.5f) / com.aliyun.svideo.editor.view.AlivcEditView.this.mSurfaceView.getWidth()) / 2.0f, dimensionPixelSize);
            }
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.hasTailAnimation) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.addTailWaterMark(com.aliyun.svideo.editor.view.AlivcEditView.this.getContext().getExternalFilesDir("") + "/AliyunEditorDemo/tail/logo.png", dip2px / com.aliyun.svideo.editor.view.AlivcEditView.this.mSurfaceView.getWidth(), dip2px2 / com.aliyun.svideo.editor.view.AlivcEditView.this.mSurfaceView.getHeight(), 0.5f, 0.5f, 2000000L);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$11, reason: invalid class name */
    public class AnonymousClass11 implements com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.OnBarSeekListener {
        public AnonymousClass11() {
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.OnBarSeekListener
        public void onThumbLineBarSeek(long j) {
            com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.seek(j, java.util.concurrent.TimeUnit.MILLISECONDS);
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar != null) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar.pause();
            }
            com.aliyun.svideo.editor.view.AlivcEditView.this.switchPlayStateUI(true);
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect != null && !com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.isEditCompleted()) {
                if (com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.isVisibleInTime(com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getCurrentPlayPosition())) {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.setPasterViewVisibility(0);
                } else {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.setPasterViewVisibility(8);
                }
            }
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mUseInvert) {
                if (j <= 300) {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCanAddAnimation = false;
                    return;
                } else {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCanAddAnimation = true;
                    return;
                }
            }
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getDuration() - j <= 300) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.mCanAddAnimation = false;
            } else {
                com.aliyun.svideo.editor.view.AlivcEditView.this.mCanAddAnimation = true;
            }
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.OnBarSeekListener
        public void onThumbLineBarSeekFinish(long j) {
            com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.seek(j, java.util.concurrent.TimeUnit.MILLISECONDS);
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar != null) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar.pause();
            }
            com.aliyun.svideo.editor.view.AlivcEditView.this.switchPlayStateUI(true);
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mUseInvert) {
                if (j <= 300) {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCanAddAnimation = false;
                    return;
                } else {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCanAddAnimation = true;
                    return;
                }
            }
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getDuration() - j >= 300) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.mCanAddAnimation = true;
            } else {
                com.aliyun.svideo.editor.view.AlivcEditView.this.mCanAddAnimation = false;
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$12, reason: invalid class name */
    public class AnonymousClass12 implements com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView {
        android.view.View headView;
        android.view.View middleView;
        android.view.View rootView;
        android.view.View tailView;

        public AnonymousClass12() {
            android.view.View inflate = android.view.LayoutInflater.from(com.aliyun.svideo.editor.view.AlivcEditView.this.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_timeline_overlay, (android.view.ViewGroup) null);
            this.rootView = inflate;
            this.headView = inflate.findViewById(com.aliyun.svideo.editor.R.id.head_view);
            this.tailView = this.rootView.findViewById(com.aliyun.svideo.editor.R.id.tail_view);
            this.middleView = this.rootView.findViewById(com.aliyun.svideo.editor.R.id.middle_view);
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView
        public android.view.ViewGroup getContainer() {
            return (android.view.ViewGroup) this.rootView;
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView
        public android.view.View getHeadView() {
            return this.headView;
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView
        public android.view.View getMiddleView() {
            return this.middleView;
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView
        public android.view.View getTailView() {
            return this.tailView;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$13, reason: invalid class name */
    public class AnonymousClass13 implements com.aliyun.svideosdk.editor.OnPasterRestored {

        /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$13$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.util.List val$controllers;

            public AnonymousClass1(java.util.List list) {
                this.val$controllers = list;
            }

            /* JADX WARN: Removed duplicated region for block: B:33:0x016b  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x01aa  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x01ff  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x0179  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                java.util.Iterator it;
                android.view.View pasterView;
                boolean z = true;
                if (com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar != null && com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar.getChildCount() != 0) {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar.removeOverlayByPages(com.aliyun.svideo.editor.effects.control.UIEditorPage.OVERLAY, com.aliyun.svideo.editor.effects.control.UIEditorPage.COMPOUND_CAPTION);
                }
                android.widget.FrameLayout frameLayout = com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterContainer;
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                }
                java.util.ArrayList<com.aliyun.svideo.editor.editor.AliyunBasePasterController> arrayList = new java.util.ArrayList();
                java.util.Iterator it2 = this.val$controllers.iterator();
                while (it2.hasNext()) {
                    com.aliyun.svideosdk.editor.AliyunIPasterController aliyunIPasterController = (com.aliyun.svideosdk.editor.impl.AliyunPasterAbstractController) it2.next();
                    if (aliyunIPasterController instanceof com.aliyun.svideosdk.editor.AliyunPasterController) {
                        com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController = (com.aliyun.svideosdk.editor.AliyunPasterController) aliyunIPasterController;
                        if (aliyunPasterController.isPasterExists() && aliyunPasterController.getPasterDuration(java.util.concurrent.TimeUnit.MILLISECONDS) < com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getStreamDuration()) {
                            aliyunPasterController.setOnlyApplyUI(z);
                            if (aliyunPasterController.getEffect() instanceof com.aliyun.svideosdk.common.struct.effect.EffectPaster) {
                                com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster = (com.aliyun.svideosdk.common.struct.effect.EffectPaster) aliyunPasterController.getEffect();
                                float pasterScaleSize = com.aliyun.svideo.editor.view.AlivcEditView.this.mViewOperate.getPasterScaleSize(effectPaster.getPasterType());
                                int i = (int) (com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterContainerPoint.x * pasterScaleSize);
                                int i2 = (int) (com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterContainerPoint.y * pasterScaleSize);
                                int i3 = effectPaster.displayWidth;
                                if (i3 != i) {
                                    float f = i;
                                    effectPaster.x = (effectPaster.x / i3) * f;
                                    float f2 = i2;
                                    effectPaster.y = (effectPaster.y / effectPaster.displayHeight) * f2;
                                    float min = java.lang.Math.min(i, i2) / java.lang.Math.min(i3, r13);
                                    float f3 = f / effectPaster.displayWidth;
                                    float f4 = f2 / effectPaster.displayHeight;
                                    effectPaster.width = (int) java.lang.Math.ceil(effectPaster.width * f3);
                                    effectPaster.height = (int) java.lang.Math.ceil(effectPaster.height * f4);
                                    if (effectPaster instanceof com.aliyun.svideosdk.common.struct.effect.EffectText) {
                                        com.aliyun.svideosdk.common.struct.effect.EffectText effectText = (com.aliyun.svideosdk.common.struct.effect.EffectText) effectPaster;
                                        it = it2;
                                        effectText.textWidth = (int) java.lang.Math.ceil(effectText.textWidth * f3);
                                        effectText.textHeight = (int) java.lang.Math.ceil(effectText.textHeight * f4);
                                        effectText.mTextSize = (int) java.lang.Math.ceil(effectText.mTextSize * min);
                                        effectText.mTextPaddingX = (int) (effectText.mTextPaddingX * f3);
                                        effectText.mTextPaddingY = (int) (effectText.mTextPaddingY * f4);
                                    } else {
                                        it = it2;
                                    }
                                    if (effectPaster instanceof com.aliyun.svideosdk.common.struct.effect.EffectCaption) {
                                        com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption = (com.aliyun.svideosdk.common.struct.effect.EffectCaption) effectPaster;
                                        effectCaption.textCenterX = (int) java.lang.Math.ceil(effectCaption.textCenterX * f3);
                                        effectCaption.textCenterY = (int) java.lang.Math.ceil(effectCaption.textCenterY * f4);
                                    }
                                    effectPaster.displayWidth = i;
                                    effectPaster.displayHeight = i2;
                                    if (aliyunPasterController.getPasterType() != 0) {
                                        com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = com.aliyun.svideo.editor.view.AlivcEditView.this;
                                        alivcEditView.mCurrentEditEffect = alivcEditView.addPaster(aliyunPasterController);
                                    } else if (aliyunPasterController.getPasterType() == 1) {
                                        com.aliyun.svideo.editor.view.AlivcEditView alivcEditView2 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                                        alivcEditView2.mCurrentEditEffect = alivcEditView2.addSubtitle(aliyunPasterController, true);
                                    } else {
                                        if (aliyunPasterController.getPasterType() == 2) {
                                            com.aliyun.svideo.editor.view.AlivcEditView alivcEditView3 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                                            alivcEditView3.mCurrentEditEffect = alivcEditView3.addCaption(aliyunPasterController);
                                        }
                                        if ((com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect instanceof com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) && (aliyunPasterController.getEffect() instanceof com.aliyun.svideosdk.common.struct.effect.EffectPaster) && ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) aliyunPasterController.getEffect()).action != null) {
                                            ((com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect).setFrameAction(((com.aliyun.svideosdk.common.struct.effect.EffectPaster) aliyunPasterController.getEffect()).action);
                                            ((com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect).setTempFrameAction(((com.aliyun.svideosdk.common.struct.effect.EffectPaster) aliyunPasterController.getEffect()).action);
                                        }
                                        com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.showTimeEdit();
                                        pasterView = com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.getPasterView();
                                        if (pasterView != null) {
                                            pasterView.setVisibility(4);
                                        }
                                        arrayList.add(com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect);
                                        com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.moveToCenter();
                                        com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.hideOverlayView();
                                    }
                                    if (com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect instanceof com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) {
                                        ((com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect).setFrameAction(((com.aliyun.svideosdk.common.struct.effect.EffectPaster) aliyunPasterController.getEffect()).action);
                                        ((com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect).setTempFrameAction(((com.aliyun.svideosdk.common.struct.effect.EffectPaster) aliyunPasterController.getEffect()).action);
                                    }
                                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.showTimeEdit();
                                    pasterView = com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.getPasterView();
                                    if (pasterView != null) {
                                    }
                                    arrayList.add(com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect);
                                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.moveToCenter();
                                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.hideOverlayView();
                                }
                            }
                            it = it2;
                            if (aliyunPasterController.getPasterType() != 0) {
                            }
                            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect instanceof com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) {
                            }
                            com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.showTimeEdit();
                            pasterView = com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.getPasterView();
                            if (pasterView != null) {
                            }
                            arrayList.add(com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect);
                            com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.moveToCenter();
                            com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.hideOverlayView();
                        }
                    } else {
                        it = it2;
                        if ((aliyunIPasterController instanceof com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption) && aliyunIPasterController.getStartTime(java.util.concurrent.TimeUnit.MILLISECONDS) < com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getStreamDuration()) {
                            com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption = (com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption) aliyunIPasterController;
                            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl == null) {
                                com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl = new com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl();
                            }
                            com.aliyun.svideo.editor.view.AlivcEditView alivcEditView4 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                            alivcEditView4.mCurrentEditEffect = alivcEditView4.mPasterUICompoundCaptionImpl;
                            com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl pasterUICompoundCaptionImpl = com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl;
                            com.aliyun.svideo.editor.view.AlivcEditView alivcEditView5 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                            pasterUICompoundCaptionImpl.updateParams(alivcEditView5, aliyunPasterControllerCompoundCaption, alivcEditView5.mPasterManager, com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar);
                            com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl.showTimeEdit();
                            arrayList.add(com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect);
                        }
                    }
                    it2 = it;
                    z = true;
                }
                for (com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController : arrayList) {
                    aliyunBasePasterController.editTimeCompleted();
                    if (aliyunBasePasterController instanceof com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) {
                        com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl abstractPasterUISimpleImpl = (com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) aliyunBasePasterController;
                        if (abstractPasterUISimpleImpl.getEffect() instanceof com.aliyun.svideosdk.common.struct.effect.EffectCaption) {
                            abstractPasterUISimpleImpl.getController().setEffect((com.aliyun.svideosdk.common.struct.effect.EffectBase) aliyunBasePasterController.getTextView().getTag());
                        }
                    }
                    aliyunBasePasterController.setOnlyApplyUI(false);
                }
            }
        }

        public AnonymousClass13() {
        }

        @Override // com.aliyun.svideosdk.editor.OnPasterRestored
        public void onPasterRestored(java.util.List<com.aliyun.svideosdk.editor.impl.AliyunPasterAbstractController> list) {
            if (list == null || list.size() == 0) {
                return;
            }
            java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onPasterRestored: ");
            sb.append(list.size());
            com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterContainer.post(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass13.AnonymousClass1(list));
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$14, reason: invalid class name */
    public class AnonymousClass14 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideo.editor.effects.control.EffectInfo val$effectInfo;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.effect.TransitionBase val$transition;

        public AnonymousClass14(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase) {
            this.val$effectInfo = effectInfo;
            this.val$transition = transitionBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.saveEffectToLocal();
            com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.setTransition(this.val$effectInfo.clipIndex, this.val$transition);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putSerializable("effectInfo", this.val$effectInfo);
            android.os.Message message = new android.os.Message();
            message.what = 1;
            message.setData(bundle);
            com.aliyun.svideo.editor.view.AlivcEditView.this.alivcEditHandler.sendMessage(message);
            com.aliyun.svideo.editor.view.AlivcEditView.this.resetTimeLineLayout();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$15, reason: invalid class name */
    public class AnonymousClass15 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideo.editor.effects.control.EffectInfo val$effectInfo;

        public AnonymousClass15(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
            this.val$effectInfo = effectInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.saveEffectToLocal();
            java.util.HashMap hashMap = new java.util.HashMap();
            for (com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo : this.val$effectInfo.mutiEffect) {
                hashMap.put(java.lang.Integer.valueOf(effectInfo.clipIndex), com.aliyun.svideo.editor.view.AlivcEditView.this.getTransitionBase(effectInfo));
            }
            com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.setTransition(hashMap);
            com.aliyun.svideo.editor.view.AlivcEditView.this.alivcEditHandler.sendEmptyMessage(2);
            com.aliyun.svideo.editor.view.AlivcEditView.this.resetTimeLineLayout();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$16, reason: invalid class name */
    public class AnonymousClass16 extends android.os.AsyncTask {
        final /* synthetic */ long val$duration;
        final /* synthetic */ boolean val$needDuration;
        final /* synthetic */ long val$startTime;
        final /* synthetic */ int val$times;
        final /* synthetic */ com.aliyun.svideosdk.editor.TimeEffectType val$type;

        /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$16$1, reason: invalid class name */
        public class AnonymousClass1 implements com.aliyun.svideosdk.crop.CropCallback {
            final /* synthetic */ java.util.concurrent.CountDownLatch val$countDownLatch;
            final /* synthetic */ java.util.concurrent.atomic.AtomicInteger val$flag;

            /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$16$1$1, reason: invalid class name and collision with other inner class name */
            public class RunnableC00821 implements java.lang.Runnable {
                final /* synthetic */ int val$percent;

                public RunnableC00821(int i) {
                    this.val$percent = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mTransCodeProgress.setProgress(this.val$percent);
                }
            }

            public AnonymousClass1(java.util.concurrent.atomic.AtomicInteger atomicInteger, java.util.concurrent.CountDownLatch countDownLatch) {
                this.val$flag = atomicInteger;
                this.val$countDownLatch = countDownLatch;
            }

            @Override // com.aliyun.svideosdk.crop.CropCallback
            public void onCancelComplete() {
                this.val$flag.set(3);
                if (com.aliyun.svideo.editor.view.AlivcEditView.this.mIsDestroyed) {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mTranscoder.dispose();
                }
                this.val$countDownLatch.countDown();
                com.aliyun.svideo.editor.view.AlivcEditView.this.mIsTranscoding = false;
            }

            @Override // com.aliyun.svideosdk.crop.CropCallback
            public void onComplete(long j) {
                com.aliyun.svideosdk.editor.AliyunISourcePartManager sourcePartManager = com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getSourcePartManager();
                com.aliyun.svideosdk.common.struct.common.AliyunClip mediaPart = sourcePartManager.getMediaPart(0);
                mediaPart.setSource(mediaPart.getSource() + "_invert_transcode.mp4");
                sourcePartManager.updateMediaClip(0, mediaPart);
                sourcePartManager.applySourceChange();
                this.val$flag.set(2);
                this.val$countDownLatch.countDown();
                com.aliyun.svideo.editor.view.AlivcEditView.this.mIsTranscoding = false;
            }

            @Override // com.aliyun.svideosdk.crop.CropCallback
            public void onError(int i) {
                java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("onError");
                sb.append(i);
                this.val$flag.set(1);
                this.val$countDownLatch.countDown();
                com.aliyun.svideo.editor.view.AlivcEditView.this.mIsTranscoding = false;
            }

            @Override // com.aliyun.svideosdk.crop.CropCallback
            public void onProgress(int i) {
                java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("percent");
                sb.append(i);
                com.aliyun.svideo.editor.view.AlivcEditView.this.post(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass16.AnonymousClass1.RunnableC00821(i));
            }
        }

        /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$16$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.view.AlivcEditView.this.mTransCodeTip.setVisibility(0);
                com.aliyun.svideo.editor.effects.control.BaseChooser bottomView = com.aliyun.svideo.editor.view.AlivcEditView.this.mViewOperate.getBottomView();
                if (bottomView != null) {
                    bottomView.setClickable(false);
                }
            }
        }

        public AnonymousClass16(com.aliyun.svideosdk.editor.TimeEffectType timeEffectType, int i, long j, long j2, boolean z) {
            this.val$type = timeEffectType;
            this.val$times = i;
            this.val$startTime = j;
            this.val$duration = j2;
            this.val$needDuration = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0120 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0121  */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public java.lang.Object doInBackground(java.lang.Object[] objArr) {
            int outputWidth;
            int outputHeight;
            int parseInt;
            com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip = com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getSourcePartManager().getAllClips().get(0);
            java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger(0);
            if (aliyunClip == null) {
                return null;
            }
            if (!com.aliyun.svideo.editor.view.AlivcEditView.this.checkInvert(aliyunClip.getSource())) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.saveEffectToLocal();
                java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
                com.aliyun.svideosdk.crop.CropParam cropParam = new com.aliyun.svideosdk.crop.CropParam();
                cropParam.setGop(5);
                cropParam.setFrameRate(30);
                cropParam.setQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality.SSD);
                cropParam.setInputPath(aliyunClip.getSource());
                cropParam.setVideoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_SOFT_OPENH264);
                cropParam.setCrf(19);
                cropParam.setOutputPath(aliyunClip.getSource() + "_invert_transcode.mp4");
                java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("log_editor_edit_transcode : ");
                sb.append(cropParam.getOutputPath());
                android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(aliyunClip.getSource());
                        parseInt = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                    } catch (java.lang.Exception unused2) {
                        outputWidth = com.aliyun.svideo.editor.view.AlivcEditView.this.mVideoParam.getOutputWidth();
                        outputHeight = com.aliyun.svideo.editor.view.AlivcEditView.this.mVideoParam.getOutputHeight();
                        try {
                            mediaMetadataRetriever.release();
                        } catch (java.io.IOException e) {
                            throw new java.lang.RuntimeException(e);
                        }
                    }
                    try {
                        if (parseInt != 90 && parseInt != 270) {
                            outputWidth = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                            outputHeight = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                            mediaMetadataRetriever.release();
                            cropParam.setOutputWidth(outputWidth);
                            cropParam.setOutputHeight(outputHeight);
                            com.aliyun.svideo.editor.view.AlivcEditView.this.mTranscoder.setCropParam(cropParam);
                            com.aliyun.svideo.editor.view.AlivcEditView.this.mTranscoder.setCropCallback(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass16.AnonymousClass1(atomicInteger, countDownLatch));
                            com.aliyun.svideo.editor.view.AlivcEditView.this.mIsTranscoding = true;
                            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mTranscoder.startCrop() == 0) {
                                return null;
                            }
                            com.aliyun.svideo.editor.view.AlivcEditView.this.post(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass16.AnonymousClass2());
                            try {
                                countDownLatch.await();
                            } catch (java.lang.InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                        mediaMetadataRetriever.release();
                        cropParam.setOutputWidth(outputWidth);
                        cropParam.setOutputHeight(outputHeight);
                        com.aliyun.svideo.editor.view.AlivcEditView.this.mTranscoder.setCropParam(cropParam);
                        com.aliyun.svideo.editor.view.AlivcEditView.this.mTranscoder.setCropCallback(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass16.AnonymousClass1(atomicInteger, countDownLatch));
                        com.aliyun.svideo.editor.view.AlivcEditView.this.mIsTranscoding = true;
                        if (com.aliyun.svideo.editor.view.AlivcEditView.this.mTranscoder.startCrop() == 0) {
                        }
                    } catch (java.io.IOException e3) {
                        throw new java.lang.RuntimeException(e3);
                    }
                    outputHeight = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                    outputWidth = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                } catch (java.lang.Throwable th) {
                    try {
                        mediaMetadataRetriever.release();
                        throw th;
                    } catch (java.io.IOException e4) {
                        throw new java.lang.RuntimeException(e4);
                    }
                }
            }
            return atomicInteger;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(java.lang.Object obj) {
            super.onPostExecute(obj);
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mIsDestroyed) {
                return;
            }
            com.aliyun.svideo.editor.view.AlivcEditView.this.mTransCodeTip.setVisibility(8);
            com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.stop();
            if (obj instanceof java.util.concurrent.atomic.AtomicInteger) {
                java.util.concurrent.atomic.AtomicInteger atomicInteger = (java.util.concurrent.atomic.AtomicInteger) obj;
                if (atomicInteger.get() == 0 || atomicInteger.get() == 2) {
                    com.aliyun.svideosdk.editor.TimeEffectType timeEffectType = this.val$type;
                    if (timeEffectType == com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_INVERT) {
                        com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.invert();
                    } else if (timeEffectType == com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_REPEAT) {
                        com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.repeat(this.val$times, this.val$startTime, this.val$duration, this.val$needDuration);
                    }
                }
            }
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mIsStop) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.isNeedResume = true;
            } else {
                com.aliyun.svideo.editor.view.AlivcEditView.this.playingResume();
            }
            com.aliyun.svideo.editor.effects.control.BaseChooser bottomView = com.aliyun.svideo.editor.view.AlivcEditView.this.mViewOperate.getBottomView();
            if (bottomView != null) {
                bottomView.setClickable(true);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$17, reason: invalid class name */
    public class AnonymousClass17 implements java.lang.Runnable {
        public AnonymousClass17() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.view.AlivcEditView.this.initThumbLineBar();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$18, reason: invalid class name */
    public class AnonymousClass18 implements android.view.View.OnClickListener {
        final /* synthetic */ com.aliyun.svideo.editor.editor.PasterUIGifImpl val$pasterUIGif;

        public AnonymousClass18(com.aliyun.svideo.editor.editor.PasterUIGifImpl pasterUIGifImpl) {
            this.val$pasterUIGif = pasterUIGifImpl;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            this.val$pasterUIGif.showAnimationDialog(com.aliyun.svideo.editor.view.AlivcEditView.this.mUseInvert);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$19, reason: invalid class name */
    public class AnonymousClass19 implements java.lang.Runnable {
        public AnonymousClass19() {
        }

        @Override // java.lang.Runnable
        public void run() {
            android.graphics.Bitmap currentFrame = com.aliyun.svideo.editor.view.AlivcEditView.this.getEditor().getCurrentFrame();
            java.lang.String str = com.aliyun.svideo.editor.view.AlivcEditView.this.getEditor().getEditorProject().getProjectDir().getAbsolutePath() + java.io.File.separator + "cover.jpeg";
            com.aliyun.common.utils.BitmapUtil.writeBitmap(str, currentFrame, android.graphics.Bitmap.CompressFormat.JPEG, 80);
            currentFrame.recycle();
            com.aliyun.svideo.editor.view.AlivcEditView.this.getEditor().updateCover(new com.aliyun.svideosdk.common.struct.project.Source(str));
            com.aliyun.svideo.editor.view.AlivcEditView.this.getEditor().saveEffectToLocal();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.view.AlivcEditView.this.targets.add(new com.aliyun.svideo.editor.guide.model.Target(com.aliyun.svideo.editor.view.AlivcEditView.this.mBottomLinear, "✨添加合适的效果，可使视频\n获得更多的点赞哦～", com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, new com.aliyun.svideo.editor.guide.shapes.Rectangle(true, com.moji.tool.DeviceTool.dp2px(8.0f), false, 0.0f, com.aliyun.svideo.editor.R.mipmap.guide_line_top, true, true)));
            com.aliyun.svideo.editor.view.AlivcEditView.this.multiLamp.build(com.aliyun.svideo.editor.view.AlivcEditView.this.targets);
            com.aliyun.svideo.editor.view.AlivcEditView.this.playingPause();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$20, reason: invalid class name */
    public class AnonymousClass20 implements java.lang.Runnable {
        final /* synthetic */ java.util.List val$animationFilters;

        public AnonymousClass20(java.util.List list) {
            this.val$animationFilters = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.view.AlivcEditView.this.mAnimationFilterController.setThumbLineBar(com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar);
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mAnimationFilterController != null) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.mAnimationFilterController.restoreAnimationFilters(this.val$animationFilters);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$21, reason: invalid class name */
    public class AnonymousClass21 implements java.lang.Runnable {
        public AnonymousClass21() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.util.EditorCommon.copyAll(com.aliyun.svideo.editor.view.AlivcEditView.this.getContext(), com.aliyun.svideo.editor.view.AlivcEditView.this.resCopy);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$22, reason: invalid class name */
    public class AnonymousClass22 implements android.content.DialogInterface.OnClickListener {
        public AnonymousClass22() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$23, reason: invalid class name */
    public class AnonymousClass23 implements com.aliyun.svideo.editor.effects.transition.TransitionChooserView.OnPreviewListener {
        public AnonymousClass23() {
        }

        @Override // com.aliyun.svideo.editor.effects.transition.TransitionChooserView.OnPreviewListener
        public void onPreview(int i, long j, boolean z) {
            long millis = java.util.concurrent.TimeUnit.MICROSECONDS.toMillis(com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getClipStartTime(i + 1));
            long j2 = millis - 1000;
            if (j2 < 0) {
                j2 = 0;
            }
            com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.seek(j2, java.util.concurrent.TimeUnit.MILLISECONDS);
            com.aliyun.svideo.editor.view.AlivcEditView.this.playingResume();
            java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onTransitionPreview: index = ");
            sb.append(i);
            sb.append(" ,clipStartTime = ");
            sb.append(millis);
            sb.append(" ,duration = ");
            sb.append(com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getDuration());
            sb.append(" ,advanceTime = ");
            sb.append(j2);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$24, reason: invalid class name */
    public class AnonymousClass24 implements com.aliyun.svideo.editor.effects.control.OnEffectActionLister {
        public AnonymousClass24() {
        }

        @Override // com.aliyun.svideo.editor.effects.control.OnEffectActionLister
        public void onCancel() {
            com.aliyun.svideo.editor.view.AlivcEditView.this.clickCancel();
        }

        @Override // com.aliyun.svideo.editor.effects.control.OnEffectActionLister
        public void onComplete() {
            com.aliyun.svideo.editor.view.AlivcEditView.this.clickConfirm();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$25, reason: invalid class name */
    public class AnonymousClass25 extends com.aliyun.svideosdk.editor.EditorCallBack {
        private int c = 0;

        /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$25$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.svideo.editor.view.AlivcEditView.this.mUseAnimationFilter) {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCanAddAnimation = false;
                    com.aliyun.svideo.editor.view.AlivcEditView.this.switchPlayStateUI(true);
                } else {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.replay();
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar.restart();
                }
            }
        }

        /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$25$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ int val$errorCode;

            public AnonymousClass2(int i) {
                this.val$errorCode = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = this.val$errorCode;
                if (i != -20004012) {
                    switch (i) {
                        case -20004002:
                            com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = com.aliyun.svideo.editor.view.AlivcEditView.this;
                            alivcEditView.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(alivcEditView.getContext(), com.aliyun.svideo.editor.view.AlivcEditView.this.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_error_tip_not_supported_audio));
                            ((android.app.Activity) com.aliyun.svideo.editor.view.AlivcEditView.this.getContext()).finish();
                            return;
                        case -20004001:
                            com.aliyun.svideo.editor.view.AlivcEditView alivcEditView2 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                            alivcEditView2.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(alivcEditView2.getContext(), com.aliyun.svideo.editor.view.AlivcEditView.this.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_error_tip_not_supported_video));
                            ((android.app.Activity) com.aliyun.svideo.editor.view.AlivcEditView.this.getContext()).finish();
                            return;
                        default:
                            switch (i) {
                                case -10008008:
                                    break;
                                case -10008007:
                                    com.aliyun.svideo.editor.view.AlivcEditView alivcEditView3 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                                    alivcEditView3.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(alivcEditView3.getContext(), this.val$errorCode + "");
                                    com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar.restart();
                                    com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.play();
                                    return;
                                case -10008006:
                                case -10008005:
                                case -10008004:
                                case -10008003:
                                case -10008002:
                                case -10008001:
                                    break;
                                default:
                                    switch (i) {
                                        case -10006004:
                                        case -10006003:
                                        case -10006002:
                                        case -10006001:
                                            break;
                                        default:
                                            switch (i) {
                                                case -10004009:
                                                case -10004007:
                                                case -10004006:
                                                case -10004005:
                                                case -10004004:
                                                case -10004003:
                                                case -10004002:
                                                case -10004001:
                                                    break;
                                                case -10004008:
                                                    com.aliyun.svideo.editor.view.AlivcEditView alivcEditView4 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                                                    alivcEditView4.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(alivcEditView4.getContext(), com.aliyun.svideo.editor.view.AlivcEditView.this.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_edit_tip_decoder_error_interrupt));
                                                    ((android.app.Activity) com.aliyun.svideo.editor.view.AlivcEditView.this.getContext()).finish();
                                                    break;
                                                default:
                                                    com.aliyun.svideo.editor.view.AlivcEditView alivcEditView5 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                                                    alivcEditView5.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(alivcEditView5.getContext(), com.aliyun.svideo.editor.view.AlivcEditView.this.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_error_tip_play_video_error));
                                                    ((android.app.Activity) com.aliyun.svideo.editor.view.AlivcEditView.this.getContext()).finish();
                                                    break;
                                            }
                                    }
                            }
                            com.aliyun.svideo.editor.view.AlivcEditView alivcEditView6 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                            alivcEditView6.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(alivcEditView6.getContext(), this.val$errorCode + "");
                            ((android.app.Activity) com.aliyun.svideo.editor.view.AlivcEditView.this.getContext()).finish();
                            return;
                    }
                }
                com.aliyun.svideo.editor.view.AlivcEditView alivcEditView7 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                alivcEditView7.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(alivcEditView7.getContext(), com.aliyun.svideo.editor.view.AlivcEditView.this.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_error_tip_not_supported_pixel_format));
                ((android.app.Activity) com.aliyun.svideo.editor.view.AlivcEditView.this.getContext()).finish();
            }
        }

        /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$25$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                long currentPlayPosition = com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getCurrentPlayPosition();
                if (!com.aliyun.svideo.editor.view.AlivcEditView.this.mUseAnimationFilter || com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getDuration() - currentPlayPosition >= 0) {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCanAddAnimation = true;
                } else {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCanAddAnimation = false;
                }
            }
        }

        /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$25$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
                if (com.aliyun.svideo.editor.view.AlivcEditView.this.mWaitForReady && com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass25.this.c > 0) {
                    java.lang.String unused2 = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mWaitForReady = false;
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.resume();
                }
                com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass25.this.c++;
            }
        }

        public AnonymousClass25() {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onCustomRender(int i, int i2, int i3) {
            return i;
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onDataReady() {
            com.aliyun.svideo.editor.view.AlivcEditView.this.post(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass25.AnonymousClass4());
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onEnd(int i) {
            com.aliyun.svideo.editor.view.AlivcEditView.this.post(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass25.AnonymousClass1());
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onError(int i) {
            java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("play error ");
            sb.append(i);
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass25.AnonymousClass2(i));
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onPlayProgress(long j, long j2) {
            com.aliyun.svideo.editor.view.AlivcEditView.this.post(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass25.AnonymousClass3());
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onTextureRender(int i, int i2, int i3) {
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.isTakeFrame) {
                if (com.aliyun.svideo.editor.view.AlivcEditView.this.mSnapshop == null) {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mSnapshop = new com.aliyun.svideo.editor.util.AlivcSnapshot();
                }
                com.aliyun.svideo.editor.view.AlivcEditView.this.mSnapshop.useTextureIDGetFrame(i, i2, i3, new java.io.File(com.aliyun.svideo.editor.view.AlivcEditView.this.PATH_THUMBNAIL));
                com.aliyun.svideo.editor.view.AlivcEditView.this.isTakeFrame = false;
            }
            return 0;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$26, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass26 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage;

        static {
            int[] iArr = new int[com.aliyun.svideo.editor.effects.control.UIEditorPage.values().length];
            $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage = iArr;
            try {
                iArr[com.aliyun.svideo.editor.effects.control.UIEditorPage.PAINT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.AUDIO_MIX.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER_EFFECT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.SOUND.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.MV.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.CAPTION.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.OVERLAY.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.FONT.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.COMPOUND_CAPTION.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.TRANSITION.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.ROLL_CAPTION.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.COVER.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.PIP.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.view.AlivcEditView.this.targets.add(new com.aliyun.svideo.editor.guide.model.Target(com.aliyun.svideo.editor.view.AlivcEditView.this.mTvRight, "✨完成编辑内容可进入下一步～", com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, new com.aliyun.svideo.editor.guide.shapes.Rectangle(false, 0.0f, true, com.moji.tool.DeviceTool.dp2px(4.0f), com.aliyun.svideo.editor.R.mipmap.guide_line_top, true, false)));
            com.aliyun.svideo.editor.view.AlivcEditView.this.multiLamp.build(com.aliyun.svideo.editor.view.AlivcEditView.this.targets);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            ((android.app.Activity) com.aliyun.svideo.editor.view.AlivcEditView.this.getContext()).finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnTouchListener {
        final /* synthetic */ android.view.GestureDetector val$mGesture;

        public AnonymousClass5(android.view.GestureDetector gestureDetector) {
            this.val$mGesture = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            return this.val$mGesture.onTouchEvent(motionEvent);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.view.AlivcEditView.this.hideBottomEditorView();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$7, reason: invalid class name */
    public class AnonymousClass7 implements com.aliyun.svideo.editor.viewoperate.ViewOperator.AnimatorListener {
        public AnonymousClass7() {
        }

        @Override // com.aliyun.svideo.editor.viewoperate.ViewOperator.AnimatorListener
        public void onHideAnimationEnd() {
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.isTakeFrameSelected) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.isTakeFrame = true;
                com.aliyun.svideo.editor.view.AlivcEditView.this.playingResume();
                com.aliyun.svideo.editor.view.AlivcEditView.this.mPlayImage.setVisibility(0);
                com.aliyun.svideo.editor.view.AlivcEditView.this.isTakeFrameSelected = false;
            }
        }

        @Override // com.aliyun.svideo.editor.viewoperate.ViewOperator.AnimatorListener
        public void onShowAnimationEnd() {
            com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.ShowAnimationEndMsg());
            if (com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass26.$SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.get(com.aliyun.svideo.editor.view.AlivcEditView.this.mTabGroup.getCheckedIndex()).ordinal()] != 1) {
                return;
            }
            com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = com.aliyun.svideo.editor.view.AlivcEditView.this;
            if (alivcEditView.mCanvasController == null) {
                int i = alivcEditView.mPasterContainer.getLayoutParams().width;
                int i2 = com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterContainer.getLayoutParams().height;
                com.aliyun.svideo.editor.view.AlivcEditView alivcEditView2 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                alivcEditView2.mCanvasController = alivcEditView2.mAliyunIEditor.obtainCanvasController(com.aliyun.svideo.editor.view.AlivcEditView.this.getContext(), i, i2);
                android.graphics.Paint paintLastApply = com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPaintLastApply();
                if (paintLastApply != null) {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCanvasController.setCurrentColor(paintLastApply.getColor());
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCanvasController.setCurrentSize(paintLastApply.getStrokeWidth());
                } else {
                    com.aliyun.svideo.editor.view.AlivcEditView alivcEditView3 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                    alivcEditView3.mCanvasController.setCurrentSize(alivcEditView3.dip2px(alivcEditView3.getContext(), 5.0f));
                }
            }
            com.aliyun.svideo.editor.view.AlivcEditView.this.mCanvasController.removeCanvas();
            android.view.View canvas = com.aliyun.svideo.editor.view.AlivcEditView.this.mCanvasController.getCanvas();
            com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterContainer.removeView(canvas);
            android.widget.FrameLayout frameLayout = com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterContainer;
            frameLayout.addView(canvas, frameLayout.getWidth(), com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterContainer.getHeight());
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$8, reason: invalid class name */
    public class AnonymousClass8 implements android.view.View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.common.utils.FastClickUtil.isFastClickActivity(com.aliyun.svideo.editor.editor.EditorActivity.class.getSimpleName())) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            com.aliyun.svideo.editor.view.AlivcEditView.this.mTvRight.setEnabled(false);
            com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.saveEffectToLocal();
            if (!com.aliyun.svideo.editor.view.AlivcEditView.this.hasCaptureCover || !com.aliyun.svideo.editor.view.AlivcEditView.this.mSnapshop.isSnapshotting()) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.jumpToNextActivity();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            com.aliyun.svideo.editor.view.AlivcEditView.this.alivcEditHandler.sendEmptyMessageDelayed(3, 500L);
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mTransitionAnimation == null) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.mTransitionAnimation = new com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog(com.aliyun.svideo.editor.view.AlivcEditView.this.getContext(), com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterContainer.getHeight());
            }
            com.aliyun.svideo.editor.view.AlivcEditView.this.mTransitionAnimation.show();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.view.AlivcEditView$9, reason: invalid class name */
    public class AnonymousClass9 implements com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener {
        public AnonymousClass9() {
        }

        @Override // com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener
        public long getCurrDuration() {
            return com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getCurrentStreamPosition();
        }

        @Override // com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener
        public long getDuration() {
            long streamDuration = com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getStreamDuration();
            java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getDuration: ");
            sb.append(streamDuration);
            return streamDuration;
        }

        @Override // com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener
        public void updateDuration(long j) {
            android.widget.TextView textView = com.aliyun.svideo.editor.view.AlivcEditView.this.mTvCurrTime;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.aliyun.svideo.editor.view.AlivcEditView.this.convertDuration2Text(j));
            sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = com.aliyun.svideo.editor.view.AlivcEditView.this;
            sb.append(alivcEditView.convertDuration2Text(alivcEditView.mAliyunIEditor.getPlayerController().getStreamDuration()));
            textView.setText(sb.toString());
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getStreamDuration() != 0) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.playProgress.setProgress((int) ((java.lang.Math.round((100 * j) / com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getStreamDuration()) / 100.0d) * 100.0d));
            }
            java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("updateDuration: ");
            sb2.append(j);
            for (com.aliyun.svideo.editor.effects.caption.listener.OnVideoUpdateDurationListener onVideoUpdateDurationListener : com.aliyun.svideo.editor.view.AlivcEditView.this.playerListenerSet) {
                if (onVideoUpdateDurationListener != null) {
                    onVideoUpdateDurationListener.onUpdateDuration(j);
                }
            }
        }
    }

    public static class AlivcEditHandler extends android.os.Handler {
        private java.lang.ref.WeakReference<com.aliyun.svideo.editor.view.AlivcEditView> reference;

        public AlivcEditHandler(com.aliyun.svideo.editor.view.AlivcEditView alivcEditView) {
            this.reference = new java.lang.ref.WeakReference<>(alivcEditView);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = this.reference.get();
            if (alivcEditView == null) {
                return;
            }
            int i = message.what;
            if (i == 1) {
                alivcEditView.addTransitionSuccess((com.aliyun.svideo.editor.effects.control.EffectInfo) message.getData().getSerializable("effectInfo"));
                return;
            }
            if (i == 2) {
                alivcEditView.playingResume();
                alivcEditView.stopTransitionAnimation();
                if (!com.aliyun.svideo.editor.view.AlivcEditView.sIsDeleteTransitionSource) {
                    alivcEditView.clickCancel();
                    return;
                } else {
                    com.aliyun.svideo.editor.view.AlivcEditView.sIsDeleteTransitionSource = false;
                    java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
                    return;
                }
            }
            if (i != 3) {
                return;
            }
            if (alivcEditView.mSnapshop.isSnapshotting()) {
                sendEmptyMessageDelayed(3, 500L);
                return;
            }
            removeMessages(3);
            alivcEditView.mTransitionAnimation.dismiss();
            alivcEditView.jumpToNextActivity();
        }
    }

    public static class AlivcEditThread implements java.util.concurrent.ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("AlivcEdit Thread");
            return thread;
        }
    }

    public class MyOnGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {
        float mPosX;
        float mPosY;
        boolean shouldDrag;

        private MyOnGestureListener() {
            this.shouldDrag = true;
        }

        public /* synthetic */ MyOnGestureListener(com.aliyun.svideo.editor.view.AlivcEditView alivcEditView, defpackage.g8 g8Var) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(android.view.MotionEvent motionEvent) {
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(android.view.MotionEvent motionEvent) {
            java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
            return super.onDoubleTapEvent(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(android.view.MotionEvent motionEvent) {
            java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect != null && com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.isPasterRemoved()) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect = null;
            }
            boolean z = false;
            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect != null) {
                java.lang.String unused2 = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
                if (!com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.isEditCompleted() && com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.contentContains(motionEvent.getX(), motionEvent.getY()) && com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.isVisibleInTime(com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getCurrentStreamPosition()) && com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.canDrag()) {
                    z = true;
                }
                this.shouldDrag = z;
            } else {
                this.shouldDrag = false;
            }
            this.mPosX = 0.0f;
            this.mPosY = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            return this.shouldDrag;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(android.view.MotionEvent motionEvent) {
            java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            if (shouldDrag()) {
                if (this.mPosX == 0.0f || this.mPosY == 0.0f) {
                    this.mPosX = motionEvent.getX();
                    this.mPosY = motionEvent.getY();
                }
                float x = motionEvent2.getX();
                float y = motionEvent2.getY();
                com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.moveContent(x - this.mPosX, y - this.mPosY);
                this.mPosX = x;
                this.mPosY = y;
            }
            return this.shouldDrag;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onShowPress(android.view.MotionEvent motionEvent) {
            java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x013f  */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onSingleTapConfirmed(android.view.MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl abstractPasterUISimpleImpl;
            java.lang.String unused = com.aliyun.svideo.editor.view.AlivcEditView.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onSingleTapConfirmed");
            sb.append(this.shouldDrag);
            if (this.shouldDrag) {
                com.aliyun.svideo.editor.view.AlivcEditView.this.playingPause();
                if (com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect instanceof com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl) {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl.updateParams(com.aliyun.svideo.editor.view.AlivcEditView.this.getIAlivcEditView(), ((com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl) com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect).getController(), com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterManager, com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar);
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.showTextEdit(com.aliyun.svideo.editor.view.AlivcEditView.this.mUseInvert);
                } else {
                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.showTextEdit(com.aliyun.svideo.editor.view.AlivcEditView.this.mUseInvert);
                }
            } else {
                com.aliyun.svideo.editor.effects.control.BaseChooser bottomView = com.aliyun.svideo.editor.view.AlivcEditView.this.mViewOperate != null ? com.aliyun.svideo.editor.view.AlivcEditView.this.mViewOperate.getBottomView() : null;
                boolean z3 = true;
                if (bottomView != null) {
                    if (com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl != null && (bottomView instanceof com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView)) {
                        com.aliyun.svideosdk.editor.AliyunIPasterController findControllerAtPoint = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.findControllerAtPoint(com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterManager, motionEvent, com.aliyun.svideo.editor.view.AlivcEditView.this.tempPointF, com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getCurrentPlayPosition());
                        if (findControllerAtPoint instanceof com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption) {
                            com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption controller = com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl.getController();
                            com.aliyun.svideo.editor.view.AlivcEditView.this.playingPause();
                            if (findControllerAtPoint != controller) {
                                if (com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect != null && !com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.isEditCompleted()) {
                                    com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.editTimeCompleted();
                                }
                                com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl.updateParams(com.aliyun.svideo.editor.view.AlivcEditView.this.getIAlivcEditView(), (com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption) findControllerAtPoint, com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterManager, com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar);
                                com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl pasterUICompoundCaptionImpl = com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl;
                                com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = com.aliyun.svideo.editor.view.AlivcEditView.this;
                                pasterUICompoundCaptionImpl.showCaptionBorderView(alivcEditView.mPasterContainer, alivcEditView.mSurfaceView);
                                com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl.showTimeEdit();
                            } else if (com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.isEditCompleted()) {
                                com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl pasterUICompoundCaptionImpl2 = com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl;
                                com.aliyun.svideo.editor.view.AlivcEditView alivcEditView2 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                                pasterUICompoundCaptionImpl2.showCaptionBorderView(alivcEditView2.mPasterContainer, alivcEditView2.mSurfaceView);
                                com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl.showTimeEdit();
                            } else {
                                com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl.updateParams(com.aliyun.svideo.editor.view.AlivcEditView.this.getIAlivcEditView(), controller, com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterManager, com.aliyun.svideo.editor.view.AlivcEditView.this.mThumbLineBar);
                                com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterUICompoundCaptionImpl.showTextEdit(com.aliyun.svideo.editor.view.AlivcEditView.this.mUseInvert);
                            }
                            com.aliyun.svideo.editor.view.AlivcEditView alivcEditView3 = com.aliyun.svideo.editor.view.AlivcEditView.this;
                            alivcEditView3.mCurrentEditEffect = alivcEditView3.mPasterUICompoundCaptionImpl;
                            com.aliyun.svideo.editor.view.AlivcEditView.this.mViewOperate.setCaptionTextView(com.aliyun.svideo.editor.effects.caption.manager.AlivcEditorViewFactory.findCaptionEditorPanelView(com.aliyun.svideo.editor.view.AlivcEditView.this.getAlivcEditView()));
                            com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.editTimeStart();
                            z = true;
                            z2 = false;
                            if (!z) {
                                for (int childCount = com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterContainer.getChildCount() - 1; childCount >= 0; childCount--) {
                                    android.view.View childAt = com.aliyun.svideo.editor.view.AlivcEditView.this.mPasterContainer.getChildAt(childCount);
                                    if ((childAt.getTag() instanceof com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) && (abstractPasterUISimpleImpl = (com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) childAt.getTag()) != null && bottomView.isHostPaster(abstractPasterUISimpleImpl)) {
                                        if (abstractPasterUISimpleImpl.isVisibleInTime(com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getCurrentStreamPosition()) && abstractPasterUISimpleImpl.contentContains(motionEvent.getX(), motionEvent.getY())) {
                                            if (com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect != null && com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect != abstractPasterUISimpleImpl && !com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.isEditCompleted()) {
                                                com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.editTimeCompleted();
                                            }
                                            com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect = abstractPasterUISimpleImpl;
                                            if (abstractPasterUISimpleImpl.isEditCompleted()) {
                                                com.aliyun.svideo.editor.view.AlivcEditView.this.playingPause();
                                                abstractPasterUISimpleImpl.editTimeStart();
                                            }
                                            z3 = false;
                                        } else if (com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect != abstractPasterUISimpleImpl && abstractPasterUISimpleImpl.isVisibleInTime(com.aliyun.svideo.editor.view.AlivcEditView.this.mAliyunIEditor.getPlayerController().getCurrentStreamPosition())) {
                                            abstractPasterUISimpleImpl.editTimeCompleted();
                                        }
                                    }
                                }
                            }
                            z3 = z2;
                        }
                    }
                    z = false;
                    z2 = true;
                    if (!z) {
                    }
                    z3 = z2;
                }
                if (z3) {
                    if (com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect != null && !com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.isEditCompleted()) {
                        com.aliyun.svideo.editor.view.AlivcEditView.this.mCurrentEditEffect.editTimeCompleted();
                    }
                    com.aliyun.svideo.editor.view.AlivcEditView.this.hideBottomEditorView();
                }
            }
            return this.shouldDrag;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
            return super.onSingleTapUp(motionEvent);
        }

        public boolean shouldDrag() {
            return this.shouldDrag;
        }
    }

    public interface OnFinishListener {
        void onComplete(com.aliyun.svideo.editor.bean.AlivcEditOutputParam alivcEditOutputParam);
    }

    public interface PlayerListener {
        long getCurrDuration();

        long getDuration();

        void updateDuration(long j);
    }

    public AlivcEditView(android.content.Context context) {
        this(context, null);
    }

    public AlivcEditView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlivcEditView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mUseInvert = false;
        this.mUseAnimationFilter = false;
        this.mCanAddAnimation = true;
        this.mIsTranscoding = false;
        this.mIsDestroyed = false;
        this.mIsStop = false;
        this.mWaitForReady = false;
        this.mVolume = 50;
        this.PATH_THUMBNAIL = com.aliyun.svideo.base.Constants.SDCardConstants.getDir(getContext()) + "thumbnail.jpg";
        this.isTakeFrame = false;
        this.isTakeFrameSelected = false;
        this.hasCaptureCover = false;
        this.mHorizontalFlip = false;
        this.mHasDeNoise = false;
        this.tempPointF = new android.graphics.PointF();
        this.playerListenerSet = new java.util.HashSet();
        this.mOnPasterRestoreListener = new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass13();
        this.mIsTransitioning = false;
        this.mPasterEffectCachetList = new java.util.ArrayList();
        this.mDurationText = new java.lang.StringBuilder(5);
        this.mOnTransitionPreviewListener = new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass23();
        this.mOnEffectActionLister = new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass24();
        this.actionTranslate = null;
        this.mEditorCallback = new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass25();
        this.isNeedResume = true;
        this.hasTailAnimation = false;
        init();
    }

    private void add2Control() {
        com.aliyun.svideo.editor.effects.control.TabViewStackBinding tabViewStackBinding = new com.aliyun.svideo.editor.effects.control.TabViewStackBinding();
        tabViewStackBinding.setViewStack(this.mViewStack);
        this.mTabGroup.setOnCheckedChangeListener(tabViewStackBinding);
        this.mTabGroup.setOnTabChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.svideo.editor.editor.PasterUICaptionImpl addCaption(com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController) {
        com.aliyun.svideo.editor.widget.AliyunPasterWithImageView aliyunPasterWithImageView = (com.aliyun.svideo.editor.widget.AliyunPasterWithImageView) android.view.View.inflate(getContext(), com.aliyun.svideo.editor.R.layout.alivc_editor_view_paster_caption, null);
        this.mPasterContainer.addView(aliyunPasterWithImageView, -1, -1);
        return new com.aliyun.svideo.editor.editor.PasterUICaptionImpl(aliyunPasterWithImageView, aliyunPasterController, this.mThumbLineBar, this.mAliyunIEditor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.svideo.editor.editor.PasterUIGifImpl addPaster(com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController) {
        com.aliyun.svideo.editor.widget.AliyunPasterWithImageView aliyunPasterWithImageView = (com.aliyun.svideo.editor.widget.AliyunPasterWithImageView) android.view.View.inflate(getContext(), com.aliyun.svideo.editor.R.layout.alivc_editor_view_paster_gif, null);
        com.aliyun.svideo.editor.editor.PasterUIGifImpl pasterUIGifImpl = new com.aliyun.svideo.editor.editor.PasterUIGifImpl(aliyunPasterWithImageView, aliyunPasterController, this.mThumbLineBar, this.mAliyunIEditor);
        ((android.widget.ImageView) aliyunPasterWithImageView.findViewById(com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_animation)).setOnClickListener(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass18(pasterUIGifImpl));
        this.mPasterContainer.addView(aliyunPasterWithImageView, -1, -1);
        return pasterUIGifImpl;
    }

    private void addPip(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        long currentPlayPosition = this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.Random random = new java.util.Random();
        int rgb = android.graphics.Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        com.aliyun.svideosdk.editor.AliyunIPipManager pipManager = this.mAliyunIEditor.getPipManager();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("newPicInPic source = ");
        sb.append(mediaInfo.filePath);
        com.aliyun.svideosdk.editor.AliyunIPipController createNewPip = pipManager.createNewPip(mediaInfo.filePath);
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MICROSECONDS;
        createNewPip.setTimelineStartTime(currentPlayPosition, timeUnit).setClipStartTime(0L, timeUnit).setBorderColor(rgb).setHorizontalFlip(this.mHorizontalFlip).apply();
        createNewPip.getLayoutController().setPosition(0.5f, 0.5f).setScale(0.3f).apply();
        createNewPip.getAudioController().setVolume(100).apply();
        playingResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.svideo.editor.editor.PasterUITextImpl addSubtitle(com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController, boolean z) {
        com.aliyun.svideo.editor.widget.AliyunPasterWithTextView aliyunPasterWithTextView = (com.aliyun.svideo.editor.widget.AliyunPasterWithTextView) android.view.View.inflate(getContext(), com.aliyun.svideo.editor.R.layout.alivc_editor_view_paster_text, null);
        this.mPasterContainer.addView(aliyunPasterWithTextView, -1, -1);
        return new com.aliyun.svideo.editor.editor.PasterUITextImpl(aliyunPasterWithTextView, aliyunPasterController, this.mThumbLineBar, this.mAliyunIEditor, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTransitionSuccess(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
        long millis = java.util.concurrent.TimeUnit.MICROSECONDS.toMillis(this.mAliyunIEditor.getClipStartTime(effectInfo.clipIndex + 1));
        long j = millis - 1000;
        if (j < 0) {
            j = 0;
        }
        this.mAliyunIEditor.seek(j, java.util.concurrent.TimeUnit.MILLISECONDS);
        playingResume();
        this.mWaitForReady = true;
        stopTransitionAnimation();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("onTransitionPreview: index = ");
        sb.append(effectInfo.clipIndex);
        sb.append(" ,clipStartTime = ");
        sb.append(millis);
        sb.append(" ,duration = ");
        sb.append(this.mAliyunIEditor.getPlayerController().getDuration());
        sb.append(" ,advanceTime = ");
        sb.append(j);
    }

    private void applyMVEffect(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
        com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean = new com.aliyun.svideosdk.common.struct.effect.EffectBean();
        effectBean.setId(effectInfo.id);
        com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController = this.mCurrentEditEffect;
        if (aliyunBasePasterController != null && !aliyunBasePasterController.isPasterRemoved()) {
            this.mCurrentEditEffect.editTimeCompleted();
        }
        java.util.List<com.aliyun.svideo.base.Form.AspectForm> list = effectInfo.list;
        java.lang.String mVPath = list != null ? com.aliyun.svideo.editor.util.EditorCommon.getMVPath(list, this.mVideoParam.getOutputWidth(), this.mVideoParam.getOutputHeight()) : null;
        effectBean.setPath(mVPath);
        effectInfo.setPath(mVPath);
        com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(mVPath);
        source.setId(java.lang.String.valueOf(effectInfo.id));
        if (!com.aliyun.common.utils.StringUtils.isEmpty(mVPath)) {
            java.lang.String path = source.getPath();
            java.lang.String str = java.io.File.separator;
            if (path.contains(str)) {
                boolean contains = mVPath.contains("aliyun_svideo_mv/");
                source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getResUri(contains ? "app" : com.aliyun.svideo.editor.util.AlivcResUtil.HOST_CLOUD, com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_MV, java.lang.String.valueOf(effectInfo.id), mVPath.substring(mVPath.lastIndexOf(str) + 1)));
            }
        }
        effectBean.setSource(source);
        effectInfo.setSource(source);
        if (mVPath == null || !new java.io.File(mVPath).exists()) {
            this.mAliyunIEditor.resetEffect(com.aliyun.svideosdk.editor.EffectType.EFFECT_TYPE_MV);
            com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream = this.lastMusicBean;
            if (trackAudioStream != null && trackAudioStream.getSource() != null && this.lastMusicBean.getSource().getPath() != null) {
                this.mAliyunIEditor.applyMusic(this.lastMusicBean);
                int streamId = this.lastMusicBean.getStreamId();
                if (this.isReplaceMusic) {
                    this.mAliyunIEditor.applyMusicMixWeight(streamId, 100);
                } else if (this.isMixRecord) {
                    this.mAliyunIEditor.applyMusicWeight(streamId, 0);
                } else {
                    this.mAliyunIEditor.applyMusicMixWeight(streamId, this.lastMusicBean.getAudioWeight());
                }
            } else if (this.isReplaceMusic) {
                this.mAliyunIEditor.applyMusicMixWeight(0, 0);
            }
        } else {
            this.mAliyunIEditor.resetEffect(com.aliyun.svideosdk.editor.EffectType.EFFECT_TYPE_MIX);
            this.mAliyunIEditor.applyMV(effectBean.toTrackMV());
            int mvAudioId = effectBean.getMvAudioId();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("editor resetEffect end:");
            sb.append(mvAudioId);
            if (this.isReplaceMusic) {
                this.mAliyunIEditor.applyMusicMixWeight(mvAudioId, 100);
            } else if (this.isMixRecord) {
                this.mAliyunIEditor.applyMusicWeight(mvAudioId, 0);
            } else {
                this.mAliyunIEditor.applyMusicMixWeight(mvAudioId, effectBean.getWeight());
            }
        }
        if (this.mUseInvert) {
            com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.mAliyunIEditor;
            aliyunIEditor.seek(aliyunIEditor.getPlayerController().getStreamDuration(), java.util.concurrent.TimeUnit.MILLISECONDS);
        } else {
            this.mAliyunIEditor.seek(0L);
        }
        this.mAliyunIEditor.resume();
        com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar = this.mThumbLineBar;
        if (overlayThumbLineBar != null) {
            overlayThumbLineBar.resume();
        }
        switchPlayStateUI(false);
    }

    private void applyTimeEffect(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
        this.mUseInvert = false;
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = this.mTimeEffectOverlay;
        if (thumbLineOverlay != null) {
            this.mThumbLineBar.removeOverlay(thumbLineOverlay);
        }
        this.mAliyunIEditor.resetEffect(com.aliyun.svideosdk.editor.EffectType.EFFECT_TYPE_TIME);
        if (effectInfo.timeEffectType.equals(com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_NONE)) {
            playingResume();
        } else if (!effectInfo.timeEffectType.equals(com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_RATE)) {
            com.aliyun.svideosdk.editor.TimeEffectType timeEffectType = effectInfo.timeEffectType;
            com.aliyun.svideosdk.editor.TimeEffectType timeEffectType2 = com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_INVERT;
            if (timeEffectType.equals(timeEffectType2)) {
                this.mUseInvert = true;
                this.mTimeEffectOverlay = this.mThumbLineBar.addOverlay(0L, 1000000L, this.mThumbLineOverlayView, 0L, false, com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME);
                checkAndTranscode(timeEffectType2, 0, 0L, 0L, false);
            } else {
                com.aliyun.svideosdk.editor.TimeEffectType timeEffectType3 = effectInfo.timeEffectType;
                com.aliyun.svideosdk.editor.TimeEffectType timeEffectType4 = com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_REPEAT;
                if (timeEffectType3.equals(timeEffectType4)) {
                    this.mTimeEffectOverlay = this.mThumbLineBar.addOverlay(effectInfo.startTime / 1000, 1000L, this.mThumbLineOverlayView, 0L, false, com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME);
                    checkAndTranscode(timeEffectType4, 3, effectInfo.startTime, 1000L, false);
                }
            }
        } else if (effectInfo.isMoment) {
            this.mTimeEffectOverlay = this.mThumbLineBar.addOverlay(effectInfo.startTime / 1000, 1000L, this.mThumbLineOverlayView, 0L, false, com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME);
            this.mAliyunIEditor.stop();
            this.mAliyunIEditor.rate(effectInfo.timeParam, effectInfo.startTime, 1000L, false);
            playingResume();
        } else {
            this.mTimeEffectOverlay = this.mThumbLineBar.addOverlay(0L, 1000000L, this.mThumbLineOverlayView, 0L, false, com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME);
            this.mAliyunIEditor.stop();
            this.mAliyunIEditor.rate(effectInfo.timeParam, 0L, 1000000L, false);
            playingResume();
        }
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay2 = this.mTimeEffectOverlay;
        if (thumbLineOverlay2 != null) {
            thumbLineOverlay2.switchState((byte) 2);
        }
    }

    private void checkAndRemoveAnimationFilter() {
        if (this.mAliyunIEditor != null) {
            com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.CheckDeleteFilter());
        }
    }

    private void checkAndRemoveEffects() {
        checkAndRemovePaster();
        checkAndRemoveTransition();
        checkAndRemoveAnimationFilter();
    }

    private void checkAndRemovePaster() {
        for (int childCount = this.mPasterContainer.getChildCount() - 1; childCount >= 0; childCount--) {
            com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController = (com.aliyun.svideo.editor.editor.AliyunBasePasterController) this.mPasterContainer.getChildAt(childCount).getTag();
            if (aliyunBasePasterController != null && !aliyunBasePasterController.isPasterExists()) {
                aliyunBasePasterController.removePaster();
            }
        }
    }

    private void checkAndRemoveTransition() {
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.mAliyunIEditor;
        if (aliyunIEditor != null) {
            java.util.List<com.aliyun.svideo.editor.effects.control.EffectInfo> checkTransitionCacheIsDelete = this.mEditorService.getTransitionEffectCache(aliyunIEditor.getSourcePartManager()).checkTransitionCacheIsDelete();
            if (checkTransitionCacheIsDelete.size() == 0) {
                return;
            }
            sIsDeleteTransitionSource = true;
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
            effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.TRANSITION;
            effectInfo.transitionType = 9;
            effectInfo.mutiEffect = checkTransitionCacheIsDelete;
            onEffectChange(effectInfo);
        }
    }

    private void checkAndTranscode(com.aliyun.svideosdk.editor.TimeEffectType timeEffectType, int i, long j, long j2, boolean z) {
        new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass16(timeEffectType, i, j, j2, z).execute(android.os.AsyncTask.THREAD_POOL_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkInvert(java.lang.String str) {
        boolean z;
        com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
        if (nativeParser.checkIfSupportedImage(str)) {
            nativeParser.release();
            nativeParser.dispose();
            return true;
        }
        nativeParser.init(str);
        boolean z2 = nativeParser.getMaxGopSize() <= 5;
        try {
        } catch (java.lang.NumberFormatException e) {
            e.getMessage();
        }
        if (java.lang.Float.parseFloat(nativeParser.getValue(13)) <= 35.0f) {
            z = true;
            nativeParser.release();
            nativeParser.dispose();
            return !z2 && z;
        }
        z = false;
        nativeParser.release();
        nativeParser.dispose();
        if (z2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickCancel() {
        com.aliyun.svideosdk.editor.AliyunPasterController addSubtitleWithStartTime;
        com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage = com.aliyun.svideo.editor.effects.control.UIEditorPage.get(this.mTabGroup.getCheckedIndex());
        com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController = this.mCurrentEditEffect;
        if (aliyunBasePasterController != null && !aliyunBasePasterController.isEditCompleted()) {
            this.mCurrentEditEffect.removePaster();
        }
        int i = com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass26.$SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[uIEditorPage.ordinal()];
        if (i == 1) {
            com.aliyun.svideosdk.editor.AliyunICanvasController aliyunICanvasController = this.mCanvasController;
            if (aliyunICanvasController != null) {
                aliyunICanvasController.cancel();
                this.mCanvasController.applyPaintCanvas();
                this.mPasterContainer.removeView(this.mCanvasController.getCanvas());
            }
        } else if (i == 2) {
            playingResume();
        } else if (i == 3) {
            playingResume();
        } else if (i == 7) {
            com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController2 = this.mCurrentEditEffect;
            if (aliyunBasePasterController2 != null && !aliyunBasePasterController2.isEditCompleted()) {
                this.mCurrentEditEffect.removePaster();
            }
            int i2 = 0;
            while (i2 < this.mPasterContainer.getChildCount()) {
                java.lang.Object tag = this.mPasterContainer.getChildAt(i2).getTag();
                if (tag != null && (tag instanceof com.aliyun.svideo.editor.editor.AliyunBasePasterController)) {
                    com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController3 = (com.aliyun.svideo.editor.editor.AliyunBasePasterController) tag;
                    if (isPasterTypeHold(aliyunBasePasterController3.getEditorPage(), uIEditorPage)) {
                        aliyunBasePasterController3.removePaster();
                        i2--;
                    }
                }
                i2++;
            }
            for (com.aliyun.svideo.editor.bean.PasterRestoreBean pasterRestoreBean : this.mPasterEffectCachetList) {
                com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase = pasterRestoreBean.getEffectBase();
                if ((effectBase instanceof com.aliyun.svideosdk.common.struct.effect.EffectCaption) && new java.io.File(effectBase.getSource().getPath()).exists()) {
                    com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption = (com.aliyun.svideosdk.common.struct.effect.EffectCaption) effectBase;
                    com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager = this.mPasterManager;
                    com.aliyun.svideosdk.common.struct.project.Source source = effectCaption.getSource();
                    long j = effectCaption.start;
                    addSubtitleWithStartTime = aliyunPasterManager.addPasterWithStartTime(source, j, effectCaption.end - j);
                } else if (effectBase instanceof com.aliyun.svideosdk.common.struct.effect.EffectText) {
                    com.aliyun.svideosdk.common.struct.effect.EffectText effectText = (com.aliyun.svideosdk.common.struct.effect.EffectText) effectBase;
                    com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager2 = this.mPasterManager;
                    java.lang.String str = effectText.text;
                    com.aliyun.svideosdk.common.struct.project.Source source2 = effectText.fontSource;
                    long j2 = effectText.start;
                    addSubtitleWithStartTime = aliyunPasterManager2.addSubtitleWithStartTime(str, source2, j2, effectText.end - j2);
                } else if ((effectBase instanceof com.aliyun.svideosdk.common.struct.effect.EffectPaster) && new java.io.File(effectBase.getSource().getPath()).exists()) {
                    com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster = (com.aliyun.svideosdk.common.struct.effect.EffectPaster) effectBase;
                    com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager3 = this.mPasterManager;
                    com.aliyun.svideosdk.common.struct.project.Source source3 = effectPaster.getSource();
                    long j3 = effectPaster.start;
                    addSubtitleWithStartTime = aliyunPasterManager3.addPasterWithStartTime(source3, j3, effectPaster.end - j3);
                }
                addSubtitleWithStartTime.setEffect(effectBase);
                addSubtitleWithStartTime.setRevert(true);
                if (addSubtitleWithStartTime.getPasterType() == 0) {
                    this.mCurrentEditEffect = addPaster(addSubtitleWithStartTime);
                }
                this.mCurrentEditEffect.showTimeEdit();
                this.mCurrentEditEffect.editTimeStart();
                this.mCurrentEditEffect.moveToCenter();
                this.mCurrentEditEffect.editTimeCompleted();
                com.aliyun.svideosdk.common.struct.effect.ActionBase frameAction = pasterRestoreBean.getFrameAction();
                com.aliyun.svideosdk.common.struct.effect.ActionBase tempFrameAction = pasterRestoreBean.getTempFrameAction();
                if (frameAction != null && (this.mCurrentEditEffect instanceof com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl)) {
                    frameAction.setTargetId(addSubtitleWithStartTime.getEffect().getViewId());
                    ((com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) this.mCurrentEditEffect).setFrameAction(frameAction);
                    ((com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) this.mCurrentEditEffect).setTempFrameAction(tempFrameAction);
                    ((com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) this.mCurrentEditEffect).setFrameSelectedPosition(pasterRestoreBean.getFrameSelectedPosition());
                    this.mAliyunIEditor.removeFrameAnimation(frameAction);
                    this.mAliyunIEditor.addFrameAnimation(frameAction);
                }
                addSubtitleWithStartTime.setRevert(false);
            }
        } else if (i == 9) {
            com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController4 = this.mCurrentEditEffect;
            if (aliyunBasePasterController4 != null && !aliyunBasePasterController4.isEditCompleted()) {
                this.mCurrentEditEffect.removePaster();
            }
        } else if (i == 11) {
            java.util.LinkedHashMap<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo> linkedHashMap = this.mTransitionCache;
            if (linkedHashMap != null && this.mTransitionParamsCache != null && !linkedHashMap.isEmpty() && !this.mTransitionParamsCache.isEmpty() && this.mTransitionCache.size() == this.mTransitionParamsCache.size()) {
                for (java.lang.Integer num : this.mTransitionCache.keySet()) {
                    for (java.lang.Integer num2 : this.mTransitionCache.keySet()) {
                        com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = this.mTransitionCache.get(num2);
                        java.util.List<com.aliyun.svideo.editor.bean.AlivcTransBean> list = this.mTransitionParamsCache.get(num2);
                        java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean> nodeTree = effectInfo.transitionBase.getNodeTree();
                        if (nodeTree != null && nodeTree.size() != 0) {
                            java.util.Iterator<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean> it = nodeTree.iterator();
                            while (it.hasNext()) {
                                java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params> params = it.next().getParams();
                                if (params != null && params.size() != 0) {
                                    if (params.size() != list.size()) {
                                        break;
                                    }
                                    for (int i3 = 0; i3 < params.size(); i3++) {
                                        com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params params2 = params.get(i3);
                                        com.aliyun.svideo.editor.bean.AlivcTransBean alivcTransBean = list.get(i3);
                                        com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum type = params2.getType();
                                        if (type == com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.INT) {
                                            params2.getValue().updateINT(java.lang.Integer.valueOf(alivcTransBean.getmIntergerValue()));
                                        } else if (type == com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.FLOAT) {
                                            params2.getValue().updateFLOAT(alivcTransBean.getmFloatValue());
                                        }
                                    }
                                }
                            }
                        }
                        this.mAliyunIEditor.updateTransition(this.mTransitionCache.get(num).clipIndex, this.mTransitionCache.get(num).transitionBase);
                    }
                    this.mAliyunIEditor.updateTransition(this.mTransitionCache.get(num).clipIndex, this.mTransitionCache.get(num).transitionBase);
                }
                this.mTransitionCache.clear();
                this.mTransitionParamsCache.clear();
            }
        } else if (i == 13) {
            this.isTakeFrameSelected = false;
            this.mPlayImage.setVisibility(0);
        }
        this.mViewOperate.hideBottomView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickConfirm() {
        com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage = com.aliyun.svideo.editor.effects.control.UIEditorPage.get(this.mTabGroup.getCheckedIndex());
        com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController = this.mCurrentEditEffect;
        if (aliyunBasePasterController != null && !aliyunBasePasterController.isPasterRemoved()) {
            this.mCurrentEditEffect.editTimeCompleted();
        }
        int i = com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass26.$SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[uIEditorPage.ordinal()];
        if (i == 1) {
            com.aliyun.svideosdk.editor.AliyunICanvasController aliyunICanvasController = this.mCanvasController;
            if (aliyunICanvasController != null) {
                aliyunICanvasController.confirm();
                this.mCanvasController.applyPaintCanvas();
                this.mPasterContainer.removeView(this.mCanvasController.getCanvas());
            }
        } else if (i == 3) {
            playingResume();
        } else if (i == 13) {
            java.util.concurrent.Executors.newSingleThreadExecutor().submit(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass19());
        }
        java.util.LinkedHashMap<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo> linkedHashMap = this.mTransitionCache;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        java.util.LinkedHashMap<java.lang.Integer, java.util.List<com.aliyun.svideo.editor.bean.AlivcTransBean>> linkedHashMap2 = this.mTransitionParamsCache;
        if (linkedHashMap2 != null) {
            linkedHashMap2.clear();
        }
        this.mViewOperate.hideBottomView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String convertDuration2Text(long j) {
        java.lang.StringBuilder sb = this.mDurationText;
        sb.delete(0, sb.length());
        float f = j / 1000.0f;
        int i = (int) ((f % 3600.0f) / 60.0f);
        int i2 = (int) (f % 60.0f);
        if (i >= 10) {
            this.mDurationText.append(i);
        } else {
            java.lang.StringBuilder sb2 = this.mDurationText;
            sb2.append("0");
            sb2.append(i);
        }
        this.mDurationText.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        if (i2 >= 10) {
            this.mDurationText.append(i2);
        } else {
            java.lang.StringBuilder sb3 = this.mDurationText;
            sb3.append("0");
            sb3.append(i2);
        }
        return this.mDurationText.toString();
    }

    private void copyAssets() {
        this.executorService.execute(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass21());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.svideo.editor.view.IAlivcEditView getIAlivcEditView() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.Nullable
    public com.aliyun.svideosdk.common.struct.effect.TransitionBase getTransitionBase(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
        switch (effectInfo.transitionType) {
            case 1:
                com.aliyun.svideosdk.common.struct.effect.TransitionTranslate transitionTranslate = new com.aliyun.svideosdk.common.struct.effect.TransitionTranslate();
                transitionTranslate.setOverlapDuration(1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                transitionTranslate.setDirection(2);
                return transitionTranslate;
            case 2:
                com.aliyun.svideosdk.common.struct.effect.TransitionTranslate transitionTranslate2 = new com.aliyun.svideosdk.common.struct.effect.TransitionTranslate();
                transitionTranslate2.setOverlapDuration(1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                transitionTranslate2.setDirection(3);
                return transitionTranslate2;
            case 3:
                com.aliyun.svideosdk.common.struct.effect.TransitionTranslate transitionTranslate3 = new com.aliyun.svideosdk.common.struct.effect.TransitionTranslate();
                transitionTranslate3.setOverlapDuration(1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                transitionTranslate3.setDirection(0);
                return transitionTranslate3;
            case 4:
                com.aliyun.svideosdk.common.struct.effect.TransitionTranslate transitionTranslate4 = new com.aliyun.svideosdk.common.struct.effect.TransitionTranslate();
                transitionTranslate4.setOverlapDuration(1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                transitionTranslate4.setDirection(1);
                return transitionTranslate4;
            case 5:
                com.aliyun.svideosdk.common.struct.effect.TransitionShutter transitionShutter = new com.aliyun.svideosdk.common.struct.effect.TransitionShutter();
                transitionShutter.setOverlapDuration(1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                transitionShutter.setLineWidth(0.1f);
                transitionShutter.setOrientation(0);
                return transitionShutter;
            case 6:
                com.aliyun.svideosdk.common.struct.effect.TransitionFade transitionFade = new com.aliyun.svideosdk.common.struct.effect.TransitionFade();
                transitionFade.setOverlapDuration(1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                return transitionFade;
            case 7:
                com.aliyun.svideosdk.common.struct.effect.TransitionFiveStar transitionFiveStar = new com.aliyun.svideosdk.common.struct.effect.TransitionFiveStar();
                transitionFiveStar.setOverlapDuration(1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                return transitionFiveStar;
            case 8:
                com.aliyun.svideosdk.common.struct.effect.TransitionCircle transitionCircle = new com.aliyun.svideosdk.common.struct.effect.TransitionCircle();
                transitionCircle.setOverlapDuration(1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                return transitionCircle;
            case 9:
                com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase = effectInfo.transitionBase;
                transitionBase.setOverlapDuration(1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                return transitionBase;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideBottomEditorView() {
        int checkedIndex = this.mTabGroup.getCheckedIndex();
        if (checkedIndex == -1) {
            return;
        }
        com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage = com.aliyun.svideo.editor.effects.control.UIEditorPage.get(checkedIndex);
        com.aliyun.svideo.editor.viewoperate.ViewOperator viewOperator = this.mViewOperate;
        if (viewOperator != null) {
            viewOperator.hideBottomEditorView(uIEditorPage);
        }
    }

    private void init() {
        com.aliyun.svideo.editor.msg.Dispatcher.getInstance().register(this);
        android.graphics.Point point = new android.graphics.Point();
        ((android.view.WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getSize(point);
        this.mScreenWidth = point.x;
        this.mScreenHeight = point.y;
        android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_edit, (android.view.ViewGroup) this, true);
        initView();
        initListView();
        add2Control();
        initThreadHandler();
        if (com.aliyun.svideo.common.utils.PermissionUtils.checkPermissionsGroup(getContext(), com.aliyun.svideo.common.utils.PermissionUtils.PERMISSION_STORAGE)) {
            copyAssets();
        }
        if (com.aliyun.svideo.editor.util.SharedPreferenceUtils.isEditPageFirstShow(getContext())) {
            com.aliyun.svideo.editor.guide.customView.MultiLamp multiLamp = new com.aliyun.svideo.editor.guide.customView.MultiLamp((android.app.Activity) getContext());
            this.multiLamp = multiLamp;
            multiLamp.addCallback(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass1());
            this.targets = new java.util.ArrayList<>();
            com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_SHORTVIDEO_EDIT_GUIDE_SW, "首页引导");
            this.mBottomLinear.post(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass2());
            this.mTvRight.post(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass3());
            com.aliyun.svideo.editor.util.SharedPreferenceUtils.setEditPageFirstShow(getContext(), false);
        }
    }

    private void initEditor() {
        com.aliyun.svideosdk.editor.EditorCallBack editorCallBack = this.mEditorCallback;
        editorCallBack.mNeedRenderCallback = 2;
        com.aliyun.svideosdk.editor.AliyunIEditor creatAliyunEditor = com.aliyun.svideosdk.editor.impl.AliyunEditorFactory.creatAliyunEditor(this.mUri, editorCallBack);
        this.mAliyunIEditor = creatAliyunEditor;
        com.aliyun.svideosdk.editor.AliyunRollCaptionComposer createRollCaptionComposer = creatAliyunEditor.createRollCaptionComposer();
        this.mAliyunRollCaptionComposer = createRollCaptionComposer;
        com.aliyun.svideo.editor.effects.control.ViewStack viewStack = this.mViewStack;
        if (viewStack != null) {
            viewStack.setAliyunRollCaptionComposer(createRollCaptionComposer);
        }
        initGlSurfaceView();
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mSurfaceView.getLayoutParams();
        com.aliyun.svideosdk.editor.AliyunPasterManager pasterManager = this.mAliyunIEditor.getPasterManager();
        this.mPasterManager = pasterManager;
        try {
            pasterManager.setDisplaySize(layoutParams.width, layoutParams.height);
            this.mPasterManager.setOnPasterRestoreListener(this.mOnPasterRestoreListener);
            this.mAnimationFilterController = new com.aliyun.svideo.editor.effects.filter.AnimationFilterController(getContext().getApplicationContext(), this.mAliyunIEditor);
            this.mAliyunIEditor.setOnAnimationRestoredListener(this);
            this.mTranscoder = com.aliyun.svideosdk.crop.impl.AliyunCropCreator.createCropInstance(getContext());
            com.aliyun.svideosdk.common.struct.common.VideoDisplayMode scaleMode = this.mVideoParam.getScaleMode();
            int init = this.mAliyunIEditor.init((android.view.SurfaceView) this.mSurfaceView, getContext().getApplicationContext());
            this.mAliyunIEditor.setDisplayMode(scaleMode);
            this.mAliyunIEditor.setVolume(this.mVolume);
            this.mAliyunIEditor.setFillBackgroundColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
            this.mAliyunIEditor.denoise(this.mAliyunIEditor.getSourcePartManager().getAllClips().get(0).getId(), this.mHasDeNoise);
            if (init != 0) {
                this.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(getContext(), getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_edit_tip_init_failed));
                ((android.app.Activity) getContext()).finish();
                return;
            }
            com.aliyun.svideosdk.common.struct.project.Filter colorEffect = this.mAliyunIEditor.getEditorProject().getColorEffect();
            if (colorEffect != null) {
                int indexOf = com.aliyun.svideo.editor.util.EditorCommon.getColorFilterList(getContext()).indexOf(colorEffect.getSource().getPath());
                if (indexOf > -1) {
                    this.mEditorService.addTabEffect(com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER, indexOf + 1);
                }
            }
            int i = -1;
            for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : this.mAliyunIEditor.getEditorProject().getTimeline().getPrimaryTrack().getVideoTrackClips()) {
                if (this.mHorizontalFlip) {
                    this.mAliyunIEditor.setHorizontalFlip(videoTrackClip.getClipId(), true);
                } else {
                    this.mAliyunIEditor.setHorizontalFlip(videoTrackClip.getClipId(), false);
                }
                java.util.Iterator<com.aliyun.svideosdk.common.struct.project.Effect> it = videoTrackClip.getEffects().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.aliyun.svideosdk.common.struct.project.Effect next = it.next();
                    if (next instanceof com.aliyun.svideosdk.common.struct.project.AudioEffect) {
                        i = ((com.aliyun.svideosdk.common.struct.project.AudioEffect) next).mEffectType.getEffectType();
                        break;
                    }
                }
                if (i != -1) {
                    break;
                }
            }
            if (i != -1) {
                this.mEditorService.addTabEffect(com.aliyun.svideo.editor.effects.control.UIEditorPage.SOUND, i);
            }
            this.mEditorService.addTabEffect(com.aliyun.svideo.editor.effects.control.UIEditorPage.MV, this.mAliyunIEditor.getMVLastApplyId());
            this.mEditorService.addTabEffect(com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER_EFFECT, this.mAliyunIEditor.getFilterLastApplyId());
            this.mEditorService.addTabEffect(com.aliyun.svideo.editor.effects.control.UIEditorPage.AUDIO_MIX, this.mAliyunIEditor.getMusicLastApplyId());
            this.mEditorService.setPaint(this.mAliyunIEditor.getPaintLastApply());
            this.mTvRight.setOnClickListener(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass8());
            com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass9 anonymousClass9 = new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass9();
            this.mPlayerListener = anonymousClass9;
            this.mViewStack.setPlayerListener(anonymousClass9);
            initThumbLineBar();
            this.mThumbLineBar.hide();
            java.util.List<com.aliyun.svideosdk.common.struct.project.TimeFilter> allTimeFilters = this.mAliyunIEditor.getEditorProject().getAllTimeFilters();
            if (allTimeFilters.size() > 0) {
                com.aliyun.svideosdk.common.struct.project.TimeFilter timeFilter = allTimeFilters.get(0);
                com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME;
                effectInfo.timeEffectType = com.aliyun.svideosdk.editor.TimeEffectType.getTypeByValue(timeFilter.getTimeFilterType());
                effectInfo.startTime = timeFilter.getStartTime() * 1000;
                effectInfo.timeParam = timeFilter.getParam();
                effectInfo.endTime = (timeFilter.getStartTime() + timeFilter.getDuration()) * 1000;
                effectInfo.isMoment = effectInfo.timeEffectType != com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_INVERT;
                onResumeTimeEffectThumbLineBar(effectInfo);
                this.mEditorService.setLastTimeEffectInfo(effectInfo);
            }
            if (new java.io.File(getContext().getExternalFilesDir("") + "/AliyunEditorDemo/tail/logo.png").exists()) {
                android.graphics.Bitmap bitmap = this.mWatermarkBitmap;
                if (bitmap == null || bitmap.isRecycled()) {
                    this.mWatermarkBitmap = android.graphics.BitmapFactory.decodeFile(getContext().getExternalFilesDir("") + "/AliyunEditorDemo/tail/logo.png");
                }
                this.mSurfaceView.post(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass10());
            }
            this.mAliyunIEditor.play();
        } catch (java.lang.Exception e) {
            this.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(getContext(), e.getMessage());
            ((android.app.Activity) getContext()).finish();
        }
    }

    private void initGlSurfaceView() {
        if (this.mVideoParam == null) {
            return;
        }
        this.mRoot.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.mScreenWidth, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(this.mScreenHeight, 1073741824));
        int measuredWidth = this.mGlSurfaceContainer.getMeasuredWidth();
        int measuredHeight = this.mGlSurfaceContainer.getMeasuredHeight();
        int outputWidth = this.mVideoParam.getOutputWidth();
        int outputHeight = this.mVideoParam.getOutputHeight();
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mSurfaceView.getLayoutParams();
        float f = measuredWidth;
        float f2 = measuredHeight;
        float f3 = outputWidth;
        float f4 = outputHeight;
        if (f / f2 < f3 / f4) {
            layoutParams.width = measuredWidth;
            layoutParams.height = java.lang.Math.round((f4 * f) / f3);
        } else {
            layoutParams.width = java.lang.Math.round((f3 * f2) / f4);
            layoutParams.height = measuredHeight;
        }
        this.mPasterContainerPoint = new android.graphics.Point(layoutParams.width, layoutParams.height);
        this.mPasterContainer.setLayoutParams(layoutParams);
        this.mSurfaceView.setLayoutParams(layoutParams);
        com.aliyun.svideo.editor.viewoperate.ViewOperator viewOperator = this.mViewOperate;
        if (viewOperator != null) {
            viewOperator.setVideoWidthAndHeight(outputWidth, outputHeight);
        }
    }

    private void initListView() {
        com.aliyun.svideo.editor.viewoperate.ViewOperator viewOperator = new com.aliyun.svideo.editor.viewoperate.ViewOperator(this, this.mActionBar, this.mSurfaceView, this.mBottomLinear, this.mPasterContainer, this.mPlayImage, this.mPlayContainer, this.mGlSurfaceContainer);
        this.mViewOperate = viewOperator;
        viewOperator.setAnimatorListener(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass7());
        this.mTvRight.setVisibility(0);
        this.mEditorService = new com.aliyun.svideo.editor.effects.control.EditorService();
        this.mTabGroup = new com.aliyun.svideo.editor.effects.control.TabGroup();
        com.aliyun.svideo.editor.effects.control.ViewStack viewStack = new com.aliyun.svideo.editor.effects.control.ViewStack(getContext(), this, this.mViewOperate);
        this.mViewStack = viewStack;
        viewStack.setEditorService(this.mEditorService);
        this.mViewStack.setEffectChange(this);
        this.mViewStack.setOnEffectActionLister(this.mOnEffectActionLister);
        this.mViewStack.setOnTransitionPreviewListener(this.mOnTransitionPreviewListener);
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_filter));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_effect_audio_mix));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_effect_overlay));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_effect_caption));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_effect_caption_old));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_effect_mv));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_effect_sound));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_effect_filter));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_effect_time));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_effect_transition));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_paint));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_cover));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_videoeq));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_roll_caption));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_pip));
        this.mTabGroup.addView(findViewById(com.aliyun.svideo.editor.R.id.tab_lut));
    }

    private void initThreadHandler() {
        this.executorService = com.aliyun.svideo.editor.util.ThreadUtil.newDynamicSingleThreadedExecutor(new com.aliyun.svideo.editor.view.AlivcEditView.AlivcEditThread());
        this.alivcEditHandler = new com.aliyun.svideo.editor.view.AlivcEditView.AlivcEditHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initThumbLineBar() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.aliyun.svideo.editor.R.dimen.aliyun_editor_size_square_thumbnail);
        android.graphics.Point point = new android.graphics.Point(dimensionPixelOffset, dimensionPixelOffset);
        com.aliyun.svideosdk.common.AliyunIThumbnailFetcher aliyunIThumbnailFetcher = this.mThumbnailFetcher;
        if (aliyunIThumbnailFetcher == null) {
            com.aliyun.svideosdk.common.AliyunIThumbnailFetcher createThumbnailFetcher = com.aliyun.svideosdk.common.impl.AliyunThumbnailFetcherFactory.createThumbnailFetcher();
            this.mThumbnailFetcher = createThumbnailFetcher;
            createThumbnailFetcher.fromConfigJson(this.mUri.getPath());
        } else if (aliyunIThumbnailFetcher.getTotalDuration() != this.mAliyunIEditor.getPlayerController().getStreamDuration()) {
            this.mAliyunIEditor.saveEffectToLocal();
            this.mThumbnailFetcher.release();
            com.aliyun.svideosdk.common.AliyunIThumbnailFetcher createThumbnailFetcher2 = com.aliyun.svideosdk.common.impl.AliyunThumbnailFetcherFactory.createThumbnailFetcher();
            this.mThumbnailFetcher = createThumbnailFetcher2;
            createThumbnailFetcher2.fromConfigJson(this.mUri.getPath());
        }
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineConfig build = new com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineConfig.Builder().thumbnailFetcher(this.mThumbnailFetcher).screenWidth(this.mScreenWidth).thumbPoint(point).thumbnailCount(this.mThumbnailFetcher.getTotalDuration() > 10000 ? (int) (this.mThumbnailFetcher.getTotalDuration() / 1000) : 10).build();
        if (this.mThumbLineBar == null) {
            this.mThumbLineBar = (com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar) findViewById(com.aliyun.svideo.editor.R.id.simplethumblinebar);
            this.mBarSeekListener = new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass11();
            this.mThumbLineOverlayView = new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass12();
        }
        this.mThumbLineBar.setup(build, this.mBarSeekListener, this.mPlayerListener);
        com.aliyun.svideo.editor.effects.filter.AnimationFilterController animationFilterController = this.mAnimationFilterController;
        if (animationFilterController != null) {
            animationFilterController.setThumbLineBar(this.mThumbLineBar);
        }
    }

    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    private void initView() {
        this.mRoot = findViewById(com.aliyun.svideo.editor.R.id.root);
        this.resCopy = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.copy_res_tip);
        this.mTransCodeTip = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.transcode_tip);
        this.mTransCodeProgress = (android.widget.ProgressBar) findViewById(com.aliyun.svideo.editor.R.id.transcode_progress);
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) findViewById(com.aliyun.svideo.editor.R.id.bar_linear);
        this.mBarLinear = linearLayout;
        linearLayout.bringToFront();
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) findViewById(com.aliyun.svideo.editor.R.id.action_bar);
        this.mActionBar = relativeLayout;
        relativeLayout.setBackgroundDrawable(null);
        this.mIvLeft = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_left);
        this.mTvRight = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_right);
        this.mIvLeft.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_back);
        this.mIvLeft.setVisibility(0);
        this.mIvLeft.setOnClickListener(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass4());
        this.mTvCurrTime = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_curr_duration);
        this.mTvCurrTime.setTypeface(android.graphics.Typeface.createFromAsset(getContext().getAssets(), "fonts/DINAlternateBold.ttf"));
        this.playProgress = (android.widget.ProgressBar) findViewById(com.aliyun.svideo.editor.R.id.play_progress);
        this.mGlSurfaceContainer = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.glsurface_view);
        this.mSurfaceView = findViewById(com.aliyun.svideo.editor.R.id.play_view);
        this.mBottomLinear = (android.widget.LinearLayout) findViewById(com.aliyun.svideo.editor.R.id.edit_bottom_tab);
        setBottomTabResource();
        this.mPasterContainer = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.pasterView);
        this.mPlayImage = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.play_button);
        android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) findViewById(com.aliyun.svideo.editor.R.id.ll_play_bar);
        this.mPlayContainer = relativeLayout2;
        relativeLayout2.bringToFront();
        this.mPlayImage.setOnClickListener(this);
        switchPlayStateUI(false);
        this.mPasterContainer.setOnTouchListener(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass5(new android.view.GestureDetector(getContext(), new com.aliyun.svideo.editor.view.AlivcEditView.MyOnGestureListener(this, null))));
        setOnClickListener(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass6());
    }

    private boolean isPasterTypeHold(com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage, com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage2) {
        com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage3 = com.aliyun.svideo.editor.effects.control.UIEditorPage.OVERLAY;
        return (uIEditorPage == uIEditorPage3 && uIEditorPage2 == uIEditorPage3) || !(uIEditorPage == uIEditorPage3 || uIEditorPage2 == uIEditorPage3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToNextActivity() {
        if (this.mOnFinishListener != null) {
            com.aliyun.svideo.editor.bean.AlivcEditOutputParam alivcEditOutputParam = new com.aliyun.svideo.editor.bean.AlivcEditOutputParam();
            alivcEditOutputParam.setConfigPath(this.mUri.getPath());
            alivcEditOutputParam.setOutputVideoHeight(this.mAliyunIEditor.getVideoHeight());
            alivcEditOutputParam.setOutputVideoWidth(this.mAliyunIEditor.getVideoWidth());
            android.graphics.Point point = this.mPasterContainerPoint;
            alivcEditOutputParam.setVideoRatio(point.x / point.y);
            alivcEditOutputParam.setVideoParam(this.mVideoParam);
            com.aliyun.svideosdk.common.struct.project.AliyunEditorProject editorProject = getEditor().getEditorProject();
            if (editorProject == null || editorProject.getCover() == null || com.aliyun.common.utils.StringUtils.isEmpty(editorProject.getCover().getPath())) {
                alivcEditOutputParam.setThumbnailPath(this.PATH_THUMBNAIL);
            } else {
                alivcEditOutputParam.setThumbnailPath(editorProject.getCover().getPath());
            }
            this.mOnFinishListener.onComplete(alivcEditOutputParam);
        }
    }

    private void onResumeTimeEffectThumbLineBar(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
        this.mUseInvert = false;
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = this.mTimeEffectOverlay;
        if (thumbLineOverlay != null) {
            this.mThumbLineBar.removeOverlay(thumbLineOverlay);
        }
        if (effectInfo.timeEffectType.equals(com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_RATE)) {
            if (effectInfo.isMoment) {
                com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar = this.mThumbLineBar;
                long j = effectInfo.startTime;
                this.mTimeEffectOverlay = overlayThumbLineBar.addOverlay(j / 1000, (effectInfo.endTime - j) / 1000, this.mThumbLineOverlayView, 0L, false, com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME);
            } else {
                this.mTimeEffectOverlay = this.mThumbLineBar.addOverlay(0L, 1000000L, this.mThumbLineOverlayView, 0L, false, com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME);
            }
        } else if (effectInfo.timeEffectType.equals(com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_INVERT)) {
            this.mUseInvert = true;
            this.mTimeEffectOverlay = this.mThumbLineBar.addOverlay(0L, 1000000L, this.mThumbLineOverlayView, 0L, false, com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME);
        } else if (effectInfo.timeEffectType.equals(com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_REPEAT)) {
            com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar2 = this.mThumbLineBar;
            long j2 = effectInfo.startTime;
            this.mTimeEffectOverlay = overlayThumbLineBar2.addOverlay(j2 / 1000, (effectInfo.endTime - j2) / 1000, this.mThumbLineOverlayView, 0L, false, com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME);
        }
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay2 = this.mTimeEffectOverlay;
        if (thumbLineOverlay2 != null) {
            thumbLineOverlay2.switchState((byte) 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetTimeLineLayout() {
        new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass17());
    }

    private void setBottomTabResource() {
        android.widget.TextView[] textViewArr = {(android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_filter), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_effect_audio_mix), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_effect_overlay), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_effect_caption), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_effect_caption_old), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_effect_mv), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_effect_sound), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_effect_filter), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_effect_time), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_effect_transition), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_paint), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_cover), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_videoeq), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_roll_caption), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_pip), (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tab_lut)};
        int[] iArr = new int[16];
        for (int i = 0; i < 16; i++) {
            iArr[i] = 1;
        }
        int i2 = com.aliyun.svideo.editor.R.attr.captionImage;
        int i3 = com.aliyun.svideo.editor.R.attr.rollCoverImage;
        int[] iArr2 = {com.aliyun.svideo.editor.R.attr.filterImage, com.aliyun.svideo.editor.R.attr.musicImage, com.aliyun.svideo.editor.R.attr.pasterImage, i2, i2, com.aliyun.svideo.editor.R.attr.mvImage, com.aliyun.svideo.editor.R.attr.sound, com.aliyun.svideo.editor.R.attr.effectImage, com.aliyun.svideo.editor.R.attr.timeImage, com.aliyun.svideo.editor.R.attr.translationImage, com.aliyun.svideo.editor.R.attr.paintImage, com.aliyun.svideo.editor.R.attr.coverImage, com.aliyun.svideo.editor.R.attr.videoEqImage, i3, com.aliyun.svideo.editor.R.attr.picInPic, com.aliyun.svideo.editor.R.attr.lutImage, i3, i2};
        int i4 = com.aliyun.svideo.editor.R.mipmap.alivc_svideo_icon_tab_filter;
        int i5 = com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_caption;
        com.aliyun.svideo.base.UIConfigManager.setImageResourceConfig(textViewArr, iArr, iArr2, new int[]{i4, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_music, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_overlay, i5, i5, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_mv, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_sound, com.aliyun.svideo.editor.R.mipmap.alivc_svideo_effect, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_time, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_transition, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_paint, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_cover, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_augmentation, i5, i4, i5, i5});
        int[] intArray = getContext().getResources().getIntArray(com.aliyun.svideo.editor.R.array.bottomItemMenuVisibleTags);
        for (int i6 = 0; i6 < 16; i6++) {
            if (intArray[i6] == 0) {
                textViewArr[i6].setVisibility(8);
            } else {
                textViewArr[i6].setVisibility(0);
            }
        }
    }

    private void setTransition(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
        if (this.mTransitionAnimation == null) {
            this.mTransitionAnimation = new com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog(getContext(), this.mPasterContainer.getHeight());
        }
        if (this.mIsTransitioning) {
            return;
        }
        startTransitionAnimation();
        java.util.List<com.aliyun.svideo.editor.effects.control.EffectInfo> list = effectInfo.mutiEffect;
        if (list == null) {
            this.executorService.execute(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass14(effectInfo, getTransitionBase(effectInfo)));
        } else if (list.size() != 0) {
            this.executorService.execute(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass15(effectInfo));
        } else {
            stopTransitionAnimation();
        }
    }

    private void setTranslateParams(int i, int i2, com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate = (com.aliyun.svideosdk.common.struct.effect.ActionTranslate) actionBase;
        actionTranslate.setToPointX(-0.1f);
        actionTranslate.setToPointY(0.88f);
        actionTranslate.setFromPointY(0.88f);
        actionTranslate.setFromPointX(-1.0f);
    }

    private void startTransitionAnimation() {
        this.mTransitionAnimation.show();
        this.mIsTransitioning = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopTransitionAnimation() {
        this.mTransitionAnimation.dismiss();
        this.mIsTransitioning = false;
    }

    @Override // com.aliyun.svideo.editor.view.IAlivcEditView
    public void addVideoUpdateListener(com.aliyun.svideo.editor.effects.caption.listener.OnVideoUpdateDurationListener onVideoUpdateDurationListener) {
        this.playerListenerSet.add(onVideoUpdateDurationListener);
    }

    public float dip2px(android.content.Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    @Override // com.aliyun.svideo.editor.view.IAlivcEditView
    public com.aliyun.svideo.editor.view.AlivcEditView getAlivcEditView() {
        return this;
    }

    @Override // com.aliyun.svideo.editor.view.IAlivcEditView
    public com.aliyun.svideosdk.editor.AliyunIEditor getAliyunIEditor() {
        return this.mAliyunIEditor;
    }

    public com.aliyun.svideosdk.editor.AliyunIEditor getEditor() {
        return this.mAliyunIEditor;
    }

    public com.aliyun.svideo.editor.view.AlivcEditView.OnFinishListener getOnFinishListener() {
        return this.mOnFinishListener;
    }

    @Override // com.aliyun.svideo.editor.view.IAlivcEditView
    public android.view.View getSufaceView() {
        return this.mSurfaceView;
    }

    public com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar getThumbLineBar() {
        return this.mThumbLineBar;
    }

    public boolean isHasRecordMusic() {
        return this.mHasRecordMusic;
    }

    public boolean isMaxRecord() {
        return this.isMixRecord;
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        if (intent == null) {
            return;
        }
        this.mViewStack.onActivityResult(i, i2, intent);
        if (2021 == i && i2 == -1) {
            java.lang.String stringExtra = intent.getStringExtra(com.aliyun.svideo.editor.publish.PublishActivity.KEY_RESULT_COVER);
            if (!com.aliyun.common.utils.StringUtils.isEmpty(stringExtra)) {
                getEditor().updateCover(new com.aliyun.svideosdk.common.struct.project.Source(stringExtra));
            }
        }
        if (i == 101) {
            java.util.ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_MEDIA_INFO);
            if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
                return;
            }
            addPip((com.aliyun.svideo.media.MediaInfo) parcelableArrayListExtra.get(0));
            return;
        }
        if (i == 300 && i2 == -1) {
            java.lang.String filePathByUri = com.aliyun.svideo.common.utils.FileUtils.getFilePathByUri(getContext(), intent.getData());
            com.aliyun.svideosdk.common.struct.effect.LUTEffectBean lUTEffectBean = new com.aliyun.svideosdk.common.struct.effect.LUTEffectBean();
            lUTEffectBean.setSource(new com.aliyun.svideosdk.common.struct.project.Source(filePathByUri));
            lUTEffectBean.setIntensity(1.0f);
            onEventLutSelected(lUTEffectBean);
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onAddPip(com.aliyun.svideo.editor.effects.pip.msg.PipAddMsg pipAddMsg) {
        playingPause();
        com.aliyun.svideo.editor.EditorMediaActivity.selectMediaOnResult((android.app.Activity) getContext(), 101);
    }

    @Override // com.aliyun.svideosdk.editor.OnAnimationFilterRestoredListener
    public void onAnimationFilterRestored(java.util.List<com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter> list) {
        this.mPasterContainer.post(new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass20(list));
    }

    public boolean onBackPressed() {
        com.aliyun.svideo.editor.viewoperate.ViewOperator viewOperator;
        if (this.mIsTranscoding) {
            this.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(getContext(), getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_edit_tip_transcode_no_operate));
            return true;
        }
        com.aliyun.svideo.editor.viewoperate.ViewOperator viewOperator2 = this.mViewOperate;
        if (viewOperator2 == null) {
            return false;
        }
        if (viewOperator2.isCaptionEditPanelShow()) {
            return true;
        }
        boolean isBottomViewShow = this.mViewOperate.isBottomViewShow();
        if (isBottomViewShow && (viewOperator = this.mViewOperate) != null) {
            viewOperator.getBottomView().onBackPressed();
            hideBottomEditorView();
        }
        return isBottomViewShow;
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onBrightnessProgressChange(com.aliyun.svideo.editor.msg.body.BrightnessProgressMsg brightnessProgressMsg) {
        java.util.Iterator<com.aliyun.svideosdk.common.struct.common.AliyunClip> it = this.mAliyunIEditor.getSourcePartManager().getAllClips().iterator();
        while (it.hasNext()) {
            this.mAliyunIEditor.setVideoAugmentation(it.next().getId(), com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.BRIGHTNESS, brightnessProgressMsg.getProgress());
        }
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor;
        if (view == this.mPlayImage && (aliyunIEditor = this.mAliyunIEditor) != null) {
            if (this.mUseAnimationFilter) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            } else if (aliyunIEditor.isPlaying()) {
                playingPause();
            } else {
                playingResume();
                com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController = this.mCurrentEditEffect;
                if (aliyunBasePasterController != null && !aliyunBasePasterController.isPasterRemoved()) {
                    this.mCurrentEditEffect.editTimeCompleted();
                }
            }
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onContrastProgressChange(com.aliyun.svideo.editor.msg.body.ContrastProgressMsg contrastProgressMsg) {
        java.util.Iterator<com.aliyun.svideosdk.common.struct.common.AliyunClip> it = this.mAliyunIEditor.getSourcePartManager().getAllClips().iterator();
        while (it.hasNext()) {
            this.mAliyunIEditor.setVideoAugmentation(it.next().getId(), com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.CONTRAST, contrastProgressMsg.getProgress());
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onDeletePip(com.aliyun.svideo.editor.effects.pip.msg.PipDeleteMsg pipDeleteMsg) {
        playingPause();
        com.aliyun.svideosdk.editor.AliyunIPipManager pipManager = this.mAliyunIEditor.getPipManager();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = pipManager.getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        pipManager.removePip(allPip.get(allPip.size() - 1));
        playingResume();
    }

    public void onDestroy() {
        this.mIsDestroyed = true;
        com.aliyun.svideo.editor.msg.Dispatcher.getInstance().unRegister(this);
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.mAliyunIEditor;
        if (aliyunIEditor != null) {
            aliyunIEditor.onDestroy();
        }
        com.aliyun.svideo.editor.effects.filter.AnimationFilterController animationFilterController = this.mAnimationFilterController;
        if (animationFilterController != null) {
            animationFilterController.destroyController();
        }
        com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar = this.mThumbLineBar;
        if (overlayThumbLineBar != null) {
            overlayThumbLineBar.stop();
        }
        com.aliyun.svideosdk.common.AliyunIThumbnailFetcher aliyunIThumbnailFetcher = this.mThumbnailFetcher;
        if (aliyunIThumbnailFetcher != null) {
            aliyunIThumbnailFetcher.release();
        }
        com.aliyun.svideosdk.editor.AliyunICanvasController aliyunICanvasController = this.mCanvasController;
        if (aliyunICanvasController != null) {
            aliyunICanvasController.release();
        }
        com.aliyun.svideosdk.crop.AliyunICrop aliyunICrop = this.mTranscoder;
        if (aliyunICrop != null) {
            if (this.mIsTranscoding) {
                aliyunICrop.cancel();
            } else {
                aliyunICrop.dispose();
            }
        }
        com.aliyun.svideo.editor.viewoperate.ViewOperator viewOperator = this.mViewOperate;
        if (viewOperator != null) {
            viewOperator.setAnimatorListener(null);
            this.mViewOperate = null;
        }
        android.animation.ObjectAnimator objectAnimator = this.animatorX;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.animatorX.addUpdateListener(null);
            this.animatorX.addListener(null);
            this.animatorX = null;
        }
        android.graphics.Bitmap bitmap = this.mWatermarkBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mWatermarkBitmap.recycle();
            this.mWatermarkBitmap = null;
        }
        java.util.concurrent.ExecutorService executorService = this.executorService;
        if (executorService != null) {
            executorService.shutdownNow();
        }
    }

    @Override // com.aliyun.svideo.editor.effects.control.OnEffectChangeListener
    public void onEffectChange(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
        com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController;
        com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean = new com.aliyun.svideosdk.common.struct.effect.EffectBean();
        effectBean.setId(effectInfo.id);
        if (effectInfo.getSource() != null) {
            effectBean.setSource(effectInfo.getSource());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("effect path ");
            sb.append(effectInfo.getSource().getPath());
        }
        switch (com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass26.$SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[effectInfo.type.ordinal()]) {
            case 2:
                if (effectInfo.isAudioMixBar) {
                    effectInfo.mixId = this.mAliyunIEditor.getMusicLastApplyId();
                } else {
                    this.mAliyunIEditor.resetEffect(com.aliyun.svideosdk.editor.EffectType.EFFECT_TYPE_MIX);
                    this.mAliyunIEditor.resetEffect(com.aliyun.svideosdk.editor.EffectType.EFFECT_TYPE_MV_AUDIO);
                    com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream = this.lastMusicBean;
                    if (trackAudioStream != null) {
                        this.mAliyunIEditor.removeMusic(trackAudioStream);
                    }
                    if (effectInfo.getSource() == null || android.text.TextUtils.isEmpty(effectInfo.getSource().getPath())) {
                        this.lastMusicBean = null;
                        com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo2 = this.mLastMVEffect;
                        if (effectInfo2 != null && effectInfo2.getSource() != null && !android.text.TextUtils.isEmpty(this.mLastMVEffect.getSource().getPath())) {
                            applyMVEffect(this.mLastMVEffect);
                        }
                    } else {
                        com.aliyun.svideosdk.common.struct.effect.TrackAudioStream.Builder source = new com.aliyun.svideosdk.common.struct.effect.TrackAudioStream.Builder().source(effectInfo.getSource());
                        long j = effectInfo.startTime;
                        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
                        com.aliyun.svideosdk.common.struct.effect.TrackAudioStream build = source.startTime(j, timeUnit).streamStartTime(effectInfo.streamStartTime, timeUnit).streamDuration(effectInfo.streamEndTime - effectInfo.streamStartTime, timeUnit).audioWeight(effectInfo.musicWeight).build();
                        this.lastMusicBean = build;
                        effectInfo.mixId = this.mAliyunIEditor.applyMusic(build);
                    }
                }
                if (this.isReplaceMusic) {
                    this.mAliyunIEditor.applyMusicMixWeight(effectInfo.mixId, 100);
                } else {
                    this.mAliyunIEditor.applyMusicMixWeight(effectInfo.mixId, effectInfo.musicWeight);
                }
                this.mAliyunIEditor.seek(0L);
                playingResume();
                break;
            case 3:
                if (effectBean.getSource() == null || !effectBean.getSource().getPath().contains("Vertigo")) {
                    this.mAliyunIEditor.applyFilter(effectBean.toTrackEffectFilter());
                    break;
                } else {
                    this.mAliyunIEditor.addAnimationFilter(new com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder().source(effectBean.getSource()).build());
                    break;
                }
                break;
            case 4:
                java.util.List<com.aliyun.svideosdk.common.struct.common.AliyunClip> allClips = this.mAliyunIEditor.getSourcePartManager().getAllClips();
                int size = allClips.size();
                if (this.mLastSoundEffect == null) {
                    java.util.Iterator<com.aliyun.svideosdk.common.struct.project.Effect> it = this.mAliyunIEditor.getEditorProject().getTimeline().getPrimaryTrack().getVideoTrackClips().get(0).getEffects().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.aliyun.svideosdk.common.struct.project.Effect next = it.next();
                            if (next.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_effect) {
                                com.aliyun.svideo.editor.effects.sound.SoundEffectInfo soundEffectInfo = new com.aliyun.svideo.editor.effects.sound.SoundEffectInfo();
                                this.mLastSoundEffect = soundEffectInfo;
                                com.aliyun.svideosdk.common.struct.project.AudioEffect audioEffect = (com.aliyun.svideosdk.common.struct.project.AudioEffect) next;
                                soundEffectInfo.audioEffectType = audioEffect.mEffectType;
                                soundEffectInfo.soundWeight = audioEffect.mEffectParam;
                            }
                        }
                    }
                }
                for (int i = 0; i < size; i++) {
                    if (this.mLastSoundEffect != null) {
                        this.mAliyunIEditor.removeAudioEffect(allClips.get(i).getId(), this.mLastSoundEffect.audioEffectType);
                    }
                    this.mAliyunIEditor.applyAudioEffect(allClips.get(i).getId(), effectInfo.audioEffectType, effectInfo.soundWeight);
                }
                this.mLastSoundEffect = effectInfo;
                java.lang.String.valueOf(effectInfo.audioEffectType);
                this.mAliyunIEditor.seek(0L);
                playingResume();
                switchPlayStateUI(false);
                break;
            case 5:
                this.mLastMVEffect = effectInfo;
                applyMVEffect(effectInfo);
                break;
            case 6:
                com.aliyun.svideosdk.editor.AliyunPasterController addPaster = this.mPasterManager.addPaster(effectInfo.getSource());
                this.mAliyunPasterController = addPaster;
                if (addPaster != null) {
                    com.aliyun.svideosdk.common.struct.effect.EffectBase effect = addPaster.getEffect();
                    if (effect instanceof com.aliyun.svideosdk.common.struct.effect.EffectCaption) {
                        com.aliyun.svideosdk.common.struct.project.Source source2 = effectInfo.fontSource;
                        if (source2 != null) {
                            source2.setPath(effectInfo.fontSource.getPath() + com.aliyun.svideo.editor.contant.CaptionConfig.FONT_NAME);
                            ((com.aliyun.svideosdk.common.struct.effect.EffectCaption) effect).fontSource = effectInfo.fontSource;
                        } else {
                            ((com.aliyun.svideosdk.common.struct.effect.EffectCaption) effect).fontSource = null;
                        }
                        this.mAliyunPasterController.setEffect(effect);
                    }
                    this.mAliyunPasterController.setPasterStartTime(this.mAliyunIEditor.getPlayerController().getCurrentStreamPosition(), java.util.concurrent.TimeUnit.MILLISECONDS);
                    com.aliyun.svideo.editor.editor.PasterUICaptionImpl addCaption = addCaption(this.mAliyunPasterController);
                    com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController2 = this.mCurrentEditEffect;
                    if (aliyunBasePasterController2 != null && !aliyunBasePasterController2.isEditCompleted()) {
                        this.mCurrentEditEffect.removePaster();
                    }
                    playingPause();
                    this.mCurrentEditEffect = addCaption;
                    addCaption.showTimeEdit();
                    break;
                } else {
                    this.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(getContext(), getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_edit_tip_captions_fail));
                    break;
                }
                break;
            case 7:
                com.aliyun.svideosdk.editor.AliyunPasterController addPaster2 = this.mPasterManager.addPaster(effectInfo.getSource());
                this.mAliyunPasterController = addPaster2;
                if (addPaster2 != null) {
                    addPaster2.setPasterStartTime(this.mAliyunIEditor.getPlayerController().getCurrentStreamPosition(), java.util.concurrent.TimeUnit.MILLISECONDS);
                    com.aliyun.svideo.editor.editor.PasterUIGifImpl addPaster3 = addPaster(this.mAliyunPasterController);
                    com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController3 = this.mCurrentEditEffect;
                    if (aliyunBasePasterController3 != null && !aliyunBasePasterController3.isEditCompleted()) {
                        this.mCurrentEditEffect.removePaster();
                    }
                    playingPause();
                    this.mCurrentEditEffect = addPaster3;
                    addPaster3.showTimeEdit();
                    break;
                } else {
                    this.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(getContext(), getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_edit_tip_gif_fail));
                    break;
                }
                break;
            case 8:
                com.aliyun.svideosdk.common.struct.project.Source source3 = effectInfo.fontSource;
                if (source3 != null) {
                    source3.setPath(effectInfo.fontSource.getPath() + com.aliyun.svideo.editor.contant.CaptionConfig.FONT_NAME);
                }
                com.aliyun.svideosdk.editor.AliyunPasterController addSubtitle = this.mPasterManager.addSubtitle((java.lang.String) null, effectInfo.fontSource);
                this.mAliyunPasterController = addSubtitle;
                if (addSubtitle != null) {
                    addSubtitle.setPasterStartTime(this.mAliyunIEditor.getPlayerController().getCurrentStreamPosition(), java.util.concurrent.TimeUnit.MILLISECONDS);
                    com.aliyun.svideo.editor.editor.PasterUITextImpl addSubtitle2 = addSubtitle(this.mAliyunPasterController, false);
                    com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController4 = this.mCurrentEditEffect;
                    if (aliyunBasePasterController4 != null && !aliyunBasePasterController4.isEditCompleted()) {
                        this.mCurrentEditEffect.removePaster();
                    }
                    playingPause();
                    this.mCurrentEditEffect = addSubtitle2;
                    addSubtitle2.showTimeEdit();
                    addSubtitle2.showTextEdit(this.mUseInvert);
                    break;
                } else {
                    this.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(getContext(), getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_edit_tip_word_fail));
                    break;
                }
            case 9:
                com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController5 = this.mCurrentEditEffect;
                if (aliyunBasePasterController5 != null && !(aliyunBasePasterController5 instanceof com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl) && !aliyunBasePasterController5.isEditCompleted()) {
                    this.mCurrentEditEffect.removePaster();
                }
                com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController6 = this.mCurrentEditEffect;
                if (aliyunBasePasterController6 instanceof com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl) {
                    aliyunBasePasterController6.editTimeCompleted();
                }
                playingPause();
                com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption addCaptionWithStartTime = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.addCaptionWithStartTime(getContext(), this.mPasterManager, null, null, this.mAliyunIEditor.getPlayerController().getCurrentPlayPosition(), com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.captionDurationBoundJudge(this.mAliyunIEditor, 1500L));
                if (addCaptionWithStartTime != null) {
                    if (this.mPasterUICompoundCaptionImpl == null) {
                        this.mPasterUICompoundCaptionImpl = new com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl();
                    }
                    com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl pasterUICompoundCaptionImpl = this.mPasterUICompoundCaptionImpl;
                    this.mCurrentEditEffect = pasterUICompoundCaptionImpl;
                    pasterUICompoundCaptionImpl.updateParams(this, addCaptionWithStartTime, this.mPasterManager, this.mThumbLineBar);
                    this.mPasterUICompoundCaptionImpl.showCaptionBorderView(this.mPasterContainer, this.mSurfaceView);
                    this.mPasterUICompoundCaptionImpl.showTimeEdit();
                    this.mPasterUICompoundCaptionImpl.editTimeStart();
                    this.mViewOperate.setCaptionTextView(com.aliyun.svideo.editor.effects.caption.manager.AlivcEditorViewFactory.findCaptionEditorPanelView(this));
                    break;
                } else {
                    this.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(getContext(), getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_edit_tip_word_fail));
                    break;
                }
                break;
            case 10:
                if (effectInfo.startTime < 0) {
                    effectInfo.startTime = java.util.concurrent.TimeUnit.MILLISECONDS.toMicros(this.mAliyunIEditor.getPlayerController().getCurrentStreamPosition());
                }
                if (this.mIsTranscoding) {
                    this.showToast = com.aliyun.svideo.editor.util.FixedToastUtils.show(getContext(), getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_edit_tip_transcode_no_operate));
                    break;
                } else {
                    if (effectInfo.timeEffectType.equals(com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_INVERT) && (aliyunBasePasterController = this.mCurrentEditEffect) != null && aliyunBasePasterController.isAddedAnimation()) {
                        com.aliyun.svideo.editor.util.FixedToastUtils.show(getContext(), getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_tip_not_support));
                    }
                    applyTimeEffect(effectInfo);
                    break;
                }
                break;
            case 11:
                if (effectInfo.isUpdateTransition) {
                    if (this.mTransitionCache == null) {
                        this.mTransitionCache = new java.util.LinkedHashMap<>();
                    }
                    if (this.mTransitionParamsCache == null) {
                        this.mTransitionParamsCache = new java.util.LinkedHashMap<>();
                    }
                    java.util.LinkedHashMap<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo> linkedHashMap = this.mTransitionCache;
                    if (linkedHashMap != null && linkedHashMap.get(java.lang.Integer.valueOf(effectInfo.clipIndex)) == null) {
                        this.mTransitionCache.put(java.lang.Integer.valueOf(effectInfo.clipIndex), effectInfo);
                        java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean> nodeTree = effectInfo.transitionBase.getNodeTree();
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        if (nodeTree != null && nodeTree.size() != 0) {
                            java.util.Iterator<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean> it2 = nodeTree.iterator();
                            while (it2.hasNext()) {
                                java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params> params = it2.next().getParams();
                                if (params != null && params.size() != 0) {
                                    for (com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params params2 : params) {
                                        com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum type = params2.getType();
                                        if (type == com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.INT) {
                                            com.aliyun.svideo.editor.bean.AlivcTransBean alivcTransBean = new com.aliyun.svideo.editor.bean.AlivcTransBean();
                                            alivcTransBean.setmType(type);
                                            if (params2.getValue().getValue() != null && params2.getValue().getValue().length > 0) {
                                                alivcTransBean.setmIntergerValue(((java.lang.Integer) params2.getValue().getValue()[0]).intValue());
                                            }
                                            arrayList.add(alivcTransBean);
                                        } else if (type == com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.FLOAT) {
                                            com.aliyun.svideo.editor.bean.AlivcTransBean alivcTransBean2 = new com.aliyun.svideo.editor.bean.AlivcTransBean();
                                            alivcTransBean2.setmType(type);
                                            if (params2.getValue().getValue() != null && params2.getValue().getValue().length > 0) {
                                                alivcTransBean2.setmFloatValue(java.lang.Float.valueOf(((java.lang.Float) params2.getValue().getValue()[0]).floatValue()));
                                            }
                                            arrayList.add(alivcTransBean2);
                                        } else {
                                            com.aliyun.svideo.editor.bean.AlivcTransBean alivcTransBean3 = new com.aliyun.svideo.editor.bean.AlivcTransBean();
                                            alivcTransBean3.setmType(type);
                                            arrayList.add(alivcTransBean3);
                                        }
                                    }
                                }
                            }
                            this.mTransitionParamsCache.put(java.lang.Integer.valueOf(effectInfo.clipIndex), arrayList);
                        }
                    }
                    effectInfo.isUpdateTransition = false;
                    this.mAliyunIEditor.updateTransition(effectInfo.clipIndex, effectInfo.transitionBase);
                    break;
                } else {
                    setTransition(effectInfo);
                    break;
                }
                break;
            case 12:
                this.mAliyunIEditor.seek(0L);
                this.mAliyunIEditor.play();
                switchPlayStateUI(false);
                break;
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onEventAnimationFilterClickUp(com.aliyun.svideo.editor.msg.body.LongClickUpAnimationFilter longClickUpAnimationFilter) {
        if (this.mUseAnimationFilter) {
            this.mUseAnimationFilter = false;
        }
        if (this.mAliyunIEditor.isPlaying()) {
            playingPause();
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onEventAnimationFilterLongClick(com.aliyun.svideo.editor.msg.body.LongClickAnimationFilter longClickAnimationFilter) {
        if (!this.mUseAnimationFilter) {
            this.mUseAnimationFilter = true;
        }
        if (this.mCanAddAnimation) {
            playingResume();
        } else {
            playingPause();
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onEventColorFilterSelected(com.aliyun.svideo.editor.msg.body.SelectColorFilter selectColorFilter) {
        com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = selectColorFilter.getEffectInfo();
        if (effectInfo == null || effectInfo.getSource() == null || android.text.TextUtils.isEmpty(effectInfo.getSource().getPath())) {
            this.mAliyunIEditor.removeFilter();
            return;
        }
        com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder source = new com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder().source(effectInfo.getSource());
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        this.mAliyunIEditor.applyFilter(source.startTime(0L, timeUnit).duration(0L, timeUnit).resId(effectInfo.id).build());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onEventFilterTabClick(com.aliyun.svideo.editor.msg.body.FilterTabClick filterTabClick) {
        if (this.mAliyunIEditor != null) {
            int position = filterTabClick.getPosition();
            if (position == 0) {
                if (this.mAliyunIEditor.isPlaying()) {
                    return;
                }
                playingResume();
            } else if (position == 1 && this.mAliyunIEditor.isPlaying()) {
                playingPause();
            }
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onEventLutSelected(com.aliyun.svideosdk.common.struct.effect.LUTEffectBean lUTEffectBean) {
        if (lUTEffectBean != null) {
            if (com.aliyun.svideo.editor.contant.EditorConstants.EFFECT_FILTER_LOCAL_LUT_CLEAR.equals(lUTEffectBean.getSource().getPath())) {
                this.mAliyunIEditor.applyLutFilter(null);
                return;
            }
            if (!com.aliyun.svideo.editor.contant.EditorConstants.EFFECT_FILTER_LOCAL_LUT_ADD.equals(lUTEffectBean.getSource().getPath())) {
                this.mAliyunIEditor.applyLutFilter(lUTEffectBean);
                return;
            }
            android.content.Intent intent = new android.content.Intent("android.intent.action.GET_CONTENT");
            intent.setType("*/*");
            intent.addCategory("android.intent.category.OPENABLE");
            ((android.app.Activity) getContext()).startActivityForResult(intent, 300);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i == 24) {
            int i2 = this.mVolume + 5;
            this.mVolume = i2;
            if (i2 > 100) {
                this.mVolume = 100;
            }
            this.mAliyunIEditor.setVolume(this.mVolume);
            return true;
        }
        if (i != 25) {
            return super.onKeyDown(i, keyEvent);
        }
        int i3 = this.mVolume - 5;
        this.mVolume = i3;
        if (i3 < 0) {
            this.mVolume = 0;
        }
        this.mAliyunIEditor.setVolume(this.mVolume);
        return true;
    }

    public void onPause() {
        this.isNeedResume = this.mAliyunIEditor.isPlaying();
        playingPause();
        this.mAliyunIEditor.saveEffectToLocal();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipAlphaProgressChange(com.aliyun.svideo.editor.effects.pip.msg.PipAlphaMsg pipAlphaMsg) {
        this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        allPip.get(allPip.size() - 1).getLayoutController().setAlpha(pipAlphaMsg.progress).apply();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipAngleProgressChange(com.aliyun.svideo.editor.effects.pip.msg.PipAngleMsg pipAngleMsg) {
        this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        allPip.get(allPip.size() - 1).getLayoutController().setRotation(pipAngleMsg.progress).apply();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipBorderProgressChange(com.aliyun.svideo.editor.effects.pip.msg.PipBorderMsg pipBorderMsg) {
        this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        allPip.get(allPip.size() - 1).setBorderWidth(pipBorderMsg.progress).apply();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipBrightnessProgressChange(com.aliyun.svideo.editor.effects.pip.msg.PipBrighnessMsg pipBrighnessMsg) {
        this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        allPip.get(allPip.size() - 1).getAugmentationController().setBrightness(pipBrighnessMsg.progress).apply();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipContrastProgressChange(com.aliyun.svideo.editor.effects.pip.msg.PipContrastMsg pipContrastMsg) {
        this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        allPip.get(allPip.size() - 1).getAugmentationController().setContrast(pipContrastMsg.progress).apply();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipCornerProgressChange(com.aliyun.svideo.editor.effects.pip.msg.PipRadiusMsg pipRadiusMsg) {
        this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        allPip.get(allPip.size() - 1).setBorderCornerRadius(pipRadiusMsg.progress).apply();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipDenoiseProgressChange(com.aliyun.svideo.editor.effects.pip.msg.PipDenoiseMsg pipDenoiseMsg) {
        this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        allPip.get(allPip.size() - 1).getAudioController().denoise(pipDenoiseMsg.progress).apply();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipEffectChanged(com.aliyun.svideo.editor.effects.pip.msg.PipEffectMsg pipEffectMsg) {
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        allPip.get(allPip.size() - 1).getAudioController().setAudioEffect(com.aliyun.svideosdk.editor.AudioEffectType.values()[new java.util.Random().nextInt(7)], 1.0f).apply();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipFrameAnimationChanged(com.aliyun.svideo.editor.effects.pip.msg.PipFrameAnimationMsg pipFrameAnimationMsg) {
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        com.aliyun.svideosdk.editor.AliyunIPipController aliyunIPipController = allPip.get(allPip.size() - 1);
        if (this.actionTranslate != null) {
            aliyunIPipController.getAnimationController().removeFrameAnimation(this.actionTranslate);
            this.actionTranslate = null;
            return;
        }
        com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
        this.actionTranslate = actionTranslate;
        actionTranslate.setFromPointX(-1.0f);
        this.actionTranslate.setFromPointY(-1.0f);
        this.actionTranslate.setToPointX(1.0f);
        this.actionTranslate.setToPointY(1.0f);
        this.actionTranslate.setStartTime(aliyunIPipController.getTimeLineStartTimeInMillis() * 1000);
        this.actionTranslate.setDuration(aliyunIPipController.getClipDurationInMillis() * 1000);
        aliyunIPipController.getAnimationController().addFrameAnimation(this.actionTranslate);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipMoveProgressChange(com.aliyun.svideo.editor.effects.pip.msg.PipMoveMsg pipMoveMsg) {
        this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        com.aliyun.svideosdk.editor.AliyunILayoutController layoutController = allPip.get(allPip.size() - 1).getLayoutController();
        float f = pipMoveMsg.progress;
        layoutController.setPosition(f, f).apply();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipSaturationProgressChange(com.aliyun.svideo.editor.effects.pip.msg.PipSaturationMsg pipSaturationMsg) {
        this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        allPip.get(allPip.size() - 1).getAugmentationController().setSaturation(pipSaturationMsg.progress).apply();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipScaleProgressChange(com.aliyun.svideo.editor.effects.pip.msg.PipScaleMsg pipScaleMsg) {
        this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        allPip.get(allPip.size() - 1).getLayoutController().setScale(pipScaleMsg.progress).apply();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipSharpnessProgressChange(com.aliyun.svideo.editor.effects.pip.msg.PipSharpnessMsg pipSharpnessMsg) {
        this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        allPip.get(allPip.size() - 1).getAugmentationController().setSharpness(pipSharpnessMsg.progress).apply();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipVignetteProgressChange(com.aliyun.svideo.editor.effects.pip.msg.PipVignetteMsg pipVignetteMsg) {
        this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        allPip.get(allPip.size() - 1).getAugmentationController().setVignette(pipVignetteMsg.progress).apply();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onPipVolumeProgressChange(com.aliyun.svideo.editor.effects.pip.msg.PipVolumeMsg pipVolumeMsg) {
        this.mAliyunIEditor.getCurrentPlayPosition();
        java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> allPip = this.mAliyunIEditor.getPipManager().getAllPip();
        if (allPip == null || allPip.size() == 0) {
            return;
        }
        allPip.get(allPip.size() - 1).getAudioController().setVolume(pipVolumeMsg.progress).apply();
    }

    public void onResume() {
        this.mTvRight.setEnabled(true);
        if (this.isNeedResume) {
            playingResume();
        }
        com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = this.mLastMVEffect;
        if (effectInfo != null) {
            java.lang.String mVPath = com.aliyun.svideo.editor.util.EditorCommon.getMVPath(effectInfo.list, this.mVideoParam.getOutputWidth(), this.mVideoParam.getOutputHeight());
            if (!android.text.TextUtils.isEmpty(mVPath) && !new java.io.File(mVPath).exists()) {
                applyMVEffect(new com.aliyun.svideo.editor.effects.control.EffectInfo());
            }
        }
        checkAndRemoveEffects();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onSaturationProgressChange(com.aliyun.svideo.editor.msg.body.SaturationProgressMsg saturationProgressMsg) {
        java.util.Iterator<com.aliyun.svideosdk.common.struct.common.AliyunClip> it = this.mAliyunIEditor.getSourcePartManager().getAllClips().iterator();
        while (it.hasNext()) {
            this.mAliyunIEditor.setVideoAugmentation(it.next().getId(), com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.SATURATION, saturationProgressMsg.getProgress());
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onSharpProgressChange(com.aliyun.svideo.editor.msg.body.SharpProgressMsg sharpProgressMsg) {
        java.util.Iterator<com.aliyun.svideosdk.common.struct.common.AliyunClip> it = this.mAliyunIEditor.getSourcePartManager().getAllClips().iterator();
        while (it.hasNext()) {
            this.mAliyunIEditor.setVideoAugmentation(it.next().getId(), com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.SHARPNESS, sharpProgressMsg.getProgress());
        }
    }

    public void onStart() {
        this.mIsStop = false;
        com.aliyun.svideo.editor.effects.control.ViewStack viewStack = this.mViewStack;
        if (viewStack != null) {
            viewStack.setVisibleStatus(true);
        }
    }

    public void onStop() {
        android.widget.TextView textView = this.mTvRight;
        if (textView != null) {
            textView.setEnabled(true);
        }
        this.mIsStop = true;
        com.aliyun.svideo.editor.effects.control.ViewStack viewStack = this.mViewStack;
        if (viewStack != null) {
            viewStack.setVisibleStatus(false);
        }
        android.widget.Toast toast = this.showToast;
        if (toast != null) {
            toast.cancel();
            this.showToast = null;
        }
    }

    @Override // com.aliyun.svideo.editor.effects.control.OnTabChangeListener
    public void onTabChange() {
        com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage = com.aliyun.svideo.editor.effects.control.UIEditorPage.get(this.mTabGroup.getCheckedIndex());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("onTabChange: page");
        sb.append(uIEditorPage.name());
        int i = com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass26.$SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[uIEditorPage.ordinal()];
        if (i == 2) {
            playingPause();
            return;
        }
        if (i == 13) {
            playingPause();
            return;
        }
        if (i == 6 || i == 7 || i == 8) {
            this.mPasterEffectCachetList.clear();
            for (int i2 = 0; i2 < this.mPasterContainer.getChildCount(); i2++) {
                java.lang.Object tag = this.mPasterContainer.getChildAt(i2).getTag();
                if (tag != null && (tag instanceof com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl)) {
                    com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl abstractPasterUISimpleImpl = (com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl) tag;
                    if (isPasterTypeHold(uIEditorPage, abstractPasterUISimpleImpl.getEditorPage())) {
                        com.aliyun.svideo.editor.bean.PasterRestoreBean pasterRestoreBean = new com.aliyun.svideo.editor.bean.PasterRestoreBean();
                        pasterRestoreBean.setFrameAction(abstractPasterUISimpleImpl.getFrameAction());
                        pasterRestoreBean.setTempFrameAction(abstractPasterUISimpleImpl.getTempFrameAction());
                        pasterRestoreBean.setFrameSelectedPosition(abstractPasterUISimpleImpl.getFrameSelectPosition());
                        com.aliyun.svideosdk.common.struct.effect.EffectBase effect = abstractPasterUISimpleImpl.getEffect();
                        if (effect instanceof com.aliyun.svideosdk.common.struct.effect.EffectCaption) {
                            com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption = new com.aliyun.svideosdk.common.struct.effect.EffectCaption("");
                            ((com.aliyun.svideosdk.common.struct.effect.EffectCaption) effect).copy(effectCaption);
                            pasterRestoreBean.setEffectBase(effectCaption);
                        } else if (effect instanceof com.aliyun.svideosdk.common.struct.effect.EffectText) {
                            com.aliyun.svideosdk.common.struct.effect.EffectText effectText = new com.aliyun.svideosdk.common.struct.effect.EffectText(new com.aliyun.svideosdk.common.struct.project.Source());
                            ((com.aliyun.svideosdk.common.struct.effect.EffectText) effect).copy(effectText);
                            pasterRestoreBean.setEffectBase(effectText);
                        } else if (effect instanceof com.aliyun.svideosdk.common.struct.effect.EffectPaster) {
                            com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster = new com.aliyun.svideosdk.common.struct.effect.EffectPaster(new com.aliyun.svideosdk.common.struct.project.Source());
                            ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) effect).copy(effectPaster);
                            pasterRestoreBean.setEffectBase(effectPaster);
                        }
                        this.mPasterEffectCachetList.add(pasterRestoreBean);
                    }
                }
            }
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onVideoEqResetAllMsg(com.aliyun.svideo.editor.msg.body.VideoEqResetAllMsg videoEqResetAllMsg) {
        for (com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip : this.mAliyunIEditor.getSourcePartManager().getAllClips()) {
            this.mAliyunIEditor.resetVideoAugmentation(aliyunClip.getId(), com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.BRIGHTNESS);
            this.mAliyunIEditor.resetVideoAugmentation(aliyunClip.getId(), com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.CONTRAST);
            this.mAliyunIEditor.resetVideoAugmentation(aliyunClip.getId(), com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.SATURATION);
            this.mAliyunIEditor.resetVideoAugmentation(aliyunClip.getId(), com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.SHARPNESS);
            this.mAliyunIEditor.resetVideoAugmentation(aliyunClip.getId(), com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.VIGNETTE);
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onVideoEqResetMsg(com.aliyun.svideo.editor.msg.body.VideoEqResetMsg videoEqResetMsg) {
        java.util.Iterator<com.aliyun.svideosdk.common.struct.common.AliyunClip> it = this.mAliyunIEditor.getSourcePartManager().getAllClips().iterator();
        while (it.hasNext()) {
            this.mAliyunIEditor.resetVideoAugmentation(it.next().getId(), videoEqResetMsg.getType());
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onVignetteCornerChange(com.aliyun.svideo.editor.msg.body.VignetteMsg vignetteMsg) {
        java.util.Iterator<com.aliyun.svideosdk.common.struct.common.AliyunClip> it = this.mAliyunIEditor.getSourcePartManager().getAllClips().iterator();
        while (it.hasNext()) {
            this.mAliyunIEditor.setVideoAugmentation(it.next().getId(), com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.VIGNETTE, vignetteMsg.getProgress());
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.mPasterContainerPoint = new android.graphics.Point(this.mSurfaceView.getWidth(), this.mSurfaceView.getHeight());
        }
    }

    public void playingPause() {
        if (this.mAliyunIEditor.isPlaying()) {
            this.mAliyunIEditor.pause();
            com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar = this.mThumbLineBar;
            if (overlayThumbLineBar != null) {
                overlayThumbLineBar.pause();
            }
            switchPlayStateUI(true);
        }
    }

    public void playingResume() {
        if (this.mAliyunIEditor.isPlaying()) {
            return;
        }
        if (this.mAliyunIEditor.isPaused()) {
            this.mAliyunIEditor.resume();
        } else {
            this.mAliyunIEditor.play();
        }
        com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar = this.mThumbLineBar;
        if (overlayThumbLineBar != null) {
            overlayThumbLineBar.resume();
        }
        switchPlayStateUI(false);
    }

    @Override // com.aliyun.svideo.editor.view.IAlivcEditView
    public void removeVideoUpdateListener(com.aliyun.svideo.editor.effects.caption.listener.OnVideoUpdateDurationListener onVideoUpdateDurationListener) {
        this.playerListenerSet.remove(onVideoUpdateDurationListener);
    }

    public void setHasDeNoise(boolean z) {
        this.mHasDeNoise = z;
    }

    public void setHasRecordMusic(boolean z) {
        this.mHasRecordMusic = z;
    }

    public void setIsMixRecord(boolean z) {
        this.isMixRecord = z;
    }

    public void setLeftOnClickListener(android.view.View.OnClickListener onClickListener) {
        android.widget.ImageView imageView = this.mIvLeft;
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void setParam(com.aliyun.svideosdk.common.struct.common.AliyunVideoParam aliyunVideoParam, android.net.Uri uri, boolean z, boolean z2, boolean z3) {
        this.hasTailAnimation = z;
        this.mUri = uri;
        this.mVideoParam = aliyunVideoParam;
        this.hasWaterMark = z2;
        this.mHorizontalFlip = z3;
        initEditor();
    }

    public void setPasterDisplayScale(float f) {
        com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager = this.mPasterManager;
        android.graphics.Point point = this.mPasterContainerPoint;
        aliyunPasterManager.setDisplaySize((int) (point.x * f), (int) (point.y * f));
    }

    public void setReplaceMusic(boolean z) {
        this.isReplaceMusic = z;
    }

    public void setmOnFinishListener(com.aliyun.svideo.editor.view.AlivcEditView.OnFinishListener onFinishListener) {
        this.mOnFinishListener = onFinishListener;
    }

    public void showMessage(int i) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setMessage(i);
        builder.setNegativeButton(com.aliyun.svideo.editor.R.string.alivc_common_cancel, new com.aliyun.svideo.editor.view.AlivcEditView.AnonymousClass22());
        builder.create().show();
    }

    public void switchPlayStateUI(boolean z) {
        if (z) {
            com.aliyun.svideo.base.UIConfigManager.setImageResourceConfig(this.mPlayImage, com.aliyun.svideo.editor.R.attr.playImage, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_play);
        } else {
            com.aliyun.svideo.base.UIConfigManager.setImageResourceConfig(this.mPlayImage, com.aliyun.svideo.editor.R.attr.pauseImage, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_pause);
        }
    }
}
