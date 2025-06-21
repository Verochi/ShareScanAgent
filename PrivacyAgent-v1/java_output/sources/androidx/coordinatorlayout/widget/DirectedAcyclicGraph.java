package androidx.coordinatorlayout.widget;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class DirectedAcyclicGraph<T> {
    private final androidx.core.util.Pools.Pool<java.util.ArrayList<T>> mListPool = new androidx.core.util.Pools.SimplePool(10);
    private final androidx.collection.SimpleArrayMap<T, java.util.ArrayList<T>> mGraph = new androidx.collection.SimpleArrayMap<>();
    private final java.util.ArrayList<T> mSortResult = new java.util.ArrayList<>();
    private final java.util.HashSet<T> mSortTmpMarked = new java.util.HashSet<>();

    private void dfs(T t, java.util.ArrayList<T> arrayList, java.util.HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new java.lang.RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        java.util.ArrayList<T> arrayList2 = this.mGraph.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                dfs(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    @androidx.annotation.NonNull
    private java.util.ArrayList<T> getEmptyList() {
        java.util.ArrayList<T> acquire = this.mListPool.acquire();
        return acquire == null ? new java.util.ArrayList<>() : acquire;
    }

    private void poolList(@androidx.annotation.NonNull java.util.ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }

    public void addEdge(@androidx.annotation.NonNull T t, @androidx.annotation.NonNull T t2) {
        if (!this.mGraph.containsKey(t) || !this.mGraph.containsKey(t2)) {
            throw new java.lang.IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        java.util.ArrayList<T> arrayList = this.mGraph.get(t);
        if (arrayList == null) {
            arrayList = getEmptyList();
            this.mGraph.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public void addNode(@androidx.annotation.NonNull T t) {
        if (this.mGraph.containsKey(t)) {
            return;
        }
        this.mGraph.put(t, null);
    }

    public void clear() {
        int size = this.mGraph.size();
        for (int i = 0; i < size; i++) {
            java.util.ArrayList<T> valueAt = this.mGraph.valueAt(i);
            if (valueAt != null) {
                poolList(valueAt);
            }
        }
        this.mGraph.clear();
    }

    public boolean contains(@androidx.annotation.NonNull T t) {
        return this.mGraph.containsKey(t);
    }

    @androidx.annotation.Nullable
    public java.util.List getIncomingEdges(@androidx.annotation.NonNull T t) {
        return this.mGraph.get(t);
    }

    @androidx.annotation.Nullable
    public java.util.List<T> getOutgoingEdges(@androidx.annotation.NonNull T t) {
        int size = this.mGraph.size();
        java.util.ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            java.util.ArrayList<T> valueAt = this.mGraph.valueAt(i);
            if (valueAt != null && valueAt.contains(t)) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                }
                arrayList.add(this.mGraph.keyAt(i));
            }
        }
        return arrayList;
    }

    @androidx.annotation.NonNull
    public java.util.ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int size = this.mGraph.size();
        for (int i = 0; i < size; i++) {
            dfs(this.mGraph.keyAt(i), this.mSortResult, this.mSortTmpMarked);
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@androidx.annotation.NonNull T t) {
        int size = this.mGraph.size();
        for (int i = 0; i < size; i++) {
            java.util.ArrayList<T> valueAt = this.mGraph.valueAt(i);
            if (valueAt != null && valueAt.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.mGraph.size();
    }
}
