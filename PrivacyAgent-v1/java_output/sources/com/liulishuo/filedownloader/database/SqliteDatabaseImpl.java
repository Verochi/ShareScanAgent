package com.liulishuo.filedownloader.database;

/* loaded from: classes23.dex */
public class SqliteDatabaseImpl implements com.liulishuo.filedownloader.database.FileDownloadDatabase {
    public static final java.lang.String CONNECTION_TABLE_NAME = "filedownloaderConnection";
    public static final java.lang.String TABLE_NAME = "filedownloader";
    public final android.database.sqlite.SQLiteDatabase a = new com.liulishuo.filedownloader.database.SqliteDatabaseOpenHelper(com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext()).getWritableDatabase();

    public class Maintainer implements com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer {
        public final android.util.SparseArray<com.liulishuo.filedownloader.model.FileDownloadModel> n;
        public com.liulishuo.filedownloader.database.SqliteDatabaseImpl.MaintainerIterator t;
        public final android.util.SparseArray<com.liulishuo.filedownloader.model.FileDownloadModel> u;
        public final android.util.SparseArray<java.util.List<com.liulishuo.filedownloader.model.ConnectionModel>> v;

        public Maintainer(com.liulishuo.filedownloader.database.SqliteDatabaseImpl sqliteDatabaseImpl) {
            this(null, null);
        }

        public Maintainer(android.util.SparseArray<com.liulishuo.filedownloader.model.FileDownloadModel> sparseArray, android.util.SparseArray<java.util.List<com.liulishuo.filedownloader.model.ConnectionModel>> sparseArray2) {
            this.n = new android.util.SparseArray<>();
            this.u = sparseArray;
            this.v = sparseArray2;
        }

        @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer
        public void changeFileDownloadModelId(int i, com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
            this.n.put(i, fileDownloadModel);
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<com.liulishuo.filedownloader.model.FileDownloadModel> iterator() {
            com.liulishuo.filedownloader.database.SqliteDatabaseImpl.MaintainerIterator maintainerIterator = com.liulishuo.filedownloader.database.SqliteDatabaseImpl.this.new MaintainerIterator();
            this.t = maintainerIterator;
            return maintainerIterator;
        }

        @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer
        public void onFinishMaintain() {
            com.liulishuo.filedownloader.database.SqliteDatabaseImpl.MaintainerIterator maintainerIterator = this.t;
            if (maintainerIterator != null) {
                maintainerIterator.b();
            }
            int size = this.n.size();
            if (size < 0) {
                return;
            }
            com.liulishuo.filedownloader.database.SqliteDatabaseImpl.this.a.beginTransaction();
            for (int i = 0; i < size; i++) {
                try {
                    int keyAt = this.n.keyAt(i);
                    com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel = this.n.get(keyAt);
                    com.liulishuo.filedownloader.database.SqliteDatabaseImpl.this.a.delete(com.liulishuo.filedownloader.database.SqliteDatabaseImpl.TABLE_NAME, "_id = ?", new java.lang.String[]{java.lang.String.valueOf(keyAt)});
                    com.liulishuo.filedownloader.database.SqliteDatabaseImpl.this.a.insert(com.liulishuo.filedownloader.database.SqliteDatabaseImpl.TABLE_NAME, null, fileDownloadModel.toContentValues());
                    if (fileDownloadModel.getConnectionCount() > 1) {
                        java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> findConnectionModel = com.liulishuo.filedownloader.database.SqliteDatabaseImpl.this.findConnectionModel(keyAt);
                        if (findConnectionModel.size() > 0) {
                            com.liulishuo.filedownloader.database.SqliteDatabaseImpl.this.a.delete(com.liulishuo.filedownloader.database.SqliteDatabaseImpl.CONNECTION_TABLE_NAME, "id = ?", new java.lang.String[]{java.lang.String.valueOf(keyAt)});
                            for (com.liulishuo.filedownloader.model.ConnectionModel connectionModel : findConnectionModel) {
                                connectionModel.setId(fileDownloadModel.getId());
                                com.liulishuo.filedownloader.database.SqliteDatabaseImpl.this.a.insert(com.liulishuo.filedownloader.database.SqliteDatabaseImpl.CONNECTION_TABLE_NAME, null, connectionModel.toContentValues());
                            }
                        }
                    }
                } finally {
                    com.liulishuo.filedownloader.database.SqliteDatabaseImpl.this.a.endTransaction();
                }
            }
            android.util.SparseArray<com.liulishuo.filedownloader.model.FileDownloadModel> sparseArray = this.u;
            if (sparseArray != null && this.v != null) {
                int size2 = sparseArray.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    int id = this.u.valueAt(i2).getId();
                    java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> findConnectionModel2 = com.liulishuo.filedownloader.database.SqliteDatabaseImpl.this.findConnectionModel(id);
                    if (findConnectionModel2 != null && findConnectionModel2.size() > 0) {
                        this.v.put(id, findConnectionModel2);
                    }
                }
            }
            com.liulishuo.filedownloader.database.SqliteDatabaseImpl.this.a.setTransactionSuccessful();
        }

