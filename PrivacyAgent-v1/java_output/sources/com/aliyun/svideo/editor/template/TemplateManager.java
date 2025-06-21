package com.aliyun.svideo.editor.template;

/* loaded from: classes12.dex */
public class TemplateManager {
    public static final java.lang.String TEMPLATE_LIST_DIR = "svideo_res/template";
    private static volatile com.aliyun.svideo.editor.template.TemplateManager sManagerManager;
    private java.io.File mTemplateListDir;

    /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideo.editor.template.TemplateManager.TemplateListCallback val$callback;

        /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00761 implements java.lang.Runnable {
            final /* synthetic */ java.util.List val$dataList;

            public RunnableC00761(java.util.List list) {
                this.val$dataList = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass1.this.val$callback.onSuccess(this.val$dataList);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$1$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ java.lang.Exception val$e;

            public AnonymousClass2(java.lang.Exception exc) {
                this.val$e = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass1.this.val$callback.onFailure(this.val$e.getMessage());
            }
        }

        public AnonymousClass1(com.aliyun.svideo.editor.template.TemplateManager.TemplateListCallback templateListCallback) {
            this.val$callback = templateListCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.io.File[] listFiles = com.aliyun.svideo.editor.template.TemplateManager.this.getTemplateListDir().listFiles();
                if (listFiles != null) {
                    for (java.io.File file : listFiles) {
                        if (file.isDirectory()) {
                            java.io.File file2 = new java.io.File(file, com.aliyun.svideosdk.common.struct.template.AliyunTemplate.FILENAME);
                            if (file2.exists() && file2.isFile()) {
                                try {
                                    com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate = (com.aliyun.svideosdk.common.struct.template.AliyunTemplate) new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl().readValue(file2, com.aliyun.svideosdk.common.struct.template.AliyunTemplate.class);
                                    aliyunTemplate.setPath(file2.getPath());
                                    arrayList.add(aliyunTemplate);
                                } catch (java.lang.Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass1.RunnableC00761(arrayList));
            } catch (java.lang.Exception e2) {
                com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass1.AnonymousClass2(e2));
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideo.editor.template.TemplateManager.ExportCallback val$callback;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.template.AliyunTemplate val$template;

        /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.io.File val$zipFile;

            public AnonymousClass1(java.io.File file) {
                this.val$zipFile = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass2.this.val$callback.onSuccess(this.val$zipFile.getAbsolutePath());
            }
        }

        /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$2$2, reason: invalid class name and collision with other inner class name */
        public class RunnableC00772 implements java.lang.Runnable {
            final /* synthetic */ java.lang.Exception val$e;

            public RunnableC00772(java.lang.Exception exc) {
                this.val$e = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass2.this.val$callback.onFailure(this.val$e.getMessage());
            }
        }

        /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$2$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass2.this.val$callback.onFailure("The template file not exists");
            }
        }

        public AnonymousClass2(com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate, com.aliyun.svideo.editor.template.TemplateManager.ExportCallback exportCallback) {
            this.val$template = aliyunTemplate;
            this.val$callback = exportCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.io.File file = new java.io.File(this.val$template.getPath());
            java.io.File file2 = new java.io.File(android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS), "svideo_template_" + java.lang.System.currentTimeMillis() + ".zip");
            if (file.exists()) {
                try {
                    com.aliyun.svideo.editor.util.ZipUtils.zip(file.getParentFile().getPath(), file2.getPath());
                    if (file2.exists()) {
                        com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass2.AnonymousClass1(file2));
                        return;
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass2.RunnableC00772(e));
                    return;
                }
            }
            com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass2.AnonymousClass3());
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideo.editor.template.TemplateManager.ImportCallback val$callback;
        final /* synthetic */ java.io.File val$templateZip;

