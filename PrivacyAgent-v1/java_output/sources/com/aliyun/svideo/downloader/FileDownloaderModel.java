package com.aliyun.svideo.downloader;

/* loaded from: classes.dex */
public class FileDownloaderModel implements java.io.Serializable {
    public static final java.lang.String ANIMATION_EFFECTS_DIR;
    public static final java.lang.String ASPECT = "aspect";
    public static final java.lang.String BANNER = "banner";
    public static final java.lang.String CAPTION_DIR;
    public static final java.lang.String CAT = "cat";
    public static final java.lang.String CATEGORY = "category";
    public static final java.lang.String CNNAME = "cnname";
    public static final java.lang.String DESCRIPTION = "description";
    public static final java.lang.String DESCRIPTION_EN = "descriptionEn";
    public static final java.lang.String DOWNLOAD = "download";
    public static final java.lang.String DURATION = "duration";
    public static final java.lang.String EFFECTTYPE = "effectType";
    public static final int EFFECT_ANIMATION_FILTER = 9;
    public static final int EFFECT_CAPTION = 6;
    public static final int EFFECT_FACE_PASTER = 7;
    public static final int EFFECT_FILTER = 4;
    public static final int EFFECT_IMG = 8;
    public static final int EFFECT_MUSIC = 5;
    public static final int EFFECT_MV = 3;
    public static final int EFFECT_PASTER = 2;
    public static final int EFFECT_TEXT = 1;
    public static final int EFFECT_TRANSITION = 10;
    public static final java.lang.String FONTID = "fontid";
    public static final java.lang.String FONT_DIR;
    public static final java.lang.String ICON = "icon";
    public static final java.lang.String ID = "id";
    public static final java.lang.String ISNEW = "isnew";
    public static final java.lang.String ISUNZIP = "isunzip";
    public static final java.lang.String KEY = "key";
    public static final java.lang.String LEVEL = "level";
    public static final java.lang.String MD5 = "md5";
    public static final java.lang.String MV_DIR;
    public static final java.lang.String NAME = "name";
    public static final java.lang.String NAME_EN = "nameEn";
    public static final java.lang.String PATH = "path";
    public static final java.lang.String PREVIEW = "preview";
    public static final java.lang.String PREVIEWMP4 = "previewmp4";
    public static final java.lang.String PREVIEWPIC = "previewpic";
    public static final java.lang.String PRIORITY = "priority";
    public static final java.lang.String RESOURCE_CLOUD_DIR;
    public static final java.lang.String SORT = "sort";
    public static final java.lang.String STICKER_DIR;
    public static final java.lang.String SUBEFFECTYPT = "subqueffectype";
    public static final java.lang.String SUBICON = "subicon";
    public static final java.lang.String SUBID = "subid";
    public static final java.lang.String SUBNAME = "subname";
    public static final java.lang.String SUBPREVIEW = "subpreview";
    public static final java.lang.String SUBSORT = "subsort";
    public static final java.lang.String SUBTYPE = "subtype";
    public static final java.lang.String TAG = "tag";
    public static final java.lang.String TASK_ID = "task_id";
    public static final java.lang.String TRANSITION_DIR;
    public static final java.lang.String TYPE = "type";
    public static final java.lang.String URL = "url";
    private int aspect;
    private java.lang.String banner;
    private int cat;
    private int category;
    private java.lang.String cnname;
    private java.lang.String description;
    private java.lang.String descriptionEn;
    private java.lang.String download;
    private long duration;
    private int effectType;
    private android.content.ContentValues extFieldCv = new android.content.ContentValues();
    private int fontid;
    private java.lang.String icon;
    private int id;
    private int isnew;
    private int isunzip;
    private java.lang.String key;
    private int level;
    private java.lang.String md5;
    private java.lang.String name;
    private java.lang.String nameEn;
    private java.lang.String path;
    private java.lang.String preview;
    private java.lang.String previewmp4;
    private java.lang.String previewpic;
    private int priority;
    private int sort;
    private java.lang.String subicon;
    private int subid;
    private java.lang.String subname;
    private java.lang.String subpreview;
    private int subqueffectype;
    private int subsort;
    private int subtype;
    private java.lang.String tag;
    private int taskId;
    private int type;
    private java.lang.String url;

