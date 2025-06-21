package com.aliyun.svideo.editor.effects.control;

/* loaded from: classes12.dex */
public class ViewStack {
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.effects.control.ViewStack";
    private com.aliyun.svideosdk.editor.AliyunRollCaptionComposer mAliyunRollCaptionComposer;
    private com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView mAnimationChooserView;
    private com.aliyun.svideo.editor.effects.audiomix.MusicChooser mAudioMixChooserMediator;
    private com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView mCaptionChooserPanelView;
    private com.aliyun.svideo.editor.effects.caption.CaptionChooserView mCaptionChooserView;
    private com.aliyun.svideo.editor.effects.filter.ColorFilterChooserView mColorFilterCHoosrView;
    private final android.content.Context mContext;
    private com.aliyun.svideo.editor.effects.cover.CoverChooserView mCoverChooserView;
    private com.aliyun.svideo.editor.effects.control.EditorService mEditorService;
    private com.aliyun.svideo.editor.effects.imv.ImvChooserMediator mImvChooserMediator;
    private com.aliyun.svideo.editor.effects.lut.LutFilterChooserView mLutFilterChooserView;
    private com.aliyun.svideo.editor.effects.control.OnEffectActionLister mOnEffectActionLister;
    private com.aliyun.svideo.editor.effects.control.OnEffectChangeListener mOnEffectChangeListener;
    private com.aliyun.svideo.editor.effects.transition.TransitionChooserView.OnPreviewListener mOnPreviewListener;
    private com.aliyun.svideo.editor.effects.overlay.OverlayChooserView mOverlayChooserView;
    private com.aliyun.svideo.editor.effects.paint.PaintChooserView mPaintChooserView;
    private com.aliyun.svideo.editor.effects.pip.PipSettingView mPipSettingView;
    private com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener mPlayerListener;
    private com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView mRollCaptionEffectChooseView;
    private com.aliyun.svideo.editor.effects.sound.SoundEffectChooseView mSoundEffectChooseView;
    private com.aliyun.svideo.editor.effects.time.TimeChooserView mTimeChooserView;
    private com.aliyun.svideo.editor.effects.transition.TransitionChooserView mTransitionChooserView;
    private com.aliyun.svideo.editor.effects.videoeq.VideoEqChooserView mVideoEqChooserView;
    private com.aliyun.svideo.editor.viewoperate.ViewOperator mViewOperator;
    private com.aliyun.svideo.editor.view.AlivcEditView rootView;

