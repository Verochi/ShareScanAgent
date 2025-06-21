package com.aliyun.svideo.editor.effects.caption.adapter.holder;

/* loaded from: classes12.dex */
public class CaptionStylePanelViewHolder extends com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder {
    private static final int[] ID_TITLE_ARRAY = {com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_color, com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_font, com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_stroke, com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_shadow, com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_fontstyle, com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_alignment};
    private com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder mBackgroundColorViewHolder;
    private com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAlignmentViewHolder mCaptionAlignmentViewHolder;
    private com.aliyun.svideo.editor.effects.caption.adapter.CaptionEditorViewPagerAdapter mCaptionEditorViewPagerAdapter;
    private com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontStyleViewHolder mCaptionFontStyleViewHolder;
    private com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder mCaptionFontTypefacePanelViewHolder;
    private com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder mCaptionShadowViewHolder;
    private com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionColorViewHolder mColorViewHolder;
    private com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder mStoreColorViewHolder;
    private com.google.android.material.tabs.TabLayout mTabLayout;
    private androidx.viewpager.widget.ViewPager mViewPage;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStylePanelViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.material.tabs.TabLayout.OnTabSelectedListener {
        public AnonymousClass1() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onTabSelected(com.google.android.material.tabs.TabLayout.Tab tab) {
            switch (tab.getPosition()) {
                case 0:
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStylePanelViewHolder.this.mColorViewHolder.onTabClick();
                    break;
                case 1:
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStylePanelViewHolder.this.mCaptionFontTypefacePanelViewHolder.onTabClick();
                    break;
                case 2:
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStylePanelViewHolder.this.mBackgroundColorViewHolder.onTabClick();
                    break;
                case 3:
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStylePanelViewHolder.this.mStoreColorViewHolder.onTabClick();
                    break;
                case 4:
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStylePanelViewHolder.this.mCaptionShadowViewHolder.onTabClick();
                    break;
                case 5:
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStylePanelViewHolder.this.mCaptionFontStyleViewHolder.onTabClick();
                    break;
                case 6:
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStylePanelViewHolder.this.mCaptionAlignmentViewHolder.onTabClick();
                    break;
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        }
    }

    public CaptionStylePanelViewHolder(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        super(context, str, onCaptionChooserStateChangeListener);
    }

    private void initTableView(android.view.View view) {
        com.google.android.material.tabs.TabLayout tabLayout = (com.google.android.material.tabs.TabLayout) view.findViewById(com.aliyun.svideo.editor.R.id.tl_tab);
        this.mTabLayout = tabLayout;
        tabLayout.setTabMode(0);
        int i = 0;
        while (true) {
            int[] iArr = ID_TITLE_ARRAY;
            if (i >= iArr.length) {
                this.mTabLayout.setSelectedTabIndicatorHeight(0);
                this.mTabLayout.setupWithViewPager(this.mViewPage);
                this.mTabLayout.addOnTabSelectedListener((com.google.android.material.tabs.TabLayout.OnTabSelectedListener) new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStylePanelViewHolder.AnonymousClass1());
                return;
            } else {
                android.view.View inflate = android.view.LayoutInflater.from(view.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_style_item_tab, (android.view.ViewGroup) view, false);
                ((android.widget.TextView) inflate.findViewById(com.aliyun.svideo.editor.R.id.tv_title)).setText(iArr[i]);
                com.google.android.material.tabs.TabLayout tabLayout2 = this.mTabLayout;
                tabLayout2.addTab(tabLayout2.newTab().setCustomView(inflate));
                i++;
            }
        }
    }

    private void initViewPage(android.view.View view) {
        androidx.viewpager.widget.ViewPager viewPager = (androidx.viewpager.widget.ViewPager) view.findViewById(com.aliyun.svideo.editor.R.id.viewpager);
        this.mViewPage = viewPager;
        viewPager.setOffscreenPageLimit(5);
        this.mCaptionEditorViewPagerAdapter = new com.aliyun.svideo.editor.effects.caption.adapter.CaptionEditorViewPagerAdapter();
        this.mColorViewHolder = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionColorViewHolder(getContext(), view.getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_color), getCaptionChooserStateChangeListener());
        this.mCaptionFontTypefacePanelViewHolder = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder(getContext(), getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_font), getCaptionChooserStateChangeListener());
        this.mBackgroundColorViewHolder = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder(getContext(), view.getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_background_color), getCaptionChooserStateChangeListener());
        this.mStoreColorViewHolder = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder(getContext(), view.getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_stroke), getCaptionChooserStateChangeListener());
        this.mCaptionShadowViewHolder = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder(getContext(), getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_shadow), getCaptionChooserStateChangeListener());
        this.mCaptionFontStyleViewHolder = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontStyleViewHolder(getContext(), getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_fontstyle), getCaptionChooserStateChangeListener());
        this.mCaptionAlignmentViewHolder = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAlignmentViewHolder(getContext(), getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_alignment), getCaptionChooserStateChangeListener());
        this.mCaptionEditorViewPagerAdapter.addViewHolder(this.mColorViewHolder);
        this.mCaptionEditorViewPagerAdapter.addViewHolder(this.mCaptionFontTypefacePanelViewHolder);
        this.mCaptionEditorViewPagerAdapter.addViewHolder(this.mBackgroundColorViewHolder);
        this.mCaptionEditorViewPagerAdapter.addViewHolder(this.mStoreColorViewHolder);
        this.mCaptionEditorViewPagerAdapter.addViewHolder(this.mCaptionShadowViewHolder);
        this.mCaptionEditorViewPagerAdapter.addViewHolder(this.mCaptionFontStyleViewHolder);
        this.mCaptionEditorViewPagerAdapter.addViewHolder(this.mCaptionAlignmentViewHolder);
        this.mViewPage.setAdapter(this.mCaptionEditorViewPagerAdapter);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void notifyDataSetChanged() {
        com.google.android.material.tabs.TabLayout tabLayout;
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionEditorViewPagerAdapter captionEditorViewPagerAdapter = this.mCaptionEditorViewPagerAdapter;
        if (captionEditorViewPagerAdapter == null || (tabLayout = this.mTabLayout) == null) {
            return;
        }
        captionEditorViewPagerAdapter.notifyDataSetChanged(tabLayout.getSelectedTabPosition());
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onBindViewHolder() {
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public android.view.View onCreateView(android.content.Context context) {
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_style_container, (android.view.ViewGroup) null, false);
        initViewPage(inflate);
        initTableView(inflate);
        return inflate;
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onTabClick() {
        notifyDataSetChanged();
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void resourceChanged() {
        com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder captionFontTypefacePanelViewHolder = this.mCaptionFontTypefacePanelViewHolder;
        if (captionFontTypefacePanelViewHolder != null) {
            captionFontTypefacePanelViewHolder.resourceChanged();
        }
    }
}
