package androidx.core.graphics;

/* loaded from: classes.dex */
public class BlendModeColorFilterCompat {
    private BlendModeColorFilterCompat() {
    }

    @androidx.annotation.Nullable
    public static android.graphics.ColorFilter createBlendModeColorFilterCompat(int i, @androidx.annotation.NonNull androidx.core.graphics.BlendModeCompat blendModeCompat) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            android.graphics.BlendMode obtainBlendModeFromCompat = androidx.core.graphics.BlendModeUtils.obtainBlendModeFromCompat(blendModeCompat);
            if (obtainBlendModeFromCompat != null) {
                return new android.graphics.BlendModeColorFilter(i, obtainBlendModeFromCompat);
            }
            return null;
        }
        android.graphics.PorterDuff.Mode obtainPorterDuffFromCompat = androidx.core.graphics.BlendModeUtils.obtainPorterDuffFromCompat(blendModeCompat);
        if (obtainPorterDuffFromCompat != null) {
            return new android.graphics.PorterDuffColorFilter(i, obtainPorterDuffFromCompat);
        }
        return null;
    }
}
