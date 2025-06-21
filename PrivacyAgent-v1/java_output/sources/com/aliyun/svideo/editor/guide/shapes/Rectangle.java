package com.aliyun.svideo.editor.guide.shapes;

/* loaded from: classes12.dex */
public class Rectangle implements com.aliyun.svideo.editor.guide.shapes.Shape {
    private float edgeRadius;
    private float highlightRadius;
    private boolean imageLineCenter;
    private int imageLineId;
    private boolean showEdge;
    private boolean showRound;
    private boolean sourceFromEdit;

    public Rectangle(boolean z, float f, boolean z2, float f2, int i, boolean z3, boolean z4) {
        this.showEdge = z;
        this.showRound = z2;
        this.highlightRadius = f2;
        this.imageLineId = i;
        this.edgeRadius = f;
        this.imageLineCenter = z3;
        this.sourceFromEdit = z4;
    }

    @Override // com.aliyun.svideo.editor.guide.shapes.Shape
    public void draw(android.graphics.Canvas canvas, android.content.Context context, android.graphics.PointF pointF, float f, com.aliyun.svideo.editor.guide.model.Target target, android.graphics.Paint paint) {
        int i;
        float f2;
        int[] iArr = new int[2];
        target.getView().getLocationInWindow(iArr);
        float f3 = iArr[0];
        pointF.x = f3;
        float f4 = iArr[1];
        pointF.y = f4;
        if (!this.showRound || this.highlightRadius <= 0.0f) {
            canvas.drawRect(f3, f4, f3 + target.getView().getWidth(), target.getView().getHeight() + pointF.y, paint);
        } else {
            float height = target.getView().getHeight() + pointF.y;
            float f5 = this.highlightRadius;
            canvas.drawRoundRect(f3, f4, f3 + target.getView().getWidth(), height, f5, f5, paint);
        }
        if (this.showEdge) {
            paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_OVER));
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            paint.setAntiAlias(true);
            paint.setColor(-1);
            paint.setStrokeWidth(com.moji.tool.DeviceTool.dp2px(1.0f));
            if (this.edgeRadius > 0.0f) {
                float dp2px = com.moji.tool.DeviceTool.dp2px(20.0f) + pointF.x;
                float dp2px2 = pointF.y - com.moji.tool.DeviceTool.dp2px(15.0f);
                float width = (pointF.x + target.getView().getWidth()) - com.moji.tool.DeviceTool.dp2px(20.0f);
                float height2 = pointF.y + target.getView().getHeight() + com.moji.tool.DeviceTool.dp2px(15.0f);
                float f6 = this.edgeRadius;
                i = -1;
                f2 = 1.0f;
                canvas.drawRoundRect(dp2px, dp2px2, width, height2, f6, f6, paint);
            } else {
                i = -1;
                f2 = 1.0f;
                canvas.drawRect(com.moji.tool.DeviceTool.dp2px(20.0f) + pointF.x, pointF.y - com.moji.tool.DeviceTool.dp2px(15.0f), (pointF.x + target.getView().getWidth()) - com.moji.tool.DeviceTool.dp2px(20.0f), pointF.y + target.getView().getHeight() + com.moji.tool.DeviceTool.dp2px(15.0f), paint);
            }
        } else {
            i = -1;
            f2 = 1.0f;
        }
        paint.setTextSize(com.moji.tool.DeviceTool.sp2px(13.0f));
        java.lang.String[] split = target.getMessage().split("\n");
        paint.setColor(i);
        android.graphics.Paint paint2 = new android.graphics.Paint();
        paint2.setColor(i);
        paint2.setTextSize(com.moji.tool.DeviceTool.sp2px(13.0f));
        paint2.setStrokeWidth(com.moji.tool.DeviceTool.dp2px(f2));
        char direction = target.getDirection();
        if (direction == 'b') {
            paint2.setTextAlign(android.graphics.Paint.Align.LEFT);
            if (this.imageLineId != 0) {
                canvas.drawBitmap(android.graphics.BitmapFactory.decodeResource(context.getResources(), this.imageLineId), (pointF.x + (target.getView().getWidth() / 2)) - (r1.getWidth() / 2), (pointF.y + target.getView().getHeight()) - com.moji.tool.DeviceTool.dp2px(10.0f), paint2);
                float height3 = pointF.y + target.getView().getHeight() + r1.getHeight();
                int length = split.length;
                for (int i2 = 0; i2 < split.length; i2++) {
                    canvas.drawText(split[i2], (pointF.x + target.getView().getWidth()) - paint2.measureText(split[0]), (i2 * (paint2.getTextSize() + com.moji.tool.DeviceTool.dp2px(3.0f))) + height3, paint2);
                }
                return;
            }
            return;
        }
        if (direction != 't') {
            return;
        }
        pointF.x += target.getView().getWidth() / 2;
        paint2.setTextAlign(android.graphics.Paint.Align.LEFT);
        if (this.imageLineId != 0) {
            android.graphics.Bitmap decodeResource = android.graphics.BitmapFactory.decodeResource(context.getResources(), this.imageLineId);
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.postScale(f2, -1.0f);
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
            float dp2px3 = (pointF.y + com.moji.tool.DeviceTool.dp2px(22.0f)) - createBitmap.getHeight();
            int length2 = split.length - 1;
            if (!this.imageLineCenter) {
                canvas.drawBitmap(createBitmap, pointF.x + com.moji.tool.DeviceTool.dp2px(9.0f), dp2px3, paint2);
                int i3 = 0;
                while (i3 < split.length) {
                    canvas.drawText(split[i3], (pointF.x - (paint2.measureText(split[0]) / 2.0f)) + com.moji.tool.DeviceTool.dp2px(9.0f), dp2px3 - (length2 * (paint2.getTextSize() + com.moji.tool.DeviceTool.dp2px(3.0f))), paint2);
                    i3++;
                    length2 += i;
                }
                return;
            }
            if (!this.sourceFromEdit) {
                canvas.drawBitmap(createBitmap, pointF.x - (decodeResource.getWidth() / 2), dp2px3, paint2);
                int i4 = 0;
                while (i4 < split.length) {
                    canvas.drawText(split[i4], pointF.x - (paint2.measureText(split[0]) / 2.0f), dp2px3 - (length2 * (paint2.getTextSize() + com.moji.tool.DeviceTool.dp2px(3.0f))), paint2);
                    i4++;
                    length2 += i;
                }
                return;
            }
            canvas.drawBitmap(createBitmap, pointF.x - (decodeResource.getWidth() / 2), dp2px3 - com.moji.tool.DeviceTool.dp2px(15.0f), paint2);
            float dp2px4 = dp2px3 - com.moji.tool.DeviceTool.dp2px(15.0f);
            int i5 = 0;
            while (i5 < split.length) {
                canvas.drawText(split[i5], pointF.x - (paint2.measureText(split[0]) / 2.0f), dp2px4 - (length2 * (paint2.getTextSize() + com.moji.tool.DeviceTool.dp2px(3.0f))), paint2);
                i5++;
                length2 += i;
            }
        }
    }

    @Override // com.aliyun.svideo.editor.guide.shapes.Shape
    public int getHeight() {
        return 0;
    }

    @Override // com.aliyun.svideo.editor.guide.shapes.Shape
    public int getWidth() {
        return 0;
    }
}
