package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
class FileDownloadTask extends android.os.AsyncTask<java.lang.Void, java.lang.Long, java.lang.Boolean> {
    private com.aliyun.vod.qupaiokhttp.FileDownloadCallback callback;
    private okhttp3.OkHttpClient okHttpClient = com.aliyun.vod.qupaiokhttp.OkHttpFinal.getInstance().getOkHttpClientBuilder().build();
    private long previousTime;
    private java.io.File target;
    private java.lang.String url;

    public FileDownloadTask(java.lang.String str, java.io.File file, com.aliyun.vod.qupaiokhttp.FileDownloadCallback fileDownloadCallback) {
        this.url = str;
        this.callback = fileDownloadCallback;
        this.target = file;
        com.aliyun.vod.common.utils.FileUtils.mkdirs(file.getParentFile());
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // android.os.AsyncTask
    public java.lang.Boolean doInBackground(java.lang.Void... voidArr) {
        boolean z = false;
        try {
            okhttp3.Response execute = this.okHttpClient.newCall(new okhttp3.Request.Builder().url(this.url).build()).execute();
            long contentLength = execute.body().contentLength();
            saveFile(execute);
            if (contentLength == this.target.length()) {
                z = true;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return java.lang.Boolean.valueOf(z);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(java.lang.Boolean bool) {
        super.onPostExecute((com.aliyun.vod.qupaiokhttp.FileDownloadTask) bool);
        if (bool.booleanValue()) {
            com.aliyun.vod.qupaiokhttp.FileDownloadCallback fileDownloadCallback = this.callback;
            if (fileDownloadCallback != null) {
                fileDownloadCallback.onDone();
                return;
            }
            return;
        }
        com.aliyun.vod.qupaiokhttp.FileDownloadCallback fileDownloadCallback2 = this.callback;
        if (fileDownloadCallback2 != null) {
            fileDownloadCallback2.onFailure();
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.previousTime = java.lang.System.currentTimeMillis();
        com.aliyun.vod.qupaiokhttp.FileDownloadCallback fileDownloadCallback = this.callback;
        if (fileDownloadCallback != null) {
            fileDownloadCallback.onStart();
        }
    }

    @Override // android.os.AsyncTask
    public void onProgressUpdate(java.lang.Long... lArr) {
        super.onProgressUpdate((java.lang.Object[]) lArr);
        if (this.callback == null || lArr == null || lArr.length < 2) {
            return;
        }
        long longValue = lArr[0].longValue();
        int longValue2 = (int) ((longValue * 100.0f) / lArr[1].longValue());
        long currentTimeMillis = (java.lang.System.currentTimeMillis() - this.previousTime) / 1000;
        if (currentTimeMillis == 0) {
            currentTimeMillis++;
        }
        this.callback.onProgress(longValue2, longValue / currentTimeMillis);
    }

    public java.lang.String saveFile(okhttp3.Response response) throws java.io.IOException {
        java.io.FileOutputStream fileOutputStream;
        byte[] bArr = new byte[2048];
        java.io.InputStream inputStream = null;
        try {
            java.io.InputStream byteStream = response.body().byteStream();
            try {
                long contentLength = response.body().contentLength();
                com.aliyun.vod.common.utils.FileUtils.mkdirs(this.target.getParentFile());
                fileOutputStream = new java.io.FileOutputStream(this.target);
                long j = 0;
                while (true) {
                    try {
                        int read = byteStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        j += read;
                        fileOutputStream.write(bArr, 0, read);
                        if (this.callback != null) {
                            publishProgress(java.lang.Long.valueOf(j), java.lang.Long.valueOf(contentLength));
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        inputStream = byteStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.io.IOException unused) {
                            }
                        }
                        if (fileOutputStream == null) {
                            throw th;
                        }
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (java.io.IOException unused2) {
                            throw th;
                        }
                    }
                }
                fileOutputStream.flush();
                java.lang.String absolutePath = this.target.getAbsolutePath();
                try {
                    byteStream.close();
                } catch (java.io.IOException unused3) {
                }
                try {
                    fileOutputStream.close();
                } catch (java.io.IOException unused4) {
                }
                return absolutePath;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }
}
