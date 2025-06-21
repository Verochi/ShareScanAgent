package com.google.android.gms.dynamic;

@com.google.android.gms.common.util.RetainForClient
@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class ObjectWrapper<T> extends com.google.android.gms.dynamic.IObjectWrapper.Stub {
    private final T zza;

    private ObjectWrapper(T t) {
        this.zza = t;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T> T unwrap(@androidx.annotation.RecentlyNonNull com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof com.google.android.gms.dynamic.ObjectWrapper) {
            return ((com.google.android.gms.dynamic.ObjectWrapper) iObjectWrapper).zza;
        }
        android.os.IBinder asBinder = iObjectWrapper.asBinder();
        java.lang.reflect.Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        java.lang.reflect.Field field = null;
        int i = 0;
        for (java.lang.reflect.Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            int length = declaredFields.length;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new java.lang.IllegalArgumentException(sb.toString());
        }
        if (((java.lang.reflect.Field) com.google.android.gms.common.internal.Preconditions.checkNotNull(field)).isAccessible()) {
            throw new java.lang.IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(asBinder);
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (java.lang.NullPointerException e2) {
            throw new java.lang.IllegalArgumentException("Binder object is null.", e2);
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T> com.google.android.gms.dynamic.IObjectWrapper wrap(@androidx.annotation.RecentlyNonNull T t) {
        return new com.google.android.gms.dynamic.ObjectWrapper(t);
    }
}
