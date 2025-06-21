package com.aliyun.svideosdk.common.struct.project;

/* loaded from: classes12.dex */
public class DynamicImage implements com.aliyun.common.resource.Resource, java.io.Serializable {
    public static final int TYPE_FACE = 1;
    public static final int TYPE_NORMAL = 2;
    public static final int TYPE_TEXT = 0;
    private static final long serialVersionUID = -4514700931607474217L;
    public float a;
    public float c;
    public float du;
    public int extendSection;
    public float fh;
    public long fid;
    public long fontId;
    public java.util.List<com.aliyun.svideosdk.common.struct.project.Frame> frameArry;
    public float fw;
    public float fx;
    public float fy;
    public float h;
    public boolean hasTextLabel;
    public int kernelFrame = -1;
    public java.lang.String n;
    public int pExtend;
    public java.lang.String pText;
    public java.lang.String path;
    public long pid;
    public int strokeB;
    public int strokeG;
    public int strokeR;
    public int strokeWidth;
    public float tAngle;
    public int tB;
    public float tBegin;
    public float tEnd;
    public java.lang.String tFont;
    public int tG;
    public float tHeight;
    public float tLeft;
    public float tMaxSize;
    public float tMinSize;
    public int tR;
    public float tSize;
    public float tTop;
    public float tWidth;
    public int textLabelColor;
    public java.util.List<com.aliyun.svideosdk.common.struct.project.FrameTime> timeArry;
    public int type;
    public boolean variableLab;
    public float variableLabHeight;
    public float variableLabLeft;
    public java.lang.String variableLabText;
    public float variableLabTop;
    public java.lang.String variableLabType;
    public float variableLabWidth;
    public float w;
    public float x;
    public float y;

    private int getKernelFrame() {
        int i = this.kernelFrame;
        if (i != -1) {
            return i;
        }
        if (this.extendSection == 1 && this.timeArry.size() > 1) {
            float f = (float) this.timeArry.get(1).beginTime;
            for (com.aliyun.svideosdk.common.struct.project.Frame frame : this.frameArry) {
                if (f == frame.time) {
                    return frame.pic;
                }
            }
        }
        java.util.List<com.aliyun.svideosdk.common.struct.project.Frame> list = this.frameArry;
        if (list == null || list.size() == 0) {
            return 0;
        }
        java.util.List<com.aliyun.svideosdk.common.struct.project.Frame> list2 = this.frameArry;
        return list2.get(list2.size() - 1).pic;
    }

    public static com.aliyun.svideosdk.common.struct.project.DynamicImage getTextOnlyConfig() {
        com.aliyun.svideosdk.common.struct.project.DynamicImage dynamicImage = new com.aliyun.svideosdk.common.struct.project.DynamicImage();
        dynamicImage.pid = 1L;
        dynamicImage.fid = 1L;
        dynamicImage.du = 1.0f;
        dynamicImage.type = 0;
        dynamicImage.x = 320.0f;
        dynamicImage.y = 320.0f;
        dynamicImage.w = 470.0f;
        dynamicImage.h = 160.0f;
        dynamicImage.a = 0.0f;
        dynamicImage.fx = 0.0f;
        dynamicImage.fy = 0.0f;
        dynamicImage.fw = 0.0f;
        dynamicImage.fh = 0.0f;
        dynamicImage.n = "text_sample";
        dynamicImage.c = 8.0f;
        dynamicImage.pText = "请输入文字";
        dynamicImage.tFont = "SentyTEA";
        dynamicImage.tMinSize = 21.0f;
        dynamicImage.tSize = 48.0f;
        dynamicImage.tLeft = 235.0f;
        dynamicImage.tTop = 80.0f;
        dynamicImage.tWidth = 460.0f;
        dynamicImage.tHeight = 120.0f;
        dynamicImage.strokeR = 51;
        dynamicImage.strokeG = 51;
        dynamicImage.strokeB = 51;
        dynamicImage.strokeWidth = 4;
        dynamicImage.pExtend = 1;
        dynamicImage.extendSection = 0;
        dynamicImage.tR = 255;
        dynamicImage.tG = 255;
        dynamicImage.tB = 255;
        dynamicImage.tBegin = 0.0f;
        dynamicImage.tEnd = 1.0f;
        return dynamicImage;
    }

