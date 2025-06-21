package com.sina.weibo.sdk.share;

/* loaded from: classes19.dex */
public final class e extends android.os.AsyncTask<com.sina.weibo.sdk.api.StoryMessage, java.lang.Void, com.sina.weibo.sdk.share.c> {
    private java.lang.ref.WeakReference<android.content.Context> H;
    private com.sina.weibo.sdk.share.b I;

    public e(android.content.Context context, com.sina.weibo.sdk.share.b bVar) {
        this.H = new java.lang.ref.WeakReference<>(context);
        this.I = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.sina.weibo.sdk.share.c doInBackground(com.sina.weibo.sdk.api.StoryMessage... storyMessageArr) {
        com.sina.weibo.sdk.api.StoryMessage storyMessage;
        android.content.Context context = this.H.get();
        if (context == null || (storyMessage = storyMessageArr[0]) == null) {
            return null;
        }
        com.sina.weibo.sdk.share.c cVar = new com.sina.weibo.sdk.share.c();
        try {
            android.net.Uri imageUri = storyMessage.getImageUri();
            if (imageUri != null && com.sina.weibo.sdk.c.b.a(context, imageUri)) {
                cVar.G = b(context, imageUri, 1);
                cVar.E = true;
            }
            android.net.Uri videoUri = storyMessage.getVideoUri();
            if (videoUri != null && com.sina.weibo.sdk.c.b.b(context, videoUri)) {
                cVar.G = b(context, videoUri, 0);
                cVar.E = true;
            }
        } catch (java.lang.Throwable th) {
            cVar.E = false;
            cVar.errorMessage = th.getMessage();
        }
        return cVar;
    }

    private static com.sina.weibo.sdk.api.StoryObject b(android.content.Context context, android.net.Uri uri, int i) {
        java.lang.String a = com.sina.weibo.sdk.share.a.a(context, uri, i);
        if (android.text.TextUtils.isEmpty(a)) {
            return null;
        }
        com.sina.weibo.sdk.api.StoryObject storyObject = new com.sina.weibo.sdk.api.StoryObject();
        storyObject.sourcePath = a;
        storyObject.sourceType = i;
        storyObject.appId = com.sina.weibo.sdk.a.a().getAppKey();
        storyObject.appPackage = context.getPackageName();
        storyObject.callbackAction = "com.sina.weibo.sdk.action.ACTION_SDK_REQ_STORY";
        return storyObject;
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
}
