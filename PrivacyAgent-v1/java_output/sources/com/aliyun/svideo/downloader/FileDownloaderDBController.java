package com.aliyun.svideo.downloader;

/* loaded from: classes.dex */
public class FileDownloaderDBController {
    protected static final java.lang.String TABLE_NAME = "FileDownloader";
    private com.aliyun.svideo.downloader.FileDownloaderDBGeneralController mFileDownloaderDBGeneralController;

    public FileDownloaderDBController(android.content.Context context, int i, java.util.Map<java.lang.String, java.lang.String> map, com.aliyun.svideo.downloader.DbUpgradeListener dbUpgradeListener, boolean z, java.lang.String str) {
        this.mFileDownloaderDBGeneralController = null;
        this.mFileDownloaderDBGeneralController = new com.aliyun.svideo.downloader.FileDownloaderDBGeneralController(new com.aliyun.svideo.downloader.FileDownloaderDBOpenHelper(context, i, map, dbUpgradeListener), TABLE_NAME);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("FileDownloaderDBController: ");
        sb.append(z);
        sb.append(android.text.TextUtils.isEmpty(str));
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

    public synchronized com.aliyun.svideo.downloader.FileDownloaderModel addTask(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel) {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController == null) {
            return null;
        }
        return fileDownloaderDBGeneralController.addTask(fileDownloaderModel);
    }

    public synchronized boolean checkExits(int i) {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController == null) {
            return false;
        }
        return fileDownloaderDBGeneralController.checkExits(i);
    }

    public synchronized boolean checkExits(int i, int i2) {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController == null) {
            return false;
        }
        return fileDownloaderDBGeneralController.checkExits(i, i2);
    }

    public synchronized boolean deleteTask(int i) {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController == null) {
            return false;
        }
        return fileDownloaderDBGeneralController.deleteTask(i);
    }

    public synchronized boolean deleteTaskById(int i) {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController == null) {
            return false;
        }
        return fileDownloaderDBGeneralController.deleteTaskById(i);
    }

    public synchronized boolean deleteTaskById(int i, boolean z) {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController == null) {
            return false;
        }
        return fileDownloaderDBGeneralController.deleteTaskById(i, z);
    }

    public android.util.SparseArray<com.aliyun.svideo.downloader.FileDownloaderModel> getAllTasks() {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController != null) {
            return fileDownloaderDBGeneralController.getAllTasks();
        }
        return null;
    }

    public synchronized java.util.List<java.lang.String> getPath(int i) {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController == null) {
            return null;
        }
        return fileDownloaderDBGeneralController.getPath(i);
    }

    public synchronized java.lang.String getPathByUrl(java.lang.String str) {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController == null) {
            return null;
        }
        return fileDownloaderDBGeneralController.getPathByUrl(str);
    }

    public synchronized java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> getResourceByFiled(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController == null) {
            return null;
        }
        return fileDownloaderDBGeneralController.getResourceByFiled(hashMap);
    }

    public synchronized android.database.Cursor getResourceById(int i) {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController == null) {
            return null;
        }
        return fileDownloaderDBGeneralController.getResourceById(i);
    }

    public synchronized java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> getResourceByType(int i) {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController == null) {
            return null;
        }
        return fileDownloaderDBGeneralController.getResourceByType(i);
    }

    public synchronized android.database.Cursor getResourceColumns(java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.util.List<java.lang.String> list) {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController == null) {
            return null;
        }
        return fileDownloaderDBGeneralController.getResourceColumns(hashMap, list);
    }

    public synchronized boolean insertDb(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.aliyun.svideo.downloader.FileDownloaderDBGeneralController fileDownloaderDBGeneralController = this.mFileDownloaderDBGeneralController;
        if (fileDownloaderDBGeneralController == null) {
            return false;
        }
        return fileDownloaderDBGeneralController.insertDb(fileDownloaderModel, hashMap);
    }
}
