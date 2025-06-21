package androidx.recyclerview.widget;

/* loaded from: classes.dex */
interface ViewTypeStorage {

    public static class IsolatedViewTypeStorage implements androidx.recyclerview.widget.ViewTypeStorage {
        android.util.SparseArray<androidx.recyclerview.widget.NestedAdapterWrapper> mGlobalTypeToWrapper = new android.util.SparseArray<>();
        int mNextViewType = 0;

        public class WrapperViewTypeLookup implements androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup {
            final androidx.recyclerview.widget.NestedAdapterWrapper mWrapper;
            private android.util.SparseIntArray mLocalToGlobalMapping = new android.util.SparseIntArray(1);
            private android.util.SparseIntArray mGlobalToLocalMapping = new android.util.SparseIntArray(1);

            public WrapperViewTypeLookup(androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper) {
                this.mWrapper = nestedAdapterWrapper;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public void dispose() {
                androidx.recyclerview.widget.ViewTypeStorage.IsolatedViewTypeStorage.this.removeWrapper(this.mWrapper);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int globalToLocal(int i) {
                int indexOfKey = this.mGlobalToLocalMapping.indexOfKey(i);
                if (indexOfKey >= 0) {
                    return this.mGlobalToLocalMapping.valueAt(indexOfKey);
                }
                throw new java.lang.IllegalStateException("requested global type " + i + " does not belong to the adapter:" + this.mWrapper.adapter);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int localToGlobal(int i) {
                int indexOfKey = this.mLocalToGlobalMapping.indexOfKey(i);
                if (indexOfKey > -1) {
                    return this.mLocalToGlobalMapping.valueAt(indexOfKey);
                }
                int obtainViewType = androidx.recyclerview.widget.ViewTypeStorage.IsolatedViewTypeStorage.this.obtainViewType(this.mWrapper);
                this.mLocalToGlobalMapping.put(i, obtainViewType);
                this.mGlobalToLocalMapping.put(obtainViewType, i);
                return obtainViewType;
            }
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        @androidx.annotation.NonNull
        public androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup createViewTypeWrapper(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper) {
            return new androidx.recyclerview.widget.ViewTypeStorage.IsolatedViewTypeStorage.WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        @androidx.annotation.NonNull
        public androidx.recyclerview.widget.NestedAdapterWrapper getWrapperForGlobalType(int i) {
            androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = this.mGlobalTypeToWrapper.get(i);
            if (nestedAdapterWrapper != null) {
                return nestedAdapterWrapper;
            }
            throw new java.lang.IllegalArgumentException("Cannot find the wrapper for global view type " + i);
        }

        public int obtainViewType(androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper) {
            int i = this.mNextViewType;
            this.mNextViewType = i + 1;
            this.mGlobalTypeToWrapper.put(i, nestedAdapterWrapper);
            return i;
        }

        public void removeWrapper(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper) {
            for (int size = this.mGlobalTypeToWrapper.size() - 1; size >= 0; size--) {
                if (this.mGlobalTypeToWrapper.valueAt(size) == nestedAdapterWrapper) {
                    this.mGlobalTypeToWrapper.removeAt(size);
                }
            }
        }
    }

    public static class SharedIdRangeViewTypeStorage implements androidx.recyclerview.widget.ViewTypeStorage {
        android.util.SparseArray<java.util.List<androidx.recyclerview.widget.NestedAdapterWrapper>> mGlobalTypeToWrapper = new android.util.SparseArray<>();

        public class WrapperViewTypeLookup implements androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup {
            final androidx.recyclerview.widget.NestedAdapterWrapper mWrapper;

            public WrapperViewTypeLookup(androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper) {
                this.mWrapper = nestedAdapterWrapper;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public void dispose() {
                androidx.recyclerview.widget.ViewTypeStorage.SharedIdRangeViewTypeStorage.this.removeWrapper(this.mWrapper);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int globalToLocal(int i) {
                return i;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int localToGlobal(int i) {
                java.util.List<androidx.recyclerview.widget.NestedAdapterWrapper> list = androidx.recyclerview.widget.ViewTypeStorage.SharedIdRangeViewTypeStorage.this.mGlobalTypeToWrapper.get(i);
                if (list == null) {
                    list = new java.util.ArrayList<>();
                    androidx.recyclerview.widget.ViewTypeStorage.SharedIdRangeViewTypeStorage.this.mGlobalTypeToWrapper.put(i, list);
                }
                if (!list.contains(this.mWrapper)) {
                    list.add(this.mWrapper);
                }
                return i;
            }
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        @androidx.annotation.NonNull
        public androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup createViewTypeWrapper(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper) {
            return new androidx.recyclerview.widget.ViewTypeStorage.SharedIdRangeViewTypeStorage.WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        @androidx.annotation.NonNull
        public androidx.recyclerview.widget.NestedAdapterWrapper getWrapperForGlobalType(int i) {
            java.util.List<androidx.recyclerview.widget.NestedAdapterWrapper> list = this.mGlobalTypeToWrapper.get(i);
            if (list != null && !list.isEmpty()) {
                return list.get(0);
            }
            throw new java.lang.IllegalArgumentException("Cannot find the wrapper for global view type " + i);
        }

        public void removeWrapper(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper) {
            for (int size = this.mGlobalTypeToWrapper.size() - 1; size >= 0; size--) {
                java.util.List<androidx.recyclerview.widget.NestedAdapterWrapper> valueAt = this.mGlobalTypeToWrapper.valueAt(size);
                if (valueAt.remove(nestedAdapterWrapper) && valueAt.isEmpty()) {
                    this.mGlobalTypeToWrapper.removeAt(size);
                }
            }
        }
    }

    public interface ViewTypeLookup {
        void dispose();

        int globalToLocal(int i);

        int localToGlobal(int i);
    }

    @androidx.annotation.NonNull
    androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup createViewTypeWrapper(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper);

    @androidx.annotation.NonNull
    androidx.recyclerview.widget.NestedAdapterWrapper getWrapperForGlobalType(int i);
}
