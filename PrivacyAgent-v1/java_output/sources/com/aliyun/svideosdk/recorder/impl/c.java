package com.aliyun.svideosdk.recorder.impl;

/* loaded from: classes12.dex */
public class c implements com.aliyun.svideosdk.recorder.AliyunIClipManager {
    private int c;
    private java.io.File e;
    private java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> a = new java.util.concurrent.CopyOnWriteArrayList<>();
    private int b = Integer.MAX_VALUE;
    private long d = 0;
    private com.aliyun.svideosdk.common.struct.project.AliyunEditorProject f = null;
    private com.aliyun.common.jasonparse.JSONSupport g = new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl();

    public class a extends android.os.AsyncTask {
        final /* synthetic */ java.lang.String[] a;

        public a(com.aliyun.svideosdk.recorder.impl.c cVar, java.lang.String[] strArr) {
            this.a = strArr;
        }

        @Override // android.os.AsyncTask
        public java.lang.Object doInBackground(java.lang.Object[] objArr) {
            for (java.lang.String str : this.a) {
                java.io.File file = new java.io.File(str);
                if (file.exists()) {
                    file.delete();
                }
            }
            return null;
        }
    }

    public c(android.content.Context context) {
        this.e = com.aliyun.svideosdk.common.struct.project.ProjectUtil.newProjectDir(context.getExternalFilesDir(null).getAbsolutePath() + java.io.File.separator + com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.DRAFT_DIR);
    }

    private void a(int i) {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.f;
        if (aliyunEditorProject == null) {
            return;
        }
        aliyunEditorProject.getTimeline().getPrimaryTrack().getVideoTrackClips().remove(i);
        this.f.refreshTimeLine();
    }

    private void a(java.lang.String[] strArr) {
        new com.aliyun.svideosdk.recorder.impl.c.a(this, strArr).executeOnExecutor(android.os.AsyncTask.SERIAL_EXECUTOR, new java.lang.Object[0]);
    }

    private void b(com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip) {
        if (this.f == null) {
            this.f = com.aliyun.svideosdk.common.struct.project.ProjectUtil.newProject(this.e);
        }
        this.f.getTimeline().getPrimaryTrack().getVideoTrackClips().add(videoTrackClip);
        this.f.refreshTimeLine();
    }

    private void d() {
        com.aliyun.common.utils.FileUtils.deleteDirectory(this.e);
        this.f = null;
    }

    private void e() {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.f;
        if (aliyunEditorProject == null) {
            return;
        }
        java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> videoTrackClips = aliyunEditorProject.getTimeline().getPrimaryTrack().getVideoTrackClips();
        if (videoTrackClips.size() > 0) {
            videoTrackClips.remove(videoTrackClips.size() - 1);
        }
        this.f.refreshTimeLine();
    }

    public java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> a() {
        return this.a;
    }

    public void a(com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip) {
        this.a.add(videoTrackClip);
        this.d = (long) (this.d + ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000000.0f));
        b(videoTrackClip);
    }

    public void a(java.lang.String str) {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.f;
        if (aliyunEditorProject == null) {
            return;
        }
        aliyunEditorProject.setRequestID(str);
    }

    public com.aliyun.svideosdk.common.struct.project.Config b() {
        return this.f.getConfig();
    }

    public android.net.Uri c() {
        f();
        return android.net.Uri.fromFile(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.getProjectFile(this.e));
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public void deleteAllPart() {
        d();
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> it = this.a.iterator();
        while (it.hasNext()) {
            a(new java.lang.String[]{it.next().getSource().getPath()});
        }
        this.a.clear();
        this.d = 0L;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public void deleteLastPart() {
        if (this.a.size() == 0) {
            return;
        }
        java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> copyOnWriteArrayList = this.a;
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip remove = copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1);
        this.d = (long) (this.d - ((remove.getOut() - remove.getIn()) * 1000000.0f));
        e();
        a(new java.lang.String[]{remove.getSource().getPath()});
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public void deletePart() {
        deleteLastPart();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public void deletePart(int i) {
        if (i < this.a.size()) {
            com.aliyun.svideosdk.common.struct.project.VideoTrackClip remove = this.a.remove(i);
            this.d = (long) (this.d - ((remove.getOut() - remove.getIn()) * 1000000.0f));
            a(i);
            a(new java.lang.String[]{remove.getSource().getPath()});
        }
    }

    public void f() {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.f;
        if (aliyunEditorProject == null) {
            return;
        }
        com.aliyun.svideosdk.common.struct.project.ProjectUtil.writeProject(aliyunEditorProject, aliyunEditorProject.getProjectFile(), this.g);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public int getDuration() {
        return (int) getDuration(java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public long getDuration(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.d, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public int getMaxDuration() {
        return this.b;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public int getMinDuration() {
        return this.c;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public int getPartCount() {
        return this.a.size();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public java.util.List<java.lang.String> getVideoPathList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> it = this.a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getSource().getPath());
        }
        return arrayList;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public void setMaxDuration(int i) {
        this.b = i;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public void setMinDuration(int i) {
        this.c = i;
    }
}
