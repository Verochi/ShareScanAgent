package com.aliyun.svideo.music.music;

/* loaded from: classes12.dex */
public class MusicQuery extends android.os.AsyncTask<java.lang.Void, java.util.ArrayList<com.aliyun.svideo.base.http.MusicFileBean>, java.lang.Void> {
    private static final java.lang.String TAG = "MusicQuery";
    private com.aliyun.svideo.music.music.MusicQuery.OnResProgressListener l;
    private java.lang.ref.WeakReference<android.content.Context> mWeakReference;

    public interface OnResProgressListener {
        void onResProgress(java.util.ArrayList<com.aliyun.svideo.base.http.MusicFileBean> arrayList);
    }

    public MusicQuery(android.content.Context context) {
        this.mWeakReference = new java.lang.ref.WeakReference<>(context);
    }

    private boolean checkIsMusic(int i, long j) {
        if (i <= 0 || j <= 0) {
            return false;
        }
        int i2 = i / 1000;
        return ((i2 / 60) % 60 > 0 || i2 % 60 > 3) && j > 1048576;
    }

    private void publishRes(java.util.ArrayList<com.aliyun.svideo.base.http.MusicFileBean> arrayList) {
        publishProgress(new java.util.ArrayList(arrayList));
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0138, code lost:
    
        if (r13 == null) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0141  */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.Void doInBackground(java.lang.Void... voidArr) {
        java.lang.Throwable th;
        android.database.Cursor cursor;
        java.lang.ref.WeakReference<android.content.Context> weakReference = this.mWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        try {
            cursor = this.mWeakReference.get().getApplicationContext().getContentResolver().query(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new java.lang.String[]{"_id", "title", "_display_name", "duration", "artist", "_data", "_size", "mime_type"}, null, null, "date_added DESC");
        } catch (java.lang.Exception e) {
            e = e;
            cursor = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        if (cursor == null) {
            if (cursor != null) {
                cursor.close();
            }
            return null;
        }
        try {
            try {
                cursor.getCount();
                java.util.ArrayList<com.aliyun.svideo.base.http.MusicFileBean> arrayList = new java.util.ArrayList<>();
                while (cursor.moveToNext()) {
                    com.aliyun.svideo.base.http.MusicFileBean musicFileBean = new com.aliyun.svideo.base.http.MusicFileBean();
                    musicFileBean.id = cursor.getInt(cursor.getColumnIndex("_id"));
                    musicFileBean.title = cursor.getString(cursor.getColumnIndex("title"));
                    musicFileBean.displayName = cursor.getString(cursor.getColumnIndex("_display_name"));
                    musicFileBean.duration = cursor.getInt(cursor.getColumnIndex("duration"));
                    musicFileBean.size = cursor.getLong(cursor.getColumnIndex("_size"));
                    musicFileBean.artist = cursor.getString(cursor.getColumnIndex("artist"));
                    musicFileBean.path = cursor.getString(cursor.getColumnIndex("_data"));
                    if (musicFileBean.displayName.endsWith("mp3") || musicFileBean.displayName.endsWith("aac") || musicFileBean.displayName.endsWith("wav")) {
                        if (!android.text.TextUtils.isEmpty(musicFileBean.path) && new java.io.File(musicFileBean.path).exists()) {
                            if (checkIsMusic(musicFileBean.duration, musicFileBean.size)) {
                                musicFileBean.uri = android.content.ContentUris.withAppendedId(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, musicFileBean.id).toString();
                                arrayList.add(musicFileBean);
                            } else {
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                sb.append("no 60s music :");
                                sb.append(musicFileBean.path);
                            }
                        }
                    }
                    if (arrayList.size() % 20 == 0) {
                        publishRes(arrayList);
                    }
                }
                publishRes(arrayList);
            } catch (java.lang.Exception e2) {
                e = e2;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("errorMsg :");
                sb2.append(e.getMessage());
            }
            cursor.close();
            return null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // android.os.AsyncTask
    @java.lang.SafeVarargs
    public final void onProgressUpdate(java.util.ArrayList<com.aliyun.svideo.base.http.MusicFileBean>... arrayListArr) {
        com.aliyun.svideo.music.music.MusicQuery.OnResProgressListener onResProgressListener = this.l;
        if (onResProgressListener != null) {
            onResProgressListener.onResProgress(arrayListArr[0]);
        }
    }

    public void setOnResProgressListener(com.aliyun.svideo.music.music.MusicQuery.OnResProgressListener onResProgressListener) {
        this.l = onResProgressListener;
    }
}
