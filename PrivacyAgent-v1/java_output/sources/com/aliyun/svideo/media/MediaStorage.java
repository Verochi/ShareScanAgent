package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class MediaStorage {
    private static final java.lang.String CACHE_NAME = "media_dir";
    public static final int FIRST_NOTIFY_SIZE = 5;
    public static final int NOTIFY_SIZE_OFFSET = 10;
    public static final int SORT_MODE_MERGE = 2;
    public static final int SORT_MODE_PHOTO = 1;
    public static final int SORT_MODE_VIDEO = 0;
    public static final int TYPE_PHOTO = 1;
    public static final int TYPE_VIDEO = 0;
    private com.aliyun.svideo.media.MediaDir cacheDir;
    private java.lang.String cacheDirName;
    private java.util.List<com.aliyun.svideo.media.MediaInfo> cacheMediaList;
    private java.lang.String cacheSavePath;
    private com.aliyun.svideo.media.MediaDir currentDir;
    private com.aliyun.svideo.media.MediaInfo currentMedia;
    private boolean isCompleted;
    private com.aliyun.svideo.media.JsonExtend.JSONSupport jsonSupport;
    private com.aliyun.svideo.media.MediaStorage.OnCompletion onCompletionListener;
    private com.aliyun.svideo.media.MediaStorage.OnCurrentMediaInfoChange onCurrentMediaInfoChangeListener;
    private com.aliyun.svideo.media.MediaStorage.OnMediaDataUpdate onMediaDataUpdateListener;
    private com.aliyun.svideo.media.MediaStorage.OnMediaDirChange onMediaDirChangeListener;
    private com.aliyun.svideo.media.MediaStorage.OnMediaDirUpdate onMediaDirUpdateListener;
    com.aliyun.svideo.media.MediaStorage.SortMergedTask task;
    private long mMinVideoDuration = 2000;
    private long mMaxVideoDuration = 2147483647L;
    private int sortMode = 2;
    private java.util.HashMap<com.aliyun.svideo.media.MediaDir, java.util.List<com.aliyun.svideo.media.MediaInfo>> mediaByDir = new java.util.HashMap<>();
    private java.util.List<com.aliyun.svideo.media.MediaInfo> medias = new java.util.ArrayList();
    private java.util.List<com.aliyun.svideo.media.MediaDir> dirs = new java.util.ArrayList();
    private boolean isActive = true;

    /* renamed from: com.aliyun.svideo.media.MediaStorage$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> {
        public AnonymousClass1() {
        }

        @Override // android.os.AsyncTask
        public java.lang.Void doInBackground(java.lang.Void... voidArr) {
            if (com.aliyun.svideo.media.MediaStorage.this.cacheSavePath == null) {
                return null;
            }
            com.aliyun.svideo.media.MediaDir currentDir = com.aliyun.svideo.media.MediaStorage.this.getCurrentDir();
            java.io.File file = new java.io.File(new java.io.File(com.aliyun.svideo.media.MediaStorage.this.cacheSavePath), "media_dir.dir");
            com.aliyun.svideo.common.utils.FileUtils.deleteFD(file);
            if (currentDir != null && currentDir.id != -1) {
                java.util.List<com.aliyun.svideo.media.MediaInfo> list = (java.util.List) com.aliyun.svideo.media.MediaStorage.this.mediaByDir.get(currentDir);
                com.aliyun.svideo.media.MediaCache mediaCache = new com.aliyun.svideo.media.MediaCache();
                mediaCache.dir = currentDir;
                mediaCache.list = list;
                try {
                    com.aliyun.svideo.media.MediaStorage.this.jsonSupport.writeValue((java.io.OutputStream) new java.io.FileOutputStream(file), (java.io.FileOutputStream) mediaCache);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    public interface OnCompletion {
        void onCompletion();
    }

    public interface OnCurrentMediaInfoChange {
        void onCurrentMediaInfoChanged(com.aliyun.svideo.media.MediaInfo mediaInfo);
    }

    public interface OnMediaDataUpdate {
        void onDataUpdate(java.util.List<com.aliyun.svideo.media.MediaInfo> list);
    }

    public interface OnMediaDirChange {
        void onMediaDirChanged();
    }

    public interface OnMediaDirUpdate {
        void onDirUpdate(com.aliyun.svideo.media.MediaDir mediaDir);
    }

    public class SortMergedTask extends android.os.AsyncTask<java.lang.Void, java.util.ArrayList<com.aliyun.svideo.media.MediaInfo>, java.lang.Void> {
        private android.content.ContentResolver mResolver;

        public SortMergedTask(android.content.Context context) {
            this.mResolver = context.getApplicationContext().getContentResolver();
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x01d9  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x01ea  */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public java.lang.Void doInBackground(java.lang.Void... voidArr) {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            java.lang.Void r6 = null;
            android.database.Cursor query = (com.aliyun.svideo.media.MediaStorage.this.sortMode == 2 || com.aliyun.svideo.media.MediaStorage.this.sortMode == 0) ? this.mResolver.query(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new java.lang.String[]{"_data", "_id", "title", "mime_type", "duration", "date_added"}, java.lang.String.format("%1$s IN (?, ?, ? ,?,?,?,?) AND %2$s > %3$d AND %2$s < %4$d", "mime_type", "duration", java.lang.Long.valueOf(com.aliyun.svideo.media.MediaStorage.this.mMinVideoDuration), java.lang.Long.valueOf(com.aliyun.svideo.media.MediaStorage.this.mMaxVideoDuration)), new java.lang.String[]{"video/mp4", "video/ext-mp4", "video/quicktime", com.google.android.exoplayer2.util.MimeTypes.VIDEO_FLV, "video/flv", "video/3gpp", "video/mov"}, "date_added DESC") : null;
            android.database.Cursor query2 = (com.aliyun.svideo.media.MediaStorage.this.sortMode == 2 || com.aliyun.svideo.media.MediaStorage.this.sortMode == 1) ? this.mResolver.query(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new java.lang.String[]{"_data", "_id", "title", "mime_type", "date_added"}, null, null, "date_added DESC") : null;
            int count = (query == null ? 0 : query.getCount()) + (query2 == null ? 0 : query2.getCount());
            if (query != null) {
                i = query.getColumnIndexOrThrow("duration");
                int columnIndexOrThrow = query.getColumnIndexOrThrow("mime_type");
                query.getColumnIndexOrThrow("_data");
                i2 = columnIndexOrThrow;
                i3 = query.getColumnIndexOrThrow("_data");
                i4 = query.getColumnIndexOrThrow("title");
                i5 = query.getColumnIndexOrThrow("_id");
                i6 = query.getColumnIndex("date_added");
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
            }
            if (query2 != null) {
                i7 = query2.getColumnIndexOrThrow("mime_type");
                int columnIndexOrThrow2 = query2.getColumnIndexOrThrow("_data");
                int columnIndexOrThrow3 = query2.getColumnIndexOrThrow("title");
                int columnIndexOrThrow4 = query2.getColumnIndexOrThrow("_id");
                i8 = columnIndexOrThrow2;
                i9 = query2.getColumnIndex("date_added");
                i10 = columnIndexOrThrow3;
                i11 = columnIndexOrThrow4;
            } else {
                i7 = 0;
                i8 = 0;
                i9 = 0;
                i10 = 0;
                i11 = 0;
            }
            com.aliyun.svideo.media.MediaInfo mediaInfo = null;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int i12 = 0;
            int i13 = 5;
            boolean z = true;
            boolean z2 = true;
            com.aliyun.svideo.media.MediaInfo mediaInfo2 = null;
            while (i12 < count) {
                if (isCancelled()) {
                    if (query != null) {
                        query.close();
                    }
                    if (query2 != null) {
                        query2.close();
                    }
                    return r6;
                }
                if (query != null) {
                    while (mediaInfo2 == null && z && query.moveToNext()) {
                        mediaInfo2 = com.aliyun.svideo.media.MediaStorage.this.generateVideoInfo(query, i3, i, i2, i4, i5, i6, this.mResolver);
                        arrayList = arrayList;
                        i13 = i13;
                        i12 = i12;
                        count = count;
                    }
                }
                int i14 = i12;
                int i15 = i13;
                java.util.ArrayList arrayList2 = arrayList;
                int i16 = count;
                if (query2 != null) {
                    while (mediaInfo == null && z2 && query2.moveToNext()) {
                        mediaInfo = com.aliyun.svideo.media.MediaStorage.this.generateImageInfo(query2, i7, i8, i10, i11, i9, this.mResolver);
                    }
                }
                com.aliyun.svideo.media.MediaInfo mediaInfo3 = mediaInfo;
                if (mediaInfo2 != null || mediaInfo3 == null) {
                    if (mediaInfo3 == null && mediaInfo2 != null) {
                        com.aliyun.svideo.media.MediaStorage.this.addMediaInfo(mediaInfo2);
                        arrayList2.add(mediaInfo2);
                        mediaInfo = mediaInfo3;
                        mediaInfo2 = null;
                        z = true;
                    } else if (mediaInfo2 == null) {
                        mediaInfo = mediaInfo3;
                    } else if (mediaInfo2.addTime > mediaInfo3.addTime) {
                        com.aliyun.svideo.media.MediaStorage.this.addMediaInfo(mediaInfo2);
                        arrayList2.add(mediaInfo2);
                        mediaInfo = mediaInfo3;
                        mediaInfo2 = null;
                        z = true;
                        z2 = false;
                    } else {
                        com.aliyun.svideo.media.MediaStorage.this.addMediaInfo(mediaInfo3);
                        arrayList2.add(mediaInfo3);
                        mediaInfo = null;
                        z = false;
                    }
                    if (arrayList2.size() != i15) {
                        publishProgress(arrayList2);
                        i13 = i15 + 10;
                        arrayList = new java.util.ArrayList();
                    } else {
                        arrayList = arrayList2;
                        i13 = i15;
                    }
                    i12 = i14 + 1;
                    count = i16;
                    r6 = null;
                } else {
                    com.aliyun.svideo.media.MediaStorage.this.addMediaInfo(mediaInfo3);
                    arrayList2.add(mediaInfo3);
                    mediaInfo = null;
                }
                z2 = true;
                if (arrayList2.size() != i15) {
                }
                i12 = i14 + 1;
                count = i16;
                r6 = null;
            }
            publishProgress(arrayList);
            if (query != null) {
                query.close();
            }
            if (query2 == null) {
                return null;
            }
            query2.close();
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(java.lang.Void r3) {
            super.onPostExecute((com.aliyun.svideo.media.MediaStorage.SortMergedTask) r3);
            if (com.aliyun.svideo.media.MediaStorage.this.cacheMediaList != null) {
                com.aliyun.svideo.media.MediaStorage.this.mediaByDir.remove(com.aliyun.svideo.media.MediaStorage.this.cacheDir);
                com.aliyun.svideo.media.MediaStorage.this.mediaByDir.put(com.aliyun.svideo.media.MediaStorage.this.cacheDir, com.aliyun.svideo.media.MediaStorage.this.cacheMediaList);
            }
            com.aliyun.svideo.media.MediaStorage.this.isCompleted = true;
            if (com.aliyun.svideo.media.MediaStorage.this.onCompletionListener != null) {
                com.aliyun.svideo.media.MediaStorage.this.onCompletionListener.onCompletion();
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (android.os.Environment.getExternalStorageState().equals("mounted")) {
                com.aliyun.svideo.media.MediaStorage.this.readMediaFromCache();
            }
        }

        @Override // android.os.AsyncTask
        public void onProgressUpdate(java.util.ArrayList<com.aliyun.svideo.media.MediaInfo>... arrayListArr) {
            if (arrayListArr[0] != null) {
                com.aliyun.svideo.media.MediaStorage.this.medias.addAll(arrayListArr[0]);
                if (com.aliyun.svideo.media.MediaStorage.this.onMediaDataUpdateListener != null) {
                    com.aliyun.svideo.media.MediaStorage.this.onMediaDataUpdateListener.onDataUpdate(arrayListArr[0]);
                }
            }
            super.onProgressUpdate((java.lang.Object[]) arrayListArr);
        }
    }

    public MediaStorage(android.content.Context context, com.aliyun.svideo.media.JsonExtend.JSONSupport jSONSupport) {
        this.jsonSupport = jSONSupport;
        this.task = new com.aliyun.svideo.media.MediaStorage.SortMergedTask(context);
        java.io.File applicationSdcardPath = com.aliyun.svideo.common.utils.FileUtils.getApplicationSdcardPath(context);
        if (applicationSdcardPath != null) {
            this.cacheSavePath = applicationSdcardPath.getPath();
        } else {
            this.cacheSavePath = null;
            com.aliyun.svideo.common.utils.ToastUtils.show(context, com.aliyun.svideo.media.R.string.alivc_media_sdcard_not_ready);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMediaInfo(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        java.util.List<com.aliyun.svideo.media.MediaInfo> arrayList;
        java.lang.String str = mediaInfo.filePath.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)[r0.length - 2];
        com.aliyun.svideo.media.MediaDir findMediaDirByName = findMediaDirByName(str);
        if (findMediaDirByName == null) {
            findMediaDirByName = new com.aliyun.svideo.media.MediaDir();
            findMediaDirByName.id = mediaInfo.id;
            findMediaDirByName.type = mediaInfo.type;
            findMediaDirByName.dirName = str;
            findMediaDirByName.thumbnailUrl = mediaInfo.thumbnailPath;
            java.lang.String str2 = mediaInfo.filePath;
            findMediaDirByName.videoDirPath = str2.substring(0, str2.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR));
            if (this.dirs.size() == 0) {
                com.aliyun.svideo.media.MediaDir mediaDir = new com.aliyun.svideo.media.MediaDir();
                mediaDir.thumbnailUrl = mediaInfo.thumbnailPath;
                mediaDir.id = -1;
                mediaDir.resId = mediaInfo.id;
                mediaDir.type = mediaInfo.type;
                this.dirs.add(mediaDir);
            }
            this.dirs.add(findMediaDirByName);
            com.aliyun.svideo.media.MediaStorage.OnMediaDirUpdate onMediaDirUpdate = this.onMediaDirUpdateListener;
            if (onMediaDirUpdate != null) {
                onMediaDirUpdate.onDirUpdate(findMediaDirByName);
            }
        }
        if (this.mediaByDir.containsKey(findMediaDirByName)) {
            arrayList = this.mediaByDir.get(findMediaDirByName);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>();
            }
        } else {
            arrayList = new java.util.ArrayList<>();
            this.mediaByDir.put(findMediaDirByName, arrayList);
        }
        if (!android.text.TextUtils.equals(this.cacheDirName, findMediaDirByName.dirName)) {
            arrayList.add(mediaInfo);
            findMediaDirByName.fileCount = arrayList.size();
            return;
        }
        if (this.cacheMediaList == null) {
            this.cacheMediaList = new java.util.ArrayList();
            this.cacheDir = findMediaDirByName;
        }
        this.cacheMediaList.add(mediaInfo);
        findMediaDirByName.fileCount = this.cacheMediaList.size();
    }

    private void checkIfNeedToRotateThumbnail(java.lang.String str, java.lang.String str2) {
        try {
            android.media.ExifInterface exifInterface = new android.media.ExifInterface(str);
            android.media.ExifInterface exifInterface2 = new android.media.ExifInterface(str2);
            int attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != exifInterface2.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1)) {
                exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, java.lang.String.valueOf(attributeInt));
                exifInterface2.saveAttributes();
            }
        } catch (java.lang.Exception unused) {
        }
    }

    private android.database.Cursor createThumbnailAndRequery(com.aliyun.svideo.media.MediaInfo mediaInfo, android.content.ContentResolver contentResolver) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inDither = false;
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        android.provider.MediaStore.Images.Thumbnails.getThumbnail(contentResolver, mediaInfo.id, 3, options);
        return contentResolver.query(android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new java.lang.String[]{"_data", "image_id"}, "image_id=?", new java.lang.String[]{java.lang.String.valueOf(mediaInfo.id)}, null);
    }

    private com.aliyun.svideo.media.MediaDir findMediaDirByName(java.lang.String str) {
        if (this.dirs == null) {
            return null;
        }
        for (int i = 0; i < this.dirs.size(); i++) {
            com.aliyun.svideo.media.MediaDir mediaDir = this.dirs.get(i);
            if (str.equals(mediaDir.dirName)) {
                return mediaDir;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.svideo.media.MediaInfo generateImageInfo(android.database.Cursor cursor, int i, int i2, int i3, int i4, int i5, android.content.ContentResolver contentResolver) {
        java.lang.String string = cursor.getString(i);
        java.lang.String string2 = cursor.getString(i2);
        if (!new java.io.File(string2).exists()) {
            return null;
        }
        com.aliyun.svideo.media.MediaInfo mediaInfo = new com.aliyun.svideo.media.MediaInfo();
        mediaInfo.type = 1;
        java.lang.String string3 = cursor.getString(i3);
        mediaInfo.filePath = string2;
        mediaInfo.mimeType = string;
        mediaInfo.title = string3;
        int i6 = cursor.getInt(i4);
        mediaInfo.id = i6;
        mediaInfo.fileUri = android.content.ContentUris.withAppendedId(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, i6).toString();
        mediaInfo.addTime = cursor.getLong(i5);
        return mediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.svideo.media.MediaInfo generateVideoInfo(android.database.Cursor cursor, int i, int i2, int i3, int i4, int i5, int i6, android.content.ContentResolver contentResolver) {
        java.lang.String string = cursor.getString(i);
        if (!new java.io.File(string).exists()) {
            return null;
        }
        com.aliyun.svideo.media.MediaInfo mediaInfo = new com.aliyun.svideo.media.MediaInfo();
        mediaInfo.type = 0;
        int i7 = cursor.getInt(i2);
        java.lang.String string2 = cursor.getString(i3);
        java.lang.String string3 = cursor.getString(i4);
        mediaInfo.filePath = string;
        mediaInfo.mimeType = string2;
        mediaInfo.duration = i7;
        mediaInfo.title = string3;
        mediaInfo.id = cursor.getInt(i5);
        mediaInfo.addTime = cursor.getLong(i6);
        mediaInfo.fileUri = android.content.ContentUris.withAppendedId(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, mediaInfo.id).toString();
        return mediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readMediaFromCache() {
        com.aliyun.svideo.media.MediaCache mediaCache;
        com.aliyun.svideo.media.MediaDir mediaDir;
        if (this.cacheSavePath == null) {
            return;
        }
        java.io.File file = new java.io.File(new java.io.File(this.cacheSavePath), "media_dir.dir");
        if (file.exists()) {
            try {
                mediaCache = (com.aliyun.svideo.media.MediaCache) this.jsonSupport.readValue(new java.io.FileInputStream(file), com.aliyun.svideo.media.MediaCache.class);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                mediaCache = null;
            }
            if (mediaCache == null || (mediaDir = mediaCache.dir) == null) {
                return;
            }
            this.cacheDirName = mediaDir.dirName;
            this.mediaByDir.put(mediaDir, mediaCache.list);
        }
    }

    public void cancelTask() {
        com.aliyun.svideo.media.MediaStorage.SortMergedTask sortMergedTask = this.task;
        if (sortMergedTask != null) {
            sortMergedTask.cancel(false);
        }
    }

    public com.aliyun.svideo.media.MediaDir findDirById(int i) {
        for (com.aliyun.svideo.media.MediaDir mediaDir : this.dirs) {
            if (mediaDir.id == i) {
                return mediaDir;
            }
        }
        return null;
    }

    public com.aliyun.svideo.media.MediaDir findDirByName(java.lang.String str) {
        for (com.aliyun.svideo.media.MediaDir mediaDir : this.dirs) {
            if (android.text.TextUtils.equals(str, mediaDir.dirName)) {
                return mediaDir;
            }
        }
        return null;
    }

    public java.util.List<com.aliyun.svideo.media.MediaInfo> findMediaByDir(int i) {
        return findMediaByDir(findDirById(i));
    }

    public java.util.List<com.aliyun.svideo.media.MediaInfo> findMediaByDir(com.aliyun.svideo.media.MediaDir mediaDir) {
        if (mediaDir == null) {
            return null;
        }
        return this.mediaByDir.get(mediaDir);
    }

    public com.aliyun.svideo.media.MediaDir getCurrentDir() {
        return this.currentDir;
    }

    public com.aliyun.svideo.media.MediaInfo getCurrentMedia() {
        return this.currentMedia;
    }

    public java.util.List<com.aliyun.svideo.media.MediaDir> getDirs() {
        return this.dirs;
    }

    public java.util.List<com.aliyun.svideo.media.MediaInfo> getMedias() {
        return this.medias;
    }

    public long getMinDuration() {
        return this.mMinVideoDuration;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public boolean isMediaEmpty() {
        return this.isCompleted && this.medias.isEmpty();
    }

    public void saveCurrentDirToCache() {
        new com.aliyun.svideo.media.MediaStorage.AnonymousClass1().executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
    }

    public void setCurrentDir(com.aliyun.svideo.media.MediaDir mediaDir) {
        if (mediaDir == null && this.currentDir == null) {
            return;
        }
        this.currentDir = mediaDir;
        com.aliyun.svideo.media.MediaStorage.OnMediaDirChange onMediaDirChange = this.onMediaDirChangeListener;
        if (onMediaDirChange != null) {
            onMediaDirChange.onMediaDirChanged();
        }
    }

    public void setCurrentDisplayMediaData(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        if (this.currentMedia == null) {
            this.currentMedia = mediaInfo;
        }
        com.aliyun.svideo.media.MediaStorage.OnCurrentMediaInfoChange onCurrentMediaInfoChange = this.onCurrentMediaInfoChangeListener;
        if (onCurrentMediaInfoChange != null) {
            onCurrentMediaInfoChange.onCurrentMediaInfoChanged(mediaInfo);
        }
    }

    public void setIsActive(boolean z) {
        this.isActive = z;
    }

    public void setMinDuration(long j) {
        this.mMinVideoDuration = j;
    }

    public void setOnCompletionListener(com.aliyun.svideo.media.MediaStorage.OnCompletion onCompletion) {
        this.onCompletionListener = onCompletion;
    }

    public void setOnCurrentMediaInfoChangeListener(com.aliyun.svideo.media.MediaStorage.OnCurrentMediaInfoChange onCurrentMediaInfoChange) {
        this.onCurrentMediaInfoChangeListener = onCurrentMediaInfoChange;
    }

    public void setOnMediaDataUpdateListener(com.aliyun.svideo.media.MediaStorage.OnMediaDataUpdate onMediaDataUpdate) {
        this.onMediaDataUpdateListener = onMediaDataUpdate;
    }

    public void setOnMediaDirChangeListener(com.aliyun.svideo.media.MediaStorage.OnMediaDirChange onMediaDirChange) {
        this.onMediaDirChangeListener = onMediaDirChange;
    }

    public void setOnMediaDirUpdateListener(com.aliyun.svideo.media.MediaStorage.OnMediaDirUpdate onMediaDirUpdate) {
        this.onMediaDirUpdateListener = onMediaDirUpdate;
    }

    public void setSortMode(int i) {
        this.sortMode = i;
    }

    public void setVideoDurationRange(int i, int i2) {
        this.mMinVideoDuration = i;
        this.mMaxVideoDuration = i2;
    }

    public void startFetchMedias() {
        this.task.executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
    }
}
