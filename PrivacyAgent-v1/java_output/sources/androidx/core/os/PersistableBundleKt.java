package androidx.core.os;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"persistableBundleOf", "Landroid/os/PersistableBundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/PersistableBundle;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class PersistableBundleKt {
    @androidx.annotation.RequiresApi(21)
    @org.jetbrains.annotations.NotNull
    public static final android.os.PersistableBundle persistableBundleOf(@org.jetbrains.annotations.NotNull kotlin.Pair<java.lang.String, ? extends java.lang.Object>... pairs) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        android.os.PersistableBundle persistableBundle = new android.os.PersistableBundle(pairs.length);
        for (kotlin.Pair<java.lang.String, ? extends java.lang.Object> pair : pairs) {
            java.lang.String component1 = pair.component1();
            java.lang.Object component2 = pair.component2();
            if (component2 == null) {
                persistableBundle.putString(component1, null);
            } else if (component2 instanceof java.lang.Boolean) {
                if (android.os.Build.VERSION.SDK_INT < 22) {
                    throw new java.lang.IllegalArgumentException("Illegal value type boolean for key \"" + component1 + kotlin.text.Typography.quote);
                }
                persistableBundle.putBoolean(component1, ((java.lang.Boolean) component2).booleanValue());
            } else if (component2 instanceof java.lang.Double) {
                persistableBundle.putDouble(component1, ((java.lang.Number) component2).doubleValue());
            } else if (component2 instanceof java.lang.Integer) {
                persistableBundle.putInt(component1, ((java.lang.Number) component2).intValue());
            } else if (component2 instanceof java.lang.Long) {
                persistableBundle.putLong(component1, ((java.lang.Number) component2).longValue());
            } else if (component2 instanceof java.lang.String) {
                persistableBundle.putString(component1, (java.lang.String) component2);
            } else if (component2 instanceof boolean[]) {
                if (android.os.Build.VERSION.SDK_INT < 22) {
                    throw new java.lang.IllegalArgumentException("Illegal value type boolean[] for key \"" + component1 + kotlin.text.Typography.quote);
                }
                persistableBundle.putBooleanArray(component1, (boolean[]) component2);
            } else if (component2 instanceof double[]) {
                persistableBundle.putDoubleArray(component1, (double[]) component2);
            } else if (component2 instanceof int[]) {
                persistableBundle.putIntArray(component1, (int[]) component2);
            } else if (component2 instanceof long[]) {
                persistableBundle.putLongArray(component1, (long[]) component2);
            } else {
                if (!(component2 instanceof java.lang.Object[])) {
                    throw new java.lang.IllegalArgumentException("Illegal value type " + component2.getClass().getCanonicalName() + " for key \"" + component1 + kotlin.text.Typography.quote);
                }
                java.lang.Class<?> componentType = component2.getClass().getComponentType();
                if (componentType == null) {
                    kotlin.jvm.internal.Intrinsics.throwNpe();
                }
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(componentType, "value::class.java.componentType!!");
                if (!java.lang.String.class.isAssignableFrom(componentType)) {
                    throw new java.lang.IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + component1 + kotlin.text.Typography.quote);
                }
                persistableBundle.putStringArray(component1, (java.lang.String[]) component2);
            }
        }
        return persistableBundle;
    }
}
