package com.aliyun.svideosdk.editor.template;

/* loaded from: classes12.dex */
public class c implements com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer {
    protected com.aliyun.svideosdk.editor.AliyunIEditor a;
    private com.aliyun.svideosdk.editor.EditorCallBack b;

    public class a extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.PasterTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
            this.a = aliyunEditorProject;
            this.b = pasterTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getPasterTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class b extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.RollCaptionTrack a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip b;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.RollCaptionTrack rollCaptionTrack, com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip rollCaptionTrackClip, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
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

    /* renamed from: com.aliyun.svideosdk.editor.template.c$c, reason: collision with other inner class name */
    public class C0100c extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.GlobalTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0100c(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.GlobalTrack globalTrack) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
            this.a = aliyunEditorProject;
            this.b = globalTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getGlobalTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class d extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.GlobalTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.GlobalTrack globalTrack) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
            this.a = aliyunEditorProject;
            this.b = globalTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getGlobalTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class e extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.EffectTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
            this.a = aliyunEditorProject;
            this.b = effectTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getEffectTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class f extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.EffectTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
            this.a = aliyunEditorProject;
            this.b = effectTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getEffectTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class g extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
            this.a = aliyunEditorProject;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.setCover(null);
            onHandleCallback(null);
        }
    }

    public class h extends com.aliyun.svideosdk.editor.EditorCallBack {
        public h() {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onCustomRender(int i, int i2, int i3) {
            if (com.aliyun.svideosdk.editor.template.c.this.b == null) {
                return 0;
            }
            com.aliyun.svideosdk.editor.template.c.this.b.onCustomRender(i, i2, i3);
            return 0;
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onDataReady() {
            if (com.aliyun.svideosdk.editor.template.c.this.b != null) {
                com.aliyun.svideosdk.editor.template.c.this.b.onDataReady();
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onEnd(int i) {
            if (com.aliyun.svideosdk.editor.template.c.this.b != null) {
                com.aliyun.svideosdk.editor.template.c.this.b.onEnd(i);
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onError(int i) {
            if (com.aliyun.svideosdk.editor.template.c.this.b != null) {
                com.aliyun.svideosdk.editor.template.c.this.b.onError(i);
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onPlayProgress(long j, long j2) {
            if (com.aliyun.svideosdk.editor.template.c.this.b != null) {
                com.aliyun.svideosdk.editor.template.c.this.b.onPlayProgress(j, j2);
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onTextureRender(int i, int i2, int i3) {
            if (com.aliyun.svideosdk.editor.template.c.this.b != null) {
                return com.aliyun.svideosdk.editor.template.c.this.b.onTextureRender(i, i2, i3);
            }
            return 0;
        }
    }

    public class i implements java.util.Comparator<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> {
        public i(com.aliyun.svideosdk.editor.template.c cVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam, com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam2) {
            if (aliyunTemplateParam.getTimelineIn() > aliyunTemplateParam2.getTimelineIn()) {
                return 1;
            }
            return aliyunTemplateParam.getTimelineIn() == aliyunTemplateParam2.getTimelineIn() ? 0 : -1;
        }
    }

    public class j extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.VideoTrack a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.VideoTrackClip b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.VideoTrack videoTrack, com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
            this.a = videoTrack;
            this.b = videoTrackClip;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getVideoTrackClips().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class k extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.VideoTrackClip a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.Effect b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip, com.aliyun.svideosdk.common.struct.project.Effect effect) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
            this.a = videoTrackClip;
            this.b = effect;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getEffects().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class l extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AudioTrack a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AudioTrackClip b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.AudioTrack audioTrack, com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
            this.a = audioTrack;
            this.b = audioTrackClip;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getAudioTrackClips().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class m extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.PasterTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
            this.a = aliyunEditorProject;
            this.b = pasterTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getPasterTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class n extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.PasterTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
            this.a = aliyunEditorProject;
            this.b = pasterTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getPasterTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class o extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.PasterTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
            this.a = aliyunEditorProject;
            this.b = pasterTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getPasterTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public class p extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.PasterTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(com.aliyun.svideosdk.editor.template.c cVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack) {
            super(aliyunResModuleType, aliyunResType, source, aVar);
            this.a = aliyunEditorProject;
            this.b = pasterTrack;
        }

        @Override // com.aliyun.svideosdk.editor.resource.AliyunResTask
        public void onRemove() {
            this.a.getTimeline().getPasterTracks().remove(this.b);
            onHandleCallback(null);
        }
    }

    public c(android.net.Uri uri) {
        this.a = com.aliyun.svideosdk.editor.impl.AliyunEditorFactory.creatAliyunEditor(uri, new com.aliyun.svideosdk.editor.template.c.h());
    }

    public com.aliyun.svideosdk.editor.AliyunIEditor a() {
        return this.a;
    }

    public void a(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, java.util.List<com.aliyun.svideosdk.editor.resource.AliyunResTask> list, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar) {
        com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType;
        com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType;
        for (com.aliyun.svideosdk.common.struct.project.VideoTrack videoTrack : aliyunEditorProject.getTimeline().getVideoTracks()) {
            for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : videoTrack.getVideoTrackClips()) {
                list.add(new com.aliyun.svideosdk.editor.template.c.j(this, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.MAIN_VIDEO, videoTrackClip.getType() == 0 ? com.aliyun.svideosdk.editor.resource.AliyunResType.VIDEO : com.aliyun.svideosdk.editor.resource.AliyunResType.IMAGE, videoTrackClip.getSource(), aVar, videoTrack, videoTrackClip));
                for (com.aliyun.svideosdk.common.struct.project.Effect effect : videoTrackClip.getEffects()) {
                    if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.transition) {
                        com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase = (com.aliyun.svideosdk.common.struct.effect.TransitionBase) effect;
                        if (transitionBase.mType == 5) {
                            list.add(new com.aliyun.svideosdk.editor.template.c.k(this, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.TRANSITION, com.aliyun.svideosdk.editor.resource.AliyunResType.CONFIG, transitionBase.getCustomSource(), aVar, videoTrackClip, effect));
                        }
                    }
                }
            }
        }
        for (com.aliyun.svideosdk.common.struct.project.AudioTrack audioTrack : aliyunEditorProject.getTimeline().getAudioTracks()) {
            for (com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip : audioTrack.getAudioTrackClips()) {
                list.add(new com.aliyun.svideosdk.editor.template.c.l(this, audioTrackClip.getType() == com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type.Music ? com.aliyun.svideosdk.editor.resource.AliyunResModuleType.MUSIC_AUDIO : com.aliyun.svideosdk.editor.resource.AliyunResModuleType.DUBS_AUDIO, com.aliyun.svideosdk.editor.resource.AliyunResType.AUDIO, audioTrackClip.getSource(), aVar, audioTrack, audioTrackClip));
            }
        }
        for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : aliyunEditorProject.getTimeline().getPasterTracks()) {
            if (pasterTrack instanceof com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) {
                com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack = (com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) pasterTrack;
                if (photoPasterTrack.getSource() != null) {
                    if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.subtitle) {
                        aliyunResModuleType = com.aliyun.svideosdk.editor.resource.AliyunResModuleType.SUBTITLE_FONT;
                        aliyunResType = com.aliyun.svideosdk.editor.resource.AliyunResType.FONT;
                    } else {
                        if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.bubble_caption) {
                            aliyunResModuleType = com.aliyun.svideosdk.editor.resource.AliyunResModuleType.BUBBLE_STICKER;
                        } else if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.caption) {
                            aliyunResModuleType = com.aliyun.svideosdk.editor.resource.AliyunResModuleType.CAPTION;
                        } else if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.gif) {
                            aliyunResModuleType = com.aliyun.svideosdk.editor.resource.AliyunResModuleType.GIF_STICKER;
                        } else if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.photo) {
                            aliyunResModuleType = com.aliyun.svideosdk.editor.resource.AliyunResModuleType.IMAGE_STICKER;
                        }
                        aliyunResType = com.aliyun.svideosdk.editor.resource.AliyunResType.CONFIG;
                    }
                    com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType2 = aliyunResType;
                    com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType2 = aliyunResModuleType;
                    if (photoPasterTrack.getSource() != null) {
                        list.add(new com.aliyun.svideosdk.editor.template.c.m(this, aliyunResModuleType2, aliyunResType2, photoPasterTrack.getSource(), aVar, aliyunEditorProject, pasterTrack));
                    }
                }
            }
            if (pasterTrack instanceof com.aliyun.svideosdk.common.struct.project.SubTitleTrack) {
                com.aliyun.svideosdk.common.struct.project.SubTitleTrack subTitleTrack = (com.aliyun.svideosdk.common.struct.project.SubTitleTrack) pasterTrack;
                if (subTitleTrack.getFont() != null) {
                    list.add(new com.aliyun.svideosdk.editor.template.c.n(this, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.SUBTITLE_FONT, com.aliyun.svideosdk.editor.resource.AliyunResType.FONT, subTitleTrack.getFont(), aVar, aliyunEditorProject, pasterTrack));
                }
            }
            if (pasterTrack instanceof com.aliyun.svideosdk.common.struct.project.CaptionTrack) {
                com.aliyun.svideosdk.common.struct.project.CaptionTrack captionTrack = (com.aliyun.svideosdk.common.struct.project.CaptionTrack) pasterTrack;
                if (captionTrack.getFont() != null) {
                    list.add(new com.aliyun.svideosdk.editor.template.c.o(this, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.CAPTION_FONT, com.aliyun.svideosdk.editor.resource.AliyunResType.FONT, captionTrack.getFont(), aVar, aliyunEditorProject, pasterTrack));
                }
                if (captionTrack.getFontEffectSource() != null) {
                    list.add(new com.aliyun.svideosdk.editor.template.c.p(this, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.CAPTION_EFFECT, com.aliyun.svideosdk.editor.resource.AliyunResType.CONFIG, captionTrack.getFontEffectSource(), aVar, aliyunEditorProject, pasterTrack));
                }
            }
            if (pasterTrack instanceof com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) {
                com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack bubbleCaptionTrack = (com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) pasterTrack;
                if (bubbleCaptionTrack.getFont() != null) {
                    list.add(new com.aliyun.svideosdk.editor.template.c.a(this, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.BUBBLE_FONT, com.aliyun.svideosdk.editor.resource.AliyunResType.FONT, bubbleCaptionTrack.getFont(), aVar, aliyunEditorProject, pasterTrack));
                }
            }
            if (pasterTrack instanceof com.aliyun.svideosdk.common.struct.project.RollCaptionTrack) {
                com.aliyun.svideosdk.common.struct.project.RollCaptionTrack rollCaptionTrack = (com.aliyun.svideosdk.common.struct.project.RollCaptionTrack) pasterTrack;
                for (com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip rollCaptionTrackClip : rollCaptionTrack.getRollCaptionTrackClips()) {
                    list.add(new com.aliyun.svideosdk.editor.template.c.b(this, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.SUBTITLE_FONT, com.aliyun.svideosdk.editor.resource.AliyunResType.FONT, rollCaptionTrackClip.getFont(), aVar, rollCaptionTrack, rollCaptionTrackClip, aliyunEditorProject));
                }
            }
        }
        for (com.aliyun.svideosdk.common.struct.project.GlobalTrack globalTrack : aliyunEditorProject.getTimeline().getGlobalTracks()) {
            if (globalTrack instanceof com.aliyun.svideosdk.common.struct.project.WaterMark) {
                list.add(new com.aliyun.svideosdk.editor.template.c.C0100c(this, globalTrack.getType() == com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.tail_watermark ? com.aliyun.svideosdk.editor.resource.AliyunResModuleType.TAIL_WATERMARK : com.aliyun.svideosdk.editor.resource.AliyunResModuleType.WATERMARK, com.aliyun.svideosdk.editor.resource.AliyunResType.IMAGE, ((com.aliyun.svideosdk.common.struct.project.WaterMark) globalTrack).getSource(), aVar, aliyunEditorProject, globalTrack));
            }
            if (globalTrack instanceof com.aliyun.svideosdk.common.struct.project.PaintTrack) {
                list.add(new com.aliyun.svideosdk.editor.template.c.d(this, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.PAINT, com.aliyun.svideosdk.editor.resource.AliyunResType.IMAGE, ((com.aliyun.svideosdk.common.struct.project.PaintTrack) globalTrack).getSource(), aVar, aliyunEditorProject, globalTrack));
            }
        }
        for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : aliyunEditorProject.getTimeline().getEffectTracks()) {
            if (effectTrack instanceof com.aliyun.svideosdk.common.struct.project.MVFilter) {
                list.add(new com.aliyun.svideosdk.editor.template.c.e(this, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.MV, com.aliyun.svideosdk.editor.resource.AliyunResType.MV, ((com.aliyun.svideosdk.common.struct.project.MVFilter) effectTrack).getSource(), aVar, aliyunEditorProject, effectTrack));
            }
            if (effectTrack instanceof com.aliyun.svideosdk.common.struct.project.Filter) {
                com.aliyun.svideosdk.common.struct.project.Filter filter = (com.aliyun.svideosdk.common.struct.project.Filter) effectTrack;
                if (filter.getSource() != null) {
                    list.add(new com.aliyun.svideosdk.editor.template.c.f(this, effectTrack.getType() == com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.filter ? com.aliyun.svideosdk.editor.resource.AliyunResModuleType.FILTER : com.aliyun.svideosdk.editor.resource.AliyunResModuleType.ANIMATION_FILTER, com.aliyun.svideosdk.editor.resource.AliyunResType.CONFIG, filter.getSource(), aVar, aliyunEditorProject, effectTrack));
                }
            }
        }
        list.add(new com.aliyun.svideosdk.editor.template.c.g(this, com.aliyun.svideosdk.editor.resource.AliyunResModuleType.COVER, com.aliyun.svideosdk.editor.resource.AliyunResType.IMAGE, aliyunEditorProject.getCover(), aVar, aliyunEditorProject));
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer
    public java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> getAllParams() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (getEditorProject() == null) {
            return arrayList;
        }
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.VideoTrack> it = getEditorProject().getTimeline().getVideoTracks().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : it.next().getVideoTrackClips()) {
                com.aliyun.svideosdk.common.struct.template.AliyunTemplateVideoParam aliyunTemplateVideoParam = new com.aliyun.svideosdk.common.struct.template.AliyunTemplateVideoParam();
                aliyunTemplateVideoParam.setTimelineIn(videoTrackClip.getTimelineIn());
                aliyunTemplateVideoParam.setTimelineOut(videoTrackClip.getTimelineOut());
                aliyunTemplateVideoParam.setSource(videoTrackClip.getSource());
                aliyunTemplateVideoParam.setTarget(videoTrackClip);
                aliyunTemplateVideoParam.setNodeKey(java.lang.String.valueOf(i2));
                videoTrackClip.setNodeKey(aliyunTemplateVideoParam.getNodeKey());
                i2++;
                arrayList.add(aliyunTemplateVideoParam);
            }
        }
        for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : getEditorProject().getTimeline().getPasterTracks()) {
            if (pasterTrack instanceof com.aliyun.svideosdk.common.struct.project.CaptionTrack) {
                com.aliyun.svideosdk.common.struct.project.CaptionTrack captionTrack = (com.aliyun.svideosdk.common.struct.project.CaptionTrack) pasterTrack;
                com.aliyun.svideosdk.common.struct.template.AliyunTemplateTextParam aliyunTemplateTextParam = new com.aliyun.svideosdk.common.struct.template.AliyunTemplateTextParam();
                aliyunTemplateTextParam.setTimelineIn(captionTrack.getTimelineIn());
                aliyunTemplateTextParam.setTimelineOut(captionTrack.getTimelineOut());
                aliyunTemplateTextParam.setTarget(captionTrack);
                aliyunTemplateTextParam.setText(captionTrack.getText());
                aliyunTemplateTextParam.setNodeKey(java.lang.String.valueOf(i2));
                captionTrack.setNodeKey(aliyunTemplateTextParam.getNodeKey());
                i2++;
                arrayList.add(aliyunTemplateTextParam);
            }
        }
        java.util.Collections.sort(arrayList, new com.aliyun.svideosdk.editor.template.c.i(this));
        return arrayList;
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer
    public long getCurrentPlayPosition() {
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.a;
        if (aliyunIEditor == null) {
            return -4L;
        }
        return aliyunIEditor.getCurrentPlayPosition();
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer
    public long getDuration() {
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.a;
        if (aliyunIEditor == null) {
            return -4L;
        }
        return aliyunIEditor.getDuration();
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer
    public com.aliyun.svideosdk.common.struct.project.AliyunEditorProject getEditorProject() {
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.a;
        if (aliyunIEditor == null) {
            return null;
        }
        return aliyunIEditor.getEditorProject();
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer
    public int init(android.view.SurfaceView surfaceView, int i2, int i3) {
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.a;
        if (aliyunIEditor == null) {
            return -4;
        }
        aliyunIEditor.createPasterManager().setDisplaySize(i2, i3);
        this.a.setMonitorSurfaceChange(true);
        this.a.init(surfaceView, surfaceView.getContext(), i2, i3);
        int checkTemplatePermission = ((com.aliyun.svideosdk.editor.impl.g) this.a).f().checkTemplatePermission();
        if (checkTemplatePermission != 0) {
            this.a.onDestroy();
        }
        return checkTemplatePermission;
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer
    public boolean isPaused() {
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.a;
        if (aliyunIEditor == null) {
            return false;
        }
        return aliyunIEditor.isPaused();
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer
    public boolean isPlaying() {
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.a;
        if (aliyunIEditor == null) {
            return false;
        }
        return aliyunIEditor.isPlaying();
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer
    public void onDestroy() {
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.a;
        if (aliyunIEditor == null) {
            return;
        }
        aliyunIEditor.stop();
        this.a.onDestroy();
        this.a = null;
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer
    public int pause() {
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.a;
        if (aliyunIEditor == null) {
            return -4;
        }
        return aliyunIEditor.pause();
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer
    public int play() {
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.a;
        if (aliyunIEditor == null) {
            return -4;
        }
        return aliyunIEditor.isPaused() ? this.a.resume() : this.a.play();
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer
    public int seek(long j2) {
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.a;
        if (aliyunIEditor == null) {
            return -4;
        }
        return aliyunIEditor.seek(j2);
    }

    @Override // com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer
    public void setPlayerCallBack(com.aliyun.svideosdk.editor.EditorCallBack editorCallBack) {
        this.b = editorCallBack;
    }
}
