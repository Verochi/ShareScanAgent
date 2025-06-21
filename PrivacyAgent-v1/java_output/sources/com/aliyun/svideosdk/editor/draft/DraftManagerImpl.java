package com.aliyun.svideosdk.editor.draft;

@com.aliyun.Visible
/* loaded from: classes12.dex */
class DraftManagerImpl extends com.aliyun.svideosdk.editor.draft.AliyunDraftManager {
    private java.lang.String mDraftDir;

    public class a extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.PasterTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = aliyunEditorProject;
            this.b = pasterTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getPasterTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class b extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.RollCaptionTrack a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip b;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.RollCaptionTrack rollCaptionTrack, com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip rollCaptionTrackClip, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = rollCaptionTrack;
            this.b = rollCaptionTrackClip;
            this.c = aliyunEditorProject;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getRollCaptionTrackClips().remove(this.b);
            if (this.a.getRollCaptionTrackClips().isEmpty()) {
                this.c.getTimeline().getPasterTracks().remove(this.a);
            }
            onHandleCallback(null);
        }
    }

    public class c extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.GlobalTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.GlobalTrack globalTrack) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = aliyunEditorProject;
            this.b = globalTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getGlobalTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class d extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.GlobalTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.GlobalTrack globalTrack) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = aliyunEditorProject;
            this.b = globalTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getGlobalTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class e extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.EffectTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = aliyunEditorProject;
            this.b = effectTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getEffectTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class f extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.EffectTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = aliyunEditorProject;
            this.b = effectTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getEffectTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class g extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = aliyunEditorProject;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.setCover(null);
            onHandleCallback(null);
        }
    }

    public class h implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideosdk.editor.draft.AliyunDraft a;
        final /* synthetic */ com.aliyun.svideosdk.editor.draft.AliyunDraftResourceLoader b;

        public class a implements java.lang.Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.h.this.b.onFailure("Draft file does not exist!");
            }
        }

        public class b implements java.lang.Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.h.this.b.onFailure("draft config Parsing failed.");
            }
        }

        public class c implements com.aliyun.svideosdk.editor.resource.AliyunResTask.a {
            final /* synthetic */ java.util.List a;
            final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject b;

            public class a implements java.lang.Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.aliyun.svideosdk.editor.draft.DraftManagerImpl.h.this.b.onSuccess();
                }
            }

            public c(java.util.List list, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject) {
                this.a = list;
                this.b = aliyunEditorProject;
            }

            @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask.a
            public void a(com.aliyun.svideosdk.editor.resource.AliyunResTask aliyunResTask) {
                if (aliyunResTask != null) {
                    this.a.remove(aliyunResTask);
                }
                if (this.a.isEmpty()) {
                    this.b.refreshTimeLine();
                    com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.b;
                    com.aliyun.svideosdk.common.struct.project.ProjectUtil.writeProject(aliyunEditorProject, aliyunEditorProject.getProjectFile(), new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl(), false);
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.h.c.a());
                }
            }
        }

        public class d implements java.lang.Runnable {
            final /* synthetic */ java.lang.Exception a;

            public d(java.lang.Exception exc) {
                this.a = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.h.this.b.onFailure(this.a.getMessage());
            }
        }

        public h(com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, com.aliyun.svideosdk.editor.draft.AliyunDraftResourceLoader aliyunDraftResourceLoader) {
            this.a = aliyunDraft;
            this.b = aliyunDraftResourceLoader;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.io.File file = new java.io.File(this.a.getEditorProjectUri());
                if (!file.exists()) {
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.h.a());
                    return;
                }
                com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject = com.aliyun.svideosdk.common.struct.project.ProjectUtil.readProject(file, new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl());
                if (readProject == null) {
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.h.b());
                    return;
                }
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.h.c cVar = new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.h.c(arrayList, readProject);
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.this.buildTasks(readProject, arrayList, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload, cVar);
                if (arrayList.isEmpty()) {
                    cVar.a(null);
                    return;
                }
                try {
                    this.b.onHandleResourceTasks(new java.util.ArrayList(arrayList));
                } catch (java.lang.Exception e) {
                    this.b.onFailure(e.getMessage());
                }
            } catch (java.lang.Exception e2) {
                com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.h.d(e2));
            }
        }
    }

    public class i implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideosdk.editor.draft.AliyunDraft a;
        final /* synthetic */ com.aliyun.svideosdk.editor.draft.AliyunDraftResourceUploader b;

        public class a implements java.lang.Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i.this.b.onFailure("Draft file does not exist!");
            }
        }

        public class b implements java.lang.Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i.this.b.onFailure("draft config Parsing failed.");
            }
        }

        public class c implements com.aliyun.svideosdk.editor.resource.AliyunResTask.a {
            final /* synthetic */ java.util.List a;
            final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject b;

            public class a implements java.lang.Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i.c cVar = com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i.c.this;
                    com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i.this.b.onSuccess(cVar.b.getProjectFile().getPath(), com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i.c.this.b.getCover().getURL());
                }
            }

            public c(java.util.List list, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject) {
                this.a = list;
                this.b = aliyunEditorProject;
            }

            @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask.a
            public void a(com.aliyun.svideosdk.editor.resource.AliyunResTask aliyunResTask) {
                if (aliyunResTask != null) {
                    this.a.remove(aliyunResTask);
                }
                if (this.a.isEmpty()) {
                    this.b.refreshTimeLine();
                    com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.b;
                    com.aliyun.svideosdk.common.struct.project.ProjectUtil.writeProject(aliyunEditorProject, aliyunEditorProject.getProjectFile(), new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl(), false);
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i.c.a());
                }
            }
        }

        public class d implements java.lang.Runnable {
            final /* synthetic */ java.lang.Exception a;

            public d(java.lang.Exception exc) {
                this.a = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i.this.b.onFailure(this.a.getMessage());
            }
        }

        public i(com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, com.aliyun.svideosdk.editor.draft.AliyunDraftResourceUploader aliyunDraftResourceUploader) {
            this.a = aliyunDraft;
            this.b = aliyunDraftResourceUploader;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.io.File file = new java.io.File(this.a.getEditorProjectUri());
                if (!file.exists()) {
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i.a());
                    return;
                }
                com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject = com.aliyun.svideosdk.common.struct.project.ProjectUtil.readProject(file, new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl());
                if (readProject == null) {
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i.b());
                    return;
                }
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i.c cVar = new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i.c(arrayList, readProject);
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.this.buildTasks(readProject, arrayList, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.upload, cVar);
                if (arrayList.isEmpty()) {
                    cVar.a(null);
                } else {
                    this.b.onHandleResourceTasks(new java.util.ArrayList(arrayList));
                }
            } catch (java.lang.Exception e) {
                com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i.d(e));
            }
        }
    }

    public class j implements java.lang.Runnable {
        final /* synthetic */ java.io.File a;
        final /* synthetic */ com.aliyun.svideosdk.editor.draft.AliyunDraftResourceDownloader b;

        public class a implements java.lang.Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.j.this.b.onFailure("Draft file does not exist!");
            }
        }

        public class b implements java.lang.Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.j.this.b.onFailure("draft config Parsing failed.");
            }
        }

        public class c implements com.aliyun.svideosdk.editor.resource.AliyunResTask.a {
            final /* synthetic */ java.util.List a;
            final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject b;

            public class a implements java.lang.Runnable {
                final /* synthetic */ com.aliyun.svideosdk.editor.draft.AliyunDraft a;

                public a(com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft) {
                    this.a = aliyunDraft;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.aliyun.svideosdk.editor.draft.DraftManagerImpl.j.this.b.onSuccess(this.a);
                }
            }

            public c(java.util.List list, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject) {
                this.a = list;
                this.b = aliyunEditorProject;
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
                    com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject2 = this.b;
                    com.aliyun.svideosdk.common.struct.project.ProjectUtil.writeProject(aliyunEditorProject2, aliyunEditorProject2.getProjectFile(), new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl(), false);
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.j.c.a(com.aliyun.svideosdk.editor.draft.DraftManagerImpl.this.projectToDraft(this.b)));
                }
            }
        }

        public class d implements java.lang.Runnable {
            final /* synthetic */ java.lang.Exception a;

            public d(java.lang.Exception exc) {
                this.a = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.j.this.b.onFailure(this.a.getMessage());
            }
        }

        public j(java.io.File file, com.aliyun.svideosdk.editor.draft.AliyunDraftResourceDownloader aliyunDraftResourceDownloader) {
            this.a = file;
            this.b = aliyunDraftResourceDownloader;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.a.exists()) {
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.j.a());
                    return;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject = com.aliyun.svideosdk.common.struct.project.ProjectUtil.readProject(this.a, new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl());
                if (readProject == null) {
                    com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.j.b());
                    return;
                }
                readProject.refreshTimeLine();
                java.io.File newProjectDir = com.aliyun.svideosdk.common.struct.project.ProjectUtil.newProjectDir(com.aliyun.svideosdk.editor.draft.DraftManagerImpl.this.mDraftDir);
                readProject.setProjectDir(newProjectDir, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.getProjectFile(newProjectDir));
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.j.c cVar = new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.j.c(arrayList, readProject);
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.this.buildTasks(readProject, arrayList, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.download, cVar);
                if (arrayList.isEmpty()) {
                    cVar.a(null);
                } else {
                    this.b.onHandleResourceTasks(newProjectDir.getAbsolutePath(), new java.util.ArrayList(arrayList));
                }
            } catch (java.lang.Exception e) {
                com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.j.d(e));
            }
        }
    }

    public class k implements java.util.Comparator<com.aliyun.svideosdk.editor.draft.AliyunDraft> {
        public k(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft2) {
            if (aliyunDraft.getUpdateTime() < aliyunDraft2.getUpdateTime()) {
                return 1;
            }
            return aliyunDraft.getUpdateTime() == aliyunDraft2.getUpdateTime() ? 0 : -1;
        }
    }

    public class l implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideosdk.editor.draft.AliyunDraftListCallback a;

        public class a implements java.lang.Runnable {
            final /* synthetic */ java.util.List a;

            public a(java.util.List list) {
                this.a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.l.this.a.onSuccess(this.a);
            }
        }

        public class b implements java.lang.Runnable {
            final /* synthetic */ java.lang.Exception a;

            public b(java.lang.Exception exc) {
                this.a = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.editor.draft.DraftManagerImpl.l.this.a.onFailure(this.a.getMessage());
            }
        }

        public l(com.aliyun.svideosdk.editor.draft.AliyunDraftListCallback aliyunDraftListCallback) {
            this.a = aliyunDraftListCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.l.a(new java.util.ArrayList(com.aliyun.svideosdk.editor.draft.DraftManagerImpl.this.getDraftList())));
            } catch (java.lang.Exception e) {
                com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.l.b(e));
            }
        }
    }

    public static /* synthetic */ class m {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.values().length];
            a = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.filter.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.animation_filter.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.lut_filter.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public class n extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.VideoTrack a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.VideoTrackClip b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.VideoTrack videoTrack, com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = videoTrack;
            this.b = videoTrackClip;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getVideoTrackClips().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class o extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.VideoTrackClip a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.Effect b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip, com.aliyun.svideosdk.common.struct.project.Effect effect) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = videoTrackClip;
            this.b = effect;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getEffects().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class p extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AudioTrack a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AudioTrackClip b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.AudioTrack audioTrack, com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = audioTrack;
            this.b = audioTrackClip;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getAudioTrackClips().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class q extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.PasterTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = aliyunEditorProject;
            this.b = pasterTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getPasterTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class r extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.PasterTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = aliyunEditorProject;
            this.b = pasterTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getPasterTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class s extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.PasterTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = aliyunEditorProject;
            this.b = pasterTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getPasterTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class t extends com.aliyun.svideosdk.editor.draft.AliyunDraftResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.PasterTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(com.aliyun.svideosdk.editor.draft.DraftManagerImpl draftManagerImpl, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack) {
            super(aVar, aliyunResModuleType, aliyunResType, source, aVar2);
            this.a = aliyunEditorProject;
            this.b = pasterTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getPasterTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public DraftManagerImpl(java.lang.String str) {
        this.mDraftDir = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildTasks(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, java.util.List<com.aliyun.svideosdk.editor.draft.AliyunDraftResTask> list, com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2) {
        com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType;
        com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType;
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.VideoTrack> it;
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.VideoTrack> it2 = aliyunEditorProject.getTimeline().getVideoTracks().iterator();
        while (it2.hasNext()) {
            com.aliyun.svideosdk.common.struct.project.VideoTrack next = it2.next();
            for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : next.getVideoTrackClips()) {
                if (videoTrackClip.isFileExists() && aVar == com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload) {
                    it = it2;
                } else {
                    it = it2;
                    list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.n(this, aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.MAIN_VIDEO, videoTrackClip.getType() == 0 ? com.aliyun.svideosdk.editor.resource.AliyunResType.VIDEO : com.aliyun.svideosdk.editor.resource.AliyunResType.IMAGE, videoTrackClip.getSource(), aVar2, next, videoTrackClip));
                }
                java.util.Iterator<com.aliyun.svideosdk.common.struct.project.Effect> it3 = videoTrackClip.getEffects().iterator();
                while (it3.hasNext()) {
                    com.aliyun.svideosdk.common.struct.project.Effect next2 = it3.next();
                    if (next2.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.transition) {
                        com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase = (com.aliyun.svideosdk.common.struct.effect.TransitionBase) next2;
                        if (transitionBase.mType == 5 && (isFileNotExists(transitionBase.getCustomSource()) || aVar != com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload)) {
                            list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.o(this, aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.TRANSITION, com.aliyun.svideosdk.editor.resource.AliyunResType.CONFIG, transitionBase.getCustomSource(), aVar2, videoTrackClip, next2));
                            it3 = it3;
                        }
                    }
                }
                it2 = it;
            }
        }
        for (com.aliyun.svideosdk.common.struct.project.AudioTrack audioTrack : aliyunEditorProject.getTimeline().getAudioTracks()) {
            for (com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip : audioTrack.getAudioTrackClips()) {
                if (isFileNotExists(audioTrackClip.getSource()) || aVar != com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload) {
                    list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.p(this, aVar, audioTrackClip.getType() == com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type.Music ? com.aliyun.svideosdk.editor.resource.AliyunResModuleType.MUSIC_AUDIO : com.aliyun.svideosdk.editor.resource.AliyunResModuleType.DUBS_AUDIO, com.aliyun.svideosdk.editor.resource.AliyunResType.AUDIO, audioTrackClip.getSource(), aVar2, audioTrack, audioTrackClip));
                }
            }
        }
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.PasterTrack> it4 = aliyunEditorProject.getTimeline().getPasterTracks().iterator();
        while (it4.hasNext()) {
            com.aliyun.svideosdk.common.struct.project.PasterTrack next3 = it4.next();
            if (next3 instanceof com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) {
                com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack = (com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) next3;
                if (photoPasterTrack.getSource() != null && (isFileNotExists(photoPasterTrack.getSource()) || aVar != com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload)) {
                    if (next3.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.subtitle) {
                        aliyunResModuleType = com.aliyun.svideosdk.editor.resource.AliyunResModuleType.SUBTITLE_FONT;
                        aliyunResType = com.aliyun.svideosdk.editor.resource.AliyunResType.FONT;
                    } else {
                        if (next3.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.bubble_caption) {
                            aliyunResModuleType = com.aliyun.svideosdk.editor.resource.AliyunResModuleType.BUBBLE_STICKER;
                        } else if (next3.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.caption) {
                            aliyunResModuleType = com.aliyun.svideosdk.editor.resource.AliyunResModuleType.CAPTION;
                        } else if (next3.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.gif) {
                            aliyunResModuleType = com.aliyun.svideosdk.editor.resource.AliyunResModuleType.GIF_STICKER;
                        } else if (next3.getType() != com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.photo) {
                            break;
                        } else {
                            aliyunResModuleType = com.aliyun.svideosdk.editor.resource.AliyunResModuleType.IMAGE_STICKER;
                        }
                        aliyunResType = com.aliyun.svideosdk.editor.resource.AliyunResType.CONFIG;
                    }
                    com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType2 = aliyunResModuleType;
                    com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType2 = aliyunResType;
                    if (photoPasterTrack.getSource() != null) {
                        list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.q(this, aVar, aliyunResModuleType2, aliyunResType2, photoPasterTrack.getSource(), aVar2, aliyunEditorProject, next3));
                    }
                }
            }
            if (next3 instanceof com.aliyun.svideosdk.common.struct.project.SubTitleTrack) {
                com.aliyun.svideosdk.common.struct.project.SubTitleTrack subTitleTrack = (com.aliyun.svideosdk.common.struct.project.SubTitleTrack) next3;
                if (subTitleTrack.getFont() != null) {
                    list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.r(this, aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.SUBTITLE_FONT, com.aliyun.svideosdk.editor.resource.AliyunResType.FONT, subTitleTrack.getFont(), aVar2, aliyunEditorProject, next3));
                }
            }
            if (next3 instanceof com.aliyun.svideosdk.common.struct.project.CaptionTrack) {
                com.aliyun.svideosdk.common.struct.project.CaptionTrack captionTrack = (com.aliyun.svideosdk.common.struct.project.CaptionTrack) next3;
                if (captionTrack.getFont() != null && (isFileNotExists(captionTrack.getFont()) || aVar != com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload)) {
                    list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.s(this, aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.CAPTION_FONT, com.aliyun.svideosdk.editor.resource.AliyunResType.FONT, captionTrack.getFont(), aVar2, aliyunEditorProject, next3));
                }
                if (captionTrack.getFontEffectSource() != null && (isFileNotExists(captionTrack.getFontEffectSource()) || aVar != com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload)) {
                    list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.t(this, aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.CAPTION_EFFECT, com.aliyun.svideosdk.editor.resource.AliyunResType.CONFIG, captionTrack.getFontEffectSource(), aVar2, aliyunEditorProject, next3));
                }
            }
            if (next3 instanceof com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) {
                com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack bubbleCaptionTrack = (com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) next3;
                if (bubbleCaptionTrack.getFont() != null && (isFileNotExists(((com.aliyun.svideosdk.common.struct.project.SubTitleTrack) next3).getFont()) || aVar != com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload)) {
                    list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.a(this, aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.BUBBLE_FONT, com.aliyun.svideosdk.editor.resource.AliyunResType.FONT, bubbleCaptionTrack.getFont(), aVar2, aliyunEditorProject, next3));
                }
            }
            if (next3 instanceof com.aliyun.svideosdk.common.struct.project.RollCaptionTrack) {
                com.aliyun.svideosdk.common.struct.project.RollCaptionTrack rollCaptionTrack = (com.aliyun.svideosdk.common.struct.project.RollCaptionTrack) next3;
                for (com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip rollCaptionTrackClip : rollCaptionTrack.getRollCaptionTrackClips()) {
                    if (isFileNotExists(rollCaptionTrackClip.getFont()) || aVar != com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload) {
                        list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.b(this, aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.SUBTITLE_FONT, com.aliyun.svideosdk.editor.resource.AliyunResType.FONT, rollCaptionTrackClip.getFont(), aVar2, rollCaptionTrack, rollCaptionTrackClip, aliyunEditorProject));
                        it4 = it4;
                    }
                }
            }
        }
        for (com.aliyun.svideosdk.common.struct.project.GlobalTrack globalTrack : aliyunEditorProject.getTimeline().getGlobalTracks()) {
            if (globalTrack instanceof com.aliyun.svideosdk.common.struct.project.WaterMark) {
                com.aliyun.svideosdk.common.struct.project.WaterMark waterMark = (com.aliyun.svideosdk.common.struct.project.WaterMark) globalTrack;
                if (isFileNotExists(waterMark.getSource()) || aVar != com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload) {
                    list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.c(this, aVar, globalTrack.getType() == com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.tail_watermark ? com.aliyun.svideosdk.editor.resource.AliyunResModuleType.TAIL_WATERMARK : com.aliyun.svideosdk.editor.resource.AliyunResModuleType.WATERMARK, com.aliyun.svideosdk.editor.resource.AliyunResType.IMAGE, waterMark.getSource(), aVar2, aliyunEditorProject, globalTrack));
                }
            }
            if (globalTrack instanceof com.aliyun.svideosdk.common.struct.project.PaintTrack) {
                com.aliyun.svideosdk.common.struct.project.PaintTrack paintTrack = (com.aliyun.svideosdk.common.struct.project.PaintTrack) globalTrack;
                if (isFileNotExists(paintTrack.getSource()) || aVar != com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload) {
                    list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.d(this, aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.PAINT, com.aliyun.svideosdk.editor.resource.AliyunResType.IMAGE, paintTrack.getSource(), aVar2, aliyunEditorProject, globalTrack));
                }
            }
        }
        for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : aliyunEditorProject.getTimeline().getEffectTracks()) {
            if (effectTrack instanceof com.aliyun.svideosdk.common.struct.project.MVFilter) {
                com.aliyun.svideosdk.common.struct.project.MVFilter mVFilter = (com.aliyun.svideosdk.common.struct.project.MVFilter) effectTrack;
                if (isFileNotExists(mVFilter.getSource()) || aVar != com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload) {
                    list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.e(this, aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.MV, com.aliyun.svideosdk.editor.resource.AliyunResType.MV, mVFilter.getSource(), aVar2, aliyunEditorProject, effectTrack));
                }
            }
            if (effectTrack instanceof com.aliyun.svideosdk.common.struct.project.Filter) {
                com.aliyun.svideosdk.common.struct.project.Filter filter = (com.aliyun.svideosdk.common.struct.project.Filter) effectTrack;
                if (filter.getSource() != null && (isFileNotExists(filter.getSource()) || aVar != com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload)) {
                    com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType3 = com.aliyun.svideosdk.editor.resource.AliyunResModuleType.FILTER;
                    int i2 = com.aliyun.svideosdk.editor.draft.DraftManagerImpl.m.a[effectTrack.getType().ordinal()];
                    if (i2 != 1) {
                        if (i2 == 2) {
                            aliyunResModuleType3 = com.aliyun.svideosdk.editor.resource.AliyunResModuleType.ANIMATION_FILTER;
                        } else if (i2 == 3) {
                            aliyunResModuleType3 = com.aliyun.svideosdk.editor.resource.AliyunResModuleType.LUT_FILTER;
                        }
                    }
                    list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.f(this, aVar, aliyunResModuleType3, com.aliyun.svideosdk.editor.resource.AliyunResType.CONFIG, filter.getSource(), aVar2, aliyunEditorProject, effectTrack));
                }
            }
        }
        if (aVar != com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a.preload) {
            list.add(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.g(this, aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.COVER, com.aliyun.svideosdk.editor.resource.AliyunResType.IMAGE, aliyunEditorProject.getCover(), aVar2, aliyunEditorProject));
        }
    }

    private com.aliyun.svideosdk.common.struct.project.AliyunEditorProject getProjectById(java.lang.String str) {
        return com.aliyun.svideosdk.common.struct.project.ProjectUtil.readProject(new java.io.File(this.mDraftDir + java.io.File.separator + str, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.PROJECT_FILENAME), new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl());
    }

    private boolean isFileNotExists(com.aliyun.svideosdk.common.struct.project.Source source) {
        if (source == null || com.aliyun.common.utils.StringUtils.isEmpty(source.getPath())) {
            return true;
        }
        return !new java.io.File(source.getPath()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.svideosdk.editor.draft.AliyunDraft projectToDraft(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject) {
        com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft = new com.aliyun.svideosdk.editor.draft.AliyunDraft();
        aliyunDraft.setId(aliyunEditorProject.getProjectDir().getName());
        aliyunDraft.setProjectId(aliyunEditorProject.getProjectId());
        aliyunDraft.setName(aliyunEditorProject.getTitle());
        aliyunDraft.setDuration((long) (aliyunEditorProject.getTimeline().getDuration() * 1000.0f));
        aliyunDraft.setFileSize(aliyunEditorProject.getResourceSize() * 1024);
        if (aliyunEditorProject.getCover() != null) {
            aliyunDraft.setCoverPath(aliyunEditorProject.getCover().getPath());
        }
        try {
            aliyunDraft.setUpdateTime(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.DATE_FORMAT.parse(aliyunEditorProject.getModifiedTime()).getTime());
        } catch (java.text.ParseException e2) {
            e2.printStackTrace();
        }
        aliyunDraft.setEditorProjectUri(aliyunEditorProject.getProjectFile().getAbsolutePath());
        aliyunDraft.setConfig(aliyunEditorProject.getConfig());
        return aliyunDraft;
    }

    @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftManager
    public com.aliyun.svideosdk.editor.draft.AliyunDraft copy(java.lang.String str) {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject projectById = getProjectById(str);
        projectById.setTitle(projectById.getTitle() + "副本");
        java.io.File newProjectDir = com.aliyun.svideosdk.common.struct.project.ProjectUtil.newProjectDir(projectById.getProjectDir().getParentFile().getAbsolutePath());
        newProjectDir.mkdirs();
        try {
            com.aliyun.common.utils.FileUtils.copyDirectoryToDirectory(projectById.getProjectDir(), newProjectDir);
        } catch (java.lang.Exception unused) {
        }
        projectById.setProjectDir(newProjectDir, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.getProjectFile(newProjectDir));
        com.aliyun.svideosdk.common.struct.project.ProjectUtil.writeProject(projectById, projectById.getProjectFile(), new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl(), false);
        return projectToDraft(projectById);
    }

    @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftManager
    public void deleteDraft(java.lang.String str) {
        java.io.File file = new java.io.File(this.mDraftDir + java.io.File.separator + str, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.PROJECT_FILENAME);
        if (file.exists()) {
            com.aliyun.common.utils.FileUtils.deleteDirectory(file.getParentFile());
        }
    }

    @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftManager
    public void downloadDraft(java.io.File file, com.aliyun.svideosdk.editor.draft.AliyunDraftResourceDownloader aliyunDraftResourceDownloader) {
        com.aliyun.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.j(file, aliyunDraftResourceDownloader));
    }

    @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftManager
    public com.aliyun.svideosdk.editor.draft.AliyunDraft getDraft(java.lang.String str) {
        return projectToDraft(getProjectById(str));
    }

    @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftManager
    public com.aliyun.svideosdk.editor.draft.AliyunDraft getDraftByPath(java.lang.String str) {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject;
        if (com.aliyun.common.utils.StringUtils.isEmpty(str)) {
            return null;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists() && (readProject = com.aliyun.svideosdk.common.struct.project.ProjectUtil.readProject(file, new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl())) != null) {
            return projectToDraft(readProject);
        }
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftManager
    public java.util.List<com.aliyun.svideosdk.editor.draft.AliyunDraft> getDraftList() {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.File[] listFiles = new java.io.File(this.mDraftDir).listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl projectJSONSupportImpl = new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl();
        for (java.io.File file : listFiles) {
            java.io.File file2 = new java.io.File(file, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.PROJECT_FILENAME);
            if (file.isDirectory() && file2.exists() && (readProject = com.aliyun.svideosdk.common.struct.project.ProjectUtil.readProject(file2, projectJSONSupportImpl)) != null) {
                arrayList.add(projectToDraft(readProject));
            }
        }
        java.util.Collections.sort(arrayList, new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.k(this));
        return arrayList;
    }

    @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftManager
    public void getDraftListByAsync(com.aliyun.svideosdk.editor.draft.AliyunDraftListCallback aliyunDraftListCallback) {
        if (aliyunDraftListCallback == null) {
            return;
        }
        com.aliyun.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.l(aliyunDraftListCallback));
    }

    @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftManager
    public void preLoadDraft(com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, com.aliyun.svideosdk.editor.draft.AliyunDraftResourceLoader aliyunDraftResourceLoader) {
        com.aliyun.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.h(aliyunDraft, aliyunDraftResourceLoader));
    }

    @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftManager
    public void rename(java.lang.String str, java.lang.String str2) {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject projectById = getProjectById(str);
        if (projectById != null) {
            projectById.setTitle(str2);
            com.aliyun.svideosdk.common.struct.project.ProjectUtil.writeProject(projectById, projectById.getProjectFile(), new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl(), true);
        }
    }

    @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftManager
    public void setProjectId(java.lang.String str, java.lang.String str2) {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject projectById = getProjectById(str);
        if (projectById != null) {
            projectById.setProjectId(str2);
            com.aliyun.svideosdk.common.struct.project.ProjectUtil.writeProject(projectById, projectById.getProjectFile(), new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl(), false);
        }
    }

    @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftManager
    public void updateCover(com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, com.aliyun.svideosdk.common.struct.project.Source source) {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject projectById = getProjectById(aliyunDraft.getId());
        if (projectById != null) {
            projectById.setCustomCover(source != null);
            if (source == null || source.getPath() == null || !new java.io.File(source.getPath()).exists()) {
                return;
            }
            java.io.File file = new java.io.File(source.getPath());
            java.lang.String str = projectById.getProjectDir().getAbsolutePath() + java.io.File.separator + "cover.jpeg";
            java.io.File file2 = new java.io.File(str);
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                com.aliyun.common.utils.FileUtils.copyFile(file, file2);
                com.aliyun.svideosdk.common.struct.project.Source source2 = new com.aliyun.svideosdk.common.struct.project.Source(str);
                source2.setURL(source.getURL());
                projectById.setCover(source2);
                com.aliyun.svideosdk.common.struct.project.ProjectUtil.writeProject(projectById, projectById.getProjectFile(), new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl(), true);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.draft.AliyunDraftManager
    public void uploadDraft(com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, com.aliyun.svideosdk.editor.draft.AliyunDraftResourceUploader aliyunDraftResourceUploader) {
        com.aliyun.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideosdk.editor.draft.DraftManagerImpl.i(aliyunDraft, aliyunDraftResourceUploader));
    }
}
