package com.google.android.gms.common.internal.safeparcel;

/* loaded from: classes22.dex */
public interface SafeParcelable extends android.os.Parcelable {

    @androidx.annotation.RecentlyNonNull
    public static final java.lang.String NULL = "SAFE_PARCELABLE_NULL_STRING";

    public @interface Class {
        @androidx.annotation.RecentlyNonNull
        java.lang.String creator();

        @androidx.annotation.RecentlyNonNull
        boolean validate() default false;
    }

    public @interface Constructor {
    }

    public @interface Field {
        @androidx.annotation.RecentlyNonNull
        java.lang.String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";

        @androidx.annotation.RecentlyNonNull
        java.lang.String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";

        @androidx.annotation.RecentlyNonNull
        java.lang.String getter() default "SAFE_PARCELABLE_NULL_STRING";

        @androidx.annotation.RecentlyNonNull
        int id();

        @androidx.annotation.RecentlyNonNull
        java.lang.String type() default "SAFE_PARCELABLE_NULL_STRING";
    }

    public @interface Indicator {
        @androidx.annotation.RecentlyNonNull
        java.lang.String getter() default "SAFE_PARCELABLE_NULL_STRING";
    }

    public @interface Param {
        @androidx.annotation.RecentlyNonNull
        int id();
    }

    public @interface Reserved {
        @androidx.annotation.RecentlyNonNull
        int[] value();
    }

    public @interface VersionField {
        @androidx.annotation.RecentlyNonNull
        java.lang.String getter() default "SAFE_PARCELABLE_NULL_STRING";

        @androidx.annotation.RecentlyNonNull
        int id();

        @androidx.annotation.RecentlyNonNull
        java.lang.String type() default "SAFE_PARCELABLE_NULL_STRING";
    }
}
