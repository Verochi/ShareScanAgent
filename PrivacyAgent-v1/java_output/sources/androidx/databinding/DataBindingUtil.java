package androidx.databinding;

/* loaded from: classes.dex */
public class DataBindingUtil {
    private static androidx.databinding.DataBinderMapper sMapper = new androidx.databinding.DataBinderMapperImpl();
    private static androidx.databinding.DataBindingComponent sDefaultComponent = null;

    private DataBindingUtil() {
    }

    @androidx.annotation.Nullable
    public static <T extends androidx.databinding.ViewDataBinding> T bind(@androidx.annotation.NonNull android.view.View view) {
        return (T) bind(view, sDefaultComponent);
    }

    @androidx.annotation.Nullable
    public static <T extends androidx.databinding.ViewDataBinding> T bind(@androidx.annotation.NonNull android.view.View view, androidx.databinding.DataBindingComponent dataBindingComponent) {
        T t = (T) getBinding(view);
        if (t != null) {
            return t;
        }
        java.lang.Object tag = view.getTag();
        if (!(tag instanceof java.lang.String)) {
            throw new java.lang.IllegalArgumentException("View is not a binding layout");
        }
        int layoutId = sMapper.getLayoutId((java.lang.String) tag);
        if (layoutId != 0) {
            return (T) sMapper.getDataBinder(dataBindingComponent, view, layoutId);
        }
        throw new java.lang.IllegalArgumentException("View is not a binding layout. Tag: " + tag);
    }

    public static <T extends androidx.databinding.ViewDataBinding> T bind(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, int i) {
        return (T) sMapper.getDataBinder(dataBindingComponent, view, i);
    }

    public static <T extends androidx.databinding.ViewDataBinding> T bind(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View[] viewArr, int i) {
        return (T) sMapper.getDataBinder(dataBindingComponent, viewArr, i);
    }

    private static <T extends androidx.databinding.ViewDataBinding> T bindToAddedViews(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.ViewGroup viewGroup, int i, int i2) {
        int childCount = viewGroup.getChildCount();
        int i3 = childCount - i;
        if (i3 == 1) {
            return (T) bind(dataBindingComponent, viewGroup.getChildAt(childCount - 1), i2);
        }
        android.view.View[] viewArr = new android.view.View[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            viewArr[i4] = viewGroup.getChildAt(i4 + i);
        }
        return (T) bind(dataBindingComponent, viewArr, i2);
    }

    @androidx.annotation.Nullable
    public static java.lang.String convertBrIdToString(int i) {
        return sMapper.convertBrIdToString(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        if (r3 == (-1)) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
    
        if (r1.indexOf(47, r3 + 1) == (-1)) goto L18;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T extends androidx.databinding.ViewDataBinding> T findBinding(@androidx.annotation.NonNull android.view.View view) {
        while (view != null) {
            T t = (T) androidx.databinding.ViewDataBinding.getBinding(view);
            if (t != null) {
                return t;
            }
            java.lang.Object tag = view.getTag();
            if (tag instanceof java.lang.String) {
                java.lang.String str = (java.lang.String) tag;
                if (str.startsWith("layout") && str.endsWith("_0")) {
                    char charAt = str.charAt(6);
                    int indexOf = str.indexOf(47, 7);
                    boolean z = true;
                    boolean z2 = false;
                    if (charAt != '/') {
                        if (charAt == '-' && indexOf != -1) {
                        }
                    }
                    if (z2) {
                        return null;
                    }
                }
            }
            java.lang.Object parent = view.getParent();
            view = parent instanceof android.view.View ? (android.view.View) parent : null;
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static <T extends androidx.databinding.ViewDataBinding> T getBinding(@androidx.annotation.NonNull android.view.View view) {
        return (T) androidx.databinding.ViewDataBinding.getBinding(view);
    }

    @androidx.annotation.Nullable
    public static androidx.databinding.DataBindingComponent getDefaultComponent() {
        return sDefaultComponent;
    }

    public static <T extends androidx.databinding.ViewDataBinding> T inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, int i, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        return (T) inflate(layoutInflater, i, viewGroup, z, sDefaultComponent);
    }

    public static <T extends androidx.databinding.ViewDataBinding> T inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, int i, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z, @androidx.annotation.Nullable androidx.databinding.DataBindingComponent dataBindingComponent) {
        boolean z2 = viewGroup != null && z;
        return z2 ? (T) bindToAddedViews(dataBindingComponent, viewGroup, z2 ? viewGroup.getChildCount() : 0, i) : (T) bind(dataBindingComponent, layoutInflater.inflate(i, viewGroup, z), i);
    }

    public static <T extends androidx.databinding.ViewDataBinding> T setContentView(@androidx.annotation.NonNull android.app.Activity activity, int i) {
        return (T) setContentView(activity, i, sDefaultComponent);
    }

    public static <T extends androidx.databinding.ViewDataBinding> T setContentView(@androidx.annotation.NonNull android.app.Activity activity, int i, @androidx.annotation.Nullable androidx.databinding.DataBindingComponent dataBindingComponent) {
        activity.setContentView(i);
        return (T) bindToAddedViews(dataBindingComponent, (android.view.ViewGroup) activity.getWindow().getDecorView().findViewById(android.R.id.content), 0, i);
    }

    public static void setDefaultComponent(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent dataBindingComponent) {
        sDefaultComponent = dataBindingComponent;
    }
}
