package com.aliyun.svideo.editor.viewoperate;

/* loaded from: classes12.dex */
public class ViewOperator {
    public static float SCALE_SIZE = 0.6f;
    private static final java.lang.String TAG = "ViewOperator";
    com.aliyun.svideo.editor.viewoperate.ViewOperator.AnimatorListener animatorListener;
    private android.view.View bottomMenuView;
    private com.aliyun.svideo.editor.effects.control.BaseChooser bottomView;
    private int bottomViewHeight;
    private int btnTranslationY;
    private int confirmViewHeight;
    private android.widget.FrameLayout mGlSurfaceContainer;
    private int mGlSurfaceHeight;
    private android.view.View pasterContainerView;
    private int playBtnMarginBottom;
    private android.view.View playContainer;
    private int playViewMarginTop;
    private android.view.View playerBtn;
    private int playerHeight;
    private android.view.View playerView;
    private int playerWidth;
    private android.widget.RelativeLayout rootView;
    private int rootViewHeight;
    float scaleMGlSurface;
    private android.view.View textEditorPanelView;
    private android.view.ViewGroup titleView;
    private int btnTranslationYMax = -1000;
    private int videoWidth = 0;
    private int videoHeight = 0;
    private int changeVideoWidth = 0;
    private int changeVideoHeight = 0;
    int changeGlSurfaceHeight = 0;
    int currentMGlSurfaceHeight = 0;

