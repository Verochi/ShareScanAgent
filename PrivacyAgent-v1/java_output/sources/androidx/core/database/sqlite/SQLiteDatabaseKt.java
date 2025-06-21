package androidx.core.database.sqlite;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"transaction", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Landroid/database/sqlite/SQLiteDatabase;", "exclusive", "", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/database/sqlite/SQLiteDatabase;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(@org.jetbrains.annotations.NotNull android.database.sqlite.SQLiteDatabase transaction, boolean z, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.database.sqlite.SQLiteDatabase, ? extends T> body) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(transaction, "$this$transaction");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(body, "body");
        if (z) {
            transaction.beginTransaction();
        } else {
            transaction.beginTransactionNonExclusive();
        }
        try {
            T invoke = body.invoke(transaction);
            transaction.setTransactionSuccessful();
            return invoke;
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            transaction.endTransaction();
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ java.lang.Object transaction$default(android.database.sqlite.SQLiteDatabase transaction, boolean z, kotlin.jvm.functions.Function1 body, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(transaction, "$this$transaction");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(body, "body");
        if (z) {
            transaction.beginTransaction();
        } else {
            transaction.beginTransactionNonExclusive();
        }
        try {
            java.lang.Object invoke = body.invoke(transaction);
            transaction.setTransactionSuccessful();
            return invoke;
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            transaction.endTransaction();
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }
}
