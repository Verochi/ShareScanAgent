package androidx.core.database;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\n\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u000f\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0015"}, d2 = {"getBlobOrNull", "", "Landroid/database/Cursor;", "index", "", "getDoubleOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Double;", "getFloatOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Float;", "getIntOrNull", "(Landroid/database/Cursor;I)Ljava/lang/Integer;", "getLongOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Long;", "getShortOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Short;", "getStringOrNull", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class CursorKt {
    @org.jetbrains.annotations.Nullable
    public static final byte[] getBlobOrNull(@org.jetbrains.annotations.NotNull android.database.Cursor getBlobOrNull, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getBlobOrNull, "$this$getBlobOrNull");
        if (getBlobOrNull.isNull(i)) {
            return null;
        }
        return getBlobOrNull.getBlob(i);
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Double getDoubleOrNull(@org.jetbrains.annotations.NotNull android.database.Cursor getDoubleOrNull, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getDoubleOrNull, "$this$getDoubleOrNull");
        if (getDoubleOrNull.isNull(i)) {
            return null;
        }
        return java.lang.Double.valueOf(getDoubleOrNull.getDouble(i));
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Float getFloatOrNull(@org.jetbrains.annotations.NotNull android.database.Cursor getFloatOrNull, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getFloatOrNull, "$this$getFloatOrNull");
        if (getFloatOrNull.isNull(i)) {
            return null;
        }
        return java.lang.Float.valueOf(getFloatOrNull.getFloat(i));
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Integer getIntOrNull(@org.jetbrains.annotations.NotNull android.database.Cursor getIntOrNull, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getIntOrNull, "$this$getIntOrNull");
        if (getIntOrNull.isNull(i)) {
            return null;
        }
        return java.lang.Integer.valueOf(getIntOrNull.getInt(i));
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Long getLongOrNull(@org.jetbrains.annotations.NotNull android.database.Cursor getLongOrNull, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getLongOrNull, "$this$getLongOrNull");
        if (getLongOrNull.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(getLongOrNull.getLong(i));
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Short getShortOrNull(@org.jetbrains.annotations.NotNull android.database.Cursor getShortOrNull, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getShortOrNull, "$this$getShortOrNull");
        if (getShortOrNull.isNull(i)) {
            return null;
        }
        return java.lang.Short.valueOf(getShortOrNull.getShort(i));
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.String getStringOrNull(@org.jetbrains.annotations.NotNull android.database.Cursor getStringOrNull, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getStringOrNull, "$this$getStringOrNull");
        if (getStringOrNull.isNull(i)) {
            return null;
        }
        return getStringOrNull.getString(i);
    }
}
