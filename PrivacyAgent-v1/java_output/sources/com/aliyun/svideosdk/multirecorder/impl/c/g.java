package com.aliyun.svideosdk.multirecorder.impl.c;

/* loaded from: classes12.dex */
public class g implements com.aliyun.svideosdk.multirecorder.impl.c.d, com.aliyun.svideosdk.multirecorder.AliyunIVideoCapture, com.aliyun.svideosdk.multirecorder.impl.c.e.c, com.aliyun.svideosdk.multirecorder.impl.c.c.b {
    private com.aliyun.svideosdk.multirecorder.impl.c.b d;
    private com.aliyun.svideosdk.multirecorder.impl.c.c f;
    private android.content.Context g;
    private com.aliyun.svideosdk.recorder.NativeRecorder h;
    private com.aliyun.common.log.reporter.AlivcRecorderReporter i;
    private com.aliyun.svideosdk.multirecorder.impl.c.g.c k;
    private com.aliyun.svideosdk.multirecorder.impl.b l;
    private boolean a = false;
    private volatile boolean b = false;
    private boolean e = false;
    private com.aliyun.svideosdk.preview.utils.CameraVersion.Version j = com.aliyun.svideosdk.preview.utils.CameraVersion.Version.CAMERA1;
    private java.lang.Integer m = null;
    private java.lang.Integer n = null;
    private java.lang.Integer o = null;
    private java.util.Map<java.lang.Integer, com.aliyun.svideosdk.multirecorder.impl.c.e> c = new java.util.concurrent.ConcurrentHashMap();

    public class a implements com.aliyun.svideosdk.multirecorder.impl.c.e.b<java.lang.Object> {
        final /* synthetic */ com.aliyun.svideosdk.multirecorder.impl.c.e a;

        public a(com.aliyun.svideosdk.multirecorder.impl.c.e eVar) {
            this.a = eVar;
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.b
        public void a(java.lang.Object obj) {
            if (obj != null) {
                if (this.a.e() != com.aliyun.svideosdk.multirecorder.impl.c.e.a.BITMAP) {
                    com.aliyun.svideosdk.multirecorder.impl.c.g.this.h.addVideoBuffer(this.a.b(), ((java.lang.Integer) obj).intValue());
                    return;
                }
                com.aliyun.common.media.ShareableBitmap shareableBitmap = (com.aliyun.common.media.ShareableBitmap) obj;
                com.aliyun.svideosdk.multirecorder.impl.c.g.this.h.addVideoBufferBitmap(this.a.b(), shareableBitmap.getData());
                shareableBitmap.release();
            }
        }
    }

