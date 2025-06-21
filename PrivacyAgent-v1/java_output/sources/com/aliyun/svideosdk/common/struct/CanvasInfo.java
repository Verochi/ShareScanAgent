package com.aliyun.svideosdk.common.struct;

/* loaded from: classes12.dex */
public class CanvasInfo implements java.io.Serializable {
    public static java.lang.String mSavePath = "/sdcard/pathinfo";
    private com.aliyun.svideosdk.common.struct.CanvasInfo.SerInfo mCurrentInfo;
    java.util.List<com.aliyun.svideosdk.common.struct.CanvasInfo.SerInfo> mSerPaths = new java.util.ArrayList();

    public class SerInfo implements java.io.Serializable {
        private int mColor;
        private java.util.List<com.aliyun.svideosdk.common.struct.CanvasInfo.SerPoint> mPoints = new java.util.ArrayList();
        private float mWidth;

        public SerInfo() {
        }

        public com.aliyun.svideosdk.common.struct.CanvasInfo.SerInfo convertCoordinate(int i, int i2, boolean z) {
            com.aliyun.svideosdk.common.struct.CanvasInfo.SerInfo serInfo = com.aliyun.svideosdk.common.struct.CanvasInfo.this.new SerInfo();
            serInfo.mColor = this.mColor;
            float f = this.mWidth;
            float f2 = i;
            serInfo.mWidth = z ? f * f2 : f / f2;
            for (com.aliyun.svideosdk.common.struct.CanvasInfo.SerPoint serPoint : this.mPoints) {
                java.util.List<com.aliyun.svideosdk.common.struct.CanvasInfo.SerPoint> list = serInfo.mPoints;
                com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo = com.aliyun.svideosdk.common.struct.CanvasInfo.this;
                float f3 = serPoint.x;
                float f4 = i;
                list.add(z ? canvasInfo.new SerPoint(f3 * f4, serPoint.y * i2) : canvasInfo.new SerPoint(f3 / f4, serPoint.y / i2));
            }
            return serInfo;
        }
    }

    public class SerPoint implements java.io.Serializable {
        public float x;
        public float y;

