package com.aliyun.svideosdk.editor.template;

/* loaded from: classes12.dex */
public class a extends com.aliyun.svideosdk.editor.template.c implements com.aliyun.svideosdk.editor.template.AliyunTemplateBuilder {

    /* renamed from: com.aliyun.svideosdk.editor.template.a$a, reason: collision with other inner class name */
    public class RunnableC0097a implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.Source b;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.Source c;
        final /* synthetic */ java.util.List d;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.Source e;
        final /* synthetic */ java.io.File f;
        final /* synthetic */ com.aliyun.svideosdk.editor.template.AliyunTemplateSourceHandleCallback g;

        /* renamed from: com.aliyun.svideosdk.editor.template.a$a$a, reason: collision with other inner class name */
        public class RunnableC0098a implements java.lang.Runnable {
            public RunnableC0098a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.template.a.RunnableC0097a.this.g.onFailure("Template project file does not exist!");
            }
        }

        /* renamed from: com.aliyun.svideosdk.editor.template.a$a$b */
        public class b implements java.lang.Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.template.a.RunnableC0097a.this.g.onFailure("draft config Parsing failed.");
            }
        }

        /* renamed from: com.aliyun.svideosdk.editor.template.a$a$c */
        public class c implements com.aliyun.svideosdk.editor.resource.AliyunResTask.a {
            final /* synthetic */ java.util.List a;
            final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject b;
            final /* synthetic */ java.io.File c;

            /* renamed from: com.aliyun.svideosdk.editor.template.a$a$c$a, reason: collision with other inner class name */
            public class RunnableC0099a implements java.lang.Runnable {
                public RunnableC0099a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.aliyun.svideosdk.editor.template.a.RunnableC0097a.this.g.onSuccess();
                }
            }

            public c(java.util.List list, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, java.io.File file) {
                this.a = list;
                this.b = aliyunEditorProject;
                this.c = file;
            }

            @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask.a
            public void a(com.aliyun.svideosdk.editor.resource.AliyunResTask aliyunResTask) {
                if (aliyunResTask != null) {
                    this.a.remove(aliyunResTask);
                }
                if (this.a.isEmpty()) {
                    this.b.setCreationTime(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.DATE_FORMAT.format(new java.util.Date()));
                    com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.b;
                    aliyunEditorProject.setModifiedTime(aliyunEditorProject.getCreationTime());
                    this.b.setTemplate(new com.aliyun.svideosdk.common.struct.project.Source(this.c.getAbsolutePath()));
                    com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject2 = this.b;
                    com.aliyun.svideosdk.common.struct.project.ProjectUtil.writeProject(aliyunEditorProject2, aliyunEditorProject2.getProjectFile(), new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl(), false);
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.template.a.RunnableC0097a.c.RunnableC0099a());
                }
            }
        }

        /* renamed from: com.aliyun.svideosdk.editor.template.a$a$d */
        public class d implements java.lang.Runnable {
            final /* synthetic */ java.lang.Exception a;

            public d(java.lang.Exception exc) {
                this.a = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.template.a.RunnableC0097a.this.g.onFailure(this.a.getMessage());
            }
        }

        public RunnableC0097a(java.lang.String str, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.common.struct.project.Source source2, java.util.List list, com.aliyun.svideosdk.common.struct.project.Source source3, java.io.File file, com.aliyun.svideosdk.editor.template.AliyunTemplateSourceHandleCallback aliyunTemplateSourceHandleCallback) {
            this.a = str;
            this.b = source;
            this.c = source2;
            this.d = list;
            this.e = source3;
            this.f = file;
            this.g = aliyunTemplateSourceHandleCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate = new com.aliyun.svideosdk.common.struct.template.AliyunTemplate();
                aliyunTemplate.setTemplateId(java.util.UUID.randomUUID().toString());
                aliyunTemplate.setTitle(this.a);
                aliyunTemplate.setCover(this.b);
                aliyunTemplate.setVideo(this.c);
                aliyunTemplate.getParams().addAll(this.d);
                java.io.File file = new java.io.File(this.e.getPath());
                com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl projectJSONSupportImpl = new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl();
                projectJSONSupportImpl.writeValue(file, (java.io.File) com.aliyun.svideosdk.editor.template.a.this.getEditorProject());
                aliyunTemplate.setProject(this.e);
                java.io.File file2 = new java.io.File(this.f, com.aliyun.svideosdk.common.struct.template.AliyunTemplate.FILENAME);
                projectJSONSupportImpl.writeValue(file2, (java.io.File) aliyunTemplate);
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if (!file.exists()) {
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.template.a.RunnableC0097a.RunnableC0098a());
                    return;
                }
                com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject = com.aliyun.svideosdk.common.struct.project.ProjectUtil.readProject(file, new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl());
                if (readProject == null) {
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.template.a.RunnableC0097a.b());
                    return;
                }
                readProject.refreshTimeLine();
                com.aliyun.svideosdk.editor.template.a.RunnableC0097a.c cVar = new com.aliyun.svideosdk.editor.template.a.RunnableC0097a.c(arrayList, readProject, file2);
                com.aliyun.svideosdk.editor.template.a.this.a(readProject, arrayList, cVar);
                if (arrayList.isEmpty()) {
                    cVar.a(null);
                } else {
                    this.g.onHandleResourceTasks(this.f.getAbsolutePath(), new java.util.ArrayList(arrayList));
                }
            } catch (java.lang.Exception e) {
                com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.template.a.RunnableC0097a.d(e));
            }
        }
    }

    public a(android.net.Uri uri) {
        super(uri);
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplateBuilder
    public void build(java.io.File file, java.lang.String str, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.common.struct.project.Source source2, com.aliyun.svideosdk.common.struct.project.Source source3, java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> list, com.aliyun.svideosdk.editor.template.AliyunTemplateSourceHandleCallback aliyunTemplateSourceHandleCallback) {
        com.aliyun.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideosdk.editor.template.a.RunnableC0097a(str, source2, source, list, source3, file, aliyunTemplateSourceHandleCallback));
    }
}
