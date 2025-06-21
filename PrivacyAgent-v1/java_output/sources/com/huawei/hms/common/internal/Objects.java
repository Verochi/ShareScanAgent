package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public final class Objects {

    public static final class ToStringHelper {
        public final java.util.List<java.lang.String> a;
        public final java.lang.Object b;

        public ToStringHelper(java.lang.Object obj) {
            this.b = com.huawei.hms.common.internal.Preconditions.checkNotNull(obj);
            this.a = new java.util.ArrayList();
        }

        public /* synthetic */ ToStringHelper(java.lang.Object obj, com.huawei.hms.common.internal.Objects.a aVar) {
            this(obj);
        }

        public final com.huawei.hms.common.internal.Objects.ToStringHelper add(java.lang.String str, java.lang.Object obj) {
            java.lang.String str2 = (java.lang.String) com.huawei.hms.common.internal.Preconditions.checkNotNull(str);
            java.lang.String valueOf = java.lang.String.valueOf(obj);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(str2.length() + valueOf.length() + 1);
            sb.append(str2);
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(valueOf);
            this.a.add(sb.toString());
            return this;
        }

        public final java.lang.String toString() {
            java.lang.String simpleName = this.b.getClass().getSimpleName();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(100);
            sb.append(simpleName);
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

    public static boolean equal(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == obj2) {
            return true;
        }
        return obj != null && obj.equals(obj2);
    }

    public static int hashCode(java.lang.Object... objArr) {
        return java.util.Arrays.hashCode(objArr);
    }

    public static com.huawei.hms.common.internal.Objects.ToStringHelper toStringHelper(java.lang.Object obj) {
        return new com.huawei.hms.common.internal.Objects.ToStringHelper(obj, null);
    }
}
