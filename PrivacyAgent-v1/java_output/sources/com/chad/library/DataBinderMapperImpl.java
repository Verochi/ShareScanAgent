package com.chad.library;

/* loaded from: classes22.dex */
public class DataBinderMapperImpl extends androidx.databinding.DataBinderMapper {
    public static final android.util.SparseIntArray a = new android.util.SparseIntArray(0);

    public static class InnerBrLookup {
        public static final android.util.SparseArray<java.lang.String> a;

        static {
            android.util.SparseArray<java.lang.String> sparseArray = new android.util.SparseArray<>(1);
            a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    public static class InnerLayoutIdLookup {
        public static final java.util.HashMap<java.lang.String, java.lang.Integer> a = new java.util.HashMap<>(0);
    }

    @Override // androidx.databinding.DataBinderMapper
    public java.util.List<androidx.databinding.DataBinderMapper> collectDependencies() {
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public java.lang.String convertBrIdToString(int i) {
        return com.chad.library.DataBinderMapperImpl.InnerBrLookup.a.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public androidx.databinding.ViewDataBinding getDataBinder(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, int i) {
        if (a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new java.lang.RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public androidx.databinding.ViewDataBinding getDataBinder(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new java.lang.RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(java.lang.String str) {
        java.lang.Integer num;
        if (str == null || (num = com.chad.library.DataBinderMapperImpl.InnerLayoutIdLookup.a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }
}
