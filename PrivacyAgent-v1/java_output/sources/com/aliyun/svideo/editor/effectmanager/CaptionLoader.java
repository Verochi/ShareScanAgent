package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes12.dex */
public class CaptionLoader {
    public com.aliyun.svideo.base.http.EffectService mService = new com.aliyun.svideo.base.http.EffectService();

    /* renamed from: com.aliyun.svideo.editor.effectmanager.CaptionLoader$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.ResourceForm>> {
        final /* synthetic */ com.aliyun.svideo.editor.effectmanager.CaptionLoader.LoadCallback val$callback;

        public AnonymousClass1(com.aliyun.svideo.editor.effectmanager.CaptionLoader.LoadCallback loadCallback) {
            this.val$callback = loadCallback;
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onFailure(java.lang.Throwable th) {
            java.util.List<com.aliyun.svideo.base.Form.ResourceForm> loadLocalCaptions = com.aliyun.svideo.editor.effectmanager.CaptionLoader.this.loadLocalCaptions();
            com.aliyun.svideo.editor.effectmanager.CaptionLoader.LoadCallback loadCallback = this.val$callback;
            if (loadCallback != null) {
                loadCallback.onLoadCompleted(loadLocalCaptions, null, th);
            }
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onSuccess(java.util.List<com.aliyun.svideo.base.Form.ResourceForm> list) {
            java.util.ArrayList arrayList;
            if (this.val$callback != null) {
                java.util.List<com.aliyun.svideo.base.Form.ResourceForm> loadLocalCaptions = com.aliyun.svideo.editor.effectmanager.CaptionLoader.this.loadLocalCaptions();
                if (loadLocalCaptions == null || loadLocalCaptions.size() <= 0) {
                    arrayList = null;
                } else {
                    arrayList = new java.util.ArrayList(loadLocalCaptions.size());
                    java.util.Iterator<com.aliyun.svideo.base.Form.ResourceForm> it = loadLocalCaptions.iterator();
                    while (it.hasNext()) {
                        arrayList.add(java.lang.Integer.valueOf(it.next().getId()));
                    }
                }
                if (arrayList != null && arrayList.size() > 0) {
                    int i = 0;
                    while (i < list.size()) {
                        if (arrayList.contains(java.lang.Integer.valueOf(list.get(i).getId()))) {
                            list.remove(i);
                            i--;
                        }
                        i++;
                    }
                }
                this.val$callback.onLoadCompleted(loadLocalCaptions, list, null);
            }
        }
    }

    public interface LoadCallback {
        void onLoadCompleted(java.util.List<com.aliyun.svideo.base.Form.ResourceForm> list, java.util.List<com.aliyun.svideo.base.Form.ResourceForm> list2, java.lang.Throwable th);
    }

    public int loadAllCaption(android.content.Context context, com.aliyun.svideo.editor.effectmanager.CaptionLoader.LoadCallback loadCallback) {
        this.mService.loadEffectCaption(context.getPackageName(), new com.aliyun.svideo.editor.effectmanager.CaptionLoader.AnonymousClass1(loadCallback));
        return 0;
    }

    public java.util.List<com.aliyun.svideo.base.Form.ResourceForm> loadLocalCaptions() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList2.add("icon");
        arrayList2.add("description");
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.DESCRIPTION_EN);
        arrayList2.add("id");
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.ISNEW);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL);
        arrayList2.add("name");
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.NAME_EN);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEW);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.SORT);
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.EFFECTTYPE, java.lang.String.valueOf(6));
        android.database.Cursor resourceColumns = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceColumns(hashMap, arrayList2);
        while (resourceColumns.moveToNext()) {
            com.aliyun.svideo.base.Form.ResourceForm resourceForm = new com.aliyun.svideo.base.Form.ResourceForm();
            resourceForm.setIcon(resourceColumns.getString(resourceColumns.getColumnIndex("icon")));
            java.lang.String string = resourceColumns.getString(resourceColumns.getColumnIndex("description"));
            if (!"assets".equals(string)) {
                resourceForm.setDescription(string);
                resourceForm.setDescriptionEn(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.DESCRIPTION_EN)));
                resourceForm.setId(resourceColumns.getInt(resourceColumns.getColumnIndex("id")));
                resourceForm.setIsNew(resourceColumns.getInt(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.ISNEW)));
                resourceForm.setLevel(resourceColumns.getInt(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL)));
                resourceForm.setName(resourceColumns.getString(resourceColumns.getColumnIndex("name")));
                resourceForm.setNameEn(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.NAME_EN)));
                resourceForm.setPreviewUrl(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEW)));
                resourceForm.setSort(resourceColumns.getInt(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.SORT)));
                arrayList.add(resourceForm);
            }
        }
        resourceColumns.close();
        return arrayList;
    }
}
