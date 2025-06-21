package androidx.databinding.adapters;

/* loaded from: classes.dex */
public class Converters {
    @androidx.databinding.BindingConversion
    public static android.content.res.ColorStateList convertColorToColorStateList(int i) {
        return android.content.res.ColorStateList.valueOf(i);
    }

    @androidx.databinding.BindingConversion
    public static android.graphics.drawable.ColorDrawable convertColorToDrawable(int i) {
        return new android.graphics.drawable.ColorDrawable(i);
    }
}
