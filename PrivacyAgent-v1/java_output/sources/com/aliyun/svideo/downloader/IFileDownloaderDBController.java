package com.aliyun.svideo.downloader;

/* loaded from: classes.dex */
public interface IFileDownloaderDBController {
    com.aliyun.svideo.downloader.FileDownloaderModel addTask(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel);

    boolean checkExits(int i);

    boolean checkExits(int i, int i2);

    boolean deleteTask(int i);

    boolean deleteTaskById(int i);

    android.util.SparseArray<com.aliyun.svideo.downloader.FileDownloaderModel> getAllTasks();

    java.util.List<java.lang.String> getPath(int i);

    java.lang.String getPathByUrl(java.lang.String str);

    java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> getResourceByFiled(java.util.HashMap<java.lang.String, java.lang.String> hashMap);

    android.database.Cursor getResourceById(int i);

    java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> getResourceByType(int i);

    android.database.Cursor getResourceColumns(java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.util.List<java.lang.String> list);

    boolean insertDb(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel, java.util.HashMap<java.lang.String, java.lang.String> hashMap);
}
