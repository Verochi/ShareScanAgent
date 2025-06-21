package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class br3 {
    public static /* synthetic */ java.lang.String a(java.lang.CharSequence charSequence, java.lang.Iterable iterable) {
        if (charSequence == null) {
            throw new java.lang.NullPointerException(com.alibaba.sdk.android.oss.common.RequestParameters.DELIMITER);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator it = iterable.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((java.lang.CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append(charSequence);
            }
        }
        return sb.toString();
    }
}
