package androidx.room.util;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class StringUtil {
    public static final java.lang.String[] EMPTY_STRING_ARRAY = new java.lang.String[0];

    private StringUtil() {
    }

    public static void appendPlaceholders(java.lang.StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("?");
            if (i2 < i - 1) {
                sb.append(",");
            }
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.String joinIntoString(@androidx.annotation.Nullable java.util.List<java.lang.Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (size == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(java.lang.Integer.toString(list.get(i).intValue()));
            if (i < size - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static java.lang.StringBuilder newStringBuilder() {
        return new java.lang.StringBuilder();
    }

    @androidx.annotation.Nullable
    public static java.util.List<java.lang.Integer> splitToIntList(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreElements()) {
            try {
                arrayList.add(java.lang.Integer.valueOf(java.lang.Integer.parseInt(stringTokenizer.nextToken())));
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return arrayList;
    }
}
