package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class Objects {

    @com.google.android.gms.common.annotation.KeepForSdk
    public static final class ToStringHelper {
        public final java.util.List<java.lang.String> a;
        public final java.lang.Object b;

        public ToStringHelper(java.lang.Object obj) {
            this.b = com.google.android.gms.common.internal.Preconditions.checkNotNull(obj);
            this.a = new java.util.ArrayList();
        }

        public /* synthetic */ ToStringHelper(java.lang.Object obj, com.google.android.gms.common.internal.zzu zzuVar) {
            this(obj);
        }

        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        public final com.google.android.gms.common.internal.Objects.ToStringHelper add(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object obj) {
            java.util.List<java.lang.String> list = this.a;
            java.lang.String str2 = (java.lang.String) com.google.android.gms.common.internal.Preconditions.checkNotNull(str);
            java.lang.String valueOf = java.lang.String.valueOf(obj);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str2).length() + 1 + valueOf.length());
            sb.append(str2);
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        public final java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(100);
            sb.append(this.b.getClass().getSimpleName());
            sb.append('{');
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.a.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public Objects() {
        throw new java.lang.AssertionError("Uninstantiable");
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean checkBundlesEquality(@androidx.annotation.RecentlyNonNull android.os.Bundle bundle, @androidx.annotation.RecentlyNonNull android.os.Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return bundle == bundle2;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        java.util.Set<java.lang.String> keySet = bundle.keySet();
        if (!keySet.containsAll(bundle2.keySet())) {
            return false;
        }
        for (java.lang.String str : keySet) {
            if (!equal(bundle.get(str), bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean equal(@androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static int hashCode(@androidx.annotation.RecentlyNonNull java.lang.Object... objArr) {
        return java.util.Arrays.hashCode(objArr);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.internal.Objects.ToStringHelper toStringHelper(@androidx.annotation.RecentlyNonNull java.lang.Object obj) {
        return new com.google.android.gms.common.internal.Objects.ToStringHelper(obj, null);
    }
}
