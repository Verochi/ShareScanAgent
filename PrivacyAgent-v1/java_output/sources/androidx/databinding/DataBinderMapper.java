package androidx.databinding;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public abstract class DataBinderMapper {
    @androidx.annotation.NonNull
    public java.util.List<androidx.databinding.DataBinderMapper> collectDependencies() {
        return java.util.Collections.emptyList();
    }

    public abstract java.lang.String convertBrIdToString(int i);

    public abstract androidx.databinding.ViewDataBinding getDataBinder(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, int i);

    public abstract androidx.databinding.ViewDataBinding getDataBinder(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View[] viewArr, int i);

    public abstract int getLayoutId(java.lang.String str);
}
