package com.aliyun.svideosdk.common.struct.template;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunTemplate {
    public static final java.lang.String FILENAME = "template.json";

    @com.google.gson.annotations.SerializedName("Cover")
    private com.aliyun.svideosdk.common.struct.project.Source mCover;

    @com.google.gson.annotations.SerializedName("Params")
    private java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> mParams = new java.util.ArrayList();
    private transient java.lang.String mPath;

    @com.google.gson.annotations.SerializedName("Project")
    private com.aliyun.svideosdk.common.struct.project.Source mProject;

    @com.google.gson.annotations.SerializedName("TemplateId")
    private java.lang.String mTemplateId;

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_TITLE)
    private java.lang.String mTitle;

    @com.google.gson.annotations.SerializedName("Version")
    private int mVersion;

    @com.google.gson.annotations.SerializedName("Video")
    private com.aliyun.svideosdk.common.struct.project.Source mVideo;

    public com.aliyun.svideosdk.common.struct.project.AliyunEditorProject createEditorProject(android.content.Context context, java.util.List<com.aliyun.svideosdk.common.struct.common.AliyunClip> list) {
        boolean z;
        com.aliyun.svideosdk.common.struct.project.Source source;
        try {
            com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl projectJSONSupportImpl = new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl();
            com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject = com.aliyun.svideosdk.common.struct.project.ProjectUtil.readProject(new java.io.File(getProject().getPath()), projectJSONSupportImpl);
            readProject.setTemplate(new com.aliyun.svideosdk.common.struct.project.Source(getPath()));
            int i = 0;
            for (com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam : getParams()) {
                if (!aliyunTemplateParam.isLock()) {
                    java.util.Iterator<com.aliyun.svideosdk.common.struct.project.VideoTrack> it = readProject.getTimeline().getVideoTracks().iterator();
                    while (it.hasNext()) {
                        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> it2 = it.next().getVideoTrackClips().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = false;
                                break;
                            }
                            com.aliyun.svideosdk.common.struct.project.VideoTrackClip next = it2.next();
                            if (aliyunTemplateParam.getNodeKey().equals(next.getNodeKey())) {
                                aliyunTemplateParam.setTimelineIn(next.getTimelineIn());
                                aliyunTemplateParam.setTimelineOut(next.getTimelineOut());
                                aliyunTemplateParam.setType(next.getType() == 0 ? com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam.Type.video : com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam.Type.image);
                                com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip = list.get(i);
                                i++;
                                z = true;
                                if (aliyunClip.getMediaType() == com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE) {
                                    next.setType(0);
                                    next.setIn(0.0f);
                                    next.setOut(next.getTimelineOut() - next.getTimelineIn());
                                    next.setDuration(((com.aliyun.svideosdk.common.struct.common.AliyunVideoClip) aliyunClip).getDuration() / 1000.0f);
                                    source = new com.aliyun.svideosdk.common.struct.project.Source(aliyunClip.getSource());
                                } else if (aliyunClip.getMediaType() == com.aliyun.svideosdk.common.struct.common.MediaType.ANY_IMAGE_TYPE) {
                                    next.setType(1);
                                    next.setDuration(9.223372E18f);
                                    source = new com.aliyun.svideosdk.common.struct.project.Source(((com.aliyun.svideosdk.common.struct.common.AliyunImageClip) aliyunClip).getSource());
                                }
                                next.setSource(source);
                            }
                        }
                        if (z) {
                            break;
                        }
                    }
                }
            }
            java.io.File externalFilesDir = context.getExternalFilesDir(null);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(externalFilesDir.getAbsolutePath());
            java.lang.String str = java.io.File.separator;
            sb.append(str);
            sb.append(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.TEMPLATE_DRAFT_DIR);
            sb.append(str);
            sb.append(java.lang.System.currentTimeMillis());
            java.io.File file = new java.io.File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            java.io.File file2 = new java.io.File(file, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.PROJECT_FILENAME);
            readProject.setProjectDir(file, file2);
            com.aliyun.svideosdk.common.struct.project.ProjectUtil.writeProject(readProject, file2, projectJSONSupportImpl);
            return readProject;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public com.aliyun.svideosdk.common.struct.project.Source getCover() {
        return this.mCover;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> getImportParams() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam : getParams()) {
            if (!aliyunTemplateParam.isLock() && (aliyunTemplateParam.getTarget() instanceof com.aliyun.svideosdk.common.struct.project.VideoTrackClip)) {
                arrayList.add(aliyunTemplateParam);
            }
        }
        return arrayList;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> getParams() {
        return this.mParams;
    }

    public java.lang.String getPath() {
        return this.mPath;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getProject() {
        return this.mProject;
    }

    public java.lang.String getTemplateId() {
        return this.mTemplateId;
    }

    public java.lang.String getTitle() {
        return this.mTitle;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getVideo() {
        return this.mVideo;
    }

    public void setCover(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mCover = source;
    }

    public void setPath(java.lang.String str) {
        this.mPath = str;
    }

    public void setProject(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mProject = source;
    }

    public void setTemplateId(java.lang.String str) {
        this.mTemplateId = str;
    }

    public void setTitle(java.lang.String str) {
        this.mTitle = str;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public void setVideo(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mVideo = source;
    }
}
