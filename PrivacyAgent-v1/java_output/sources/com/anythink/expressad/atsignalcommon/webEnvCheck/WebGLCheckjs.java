package com.anythink.expressad.atsignalcommon.webEnvCheck;

/* loaded from: classes12.dex */
public class WebGLCheckjs extends com.anythink.expressad.atsignalcommon.windvane.l {
    public void webglState(java.lang.Object obj, java.lang.String str) {
        try {
            new org.json.JSONObject(str).optInt("webgl");
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }
}
