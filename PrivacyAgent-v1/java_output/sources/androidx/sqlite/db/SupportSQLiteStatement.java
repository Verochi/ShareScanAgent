package androidx.sqlite.db;

/* loaded from: classes.dex */
public interface SupportSQLiteStatement extends androidx.sqlite.db.SupportSQLiteProgram {
    void execute();

    long executeInsert();

    int executeUpdateDelete();

    long simpleQueryForLong();

    java.lang.String simpleQueryForString();
}
