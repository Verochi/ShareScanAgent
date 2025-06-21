package com.aliyun.svideo.downloader;

/* loaded from: classes.dex */
public class FileDownloaderDBGeneralController implements com.aliyun.svideo.downloader.IFileDownloaderDBController {
    private com.aliyun.svideo.downloader.FileDownloaderDBOpenHelper mDBHelper;
    private java.lang.String mTableName;

    public FileDownloaderDBGeneralController(com.aliyun.svideo.downloader.FileDownloaderDBOpenHelper fileDownloaderDBOpenHelper, java.lang.String str) {
        this.mDBHelper = fileDownloaderDBOpenHelper;
        this.mTableName = str;
    }

    private com.aliyun.svideo.downloader.FileDownloaderModel addCursor2Data(android.database.Cursor cursor) {
        java.lang.String string = cursor.getString(cursor.getColumnIndex("url"));
        int i = cursor.getInt(cursor.getColumnIndex("task_id"));
        int i2 = cursor.getInt(cursor.getColumnIndex("id"));
        java.lang.String string2 = cursor.getString(cursor.getColumnIndex("name"));
        java.lang.String string3 = cursor.getString(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.NAME_EN));
        java.lang.String string4 = cursor.getString(cursor.getColumnIndex("path"));
        int i3 = cursor.getInt(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.ISUNZIP));
        int i4 = cursor.getInt(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.EFFECTTYPE));
        java.lang.String string5 = cursor.getString(cursor.getColumnIndex("key"));
        int i5 = cursor.getInt(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL));
        java.lang.String string6 = cursor.getString(cursor.getColumnIndex("tag"));
        int i6 = cursor.getInt(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.CAT));
        java.lang.String string7 = cursor.getString(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWPIC));
        java.lang.String string8 = cursor.getString(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWMP4));
        long j = cursor.getLong(cursor.getColumnIndex("duration"));
        int i7 = cursor.getInt(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.SORT));
        int i8 = cursor.getInt(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.ASPECT));
        java.lang.String string9 = cursor.getString(cursor.getColumnIndex("download"));
        java.lang.String string10 = cursor.getString(cursor.getColumnIndex("md5"));
        java.lang.String string11 = cursor.getString(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.CNNAME));
        int i9 = cursor.getInt(cursor.getColumnIndex("category"));
        java.lang.String string12 = cursor.getString(cursor.getColumnIndex("banner"));
        java.lang.String string13 = cursor.getString(cursor.getColumnIndex("icon"));
        java.lang.String string14 = cursor.getString(cursor.getColumnIndex("description"));
        int i10 = cursor.getInt(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.ISNEW));
        java.lang.String string15 = cursor.getString(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEW));
        int i11 = cursor.getInt(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.SUBID));
        int i12 = cursor.getInt(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.FONTID));
        java.lang.String string16 = cursor.getString(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.SUBICON));
        java.lang.String string17 = cursor.getString(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.SUBNAME));
        int i13 = cursor.getInt(cursor.getColumnIndex("priority"));
        java.lang.String string18 = cursor.getString(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.SUBPREVIEW));
        int i14 = cursor.getInt(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.SUBSORT));
        int i15 = cursor.getInt(cursor.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.SUBTYPE));
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
        fileDownloaderModel.setTaskId(i);
        fileDownloaderModel.setId(i2);
        fileDownloaderModel.setName(string2);
        fileDownloaderModel.setNameEn(string3);
        fileDownloaderModel.setUrl(string);
        fileDownloaderModel.setPath(string4);
        fileDownloaderModel.setIsunzip(i3);
        fileDownloaderModel.setEffectType(i4);
        fileDownloaderModel.setKey(string5);
        fileDownloaderModel.setLevel(i5);
        fileDownloaderModel.setTag(string6);
        fileDownloaderModel.setCat(i6);
        fileDownloaderModel.setPreviewpic(string7);
        fileDownloaderModel.setPreviewmp4(string8);
        fileDownloaderModel.setDuration(j);
        fileDownloaderModel.setSubtype(i15);
        fileDownloaderModel.setSort(i7);
        fileDownloaderModel.setAspect(i8);
        fileDownloaderModel.setDownload(string9);
        fileDownloaderModel.setMd5(string10);
        fileDownloaderModel.setCnname(string11);
        fileDownloaderModel.setCategory(i9);
        fileDownloaderModel.setBanner(string12);
        fileDownloaderModel.setIcon(string13);
        fileDownloaderModel.setDescription(string14);
        fileDownloaderModel.setIsnew(i10);
        fileDownloaderModel.setPreview(string15);
        fileDownloaderModel.setSubid(i11);
        fileDownloaderModel.setFontid(i12);
        fileDownloaderModel.setSubicon(string16);
        fileDownloaderModel.setSubname(string17);
        fileDownloaderModel.setPriority(i13);
        fileDownloaderModel.setSubpreview(string18);
        fileDownloaderModel.setSubsort(i14);
        fileDownloaderModel.parseExtField(cursor);
        return fileDownloaderModel;
    }

    private java.lang.String listToString(java.util.List<java.lang.String> list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                break;
            }
            if (i == list.size() - 1) {
                sb.append(list.get(i));
                break;
            }
            sb.append(list.get(i) + ",");
            i++;
        }
        return sb.toString();
    }

    @Override // com.aliyun.svideo.downloader.IFileDownloaderDBController
    public synchronized com.aliyun.svideo.downloader.FileDownloaderModel addTask(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel) {
        if (com.aliyun.common.utils.StringUtils.isEmpty(fileDownloaderModel.getPath())) {
            return null;
        }
        int taskId = fileDownloaderModel.getTaskId();
        android.database.sqlite.SQLiteDatabase writableDatabase = this.mDBHelper.getWritableDatabase();
        boolean z = false;
        if (writableDatabase.isOpen()) {
            try {
                if (checkExits(taskId) ? writableDatabase.update(this.mTableName, fileDownloaderModel.toContentValues(), "task_id = ?", new java.lang.String[]{java.lang.String.valueOf(taskId)}) != -1 : writableDatabase.insert(this.mTableName, null, fileDownloaderModel.toContentValues()) != -1) {
                    z = true;
                }
            } catch (java.lang.Exception unused) {
            }
        }
        try {
            writableDatabase.close();
        } catch (android.database.SQLException unused2) {
        }
        if (!z) {
            fileDownloaderModel = null;
        }
        return fileDownloaderModel;
    }

    @Override // com.aliyun.svideo.downloader.IFileDownloaderDBController
    public synchronized boolean checkExits(int i) {
        boolean z;
        z = true;
        java.lang.String[] strArr = {java.lang.String.valueOf(i)};
        android.database.Cursor rawQuery = this.mDBHelper.getReadableDatabase().rawQuery("SELECT * FROM " + this.mTableName + " where task_id = ?", strArr);
        if (rawQuery.getCount() <= 0) {
            z = false;
        }
        rawQuery.close();
        return z;
    }

    @Override // com.aliyun.svideo.downloader.IFileDownloaderDBController
    public synchronized boolean checkExits(int i, int i2) {
        boolean z;
        java.lang.String[] strArr = {java.lang.String.valueOf(i), java.lang.String.valueOf(i2)};
        android.database.Cursor rawQuery = this.mDBHelper.getReadableDatabase().rawQuery("SELECT * FROM " + this.mTableName + " where id = ? and type = ?", strArr);
        z = rawQuery.getCount() > 0;
        rawQuery.close();
        return z;
    }

    @Override // com.aliyun.svideo.downloader.IFileDownloaderDBController
    public synchronized boolean deleteTask(int i) {
        boolean z;
        z = false;
        java.lang.String[] strArr = {java.lang.String.valueOf(i)};
        android.database.sqlite.SQLiteDatabase writableDatabase = this.mDBHelper.getWritableDatabase();
        if (writableDatabase.isOpen()) {
            try {
                z = writableDatabase.delete(this.mTableName, "task_id=?", strArr) != -1;
            } catch (java.lang.Exception unused) {
            }
        }
        try {
            writableDatabase.close();
        } catch (android.database.SQLException unused2) {
        }
        return z;
    }

    @Override // com.aliyun.svideo.downloader.IFileDownloaderDBController
    public synchronized boolean deleteTaskById(int i) {
        return deleteTaskById(i, false);
    }

    public synchronized boolean deleteTaskById(int i, boolean z) {
        boolean z2;
        z2 = false;
        z2 = false;
        java.lang.String[] strArr = {java.lang.String.valueOf(i)};
        android.database.sqlite.SQLiteDatabase writableDatabase = this.mDBHelper.getWritableDatabase();
        if (writableDatabase.isOpen()) {
            try {
                java.util.List<java.lang.String> path = getPath(i);
                boolean z3 = writableDatabase.delete(this.mTableName, "id=?", strArr) != -1;
                if (z3) {
                    for (int i2 = 0; i2 < path.size(); i2++) {
                        try {
                            if (z) {
                                com.aliyun.common.utils.FileUtils.deleteFD(new java.io.File(path.get(i2)).getParent());
                            } else {
                                com.aliyun.common.utils.FileUtils.deleteFD(new java.io.File(path.get(i2)));
                            }
                        } catch (java.lang.Exception unused) {
                        }
                    }
                }
                z2 = z3;
            } catch (java.lang.Exception unused2) {
            }
        }
        try {
            writableDatabase.close();
        } catch (android.database.SQLException unused3) {
        }
        return z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0061, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        if (r0.isOpen() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0042, code lost:
    
        if (r0.isOpen() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0064, code lost:
    
        return r2;
     */
    @Override // com.aliyun.svideo.downloader.IFileDownloaderDBController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public android.util.SparseArray<com.aliyun.svideo.downloader.FileDownloaderModel> getAllTasks() {
        android.database.sqlite.SQLiteDatabase readableDatabase = this.mDBHelper.getReadableDatabase();
        android.database.Cursor rawQuery = readableDatabase.rawQuery("SELECT * FROM " + this.mTableName, null);
        android.util.SparseArray<com.aliyun.svideo.downloader.FileDownloaderModel> sparseArray = new android.util.SparseArray<>();
        while (rawQuery.moveToNext()) {
            try {
                sparseArray.put(rawQuery.getInt(rawQuery.getColumnIndex("task_id")), addCursor2Data(rawQuery));
            } catch (java.lang.Exception unused) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (java.lang.Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (readableDatabase.isOpen()) {
                    readableDatabase.close();
                }
                throw th;
            }
        }
        rawQuery.close();
    }

    @Override // com.aliyun.svideo.downloader.IFileDownloaderDBController
    public synchronized java.util.List<java.lang.String> getPath(int i) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("id", java.lang.String.valueOf(i));
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList2.add("path");
        android.database.Cursor resourceColumns = getResourceColumns(hashMap, arrayList2);
        if (resourceColumns.getCount() > 0) {
            while (resourceColumns.moveToNext()) {
                arrayList.add(resourceColumns.getString(resourceColumns.getColumnIndex("path")));
            }
        }
        resourceColumns.close();
        return arrayList;
    }

    @Override // com.aliyun.svideo.downloader.IFileDownloaderDBController
    public synchronized java.lang.String getPathByUrl(java.lang.String str) {
        java.lang.String str2 = null;
        if (str != null) {
            if (!str.isEmpty()) {
                java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
                hashMap.put("url", str);
                java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> resourceByFiled = getResourceByFiled(hashMap);
                if (resourceByFiled.size() > 0) {
                    java.lang.String path = resourceByFiled.get(0).getPath();
                    if (new java.io.File(path).exists()) {
                        str2 = path;
                    }
                }
                return str2;
            }
        }
        return null;
    }

    @Override // com.aliyun.svideo.downloader.IFileDownloaderDBController
    public synchronized java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> getResourceByFiled(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        java.util.ArrayList arrayList;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(" where ");
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry<java.lang.String, java.lang.String> next = it.next();
            stringBuffer.append(next.getKey().toString() + " = ?");
            arrayList2.add(next.getValue().toString());
            if (it.hasNext()) {
                stringBuffer.append(" and ");
            }
        }
        java.lang.String[] strArr = (java.lang.String[]) arrayList2.toArray(new java.lang.String[arrayList2.size()]);
        arrayList = new java.util.ArrayList();
        android.database.Cursor rawQuery = this.mDBHelper.getReadableDatabase().rawQuery("SELECT * FROM " + this.mTableName + ((java.lang.Object) stringBuffer), strArr);
        while (rawQuery.moveToNext()) {
            arrayList.add(addCursor2Data(rawQuery));
        }
        rawQuery.close();
        return arrayList;
    }

    @Override // com.aliyun.svideo.downloader.IFileDownloaderDBController
    public synchronized android.database.Cursor getResourceById(int i) {
        java.lang.String[] strArr = {java.lang.String.valueOf(i)};
        android.database.Cursor rawQuery = this.mDBHelper.getReadableDatabase().rawQuery("SELECT * FROM " + this.mTableName + " where id = ?", strArr);
        return rawQuery.getCount() > 0 ? rawQuery : rawQuery;
    }

    @Override // com.aliyun.svideo.downloader.IFileDownloaderDBController
    public synchronized java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> getResourceByType(int i) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        java.lang.String[] strArr = {java.lang.String.valueOf(i)};
        android.database.Cursor rawQuery = this.mDBHelper.getReadableDatabase().rawQuery("SELECT * FROM " + this.mTableName + " where effecttype = ? order by id", strArr);
        while (rawQuery.moveToNext()) {
            arrayList.add(addCursor2Data(rawQuery));
        }
        rawQuery.close();
        return arrayList;
    }

    @Override // com.aliyun.svideo.downloader.IFileDownloaderDBController
    public synchronized android.database.Cursor getResourceColumns(java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.util.List<java.lang.String> list) {
        java.lang.String str;
        java.lang.StringBuffer stringBuffer;
        java.lang.String[] strArr;
        str = "SELECT DISTINCT * FROM ";
        if (list.size() > 0) {
            str = "SELECT DISTINCT " + listToString(list) + " FROM ";
        }
        stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(" where ");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry<java.lang.String, java.lang.String> next = it.next();
            stringBuffer.append(next.getKey().toString() + " = ?");
            arrayList.add(next.getValue().toString());
            if (it.hasNext()) {
                stringBuffer.append(" and ");
            }
        }
        strArr = (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
        return this.mDBHelper.getReadableDatabase().rawQuery(str + this.mTableName + ((java.lang.Object) stringBuffer), strArr);
    }

    @Override // com.aliyun.svideo.downloader.IFileDownloaderDBController
    public synchronized boolean insertDb(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        boolean z;
        android.database.sqlite.SQLiteDatabase writableDatabase = this.mDBHelper.getWritableDatabase();
        java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> resourceByFiled = getResourceByFiled(hashMap);
        z = false;
        if (writableDatabase.isOpen()) {
            try {
                if (resourceByFiled.size() == 0) {
                    if (writableDatabase.insert(this.mTableName, null, fileDownloaderModel.toContentValues()) != -1) {
                        z = true;
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }
        try {
            writableDatabase.close();
        } catch (android.database.SQLException unused2) {
        }
        return z;
    }
}
