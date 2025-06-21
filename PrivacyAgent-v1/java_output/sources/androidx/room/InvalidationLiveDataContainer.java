package androidx.room;

/* loaded from: classes.dex */
class InvalidationLiveDataContainer {
    private final androidx.room.RoomDatabase mDatabase;

    @androidx.annotation.VisibleForTesting
    final java.util.Set<androidx.lifecycle.LiveData> mLiveDataSet = java.util.Collections.newSetFromMap(new java.util.IdentityHashMap());

    public InvalidationLiveDataContainer(androidx.room.RoomDatabase roomDatabase) {
        this.mDatabase = roomDatabase;
    }

    public <T> androidx.lifecycle.LiveData<T> create(java.lang.String[] strArr, boolean z, java.util.concurrent.Callable<T> callable) {
        return new androidx.room.RoomTrackingLiveData(this.mDatabase, this, z, callable, strArr);
    }

    public void onActive(androidx.lifecycle.LiveData liveData) {
        this.mLiveDataSet.add(liveData);
    }

    public void onInactive(androidx.lifecycle.LiveData liveData) {
        this.mLiveDataSet.remove(liveData);
    }
}
