package com.aliyun.player;

/* loaded from: classes.dex */
public class FilterConfig {
    private org.json.JSONArray filters = new org.json.JSONArray();

    public static class Filter {
        org.json.JSONObject filter;

        public Filter(java.lang.String str) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            this.filter = jSONObject;
            try {
                jSONObject.put(com.umeng.ccg.a.A, str);
            } catch (org.json.JSONException unused) {
            }
        }

        public org.json.JSONObject getFilter() {
            return this.filter;
        }

        public void setOptions(com.aliyun.player.FilterConfig.FilterOptions filterOptions) {
            if (filterOptions == null || filterOptions.getOptions().length() <= 0) {
                return;
            }
            try {
                this.filter.put("options", filterOptions.getOptions());
            } catch (org.json.JSONException unused) {
            }
        }
    }

    public static class FilterOptions {
        org.json.JSONObject options = new org.json.JSONObject();

        public org.json.JSONObject getOptions() {
            return this.options;
        }

        public void setOption(java.lang.String str, java.lang.Object obj) {
            try {
                this.options.put(str, obj);
            } catch (org.json.JSONException unused) {
            }
        }

        public java.lang.String toString() {
            return this.options.toString();
        }
    }

    public void addFilter(com.aliyun.player.FilterConfig.Filter filter) {
        if (filter == null || filter.getFilter() == null) {
            return;
        }
        this.filters.put(filter.getFilter());
    }

    public java.lang.String toString() {
        return this.filters.toString();
    }
}
