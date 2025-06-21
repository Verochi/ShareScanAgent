package androidx.core.view.inputmethod;

/* loaded from: classes.dex */
public final class EditorInfoCompat {
    private static final java.lang.String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final java.lang.String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final java.lang.String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final java.lang.String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final java.lang.String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final java.lang.String[] EMPTY_STRING_ARRAY = new java.lang.String[0];
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;

    @androidx.annotation.VisibleForTesting
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;

    @androidx.annotation.VisibleForTesting
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;

    @androidx.annotation.RequiresApi(30)
    public static class Impl30 {
        private Impl30() {
        }

        public static java.lang.CharSequence getInitialSelectedText(@androidx.annotation.NonNull android.view.inputmethod.EditorInfo editorInfo, int i) {
            java.lang.CharSequence initialSelectedText;
            initialSelectedText = editorInfo.getInitialSelectedText(i);
            return initialSelectedText;
        }

        public static java.lang.CharSequence getInitialTextAfterCursor(@androidx.annotation.NonNull android.view.inputmethod.EditorInfo editorInfo, int i, int i2) {
            java.lang.CharSequence initialTextAfterCursor;
            initialTextAfterCursor = editorInfo.getInitialTextAfterCursor(i, i2);
            return initialTextAfterCursor;
        }

        public static java.lang.CharSequence getInitialTextBeforeCursor(@androidx.annotation.NonNull android.view.inputmethod.EditorInfo editorInfo, int i, int i2) {
            java.lang.CharSequence initialTextBeforeCursor;
            initialTextBeforeCursor = editorInfo.getInitialTextBeforeCursor(i, i2);
            return initialTextBeforeCursor;
        }

        public static void setInitialSurroundingSubText(@androidx.annotation.NonNull android.view.inputmethod.EditorInfo editorInfo, java.lang.CharSequence charSequence, int i) {
            editorInfo.setInitialSurroundingSubText(charSequence, i);
        }
    }

    @java.lang.Deprecated
    public EditorInfoCompat() {
    }

