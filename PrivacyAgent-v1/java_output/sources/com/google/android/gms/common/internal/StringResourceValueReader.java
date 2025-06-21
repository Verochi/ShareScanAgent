package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class StringResourceValueReader {
    public final android.content.res.Resources a;
    public final java.lang.String b;

    public StringResourceValueReader(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        com.google.android.gms.common.internal.Preconditions.checkNotNull(context);
        android.content.res.Resources resources = context.getResources();
        this.a = resources;
        this.b = resources.getResourcePackageName(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public java.lang.String getString(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        int identifier = this.a.getIdentifier(str, com.anythink.expressad.foundation.h.i.g, this.b);
        if (identifier == 0) {
            return null;
        }
        return this.a.getString(identifier);
    }
}
