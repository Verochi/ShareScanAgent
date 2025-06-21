package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes29.dex */
public class EffectManagerActivity extends com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity implements android.view.View.OnClickListener {
    public static final int ANIM_EFFECT = 4;
    public static final int CAPTION = 1;
    public static final java.lang.String KEY_TAB = "key_tab";
    public static final int MV = 3;
    public static final int PASTER = 0;
    public static final int TEXT = 2;
    public static final int TRANSITION = 5;
    private com.aliyun.svideo.editor.effectmanager.EffectManagerFragment mCaptionManagerFragment;
    private com.aliyun.svideo.editor.effectmanager.EffectManagerFragment mEffectManagerFragment;
    private com.aliyun.svideo.editor.effectmanager.EffectManagerFragment mMvManagerFragment;
    private com.aliyun.svideo.editor.effectmanager.EffectManagerFragment mPasterManagerFragment;
    private com.aliyun.svideo.editor.effectmanager.StateController mStateController;
    private com.google.android.material.tabs.TabLayout mTabLayout;
    private com.aliyun.svideo.editor.effectmanager.EffectManagerFragment mTextManagerFragment;
    private com.aliyun.svideo.editor.effectmanager.EffectManagerFragment mTransitionManagerFragment;
    private androidx.viewpager.widget.ViewPager mViewPager;

    public class EffectPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {
        private java.util.Set<java.util.Map.Entry<java.lang.String, androidx.fragment.app.Fragment>> mEntries;
        private java.util.LinkedHashMap<java.lang.String, androidx.fragment.app.Fragment> mFragments;

        public EffectPagerAdapter(androidx.fragment.app.FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mFragments = new java.util.LinkedHashMap<>();
        }

        public void addFragment(java.lang.String str, androidx.fragment.app.Fragment fragment) {
            this.mFragments.put(str, fragment);
            this.mEntries = this.mFragments.entrySet();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mFragments.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public androidx.fragment.app.Fragment getItem(int i) {
            int i2 = 0;
            for (java.util.Map.Entry<java.lang.String, androidx.fragment.app.Fragment> entry : this.mFragments.entrySet()) {
                if (i2 == i) {
                    return entry.getValue();
                }
                i2++;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public java.lang.CharSequence getPageTitle(int i) {
            int i2 = 0;
            for (java.util.Map.Entry<java.lang.String, androidx.fragment.app.Fragment> entry : this.mFragments.entrySet()) {
                if (i2 == i) {
                    return entry.getKey();
                }
                i2++;
            }
            return null;
        }
    }

    private void initViewPager() {
        this.mTabLayout = (com.google.android.material.tabs.TabLayout) findViewById(com.aliyun.svideo.editor.R.id.tab_layout);
        this.mViewPager = (androidx.viewpager.widget.ViewPager) findViewById(com.aliyun.svideo.editor.R.id.view_pager);
        this.mPasterManagerFragment = com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.newInstance(2);
        this.mCaptionManagerFragment = com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.newInstance(6);
        this.mTextManagerFragment = com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.newInstance(1);
        this.mMvManagerFragment = com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.newInstance(3);
        this.mEffectManagerFragment = com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.newInstance(9);
        this.mTransitionManagerFragment = com.aliyun.svideo.editor.effectmanager.EffectManagerFragment.newInstance(10);
        com.aliyun.svideo.editor.effectmanager.EffectManagerActivity.EffectPagerAdapter effectPagerAdapter = new com.aliyun.svideo.editor.effectmanager.EffectManagerActivity.EffectPagerAdapter(getSupportFragmentManager());
        effectPagerAdapter.addFragment(getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_sticker), this.mPasterManagerFragment);
        effectPagerAdapter.addFragment(getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_caption), this.mCaptionManagerFragment);
        effectPagerAdapter.addFragment(getString(com.aliyun.svideo.editor.R.string.alivc_editor_manager_font), this.mTextManagerFragment);
        effectPagerAdapter.addFragment(getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_mv), this.mMvManagerFragment);
        effectPagerAdapter.addFragment(getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_effect), this.mEffectManagerFragment);
        effectPagerAdapter.addFragment(getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_transition), this.mTransitionManagerFragment);
        this.mViewPager.setAdapter(effectPagerAdapter);
        this.mTabLayout.setupWithViewPager(this.mViewPager);
        this.mTabLayout.getTabAt(getIntent().getIntExtra(KEY_TAB, 0)).select();
    }

    public com.aliyun.svideo.editor.effectmanager.StateController getStateController() {
        return this.mStateController;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (view.getId() == getActionBarRightViewID()) {
            this.mStateController.switchState();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_effect_manager);
        setActionBarTitle(getString(com.aliyun.svideo.editor.R.string.alivc_editor_mananger_tittle));
        setActionBarLeftView(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_back);
        setActionBarLeftViewVisibility(0);
        setActionBarTitleVisibility(0);
        setActionBarRightViewVisibility(8);
        this.mStateController = new com.aliyun.svideo.editor.effectmanager.StateController();
        initViewPager();
    }
}
