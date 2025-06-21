package androidx.sqlite.db;

/* loaded from: classes.dex */
public interface SupportSQLiteQuery {
    void bindTo(androidx.sqlite.db.SupportSQLiteProgram supportSQLiteProgram);

    int getArgCount();

    java.lang.String getSql();
}
