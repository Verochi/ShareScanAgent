package androidx.room;

/* loaded from: classes.dex */
interface DelegatingOpenHelper {
    @androidx.annotation.NonNull
    androidx.sqlite.db.SupportSQLiteOpenHelper getDelegate();
}
