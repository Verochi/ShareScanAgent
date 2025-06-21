package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class k extends android.os.AsyncTask<java.lang.String, java.lang.Void, java.util.List<android.graphics.Bitmap>> {
    private android.content.Context a;
    private com.vivo.push.model.InsideNotificationItem b;
    private long c;
    private boolean d;
    private int e = 0;
    private com.vivo.push.d.r.a f;

    public k(android.content.Context context, com.vivo.push.model.InsideNotificationItem insideNotificationItem, long j, boolean z, com.vivo.push.d.r.a aVar) {
        this.a = context;
        this.b = insideNotificationItem;
        this.c = j;
        this.d = z;
        this.f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0094, code lost:
    
        if (r5 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008a, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0088, code lost:
    
        if (r5 == null) goto L31;
     */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.util.List<android.graphics.Bitmap> doInBackground(java.lang.String... strArr) {
        java.util.ArrayList arrayList;
        int i;
        java.io.InputStream inputStream;
        android.graphics.Bitmap bitmap;
        this.e = this.b.getNotifyDisplayStatus();
        java.io.InputStream inputStream2 = null;
        if (!this.d) {
            com.vivo.push.util.p.d("ImageDownTask", "bitmap is not display by forbid net");
            return null;
        }
        arrayList = new java.util.ArrayList();
        for (i = 0; i < 2; i++) {
            java.lang.String str = strArr[i];
            com.vivo.push.util.p.d("ImageDownTask", "imgUrl=" + str + " i=" + i);
            if (!android.text.TextUtils.isEmpty(str)) {
                try {
                    java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    com.vivo.push.util.p.c("ImageDownTask", "code=".concat(java.lang.String.valueOf(responseCode)));
                    if (responseCode == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            try {
                                bitmap = android.graphics.BitmapFactory.decodeStream(inputStream);
                            } catch (java.lang.Throwable th) {
                                th = th;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (java.lang.Exception unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (java.net.MalformedURLException unused2) {
                            com.vivo.push.util.p.a("ImageDownTask", "MalformedURLException");
                        } catch (java.io.IOException unused3) {
                            com.vivo.push.util.p.a("ImageDownTask", "IOException");
                        }
                    } else {
                        inputStream = null;
                        bitmap = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Exception unused4) {
                        }
                    }
                } catch (java.net.MalformedURLException unused5) {
                    inputStream = null;
                } catch (java.io.IOException unused6) {
                    inputStream = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
                arrayList.add(bitmap);
            } else if (i == 0) {
                arrayList.add(null);
            }
        }
        return arrayList;
        bitmap = null;
        arrayList.add(bitmap);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(java.util.List<android.graphics.Bitmap> list) {
        java.util.List<android.graphics.Bitmap> list2 = list;
        super.onPostExecute(list2);
        com.vivo.push.util.p.c("ImageDownTask", "onPostExecute");
        com.vivo.push.m.c(new com.vivo.push.util.l(this, list2));
    }
}
