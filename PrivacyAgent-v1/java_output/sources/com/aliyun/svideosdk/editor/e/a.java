package com.aliyun.svideosdk.editor.e;

/* loaded from: classes12.dex */
public class a implements com.aliyun.svideosdk.editor.AliyunRollCaptionComposer {
    private com.aliyun.svideosdk.editor.NativeEditor a;
    private int b;
    private int c;
    private java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.editor.e.b> d;
    private com.aliyun.svideosdk.editor.e.c e;
    private android.content.Context h;
    private com.aliyun.svideosdk.common.struct.project.AliyunEditorProject j;
    private boolean f = false;
    private java.util.regex.Pattern g = java.util.regex.Pattern.compile("\\[(\\d{1,2}):(\\d{1,2}).(\\d{1,2})\\]");
    private java.util.concurrent.ThreadPoolExecutor i = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.aliyun.svideosdk.editor.e.a.ThreadFactoryC0093a(this));

    /* renamed from: com.aliyun.svideosdk.editor.e.a$a, reason: collision with other inner class name */
    public class ThreadFactoryC0093a implements java.util.concurrent.ThreadFactory {
        public ThreadFactoryC0093a(com.aliyun.svideosdk.editor.e.a aVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("RollCaptionComposerThread");
            return thread;
        }
    }

    public class b implements java.lang.Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList = com.aliyun.svideosdk.editor.e.a.this.d;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
                return;
            }
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            com.aliyun.svideosdk.editor.e.a.this.hide();
            com.aliyun.svideosdk.editor.e.a.this.b(false);
            java.util.Iterator it = copyOnWriteArrayList.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                com.aliyun.svideosdk.editor.e.b bVar = (com.aliyun.svideosdk.editor.e.b) it.next();
                com.aliyun.svideosdk.editor.e.c b = com.aliyun.svideosdk.editor.e.a.this.b(bVar);
                if (!new com.aliyun.svideosdk.editor.e.d(com.aliyun.svideosdk.editor.e.a.this.a, bVar, com.aliyun.svideosdk.editor.e.a.this.b, com.aliyun.svideosdk.editor.e.a.this.c, com.aliyun.svideosdk.editor.e.e.a(com.aliyun.svideosdk.editor.e.a.this.h, bVar.b(), b, com.aliyun.svideosdk.editor.e.a.this.b, com.aliyun.svideosdk.editor.e.a.this.c), b).a()) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("applyDisplay. failed to attach caption:");
                    sb.append(bVar);
                    z = false;
                    break;
                }
                i++;
            }
            long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            com.aliyun.svideosdk.editor.e.a aVar = com.aliyun.svideosdk.editor.e.a.this;
            if (z) {
                aVar.a.applyRollCaptionEffects();
                com.aliyun.svideosdk.editor.e.a.this.c();
            } else {
                aVar.hide();
            }
            long elapsedRealtime3 = android.os.SystemClock.elapsedRealtime();
            java.lang.String.format("applyDisplay. allAttached:%b, costMills:%d, t1:%d, t2:%d, size:%d, caption count:%d", java.lang.Boolean.valueOf(z), java.lang.Long.valueOf(elapsedRealtime3 - elapsedRealtime), java.lang.Long.valueOf(elapsedRealtime2 - elapsedRealtime), java.lang.Long.valueOf(elapsedRealtime3 - elapsedRealtime2), java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(copyOnWriteArrayList.size()));
        }
    }

    public class c implements com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor {
        private com.aliyun.svideosdk.editor.e.c a;

        public c(com.aliyun.svideosdk.editor.e.c cVar) {
            this.a = cVar;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.aliyun.svideosdk.editor.e.a.c setTextColor(int i) {
            com.aliyun.svideosdk.editor.e.c cVar = this.a;
            if (cVar == null) {
                return this;
            }
            cVar.a(i);
            return this;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor
        @java.lang.Deprecated
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.aliyun.svideosdk.editor.e.a.c setTextFont(java.lang.String str) {
            com.aliyun.svideosdk.editor.e.c cVar = this.a;
            if (cVar == null) {
                return this;
            }
            cVar.a(new com.aliyun.svideosdk.common.struct.project.Source(str));
            return this;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.aliyun.svideosdk.editor.e.a.c setTextStrokeColor(int i) {
            com.aliyun.svideosdk.editor.e.c cVar = this.a;
            if (cVar == null) {
                return this;
            }
            cVar.b(i);
            return this;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor
        public void done() {
            com.aliyun.svideosdk.editor.e.a.this.b(true);
        }

        @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor
        public com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor setDefaultTextSize(int i, int i2) {
            com.aliyun.svideosdk.editor.e.c cVar = this.a;
            if (cVar == null) {
                return this;
            }
            cVar.a(i, i2);
            return this;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor
        public com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor setTextFont(com.aliyun.svideosdk.common.struct.project.Source source) {
            com.aliyun.svideosdk.editor.e.c cVar = this.a;
            if (cVar == null) {
                return this;
            }
            cVar.a(source);
            return this;
        }
    }

    public a(com.aliyun.svideosdk.editor.NativeEditor nativeEditor, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject) {
        this.a = nativeEditor;
        this.j = aliyunEditorProject;
    }

    private long a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        int parseInt = java.lang.Integer.parseInt(str);
        int parseInt2 = java.lang.Integer.parseInt(str2);
        int parseInt3 = java.lang.Integer.parseInt(str3) * 10;
        if (parseInt2 >= 60) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("时间格式不正确的项:[");
            sb.append(str);
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(str2);
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(str3);
            sb.append("]");
            parseInt += parseInt2 / 60;
            parseInt2 %= 60;
        }
        return (parseInt * 60 * 1000) + (parseInt2 * 1000) + parseInt3;
    }

    private com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip a(com.aliyun.svideosdk.editor.e.b bVar) {
        com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip rollCaptionTrackClip = new com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip();
        com.aliyun.svideosdk.editor.e.c b2 = b(bVar);
        rollCaptionTrackClip.setTimelineIn(bVar.a() / 1000.0f);
        rollCaptionTrackClip.setText(bVar.b());
        rollCaptionTrackClip.setFont(b2.b());
        rollCaptionTrackClip.setTextColor(b2.c());
        rollCaptionTrackClip.setOutlineColor(b2.f());
        return rollCaptionTrackClip;
    }

    private com.aliyun.svideosdk.editor.e.b a(int i) {
        java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.editor.e.b> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList != null && i >= 0 && i < copyOnWriteArrayList.size()) {
            return copyOnWriteArrayList.get(i);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("findCaptionInfo. caption not found at index ");
        sb.append(i);
        return null;
    }

    private com.aliyun.svideosdk.editor.e.b a(com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip rollCaptionTrackClip) {
        com.aliyun.svideosdk.editor.e.b bVar = new com.aliyun.svideosdk.editor.e.b();
        bVar.a((long) (rollCaptionTrackClip.getTimelineIn() * 1000.0f));
        bVar.a(rollCaptionTrackClip.getText());
        com.aliyun.svideosdk.editor.e.c cVar = new com.aliyun.svideosdk.editor.e.c();
        cVar.a(rollCaptionTrackClip.getTextColor());
        cVar.b(rollCaptionTrackClip.getOutlineColor());
        cVar.a(rollCaptionTrackClip.getFont());
        bVar.a(cVar);
        return bVar;
    }

    private com.aliyun.svideosdk.editor.e.b a(java.lang.String str) {
        java.lang.StringBuilder sb;
        java.util.regex.Matcher matcher = this.g.matcher(str);
        if (matcher.find()) {
            long a = a(matcher.group(1), matcher.group(2), matcher.group(3));
            java.lang.String substring = str.substring(matcher.end());
            if (!android.text.TextUtils.isEmpty(substring)) {
                com.aliyun.svideosdk.editor.e.b bVar = new com.aliyun.svideosdk.editor.e.b();
                bVar.a(a);
                bVar.a(substring);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("成功解析字幕：");
                sb2.append(bVar);
                return bVar;
            }
            sb = new java.lang.StringBuilder();
            sb.append("字幕文本不存在:");
        } else {
            sb = new java.lang.StringBuilder();
            sb.append("字幕格式不正确:");
            sb.append(str);
            str = ", 参考格式:[00:10:10]字幕内容";
        }
        sb.append(str);
        return null;
    }

    private static com.aliyun.svideosdk.editor.e.c a() {
        com.aliyun.svideosdk.editor.e.c cVar = new com.aliyun.svideosdk.editor.e.c();
        cVar.a(-1);
        cVar.b(0);
        return cVar;
    }

    private boolean a(boolean z) {
        java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.editor.e.b> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0 || !b()) {
            return false;
        }
        com.aliyun.svideosdk.editor.e.a.b bVar = new com.aliyun.svideosdk.editor.e.a.b();
        if (z) {
            this.i.execute(bVar);
            return true;
        }
        bVar.run();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.svideosdk.editor.e.c b(com.aliyun.svideosdk.editor.e.b bVar) {
        com.aliyun.svideosdk.editor.e.c cVar = this.e;
        return cVar != null ? cVar : bVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.f = z;
    }

    private boolean b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.editor.e.b> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(copyOnWriteArrayList.size());
        java.util.Iterator<com.aliyun.svideosdk.editor.e.b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        com.aliyun.svideosdk.common.struct.project.RollCaptionTrack rollCaptionTrack = new com.aliyun.svideosdk.common.struct.project.RollCaptionTrack();
        rollCaptionTrack.getRollCaptionTrackClips().addAll(arrayList);
        this.j.setRollCaptionTrack(rollCaptionTrack);
    }

    public void a(int i, int i2) {
        this.b = i;
        this.c = i2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("setDisplaySize width:");
        sb.append(i);
        sb.append(", height:");
        sb.append(i2);
    }

    public void a(android.content.Context context) {
        this.h = context;
    }

    public void a(com.aliyun.svideosdk.common.struct.project.RollCaptionTrack rollCaptionTrack) {
        if (rollCaptionTrack == null || rollCaptionTrack.getRollCaptionTrackClips().size() == 0) {
            this.d = null;
            return;
        }
        java.util.List<com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip> rollCaptionTrackClips = rollCaptionTrack.getRollCaptionTrackClips();
        java.util.ArrayList arrayList = new java.util.ArrayList(rollCaptionTrackClips.size());
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip> it = rollCaptionTrackClips.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        this.d = new java.util.concurrent.CopyOnWriteArrayList<>(arrayList);
        b(true);
        a(false);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer
    public com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor editCaptionFamilyStyle() {
        if (this.e == null) {
            this.e = a();
        }
        return new com.aliyun.svideosdk.editor.e.a.c(this.e);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer
    public com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor editCaptionStyle(int i) {
        com.aliyun.svideosdk.editor.e.b a = a(i);
        return new com.aliyun.svideosdk.editor.e.a.c(a != null ? a.c() : null);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer
    public void hide() {
        this.a.clearRollCaptions();
        b(true);
        this.j.clearRollCaptionTrack();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer
    public void reset() {
        hide();
        this.e = null;
        this.d = null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer
    public boolean show() {
        return a(true);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunRollCaptionComposer
    public void updateCaptionList(java.util.List<java.lang.String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("updateCaptionList size=");
        sb.append(list.size());
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            com.aliyun.svideosdk.editor.e.b a = a(it.next());
            if (a != null) {
                a.a(a());
                arrayList.add(a);
            }
        }
        this.d = new java.util.concurrent.CopyOnWriteArrayList<>(arrayList);
        b(true);
    }
}
