package androidx.core.os;

/* loaded from: classes.dex */
public class UserManagerCompat {
    private UserManagerCompat() {
    }

    public static boolean isUserUnlocked(@androidx.annotation.NonNull android.content.Context context) {
        java.lang.Object systemService;
        boolean isUserUnlocked;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return true;
        }
        systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.os.UserManager.class);
        isUserUnlocked = ((android.os.UserManager) systemService).isUserUnlocked();
        return isUserUnlocked;
    }
}
