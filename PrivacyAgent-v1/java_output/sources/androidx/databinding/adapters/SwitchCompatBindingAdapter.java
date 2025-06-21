package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "android:thumb", method = "setThumbDrawable", type = androidx.appcompat.widget.SwitchCompat.class), @androidx.databinding.BindingMethod(attribute = "android:track", method = "setTrackDrawable", type = androidx.appcompat.widget.SwitchCompat.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class SwitchCompatBindingAdapter {
    @androidx.databinding.BindingAdapter({"android:switchTextAppearance"})
    public static void setSwitchTextAppearance(androidx.appcompat.widget.SwitchCompat switchCompat, int i) {
        switchCompat.setSwitchTextAppearance(null, i);
    }
}
