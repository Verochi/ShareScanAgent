package androidx.lifecycle;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MethodCallsLogger {
    private java.util.Map<java.lang.String, java.lang.Integer> mCalledMethods = new java.util.HashMap();

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(java.lang.String str, int i) {
        java.lang.Integer num = this.mCalledMethods.get(str);
        int intValue = num != null ? num.intValue() : 0;
        boolean z = (intValue & i) != 0;
        this.mCalledMethods.put(str, java.lang.Integer.valueOf(i | intValue));
        return !z;
    }
}
