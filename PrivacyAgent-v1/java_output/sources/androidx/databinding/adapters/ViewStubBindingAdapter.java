package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "android:layout", method = "setLayoutResource", type = android.view.ViewStub.class)})
@androidx.databinding.Untaggable({"android.view.ViewStub"})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ViewStubBindingAdapter {
    @androidx.databinding.BindingAdapter({"android:onInflate"})
    public static void setOnInflateListener(androidx.databinding.ViewStubProxy viewStubProxy, android.view.ViewStub.OnInflateListener onInflateListener) {
        viewStubProxy.setOnInflateListener(onInflateListener);
    }
}
