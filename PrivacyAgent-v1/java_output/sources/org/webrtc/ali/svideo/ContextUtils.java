package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
public class ContextUtils {
    private static final java.lang.String TAG = "ContextUtils";
    private static android.content.Context applicationContext;

    public static android.content.Context getApplicationContext() {
        return applicationContext;
    }

    public static void initialize(android.content.Context context) {
        if (applicationContext != null) {
            org.webrtc.ali.svideo.Logging.e(TAG, "Calling ContextUtils.initialize multiple times, this will crash in the future!");
        }
        if (context == null) {
            throw new java.lang.RuntimeException("Application context cannot be null for ContextUtils.initialize.");
        }
        applicationContext = context;
    }
}
