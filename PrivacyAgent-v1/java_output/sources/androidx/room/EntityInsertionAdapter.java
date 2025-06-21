package androidx.room;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class EntityInsertionAdapter<T> extends androidx.room.SharedSQLiteStatement {
    public EntityInsertionAdapter(androidx.room.RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public abstract void bind(androidx.sqlite.db.SupportSQLiteStatement supportSQLiteStatement, T t);

    public final void insert(java.lang.Iterable<? extends T> iterable) {
        androidx.sqlite.db.SupportSQLiteStatement acquire = acquire();
        try {
            java.util.Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final void insert(T t) {
        androidx.sqlite.db.SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t);
            acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final void insert(T[] tArr) {
        androidx.sqlite.db.SupportSQLiteStatement acquire = acquire();
        try {
            for (T t : tArr) {
                bind(acquire, t);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t) {
        androidx.sqlite.db.SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t);
            return acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(java.util.Collection<? extends T> collection) {
        androidx.sqlite.db.SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            java.util.Iterator<? extends T> it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                bind(acquire, it.next());
                jArr[i] = acquire.executeInsert();
                i++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        androidx.sqlite.db.SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int i = 0;
            for (T t : tArr) {
                bind(acquire, t);
                jArr[i] = acquire.executeInsert();
                i++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final java.lang.Long[] insertAndReturnIdsArrayBox(java.util.Collection<? extends T> collection) {
        androidx.sqlite.db.SupportSQLiteStatement acquire = acquire();
        try {
            java.lang.Long[] lArr = new java.lang.Long[collection.size()];
            java.util.Iterator<? extends T> it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                bind(acquire, it.next());
                lArr[i] = java.lang.Long.valueOf(acquire.executeInsert());
                i++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final java.lang.Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        androidx.sqlite.db.SupportSQLiteStatement acquire = acquire();
        try {
            java.lang.Long[] lArr = new java.lang.Long[tArr.length];
            int i = 0;
            for (T t : tArr) {
                bind(acquire, t);
                lArr[i] = java.lang.Long.valueOf(acquire.executeInsert());
                i++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final java.util.List<java.lang.Long> insertAndReturnIdsList(java.util.Collection<? extends T> collection) {
        androidx.sqlite.db.SupportSQLiteStatement acquire = acquire();
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
            java.util.Iterator<? extends T> it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                bind(acquire, it.next());
                arrayList.add(i, java.lang.Long.valueOf(acquire.executeInsert()));
                i++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final java.util.List<java.lang.Long> insertAndReturnIdsList(T[] tArr) {
        androidx.sqlite.db.SupportSQLiteStatement acquire = acquire();
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList(tArr.length);
            int i = 0;
            for (T t : tArr) {
                bind(acquire, t);
                arrayList.add(i, java.lang.Long.valueOf(acquire.executeInsert()));
                i++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }
}
