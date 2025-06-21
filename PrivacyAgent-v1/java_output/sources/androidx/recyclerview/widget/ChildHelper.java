package androidx.recyclerview.widget;

/* loaded from: classes.dex */
class ChildHelper {
    private static final boolean DEBUG = false;
    private static final java.lang.String TAG = "ChildrenHelper";
    final androidx.recyclerview.widget.ChildHelper.Callback mCallback;
    final androidx.recyclerview.widget.ChildHelper.Bucket mBucket = new androidx.recyclerview.widget.ChildHelper.Bucket();
    final java.util.List<android.view.View> mHiddenViews = new java.util.ArrayList();

    public static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        androidx.recyclerview.widget.ChildHelper.Bucket mNext;

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new androidx.recyclerview.widget.ChildHelper.Bucket();
            }
        }

        public void clear(int i) {
            if (i < 64) {
                this.mData &= ~(1 << i);
                return;
            }
            androidx.recyclerview.widget.ChildHelper.Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.clear(i - 64);
            }
        }

        public int countOnesBefore(int i) {
            androidx.recyclerview.widget.ChildHelper.Bucket bucket = this.mNext;
            return bucket == null ? i >= 64 ? java.lang.Long.bitCount(this.mData) : java.lang.Long.bitCount(this.mData & ((1 << i) - 1)) : i < 64 ? java.lang.Long.bitCount(this.mData & ((1 << i) - 1)) : bucket.countOnesBefore(i - 64) + java.lang.Long.bitCount(this.mData);
        }

        public boolean get(int i) {
            if (i < 64) {
                return (this.mData & (1 << i)) != 0;
            }
            ensureNext();
            return this.mNext.get(i - 64);
        }

        public void insert(int i, boolean z) {
            if (i >= 64) {
                ensureNext();
                this.mNext.insert(i - 64, z);
                return;
            }
            long j = this.mData;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.mData = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                set(i);
            } else {
                clear(i);
            }
            if (z2 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z2);
            }
        }

        public boolean remove(int i) {
            if (i >= 64) {
                ensureNext();
                return this.mNext.remove(i - 64);
            }
            long j = 1 << i;
            long j2 = this.mData;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.mData = j3;
            long j4 = j - 1;
            this.mData = (j3 & j4) | java.lang.Long.rotateRight((~j4) & j3, 1);
            androidx.recyclerview.widget.ChildHelper.Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z;
        }

        public void reset() {
            this.mData = 0L;
            androidx.recyclerview.widget.ChildHelper.Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        public void set(int i) {
            if (i < 64) {
                this.mData |= 1 << i;
            } else {
                ensureNext();
                this.mNext.set(i - 64);
            }
        }

        public java.lang.String toString() {
            if (this.mNext == null) {
                return java.lang.Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + java.lang.Long.toBinaryString(this.mData);
        }
    }

    public interface Callback {
        void addView(android.view.View view, int i);

        void attachViewToParent(android.view.View view, int i, android.view.ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i);

        android.view.View getChildAt(int i);

        int getChildCount();

        androidx.recyclerview.widget.RecyclerView.ViewHolder getChildViewHolder(android.view.View view);

        int indexOfChild(android.view.View view);

        void onEnteredHiddenState(android.view.View view);

        void onLeftHiddenState(android.view.View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    public ChildHelper(androidx.recyclerview.widget.ChildHelper.Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int countOnesBefore = i - (i2 - this.mBucket.countOnesBefore(i2));
            if (countOnesBefore == 0) {
                while (this.mBucket.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += countOnesBefore;
        }
        return -1;
    }

    private void hideViewInternal(android.view.View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(android.view.View view) {
        if (!this.mHiddenViews.remove(view)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(view);
        return true;
    }

    public void addView(android.view.View view, int i, boolean z) {
        int childCount = i < 0 ? this.mCallback.getChildCount() : getOffset(i);
        this.mBucket.insert(childCount, z);
        if (z) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, childCount);
    }

    public void addView(android.view.View view, boolean z) {
        addView(view, -1, z);
    }

    public void attachViewToParent(android.view.View view, int i, android.view.ViewGroup.LayoutParams layoutParams, boolean z) {
        int childCount = i < 0 ? this.mCallback.getChildCount() : getOffset(i);
        this.mBucket.insert(childCount, z);
        if (z) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, childCount, layoutParams);
    }

    public void detachViewFromParent(int i) {
        int offset = getOffset(i);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    public android.view.View findHiddenNonRemovedView(int i) {
        int size = this.mHiddenViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            android.view.View view = this.mHiddenViews.get(i2);
            androidx.recyclerview.widget.RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public android.view.View getChildAt(int i) {
        return this.mCallback.getChildAt(getOffset(i));
    }

    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    public android.view.View getUnfilteredChildAt(int i) {
        return this.mCallback.getChildAt(i);
    }

    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    public void hide(android.view.View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            this.mBucket.set(indexOfChild);
            hideViewInternal(view);
        } else {
            throw new java.lang.IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public int indexOfChild(android.view.View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1 || this.mBucket.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.mBucket.countOnesBefore(indexOfChild);
    }

    public boolean isHidden(android.view.View view) {
        return this.mHiddenViews.contains(view);
    }

    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    public void removeView(android.view.View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            return;
        }
        if (this.mBucket.remove(indexOfChild)) {
            unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(indexOfChild);
    }

    public void removeViewAt(int i) {
        int offset = getOffset(i);
        android.view.View childAt = this.mCallback.getChildAt(offset);
        if (childAt == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        this.mCallback.removeViewAt(offset);
    }

    public boolean removeViewIfHidden(android.view.View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1) {
            unhideViewInternal(view);
            return true;
        }
        if (!this.mBucket.get(indexOfChild)) {
            return false;
        }
        this.mBucket.remove(indexOfChild);
        unhideViewInternal(view);
        this.mCallback.removeViewAt(indexOfChild);
        return true;
    }

    public java.lang.String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public void unhide(android.view.View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new java.lang.IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.mBucket.get(indexOfChild)) {
            this.mBucket.clear(indexOfChild);
            unhideViewInternal(view);
        } else {
            throw new java.lang.RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }
}
