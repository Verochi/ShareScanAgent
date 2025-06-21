package androidx.core.content;

@java.lang.Deprecated
/* loaded from: classes.dex */
public final class SharedPreferencesCompat {

    @java.lang.Deprecated
    public static final class EditorCompat {
        private static androidx.core.content.SharedPreferencesCompat.EditorCompat sInstance;
        private final androidx.core.content.SharedPreferencesCompat.EditorCompat.Helper mHelper = new androidx.core.content.SharedPreferencesCompat.EditorCompat.Helper();

        public static class Helper {
            public void apply(@androidx.annotation.NonNull android.content.SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (java.lang.AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        private EditorCompat() {
        }

        @java.lang.Deprecated
        public static androidx.core.content.SharedPreferencesCompat.EditorCompat getInstance() {
            if (sInstance == null) {
                sInstance = new androidx.core.content.SharedPreferencesCompat.EditorCompat();
            }
            return sInstance;
        }

        @java.lang.Deprecated
        public void apply(@androidx.annotation.NonNull android.content.SharedPreferences.Editor editor) {
            this.mHelper.apply(editor);
        }
    }

    private SharedPreferencesCompat() {
    }
}
