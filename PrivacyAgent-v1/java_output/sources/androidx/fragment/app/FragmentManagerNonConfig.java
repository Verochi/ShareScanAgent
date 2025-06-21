package androidx.fragment.app;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class FragmentManagerNonConfig {

    @androidx.annotation.Nullable
    private final java.util.Map<java.lang.String, androidx.fragment.app.FragmentManagerNonConfig> mChildNonConfigs;

    @androidx.annotation.Nullable
    private final java.util.Collection<androidx.fragment.app.Fragment> mFragments;

    @androidx.annotation.Nullable
    private final java.util.Map<java.lang.String, androidx.lifecycle.ViewModelStore> mViewModelStores;

    public FragmentManagerNonConfig(@androidx.annotation.Nullable java.util.Collection<androidx.fragment.app.Fragment> collection, @androidx.annotation.Nullable java.util.Map<java.lang.String, androidx.fragment.app.FragmentManagerNonConfig> map, @androidx.annotation.Nullable java.util.Map<java.lang.String, androidx.lifecycle.ViewModelStore> map2) {
        this.mFragments = collection;
        this.mChildNonConfigs = map;
        this.mViewModelStores = map2;
    }

    @androidx.annotation.Nullable
    public java.util.Map<java.lang.String, androidx.fragment.app.FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    @androidx.annotation.Nullable
    public java.util.Collection<androidx.fragment.app.Fragment> getFragments() {
        return this.mFragments;
    }

    @androidx.annotation.Nullable
    public java.util.Map<java.lang.String, androidx.lifecycle.ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }

    public boolean isRetaining(androidx.fragment.app.Fragment fragment) {
        java.util.Collection<androidx.fragment.app.Fragment> collection = this.mFragments;
        if (collection == null) {
            return false;
        }
        return collection.contains(fragment);
    }
}