    /* renamed from: com.aliyun.svideo.editor.viewoperate.ViewOperator$1, reason: invalid class name */
    public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            com.aliyun.svideo.editor.viewoperate.ViewOperator.AnimatorListener animatorListener;
            float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = 1.0f - (floatValue / com.aliyun.svideo.editor.viewoperate.ViewOperator.this.bottomViewHeight);
            android.view.ViewGroup.LayoutParams layoutParams = com.aliyun.svideo.editor.viewoperate.ViewOperator.this.titleView.getLayoutParams();
            float f2 = 1.0f - f;
            layoutParams.height = (int) (com.moji.tool.DeviceTool.dp2px(43.0f) * f2);
            com.aliyun.svideo.editor.viewoperate.ViewOperator.this.titleView.setLayoutParams(layoutParams);
            com.aliyun.svideo.editor.viewoperate.ViewOperator viewOperator = com.aliyun.svideo.editor.viewoperate.ViewOperator.this;
            viewOperator.btnTranslationY = (viewOperator.playBtnMarginBottom - com.aliyun.svideo.common.utils.DensityUtils.dip2px(com.aliyun.svideo.editor.viewoperate.ViewOperator.this.rootView.getContext(), 13.0f)) - com.aliyun.svideo.editor.viewoperate.ViewOperator.this.bottomViewHeight;
            if (com.aliyun.svideo.editor.viewoperate.ViewOperator.this.btnTranslationYMax < com.aliyun.svideo.editor.viewoperate.ViewOperator.this.btnTranslationY && com.aliyun.svideo.editor.viewoperate.ViewOperator.this.btnTranslationY < 0) {
                android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.bottomMargin = (int) (com.moji.tool.DeviceTool.dp2px(165.0f) + ((-com.aliyun.svideo.editor.viewoperate.ViewOperator.this.btnTranslationY) * f));
                layoutParams2.leftMargin = com.moji.tool.DeviceTool.dp2px(38.0f);
                layoutParams2.rightMargin = com.moji.tool.DeviceTool.dp2px(38.0f);
                layoutParams2.addRule(12);
                com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playContainer.setLayoutParams(layoutParams2);
            }
            com.aliyun.svideo.editor.viewoperate.ViewOperator viewOperator2 = com.aliyun.svideo.editor.viewoperate.ViewOperator.this;
            if (viewOperator2.scaleMGlSurface > 1.0f) {
                float f3 = viewOperator2.mGlSurfaceHeight;
                com.aliyun.svideo.editor.viewoperate.ViewOperator viewOperator3 = com.aliyun.svideo.editor.viewoperate.ViewOperator.this;
                viewOperator2.currentMGlSurfaceHeight = (int) (f3 + ((viewOperator3.changeGlSurfaceHeight - viewOperator3.mGlSurfaceHeight) * f));
            } else {
                viewOperator2.currentMGlSurfaceHeight = (int) (viewOperator2.mGlSurfaceHeight - ((com.aliyun.svideo.editor.viewoperate.ViewOperator.this.mGlSurfaceHeight - com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeGlSurfaceHeight) * f));
            }
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, com.aliyun.svideo.editor.viewoperate.ViewOperator.this.currentMGlSurfaceHeight);
            layoutParams3.topMargin = com.aliyun.svideo.common.utils.DensityUtils.dip2px(com.aliyun.svideo.editor.viewoperate.ViewOperator.this.rootView.getContext(), 15.0f) + ((int) (com.aliyun.svideo.common.utils.DensityUtils.dip2px(com.aliyun.svideo.editor.viewoperate.ViewOperator.this.rootView.getContext(), 43.0f) * f2));
            layoutParams3.bottomMargin = com.aliyun.svideo.common.utils.DensityUtils.dip2px(com.aliyun.svideo.editor.viewoperate.ViewOperator.this.rootView.getContext(), 15.0f);
            com.aliyun.svideo.editor.viewoperate.ViewOperator.this.mGlSurfaceContainer.setLayoutParams(layoutParams3);
            android.view.ViewGroup.LayoutParams layoutParams4 = com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerView.getLayoutParams();
            if (com.aliyun.svideo.editor.viewoperate.ViewOperator.SCALE_SIZE > 1.0f) {
                layoutParams4.height = (int) (com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerHeight + ((com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeVideoHeight - com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerHeight) * f));
                layoutParams4.width = (int) (com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerWidth + ((com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeVideoWidth - com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerWidth) * f));
            } else {
                layoutParams4.height = (int) (com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerHeight - ((com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerHeight - com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeVideoHeight) * f));
                layoutParams4.width = (int) (com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerWidth - ((com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerWidth - com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeVideoWidth) * f));
            }
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams4 instanceof android.view.ViewGroup.MarginLayoutParams ? (android.view.ViewGroup.MarginLayoutParams) layoutParams4 : new android.view.ViewGroup.MarginLayoutParams(layoutParams4);
            marginLayoutParams.setMargins(0, 0, 0, 0);
            com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerView.setLayoutParams(marginLayoutParams);
            com.aliyun.svideo.editor.viewoperate.ViewOperator.this.pasterContainerView.setLayoutParams(marginLayoutParams);
            if (floatValue != 0.0f || (animatorListener = com.aliyun.svideo.editor.viewoperate.ViewOperator.this.animatorListener) == null) {
                return;
            }
            animatorListener.onShowAnimationEnd();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.viewoperate.ViewOperator$2, reason: invalid class name */
    public class AnonymousClass2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass2() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            int i;
            com.aliyun.svideo.editor.viewoperate.ViewOperator.AnimatorListener animatorListener;
            float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            float height = 1.0f - (floatValue / com.aliyun.svideo.editor.viewoperate.ViewOperator.this.bottomMenuView.getHeight());
            android.view.ViewGroup.LayoutParams layoutParams = com.aliyun.svideo.editor.viewoperate.ViewOperator.this.titleView.getLayoutParams();
            layoutParams.height = (int) (com.moji.tool.DeviceTool.dp2px(43.0f) * height);
            com.aliyun.svideo.editor.viewoperate.ViewOperator.this.titleView.setLayoutParams(layoutParams);
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = (int) ((com.moji.tool.DeviceTool.dp2px(165.0f) - com.aliyun.svideo.editor.viewoperate.ViewOperator.this.btnTranslationY) - ((-com.aliyun.svideo.editor.viewoperate.ViewOperator.this.btnTranslationY) * height));
            layoutParams2.leftMargin = com.moji.tool.DeviceTool.dp2px(38.0f);
            layoutParams2.rightMargin = com.moji.tool.DeviceTool.dp2px(38.0f);
            layoutParams2.addRule(12);
            com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playContainer.setLayoutParams(layoutParams2);
            com.aliyun.svideo.editor.viewoperate.ViewOperator viewOperator = com.aliyun.svideo.editor.viewoperate.ViewOperator.this;
            if (viewOperator.scaleMGlSurface > 1.0f) {
                i = (int) (viewOperator.changeGlSurfaceHeight - ((r4 - viewOperator.mGlSurfaceHeight) * height));
            } else {
                i = (int) (viewOperator.changeGlSurfaceHeight + ((viewOperator.mGlSurfaceHeight - com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeGlSurfaceHeight) * height));
            }
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, i);
            layoutParams3.topMargin = com.aliyun.svideo.common.utils.DensityUtils.dip2px(com.aliyun.svideo.editor.viewoperate.ViewOperator.this.rootView.getContext(), 15.0f) + ((int) (com.aliyun.svideo.common.utils.DensityUtils.dip2px(com.aliyun.svideo.editor.viewoperate.ViewOperator.this.rootView.getContext(), 43.0f) * height));
            layoutParams3.bottomMargin = com.aliyun.svideo.common.utils.DensityUtils.dip2px(com.aliyun.svideo.editor.viewoperate.ViewOperator.this.rootView.getContext(), 15.0f);
            com.aliyun.svideo.editor.viewoperate.ViewOperator.this.mGlSurfaceContainer.setLayoutParams(layoutParams3);
            android.view.ViewGroup.LayoutParams layoutParams4 = com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerView.getLayoutParams();
            if (com.aliyun.svideo.editor.viewoperate.ViewOperator.SCALE_SIZE > 1.0f) {
                layoutParams4.height = (int) (com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeVideoHeight - ((com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeVideoHeight - com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerHeight) * height));
                layoutParams4.width = (int) (com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeVideoWidth - ((com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeVideoWidth - com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerWidth) * height));
            } else {
                layoutParams4.height = (int) (com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeVideoHeight + ((com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerHeight - com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeVideoHeight) * height));
                layoutParams4.width = (int) (com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeVideoWidth + ((com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerWidth - com.aliyun.svideo.editor.viewoperate.ViewOperator.this.changeVideoWidth) * height));
            }
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams4 instanceof android.view.ViewGroup.MarginLayoutParams ? (android.view.ViewGroup.MarginLayoutParams) layoutParams4 : new android.view.ViewGroup.MarginLayoutParams(layoutParams4);
            marginLayoutParams.setMargins(0, 0, 0, 0);
            com.aliyun.svideo.editor.viewoperate.ViewOperator.this.playerView.setLayoutParams(marginLayoutParams);
            com.aliyun.svideo.editor.viewoperate.ViewOperator.this.pasterContainerView.setLayoutParams(marginLayoutParams);
            if (floatValue != 0.0f || (animatorListener = com.aliyun.svideo.editor.viewoperate.ViewOperator.this.animatorListener) == null) {
                return;
            }
            animatorListener.onHideAnimationEnd();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.viewoperate.ViewOperator$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage;

        static {
            int[] iArr = new int[com.aliyun.svideo.editor.effects.control.UIEditorPage.values().length];
            $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage = iArr;
            try {
                iArr[com.aliyun.svideo.editor.effects.control.UIEditorPage.LUT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.MV.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.ROLL_CAPTION.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.PIP.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public interface AnimatorListener {
        void onHideAnimationEnd();

        void onShowAnimationEnd();
    }

    public ViewOperator(android.widget.RelativeLayout relativeLayout, android.view.ViewGroup viewGroup, android.view.View view, android.view.View view2, android.view.View view3, android.view.View view4, android.view.View view5, android.widget.FrameLayout frameLayout) {
        this.rootView = relativeLayout;
        this.titleView = viewGroup;
        this.playerView = view;
        this.pasterContainerView = view3;
        this.bottomMenuView = view2;
        this.playerBtn = view4;
        this.playContainer = view5;
        this.mGlSurfaceContainer = frameLayout;
    }

    public com.aliyun.svideo.editor.effects.control.BaseChooser getBottomView() {
        return this.bottomView;
    }

    public float getPasterScaleSize(int i) {
        int calculateHeight;
        if (i == 0) {
            com.aliyun.svideo.editor.effects.overlay.OverlayChooserView overlayChooserView = new com.aliyun.svideo.editor.effects.overlay.OverlayChooserView(this.rootView.getContext());
            overlayChooserView.addThumbView(((com.aliyun.svideo.editor.view.AlivcEditView) this.rootView).getThumbLineBar());
            calculateHeight = overlayChooserView.getCalculateHeight();
        } else if (i == 1 || i == 2) {
            com.aliyun.svideo.editor.effects.caption.CaptionChooserView captionChooserView = new com.aliyun.svideo.editor.effects.caption.CaptionChooserView(this.rootView.getContext());
            captionChooserView.addThumbView(((com.aliyun.svideo.editor.view.AlivcEditView) this.rootView).getThumbLineBar());
            calculateHeight = captionChooserView.getCalculateHeight();
        } else {
            calculateHeight = 0;
        }
        float height = ((this.rootView.getHeight() - calculateHeight) - com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.rootView.getContext(), 20.0f)) / this.playerView.getHeight();
        if (height >= 0.95f) {
            return 0.95f;
        }
        return height;
    }

    public void hideBottomEditorView(com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage) {
        int i = com.aliyun.svideo.editor.viewoperate.ViewOperator.AnonymousClass3.$SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[uIEditorPage.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            hideBottomView();
        }
    }

    public void hideBottomView() {
        if (this.bottomView == null) {
            return;
        }
        this.bottomMenuView.setVisibility(0);
        android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this.bottomMenuView, "translationY", r0.getHeight(), 0.0f);
        ofFloat.setDuration(250L);
        ofFloat.addUpdateListener(new com.aliyun.svideo.editor.viewoperate.ViewOperator.AnonymousClass2());
        ofFloat.start();
        com.aliyun.svideo.base.widget.beauty.animation.AnimUitls.startDisappearAnimY(this.bottomView);
        this.bottomView.removeOwn();
        this.bottomView = null;
    }

    public boolean isBottomViewShow() {
        return this.bottomView != null;
    }

    public boolean isCaptionEditPanelShow() {
        android.view.View view = this.textEditorPanelView;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        this.textEditorPanelView.setVisibility(8);
        return true;
    }

    public void setAnimatorListener(com.aliyun.svideo.editor.viewoperate.ViewOperator.AnimatorListener animatorListener) {
        this.animatorListener = animatorListener;
    }

    public void setCaptionTextView(android.view.View view) {
        this.textEditorPanelView = view;
    }

    public void setVideoWidthAndHeight(int i, int i2) {
        this.videoHeight = i2;
        this.videoWidth = i;
    }

    public void showBottomView(com.aliyun.svideo.editor.effects.control.BaseChooser baseChooser) {
        android.widget.RelativeLayout.LayoutParams layoutParams;
        int i;
        if (this.bottomView != null) {
            return;
        }
        android.view.ViewGroup.LayoutParams layoutParams2 = this.playContainer.getLayoutParams();
        this.bottomMenuView.setVisibility(8);
        if (layoutParams2 instanceof android.view.ViewGroup.MarginLayoutParams) {
            this.playBtnMarginBottom = ((android.view.ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
        } else {
            this.playBtnMarginBottom = this.rootView.getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.alivc_svideo_btn_player_margin_b);
        }
        android.view.ViewGroup.LayoutParams layoutParams3 = this.playerView.getLayoutParams();
        if (layoutParams3 instanceof android.view.ViewGroup.MarginLayoutParams) {
            this.playViewMarginTop = ((android.view.ViewGroup.MarginLayoutParams) layoutParams3).topMargin;
        } else {
            this.playViewMarginTop = 0;
        }
        this.rootViewHeight = this.rootView.getHeight();
        this.playerWidth = this.playerView.getWidth();
        this.playerHeight = this.playerView.getHeight();
        this.mGlSurfaceHeight = this.mGlSurfaceContainer.getHeight();
        this.bottomViewHeight = baseChooser.getCalculateHeight();
        this.confirmViewHeight = this.titleView.getHeight();
        int dip2px = (this.rootViewHeight - this.bottomViewHeight) - com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.rootView.getContext(), 55.0f);
        if (this.bottomView == baseChooser) {
            return;
        }
        if (baseChooser instanceof com.aliyun.svideo.editor.effects.audiomix.MusicChooser) {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
        } else if (baseChooser instanceof com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView) {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, this.bottomViewHeight);
            layoutParams.topMargin = this.rootView.getHeight() - this.bottomViewHeight;
        } else {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
        }
        this.rootView.addView(baseChooser, layoutParams);
        if (baseChooser.isPlayerNeedZoom()) {
            int i2 = this.videoHeight;
            if (i2 > 0 && (i = this.videoWidth) > 0) {
                if (i2 > i) {
                    SCALE_SIZE = dip2px / this.playerHeight;
                } else {
                    SCALE_SIZE = com.moji.tool.DeviceTool.getScreenWidth() / this.playerWidth;
                }
                float f = this.playerWidth;
                float f2 = SCALE_SIZE;
                this.changeVideoWidth = (int) (f * f2);
                this.changeVideoHeight = (int) (this.playerHeight * f2);
            }
            int i3 = this.mGlSurfaceHeight;
            float f3 = dip2px / i3;
            this.scaleMGlSurface = f3;
            this.changeGlSurfaceHeight = (int) (i3 * f3);
            android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(baseChooser, "translationY", this.bottomViewHeight, 0.0f);
            ofFloat.setDuration(250L);
            ofFloat.addUpdateListener(new com.aliyun.svideo.editor.viewoperate.ViewOperator.AnonymousClass1());
            ofFloat.start();
        }
        this.bottomView = baseChooser;
    }
}
