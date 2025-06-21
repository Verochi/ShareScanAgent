package com.aliyun.svideo.editor.effects.overlay;

/* loaded from: classes12.dex */
public class AnimationDialog extends android.app.DialogFragment {
    public static final int EFFECT_DOWN = 2;
    public static final int EFFECT_FADE = 5;
    public static final int EFFECT_LEFT = 3;
    public static final int EFFECT_LINEARWIPE = 6;
    public static final int EFFECT_NONE = 0;
    public static final int EFFECT_RIGHT = 4;
    public static final int EFFECT_SCALE = 7;
    public static final int EFFECT_UP = 1;
    public static final int[] POSITION_FONT_ANIM_ARRAY = {0, 1, 4, 3, 2, 6, 5, 7};
    public static boolean sIsShowing = false;
    com.aliyun.svideosdk.common.struct.effect.ActionBase mActionBase;
    private int mAnimationSelectPosition;
    private android.view.View mBack;
    private android.view.View mConfirm;
    private com.aliyun.svideo.editor.effects.overlay.AnimationDialog.OnConfirmListener onConfirmListener;
    private com.aliyun.svideo.editor.effects.overlay.AnimationDialog.PasterInfo pasterInfo;
    private boolean mUseInvert = false;
    private com.aliyun.svideo.editor.effects.overlay.AnimationDialog.OnItemClickListener mOnItemClickListener = new com.aliyun.svideo.editor.effects.overlay.AnimationDialog.AnonymousClass2();

