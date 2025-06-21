package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class AlivcResUtil {
    public static final java.lang.String HOST_APP = "app";
    public static final java.lang.String HOST_CLOUD = "cloud";
    public static final java.lang.String HOST_RELATION = "relation";
    public static final java.lang.String SCHEME = "alivc_resource";
    public static final java.lang.String TYPE_ANIMATION_EFFECTS = "animation_effects";
    public static final java.lang.String TYPE_BUBBLE = "bubble";
    public static final java.lang.String TYPE_CAPTION = "caption";
    public static final java.lang.String TYPE_FILTER = "filter";
    public static final java.lang.String TYPE_FONT = "font";
    public static final java.lang.String TYPE_LUT = "lut_filter";
    public static final java.lang.String TYPE_MUSIC = "music";
    public static final java.lang.String TYPE_MV = "mv";
    public static final java.lang.String TYPE_STICKER = "sticker";
    public static final java.lang.String TYPE_TRANSITION = "transition";

    /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$1, reason: invalid class name */
    public class AnonymousClass1 extends com.aliyun.common.qupaiokhttp.FileDownloadCallback {
        final /* synthetic */ com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback val$callback;
        final /* synthetic */ java.lang.String val$path;

        public AnonymousClass1(com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback, java.lang.String str) {
            this.val$callback = loadCallback;
            this.val$path = str;
        }

        @Override // com.aliyun.common.qupaiokhttp.FileDownloadCallback
        public void onDone() {
            this.val$callback.onSuccess(this.val$path);
        }

        @Override // com.aliyun.common.qupaiokhttp.FileDownloadCallback
        public void onFailure() {
            this.val$callback.onFailure(null, "download failure");
        }
    }

    /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.base.http.HttpCallback<java.lang.String> {
        final /* synthetic */ com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback val$callback;
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ java.lang.String val$title;

        /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.aliyun.common.qupaiokhttp.FileDownloadCallback {
            final /* synthetic */ java.io.File val$file;

            public AnonymousClass1(java.io.File file) {
                this.val$file = file;
            }

            @Override // com.aliyun.common.qupaiokhttp.FileDownloadCallback
            public void onDone() {
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass2.this.val$callback.onSuccess(this.val$file.getAbsolutePath());
            }

            @Override // com.aliyun.common.qupaiokhttp.FileDownloadCallback
            public void onFailure() {
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass2.this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_MUSIC, "music download failure");
            }
        }

        public AnonymousClass2(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
            this.val$context = context;
            this.val$title = str;
            this.val$callback = loadCallback;
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onFailure(java.lang.Throwable th) {
            this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_MUSIC, "music download failure " + th.getMessage());
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onSuccess(java.lang.String str) {
            java.io.File file = new java.io.File(com.aliyun.common.utils.StorageUtils.getFilesDirectory(this.val$context) + "/svideo_res/cloud/music/" + this.val$title);
            com.aliyun.common.qupaiokhttp.HttpRequest.download(str, file, new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass2.AnonymousClass1(file));
        }
    }

    /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback<com.aliyun.svideo.base.Form.AnimationEffectForm> {
        final /* synthetic */ com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback val$callback;
        final /* synthetic */ int val$groupId;
        final /* synthetic */ java.lang.String val$id;

        /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$3$1, reason: invalid class name */
        public class AnonymousClass1 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
            public AnonymousClass1() {
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onError(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass3.this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_TRANSITION, th.getMessage());
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onFinish(int i, java.lang.String str) {
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass3.this.val$callback.onSuccess(str + java.io.File.separator + com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass3.this.val$id);
            }
        }

        public AnonymousClass3(int i, java.lang.String str, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
            this.val$groupId = i;
            this.val$id = str;
            this.val$callback = loadCallback;
        }

        @Override // com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback
        public void onLoadCompleted(java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> list, java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> list2, java.lang.Throwable th) {
            if (list2 != null) {
                for (com.aliyun.svideo.base.Form.AnimationEffectForm animationEffectForm : list2) {
                    if (animationEffectForm.getId() == this.val$groupId) {
                        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
                        fileDownloaderModel.setEffectType(10);
                        fileDownloaderModel.setName(animationEffectForm.getName());
                        fileDownloaderModel.setNameEn(animationEffectForm.getNameEn());
                        fileDownloaderModel.setId(animationEffectForm.getId());
                        fileDownloaderModel.setPreviewpic(animationEffectForm.getPreviewImageUrl());
                        fileDownloaderModel.setIcon(animationEffectForm.getIconUrl());
                        fileDownloaderModel.setPreviewmp4(animationEffectForm.getPreviewMediaUrl());
                        fileDownloaderModel.setSort(animationEffectForm.getSort());
                        fileDownloaderModel.setSubtype(animationEffectForm.getType());
                        fileDownloaderModel.setDownload(animationEffectForm.getResourceUrl());
                        fileDownloaderModel.setUrl(animationEffectForm.getResourceUrl());
                        fileDownloaderModel.setDuration(animationEffectForm.getDuration());
                        fileDownloaderModel.setIsunzip(1);
                        com.aliyun.svideo.downloader.FileDownloaderModel addTask = com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, fileDownloaderModel.getDownload());
                        com.aliyun.svideo.editor.effectmanager.TasksManager tasksManager = new com.aliyun.svideo.editor.effectmanager.TasksManager();
                        tasksManager.addTask(addTask.getTaskId(), new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass3.AnonymousClass1());
                        tasksManager.startTask();
                        return;
                    }
                }
            }
            this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_TRANSITION, "Not found");
        }
    }

    /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$4, reason: invalid class name */
    public class AnonymousClass4 implements com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback<com.aliyun.svideo.base.Form.AnimationEffectForm> {
        final /* synthetic */ com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback val$callback;
        final /* synthetic */ int val$groupId;
        final /* synthetic */ java.lang.String val$id;

        /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$4$1, reason: invalid class name */
        public class AnonymousClass1 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
            public AnonymousClass1() {
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onError(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass4.this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_ANIMATION_EFFECTS, th.getMessage());
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onFinish(int i, java.lang.String str) {
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass4.this.val$callback.onSuccess(str + java.io.File.separator + com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass4.this.val$id);
            }
        }

        public AnonymousClass4(int i, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback, java.lang.String str) {
            this.val$groupId = i;
            this.val$callback = loadCallback;
            this.val$id = str;
        }

        @Override // com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback
        public void onLoadCompleted(java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> list, java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm> list2, java.lang.Throwable th) {
            if (list2 != null) {
                for (com.aliyun.svideo.base.Form.AnimationEffectForm animationEffectForm : list2) {
                    if (animationEffectForm.getId() == this.val$groupId) {
                        com.aliyun.svideo.editor.effectmanager.TasksManager tasksManager = new com.aliyun.svideo.editor.effectmanager.TasksManager();
                        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
                        fileDownloaderModel.setEffectType(9);
                        fileDownloaderModel.setName(animationEffectForm.getName());
                        fileDownloaderModel.setNameEn(animationEffectForm.getNameEn());
                        fileDownloaderModel.setId(animationEffectForm.getId());
                        fileDownloaderModel.setPreviewpic(animationEffectForm.getPreviewImageUrl());
                        fileDownloaderModel.setIcon(animationEffectForm.getIconUrl());
                        fileDownloaderModel.setPreviewmp4(animationEffectForm.getPreviewMediaUrl());
                        fileDownloaderModel.setSort(animationEffectForm.getSort());
                        fileDownloaderModel.setSubtype(animationEffectForm.getType());
                        fileDownloaderModel.setDownload(animationEffectForm.getResourceUrl());
                        fileDownloaderModel.setUrl(animationEffectForm.getResourceUrl());
                        fileDownloaderModel.setDuration(animationEffectForm.getDuration());
                        fileDownloaderModel.setIsunzip(1);
                        tasksManager.addTask(com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, fileDownloaderModel.getDownload()).getTaskId(), new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass4.AnonymousClass1());
                        tasksManager.startTask();
                        return;
                    }
                }
            }
            this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_ANIMATION_EFFECTS, "Not found");
        }
    }

    /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback<com.aliyun.svideo.base.Form.ResourceForm> {
        final /* synthetic */ com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback val$callback;
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ int val$groupId;
        final /* synthetic */ int val$id;

        /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$5$1, reason: invalid class name */
        public class AnonymousClass1 implements com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.PasterForm>> {
            final /* synthetic */ com.aliyun.svideo.base.Form.ResourceForm val$paster;

            /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$5$1$1, reason: invalid class name and collision with other inner class name */
            public class C00801 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
                final /* synthetic */ com.aliyun.svideo.downloader.FileDownloaderModel val$task;

                public C00801(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel) {
                    this.val$task = fileDownloaderModel;
                }

                @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
                public void onError(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
                    com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass5.this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_STICKER, th.getMessage());
                }

                @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
                public void onFinish(int i, java.lang.String str) {
                    com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().deleteTask(this.val$task.getTaskId());
                    com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass5.this.val$callback.onSuccess(str);
                }
            }

            public AnonymousClass1(com.aliyun.svideo.base.Form.ResourceForm resourceForm) {
                this.val$paster = resourceForm;
            }

            @Override // com.aliyun.svideo.base.http.HttpCallback
            public void onFailure(java.lang.Throwable th) {
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass5.this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_STICKER, th.getMessage());
            }

            @Override // com.aliyun.svideo.base.http.HttpCallback
            public void onSuccess(java.util.List<com.aliyun.svideo.base.Form.PasterForm> list) {
                if (list != null) {
                    for (com.aliyun.svideo.base.Form.PasterForm pasterForm : list) {
                        if (pasterForm.getId() == com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass5.this.val$id) {
                            com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
                            fileDownloaderModel.setEffectType(2);
                            fileDownloaderModel.setName(this.val$paster.getName());
                            fileDownloaderModel.setNameEn(this.val$paster.getNameEn());
                            fileDownloaderModel.setDescription(this.val$paster.getDescription());
                            fileDownloaderModel.setDescriptionEn(this.val$paster.getDescriptionEn());
                            fileDownloaderModel.setIcon(this.val$paster.getIcon());
                            fileDownloaderModel.setIsnew(this.val$paster.getIsNew());
                            fileDownloaderModel.setId(this.val$paster.getId());
                            fileDownloaderModel.setLevel(this.val$paster.getLevel());
                            fileDownloaderModel.setPreview(this.val$paster.getPreviewUrl());
                            fileDownloaderModel.setSort(this.val$paster.getSort());
                            fileDownloaderModel.setSubname(pasterForm.getName());
                            fileDownloaderModel.setSubicon(pasterForm.getIcon());
                            fileDownloaderModel.setSubid(pasterForm.getId());
                            fileDownloaderModel.setPriority(pasterForm.getPriority());
                            fileDownloaderModel.setUrl(pasterForm.getDownloadUrl());
                            fileDownloaderModel.setMd5(pasterForm.getMD5());
                            fileDownloaderModel.setSubpreview(pasterForm.getPreviewUrl());
                            fileDownloaderModel.setSubsort(pasterForm.getSort());
                            fileDownloaderModel.setSubtype(pasterForm.getType());
                            fileDownloaderModel.setIsunzip(1);
                            com.aliyun.svideo.downloader.FileDownloaderModel addTask = com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, fileDownloaderModel.getUrl());
                            com.aliyun.svideo.editor.effectmanager.TasksManager tasksManager = new com.aliyun.svideo.editor.effectmanager.TasksManager();
                            tasksManager.addTask(addTask.getTaskId(), new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass5.AnonymousClass1.C00801(addTask));
                            tasksManager.startTask();
                            return;
                        }
                    }
                }
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass5.this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_STICKER, "Not found");
            }
        }

        public AnonymousClass5(int i, android.content.Context context, int i2, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
            this.val$groupId = i;
            this.val$context = context;
            this.val$id = i2;
            this.val$callback = loadCallback;
        }

        @Override // com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback
        public void onLoadCompleted(java.util.List<com.aliyun.svideo.base.Form.ResourceForm> list, java.util.List<com.aliyun.svideo.base.Form.ResourceForm> list2, java.lang.Throwable th) {
            if (list2 != null) {
                for (com.aliyun.svideo.base.Form.ResourceForm resourceForm : list2) {
                    if (resourceForm.getId() == this.val$groupId) {
                        new com.aliyun.svideo.base.http.EffectService().getPasterListById(this.val$context.getPackageName(), this.val$groupId, new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass5.AnonymousClass1(resourceForm));
                        return;
                    }
                }
            }
            this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_STICKER, "Not found");
        }
    }

    /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$6, reason: invalid class name */
    public class AnonymousClass6 implements com.aliyun.svideo.editor.effectmanager.CaptionLoader.LoadCallback {
        final /* synthetic */ com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback val$callback;
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ int val$groupId;
        final /* synthetic */ int val$id;

        /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$6$1, reason: invalid class name */
        public class AnonymousClass1 implements com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.PasterForm>> {
            final /* synthetic */ com.aliyun.svideo.base.Form.ResourceForm val$caption;

            /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$6$1$1, reason: invalid class name and collision with other inner class name */
            public class C00811 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
                final /* synthetic */ com.aliyun.svideo.downloader.FileDownloaderModel val$task;

                public C00811(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel) {
                    this.val$task = fileDownloaderModel;
                }

                @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
                public void onError(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
                    com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass6.this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_BUBBLE, th.getMessage());
                }

                @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
                public void onFinish(int i, java.lang.String str) {
                    com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().deleteTask(this.val$task.getTaskId());
                    com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass6.this.val$callback.onSuccess(str);
                }
            }

            public AnonymousClass1(com.aliyun.svideo.base.Form.ResourceForm resourceForm) {
                this.val$caption = resourceForm;
            }

            @Override // com.aliyun.svideo.base.http.HttpCallback
            public void onFailure(java.lang.Throwable th) {
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass6.this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_BUBBLE, th.getMessage());
            }

            @Override // com.aliyun.svideo.base.http.HttpCallback
            public void onSuccess(java.util.List<com.aliyun.svideo.base.Form.PasterForm> list) {
                if (list != null) {
                    for (com.aliyun.svideo.base.Form.PasterForm pasterForm : list) {
                        if (pasterForm.getId() == com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass6.this.val$id) {
                            com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
                            fileDownloaderModel.setEffectType(6);
                            fileDownloaderModel.setName(this.val$caption.getName());
                            fileDownloaderModel.setNameEn(this.val$caption.getNameEn());
                            fileDownloaderModel.setDescription(this.val$caption.getDescription());
                            fileDownloaderModel.setDescriptionEn(this.val$caption.getDescriptionEn());
                            fileDownloaderModel.setIcon(this.val$caption.getIcon());
                            fileDownloaderModel.setIsnew(this.val$caption.getIsNew());
                            fileDownloaderModel.setId(this.val$caption.getId());
                            fileDownloaderModel.setLevel(this.val$caption.getLevel());
                            fileDownloaderModel.setPreview(this.val$caption.getPreviewUrl());
                            fileDownloaderModel.setSort(this.val$caption.getSort());
                            fileDownloaderModel.setSubname(pasterForm.getName());
                            fileDownloaderModel.setSubicon(pasterForm.getIcon());
                            fileDownloaderModel.setSubid(pasterForm.getId());
                            fileDownloaderModel.setUrl(pasterForm.getDownloadUrl());
                            fileDownloaderModel.setMd5(pasterForm.getMD5());
                            fileDownloaderModel.setSubpreview(pasterForm.getPreviewUrl());
                            fileDownloaderModel.setSubsort(pasterForm.getSort());
                            fileDownloaderModel.setSubtype(pasterForm.getType());
                            fileDownloaderModel.setFontid(pasterForm.getFontId());
                            fileDownloaderModel.setIsunzip(1);
                            com.aliyun.svideo.downloader.FileDownloaderModel addTask = com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, fileDownloaderModel.getUrl());
                            com.aliyun.svideo.editor.effectmanager.TasksManager tasksManager = new com.aliyun.svideo.editor.effectmanager.TasksManager();
                            tasksManager.addTask(addTask.getTaskId(), new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass6.AnonymousClass1.C00811(addTask));
                            tasksManager.startTask();
                            return;
                        }
                    }
                }
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass6.this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_BUBBLE, "Not found");
            }
        }

        public AnonymousClass6(int i, android.content.Context context, int i2, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
            this.val$groupId = i;
            this.val$context = context;
            this.val$id = i2;
            this.val$callback = loadCallback;
        }

        @Override // com.aliyun.svideo.editor.effectmanager.CaptionLoader.LoadCallback
        public void onLoadCompleted(java.util.List<com.aliyun.svideo.base.Form.ResourceForm> list, java.util.List<com.aliyun.svideo.base.Form.ResourceForm> list2, java.lang.Throwable th) {
            if (list2 != null) {
                for (com.aliyun.svideo.base.Form.ResourceForm resourceForm : list2) {
                    if (resourceForm.getId() == this.val$groupId) {
                        new com.aliyun.svideo.base.http.EffectService().getCaptionListById(this.val$context.getPackageName(), resourceForm.getId(), new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass6.AnonymousClass1(resourceForm));
                        return;
                    }
                }
            }
            this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_BUBBLE, "Not found");
        }
    }

    /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$7, reason: invalid class name */
    public class AnonymousClass7 implements com.aliyun.svideo.base.http.HttpCallback<com.aliyun.svideo.base.Form.FontForm> {
        final /* synthetic */ com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback val$callback;

        /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$7$1, reason: invalid class name */
        public class AnonymousClass1 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
            public AnonymousClass1() {
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onError(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass7.this.val$callback.onFailure("font", th.getMessage());
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onFinish(int i, java.lang.String str) {
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass7.this.val$callback.onSuccess(str + java.io.File.separator + "font.ttf");
            }
        }

        public AnonymousClass7(com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
            this.val$callback = loadCallback;
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onFailure(java.lang.Throwable th) {
            this.val$callback.onFailure("font", th.getMessage());
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onSuccess(com.aliyun.svideo.base.Form.FontForm fontForm) {
            if (fontForm == null) {
                this.val$callback.onFailure("font", "Not found");
                return;
            }
            com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
            fileDownloaderModel.setEffectType(1);
            fileDownloaderModel.setName(fontForm.getName());
            fileDownloaderModel.setIcon(fontForm.getIcon());
            fileDownloaderModel.setId(fontForm.getId());
            fileDownloaderModel.setLevel(fontForm.getLevel());
            fileDownloaderModel.setSort(fontForm.getSort());
            fileDownloaderModel.setUrl(fontForm.getUrl());
            fileDownloaderModel.setMd5(fontForm.getMd5());
            fileDownloaderModel.setBanner(fontForm.getBanner());
            fileDownloaderModel.setIsunzip(1);
            com.aliyun.svideo.downloader.FileDownloaderModel addTask = com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, fileDownloaderModel.getUrl());
            com.aliyun.svideo.editor.effectmanager.TasksManager tasksManager = new com.aliyun.svideo.editor.effectmanager.TasksManager();
            tasksManager.addTask(addTask.getTaskId(), new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass7.AnonymousClass1());
            tasksManager.startTask();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$8, reason: invalid class name */
    public class AnonymousClass8 implements com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback<com.aliyun.svideo.base.Form.IMVForm> {
        final /* synthetic */ com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback val$callback;
        final /* synthetic */ int val$groupId;
        final /* synthetic */ java.lang.String val$id;

        /* renamed from: com.aliyun.svideo.editor.util.AlivcResUtil$8$1, reason: invalid class name */
        public class AnonymousClass1 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
            public AnonymousClass1() {
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onError(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass8.this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_MV, th.getMessage());
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onFinish(int i, java.lang.String str) {
                com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass8.this.val$callback.onSuccess(new java.io.File(new java.io.File(str).getParentFile(), com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass8.this.val$id).getAbsolutePath());
            }
        }

        public AnonymousClass8(int i, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback, java.lang.String str) {
            this.val$groupId = i;
            this.val$callback = loadCallback;
            this.val$id = str;
        }

        @Override // com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback
        public void onLoadCompleted(java.util.List<com.aliyun.svideo.base.Form.IMVForm> list, java.util.List<com.aliyun.svideo.base.Form.IMVForm> list2, java.lang.Throwable th) {
            if (list2 != null) {
                for (com.aliyun.svideo.base.Form.IMVForm iMVForm : list2) {
                    if (this.val$groupId == iMVForm.getId()) {
                        com.aliyun.svideo.editor.effectmanager.TasksManager tasksManager = new com.aliyun.svideo.editor.effectmanager.TasksManager();
                        java.util.List<com.aliyun.svideo.base.Form.AspectForm> aspectList = iMVForm.getAspectList();
                        if (aspectList != null) {
                            com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass8.AnonymousClass1 anonymousClass1 = new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass8.AnonymousClass1();
                            for (com.aliyun.svideo.base.Form.AspectForm aspectForm : aspectList) {
                                com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
                                fileDownloaderModel.setEffectType(3);
                                fileDownloaderModel.setTag(iMVForm.getTag());
                                fileDownloaderModel.setKey(iMVForm.getKey());
                                fileDownloaderModel.setName(iMVForm.getName());
                                fileDownloaderModel.setNameEn(iMVForm.getNameEn());
                                fileDownloaderModel.setId(iMVForm.getId());
                                fileDownloaderModel.setCat(iMVForm.getCat());
                                fileDownloaderModel.setLevel(iMVForm.getLevel());
                                fileDownloaderModel.setPreviewpic(iMVForm.getPreviewPic());
                                fileDownloaderModel.setIcon(iMVForm.getIcon());
                                fileDownloaderModel.setPreviewmp4(iMVForm.getPreviewMp4());
                                fileDownloaderModel.setSort(iMVForm.getSort());
                                fileDownloaderModel.setSubtype(iMVForm.getType());
                                fileDownloaderModel.setMd5(aspectForm.getMd5());
                                fileDownloaderModel.setDownload(aspectForm.getDownload());
                                fileDownloaderModel.setUrl(aspectForm.getDownload());
                                fileDownloaderModel.setAspect(aspectForm.getAspect());
                                fileDownloaderModel.setDuration(iMVForm.getDuration());
                                fileDownloaderModel.setIsunzip(1);
                                tasksManager.addTask(com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, fileDownloaderModel.getDownload()).getTaskId(), anonymousClass1);
                            }
                            tasksManager.startTask();
                            return;
                        }
                    }
                }
            }
            this.val$callback.onFailure(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_MV, "Not found");
        }
    }

    public interface LoadCallback {
        void onFailure(java.lang.String str, java.lang.String str2);

        void onSuccess(java.lang.String str);
    }

    public static void downloadRes(java.lang.String str, java.lang.String str2, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
        com.aliyun.common.qupaiokhttp.HttpRequest.download(str, new java.io.File(str2), new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass1(loadCallback, str2));
    }

    public static java.lang.String getAppResUri(java.lang.String str, java.lang.String str2) {
        return getResUri("app", str, str2);
    }

    public static java.lang.String getAppResUri(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return getResUri("app", str, str2, str3);
    }

    public static java.lang.String getCloudResUri(java.lang.String str, java.lang.String str2) {
        return getResUri(HOST_CLOUD, str, str2);
    }

    public static java.lang.String getCloudResUri(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return getResUri(HOST_CLOUD, str, str2, str3);
    }

    private static java.lang.String getLocalPath(int i, int i2, int i3) {
        for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel : com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(i)) {
            if (i2 == -1) {
                if (fileDownloaderModel.getId() == i3) {
                    return fileDownloaderModel.getPath();
                }
            } else if (i2 == fileDownloaderModel.getId() && fileDownloaderModel.getSubid() == i3) {
                return fileDownloaderModel.getPath();
            }
        }
        return null;
    }

    public static java.lang.String getRelationResUri(java.lang.String str) {
        try {
            str = java.net.URLEncoder.encode(str, "utf-8");
        } catch (java.lang.Exception unused) {
        }
        return java.lang.String.format("alivc_resource://%s?path=%s", HOST_RELATION, str);
    }

    public static java.lang.String getResUri(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            str3 = java.net.URLEncoder.encode(str3, "utf-8");
        } catch (java.lang.Exception unused) {
        }
        return java.lang.String.format("alivc_resource://%s?type=%s&id=%s", str, str2, str3);
    }

    public static java.lang.String getResUri(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        try {
            str3 = java.net.URLEncoder.encode(str3, "utf-8");
            str4 = java.net.URLEncoder.encode(str4, "utf-8");
        } catch (java.lang.Exception unused) {
        }
        return java.lang.String.format("alivc_resource://%s?type=%s&gid=%s&id=%s", str, str2, str3, str4);
    }

    public static void loadAnimationFilter(android.content.Context context, int i, java.lang.String str, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
        java.lang.String str2;
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderModel> it = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(9).iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            com.aliyun.svideo.downloader.FileDownloaderModel next = it.next();
            if (next.getId() == i && new java.io.File(next.getPath()).exists()) {
                str2 = next.getPath() + java.io.File.separator + str;
                break;
            }
        }
        if (com.aliyun.common.utils.StringUtils.isEmpty(str2)) {
            new com.aliyun.svideo.editor.effectmanager.EffectLoader().loadAllAnimationFilter(context, new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass4(i, loadCallback, str));
        } else {
            loadCallback.onSuccess(str2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void loadAppRes(android.net.Uri uri, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
        char c;
        java.lang.String localPath;
        java.lang.String queryParameter = uri.getQueryParameter("type");
        java.lang.String queryParameter2 = uri.getQueryParameter("gid");
        java.lang.String queryParameter3 = uri.getQueryParameter("id");
        queryParameter.hashCode();
        switch (queryParameter.hashCode()) {
            case -1890252483:
                if (queryParameter.equals(TYPE_STICKER)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1378241396:
                if (queryParameter.equals(TYPE_BUBBLE)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1274492040:
                if (queryParameter.equals("filter")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3497:
                if (queryParameter.equals(TYPE_MV)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 552573414:
                if (queryParameter.equals(TYPE_CAPTION)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 837384007:
                if (queryParameter.equals(TYPE_ANIMATION_EFFECTS)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 969118252:
                if (queryParameter.equals(TYPE_LUT)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                localPath = getLocalPath(2, java.lang.Integer.parseInt(queryParameter2), java.lang.Integer.parseInt(queryParameter3));
                break;
            case 1:
                localPath = getLocalPath(6, java.lang.Integer.parseInt(queryParameter2), java.lang.Integer.parseInt(queryParameter3));
                break;
            case 2:
                localPath = new java.io.File(com.aliyun.svideo.editor.util.EditorCommon.SD_DIR + com.aliyun.svideo.editor.util.EditorCommon.QU_NAME + java.io.File.separator + com.aliyun.svideo.editor.util.EditorCommon.QU_COLOR_FILTER, queryParameter3).getAbsolutePath();
                break;
            case 3:
                java.lang.String localPath2 = getLocalPath(3, -1, java.lang.Integer.parseInt(queryParameter2));
                try {
                    localPath = localPath2.substring(0, localPath2.lastIndexOf(java.io.File.separator) + 1) + queryParameter3;
                    break;
                } catch (java.lang.Exception unused) {
                    localPath = localPath2;
                    break;
                }
            case 4:
                localPath = new java.io.File(com.aliyun.svideo.editor.util.EditorCommon.SD_DIR + com.aliyun.svideo.editor.contant.CaptionConfig.COOL_TEXT_FILE_DIR, queryParameter3).getAbsolutePath();
                break;
            case 5:
                localPath = new java.io.File(com.aliyun.svideo.editor.util.EditorCommon.SD_DIR + com.aliyun.svideo.editor.util.EditorCommon.QU_NAME + java.io.File.separator + (java.lang.String.valueOf(0).equals(queryParameter2) ? com.aliyun.svideo.editor.util.EditorCommon.QU_ANIMATION_FILTER : java.lang.String.valueOf(1).equals(queryParameter2) ? com.aliyun.svideo.editor.util.EditorCommon.QU_ANIMATION_SPLIT_SCREEN_FILTER : ""), queryParameter3).getAbsolutePath();
                break;
            case 6:
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.aliyun.svideo.editor.util.EditorCommon.SD_DIR);
                sb.append(com.aliyun.svideo.editor.contant.EditorConstants.LUT_FILE_DIR);
                java.lang.String str = java.io.File.separator;
                sb.append(str);
                sb.append("default");
                sb.append(str);
                sb.append(queryParameter3);
                sb.append(str);
                sb.append("lookup.png");
                localPath = new java.io.File(sb.toString()).getAbsolutePath();
                break;
            default:
                localPath = null;
                break;
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("loadAppRes>");
        sb2.append(localPath);
        if (com.aliyun.common.utils.StringUtils.isEmpty(localPath)) {
            loadCallback.onFailure(queryParameter, "Not found");
        } else {
            loadCallback.onSuccess(localPath);
        }
    }

    public static void loadBubble(android.content.Context context, int i, int i2, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
        java.lang.String str;
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderModel> it = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(6).iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            com.aliyun.svideo.downloader.FileDownloaderModel next = it.next();
            if (next.getId() == i && next.getSubid() == i2 && new java.io.File(next.getPath()).exists()) {
                str = next.getPath();
                break;
            }
        }
        if (com.aliyun.common.utils.StringUtils.isEmpty(str)) {
            new com.aliyun.svideo.editor.effectmanager.CaptionLoader().loadAllCaption(context, new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass6(i, context, i2, loadCallback));
        } else {
            loadCallback.onSuccess(str);
        }
    }

    public static void loadCloudRes(android.content.Context context, android.net.Uri uri, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
        java.lang.String queryParameter;
        java.lang.String queryParameter2;
        java.lang.String queryParameter3 = uri.getQueryParameter("type");
        queryParameter = uri.getQueryParameter("gid");
        queryParameter2 = uri.getQueryParameter("id");
        queryParameter3.hashCode();
        switch (queryParameter3) {
            case "sticker":
                loadSticker(context, java.lang.Integer.parseInt(queryParameter), java.lang.Integer.parseInt(queryParameter2), loadCallback);
                break;
            case "transition":
                loadTransition(context, java.lang.Integer.parseInt(queryParameter), queryParameter2, loadCallback);
                break;
            case "bubble":
                loadBubble(context, java.lang.Integer.parseInt(queryParameter), java.lang.Integer.parseInt(queryParameter2), loadCallback);
                break;
            case "mv":
                loadMv(context, java.lang.Integer.parseInt(queryParameter), queryParameter2, loadCallback);
                break;
            case "font":
                loadFont(context, java.lang.Integer.parseInt(queryParameter2), loadCallback);
                break;
            case "music":
                loadMusicRes(context, queryParameter2, uri.getQueryParameter("name"), loadCallback);
                break;
            case "animation_effects":
                loadAnimationFilter(context, java.lang.Integer.parseInt(queryParameter), queryParameter2, loadCallback);
                break;
            default:
                loadCallback.onFailure(null, "Type not found");
                break;
        }
    }

    public static void loadFont(android.content.Context context, int i, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
        java.lang.String str;
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderModel> it = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(1).iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            com.aliyun.svideo.downloader.FileDownloaderModel next = it.next();
            if (next.getId() == i && new java.io.File(next.getPath()).exists()) {
                str = next.getPath() + java.io.File.separator + "font.ttf";
                break;
            }
        }
        if (com.aliyun.common.utils.StringUtils.isEmpty(str)) {
            new com.aliyun.svideo.base.http.EffectService().getFontById(context.getPackageName(), i, new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass7(loadCallback));
        } else {
            loadCallback.onSuccess(str);
        }
    }

    public static void loadMusicRes(android.content.Context context, java.lang.String str, java.lang.String str2, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
        java.lang.String str3;
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderModel> it = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(5).iterator();
        while (true) {
            if (!it.hasNext()) {
                str3 = null;
                break;
            }
            com.aliyun.svideo.downloader.FileDownloaderModel next = it.next();
            if (str.equals(next.getDownload()) && new java.io.File(next.getPath()).exists()) {
                str3 = next.getPath();
                break;
            }
        }
        if (com.aliyun.common.utils.StringUtils.isEmpty(str3)) {
            new com.aliyun.svideo.base.http.EffectService().getMusicDownloadUrlById(context.getPackageName(), str, new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass2(context, str2, loadCallback));
        } else {
            loadCallback.onSuccess(str3);
        }
    }

    public static void loadMv(android.content.Context context, int i, java.lang.String str, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
        java.lang.String str2;
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderModel> it = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(3).iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            com.aliyun.svideo.downloader.FileDownloaderModel next = it.next();
            if (next.getId() == i && new java.io.File(next.getPath(), str).exists()) {
                str2 = next.getPath() + java.io.File.separator + str;
                break;
            }
        }
        if (com.aliyun.common.utils.StringUtils.isEmpty(str2)) {
            new com.aliyun.svideo.editor.effectmanager.EffectLoader().loadAllMV(context, new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass8(i, loadCallback, str));
        } else {
            loadCallback.onSuccess(str2);
        }
    }

    public static void loadRes(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
        loadRes(context, str, null, loadCallback);
    }

    public static void loadRes(android.content.Context context, java.lang.String str, java.lang.String str2, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
        if (loadCallback == null) {
            return;
        }
        android.net.Uri parse = android.net.Uri.parse(str);
        if ("app".equals(parse.getHost())) {
            loadAppRes(parse, loadCallback);
        } else if (HOST_CLOUD.equals(parse.getHost())) {
            loadCloudRes(context, parse, loadCallback);
        } else if (HOST_RELATION.equals(parse.getHost())) {
            if (com.aliyun.common.utils.StringUtils.isEmpty(str2)) {
                loadCallback.onFailure(null, "relation dir is null");
            } else {
                loadCallback.onSuccess(str2 + java.io.File.separator + parse.getQueryParameter("path"));
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("downloadDraft>resumeRes>");
        sb.append(parse.getScheme());
        sb.append(">");
        sb.append(parse.getHost());
        sb.append(">");
        sb.append(parse.getPath());
        sb.append(">");
        sb.append(parse.getQueryParameter("type"));
    }

    public static void loadSticker(android.content.Context context, int i, int i2, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
        java.lang.String str;
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderModel> it = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(2).iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            com.aliyun.svideo.downloader.FileDownloaderModel next = it.next();
            if (next.getId() == i && next.getSubid() == i2 && new java.io.File(next.getPath()).exists()) {
                str = next.getPath();
                break;
            }
        }
        if (com.aliyun.common.utils.StringUtils.isEmpty(str)) {
            new com.aliyun.svideo.editor.effectmanager.EffectLoader().loadAllPaster(context, new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass5(i, context, i2, loadCallback));
        } else {
            loadCallback.onSuccess(str);
        }
    }

    public static void loadTransition(android.content.Context context, int i, java.lang.String str, com.aliyun.svideo.editor.util.AlivcResUtil.LoadCallback loadCallback) {
        java.lang.String str2;
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderModel> it = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(10).iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            com.aliyun.svideo.downloader.FileDownloaderModel next = it.next();
            if (next.getId() == i && new java.io.File(next.getPath()).exists()) {
                str2 = next.getPath() + java.io.File.separator + str;
                break;
            }
        }
        if (com.aliyun.common.utils.StringUtils.isEmpty(str2)) {
            new com.aliyun.svideo.editor.effectmanager.EffectLoader().loadAllTransition(context, new com.aliyun.svideo.editor.util.AlivcResUtil.AnonymousClass3(i, str, loadCallback));
        } else {
            loadCallback.onSuccess(str2);
        }
    }
}
