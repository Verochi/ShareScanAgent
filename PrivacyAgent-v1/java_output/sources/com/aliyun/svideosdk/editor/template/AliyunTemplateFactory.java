package com.aliyun.svideosdk.editor.template;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunTemplateFactory {
    public static com.aliyun.svideosdk.editor.template.AliyunTemplateBuilder createAliyunTemplateBuilder(android.net.Uri uri) {
        return new com.aliyun.svideosdk.editor.template.a(uri);
    }

    public static com.aliyun.svideosdk.editor.template.AliyunTemplateEditor createAliyunTemplateEditor(android.net.Uri uri) {
        return new com.aliyun.svideosdk.editor.template.b(uri);
    }

    public static com.aliyun.svideosdk.common.struct.template.AliyunTemplate getAliyunTemplate(android.net.Uri uri) {
        boolean z;
        try {
            com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl projectJSONSupportImpl = new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl();
            com.aliyun.svideosdk.common.struct.template.AliyunTemplate aliyunTemplate = (com.aliyun.svideosdk.common.struct.template.AliyunTemplate) new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl().readValue(new java.io.File(uri.getPath()), com.aliyun.svideosdk.common.struct.template.AliyunTemplate.class);
            aliyunTemplate.setPath(uri.getPath());
            com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject = com.aliyun.svideosdk.common.struct.project.ProjectUtil.readProject(new java.io.File(aliyunTemplate.getProject().getPath()), projectJSONSupportImpl);
            if (readProject == null) {
                return null;
            }
            for (com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam aliyunTemplateParam : aliyunTemplate.getParams()) {
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
                                aliyunTemplateParam.setTarget(next);
                                z = true;
                            }
                        }
                        if (z) {
                            break;
                        }
                    }
                    java.util.Iterator<com.aliyun.svideosdk.common.struct.project.PasterTrack> it3 = readProject.getTimeline().getPasterTracks().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            com.aliyun.svideosdk.common.struct.project.PasterTrack next2 = it3.next();
                            if (next2 instanceof com.aliyun.svideosdk.common.struct.project.CaptionTrack) {
                                com.aliyun.svideosdk.common.struct.project.CaptionTrack captionTrack = (com.aliyun.svideosdk.common.struct.project.CaptionTrack) next2;
                                if (aliyunTemplateParam.getNodeKey().equals(captionTrack.getNodeKey())) {
                                    aliyunTemplateParam.setTimelineIn(captionTrack.getTimelineIn());
                                    aliyunTemplateParam.setTimelineOut(captionTrack.getTimelineOut());
                                    aliyunTemplateParam.setType(com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam.Type.text);
                                    aliyunTemplateParam.setTarget(captionTrack);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return aliyunTemplate;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
