package androidx.viewpager.widget;

/* loaded from: classes.dex */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    private final android.database.DataSetObservable mObservable = new android.database.DataSetObservable();
    private android.database.DataSetObserver mViewPagerObserver;

    @java.lang.Deprecated
    public void destroyItem(@androidx.annotation.NonNull android.view.View view, int i, @androidx.annotation.NonNull java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void destroyItem(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, int i, @androidx.annotation.NonNull java.lang.Object obj) {
        destroyItem((android.view.View) viewGroup, i, obj);
    }

    @java.lang.Deprecated
    public void finishUpdate(@androidx.annotation.NonNull android.view.View view) {
    }

    public void finishUpdate(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        finishUpdate((android.view.View) viewGroup);
    }

    public abstract int getCount();

    public int getItemPosition(@androidx.annotation.NonNull java.lang.Object obj) {
        return -1;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getPageTitle(int i) {
        return null;
    }

    public float getPageWidth(int i) {
        return 1.0f;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public java.lang.Object instantiateItem(@androidx.annotation.NonNull android.view.View view, int i) {
        throw new java.lang.UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @androidx.annotation.NonNull
    public java.lang.Object instantiateItem(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, int i) {
        return instantiateItem((android.view.View) viewGroup, i);
    }

    public abstract boolean isViewFromObject(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.Object obj);

    public void notifyDataSetChanged() {
        synchronized (this) {
            android.database.DataSetObserver dataSetObserver = this.mViewPagerObserver;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.mObservable.notifyChanged();
    }

    public void registerDataSetObserver(@androidx.annotation.NonNull android.database.DataSetObserver dataSetObserver) {
        this.mObservable.registerObserver(dataSetObserver);
    }

    public void restoreState(@androidx.annotation.Nullable android.os.Parcelable parcelable, @androidx.annotation.Nullable java.lang.ClassLoader classLoader) {
    }

    @androidx.annotation.Nullable
    public android.os.Parcelable saveState() {
        return null;
    }

    @java.lang.Deprecated
    public void setPrimaryItem(@androidx.annotation.NonNull android.view.View view, int i, @androidx.annotation.NonNull java.lang.Object obj) {
    }

    public void setPrimaryItem(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, int i, @androidx.annotation.NonNull java.lang.Object obj) {
        setPrimaryItem((android.view.View) viewGroup, i, obj);
    }

    public void setViewPagerObserver(android.database.DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.mViewPagerObserver = dataSetObserver;
        }
    }

    @java.lang.Deprecated
    public void startUpdate(@androidx.annotation.NonNull android.view.View view) {
    }

    public void startUpdate(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        startUpdate((android.view.View) viewGroup);
    }

    public void unregisterDataSetObserver(@androidx.annotation.NonNull android.database.DataSetObserver dataSetObserver) {
        this.mObservable.unregisterObserver(dataSetObserver);
    }
}
