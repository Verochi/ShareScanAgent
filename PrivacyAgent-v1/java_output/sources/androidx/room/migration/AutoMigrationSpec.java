package androidx.room.migration;

/* loaded from: classes.dex */
public interface AutoMigrationSpec {
    void onPostMigrate(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase);
}
