package com.aliyun.svideo.editor.draft;

/* loaded from: classes12.dex */
public class DraftPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {
    private java.lang.String[] tabs;

    public DraftPagerAdapter(androidx.fragment.app.FragmentManager fragmentManager) {
        super(fragmentManager);
        this.tabs = new java.lang.String[]{"草稿箱", "模板草稿", "云端草稿"};
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.tabs.length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public androidx.fragment.app.Fragment getItem(int i) {
        if (i == 2) {
            return new com.aliyun.svideo.editor.draft.CloudDraftFragment();
        }
        com.aliyun.svideo.editor.draft.LocalDraftFragment localDraftFragment = new com.aliyun.svideo.editor.draft.LocalDraftFragment();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("TAB_INDEX", i);
        localDraftFragment.setArguments(bundle);
        return localDraftFragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public java.lang.CharSequence getPageTitle(int i) {
        return this.tabs[i];
    }
}
