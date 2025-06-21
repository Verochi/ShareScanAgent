package androidx.recyclerview.widget;

/* loaded from: classes.dex */
interface StableIdStorage {

    public static class IsolatedStableIdStorage implements androidx.recyclerview.widget.StableIdStorage {
        long mNextStableId = 0;

        public class WrapperStableIdLookup implements androidx.recyclerview.widget.StableIdStorage.StableIdLookup {
            private final androidx.collection.LongSparseArray<java.lang.Long> mLocalToGlobalLookup = new androidx.collection.LongSparseArray<>();

            public WrapperStableIdLookup() {
            }

            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j) {
                java.lang.Long l = this.mLocalToGlobalLookup.get(j);
                if (l == null) {
                    l = java.lang.Long.valueOf(androidx.recyclerview.widget.StableIdStorage.IsolatedStableIdStorage.this.obtainId());
                    this.mLocalToGlobalLookup.put(j, l);
                }
                return l.longValue();
            }
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        @androidx.annotation.NonNull
        public androidx.recyclerview.widget.StableIdStorage.StableIdLookup createStableIdLookup() {
            return new androidx.recyclerview.widget.StableIdStorage.IsolatedStableIdStorage.WrapperStableIdLookup();
        }

        public long obtainId() {
            long j = this.mNextStableId;
            this.mNextStableId = 1 + j;
            return j;
        }
    }

    public static class NoStableIdStorage implements androidx.recyclerview.widget.StableIdStorage {
        private final androidx.recyclerview.widget.StableIdStorage.StableIdLookup mNoIdLookup = new androidx.recyclerview.widget.StableIdStorage.NoStableIdStorage.AnonymousClass1();

        /* renamed from: androidx.recyclerview.widget.StableIdStorage$NoStableIdStorage$1, reason: invalid class name */
        public class AnonymousClass1 implements androidx.recyclerview.widget.StableIdStorage.StableIdLookup {
            public AnonymousClass1() {
            }

            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j) {
                return -1L;
            }
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        @androidx.annotation.NonNull
        public androidx.recyclerview.widget.StableIdStorage.StableIdLookup createStableIdLookup() {
            return this.mNoIdLookup;
        }
    }

    public static class SharedPoolStableIdStorage implements androidx.recyclerview.widget.StableIdStorage {
        private final androidx.recyclerview.widget.StableIdStorage.StableIdLookup mSameIdLookup = new androidx.recyclerview.widget.StableIdStorage.SharedPoolStableIdStorage.AnonymousClass1();

        /* renamed from: androidx.recyclerview.widget.StableIdStorage$SharedPoolStableIdStorage$1, reason: invalid class name */
        public class AnonymousClass1 implements androidx.recyclerview.widget.StableIdStorage.StableIdLookup {
            public AnonymousClass1() {
            }

            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j) {
                return j;
            }
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        @androidx.annotation.NonNull
        public androidx.recyclerview.widget.StableIdStorage.StableIdLookup createStableIdLookup() {
            return this.mSameIdLookup;
        }
    }

    public interface StableIdLookup {
        long localToGlobal(long j);
    }

    @androidx.annotation.NonNull
    androidx.recyclerview.widget.StableIdStorage.StableIdLookup createStableIdLookup();
}
