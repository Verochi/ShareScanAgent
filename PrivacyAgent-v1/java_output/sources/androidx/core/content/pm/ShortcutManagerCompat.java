package androidx.core.content.pm;

/* loaded from: classes.dex */
public class ShortcutManagerCompat {

    @androidx.annotation.VisibleForTesting
    static final java.lang.String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final java.lang.String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;

    @androidx.annotation.VisibleForTesting
    static final java.lang.String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static volatile androidx.core.content.pm.ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    /* renamed from: androidx.core.content.pm.ShortcutManagerCompat$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.BroadcastReceiver {
        final /* synthetic */ android.content.IntentSender val$callback;

        public AnonymousClass1(android.content.IntentSender intentSender) {
            this.val$callback = intentSender;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            try {
                this.val$callback.sendIntent(context, 0, null, null, null);
            } catch (android.content.IntentSender.SendIntentException unused) {
            }
        }
    }

    @androidx.annotation.RequiresApi(25)
    public static class Api25Impl {
        private Api25Impl() {
        }

        public static java.lang.String getShortcutInfoWithLowestRank(@androidx.annotation.NonNull java.util.List<android.content.pm.ShortcutInfo> list) {
            int rank;
            java.lang.String id;
            int rank2;
            int i = -1;
            java.lang.String str = null;
            for (android.content.pm.ShortcutInfo shortcutInfo : list) {
                rank = shortcutInfo.getRank();
                if (rank > i) {
                    id = shortcutInfo.getId();
                    rank2 = shortcutInfo.getRank();
                    str = id;
                    i = rank2;
                }
            }
            return str;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ShortcutMatchFlags {
    }

    private ShortcutManagerCompat() {
    }

    public static boolean addDynamicShortcuts(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.List<androidx.core.content.pm.ShortcutInfoCompat> list) {
        java.lang.Object systemService;
        boolean addDynamicShortcuts;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i <= 29) {
            convertUriIconsToBitmapIcons(context, list);
        }
        if (i >= 25) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<androidx.core.content.pm.ShortcutInfoCompat> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toShortcutInfo());
            }
            systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            addDynamicShortcuts = ((android.content.pm.ShortcutManager) systemService).addDynamicShortcuts(arrayList);
            if (!addDynamicShortcuts) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).addShortcuts(list);
        return true;
    }

    @androidx.annotation.VisibleForTesting
    public static boolean convertUriIconToBitmapIcon(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.core.content.pm.ShortcutInfoCompat shortcutInfoCompat) {
        android.graphics.Bitmap decodeStream;
        androidx.core.graphics.drawable.IconCompat iconCompat = shortcutInfoCompat.mIcon;
        if (iconCompat == null) {
            return false;
        }
        int i = iconCompat.mType;
        if (i != 6 && i != 4) {
            return true;
        }
        java.io.InputStream uriInputStream = iconCompat.getUriInputStream(context);
        if (uriInputStream == null || (decodeStream = android.graphics.BitmapFactory.decodeStream(uriInputStream)) == null) {
            return false;
        }
        shortcutInfoCompat.mIcon = i == 6 ? androidx.core.graphics.drawable.IconCompat.createWithAdaptiveBitmap(decodeStream) : androidx.core.graphics.drawable.IconCompat.createWithBitmap(decodeStream);
        return true;
    }

    @androidx.annotation.VisibleForTesting
    public static void convertUriIconsToBitmapIcons(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.List<androidx.core.content.pm.ShortcutInfoCompat> list) {
        for (androidx.core.content.pm.ShortcutInfoCompat shortcutInfoCompat : new java.util.ArrayList(list)) {
            if (!convertUriIconToBitmapIcon(context, shortcutInfoCompat)) {
                list.remove(shortcutInfoCompat);
            }
        }
    }

    @androidx.annotation.NonNull
    public static android.content.Intent createShortcutResultIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.core.content.pm.ShortcutInfoCompat shortcutInfoCompat) {
        android.content.Intent intent;
        java.lang.Object systemService;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            intent = ((android.content.pm.ShortcutManager) systemService).createShortcutResultIntent(shortcutInfoCompat.toShortcutInfo());
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = new android.content.Intent();
        }
        return shortcutInfoCompat.addToIntent(intent);
    }

    public static void disableShortcuts(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.List<java.lang.String> list, @androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        java.lang.Object systemService;
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            ((android.content.pm.ShortcutManager) systemService).disableShortcuts(list, charSequence);
        }
        getShortcutInfoSaverInstance(context).removeShortcuts(list);
    }

    public static void enableShortcuts(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.List<androidx.core.content.pm.ShortcutInfoCompat> list) {
        java.lang.Object systemService;
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
            java.util.Iterator<androidx.core.content.pm.ShortcutInfoCompat> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().mId);
            }
            systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            ((android.content.pm.ShortcutManager) systemService).enableShortcuts(arrayList);
        }
        getShortcutInfoSaverInstance(context).addShortcuts(list);
    }

    @androidx.annotation.NonNull
    public static java.util.List<androidx.core.content.pm.ShortcutInfoCompat> getDynamicShortcuts(@androidx.annotation.NonNull android.content.Context context) {
        java.lang.Object systemService;
        java.util.List dynamicShortcuts;
        if (android.os.Build.VERSION.SDK_INT < 25) {
            try {
                return getShortcutInfoSaverInstance(context).getShortcuts();
            } catch (java.lang.Exception unused) {
                return new java.util.ArrayList();
            }
        }
        systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
        dynamicShortcuts = ((android.content.pm.ShortcutManager) systemService).getDynamicShortcuts();
        java.util.ArrayList arrayList = new java.util.ArrayList(dynamicShortcuts.size());
        java.util.Iterator it = dynamicShortcuts.iterator();
        while (it.hasNext()) {
            arrayList.add(new androidx.core.content.pm.ShortcutInfoCompat.Builder(context, (android.content.pm.ShortcutInfo) it.next()).build());
        }
        return arrayList;
    }

    private static int getIconDimensionInternal(@androidx.annotation.NonNull android.content.Context context, boolean z) {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        int max = java.lang.Math.max(1, activityManager == null || activityManager.isLowRamDevice() ? 48 : 96);
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (max * ((z ? displayMetrics.xdpi : displayMetrics.ydpi) / 160.0f));
    }

    public static int getIconMaxHeight(@androidx.annotation.NonNull android.content.Context context) {
        java.lang.Object systemService;
        int iconMaxHeight;
        androidx.core.util.Preconditions.checkNotNull(context);
        if (android.os.Build.VERSION.SDK_INT < 25) {
            return getIconDimensionInternal(context, false);
        }
        systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
        iconMaxHeight = ((android.content.pm.ShortcutManager) systemService).getIconMaxHeight();
        return iconMaxHeight;
    }

    public static int getIconMaxWidth(@androidx.annotation.NonNull android.content.Context context) {
        java.lang.Object systemService;
        int iconMaxWidth;
        androidx.core.util.Preconditions.checkNotNull(context);
        if (android.os.Build.VERSION.SDK_INT < 25) {
            return getIconDimensionInternal(context, true);
        }
        systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
        iconMaxWidth = ((android.content.pm.ShortcutManager) systemService).getIconMaxWidth();
        return iconMaxWidth;
    }

    public static int getMaxShortcutCountPerActivity(@androidx.annotation.NonNull android.content.Context context) {
        java.lang.Object systemService;
        int maxShortcutCountPerActivity;
        androidx.core.util.Preconditions.checkNotNull(context);
        if (android.os.Build.VERSION.SDK_INT < 25) {
            return 5;
        }
        systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
        maxShortcutCountPerActivity = ((android.content.pm.ShortcutManager) systemService).getMaxShortcutCountPerActivity();
        return maxShortcutCountPerActivity;
    }

    private static java.lang.String getShortcutInfoCompatWithLowestRank(@androidx.annotation.NonNull java.util.List<androidx.core.content.pm.ShortcutInfoCompat> list) {
        int i = -1;
        java.lang.String str = null;
        for (androidx.core.content.pm.ShortcutInfoCompat shortcutInfoCompat : list) {
            if (shortcutInfoCompat.getRank() > i) {
                str = shortcutInfoCompat.getId();
                i = shortcutInfoCompat.getRank();
            }
        }
        return str;
    }

    private static androidx.core.content.pm.ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(android.content.Context context) {
        if (sShortcutInfoCompatSaver == null) {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                try {
                    sShortcutInfoCompatSaver = (androidx.core.content.pm.ShortcutInfoCompatSaver) java.lang.Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, androidx.core.content.pm.ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", android.content.Context.class).invoke(null, context);
                } catch (java.lang.Exception unused) {
                }
            }
            if (sShortcutInfoCompatSaver == null) {
                sShortcutInfoCompatSaver = new androidx.core.content.pm.ShortcutInfoCompatSaver.NoopImpl();
            }
        }
        return sShortcutInfoCompatSaver;
    }

    @androidx.annotation.NonNull
    public static java.util.List<androidx.core.content.pm.ShortcutInfoCompat> getShortcuts(@androidx.annotation.NonNull android.content.Context context, int i) {
        java.lang.Object systemService;
        java.util.List pinnedShortcuts;
        java.util.List dynamicShortcuts;
        java.util.List manifestShortcuts;
        java.lang.Object systemService2;
        java.util.List shortcuts;
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            systemService2 = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            shortcuts = ((android.content.pm.ShortcutManager) systemService2).getShortcuts(i);
            return androidx.core.content.pm.ShortcutInfoCompat.fromShortcuts(context, shortcuts);
        }
        if (i2 < 25) {
            if ((i & 2) != 0) {
                try {
                    return getShortcutInfoSaverInstance(context).getShortcuts();
                } catch (java.lang.Exception unused) {
                }
            }
            return java.util.Collections.emptyList();
        }
        systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
        android.content.pm.ShortcutManager shortcutManager = (android.content.pm.ShortcutManager) systemService;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if ((i & 1) != 0) {
            manifestShortcuts = shortcutManager.getManifestShortcuts();
            arrayList.addAll(manifestShortcuts);
        }
        if ((i & 2) != 0) {
            dynamicShortcuts = shortcutManager.getDynamicShortcuts();
            arrayList.addAll(dynamicShortcuts);
        }
        if ((i & 4) != 0) {
            pinnedShortcuts = shortcutManager.getPinnedShortcuts();
            arrayList.addAll(pinnedShortcuts);
        }
        return androidx.core.content.pm.ShortcutInfoCompat.fromShortcuts(context, arrayList);
    }

    public static boolean isRateLimitingActive(@androidx.annotation.NonNull android.content.Context context) {
        java.lang.Object systemService;
        boolean isRateLimitingActive;
        androidx.core.util.Preconditions.checkNotNull(context);
        if (android.os.Build.VERSION.SDK_INT < 25) {
            return getShortcuts(context, 3).size() == getMaxShortcutCountPerActivity(context);
        }
        systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
        isRateLimitingActive = ((android.content.pm.ShortcutManager) systemService).isRateLimitingActive();
        return isRateLimitingActive;
    }

    public static boolean isRequestPinShortcutSupported(@androidx.annotation.NonNull android.content.Context context) {
        java.lang.Object systemService;
        boolean isRequestPinShortcutSupported;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            isRequestPinShortcutSupported = ((android.content.pm.ShortcutManager) systemService).isRequestPinShortcutSupported();
            return isRequestPinShortcutSupported;
        }
        if (androidx.core.content.ContextCompat.checkSelfPermission(context, INSTALL_SHORTCUT_PERMISSION) != 0) {
            return false;
        }
        java.util.Iterator<android.content.pm.ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(new android.content.Intent(ACTION_INSTALL_SHORTCUT), 0).iterator();
        while (it.hasNext()) {
            java.lang.String str = it.next().activityInfo.permission;
            if (android.text.TextUtils.isEmpty(str) || INSTALL_SHORTCUT_PERMISSION.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean pushDynamicShortcut(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.core.content.pm.ShortcutInfoCompat shortcutInfoCompat) {
        java.lang.Object systemService;
        boolean isRateLimitingActive;
        java.util.List dynamicShortcuts;
        java.lang.Object systemService2;
        androidx.core.util.Preconditions.checkNotNull(context);
        androidx.core.util.Preconditions.checkNotNull(shortcutInfoCompat);
        int maxShortcutCountPerActivity = getMaxShortcutCountPerActivity(context);
        if (maxShortcutCountPerActivity == 0) {
            return false;
        }
        int i = android.os.Build.VERSION.SDK_INT;
        if (i <= 29) {
            convertUriIconToBitmapIcon(context, shortcutInfoCompat);
        }
        if (i >= 30) {
            systemService2 = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            ((android.content.pm.ShortcutManager) systemService2).pushDynamicShortcut(shortcutInfoCompat.toShortcutInfo());
        } else if (i >= 25) {
            systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            android.content.pm.ShortcutManager shortcutManager = (android.content.pm.ShortcutManager) systemService;
            isRateLimitingActive = shortcutManager.isRateLimitingActive();
            if (isRateLimitingActive) {
                return false;
            }
            dynamicShortcuts = shortcutManager.getDynamicShortcuts();
            if (dynamicShortcuts.size() >= maxShortcutCountPerActivity) {
                shortcutManager.removeDynamicShortcuts(java.util.Arrays.asList(androidx.core.content.pm.ShortcutManagerCompat.Api25Impl.getShortcutInfoWithLowestRank(dynamicShortcuts)));
            }
            shortcutManager.addDynamicShortcuts(java.util.Arrays.asList(shortcutInfoCompat.toShortcutInfo()));
        }
        androidx.core.content.pm.ShortcutInfoCompatSaver<?> shortcutInfoSaverInstance = getShortcutInfoSaverInstance(context);
        try {
            java.util.List<androidx.core.content.pm.ShortcutInfoCompat> shortcuts = shortcutInfoSaverInstance.getShortcuts();
            if (shortcuts.size() >= maxShortcutCountPerActivity) {
                shortcutInfoSaverInstance.removeShortcuts(java.util.Arrays.asList(getShortcutInfoCompatWithLowestRank(shortcuts)));
            }
            shortcutInfoSaverInstance.addShortcuts(java.util.Arrays.asList(shortcutInfoCompat));
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static void removeAllDynamicShortcuts(@androidx.annotation.NonNull android.content.Context context) {
        java.lang.Object systemService;
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            ((android.content.pm.ShortcutManager) systemService).removeAllDynamicShortcuts();
        }
        getShortcutInfoSaverInstance(context).removeAllShortcuts();
    }

    public static void removeDynamicShortcuts(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.List<java.lang.String> list) {
        java.lang.Object systemService;
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            ((android.content.pm.ShortcutManager) systemService).removeDynamicShortcuts(list);
        }
        getShortcutInfoSaverInstance(context).removeShortcuts(list);
    }

    public static void removeLongLivedShortcuts(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.List<java.lang.String> list) {
        java.lang.Object systemService;
        if (android.os.Build.VERSION.SDK_INT < 30) {
            removeDynamicShortcuts(context, list);
            return;
        }
        systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
        ((android.content.pm.ShortcutManager) systemService).removeLongLivedShortcuts(list);
        getShortcutInfoSaverInstance(context).removeShortcuts(list);
    }

    public static void reportShortcutUsed(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
        java.lang.Object systemService;
        androidx.core.util.Preconditions.checkNotNull(context);
        androidx.core.util.Preconditions.checkNotNull(str);
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            ((android.content.pm.ShortcutManager) systemService).reportShortcutUsed(str);
        }
    }

    public static boolean requestPinShortcut(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.core.content.pm.ShortcutInfoCompat shortcutInfoCompat, @androidx.annotation.Nullable android.content.IntentSender intentSender) {
        java.lang.Object systemService;
        boolean requestPinShortcut;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            requestPinShortcut = ((android.content.pm.ShortcutManager) systemService).requestPinShortcut(shortcutInfoCompat.toShortcutInfo(), intentSender);
            return requestPinShortcut;
        }
        if (!isRequestPinShortcutSupported(context)) {
            return false;
        }
        android.content.Intent addToIntent = shortcutInfoCompat.addToIntent(new android.content.Intent(ACTION_INSTALL_SHORTCUT));
        if (intentSender == null) {
            context.sendBroadcast(addToIntent);
            return true;
        }
        context.sendOrderedBroadcast(addToIntent, null, new androidx.core.content.pm.ShortcutManagerCompat.AnonymousClass1(intentSender), null, -1, null, null);
        return true;
    }

    public static boolean setDynamicShortcuts(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.List<androidx.core.content.pm.ShortcutInfoCompat> list) {
        java.lang.Object systemService;
        boolean dynamicShortcuts;
        androidx.core.util.Preconditions.checkNotNull(context);
        androidx.core.util.Preconditions.checkNotNull(list);
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
            java.util.Iterator<androidx.core.content.pm.ShortcutInfoCompat> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toShortcutInfo());
            }
            systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            dynamicShortcuts = ((android.content.pm.ShortcutManager) systemService).setDynamicShortcuts(arrayList);
            if (!dynamicShortcuts) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).removeAllShortcuts();
        getShortcutInfoSaverInstance(context).addShortcuts(list);
        return true;
    }

    @androidx.annotation.VisibleForTesting
    public static void setShortcutInfoCompatSaver(androidx.core.content.pm.ShortcutInfoCompatSaver<java.lang.Void> shortcutInfoCompatSaver) {
        sShortcutInfoCompatSaver = shortcutInfoCompatSaver;
    }

    public static boolean updateShortcuts(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.List<androidx.core.content.pm.ShortcutInfoCompat> list) {
        java.lang.Object systemService;
        boolean updateShortcuts;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i <= 29) {
            convertUriIconsToBitmapIcons(context, list);
        }
        if (i >= 25) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<androidx.core.content.pm.ShortcutInfoCompat> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toShortcutInfo());
            }
            systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.content.pm.ShortcutManager.class);
            updateShortcuts = ((android.content.pm.ShortcutManager) systemService).updateShortcuts(arrayList);
            if (!updateShortcuts) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).addShortcuts(list);
        return true;
    }
}
