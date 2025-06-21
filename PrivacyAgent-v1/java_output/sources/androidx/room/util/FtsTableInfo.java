package androidx.room.util;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class FtsTableInfo {
    private static final java.lang.String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    public final java.util.Set<java.lang.String> columns;
    public final java.lang.String name;
    public final java.util.Set<java.lang.String> options;

    public FtsTableInfo(java.lang.String str, java.util.Set<java.lang.String> set, java.lang.String str2) {
        this.name = str;
        this.columns = set;
        this.options = parseOptions(str2);
    }

    public FtsTableInfo(java.lang.String str, java.util.Set<java.lang.String> set, java.util.Set<java.lang.String> set2) {
        this.name = str;
        this.columns = set;
        this.options = set2;
    }

    @androidx.annotation.VisibleForTesting
    public static java.util.Set<java.lang.String> parseOptions(java.lang.String str) {
        if (str.isEmpty()) {
            return new java.util.HashSet();
        }
        java.lang.String substring = str.substring(str.indexOf(40) + 1, str.lastIndexOf(41));
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList();
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        int i = -1;
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt != '\"' && charAt != '\'') {
                if (charAt != ',') {
                    if (charAt != '[') {
                        if (charAt != ']') {
                            if (charAt != '`') {
                            }
                        } else if (!arrayDeque.isEmpty() && ((java.lang.Character) arrayDeque.peek()).charValue() == '[') {
                            arrayDeque.pop();
                        }
                    } else if (arrayDeque.isEmpty()) {
                        arrayDeque.push(java.lang.Character.valueOf(charAt));
                    }
                } else if (arrayDeque.isEmpty()) {
                    arrayList.add(substring.substring(i + 1, i2).trim());
                    i = i2;
                }
            }
            if (arrayDeque.isEmpty()) {
                arrayDeque.push(java.lang.Character.valueOf(charAt));
            } else if (((java.lang.Character) arrayDeque.peek()).charValue() == charAt) {
                arrayDeque.pop();
            }
        }
        arrayList.add(substring.substring(i + 1).trim());
        java.util.HashSet hashSet = new java.util.HashSet();
        for (java.lang.String str2 : arrayList) {
            for (java.lang.String str3 : FTS_OPTIONS) {
                if (str2.startsWith(str3)) {
                    hashSet.add(str2);
                }
            }
        }
        return hashSet;
    }

    public static androidx.room.util.FtsTableInfo read(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, java.lang.String str) {
        return new androidx.room.util.FtsTableInfo(str, readColumns(supportSQLiteDatabase, str), readOptions(supportSQLiteDatabase, str));
    }

    private static java.util.Set<java.lang.String> readColumns(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, java.lang.String str) {
        android.database.Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        java.util.HashSet hashSet = new java.util.HashSet();
        try {
            if (query.getColumnCount() > 0) {
                int columnIndex = query.getColumnIndex("name");
                while (query.moveToNext()) {
                    hashSet.add(query.getString(columnIndex));
                }
            }
            return hashSet;
        } finally {
            query.close();
        }
    }

    private static java.util.Set<java.lang.String> readOptions(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, java.lang.String str) {
        android.database.Cursor query = supportSQLiteDatabase.query("SELECT * FROM sqlite_master WHERE `name` = '" + str + "'");
        try {
            java.lang.String string = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("sql")) : "";
            query.close();
            return parseOptions(string);
        } catch (java.lang.Throwable th) {
            query.close();
            throw th;
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof androidx.room.util.FtsTableInfo)) {
            return false;
        }
        androidx.room.util.FtsTableInfo ftsTableInfo = (androidx.room.util.FtsTableInfo) obj;
        java.lang.String str = this.name;
        if (str == null ? ftsTableInfo.name != null : !str.equals(ftsTableInfo.name)) {
            return false;
        }
        java.util.Set<java.lang.String> set = this.columns;
        if (set == null ? ftsTableInfo.columns != null : !set.equals(ftsTableInfo.columns)) {
            return false;
        }
        java.util.Set<java.lang.String> set2 = this.options;
        java.util.Set<java.lang.String> set3 = ftsTableInfo.options;
        return set2 != null ? set2.equals(set3) : set3 == null;
    }

    public int hashCode() {
        java.lang.String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        java.util.Set<java.lang.String> set = this.columns;
        int hashCode2 = (hashCode + (set != null ? set.hashCode() : 0)) * 31;
        java.util.Set<java.lang.String> set2 = this.options;
        return hashCode2 + (set2 != null ? set2.hashCode() : 0);
    }

    public java.lang.String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + '}';
    }
}
