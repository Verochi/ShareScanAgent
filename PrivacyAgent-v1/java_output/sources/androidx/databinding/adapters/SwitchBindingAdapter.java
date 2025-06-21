package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "android:thumb", method = "setThumbDrawable", type = android.widget.Switch.class), @androidx.databinding.BindingMethod(attribute = "android:track", method = "setTrackDrawable", type = android.widget.Switch.class)})
@android.annotation.TargetApi(14)
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class SwitchBindingAdapter {
    @androidx.databinding.BindingAdapter({"android:switchTextAppearance"})
    public static void setSwitchTextAppearance(android.widget.Switch r1, int i) {
        r1.setSwitchTextAppearance(null, i);
    }
}
