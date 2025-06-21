package androidx.databinding.library.baseAdapters;

/* loaded from: classes.dex */
public class DataBinderMapperImpl extends androidx.databinding.DataBinderMapper {
    private static final android.util.SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new android.util.SparseIntArray(0);

    public static class InnerBrLookup {
        static final android.util.SparseArray<java.lang.String> sKeys;

        static {
            android.util.SparseArray<java.lang.String> sparseArray = new android.util.SparseArray<>(1);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
        }

        private InnerBrLookup() {
        }
    }

    public static class InnerLayoutIdLookup {
        static final java.util.HashMap<java.lang.String, java.lang.Integer> sKeys = new java.util.HashMap<>(0);

        private InnerLayoutIdLookup() {
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public java.util.List<androidx.databinding.DataBinderMapper> collectDependencies() {
        return new java.util.ArrayList(0);
    }

    @Override // androidx.databinding.DataBinderMapper
    public java.lang.String convertBrIdToString(int i) {
        return androidx.databinding.library.baseAdapters.DataBinderMapperImpl.InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public androidx.databinding.ViewDataBinding getDataBinder(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, int i) {
        if (INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new java.lang.RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public androidx.databinding.ViewDataBinding getDataBinder(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new java.lang.RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(java.lang.String str) {
        java.lang.Integer num;
        if (str == null || (num = androidx.databinding.library.baseAdapters.DataBinderMapperImpl.InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }
}