        @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer
        public void onRefreshedValidData(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
            android.util.SparseArray<com.liulishuo.filedownloader.model.FileDownloadModel> sparseArray = this.u;
            if (sparseArray != null) {
                sparseArray.put(fileDownloadModel.getId(), fileDownloadModel);
            }
        }

        @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer
        public void onRemovedInvalidData(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        }
    }

    public class MaintainerIterator implements java.util.Iterator<com.liulishuo.filedownloader.model.FileDownloadModel> {
        public final android.database.Cursor n;
        public final java.util.List<java.lang.Integer> t = new java.util.ArrayList();
        public int u;

        public MaintainerIterator() {
            this.n = com.liulishuo.filedownloader.database.SqliteDatabaseImpl.this.a.rawQuery("SELECT * FROM filedownloader", null);
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.liulishuo.filedownloader.model.FileDownloadModel next() {
            com.liulishuo.filedownloader.model.FileDownloadModel c = com.liulishuo.filedownloader.database.SqliteDatabaseImpl.c(this.n);
            this.u = c.getId();
            return c;
        }

        public void b() {
            this.n.close();
            if (this.t.isEmpty()) {
                return;
            }
            java.lang.String join = android.text.TextUtils.join(", ", this.t);
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "delete %s", join);
            }
            com.liulishuo.filedownloader.database.SqliteDatabaseImpl.this.a.execSQL(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("DELETE FROM %s WHERE %s IN (%s);", com.liulishuo.filedownloader.database.SqliteDatabaseImpl.TABLE_NAME, "_id", join));
            com.liulishuo.filedownloader.database.SqliteDatabaseImpl.this.a.execSQL(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("DELETE FROM %s WHERE %s IN (%s);", com.liulishuo.filedownloader.database.SqliteDatabaseImpl.CONNECTION_TABLE_NAME, "id", join));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.moveToNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.t.add(java.lang.Integer.valueOf(this.u));
        }
    }

    public static class Maker implements com.liulishuo.filedownloader.util.FileDownloadHelper.DatabaseCustomMaker {
        @Override // com.liulishuo.filedownloader.util.FileDownloadHelper.DatabaseCustomMaker
        public com.liulishuo.filedownloader.database.FileDownloadDatabase customMake() {
            return new com.liulishuo.filedownloader.database.SqliteDatabaseImpl();
        }
    }

    public static com.liulishuo.filedownloader.model.FileDownloadModel c(android.database.Cursor cursor) {
        com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel = new com.liulishuo.filedownloader.model.FileDownloadModel();
        fileDownloadModel.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        fileDownloadModel.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        fileDownloadModel.setPath(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex(com.liulishuo.filedownloader.model.FileDownloadModel.PATH_AS_DIRECTORY)) == 1);
        fileDownloadModel.setStatus((byte) cursor.getShort(cursor.getColumnIndex("status")));
        fileDownloadModel.setSoFar(cursor.getLong(cursor.getColumnIndex(com.liulishuo.filedownloader.model.FileDownloadModel.SOFAR)));
        fileDownloadModel.setTotal(cursor.getLong(cursor.getColumnIndex(com.liulishuo.filedownloader.model.FileDownloadModel.TOTAL)));
        fileDownloadModel.setErrMsg(cursor.getString(cursor.getColumnIndex(com.liulishuo.filedownloader.model.FileDownloadModel.ERR_MSG)));
        fileDownloadModel.setETag(cursor.getString(cursor.getColumnIndex(com.liulishuo.filedownloader.model.FileDownloadModel.ETAG)));
        fileDownloadModel.setFilename(cursor.getString(cursor.getColumnIndex(com.liulishuo.filedownloader.model.FileDownloadModel.FILENAME)));
        fileDownloadModel.setConnectionCount(cursor.getInt(cursor.getColumnIndex(com.liulishuo.filedownloader.model.FileDownloadModel.CONNECTION_COUNT)));
        return fileDownloadModel;
    }

    public static com.liulishuo.filedownloader.database.SqliteDatabaseImpl.Maker createMaker() {
        return new com.liulishuo.filedownloader.database.SqliteDatabaseImpl.Maker();
    }

    private void update(int i, android.content.ContentValues contentValues) {
        this.a.update(TABLE_NAME, contentValues, "_id = ? ", new java.lang.String[]{java.lang.String.valueOf(i)});
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void clear() {
        this.a.delete(TABLE_NAME, null, null);
        this.a.delete(CONNECTION_TABLE_NAME, null, null);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public com.liulishuo.filedownloader.model.FileDownloadModel find(int i) {
        java.lang.Throwable th;
        android.database.Cursor cursor;
        try {
            cursor = this.a.rawQuery(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("SELECT * FROM %s WHERE %s = ?", TABLE_NAME, "_id"), new java.lang.String[]{java.lang.Integer.toString(i)});
            try {
                if (!cursor.moveToNext()) {
                    cursor.close();
                    return null;
                }
                com.liulishuo.filedownloader.model.FileDownloadModel c = c(cursor);
                cursor.close();
                return c;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> findConnectionModel(int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursor = null;
        try {
            cursor = this.a.rawQuery(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("SELECT * FROM %s WHERE %s = ?", CONNECTION_TABLE_NAME, "id"), new java.lang.String[]{java.lang.Integer.toString(i)});
            while (cursor.moveToNext()) {
                com.liulishuo.filedownloader.model.ConnectionModel connectionModel = new com.liulishuo.filedownloader.model.ConnectionModel();
                connectionModel.setId(i);
                connectionModel.setIndex(cursor.getInt(cursor.getColumnIndex(com.liulishuo.filedownloader.model.ConnectionModel.INDEX)));
                connectionModel.setStartOffset(cursor.getLong(cursor.getColumnIndex("startOffset")));
                connectionModel.setCurrentOffset(cursor.getLong(cursor.getColumnIndex(com.liulishuo.filedownloader.model.ConnectionModel.CURRENT_OFFSET)));
                connectionModel.setEndOffset(cursor.getLong(cursor.getColumnIndex("endOffset")));
                arrayList.add(connectionModel);
            }
            cursor.close();
            return arrayList;
        } catch (java.lang.Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void insert(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        this.a.insert(TABLE_NAME, null, fileDownloadModel.toContentValues());
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void insertConnectionModel(com.liulishuo.filedownloader.model.ConnectionModel connectionModel) {
        this.a.insert(CONNECTION_TABLE_NAME, null, connectionModel.toContentValues());
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer maintainer() {
        return new com.liulishuo.filedownloader.database.SqliteDatabaseImpl.Maintainer(this);
    }

    public com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer maintainer(android.util.SparseArray<com.liulishuo.filedownloader.model.FileDownloadModel> sparseArray, android.util.SparseArray<java.util.List<com.liulishuo.filedownloader.model.ConnectionModel>> sparseArray2) {
        return new com.liulishuo.filedownloader.database.SqliteDatabaseImpl.Maintainer(sparseArray, sparseArray2);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void onTaskStart(int i) {
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public boolean remove(int i) {
        return this.a.delete(TABLE_NAME, "_id = ?", new java.lang.String[]{java.lang.String.valueOf(i)}) != 0;
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void removeConnections(int i) {
        this.a.execSQL("DELETE FROM filedownloaderConnection WHERE id = " + i);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void update(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "update but model == null!", new java.lang.Object[0]);
        } else if (find(fileDownloadModel.getId()) == null) {
            insert(fileDownloadModel);
        } else {
            this.a.update(TABLE_NAME, fileDownloadModel.toContentValues(), "_id = ? ", new java.lang.String[]{java.lang.String.valueOf(fileDownloadModel.getId())});
        }
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateCompleted(int i, long j) {
        remove(i);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateConnected(int i, long j, java.lang.String str, java.lang.String str2) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", (java.lang.Byte) (byte) 2);
        contentValues.put(com.liulishuo.filedownloader.model.FileDownloadModel.TOTAL, java.lang.Long.valueOf(j));
        contentValues.put(com.liulishuo.filedownloader.model.FileDownloadModel.ETAG, str);
        contentValues.put(com.liulishuo.filedownloader.model.FileDownloadModel.FILENAME, str2);
        update(i, contentValues);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateConnectionCount(int i, int i2) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.liulishuo.filedownloader.model.FileDownloadModel.CONNECTION_COUNT, java.lang.Integer.valueOf(i2));
        this.a.update(TABLE_NAME, contentValues, "_id = ? ", new java.lang.String[]{java.lang.Integer.toString(i)});
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateConnectionModel(int i, int i2, long j) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.liulishuo.filedownloader.model.ConnectionModel.CURRENT_OFFSET, java.lang.Long.valueOf(j));
        this.a.update(CONNECTION_TABLE_NAME, contentValues, "id = ? AND connectionIndex = ?", new java.lang.String[]{java.lang.Integer.toString(i), java.lang.Integer.toString(i2)});
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateError(int i, java.lang.Throwable th, long j) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.liulishuo.filedownloader.model.FileDownloadModel.ERR_MSG, th.toString());
        contentValues.put("status", (java.lang.Byte) (byte) -1);
        contentValues.put(com.liulishuo.filedownloader.model.FileDownloadModel.SOFAR, java.lang.Long.valueOf(j));
        update(i, contentValues);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateOldEtagOverdue(int i, java.lang.String str, long j, long j2, int i2) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.liulishuo.filedownloader.model.FileDownloadModel.SOFAR, java.lang.Long.valueOf(j));
        contentValues.put(com.liulishuo.filedownloader.model.FileDownloadModel.TOTAL, java.lang.Long.valueOf(j2));
        contentValues.put(com.liulishuo.filedownloader.model.FileDownloadModel.ETAG, str);
        contentValues.put(com.liulishuo.filedownloader.model.FileDownloadModel.CONNECTION_COUNT, java.lang.Integer.valueOf(i2));
        update(i, contentValues);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updatePause(int i, long j) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", (java.lang.Byte) (byte) -2);
        contentValues.put(com.liulishuo.filedownloader.model.FileDownloadModel.SOFAR, java.lang.Long.valueOf(j));
        update(i, contentValues);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updatePending(int i) {
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateProgress(int i, long j) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", (java.lang.Byte) (byte) 3);
        contentValues.put(com.liulishuo.filedownloader.model.FileDownloadModel.SOFAR, java.lang.Long.valueOf(j));
        update(i, contentValues);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateRetry(int i, java.lang.Throwable th) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.liulishuo.filedownloader.model.FileDownloadModel.ERR_MSG, th.toString());
        contentValues.put("status", (java.lang.Byte) (byte) 5);
        update(i, contentValues);
    }
}