        public SerPoint(float f, float f2) {
            this.x = f;
            this.y = f2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.IOException, java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.aliyun.svideosdk.common.struct.CanvasInfo load() {
        com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo;
        java.lang.ClassNotFoundException e;
        com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo2;
        java.io.IOException e2;
        java.io.StreamCorruptedException e3;
        java.io.FileNotFoundException e4;
        java.io.ObjectInputStream objectInputStream;
        java.lang.Throwable th;
        java.io.ObjectInputStream objectInputStream2 = null;
        com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo3 = null;
        com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo4 = null;
        com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo5 = null;
        com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo6 = null;
        java.io.ObjectInputStream objectInputStream3 = null;
        java.io.ObjectInputStream objectInputStream4 = null;
        java.io.ObjectInputStream objectInputStream5 = null;
        java.io.ObjectInputStream objectInputStream6 = null;
        java.io.ObjectInputStream objectInputStream7 = null;
        try {
            try {
                objectInputStream = new java.io.ObjectInputStream(new java.io.FileInputStream(mSavePath));
                try {
                    canvasInfo = (com.aliyun.svideosdk.common.struct.CanvasInfo) objectInputStream.readObject();
                } catch (java.io.FileNotFoundException e5) {
                    e4 = e5;
                } catch (java.io.StreamCorruptedException e6) {
                    e3 = e6;
                } catch (java.io.IOException e7) {
                    e2 = e7;
                } catch (java.lang.ClassNotFoundException e8) {
                    e = e8;
                } catch (java.lang.Throwable th2) {
                    canvasInfo = null;
                    th = th2;
                }
            } catch (java.lang.Throwable th3) {
                com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo7 = canvasInfo2;
                objectInputStream = objectInputStream2;
                th = th3;
                canvasInfo = canvasInfo7;
            }
        } catch (java.io.FileNotFoundException e9) {
            e4 = e9;
            canvasInfo2 = null;
        } catch (java.io.StreamCorruptedException e10) {
            e3 = e10;
            canvasInfo2 = null;
        } catch (java.io.IOException e11) {
            e2 = e11;
            canvasInfo2 = null;
        } catch (java.lang.ClassNotFoundException e12) {
            e = e12;
            canvasInfo2 = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            canvasInfo = null;
            if (objectInputStream7 != null) {
                try {
                    objectInputStream7.close();
                } catch (java.io.IOException e13) {
                    e13.printStackTrace();
                }
            }
            if (canvasInfo == null) {
                throw th;
            }
            new com.aliyun.svideosdk.common.struct.CanvasInfo();
            throw th;
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("load ok, size = ");
            sb.append(canvasInfo.mSerPaths.size());
            try {
                objectInputStream.close();
                return canvasInfo;
            } catch (java.io.IOException e14) {
                e14.printStackTrace();
                return canvasInfo;
            }
        } catch (java.io.FileNotFoundException e15) {
            e4 = e15;
            canvasInfo3 = canvasInfo;
            canvasInfo2 = canvasInfo3;
            objectInputStream3 = objectInputStream;
            e4.printStackTrace();
            objectInputStream2 = objectInputStream3;
            if (objectInputStream3 != null) {
                try {
                    objectInputStream3.close();
                    objectInputStream2 = objectInputStream3;
                } catch (java.io.IOException e16) {
                    e16.printStackTrace();
                    objectInputStream2 = e16;
                }
            }
            if (canvasInfo2 == null) {
                return new com.aliyun.svideosdk.common.struct.CanvasInfo();
            }
            return canvasInfo2;
        } catch (java.io.StreamCorruptedException e17) {
            e3 = e17;
            canvasInfo4 = canvasInfo;
            canvasInfo2 = canvasInfo4;
            objectInputStream4 = objectInputStream;
            e3.printStackTrace();
            objectInputStream2 = objectInputStream4;
            if (objectInputStream4 != null) {
                try {
                    objectInputStream4.close();
                    objectInputStream2 = objectInputStream4;
                } catch (java.io.IOException e18) {
                    e18.printStackTrace();
                    objectInputStream2 = e18;
                }
            }
            if (canvasInfo2 == null) {
                return new com.aliyun.svideosdk.common.struct.CanvasInfo();
            }
            return canvasInfo2;
        } catch (java.io.IOException e19) {
            e2 = e19;
            canvasInfo5 = canvasInfo;
            canvasInfo2 = canvasInfo5;
            objectInputStream5 = objectInputStream;
            e2.printStackTrace();
            objectInputStream2 = objectInputStream5;
            if (objectInputStream5 != null) {
                try {
                    objectInputStream5.close();
                    objectInputStream2 = objectInputStream5;
                } catch (java.io.IOException e20) {
                    e20.printStackTrace();
                    objectInputStream2 = e20;
                }
            }
            if (canvasInfo2 == null) {
                return new com.aliyun.svideosdk.common.struct.CanvasInfo();
            }
            return canvasInfo2;
        } catch (java.lang.ClassNotFoundException e21) {
            e = e21;
            canvasInfo6 = canvasInfo;
            canvasInfo2 = canvasInfo6;
            objectInputStream6 = objectInputStream;
            e.printStackTrace();
            objectInputStream2 = objectInputStream6;
            if (objectInputStream6 != null) {
                try {
                    objectInputStream6.close();
                    objectInputStream2 = objectInputStream6;
                } catch (java.io.IOException e22) {
                    e22.printStackTrace();
                    objectInputStream2 = e22;
                }
            }
            if (canvasInfo2 == null) {
                return new com.aliyun.svideosdk.common.struct.CanvasInfo();
            }
            return canvasInfo2;
        } catch (java.lang.Throwable th5) {
            th = th5;
            java.io.ObjectInputStream objectInputStream8 = objectInputStream;
            th = th;
            objectInputStream7 = objectInputStream8;
            if (objectInputStream7 != null) {
            }
            if (canvasInfo == null) {
            }
        }
    }

    private android.graphics.Paint transferPaint(com.aliyun.svideosdk.common.struct.CanvasInfo.SerInfo serInfo) {
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeWidth(serInfo.mWidth);
        paint.setColor(serInfo.mColor);
        return paint;
    }

    private android.graphics.Path transferPath(com.aliyun.svideosdk.common.struct.CanvasInfo.SerInfo serInfo) {
        android.graphics.Path path = new android.graphics.Path();
        int size = serInfo.mPoints.size();
        if (size < 3) {
            return path;
        }
        com.aliyun.svideosdk.common.struct.CanvasInfo.SerPoint serPoint = (com.aliyun.svideosdk.common.struct.CanvasInfo.SerPoint) serInfo.mPoints.get(0);
        path.moveTo(serPoint.x, serPoint.y);
        float f = serPoint.x;
        float f2 = serPoint.y;
        int i = 1;
        while (true) {
            int i2 = size - 1;
            if (i >= i2) {
                com.aliyun.svideosdk.common.struct.CanvasInfo.SerPoint serPoint2 = (com.aliyun.svideosdk.common.struct.CanvasInfo.SerPoint) serInfo.mPoints.get(i2);
                path.lineTo(serPoint2.x, serPoint2.y);
                return path;
            }
            com.aliyun.svideosdk.common.struct.CanvasInfo.SerPoint serPoint3 = (com.aliyun.svideosdk.common.struct.CanvasInfo.SerPoint) serInfo.mPoints.get(i);
            path.quadTo(f, f2, (serPoint3.x + f) / 2.0f, (serPoint3.y + f2) / 2.0f);
            f = serPoint3.x;
            f2 = serPoint3.y;
            i++;
        }
    }

    public void clean() {
        this.mSerPaths.clear();
    }

    public com.aliyun.svideosdk.common.struct.CanvasInfo convertCoordinate(int i, int i2, boolean z) {
        com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo = new com.aliyun.svideosdk.common.struct.CanvasInfo();
        com.aliyun.svideosdk.common.struct.CanvasInfo.SerInfo serInfo = this.mCurrentInfo;
        if (serInfo != null) {
            canvasInfo.mCurrentInfo = serInfo.convertCoordinate(i, i2, z);
        }
        java.util.Iterator<com.aliyun.svideosdk.common.struct.CanvasInfo.SerInfo> it = this.mSerPaths.iterator();
        while (it.hasNext()) {
            canvasInfo.mSerPaths.add(it.next().convertCoordinate(i, i2, z));
        }
        return canvasInfo;
    }

    public void lineEnd(float f, float f2, android.graphics.Paint paint) {
        this.mCurrentInfo.mPoints.add(new com.aliyun.svideosdk.common.struct.CanvasInfo.SerPoint(f, f2));
        this.mCurrentInfo.mColor = paint.getColor();
        this.mCurrentInfo.mWidth = paint.getStrokeWidth();
        this.mSerPaths.add(this.mCurrentInfo);
    }

    public void lineMove(float f, float f2) {
        this.mCurrentInfo.mPoints.add(new com.aliyun.svideosdk.common.struct.CanvasInfo.SerPoint(f, f2));
    }

    public void lineStart(float f, float f2) {
        com.aliyun.svideosdk.common.struct.CanvasInfo.SerInfo serInfo = new com.aliyun.svideosdk.common.struct.CanvasInfo.SerInfo();
        this.mCurrentInfo = serInfo;
        serInfo.mPoints.add(new com.aliyun.svideosdk.common.struct.CanvasInfo.SerPoint(f, f2));
    }

    public void remove() {
        java.util.List<com.aliyun.svideosdk.common.struct.CanvasInfo.SerInfo> list = this.mSerPaths;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mSerPaths.remove(r0.size() - 1);
    }

    public void resore(com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo) {
        java.util.List<com.aliyun.svideosdk.common.struct.CanvasInfo.SerInfo> list = canvasInfo.mSerPaths;
        if (list == null || list.size() == 0) {
            return;
        }
        this.mSerPaths.addAll(0, canvasInfo.mSerPaths);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void save() {
        java.io.ObjectOutputStream objectOutputStream;
        java.io.IOException e;
        java.io.FileNotFoundException e2;
        java.io.ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new java.io.ObjectOutputStream(new java.io.FileOutputStream(mSavePath));
                try {
                    objectOutputStream.writeObject(this);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("save ok, size = ");
                    sb.append(this.mSerPaths.size());
                } catch (java.io.FileNotFoundException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    if (objectOutputStream == null) {
                        return;
                    }
                    objectOutputStream.close();
                } catch (java.io.IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (objectOutputStream == null) {
                        return;
                    }
                    objectOutputStream.close();
                }
            } catch (java.lang.Throwable th) {
                java.io.ObjectOutputStream objectOutputStream3 = objectOutputStream;
                th = th;
                objectOutputStream2 = objectOutputStream3;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.io.FileNotFoundException e6) {
            objectOutputStream = null;
            e2 = e6;
        } catch (java.io.IOException e7) {
            objectOutputStream = null;
            e = e7;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (objectOutputStream2 != null) {
            }
            throw th;
        }
        try {
            objectOutputStream.close();
        } catch (java.io.IOException e8) {
            e8.printStackTrace();
        }
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.CanvasAction> transfer() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.svideosdk.common.struct.CanvasInfo.SerInfo serInfo : this.mSerPaths) {
            arrayList.add(new com.aliyun.svideosdk.common.struct.project.CanvasAction(transferPaint(serInfo), transferPath(serInfo)));
        }
        return arrayList;
    }
}
