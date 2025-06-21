package androidx.core.content;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"contentValuesOf", "Landroid/content/ContentValues;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class ContentValuesKt {
    @org.jetbrains.annotations.NotNull
    public static final android.content.ContentValues contentValuesOf(@org.jetbrains.annotations.NotNull kotlin.Pair<java.lang.String, ? extends java.lang.Object>... pairs) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        android.content.ContentValues contentValues = new android.content.ContentValues(pairs.length);
        for (kotlin.Pair<java.lang.String, ? extends java.lang.Object> pair : pairs) {
            java.lang.String component1 = pair.component1();
            java.lang.Object component2 = pair.component2();
            if (component2 == null) {
                contentValues.putNull(component1);
            } else if (component2 instanceof java.lang.String) {
                contentValues.put(component1, (java.lang.String) component2);
            } else if (component2 instanceof java.lang.Integer) {
                contentValues.put(component1, (java.lang.Integer) component2);
            } else if (component2 instanceof java.lang.Long) {
                contentValues.put(component1, (java.lang.Long) component2);
            } else if (component2 instanceof java.lang.Boolean) {
                contentValues.put(component1, (java.lang.Boolean) component2);
            } else if (component2 instanceof java.lang.Float) {
                contentValues.put(component1, (java.lang.Float) component2);
            } else if (component2 instanceof java.lang.Double) {
                contentValues.put(component1, (java.lang.Double) component2);
            } else if (component2 instanceof byte[]) {
                contentValues.put(component1, (byte[]) component2);
            } else if (component2 instanceof java.lang.Byte) {
                contentValues.put(component1, (java.lang.Byte) component2);
            } else {
                if (!(component2 instanceof java.lang.Short)) {
                    throw new java.lang.IllegalArgumentException("Illegal value type " + component2.getClass().getCanonicalName() + " for key \"" + component1 + kotlin.text.Typography.quote);
                }
                contentValues.put(component1, (java.lang.Short) component2);
            }
        }
        return contentValues;
    }
}
