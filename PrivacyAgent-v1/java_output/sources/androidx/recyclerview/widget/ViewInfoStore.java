package androidx.recyclerview.widget;

/* loaded from: classes.dex */
class ViewInfoStore {
    private static final boolean DEBUG = false;

    @androidx.annotation.VisibleForTesting
    final androidx.collection.SimpleArrayMap<androidx.recyclerview.widget.RecyclerView.ViewHolder, androidx.recyclerview.widget.ViewInfoStore.InfoRecord> mLayoutHolderMap = new androidx.collection.SimpleArrayMap<>();

    @androidx.annotation.VisibleForTesting
    final androidx.collection.LongSparseArray<androidx.recyclerview.widget.RecyclerView.ViewHolder> mOldChangedHolders = new androidx.collection.LongSparseArray<>();

    public static class InfoRecord {
        static final int FLAG_APPEAR = 2;
        static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
        static final int FLAG_APPEAR_PRE_AND_POST = 14;
        static final int FLAG_DISAPPEARED = 1;
        static final int FLAG_POST = 8;
        static final int FLAG_PRE = 4;
        static final int FLAG_PRE_AND_POST = 12;
        static androidx.core.util.Pools.Pool<androidx.recyclerview.widget.ViewInfoStore.InfoRecord> sPool = new androidx.core.util.Pools.SimplePool(20);
        int flags;

        @androidx.annotation.Nullable
        androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo postInfo;

        @androidx.annotation.Nullable
        androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

        private InfoRecord() {
        }

        public static void drainCache() {
            while (sPool.acquire() != null) {
            }
        }

        public static androidx.recyclerview.widget.ViewInfoStore.InfoRecord obtain() {
            androidx.recyclerview.widget.ViewInfoStore.InfoRecord acquire = sPool.acquire();
            return acquire == null ? new androidx.recyclerview.widget.ViewInfoStore.InfoRecord() : acquire;
        }

        public static void recycle(androidx.recyclerview.widget.ViewInfoStore.InfoRecord infoRecord) {
            infoRecord.flags = 0;
            infoRecord.preInfo = null;
            infoRecord.postInfo = null;
            sPool.release(infoRecord);
        }
    }

    public interface ProcessCallback {
        void processAppeared(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, @androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processDisappeared(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processPersistent(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void unused(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder);
    }

    private androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        androidx.recyclerview.widget.ViewInfoStore.InfoRecord valueAt;
        androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int indexOfKey = this.mLayoutHolderMap.indexOfKey(viewHolder);
        if (indexOfKey >= 0 && (valueAt = this.mLayoutHolderMap.valueAt(indexOfKey)) != null) {
            int i2 = valueAt.flags;
            if ((i2 & i) != 0) {
                int i3 = (~i) & i2;
                valueAt.flags = i3;
                if (i == 4) {
                    itemHolderInfo = valueAt.preInfo;
                } else {
                    if (i != 8) {
                        throw new java.lang.IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    itemHolderInfo = valueAt.postInfo;
                }
                if ((i3 & 12) == 0) {
                    this.mLayoutHolderMap.removeAt(indexOfKey);
                    androidx.recyclerview.widget.ViewInfoStore.InfoRecord.recycle(valueAt);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    public void addToAppearedInPreLayoutHolders(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        androidx.recyclerview.widget.ViewInfoStore.InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = androidx.recyclerview.widget.ViewInfoStore.InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, infoRecord);
        }
        infoRecord.flags |= 2;
        infoRecord.preInfo = itemHolderInfo;
    }

    public void addToDisappearedInLayout(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        androidx.recyclerview.widget.ViewInfoStore.InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = androidx.recyclerview.widget.ViewInfoStore.InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, infoRecord);
        }
        infoRecord.flags |= 1;
    }

    public void addToOldChangeHolders(long j, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        this.mOldChangedHolders.put(j, viewHolder);
    }

    public void addToPostLayout(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        androidx.recyclerview.widget.ViewInfoStore.InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = androidx.recyclerview.widget.ViewInfoStore.InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, infoRecord);
        }
        infoRecord.postInfo = itemHolderInfo;
        infoRecord.flags |= 8;
    }

    public void addToPreLayout(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        androidx.recyclerview.widget.ViewInfoStore.InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = androidx.recyclerview.widget.ViewInfoStore.InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, infoRecord);
        }
        infoRecord.preInfo = itemHolderInfo;
        infoRecord.flags |= 4;
    }

    public void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.clear();
    }

    public androidx.recyclerview.widget.RecyclerView.ViewHolder getFromOldChangeHolders(long j) {
        return this.mOldChangedHolders.get(j);
    }

    public boolean isDisappearing(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        androidx.recyclerview.widget.ViewInfoStore.InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        return (infoRecord == null || (infoRecord.flags & 1) == 0) ? false : true;
    }

    public boolean isInPreLayout(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        androidx.recyclerview.widget.ViewInfoStore.InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        return (infoRecord == null || (infoRecord.flags & 4) == 0) ? false : true;
    }

    public void onDetach() {
        androidx.recyclerview.widget.ViewInfoStore.InfoRecord.drainCache();
    }

    public void onViewDetached(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        removeFromDisappearedInLayout(viewHolder);
    }

    @androidx.annotation.Nullable
    public androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        return popFromLayoutStep(viewHolder, 8);
    }

    @androidx.annotation.Nullable
    public androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        return popFromLayoutStep(viewHolder, 4);
    }

    public void process(androidx.recyclerview.widget.ViewInfoStore.ProcessCallback processCallback) {
        for (int size = this.mLayoutHolderMap.size() - 1; size >= 0; size--) {
            androidx.recyclerview.widget.RecyclerView.ViewHolder keyAt = this.mLayoutHolderMap.keyAt(size);
            androidx.recyclerview.widget.ViewInfoStore.InfoRecord removeAt = this.mLayoutHolderMap.removeAt(size);
            int i = removeAt.flags;
            if ((i & 3) == 3) {
                processCallback.unused(keyAt);
            } else if ((i & 1) != 0) {
                androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = removeAt.preInfo;
                if (itemHolderInfo == null) {
                    processCallback.unused(keyAt);
                } else {
                    processCallback.processDisappeared(keyAt, itemHolderInfo, removeAt.postInfo);
                }
            } else if ((i & 14) == 14) {
                processCallback.processAppeared(keyAt, removeAt.preInfo, removeAt.postInfo);
            } else if ((i & 12) == 12) {
                processCallback.processPersistent(keyAt, removeAt.preInfo, removeAt.postInfo);
            } else if ((i & 4) != 0) {
                processCallback.processDisappeared(keyAt, removeAt.preInfo, null);
            } else if ((i & 8) != 0) {
                processCallback.processAppeared(keyAt, removeAt.preInfo, removeAt.postInfo);
            }
            androidx.recyclerview.widget.ViewInfoStore.InfoRecord.recycle(removeAt);
        }
    }

    public void removeFromDisappearedInLayout(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        androidx.recyclerview.widget.ViewInfoStore.InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.flags &= -2;
    }

    public void removeViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        int size = this.mOldChangedHolders.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (viewHolder == this.mOldChangedHolders.valueAt(size)) {
                this.mOldChangedHolders.removeAt(size);
                break;
            }
            size--;
        }
        androidx.recyclerview.widget.ViewInfoStore.InfoRecord remove = this.mLayoutHolderMap.remove(viewHolder);
        if (remove != null) {
            androidx.recyclerview.widget.ViewInfoStore.InfoRecord.recycle(remove);
        }
    }
}
