package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class SkeletonJson {
    public final com.esotericsoftware.spine.attachments.AttachmentLoader a;
    public float b = 1.0f;
    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.SkeletonJson.LinkedMesh> c = new com.badlogic.gdx.utils.Array<>();

    /* renamed from: com.esotericsoftware.spine.SkeletonJson$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.esotericsoftware.spine.attachments.AttachmentType.values().length];
            a = iArr;
            try {
                iArr[com.esotericsoftware.spine.attachments.AttachmentType.region.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.esotericsoftware.spine.attachments.AttachmentType.boundingbox.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.esotericsoftware.spine.attachments.AttachmentType.mesh.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.esotericsoftware.spine.attachments.AttachmentType.linkedmesh.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.esotericsoftware.spine.attachments.AttachmentType.path.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.esotericsoftware.spine.attachments.AttachmentType.point.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[com.esotericsoftware.spine.attachments.AttachmentType.clipping.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    public static class LinkedMesh {
        public java.lang.String a;
        public java.lang.String b;
        public int c;
        public com.esotericsoftware.spine.attachments.MeshAttachment d;

        public LinkedMesh(com.esotericsoftware.spine.attachments.MeshAttachment meshAttachment, java.lang.String str, int i, java.lang.String str2) {
            this.d = meshAttachment;
            this.b = str;
            this.c = i;
            this.a = str2;
        }
    }

    public SkeletonJson(com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas) {
        this.a = new com.esotericsoftware.spine.attachments.AtlasAttachmentLoader(textureAtlas);
    }

    public SkeletonJson(com.esotericsoftware.spine.attachments.AttachmentLoader attachmentLoader) {
        if (attachmentLoader == null) {
            throw new java.lang.IllegalArgumentException("attachmentLoader cannot be null.");
        }
        this.a = attachmentLoader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x048c, code lost:
    
        if (r3 != com.esotericsoftware.spine.PathConstraintData.SpacingMode.fixed) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x049f, code lost:
    
        r3 = 1.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x049a, code lost:
    
        if (r10.e == com.esotericsoftware.spine.PathConstraintData.PositionMode.fixed) goto L116;
     */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02ab A[LOOP:8: B:72:0x02a9->B:73:0x02ab, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.badlogic.gdx.utils.JsonValue jsonValue, java.lang.String str, com.esotericsoftware.spine.SkeletonData skeletonData) {
        java.lang.Object obj;
        java.lang.String str2;
        com.esotericsoftware.spine.SkeletonData skeletonData2;
        java.lang.String str3;
        int[] iArr;
        int i;
        com.badlogic.gdx.utils.JsonValue jsonValue2;
        com.badlogic.gdx.utils.JsonValue jsonValue3;
        java.lang.String str4;
        com.badlogic.gdx.utils.JsonValue jsonValue4;
        float[] fArr;
        java.lang.Object obj2;
        java.lang.String str5;
        com.esotericsoftware.spine.Animation.PathConstraintPositionTimeline pathConstraintPositionTimeline;
        float f;
        java.lang.String str6;
        java.lang.String str7;
        com.esotericsoftware.spine.Animation.TranslateTimeline translateTimeline;
        float f2;
        com.badlogic.gdx.utils.JsonValue jsonValue5;
        java.lang.String str8;
        com.esotericsoftware.spine.BoneData boneData;
        float f3;
        java.lang.String str9;
        java.lang.String str10;
        java.lang.String str11;
        com.esotericsoftware.spine.SlotData slotData;
        com.esotericsoftware.spine.SkeletonData skeletonData3 = skeletonData;
        float f4 = this.b;
        com.badlogic.gdx.utils.Array array = new com.badlogic.gdx.utils.Array();
        com.badlogic.gdx.utils.JsonValue child = jsonValue.getChild("slots");
        float f5 = 0.0f;
        while (true) {
            java.lang.String str12 = ")";
            java.lang.String str13 = "name";
            java.lang.String str14 = "Slot not found: ";
            java.lang.String str15 = "time";
            if (child != null) {
                com.esotericsoftware.spine.SlotData findSlot = skeletonData3.findSlot(child.name);
                if (findSlot == null) {
                    throw new com.badlogic.gdx.utils.SerializationException("Slot not found: " + child.name);
                }
                com.badlogic.gdx.utils.JsonValue jsonValue6 = child.child;
                while (jsonValue6 != null) {
                    java.lang.String str16 = jsonValue6.name;
                    if (str16.equals("attachment")) {
                        com.esotericsoftware.spine.Animation.AttachmentTimeline attachmentTimeline = new com.esotericsoftware.spine.Animation.AttachmentTimeline(jsonValue6.size);
                        attachmentTimeline.a = findSlot.a;
                        com.badlogic.gdx.utils.JsonValue jsonValue7 = jsonValue6.child;
                        int i2 = 0;
                        while (jsonValue7 != null) {
                            attachmentTimeline.setFrame(i2, jsonValue7.getFloat(str15), jsonValue7.getString(str13));
                            jsonValue7 = jsonValue7.next;
                            i2++;
                            f4 = f4;
                        }
                        f3 = f4;
                        array.add(attachmentTimeline);
                        f5 = java.lang.Math.max(f5, attachmentTimeline.getFrames()[attachmentTimeline.getFrameCount() - 1]);
                        str10 = str12;
                        str9 = str13;
                    } else {
                        f3 = f4;
                        java.lang.String str17 = "color";
                        if (str16.equals("color")) {
                            com.esotericsoftware.spine.Animation.ColorTimeline colorTimeline = new com.esotericsoftware.spine.Animation.ColorTimeline(jsonValue6.size);
                            colorTimeline.b = findSlot.a;
                            com.badlogic.gdx.utils.JsonValue jsonValue8 = jsonValue6.child;
                            int i3 = 0;
                            while (jsonValue8 != null) {
                                com.badlogic.gdx.graphics.Color valueOf = com.badlogic.gdx.graphics.Color.valueOf(jsonValue8.getString(str17));
                                colorTimeline.setFrame(i3, jsonValue8.getFloat(str15), valueOf.r, valueOf.g, valueOf.b, valueOf.a);
                                c(jsonValue8, colorTimeline, i3);
                                i3++;
                                jsonValue8 = jsonValue8.next;
                                str17 = str17;
                                str13 = str13;
                            }
                            str9 = str13;
                            array.add(colorTimeline);
                            f5 = java.lang.Math.max(f5, colorTimeline.getFrames()[(colorTimeline.getFrameCount() - 1) * 5]);
                            str10 = str12;
                        } else {
                            str9 = str13;
                            if (!str16.equals("twoColor")) {
                                throw new java.lang.RuntimeException("Invalid timeline type for a slot: " + str16 + " (" + child.name + str12);
                            }
                            com.esotericsoftware.spine.Animation.TwoColorTimeline twoColorTimeline = new com.esotericsoftware.spine.Animation.TwoColorTimeline(jsonValue6.size);
                            twoColorTimeline.b = findSlot.a;
                            com.badlogic.gdx.utils.JsonValue jsonValue9 = jsonValue6.child;
                            int i4 = 0;
                            while (jsonValue9 != null) {
                                com.badlogic.gdx.graphics.Color valueOf2 = com.badlogic.gdx.graphics.Color.valueOf(jsonValue9.getString("light"));
                                com.badlogic.gdx.graphics.Color valueOf3 = com.badlogic.gdx.graphics.Color.valueOf(jsonValue9.getString("dark"));
                                twoColorTimeline.setFrame(i4, jsonValue9.getFloat(str15), valueOf2.r, valueOf2.g, valueOf2.b, valueOf2.a, valueOf3.r, valueOf3.g, valueOf3.b);
                                c(jsonValue9, twoColorTimeline, i4);
                                i4++;
                                jsonValue9 = jsonValue9.next;
                                findSlot = findSlot;
                                str15 = str15;
                                str12 = str12;
                            }
                            str10 = str12;
                            str11 = str15;
                            slotData = findSlot;
                            array.add(twoColorTimeline);
                            f5 = java.lang.Math.max(f5, twoColorTimeline.getFrames()[(twoColorTimeline.getFrameCount() - 1) * 8]);
                            jsonValue6 = jsonValue6.next;
                            findSlot = slotData;
                            f4 = f3;
                            str15 = str11;
                            str12 = str10;
                            str13 = str9;
                        }
                    }
                    str11 = str15;
                    slotData = findSlot;
                    jsonValue6 = jsonValue6.next;
                    findSlot = slotData;
                    f4 = f3;
                    str15 = str11;
                    str12 = str10;
                    str13 = str9;
                }
                child = child.next;
                skeletonData3 = skeletonData;
            } else {
                float f6 = f4;
                java.lang.String str18 = ")";
                java.lang.String str19 = "name";
                java.lang.String str20 = "time";
                com.badlogic.gdx.utils.JsonValue child2 = jsonValue.getChild("bones");
                while (child2 != null) {
                    com.esotericsoftware.spine.BoneData findBone = skeletonData.findBone(child2.name);
                    if (findBone == null) {
                        throw new com.badlogic.gdx.utils.SerializationException("Bone not found: " + child2.name);
                    }
                    com.badlogic.gdx.utils.JsonValue jsonValue10 = child2.child;
                    while (jsonValue10 != null) {
                        java.lang.String str21 = jsonValue10.name;
                        if (str21.equals("rotate")) {
                            com.esotericsoftware.spine.Animation.RotateTimeline rotateTimeline = new com.esotericsoftware.spine.Animation.RotateTimeline(jsonValue10.size);
                            rotateTimeline.b = findBone.a;
                            com.badlogic.gdx.utils.JsonValue jsonValue11 = jsonValue10.child;
                            int i5 = 0;
                            while (jsonValue11 != null) {
                                java.lang.String str22 = str20;
                                rotateTimeline.setFrame(i5, jsonValue11.getFloat(str22), jsonValue11.getFloat("angle"));
                                c(jsonValue11, rotateTimeline, i5);
                                i5++;
                                jsonValue11 = jsonValue11.next;
                                str14 = str14;
                                str20 = str22;
                            }
                            str6 = str20;
                            str7 = str14;
                            array.add(rotateTimeline);
                            str8 = str18;
                            f5 = java.lang.Math.max(f5, rotateTimeline.getFrames()[(rotateTimeline.getFrameCount() - 1) * 2]);
                            boneData = findBone;
                        } else {
                            str6 = str20;
                            str7 = str14;
                            if (!str21.equals("translate") && !str21.equals("scale") && !str21.equals("shear")) {
                                throw new java.lang.RuntimeException("Invalid timeline type for a bone: " + str21 + " (" + child2.name + str18);
                            }
                            if (str21.equals("scale")) {
                                translateTimeline = new com.esotericsoftware.spine.Animation.ScaleTimeline(jsonValue10.size);
                            } else if (str21.equals("shear")) {
                                translateTimeline = new com.esotericsoftware.spine.Animation.ShearTimeline(jsonValue10.size);
                            } else {
                                translateTimeline = new com.esotericsoftware.spine.Animation.TranslateTimeline(jsonValue10.size);
                                f2 = f6;
                                translateTimeline.b = findBone.a;
                                jsonValue5 = jsonValue10.child;
                                int i6 = 0;
                                while (jsonValue5 != null) {
                                    translateTimeline.setFrame(i6, jsonValue5.getFloat(str6), jsonValue5.getFloat("x", 0.0f) * f2, jsonValue5.getFloat("y", 0.0f) * f2);
                                    c(jsonValue5, translateTimeline, i6);
                                    i6++;
                                    jsonValue5 = jsonValue5.next;
                                    str18 = str18;
                                    findBone = findBone;
                                }
                                str8 = str18;
                                boneData = findBone;
                                array.add(translateTimeline);
                                f5 = java.lang.Math.max(f5, translateTimeline.getFrames()[(translateTimeline.getFrameCount() - 1) * 3]);
                            }
                            f2 = 1.0f;
                            translateTimeline.b = findBone.a;
                            jsonValue5 = jsonValue10.child;
                            int i62 = 0;
                            while (jsonValue5 != null) {
                            }
                            str8 = str18;
                            boneData = findBone;
                            array.add(translateTimeline);
                            f5 = java.lang.Math.max(f5, translateTimeline.getFrames()[(translateTimeline.getFrameCount() - 1) * 3]);
                        }
                        jsonValue10 = jsonValue10.next;
                        str14 = str7;
                        str18 = str8;
                        findBone = boneData;
                        str20 = str6;
                    }
                    child2 = child2.next;
                    str20 = str20;
                }
                com.esotericsoftware.spine.SkeletonData skeletonData4 = skeletonData;
                java.lang.String str23 = str20;
                java.lang.String str24 = str14;
                com.badlogic.gdx.utils.JsonValue child3 = jsonValue.getChild("ik");
                while (true) {
                    obj = "mix";
                    if (child3 == null) {
                        break;
                    }
                    com.esotericsoftware.spine.IkConstraintData findIkConstraint = skeletonData4.findIkConstraint(child3.name);
                    com.esotericsoftware.spine.Animation.IkConstraintTimeline ikConstraintTimeline = new com.esotericsoftware.spine.Animation.IkConstraintTimeline(child3.size);
                    ikConstraintTimeline.b = skeletonData.getIkConstraints().indexOf(findIkConstraint, true);
                    int i7 = 0;
                    for (com.badlogic.gdx.utils.JsonValue jsonValue12 = child3.child; jsonValue12 != null; jsonValue12 = jsonValue12.next) {
                        ikConstraintTimeline.setFrame(i7, jsonValue12.getFloat(str23), jsonValue12.getFloat("mix", 1.0f), jsonValue12.getBoolean("bendPositive", true) ? 1 : -1);
                        c(jsonValue12, ikConstraintTimeline, i7);
                        i7++;
                    }
                    array.add(ikConstraintTimeline);
                    f5 = java.lang.Math.max(f5, ikConstraintTimeline.getFrames()[(ikConstraintTimeline.getFrameCount() - 1) * 3]);
                    child3 = child3.next;
                }
                com.badlogic.gdx.utils.JsonValue child4 = jsonValue.getChild("transform");
                while (true) {
                    str2 = "rotateMix";
                    if (child4 == null) {
                        break;
                    }
                    com.esotericsoftware.spine.TransformConstraintData findTransformConstraint = skeletonData4.findTransformConstraint(child4.name);
                    com.esotericsoftware.spine.Animation.TransformConstraintTimeline transformConstraintTimeline = new com.esotericsoftware.spine.Animation.TransformConstraintTimeline(child4.size);
                    transformConstraintTimeline.b = skeletonData.getTransformConstraints().indexOf(findTransformConstraint, true);
                    int i8 = 0;
                    for (com.badlogic.gdx.utils.JsonValue jsonValue13 = child4.child; jsonValue13 != null; jsonValue13 = jsonValue13.next) {
                        transformConstraintTimeline.setFrame(i8, jsonValue13.getFloat(str23), jsonValue13.getFloat("rotateMix", 1.0f), jsonValue13.getFloat("translateMix", 1.0f), jsonValue13.getFloat("scaleMix", 1.0f), jsonValue13.getFloat("shearMix", 1.0f));
                        c(jsonValue13, transformConstraintTimeline, i8);
                        i8++;
                    }
                    array.add(transformConstraintTimeline);
                    f5 = java.lang.Math.max(f5, transformConstraintTimeline.getFrames()[(transformConstraintTimeline.getFrameCount() - 1) * 5]);
                    child4 = child4.next;
                }
                com.badlogic.gdx.utils.JsonValue child5 = jsonValue.getChild("paths");
                while (child5 != null) {
                    com.esotericsoftware.spine.PathConstraintData findPathConstraint = skeletonData4.findPathConstraint(child5.name);
                    if (findPathConstraint == null) {
                        throw new com.badlogic.gdx.utils.SerializationException("Path constraint not found: " + child5.name);
                    }
                    int indexOf = skeletonData4.j.indexOf(findPathConstraint, true);
                    com.badlogic.gdx.utils.JsonValue jsonValue14 = child5.child;
                    while (jsonValue14 != null) {
                        java.lang.String str25 = jsonValue14.name;
                        if (str25.equals(com.alibaba.sdk.android.oss.common.RequestParameters.POSITION) || str25.equals("spacing")) {
                            obj2 = obj;
                            str5 = str2;
                            if (str25.equals("spacing")) {
                                pathConstraintPositionTimeline = new com.esotericsoftware.spine.Animation.PathConstraintSpacingTimeline(jsonValue14.size);
                                com.esotericsoftware.spine.PathConstraintData.SpacingMode spacingMode = findPathConstraint.f;
                                if (spacingMode != com.esotericsoftware.spine.PathConstraintData.SpacingMode.length) {
                                }
                                f = f6;
                            } else {
                                pathConstraintPositionTimeline = new com.esotericsoftware.spine.Animation.PathConstraintPositionTimeline(jsonValue14.size);
                            }
                            pathConstraintPositionTimeline.b = indexOf;
                            int i9 = 0;
                            for (com.badlogic.gdx.utils.JsonValue jsonValue15 = jsonValue14.child; jsonValue15 != null; jsonValue15 = jsonValue15.next) {
                                pathConstraintPositionTimeline.setFrame(i9, jsonValue15.getFloat(str23), jsonValue15.getFloat(str25, 0.0f) * f);
                                c(jsonValue15, pathConstraintPositionTimeline, i9);
                                i9++;
                            }
                            array.add(pathConstraintPositionTimeline);
                            f5 = java.lang.Math.max(f5, pathConstraintPositionTimeline.getFrames()[(pathConstraintPositionTimeline.getFrameCount() - 1) * 2]);
                        } else if (str25.equals(obj)) {
                            com.esotericsoftware.spine.Animation.PathConstraintMixTimeline pathConstraintMixTimeline = new com.esotericsoftware.spine.Animation.PathConstraintMixTimeline(jsonValue14.size);
                            pathConstraintMixTimeline.b = indexOf;
                            com.badlogic.gdx.utils.JsonValue jsonValue16 = jsonValue14.child;
                            int i10 = 0;
                            while (jsonValue16 != null) {
                                pathConstraintMixTimeline.setFrame(i10, jsonValue16.getFloat(str23), jsonValue16.getFloat(str2, 1.0f), jsonValue16.getFloat("translateMix", 1.0f));
                                c(jsonValue16, pathConstraintMixTimeline, i10);
                                i10++;
                                jsonValue16 = jsonValue16.next;
                                obj = obj;
                                str2 = str2;
                            }
                            obj2 = obj;
                            str5 = str2;
                            array.add(pathConstraintMixTimeline);
                            f5 = java.lang.Math.max(f5, pathConstraintMixTimeline.getFrames()[(pathConstraintMixTimeline.getFrameCount() - 1) * 3]);
                        } else {
                            obj2 = obj;
                            str5 = str2;
                        }
                        jsonValue14 = jsonValue14.next;
                        obj = obj2;
                        str2 = str5;
                    }
                    child5 = child5.next;
                    skeletonData4 = skeletonData;
                }
                com.badlogic.gdx.utils.JsonValue child6 = jsonValue.getChild("deform");
                while (true) {
                    java.lang.String str26 = "offset";
                    if (child6 == null) {
                        java.lang.String str27 = "offset";
                        com.badlogic.gdx.utils.JsonValue jsonValue17 = jsonValue.get("drawOrder");
                        if (jsonValue17 == null) {
                            jsonValue17 = jsonValue.get("draworder");
                        }
                        if (jsonValue17 != null) {
                            com.esotericsoftware.spine.Animation.DrawOrderTimeline drawOrderTimeline = new com.esotericsoftware.spine.Animation.DrawOrderTimeline(jsonValue17.size);
                            skeletonData2 = skeletonData;
                            int i11 = skeletonData2.c.size;
                            com.badlogic.gdx.utils.JsonValue jsonValue18 = jsonValue17.child;
                            int i12 = 0;
                            while (jsonValue18 != null) {
                                com.badlogic.gdx.utils.JsonValue jsonValue19 = jsonValue18.get("offsets");
                                if (jsonValue19 != null) {
                                    iArr = new int[i11];
                                    int i13 = i11 - 1;
                                    for (int i14 = i13; i14 >= 0; i14--) {
                                        iArr[i14] = -1;
                                    }
                                    int[] iArr2 = new int[i11 - jsonValue19.size];
                                    com.badlogic.gdx.utils.JsonValue jsonValue20 = jsonValue19.child;
                                    int i15 = 0;
                                    int i16 = 0;
                                    while (jsonValue20 != null) {
                                        com.esotericsoftware.spine.SlotData findSlot2 = skeletonData2.findSlot(jsonValue20.getString("slot"));
                                        if (findSlot2 == null) {
                                            throw new com.badlogic.gdx.utils.SerializationException(str24 + jsonValue20.getString("slot"));
                                        }
                                        int i17 = i13;
                                        while (true) {
                                            i = i16;
                                            if (i != findSlot2.a) {
                                                i16 = i + 1;
                                                iArr2[i15] = i;
                                                i15++;
                                            }
                                        }
                                        i16 = i + 1;
                                        iArr[jsonValue20.getInt(str27) + i] = i;
                                        jsonValue20 = jsonValue20.next;
                                        i13 = i17;
                                    }
                                    str3 = str27;
                                    while (true) {
                                        int i18 = i16;
                                        if (i18 >= i11) {
                                            break;
                                        }
                                        i16 = i18 + 1;
                                        iArr2[i15] = i18;
                                        i15++;
                                    }
                                    for (int i19 = i13; i19 >= 0; i19--) {
                                        if (iArr[i19] == -1) {
                                            i15--;
                                            iArr[i19] = iArr2[i15];
                                        }
                                    }
                                } else {
                                    str3 = str27;
                                    iArr = null;
                                }
                                drawOrderTimeline.setFrame(i12, jsonValue18.getFloat(str23), iArr);
                                jsonValue18 = jsonValue18.next;
                                i12++;
                                str27 = str3;
                            }
                            array.add(drawOrderTimeline);
                            f5 = java.lang.Math.max(f5, drawOrderTimeline.getFrames()[drawOrderTimeline.getFrameCount() - 1]);
                        } else {
                            skeletonData2 = skeletonData;
                        }
                        com.badlogic.gdx.utils.JsonValue jsonValue21 = jsonValue.get("events");
                        if (jsonValue21 != null) {
                            com.esotericsoftware.spine.Animation.EventTimeline eventTimeline = new com.esotericsoftware.spine.Animation.EventTimeline(jsonValue21.size);
                            com.badlogic.gdx.utils.JsonValue jsonValue22 = jsonValue21.child;
                            int i20 = 0;
                            while (jsonValue22 != null) {
                                java.lang.String str28 = str19;
                                com.esotericsoftware.spine.EventData findEvent = skeletonData2.findEvent(jsonValue22.getString(str28));
                                if (findEvent == null) {
                                    throw new com.badlogic.gdx.utils.SerializationException("Event not found: " + jsonValue22.getString(str28));
                                }
                                com.esotericsoftware.spine.Event event = new com.esotericsoftware.spine.Event(jsonValue22.getFloat(str23), findEvent);
                                event.b = jsonValue22.getInt(com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, findEvent.getInt());
                                event.c = jsonValue22.getFloat("float", findEvent.getFloat());
                                event.d = jsonValue22.getString(com.anythink.expressad.foundation.h.i.g, findEvent.getString());
                                eventTimeline.setFrame(i20, event);
                                jsonValue22 = jsonValue22.next;
                                str19 = str28;
                                i20++;
                            }
                            array.add(eventTimeline);
                            f5 = java.lang.Math.max(f5, eventTimeline.getFrames()[eventTimeline.getFrameCount() - 1]);
                        }
                        array.shrink();
                        skeletonData2.g.add(new com.esotericsoftware.spine.Animation(str, array, f5));
                        return;
                    }
                    com.esotericsoftware.spine.SkeletonData skeletonData5 = skeletonData;
                    com.esotericsoftware.spine.Skin findSkin = skeletonData5.findSkin(child6.name);
                    if (findSkin == null) {
                        throw new com.badlogic.gdx.utils.SerializationException("Skin not found: " + child6.name);
                    }
                    com.badlogic.gdx.utils.JsonValue jsonValue23 = child6.child;
                    while (jsonValue23 != null) {
                        com.esotericsoftware.spine.SlotData findSlot3 = skeletonData5.findSlot(jsonValue23.name);
                        if (findSlot3 == null) {
                            throw new com.badlogic.gdx.utils.SerializationException(str24 + jsonValue23.name);
                        }
                        com.badlogic.gdx.utils.JsonValue jsonValue24 = jsonValue23.child;
                        while (jsonValue24 != null) {
                            com.esotericsoftware.spine.attachments.VertexAttachment vertexAttachment = (com.esotericsoftware.spine.attachments.VertexAttachment) findSkin.getAttachment(findSlot3.a, jsonValue24.name);
                            if (vertexAttachment == null) {
                                throw new com.badlogic.gdx.utils.SerializationException("Deform attachment not found: " + jsonValue24.name);
                            }
                            boolean z = vertexAttachment.getBones() != null;
                            float[] vertices = vertexAttachment.getVertices();
                            int length = vertices.length;
                            if (z) {
                                length = (length / 3) * 2;
                            }
                            com.esotericsoftware.spine.Skin skin = findSkin;
                            com.esotericsoftware.spine.Animation.DeformTimeline deformTimeline = new com.esotericsoftware.spine.Animation.DeformTimeline(jsonValue24.size);
                            deformTimeline.b = findSlot3.a;
                            deformTimeline.c = vertexAttachment;
                            com.badlogic.gdx.utils.JsonValue jsonValue25 = jsonValue24.child;
                            int i21 = 0;
                            while (jsonValue25 != null) {
                                com.esotericsoftware.spine.SlotData slotData2 = findSlot3;
                                com.badlogic.gdx.utils.JsonValue jsonValue26 = jsonValue25.get("vertices");
                                if (jsonValue26 == null) {
                                    fArr = z ? new float[length] : vertices;
                                    jsonValue2 = child6;
                                    str4 = str26;
                                    jsonValue3 = jsonValue23;
                                    jsonValue4 = jsonValue24;
                                } else {
                                    float[] fArr2 = new float[length];
                                    jsonValue2 = child6;
                                    jsonValue3 = jsonValue23;
                                    int i22 = jsonValue25.getInt(str26, 0);
                                    str4 = str26;
                                    jsonValue4 = jsonValue24;
                                    java.lang.System.arraycopy(jsonValue26.asFloatArray(), 0, fArr2, i22, jsonValue26.size);
                                    if (f6 != 1.0f) {
                                        int i23 = jsonValue26.size + i22;
                                        while (i22 < i23) {
                                            fArr2[i22] = fArr2[i22] * f6;
                                            i22++;
                                        }
                                    }
                                    if (!z) {
                                        for (int i24 = 0; i24 < length; i24++) {
                                            fArr2[i24] = fArr2[i24] + vertices[i24];
                                        }
                                    }
                                    fArr = fArr2;
                                }
                                deformTimeline.setFrame(i21, jsonValue25.getFloat(str23), fArr);
                                c(jsonValue25, deformTimeline, i21);
                                i21++;
                                jsonValue25 = jsonValue25.next;
                                jsonValue23 = jsonValue3;
                                findSlot3 = slotData2;
                                child6 = jsonValue2;
                                str26 = str4;
                                jsonValue24 = jsonValue4;
                            }
                            array.add(deformTimeline);
                            f5 = java.lang.Math.max(f5, deformTimeline.getFrames()[deformTimeline.getFrameCount() - 1]);
                            jsonValue24 = jsonValue24.next;
                            findSkin = skin;
                            child6 = child6;
                            str26 = str26;
                        }
                        jsonValue23 = jsonValue23.next;
                        skeletonData5 = skeletonData;
                        child6 = child6;
                        str26 = str26;
                    }
                    child6 = child6.next;
                }
            }
        }
    }

    public final com.esotericsoftware.spine.attachments.Attachment b(com.badlogic.gdx.utils.JsonValue jsonValue, com.esotericsoftware.spine.Skin skin, int i, java.lang.String str, com.esotericsoftware.spine.SkeletonData skeletonData) {
        float f = this.b;
        java.lang.String string = jsonValue.getString("name", str);
        switch (com.esotericsoftware.spine.SkeletonJson.AnonymousClass1.a[com.esotericsoftware.spine.attachments.AttachmentType.valueOf(jsonValue.getString("type", com.esotericsoftware.spine.attachments.AttachmentType.region.name())).ordinal()]) {
            case 1:
                java.lang.String string2 = jsonValue.getString("path", string);
                com.esotericsoftware.spine.attachments.RegionAttachment newRegionAttachment = this.a.newRegionAttachment(skin, string, string2);
                if (newRegionAttachment == null) {
                    return null;
                }
                newRegionAttachment.setPath(string2);
                newRegionAttachment.setX(jsonValue.getFloat("x", 0.0f) * f);
                newRegionAttachment.setY(jsonValue.getFloat("y", 0.0f) * f);
                newRegionAttachment.setScaleX(jsonValue.getFloat("scaleX", 1.0f));
                newRegionAttachment.setScaleY(jsonValue.getFloat("scaleY", 1.0f));
                newRegionAttachment.setRotation(jsonValue.getFloat("rotation", 0.0f));
                newRegionAttachment.setWidth(jsonValue.getFloat("width") * f);
                newRegionAttachment.setHeight(jsonValue.getFloat("height") * f);
                java.lang.String string3 = jsonValue.getString("color", null);
                if (string3 != null) {
                    newRegionAttachment.getColor().set(com.badlogic.gdx.graphics.Color.valueOf(string3));
                }
                newRegionAttachment.updateOffset();
                return newRegionAttachment;
            case 2:
                com.esotericsoftware.spine.attachments.BoundingBoxAttachment newBoundingBoxAttachment = this.a.newBoundingBoxAttachment(skin, string);
                if (newBoundingBoxAttachment == null) {
                    return null;
                }
                d(jsonValue, newBoundingBoxAttachment, jsonValue.getInt("vertexCount") << 1);
                java.lang.String string4 = jsonValue.getString("color", null);
                if (string4 != null) {
                    newBoundingBoxAttachment.getColor().set(com.badlogic.gdx.graphics.Color.valueOf(string4));
                }
                return newBoundingBoxAttachment;
            case 3:
            case 4:
                java.lang.String string5 = jsonValue.getString("path", string);
                com.esotericsoftware.spine.attachments.MeshAttachment newMeshAttachment = this.a.newMeshAttachment(skin, string, string5);
                if (newMeshAttachment == null) {
                    return null;
                }
                newMeshAttachment.setPath(string5);
                java.lang.String string6 = jsonValue.getString("color", null);
                if (string6 != null) {
                    newMeshAttachment.getColor().set(com.badlogic.gdx.graphics.Color.valueOf(string6));
                }
                newMeshAttachment.setWidth(jsonValue.getFloat("width", 0.0f) * f);
                newMeshAttachment.setHeight(jsonValue.getFloat("height", 0.0f) * f);
                java.lang.String string7 = jsonValue.getString("parent", null);
                if (string7 != null) {
                    newMeshAttachment.setInheritDeform(jsonValue.getBoolean("deform", true));
                    this.c.add(new com.esotericsoftware.spine.SkeletonJson.LinkedMesh(newMeshAttachment, jsonValue.getString("skin", null), i, string7));
                    return newMeshAttachment;
                }
                float[] asFloatArray = jsonValue.require("uvs").asFloatArray();
                d(jsonValue, newMeshAttachment, asFloatArray.length);
                newMeshAttachment.setTriangles(jsonValue.require("triangles").asShortArray());
                newMeshAttachment.setRegionUVs(asFloatArray);
                newMeshAttachment.updateUVs();
                if (jsonValue.has("hull")) {
                    newMeshAttachment.setHullLength(jsonValue.require("hull").asInt() * 2);
                }
                if (jsonValue.has("edges")) {
                    newMeshAttachment.setEdges(jsonValue.require("edges").asShortArray());
                }
                return newMeshAttachment;
            case 5:
                com.esotericsoftware.spine.attachments.PathAttachment newPathAttachment = this.a.newPathAttachment(skin, string);
                if (newPathAttachment == null) {
                    return null;
                }
                int i2 = 0;
                newPathAttachment.setClosed(jsonValue.getBoolean("closed", false));
                newPathAttachment.setConstantSpeed(jsonValue.getBoolean("constantSpeed", true));
                int i3 = jsonValue.getInt("vertexCount");
                d(jsonValue, newPathAttachment, i3 << 1);
                float[] fArr = new float[i3 / 3];
                com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.require("lengths").child;
                while (jsonValue2 != null) {
                    fArr[i2] = jsonValue2.asFloat() * f;
                    jsonValue2 = jsonValue2.next;
                    i2++;
                }
                newPathAttachment.setLengths(fArr);
                java.lang.String string8 = jsonValue.getString("color", null);
                if (string8 != null) {
                    newPathAttachment.getColor().set(com.badlogic.gdx.graphics.Color.valueOf(string8));
                }
                return newPathAttachment;
            case 6:
                com.esotericsoftware.spine.attachments.PointAttachment newPointAttachment = this.a.newPointAttachment(skin, string);
                if (newPointAttachment == null) {
                    return null;
                }
                newPointAttachment.setX(jsonValue.getFloat("x", 0.0f) * f);
                newPointAttachment.setY(jsonValue.getFloat("y", 0.0f) * f);
                newPointAttachment.setRotation(jsonValue.getFloat("rotation", 0.0f));
                java.lang.String string9 = jsonValue.getString("color", null);
                if (string9 != null) {
                    newPointAttachment.getColor().set(com.badlogic.gdx.graphics.Color.valueOf(string9));
                }
                return newPointAttachment;
            case 7:
                com.esotericsoftware.spine.attachments.ClippingAttachment newClippingAttachment = this.a.newClippingAttachment(skin, string);
                if (newClippingAttachment == null) {
                    return null;
                }
                java.lang.String string10 = jsonValue.getString("end", null);
                if (string10 != null) {
                    com.esotericsoftware.spine.SlotData findSlot = skeletonData.findSlot(string10);
                    if (findSlot == null) {
                        throw new com.badlogic.gdx.utils.SerializationException("Clipping end slot not found: " + string10);
                    }
                    newClippingAttachment.setEndSlot(findSlot);
                }
                d(jsonValue, newClippingAttachment, jsonValue.getInt("vertexCount") << 1);
                java.lang.String string11 = jsonValue.getString("color", null);
                if (string11 != null) {
                    newClippingAttachment.getColor().set(com.badlogic.gdx.graphics.Color.valueOf(string11));
                }
                return newClippingAttachment;
            default:
                return null;
        }
    }

    public void c(com.badlogic.gdx.utils.JsonValue jsonValue, com.esotericsoftware.spine.Animation.CurveTimeline curveTimeline, int i) {
        com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.get("curve");
        if (jsonValue2 == null) {
            return;
        }
        if (jsonValue2.isString() && jsonValue2.asString().equals("stepped")) {
            curveTimeline.setStepped(i);
        } else if (jsonValue2.isArray()) {
            curveTimeline.setCurve(i, jsonValue2.getFloat(0), jsonValue2.getFloat(1), jsonValue2.getFloat(2), jsonValue2.getFloat(3));
        }
    }

    public final void d(com.badlogic.gdx.utils.JsonValue jsonValue, com.esotericsoftware.spine.attachments.VertexAttachment vertexAttachment, int i) {
        vertexAttachment.setWorldVerticesLength(i);
        float[] asFloatArray = jsonValue.require("vertices").asFloatArray();
        int i2 = 0;
        if (i == asFloatArray.length) {
            if (this.b != 1.0f) {
                int length = asFloatArray.length;
                while (i2 < length) {
                    asFloatArray[i2] = asFloatArray[i2] * this.b;
                    i2++;
                }
            }
            vertexAttachment.setVertices(asFloatArray);
            return;
        }
        int i3 = i * 3;
        com.badlogic.gdx.utils.FloatArray floatArray = new com.badlogic.gdx.utils.FloatArray(i3 * 3);
        com.badlogic.gdx.utils.IntArray intArray = new com.badlogic.gdx.utils.IntArray(i3);
        int length2 = asFloatArray.length;
        while (i2 < length2) {
            int i4 = i2 + 1;
            int i5 = (int) asFloatArray[i2];
            intArray.add(i5);
            int i6 = (i5 * 4) + i4;
            while (i4 < i6) {
                intArray.add((int) asFloatArray[i4]);
                floatArray.add(asFloatArray[i4 + 1] * this.b);
                floatArray.add(asFloatArray[i4 + 2] * this.b);
                floatArray.add(asFloatArray[i4 + 3]);
                i4 += 4;
            }
            i2 = i4;
        }
        vertexAttachment.setBones(intArray.toArray());
        vertexAttachment.setVertices(floatArray.toArray());
    }

    public float getScale() {
        return this.b;
    }

    public com.esotericsoftware.spine.SkeletonData readSkeletonData(com.badlogic.gdx.files.FileHandle fileHandle) {
        com.esotericsoftware.spine.BoneData boneData;
        if (fileHandle == null) {
            throw new java.lang.IllegalArgumentException("file cannot be null.");
        }
        float f = this.b;
        com.esotericsoftware.spine.SkeletonData skeletonData = new com.esotericsoftware.spine.SkeletonData();
        skeletonData.a = fileHandle.nameWithoutExtension();
        com.badlogic.gdx.utils.JsonValue parse = new com.badlogic.gdx.utils.JsonReader().parse(fileHandle);
        com.badlogic.gdx.utils.JsonValue jsonValue = parse.get("skeleton");
        java.lang.String str = "audio";
        if (jsonValue != null) {
            skeletonData.n = jsonValue.getString("hash", null);
            skeletonData.m = jsonValue.getString("spine", null);
            skeletonData.k = jsonValue.getFloat("width", 0.0f);
            skeletonData.l = jsonValue.getFloat("height", 0.0f);
            skeletonData.o = jsonValue.getFloat("fps", 30.0f);
            skeletonData.p = jsonValue.getString("images", null);
            skeletonData.q = jsonValue.getString("audio", null);
        }
        java.lang.String str2 = "bones";
        com.badlogic.gdx.utils.JsonValue child = parse.getChild("bones");
        while (true) {
            java.lang.String str3 = "shearY";
            java.lang.String str4 = "scaleY";
            java.lang.String str5 = "length";
            java.lang.String str6 = str;
            if (child != null) {
                java.lang.String str7 = str2;
                java.lang.String string = child.getString("parent", null);
                if (string != null) {
                    boneData = skeletonData.findBone(string);
                    if (boneData == null) {
                        throw new com.badlogic.gdx.utils.SerializationException("Parent bone not found: " + string);
                    }
                } else {
                    boneData = null;
                }
                com.badlogic.gdx.utils.JsonValue jsonValue2 = parse;
                com.esotericsoftware.spine.BoneData boneData2 = new com.esotericsoftware.spine.BoneData(skeletonData.b.size, child.getString("name"), boneData);
                boneData2.d = child.getFloat("length", 0.0f) * f;
                boneData2.e = child.getFloat("x", 0.0f) * f;
                boneData2.f = child.getFloat("y", 0.0f) * f;
                boneData2.g = child.getFloat("rotation", 0.0f);
                boneData2.h = child.getFloat("scaleX", 1.0f);
                boneData2.i = child.getFloat("scaleY", 1.0f);
                boneData2.j = child.getFloat("shearX", 0.0f);
                boneData2.k = child.getFloat("shearY", 0.0f);
                boneData2.l = com.esotericsoftware.spine.BoneData.TransformMode.valueOf(child.getString("transform", com.esotericsoftware.spine.BoneData.TransformMode.normal.name()));
                java.lang.String string2 = child.getString("color", null);
                if (string2 != null) {
                    boneData2.getColor().set(com.badlogic.gdx.graphics.Color.valueOf(string2));
                }
                skeletonData.b.add(boneData2);
                child = child.next;
                str = str6;
                str2 = str7;
                parse = jsonValue2;
            } else {
                java.lang.String str8 = str2;
                com.badlogic.gdx.utils.JsonValue jsonValue3 = parse;
                com.badlogic.gdx.utils.JsonValue child2 = jsonValue3.getChild("slots");
                while (child2 != null) {
                    java.lang.String string3 = child2.getString("name");
                    java.lang.String string4 = child2.getString("bone");
                    java.lang.String str9 = str5;
                    com.esotericsoftware.spine.BoneData findBone = skeletonData.findBone(string4);
                    if (findBone == null) {
                        throw new com.badlogic.gdx.utils.SerializationException("Slot bone not found: " + string4);
                    }
                    java.lang.String str10 = str3;
                    com.esotericsoftware.spine.SlotData slotData = new com.esotericsoftware.spine.SlotData(skeletonData.c.size, string3, findBone);
                    java.lang.String string5 = child2.getString("color", null);
                    if (string5 != null) {
                        slotData.getColor().set(com.badlogic.gdx.graphics.Color.valueOf(string5));
                    }
                    java.lang.String string6 = child2.getString("dark", null);
                    if (string6 != null) {
                        slotData.setDarkColor(com.badlogic.gdx.graphics.Color.valueOf(string6));
                    }
                    slotData.f = child2.getString("attachment", null);
                    slotData.g = com.esotericsoftware.spine.BlendMode.valueOf(child2.getString("blend", com.esotericsoftware.spine.BlendMode.normal.name()));
                    skeletonData.c.add(slotData);
                    child2 = child2.next;
                    str5 = str9;
                    str3 = str10;
                }
                java.lang.String str11 = str5;
                java.lang.String str12 = str3;
                com.badlogic.gdx.utils.JsonValue child3 = jsonValue3.getChild("ik");
                while (true) {
                    int i = 0;
                    if (child3 == null) {
                        java.lang.String str13 = str4;
                        java.lang.String str14 = str8;
                        com.badlogic.gdx.utils.JsonValue child4 = jsonValue3.getChild("transform");
                        while (child4 != null) {
                            com.badlogic.gdx.utils.JsonValue jsonValue4 = jsonValue3;
                            com.esotericsoftware.spine.TransformConstraintData transformConstraintData = new com.esotericsoftware.spine.TransformConstraintData(child4.getString("name"));
                            transformConstraintData.b = child4.getInt("order", i);
                            com.badlogic.gdx.utils.JsonValue child5 = child4.getChild(str14);
                            while (child5 != null) {
                                java.lang.String asString = child5.asString();
                                java.lang.String str15 = str14;
                                com.esotericsoftware.spine.BoneData findBone2 = skeletonData.findBone(asString);
                                if (findBone2 == null) {
                                    throw new com.badlogic.gdx.utils.SerializationException("Transform constraint bone not found: " + asString);
                                }
                                transformConstraintData.c.add(findBone2);
                                child5 = child5.next;
                                str14 = str15;
                            }
                            java.lang.String str16 = str14;
                            java.lang.String string7 = child4.getString(com.umeng.ccg.a.A);
                            com.esotericsoftware.spine.BoneData findBone3 = skeletonData.findBone(string7);
                            transformConstraintData.d = findBone3;
                            if (findBone3 == null) {
                                throw new com.badlogic.gdx.utils.SerializationException("Transform constraint target bone not found: " + string7);
                            }
                            transformConstraintData.p = child4.getBoolean("local", false);
                            transformConstraintData.o = child4.getBoolean("relative", false);
                            transformConstraintData.i = child4.getFloat("rotation", 0.0f);
                            transformConstraintData.j = child4.getFloat("x", 0.0f) * f;
                            transformConstraintData.k = child4.getFloat("y", 0.0f) * f;
                            transformConstraintData.l = child4.getFloat("scaleX", 0.0f);
                            transformConstraintData.m = child4.getFloat(str13, 0.0f);
                            transformConstraintData.n = child4.getFloat(str12, 0.0f);
                            transformConstraintData.e = child4.getFloat("rotateMix", 1.0f);
                            transformConstraintData.f = child4.getFloat("translateMix", 1.0f);
                            transformConstraintData.g = child4.getFloat("scaleMix", 1.0f);
                            transformConstraintData.h = child4.getFloat("shearMix", 1.0f);
                            skeletonData.i.add(transformConstraintData);
                            child4 = child4.next;
                            jsonValue3 = jsonValue4;
                            str14 = str16;
                            i = 0;
                        }
                        java.lang.String str17 = str14;
                        com.badlogic.gdx.utils.JsonValue child6 = jsonValue3.getChild("path");
                        while (child6 != null) {
                            com.esotericsoftware.spine.PathConstraintData pathConstraintData = new com.esotericsoftware.spine.PathConstraintData(child6.getString("name"));
                            pathConstraintData.b = child6.getInt("order", 0);
                            java.lang.String str18 = str17;
                            for (com.badlogic.gdx.utils.JsonValue child7 = child6.getChild(str18); child7 != null; child7 = child7.next) {
                                java.lang.String asString2 = child7.asString();
                                com.esotericsoftware.spine.BoneData findBone4 = skeletonData.findBone(asString2);
                                if (findBone4 == null) {
                                    throw new com.badlogic.gdx.utils.SerializationException("Path bone not found: " + asString2);
                                }
                                pathConstraintData.c.add(findBone4);
                            }
                            java.lang.String string8 = child6.getString(com.umeng.ccg.a.A);
                            com.esotericsoftware.spine.SlotData findSlot = skeletonData.findSlot(string8);
                            pathConstraintData.d = findSlot;
                            if (findSlot == null) {
                                throw new com.badlogic.gdx.utils.SerializationException("Path target slot not found: " + string8);
                            }
                            pathConstraintData.e = com.esotericsoftware.spine.PathConstraintData.PositionMode.valueOf(child6.getString("positionMode", "percent"));
                            java.lang.String str19 = str11;
                            pathConstraintData.f = com.esotericsoftware.spine.PathConstraintData.SpacingMode.valueOf(child6.getString("spacingMode", str19));
                            pathConstraintData.g = com.esotericsoftware.spine.PathConstraintData.RotateMode.valueOf(child6.getString("rotateMode", "tangent"));
                            pathConstraintData.h = child6.getFloat("rotation", 0.0f);
                            float f2 = child6.getFloat(com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, 0.0f);
                            pathConstraintData.i = f2;
                            if (pathConstraintData.e == com.esotericsoftware.spine.PathConstraintData.PositionMode.fixed) {
                                pathConstraintData.i = f2 * f;
                            }
                            float f3 = child6.getFloat("spacing", 0.0f);
                            pathConstraintData.j = f3;
                            com.esotericsoftware.spine.PathConstraintData.SpacingMode spacingMode = pathConstraintData.f;
                            if (spacingMode == com.esotericsoftware.spine.PathConstraintData.SpacingMode.length || spacingMode == com.esotericsoftware.spine.PathConstraintData.SpacingMode.fixed) {
                                pathConstraintData.j = f3 * f;
                            }
                            pathConstraintData.k = child6.getFloat("rotateMix", 1.0f);
                            pathConstraintData.l = child6.getFloat("translateMix", 1.0f);
                            skeletonData.j.add(pathConstraintData);
                            child6 = child6.next;
                            str17 = str18;
                            str11 = str19;
                        }
                        for (com.badlogic.gdx.utils.JsonValue child8 = jsonValue3.getChild("skins"); child8 != null; child8 = child8.next) {
                            com.esotericsoftware.spine.Skin skin = new com.esotericsoftware.spine.Skin(child8.name);
                            for (com.badlogic.gdx.utils.JsonValue jsonValue5 = child8.child; jsonValue5 != null; jsonValue5 = jsonValue5.next) {
                                com.esotericsoftware.spine.SlotData findSlot2 = skeletonData.findSlot(jsonValue5.name);
                                if (findSlot2 == null) {
                                    throw new com.badlogic.gdx.utils.SerializationException("Slot not found: " + jsonValue5.name);
                                }
                                for (com.badlogic.gdx.utils.JsonValue jsonValue6 = jsonValue5.child; jsonValue6 != null; jsonValue6 = jsonValue6.next) {
                                    try {
                                        com.esotericsoftware.spine.attachments.Attachment b = b(jsonValue6, skin, findSlot2.a, jsonValue6.name, skeletonData);
                                        if (b != null) {
                                            skin.addAttachment(findSlot2.a, jsonValue6.name, b);
                                        }
                                    } catch (java.lang.Exception e) {
                                        throw new com.badlogic.gdx.utils.SerializationException("Error reading attachment: " + jsonValue6.name + ", skin: " + skin, e);
                                    }
                                }
                            }
                            skeletonData.d.add(skin);
                            if (skin.a.equals("default")) {
                                skeletonData.e = skin;
                            }
                        }
                        int i2 = this.c.size;
                        for (int i3 = 0; i3 < i2; i3++) {
                            com.esotericsoftware.spine.SkeletonJson.LinkedMesh linkedMesh = this.c.get(i3);
                            java.lang.String str20 = linkedMesh.b;
                            com.esotericsoftware.spine.Skin defaultSkin = str20 == null ? skeletonData.getDefaultSkin() : skeletonData.findSkin(str20);
                            if (defaultSkin == null) {
                                throw new com.badlogic.gdx.utils.SerializationException("Skin not found: " + linkedMesh.b);
                            }
                            com.esotericsoftware.spine.attachments.Attachment attachment = defaultSkin.getAttachment(linkedMesh.c, linkedMesh.a);
                            if (attachment == null) {
                                throw new com.badlogic.gdx.utils.SerializationException("Parent mesh not found: " + linkedMesh.a);
                            }
                            linkedMesh.d.setParentMesh((com.esotericsoftware.spine.attachments.MeshAttachment) attachment);
                            linkedMesh.d.updateUVs();
                        }
                        this.c.clear();
                        for (com.badlogic.gdx.utils.JsonValue child9 = jsonValue3.getChild("events"); child9 != null; child9 = child9.next) {
                            com.esotericsoftware.spine.EventData eventData = new com.esotericsoftware.spine.EventData(child9.name);
                            eventData.b = child9.getInt(com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, 0);
                            eventData.c = child9.getFloat("float", 0.0f);
                            eventData.d = child9.getString(com.anythink.expressad.foundation.h.i.g, "");
                            eventData.e = child9.getString(str6, "");
                            skeletonData.f.add(eventData);
                        }
                        for (com.badlogic.gdx.utils.JsonValue child10 = jsonValue3.getChild("animations"); child10 != null; child10 = child10.next) {
                            try {
                                a(child10, child10.name, skeletonData);
                            } catch (java.lang.Exception e2) {
                                throw new com.badlogic.gdx.utils.SerializationException("Error reading animation: " + child10.name, e2);
                            }
                        }
                        skeletonData.b.shrink();
                        skeletonData.c.shrink();
                        skeletonData.d.shrink();
                        skeletonData.f.shrink();
                        skeletonData.g.shrink();
                        skeletonData.h.shrink();
                        return skeletonData;
                    }
                    com.esotericsoftware.spine.IkConstraintData ikConstraintData = new com.esotericsoftware.spine.IkConstraintData(child3.getString("name"));
                    ikConstraintData.b = child3.getInt("order", 0);
                    java.lang.String str21 = str8;
                    com.badlogic.gdx.utils.JsonValue child11 = child3.getChild(str21);
                    while (child11 != null) {
                        java.lang.String asString3 = child11.asString();
                        java.lang.String str22 = str4;
                        com.esotericsoftware.spine.BoneData findBone5 = skeletonData.findBone(asString3);
                        if (findBone5 == null) {
                            throw new com.badlogic.gdx.utils.SerializationException("IK bone not found: " + asString3);
                        }
                        ikConstraintData.c.add(findBone5);
                        child11 = child11.next;
                        str4 = str22;
                    }
                    java.lang.String str23 = str4;
                    java.lang.String string9 = child3.getString(com.umeng.ccg.a.A);
                    com.esotericsoftware.spine.BoneData findBone6 = skeletonData.findBone(string9);
                    ikConstraintData.d = findBone6;
                    if (findBone6 == null) {
                        throw new com.badlogic.gdx.utils.SerializationException("IK target bone not found: " + string9);
                    }
                    int i4 = 1;
                    if (!child3.getBoolean("bendPositive", true)) {
                        i4 = -1;
                    }
                    ikConstraintData.e = i4;
                    ikConstraintData.f = child3.getFloat("mix", 1.0f);
                    skeletonData.h.add(ikConstraintData);
                    child3 = child3.next;
                    str8 = str21;
                    str4 = str23;
                }
            }
        }
    }

    public void setScale(float f) {
        this.b = f;
    }
}
