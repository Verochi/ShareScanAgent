package androidx.core.content;

/* loaded from: classes.dex */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    @androidx.annotation.Nullable
    public static java.lang.String matches(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull java.lang.String[] strArr) {
        if (str == null) {
            return null;
        }
        java.lang.String[] split = str.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        for (java.lang.String str2 : strArr) {
            if (mimeTypeAgainstFilter(split, str2.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR))) {
                return str2;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static java.lang.String matches(@androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.NonNull java.lang.String str) {
        if (strArr == null) {
            return null;
        }
        java.lang.String[] split = str.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        for (java.lang.String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR), split)) {
                return str2;
            }
        }
        return null;
    }

    public static boolean matches(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        if (str == null) {
            return false;
        }
        return mimeTypeAgainstFilter(str.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR), str2.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR));
    }

    @androidx.annotation.NonNull
    public static java.lang.String[] matchesMany(@androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.NonNull java.lang.String str) {
        if (strArr == null) {
            return new java.lang.String[0];
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String[] split = str.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        for (java.lang.String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR), split)) {
                arrayList.add(str2);
            }
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    private static boolean mimeTypeAgainstFilter(@androidx.annotation.NonNull java.lang.String[] strArr, @androidx.annotation.NonNull java.lang.String[] strArr2) {
        if (strArr2.length != 2) {
            throw new java.lang.IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        }
        if (strArr2[0].isEmpty() || strArr2[1].isEmpty()) {
            throw new java.lang.IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        }
        if (strArr.length != 2) {
            return false;
        }
        if ("*".equals(strArr2[0]) || strArr2[0].equals(strArr[0])) {
            return "*".equals(strArr2[1]) || strArr2[1].equals(strArr[1]);
        }
        return false;
    }
}