    /* renamed from: com.aliyun.svideo.editor.effects.control.ViewStack$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect
        public void onColorSelect(int i) {
            if (com.aliyun.svideo.editor.effects.control.ViewStack.this.rootView.mCanvasController != null) {
                com.aliyun.svideo.editor.effects.control.ViewStack.this.rootView.mCanvasController.setCurrentColor(i);
            }
        }

        @Override // com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect
        public void onSizeSelect(float f) {
            if (com.aliyun.svideo.editor.effects.control.ViewStack.this.rootView.mCanvasController != null) {
                com.aliyun.svideo.editor.effects.control.ViewStack.this.rootView.mCanvasController.setCurrentSize(f);
            }
        }

        @Override // com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect
        public void onUndo() {
            com.aliyun.svideo.editor.effects.control.ViewStack.this.rootView.mCanvasController.undo();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.control.ViewStack$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage;

        static {
            int[] iArr = new int[com.aliyun.svideo.editor.effects.control.UIEditorPage.values().length];
            $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage = iArr;
            try {
                iArr[com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.LUT.ordinal()] = 2;
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
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.OVERLAY.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.CAPTION.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.COMPOUND_CAPTION.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.AUDIO_MIX.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.PAINT.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.TRANSITION.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.PIP.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.COVER.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.ROLL_CAPTION.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[com.aliyun.svideo.editor.effects.control.UIEditorPage.VIDEOEQ.ordinal()] = 16;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
        }
    }

    public ViewStack(android.content.Context context, com.aliyun.svideo.editor.view.AlivcEditView alivcEditView, com.aliyun.svideo.editor.viewoperate.ViewOperator viewOperator) {
        this.mContext = context;
        this.rootView = alivcEditView;
        this.mViewOperator = viewOperator;
    }

    private void setLayoutParams(com.aliyun.svideo.editor.effects.control.BaseChooser baseChooser) {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        baseChooser.setLayoutParams(layoutParams);
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        switch (i) {
            case 1001:
                com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView captionChooserPanelView = this.mCaptionChooserPanelView;
                if (captionChooserPanelView != null) {
                    captionChooserPanelView.onActivityResult(i, i2, intent);
                    break;
                }
                break;
            case 1002:
                if (this.mImvChooserMediator != null) {
                    if (i2 != -1) {
                        if (i2 == 0 && intent != null) {
                            this.mImvChooserMediator.setCurrResourceID(intent.getIntExtra("selected_id", 0));
                            break;
                        }
                    } else {
                        this.mImvChooserMediator.setCurrResourceID(intent.getIntExtra("selected_id", 0));
                        break;
                    }
                }
                break;
            case 1003:
                com.aliyun.svideo.editor.effects.overlay.OverlayChooserView overlayChooserView = this.mOverlayChooserView;
                if (overlayChooserView != null) {
                    if (i2 != -1) {
                        overlayChooserView.setCurrResourceID(-1);
                        break;
                    } else {
                        this.mOverlayChooserView.setCurrResourceID(intent.getIntExtra("selected_id", 0));
                        break;
                    }
                }
                break;
            case 1004:
                com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView animationFilterChooserView = this.mAnimationChooserView;
                if (animationFilterChooserView != null) {
                    if (i2 != -1) {
                        animationFilterChooserView.setCurrResourceID(-1);
                        break;
                    } else {
                        this.mAnimationChooserView.setCurrResourceID(intent.getIntExtra("selected_id", 0));
                        break;
                    }
                }
                break;
            case 1005:
                com.aliyun.svideo.editor.effects.transition.TransitionChooserView transitionChooserView = this.mTransitionChooserView;
                if (transitionChooserView != null) {
                    if (i2 != -1) {
                        transitionChooserView.setCurrResourceID(-1);
                        break;
                    } else {
                        this.mTransitionChooserView.setCurrResourceID(intent.getIntExtra("selected_id", 0));
                        break;
                    }
                }
                break;
            case 1006:
                if (i2 == -1 && this.mOnEffectChangeListener != null) {
                    com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                    if (intent != null) {
                        java.util.ArrayList<com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean> arrayList = (java.util.ArrayList) intent.getSerializableExtra(com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.INTENT_ROLL_CAPTION_SUBTITLE_LIST);
                        com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView rollCaptionEffectChooseView = this.mRollCaptionEffectChooseView;
                        if (rollCaptionEffectChooseView != null) {
                            rollCaptionEffectChooseView.setUseFamilyColor(false);
                            this.mRollCaptionEffectChooseView.setSubtitleList(arrayList);
                        }
                    }
                    effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.ROLL_CAPTION;
                    this.mOnEffectChangeListener.onEffectChange(effectInfo);
                    break;
                }
                break;
        }
    }

    public void setActiveIndex(int i) {
        com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage = com.aliyun.svideo.editor.effects.control.UIEditorPage.get(i);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("setActiveIndex onTabChange: page");
        sb.append(uIEditorPage);
        switch (com.aliyun.svideo.editor.effects.control.ViewStack.AnonymousClass2.$SwitchMap$com$aliyun$svideo$editor$effects$control$UIEditorPage[uIEditorPage.ordinal()]) {
            case 1:
                if (this.mColorFilterCHoosrView == null) {
                    com.aliyun.svideo.editor.effects.filter.ColorFilterChooserView colorFilterChooserView = new com.aliyun.svideo.editor.effects.filter.ColorFilterChooserView(this.mContext);
                    this.mColorFilterCHoosrView = colorFilterChooserView;
                    colorFilterChooserView.setEditorService(this.mEditorService);
                    this.mColorFilterCHoosrView.setSelectedPos(this.mEditorService.getEffectIndex(com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER));
                    this.mColorFilterCHoosrView.setOnEffectActionLister(this.mOnEffectActionLister);
                }
                this.mViewOperator.showBottomView(this.mColorFilterCHoosrView);
                com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_SHORTVIDEO_EDIT_EFFECT_CK, "滤镜");
                break;
            case 2:
                if (this.mLutFilterChooserView == null) {
                    com.aliyun.svideo.editor.effects.lut.LutFilterChooserView lutFilterChooserView = new com.aliyun.svideo.editor.effects.lut.LutFilterChooserView(this.mContext);
                    this.mLutFilterChooserView = lutFilterChooserView;
                    lutFilterChooserView.setSelectedPos(this.mEditorService.getEffectIndex(com.aliyun.svideo.editor.effects.control.UIEditorPage.LUT));
                }
                this.mViewOperator.showBottomView(this.mLutFilterChooserView);
                break;
            case 3:
                com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView animationFilterChooserView = new com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView(this.mContext);
                this.mAnimationChooserView = animationFilterChooserView;
                animationFilterChooserView.setEditorService(this.mEditorService);
                this.mAnimationChooserView.setFirstShow(com.aliyun.svideo.editor.util.SharedPreferenceUtils.isAnimationEffectFirstShow(this.mContext));
                this.mAnimationChooserView.setFirstShowEffect(com.aliyun.svideo.editor.util.SharedPreferenceUtils.isEditPageEffectFirstShow(this.mContext));
                this.mAnimationChooserView.setOnEffectChangeListener(this.mOnEffectChangeListener);
                this.mAnimationChooserView.setPlayerListener(this.mPlayerListener);
                this.mAnimationChooserView.addThumbView(this.rootView.getThumbLineBar());
                this.mAnimationChooserView.setOnEffectActionLister(this.mOnEffectActionLister);
                this.mViewOperator.showBottomView(this.mAnimationChooserView);
                com.aliyun.svideo.editor.util.SharedPreferenceUtils.setEditPageEffectFirstShow(this.mContext, false);
                com.aliyun.svideo.editor.util.SharedPreferenceUtils.setAnimationEffectFirstShow(this.mContext, false);
                com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_SHORTVIDEO_EDIT_EFFECT_CK, "特效");
                break;
            case 4:
                if (!this.rootView.isHasRecordMusic()) {
                    if (this.mSoundEffectChooseView == null) {
                        com.aliyun.svideo.editor.effects.sound.SoundEffectChooseView soundEffectChooseView = new com.aliyun.svideo.editor.effects.sound.SoundEffectChooseView(this.mContext);
                        this.mSoundEffectChooseView = soundEffectChooseView;
                        soundEffectChooseView.setEditorService(this.mEditorService);
                        this.mSoundEffectChooseView.setOnEffectActionLister(this.mOnEffectActionLister);
                        this.mSoundEffectChooseView.setSelectedPos(this.mEditorService.getEffectIndex(com.aliyun.svideo.editor.effects.control.UIEditorPage.SOUND));
                    }
                    this.mSoundEffectChooseView.setOnEffectChangeListener(this.mOnEffectChangeListener);
                    this.mViewOperator.showBottomView(this.mSoundEffectChooseView);
                    com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_SHORTVIDEO_EDIT_EFFECT_CK, "音效");
                    break;
                } else {
                    android.content.Context context = this.mContext;
                    com.aliyun.svideo.editor.util.FixedToastUtils.show(context, context.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_sound_not_support));
                    break;
                }
            case 5:
                com.aliyun.svideo.editor.effects.imv.ImvChooserMediator imvChooserMediator = new com.aliyun.svideo.editor.effects.imv.ImvChooserMediator(this.mContext);
                this.mImvChooserMediator = imvChooserMediator;
                imvChooserMediator.setEditorService(this.mEditorService);
                this.mImvChooserMediator.setOnEffectChangeListener(this.mOnEffectChangeListener);
                this.mViewOperator.showBottomView(this.mImvChooserMediator);
                break;
            case 6:
                com.aliyun.svideo.editor.effects.overlay.OverlayChooserView overlayChooserView = new com.aliyun.svideo.editor.effects.overlay.OverlayChooserView(this.mContext);
                this.mOverlayChooserView = overlayChooserView;
                overlayChooserView.setEditorService(this.mEditorService);
                this.mOverlayChooserView.setOnEffectChangeListener(this.mOnEffectChangeListener);
                this.mOverlayChooserView.setOnEffectActionLister(this.mOnEffectActionLister);
                setLayoutParams(this.mOverlayChooserView);
                this.mOverlayChooserView.addThumbView(this.rootView.getThumbLineBar());
                this.mViewOperator.showBottomView(this.mOverlayChooserView);
                break;
            case 7:
                com.aliyun.svideo.editor.effects.caption.CaptionChooserView captionChooserView = new com.aliyun.svideo.editor.effects.caption.CaptionChooserView(this.mContext);
                this.mCaptionChooserView = captionChooserView;
                captionChooserView.setEditorService(this.mEditorService);
                this.mCaptionChooserView.setOnEffectChangeListener(this.mOnEffectChangeListener);
                this.mCaptionChooserView.setOnEffectActionLister(this.mOnEffectActionLister);
                setLayoutParams(this.mCaptionChooserView);
                this.mCaptionChooserView.addThumbView(this.rootView.getThumbLineBar());
                this.mViewOperator.showBottomView(this.mCaptionChooserView);
                break;
            case 8:
                if (this.mCaptionChooserPanelView == null) {
                    this.mCaptionChooserPanelView = new com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView(this.mContext);
                }
                this.mCaptionChooserPanelView.setEditorService(this.mEditorService);
                this.mCaptionChooserPanelView.setOnEffectChangeListener(this.mOnEffectChangeListener);
                this.mCaptionChooserPanelView.setOnEffectActionLister(this.mOnEffectActionLister);
                setLayoutParams(this.mCaptionChooserPanelView);
                this.mCaptionChooserPanelView.addThumbView(this.rootView.getThumbLineBar());
                this.mViewOperator.showBottomView(this.mCaptionChooserPanelView);
                break;
            case 9:
                if (!this.rootView.isMaxRecord()) {
                    if (this.mAudioMixChooserMediator == null) {
                        com.aliyun.svideo.editor.effects.audiomix.MusicChooser musicChooser = new com.aliyun.svideo.editor.effects.audiomix.MusicChooser(this.mContext);
                        this.mAudioMixChooserMediator = musicChooser;
                        musicChooser.setOnEffectChangeListener(this.mOnEffectChangeListener);
                        this.mAudioMixChooserMediator.setOnEffectActionLister(this.mOnEffectActionLister);
                    }
                    this.mAudioMixChooserMediator.setStreamDuration(this.rootView.getEditor().getPlayerController().getStreamDuration());
                    this.mViewOperator.showBottomView(this.mAudioMixChooserMediator);
                    break;
                } else {
                    android.content.Context context2 = this.mContext;
                    com.aliyun.svideo.editor.util.FixedToastUtils.show(context2, context2.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_mix_record_waring_content));
                    break;
                }
            case 10:
                com.aliyun.svideo.editor.effects.paint.PaintChooserView paintChooserView = new com.aliyun.svideo.editor.effects.paint.PaintChooserView(this.mContext);
                this.mPaintChooserView = paintChooserView;
                paintChooserView.setEditorService(this.mEditorService);
                this.mPaintChooserView.setOnEffectActionLister(this.mOnEffectActionLister);
                this.mPaintChooserView.setPaintSelectListener(new com.aliyun.svideo.editor.effects.control.ViewStack.AnonymousClass1());
                this.mViewOperator.showBottomView(this.mPaintChooserView);
                break;
            case 11:
                if (this.rootView.getEditor().getSourcePartManager().getAllClips().size() <= 1) {
                    com.aliyun.svideo.editor.effects.time.TimeChooserView timeChooserView = new com.aliyun.svideo.editor.effects.time.TimeChooserView(this.mContext);
                    this.mTimeChooserView = timeChooserView;
                    timeChooserView.setFirstShow(com.aliyun.svideo.editor.util.SharedPreferenceUtils.isTimeEffectFirstShow(this.mContext));
                    this.mTimeChooserView.setOnEffectChangeListener(this.mOnEffectChangeListener);
                    this.mTimeChooserView.setEditorService(this.mEditorService);
                    this.mTimeChooserView.addThumbView(this.rootView.getThumbLineBar());
                    this.mTimeChooserView.setOnEffectActionLister(this.mOnEffectActionLister);
                    this.mViewOperator.showBottomView(this.mTimeChooserView);
                    com.aliyun.svideo.editor.util.SharedPreferenceUtils.setTimeEffectFirstShow(this.mContext, false);
                    break;
                } else {
                    android.content.Context context3 = this.mContext;
                    com.aliyun.svideo.editor.util.FixedToastUtils.show(context3, context3.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_time_tip_not_support));
                    break;
                }
            case 12:
                com.aliyun.svideosdk.editor.AliyunISourcePartManager isClipLimit = com.aliyun.svideo.editor.effects.transition.TransitionChooserView.isClipLimit(this.rootView.getEditor());
                if (isClipLimit != null) {
                    com.aliyun.svideo.editor.effects.transition.TransitionChooserView transitionChooserView = new com.aliyun.svideo.editor.effects.transition.TransitionChooserView(this.mContext);
                    this.mTransitionChooserView = transitionChooserView;
                    transitionChooserView.setEditorService(this.mEditorService);
                    this.mTransitionChooserView.setOnEffectChangeListener(this.mOnEffectChangeListener);
                    this.mTransitionChooserView.setOnEffectActionLister(this.mOnEffectActionLister);
                    this.mTransitionChooserView.setOnPreviewListener(this.mOnPreviewListener);
                    this.mTransitionChooserView.initTransitionAdapter(isClipLimit);
                    setLayoutParams(this.mTransitionChooserView);
                    this.mViewOperator.showBottomView(this.mTransitionChooserView);
                    break;
                } else {
                    android.content.Context context4 = this.mContext;
                    android.widget.Toast.makeText(context4, context4.getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_transition_tip_limit), 0).show();
                    break;
                }
            case 13:
                if (this.mPipSettingView == null) {
                    this.mPipSettingView = new com.aliyun.svideo.editor.effects.pip.PipSettingView(this.mContext);
                }
                this.mPipSettingView.setEditorService(this.mEditorService);
                this.mPipSettingView.addThumbView(this.rootView.getThumbLineBar());
                setLayoutParams(this.mPipSettingView);
                this.mViewOperator.showBottomView(this.mPipSettingView);
                break;
            case 14:
                com.aliyun.svideo.editor.effects.cover.CoverChooserView coverChooserView = new com.aliyun.svideo.editor.effects.cover.CoverChooserView(this.mContext);
                this.mCoverChooserView = coverChooserView;
                coverChooserView.setOnEffectActionLister(this.mOnEffectActionLister);
                this.mCoverChooserView.addThumbView(this.rootView.getThumbLineBar());
                boolean isCoverViewFirstShow = com.aliyun.svideo.editor.util.SharedPreferenceUtils.isCoverViewFirstShow(this.mContext);
                if (isCoverViewFirstShow) {
                    com.aliyun.svideo.editor.util.SharedPreferenceUtils.setCoverViewFirstShow(this.mContext, false);
                }
                this.mCoverChooserView.setFirstShow(isCoverViewFirstShow);
                this.mViewOperator.showBottomView(this.mCoverChooserView);
                break;
            case 15:
                if (this.mRollCaptionEffectChooseView == null) {
                    this.mRollCaptionEffectChooseView = new com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView(this.mContext);
                }
                this.mRollCaptionEffectChooseView.setAliyunRollCaptionComposer(this.mAliyunRollCaptionComposer);
                this.mRollCaptionEffectChooseView.setEditorService(this.mEditorService);
                this.mRollCaptionEffectChooseView.setOnEffectActionLister(this.mOnEffectActionLister);
                this.mRollCaptionEffectChooseView.setOnEffectChangeListener(this.mOnEffectChangeListener);
                this.mViewOperator.showBottomView(this.mRollCaptionEffectChooseView);
                break;
            case 16:
                if (this.mVideoEqChooserView == null) {
                    com.aliyun.svideo.editor.effects.videoeq.VideoEqChooserView videoEqChooserView = new com.aliyun.svideo.editor.effects.videoeq.VideoEqChooserView(this.mContext);
                    this.mVideoEqChooserView = videoEqChooserView;
                    videoEqChooserView.setOnEffectActionLister(this.mOnEffectActionLister);
                }
                this.mViewOperator.showBottomView(this.mVideoEqChooserView);
                com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_SHORTVIDEO_EDIT_EFFECT_CK, "增强");
                break;
            default:
                return;
        }
        com.aliyun.svideo.editor.effects.control.BaseChooser bottomView = this.mViewOperator.getBottomView();
        if (bottomView == null || !bottomView.isPlayerNeedZoom()) {
            return;
        }
        this.rootView.setPasterDisplayScale(com.aliyun.svideo.editor.viewoperate.ViewOperator.SCALE_SIZE);
    }

    public void setAliyunRollCaptionComposer(com.aliyun.svideosdk.editor.AliyunRollCaptionComposer aliyunRollCaptionComposer) {
        this.mAliyunRollCaptionComposer = aliyunRollCaptionComposer;
    }

    public void setEditorService(com.aliyun.svideo.editor.effects.control.EditorService editorService) {
        this.mEditorService = editorService;
    }

    public void setEffectChange(com.aliyun.svideo.editor.effects.control.OnEffectChangeListener onEffectChangeListener) {
        this.mOnEffectChangeListener = onEffectChangeListener;
    }

    public void setOnEffectActionLister(com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister) {
        this.mOnEffectActionLister = onEffectActionLister;
    }

    public void setOnTransitionPreviewListener(com.aliyun.svideo.editor.effects.transition.TransitionChooserView.OnPreviewListener onPreviewListener) {
        this.mOnPreviewListener = onPreviewListener;
    }

    public void setPlayerListener(com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener playerListener) {
        this.mPlayerListener = playerListener;
    }

    public void setVisibleStatus(boolean z) {
        com.aliyun.svideo.editor.effects.audiomix.MusicChooser musicChooser = this.mAudioMixChooserMediator;
        if (musicChooser != null) {
            musicChooser.setVisibleStatus(z);
        }
    }
}