    @androidx.annotation.NonNull
    public static java.lang.String[] getContentMimeTypes(android.view.inputmethod.EditorInfo editorInfo) {
        java.lang.String[] strArr;
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            strArr = editorInfo.contentMimeTypes;
            return strArr != null ? strArr : EMPTY_STRING_ARRAY;
        }
        android.os.Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return EMPTY_STRING_ARRAY;
        }
        java.lang.String[] stringArray = bundle.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
        }
        return stringArray != null ? stringArray : EMPTY_STRING_ARRAY;
    }

    @androidx.annotation.Nullable
    public static java.lang.CharSequence getInitialSelectedText(@androidx.annotation.NonNull android.view.inputmethod.EditorInfo editorInfo, int i) {
        java.lang.CharSequence charSequence;
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            return androidx.core.view.inputmethod.EditorInfoCompat.Impl30.getInitialSelectedText(editorInfo, i);
        }
        android.os.Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return null;
        }
        int i2 = editorInfo.initialSelStart;
        int i3 = editorInfo.initialSelEnd;
        int i4 = i2 > i3 ? i3 : i2;
        if (i2 <= i3) {
            i2 = i3;
        }
        int i5 = bundle.getInt(CONTENT_SELECTION_HEAD_KEY);
        int i6 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int i7 = i2 - i4;
        if (editorInfo.initialSelStart < 0 || editorInfo.initialSelEnd < 0 || i6 - i5 != i7 || (charSequence = editorInfo.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        return (i & 1) != 0 ? charSequence.subSequence(i5, i6) : android.text.TextUtils.substring(charSequence, i5, i6);
    }

    @androidx.annotation.Nullable
    public static java.lang.CharSequence getInitialTextAfterCursor(@androidx.annotation.NonNull android.view.inputmethod.EditorInfo editorInfo, int i, int i2) {
        java.lang.CharSequence charSequence;
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            return androidx.core.view.inputmethod.EditorInfoCompat.Impl30.getInitialTextAfterCursor(editorInfo, i, i2);
        }
        android.os.Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i3 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int min = java.lang.Math.min(i, charSequence.length() - i3);
        return (i2 & 1) != 0 ? charSequence.subSequence(i3, min + i3) : android.text.TextUtils.substring(charSequence, i3, min + i3);
    }

    @androidx.annotation.Nullable
    public static java.lang.CharSequence getInitialTextBeforeCursor(@androidx.annotation.NonNull android.view.inputmethod.EditorInfo editorInfo, int i, int i2) {
        java.lang.CharSequence charSequence;
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            return androidx.core.view.inputmethod.EditorInfoCompat.Impl30.getInitialTextBeforeCursor(editorInfo, i, i2);
        }
        android.os.Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i3 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int min = java.lang.Math.min(i, i3);
        return (i2 & 1) != 0 ? charSequence.subSequence(i3 - min, i3) : android.text.TextUtils.substring(charSequence, i3 - min, i3);
    }

    public static int getProtocol(android.view.inputmethod.EditorInfo editorInfo) {
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        android.os.Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return 0;
        }
        boolean containsKey = bundle.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean containsKey2 = editorInfo.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (containsKey && containsKey2) {
            return 4;
        }
        if (containsKey) {
            return 3;
        }
        return containsKey2 ? 2 : 0;
    }

    private static boolean isCutOnSurrogate(java.lang.CharSequence charSequence, int i, int i2) {
        if (i2 == 0) {
            return java.lang.Character.isLowSurrogate(charSequence.charAt(i));
        }
        if (i2 != 1) {
            return false;
        }
        return java.lang.Character.isHighSurrogate(charSequence.charAt(i));
    }

    private static boolean isPasswordInputType(int i) {
        int i2 = i & org.apache.tools.zip.UnixStat.PERM_MASK;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    public static void setContentMimeTypes(@androidx.annotation.NonNull android.view.inputmethod.EditorInfo editorInfo, @androidx.annotation.Nullable java.lang.String[] strArr) {
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new android.os.Bundle();
        }
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_KEY, strArr);
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, strArr);
    }

    public static void setInitialSurroundingSubText(@androidx.annotation.NonNull android.view.inputmethod.EditorInfo editorInfo, @androidx.annotation.NonNull java.lang.CharSequence charSequence, int i) {
        androidx.core.util.Preconditions.checkNotNull(charSequence);
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            androidx.core.view.inputmethod.EditorInfoCompat.Impl30.setInitialSurroundingSubText(editorInfo, charSequence, i);
            return;
        }
        int i2 = editorInfo.initialSelStart;
        int i3 = editorInfo.initialSelEnd;
        int i4 = i2 > i3 ? i3 - i : i2 - i;
        int i5 = i2 > i3 ? i2 - i : i3 - i;
        int length = charSequence.length();
        if (i < 0 || i4 < 0 || i5 > length) {
            setSurroundingText(editorInfo, null, 0, 0);
            return;
        }
        if (isPasswordInputType(editorInfo.inputType)) {
            setSurroundingText(editorInfo, null, 0, 0);
        } else if (length <= 2048) {
            setSurroundingText(editorInfo, charSequence, i4, i5);
        } else {
            trimLongSurroundingText(editorInfo, charSequence, i4, i5);
        }
    }

    public static void setInitialSurroundingText(@androidx.annotation.NonNull android.view.inputmethod.EditorInfo editorInfo, @androidx.annotation.NonNull java.lang.CharSequence charSequence) {
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            androidx.core.view.inputmethod.EditorInfoCompat.Impl30.setInitialSurroundingSubText(editorInfo, charSequence, 0);
        } else {
            setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }

    private static void setSurroundingText(android.view.inputmethod.EditorInfo editorInfo, java.lang.CharSequence charSequence, int i, int i2) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new android.os.Bundle();
        }
        editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, charSequence != null ? new android.text.SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, i);
        editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, i2);
    }

    private static void trimLongSurroundingText(android.view.inputmethod.EditorInfo editorInfo, java.lang.CharSequence charSequence, int i, int i2) {
        int i3 = i2 - i;
        int i4 = i3 > 1024 ? 0 : i3;
        int i5 = 2048 - i4;
        int min = java.lang.Math.min(charSequence.length() - i2, i5 - java.lang.Math.min(i, (int) (i5 * 0.8d)));
        int min2 = java.lang.Math.min(i, i5 - min);
        int i6 = i - min2;
        if (isCutOnSurrogate(charSequence, i6, 0)) {
            i6++;
            min2--;
        }
        if (isCutOnSurrogate(charSequence, (i2 + min) - 1, 1)) {
            min--;
        }
        java.lang.CharSequence concat = i4 != i3 ? android.text.TextUtils.concat(charSequence.subSequence(i6, i6 + min2), charSequence.subSequence(i2, min + i2)) : charSequence.subSequence(i6, min2 + i4 + min + i6);
        int i7 = min2 + 0;
        setSurroundingText(editorInfo, concat, i7, i4 + i7);
    }
}