    public void fillPaster(com.aliyun.svideosdk.common.struct.project.SubTitleTrack subTitleTrack) {
        subTitleTrack.setWidth(this.w);
        subTitleTrack.setHeight(this.h);
        subTitleTrack.setX(this.x);
        subTitleTrack.setY(this.y);
        subTitleTrack.setName(this.n);
        subTitleTrack.setTimelineIn(0.0f);
        subTitleTrack.setTimelineOut(this.du);
        subTitleTrack.setPreBegin(this.tBegin);
        subTitleTrack.setPreEnd(this.tEnd);
        subTitleTrack.setTextColor(getTextColor());
        subTitleTrack.setTextStrokeColor(getTextStrokeColor());
        subTitleTrack.setRotation(0.0f);
        subTitleTrack.setTextRotation((float) java.lang.Math.toRadians(this.tAngle));
        subTitleTrack.setText(this.pText);
        subTitleTrack.setTextWidth(this.tWidth);
        subTitleTrack.setTextHeight(this.tHeight);
        subTitleTrack.setFrameArray(this.frameArry);
        subTitleTrack.setTimeArray(this.timeArry);
        subTitleTrack.setTextBackgroundColor(this.textLabelColor);
        if (subTitleTrack instanceof com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) {
            com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack bubbleCaptionTrack = (com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) subTitleTrack;
            bubbleCaptionTrack.setTextCenterX(this.tLeft);
            bubbleCaptionTrack.setTextCenterY(this.tTop);
        }
    }

    public float getA() {
        return this.a;
    }

    public float getC() {
        return this.c;
    }

    public float getDu() {
        return this.du;
    }

    public int getExtendSection() {
        return this.extendSection;
    }

    public float getFh() {
        return this.fh;
    }

    public long getFid() {
        return this.fid;
    }