    static {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("svideo_res");
        java.lang.String str = java.io.File.separator;
        sb.append(str);
        sb.append(com.aliyun.svideo.editor.util.AlivcResUtil.HOST_CLOUD);
        java.lang.String sb2 = sb.toString();
        RESOURCE_CLOUD_DIR = sb2;
        MV_DIR = sb2 + str + com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_MV;
        ANIMATION_EFFECTS_DIR = sb2 + str + com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_ANIMATION_EFFECTS;
        TRANSITION_DIR = sb2 + str + com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_TRANSITION;
        FONT_DIR = sb2 + str + "font";
        STICKER_DIR = sb2 + str + com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_STICKER;
        CAPTION_DIR = sb2 + str + com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_CAPTION;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.aliyun.svideo.downloader.FileDownloaderModel) && ((com.aliyun.svideo.downloader.FileDownloaderModel) obj).getTaskId() == getTaskId();
    }

    public int getAspect() {
        return this.aspect;
    }

    public java.lang.String getBanner() {
        return this.banner;
    }

    public int getCat() {
        return this.cat;
    }

    public int getCategory() {
        return this.category;
    }

    public java.lang.String getCnname() {
        return this.cnname;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public java.lang.String getDescriptionEn() {
        return this.descriptionEn;
    }

    public java.lang.String getDownload() {
        return this.download;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getEffectType() {
        return this.effectType;
    }

    public java.lang.String getExtFieldValue(java.lang.String str) {
        return this.extFieldCv.getAsString(str);
    }

    public int getFontid() {
        return this.fontid;
    }

    public java.lang.String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public int getIsnew() {
        return this.isnew;
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public int getLevel() {
        return this.level;
    }

    public java.lang.String getMd5() {
        return this.md5;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public java.lang.String getNameEn() {
        return this.nameEn;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public java.lang.String getPreview() {
        return this.preview;
    }

    public java.lang.String getPreviewmp4() {
        return this.previewmp4;
    }

    public java.lang.String getPreviewpic() {
        return this.previewpic;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getSort() {
        return this.sort;
    }

    public java.lang.String getSubicon() {
        return this.subicon;
    }

    public int getSubid() {
        return this.subid;
    }

    public java.lang.String getSubname() {
        return this.subname;
    }

    public java.lang.String getSubpreview() {
        return this.subpreview;
    }

    public int getSubsort() {
        return this.subsort;
    }

    public int getSubtype() {
        return this.subtype;
    }

    public java.lang.String getTag() {
        return this.tag;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public int isunzip() {
        return this.isunzip;
    }

    public void parseExtField(android.database.Cursor cursor) {
        java.util.Map<java.lang.String, java.lang.String> dbExtFieldMap;
        if (cursor == null || cursor.isClosed() || (dbExtFieldMap = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbExtFieldMap()) == null || dbExtFieldMap.size() == 0) {
            return;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> it = dbExtFieldMap.entrySet().iterator();
        while (it.hasNext()) {
            java.lang.String key = it.next().getKey();
            if (key != null) {
                this.extFieldCv.put(key, cursor.getString(cursor.getColumnIndex(key)));
            }
        }
    }

    public void putExtField(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        this.extFieldCv.put(str, str2);
    }

    public void setAspect(int i) {
        this.aspect = i;
    }

    public void setBanner(java.lang.String str) {
        this.banner = str;
    }

    public void setCat(int i) {
        this.cat = i;
    }

    public void setCategory(int i) {
        this.category = i;
    }

    public void setCnname(java.lang.String str) {
        this.cnname = str;
    }

    public void setDescription(java.lang.String str) {
        this.description = str;
    }

    public void setDescriptionEn(java.lang.String str) {
        this.descriptionEn = str;
    }

    public void setDownload(java.lang.String str) {
        this.download = str;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setEffectType(int i) {
        this.effectType = i;
    }

    public void setFontid(int i) {
        this.fontid = i;
    }

    public void setIcon(java.lang.String str) {
        this.icon = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsnew(int i) {
        this.isnew = i;
    }

    public void setIsunzip(int i) {
        this.isunzip = i;
    }

    public void setKey(java.lang.String str) {
        this.key = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setMd5(java.lang.String str) {
        this.md5 = str;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public void setNameEn(java.lang.String str) {
        this.nameEn = str;
    }

    public void setPath(java.lang.String str) {
        this.path = str;
    }

    public void setPreview(java.lang.String str) {
        this.preview = str;
    }

    public void setPreviewmp4(java.lang.String str) {
        this.previewmp4 = str;
    }

    public void setPreviewpic(java.lang.String str) {
        this.previewpic = str;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setSort(int i) {
        this.sort = i;
    }

    public void setSubicon(java.lang.String str) {
        this.subicon = str;
    }

    public void setSubid(int i) {
        this.subid = i;
    }

    public void setSubname(java.lang.String str) {
        this.subname = str;
    }

    public void setSubpreview(java.lang.String str) {
        this.subpreview = str;
    }

    public void setSubsort(int i) {
        this.subsort = i;
    }

    public void setSubtype(int i) {
        this.subtype = i;
    }

    public void setTag(java.lang.String str) {
        this.tag = str;
    }

    public void setTaskId(int i) {
        this.taskId = i;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public android.content.ContentValues toContentValues() {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("task_id", java.lang.Integer.valueOf(this.taskId));
        contentValues.put("id", java.lang.Integer.valueOf(this.id));
        contentValues.put("name", this.name);
        contentValues.put(NAME_EN, this.nameEn);
        contentValues.put("url", this.url);
        contentValues.put("path", this.path);
        contentValues.put(ISUNZIP, java.lang.Integer.valueOf(this.isunzip));
        contentValues.put(EFFECTTYPE, java.lang.Integer.valueOf(this.effectType));
        contentValues.put("key", this.key);
        contentValues.put(LEVEL, java.lang.Integer.valueOf(this.level));
        contentValues.put("tag", this.tag);
        contentValues.put(CAT, java.lang.Integer.valueOf(this.cat));
        contentValues.put(PREVIEWPIC, this.previewpic);
        contentValues.put(PREVIEWMP4, this.previewmp4);
        contentValues.put("duration", java.lang.Long.valueOf(this.duration));
        contentValues.put(SORT, java.lang.Integer.valueOf(this.sort));
        contentValues.put(ASPECT, java.lang.Integer.valueOf(this.aspect));
        contentValues.put("download", this.download);
        contentValues.put("md5", this.md5);
        contentValues.put(CNNAME, this.cnname);
        contentValues.put("category", java.lang.Integer.valueOf(this.category));
        contentValues.put("banner", this.banner);
        contentValues.put("icon", this.icon);
        contentValues.put("description", this.description);
        contentValues.put(DESCRIPTION_EN, this.descriptionEn);
        contentValues.put(ISNEW, java.lang.Integer.valueOf(this.isnew));
        contentValues.put(PREVIEW, this.preview);
        contentValues.put(SUBID, java.lang.Integer.valueOf(this.subid));
        contentValues.put(FONTID, java.lang.Integer.valueOf(this.fontid));
        contentValues.put(SUBICON, this.subicon);
        contentValues.put(SUBNAME, this.subname);
        contentValues.put("priority", java.lang.Integer.valueOf(this.priority));
        contentValues.put(SUBPREVIEW, this.subpreview);
        contentValues.put(SUBSORT, java.lang.Integer.valueOf(this.subsort));
        contentValues.put(SUBTYPE, java.lang.Integer.valueOf(this.subtype));
        java.util.Map<java.lang.String, java.lang.String> dbExtFieldMap = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbExtFieldMap();
        if (dbExtFieldMap != null && dbExtFieldMap.size() != 0) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> it = dbExtFieldMap.entrySet().iterator();
            while (it.hasNext()) {
                java.lang.String key = it.next().getKey();
                if (key != null) {
                    contentValues.put(key, this.extFieldCv.getAsString(key));
                }
            }
        }
        return contentValues;
    }
}
