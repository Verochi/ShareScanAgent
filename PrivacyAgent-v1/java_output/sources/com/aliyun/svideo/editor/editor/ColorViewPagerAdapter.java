package com.aliyun.svideo.editor.editor;

/* loaded from: classes12.dex */
public class ColorViewPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
    private java.util.List<com.aliyun.svideo.editor.editor.ColorViewPagerAdapter.ViewHolder> mTabHolder = new java.util.ArrayList();

    public static abstract class ViewHolder {
        android.view.View mItemView;
        java.lang.String mTitle;

        public ViewHolder(android.content.Context context, java.lang.String str) {
            this.mItemView = onCreateView(context);
            this.mTitle = str;
        }

        public abstract void onBindViewHolder();

        public abstract android.view.View onCreateView(android.content.Context context);
    }

    public void addViewHolder(com.aliyun.svideo.editor.editor.ColorViewPagerAdapter.ViewHolder viewHolder) {
        this.mTabHolder.add(viewHolder);
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
        return this.mTabHolder.get(i).mTitle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public java.lang.Object instantiateItem(android.view.ViewGroup viewGroup, int i) {
        com.aliyun.svideo.editor.editor.ColorViewPagerAdapter.ViewHolder viewHolder = this.mTabHolder.get(i);
        viewGroup.addView(viewHolder.mItemView);
        viewHolder.onBindViewHolder();
        return viewHolder.mItemView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
        return view == obj;
    }
}
