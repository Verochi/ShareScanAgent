package com.aliyun.svideosdk.importer.impl;

/* loaded from: classes12.dex */
class a implements com.aliyun.svideosdk.importer.AliyunIImport {
    private com.aliyun.svideosdk.common.struct.project.AliyunEditorProject a;
    private com.aliyun.common.jasonparse.JSONSupport b = new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl();
    private com.aliyun.svideosdk.common.struct.common.AliyunVideoParam c;
    private com.aliyun.svideosdk.common.AliyunIClipConstructor d;
    private com.aliyun.common.log.reporter.AlivcImportReporter e;

    public a(android.content.Context context) {
        a(context);
    }

    public void a(android.content.Context context) {
        if (context == null) {
            throw new java.lang.RuntimeException("AliyunIImport init failed,because context is invalid");
        }
        if (this.a == null) {
            this.a = com.aliyun.svideosdk.common.struct.project.ProjectUtil.newProject(com.aliyun.svideosdk.common.struct.project.ProjectUtil.newProjectDir(context.getExternalFilesDir(null).getAbsolutePath() + java.io.File.separator + com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.DRAFT_DIR));
        }
        if (this.a == null) {
            throw new java.lang.RuntimeException("AliyunIImport init failed");
        }
        java.lang.String generateUUID = com.aliyun.common.log.util.UUIDGenerator.generateUUID();
        this.e = new com.aliyun.common.log.reporter.AlivcImportReporter(context, generateUUID);
        this.a.setRequestID(generateUUID);
        this.d = new com.aliyun.svideosdk.common.impl.b(this.a.getTimeline().getPrimaryTrack().getVideoTrackClips());
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int addImage(java.lang.String str, long j, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase, com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode aliyunDisplayMode) {
        if (str == null || !new java.io.File(str).exists()) {
            return -20003013;
        }
        return this.d.addImage(str, j, transitionBase, aliyunDisplayMode);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int addMediaClip(int i, com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip) {
        return this.d.addMediaClip(i, aliyunClip);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int addMediaClip(com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip) {
        return this.d.addMediaClip(aliyunClip);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int addVideo(java.lang.String str, long j, long j2, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase, com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode aliyunDisplayMode) {
        long overlapDuration = transitionBase == null ? 0L : transitionBase.getOverlapDuration();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("addVideo:videoPath:");
        sb.append(str);
        sb.append(",startTime:");
        sb.append(j);
        sb.append(",endTime:");
        sb.append(j2);
        sb.append("overlapDuration:");
        sb.append(overlapDuration);
        if (str == null || !new java.io.File(str).exists()) {
            return -20003004;
        }
        if (j2 > j) {
            return this.d.addVideo(str, j, j2, transitionBase, aliyunDisplayMode);
        }
        throw new java.lang.RuntimeException("video duration invalid");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        if (r1 != 0) goto L9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0091  */
    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int addVideo(java.lang.String str, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase, com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode aliyunDisplayMode) {
        android.media.MediaMetadataRetriever mediaMetadataRetriever;
        long j;
        com.aliyun.svideosdk.transcode.NativeParser nativeParser;
        if (str == null || !new java.io.File(str).exists()) {
            return -20003004;
        }
        com.aliyun.svideosdk.transcode.NativeParser nativeParser2 = null;
        try {
            mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                j = java.lang.Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            } catch (java.lang.Exception unused) {
                try {
                    try {
                        try {
                            nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
                        } catch (java.lang.Exception unused2) {
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        nativeParser2 = mediaMetadataRetriever;
                        mediaMetadataRetriever = nativeParser2;
                        if (mediaMetadataRetriever != 0) {
                            mediaMetadataRetriever.release();
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
                try {
                    nativeParser.init(str);
                    j = java.lang.Long.parseLong(nativeParser.getValue(3)) / 1000;
                    nativeParser.release();
                } catch (java.lang.Exception unused3) {
                    nativeParser2 = nativeParser;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("NativeParser failed, tempFilePath :");
                    sb.append(str);
                    j = 0;
                    if (nativeParser2 != null) {
                        nativeParser2.release();
                        nativeParser = nativeParser2;
                        nativeParser.dispose();
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    nativeParser2 = nativeParser;
                    if (nativeParser2 != null) {
                        nativeParser2.release();
                        nativeParser2.dispose();
                    }
                    throw th;
                }
                nativeParser.dispose();
            } catch (java.lang.Throwable th4) {
                th = th4;
                if (mediaMetadataRetriever != 0) {
                }
                throw th;
            }
        } catch (java.lang.Exception unused4) {
            mediaMetadataRetriever = 0;
        } catch (java.lang.Throwable th5) {
            th = th5;
            mediaMetadataRetriever = nativeParser2;
            if (mediaMetadataRetriever != 0) {
            }
            throw th;
        }
        mediaMetadataRetriever.release();
        try {
            return addVideo(str, 0L, j, transitionBase, aliyunDisplayMode);
        } catch (java.lang.Exception unused5) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("addVideo failed, videoPath = ");
            sb2.append(str);
            return -20004001;
        }
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int deleteLastMediaClip() {
        return this.d.deleteLastMediaClip();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int deleteMediaClip() {
        return this.d.deleteLastMediaClip();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int deleteMediaClip(int i) {
        return this.d.deleteMediaClip(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public void deleteMediaClip(com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip) {
        this.d.deleteMediaClip(aliyunClip);
    }

    @Override // com.aliyun.svideosdk.importer.AliyunIImport
    public java.lang.String generateProjectConfigure() {
        if (this.d.getMediaClipCount() == 0) {
            return null;
        }
        java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> videoTrackClips = this.a.getTimeline().getPrimaryTrack().getVideoTrackClips();
        videoTrackClips.clear();
        for (com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip : this.d.getAllClips()) {
            com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip mainVideoTrackClip = new com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip();
            mainVideoTrackClip.setSource(new com.aliyun.svideosdk.common.struct.project.Source(aliyunClip.getSource()));
            mainVideoTrackClip.setTransition(aliyunClip.getTransition());
            mainVideoTrackClip.setDisplayMode(aliyunClip.getDisplayMode().ordinal());
            mainVideoTrackClip.setWidth(aliyunClip.getClipWidth());
            mainVideoTrackClip.setHeight(aliyunClip.getClipHeight());
            if (aliyunClip.getMediaType() == com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE && (aliyunClip instanceof com.aliyun.svideosdk.common.struct.common.AliyunVideoClip)) {
                mainVideoTrackClip.setType(0);
                com.aliyun.svideosdk.common.struct.common.AliyunVideoClip aliyunVideoClip = (com.aliyun.svideosdk.common.struct.common.AliyunVideoClip) aliyunClip;
                mainVideoTrackClip.setIn(aliyunVideoClip.getStartTime() / 1000.0f);
                mainVideoTrackClip.setOut(aliyunVideoClip.getEndTime() / 1000.0f);
                mainVideoTrackClip.setDuration(aliyunVideoClip.getDuration() / 1000.0f);
                com.aliyun.common.log.reporter.AlivcImportReporter alivcImportReporter = this.e;
                if (alivcImportReporter != null) {
                    alivcImportReporter.sendAddVideoEvent(aliyunVideoClip.getSource(), aliyunVideoClip.getStartTime(), aliyunVideoClip.getStartTime(), mainVideoTrackClip.getTransition() == null ? 0L : mainVideoTrackClip.getTransition().getOverlapDuration());
                }
            } else if (aliyunClip.getMediaType() == com.aliyun.svideosdk.common.struct.common.MediaType.ANY_IMAGE_TYPE && (aliyunClip instanceof com.aliyun.svideosdk.common.struct.common.AliyunImageClip)) {
                mainVideoTrackClip.setType(1);
                mainVideoTrackClip.setIn(0.0f);
                mainVideoTrackClip.setOut(((com.aliyun.svideosdk.common.struct.common.AliyunImageClip) aliyunClip).getDuration() / 1000.0f);
                mainVideoTrackClip.setDuration(9.223372E18f);
                mainVideoTrackClip.setType(1);
                com.aliyun.common.log.reporter.AlivcImportReporter alivcImportReporter2 = this.e;
                if (alivcImportReporter2 != null) {
                    alivcImportReporter2.sendAddImageEvent();
                }
            }
            videoTrackClips.add(mainVideoTrackClip);
        }
        this.a.refreshTimeLine();
        com.aliyun.svideosdk.common.struct.common.AliyunVideoParam aliyunVideoParam = this.c;
        if (aliyunVideoParam != null) {
            int outputWidth = aliyunVideoParam.getOutputWidth();
            int outputHeight = this.c.getOutputHeight();
            this.a.getConfig().setOutputWidth(outputWidth);
            this.a.getConfig().setOutputHeight(outputHeight);
            this.a.getConfig().setGop(this.c.getGop());
            this.a.getConfig().setFps(this.c.getFrameRate());
            this.a.getConfig().setBitrate(this.c.getBitrate());
            this.a.getConfig().setCrf(this.c.getCrf());
            this.a.getConfig().setDisplayMode(this.c.getScaleMode().ordinal());
            this.a.getConfig().setVideoQuality(this.c.getVideoQuality().ordinal());
            this.a.getConfig().setVideoCodec(this.c.getVideoCodec().ordinal());
            this.a.getConfig().setScale(this.c.getScaleRate());
        }
        com.aliyun.common.log.reporter.AlivcImportReporter alivcImportReporter3 = this.e;
        if (alivcImportReporter3 != null) {
            alivcImportReporter3.sendImportCompleteEvent();
        }
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.a;
        com.aliyun.svideosdk.common.struct.project.ProjectUtil.writeProject(aliyunEditorProject, aliyunEditorProject.getProjectFile(), this.b);
        return this.a.getProjectFile().getAbsolutePath();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public java.util.List<com.aliyun.svideosdk.common.struct.common.AliyunClip> getAllClips() {
        return this.d.getAllClips();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public com.aliyun.svideosdk.common.struct.common.AliyunClip getMediaClip(int i) {
        return this.d.getMediaClip(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int getMediaClipCount() {
        return this.d.getMediaClipCount();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public com.aliyun.svideosdk.common.struct.common.AliyunClip getMediaPart(int i) {
        return this.d.getMediaClip(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int getMediaPartCount() {
        return this.d.getMediaClipCount();
    }

    @Override // com.aliyun.svideosdk.importer.AliyunIImport
    public void release() {
        this.a = null;
        com.aliyun.common.log.reporter.AlivcImportReporter alivcImportReporter = this.e;
        if (alivcImportReporter != null) {
            alivcImportReporter.release();
        }
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public void removeMedia(int i) {
        this.d.deleteMediaClip(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public void removeVideo(java.lang.String str) throws java.lang.IllegalAccessException {
        this.d.removeVideo(str);
    }

    @Override // com.aliyun.svideosdk.importer.AliyunIImport
    public void setVideoParam(com.aliyun.svideosdk.common.struct.common.AliyunVideoParam aliyunVideoParam) {
        this.c = aliyunVideoParam;
        int outputWidth = aliyunVideoParam.getOutputWidth();
        int outputHeight = aliyunVideoParam.getOutputHeight();
        if (outputWidth % 2 != 0) {
            aliyunVideoParam.setOutputWidth(outputWidth - 1);
        }
        if (outputHeight % 2 != 0) {
            aliyunVideoParam.setOutputHeight(outputHeight - 1);
        }
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public void swap(int i, int i2) {
        this.d.swap(i, i2);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public void updateAllClips(java.util.List<com.aliyun.svideosdk.common.struct.common.AliyunClip> list) {
        this.d.updateAllClips(list);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int updateMediaClip(int i, com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip) {
        return this.d.updateMediaClip(i, aliyunClip);
    }
}
