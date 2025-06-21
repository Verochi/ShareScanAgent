package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final java.lang.String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final androidx.recyclerview.widget.ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final androidx.recyclerview.widget.ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final androidx.recyclerview.widget.AsyncListUtil.DataCallback<T> mDataCallback;
    private final androidx.recyclerview.widget.ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final androidx.recyclerview.widget.ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final java.lang.Class<T> mTClass;
    final androidx.recyclerview.widget.TileList<T> mTileList;
    final int mTileSize;
    final androidx.recyclerview.widget.AsyncListUtil.ViewCallback mViewCallback;
    final int[] mTmpRange = new int[2];
    final int[] mPrevRange = new int[2];
    final int[] mTmpRangeExtended = new int[2];
    private int mScrollHint = 0;
    int mItemCount = 0;
    int mDisplayedGeneration = 0;
    int mRequestedGeneration = 0;
    final android.util.SparseIntArray mMissingPositions = new android.util.SparseIntArray();

    /* renamed from: androidx.recyclerview.widget.AsyncListUtil$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.recyclerview.widget.ThreadUtil.MainThreadCallback<T> {
        public AnonymousClass1() {
        }

        private boolean isRequestedGeneration(int i) {
            return i == androidx.recyclerview.widget.AsyncListUtil.this.mRequestedGeneration;
        }

        private void recycleAllTiles() {
            for (int i = 0; i < androidx.recyclerview.widget.AsyncListUtil.this.mTileList.size(); i++) {
                androidx.recyclerview.widget.AsyncListUtil asyncListUtil = androidx.recyclerview.widget.AsyncListUtil.this;
                asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.getAtIndex(i));
            }
            androidx.recyclerview.widget.AsyncListUtil.this.mTileList.clear();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int i, androidx.recyclerview.widget.TileList.Tile<T> tile) {
            if (!isRequestedGeneration(i)) {
                androidx.recyclerview.widget.AsyncListUtil.this.mBackgroundProxy.recycleTile(tile);
                return;
            }
            androidx.recyclerview.widget.TileList.Tile<T> addOrReplace = androidx.recyclerview.widget.AsyncListUtil.this.mTileList.addOrReplace(tile);
            if (addOrReplace != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("duplicate tile @");
                sb.append(addOrReplace.mStartPosition);
                androidx.recyclerview.widget.AsyncListUtil.this.mBackgroundProxy.recycleTile(addOrReplace);
            }
            int i2 = tile.mStartPosition + tile.mItemCount;
            int i3 = 0;
            while (i3 < androidx.recyclerview.widget.AsyncListUtil.this.mMissingPositions.size()) {
                int keyAt = androidx.recyclerview.widget.AsyncListUtil.this.mMissingPositions.keyAt(i3);
                if (tile.mStartPosition > keyAt || keyAt >= i2) {
                    i3++;
                } else {
                    androidx.recyclerview.widget.AsyncListUtil.this.mMissingPositions.removeAt(i3);
                    androidx.recyclerview.widget.AsyncListUtil.this.mViewCallback.onItemLoaded(keyAt);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int i, int i2) {
            if (isRequestedGeneration(i)) {
                androidx.recyclerview.widget.TileList.Tile<T> removeAtPos = androidx.recyclerview.widget.AsyncListUtil.this.mTileList.removeAtPos(i2);
                if (removeAtPos != null) {
                    androidx.recyclerview.widget.AsyncListUtil.this.mBackgroundProxy.recycleTile(removeAtPos);
                    return;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("tile not found @");
                sb.append(i2);
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i, int i2) {
            if (isRequestedGeneration(i)) {
                androidx.recyclerview.widget.AsyncListUtil asyncListUtil = androidx.recyclerview.widget.AsyncListUtil.this;
                asyncListUtil.mItemCount = i2;
                asyncListUtil.mViewCallback.onDataRefresh();
                androidx.recyclerview.widget.AsyncListUtil asyncListUtil2 = androidx.recyclerview.widget.AsyncListUtil.this;
                asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
                recycleAllTiles();
                androidx.recyclerview.widget.AsyncListUtil asyncListUtil3 = androidx.recyclerview.widget.AsyncListUtil.this;
                asyncListUtil3.mAllowScrollHints = false;
                asyncListUtil3.updateRange();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.AsyncListUtil$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.recyclerview.widget.ThreadUtil.BackgroundCallback<T> {
        private int mFirstRequiredTileStart;
        private int mGeneration;
        private int mItemCount;
        private int mLastRequiredTileStart;
        final android.util.SparseBooleanArray mLoadedTiles = new android.util.SparseBooleanArray();
        private androidx.recyclerview.widget.TileList.Tile<T> mRecycledRoot;

        public AnonymousClass2() {
        }

        private androidx.recyclerview.widget.TileList.Tile<T> acquireTile() {
            androidx.recyclerview.widget.TileList.Tile<T> tile = this.mRecycledRoot;
            if (tile != null) {
                this.mRecycledRoot = tile.mNext;
                return tile;
            }
            androidx.recyclerview.widget.AsyncListUtil asyncListUtil = androidx.recyclerview.widget.AsyncListUtil.this;
            return new androidx.recyclerview.widget.TileList.Tile<>(asyncListUtil.mTClass, asyncListUtil.mTileSize);
        }

        private void addTile(androidx.recyclerview.widget.TileList.Tile<T> tile) {
            this.mLoadedTiles.put(tile.mStartPosition, true);
            androidx.recyclerview.widget.AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, tile);
        }

        private void flushTileCache(int i) {
            int maxCachedTiles = androidx.recyclerview.widget.AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
            while (this.mLoadedTiles.size() >= maxCachedTiles) {
                int keyAt = this.mLoadedTiles.keyAt(0);
                android.util.SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
                int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i2 = this.mFirstRequiredTileStart - keyAt;
                int i3 = keyAt2 - this.mLastRequiredTileStart;
                if (i2 > 0 && (i2 >= i3 || i == 2)) {
                    removeTile(keyAt);
                } else {
                    if (i3 <= 0) {
                        return;
                    }
                    if (i2 >= i3 && i != 1) {
                        return;
                    } else {
                        removeTile(keyAt2);
                    }
                }
            }
        }

        private int getTileStart(int i) {
            return i - (i % androidx.recyclerview.widget.AsyncListUtil.this.mTileSize);
        }

        private boolean isTileLoaded(int i) {
            return this.mLoadedTiles.get(i);
        }

        private void log(java.lang.String str, java.lang.Object... objArr) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[BKGR] ");
            sb.append(java.lang.String.format(str, objArr));
        }

        private void removeTile(int i) {
            this.mLoadedTiles.delete(i);
            androidx.recyclerview.widget.AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, i);
        }

        private void requestTiles(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                androidx.recyclerview.widget.AsyncListUtil.this.mBackgroundProxy.loadTile(z ? (i2 + i) - i4 : i4, i3);
                i4 += androidx.recyclerview.widget.AsyncListUtil.this.mTileSize;
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int i, int i2) {
            if (isTileLoaded(i)) {
                return;
            }
            androidx.recyclerview.widget.TileList.Tile<T> acquireTile = acquireTile();
            acquireTile.mStartPosition = i;
            int min = java.lang.Math.min(androidx.recyclerview.widget.AsyncListUtil.this.mTileSize, this.mItemCount - i);
            acquireTile.mItemCount = min;
            androidx.recyclerview.widget.AsyncListUtil.this.mDataCallback.fillData(acquireTile.mItems, acquireTile.mStartPosition, min);
            flushTileCache(i2);
            addTile(acquireTile);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(androidx.recyclerview.widget.TileList.Tile<T> tile) {
            androidx.recyclerview.widget.AsyncListUtil.this.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
            tile.mNext = this.mRecycledRoot;
            this.mRecycledRoot = tile;
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int i) {
            this.mGeneration = i;
            this.mLoadedTiles.clear();
            int refreshData = androidx.recyclerview.widget.AsyncListUtil.this.mDataCallback.refreshData();
            this.mItemCount = refreshData;
            androidx.recyclerview.widget.AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, refreshData);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            if (i > i2) {
                return;
            }
            int tileStart = getTileStart(i);
            int tileStart2 = getTileStart(i2);
            this.mFirstRequiredTileStart = getTileStart(i3);
            int tileStart3 = getTileStart(i4);
            this.mLastRequiredTileStart = tileStart3;
            if (i5 == 1) {
                requestTiles(this.mFirstRequiredTileStart, tileStart2, i5, true);
                requestTiles(tileStart2 + androidx.recyclerview.widget.AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, i5, false);
            } else {
                requestTiles(tileStart, tileStart3, i5, false);
                requestTiles(this.mFirstRequiredTileStart, tileStart - androidx.recyclerview.widget.AsyncListUtil.this.mTileSize, i5, true);
            }
        }
    }

    public static abstract class DataCallback<T> {
        @androidx.annotation.WorkerThread
        public abstract void fillData(@androidx.annotation.NonNull T[] tArr, int i, int i2);

        @androidx.annotation.WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @androidx.annotation.WorkerThread
        public void recycleData(@androidx.annotation.NonNull T[] tArr, int i) {
        }

        @androidx.annotation.WorkerThread
        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @androidx.annotation.UiThread
        public void extendRangeInto(@androidx.annotation.NonNull int[] iArr, @androidx.annotation.NonNull int[] iArr2, int i) {
            int i2 = iArr[1];
            int i3 = iArr[0];
            int i4 = (i2 - i3) + 1;
            int i5 = i4 / 2;
            iArr2[0] = i3 - (i == 1 ? i4 : i5);
            if (i != 2) {
                i4 = i5;
            }
            iArr2[1] = i2 + i4;
        }

        @androidx.annotation.UiThread
        public abstract void getItemRangeInto(@androidx.annotation.NonNull int[] iArr);

        @androidx.annotation.UiThread
        public abstract void onDataRefresh();

        @androidx.annotation.UiThread
        public abstract void onItemLoaded(int i);
    }

    public AsyncListUtil(@androidx.annotation.NonNull java.lang.Class<T> cls, int i, @androidx.annotation.NonNull androidx.recyclerview.widget.AsyncListUtil.DataCallback<T> dataCallback, @androidx.annotation.NonNull androidx.recyclerview.widget.AsyncListUtil.ViewCallback viewCallback) {
        androidx.recyclerview.widget.AsyncListUtil.AnonymousClass1 anonymousClass1 = new androidx.recyclerview.widget.AsyncListUtil.AnonymousClass1();
        this.mMainThreadCallback = anonymousClass1;
        androidx.recyclerview.widget.AsyncListUtil.AnonymousClass2 anonymousClass2 = new androidx.recyclerview.widget.AsyncListUtil.AnonymousClass2();
        this.mBackgroundCallback = anonymousClass2;
        this.mTClass = cls;
        this.mTileSize = i;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new androidx.recyclerview.widget.TileList<>(i);
        androidx.recyclerview.widget.MessageThreadUtil messageThreadUtil = new androidx.recyclerview.widget.MessageThreadUtil();
        this.mMainThreadProxy = messageThreadUtil.getMainThreadProxy(anonymousClass1);
        this.mBackgroundProxy = messageThreadUtil.getBackgroundProxy(anonymousClass2);
        refresh();
    }

    private boolean isRefreshPending() {
        return this.mRequestedGeneration != this.mDisplayedGeneration;
    }

    @androidx.annotation.Nullable
    public T getItem(int i) {
        if (i < 0 || i >= this.mItemCount) {
            throw new java.lang.IndexOutOfBoundsException(i + " is not within 0 and " + this.mItemCount);
        }
        T itemAt = this.mTileList.getItemAt(i);
        if (itemAt == null && !isRefreshPending()) {
            this.mMissingPositions.put(i, 0);
        }
        return itemAt;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public void log(java.lang.String str, java.lang.Object... objArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("[MAIN] ");
        sb.append(java.lang.String.format(str, objArr));
    }

    public void onRangeChanged() {
        if (isRefreshPending()) {
            return;
        }
        updateRange();
        this.mAllowScrollHints = true;
    }

    public void refresh() {
        this.mMissingPositions.clear();
        androidx.recyclerview.widget.ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int i = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = i;
        backgroundCallback.refresh(i);
    }

    public void updateRange() {
        int i;
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] iArr = this.mTmpRange;
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (i2 > i3 || i2 < 0 || i3 >= this.mItemCount) {
            return;
        }
        if (this.mAllowScrollHints) {
            int[] iArr2 = this.mPrevRange;
            if (i2 > iArr2[1] || (i = iArr2[0]) > i3) {
                this.mScrollHint = 0;
            } else if (i2 < i) {
                this.mScrollHint = 1;
            } else if (i2 > i) {
                this.mScrollHint = 2;
            }
        } else {
            this.mScrollHint = 0;
        }
        int[] iArr3 = this.mPrevRange;
        iArr3[0] = i2;
        iArr3[1] = i3;
        this.mViewCallback.extendRangeInto(iArr, this.mTmpRangeExtended, this.mScrollHint);
        int[] iArr4 = this.mTmpRangeExtended;
        iArr4[0] = java.lang.Math.min(this.mTmpRange[0], java.lang.Math.max(iArr4[0], 0));
        int[] iArr5 = this.mTmpRangeExtended;
        iArr5[1] = java.lang.Math.max(this.mTmpRange[1], java.lang.Math.min(iArr5[1], this.mItemCount - 1));
        androidx.recyclerview.widget.ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int[] iArr6 = this.mTmpRange;
        int i4 = iArr6[0];
        int i5 = iArr6[1];
        int[] iArr7 = this.mTmpRangeExtended;
        backgroundCallback.updateRange(i4, i5, iArr7[0], iArr7[1], this.mScrollHint);
    }
}
