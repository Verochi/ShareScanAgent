package androidx.core.util;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DebugUtils {
    private DebugUtils() {
    }

    public static void buildShortClassTag(java.lang.Object obj, java.lang.StringBuilder sb) {
        int lastIndexOf;
        if (obj == null) {
            sb.append(com.igexin.push.core.b.m);
            return;
        }
        java.lang.String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(obj)));
    }
}