    public long getFontId() {
        return this.fontId;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.Frame> getFrameArry() {
        return this.frameArry;
    }

    public float getFw() {
        return this.fw;
    }

    public float getFx() {
        return this.fx;
    }

    public float getFy() {
        return this.fy;
    }

    public float getH() {
        return this.h;
    }

    public java.lang.String getN() {
        return this.n;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public long getPid() {
        return this.pid;
    }

    public int getStrokeB() {
        return this.strokeB;
    }

    public int getStrokeG() {
        return this.strokeG;
    }

    public int getStrokeR() {
        return this.strokeR;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public int getTextColor() {
        return android.graphics.Color.argb(255, this.tR, this.tG, this.tB);
    }

    public int getTextStrokeColor() {
        return android.graphics.Color.argb(255, this.strokeR, this.strokeG, this.strokeB);
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.FrameTime> getTimeArry() {
        return this.timeArry;
    }

    public int getType() {
        return this.type;
    }

    public float getVariableLabHeight() {
        return this.variableLabHeight;
    }

    public float getVariableLabLeft() {
        return this.variableLabLeft;
    }

    public java.lang.String getVariableLabText() {
        return this.variableLabText;
    }

    public float getVariableLabTop() {
        return this.variableLabTop;
    }

    public java.lang.String getVariableLabType() {
        return this.variableLabType;
    }

    public float getVariableLabWidth() {
        return this.variableLabWidth;
    }

    public float getW() {
        return this.w;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public java.lang.String getpText() {
        return this.pText;
    }

    public float gettAngle() {
        return this.tAngle;
    }

    public int gettB() {
        return this.tB;
    }

    public float gettBegin() {
        return this.tBegin;
    }

    public float gettEnd() {
        return this.tEnd;
    }

    public java.lang.String gettFont() {
        return this.tFont;
    }

    public int gettG() {
        return this.tG;
    }

    public float gettHeight() {
        return this.tHeight;
    }

    public float gettLeft() {
        return this.tLeft;
    }

    public float gettMaxSize() {
        return this.tMaxSize;
    }

    public float gettMinSize() {
        return this.tMinSize;
    }

    public int gettR() {
        return this.tR;
    }

    public float gettSize() {
        return this.tSize;
    }

    public float gettTop() {
        return this.tTop;
    }

    public float gettWidth() {
        return this.tWidth;
    }

    public boolean isVariableLab() {
        return this.variableLab;
    }

    public int ispExtend() {
        return this.pExtend;
    }

    public void setA(float f) {
        this.a = f;
    }

    public void setC(float f) {
        this.c = f;
    }

    public void setDu(float f) {
        this.du = f;
    }

    public void setExtendSection(int i) {
        this.extendSection = i;
    }

    public void setFh(float f) {
        this.fh = f;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setFontId(long j) {
        this.fontId = j;
    }

    public void setFrameArry(java.util.List<com.aliyun.svideosdk.common.struct.project.Frame> list) {
        this.frameArry = list;
    }

    public void setFw(float f) {
        this.fw = f;
    }

    public void setFx(float f) {
        this.fx = f;
    }

    public void setFy(float f) {
        this.fy = f;
    }

    public void setH(float f) {
        this.h = f;
    }

    public void setKernelFrame(int i) {
        this.kernelFrame = i;
    }

    public void setN(java.lang.String str) {
        this.n = str;
    }

    public void setPath(java.lang.String str) {
        this.path = str;
    }

    public void setPid(long j) {
        this.pid = j;
    }

    public void setStrokeB(int i) {
        this.strokeB = i;
    }

    public void setStrokeG(int i) {
        this.strokeG = i;
    }

    public void setStrokeR(int i) {
        this.strokeR = i;
    }

    public void setStrokeWidth(int i) {
        this.strokeWidth = i;
    }

    public void setTimeArry(java.util.List<com.aliyun.svideosdk.common.struct.project.FrameTime> list) {
        this.timeArry = list;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setVariableLab(boolean z) {
        this.variableLab = z;
    }

    public void setVariableLabHeight(float f) {
        this.variableLabHeight = f;
    }

    public void setVariableLabLeft(float f) {
        this.variableLabLeft = f;
    }

    public void setVariableLabText(java.lang.String str) {
        this.variableLabText = str;
    }

    public void setVariableLabTop(float f) {
        this.variableLabTop = f;
    }

    public void setVariableLabType(java.lang.String str) {
        this.variableLabType = str;
    }

    public void setVariableLabWidth(float f) {
        this.variableLabWidth = f;
    }

    public void setW(float f) {
        this.w = f;
    }

    public void setX(float f) {
        this.x = f;
    }

    public void setY(float f) {
        this.y = f;
    }

    public void setpExtend(int i) {
        this.pExtend = i;
    }

    public void setpText(java.lang.String str) {
        this.pText = str;
    }

    public void settAngle(float f) {
        this.tAngle = f;
    }

    public void settB(int i) {
        this.tB = i;
    }

    public void settBegin(float f) {
        this.tBegin = f;
    }

    public void settEnd(float f) {
        this.tEnd = f;
    }

    public void settFont(java.lang.String str) {
        this.tFont = str;
    }

    public void settG(int i) {
        this.tG = i;
    }

    public void settHeight(float f) {
        this.tHeight = f;
    }

    public void settLeft(float f) {
        this.tLeft = f;
    }

    public void settMaxSize(float f) {
        this.tMaxSize = f;
    }

    public void settMinSize(float f) {
        this.tMinSize = f;
    }

    public void settR(int i) {
        this.tR = i;
    }

    public void settSize(float f) {
        this.tSize = f;
    }

    public void settTop(float f) {
        this.tTop = f;
    }

    public void settWidth(float f) {
        this.tWidth = f;
    }

    @Override // com.aliyun.common.resource.Resource
    public boolean validate() {
        java.util.List<com.aliyun.svideosdk.common.struct.project.FrameTime> list;
        if (android.text.TextUtils.equals(this.n, "text_sample")) {
            return true;
        }
        java.util.List<com.aliyun.svideosdk.common.struct.project.Frame> list2 = this.frameArry;
        return (list2 == null || list2.isEmpty() || (list = this.timeArry) == null || list.isEmpty()) ? false : true;
    }
}
