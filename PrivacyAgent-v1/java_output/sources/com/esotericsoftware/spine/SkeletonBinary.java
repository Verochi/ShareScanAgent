package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class SkeletonBinary {
    public static final int BONE_ROTATE = 0;
    public static final int BONE_SCALE = 2;
    public static final int BONE_SHEAR = 3;
    public static final int BONE_TRANSLATE = 1;
    public static final int CURVE_BEZIER = 2;
    public static final int CURVE_LINEAR = 0;
    public static final int CURVE_STEPPED = 1;
    public static final int PATH_MIX = 2;
    public static final int PATH_POSITION = 0;
    public static final int PATH_SPACING = 1;
    public static final int SLOT_ATTACHMENT = 0;
    public static final int SLOT_COLOR = 1;
    public static final int SLOT_TWO_COLOR = 2;
    public static final com.badlogic.gdx.graphics.Color d = new com.badlogic.gdx.graphics.Color();
    public static final com.badlogic.gdx.graphics.Color e = new com.badlogic.gdx.graphics.Color();
    public final com.esotericsoftware.spine.attachments.AttachmentLoader a;
    public float b = 1.0f;
    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.SkeletonJson.LinkedMesh> c = new com.badlogic.gdx.utils.Array<>();

    /* renamed from: com.esotericsoftware.spine.SkeletonBinary$1, reason: invalid class name */
    public class AnonymousClass1 extends com.badlogic.gdx.utils.DataInput {
        public char[] t;

        public AnonymousClass1(java.io.InputStream inputStream) {
            super(inputStream);
            this.t = new char[32];
        }

        @Override // com.badlogic.gdx.utils.DataInput
        public java.lang.String readString() throws java.io.IOException {
            int i;
            int readInt = readInt(true);
            if (readInt == 0) {
                return null;
            }
            if (readInt == 1) {
                return "";
            }
            int i2 = readInt - 1;
            if (this.t.length < i2) {
                this.t = new char[i2];
            }
            char[] cArr = this.t;
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int read = read();
                int i5 = read >> 4;
                if (i5 == -1) {
                    throw new java.io.EOFException();
                }
                switch (i5) {
                    case 12:
                    case 13:
                        i = i4 + 1;
                        cArr[i4] = (char) (((read & 31) << 6) | (read() & 63));
                        i3 += 2;
                        break;
                    case 14:
                        i = i4 + 1;
                        cArr[i4] = (char) (((read & 15) << 12) | ((read() & 63) << 6) | (read() & 63));
                        i3 += 3;
                        break;
                    default:
                        i = i4 + 1;
                        cArr[i4] = (char) read;
                        i3++;
                        break;
                }
                i4 = i;
            }
            return new java.lang.String(cArr, 0, i4);
        }
    }

    /* renamed from: com.esotericsoftware.spine.SkeletonBinary$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
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

    public static class Vertices {
        public int[] a;
        public float[] b;
    }

    public SkeletonBinary(com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas) {
        this.a = new com.esotericsoftware.spine.attachments.AtlasAttachmentLoader(textureAtlas);
    }

    public SkeletonBinary(com.esotericsoftware.spine.attachments.AttachmentLoader attachmentLoader) {
        if (attachmentLoader == null) {
            throw new java.lang.IllegalArgumentException("attachmentLoader cannot be null.");
        }
        this.a = attachmentLoader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:162:0x032a, code lost:
    
        if (r9.e == com.esotericsoftware.spine.PathConstraintData.PositionMode.fixed) goto L112;
     */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019c A[Catch: IOException -> 0x0589, TryCatch #0 {IOException -> 0x0589, blocks: (B:3:0x000e, B:6:0x0017, B:8:0x0022, B:14:0x0137, B:15:0x003a, B:17:0x0044, B:19:0x0089, B:21:0x008c, B:24:0x009b, B:26:0x00b6, B:28:0x00c8, B:30:0x00f0, B:32:0x00f3, B:35:0x00f6, B:37:0x0108, B:39:0x011a, B:41:0x0128, B:44:0x0147, B:46:0x0154, B:49:0x015f, B:51:0x016a, B:59:0x01fe, B:61:0x0180, B:63:0x0197, B:65:0x019c, B:67:0x01b3, B:69:0x01b6, B:72:0x01ba, B:75:0x018a, B:76:0x0190, B:78:0x01cd, B:80:0x01d7, B:82:0x01e6, B:84:0x01e9, B:87:0x01ec, B:90:0x0204, B:92:0x0209, B:94:0x0210, B:96:0x0222, B:98:0x0235, B:100:0x0238, B:103:0x023b, B:105:0x0251, B:107:0x0258, B:109:0x026a, B:111:0x0287, B:113:0x028a, B:116:0x028d, B:118:0x02a2, B:120:0x02a9, B:122:0x02be, B:129:0x035f, B:130:0x02d1, B:132:0x02db, B:134:0x02f0, B:136:0x02f3, B:139:0x02f8, B:143:0x0311, B:145:0x031c, B:149:0x0331, B:151:0x0336, B:153:0x0347, B:155:0x034a, B:158:0x034d, B:161:0x0321, B:164:0x0366, B:166:0x036d, B:168:0x0376, B:170:0x0389, B:172:0x0394, B:175:0x03a7, B:177:0x03af, B:178:0x03be, B:180:0x03d3, B:183:0x03e4, B:185:0x042c, B:187:0x0433, B:189:0x0436, B:192:0x03ed, B:196:0x0402, B:201:0x0421, B:205:0x0411, B:208:0x0441, B:209:0x03b9, B:212:0x046a, B:214:0x047f, B:216:0x0490, B:218:0x0496, B:220:0x04a4, B:223:0x04b5, B:225:0x04ba, B:227:0x04c5, B:229:0x04ce, B:231:0x04d9, B:235:0x04f0, B:238:0x04fb, B:240:0x0500, B:242:0x0506, B:245:0x0509, B:247:0x0511, B:248:0x0523, B:250:0x052a, B:252:0x0532, B:254:0x055b, B:256:0x0562, B:257:0x0560, B:260:0x056a), top: B:2:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.badlogic.gdx.utils.DataInput dataInput, java.lang.String str, com.esotericsoftware.spine.SkeletonData skeletonData) {
        com.esotericsoftware.spine.SkeletonData skeletonData2;
        float[] fArr;
        int i;
        int i2;
        com.esotericsoftware.spine.Animation.PathConstraintPositionTimeline pathConstraintPositionTimeline;
        float f;
        byte b;
        com.esotericsoftware.spine.Animation.TranslateTimeline translateTimeline;
        float f2;
        int i3;
        float f3;
        int i4;
        int i5;
        int i6;
        com.badlogic.gdx.utils.Array array = new com.badlogic.gdx.utils.Array();
        float f4 = this.b;
        boolean z = true;
        try {
            int readInt = dataInput.readInt(true);
            float f5 = 0.0f;
            int i7 = 0;
            while (true) {
                byte b2 = 2;
                if (i7 >= readInt) {
                    break;
                }
                int readInt2 = dataInput.readInt(z);
                int readInt3 = dataInput.readInt(z);
                int i8 = 0;
                while (i8 < readInt3) {
                    byte readByte = dataInput.readByte();
                    int readInt4 = dataInput.readInt(z);
                    if (readByte == 0) {
                        f3 = f4;
                        i4 = readInt;
                        i5 = i7;
                        i6 = readInt3;
                        com.esotericsoftware.spine.Animation.AttachmentTimeline attachmentTimeline = new com.esotericsoftware.spine.Animation.AttachmentTimeline(readInt4);
                        attachmentTimeline.a = readInt2;
                        for (int i9 = 0; i9 < readInt4; i9++) {
                            attachmentTimeline.setFrame(i9, dataInput.readFloat(), dataInput.readString());
                        }
                        array.add(attachmentTimeline);
                        f5 = java.lang.Math.max(f5, attachmentTimeline.getFrames()[readInt4 - 1]);
                    } else if (readByte == z) {
                        f3 = f4;
                        i4 = readInt;
                        i5 = i7;
                        i6 = readInt3;
                        com.esotericsoftware.spine.Animation.ColorTimeline colorTimeline = new com.esotericsoftware.spine.Animation.ColorTimeline(readInt4);
                        colorTimeline.b = readInt2;
                        for (int i10 = 0; i10 < readInt4; i10++) {
                            float readFloat = dataInput.readFloat();
                            com.badlogic.gdx.graphics.Color color = d;
                            com.badlogic.gdx.graphics.Color.rgba8888ToColor(color, dataInput.readInt());
                            colorTimeline.setFrame(i10, readFloat, color.r, color.g, color.b, color.a);
                            if (i10 < readInt4 - 1) {
                                c(dataInput, i10, colorTimeline);
                            }
                        }
                        array.add(colorTimeline);
                        f5 = java.lang.Math.max(f5, colorTimeline.getFrames()[(readInt4 - 1) * 5]);
                    } else if (readByte != b2) {
                        f3 = f4;
                        i4 = readInt;
                        i5 = i7;
                        i6 = readInt3;
                    } else {
                        com.esotericsoftware.spine.Animation.TwoColorTimeline twoColorTimeline = new com.esotericsoftware.spine.Animation.TwoColorTimeline(readInt4);
                        twoColorTimeline.b = readInt2;
                        int i11 = 0;
                        while (i11 < readInt4) {
                            float readFloat2 = dataInput.readFloat();
                            com.badlogic.gdx.graphics.Color color2 = d;
                            com.badlogic.gdx.graphics.Color.rgba8888ToColor(color2, dataInput.readInt());
                            com.badlogic.gdx.graphics.Color color3 = e;
                            int i12 = readInt;
                            com.badlogic.gdx.graphics.Color.rgb888ToColor(color3, dataInput.readInt());
                            int i13 = readInt3;
                            float f6 = f4;
                            int i14 = i7;
                            twoColorTimeline.setFrame(i11, readFloat2, color2.r, color2.g, color2.b, color2.a, color3.r, color3.g, color3.b);
                            if (i11 < readInt4 - 1) {
                                c(dataInput, i11, twoColorTimeline);
                            }
                            i11++;
                            readInt = i12;
                            readInt3 = i13;
                            f4 = f6;
                            i7 = i14;
                        }
                        f3 = f4;
                        i4 = readInt;
                        i5 = i7;
                        i6 = readInt3;
                        array.add(twoColorTimeline);
                        f5 = java.lang.Math.max(f5, twoColorTimeline.getFrames()[(readInt4 - 1) * 8]);
                    }
                    i8++;
                    readInt = i4;
                    readInt3 = i6;
                    f4 = f3;
                    i7 = i5;
                    z = true;
                    b2 = 2;
                }
                i7++;
                z = true;
            }
            float f7 = f4;
            boolean z2 = true;
            int readInt5 = dataInput.readInt(true);
            int i15 = 0;
            while (true) {
                byte b3 = 3;
                if (i15 >= readInt5) {
                    break;
                }
                int readInt6 = dataInput.readInt(z2);
                int readInt7 = dataInput.readInt(z2);
                int i16 = 0;
                while (i16 < readInt7) {
                    byte readByte2 = dataInput.readByte();
                    int readInt8 = dataInput.readInt(z2);
                    if (readByte2 != 0) {
                        if (readByte2 != z2) {
                            b = 2;
                            if (readByte2 != 2 && readByte2 != b3) {
                            }
                        } else {
                            b = 2;
                        }
                        if (readByte2 == b) {
                            translateTimeline = new com.esotericsoftware.spine.Animation.ScaleTimeline(readInt8);
                        } else if (readByte2 == b3) {
                            translateTimeline = new com.esotericsoftware.spine.Animation.ShearTimeline(readInt8);
                        } else {
                            translateTimeline = new com.esotericsoftware.spine.Animation.TranslateTimeline(readInt8);
                            f2 = f7;
                            translateTimeline.b = readInt6;
                            for (i3 = 0; i3 < readInt8; i3++) {
                                translateTimeline.setFrame(i3, dataInput.readFloat(), dataInput.readFloat() * f2, dataInput.readFloat() * f2);
                                if (i3 < readInt8 - 1) {
                                    c(dataInput, i3, translateTimeline);
                                }
                            }
                            array.add(translateTimeline);
                            f5 = java.lang.Math.max(f5, translateTimeline.getFrames()[(readInt8 - 1) * 3]);
                        }
                        f2 = 1.0f;
                        translateTimeline.b = readInt6;
                        while (i3 < readInt8) {
                        }
                        array.add(translateTimeline);
                        f5 = java.lang.Math.max(f5, translateTimeline.getFrames()[(readInt8 - 1) * 3]);
                    } else {
                        com.esotericsoftware.spine.Animation.RotateTimeline rotateTimeline = new com.esotericsoftware.spine.Animation.RotateTimeline(readInt8);
                        rotateTimeline.b = readInt6;
                        for (int i17 = 0; i17 < readInt8; i17++) {
                            rotateTimeline.setFrame(i17, dataInput.readFloat(), dataInput.readFloat());
                            if (i17 < readInt8 - 1) {
                                c(dataInput, i17, rotateTimeline);
                            }
                        }
                        array.add(rotateTimeline);
                        f5 = java.lang.Math.max(f5, rotateTimeline.getFrames()[(readInt8 - 1) * 2]);
                    }
                    i16++;
                    z2 = true;
                    b3 = 3;
                }
                i15++;
                z2 = true;
            }
            int readInt9 = dataInput.readInt(z2);
            int i18 = 0;
            while (i18 < readInt9) {
                int readInt10 = dataInput.readInt(z2);
                int readInt11 = dataInput.readInt(z2);
                com.esotericsoftware.spine.Animation.IkConstraintTimeline ikConstraintTimeline = new com.esotericsoftware.spine.Animation.IkConstraintTimeline(readInt11);
                ikConstraintTimeline.b = readInt10;
                for (int i19 = 0; i19 < readInt11; i19++) {
                    ikConstraintTimeline.setFrame(i19, dataInput.readFloat(), dataInput.readFloat(), dataInput.readByte());
                    if (i19 < readInt11 - 1) {
                        c(dataInput, i19, ikConstraintTimeline);
                    }
                }
                array.add(ikConstraintTimeline);
                f5 = java.lang.Math.max(f5, ikConstraintTimeline.getFrames()[(readInt11 - 1) * 3]);
                i18++;
                z2 = true;
            }
            int readInt12 = dataInput.readInt(z2);
            int i20 = 0;
            while (i20 < readInt12) {
                int readInt13 = dataInput.readInt(z2);
                int readInt14 = dataInput.readInt(z2);
                com.esotericsoftware.spine.Animation.TransformConstraintTimeline transformConstraintTimeline = new com.esotericsoftware.spine.Animation.TransformConstraintTimeline(readInt14);
                transformConstraintTimeline.b = readInt13;
                for (int i21 = 0; i21 < readInt14; i21++) {
                    transformConstraintTimeline.setFrame(i21, dataInput.readFloat(), dataInput.readFloat(), dataInput.readFloat(), dataInput.readFloat(), dataInput.readFloat());
                    if (i21 < readInt14 - 1) {
                        c(dataInput, i21, transformConstraintTimeline);
                    }
                }
                array.add(transformConstraintTimeline);
                f5 = java.lang.Math.max(f5, transformConstraintTimeline.getFrames()[(readInt14 - 1) * 5]);
                i20++;
                z2 = true;
            }
            int readInt15 = dataInput.readInt(z2);
            int i22 = 0;
            while (i22 < readInt15) {
                int readInt16 = dataInput.readInt(z2);
                com.esotericsoftware.spine.PathConstraintData pathConstraintData = skeletonData.j.get(readInt16);
                int readInt17 = dataInput.readInt(z2);
                int i23 = 0;
                while (i23 < readInt17) {
                    byte readByte3 = dataInput.readByte();
                    int readInt18 = dataInput.readInt(z2);
                    if (readByte3 == 0 || readByte3 == z2) {
                        i2 = readInt15;
                        if (readByte3 == z2) {
                            pathConstraintPositionTimeline = new com.esotericsoftware.spine.Animation.PathConstraintSpacingTimeline(readInt18);
                            com.esotericsoftware.spine.PathConstraintData.SpacingMode spacingMode = pathConstraintData.f;
                            if (spacingMode != com.esotericsoftware.spine.PathConstraintData.SpacingMode.length) {
                                if (spacingMode == com.esotericsoftware.spine.PathConstraintData.SpacingMode.fixed) {
                                }
                                f = 1.0f;
                            }
                            f = f7;
                        } else {
                            pathConstraintPositionTimeline = new com.esotericsoftware.spine.Animation.PathConstraintPositionTimeline(readInt18);
                        }
                        pathConstraintPositionTimeline.b = readInt16;
                        for (int i24 = 0; i24 < readInt18; i24++) {
                            pathConstraintPositionTimeline.setFrame(i24, dataInput.readFloat(), dataInput.readFloat() * f);
                            if (i24 < readInt18 - 1) {
                                c(dataInput, i24, pathConstraintPositionTimeline);
                            }
                        }
                        array.add(pathConstraintPositionTimeline);
                        f5 = java.lang.Math.max(f5, pathConstraintPositionTimeline.getFrames()[(readInt18 - 1) * 2]);
                    } else if (readByte3 != 2) {
                        i2 = readInt15;
                    } else {
                        com.esotericsoftware.spine.Animation.PathConstraintMixTimeline pathConstraintMixTimeline = new com.esotericsoftware.spine.Animation.PathConstraintMixTimeline(readInt18);
                        pathConstraintMixTimeline.b = readInt16;
                        int i25 = 0;
                        while (i25 < readInt18) {
                            int i26 = readInt15;
                            pathConstraintMixTimeline.setFrame(i25, dataInput.readFloat(), dataInput.readFloat(), dataInput.readFloat());
                            if (i25 < readInt18 - 1) {
                                c(dataInput, i25, pathConstraintMixTimeline);
                            }
                            i25++;
                            readInt15 = i26;
                        }
                        i2 = readInt15;
                        array.add(pathConstraintMixTimeline);
                        f5 = java.lang.Math.max(f5, pathConstraintMixTimeline.getFrames()[(readInt18 - 1) * 3]);
                    }
                    i23++;
                    readInt15 = i2;
                    z2 = true;
                }
                i22++;
                z2 = true;
            }
            com.esotericsoftware.spine.SkeletonData skeletonData3 = skeletonData;
            int readInt19 = dataInput.readInt(z2);
            int i27 = 0;
            while (i27 < readInt19) {
                com.esotericsoftware.spine.Skin skin = skeletonData3.d.get(dataInput.readInt(z2));
                int readInt20 = dataInput.readInt(z2);
                int i28 = 0;
                while (i28 < readInt20) {
                    int readInt21 = dataInput.readInt(z2);
                    int readInt22 = dataInput.readInt(z2);
                    int i29 = 0;
                    while (i29 < readInt22) {
                        com.esotericsoftware.spine.attachments.VertexAttachment vertexAttachment = (com.esotericsoftware.spine.attachments.VertexAttachment) skin.getAttachment(readInt21, dataInput.readString());
                        boolean z3 = vertexAttachment.getBones() != null;
                        float[] vertices = vertexAttachment.getVertices();
                        int i30 = readInt19;
                        int length = z3 ? (vertices.length / 3) * 2 : vertices.length;
                        com.esotericsoftware.spine.Skin skin2 = skin;
                        int i31 = readInt20;
                        int readInt23 = dataInput.readInt(true);
                        com.esotericsoftware.spine.Animation.DeformTimeline deformTimeline = new com.esotericsoftware.spine.Animation.DeformTimeline(readInt23);
                        deformTimeline.b = readInt21;
                        deformTimeline.c = vertexAttachment;
                        int i32 = 0;
                        while (i32 < readInt23) {
                            int i33 = readInt21;
                            float readFloat3 = dataInput.readFloat();
                            int i34 = readInt22;
                            int readInt24 = dataInput.readInt(true);
                            if (readInt24 == 0) {
                                fArr = z3 ? new float[length] : vertices;
                                i = i27;
                            } else {
                                fArr = new float[length];
                                int readInt25 = dataInput.readInt(true);
                                int i35 = readInt24 + readInt25;
                                if (f7 == 1.0f) {
                                    i = i27;
                                    for (int i36 = readInt25; i36 < i35; i36++) {
                                        fArr[i36] = dataInput.readFloat();
                                    }
                                } else {
                                    i = i27;
                                    for (int i37 = readInt25; i37 < i35; i37++) {
                                        fArr[i37] = dataInput.readFloat() * f7;
                                    }
                                }
                                if (!z3) {
                                    for (int i38 = 0; i38 < length; i38++) {
                                        fArr[i38] = fArr[i38] + vertices[i38];
                                    }
                                }
                            }
                            deformTimeline.setFrame(i32, readFloat3, fArr);
                            if (i32 < readInt23 - 1) {
                                c(dataInput, i32, deformTimeline);
                            }
                            i32++;
                            readInt21 = i33;
                            readInt22 = i34;
                            i27 = i;
                        }
                        array.add(deformTimeline);
                        f5 = java.lang.Math.max(f5, deformTimeline.getFrames()[readInt23 - 1]);
                        i29++;
                        readInt19 = i30;
                        skin = skin2;
                        readInt20 = i31;
                        readInt21 = readInt21;
                        readInt22 = readInt22;
                        i27 = i27;
                    }
                    i28++;
                    z2 = true;
                }
                i27++;
                skeletonData3 = skeletonData;
                z2 = true;
            }
            int readInt26 = dataInput.readInt(z2);
            if (readInt26 > 0) {
                com.esotericsoftware.spine.Animation.DrawOrderTimeline drawOrderTimeline = new com.esotericsoftware.spine.Animation.DrawOrderTimeline(readInt26);
                skeletonData2 = skeletonData;
                int i39 = skeletonData2.c.size;
                for (int i40 = 0; i40 < readInt26; i40++) {
                    float readFloat4 = dataInput.readFloat();
                    int readInt27 = dataInput.readInt(true);
                    int[] iArr = new int[i39];
                    int i41 = i39 - 1;
                    for (int i42 = i41; i42 >= 0; i42--) {
                        iArr[i42] = -1;
                    }
                    int[] iArr2 = new int[i39 - readInt27];
                    int i43 = 0;
                    int i44 = 0;
                    int i45 = 0;
                    while (i43 < readInt27) {
                        int readInt28 = dataInput.readInt(true);
                        int i46 = i45;
                        while (i46 != readInt28) {
                            iArr2[i44] = i46;
                            i44++;
                            i46++;
                        }
                        iArr[i46 + dataInput.readInt(true)] = i46;
                        i43++;
                        i45 = i46 + 1;
                    }
                    while (true) {
                        int i47 = i45;
                        if (i47 >= i39) {
                            break;
                        }
                        i45 = i47 + 1;
                        iArr2[i44] = i47;
                        i44++;
                    }
                    while (i41 >= 0) {
                        if (iArr[i41] == -1) {
                            i44--;
                            iArr[i41] = iArr2[i44];
                        }
                        i41--;
                    }
                    drawOrderTimeline.setFrame(i40, readFloat4, iArr);
                }
                array.add(drawOrderTimeline);
                f5 = java.lang.Math.max(f5, drawOrderTimeline.getFrames()[readInt26 - 1]);
            } else {
                skeletonData2 = skeletonData;
            }
            int readInt29 = dataInput.readInt(true);
            if (readInt29 > 0) {
                com.esotericsoftware.spine.Animation.EventTimeline eventTimeline = new com.esotericsoftware.spine.Animation.EventTimeline(readInt29);
                for (int i48 = 0; i48 < readInt29; i48++) {
                    float readFloat5 = dataInput.readFloat();
                    com.esotericsoftware.spine.EventData eventData = skeletonData2.f.get(dataInput.readInt(true));
                    com.esotericsoftware.spine.Event event = new com.esotericsoftware.spine.Event(readFloat5, eventData);
                    event.b = dataInput.readInt(false);
                    event.c = dataInput.readFloat();
                    event.d = dataInput.readBoolean() ? dataInput.readString() : eventData.d;
                    eventTimeline.setFrame(i48, event);
                }
                array.add(eventTimeline);
                f5 = java.lang.Math.max(f5, eventTimeline.getFrames()[readInt29 - 1]);
            }
            array.shrink();
            skeletonData2.g.add(new com.esotericsoftware.spine.Animation(str, array, f5));
        } catch (java.io.IOException e2) {
            throw new com.badlogic.gdx.utils.SerializationException("Error reading skeleton file.", e2);
        }
    }

    public final com.esotericsoftware.spine.attachments.Attachment b(com.badlogic.gdx.utils.DataInput dataInput, com.esotericsoftware.spine.SkeletonData skeletonData, com.esotericsoftware.spine.Skin skin, int i, java.lang.String str, boolean z) throws java.io.IOException {
        int readInt;
        short[] sArr;
        float f;
        float f2;
        float f3;
        float f4 = this.b;
        java.lang.String readString = dataInput.readString();
        if (readString == null) {
            readString = str;
        }
        float f5 = 0.0f;
        switch (com.esotericsoftware.spine.SkeletonBinary.AnonymousClass2.a[com.esotericsoftware.spine.attachments.AttachmentType.values[dataInput.readByte()].ordinal()]) {
            case 1:
                java.lang.String readString2 = dataInput.readString();
                float readFloat = dataInput.readFloat();
                float readFloat2 = dataInput.readFloat();
                float readFloat3 = dataInput.readFloat();
                float readFloat4 = dataInput.readFloat();
                float readFloat5 = dataInput.readFloat();
                float readFloat6 = dataInput.readFloat();
                float readFloat7 = dataInput.readFloat();
                int readInt2 = dataInput.readInt();
                if (readString2 == null) {
                    readString2 = readString;
                }
                com.esotericsoftware.spine.attachments.RegionAttachment newRegionAttachment = this.a.newRegionAttachment(skin, readString, readString2);
                if (newRegionAttachment != null) {
                    newRegionAttachment.setPath(readString2);
                    newRegionAttachment.setX(readFloat2 * f4);
                    newRegionAttachment.setY(readFloat3 * f4);
                    newRegionAttachment.setScaleX(readFloat4);
                    newRegionAttachment.setScaleY(readFloat5);
                    newRegionAttachment.setRotation(readFloat);
                    newRegionAttachment.setWidth(readFloat6 * f4);
                    newRegionAttachment.setHeight(readFloat7 * f4);
                    com.badlogic.gdx.graphics.Color.rgba8888ToColor(newRegionAttachment.getColor(), readInt2);
                    newRegionAttachment.updateOffset();
                    break;
                }
                break;
            case 2:
                int readInt3 = dataInput.readInt(true);
                com.esotericsoftware.spine.SkeletonBinary.Vertices g = g(dataInput, readInt3);
                readInt = z ? dataInput.readInt() : 0;
                com.esotericsoftware.spine.attachments.BoundingBoxAttachment newBoundingBoxAttachment = this.a.newBoundingBoxAttachment(skin, readString);
                if (newBoundingBoxAttachment != null) {
                    newBoundingBoxAttachment.setWorldVerticesLength(readInt3 << 1);
                    newBoundingBoxAttachment.setVertices(g.b);
                    newBoundingBoxAttachment.setBones(g.a);
                    if (z) {
                        com.badlogic.gdx.graphics.Color.rgba8888ToColor(newBoundingBoxAttachment.getColor(), readInt);
                        break;
                    }
                }
                break;
            case 3:
                java.lang.String readString3 = dataInput.readString();
                int readInt4 = dataInput.readInt();
                int readInt5 = dataInput.readInt(true);
                int i2 = readInt5 << 1;
                float[] d2 = d(dataInput, i2, 1.0f);
                short[] e2 = e(dataInput);
                com.esotericsoftware.spine.SkeletonBinary.Vertices g2 = g(dataInput, readInt5);
                int readInt6 = dataInput.readInt(true);
                if (z) {
                    sArr = e(dataInput);
                    f2 = dataInput.readFloat();
                    f = dataInput.readFloat();
                } else {
                    sArr = null;
                    f = 0.0f;
                    f2 = 0.0f;
                }
                if (readString3 == null) {
                    readString3 = readString;
                }
                com.esotericsoftware.spine.attachments.MeshAttachment newMeshAttachment = this.a.newMeshAttachment(skin, readString, readString3);
                if (newMeshAttachment != null) {
                    newMeshAttachment.setPath(readString3);
                    com.badlogic.gdx.graphics.Color.rgba8888ToColor(newMeshAttachment.getColor(), readInt4);
                    newMeshAttachment.setBones(g2.a);
                    newMeshAttachment.setVertices(g2.b);
                    newMeshAttachment.setWorldVerticesLength(i2);
                    newMeshAttachment.setTriangles(e2);
                    newMeshAttachment.setRegionUVs(d2);
                    newMeshAttachment.updateUVs();
                    newMeshAttachment.setHullLength(readInt6 << 1);
                    if (z) {
                        newMeshAttachment.setEdges(sArr);
                        newMeshAttachment.setWidth(f2 * f4);
                        newMeshAttachment.setHeight(f * f4);
                        break;
                    }
                }
                break;
            case 4:
                java.lang.String readString4 = dataInput.readString();
                int readInt7 = dataInput.readInt();
                java.lang.String readString5 = dataInput.readString();
                java.lang.String readString6 = dataInput.readString();
                boolean readBoolean = dataInput.readBoolean();
                if (z) {
                    f5 = dataInput.readFloat();
                    f3 = dataInput.readFloat();
                } else {
                    f3 = 0.0f;
                }
                if (readString4 == null) {
                    readString4 = readString;
                }
                com.esotericsoftware.spine.attachments.MeshAttachment newMeshAttachment2 = this.a.newMeshAttachment(skin, readString, readString4);
                if (newMeshAttachment2 != null) {
                    newMeshAttachment2.setPath(readString4);
                    com.badlogic.gdx.graphics.Color.rgba8888ToColor(newMeshAttachment2.getColor(), readInt7);
                    newMeshAttachment2.setInheritDeform(readBoolean);
                    if (z) {
                        newMeshAttachment2.setWidth(f5 * f4);
                        newMeshAttachment2.setHeight(f3 * f4);
                    }
                    this.c.add(new com.esotericsoftware.spine.SkeletonJson.LinkedMesh(newMeshAttachment2, readString5, i, readString6));
                    break;
                }
                break;
            case 5:
                boolean readBoolean2 = dataInput.readBoolean();
                boolean readBoolean3 = dataInput.readBoolean();
                int readInt8 = dataInput.readInt(true);
                com.esotericsoftware.spine.SkeletonBinary.Vertices g3 = g(dataInput, readInt8);
                int i3 = readInt8 / 3;
                float[] fArr = new float[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    fArr[i4] = dataInput.readFloat() * f4;
                }
                readInt = z ? dataInput.readInt() : 0;
                com.esotericsoftware.spine.attachments.PathAttachment newPathAttachment = this.a.newPathAttachment(skin, readString);
                if (newPathAttachment != null) {
                    newPathAttachment.setClosed(readBoolean2);
                    newPathAttachment.setConstantSpeed(readBoolean3);
                    newPathAttachment.setWorldVerticesLength(readInt8 << 1);
                    newPathAttachment.setVertices(g3.b);
                    newPathAttachment.setBones(g3.a);
                    newPathAttachment.setLengths(fArr);
                    if (z) {
                        com.badlogic.gdx.graphics.Color.rgba8888ToColor(newPathAttachment.getColor(), readInt);
                        break;
                    }
                }
                break;
            case 6:
                float readFloat8 = dataInput.readFloat();
                float readFloat9 = dataInput.readFloat();
                float readFloat10 = dataInput.readFloat();
                readInt = z ? dataInput.readInt() : 0;
                com.esotericsoftware.spine.attachments.PointAttachment newPointAttachment = this.a.newPointAttachment(skin, readString);
                if (newPointAttachment != null) {
                    newPointAttachment.setX(readFloat9 * f4);
                    newPointAttachment.setY(readFloat10 * f4);
                    newPointAttachment.setRotation(readFloat8);
                    if (z) {
                        com.badlogic.gdx.graphics.Color.rgba8888ToColor(newPointAttachment.getColor(), readInt);
                        break;
                    }
                }
                break;
            case 7:
                int readInt9 = dataInput.readInt(true);
                int readInt10 = dataInput.readInt(true);
                com.esotericsoftware.spine.SkeletonBinary.Vertices g4 = g(dataInput, readInt10);
                readInt = z ? dataInput.readInt() : 0;
                com.esotericsoftware.spine.attachments.ClippingAttachment newClippingAttachment = this.a.newClippingAttachment(skin, readString);
                if (newClippingAttachment != null) {
                    newClippingAttachment.setEndSlot(skeletonData.c.get(readInt9));
                    newClippingAttachment.setWorldVerticesLength(readInt10 << 1);
                    newClippingAttachment.setVertices(g4.b);
                    newClippingAttachment.setBones(g4.a);
                    if (z) {
                        com.badlogic.gdx.graphics.Color.rgba8888ToColor(newClippingAttachment.getColor(), readInt);
                        break;
                    }
                }
                break;
        }
        return null;
    }

    public final void c(com.badlogic.gdx.utils.DataInput dataInput, int i, com.esotericsoftware.spine.Animation.CurveTimeline curveTimeline) throws java.io.IOException {
        byte readByte = dataInput.readByte();
        if (readByte == 1) {
            curveTimeline.setStepped(i);
        } else {
            if (readByte != 2) {
                return;
            }
            h(curveTimeline, i, dataInput.readFloat(), dataInput.readFloat(), dataInput.readFloat(), dataInput.readFloat());
        }
    }

    public final float[] d(com.badlogic.gdx.utils.DataInput dataInput, int i, float f) throws java.io.IOException {
        float[] fArr = new float[i];
        int i2 = 0;
        if (f == 1.0f) {
            while (i2 < i) {
                fArr[i2] = dataInput.readFloat();
                i2++;
            }
        } else {
            while (i2 < i) {
                fArr[i2] = dataInput.readFloat() * f;
                i2++;
            }
        }
        return fArr;
    }

    public final short[] e(com.badlogic.gdx.utils.DataInput dataInput) throws java.io.IOException {
        int readInt = dataInput.readInt(true);
        short[] sArr = new short[readInt];
        for (int i = 0; i < readInt; i++) {
            sArr[i] = dataInput.readShort();
        }
        return sArr;
    }

    public final com.esotericsoftware.spine.Skin f(com.badlogic.gdx.utils.DataInput dataInput, com.esotericsoftware.spine.SkeletonData skeletonData, java.lang.String str, boolean z) throws java.io.IOException {
        boolean z2 = true;
        int readInt = dataInput.readInt(true);
        if (readInt == 0) {
            return null;
        }
        com.esotericsoftware.spine.Skin skin = new com.esotericsoftware.spine.Skin(str);
        int i = 0;
        while (i < readInt) {
            int readInt2 = dataInput.readInt(z2);
            int readInt3 = dataInput.readInt(z2);
            for (int i2 = 0; i2 < readInt3; i2++) {
                java.lang.String readString = dataInput.readString();
                com.esotericsoftware.spine.attachments.Attachment b = b(dataInput, skeletonData, skin, readInt2, readString, z);
                if (b != null) {
                    skin.addAttachment(readInt2, readString, b);
                }
            }
            i++;
            z2 = true;
        }
        return skin;
    }

    public final com.esotericsoftware.spine.SkeletonBinary.Vertices g(com.badlogic.gdx.utils.DataInput dataInput, int i) throws java.io.IOException {
        int i2 = i << 1;
        com.esotericsoftware.spine.SkeletonBinary.Vertices vertices = new com.esotericsoftware.spine.SkeletonBinary.Vertices();
        if (!dataInput.readBoolean()) {
            vertices.b = d(dataInput, i2, this.b);
            return vertices;
        }
        int i3 = i2 * 3;
        com.badlogic.gdx.utils.FloatArray floatArray = new com.badlogic.gdx.utils.FloatArray(i3 * 3);
        com.badlogic.gdx.utils.IntArray intArray = new com.badlogic.gdx.utils.IntArray(i3);
        for (int i4 = 0; i4 < i; i4++) {
            int readInt = dataInput.readInt(true);
            intArray.add(readInt);
            for (int i5 = 0; i5 < readInt; i5++) {
                intArray.add(dataInput.readInt(true));
                floatArray.add(dataInput.readFloat() * this.b);
                floatArray.add(dataInput.readFloat() * this.b);
                floatArray.add(dataInput.readFloat());
            }
        }
        vertices.b = floatArray.toArray();
        vertices.a = intArray.toArray();
        return vertices;
    }

    public float getScale() {
        return this.b;
    }

    public void h(com.esotericsoftware.spine.Animation.CurveTimeline curveTimeline, int i, float f, float f2, float f3, float f4) {
        curveTimeline.setCurve(i, f, f2, f3, f4);
    }

    public com.esotericsoftware.spine.SkeletonData readSkeletonData(com.badlogic.gdx.files.FileHandle fileHandle) {
        if (fileHandle == null) {
            throw new java.lang.IllegalArgumentException("file cannot be null.");
        }
        float f = this.b;
        com.esotericsoftware.spine.SkeletonData skeletonData = new com.esotericsoftware.spine.SkeletonData();
        skeletonData.a = fileHandle.nameWithoutExtension();
        com.esotericsoftware.spine.SkeletonBinary.AnonymousClass1 anonymousClass1 = new com.esotericsoftware.spine.SkeletonBinary.AnonymousClass1(fileHandle.read(512));
        try {
            try {
                java.lang.String readString = anonymousClass1.readString();
                skeletonData.n = readString;
                if (readString.isEmpty()) {
                    skeletonData.n = null;
                }
                java.lang.String readString2 = anonymousClass1.readString();
                skeletonData.m = readString2;
                if (readString2.isEmpty()) {
                    skeletonData.m = null;
                }
                skeletonData.k = anonymousClass1.readFloat();
                skeletonData.l = anonymousClass1.readFloat();
                boolean readBoolean = anonymousClass1.readBoolean();
                if (readBoolean) {
                    skeletonData.o = anonymousClass1.readFloat();
                    java.lang.String readString3 = anonymousClass1.readString();
                    skeletonData.p = readString3;
                    if (readString3.isEmpty()) {
                        skeletonData.p = null;
                    }
                    java.lang.String readString4 = anonymousClass1.readString();
                    skeletonData.q = readString4;
                    if (readString4.isEmpty()) {
                        skeletonData.q = null;
                    }
                }
                int readInt = anonymousClass1.readInt(true);
                int i = 0;
                while (i < readInt) {
                    com.esotericsoftware.spine.BoneData boneData = new com.esotericsoftware.spine.BoneData(i, anonymousClass1.readString(), i == 0 ? null : skeletonData.b.get(anonymousClass1.readInt(true)));
                    boneData.g = anonymousClass1.readFloat();
                    boneData.e = anonymousClass1.readFloat() * f;
                    boneData.f = anonymousClass1.readFloat() * f;
                    boneData.h = anonymousClass1.readFloat();
                    boneData.i = anonymousClass1.readFloat();
                    boneData.j = anonymousClass1.readFloat();
                    boneData.k = anonymousClass1.readFloat();
                    boneData.d = anonymousClass1.readFloat() * f;
                    boneData.l = com.esotericsoftware.spine.BoneData.TransformMode.values[anonymousClass1.readInt(true)];
                    if (readBoolean) {
                        com.badlogic.gdx.graphics.Color.rgba8888ToColor(boneData.m, anonymousClass1.readInt());
                    }
                    skeletonData.b.add(boneData);
                    i++;
                }
                int readInt2 = anonymousClass1.readInt(true);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    com.esotericsoftware.spine.SlotData slotData = new com.esotericsoftware.spine.SlotData(i2, anonymousClass1.readString(), skeletonData.b.get(anonymousClass1.readInt(true)));
                    com.badlogic.gdx.graphics.Color.rgba8888ToColor(slotData.d, anonymousClass1.readInt());
                    int readInt3 = anonymousClass1.readInt();
                    if (readInt3 != -1) {
                        com.badlogic.gdx.graphics.Color color = new com.badlogic.gdx.graphics.Color();
                        slotData.e = color;
                        com.badlogic.gdx.graphics.Color.rgb888ToColor(color, readInt3);
                    }
                    slotData.f = anonymousClass1.readString();
                    slotData.g = com.esotericsoftware.spine.BlendMode.values[anonymousClass1.readInt(true)];
                    skeletonData.c.add(slotData);
                }
                int readInt4 = anonymousClass1.readInt(true);
                for (int i3 = 0; i3 < readInt4; i3++) {
                    com.esotericsoftware.spine.IkConstraintData ikConstraintData = new com.esotericsoftware.spine.IkConstraintData(anonymousClass1.readString());
                    ikConstraintData.b = anonymousClass1.readInt(true);
                    int readInt5 = anonymousClass1.readInt(true);
                    for (int i4 = 0; i4 < readInt5; i4++) {
                        ikConstraintData.c.add(skeletonData.b.get(anonymousClass1.readInt(true)));
                    }
                    ikConstraintData.d = skeletonData.b.get(anonymousClass1.readInt(true));
                    ikConstraintData.f = anonymousClass1.readFloat();
                    ikConstraintData.e = anonymousClass1.readByte();
                    skeletonData.h.add(ikConstraintData);
                }
                int readInt6 = anonymousClass1.readInt(true);
                for (int i5 = 0; i5 < readInt6; i5++) {
                    com.esotericsoftware.spine.TransformConstraintData transformConstraintData = new com.esotericsoftware.spine.TransformConstraintData(anonymousClass1.readString());
                    transformConstraintData.b = anonymousClass1.readInt(true);
                    int readInt7 = anonymousClass1.readInt(true);
                    for (int i6 = 0; i6 < readInt7; i6++) {
                        transformConstraintData.c.add(skeletonData.b.get(anonymousClass1.readInt(true)));
                    }
                    transformConstraintData.d = skeletonData.b.get(anonymousClass1.readInt(true));
                    transformConstraintData.p = anonymousClass1.readBoolean();
                    transformConstraintData.o = anonymousClass1.readBoolean();
                    transformConstraintData.i = anonymousClass1.readFloat();
                    transformConstraintData.j = anonymousClass1.readFloat() * f;
                    transformConstraintData.k = anonymousClass1.readFloat() * f;
                    transformConstraintData.l = anonymousClass1.readFloat();
                    transformConstraintData.m = anonymousClass1.readFloat();
                    transformConstraintData.n = anonymousClass1.readFloat();
                    transformConstraintData.e = anonymousClass1.readFloat();
                    transformConstraintData.f = anonymousClass1.readFloat();
                    transformConstraintData.g = anonymousClass1.readFloat();
                    transformConstraintData.h = anonymousClass1.readFloat();
                    skeletonData.i.add(transformConstraintData);
                }
                int readInt8 = anonymousClass1.readInt(true);
                for (int i7 = 0; i7 < readInt8; i7++) {
                    com.esotericsoftware.spine.PathConstraintData pathConstraintData = new com.esotericsoftware.spine.PathConstraintData(anonymousClass1.readString());
                    pathConstraintData.b = anonymousClass1.readInt(true);
                    int readInt9 = anonymousClass1.readInt(true);
                    for (int i8 = 0; i8 < readInt9; i8++) {
                        pathConstraintData.c.add(skeletonData.b.get(anonymousClass1.readInt(true)));
                    }
                    pathConstraintData.d = skeletonData.c.get(anonymousClass1.readInt(true));
                    pathConstraintData.e = com.esotericsoftware.spine.PathConstraintData.PositionMode.values[anonymousClass1.readInt(true)];
                    pathConstraintData.f = com.esotericsoftware.spine.PathConstraintData.SpacingMode.values[anonymousClass1.readInt(true)];
                    pathConstraintData.g = com.esotericsoftware.spine.PathConstraintData.RotateMode.values[anonymousClass1.readInt(true)];
                    pathConstraintData.h = anonymousClass1.readFloat();
                    float readFloat = anonymousClass1.readFloat();
                    pathConstraintData.i = readFloat;
                    if (pathConstraintData.e == com.esotericsoftware.spine.PathConstraintData.PositionMode.fixed) {
                        pathConstraintData.i = readFloat * f;
                    }
                    float readFloat2 = anonymousClass1.readFloat();
                    pathConstraintData.j = readFloat2;
                    com.esotericsoftware.spine.PathConstraintData.SpacingMode spacingMode = pathConstraintData.f;
                    if (spacingMode == com.esotericsoftware.spine.PathConstraintData.SpacingMode.length || spacingMode == com.esotericsoftware.spine.PathConstraintData.SpacingMode.fixed) {
                        pathConstraintData.j = readFloat2 * f;
                    }
                    pathConstraintData.k = anonymousClass1.readFloat();
                    pathConstraintData.l = anonymousClass1.readFloat();
                    skeletonData.j.add(pathConstraintData);
                }
                com.esotericsoftware.spine.Skin f2 = f(anonymousClass1, skeletonData, "default", readBoolean);
                if (f2 != null) {
                    skeletonData.e = f2;
                    skeletonData.d.add(f2);
                }
                int readInt10 = anonymousClass1.readInt(true);
                for (int i9 = 0; i9 < readInt10; i9++) {
                    skeletonData.d.add(f(anonymousClass1, skeletonData, anonymousClass1.readString(), readBoolean));
                }
                int i10 = this.c.size;
                for (int i11 = 0; i11 < i10; i11++) {
                    com.esotericsoftware.spine.SkeletonJson.LinkedMesh linkedMesh = this.c.get(i11);
                    java.lang.String str = linkedMesh.b;
                    com.esotericsoftware.spine.Skin defaultSkin = str == null ? skeletonData.getDefaultSkin() : skeletonData.findSkin(str);
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
                int readInt11 = anonymousClass1.readInt(true);
                for (int i12 = 0; i12 < readInt11; i12++) {
                    com.esotericsoftware.spine.EventData eventData = new com.esotericsoftware.spine.EventData(anonymousClass1.readString());
                    eventData.b = anonymousClass1.readInt(false);
                    eventData.c = anonymousClass1.readFloat();
                    eventData.d = anonymousClass1.readString();
                    eventData.e = anonymousClass1.readString();
                    skeletonData.f.add(eventData);
                }
                int readInt12 = anonymousClass1.readInt(true);
                for (int i13 = 0; i13 < readInt12; i13++) {
                    a(anonymousClass1, anonymousClass1.readString(), skeletonData);
                }
                skeletonData.b.shrink();
                skeletonData.c.shrink();
                skeletonData.d.shrink();
                skeletonData.f.shrink();
                skeletonData.g.shrink();
                skeletonData.h.shrink();
                return skeletonData;
            } catch (java.io.IOException e2) {
                throw new com.badlogic.gdx.utils.SerializationException("Error reading skeleton file.", e2);
            }
        } finally {
            try {
                anonymousClass1.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public void setScale(float f) {
        this.b = f;
    }
}
