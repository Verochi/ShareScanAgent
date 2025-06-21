package com.aliyun.svideo.editor.effects.control;

/* loaded from: classes12.dex */
public abstract class BaseChooser extends android.widget.FrameLayout {
    public static final int ANIMATION_FILTER_REQUEST_CODE = 1004;
    public static final int CAPTION_REQUEST_CODE = 1001;
    public static final int IMV_REQUEST_CODE = 1002;
    public static final int PASTER_REQUEST_CODE = 1003;
    public static final int ROLL_CAPTION_REQUEST_CODE = 1006;
    protected static final java.lang.String TAG = "com.aliyun.svideo.editor.effects.control.BaseChooser";
    public static final int TRANSITION_EFFECT_REQUEST_CODE = 1005;
    protected int mCurrID;
    public com.aliyun.svideo.editor.effects.control.EditorService mEditorService;
    protected com.aliyun.svideo.editor.effects.control.OnEffectActionLister mOnEffectActionLister;
    public com.aliyun.svideo.editor.effects.control.OnEffectChangeListener mOnEffectChangeListener;
    protected com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener mPlayerListener;
    protected android.widget.FrameLayout mThumbContainer;
    protected com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar mThumbLineBar;
    private android.view.View mTransparentView;

    public BaseChooser(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        this.mCurrID = 0;
    }

    public BaseChooser(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrID = 0;
    }

    public BaseChooser(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrID = 0;
        init();
        this.mThumbContainer = getThumbContainer();
    }

    private void setClickable(android.view.ViewGroup viewGroup, boolean z) {
        if (this.mTransparentView == null) {
            this.mTransparentView = new android.widget.ImageButton(getContext());
            this.mTransparentView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            this.mTransparentView.setBackgroundColor(0);
        }
        android.view.ViewParent parent = this.mTransparentView.getParent();
        if (parent != null) {
            ((android.view.ViewGroup) parent).removeView(this.mTransparentView);
        }
        viewGroup.addView(this.mTransparentView);
        if (z) {
            this.mTransparentView.setVisibility(8);
        } else {
            this.mTransparentView.setVisibility(0);
        }
    }

    @android.annotation.SuppressLint({"ResourceType"})
    public void addThumbView(com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar) {
        if (overlayThumbLineBar == null) {
            return;
        }
        android.view.ViewParent parent = overlayThumbLineBar.getParent();
        if (parent != null) {
            ((android.view.ViewGroup) parent).removeView(overlayThumbLineBar);
        }
        android.widget.FrameLayout frameLayout = this.mThumbContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mThumbContainer.addView(overlayThumbLineBar);
            overlayThumbLineBar.showOverlay(getUIEditorPage());
            overlayThumbLineBar.setBackgroundResource(0);
            overlayThumbLineBar.show();
            this.mThumbLineBar = overlayThumbLineBar;
        }
    }

    public int getCalculateHeight() {
        int measuredHeight = getMeasuredHeight();
        if (measuredHeight != 0) {
            return measuredHeight;
        }
        measure(0, 0);
        return getMeasuredHeight();
    }

    public android.widget.FrameLayout getThumbContainer() {
        return null;
    }

    public com.aliyun.svideo.editor.effects.control.UIEditorPage getUIEditorPage() {
        return null;
    }

    public abstract void init();

    public boolean isHostPaster(com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController) {
        return false;
    }

    public abstract boolean isPlayerNeedZoom();

    public boolean isShowSelectedView() {
        return true;
    }

    public void onBackPressed() {
    }

    public void onRemove() {
        android.view.View childAt;
        android.widget.FrameLayout frameLayout = this.mThumbContainer;
        if (frameLayout == null || (childAt = frameLayout.getChildAt(0)) == null) {
            return;
        }
        ((com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar) childAt).hide();
    }

    public void removeOwn() {
        android.view.ViewParent parent = getParent();
        if (parent != null) {
            ((android.view.ViewGroup) parent).removeView(this);
        }
        onRemove();
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        setClickable(this, z);
    }

    public void setEditorService(com.aliyun.svideo.editor.effects.control.EditorService editorService) {
        this.mEditorService = editorService;
    }

    public void setOnEffectActionLister(com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister) {
        this.mOnEffectActionLister = onEffectActionLister;
    }

    public void setOnEffectChangeListener(com.aliyun.svideo.editor.effects.control.OnEffectChangeListener onEffectChangeListener) {
        this.mOnEffectChangeListener = onEffectChangeListener;
    }

    public void setPlayerListener(com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener playerListener) {
        this.mPlayerListener = playerListener;
    }

    public void setThumbScrollEnable(boolean z) {
        android.widget.FrameLayout frameLayout = this.mThumbContainer;
        if (frameLayout != null) {
            setClickable(frameLayout, z);
        }
    }
}
