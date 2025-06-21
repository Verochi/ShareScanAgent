package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class ServiceSpecificExtraArgs {

    @com.google.android.gms.common.annotation.KeepForSdk
    public interface CastExtraArgs {

        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        public static final java.lang.String LISTENER = "listener";
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public interface GamesExtraArgs {

        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        public static final java.lang.String DESIRED_LOCALE = "com.google.android.gms.games.key.desiredLocale";

        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        public static final java.lang.String GAME_PACKAGE_NAME = "com.google.android.gms.games.key.gamePackageName";

        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        public static final java.lang.String SIGNIN_OPTIONS = "com.google.android.gms.games.key.signInOptions";

        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        public static final java.lang.String WINDOW_TOKEN = "com.google.android.gms.games.key.popupWindowToken";
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public interface PlusExtraArgs {

        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        public static final java.lang.String PLUS_AUTH_PACKAGE = "auth_package";
    }
}
