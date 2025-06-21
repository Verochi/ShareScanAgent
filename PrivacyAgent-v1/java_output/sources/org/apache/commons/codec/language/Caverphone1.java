package org.apache.commons.codec.language;

/* loaded from: classes24.dex */
public class Caverphone1 extends org.apache.commons.codec.language.AbstractCaverphone {
    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return "111111";
        }
        return (str.toLowerCase(java.util.Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", "si").replaceAll("ce", "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll("c", "k").replaceAll("q", "k").replaceAll("x", "k").replaceAll("v", "f").replaceAll("dg", com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_2G).replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll("d", "t").replaceAll("ph", com.aliyun.vod.log.struct.AliyunLogKey.KEY_FILE_HEIGHT).replaceAll("b", "p").replaceAll(com.anythink.expressad.foundation.d.d.t, com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_2).replaceAll(com.umeng.analytics.pro.bo.aJ, "s").replaceAll("^[aeiou]", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("[aeiou]", "3").replaceAll("3gh3", "3kh3").replaceAll("gh", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE).replaceAll("g", "k").replaceAll("s+", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH).replaceAll("t+", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE).replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", "F").replaceAll("m+", "M").replaceAll("n+", "N").replaceAll("w3", "W3").replaceAll("wy", "Wy").replaceAll("wh3", "Wh3").replaceAll("why", "Why").replaceAll(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "2").replaceAll("^h", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("h", "2").replaceAll("r3", "R3").replaceAll(com.aliyun.common.log.struct.AliyunLogKey.KEY_CROP_RECT_Y, "Ry").replaceAll("r", "2").replaceAll("l3", "L3").replaceAll("ly", "Ly").replaceAll("l", "2").replaceAll("j", "y").replaceAll("y3", "Y3").replaceAll("y", "2").replaceAll("2", "").replaceAll("3", "") + "111111").substring(0, 6);
    }
}
