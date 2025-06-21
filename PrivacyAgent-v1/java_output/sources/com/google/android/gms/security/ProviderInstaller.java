package com.google.android.gms.security;

/* loaded from: classes22.dex */
public class ProviderInstaller {

    @androidx.annotation.RecentlyNonNull
    public static final java.lang.String PROVIDER_NAME = "GmsCore_OpenSSL";
    public static final com.google.android.gms.common.GoogleApiAvailabilityLight a = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance();
    public static final java.lang.Object b = new java.lang.Object();
    public static java.lang.reflect.Method c = null;

    public interface ProviderInstallListener {
        void onProviderInstallFailed(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.content.Intent intent);

        void onProviderInstalled();
    }

    @androidx.annotation.Nullable
    public static android.content.Context a(android.content.Context context) {
        try {
            return com.google.android.gms.dynamite.DynamiteModule.load(context, com.google.android.gms.dynamite.DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.providerinstaller").getModuleContext();
        } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException e) {
            java.lang.String valueOf = java.lang.String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
                return null;
            }
            "Failed to load providerinstaller module: ".concat(valueOf);
            return null;
        }
    }

    @androidx.annotation.Nullable
    public static android.content.Context c(android.content.Context context) {
        try {
            return com.google.android.gms.common.GooglePlayServicesUtilLight.getRemoteContext(context);
        } catch (android.content.res.Resources.NotFoundException e) {
            java.lang.String valueOf = java.lang.String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                "Failed to load GMS Core context for providerinstaller: ".concat(valueOf);
            }
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(context, e);
            return null;
        }
    }

    public static void installIfNeeded(@androidx.annotation.RecentlyNonNull android.content.Context context) throws com.google.android.gms.common.GooglePlayServicesRepairableException, com.google.android.gms.common.GooglePlayServicesNotAvailableException {
        com.google.android.gms.common.internal.Preconditions.checkNotNull(context, "Context must not be null");
        a.verifyGooglePlayServicesIsAvailable(context, 11925000);
        android.content.Context a2 = a(context);
        if (a2 == null) {
            a2 = c(context);
        }
        if (a2 == null) {
            throw new com.google.android.gms.common.GooglePlayServicesNotAvailableException(8);
        }
        synchronized (b) {
            try {
                try {
                    if (c == null) {
                        c = a2.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", android.content.Context.class);
                    }
                    c.invoke(null, a2);
                } catch (java.lang.Exception e) {
                    java.lang.Throwable cause = e.getCause();
                    if (android.util.Log.isLoggable("ProviderInstaller", 6)) {
                        java.lang.String valueOf = java.lang.String.valueOf(cause == null ? e.getMessage() : cause.getMessage());
                        if (valueOf.length() != 0) {
                            "Failed to install provider: ".concat(valueOf);
                        }
                    }
                    throw new com.google.android.gms.common.GooglePlayServicesNotAvailableException(8);
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    public static void installIfNeededAsync(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull com.google.android.gms.security.ProviderInstaller.ProviderInstallListener providerInstallListener) {
        com.google.android.gms.common.internal.Preconditions.checkNotNull(context, "Context must not be null");
        com.google.android.gms.common.internal.Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        com.google.android.gms.common.internal.Preconditions.checkMainThread("Must be called on the UI thread");
        new com.google.android.gms.security.zza(context, providerInstallListener).execute(new java.lang.Void[0]);
    }
}
