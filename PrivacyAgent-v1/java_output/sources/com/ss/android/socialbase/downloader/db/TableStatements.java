package com.ss.android.socialbase.downloader.db;

/* loaded from: classes19.dex */
public class TableStatements {
    private final java.lang.String[] allColumns;
    private final android.database.sqlite.SQLiteDatabase database;
    private android.database.sqlite.SQLiteStatement deleteStatement;
    private android.database.sqlite.SQLiteStatement insertOrReplaceStatement;
    private android.database.sqlite.SQLiteStatement insertStatement;
    private final java.lang.String[] pkColumns;
    private final java.lang.String tableName;
    private android.database.sqlite.SQLiteStatement updateStatement;

    public TableStatements(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2) {
        this.database = sQLiteDatabase;
        this.tableName = str;
        this.allColumns = strArr;
        this.pkColumns = strArr2;
    }

    public android.database.sqlite.SQLiteStatement getDeleteStatement() {
        if (this.deleteStatement == null) {
            android.database.sqlite.SQLiteStatement compileStatement = this.database.compileStatement(com.ss.android.socialbase.downloader.utils.SqlUtils.createSqlDelete(this.tableName, this.pkColumns));
            synchronized (this) {
                if (this.deleteStatement == null) {
                    this.deleteStatement = compileStatement;
                }
            }
            if (this.deleteStatement != compileStatement) {
                compileStatement.close();
            }
        }
        return this.deleteStatement;
    }

    public android.database.sqlite.SQLiteStatement getInsertOrReplaceStatement() {
        if (this.insertOrReplaceStatement == null) {
            android.database.sqlite.SQLiteStatement compileStatement = this.database.compileStatement(com.ss.android.socialbase.downloader.utils.SqlUtils.createSqlInsertOrReplace(this.tableName, this.allColumns, this.pkColumns));
            synchronized (this) {
                if (this.insertOrReplaceStatement == null) {
                    this.insertOrReplaceStatement = compileStatement;
                }
            }
            if (this.insertOrReplaceStatement != compileStatement) {
                compileStatement.close();
            }
        }
        return this.insertOrReplaceStatement;
    }

    public android.database.sqlite.SQLiteStatement getInsertStatement() {
        if (this.insertStatement == null) {
            android.database.sqlite.SQLiteStatement compileStatement = this.database.compileStatement(com.ss.android.socialbase.downloader.utils.SqlUtils.createSqlInsert("INSERT INTO ", this.tableName, this.allColumns));
            synchronized (this) {
                if (this.insertStatement == null) {
                    this.insertStatement = compileStatement;
                }
            }
            if (this.insertStatement != compileStatement) {
                compileStatement.close();
            }
        }
        return this.insertStatement;
    }

    public android.database.sqlite.SQLiteStatement getUpdateStatement() {
        if (this.updateStatement == null) {
            android.database.sqlite.SQLiteStatement compileStatement = this.database.compileStatement(com.ss.android.socialbase.downloader.utils.SqlUtils.createSqlUpdate(this.tableName, this.allColumns, this.pkColumns));
            synchronized (this) {
                if (this.updateStatement == null) {
                    this.updateStatement = compileStatement;
                }
            }
            if (this.updateStatement != compileStatement) {
                compileStatement.close();
            }
        }
        return this.updateStatement;
    }
}
