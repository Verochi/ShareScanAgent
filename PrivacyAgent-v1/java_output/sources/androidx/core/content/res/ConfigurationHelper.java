package androidx.core.content.res;

/* loaded from: classes.dex */
public final class ConfigurationHelper {
    private ConfigurationHelper() {
    }

    public static int getDensityDpi(@androidx.annotation.NonNull android.content.res.Resources resources) {
        return resources.getConfiguration().densityDpi;
    }
}
