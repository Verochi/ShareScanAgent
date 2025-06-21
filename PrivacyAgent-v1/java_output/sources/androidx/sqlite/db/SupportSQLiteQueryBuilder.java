package androidx.sqlite.db;

/* loaded from: classes.dex */
public final class SupportSQLiteQueryBuilder {
    private static final java.util.regex.Pattern sLimitPattern = java.util.regex.Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private java.lang.Object[] mBindArgs;
    private java.lang.String mSelection;
    private final java.lang.String mTable;
    private boolean mDistinct = false;
    private java.lang.String[] mColumns = null;
    private java.lang.String mGroupBy = null;
    private java.lang.String mHaving = null;
    private java.lang.String mOrderBy = null;
    private java.lang.String mLimit = null;

    private SupportSQLiteQueryBuilder(java.lang.String str) {
        this.mTable = str;
    }

    private static void appendClause(java.lang.StringBuilder sb, java.lang.String str, java.lang.String str2) {
        if (isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append(str2);
    }

    private static void appendColumns(java.lang.StringBuilder sb, java.lang.String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            java.lang.String str = strArr[i];
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(' ');
    }

    public static androidx.sqlite.db.SupportSQLiteQueryBuilder builder(java.lang.String str) {
        return new androidx.sqlite.db.SupportSQLiteQueryBuilder(str);
    }

    private static boolean isEmpty(java.lang.String str) {
        return str == null || str.length() == 0;
    }

    public androidx.sqlite.db.SupportSQLiteQueryBuilder columns(java.lang.String[] strArr) {
        this.mColumns = strArr;
        return this;
    }

    public androidx.sqlite.db.SupportSQLiteQuery create() {
        if (isEmpty(this.mGroupBy) && !isEmpty(this.mHaving)) {
            throw new java.lang.IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(120);
        sb.append("SELECT ");
        if (this.mDistinct) {
            sb.append("DISTINCT ");
        }
        java.lang.String[] strArr = this.mColumns;
        if (strArr == null || strArr.length == 0) {
            sb.append(" * ");
        } else {
            appendColumns(sb, strArr);
        }
        sb.append(" FROM ");
        sb.append(this.mTable);
        appendClause(sb, " WHERE ", this.mSelection);
        appendClause(sb, " GROUP BY ", this.mGroupBy);
        appendClause(sb, " HAVING ", this.mHaving);
        appendClause(sb, " ORDER BY ", this.mOrderBy);
        appendClause(sb, " LIMIT ", this.mLimit);
        return new androidx.sqlite.db.SimpleSQLiteQuery(sb.toString(), this.mBindArgs);
    }

    public androidx.sqlite.db.SupportSQLiteQueryBuilder distinct() {
        this.mDistinct = true;
        return this;
    }

    public androidx.sqlite.db.SupportSQLiteQueryBuilder groupBy(java.lang.String str) {
        this.mGroupBy = str;
        return this;
    }

    public androidx.sqlite.db.SupportSQLiteQueryBuilder having(java.lang.String str) {
        this.mHaving = str;
        return this;
    }

    public androidx.sqlite.db.SupportSQLiteQueryBuilder limit(java.lang.String str) {
        if (isEmpty(str) || sLimitPattern.matcher(str).matches()) {
            this.mLimit = str;
            return this;
        }
        throw new java.lang.IllegalArgumentException("invalid LIMIT clauses:" + str);
    }

    public androidx.sqlite.db.SupportSQLiteQueryBuilder orderBy(java.lang.String str) {
        this.mOrderBy = str;
        return this;
    }

    public androidx.sqlite.db.SupportSQLiteQueryBuilder selection(java.lang.String str, java.lang.Object[] objArr) {
        this.mSelection = str;
        this.mBindArgs = objArr;
        return this;
    }
}
