package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes12.dex */
public class EffectLoader {
    public static final int ASPECT_1_1 = 1;
    public static final int ASPECT_4_3 = 2;
    public static final int ASPECT_9_16 = 3;
    public com.aliyun.svideo.base.http.EffectService mService = new com.aliyun.svideo.base.http.EffectService();

    /* renamed from: com.aliyun.svideo.editor.effectmanager.EffectLoader$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.ResourceForm>> {
        final /* synthetic */ com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback val$callback;

        public AnonymousClass1(com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback loadCallback) {
            this.val$callback = loadCallback;
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onFailure(java.lang.Throwable th) {
            java.util.List<com.aliyun.svideo.base.Form.ResourceForm> loadLocalPaster = com.aliyun.svideo.editor.effectmanager.EffectLoader.this.loadLocalPaster();
            com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback loadCallback = this.val$callback;
            if (loadCallback != null) {
                loadCallback.onLoadCompleted(loadLocalPaster, null, th);
            }
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onSuccess(java.util.List<com.aliyun.svideo.base.Form.ResourceForm> list) {
            java.util.ArrayList arrayList;
            if (this.val$callback != null) {
                java.util.List<com.aliyun.svideo.base.Form.ResourceForm> loadLocalPaster = com.aliyun.svideo.editor.effectmanager.EffectLoader.this.loadLocalPaster();
                if (loadLocalPaster == null || loadLocalPaster.size() <= 0) {
                    arrayList = null;
                } else {
                    arrayList = new java.util.ArrayList(loadLocalPaster.size());
                    java.util.Iterator<com.aliyun.svideo.base.Form.ResourceForm> it = loadLocalPaster.iterator();
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
                this.val$callback.onLoadCompleted(loadLocalPaster, list, null);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.EffectLoader$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.IMVForm>> {
        final /* synthetic */ com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback val$callback;

        public AnonymousClass2(com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback loadCallback) {
            this.val$callback = loadCallback;
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onFailure(java.lang.Throwable th) {
            java.util.List<com.aliyun.svideo.base.Form.IMVForm> loadLocalMV = com.aliyun.svideo.editor.effectmanager.EffectLoader.this.loadLocalMV();
            com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback loadCallback = this.val$callback;
            if (loadCallback != null) {
                loadCallback.onLoadCompleted(loadLocalMV, null, th);
            }
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onSuccess(java.util.List<com.aliyun.svideo.base.Form.IMVForm> list) {
            java.util.ArrayList arrayList;
            if (this.val$callback != null) {
                java.util.List<com.aliyun.svideo.base.Form.IMVForm> loadLocalMV = com.aliyun.svideo.editor.effectmanager.EffectLoader.this.loadLocalMV();
                if (loadLocalMV == null || loadLocalMV.size() <= 0) {
                    arrayList = null;
                } else {
                    arrayList = new java.util.ArrayList(loadLocalMV.size());
                    java.util.Iterator<com.aliyun.svideo.base.Form.IMVForm> it = loadLocalMV.iterator();
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
                this.val$callback.onLoadCompleted(loadLocalMV, list, null);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.EffectLoader$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm>> {
        final /* synthetic */ com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback val$callback;

        public AnonymousClass3(com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback loadCallback) {
            this.val$callback = loadCallback;
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onFailure(java.lang.Throwable th) {
            java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> loadLocalAnimationEffect = com.aliyun.svideo.editor.effectmanager.EffectLoader.this.loadLocalAnimationEffect(9);
            com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback loadCallback = this.val$callback;
            if (loadCallback != null) {
                loadCallback.onLoadCompleted(loadLocalAnimationEffect, null, th);
            }
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onSuccess(java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> list) {
            java.util.ArrayList arrayList;
            if (this.val$callback != null) {
                java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> loadLocalAnimationEffect = com.aliyun.svideo.editor.effectmanager.EffectLoader.this.loadLocalAnimationEffect(9);
                if (loadLocalAnimationEffect == null || loadLocalAnimationEffect.size() <= 0) {
                    arrayList = null;
                } else {
                    arrayList = new java.util.ArrayList(loadLocalAnimationEffect.size());
                    java.util.Iterator<com.aliyun.svideo.base.Form.AnimationEffectForm> it = loadLocalAnimationEffect.iterator();
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
                this.val$callback.onLoadCompleted(loadLocalAnimationEffect, list, null);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.EffectLoader$4, reason: invalid class name */
    public class AnonymousClass4 implements com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm>> {
        final /* synthetic */ com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback val$callback;

        public AnonymousClass4(com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback loadCallback) {
            this.val$callback = loadCallback;
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onFailure(java.lang.Throwable th) {
            java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> loadLocalAnimationEffect = com.aliyun.svideo.editor.effectmanager.EffectLoader.this.loadLocalAnimationEffect(10);
            com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback loadCallback = this.val$callback;
            if (loadCallback != null) {
                loadCallback.onLoadCompleted(loadLocalAnimationEffect, null, th);
            }
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onSuccess(java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> list) {
            java.util.ArrayList arrayList;
            if (this.val$callback != null) {
                java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> loadLocalAnimationEffect = com.aliyun.svideo.editor.effectmanager.EffectLoader.this.loadLocalAnimationEffect(10);
                if (loadLocalAnimationEffect == null || loadLocalAnimationEffect.size() <= 0) {
                    arrayList = null;
                } else {
                    arrayList = new java.util.ArrayList(loadLocalAnimationEffect.size());
                    java.util.Iterator<com.aliyun.svideo.base.Form.AnimationEffectForm> it = loadLocalAnimationEffect.iterator();
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
                this.val$callback.onLoadCompleted(loadLocalAnimationEffect, list, null);
            }
        }
    }

    public interface LoadCallback<T> {
        void onLoadCompleted(java.util.List<T> list, java.util.List<T> list2, java.lang.Throwable th);
    }

    public int loadAllAnimationFilter(android.content.Context context, com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback<com.aliyun.svideo.base.Form.AnimationEffectForm> loadCallback) {
        this.mService.loadAnimationFilter(context.getPackageName(), new com.aliyun.svideo.editor.effectmanager.EffectLoader.AnonymousClass3(loadCallback));
        return 0;
    }

    public int loadAllMV(android.content.Context context, com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback<com.aliyun.svideo.base.Form.IMVForm> loadCallback) {
        this.mService.loadEffectMv(context.getPackageName(), new com.aliyun.svideo.editor.effectmanager.EffectLoader.AnonymousClass2(loadCallback));
        return 0;
    }

    public int loadAllPaster(android.content.Context context, com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback<com.aliyun.svideo.base.Form.ResourceForm> loadCallback) {
        this.mService.loadEffectPaster(context.getPackageName(), new com.aliyun.svideo.editor.effectmanager.EffectLoader.AnonymousClass1(loadCallback));
        return 0;
    }

    public void loadAllTransition(android.content.Context context, com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback<com.aliyun.svideo.base.Form.AnimationEffectForm> loadCallback) {
        this.mService.loadTransitonEffect(context.getPackageName(), new com.aliyun.svideo.editor.effectmanager.EffectLoader.AnonymousClass4(loadCallback));
    }

    public java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> loadLocalAnimationEffect(int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList2.add("tag");
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.CAT);
        java.lang.String str = "id";
        arrayList2.add("id");
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.SUBTYPE);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL);
        arrayList2.add("name");
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.NAME_EN);
        arrayList2.add("description");
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWPIC);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWMP4);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.SORT);
        arrayList2.add("duration");
        arrayList2.add("key");
        java.lang.String str2 = "icon";
        arrayList2.add("icon");
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.EFFECTTYPE, java.lang.String.valueOf(i));
        android.database.Cursor resourceColumns = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceColumns(hashMap, arrayList2);
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        while (resourceColumns.moveToNext()) {
            com.aliyun.svideo.base.Form.AnimationEffectForm animationEffectForm = new com.aliyun.svideo.base.Form.AnimationEffectForm();
            animationEffectForm.setId(resourceColumns.getInt(resourceColumns.getColumnIndex(str)));
            java.lang.String str3 = str;
            if (!"assets".equals(resourceColumns.getString(resourceColumns.getColumnIndex("description")))) {
                java.lang.String str4 = str2;
                animationEffectForm.setDuration(resourceColumns.getLong(resourceColumns.getColumnIndex("duration")));
                animationEffectForm.setName(resourceColumns.getString(resourceColumns.getColumnIndex("name")));
                animationEffectForm.setNameEn(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.NAME_EN)));
                animationEffectForm.setPreviewImageUrl(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWPIC)));
                animationEffectForm.setPreviewMediaUrl(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWMP4)));
                animationEffectForm.setSort(resourceColumns.getInt(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.SORT)));
                animationEffectForm.setType(resourceColumns.getInt(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.SUBTYPE)));
                animationEffectForm.setDescription(resourceColumns.getString(resourceColumns.getColumnIndex("key")));
                animationEffectForm.setIconUrl(resourceColumns.getString(resourceColumns.getColumnIndex(str4)));
                arrayList.add(animationEffectForm);
                arrayList3 = arrayList3;
                arrayList3.add(java.lang.Integer.valueOf(animationEffectForm.getId()));
                str2 = str4;
            }
            str = str3;
        }
        resourceColumns.close();
        return arrayList;
    }

    public java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> loadLocalEffect(int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.lang.String str = "icon";
        arrayList2.add("icon");
        java.lang.String str2 = "description";
        arrayList2.add("description");
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.DESCRIPTION_EN);
        arrayList2.add("id");
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.ISNEW);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL);
        arrayList2.add("name");
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.NAME_EN);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEW);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.SORT);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWMP4);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWPIC);
        arrayList2.add("key");
        arrayList2.add("duration");
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        java.lang.String str3 = "duration";
        java.lang.String str4 = "key";
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.EFFECTTYPE, java.lang.String.valueOf(i));
        android.database.Cursor resourceColumns = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceColumns(hashMap, arrayList2);
        while (resourceColumns.moveToNext()) {
            com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
            fileDownloaderModel.setIcon(resourceColumns.getString(resourceColumns.getColumnIndex(str)));
            java.lang.String string = resourceColumns.getString(resourceColumns.getColumnIndex(str2));
            if (!"assets".equals(string)) {
                fileDownloaderModel.setDescription(string);
                fileDownloaderModel.setDescriptionEn(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.DESCRIPTION_EN)));
                fileDownloaderModel.setId(resourceColumns.getInt(resourceColumns.getColumnIndex("id")));
                fileDownloaderModel.setIsnew(resourceColumns.getInt(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.ISNEW)));
                fileDownloaderModel.setLevel(resourceColumns.getInt(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL)));
                fileDownloaderModel.setName(resourceColumns.getString(resourceColumns.getColumnIndex("name")));
                fileDownloaderModel.setNameEn(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.NAME_EN)));
                fileDownloaderModel.setPreview(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEW)));
                fileDownloaderModel.setSort(resourceColumns.getInt(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.SORT)));
                fileDownloaderModel.setPreviewmp4(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWMP4)));
                fileDownloaderModel.setPreviewpic(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWPIC)));
                java.lang.String str5 = str4;
                fileDownloaderModel.setKey(resourceColumns.getString(resourceColumns.getColumnIndex(str5)));
                java.lang.String str6 = str3;
                fileDownloaderModel.setDuration(resourceColumns.getLong(resourceColumns.getColumnIndex(str6)));
                arrayList.add(fileDownloaderModel);
                str = str;
                str2 = str2;
                str4 = str5;
                str3 = str6;
            }
        }
        resourceColumns.close();
        return arrayList;
    }

    public java.util.List<com.aliyun.svideo.base.Form.IMVForm> loadLocalMV() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.lang.String str = "tag";
        arrayList2.add("tag");
        java.lang.String str2 = com.aliyun.svideo.downloader.FileDownloaderModel.CAT;
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.CAT);
        arrayList2.add("id");
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.SUBTYPE);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL);
        arrayList2.add("name");
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.NAME_EN);
        arrayList2.add("description");
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWPIC);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWMP4);
        arrayList2.add(com.aliyun.svideo.downloader.FileDownloaderModel.SORT);
        arrayList2.add("duration");
        arrayList2.add("key");
        arrayList2.add("icon");
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.EFFECTTYPE, java.lang.String.valueOf(3));
        android.database.Cursor resourceColumns = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceColumns(hashMap, arrayList2);
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        while (resourceColumns.moveToNext()) {
            com.aliyun.svideo.base.Form.IMVForm iMVForm = new com.aliyun.svideo.base.Form.IMVForm();
            iMVForm.setTag(resourceColumns.getString(resourceColumns.getColumnIndex(str)));
            iMVForm.setCat(resourceColumns.getInt(resourceColumns.getColumnIndex(str2)));
            iMVForm.setId(resourceColumns.getInt(resourceColumns.getColumnIndex("id")));
            java.lang.String str3 = str;
            if (!"assets".equals(resourceColumns.getString(resourceColumns.getColumnIndex("description")))) {
                iMVForm.setDuration(resourceColumns.getLong(resourceColumns.getColumnIndex("duration")));
                iMVForm.setLevel(resourceColumns.getInt(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL)));
                iMVForm.setName(resourceColumns.getString(resourceColumns.getColumnIndex("name")));
                iMVForm.setNameEn(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.NAME_EN)));
                iMVForm.setPreviewPic(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWPIC)));
                iMVForm.setPreviewMp4(resourceColumns.getString(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWMP4)));
                iMVForm.setSort(resourceColumns.getInt(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.SORT)));
                iMVForm.setType(resourceColumns.getInt(resourceColumns.getColumnIndex(com.aliyun.svideo.downloader.FileDownloaderModel.SUBTYPE)));
                iMVForm.setKey(resourceColumns.getString(resourceColumns.getColumnIndex("key")));
                iMVForm.setIcon(resourceColumns.getString(resourceColumns.getColumnIndex("icon")));
                arrayList.add(iMVForm);
                arrayList3.add(java.lang.Integer.valueOf(iMVForm.getId()));
                str2 = str2;
            }
            str = str3;
        }
        resourceColumns.close();
        return arrayList;
    }

    public java.util.List<com.aliyun.svideo.base.Form.ResourceForm> loadLocalPaster() {
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
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.EFFECTTYPE, java.lang.String.valueOf(2));
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
