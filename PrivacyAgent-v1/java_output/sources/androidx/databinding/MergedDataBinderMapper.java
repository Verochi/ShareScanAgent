package androidx.databinding;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class MergedDataBinderMapper extends androidx.databinding.DataBinderMapper {
    private static final java.lang.String TAG = "MergedDataBinderMapper";
    private java.util.Set<java.lang.Class<? extends androidx.databinding.DataBinderMapper>> mExistingMappers = new java.util.HashSet();
    private java.util.List<androidx.databinding.DataBinderMapper> mMappers = new java.util.concurrent.CopyOnWriteArrayList();
    private java.util.List<java.lang.String> mFeatureBindingMappers = new java.util.concurrent.CopyOnWriteArrayList();

    private boolean loadFeatures() {
        boolean z = false;
        for (java.lang.String str : this.mFeatureBindingMappers) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(str);
                if (androidx.databinding.DataBinderMapper.class.isAssignableFrom(cls)) {
                    addMapper((androidx.databinding.DataBinderMapper) cls.newInstance());
                    this.mFeatureBindingMappers.remove(str);
                    z = true;
                }
            } catch (java.lang.ClassNotFoundException unused) {
            } catch (java.lang.IllegalAccessException unused2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("unable to add feature mapper for ");
                sb.append(str);
            } catch (java.lang.InstantiationException unused3) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("unable to add feature mapper for ");
                sb2.append(str);
            }
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addMapper(androidx.databinding.DataBinderMapper dataBinderMapper) {
        if (this.mExistingMappers.add(dataBinderMapper.getClass())) {
            this.mMappers.add(dataBinderMapper);
            java.util.Iterator<androidx.databinding.DataBinderMapper> it = dataBinderMapper.collectDependencies().iterator();
            while (it.hasNext()) {
                addMapper(it.next());
            }
        }
    }

    public void addMapper(java.lang.String str) {
        this.mFeatureBindingMappers.add(str + ".DataBinderMapperImpl");
    }

    @Override // androidx.databinding.DataBinderMapper
    public java.lang.String convertBrIdToString(int i) {
        java.util.Iterator<androidx.databinding.DataBinderMapper> it = this.mMappers.iterator();
        while (it.hasNext()) {
            java.lang.String convertBrIdToString = it.next().convertBrIdToString(i);
            if (convertBrIdToString != null) {
                return convertBrIdToString;
            }
        }
        if (loadFeatures()) {
            return convertBrIdToString(i);
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public androidx.databinding.ViewDataBinding getDataBinder(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, int i) {
        java.util.Iterator<androidx.databinding.DataBinderMapper> it = this.mMappers.iterator();
        while (it.hasNext()) {
            androidx.databinding.ViewDataBinding dataBinder = it.next().getDataBinder(dataBindingComponent, view, i);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, view, i);
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public androidx.databinding.ViewDataBinding getDataBinder(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View[] viewArr, int i) {
        java.util.Iterator<androidx.databinding.DataBinderMapper> it = this.mMappers.iterator();
        while (it.hasNext()) {
            androidx.databinding.ViewDataBinding dataBinder = it.next().getDataBinder(dataBindingComponent, viewArr, i);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, viewArr, i);
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(java.lang.String str) {
        java.util.Iterator<androidx.databinding.DataBinderMapper> it = this.mMappers.iterator();
        while (it.hasNext()) {
            int layoutId = it.next().getLayoutId(str);
            if (layoutId != 0) {
                return layoutId;
            }
        }
        if (loadFeatures()) {
            return getLayoutId(str);
        }
        return 0;
    }
}