        /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass3.this.val$callback.onFailure("The template zip file not exists");
            }
        }

        /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$3$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ com.aliyun.svideosdk.common.struct.template.AliyunTemplate val$template;

            public AnonymousClass2(com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate) {
                this.val$template = aliyunTemplate;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass3.this.val$callback.onSuccess(this.val$template);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$3$3, reason: invalid class name and collision with other inner class name */
        public class RunnableC00783 implements java.lang.Runnable {
            public RunnableC00783() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass3.this.val$callback.onFailure("The template json not exists");
            }
        }

        /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$3$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ java.lang.Exception val$e;

            public AnonymousClass4(java.lang.Exception exc) {
                this.val$e = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass3.this.val$callback.onFailure(this.val$e.getMessage());
            }
        }

        public AnonymousClass3(java.io.File file, com.aliyun.svideo.editor.template.TemplateManager.ImportCallback importCallback) {
            this.val$templateZip = file;
            this.val$callback = importCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.io.File file = this.val$templateZip;
            if (file == null || !file.exists()) {
                com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass3.AnonymousClass1());
                return;
            }
            java.io.File file2 = new java.io.File(com.aliyun.svideo.editor.template.TemplateManager.this.getTemplateListDir(), java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
            try {
                com.aliyun.svideo.editor.util.ZipUtils.unZip(this.val$templateZip.getPath(), file2.getAbsolutePath());
                java.io.File file3 = new java.io.File(file2, com.aliyun.svideosdk.common.struct.template.AliyunTemplate.FILENAME);
                if (!file3.exists() || !file3.isFile()) {
                    com.aliyun.common.utils.FileUtils.deleteDirectory(file2);
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass3.RunnableC00783());
                    return;
                }
                com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl projectJSONSupportImpl = new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl();
                com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate = (com.aliyun.svideosdk.common.struct.template.AliyunTemplate) projectJSONSupportImpl.readValue(file3, com.aliyun.svideosdk.common.struct.template.AliyunTemplate.class);
                aliyunTemplate.setPath(file3.getAbsolutePath());
                aliyunTemplate.getProject().setPath(new java.io.File(file2, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.PROJECT_FILENAME).getAbsolutePath());
                projectJSONSupportImpl.writeValue(file3, (java.io.File) aliyunTemplate);
                com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass3.AnonymousClass2(aliyunTemplate));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.aliyun.common.utils.FileUtils.deleteDirectory(file2);
                com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass3.AnonymousClass4(e));
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideo.editor.template.TemplateSourceHandleCallback val$callback;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.template.AliyunTemplate val$template;

        /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass4.this.val$callback.onFailure("The template not exists");
            }
        }

        /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$4$2, reason: invalid class name */
        public class AnonymousClass2 implements com.aliyun.svideo.editor.template.TemplateResTask.HandleCallback {
            final /* synthetic */ java.util.List val$list;

            /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$4$2$1, reason: invalid class name */
            public class AnonymousClass1 implements java.lang.Runnable {
                final /* synthetic */ java.lang.Exception val$e;

                public AnonymousClass1(java.lang.Exception exc) {
                    this.val$e = exc;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass4.this.val$callback.onFailure(this.val$e.getMessage());
                }
            }

            /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$4$2$2, reason: invalid class name and collision with other inner class name */
            public class RunnableC00792 implements java.lang.Runnable {
                public RunnableC00792() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass4.this.val$callback.onSuccess();
                }
            }

            public AnonymousClass2(java.util.List list) {
                this.val$list = list;
            }

            @Override // com.aliyun.svideo.editor.template.TemplateResTask.HandleCallback
            public void onCallback(com.aliyun.svideo.editor.template.TemplateResTask templateResTask) {
                if (templateResTask != null) {
                    this.val$list.remove(templateResTask);
                }
                if (this.val$list.isEmpty()) {
                    try {
                        new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl().writeValue(new java.io.File(com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass4.this.val$template.getPath()), (java.io.File) com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass4.this.val$template);
                        com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass4.AnonymousClass2.RunnableC00792());
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass4.AnonymousClass2.AnonymousClass1(e));
                    }
                }
            }
        }

        /* renamed from: com.aliyun.svideo.editor.template.TemplateManager$4$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ java.lang.Exception val$e;

            public AnonymousClass3(java.lang.Exception exc) {
                this.val$e = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass4.this.val$callback.onFailure(this.val$e.getMessage());
            }
        }

        public AnonymousClass4(com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate, com.aliyun.svideo.editor.template.TemplateSourceHandleCallback templateSourceHandleCallback) {
            this.val$template = aliyunTemplate;
            this.val$callback = templateSourceHandleCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$template == null) {
                com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass4.AnonymousClass1());
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass4.AnonymousClass2 anonymousClass2 = new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass4.AnonymousClass2(arrayList);
            arrayList.add(new com.aliyun.svideo.editor.template.TemplateResTask(com.aliyun.svideo.editor.template.TemplateResTask.TemplateResType.Cover, this.val$template.getCover(), anonymousClass2));
            arrayList.add(new com.aliyun.svideo.editor.template.TemplateResTask(com.aliyun.svideo.editor.template.TemplateResTask.TemplateResType.Video, this.val$template.getVideo(), anonymousClass2));
            arrayList.add(new com.aliyun.svideo.editor.template.TemplateResTask(com.aliyun.svideo.editor.template.TemplateResTask.TemplateResType.Project, this.val$template.getProject(), anonymousClass2));
            try {
                this.val$callback.onHandleResourceTasks(new java.io.File(this.val$template.getPath()).getParentFile().getAbsolutePath(), new java.util.ArrayList(arrayList));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass4.AnonymousClass3(e));
            }
        }
    }

    public interface ExportCallback {
        void onFailure(java.lang.String str);

        void onSuccess(java.lang.String str);
    }

    public interface ImportCallback {
        void onFailure(java.lang.String str);

        void onSuccess(com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate);
    }

    public interface TemplateListCallback {
        void onFailure(java.lang.String str);

        void onSuccess(java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplate> list);
    }

    private TemplateManager(java.io.File file) {
        this.mTemplateListDir = file;
    }

    public static com.aliyun.svideo.editor.template.TemplateManager getInstance(android.content.Context context) {
        if (sManagerManager == null) {
            synchronized (com.aliyun.svideosdk.editor.draft.AliyunDraftManager.class) {
                if (sManagerManager == null) {
                    java.io.File file = new java.io.File(context.getExternalFilesDir(null).getAbsolutePath() + java.io.File.separator + TEMPLATE_LIST_DIR);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    sManagerManager = new com.aliyun.svideo.editor.template.TemplateManager(file);
                }
            }
        }
        return sManagerManager;
    }

    public void exportTemplateZip(com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate, com.aliyun.svideo.editor.template.TemplateManager.ExportCallback exportCallback) {
        com.aliyun.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass2(aliyunTemplate, exportCallback));
    }

    public void getTemplateListByAsync(com.aliyun.svideo.editor.template.TemplateManager.TemplateListCallback templateListCallback) {
        if (templateListCallback == null) {
            return;
        }
        com.aliyun.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass1(templateListCallback));
    }

    public java.io.File getTemplateListDir() {
        return this.mTemplateListDir;
    }

    public void importTemplateZip(java.io.File file, com.aliyun.svideo.editor.template.TemplateManager.ImportCallback importCallback) {
        com.aliyun.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass3(file, importCallback));
    }

    public void loadTemplateSource(com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate, com.aliyun.svideo.editor.template.TemplateSourceHandleCallback templateSourceHandleCallback) {
        com.aliyun.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.template.TemplateManager.AnonymousClass4(aliyunTemplate, templateSourceHandleCallback));
    }
}