    /* renamed from: com.aliyun.svideo.editor.effects.overlay.AnimationDialog$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.DialogInterface.OnKeyListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            dialogInterface.dismiss();
            return true;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.overlay.AnimationDialog$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.editor.effects.overlay.AnimationDialog.OnItemClickListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.editor.effects.overlay.AnimationDialog.OnItemClickListener
        public void onItemClick(int i) {
            if (com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mUseInvert) {
                com.aliyun.svideo.editor.util.FixedToastUtils.show(com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mConfirm.getContext(), com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mConfirm.getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_tip_not_support));
            }
            com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mAnimationSelectPosition = i;
            switch (i) {
                case 0:
                    com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase = null;
                    break;
                case 1:
                    com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase).setToPointY(1.0f);
                    break;
                case 2:
                    com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase).setToPointY(-1.0f);
                    break;
                case 3:
                    com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase).setToPointX(-1.0f);
                    break;
                case 4:
                    com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase).setToPointX(1.0f);
                    break;
                case 5:
                    com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionFade();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionFade) com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase).setFromAlpha(1.0f);
                    ((com.aliyun.svideosdk.common.struct.effect.ActionFade) com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase).setToAlpha(0.2f);
                    break;
                case 6:
                    com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionWipe();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionWipe) com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase).setWipeMode(1);
                    ((com.aliyun.svideosdk.common.struct.effect.ActionWipe) com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase).setDirection(2);
                    break;
                case 7:
                    com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionScale();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionScale) com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase).setFromScale(1.0f);
                    ((com.aliyun.svideosdk.common.struct.effect.ActionScale) com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mActionBase).setToScale(0.25f);
                    break;
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.overlay.AnimationDialog$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.overlay.AnimationDialog$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.overlay.AnimationDialog.PasterInfo pasterInfo = com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.pasterInfo;
            com.aliyun.svideo.editor.effects.overlay.AnimationDialog animationDialog = com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this;
            pasterInfo.mAnimation = animationDialog.mActionBase;
            animationDialog.pasterInfo.mAnimationSelect = com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.mAnimationSelectPosition;
            if (com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.onConfirmListener != null) {
                com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.onConfirmListener.onCompleted(com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.pasterInfo);
            }
            com.aliyun.svideo.editor.effects.overlay.AnimationDialog.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface OnConfirmListener {
        void onCompleted(com.aliyun.svideo.editor.effects.overlay.AnimationDialog.PasterInfo pasterInfo);
    }

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public static class PasterInfo implements java.io.Serializable {
        public com.aliyun.svideosdk.common.struct.effect.ActionBase mAnimation;
        public int mAnimationSelect = -1;
    }

    private void initFontAnimationView(android.view.View view) {
        com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase;
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) view.findViewById(com.aliyun.svideo.editor.R.id.font_animation_view);
        com.aliyun.svideo.editor.effects.overlay.AnimationAdapter animationAdapter = new com.aliyun.svideo.editor.effects.overlay.AnimationAdapter(view.getContext());
        com.aliyun.svideo.editor.effects.overlay.AnimationDialog.PasterInfo pasterInfo = this.pasterInfo;
        if (pasterInfo.mAnimationSelect == -1 && (actionBase = this.mActionBase) != null) {
            if (actionBase instanceof com.aliyun.svideosdk.common.struct.effect.ActionTranslate) {
                if (((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) actionBase).getToPointY() == 1.0f) {
                    this.pasterInfo.mAnimationSelect = 1;
                } else if (((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) this.mActionBase).getToPointY() == -1.0f) {
                    this.pasterInfo.mAnimationSelect = 2;
                } else if (((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) this.mActionBase).getToPointX() == 1.0f) {
                    this.pasterInfo.mAnimationSelect = 4;
                } else if (((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) this.mActionBase).getToPointX() == -1.0f) {
                    this.pasterInfo.mAnimationSelect = 3;
                } else if (((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) this.mActionBase).getFromPointX() == -1.0f) {
                    this.pasterInfo.mAnimationSelect = 4;
                } else if (((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) this.mActionBase).getFromPointX() == 1.0f) {
                    this.pasterInfo.mAnimationSelect = 3;
                } else if (((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) this.mActionBase).getFromPointY() > 0.0f) {
                    this.pasterInfo.mAnimationSelect = 2;
                } else if (((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) this.mActionBase).getFromPointY() < 0.0f) {
                    this.pasterInfo.mAnimationSelect = 1;
                } else {
                    this.pasterInfo.mAnimationSelect = 0;
                }
            } else if (actionBase instanceof com.aliyun.svideosdk.common.struct.effect.ActionScale) {
                pasterInfo.mAnimationSelect = 7;
            } else if (actionBase instanceof com.aliyun.svideosdk.common.struct.effect.ActionWipe) {
                pasterInfo.mAnimationSelect = 6;
            } else if (actionBase instanceof com.aliyun.svideosdk.common.struct.effect.ActionFade) {
                pasterInfo.mAnimationSelect = 5;
            } else {
                pasterInfo.mAnimationSelect = 0;
            }
        }
        int i = this.pasterInfo.mAnimationSelect;
        if (i != -1) {
            this.mAnimationSelectPosition = i;
            animationAdapter.setSelectPosition(i);
        }
        animationAdapter.setOnItemClickListener(this.mOnItemClickListener);
        androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = new androidx.recyclerview.widget.LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpaceItemDecoration(view.getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.list_item_space)));
        recyclerView.setAdapter(animationAdapter);
    }

    public static com.aliyun.svideo.editor.effects.overlay.AnimationDialog newInstance(com.aliyun.svideo.editor.effects.overlay.AnimationDialog.PasterInfo pasterInfo, boolean z) {
        if (sIsShowing) {
            return null;
        }
        sIsShowing = true;
        com.aliyun.svideo.editor.effects.overlay.AnimationDialog animationDialog = new com.aliyun.svideo.editor.effects.overlay.AnimationDialog();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putSerializable(com.aliyun.vod.log.core.AliyunLogCommon.SubModule.EDIT, pasterInfo);
        bundle.putBoolean("invert", z);
        animationDialog.setArguments(bundle);
        return animationDialog;
    }

    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    private void setOnClick() {
        android.view.View view = this.mBack;
        if (view != null) {
            view.setOnClickListener(new com.aliyun.svideo.editor.effects.overlay.AnimationDialog.AnonymousClass3());
        }
        this.mConfirm.setOnClickListener(new com.aliyun.svideo.editor.effects.overlay.AnimationDialog.AnonymousClass4());
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Dialog oncreate的时间：");
        sb.append(java.lang.System.currentTimeMillis());
        setStyle(2, com.aliyun.svideo.editor.R.style.AnimationDlgStyle);
    }

    @Override // android.app.DialogFragment
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        android.app.Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            onCreateDialog.setOnKeyListener(new com.aliyun.svideo.editor.effects.overlay.AnimationDialog.AnonymousClass1());
            onCreateDialog.getWindow().setSoftInputMode(16);
        }
        return onCreateDialog;
    }

    @Override // android.app.Fragment
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        android.view.View inflate = android.view.View.inflate(getActivity(), com.aliyun.svideo.editor.R.layout.alivc_editor_animation_dialog_text, null);
        this.pasterInfo = (com.aliyun.svideo.editor.effects.overlay.AnimationDialog.PasterInfo) getArguments().getSerializable(com.aliyun.vod.log.core.AliyunLogCommon.SubModule.EDIT);
        this.mUseInvert = getArguments().getBoolean("invert");
        com.aliyun.svideo.editor.effects.overlay.AnimationDialog.PasterInfo pasterInfo = this.pasterInfo;
        if (pasterInfo == null) {
            dismiss();
            return inflate;
        }
        this.mActionBase = pasterInfo.mAnimation;
        this.mConfirm = inflate.findViewById(com.aliyun.svideo.editor.R.id.iv_confirm);
        this.mBack = inflate.findViewById(com.aliyun.svideo.editor.R.id.iv_back);
        initFontAnimationView(inflate);
        android.view.WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        setOnClick();
        return inflate;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        sIsShowing = false;
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onResume() {
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(-1, -2);
        }
        super.onResume();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setOnStateChangeListener(com.aliyun.svideo.editor.effects.overlay.AnimationDialog.OnConfirmListener onConfirmListener) {
        this.onConfirmListener = onConfirmListener;
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
