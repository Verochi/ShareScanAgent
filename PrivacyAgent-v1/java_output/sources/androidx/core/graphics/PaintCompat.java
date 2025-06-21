package androidx.core.graphics;

/* loaded from: classes.dex */
public final class PaintCompat {
    private static final java.lang.String EM_STRING = "m";
    private static final java.lang.String TOFU_STRING = "\udfffd";
    private static final java.lang.ThreadLocal<androidx.core.util.Pair<android.graphics.Rect, android.graphics.Rect>> sRectThreadLocal = new java.lang.ThreadLocal<>();

    private PaintCompat() {
    }

    public static boolean hasGlyph(@androidx.annotation.NonNull android.graphics.Paint paint, @androidx.annotation.NonNull java.lang.String str) {
        boolean hasGlyph;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            hasGlyph = paint.hasGlyph(str);
            return hasGlyph;
        }
        int length = str.length();
        if (length == 1 && java.lang.Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText(TOFU_STRING);
        float measureText2 = paint.measureText("m");
        float measureText3 = paint.measureText(str);
        float f = 0.0f;
        if (measureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > measureText2 * 2.0f) {
                return false;
            }
            int i = 0;
            while (i < length) {
                int charCount = java.lang.Character.charCount(str.codePointAt(i)) + i;
                f += paint.measureText(str, i, charCount);
                i = charCount;
            }
            if (measureText3 >= f) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        androidx.core.util.Pair<android.graphics.Rect, android.graphics.Rect> obtainEmptyRects = obtainEmptyRects();
        paint.getTextBounds(TOFU_STRING, 0, 2, obtainEmptyRects.first);
        paint.getTextBounds(str, 0, length, obtainEmptyRects.second);
        return !obtainEmptyRects.first.equals(obtainEmptyRects.second);
    }

    private static androidx.core.util.Pair<android.graphics.Rect, android.graphics.Rect> obtainEmptyRects() {
        java.lang.ThreadLocal<androidx.core.util.Pair<android.graphics.Rect, android.graphics.Rect>> threadLocal = sRectThreadLocal;
        androidx.core.util.Pair<android.graphics.Rect, android.graphics.Rect> pair = threadLocal.get();
        if (pair == null) {
            androidx.core.util.Pair<android.graphics.Rect, android.graphics.Rect> pair2 = new androidx.core.util.Pair<>(new android.graphics.Rect(), new android.graphics.Rect());
            threadLocal.set(pair2);
            return pair2;
        }
        pair.first.setEmpty();
        pair.second.setEmpty();
        return pair;
    }

    public static boolean setBlendMode(@androidx.annotation.NonNull android.graphics.Paint paint, @androidx.annotation.Nullable androidx.core.graphics.BlendModeCompat blendModeCompat) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            paint.setBlendMode(blendModeCompat != null ? androidx.core.graphics.BlendModeUtils.obtainBlendModeFromCompat(blendModeCompat) : null);
            return true;
        }
        if (blendModeCompat == null) {
            paint.setXfermode(null);
            return true;
        }
        android.graphics.PorterDuff.Mode obtainPorterDuffFromCompat = androidx.core.graphics.BlendModeUtils.obtainPorterDuffFromCompat(blendModeCompat);
        paint.setXfermode(obtainPorterDuffFromCompat != null ? new android.graphics.PorterDuffXfermode(obtainPorterDuffFromCompat) : null);
        return obtainPorterDuffFromCompat != null;
    }
}
