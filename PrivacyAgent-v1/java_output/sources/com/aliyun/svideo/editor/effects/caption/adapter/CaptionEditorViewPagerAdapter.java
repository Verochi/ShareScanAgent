package com.aliyun.svideo.editor.effects.caption.adapter;

/* loaded from: classes12.dex */
public class CaptionEditorViewPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
    private java.util.List<com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder> mTabHolder = new java.util.ArrayList();

    public void addViewHolder(com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder baseCaptionViewHolder) {
        this.mTabHolder.add(baseCaptionViewHolder);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(android.view.ViewGroup viewGroup, int i, java.lang.Object obj) {
        if (obj instanceof android.view.View) {
            viewGroup.removeView((android.view.View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mTabHolder.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public java.lang.CharSequence getPageTitle(int i) {
        return this.mTabHolder.get(i).getTitle();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public java.lang.Object instantiateItem(android.view.ViewGroup viewGroup, int i) {
        com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder baseCaptionViewHolder = this.mTabHolder.get(i);
        viewGroup.addView(baseCaptionViewHolder.getItemView());
        baseCaptionViewHolder.onBindViewHolder();
        return baseCaptionViewHolder.getItemView();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
        return view == obj;
    }

    public void notifyDataSetChanged(int i) {
        if (this.mTabHolder.size() > i) {
            this.mTabHolder.get(i).notifyDataSetChanged();
        }
    }
}
