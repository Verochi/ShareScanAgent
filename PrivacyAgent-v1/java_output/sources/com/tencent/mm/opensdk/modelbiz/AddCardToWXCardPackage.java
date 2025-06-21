package com.tencent.mm.opensdk.modelbiz;

/* loaded from: classes19.dex */
public class AddCardToWXCardPackage {
    private static final java.lang.String TAG = "MicroMsg.AddCardToWXCardPackage";

    public static class Req extends com.tencent.mm.opensdk.modelbase.BaseReq {
        public java.util.List<com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.WXCardItem> cardArrary;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            java.lang.String str;
            java.lang.String str2;
            java.util.List<com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.WXCardItem> list = this.cardArrary;
            if (list == null || list.size() == 0 || this.cardArrary.size() > 40) {
                return false;
            }
            for (com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.WXCardItem wXCardItem : this.cardArrary) {
                if (wXCardItem == null || (str = wXCardItem.cardId) == null || str.length() > 1024 || ((str2 = wXCardItem.cardExtMsg) != null && str2.length() > 1024)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 9;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(android.os.Bundle bundle) {
            super.toBundle(bundle);
            org.json.JSONStringer jSONStringer = new org.json.JSONStringer();
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
                jSONStringer.array();
                for (com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.WXCardItem wXCardItem : this.cardArrary) {
                    jSONStringer.object();
                    jSONStringer.key("card_id");
                    jSONStringer.value(wXCardItem.cardId);
                    jSONStringer.key("card_ext");
                    java.lang.String str = wXCardItem.cardExtMsg;
                    if (str == null) {
                        str = "";
                    }
                    jSONStringer.value(str);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
            } catch (java.lang.Exception e) {
                com.tencent.mm.opensdk.utils.Log.e(com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.TAG, "Req.toBundle exception:" + e.getMessage());
            }
            bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
        }
    }

    public static class Resp extends com.tencent.mm.opensdk.modelbase.BaseResp {
        public java.util.List<com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.WXCardItem> cardArrary;

        public Resp() {
        }

        public Resp(android.os.Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            java.util.List<com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.WXCardItem> list = this.cardArrary;
            return (list == null || list.size() == 0) ? false : true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(android.os.Bundle bundle) {
            super.fromBundle(bundle);
            if (this.cardArrary == null) {
                this.cardArrary = new java.util.LinkedList();
            }
            java.lang.String string = bundle.getString("_wxapi_add_card_to_wx_card_list");
            if (string == null || string.length() <= 0) {
                return;
            }
            try {
                org.json.JSONArray jSONArray = ((org.json.JSONObject) new org.json.JSONTokener(string).nextValue()).getJSONArray("card_list");
                for (int i = 0; i < jSONArray.length(); i++) {
                    org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                    com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.WXCardItem wXCardItem = new com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.WXCardItem();
                    wXCardItem.cardId = jSONObject.optString("card_id");
                    wXCardItem.cardExtMsg = jSONObject.optString("card_ext");
                    wXCardItem.cardState = jSONObject.optInt("is_succ");
                    this.cardArrary.add(wXCardItem);
                }
            } catch (java.lang.Exception unused) {
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 9;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(android.os.Bundle bundle) {
            super.toBundle(bundle);
            org.json.JSONStringer jSONStringer = new org.json.JSONStringer();
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
                jSONStringer.array();
                for (com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.WXCardItem wXCardItem : this.cardArrary) {
                    jSONStringer.object();
                    jSONStringer.key("card_id");
                    jSONStringer.value(wXCardItem.cardId);
                    jSONStringer.key("card_ext");
                    java.lang.String str = wXCardItem.cardExtMsg;
                    if (str == null) {
                        str = "";
                    }
                    jSONStringer.value(str);
                    jSONStringer.key("is_succ");
                    jSONStringer.value(wXCardItem.cardState);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
            } catch (java.lang.Exception e) {
                com.tencent.mm.opensdk.utils.Log.e(com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.TAG, "Resp.toBundle exception:" + e.getMessage());
            }
            bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
        }
    }

    public static final class WXCardItem {
        public java.lang.String cardExtMsg;
        public java.lang.String cardId;
        public int cardState;
    }
}
