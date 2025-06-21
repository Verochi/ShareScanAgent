package com.loc;

/* loaded from: classes23.dex */
public final class fs {
    private java.lang.StringBuilder a = new java.lang.StringBuilder();
    private com.amap.api.location.AMapLocationClientOption b = new com.amap.api.location.AMapLocationClientOption();

    private void a(com.loc.ey eyVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!android.text.TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            a(str, str2, sb);
        }
        if (!android.text.TextUtils.isEmpty(str3)) {
            sb.append(str3);
            sb.append(" ");
        }
        if (!android.text.TextUtils.isEmpty(str4)) {
            sb.append(str4);
            sb.append(" ");
        }
        if (!android.text.TextUtils.isEmpty(str5)) {
            sb.append(str5);
            sb.append(" ");
        }
        if (!android.text.TextUtils.isEmpty(str6)) {
            a(str7, str6, sb, eyVar);
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("citycode", eyVar.getCityCode());
        bundle.putString("desc", sb.toString());
        bundle.putString("adcode", eyVar.getAdCode());
        eyVar.setExtras(bundle);
        eyVar.g(sb.toString());
        java.lang.String adCode = eyVar.getAdCode();
        eyVar.setAddress((adCode == null || adCode.trim().length() <= 0 || this.b.getGeoLanguage() == com.amap.api.location.AMapLocationClientOption.GeoLanguage.EN) ? sb.toString() : sb.toString().replace(" ", ""));
    }

    private static void a(com.loc.ey eyVar, short s2) {
        if ("-1".equals(eyVar.d())) {
            if (s2 == 101) {
                s2 = 100;
            }
            eyVar.setConScenario(s2);
        } else {
            if (s2 == -1) {
                s2 = 0;
            } else if (s2 == 0) {
                s2 = -1;
            }
            eyVar.setConScenario(s2);
        }
    }

    private void a(java.lang.String str, java.lang.String str2, java.lang.StringBuilder sb) {
        if (this.b.getGeoLanguage() == com.amap.api.location.AMapLocationClientOption.GeoLanguage.EN) {
            if (str2.equals(str)) {
                return;
            }
            sb.append(str2);
            sb.append(" ");
            return;
        }
        if (str.contains("市") && str.equals(str2)) {
            return;
        }
        sb.append(str2);
        sb.append(" ");
    }

    private void a(java.lang.String str, java.lang.String str2, java.lang.StringBuilder sb, com.loc.ey eyVar) {
        java.lang.String concat;
        if (android.text.TextUtils.isEmpty(str) || this.b.getGeoLanguage() == com.amap.api.location.AMapLocationClientOption.GeoLanguage.EN) {
            sb.append("Near ".concat(java.lang.String.valueOf(str2)));
            concat = "Near ".concat(java.lang.String.valueOf(str2));
        } else {
            sb.append("靠近");
            sb.append(str2);
            sb.append(" ");
            concat = "在" + str2 + "附近";
        }
        eyVar.setDescription(concat);
    }

