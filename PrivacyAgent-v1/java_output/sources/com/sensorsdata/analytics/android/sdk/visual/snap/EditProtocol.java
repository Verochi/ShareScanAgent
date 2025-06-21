package com.sensorsdata.analytics.android.sdk.visual.snap;

/* loaded from: classes19.dex */
public class EditProtocol {
    private static final java.lang.Class<?>[] NO_PARAMS = new java.lang.Class[0];
    private static final java.lang.String TAG = "SA.EProtocol";
    private final com.sensorsdata.analytics.android.sdk.visual.snap.ResourceIds mResourceIds;
    private java.util.List<com.sensorsdata.analytics.android.sdk.visual.snap.PropertyDescription> propertyDescriptionList;

    public static class BadInstructionsException extends java.lang.Exception {
        private static final long serialVersionUID = -4062004792184145311L;

        public BadInstructionsException(java.lang.String str) {
            super(str);
        }

        public BadInstructionsException(java.lang.String str, java.lang.Throwable th) {
            super(str, th);
        }
    }

    public EditProtocol(com.sensorsdata.analytics.android.sdk.visual.snap.ResourceIds resourceIds) {
        this.mResourceIds = resourceIds;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject("{\"type\":\"snapshot_request\",\"payload\":{\"config\":{\"classes\":[{\"name\":\"android.view.View\",\"properties\":[{\"name\":\"clickable\",\"get\":{\"selector\":\"isClickable\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}}]},{\"name\":\"android.widget.TextView\",\"properties\":[{\"name\":\"clickable\",\"get\":{\"selector\":\"isClickable\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}}]},{\"name\":\"android.widget.ImageView\",\"properties\":[{\"name\":\"clickable\",\"get\":{\"selector\":\"isClickable\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}}]}]}}}").getJSONObject("payload");
            if (jSONObject.has("config")) {
                this.propertyDescriptionList = getListPropertyDescription(jSONObject);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private java.util.List<com.sensorsdata.analytics.android.sdk.visual.snap.PropertyDescription> getListPropertyDescription(org.json.JSONObject jSONObject) throws com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol.BadInstructionsException {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        try {
            org.json.JSONArray jSONArray = jSONObject.getJSONObject("config").getJSONArray("classes");
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                java.lang.Class<?> cls = java.lang.Class.forName(jSONObject2.getString("name"));
                org.json.JSONArray jSONArray2 = jSONObject2.getJSONArray("properties");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    linkedList.add(readPropertyDescription(cls, jSONArray2.getJSONObject(i2)));
                }
            }
            return linkedList;
        } catch (java.lang.ClassNotFoundException e) {
            throw new com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol.BadInstructionsException("Can't resolve types for snapshot configuration", e);
        } catch (org.json.JSONException e2) {
            throw new com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol.BadInstructionsException("Can't read snapshot configuration", e2);
        }
    }

    private com.sensorsdata.analytics.android.sdk.visual.snap.PropertyDescription readPropertyDescription(java.lang.Class<?> cls, org.json.JSONObject jSONObject) throws com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol.BadInstructionsException {
        com.sensorsdata.analytics.android.sdk.visual.snap.Caller caller;
        try {
            java.lang.String string = jSONObject.getString("name");
            if (jSONObject.has(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET)) {
                org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET);
                caller = new com.sensorsdata.analytics.android.sdk.visual.snap.Caller(cls, jSONObject2.getString("selector"), NO_PARAMS, java.lang.Class.forName(jSONObject2.getJSONObject("result").getString("type")));
            } else {
                caller = null;
            }
            return new com.sensorsdata.analytics.android.sdk.visual.snap.PropertyDescription(string, cls, caller, jSONObject.has("set") ? jSONObject.getJSONObject("set").getString("selector") : null);
        } catch (java.lang.ClassNotFoundException e) {
            throw new com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol.BadInstructionsException("Can't read property JSON, relevant arg/return class not found", e);
        } catch (java.lang.NoSuchMethodException e2) {
            throw new com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol.BadInstructionsException("Can't create property reader", e2);
        } catch (org.json.JSONException e3) {
            throw new com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol.BadInstructionsException("Can't read property JSON", e3);
        }
    }

    public com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot readSnapshotConfig(android.os.Handler handler) throws com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol.BadInstructionsException {
        java.util.List<com.sensorsdata.analytics.android.sdk.visual.snap.PropertyDescription> list = this.propertyDescriptionList;
        if (list == null) {
            return null;
        }
        return new com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot(list, this.mResourceIds, handler);
    }
}
