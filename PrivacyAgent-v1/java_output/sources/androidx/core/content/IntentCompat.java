package androidx.core.content;

/* loaded from: classes.dex */
public final class IntentCompat {

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final java.lang.String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final java.lang.String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final java.lang.String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_TIME = "android.intent.extra.TIME";

    private IntentCompat() {
    }

    @androidx.annotation.NonNull
    public static android.content.Intent makeMainSelectorActivity(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        return android.content.Intent.makeMainSelectorActivity(str, str2);
    }
}