    private static java.lang.String b(java.lang.String str) {
        return "[]".equals(str) ? "" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0286 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0292  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.loc.ey a(com.loc.ey eyVar, byte[] bArr, com.loc.es esVar) {
        java.nio.ByteBuffer wrap;
        java.nio.ByteBuffer byteBuffer;
        java.nio.ByteBuffer byteBuffer2;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        byte b;
        com.loc.ey eyVar2 = eyVar;
        java.nio.ByteBuffer byteBuffer3 = null;
        try {
            if (bArr == null) {
                try {
                    eyVar2.setErrorCode(5);
                    esVar.f("#0504");
                    this.a.append("binaryResult is null#0504");
                    eyVar2.setLocationDetail(this.a.toString());
                    java.lang.StringBuilder sb = this.a;
                    sb.delete(0, sb.length());
                    return eyVar2;
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } else {
                try {
                    wrap = java.nio.ByteBuffer.wrap(bArr);
                    try {
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        byteBuffer = wrap;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    byteBuffer3 = null;
                }
                if (wrap.get() != 0) {
                    eyVar2.setLongitude(com.loc.gd.a(wrap.getInt() / 1000000.0d));
                    eyVar2.setLatitude(com.loc.gd.a(wrap.getInt() / 1000000.0d));
                    eyVar2.setAccuracy(wrap.getShort());
                    eyVar2.c(java.lang.String.valueOf((int) wrap.get()));
                    eyVar2.d(java.lang.String.valueOf((int) wrap.get()));
                    if (wrap.get() == 1) {
                        try {
                            byte[] bArr2 = new byte[wrap.get() & 255];
                            wrap.get(bArr2);
                            try {
                                eyVar2.setCountry(new java.lang.String(bArr2, "UTF-8"));
                            } catch (java.lang.Throwable unused) {
                            }
                            byte[] bArr3 = new byte[wrap.get() & 255];
                            wrap.get(bArr3);
                            try {
                                str = new java.lang.String(bArr3, "UTF-8");
                                try {
                                    eyVar2.setProvince(str);
                                } catch (java.lang.Throwable unused2) {
                                }
                            } catch (java.lang.Throwable unused3) {
                                str = "";
                            }
                            java.lang.String str9 = str;
                            byte[] bArr4 = new byte[wrap.get() & 255];
                            wrap.get(bArr4);
                            try {
                                str2 = new java.lang.String(bArr4, "UTF-8");
                                try {
                                    eyVar2.setCity(str2);
                                } catch (java.lang.Throwable unused4) {
                                }
                            } catch (java.lang.Throwable unused5) {
                                str2 = "";
                            }
                            java.lang.String str10 = str2;
                            byte[] bArr5 = new byte[wrap.get() & 255];
                            wrap.get(bArr5);
                            try {
                                str3 = new java.lang.String(bArr5, "UTF-8");
                                try {
                                    eyVar2.setDistrict(str3);
                                } catch (java.lang.Throwable unused6) {
                                }
                            } catch (java.lang.Throwable unused7) {
                                str3 = "";
                            }
                            java.lang.String str11 = str3;
                            byte[] bArr6 = new byte[wrap.get() & 255];
                            wrap.get(bArr6);
                            try {
                                str4 = new java.lang.String(bArr6, "UTF-8");
                                try {
                                    eyVar2.setStreet(str4);
                                    eyVar2.setRoad(str4);
                                } catch (java.lang.Throwable unused8) {
                                }
                            } catch (java.lang.Throwable unused9) {
                                str4 = "";
                            }
                            java.lang.String str12 = str4;
                            byte[] bArr7 = new byte[wrap.get() & 255];
                            wrap.get(bArr7);
                            try {
                                str5 = new java.lang.String(bArr7, "UTF-8");
                                try {
                                    eyVar2.setNumber(str5);
                                } catch (java.lang.Throwable unused10) {
                                }
                            } catch (java.lang.Throwable unused11) {
                                str5 = "";
                            }
                            java.lang.String str13 = str5;
                            byte[] bArr8 = new byte[wrap.get() & 255];
                            wrap.get(bArr8);
                            try {
                                str6 = new java.lang.String(bArr8, "UTF-8");
                                try {
                                    eyVar2.setPoiName(str6);
                                } catch (java.lang.Throwable unused12) {
                                }
                            } catch (java.lang.Throwable unused13) {
                                str6 = "";
                            }
                            java.lang.String str14 = str6;
                            byte[] bArr9 = new byte[wrap.get() & 255];
                            wrap.get(bArr9);
                            try {
                                eyVar2.setAoiName(new java.lang.String(bArr9, "UTF-8"));
                            } catch (java.lang.Throwable unused14) {
                            }
                            byte[] bArr10 = new byte[wrap.get() & 255];
                            wrap.get(bArr10);
                            try {
                                str7 = new java.lang.String(bArr10, "UTF-8");
                                try {
                                    eyVar2.setAdCode(str7);
                                } catch (java.lang.Throwable unused15) {
                                }
                            } catch (java.lang.Throwable unused16) {
                                str7 = "";
                            }
                            java.lang.String str15 = str7;
                            byte[] bArr11 = new byte[wrap.get() & 255];
                            wrap.get(bArr11);
                            try {
                                eyVar2.setCityCode(new java.lang.String(bArr11, "UTF-8"));
                            } catch (java.lang.Throwable unused17) {
                            }
                            str8 = "UTF-8";
                            b = 1;
                            byteBuffer2 = wrap;
                            try {
                                a(eyVar, str9, str10, str11, str12, str13, str14, str15);
                            } catch (java.lang.Throwable th4) {
                                th = th4;
                                byteBuffer3 = byteBuffer2;
                                com.loc.ey eyVar3 = new com.loc.ey("");
                                eyVar3.setErrorCode(5);
                                esVar.f("#0505");
                                this.a.append("parser data error:" + th.getMessage() + "#0505");
                                com.loc.gb.a((java.lang.String) null, 2054);
                                eyVar3.setLocationDetail(this.a.toString());
                                eyVar2 = eyVar3;
                                if (this.a.length() > 0) {
                                }
                                return eyVar2;
                            }
                        } catch (java.lang.Throwable th5) {
                            th = th5;
                            byteBuffer2 = wrap;
                        }
                    } else {
                        str8 = "UTF-8";
                        byteBuffer2 = wrap;
                        b = 1;
                    }
                    try {
                        byteBuffer = byteBuffer2;
                        try {
                            byteBuffer.get(new byte[byteBuffer2.get() & 255]);
                            if (byteBuffer.get() == b) {
                                byteBuffer.getInt();
                                byteBuffer.getInt();
                                byteBuffer.getShort();
                            }
                            if (byteBuffer.get() == b) {
                                byte[] bArr12 = new byte[byteBuffer.get() & 255];
                                byteBuffer.get(bArr12);
                                try {
                                    eyVar2.setBuildingId(new java.lang.String(bArr12, str8));
                                } catch (java.lang.Throwable unused18) {
                                }
                                byte[] bArr13 = new byte[byteBuffer.get() & 255];
                                byteBuffer.get(bArr13);
                                try {
                                    eyVar2.setFloor(new java.lang.String(bArr13, str8));
                                } catch (java.lang.Throwable unused19) {
                                }
                            }
                            if (byteBuffer.get() == b) {
                                byteBuffer.get();
                                byteBuffer.getInt();
                                byteBuffer.get();
                            }
                            if (byteBuffer.get() == b) {
                                eyVar2.setTime(byteBuffer.getLong());
                            }
                            int i = byteBuffer.getShort();
                            if (i > 0) {
                                byte[] bArr14 = new byte[i];
                                byteBuffer.get(bArr14);
                                if (i > 0) {
                                    try {
                                        eyVar2.a(new java.lang.String(android.util.Base64.decode(bArr14, 0), str8));
                                    } catch (java.lang.Throwable unused20) {
                                    }
                                }
                            }
                            int i2 = byteBuffer.getShort();
                            if (i2 > 0) {
                                byteBuffer.get(new byte[i2]);
                            }
                            if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.1d) {
                                a(eyVar2, byteBuffer.getShort());
                                eyVar2.a(byteBuffer.get());
                            }
                            byteBuffer.clear();
                        } catch (java.lang.Throwable th6) {
                            th = th6;
                            byteBuffer3 = byteBuffer;
                            com.loc.ey eyVar32 = new com.loc.ey("");
                            eyVar32.setErrorCode(5);
                            esVar.f("#0505");
                            this.a.append("parser data error:" + th.getMessage() + "#0505");
                            com.loc.gb.a((java.lang.String) null, 2054);
                            eyVar32.setLocationDetail(this.a.toString());
                            eyVar2 = eyVar32;
                            if (this.a.length() > 0) {
                            }
                            return eyVar2;
                        }
                    } catch (java.lang.Throwable th7) {
                        th = th7;
                        byteBuffer = byteBuffer2;
                    }
                    if (this.a.length() > 0) {
                        java.lang.StringBuilder sb2 = this.a;
                        sb2.delete(0, sb2.length());
                    }
                    return eyVar2;
                }
                try {
                    eyVar2.b(java.lang.String.valueOf((int) wrap.getShort()));
                    wrap.clear();
                    wrap.clear();
                    return eyVar2;
                } catch (java.lang.Throwable th8) {
                    th = th8;
                    byteBuffer3 = wrap;
                }
            }
            com.loc.ey eyVar322 = new com.loc.ey("");
            eyVar322.setErrorCode(5);
            esVar.f("#0505");
            this.a.append("parser data error:" + th.getMessage() + "#0505");
            com.loc.gb.a((java.lang.String) null, 2054);
            eyVar322.setLocationDetail(this.a.toString());
            eyVar2 = eyVar322;
            if (this.a.length() > 0) {
            }
            return eyVar2;
        } finally {
            if (byteBuffer3 != null) {
                byteBuffer3.clear();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
    
        if (r3.length() <= 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
    
        r10.setCity(r3);
        r4 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0081 A[Catch: all -> 0x0105, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0001, B:5:0x004e, B:7:0x0056, B:9:0x005e, B:12:0x0067, B:13:0x007b, B:15:0x0081, B:16:0x0085, B:19:0x00d1, B:20:0x00e3, B:22:0x00ef, B:23:0x00fe, B:29:0x0071, B:31:0x0077), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d1 A[Catch: all -> 0x0105, TRY_ENTER, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0001, B:5:0x004e, B:7:0x0056, B:9:0x005e, B:12:0x0067, B:13:0x007b, B:15:0x0081, B:16:0x0085, B:19:0x00d1, B:20:0x00e3, B:22:0x00ef, B:23:0x00fe, B:29:0x0071, B:31:0x0077), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ef A[Catch: all -> 0x0105, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0001, B:5:0x004e, B:7:0x0056, B:9:0x005e, B:12:0x0067, B:13:0x007b, B:15:0x0081, B:16:0x0085, B:19:0x00d1, B:20:0x00e3, B:22:0x00ef, B:23:0x00fe, B:29:0x0071, B:31:0x0077), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.loc.ey a(java.lang.String str) {
        org.json.JSONArray optJSONArray;
        java.lang.String str2;
        org.json.JSONArray optJSONArray2;
        try {
            com.loc.ey eyVar = new com.loc.ey("");
            org.json.JSONObject optJSONObject = new org.json.JSONObject(str).optJSONObject("regeocode");
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
            eyVar.setCountry(b(optJSONObject2.optString("country")));
            java.lang.String b = b(optJSONObject2.optString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE));
            eyVar.setProvince(b);
            java.lang.String b2 = b(optJSONObject2.optString("citycode"));
            eyVar.setCityCode(b2);
            java.lang.String optString = optJSONObject2.optString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY);
            if (!b2.endsWith("010") && !b2.endsWith("021") && !b2.endsWith("022") && !b2.endsWith("023")) {
                optString = b(optString);
                eyVar.setCity(optString);
                if (android.text.TextUtils.isEmpty(optString)) {
                    eyVar.setCity(b);
                    optString = b;
                }
                java.lang.String b3 = b(optJSONObject2.optString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_DISTRICT));
                eyVar.setDistrict(b3);
                java.lang.String b4 = b(optJSONObject2.optString("adcode"));
                eyVar.setAdCode(b4);
                org.json.JSONObject optJSONObject3 = optJSONObject2.optJSONObject("streetNumber");
                java.lang.String b5 = b(optJSONObject3.optString("street"));
                eyVar.setStreet(b5);
                eyVar.setRoad(b5);
                java.lang.String b6 = b(optJSONObject3.optString("number"));
                eyVar.setNumber(b6);
                optJSONArray = optJSONObject.optJSONArray("pois");
                if (optJSONArray.length() <= 0) {
                    java.lang.String b7 = b(optJSONArray.getJSONObject(0).optString("name"));
                    eyVar.setPoiName(b7);
                    str2 = b7;
                } else {
                    str2 = null;
                }
                optJSONArray2 = optJSONObject.optJSONArray("aois");
                if (optJSONArray2.length() > 0) {
                    eyVar.setAoiName(b(optJSONArray2.getJSONObject(0).optString("name")));
                }
                a(eyVar, b, optString, b3, b5, b6, str2, b4);
                return eyVar;
            }
            if (android.text.TextUtils.isEmpty(optString)) {
            }
            java.lang.String b32 = b(optJSONObject2.optString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_DISTRICT));
            eyVar.setDistrict(b32);
            java.lang.String b42 = b(optJSONObject2.optString("adcode"));
            eyVar.setAdCode(b42);
            org.json.JSONObject optJSONObject32 = optJSONObject2.optJSONObject("streetNumber");
            java.lang.String b52 = b(optJSONObject32.optString("street"));
            eyVar.setStreet(b52);
            eyVar.setRoad(b52);
            java.lang.String b62 = b(optJSONObject32.optString("number"));
            eyVar.setNumber(b62);
            optJSONArray = optJSONObject.optJSONArray("pois");
            if (optJSONArray.length() <= 0) {
            }
            optJSONArray2 = optJSONObject.optJSONArray("aois");
            if (optJSONArray2.length() > 0) {
            }
            a(eyVar, b, optString, b32, b52, b62, str2, b42);
            return eyVar;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public final com.loc.ey a(java.lang.String str, android.content.Context context, com.loc.bv bvVar, com.loc.es esVar) {
        com.loc.ey eyVar = new com.loc.ey("");
        eyVar.setErrorCode(7);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        try {
            stringBuffer.append("#SHA1AndPackage#");
            stringBuffer.append(com.loc.m.e(context));
            java.lang.String str2 = bvVar.b.get("gsid").get(0);
            if (!android.text.TextUtils.isEmpty(str2)) {
                stringBuffer.append("#gsid#");
                stringBuffer.append(str2);
            }
            java.lang.String str3 = bvVar.c;
            if (!android.text.TextUtils.isEmpty(str3)) {
                stringBuffer.append("#csid#".concat(java.lang.String.valueOf(str3)));
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                esVar.f("#0702");
                java.lang.StringBuilder sb = this.a;
                sb.append("json is error:");
                sb.append(str);
                sb.append(stringBuffer);
                sb.append("#0702");
            }
            java.lang.String string = jSONObject.getString("status");
            java.lang.String string2 = jSONObject.getString("info");
            java.lang.String string3 = jSONObject.getString("infocode");
            if ("0".equals(string)) {
                esVar.f("#0701");
                java.lang.StringBuilder sb2 = this.a;
                sb2.append("auth fail:");
                sb2.append(string2);
                sb2.append(stringBuffer);
                sb2.append("#0701");
                com.loc.gb.a(bvVar.d, string3, string2);
            }
        } catch (java.lang.Throwable th) {
            esVar.f("#0703");
            java.lang.StringBuilder sb3 = this.a;
            sb3.append("json exception error:");
            sb3.append(th.getMessage());
            sb3.append(stringBuffer);
            sb3.append("#0703");
            com.loc.fv.a(th, "parser", "paseAuthFailurJson");
        }
        eyVar.setLocationDetail(this.a.toString());
        if (this.a.length() > 0) {
            java.lang.StringBuilder sb4 = this.a;
            sb4.delete(0, sb4.length());
        }
        return eyVar;
    }

    public final void a(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            this.b = new com.amap.api.location.AMapLocationClientOption();
        } else {
            this.b = aMapLocationClientOption;
        }
    }
}
