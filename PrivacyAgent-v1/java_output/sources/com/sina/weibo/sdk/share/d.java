package com.sina.weibo.sdk.share;

/* loaded from: classes19.dex */
public final class d extends android.os.AsyncTask<com.sina.weibo.sdk.api.WeiboMultiMessage, java.lang.Void, com.sina.weibo.sdk.share.c> {
    private java.lang.ref.WeakReference<android.content.Context> H;
    private com.sina.weibo.sdk.share.b I;

    public d(android.content.Context context, com.sina.weibo.sdk.share.b bVar) {
        this.H = new java.lang.ref.WeakReference<>(context);
        this.I = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.sina.weibo.sdk.share.c doInBackground(com.sina.weibo.sdk.api.WeiboMultiMessage... weiboMultiMessageArr) {
        com.sina.weibo.sdk.api.WeiboMultiMessage weiboMultiMessage;
        android.net.Uri uri;
        android.content.Context context = this.H.get();
        if (context == null || (weiboMultiMessage = weiboMultiMessageArr[0]) == null) {
            return null;
        }
        java.lang.String str = com.sina.weibo.sdk.c.a.c(context).packageName;
        if (android.text.TextUtils.isEmpty(str)) {
            str = "com.sina.weibo";
        }
        com.sina.weibo.sdk.share.c cVar = new com.sina.weibo.sdk.share.c();
        try {
            if (weiboMultiMessage.imageObject != null && weiboMultiMessage.multiImageObject != null) {
                weiboMultiMessage.imageObject = null;
            }
            if (weiboMultiMessage.videoSourceObject != null && (weiboMultiMessage.imageObject != null || weiboMultiMessage.multiImageObject != null)) {
                weiboMultiMessage.imageObject = null;
                weiboMultiMessage.multiImageObject = null;
            }
            if (weiboMultiMessage.multiImageObject != null) {
                java.util.ArrayList<android.net.Uri> arrayList = new java.util.ArrayList<>();
                java.util.Iterator<android.net.Uri> it = weiboMultiMessage.multiImageObject.getImageList().iterator();
                while (it.hasNext()) {
                    android.net.Uri next = it.next();
                    if (next != null && com.sina.weibo.sdk.c.b.a(context, next)) {
                        if (android.os.Build.VERSION.SDK_INT >= 24) {
                            arrayList.add(next);
                            context.grantUriPermission(str, next, 1);
                        } else {
                            java.lang.String a = com.sina.weibo.sdk.share.a.a(context, next, 1);
                            if (android.text.TextUtils.isEmpty(a)) {
                                throw new java.lang.IllegalArgumentException("image's path is null");
                            }
                            arrayList.add(android.net.Uri.fromFile(new java.io.File(a)));
                        }
                    }
                }
                weiboMultiMessage.multiImageObject.imageList = arrayList;
            }
            com.sina.weibo.sdk.api.VideoSourceObject videoSourceObject = weiboMultiMessage.videoSourceObject;
            if (videoSourceObject != null && (uri = videoSourceObject.videoPath) != null && com.sina.weibo.sdk.c.b.b(context, uri)) {
                if (android.os.Build.VERSION.SDK_INT >= 24) {
                    com.sina.weibo.sdk.api.VideoSourceObject videoSourceObject2 = weiboMultiMessage.videoSourceObject;
                    videoSourceObject2.videoPath = uri;
                    videoSourceObject2.during = com.sina.weibo.sdk.c.b.e(com.sina.weibo.sdk.c.b.d(context, uri));
                    context.grantUriPermission(str, weiboMultiMessage.videoSourceObject.videoPath, 1);
                } else {
                    java.lang.String a2 = com.sina.weibo.sdk.share.a.a(context, uri, 0);
                    com.sina.weibo.sdk.c.c.a("WBShareTag", "prepare video resource and video'path is" + a2);
                    if (android.text.TextUtils.isEmpty(a2)) {
                        throw new java.lang.IllegalArgumentException("video's path is null");
                    }
                    weiboMultiMessage.videoSourceObject.videoPath = android.net.Uri.fromFile(new java.io.File(a2));
                    weiboMultiMessage.videoSourceObject.during = com.sina.weibo.sdk.c.b.e(a2);
                }
            }
            cVar.F = weiboMultiMessage;
            cVar.E = true;
        } catch (java.lang.Throwable th) {
            cVar.E = false;
            java.lang.String message = th.getMessage();
            if (android.text.TextUtils.isEmpty(message)) {
                message = th.toString();
            }
            cVar.errorMessage = message;
            com.sina.weibo.sdk.c.c.b("WBShareTag", "prepare resource error is :" + message);
        }
        return cVar;
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(com.sina.weibo.sdk.share.c cVar) {
        com.sina.weibo.sdk.share.c cVar2 = cVar;
        super.onPostExecute(cVar2);
        com.sina.weibo.sdk.share.b bVar = this.I;
        if (bVar != null) {
            bVar.a(cVar2);
        }
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        super.onPreExecute();
    }
}
