package com.bytedance.pangle.activity;

/* loaded from: classes12.dex */
public class IntentUtils {
    static java.util.HashMap<java.lang.Long, java.lang.ref.WeakReference<android.os.Bundle>> a = new java.util.HashMap<>();

    public static void a(android.content.Intent intent) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (longExtra != 0) {
            java.lang.ref.WeakReference<android.os.Bundle> remove = a.remove(java.lang.Long.valueOf(longExtra));
            android.os.Bundle bundle = remove != null ? remove.get() : null;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
        }
    }

    public static void a(android.content.Intent intent, java.lang.String str) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (com.bytedance.pangle.Zeus.getPlugin(str).mUseMemoryForActivityIntent && longExtra == 0) {
            longExtra = java.lang.System.currentTimeMillis();
        }
        if (longExtra != 0) {
            android.os.Bundle extras = intent.getExtras();
            intent.replaceExtras((android.os.Bundle) null);
            a.put(java.lang.Long.valueOf(longExtra), new java.lang.ref.WeakReference<>(extras));
            intent.putExtra("pangle_use_memory", longExtra);
        }
    }

    @androidx.annotation.Keep
    public static void setUseMemory(android.content.Intent intent) {
        intent.putExtra("pangle_use_memory", java.lang.System.currentTimeMillis());
    }
}
