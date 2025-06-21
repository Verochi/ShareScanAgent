package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class AMapPara {
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;
    public static final int DOTTEDLINE_TYPE_DEFAULT = -1;
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    public enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapArrow(2),
        LineCapRound(3);

        private int type;

        LineCapType(int i) {
            this.type = i;
        }

        public static com.amap.api.maps.model.AMapPara.LineCapType valueOf(int i) {
            com.amap.api.maps.model.AMapPara.LineCapType[] values = values();
            return values[java.lang.Math.max(0, java.lang.Math.min(i, values.length))];
        }

        public final int getTypeValue() {
            return this.type;
        }
    }

    public enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);

        private int type;

        LineJoinType(int i) {
            this.type = i;
        }

        public static com.amap.api.maps.model.AMapPara.LineJoinType valueOf(int i) {
            com.amap.api.maps.model.AMapPara.LineJoinType[] values = values();
            return values[java.lang.Math.max(0, java.lang.Math.min(i, values.length))];
        }

        public final int getTypeValue() {
            return this.type;
        }
    }
}
