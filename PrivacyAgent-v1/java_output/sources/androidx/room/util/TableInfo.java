package androidx.room.util;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public final java.util.Map<java.lang.String, androidx.room.util.TableInfo.Column> columns;
    public final java.util.Set<androidx.room.util.TableInfo.ForeignKey> foreignKeys;

    @androidx.annotation.Nullable
    public final java.util.Set<androidx.room.util.TableInfo.Index> indices;
    public final java.lang.String name;

    public static final class Column {

        @androidx.room.ColumnInfo.SQLiteTypeAffinity
        public final int affinity;
        public final java.lang.String defaultValue;
        private final int mCreatedFrom;
        public final java.lang.String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final java.lang.String type;

        @java.lang.Deprecated
        public Column(java.lang.String str, java.lang.String str2, boolean z, int i) {
            this(str, str2, z, i, null, 0);
        }

        public Column(java.lang.String str, java.lang.String str2, boolean z, int i, java.lang.String str3, int i2) {
            this.name = str;
            this.type = str2;
            this.notNull = z;
            this.primaryKeyPosition = i;
            this.affinity = findAffinity(str2);
            this.defaultValue = str3;
            this.mCreatedFrom = i2;
        }

        private static boolean containsSurroundingParenthesis(@androidx.annotation.NonNull java.lang.String str) {
            if (str.length() == 0) {
                return false;
            }
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (i2 == 0 && charAt != '(') {
                    return false;
                }
                if (charAt == '(') {
                    i++;
                } else if (charAt == ')' && i - 1 == 0 && i2 != str.length() - 1) {
                    return false;
                }
            }
            return i == 0;
        }

        public static boolean defaultValueEquals(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
            if (str2 == null) {
                return false;
            }
            if (str.equals(str2)) {
                return true;
            }
            if (containsSurroundingParenthesis(str)) {
                return str.substring(1, str.length() - 1).trim().equals(str2);
            }
            return false;
        }

        @androidx.room.ColumnInfo.SQLiteTypeAffinity
        private static int findAffinity(@androidx.annotation.Nullable java.lang.String str) {
            if (str == null) {
                return 5;
            }
            java.lang.String upperCase = str.toUpperCase(java.util.Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean equals(java.lang.Object obj) {
            java.lang.String str;
            java.lang.String str2;
            java.lang.String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof androidx.room.util.TableInfo.Column)) {
                return false;
            }
            androidx.room.util.TableInfo.Column column = (androidx.room.util.TableInfo.Column) obj;
            if (this.primaryKeyPosition != column.primaryKeyPosition || !this.name.equals(column.name) || this.notNull != column.notNull) {
                return false;
            }
            if (this.mCreatedFrom == 1 && column.mCreatedFrom == 2 && (str3 = this.defaultValue) != null && !defaultValueEquals(str3, column.defaultValue)) {
                return false;
            }
            if (this.mCreatedFrom == 2 && column.mCreatedFrom == 1 && (str2 = column.defaultValue) != null && !defaultValueEquals(str2, this.defaultValue)) {
                return false;
            }
            int i = this.mCreatedFrom;
            return (i == 0 || i != column.mCreatedFrom || ((str = this.defaultValue) == null ? column.defaultValue == null : defaultValueEquals(str, column.defaultValue))) && this.affinity == column.affinity;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
        }

        public boolean isPrimaryKey() {
            return this.primaryKeyPosition > 0;
        }

        public java.lang.String toString() {
            return "Column{name='" + this.name + "', type='" + this.type + "', affinity='" + this.affinity + "', notNull=" + this.notNull + ", primaryKeyPosition=" + this.primaryKeyPosition + ", defaultValue='" + this.defaultValue + "'}";
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class ForeignKey {

        @androidx.annotation.NonNull
        public final java.util.List<java.lang.String> columnNames;

        @androidx.annotation.NonNull
        public final java.lang.String onDelete;

        @androidx.annotation.NonNull
        public final java.lang.String onUpdate;

        @androidx.annotation.NonNull
        public final java.util.List<java.lang.String> referenceColumnNames;

        @androidx.annotation.NonNull
        public final java.lang.String referenceTable;

        public ForeignKey(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, @androidx.annotation.NonNull java.lang.String str3, @androidx.annotation.NonNull java.util.List<java.lang.String> list, @androidx.annotation.NonNull java.util.List<java.lang.String> list2) {
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = java.util.Collections.unmodifiableList(list);
            this.referenceColumnNames = java.util.Collections.unmodifiableList(list2);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof androidx.room.util.TableInfo.ForeignKey)) {
                return false;
            }
            androidx.room.util.TableInfo.ForeignKey foreignKey = (androidx.room.util.TableInfo.ForeignKey) obj;
            if (this.referenceTable.equals(foreignKey.referenceTable) && this.onDelete.equals(foreignKey.onDelete) && this.onUpdate.equals(foreignKey.onUpdate) && this.columnNames.equals(foreignKey.columnNames)) {
                return this.referenceColumnNames.equals(foreignKey.referenceColumnNames);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode();
        }

        public java.lang.String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + "', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ForeignKeyWithSequence implements java.lang.Comparable<androidx.room.util.TableInfo.ForeignKeyWithSequence> {
        final java.lang.String mFrom;
        final int mId;
        final int mSequence;
        final java.lang.String mTo;

        public ForeignKeyWithSequence(int i, int i2, java.lang.String str, java.lang.String str2) {
            this.mId = i;
            this.mSequence = i2;
            this.mFrom = str;
            this.mTo = str2;
        }

        @Override // java.lang.Comparable
        public int compareTo(@androidx.annotation.NonNull androidx.room.util.TableInfo.ForeignKeyWithSequence foreignKeyWithSequence) {
            int i = this.mId - foreignKeyWithSequence.mId;
            return i == 0 ? this.mSequence - foreignKeyWithSequence.mSequence : i;
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Index {
        public static final java.lang.String DEFAULT_PREFIX = "index_";
        public final java.util.List<java.lang.String> columns;
        public final java.lang.String name;
        public final boolean unique;

        public Index(java.lang.String str, boolean z, java.util.List<java.lang.String> list) {
            this.name = str;
            this.unique = z;
            this.columns = list;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof androidx.room.util.TableInfo.Index)) {
                return false;
            }
            androidx.room.util.TableInfo.Index index = (androidx.room.util.TableInfo.Index) obj;
            if (this.unique == index.unique && this.columns.equals(index.columns)) {
                return this.name.startsWith(DEFAULT_PREFIX) ? index.name.startsWith(DEFAULT_PREFIX) : this.name.equals(index.name);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.name.startsWith(DEFAULT_PREFIX) ? -1184239155 : this.name.hashCode()) * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode();
        }

        public java.lang.String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + '}';
        }
    }

    public TableInfo(java.lang.String str, java.util.Map<java.lang.String, androidx.room.util.TableInfo.Column> map, java.util.Set<androidx.room.util.TableInfo.ForeignKey> set) {
        this(str, map, set, java.util.Collections.emptySet());
    }

    public TableInfo(java.lang.String str, java.util.Map<java.lang.String, androidx.room.util.TableInfo.Column> map, java.util.Set<androidx.room.util.TableInfo.ForeignKey> set, java.util.Set<androidx.room.util.TableInfo.Index> set2) {
        this.name = str;
        this.columns = java.util.Collections.unmodifiableMap(map);
        this.foreignKeys = java.util.Collections.unmodifiableSet(set);
        this.indices = set2 == null ? null : java.util.Collections.unmodifiableSet(set2);
    }

    public static androidx.room.util.TableInfo read(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, java.lang.String str) {
        return new androidx.room.util.TableInfo(str, readColumns(supportSQLiteDatabase, str), readForeignKeys(supportSQLiteDatabase, str), readIndices(supportSQLiteDatabase, str));
    }

    private static java.util.Map<java.lang.String, androidx.room.util.TableInfo.Column> readColumns(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, java.lang.String str) {
        android.database.Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        java.util.HashMap hashMap = new java.util.HashMap();
        try {
            if (query.getColumnCount() > 0) {
                int columnIndex = query.getColumnIndex("name");
                int columnIndex2 = query.getColumnIndex("type");
                int columnIndex3 = query.getColumnIndex("notnull");
                int columnIndex4 = query.getColumnIndex("pk");
                int columnIndex5 = query.getColumnIndex("dflt_value");
                while (query.moveToNext()) {
                    java.lang.String string = query.getString(columnIndex);
                    hashMap.put(string, new androidx.room.util.TableInfo.Column(string, query.getString(columnIndex2), query.getInt(columnIndex3) != 0, query.getInt(columnIndex4), query.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            query.close();
        }
    }

    private static java.util.List<androidx.room.util.TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings(android.database.Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex(com.huawei.hms.push.constant.RemoteMessageConst.TO);
        int count = cursor.getCount();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new androidx.room.util.TableInfo.ForeignKeyWithSequence(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        java.util.Collections.sort(arrayList);
        return arrayList;
    }

    private static java.util.Set<androidx.room.util.TableInfo.ForeignKey> readForeignKeys(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, java.lang.String str) {
        java.util.HashSet hashSet = new java.util.HashSet();
        android.database.Cursor query = supportSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("id");
            int columnIndex2 = query.getColumnIndex("seq");
            int columnIndex3 = query.getColumnIndex("table");
            int columnIndex4 = query.getColumnIndex("on_delete");
            int columnIndex5 = query.getColumnIndex("on_update");
            java.util.List<androidx.room.util.TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings = readForeignKeyFieldMappings(query);
            int count = query.getCount();
            for (int i = 0; i < count; i++) {
                query.moveToPosition(i);
                if (query.getInt(columnIndex2) == 0) {
                    int i2 = query.getInt(columnIndex);
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                    for (androidx.room.util.TableInfo.ForeignKeyWithSequence foreignKeyWithSequence : readForeignKeyFieldMappings) {
                        if (foreignKeyWithSequence.mId == i2) {
                            arrayList.add(foreignKeyWithSequence.mFrom);
                            arrayList2.add(foreignKeyWithSequence.mTo);
                        }
                    }
                    hashSet.add(new androidx.room.util.TableInfo.ForeignKey(query.getString(columnIndex3), query.getString(columnIndex4), query.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            query.close();
        }
    }

    @androidx.annotation.Nullable
    private static androidx.room.util.TableInfo.Index readIndex(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, java.lang.String str, boolean z) {
        android.database.Cursor query = supportSQLiteDatabase.query("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("seqno");
            int columnIndex2 = query.getColumnIndex("cid");
            int columnIndex3 = query.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                java.util.TreeMap treeMap = new java.util.TreeMap();
                while (query.moveToNext()) {
                    if (query.getInt(columnIndex2) >= 0) {
                        treeMap.put(java.lang.Integer.valueOf(query.getInt(columnIndex)), query.getString(columnIndex3));
                    }
                }
                java.util.ArrayList arrayList = new java.util.ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new androidx.room.util.TableInfo.Index(str, z, arrayList);
            }
            query.close();
            return null;
        } finally {
            query.close();
        }
    }

    @androidx.annotation.Nullable
    private static java.util.Set<androidx.room.util.TableInfo.Index> readIndices(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, java.lang.String str) {
        android.database.Cursor query = supportSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("name");
            int columnIndex2 = query.getColumnIndex("origin");
            int columnIndex3 = query.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                java.util.HashSet hashSet = new java.util.HashSet();
                while (query.moveToNext()) {
                    if ("c".equals(query.getString(columnIndex2))) {
                        java.lang.String string = query.getString(columnIndex);
                        boolean z = true;
                        if (query.getInt(columnIndex3) != 1) {
                            z = false;
                        }
                        androidx.room.util.TableInfo.Index readIndex = readIndex(supportSQLiteDatabase, string, z);
                        if (readIndex == null) {
                            return null;
                        }
                        hashSet.add(readIndex);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            query.close();
        }
    }

    public boolean equals(java.lang.Object obj) {
        java.util.Set<androidx.room.util.TableInfo.Index> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof androidx.room.util.TableInfo)) {
            return false;
        }
        androidx.room.util.TableInfo tableInfo = (androidx.room.util.TableInfo) obj;
        java.lang.String str = this.name;
        if (str == null ? tableInfo.name != null : !str.equals(tableInfo.name)) {
            return false;
        }
        java.util.Map<java.lang.String, androidx.room.util.TableInfo.Column> map = this.columns;
        if (map == null ? tableInfo.columns != null : !map.equals(tableInfo.columns)) {
            return false;
        }
        java.util.Set<androidx.room.util.TableInfo.ForeignKey> set2 = this.foreignKeys;
        if (set2 == null ? tableInfo.foreignKeys != null : !set2.equals(tableInfo.foreignKeys)) {
            return false;
        }
        java.util.Set<androidx.room.util.TableInfo.Index> set3 = this.indices;
        if (set3 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        java.lang.String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        java.util.Map<java.lang.String, androidx.room.util.TableInfo.Column> map = this.columns;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        java.util.Set<androidx.room.util.TableInfo.ForeignKey> set = this.foreignKeys;
        return hashCode2 + (set != null ? set.hashCode() : 0);
    }

    public java.lang.String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }
}
