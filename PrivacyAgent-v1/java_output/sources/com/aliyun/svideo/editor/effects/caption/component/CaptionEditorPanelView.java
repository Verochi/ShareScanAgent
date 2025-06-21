package com.aliyun.svideo.editor.effects.caption.component;

/* loaded from: classes12.dex */
public class CaptionEditorPanelView extends android.widget.FrameLayout {
    private static final int[] ID_TITLE_ARRAY = {com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_style, com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_bubble, com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_flourish, com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_animation};
    private static final java.lang.String TAG = "CaptionEditorPanelView";
    private com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder captionAnimationPanelViewHolder;
    private com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder captionBubblePanelViewHolder;
    private com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder captionCoolTextPanelViewHolder;
    private com.aliyun.svideo.editor.effects.caption.adapter.CaptionEditorViewPagerAdapter captionEditorViewPagerAdapter;
    private final java.lang.Runnable lazyGetTextRunnable;
    private android.view.View mBack;
    private android.view.View mConfirm;
    private android.widget.EditText mEditView;
    private com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener mOnCaptionChooserStateChangeListener;
    private final android.view.ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private com.google.android.material.tabs.TabLayout mTabLayout;
    private androidx.viewpager.widget.ViewPager mViewPage;
    private android.view.View parentView;
    private int realDisplayHeight;
    private com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStylePanelViewHolder stylePanelViewHolder;
    private final com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.MyTextWatcher textWatch;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.setVisibility(8);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.mOnCaptionChooserStateChangeListener != null) {
                com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.mOnCaptionChooserStateChangeListener.onCaptionConfirm();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.mEditView == null) {
                return;
            }
            android.text.Editable text = com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.mEditView.getText();
            java.lang.String obj = text != null ? text.toString() : null;
            if (android.text.TextUtils.isEmpty(obj)) {
                obj = com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_default);
            }
            int i = !com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.isTextOnly() ? 10 : 0;
            if (i != 0 && obj.length() > i) {
                com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.getContext(), com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_tip_text_limit);
                int length = obj.length() - i;
                int selectionStart = com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.mEditView.getSelectionStart();
                int i2 = selectionStart - length;
                int i3 = i2 >= 0 ? i2 : 0;
                if (selectionStart > obj.length()) {
                    selectionStart = obj.length();
                }
                if (i3 > selectionStart) {
                    i3 = selectionStart;
                }
                if (text != null) {
                    text.delete(i3, selectionStart);
                }
            }
            if (com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.mOnCaptionChooserStateChangeListener != null) {
                com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.mOnCaptionChooserStateChangeListener.onCaptionTextChanged(obj);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.google.android.material.tabs.TabLayout.OnTabSelectedListener {
        public AnonymousClass4() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onTabSelected(com.google.android.material.tabs.TabLayout.Tab tab) {
            int position = tab.getPosition();
            com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.closeKeyboard();
            if (position == 0) {
                com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.stylePanelViewHolder.onTabClick();
            } else if (position == 1) {
                com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.captionBubblePanelViewHolder.onTabClick();
            } else if (position == 2) {
                com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.captionCoolTextPanelViewHolder.onTabClick();
            } else if (position == 3) {
                com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.captionAnimationPanelViewHolder.onTabClick();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ android.view.inputmethod.InputMethodManager val$inputManager;

        public AnonymousClass5(android.view.inputmethod.InputMethodManager inputMethodManager) {
            this.val$inputManager = inputMethodManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.mEditView.requestFocus();
            this.val$inputManager.showSoftInput(com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.mEditView, 0);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView$6$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ int val$keyboardHeight;
            final /* synthetic */ android.view.ViewGroup.LayoutParams val$layoutParams;

            public AnonymousClass1(android.view.ViewGroup.LayoutParams layoutParams, int i) {
                this.val$layoutParams = layoutParams;
                this.val$keyboardHeight = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.setSoftInputAdjustNothing();
                this.val$layoutParams.height = this.val$keyboardHeight;
                com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.mViewPage.setLayoutParams(this.val$layoutParams);
            }
        }

        public AnonymousClass6() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int displayHeight = com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.realDisplayHeight - com.aliyun.svideo.common.utils.ScreenUtils.getDisplayHeight((android.app.Activity) com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.getContext());
            android.view.ViewGroup.LayoutParams layoutParams = com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.mViewPage.getLayoutParams();
            if (displayHeight <= 130 || displayHeight == layoutParams.height) {
                return;
            }
            com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.AnonymousClass6.AnonymousClass1(layoutParams, displayHeight), 200L);
        }
    }

    public class MyTextWatcher implements android.text.TextWatcher {
        private MyTextWatcher() {
        }

        public /* synthetic */ MyTextWatcher(com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView captionEditorPanelView, defpackage.kk kkVar) {
            this();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(android.text.Editable editable) {
            com.aliyun.svideo.common.utils.ThreadUtils.removeCallbacks(com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.lazyGetTextRunnable);
            com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.this.lazyGetTextRunnable, 100L);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public CaptionEditorPanelView(android.content.Context context, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        super(context);
        this.textWatch = new com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.MyTextWatcher(this, null);
        this.lazyGetTextRunnable = new com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.AnonymousClass3();
        this.mOnGlobalLayoutListener = new com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.AnonymousClass6();
        this.mOnCaptionChooserStateChangeListener = onCaptionChooserStateChangeListener;
        initView();
    }

    private void addOnSoftKeyBoardVisbleListener() {
        ((android.app.Activity) getContext()).getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    private void initTableView() {
        com.google.android.material.tabs.TabLayout tabLayout = (com.google.android.material.tabs.TabLayout) this.parentView.findViewById(com.aliyun.svideo.editor.R.id.tl_tab);
        this.mTabLayout = tabLayout;
        tabLayout.setTabMode(0);
        int i = 0;
        while (true) {
            int[] iArr = ID_TITLE_ARRAY;
            if (i >= iArr.length) {
                this.mTabLayout.setSelectedTabIndicatorColor(androidx.core.content.ContextCompat.getColor(this.parentView.getContext(), com.aliyun.svideo.editor.R.color.alivc_common_bg_cyan_light));
                this.mTabLayout.setupWithViewPager(this.mViewPage);
                this.mTabLayout.addOnTabSelectedListener((com.google.android.material.tabs.TabLayout.OnTabSelectedListener) new com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.AnonymousClass4());
                return;
            } else {
                android.view.View inflate = android.view.LayoutInflater.from(this.parentView.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_dialog_text_item_tab, (android.view.ViewGroup) this.parentView, false);
                ((android.widget.TextView) inflate.findViewById(com.aliyun.svideo.editor.R.id.tv_title)).setText(iArr[i]);
                com.google.android.material.tabs.TabLayout tabLayout2 = this.mTabLayout;
                tabLayout2.addTab(tabLayout2.newTab().setCustomView(inflate));
                i++;
            }
        }
    }

    private void initView() {
        android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_text_panel, (android.view.ViewGroup) this, true);
        this.parentView = inflate;
        this.mEditView = (android.widget.EditText) inflate.findViewById(com.aliyun.svideo.editor.R.id.fl_editText);
        this.mBack = this.parentView.findViewById(com.aliyun.svideo.editor.R.id.iv_back);
        this.mConfirm = this.parentView.findViewById(com.aliyun.svideo.editor.R.id.iv_confirm);
        this.realDisplayHeight = com.aliyun.svideo.common.utils.ScreenUtils.getDisplayHeight((android.app.Activity) getContext());
        initViewPage();
        initTableView();
        setOnClick();
        showKeyboard();
    }

    private void initViewPage() {
        androidx.viewpager.widget.ViewPager viewPager = (androidx.viewpager.widget.ViewPager) this.parentView.findViewById(com.aliyun.svideo.editor.R.id.viewpager);
        this.mViewPage = viewPager;
        viewPager.setOffscreenPageLimit(3);
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionEditorViewPagerAdapter captionEditorViewPagerAdapter = new com.aliyun.svideo.editor.effects.caption.adapter.CaptionEditorViewPagerAdapter();
        this.captionEditorViewPagerAdapter = captionEditorViewPagerAdapter;
        this.mViewPage.setAdapter(captionEditorViewPagerAdapter);
        this.stylePanelViewHolder = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStylePanelViewHolder(getContext(), getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_style), this.mOnCaptionChooserStateChangeListener);
        this.captionBubblePanelViewHolder = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder(getContext(), getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_bubble), this.mOnCaptionChooserStateChangeListener);
        this.captionCoolTextPanelViewHolder = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder(getContext(), getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_flourish), this.mOnCaptionChooserStateChangeListener);
        this.captionAnimationPanelViewHolder = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder(getContext(), getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_animation), this.mOnCaptionChooserStateChangeListener);
        this.captionEditorViewPagerAdapter.addViewHolder(this.stylePanelViewHolder);
        this.captionEditorViewPagerAdapter.addViewHolder(this.captionBubblePanelViewHolder);
        this.captionEditorViewPagerAdapter.addViewHolder(this.captionCoolTextPanelViewHolder);
        this.captionEditorViewPagerAdapter.addViewHolder(this.captionAnimationPanelViewHolder);
        this.captionEditorViewPagerAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTextOnly() {
        com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener = this.mOnCaptionChooserStateChangeListener;
        if (onCaptionChooserStateChangeListener != null) {
            return com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.isTextOnly(onCaptionChooserStateChangeListener.getAliyunPasterController());
        }
        return true;
    }

    private void notifyCaptionControllerChanged(int i) {
        com.google.android.material.tabs.TabLayout tabLayout;
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionEditorViewPagerAdapter captionEditorViewPagerAdapter;
        if (getVisibility() != 8 || i != 0 || (tabLayout = this.mTabLayout) == null || (captionEditorViewPagerAdapter = this.captionEditorViewPagerAdapter) == null) {
            return;
        }
        captionEditorViewPagerAdapter.notifyDataSetChanged(tabLayout.getSelectedTabPosition());
    }

    private void removeSoftKeyBoardVisbleListener() {
        ((android.app.Activity) getContext()).getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    private void setOnClick() {
        this.mEditView.addTextChangedListener(this.textWatch);
        addOnSoftKeyBoardVisbleListener();
        android.view.View view = this.mBack;
        if (view != null) {
            view.setOnClickListener(new com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.AnonymousClass1());
        }
        this.mConfirm.setOnClickListener(new com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSoftInputAdjustNothing() {
        ((android.app.Activity) getContext()).getWindow().setSoftInputMode(48);
    }

    private void setSoftInputAdjustResize() {
        ((android.app.Activity) getContext()).getWindow().setSoftInputMode(20);
    }

    public void closeKeyboard() {
        android.widget.EditText editText;
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager == null || !inputMethodManager.isActive() || (editText = this.mEditView) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("onActivityResult requestCode:");
        sb.append(i);
        sb.append(" resultCode：");
        sb.append(i2);
        com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder captionBubblePanelViewHolder = this.captionBubblePanelViewHolder;
        if (captionBubblePanelViewHolder != null) {
            captionBubblePanelViewHolder.resourceChanged();
        }
        com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStylePanelViewHolder captionStylePanelViewHolder = this.stylePanelViewHolder;
        if (captionStylePanelViewHolder != null) {
            captionStylePanelViewHolder.resourceChanged();
        }
    }

    public void refreshData() {
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterController;
        com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener = this.mOnCaptionChooserStateChangeListener;
        if (onCaptionChooserStateChangeListener == null || (aliyunPasterController = onCaptionChooserStateChangeListener.getAliyunPasterController()) == null) {
            return;
        }
        java.lang.String text = aliyunPasterController.getText();
        this.mEditView.removeTextChangedListener(this.textWatch);
        this.mEditView.setText(text);
        this.mEditView.addTextChangedListener(this.textWatch);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener;
        closeKeyboard();
        if (i == 8) {
            removeSoftKeyBoardVisbleListener();
        }
        if (getVisibility() == 0 && i == 8 && (onCaptionChooserStateChangeListener = this.mOnCaptionChooserStateChangeListener) != null) {
            onCaptionChooserStateChangeListener.onCaptionCancel();
        }
        notifyCaptionControllerChanged(i);
        super.setVisibility(i);
    }

    public void showKeyboard() {
        android.widget.EditText editText;
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager == null || (editText = this.mEditView) == null) {
            return;
        }
        editText.post(new com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView.AnonymousClass5(inputMethodManager));
    }
}
