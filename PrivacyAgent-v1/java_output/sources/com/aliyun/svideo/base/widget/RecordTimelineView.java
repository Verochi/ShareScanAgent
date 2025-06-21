package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class RecordTimelineView extends android.view.View {
    private static final java.lang.String TAG = "RecordTimelineView";
    private int backgroundColor;
    private java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo> clipDurationList;
    private com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo currentClipDuration;
    private int durationColor;
    private boolean isSelected;
    private int maxDuration;
    private int minDuration;
    private int offsetColor;
    private android.graphics.Paint paint;
    private android.graphics.RectF rectF;
    private int selectColor;

    /* renamed from: com.aliyun.svideo.base.widget.RecordTimelineView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideo$base$widget$RecordTimelineView$DrawType;

        static {
            int[] iArr = new int[com.aliyun.svideo.base.widget.RecordTimelineView.DrawType.values().length];
            $SwitchMap$com$aliyun$svideo$base$widget$RecordTimelineView$DrawType = iArr;
            try {
                iArr[com.aliyun.svideo.base.widget.RecordTimelineView.DrawType.OFFSET.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$base$widget$RecordTimelineView$DrawType[com.aliyun.svideo.base.widget.RecordTimelineView.DrawType.DURATION.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$base$widget$RecordTimelineView$DrawType[com.aliyun.svideo.base.widget.RecordTimelineView.DrawType.SELECT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public class DrawInfo {
        com.aliyun.svideo.base.widget.RecordTimelineView.DrawType drawType = com.aliyun.svideo.base.widget.RecordTimelineView.DrawType.DURATION;
        int length;

        public DrawInfo() {
        }
    }

    public enum DrawType {
        OFFSET,
        DURATION,
        SELECT
    }

    public RecordTimelineView(android.content.Context context) {
        super(context);
        this.clipDurationList = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.currentClipDuration = new com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo();
        this.paint = new android.graphics.Paint();
        this.rectF = new android.graphics.RectF();
        this.isSelected = false;
        init();
    }

    public RecordTimelineView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clipDurationList = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.currentClipDuration = new com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo();
        this.paint = new android.graphics.Paint();
        this.rectF = new android.graphics.RectF();
        this.isSelected = false;
        init();
    }

    public RecordTimelineView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.clipDurationList = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.currentClipDuration = new com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo();
        this.paint = new android.graphics.Paint();
        this.rectF = new android.graphics.RectF();
        this.isSelected = false;
        init();
    }

    private void init() {
        this.paint.setAntiAlias(true);
    }

    public void clear() {
        if (this.clipDurationList.size() >= 2) {
            this.clipDurationList.clear();
        }
        invalidate();
    }

    public void clipComplete() {
        this.clipDurationList.add(this.currentClipDuration);
        com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo drawInfo = new com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo();
        drawInfo.length = com.aliyun.svideo.common.utils.DensityUtils.px2dip(getContext(), this.maxDuration / 100);
        drawInfo.drawType = com.aliyun.svideo.base.widget.RecordTimelineView.DrawType.OFFSET;
        this.clipDurationList.add(drawInfo);
        this.currentClipDuration = new com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo();
        invalidate();
    }

    public void deleteLast() {
        if (this.clipDurationList.size() >= 2) {
            this.clipDurationList.remove(r0.size() - 1);
            this.clipDurationList.remove(r0.size() - 1);
        }
        invalidate();
    }

    public int getTimelineDuration() {
        java.util.Iterator<com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo> it = this.clipDurationList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo next = it.next();
            if (next.drawType == com.aliyun.svideo.base.widget.RecordTimelineView.DrawType.DURATION) {
                i += next.length;
            }
        }
        return i;
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (this.backgroundColor != 0) {
            this.paint.setColor(getResources().getColor(this.backgroundColor));
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.paint);
        }
        int i = 0;
        for (int i2 = 0; i2 < this.clipDurationList.size(); i2++) {
            com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo drawInfo = this.clipDurationList.get(i2);
            int i3 = com.aliyun.svideo.base.widget.RecordTimelineView.AnonymousClass1.$SwitchMap$com$aliyun$svideo$base$widget$RecordTimelineView$DrawType[drawInfo.drawType.ordinal()];
            if (i3 == 1) {
                this.paint.setColor(getResources().getColor(this.offsetColor));
            } else if (i3 == 2) {
                this.paint.setColor(getResources().getColor(this.durationColor));
            } else if (i3 != 3) {
                this.paint.setColor(getResources().getColor(this.offsetColor));
            } else {
                this.paint.setColor(getResources().getColor(this.selectColor));
            }
            if (drawInfo.drawType == com.aliyun.svideo.base.widget.RecordTimelineView.DrawType.OFFSET) {
                canvas.drawRect(((i - drawInfo.length) / this.maxDuration) * getWidth(), 0.0f, (i / this.maxDuration) * getWidth(), getHeight(), this.paint);
            } else {
                if (i2 == 0) {
                    this.rectF.set(0.0f, 0.0f, getHeight(), getHeight());
                    canvas.drawArc(this.rectF, 90.0f, 180.0f, true, this.paint);
                    float width = ((drawInfo.length + i) / this.maxDuration) * getWidth();
                    if (width > getHeight() / 2) {
                        canvas.drawRect(getHeight() / 2, 0.0f, width, getHeight(), this.paint);
                    }
                } else {
                    canvas.drawRect((i / this.maxDuration) * getWidth(), 0.0f, ((drawInfo.length + i) / this.maxDuration) * getWidth(), getHeight(), this.paint);
                }
                i += drawInfo.length;
            }
        }
        com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo drawInfo2 = this.currentClipDuration;
        if (drawInfo2 != null && drawInfo2.length != 0) {
            this.paint.setColor(getResources().getColor(this.durationColor));
            float width2 = (i / this.maxDuration) * getWidth();
            float width3 = ((this.currentClipDuration.length + i) / this.maxDuration) * getWidth();
            if (this.clipDurationList.size() == 0) {
                this.rectF.set(0.0f, 0.0f, getHeight(), getHeight());
                canvas.drawArc(this.rectF, 90.0f, 180.0f, true, this.paint);
                if (width3 > getHeight() / 2) {
                    canvas.drawRect(width2 + (getHeight() / 2), 0.0f, width3, getHeight(), this.paint);
                }
            } else {
                canvas.drawRect(width2, 0.0f, width3, getHeight(), this.paint);
            }
        }
        if (i + this.currentClipDuration.length < this.minDuration) {
            this.paint.setColor(getResources().getColor(this.offsetColor));
            int i4 = this.minDuration;
            canvas.drawRect((this.minDuration / this.maxDuration) * getWidth(), 0.0f, ((i4 + (r2 / 200)) / this.maxDuration) * getWidth(), getHeight(), this.paint);
        }
    }

    public void selectLast() {
        if (this.clipDurationList.size() >= 2) {
            java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo> copyOnWriteArrayList = this.clipDurationList;
            copyOnWriteArrayList.get(copyOnWriteArrayList.size() - 2).drawType = com.aliyun.svideo.base.widget.RecordTimelineView.DrawType.SELECT;
            invalidate();
            this.isSelected = true;
        }
    }

    public void setColor(int i, int i2, int i3, int i4) {
        this.durationColor = i;
        this.selectColor = i2;
        this.offsetColor = i3;
        this.backgroundColor = i4;
    }

    public void setDuration(int i) {
        if (this.isSelected) {
            java.util.Iterator<com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo> it = this.clipDurationList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo next = it.next();
                if (next.drawType == com.aliyun.svideo.base.widget.RecordTimelineView.DrawType.SELECT) {
                    next.drawType = com.aliyun.svideo.base.widget.RecordTimelineView.DrawType.DURATION;
                    this.isSelected = false;
                    break;
                }
            }
        }
        com.aliyun.svideo.base.widget.RecordTimelineView.DrawInfo drawInfo = this.currentClipDuration;
        drawInfo.drawType = com.aliyun.svideo.base.widget.RecordTimelineView.DrawType.DURATION;
        drawInfo.length = i;
        invalidate();
    }

    public void setMaxDuration(int i) {
        this.maxDuration = i;
    }

    public void setMinDuration(int i) {
        this.minDuration = i;
    }
}