    public class b implements com.aliyun.svideosdk.multirecorder.impl.c.b.e {
        public b() {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.b.e
        public void a(int i) {
            if (com.aliyun.svideosdk.multirecorder.impl.c.g.this.k != null) {
                com.aliyun.svideosdk.multirecorder.impl.c.g.this.k.a(i);
            }
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.b.e
        public void a(int i, float f, float f2, float f3, float f4) {
            com.aliyun.svideosdk.multirecorder.impl.c.g.this.d.b().getStickerManager().updateStickerPosition(i, f, f2, f3, f4);
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.b.e
        public void onInitReady() {
            if (com.aliyun.svideosdk.multirecorder.impl.c.g.this.k != null) {
                com.aliyun.svideosdk.multirecorder.impl.c.g.this.k.onInitReady();
            }
        }
    }

    public interface c {
        void a();

        void a(int i);

        void onInitReady();
    }

    public g(android.content.Context context, com.aliyun.svideosdk.recorder.NativeRecorder nativeRecorder, com.aliyun.svideosdk.multirecorder.impl.b bVar, com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter) {
        this.g = context;
        this.h = nativeRecorder;
        this.l = bVar;
        this.i = alivcRecorderReporter;
    }

    private void b(com.aliyun.svideosdk.multirecorder.impl.c.e eVar, com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam aliyunLayoutParam) {
        com.aliyun.svideosdk.common.AliyunRecordVideoSource createVideoWithInfo = com.aliyun.svideosdk.common.AliyunRecordVideoSource.createVideoWithInfo(1, 1);
        createVideoWithInfo.setLayoutInfo(new com.aliyun.svideosdk.common.AliyunRecordVideoSource.LayoutInfo(aliyunLayoutParam.getWidthRatio(), aliyunLayoutParam.getHeightRatio(), aliyunLayoutParam.getCenterX(), aliyunLayoutParam.getCenterY(), 0, aliyunLayoutParam.getDisplayMode().ordinal(), eVar.c(), eVar.d()));
        createVideoWithInfo.setVideoNeedOutput(true);
        createVideoWithInfo.setVideoNeedRender(eVar.h());
        this.h.addSource(createVideoWithInfo);
        eVar.a(createVideoWithInfo, aliyunLayoutParam, this.l);
        eVar.a(this);
    }

    private void i() {
        if (l() && !this.a) {
            throw new java.lang.RuntimeException("You have to call prepare() before startPreview() or startRecording()");
        }
        if (this.a) {
            return;
        }
        prepare();
    }

    private void j() {
        java.lang.System.currentTimeMillis();
        boolean z = !this.b;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.svideosdk.multirecorder.impl.c.e eVar : this.c.values()) {
            if (!z || eVar.h()) {
                arrayList.add(eVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.aliyun.svideosdk.multirecorder.impl.c.e eVar2 = (com.aliyun.svideosdk.multirecorder.impl.c.e) it.next();
            eVar2.a(new com.aliyun.svideosdk.multirecorder.impl.c.g.a(eVar2));
        }
    }

    private boolean k() {
        java.util.Collection<com.aliyun.svideosdk.multirecorder.impl.c.e> values = this.c.values();
        if (values.isEmpty()) {
            return true;
        }
        java.util.Iterator<com.aliyun.svideosdk.multirecorder.impl.c.e> it = values.iterator();
        while (it.hasNext()) {
            if (!it.next().a()) {
                return false;
            }
        }
        return true;
    }

    private boolean l() {
        return com.aliyun.svideosdk.AlivcSdkCore.AlivcLogLevel.AlivcLogClose != com.aliyun.svideosdk.AlivcSdkCore.getLogLevel() && com.aliyun.svideosdk.AlivcSdkCore.AlivcLogLevel.AlivcLogDebug.getValue() >= com.aliyun.svideosdk.AlivcSdkCore.getLogLevel().getValue();
    }

    private void m() {
        java.lang.Integer num = this.m;
        if (num != null) {
            a(num.intValue());
            this.m = null;
        }
        java.lang.Integer num2 = this.n;
        if (num2 == null || this.o == null) {
            return;
        }
        a(num2.intValue(), this.o.intValue());
        this.n = null;
        this.o = null;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(int i) {
        if (!this.a) {
            this.m = java.lang.Integer.valueOf(i);
            return;
        }
        java.util.Iterator<com.aliyun.svideosdk.multirecorder.impl.c.e> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().a(i);
        }
        com.aliyun.svideosdk.multirecorder.impl.c.c cVar = this.f;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(int i, int i2) {
        if (!this.a) {
            this.n = java.lang.Integer.valueOf(i);
            this.o = java.lang.Integer.valueOf(i2);
        } else {
            java.util.Iterator<com.aliyun.svideosdk.multirecorder.impl.c.e> it = this.c.values().iterator();
            while (it.hasNext()) {
                it.next().a(i, i2);
            }
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.c
    public void a(com.aliyun.svideosdk.multirecorder.impl.c.e eVar) {
        if (eVar.f()) {
            g();
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.c
    public void a(com.aliyun.svideosdk.multirecorder.impl.c.e eVar, com.aliyun.svideosdk.common.struct.common.AliyunBorderParam aliyunBorderParam, int i, int i2) {
        float cornerRadius = aliyunBorderParam.getCornerRadius();
        if (cornerRadius < 0.0f) {
            cornerRadius = (aliyunBorderParam.getCorner() * 1.0f) / i;
        }
        eVar.b().setPureColorBorder((aliyunBorderParam.getBorderWidth() * 1.0f) / i, aliyunBorderParam.getBorderColor(), cornerRadius);
        this.h.updateSource(eVar.b());
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.c
    public void a(com.aliyun.svideosdk.multirecorder.impl.c.e eVar, com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam aliyunLayoutParam) {
        eVar.b().setLayoutInfo(new com.aliyun.svideosdk.common.AliyunRecordVideoSource.LayoutInfo(aliyunLayoutParam.getWidthRatio(), aliyunLayoutParam.getHeightRatio(), aliyunLayoutParam.getCenterX(), aliyunLayoutParam.getCenterY(), 0, aliyunLayoutParam.getDisplayMode().ordinal(), eVar.c(), eVar.d()));
        this.h.updateSource(eVar.b());
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.c
    public void a(com.aliyun.svideosdk.multirecorder.impl.c.e eVar, boolean z) {
        eVar.b().setMirrorInfo(z ? 1 : 0);
        this.h.updateSource(eVar.b());
    }

    public void a(com.aliyun.svideosdk.multirecorder.impl.c.g.c cVar) {
        this.k = cVar;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(boolean z) {
        this.b = false;
        com.aliyun.svideosdk.multirecorder.impl.c.c cVar = this.f;
        if (cVar != null && !this.e) {
            cVar.d();
        }
        java.util.Iterator<com.aliyun.svideosdk.multirecorder.impl.c.e> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().a(z);
        }
    }

    public boolean a() {
        return k();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoCapture
    public com.aliyun.svideosdk.multirecorder.AliyunICameraCapture addCameraCapture(com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam aliyunLayoutParam) {
        if (this.a) {
            throw new java.lang.RuntimeException("Have to call addCameraCapture() before AliyunIVideoRecorder#prepare() called");
        }
        if (this.d != null) {
            throw new java.lang.RuntimeException("You can only add one camera capture");
        }
        com.aliyun.svideosdk.multirecorder.impl.c.b bVar = new com.aliyun.svideosdk.multirecorder.impl.c.b(this.g, this.j, this.h, this.i);
        this.d = bVar;
        b(bVar, aliyunLayoutParam);
        this.d.a(new com.aliyun.svideosdk.multirecorder.impl.c.g.b());
        this.c.put(java.lang.Integer.valueOf(this.d.n()), this.d);
        return this.d;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoCapture
    public com.aliyun.svideosdk.multirecorder.AliyunIViewCapture addViewCapture(com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam aliyunLayoutParam, android.view.View view) {
        if (this.a) {
            throw new java.lang.RuntimeException("Have to call addViewCapture() before AliyunIVideoRecorder#prepare() called");
        }
        com.aliyun.svideosdk.multirecorder.impl.c.h hVar = new com.aliyun.svideosdk.multirecorder.impl.c.h();
        hVar.a(this.n.intValue(), this.o.intValue());
        hVar.setCaptureView(view);
        b(hVar, aliyunLayoutParam);
        this.c.put(java.lang.Integer.valueOf(hVar.n()), hVar);
        return hVar;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.c
    public void b(com.aliyun.svideosdk.multirecorder.impl.c.e eVar) {
        com.aliyun.svideosdk.multirecorder.impl.c.g.c cVar;
        if (!k() || (cVar = this.k) == null) {
            return;
        }
        cVar.a();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.c
    public void c(com.aliyun.svideosdk.multirecorder.impl.c.e eVar) {
        eVar.b().setPureColorBorder(0.0f, 0, 0.0f);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void destroy() {
        com.aliyun.svideosdk.multirecorder.impl.c.c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
        this.d = null;
        for (com.aliyun.svideosdk.multirecorder.impl.c.e eVar : this.c.values()) {
            eVar.destroy();
            this.h.removeSource(eVar.b());
            eVar.b().release();
        }
        this.c.clear();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.c.b
    public void g() {
        j();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void prepare() {
        com.aliyun.svideosdk.multirecorder.impl.c.g.c cVar;
        if (this.a) {
            return;
        }
        if (this.c.isEmpty()) {
            throw new java.lang.RuntimeException("You have to add at least one video capture");
        }
        boolean z = true;
        for (com.aliyun.svideosdk.multirecorder.impl.c.e eVar : this.c.values()) {
            eVar.prepare();
            if (eVar.f()) {
                if (!z) {
                    throw new java.lang.RuntimeException("You have to set only one main capture");
                }
                z = false;
            }
        }
        if (z) {
            this.f = new com.aliyun.svideosdk.multirecorder.impl.c.c(this);
        }
        if (this.d == null && (cVar = this.k) != null) {
            cVar.onInitReady();
        }
        this.a = true;
        m();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startPreview() {
        i();
        int i = 0;
        boolean z = false;
        for (com.aliyun.svideosdk.multirecorder.impl.c.e eVar : this.c.values()) {
            if (eVar.h()) {
                z = true;
            }
            i = eVar.startPreview();
            if (i != 0) {
                break;
            }
        }
        if (!z) {
            return i;
        }
        if (i == 0) {
            com.aliyun.svideosdk.multirecorder.impl.c.c cVar = this.f;
            if (cVar != null) {
                this.e = true;
                cVar.a(false);
            }
        } else {
            stopPreview();
        }
        return i;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startRecording() {
        i();
        this.b = true;
        java.util.Iterator<com.aliyun.svideosdk.multirecorder.impl.c.e> it = this.c.values().iterator();
        int i = 0;
        while (it.hasNext() && (i = it.next().startRecording()) == 0) {
        }
        if (i == 0) {
            com.aliyun.svideosdk.multirecorder.impl.c.c cVar = this.f;
            if (cVar != null && !this.e) {
                cVar.a(false);
            }
        } else {
            a(true);
        }
        return i;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void stopPreview() {
        com.aliyun.svideosdk.multirecorder.impl.c.c cVar = this.f;
        if (cVar != null) {
            this.e = false;
            cVar.d();
        }
        java.util.Iterator<com.aliyun.svideosdk.multirecorder.impl.c.e> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().stopPreview();
        }
    }
}
