package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public class DiffUtil {
    private static final java.util.Comparator<androidx.recyclerview.widget.DiffUtil.Diagonal> DIAGONAL_COMPARATOR = new androidx.recyclerview.widget.DiffUtil.AnonymousClass1();

    /* renamed from: androidx.recyclerview.widget.DiffUtil$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<androidx.recyclerview.widget.DiffUtil.Diagonal> {
        @Override // java.util.Comparator
        public int compare(androidx.recyclerview.widget.DiffUtil.Diagonal diagonal, androidx.recyclerview.widget.DiffUtil.Diagonal diagonal2) {
            return diagonal.x - diagonal2.x;
        }
    }

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        @androidx.annotation.Nullable
        public java.lang.Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        public CenteredArray(int i) {
            int[] iArr = new int[i];
            this.mData = iArr;
            this.mMid = iArr.length / 2;
        }

        public int[] backingData() {
            return this.mData;
        }

        public void fill(int i) {
            java.util.Arrays.fill(this.mData, i);
        }

        public int get(int i) {
            return this.mData[i + this.mMid];
        }

        public void set(int i, int i2) {
            this.mData[i + this.mMid] = i2;
        }
    }

    public static class Diagonal {
        public final int size;
        public final int x;
        public final int y;

        public Diagonal(int i, int i2, int i3) {
            this.x = i;
            this.y = i2;
            this.size = i3;
        }

        public int endX() {
            return this.x + this.size;
        }

        public int endY() {
            return this.y + this.size;
        }
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final androidx.recyclerview.widget.DiffUtil.Callback mCallback;
        private final boolean mDetectMoves;
        private final java.util.List<androidx.recyclerview.widget.DiffUtil.Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        public DiffResult(androidx.recyclerview.widget.DiffUtil.Callback callback, java.util.List<androidx.recyclerview.widget.DiffUtil.Diagonal> list, int[] iArr, int[] iArr2, boolean z) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            java.util.Arrays.fill(iArr, 0);
            java.util.Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            androidx.recyclerview.widget.DiffUtil.Diagonal diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
            if (diagonal == null || diagonal.x != 0 || diagonal.y != 0) {
                this.mDiagonals.add(0, new androidx.recyclerview.widget.DiffUtil.Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new androidx.recyclerview.widget.DiffUtil.Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i) {
            int size = this.mDiagonals.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                androidx.recyclerview.widget.DiffUtil.Diagonal diagonal = this.mDiagonals.get(i3);
                while (i2 < diagonal.y) {
                    if (this.mNewItemStatuses[i2] == 0 && this.mCallback.areItemsTheSame(i, i2)) {
                        int i4 = this.mCallback.areContentsTheSame(i, i2) ? 8 : 4;
                        this.mOldItemStatuses[i] = (i2 << 4) | i4;
                        this.mNewItemStatuses[i2] = (i << 4) | i4;
                        return;
                    }
                    i2++;
                }
                i2 = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            for (androidx.recyclerview.widget.DiffUtil.Diagonal diagonal : this.mDiagonals) {
                for (int i = 0; i < diagonal.size; i++) {
                    int i2 = diagonal.x + i;
                    int i3 = diagonal.y + i;
                    int i4 = this.mCallback.areContentsTheSame(i2, i3) ? 1 : 2;
                    this.mOldItemStatuses[i2] = (i3 << 4) | i4;
                    this.mNewItemStatuses[i3] = (i2 << 4) | i4;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int i = 0;
            for (androidx.recyclerview.widget.DiffUtil.Diagonal diagonal : this.mDiagonals) {
                while (i < diagonal.x) {
                    if (this.mOldItemStatuses[i] == 0) {
                        findMatchingAddition(i);
                    }
                    i++;
                }
                i = diagonal.endX();
            }
        }

        @androidx.annotation.Nullable
        private static androidx.recyclerview.widget.DiffUtil.PostponedUpdate getPostponedUpdate(java.util.Collection<androidx.recyclerview.widget.DiffUtil.PostponedUpdate> collection, int i, boolean z) {
            androidx.recyclerview.widget.DiffUtil.PostponedUpdate postponedUpdate;
            java.util.Iterator<androidx.recyclerview.widget.DiffUtil.PostponedUpdate> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postponedUpdate = null;
                    break;
                }
                postponedUpdate = it.next();
                if (postponedUpdate.posInOwnerList == i && postponedUpdate.removal == z) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                androidx.recyclerview.widget.DiffUtil.PostponedUpdate next = it.next();
                if (z) {
                    next.currentPos--;
                } else {
                    next.currentPos++;
                }
            }
            return postponedUpdate;
        }

        public int convertNewPositionToOld(@androidx.annotation.IntRange(from = 0) int i) {
            if (i >= 0 && i < this.mNewListSize) {
                int i2 = this.mNewItemStatuses[i];
                if ((i2 & 15) == 0) {
                    return -1;
                }
                return i2 >> 4;
            }
            throw new java.lang.IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", new list size = " + this.mNewListSize);
        }

        public int convertOldPositionToNew(@androidx.annotation.IntRange(from = 0) int i) {
            if (i >= 0 && i < this.mOldListSize) {
                int i2 = this.mOldItemStatuses[i];
                if ((i2 & 15) == 0) {
                    return -1;
                }
                return i2 >> 4;
            }
            throw new java.lang.IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", old list size = " + this.mOldListSize);
        }

        public void dispatchUpdatesTo(@androidx.annotation.NonNull androidx.recyclerview.widget.ListUpdateCallback listUpdateCallback) {
            int i;
            androidx.recyclerview.widget.BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof androidx.recyclerview.widget.BatchingListUpdateCallback ? (androidx.recyclerview.widget.BatchingListUpdateCallback) listUpdateCallback : new androidx.recyclerview.widget.BatchingListUpdateCallback(listUpdateCallback);
            int i2 = this.mOldListSize;
            java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
            int i3 = this.mOldListSize;
            int i4 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                androidx.recyclerview.widget.DiffUtil.Diagonal diagonal = this.mDiagonals.get(size);
                int endX = diagonal.endX();
                int endY = diagonal.endY();
                while (true) {
                    if (i3 <= endX) {
                        break;
                    }
                    i3--;
                    int i5 = this.mOldItemStatuses[i3];
                    if ((i5 & 12) != 0) {
                        int i6 = i5 >> 4;
                        androidx.recyclerview.widget.DiffUtil.PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i6, false);
                        if (postponedUpdate != null) {
                            int i7 = (i2 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i3, i7);
                            if ((i5 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i7, 1, this.mCallback.getChangePayload(i3, i6));
                            }
                        } else {
                            arrayDeque.add(new androidx.recyclerview.widget.DiffUtil.PostponedUpdate(i3, (i2 - i3) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i3, 1);
                        i2--;
                    }
                }
                while (i4 > endY) {
                    i4--;
                    int i8 = this.mNewItemStatuses[i4];
                    if ((i8 & 12) != 0) {
                        int i9 = i8 >> 4;
                        androidx.recyclerview.widget.DiffUtil.PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i9, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new androidx.recyclerview.widget.DiffUtil.PostponedUpdate(i4, i2 - i3, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i2 - postponedUpdate2.currentPos) - 1, i3);
                            if ((i8 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i3, 1, this.mCallback.getChangePayload(i9, i4));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i3, 1);
                        i2++;
                    }
                }
                int i10 = diagonal.x;
                int i11 = diagonal.y;
                for (i = 0; i < diagonal.size; i++) {
                    if ((this.mOldItemStatuses[i10] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i10, 1, this.mCallback.getChangePayload(i10, i11));
                    }
                    i10++;
                    i11++;
                }
                i3 = diagonal.x;
                i4 = diagonal.y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        public void dispatchUpdatesTo(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new androidx.recyclerview.widget.AdapterListUpdateCallback(adapter));
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@androidx.annotation.NonNull T t, @androidx.annotation.NonNull T t2);

        public abstract boolean areItemsTheSame(@androidx.annotation.NonNull T t, @androidx.annotation.NonNull T t2);

        @androidx.annotation.Nullable
        public java.lang.Object getChangePayload(@androidx.annotation.NonNull T t, @androidx.annotation.NonNull T t2) {
            return null;
        }
    }

    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i, int i2, boolean z) {
            this.posInOwnerList = i;
            this.currentPos = i2;
            this.removal = z;
        }
    }

    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int i, int i2, int i3, int i4) {
            this.oldListStart = i;
            this.oldListEnd = i2;
            this.newListStart = i3;
            this.newListEnd = i4;
        }

        public int newSize() {
            return this.newListEnd - this.newListStart;
        }

        public int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }
    }

    public static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        public int diagonalSize() {
            return java.lang.Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        public boolean hasAdditionOrRemoval() {
            return this.endY - this.startY != this.endX - this.startX;
        }

        public boolean isAddition() {
            return this.endY - this.startY > this.endX - this.startX;
        }

        @androidx.annotation.NonNull
        public androidx.recyclerview.widget.DiffUtil.Diagonal toDiagonal() {
            if (hasAdditionOrRemoval()) {
                return this.reverse ? new androidx.recyclerview.widget.DiffUtil.Diagonal(this.startX, this.startY, diagonalSize()) : isAddition() ? new androidx.recyclerview.widget.DiffUtil.Diagonal(this.startX, this.startY + 1, diagonalSize()) : new androidx.recyclerview.widget.DiffUtil.Diagonal(this.startX + 1, this.startY, diagonalSize());
            }
            int i = this.startX;
            return new androidx.recyclerview.widget.DiffUtil.Diagonal(i, this.startY, this.endX - i);
        }
    }

    private DiffUtil() {
    }

    @androidx.annotation.Nullable
    private static androidx.recyclerview.widget.DiffUtil.Snake backward(androidx.recyclerview.widget.DiffUtil.Range range, androidx.recyclerview.widget.DiffUtil.Callback callback, androidx.recyclerview.widget.DiffUtil.CenteredArray centeredArray, androidx.recyclerview.widget.DiffUtil.CenteredArray centeredArray2, int i) {
        int i2;
        int i3;
        int i4;
        boolean z = (range.oldSize() - range.newSize()) % 2 == 0;
        int oldSize = range.oldSize() - range.newSize();
        int i5 = -i;
        for (int i6 = i5; i6 <= i; i6 += 2) {
            if (i6 == i5 || (i6 != i && centeredArray2.get(i6 + 1) < centeredArray2.get(i6 - 1))) {
                i2 = centeredArray2.get(i6 + 1);
                i3 = i2;
            } else {
                i2 = centeredArray2.get(i6 - 1);
                i3 = i2 - 1;
            }
            int i7 = range.newListEnd - ((range.oldListEnd - i3) - i6);
            int i8 = (i == 0 || i3 != i2) ? i7 : i7 + 1;
            while (i3 > range.oldListStart && i7 > range.newListStart && callback.areItemsTheSame(i3 - 1, i7 - 1)) {
                i3--;
                i7--;
            }
            centeredArray2.set(i6, i3);
            if (z && (i4 = oldSize - i6) >= i5 && i4 <= i && centeredArray.get(i4) >= i3) {
                androidx.recyclerview.widget.DiffUtil.Snake snake = new androidx.recyclerview.widget.DiffUtil.Snake();
                snake.startX = i3;
                snake.startY = i7;
                snake.endX = i2;
                snake.endY = i8;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    @androidx.annotation.NonNull
    public static androidx.recyclerview.widget.DiffUtil.DiffResult calculateDiff(@androidx.annotation.NonNull androidx.recyclerview.widget.DiffUtil.Callback callback) {
        return calculateDiff(callback, true);
    }

    @androidx.annotation.NonNull
    public static androidx.recyclerview.widget.DiffUtil.DiffResult calculateDiff(@androidx.annotation.NonNull androidx.recyclerview.widget.DiffUtil.Callback callback, boolean z) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList2.add(new androidx.recyclerview.widget.DiffUtil.Range(0, oldListSize, 0, newListSize));
        int i = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        androidx.recyclerview.widget.DiffUtil.CenteredArray centeredArray = new androidx.recyclerview.widget.DiffUtil.CenteredArray(i);
        androidx.recyclerview.widget.DiffUtil.CenteredArray centeredArray2 = new androidx.recyclerview.widget.DiffUtil.CenteredArray(i);
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        while (!arrayList2.isEmpty()) {
            androidx.recyclerview.widget.DiffUtil.Range range = (androidx.recyclerview.widget.DiffUtil.Range) arrayList2.remove(arrayList2.size() - 1);
            androidx.recyclerview.widget.DiffUtil.Snake midPoint = midPoint(range, callback, centeredArray, centeredArray2);
            if (midPoint != null) {
                if (midPoint.diagonalSize() > 0) {
                    arrayList.add(midPoint.toDiagonal());
                }
                androidx.recyclerview.widget.DiffUtil.Range range2 = arrayList3.isEmpty() ? new androidx.recyclerview.widget.DiffUtil.Range() : (androidx.recyclerview.widget.DiffUtil.Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                range2.oldListEnd = midPoint.startX;
                range2.newListEnd = midPoint.startY;
                arrayList2.add(range2);
                range.oldListEnd = range.oldListEnd;
                range.newListEnd = range.newListEnd;
                range.oldListStart = midPoint.endX;
                range.newListStart = midPoint.endY;
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        java.util.Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new androidx.recyclerview.widget.DiffUtil.DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z);
    }

    @androidx.annotation.Nullable
    private static androidx.recyclerview.widget.DiffUtil.Snake forward(androidx.recyclerview.widget.DiffUtil.Range range, androidx.recyclerview.widget.DiffUtil.Callback callback, androidx.recyclerview.widget.DiffUtil.CenteredArray centeredArray, androidx.recyclerview.widget.DiffUtil.CenteredArray centeredArray2, int i) {
        int i2;
        int i3;
        int i4;
        boolean z = java.lang.Math.abs(range.oldSize() - range.newSize()) % 2 == 1;
        int oldSize = range.oldSize() - range.newSize();
        int i5 = -i;
        for (int i6 = i5; i6 <= i; i6 += 2) {
            if (i6 == i5 || (i6 != i && centeredArray.get(i6 + 1) > centeredArray.get(i6 - 1))) {
                i2 = centeredArray.get(i6 + 1);
                i3 = i2;
            } else {
                i2 = centeredArray.get(i6 - 1);
                i3 = i2 + 1;
            }
            int i7 = (range.newListStart + (i3 - range.oldListStart)) - i6;
            int i8 = (i == 0 || i3 != i2) ? i7 : i7 - 1;
            while (i3 < range.oldListEnd && i7 < range.newListEnd && callback.areItemsTheSame(i3, i7)) {
                i3++;
                i7++;
            }
            centeredArray.set(i6, i3);
            if (z && (i4 = oldSize - i6) >= i5 + 1 && i4 <= i - 1 && centeredArray2.get(i4) <= i3) {
                androidx.recyclerview.widget.DiffUtil.Snake snake = new androidx.recyclerview.widget.DiffUtil.Snake();
                snake.startX = i2;
                snake.startY = i8;
                snake.endX = i3;
                snake.endY = i7;
                snake.reverse = false;
                return snake;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    private static androidx.recyclerview.widget.DiffUtil.Snake midPoint(androidx.recyclerview.widget.DiffUtil.Range range, androidx.recyclerview.widget.DiffUtil.Callback callback, androidx.recyclerview.widget.DiffUtil.CenteredArray centeredArray, androidx.recyclerview.widget.DiffUtil.CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int oldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i = 0; i < oldSize; i++) {
                androidx.recyclerview.widget.DiffUtil.Snake forward = forward(range, callback, centeredArray, centeredArray2, i);
                if (forward != null) {
                    return forward;
                }
                androidx.recyclerview.widget.DiffUtil.Snake backward = backward(range, callback, centeredArray, centeredArray2, i);
                if (backward != null) {
                    return backward;
                }
            }
        }
        return null;
    }
}
