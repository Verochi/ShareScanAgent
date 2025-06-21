package androidx.exifinterface.media;

/* loaded from: classes.dex */
public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    static final java.nio.charset.Charset ASCII;
    static final short BYTE_ALIGN_II = 18761;
    static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] EXIF_POINTER_TAGS;
    static final androidx.exifinterface.media.ExifInterface.ExifTag[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final java.lang.String GPS_DIRECTION_MAGNETIC = "M";
    public static final java.lang.String GPS_DIRECTION_TRUE = "T";
    public static final java.lang.String GPS_DISTANCE_KILOMETERS = "K";
    public static final java.lang.String GPS_DISTANCE_MILES = "M";
    public static final java.lang.String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final java.lang.String GPS_MEASUREMENT_2D = "2";
    public static final java.lang.String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final java.lang.String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final java.lang.String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final java.lang.String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final java.lang.String GPS_SPEED_KNOTS = "N";
    public static final java.lang.String GPS_SPEED_MILES_PER_HOUR = "M";
    static final byte[] IDENTIFIER_EXIF_APP1;
    private static final byte[] IDENTIFIER_XMP_APP1;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] IFD_EXIF_TAGS;
    private static final int IFD_FORMAT_BYTE = 1;
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] IFD_GPS_TAGS;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final int IFD_OFFSET = 8;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] IFD_THUMBNAIL_TAGS;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] IFD_TIFF_TAGS;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    static final int IFD_TYPE_PREVIEW = 5;
    static final int IFD_TYPE_PRIMARY = 0;
    static final int IFD_TYPE_THUMBNAIL = 4;
    private static final int IMAGE_TYPE_ARW = 1;
    private static final int IMAGE_TYPE_CR2 = 2;
    private static final int IMAGE_TYPE_DNG = 3;
    private static final int IMAGE_TYPE_HEIF = 12;
    private static final int IMAGE_TYPE_JPEG = 4;
    private static final int IMAGE_TYPE_NEF = 5;
    private static final int IMAGE_TYPE_NRW = 6;
    private static final int IMAGE_TYPE_ORF = 7;
    private static final int IMAGE_TYPE_PEF = 8;
    private static final int IMAGE_TYPE_PNG = 13;
    private static final int IMAGE_TYPE_RAF = 9;
    private static final int IMAGE_TYPE_RW2 = 10;
    private static final int IMAGE_TYPE_SRW = 11;
    private static final int IMAGE_TYPE_UNKNOWN = 0;
    private static final int IMAGE_TYPE_WEBP = 14;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag JPEG_INTERCHANGE_FORMAT_TAG;
    public static final java.lang.String LATITUDE_NORTH = "N";
    public static final java.lang.String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final java.lang.String LONGITUDE_EAST = "E";
    public static final java.lang.String LONGITUDE_WEST = "W";
    static final byte MARKER = -1;
    static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    static final byte MARKER_EOI = -39;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] ORF_CAMERA_SETTINGS_TAGS;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] ORF_IMAGE_PROCESSING_TAGS;
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] ORF_MAKER_NOTE_TAGS;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final java.lang.String PEF_SIGNATURE = "PENTAX";
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    private static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final int RAF_JPEG_LENGTH_VALUE_SIZE = 4;
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final java.lang.String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    public static final java.lang.String TAG_APERTURE_VALUE = "ApertureValue";
    public static final java.lang.String TAG_ARTIST = "Artist";
    public static final java.lang.String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final java.lang.String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final java.lang.String TAG_BRIGHTNESS_VALUE = "BrightnessValue";

    @java.lang.Deprecated
    public static final java.lang.String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final java.lang.String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final java.lang.String TAG_CFA_PATTERN = "CFAPattern";
    public static final java.lang.String TAG_COLOR_SPACE = "ColorSpace";
    public static final java.lang.String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final java.lang.String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final java.lang.String TAG_COMPRESSION = "Compression";
    public static final java.lang.String TAG_CONTRAST = "Contrast";
    public static final java.lang.String TAG_COPYRIGHT = "Copyright";
    public static final java.lang.String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final java.lang.String TAG_DATETIME = "DateTime";
    public static final java.lang.String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final java.lang.String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final java.lang.String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final java.lang.String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final java.lang.String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final java.lang.String TAG_DNG_VERSION = "DNGVersion";
    private static final java.lang.String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final java.lang.String TAG_EXIF_VERSION = "ExifVersion";
    public static final java.lang.String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final java.lang.String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final java.lang.String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final java.lang.String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final java.lang.String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final java.lang.String TAG_FILE_SOURCE = "FileSource";
    public static final java.lang.String TAG_FLASH = "Flash";
    public static final java.lang.String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final java.lang.String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final java.lang.String TAG_FOCAL_LENGTH = "FocalLength";
    public static final java.lang.String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final java.lang.String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final java.lang.String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final java.lang.String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final java.lang.String TAG_F_NUMBER = "FNumber";
    public static final java.lang.String TAG_GAIN_CONTROL = "GainControl";
    public static final java.lang.String TAG_GAMMA = "Gamma";
    public static final java.lang.String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final java.lang.String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final java.lang.String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final java.lang.String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final java.lang.String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final java.lang.String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final java.lang.String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final java.lang.String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final java.lang.String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final java.lang.String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final java.lang.String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final java.lang.String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final java.lang.String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final java.lang.String TAG_GPS_DOP = "GPSDOP";
    public static final java.lang.String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final java.lang.String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final java.lang.String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final java.lang.String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final java.lang.String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final java.lang.String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final java.lang.String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final java.lang.String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final java.lang.String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final java.lang.String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final java.lang.String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final java.lang.String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final java.lang.String TAG_GPS_SPEED = "GPSSpeed";
    public static final java.lang.String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final java.lang.String TAG_GPS_STATUS = "GPSStatus";
    public static final java.lang.String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final java.lang.String TAG_GPS_TRACK = "GPSTrack";
    public static final java.lang.String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final java.lang.String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final java.lang.String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final java.lang.String TAG_IMAGE_LENGTH = "ImageLength";
    public static final java.lang.String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final java.lang.String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final java.lang.String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final java.lang.String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final java.lang.String TAG_ISO_SPEED = "ISOSpeed";
    public static final java.lang.String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final java.lang.String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";

    @java.lang.Deprecated
    public static final java.lang.String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final java.lang.String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final java.lang.String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final java.lang.String TAG_LENS_MAKE = "LensMake";
    public static final java.lang.String TAG_LENS_MODEL = "LensModel";
    public static final java.lang.String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final java.lang.String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final java.lang.String TAG_LIGHT_SOURCE = "LightSource";
    public static final java.lang.String TAG_MAKE = "Make";
    public static final java.lang.String TAG_MAKER_NOTE = "MakerNote";
    public static final java.lang.String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final java.lang.String TAG_METERING_MODE = "MeteringMode";
    public static final java.lang.String TAG_MODEL = "Model";
    public static final java.lang.String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final java.lang.String TAG_OECF = "OECF";
    public static final java.lang.String TAG_OFFSET_TIME = "OffsetTime";
    public static final java.lang.String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final java.lang.String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final java.lang.String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final java.lang.String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final java.lang.String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final java.lang.String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final java.lang.String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final java.lang.String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final java.lang.String TAG_ORIENTATION = "Orientation";
    public static final java.lang.String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final java.lang.String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final java.lang.String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final java.lang.String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final java.lang.String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final java.lang.String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final androidx.exifinterface.media.ExifInterface.ExifTag TAG_RAF_IMAGE_SIZE;
    public static final java.lang.String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final java.lang.String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final java.lang.String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final java.lang.String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final java.lang.String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final java.lang.String TAG_RW2_ISO = "ISO";
    public static final java.lang.String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final java.lang.String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final java.lang.String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final java.lang.String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final java.lang.String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final java.lang.String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final java.lang.String TAG_SATURATION = "Saturation";
    public static final java.lang.String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final java.lang.String TAG_SCENE_TYPE = "SceneType";
    public static final java.lang.String TAG_SENSING_METHOD = "SensingMethod";
    public static final java.lang.String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final java.lang.String TAG_SHARPNESS = "Sharpness";
    public static final java.lang.String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final java.lang.String TAG_SOFTWARE = "Software";
    public static final java.lang.String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final java.lang.String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final java.lang.String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final java.lang.String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final java.lang.String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final java.lang.String TAG_SUBFILE_TYPE = "SubfileType";
    public static final java.lang.String TAG_SUBJECT_AREA = "SubjectArea";
    public static final java.lang.String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final java.lang.String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final java.lang.String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final java.lang.String TAG_SUBSEC_TIME = "SubSecTime";
    public static final java.lang.String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final java.lang.String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final java.lang.String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final java.lang.String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final java.lang.String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final java.lang.String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final java.lang.String TAG_USER_COMMENT = "UserComment";
    public static final java.lang.String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final java.lang.String TAG_WHITE_POINT = "WhitePoint";
    public static final java.lang.String TAG_XMP = "Xmp";
    public static final java.lang.String TAG_X_RESOLUTION = "XResolution";
    public static final java.lang.String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final java.lang.String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final java.lang.String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final java.lang.String TAG_Y_RESOLUTION = "YResolution";
    private static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    private static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    private static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    private static final byte WEBP_VP8L_SIGNATURE = 47;

    @java.lang.Deprecated
    public static final int WHITEBALANCE_AUTO = 0;

    @java.lang.Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final java.util.HashMap<java.lang.Integer, java.lang.Integer> sExifPointerTagMap;
    private static final java.util.HashMap<java.lang.Integer, androidx.exifinterface.media.ExifInterface.ExifTag>[] sExifTagMapsForReading;
    private static final java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifTag>[] sExifTagMapsForWriting;
    private static java.text.SimpleDateFormat sFormatter;
    private static final java.util.regex.Pattern sGpsTimestampPattern;
    private static final java.util.regex.Pattern sNonZeroTimePattern;
    private static final java.util.HashSet<java.lang.String> sTagSetForCompatibility;
    private boolean mAreThumbnailStripsConsecutive;
    private android.content.res.AssetManager.AssetInputStream mAssetInputStream;
    private final java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute>[] mAttributes;
    private java.util.Set<java.lang.Integer> mAttributesOffsets;
    private java.nio.ByteOrder mExifByteOrder;
    private int mExifOffset;
    private java.lang.String mFilename;
    private boolean mHasThumbnail;
    private boolean mHasThumbnailStrips;
    private boolean mIsExifDataOnly;
    private boolean mIsSupportedFile;
    private int mMimeType;
    private boolean mModified;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private int mRw2JpgFromRawOffset;
    private java.io.FileDescriptor mSeekableFileDescriptor;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;
    private boolean mXmpIsFromSeparateMarker;
    private static final java.lang.String TAG = "ExifInterface";
    private static final boolean DEBUG = android.util.Log.isLoggable(TAG, 3);
    private static final java.util.List<java.lang.Integer> ROTATION_ORDER = java.util.Arrays.asList(1, 6, 3, 8);
    private static final java.util.List<java.lang.Integer> FLIPPED_ROTATION_ORDER = java.util.Arrays.asList(2, 7, 4, 5);
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    private static final byte MARKER_SOI = -40;
    static final byte[] JPEG_SIGNATURE = {-1, MARKER_SOI, -1};
    private static final byte[] HEIF_TYPE_FTYP = {102, 116, 121, 112};
    private static final byte[] HEIF_BRAND_MIF1 = {109, 105, 102, org.apache.tools.tar.TarConstants.LF_LINK};
    private static final byte[] HEIF_BRAND_HEIC = {104, 101, 105, 99};
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 89, 77, 80, 0};
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 89, 77, 80, 85, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 0, 73, 73};
    private static final byte[] PNG_SIGNATURE = {-119, 80, 78, 71, 13, 10, com.google.common.base.Ascii.SUB, 10};
    private static final byte[] PNG_CHUNK_TYPE_EXIF = {101, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 73, 102};
    private static final byte[] PNG_CHUNK_TYPE_IHDR = {73, 72, 68, 82};
    private static final byte[] PNG_CHUNK_TYPE_IEND = {73, 69, 78, 68};
    private static final byte[] WEBP_SIGNATURE_1 = {82, 73, 70, 70};
    private static final byte[] WEBP_SIGNATURE_2 = {87, 69, 66, 80};
    private static final byte[] WEBP_CHUNK_TYPE_EXIF = {69, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 73, 70};
    static final byte START_CODE = 42;
    private static final byte[] WEBP_VP8_SIGNATURE = {-99, 1, START_CODE};
    private static final byte[] WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(java.nio.charset.Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(java.nio.charset.Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(java.nio.charset.Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(java.nio.charset.Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(java.nio.charset.Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_XMP = "XMP ".getBytes(java.nio.charset.Charset.defaultCharset());
    static final java.lang.String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] EXIF_ASCII_PREFIX = {65, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 67, 73, 73, 0, 0, 0};

    /* renamed from: androidx.exifinterface.media.ExifInterface$1, reason: invalid class name */
    public class AnonymousClass1 extends android.media.MediaDataSource {
        long mPosition;
        final /* synthetic */ androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream val$in;

        public AnonymousClass1(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) {
            this.val$in = byteOrderedDataInputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
        }

        @Override // android.media.MediaDataSource
        public long getSize() throws java.io.IOException {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) throws java.io.IOException {
            if (i2 == 0) {
                return 0;
            }
            if (j < 0) {
                return -1;
            }
            try {
                long j2 = this.mPosition;
                if (j2 != j) {
                    if (j2 >= 0 && j >= j2 + this.val$in.available()) {
                        return -1;
                    }
                    this.val$in.seek(j);
                    this.mPosition = j;
                }
                if (i2 > this.val$in.available()) {
                    i2 = this.val$in.available();
                }
                int read = this.val$in.read(bArr, i, i2);
                if (read >= 0) {
                    this.mPosition += read;
                    return read;
                }
            } catch (java.io.IOException unused) {
            }
            this.mPosition = -1L;
            return -1;
        }
    }

    public static class ByteOrderedDataInputStream extends java.io.InputStream implements java.io.DataInput {
        private java.nio.ByteOrder mByteOrder;
        private java.io.DataInputStream mDataInputStream;
        final int mLength;
        int mPosition;
        private static final java.nio.ByteOrder LITTLE_ENDIAN = java.nio.ByteOrder.LITTLE_ENDIAN;
        private static final java.nio.ByteOrder BIG_ENDIAN = java.nio.ByteOrder.BIG_ENDIAN;

        public ByteOrderedDataInputStream(java.io.InputStream inputStream) throws java.io.IOException {
            this(inputStream, java.nio.ByteOrder.BIG_ENDIAN);
        }

        public ByteOrderedDataInputStream(java.io.InputStream inputStream, java.nio.ByteOrder byteOrder) throws java.io.IOException {
            this.mByteOrder = java.nio.ByteOrder.BIG_ENDIAN;
            java.io.DataInputStream dataInputStream = new java.io.DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            int available = dataInputStream.available();
            this.mLength = available;
            this.mPosition = 0;
            this.mDataInputStream.mark(available);
            this.mByteOrder = byteOrder;
        }

        public ByteOrderedDataInputStream(byte[] bArr) throws java.io.IOException {
            this(new java.io.ByteArrayInputStream(bArr));
        }

        @Override // java.io.InputStream
        public int available() throws java.io.IOException {
            return this.mDataInputStream.available();
        }

        public int getLength() {
            return this.mLength;
        }

        public int peek() {
            return this.mPosition;
        }

        @Override // java.io.InputStream
        public int read() throws java.io.IOException {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
            int read = this.mDataInputStream.read(bArr, i, i2);
            this.mPosition += read;
            return read;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws java.io.IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws java.io.IOException {
            int i = this.mPosition + 1;
            this.mPosition = i;
            if (i > this.mLength) {
                throw new java.io.EOFException();
            }
            int read = this.mDataInputStream.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new java.io.EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws java.io.IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws java.io.IOException {
            return java.lang.Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws java.io.IOException {
            return java.lang.Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws java.io.IOException {
            int length = this.mPosition + bArr.length;
            this.mPosition = length;
            if (length > this.mLength) {
                throw new java.io.EOFException();
            }
            if (this.mDataInputStream.read(bArr, 0, bArr.length) != bArr.length) {
                throw new java.io.IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws java.io.IOException {
            int i3 = this.mPosition + i2;
            this.mPosition = i3;
            if (i3 > this.mLength) {
                throw new java.io.EOFException();
            }
            if (this.mDataInputStream.read(bArr, i, i2) != i2) {
                throw new java.io.IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() throws java.io.IOException {
            int i = this.mPosition + 4;
            this.mPosition = i;
            if (i > this.mLength) {
                throw new java.io.EOFException();
            }
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            int read3 = this.mDataInputStream.read();
            int read4 = this.mDataInputStream.read();
            if ((read | read2 | read3 | read4) < 0) {
                throw new java.io.EOFException();
            }
            java.nio.ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == LITTLE_ENDIAN) {
                return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == BIG_ENDIAN) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            }
            throw new java.io.IOException("Invalid byte order: " + this.mByteOrder);
        }

        @Override // java.io.DataInput
        public java.lang.String readLine() throws java.io.IOException {
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws java.io.IOException {
            int i = this.mPosition + 8;
            this.mPosition = i;
            if (i > this.mLength) {
                throw new java.io.EOFException();
            }
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            int read3 = this.mDataInputStream.read();
            int read4 = this.mDataInputStream.read();
            int read5 = this.mDataInputStream.read();
            int read6 = this.mDataInputStream.read();
            int read7 = this.mDataInputStream.read();
            int read8 = this.mDataInputStream.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                throw new java.io.EOFException();
            }
            java.nio.ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == LITTLE_ENDIAN) {
                return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == BIG_ENDIAN) {
                return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
            }
            throw new java.io.IOException("Invalid byte order: " + this.mByteOrder);
        }

        @Override // java.io.DataInput
        public short readShort() throws java.io.IOException {
            int i = this.mPosition + 2;
            this.mPosition = i;
            if (i > this.mLength) {
                throw new java.io.EOFException();
            }
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            if ((read | read2) < 0) {
                throw new java.io.EOFException();
            }
            java.nio.ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == LITTLE_ENDIAN) {
                return (short) ((read2 << 8) + read);
            }
            if (byteOrder == BIG_ENDIAN) {
                return (short) ((read << 8) + read2);
            }
            throw new java.io.IOException("Invalid byte order: " + this.mByteOrder);
        }

        @Override // java.io.DataInput
        public java.lang.String readUTF() throws java.io.IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws java.io.IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        public long readUnsignedInt() throws java.io.IOException {
            return readInt() & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws java.io.IOException {
            int i = this.mPosition + 2;
            this.mPosition = i;
            if (i > this.mLength) {
                throw new java.io.EOFException();
            }
            int read = this.mDataInputStream.read();
            int read2 = this.mDataInputStream.read();
            if ((read | read2) < 0) {
                throw new java.io.EOFException();
            }
            java.nio.ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == LITTLE_ENDIAN) {
                return (read2 << 8) + read;
            }
            if (byteOrder == BIG_ENDIAN) {
                return (read << 8) + read2;
            }
            throw new java.io.IOException("Invalid byte order: " + this.mByteOrder);
        }

        public void seek(long j) throws java.io.IOException {
            int i = this.mPosition;
            if (i > j) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
                this.mDataInputStream.mark(this.mLength);
            } else {
                j -= i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new java.io.IOException("Couldn't seek up to the byteCount");
            }
        }

        public void setByteOrder(java.nio.ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) throws java.io.IOException {
            int min = java.lang.Math.min(i, this.mLength - this.mPosition);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.mDataInputStream.skipBytes(min - i2);
            }
            this.mPosition += i2;
            return i2;
        }
    }

    public static class ByteOrderedDataOutputStream extends java.io.FilterOutputStream {
        private java.nio.ByteOrder mByteOrder;
        final java.io.OutputStream mOutputStream;

        public ByteOrderedDataOutputStream(java.io.OutputStream outputStream, java.nio.ByteOrder byteOrder) {
            super(outputStream);
            this.mOutputStream = outputStream;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(java.nio.ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws java.io.IOException {
            this.mOutputStream.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
            this.mOutputStream.write(bArr, i, i2);
        }

        public void writeByte(int i) throws java.io.IOException {
            this.mOutputStream.write(i);
        }

        public void writeInt(int i) throws java.io.IOException {
            java.nio.ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == java.nio.ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((i >>> 0) & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                this.mOutputStream.write((i >>> 24) & 255);
                return;
            }
            if (byteOrder == java.nio.ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((i >>> 24) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                this.mOutputStream.write((i >>> 0) & 255);
            }
        }

        public void writeShort(short s2) throws java.io.IOException {
            java.nio.ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == java.nio.ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((s2 >>> 0) & 255);
                this.mOutputStream.write((s2 >>> 8) & 255);
            } else if (byteOrder == java.nio.ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((s2 >>> 8) & 255);
                this.mOutputStream.write((s2 >>> 0) & 255);
            }
        }

        public void writeUnsignedInt(long j) throws java.io.IOException {
            writeInt((int) j);
        }

        public void writeUnsignedShort(int i) throws java.io.IOException {
            writeShort((short) i);
        }
    }

    public static class ExifAttribute {
        public static final long BYTES_OFFSET_UNKNOWN = -1;
        public final byte[] bytes;
        public final long bytesOffset;
        public final int format;
        public final int numberOfComponents;

        public ExifAttribute(int i, int i2, long j, byte[] bArr) {
            this.format = i;
            this.numberOfComponents = i2;
            this.bytesOffset = j;
            this.bytes = bArr;
        }

        public ExifAttribute(int i, int i2, byte[] bArr) {
            this(i, i2, -1L, bArr);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createByte(java.lang.String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new androidx.exifinterface.media.ExifInterface.ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(androidx.exifinterface.media.ExifInterface.ASCII);
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(1, bytes.length, bytes);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createDouble(double d, java.nio.ByteOrder byteOrder) {
            return createDouble(new double[]{d}, byteOrder);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createDouble(double[] dArr, java.nio.ByteOrder byteOrder) {
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(new byte[androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length]);
            wrap.order(byteOrder);
            for (double d : dArr) {
                wrap.putDouble(d);
            }
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(12, dArr.length, wrap.array());
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createSLong(int i, java.nio.ByteOrder byteOrder) {
            return createSLong(new int[]{i}, byteOrder);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createSLong(int[] iArr, java.nio.ByteOrder byteOrder) {
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(new byte[androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putInt(i);
            }
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(9, iArr.length, wrap.array());
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createSRational(androidx.exifinterface.media.ExifInterface.Rational rational, java.nio.ByteOrder byteOrder) {
            return createSRational(new androidx.exifinterface.media.ExifInterface.Rational[]{rational}, byteOrder);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createSRational(androidx.exifinterface.media.ExifInterface.Rational[] rationalArr, java.nio.ByteOrder byteOrder) {
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(new byte[androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * rationalArr.length]);
            wrap.order(byteOrder);
            for (androidx.exifinterface.media.ExifInterface.Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createString(java.lang.String str) {
            byte[] bytes = (str + (char) 0).getBytes(androidx.exifinterface.media.ExifInterface.ASCII);
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(2, bytes.length, bytes);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createULong(long j, java.nio.ByteOrder byteOrder) {
            return createULong(new long[]{j}, byteOrder);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createULong(long[] jArr, java.nio.ByteOrder byteOrder) {
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(new byte[androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(4, jArr.length, wrap.array());
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createURational(androidx.exifinterface.media.ExifInterface.Rational rational, java.nio.ByteOrder byteOrder) {
            return createURational(new androidx.exifinterface.media.ExifInterface.Rational[]{rational}, byteOrder);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createURational(androidx.exifinterface.media.ExifInterface.Rational[] rationalArr, java.nio.ByteOrder byteOrder) {
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(new byte[androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length]);
            wrap.order(byteOrder);
            for (androidx.exifinterface.media.ExifInterface.Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createUShort(int i, java.nio.ByteOrder byteOrder) {
            return createUShort(new int[]{i}, byteOrder);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createUShort(int[] iArr, java.nio.ByteOrder byteOrder) {
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(new byte[androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(3, iArr.length, wrap.array());
        }

        public double getDoubleValue(java.nio.ByteOrder byteOrder) {
            java.lang.Object value = getValue(byteOrder);
            if (value == null) {
                throw new java.lang.NumberFormatException("NULL can't be converted to a double value");
            }
            if (value instanceof java.lang.String) {
                return java.lang.Double.parseDouble((java.lang.String) value);
            }
            if (value instanceof long[]) {
                if (((long[]) value).length == 1) {
                    return r5[0];
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            if (value instanceof int[]) {
                if (((int[]) value).length == 1) {
                    return r5[0];
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            if (!(value instanceof androidx.exifinterface.media.ExifInterface.Rational[])) {
                throw new java.lang.NumberFormatException("Couldn't find a double value");
            }
            androidx.exifinterface.media.ExifInterface.Rational[] rationalArr = (androidx.exifinterface.media.ExifInterface.Rational[]) value;
            if (rationalArr.length == 1) {
                return rationalArr[0].calculate();
            }
            throw new java.lang.NumberFormatException("There are more than one component");
        }

        public int getIntValue(java.nio.ByteOrder byteOrder) {
            java.lang.Object value = getValue(byteOrder);
            if (value == null) {
                throw new java.lang.NumberFormatException("NULL can't be converted to a integer value");
            }
            if (value instanceof java.lang.String) {
                return java.lang.Integer.parseInt((java.lang.String) value);
            }
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            if (!(value instanceof int[])) {
                throw new java.lang.NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) value;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new java.lang.NumberFormatException("There are more than one component");
        }

        public java.lang.String getStringValue(java.nio.ByteOrder byteOrder) {
            java.lang.Object value = getValue(byteOrder);
            if (value == null) {
                return null;
            }
            if (value instanceof java.lang.String) {
                return (java.lang.String) value;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i = 0;
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(value instanceof androidx.exifinterface.media.ExifInterface.Rational[])) {
                return null;
            }
            androidx.exifinterface.media.ExifInterface.Rational[] rationalArr = (androidx.exifinterface.media.ExifInterface.Rational[]) value;
            while (i < rationalArr.length) {
                sb.append(rationalArr[i].numerator);
                sb.append('/');
                sb.append(rationalArr[i].denominator);
                i++;
                if (i != rationalArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        public java.lang.Object getValue(java.nio.ByteOrder byteOrder) {
            androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream;
            byte b;
            byte b2;
            byte[] bArr;
            androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
            try {
                byteOrderedDataInputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(this.bytes);
                try {
                    byteOrderedDataInputStream.setByteOrder(byteOrder);
                    int i = 0;
                    boolean z = true;
                    switch (this.format) {
                        case 1:
                        case 6:
                            byte[] bArr2 = this.bytes;
                            if (bArr2.length != 1 || (b = bArr2[0]) < 0 || b > 1) {
                                java.lang.String str = new java.lang.String(bArr2, androidx.exifinterface.media.ExifInterface.ASCII);
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (java.io.IOException unused) {
                                }
                                return str;
                            }
                            java.lang.String str2 = new java.lang.String(new char[]{(char) (b + org.apache.tools.tar.TarConstants.LF_NORMAL)});
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (java.io.IOException unused2) {
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (this.numberOfComponents >= androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX.length) {
                                int i2 = 0;
                                while (true) {
                                    bArr = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX;
                                    if (i2 < bArr.length) {
                                        if (this.bytes[i2] != bArr[i2]) {
                                            z = false;
                                        } else {
                                            i2++;
                                        }
                                    }
                                }
                                if (z) {
                                    i = bArr.length;
                                }
                            }
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            while (i < this.numberOfComponents && (b2 = this.bytes[i]) != 0) {
                                if (b2 >= 32) {
                                    sb.append((char) b2);
                                } else {
                                    sb.append('?');
                                }
                                i++;
                            }
                            java.lang.String sb2 = sb.toString();
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (java.io.IOException unused3) {
                            }
                            return sb2;
                        case 3:
                            int[] iArr = new int[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                iArr[i] = byteOrderedDataInputStream.readUnsignedShort();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (java.io.IOException unused4) {
                            }
                            return iArr;
                        case 4:
                            long[] jArr = new long[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                jArr[i] = byteOrderedDataInputStream.readUnsignedInt();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (java.io.IOException unused5) {
                            }
                            return jArr;
                        case 5:
                            androidx.exifinterface.media.ExifInterface.Rational[] rationalArr = new androidx.exifinterface.media.ExifInterface.Rational[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                rationalArr[i] = new androidx.exifinterface.media.ExifInterface.Rational(byteOrderedDataInputStream.readUnsignedInt(), byteOrderedDataInputStream.readUnsignedInt());
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (java.io.IOException unused6) {
                            }
                            return rationalArr;
                        case 8:
                            int[] iArr2 = new int[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                iArr2[i] = byteOrderedDataInputStream.readShort();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (java.io.IOException unused7) {
                            }
                            return iArr2;
                        case 9:
                            int[] iArr3 = new int[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                iArr3[i] = byteOrderedDataInputStream.readInt();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (java.io.IOException unused8) {
                            }
                            return iArr3;
                        case 10:
                            androidx.exifinterface.media.ExifInterface.Rational[] rationalArr2 = new androidx.exifinterface.media.ExifInterface.Rational[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                rationalArr2[i] = new androidx.exifinterface.media.ExifInterface.Rational(byteOrderedDataInputStream.readInt(), byteOrderedDataInputStream.readInt());
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (java.io.IOException unused9) {
                            }
                            return rationalArr2;
                        case 11:
                            double[] dArr = new double[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                dArr[i] = byteOrderedDataInputStream.readFloat();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (java.io.IOException unused10) {
                            }
                            return dArr;
                        case 12:
                            double[] dArr2 = new double[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                dArr2[i] = byteOrderedDataInputStream.readDouble();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (java.io.IOException unused11) {
                            }
                            return dArr2;
                        default:
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (java.io.IOException unused12) {
                            }
                            return null;
                    }
                } catch (java.io.IOException unused13) {
                    if (byteOrderedDataInputStream != null) {
                        try {
                            byteOrderedDataInputStream.close();
                        } catch (java.io.IOException unused14) {
                        }
                    }
                    return null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    byteOrderedDataInputStream2 = byteOrderedDataInputStream;
                    if (byteOrderedDataInputStream2 != null) {
                        try {
                            byteOrderedDataInputStream2.close();
                        } catch (java.io.IOException unused15) {
                        }
                    }
                    throw th;
                }
            } catch (java.io.IOException unused16) {
                byteOrderedDataInputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }

        public int size() {
            return androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
        }

        public java.lang.String toString() {
            return "(" + androidx.exifinterface.media.ExifInterface.IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public @interface ExifStreamType {
    }

    public static class ExifTag {
        public final java.lang.String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        public ExifTag(java.lang.String str, int i, int i2) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = -1;
        }

        public ExifTag(java.lang.String str, int i, int i2, int i3) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = i3;
        }

        public boolean isFormatCompatible(int i) {
            int i2;
            int i3 = this.primaryFormat;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.secondaryFormat) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((i3 == 9 || i2 == 9) && i == 8) {
                return true;
            }
            return (i3 == 12 || i2 == 12) && i == 11;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public @interface IfdType {
    }

    public static class Rational {
        public final long denominator;
        public final long numerator;

        public Rational(double d) {
            this((long) (d * 10000.0d), 10000L);
        }

        public Rational(long j, long j2) {
            if (j2 == 0) {
                this.numerator = 0L;
                this.denominator = 1L;
            } else {
                this.numerator = j;
                this.denominator = j2;
            }
        }

        public double calculate() {
            return this.numerator / this.denominator;
        }

        public java.lang.String toString() {
            return this.numerator + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + this.denominator;
        }
    }

    static {
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr = {new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_NEW_SUBFILE_TYPE, com.getui.gtc.extension.distribution.gbd.d.g.aI, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUBFILE_TYPE, 255, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_IMAGE_LENGTH, 257, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_COMPRESSION, 259, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_MAKE, 271, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_MODEL, 272, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ORIENTATION, 274, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ROWS_PER_STRIP, com.anythink.expressad.foundation.g.a.aS, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_STRIP_BYTE_COUNTS, com.anythink.expressad.foundation.g.a.aT, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_X_RESOLUTION, 282, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_Y_RESOLUTION, 283, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_RESOLUTION_UNIT, com.anythink.expressad.foundation.g.a.aP, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SOFTWARE, com.umeng.ccg.c.f452s, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_DATETIME, 306, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ARTIST, 315, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_WHITE_POINT, 318, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, com.badlogic.gdx.graphics.GL20.GL_EQUAL, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_COPYRIGHT, 33432, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_INFO_IFD_POINTER, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER0, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_RW2_ISO, 23, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_XMP, 700, 1)};
        IFD_TIFF_TAGS = exifTagArr;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr2 = {new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_EXPOSURE_TIME, 33434, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_F_NUMBER, 33437, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SPECTRAL_SENSITIVITY, com.badlogic.gdx.graphics.GL30.GL_MAX_DRAW_BUFFERS, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER2, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_OECF, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER3, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SENSITIVITY_TYPE, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER11, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_STANDARD_OUTPUT_SENSITIVITY, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER12, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_RECOMMENDED_EXPOSURE_INDEX, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER13, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ISO_SPEED, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER14, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ISO_SPEED_LATITUDE_YYY, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER15, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_EXIF_VERSION, 36864, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_OFFSET_TIME, 36880, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_APERTURE_VALUE, 37378, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_METERING_MODE, 37383, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_LIGHT_SOURCE, 37384, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_FLASH, 37385, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_FOCAL_LENGTH, 37386, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUBJECT_AREA, 37396, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_MAKER_NOTE, 37500, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_USER_COMMENT, 37510, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUBSEC_TIME, 37520, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_FLASHPIX_VERSION, org.apache.tools.zip.UnixStat.LINK_FLAG, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_COLOR_SPACE, 40961, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_FLASH_ENERGY, 41483, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SENSING_METHOD, 41495, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_FILE_SOURCE, 41728, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SCENE_TYPE, 41729, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_CFA_PATTERN, 41730, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_WHITE_BALANCE, 41987, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GAIN_CONTROL, 41991, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_CONTRAST, 41992, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SATURATION, 41993, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SHARPNESS, 41994, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("CameraOwnerName", 42032, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_BODY_SERIAL_NUMBER, 42033, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_LENS_SPECIFICATION, 42034, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_LENS_MAKE, 42035, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_LENS_MODEL, 42036, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GAMMA, 42240, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_DNG_VERSION, 50706, 1), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_EXIF_TAGS = exifTagArr2;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr3 = {new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_VERSION_ID, 0, 1), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_LATITUDE_REF, 1, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_LATITUDE, 2, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_LONGITUDE, 4, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_ALTITUDE, 6, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_TIMESTAMP, 7, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_SATELLITES, 8, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_STATUS, 9, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_DOP, 11, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_SPEED_REF, 12, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_SPEED, 13, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_TRACK_REF, 14, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_TRACK, 15, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_DATESTAMP, 29, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
        IFD_GPS_TAGS = exifTagArr3;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr4 = {new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifTagArr4;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr5 = {new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_NEW_SUBFILE_TYPE, com.getui.gtc.extension.distribution.gbd.d.g.aI, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUBFILE_TYPE, 255, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_COMPRESSION, 259, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_MAKE, 271, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_MODEL, 272, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_THUMBNAIL_ORIENTATION, 274, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ROWS_PER_STRIP, com.anythink.expressad.foundation.g.a.aS, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_STRIP_BYTE_COUNTS, com.anythink.expressad.foundation.g.a.aT, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_X_RESOLUTION, 282, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_Y_RESOLUTION, 283, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_RESOLUTION_UNIT, com.anythink.expressad.foundation.g.a.aP, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SOFTWARE, com.umeng.ccg.c.f452s, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_DATETIME, 306, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ARTIST, 315, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_WHITE_POINT, 318, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, com.badlogic.gdx.graphics.GL20.GL_EQUAL, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_COPYRIGHT, 33432, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_INFO_IFD_POINTER, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER0, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_DNG_VERSION, 50706, 1), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_THUMBNAIL_TAGS = exifTagArr5;
        TAG_RAF_IMAGE_SIZE = new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_STRIP_OFFSETS, 273, 3);
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr6 = {new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
        ORF_MAKER_NOTE_TAGS = exifTagArr6;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr7 = {new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
        ORF_CAMERA_SETTINGS_TAGS = exifTagArr7;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr8 = {new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
        ORF_IMAGE_PROCESSING_TAGS = exifTagArr8;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr9 = {new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_COLOR_SPACE, 55, 3)};
        PEF_TAGS = exifTagArr9;
        androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr10 = {exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, exifTagArr6, exifTagArr7, exifTagArr8, exifTagArr9};
        EXIF_TAGS = exifTagArr10;
        EXIF_POINTER_TAGS = new androidx.exifinterface.media.ExifInterface.ExifTag[]{new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_INFO_IFD_POINTER, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER0, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
        JPEG_INTERCHANGE_FORMAT_TAG = new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4);
        JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, com.badlogic.gdx.graphics.GL20.GL_EQUAL, 4);
        sExifTagMapsForReading = new java.util.HashMap[exifTagArr10.length];
        sExifTagMapsForWriting = new java.util.HashMap[exifTagArr10.length];
        sTagSetForCompatibility = new java.util.HashSet<>(java.util.Arrays.asList(TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP));
        sExifPointerTagMap = new java.util.HashMap<>();
        java.nio.charset.Charset forName = java.nio.charset.Charset.forName("US-ASCII");
        ASCII = forName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(forName);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        sFormatter = simpleDateFormat;
        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr11 = EXIF_TAGS;
            if (i >= exifTagArr11.length) {
                java.util.HashMap<java.lang.Integer, java.lang.Integer> hashMap = sExifPointerTagMap;
                androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr12 = EXIF_POINTER_TAGS;
                hashMap.put(java.lang.Integer.valueOf(exifTagArr12[0].number), 5);
                hashMap.put(java.lang.Integer.valueOf(exifTagArr12[1].number), 1);
                hashMap.put(java.lang.Integer.valueOf(exifTagArr12[2].number), 2);
                hashMap.put(java.lang.Integer.valueOf(exifTagArr12[3].number), 3);
                hashMap.put(java.lang.Integer.valueOf(exifTagArr12[4].number), 7);
                hashMap.put(java.lang.Integer.valueOf(exifTagArr12[5].number), 8);
                sNonZeroTimePattern = java.util.regex.Pattern.compile(".*[1-9].*");
                sGpsTimestampPattern = java.util.regex.Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            sExifTagMapsForReading[i] = new java.util.HashMap<>();
            sExifTagMapsForWriting[i] = new java.util.HashMap<>();
            for (androidx.exifinterface.media.ExifInterface.ExifTag exifTag : exifTagArr11[i]) {
                sExifTagMapsForReading[i].put(java.lang.Integer.valueOf(exifTag.number), exifTag);
                sExifTagMapsForWriting[i].put(exifTag.name, exifTag);
            }
            i++;
        }
    }

    public ExifInterface(@androidx.annotation.NonNull java.io.File file) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new java.util.HashMap[exifTagArr.length];
        this.mAttributesOffsets = new java.util.HashSet(exifTagArr.length);
        this.mExifByteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        if (file == null) {
            throw new java.lang.NullPointerException("file cannot be null");
        }
        initForFilename(file.getAbsolutePath());
    }

    public ExifInterface(@androidx.annotation.NonNull java.io.FileDescriptor fileDescriptor) throws java.io.IOException {
        boolean z;
        java.io.FileInputStream fileInputStream;
        java.lang.Throwable th;
        androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new java.util.HashMap[exifTagArr.length];
        this.mAttributesOffsets = new java.util.HashSet(exifTagArr.length);
        this.mExifByteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        if (fileDescriptor == null) {
            throw new java.lang.NullPointerException("fileDescriptor cannot be null");
        }
        this.mAssetInputStream = null;
        this.mFilename = null;
        if (isSeekableFD(fileDescriptor)) {
            this.mSeekableFileDescriptor = fileDescriptor;
            try {
                fileDescriptor = android.system.Os.dup(fileDescriptor);
                z = true;
            } catch (java.lang.Exception e) {
                throw new java.io.IOException("Failed to duplicate file descriptor", e);
            }
        } else {
            this.mSeekableFileDescriptor = null;
            z = false;
        }
        try {
            fileInputStream = new java.io.FileInputStream(fileDescriptor);
            try {
                loadAttributes(fileInputStream);
                closeQuietly(fileInputStream);
                if (z) {
                    closeFileDescriptor(fileDescriptor);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                closeQuietly(fileInputStream);
                if (z) {
                    closeFileDescriptor(fileDescriptor);
                }
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public ExifInterface(@androidx.annotation.NonNull java.io.InputStream inputStream) throws java.io.IOException {
        this(inputStream, false);
    }

    public ExifInterface(@androidx.annotation.NonNull java.io.InputStream inputStream, int i) throws java.io.IOException {
        this(inputStream, i == 1);
    }

    private ExifInterface(@androidx.annotation.NonNull java.io.InputStream inputStream, boolean z) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new java.util.HashMap[exifTagArr.length];
        this.mAttributesOffsets = new java.util.HashSet(exifTagArr.length);
        this.mExifByteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new java.lang.NullPointerException("inputStream cannot be null");
        }
        this.mFilename = null;
        if (z) {
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream, 5000);
            if (!isExifDataOnly(bufferedInputStream)) {
                return;
            }
            this.mIsExifDataOnly = true;
            this.mAssetInputStream = null;
            this.mSeekableFileDescriptor = null;
            inputStream = bufferedInputStream;
        } else if (inputStream instanceof android.content.res.AssetManager.AssetInputStream) {
            this.mAssetInputStream = (android.content.res.AssetManager.AssetInputStream) inputStream;
            this.mSeekableFileDescriptor = null;
        } else {
            if (inputStream instanceof java.io.FileInputStream) {
                java.io.FileInputStream fileInputStream = (java.io.FileInputStream) inputStream;
                if (isSeekableFD(fileInputStream.getFD())) {
                    this.mAssetInputStream = null;
                    this.mSeekableFileDescriptor = fileInputStream.getFD();
                }
            }
            this.mAssetInputStream = null;
            this.mSeekableFileDescriptor = null;
        }
        loadAttributes(inputStream);
    }

    public ExifInterface(@androidx.annotation.NonNull java.lang.String str) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new java.util.HashMap[exifTagArr.length];
        this.mAttributesOffsets = new java.util.HashSet(exifTagArr.length);
        this.mExifByteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new java.lang.NullPointerException("filename cannot be null");
        }
        initForFilename(str);
    }

    private void addDefaultValuesForCompatibility() {
        java.lang.String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.mAttributes[0].put(TAG_DATETIME, androidx.exifinterface.media.ExifInterface.ExifAttribute.createString(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.mAttributes[0].put(TAG_ORIENTATION, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.mAttributes[1].put(TAG_LIGHT_SOURCE, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
    }

    private static java.lang.String byteArrayToHexString(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b)));
        }
        return sb.toString();
    }

    private static void closeFileDescriptor(java.io.FileDescriptor fileDescriptor) {
        try {
            android.system.Os.close(fileDescriptor);
        } catch (java.lang.Exception unused) {
        }
    }

    private static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e) {
                throw e;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private java.lang.String convertDecimalDegree(double d) {
        long j = (long) d;
        double d2 = d - j;
        long j2 = (long) (d2 * 60.0d);
        return j + "/1," + j2 + "/1," + java.lang.Math.round((d2 - (j2 / 60.0d)) * 3600.0d * 1.0E7d) + "/10000000";
    }

    private static double convertRationalLatLonToDouble(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String[] split = str.split(",", -1);
            java.lang.String[] split2 = split[0].split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, -1);
            double parseDouble = java.lang.Double.parseDouble(split2[0].trim()) / java.lang.Double.parseDouble(split2[1].trim());
            java.lang.String[] split3 = split[1].split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, -1);
            double parseDouble2 = java.lang.Double.parseDouble(split3[0].trim()) / java.lang.Double.parseDouble(split3[1].trim());
            java.lang.String[] split4 = split[2].split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, -1);
            double parseDouble3 = parseDouble + (parseDouble2 / 60.0d) + ((java.lang.Double.parseDouble(split4[0].trim()) / java.lang.Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals(LATITUDE_SOUTH) && !str2.equals(LONGITUDE_WEST)) {
                if (!str2.equals("N") && !str2.equals(LONGITUDE_EAST)) {
                    throw new java.lang.IllegalArgumentException();
                }
                return parseDouble3;
            }
            return -parseDouble3;
        } catch (java.lang.ArrayIndexOutOfBoundsException | java.lang.NumberFormatException unused) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    private static long[] convertToLongArray(java.lang.Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    private static int copy(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i;
            }
            i += read;
            outputStream.write(bArr, 0, read);
        }
    }

    private static void copy(java.io.InputStream inputStream, java.io.OutputStream outputStream, int i) throws java.io.IOException {
        byte[] bArr = new byte[8192];
        while (i > 0) {
            int min = java.lang.Math.min(i, 8192);
            int read = inputStream.read(bArr, 0, min);
            if (read != min) {
                throw new java.io.IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
            i -= read;
            outputStream.write(bArr, 0, read);
        }
    }

    private void copyChunksUpToGivenChunkType(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr, byte[] bArr2) throws java.io.IOException {
        java.lang.String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                java.nio.charset.Charset charset = ASCII;
                sb.append(new java.lang.String(bArr, charset));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new java.lang.String(bArr2, charset);
                }
                sb.append(str);
                throw new java.io.IOException(sb.toString());
            }
            copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr3);
            if (java.util.Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && java.util.Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void copyWebPChunk(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr) throws java.io.IOException {
        int readInt = byteOrderedDataInputStream.readInt();
        byteOrderedDataOutputStream.write(bArr);
        byteOrderedDataOutputStream.writeInt(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt);
    }

    @androidx.annotation.Nullable
    private androidx.exifinterface.media.ExifInterface.ExifAttribute getExifAttribute(@androidx.annotation.NonNull java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        if (TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[i].get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    private void getHeifAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.io.IOException {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
        try {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                mediaMetadataRetriever.setDataSource(new androidx.exifinterface.media.ExifInterface.AnonymousClass1(byteOrderedDataInputStream));
            } else {
                java.io.FileDescriptor fileDescriptor = this.mSeekableFileDescriptor;
                if (fileDescriptor != null) {
                    mediaMetadataRetriever.setDataSource(fileDescriptor);
                } else {
                    java.lang.String str4 = this.mFilename;
                    if (str4 == null) {
                        return;
                    } else {
                        mediaMetadataRetriever.setDataSource(str4);
                    }
                }
            }
            java.lang.String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
            java.lang.String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
            java.lang.String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
            java.lang.String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
            if ("yes".equals(extractMetadata3)) {
                str = mediaMetadataRetriever.extractMetadata(29);
                str2 = mediaMetadataRetriever.extractMetadata(30);
                str3 = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(extractMetadata4)) {
                str = mediaMetadataRetriever.extractMetadata(18);
                str2 = mediaMetadataRetriever.extractMetadata(19);
                str3 = mediaMetadataRetriever.extractMetadata(24);
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            if (str != null) {
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(java.lang.Integer.parseInt(str), this.mExifByteOrder));
            }
            if (str2 != null) {
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(java.lang.Integer.parseInt(str2), this.mExifByteOrder));
            }
            if (str3 != null) {
                int parseInt = java.lang.Integer.parseInt(str3);
                this.mAttributes[0].put(TAG_ORIENTATION, androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(parseInt != 90 ? parseInt != 180 ? parseInt != 270 ? 1 : 8 : 3 : 6, this.mExifByteOrder));
            }
            if (extractMetadata != null && extractMetadata2 != null) {
                int parseInt2 = java.lang.Integer.parseInt(extractMetadata);
                int parseInt3 = java.lang.Integer.parseInt(extractMetadata2);
                if (parseInt3 <= 6) {
                    throw new java.io.IOException("Invalid exif length");
                }
                byteOrderedDataInputStream.seek(parseInt2);
                byte[] bArr = new byte[6];
                if (byteOrderedDataInputStream.read(bArr) != 6) {
                    throw new java.io.IOException("Can't read identifier");
                }
                int i = parseInt2 + 6;
                int i2 = parseInt3 - 6;
                if (!java.util.Arrays.equals(bArr, IDENTIFIER_EXIF_APP1)) {
                    throw new java.io.IOException("Invalid identifier");
                }
                byte[] bArr2 = new byte[i2];
                if (byteOrderedDataInputStream.read(bArr2) != i2) {
                    throw new java.io.IOException("Can't read exif");
                }
                this.mExifOffset = i;
                readExifSegment(bArr2, 0);
            }
            if (DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Heif meta: ");
                sb.append(str);
                sb.append("x");
                sb.append(str2);
                sb.append(", rotation ");
                sb.append(str3);
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x017f, code lost:
    
        r19.setByteOrder(r18.mExifByteOrder);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0184, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0173 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ab A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void getJpegAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, int i, int i2) throws java.io.IOException {
        int i3;
        if (DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getJpegAttributes starting with: ");
            sb.append(byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.setByteOrder(java.nio.ByteOrder.BIG_ENDIAN);
        byteOrderedDataInputStream.seek(i);
        byte readByte = byteOrderedDataInputStream.readByte();
        byte b = -1;
        if (readByte != -1) {
            throw new java.io.IOException("Invalid marker: " + java.lang.Integer.toHexString(readByte & 255));
        }
        int i4 = 1;
        int i5 = i + 1;
        if (byteOrderedDataInputStream.readByte() != -40) {
            throw new java.io.IOException("Invalid marker: " + java.lang.Integer.toHexString(readByte & 255));
        }
        int i6 = i5 + 1;
        while (true) {
            byte readByte2 = byteOrderedDataInputStream.readByte();
            if (readByte2 != b) {
                throw new java.io.IOException("Invalid marker:" + java.lang.Integer.toHexString(readByte2 & 255));
            }
            int i7 = i6 + i4;
            byte readByte3 = byteOrderedDataInputStream.readByte();
            boolean z = DEBUG;
            if (z) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Found JPEG segment indicator: ");
                sb2.append(java.lang.Integer.toHexString(readByte3 & 255));
            }
            int i8 = i7 + i4;
            if (readByte3 != -39 && readByte3 != -38) {
                int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort() - 2;
                int i9 = i8 + 2;
                if (z) {
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append("JPEG segment: ");
                    sb3.append(java.lang.Integer.toHexString(readByte3 & 255));
                    sb3.append(" (length: ");
                    sb3.append(readUnsignedShort + 2);
                    sb3.append(")");
                }
                if (readUnsignedShort < 0) {
                    throw new java.io.IOException("Invalid length");
                }
                if (readByte3 == -31) {
                    byte[] bArr = new byte[readUnsignedShort];
                    byteOrderedDataInputStream.readFully(bArr);
                    i3 = i9 + readUnsignedShort;
                    byte[] bArr2 = IDENTIFIER_EXIF_APP1;
                    if (startsWith(bArr, bArr2)) {
                        int length = i9 + bArr2.length;
                        byte[] copyOfRange = java.util.Arrays.copyOfRange(bArr, bArr2.length, readUnsignedShort);
                        this.mExifOffset = length;
                        readExifSegment(copyOfRange, i2);
                    } else {
                        byte[] bArr3 = IDENTIFIER_XMP_APP1;
                        if (startsWith(bArr, bArr3)) {
                            int length2 = i9 + bArr3.length;
                            byte[] copyOfRange2 = java.util.Arrays.copyOfRange(bArr, bArr3.length, readUnsignedShort);
                            if (getAttribute(TAG_XMP) == null) {
                                this.mAttributes[0].put(TAG_XMP, new androidx.exifinterface.media.ExifInterface.ExifAttribute(1, copyOfRange2.length, length2, copyOfRange2));
                                this.mXmpIsFromSeparateMarker = true;
                                readUnsignedShort = 0;
                                if (readUnsignedShort < 0) {
                                }
                            }
                        }
                    }
                } else if (readByte3 != -2) {
                    switch (readByte3) {
                        default:
                            switch (readByte3) {
                                default:
                                    switch (readByte3) {
                                        default:
                                            switch (readByte3) {
                                            }
                                        case -55:
                                        case -54:
                                        case -53:
                                            if (byteOrderedDataInputStream.skipBytes(i4) != i4) {
                                                throw new java.io.IOException("Invalid SOFx");
                                            }
                                            this.mAttributes[i2].put(TAG_IMAGE_LENGTH, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                            this.mAttributes[i2].put(TAG_IMAGE_WIDTH, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                            readUnsignedShort -= 5;
                                            break;
                                    }
                                case -59:
                                case -58:
                                case -57:
                                    break;
                            }
                        case -64:
                        case -63:
                        case -62:
                        case -61:
                            break;
                    }
                    i3 = i9;
                    if (readUnsignedShort < 0) {
                        throw new java.io.IOException("Invalid length");
                    }
                    if (byteOrderedDataInputStream.skipBytes(readUnsignedShort) != readUnsignedShort) {
                        throw new java.io.IOException("Invalid JPEG segment");
                    }
                    i6 = i3 + readUnsignedShort;
                    b = -1;
                    i4 = 1;
                } else {
                    byte[] bArr4 = new byte[readUnsignedShort];
                    if (byteOrderedDataInputStream.read(bArr4) != readUnsignedShort) {
                        throw new java.io.IOException("Invalid exif");
                    }
                    if (getAttribute(TAG_USER_COMMENT) == null) {
                        this.mAttributes[i4].put(TAG_USER_COMMENT, androidx.exifinterface.media.ExifInterface.ExifAttribute.createString(new java.lang.String(bArr4, ASCII)));
                    }
                    i3 = i9;
                }
                readUnsignedShort = 0;
                if (readUnsignedShort < 0) {
                }
            }
        }
    }

    private int getMimeType(java.io.BufferedInputStream bufferedInputStream) throws java.io.IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (isJpegFormat(bArr)) {
            return 4;
        }
        if (isRafFormat(bArr)) {
            return 9;
        }
        if (isHeifFormat(bArr)) {
            return 12;
        }
        if (isOrfFormat(bArr)) {
            return 7;
        }
        if (isRw2Format(bArr)) {
            return 10;
        }
        if (isPngFormat(bArr)) {
            return 13;
        }
        return isWebpFormat(bArr) ? 14 : 0;
    }

    private void getOrfAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.io.IOException {
        int i;
        int i2;
        getRawAttributes(byteOrderedDataInputStream);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (exifAttribute != null) {
            androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream2 = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(exifAttribute.bytes);
            byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byte[] bArr = ORF_MAKER_NOTE_HEADER_1;
            byte[] bArr2 = new byte[bArr.length];
            byteOrderedDataInputStream2.readFully(bArr2);
            byteOrderedDataInputStream2.seek(0L);
            byte[] bArr3 = ORF_MAKER_NOTE_HEADER_2;
            byte[] bArr4 = new byte[bArr3.length];
            byteOrderedDataInputStream2.readFully(bArr4);
            if (java.util.Arrays.equals(bArr2, bArr)) {
                byteOrderedDataInputStream2.seek(8L);
            } else if (java.util.Arrays.equals(bArr4, bArr3)) {
                byteOrderedDataInputStream2.seek(12L);
            }
            readImageFileDirectory(byteOrderedDataInputStream2, 6);
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute3 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (exifAttribute2 != null && exifAttribute3 != null) {
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, exifAttribute2);
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifAttribute3);
            }
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute4 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Invalid aspect frame values. frame=");
                    sb.append(java.util.Arrays.toString(iArr));
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                androidx.exifinterface.media.ExifInterface.ExifAttribute createUShort = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(i5, this.mExifByteOrder);
                androidx.exifinterface.media.ExifInterface.ExifAttribute createUShort2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(i6, this.mExifByteOrder);
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort);
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort2);
            }
        }
    }

    private void getPngAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.io.IOException {
        if (DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getPngAttributes starting with: ");
            sb.append(byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.setByteOrder(java.nio.ByteOrder.BIG_ENDIAN);
        byte[] bArr = PNG_SIGNATURE;
        byteOrderedDataInputStream.skipBytes(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = byteOrderedDataInputStream.readInt();
                int i = length + 4;
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) != 4) {
                    throw new java.io.IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i2 = i + 4;
                if (i2 == 16 && !java.util.Arrays.equals(bArr2, PNG_CHUNK_TYPE_IHDR)) {
                    throw new java.io.IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (java.util.Arrays.equals(bArr2, PNG_CHUNK_TYPE_IEND)) {
                    return;
                }
                if (java.util.Arrays.equals(bArr2, PNG_CHUNK_TYPE_EXIF)) {
                    byte[] bArr3 = new byte[readInt];
                    if (byteOrderedDataInputStream.read(bArr3) != readInt) {
                        throw new java.io.IOException("Failed to read given length for given PNG chunk type: " + byteArrayToHexString(bArr2));
                    }
                    int readInt2 = byteOrderedDataInputStream.readInt();
                    java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == readInt2) {
                        this.mExifOffset = i2;
                        readExifSegment(bArr3, 0);
                        validateImages();
                        return;
                    } else {
                        throw new java.io.IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                    }
                }
                int i3 = readInt + 4;
                byteOrderedDataInputStream.skipBytes(i3);
                length = i2 + i3;
            } catch (java.io.EOFException unused) {
                throw new java.io.IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void getRafAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.io.IOException {
        byteOrderedDataInputStream.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.skipBytes(4);
        byteOrderedDataInputStream.read(bArr2);
        int i = java.nio.ByteBuffer.wrap(bArr).getInt();
        int i2 = java.nio.ByteBuffer.wrap(bArr2).getInt();
        getJpegAttributes(byteOrderedDataInputStream, i, 5);
        byteOrderedDataInputStream.seek(i2);
        byteOrderedDataInputStream.setByteOrder(java.nio.ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        if (DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("numberOfDirectoryEntry: ");
            sb.append(readInt);
        }
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                androidx.exifinterface.media.ExifInterface.ExifAttribute createUShort = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(readShort, this.mExifByteOrder);
                androidx.exifinterface.media.ExifInterface.ExifAttribute createUShort2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(readShort2, this.mExifByteOrder);
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort);
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort2);
                if (DEBUG) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Updated to length: ");
                    sb2.append((int) readShort);
                    sb2.append(", width: ");
                    sb2.append((int) readShort2);
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.skipBytes(readUnsignedShort2);
        }
    }

    private void getRawAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute;
        parseTiffHeaders(byteOrderedDataInputStream, byteOrderedDataInputStream.available());
        readImageFileDirectory(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 5);
        updateImageSizeValues(byteOrderedDataInputStream, 4);
        validateImages();
        if (this.mMimeType != 8 || (exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE)) == null) {
            return;
        }
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream2 = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(exifAttribute.bytes);
        byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
        byteOrderedDataInputStream2.seek(6L);
        readImageFileDirectory(byteOrderedDataInputStream2, 9);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[9].get(TAG_COLOR_SPACE);
        if (exifAttribute2 != null) {
            this.mAttributes[1].put(TAG_COLOR_SPACE, exifAttribute2);
        }
    }

    private void getRw2Attributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.io.IOException {
        getRawAttributes(byteOrderedDataInputStream);
        if (this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW) != null) {
            getJpegAttributes(byteOrderedDataInputStream, this.mRw2JpgFromRawOffset, 5);
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[0].get(TAG_RW2_ISO);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (exifAttribute == null || exifAttribute2 != null) {
            return;
        }
        this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, exifAttribute);
    }

    private void getStandaloneAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.io.IOException {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        byteOrderedDataInputStream.skipBytes(bArr.length);
        byte[] bArr2 = new byte[byteOrderedDataInputStream.available()];
        byteOrderedDataInputStream.readFully(bArr2);
        this.mExifOffset = bArr.length;
        readExifSegment(bArr2, 0);
    }

    private void getWebpAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.io.IOException {
        if (DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getWebpAttributes starting with: ");
            sb.append(byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.setByteOrder(java.nio.ByteOrder.LITTLE_ENDIAN);
        byteOrderedDataInputStream.skipBytes(WEBP_SIGNATURE_1.length);
        int readInt = byteOrderedDataInputStream.readInt() + 8;
        int skipBytes = byteOrderedDataInputStream.skipBytes(WEBP_SIGNATURE_2.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (byteOrderedDataInputStream.read(bArr) != 4) {
                    throw new java.io.IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int readInt2 = byteOrderedDataInputStream.readInt();
                int i = skipBytes + 4 + 4;
                if (java.util.Arrays.equals(WEBP_CHUNK_TYPE_EXIF, bArr)) {
                    byte[] bArr2 = new byte[readInt2];
                    if (byteOrderedDataInputStream.read(bArr2) == readInt2) {
                        this.mExifOffset = i;
                        readExifSegment(bArr2, 0);
                        this.mExifOffset = i;
                        return;
                    } else {
                        throw new java.io.IOException("Failed to read given length for given PNG chunk type: " + byteArrayToHexString(bArr));
                    }
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                int i2 = i + readInt2;
                if (i2 == readInt) {
                    return;
                }
                if (i2 > readInt) {
                    throw new java.io.IOException("Encountered WebP file with invalid chunk size");
                }
                int skipBytes2 = byteOrderedDataInputStream.skipBytes(readInt2);
                if (skipBytes2 != readInt2) {
                    throw new java.io.IOException("Encountered WebP file with invalid chunk size");
                }
                skipBytes = i + skipBytes2;
            } catch (java.io.EOFException unused) {
                throw new java.io.IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private static android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat(java.lang.String str) {
        if (str.contains(",")) {
            java.lang.String[] split = str.split(",", -1);
            android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat = guessDataFormat(split[0]);
            if (((java.lang.Integer) guessDataFormat.first).intValue() == 2) {
                return guessDataFormat;
            }
            for (int i = 1; i < split.length; i++) {
                android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat2 = guessDataFormat(split[i]);
                int intValue = (((java.lang.Integer) guessDataFormat2.first).equals(guessDataFormat.first) || ((java.lang.Integer) guessDataFormat2.second).equals(guessDataFormat.first)) ? ((java.lang.Integer) guessDataFormat.first).intValue() : -1;
                int intValue2 = (((java.lang.Integer) guessDataFormat.second).intValue() == -1 || !(((java.lang.Integer) guessDataFormat2.first).equals(guessDataFormat.second) || ((java.lang.Integer) guessDataFormat2.second).equals(guessDataFormat.second))) ? -1 : ((java.lang.Integer) guessDataFormat.second).intValue();
                if (intValue == -1 && intValue2 == -1) {
                    return new android.util.Pair<>(2, -1);
                }
                if (intValue == -1) {
                    guessDataFormat = new android.util.Pair<>(java.lang.Integer.valueOf(intValue2), -1);
                } else if (intValue2 == -1) {
                    guessDataFormat = new android.util.Pair<>(java.lang.Integer.valueOf(intValue), -1);
                }
            }
            return guessDataFormat;
        }
        if (!str.contains(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            try {
                try {
                    java.lang.Long valueOf = java.lang.Long.valueOf(java.lang.Long.parseLong(str));
                    return (valueOf.longValue() < 0 || valueOf.longValue() > 65535) ? valueOf.longValue() < 0 ? new android.util.Pair<>(9, -1) : new android.util.Pair<>(4, -1) : new android.util.Pair<>(3, 4);
                } catch (java.lang.NumberFormatException unused) {
                    return new android.util.Pair<>(2, -1);
                }
            } catch (java.lang.NumberFormatException unused2) {
                java.lang.Double.parseDouble(str);
                return new android.util.Pair<>(12, -1);
            }
        }
        java.lang.String[] split2 = str.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, -1);
        if (split2.length == 2) {
            try {
                long parseDouble = (long) java.lang.Double.parseDouble(split2[0]);
                long parseDouble2 = (long) java.lang.Double.parseDouble(split2[1]);
                if (parseDouble >= 0 && parseDouble2 >= 0) {
                    if (parseDouble <= 2147483647L && parseDouble2 <= 2147483647L) {
                        return new android.util.Pair<>(10, 5);
                    }
                    return new android.util.Pair<>(5, -1);
                }
                return new android.util.Pair<>(10, -1);
            } catch (java.lang.NumberFormatException unused3) {
            }
        }
        return new android.util.Pair<>(2, -1);
    }

    private void handleThumbnailFromJfif(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, java.util.HashMap hashMap) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = (androidx.exifinterface.media.ExifInterface.ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        if (this.mMimeType == 7) {
            intValue += this.mOrfMakerNoteOffset;
        }
        int min = java.lang.Math.min(intValue2, byteOrderedDataInputStream.getLength() - intValue);
        if (intValue > 0 && min > 0) {
            this.mHasThumbnail = true;
            int i = this.mExifOffset + intValue;
            this.mThumbnailOffset = i;
            this.mThumbnailLength = min;
            if (this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
                byte[] bArr = new byte[min];
                byteOrderedDataInputStream.seek(i);
                byteOrderedDataInputStream.readFully(bArr);
                this.mThumbnailBytes = bArr;
            }
        }
        if (DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Setting thumbnail attributes with offset: ");
            sb.append(intValue);
            sb.append(", length: ");
            sb.append(min);
        }
    }

    private void handleThumbnailFromStrips(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, java.util.HashMap hashMap) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = (androidx.exifinterface.media.ExifInterface.ExifAttribute) hashMap.get(TAG_STRIP_OFFSETS);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) hashMap.get(TAG_STRIP_BYTE_COUNTS);
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        long[] convertToLongArray = convertToLongArray(exifAttribute.getValue(this.mExifByteOrder));
        long[] convertToLongArray2 = convertToLongArray(exifAttribute2.getValue(this.mExifByteOrder));
        if (convertToLongArray == null || convertToLongArray.length == 0 || convertToLongArray2 == null || convertToLongArray2.length == 0 || convertToLongArray.length != convertToLongArray2.length) {
            return;
        }
        long j = 0;
        for (long j2 : convertToLongArray2) {
            j += j2;
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        this.mAreThumbnailStripsConsecutive = true;
        this.mHasThumbnailStrips = true;
        this.mHasThumbnail = true;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < convertToLongArray.length; i4++) {
            int i5 = (int) convertToLongArray[i4];
            int i6 = (int) convertToLongArray2[i4];
            if (i4 < convertToLongArray.length - 1 && i5 + i6 != convertToLongArray[i4 + 1]) {
                this.mAreThumbnailStripsConsecutive = false;
            }
            int i7 = i5 - i2;
            byteOrderedDataInputStream.seek(i7);
            int i8 = i2 + i7;
            byte[] bArr2 = new byte[i6];
            byteOrderedDataInputStream.read(bArr2);
            i2 = i8 + i6;
            java.lang.System.arraycopy(bArr2, 0, bArr, i3, i6);
            i3 += i6;
        }
        this.mThumbnailBytes = bArr;
        if (this.mAreThumbnailStripsConsecutive) {
            this.mThumbnailOffset = ((int) convertToLongArray[0]) + this.mExifOffset;
            this.mThumbnailLength = i;
        }
    }

    private void initForFilename(java.lang.String str) throws java.io.IOException {
        if (str == null) {
            throw new java.lang.NullPointerException("filename cannot be null");
        }
        java.io.FileInputStream fileInputStream = null;
        this.mAssetInputStream = null;
        this.mFilename = str;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(str);
            try {
                if (isSeekableFD(fileInputStream2.getFD())) {
                    this.mSeekableFileDescriptor = fileInputStream2.getFD();
                } else {
                    this.mSeekableFileDescriptor = null;
                }
                loadAttributes(fileInputStream2);
                closeQuietly(fileInputStream2);
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static boolean isExifDataOnly(java.io.BufferedInputStream bufferedInputStream) throws java.io.IOException {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr3 = IDENTIFIER_EXIF_APP1;
            if (i >= bArr3.length) {
                return true;
            }
            if (bArr2[i] != bArr3[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean isHeifFormat(byte[] bArr) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream;
        long readInt;
        byte[] bArr2;
        long j;
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
        try {
            try {
                byteOrderedDataInputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(bArr);
            } catch (java.lang.Exception unused) {
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            readInt = byteOrderedDataInputStream.readInt();
            bArr2 = new byte[4];
            byteOrderedDataInputStream.read(bArr2);
        } catch (java.lang.Exception unused2) {
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            boolean z = DEBUG;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            return false;
        } catch (java.lang.Throwable th2) {
            th = th2;
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            throw th;
        }
        if (!java.util.Arrays.equals(bArr2, HEIF_TYPE_FTYP)) {
            byteOrderedDataInputStream.close();
            return false;
        }
        if (readInt == 1) {
            readInt = byteOrderedDataInputStream.readLong();
            j = 16;
            if (readInt < 16) {
                byteOrderedDataInputStream.close();
                return false;
            }
        } else {
            j = 8;
        }
        if (readInt > bArr.length) {
            readInt = bArr.length;
        }
        long j2 = readInt - j;
        if (j2 < 8) {
            byteOrderedDataInputStream.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z2 = false;
        boolean z3 = false;
        for (long j3 = 0; j3 < j2 / 4; j3++) {
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                byteOrderedDataInputStream.close();
                return false;
            }
            if (j3 != 1) {
                if (java.util.Arrays.equals(bArr3, HEIF_BRAND_MIF1)) {
                    z2 = true;
                } else if (java.util.Arrays.equals(bArr3, HEIF_BRAND_HEIC)) {
                    z3 = true;
                }
                if (z2 && z3) {
                    byteOrderedDataInputStream.close();
                    return true;
                }
            }
        }
        byteOrderedDataInputStream.close();
        return false;
    }

    private static boolean isJpegFormat(byte[] bArr) throws java.io.IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean isOrfFormat(byte[] bArr) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream = null;
        try {
            androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream2 = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(bArr);
            try {
                java.nio.ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream2);
                this.mExifByteOrder = readByteOrder;
                byteOrderedDataInputStream2.setByteOrder(readByteOrder);
                short readShort = byteOrderedDataInputStream2.readShort();
                boolean z = readShort == 20306 || readShort == 21330;
                byteOrderedDataInputStream2.close();
                return z;
            } catch (java.lang.Exception unused) {
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                return false;
            } catch (java.lang.Throwable th) {
                th = th;
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                throw th;
            }
        } catch (java.lang.Exception unused2) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private boolean isPngFormat(byte[] bArr) throws java.io.IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = PNG_SIGNATURE;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean isRafFormat(byte[] bArr) throws java.io.IOException {
        byte[] bytes = RAF_SIGNATURE.getBytes(java.nio.charset.Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isRw2Format(byte[] bArr) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream = null;
        try {
            androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream2 = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(bArr);
            try {
                java.nio.ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream2);
                this.mExifByteOrder = readByteOrder;
                byteOrderedDataInputStream2.setByteOrder(readByteOrder);
                boolean z = byteOrderedDataInputStream2.readShort() == 85;
                byteOrderedDataInputStream2.close();
                return z;
            } catch (java.lang.Exception unused) {
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                return false;
            } catch (java.lang.Throwable th) {
                th = th;
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                throw th;
            }
        } catch (java.lang.Exception unused2) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static boolean isSeekableFD(java.io.FileDescriptor fileDescriptor) {
        try {
            android.system.Os.lseek(fileDescriptor, 0L, android.system.OsConstants.SEEK_CUR);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private boolean isSupportedDataType(java.util.HashMap hashMap) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute;
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) hashMap.get(TAG_BITS_PER_SAMPLE);
        if (exifAttribute2 == null) {
            return false;
        }
        int[] iArr = (int[]) exifAttribute2.getValue(this.mExifByteOrder);
        int[] iArr2 = BITS_PER_SAMPLE_RGB;
        if (java.util.Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.mMimeType != 3 || (exifAttribute = (androidx.exifinterface.media.ExifInterface.ExifAttribute) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION)) == null) {
            return false;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        return (intValue == 1 && java.util.Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (intValue == 6 && java.util.Arrays.equals(iArr, iArr2));
    }

    private boolean isSupportedFormatForSavingAttributes() {
        if (!this.mIsSupportedFile) {
            return false;
        }
        int i = this.mMimeType;
        return i == 4 || i == 13 || i == 14;
    }

    public static boolean isSupportedMimeType(@androidx.annotation.NonNull java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("mimeType shouldn't be null");
        }
        java.lang.String lowerCase = str.toLowerCase(java.util.Locale.ROOT);
        lowerCase.hashCode();
        switch (lowerCase) {
            case "image/x-fuji-raf":
            case "image/x-samsung-srw":
            case "image/x-sony-arw":
            case "image/heic":
            case "image/heif":
            case "image/jpeg":
            case "image/webp":
            case "image/x-adobe-dng":
            case "image/x-panasonic-rw2":
            case "image/png":
            case "image/x-pentax-pef":
            case "image/x-olympus-orf":
            case "image/x-nikon-nef":
            case "image/x-nikon-nrw":
            case "image/x-canon-cr2":
                return true;
            default:
                return false;
        }
    }

    private boolean isThumbnail(java.util.HashMap hashMap) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = (androidx.exifinterface.media.ExifInterface.ExifAttribute) hashMap.get(TAG_IMAGE_LENGTH);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) hashMap.get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.getIntValue(this.mExifByteOrder) <= 512 && exifAttribute2.getIntValue(this.mExifByteOrder) <= 512;
    }

    private boolean isWebpFormat(byte[] bArr) throws java.io.IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = WEBP_SIGNATURE_1;
            if (i >= bArr2.length) {
                int i2 = 0;
                while (true) {
                    byte[] bArr3 = WEBP_SIGNATURE_2;
                    if (i2 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[WEBP_SIGNATURE_1.length + i2 + 4] != bArr3[i2]) {
                        return false;
                    }
                    i2++;
                }
            } else {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
                i++;
            }
        }
    }

    private void loadAttributes(@androidx.annotation.NonNull java.io.InputStream inputStream) {
        if (inputStream == null) {
            throw new java.lang.NullPointerException("inputstream shouldn't be null");
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            try {
                try {
                    this.mAttributes[i] = new java.util.HashMap<>();
                } catch (java.io.IOException unused) {
                    this.mIsSupportedFile = false;
                    boolean z = DEBUG;
                    addDefaultValuesForCompatibility();
                    if (!z) {
                        return;
                    }
                }
            } finally {
                addDefaultValuesForCompatibility();
                if (DEBUG) {
                    printAttributes();
                }
            }
        }
        if (!this.mIsExifDataOnly) {
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream, 5000);
            this.mMimeType = getMimeType(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(inputStream);
        if (!this.mIsExifDataOnly) {
            switch (this.mMimeType) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                case 8:
                case 11:
                    getRawAttributes(byteOrderedDataInputStream);
                    break;
                case 4:
                    getJpegAttributes(byteOrderedDataInputStream, 0, 0);
                    break;
                case 7:
                    getOrfAttributes(byteOrderedDataInputStream);
                    break;
                case 9:
                    getRafAttributes(byteOrderedDataInputStream);
                    break;
                case 10:
                    getRw2Attributes(byteOrderedDataInputStream);
                    break;
                case 12:
                    getHeifAttributes(byteOrderedDataInputStream);
                    break;
                case 13:
                    getPngAttributes(byteOrderedDataInputStream);
                    break;
                case 14:
                    getWebpAttributes(byteOrderedDataInputStream);
                    break;
            }
        } else {
            getStandaloneAttributes(byteOrderedDataInputStream);
        }
        setThumbnailData(byteOrderedDataInputStream);
        this.mIsSupportedFile = true;
    }

    private static long parseDateTime(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        if (str != null && sNonZeroTimePattern.matcher(str).matches()) {
            try {
                java.util.Date parse = sFormatter.parse(str, new java.text.ParsePosition(0));
                if (parse == null) {
                    return -1L;
                }
                long time = parse.getTime();
                if (str2 == null) {
                    return time;
                }
                try {
                    long parseLong = java.lang.Long.parseLong(str2);
                    while (parseLong > 1000) {
                        parseLong /= 10;
                    }
                    return time + parseLong;
                } catch (java.lang.NumberFormatException unused) {
                    return time;
                }
            } catch (java.lang.IllegalArgumentException unused2) {
            }
        }
        return -1L;
    }

    private void parseTiffHeaders(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws java.io.IOException {
        java.nio.ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i2 = this.mMimeType;
        if (i2 != 7 && i2 != 10 && readUnsignedShort != 42) {
            throw new java.io.IOException("Invalid start code: " + java.lang.Integer.toHexString(readUnsignedShort));
        }
        int readInt = byteOrderedDataInputStream.readInt();
        if (readInt < 8 || readInt >= i) {
            throw new java.io.IOException("Invalid first Ifd offset: " + readInt);
        }
        int i3 = readInt - 8;
        if (i3 <= 0 || byteOrderedDataInputStream.skipBytes(i3) == i3) {
            return;
        }
        throw new java.io.IOException("Couldn't jump to first Ifd: " + i3);
    }

    private void printAttributes() {
        for (int i = 0; i < this.mAttributes.length; i++) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("The size of tag group[");
            sb.append(i);
            sb.append("]: ");
            sb.append(this.mAttributes[i].size());
            for (java.util.Map.Entry<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute> entry : this.mAttributes[i].entrySet()) {
                androidx.exifinterface.media.ExifInterface.ExifAttribute value = entry.getValue();
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("tagName: ");
                sb2.append(entry.getKey());
                sb2.append(", tagType: ");
                sb2.append(value.toString());
                sb2.append(", tagValue: '");
                sb2.append(value.getStringValue(this.mExifByteOrder));
                sb2.append("'");
            }
        }
    }

    private java.nio.ByteOrder readByteOrder(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.io.IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort == 18761) {
            return java.nio.ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return java.nio.ByteOrder.BIG_ENDIAN;
        }
        throw new java.io.IOException("Invalid byte order: " + java.lang.Integer.toHexString(readShort));
    }

    private void readExifSegment(byte[] bArr, int i) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(bArr);
        parseTiffHeaders(byteOrderedDataInputStream, bArr.length);
        readImageFileDirectory(byteOrderedDataInputStream, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x029c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void readImageFileDirectory(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws java.io.IOException {
        long j;
        long j2;
        boolean z;
        short s2;
        java.lang.String str;
        short s3;
        int i2;
        int i3;
        int i4;
        int readUnsignedShort;
        long j3;
        this.mAttributesOffsets.add(java.lang.Integer.valueOf(byteOrderedDataInputStream.mPosition));
        if (byteOrderedDataInputStream.mPosition + 2 > byteOrderedDataInputStream.mLength) {
            return;
        }
        short readShort = byteOrderedDataInputStream.readShort();
        if (DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("numberOfDirectoryEntry: ");
            sb.append((int) readShort);
        }
        if (byteOrderedDataInputStream.mPosition + (readShort * 12) > byteOrderedDataInputStream.mLength || readShort <= 0) {
            return;
        }
        char c = 0;
        short s4 = 0;
        while (s4 < readShort) {
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort3 = byteOrderedDataInputStream.readUnsignedShort();
            int readInt = byteOrderedDataInputStream.readInt();
            long peek = byteOrderedDataInputStream.peek() + 4;
            androidx.exifinterface.media.ExifInterface.ExifTag exifTag = sExifTagMapsForReading[i].get(java.lang.Integer.valueOf(readUnsignedShort2));
            boolean z2 = DEBUG;
            if (z2) {
                java.lang.Object[] objArr = new java.lang.Object[5];
                objArr[c] = java.lang.Integer.valueOf(i);
                objArr[1] = java.lang.Integer.valueOf(readUnsignedShort2);
                objArr[2] = exifTag != null ? exifTag.name : null;
                objArr[3] = java.lang.Integer.valueOf(readUnsignedShort3);
                objArr[4] = java.lang.Integer.valueOf(readInt);
                java.lang.String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", objArr);
            }
            if (exifTag != null) {
                if (readUnsignedShort3 > 0) {
                    if (readUnsignedShort3 < IFD_FORMAT_BYTES_PER_FORMAT.length) {
                        if (exifTag.isFormatCompatible(readUnsignedShort3)) {
                            if (readUnsignedShort3 == 7) {
                                readUnsignedShort3 = exifTag.primaryFormat;
                            }
                            j = peek;
                            j2 = readInt * r5[readUnsignedShort3];
                            if (j2 < 0 || j2 > 2147483647L) {
                                if (z2) {
                                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                    sb2.append("Skip the tag entry since the number of components is invalid: ");
                                    sb2.append(readInt);
                                }
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                long j4 = j;
                                if (j2 > 4) {
                                    int readInt2 = byteOrderedDataInputStream.readInt();
                                    s2 = readShort;
                                    if (z2) {
                                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                                        s3 = s4;
                                        sb3.append("seek to data offset: ");
                                        sb3.append(readInt2);
                                    } else {
                                        s3 = s4;
                                    }
                                    int i5 = this.mMimeType;
                                    if (i5 == 7) {
                                        if (TAG_MAKER_NOTE.equals(exifTag.name)) {
                                            this.mOrfMakerNoteOffset = readInt2;
                                        } else if (i == 6 && TAG_ORF_THUMBNAIL_IMAGE.equals(exifTag.name)) {
                                            this.mOrfThumbnailOffset = readInt2;
                                            this.mOrfThumbnailLength = readInt;
                                            androidx.exifinterface.media.ExifInterface.ExifAttribute createUShort = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(6, this.mExifByteOrder);
                                            i2 = readUnsignedShort2;
                                            i3 = readUnsignedShort3;
                                            androidx.exifinterface.media.ExifInterface.ExifAttribute createULong = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(this.mOrfThumbnailOffset, this.mExifByteOrder);
                                            i4 = readInt;
                                            androidx.exifinterface.media.ExifInterface.ExifAttribute createULong2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(this.mOrfThumbnailLength, this.mExifByteOrder);
                                            this.mAttributes[4].put(TAG_COMPRESSION, createUShort);
                                            this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, createULong);
                                            this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, createULong2);
                                        }
                                        i2 = readUnsignedShort2;
                                        i3 = readUnsignedShort3;
                                        i4 = readInt;
                                    } else {
                                        i2 = readUnsignedShort2;
                                        i3 = readUnsignedShort3;
                                        i4 = readInt;
                                        if (i5 == 10 && TAG_RW2_JPG_FROM_RAW.equals(exifTag.name)) {
                                            this.mRw2JpgFromRawOffset = readInt2;
                                        }
                                    }
                                    long j5 = readInt2;
                                    long j6 = j5 + j2;
                                    int i6 = byteOrderedDataInputStream.mLength;
                                    str = TAG_COMPRESSION;
                                    if (j6 <= i6) {
                                        byteOrderedDataInputStream.seek(j5);
                                    } else {
                                        if (z2) {
                                            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                                            sb4.append("Skip the tag entry since data offset is invalid: ");
                                            sb4.append(readInt2);
                                        }
                                        byteOrderedDataInputStream.seek(j4);
                                    }
                                } else {
                                    s2 = readShort;
                                    str = TAG_COMPRESSION;
                                    s3 = s4;
                                    i2 = readUnsignedShort2;
                                    i3 = readUnsignedShort3;
                                    i4 = readInt;
                                }
                                java.lang.Integer num = sExifPointerTagMap.get(java.lang.Integer.valueOf(i2));
                                if (z2) {
                                    java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                                    sb5.append("nextIfdType: ");
                                    sb5.append(num);
                                    sb5.append(" byteCount: ");
                                    sb5.append(j2);
                                }
                                if (num != null) {
                                    int i7 = i3;
                                    if (i7 != 3) {
                                        if (i7 == 4) {
                                            j3 = byteOrderedDataInputStream.readUnsignedInt();
                                        } else if (i7 == 8) {
                                            readUnsignedShort = byteOrderedDataInputStream.readShort();
                                        } else if (i7 == 9 || i7 == 13) {
                                            readUnsignedShort = byteOrderedDataInputStream.readInt();
                                        } else {
                                            j3 = -1;
                                        }
                                        if (z2) {
                                            java.lang.String.format("Offset: %d, tagName: %s", java.lang.Long.valueOf(j3), exifTag.name);
                                        }
                                        if (j3 > 0 || j3 >= byteOrderedDataInputStream.mLength) {
                                            if (z2) {
                                                java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                                                sb6.append("Skip jump into the IFD since its offset is invalid: ");
                                                sb6.append(j3);
                                            }
                                        } else if (!this.mAttributesOffsets.contains(java.lang.Integer.valueOf((int) j3))) {
                                            byteOrderedDataInputStream.seek(j3);
                                            readImageFileDirectory(byteOrderedDataInputStream, num.intValue());
                                        } else if (z2) {
                                            java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
                                            sb7.append("Skip jump into the IFD since it has already been read: IfdType ");
                                            sb7.append(num);
                                            sb7.append(" (at ");
                                            sb7.append(j3);
                                            sb7.append(")");
                                        }
                                        byteOrderedDataInputStream.seek(j4);
                                    } else {
                                        readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                                    }
                                    j3 = readUnsignedShort;
                                    if (z2) {
                                    }
                                    if (j3 > 0) {
                                    }
                                    if (z2) {
                                    }
                                    byteOrderedDataInputStream.seek(j4);
                                } else {
                                    int peek2 = byteOrderedDataInputStream.peek() + this.mExifOffset;
                                    byte[] bArr = new byte[(int) j2];
                                    byteOrderedDataInputStream.readFully(bArr);
                                    androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = new androidx.exifinterface.media.ExifInterface.ExifAttribute(i3, i4, peek2, bArr);
                                    this.mAttributes[i].put(exifTag.name, exifAttribute);
                                    if (TAG_DNG_VERSION.equals(exifTag.name)) {
                                        this.mMimeType = 3;
                                    }
                                    if (((TAG_MAKE.equals(exifTag.name) || TAG_MODEL.equals(exifTag.name)) && exifAttribute.getStringValue(this.mExifByteOrder).contains(PEF_SIGNATURE)) || (str.equals(exifTag.name) && exifAttribute.getIntValue(this.mExifByteOrder) == 65535)) {
                                        this.mMimeType = 8;
                                    }
                                    if (byteOrderedDataInputStream.peek() != j4) {
                                        byteOrderedDataInputStream.seek(j4);
                                    }
                                }
                                s4 = (short) (s3 + 1);
                                readShort = s2;
                                c = 0;
                            } else {
                                byteOrderedDataInputStream.seek(j);
                                s2 = readShort;
                                s3 = s4;
                            }
                            s4 = (short) (s3 + 1);
                            readShort = s2;
                            c = 0;
                        } else if (z2) {
                            java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
                            sb8.append("Skip the tag entry since data format (");
                            sb8.append(IFD_FORMAT_NAMES[readUnsignedShort3]);
                            sb8.append(") is unexpected for tag: ");
                            sb8.append(exifTag.name);
                        }
                    }
                }
                j = peek;
                if (z2) {
                    java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
                    sb9.append("Skip the tag entry since data format is invalid: ");
                    sb9.append(readUnsignedShort3);
                }
                z = false;
                j2 = 0;
                if (z) {
                }
                s4 = (short) (s3 + 1);
                readShort = s2;
                c = 0;
            } else if (z2) {
                java.lang.StringBuilder sb10 = new java.lang.StringBuilder();
                sb10.append("Skip the tag entry since tag number is not defined: ");
                sb10.append(readUnsignedShort2);
            }
            j = peek;
            z = false;
            j2 = 0;
            if (z) {
            }
            s4 = (short) (s3 + 1);
            readShort = s2;
            c = 0;
        }
        if (byteOrderedDataInputStream.peek() + 4 <= byteOrderedDataInputStream.mLength) {
            int readInt3 = byteOrderedDataInputStream.readInt();
            boolean z3 = DEBUG;
            if (z3) {
                java.lang.String.format("nextIfdOffset: %d", java.lang.Integer.valueOf(readInt3));
            }
            long j7 = readInt3;
            if (j7 <= 0 || readInt3 >= byteOrderedDataInputStream.mLength) {
                if (z3) {
                    java.lang.StringBuilder sb11 = new java.lang.StringBuilder();
                    sb11.append("Stop reading file since a wrong offset may cause an infinite loop: ");
                    sb11.append(readInt3);
                    return;
                }
                return;
            }
            if (this.mAttributesOffsets.contains(java.lang.Integer.valueOf(readInt3))) {
                if (z3) {
                    java.lang.StringBuilder sb12 = new java.lang.StringBuilder();
                    sb12.append("Stop reading file since re-reading an IFD may cause an infinite loop: ");
                    sb12.append(readInt3);
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.seek(j7);
            if (this.mAttributes[4].isEmpty()) {
                readImageFileDirectory(byteOrderedDataInputStream, 4);
            } else if (this.mAttributes[5].isEmpty()) {
                readImageFileDirectory(byteOrderedDataInputStream, 5);
            }
        }
    }

    private void removeAttribute(java.lang.String str) {
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            this.mAttributes[i].remove(str);
        }
    }

    private void retrieveJpegImageSize(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute;
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[i].get(TAG_IMAGE_LENGTH);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute3 = this.mAttributes[i].get(TAG_IMAGE_WIDTH);
        if ((exifAttribute2 == null || exifAttribute3 == null) && (exifAttribute = this.mAttributes[i].get(TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
            getJpegAttributes(byteOrderedDataInputStream, exifAttribute.getIntValue(this.mExifByteOrder), i);
        }
    }

    private void saveJpegAttributes(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        if (DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("saveJpegAttributes starting with (inputStream: ");
            sb.append(inputStream);
            sb.append(", outputStream: ");
            sb.append(outputStream);
            sb.append(")");
        }
        java.io.DataInputStream dataInputStream = new java.io.DataInputStream(inputStream);
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream(outputStream, java.nio.ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() != -1) {
            throw new java.io.IOException("Invalid marker");
        }
        byteOrderedDataOutputStream.writeByte(-1);
        if (dataInputStream.readByte() != -40) {
            throw new java.io.IOException("Invalid marker");
        }
        byteOrderedDataOutputStream.writeByte(-40);
        androidx.exifinterface.media.ExifInterface.ExifAttribute remove = (getAttribute(TAG_XMP) == null || !this.mXmpIsFromSeparateMarker) ? null : this.mAttributes[0].remove(TAG_XMP);
        byteOrderedDataOutputStream.writeByte(-1);
        byteOrderedDataOutputStream.writeByte(-31);
        writeExifSegment(byteOrderedDataOutputStream);
        if (remove != null) {
            this.mAttributes[0].put(TAG_XMP, remove);
        }
        byte[] bArr = new byte[4096];
        while (dataInputStream.readByte() == -1) {
            byte readByte = dataInputStream.readByte();
            if (readByte == -39 || readByte == -38) {
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(readByte);
                copy(dataInputStream, byteOrderedDataOutputStream);
                return;
            }
            if (readByte != -31) {
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(readByte);
                int readUnsignedShort = dataInputStream.readUnsignedShort();
                byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort);
                int i = readUnsignedShort - 2;
                if (i < 0) {
                    throw new java.io.IOException("Invalid length");
                }
                while (i > 0) {
                    int read = dataInputStream.read(bArr, 0, java.lang.Math.min(i, 4096));
                    if (read >= 0) {
                        byteOrderedDataOutputStream.write(bArr, 0, read);
                        i -= read;
                    }
                }
            } else {
                int readUnsignedShort2 = dataInputStream.readUnsignedShort() - 2;
                if (readUnsignedShort2 < 0) {
                    throw new java.io.IOException("Invalid length");
                }
                byte[] bArr2 = new byte[6];
                if (readUnsignedShort2 >= 6) {
                    if (dataInputStream.read(bArr2) != 6) {
                        throw new java.io.IOException("Invalid exif");
                    }
                    if (java.util.Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                        int i2 = readUnsignedShort2 - 6;
                        if (dataInputStream.skipBytes(i2) != i2) {
                            throw new java.io.IOException("Invalid length");
                        }
                    }
                }
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(readByte);
                byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort2 + 2);
                if (readUnsignedShort2 >= 6) {
                    readUnsignedShort2 -= 6;
                    byteOrderedDataOutputStream.write(bArr2);
                }
                while (readUnsignedShort2 > 0) {
                    int read2 = dataInputStream.read(bArr, 0, java.lang.Math.min(readUnsignedShort2, 4096));
                    if (read2 >= 0) {
                        byteOrderedDataOutputStream.write(bArr, 0, read2);
                        readUnsignedShort2 -= read2;
                    }
                }
            }
        }
        throw new java.io.IOException("Invalid marker");
    }

    private void savePngAttributes(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        if (DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("savePngAttributes starting with (inputStream: ");
            sb.append(inputStream);
            sb.append(", outputStream: ");
            sb.append(outputStream);
            sb.append(")");
        }
        java.io.DataInputStream dataInputStream = new java.io.DataInputStream(inputStream);
        java.nio.ByteOrder byteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream(outputStream, byteOrder);
        byte[] bArr = PNG_SIGNATURE;
        copy(dataInputStream, byteOrderedDataOutputStream, bArr.length);
        int i = this.mExifOffset;
        if (i == 0) {
            int readInt = dataInputStream.readInt();
            byteOrderedDataOutputStream.writeInt(readInt);
            copy(dataInputStream, byteOrderedDataOutputStream, readInt + 4 + 4);
        } else {
            copy(dataInputStream, byteOrderedDataOutputStream, ((i - bArr.length) - 4) - 4);
            dataInputStream.skipBytes(dataInputStream.readInt() + 4 + 4);
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
            try {
                androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream(byteArrayOutputStream2, byteOrder);
                writeExifSegment(byteOrderedDataOutputStream2);
                byte[] byteArray = ((java.io.ByteArrayOutputStream) byteOrderedDataOutputStream2.mOutputStream).toByteArray();
                byteOrderedDataOutputStream.write(byteArray);
                java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                byteOrderedDataOutputStream.writeInt((int) crc32.getValue());
                closeQuietly(byteArrayOutputStream2);
                copy(dataInputStream, byteOrderedDataOutputStream);
            } catch (java.lang.Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private void saveWebpAttributes(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        if (DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("saveWebpAttributes starting with (inputStream: ");
            sb.append(inputStream);
            sb.append(", outputStream: ");
            sb.append(outputStream);
            sb.append(")");
        }
        java.nio.ByteOrder byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(inputStream, byteOrder);
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream(outputStream, byteOrder);
        byte[] bArr = WEBP_SIGNATURE_1;
        copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr.length);
        byte[] bArr2 = WEBP_SIGNATURE_2;
        byteOrderedDataInputStream.skipBytes(bArr2.length + 4);
        java.io.ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            } catch (java.lang.Exception e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream(byteArrayOutputStream, byteOrder);
            int i = this.mExifOffset;
            if (i != 0) {
                copy(byteOrderedDataInputStream, byteOrderedDataOutputStream2, ((i - ((bArr.length + 4) + bArr2.length)) - 4) - 4);
                byteOrderedDataInputStream.skipBytes(4);
                byteOrderedDataInputStream.skipBytes(byteOrderedDataInputStream.readInt());
                writeExifSegment(byteOrderedDataOutputStream2);
            } else {
                byte[] bArr3 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr3) != 4) {
                    throw new java.io.IOException("Encountered invalid length while parsing WebP chunk type");
                }
                byte[] bArr4 = WEBP_CHUNK_TYPE_VP8X;
                if (java.util.Arrays.equals(bArr3, bArr4)) {
                    int readInt = byteOrderedDataInputStream.readInt();
                    boolean z = true;
                    byte[] bArr5 = new byte[readInt % 2 == 1 ? readInt + 1 : readInt];
                    byteOrderedDataInputStream.read(bArr5);
                    byte b = (byte) (bArr5[0] | 8);
                    bArr5[0] = b;
                    if (((b >> 1) & 1) != 1) {
                        z = false;
                    }
                    byteOrderedDataOutputStream2.write(bArr4);
                    byteOrderedDataOutputStream2.writeInt(readInt);
                    byteOrderedDataOutputStream2.write(bArr5);
                    if (z) {
                        copyChunksUpToGivenChunkType(byteOrderedDataInputStream, byteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_ANIM, null);
                        while (true) {
                            byte[] bArr6 = new byte[4];
                            inputStream.read(bArr6);
                            if (!java.util.Arrays.equals(bArr6, WEBP_CHUNK_TYPE_ANMF)) {
                                break;
                            } else {
                                copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream2, bArr6);
                            }
                        }
                        writeExifSegment(byteOrderedDataOutputStream2);
                    } else {
                        copyChunksUpToGivenChunkType(byteOrderedDataInputStream, byteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_VP8, WEBP_CHUNK_TYPE_VP8L);
                        writeExifSegment(byteOrderedDataOutputStream2);
                    }
                } else if (java.util.Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8) || java.util.Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                    throw new java.io.IOException("WebP files with only VP8 or VP8L chunks are currently not supported");
                }
            }
            copy(byteOrderedDataInputStream, byteOrderedDataOutputStream2);
            int size = byteArrayOutputStream.size();
            byte[] bArr7 = WEBP_SIGNATURE_2;
            byteOrderedDataOutputStream.writeInt(size + bArr7.length);
            byteOrderedDataOutputStream.write(bArr7);
            byteArrayOutputStream.writeTo(byteOrderedDataOutputStream);
            closeQuietly(byteArrayOutputStream);
        } catch (java.lang.Exception e2) {
            e = e2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            throw new java.io.IOException("Failed to save WebP file", e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            closeQuietly(byteArrayOutputStream2);
            throw th;
        }
    }

    private void setThumbnailData(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.io.IOException {
        java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute> hashMap = this.mAttributes[4];
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = hashMap.get(TAG_COMPRESSION);
        if (exifAttribute == null) {
            this.mThumbnailCompression = 6;
            handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        this.mThumbnailCompression = intValue;
        if (intValue != 1) {
            if (intValue == 6) {
                handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
                return;
            } else if (intValue != 7) {
                return;
            }
        }
        if (isSupportedDataType(hashMap)) {
            handleThumbnailFromStrips(byteOrderedDataInputStream, hashMap);
        }
    }

    private static boolean startsWith(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private void swapBasedOnImageSize(int i, int i2) throws java.io.IOException {
        if (this.mAttributes[i].isEmpty() || this.mAttributes[i2].isEmpty()) {
            return;
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[i].get(TAG_IMAGE_LENGTH);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[i].get(TAG_IMAGE_WIDTH);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute3 = this.mAttributes[i2].get(TAG_IMAGE_LENGTH);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute4 = this.mAttributes[i2].get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null || exifAttribute3 == null || exifAttribute4 == null) {
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
        int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
        if (intValue >= intValue3 || intValue2 >= intValue4) {
            return;
        }
        java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute>[] hashMapArr = this.mAttributes;
        java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute> hashMap = hashMapArr[i];
        hashMapArr[i] = hashMapArr[i2];
        hashMapArr[i2] = hashMap;
    }

    private void updateImageSizeValues(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifAttribute createUShort;
        androidx.exifinterface.media.ExifInterface.ExifAttribute createUShort2;
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[i].get(TAG_DEFAULT_CROP_SIZE);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[i].get(TAG_RW2_SENSOR_TOP_BORDER);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute3 = this.mAttributes[i].get(TAG_RW2_SENSOR_LEFT_BORDER);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute4 = this.mAttributes[i].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute5 = this.mAttributes[i].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (exifAttribute == null) {
            if (exifAttribute2 == null || exifAttribute3 == null || exifAttribute4 == null || exifAttribute5 == null) {
                retrieveJpegImageSize(byteOrderedDataInputStream, i);
                return;
            }
            int intValue = exifAttribute2.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute5.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute3.getIntValue(this.mExifByteOrder);
            if (intValue2 <= intValue || intValue3 <= intValue4) {
                return;
            }
            androidx.exifinterface.media.ExifInterface.ExifAttribute createUShort3 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
            androidx.exifinterface.media.ExifInterface.ExifAttribute createUShort4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
            this.mAttributes[i].put(TAG_IMAGE_LENGTH, createUShort3);
            this.mAttributes[i].put(TAG_IMAGE_WIDTH, createUShort4);
            return;
        }
        if (exifAttribute.format == 5) {
            androidx.exifinterface.media.ExifInterface.Rational[] rationalArr = (androidx.exifinterface.media.ExifInterface.Rational[]) exifAttribute.getValue(this.mExifByteOrder);
            if (rationalArr == null || rationalArr.length != 2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Invalid crop size values. cropSize=");
                sb.append(java.util.Arrays.toString(rationalArr));
                return;
            }
            createUShort = androidx.exifinterface.media.ExifInterface.ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
            createUShort2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
        } else {
            int[] iArr = (int[]) exifAttribute.getValue(this.mExifByteOrder);
            if (iArr == null || iArr.length != 2) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Invalid crop size values. cropSize=");
                sb2.append(java.util.Arrays.toString(iArr));
                return;
            }
            createUShort = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
            createUShort2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
        }
        this.mAttributes[i].put(TAG_IMAGE_WIDTH, createUShort);
        this.mAttributes[i].put(TAG_IMAGE_LENGTH, createUShort2);
    }

    private void validateImages() throws java.io.IOException {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
        if (exifAttribute != null && exifAttribute2 != null) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, exifAttribute);
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, exifAttribute2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute>[] hashMapArr = this.mAttributes;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new java.util.HashMap<>();
        }
        isThumbnail(this.mAttributes[4]);
    }

    private int writeExifSegment(androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr = EXIF_TAGS;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (androidx.exifinterface.media.ExifInterface.ExifTag exifTag : EXIF_POINTER_TAGS) {
            removeAttribute(exifTag.name);
        }
        removeAttribute(JPEG_INTERCHANGE_FORMAT_TAG.name);
        removeAttribute(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name);
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            for (java.lang.Object obj : this.mAttributes[i].entrySet().toArray()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.mAttributes[i].remove(entry.getKey());
                }
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(this.mThumbnailLength, this.mExifByteOrder));
        }
        for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute>> it = this.mAttributes[i2].entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int size = it.next().getValue().size();
                if (size > 4) {
                    i3 += size;
                }
            }
            iArr2[i2] = iArr2[i2] + i3;
        }
        int i4 = 8;
        for (int i5 = 0; i5 < EXIF_TAGS.length; i5++) {
            if (!this.mAttributes[i5].isEmpty()) {
                iArr[i5] = i4;
                i4 += (this.mAttributes[i5].size() * 12) + 2 + 4 + iArr2[i5];
            }
        }
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(i4, this.mExifByteOrder));
            this.mThumbnailOffset = this.mExifOffset + i4;
            i4 += this.mThumbnailLength;
        }
        if (this.mMimeType == 4) {
            i4 += 8;
        }
        if (DEBUG) {
            for (int i6 = 0; i6 < EXIF_TAGS.length; i6++) {
                java.lang.String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", java.lang.Integer.valueOf(i6), java.lang.Integer.valueOf(iArr[i6]), java.lang.Integer.valueOf(this.mAttributes[i6].size()), java.lang.Integer.valueOf(iArr2[i6]), java.lang.Integer.valueOf(i4));
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(iArr[1], this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(iArr[2], this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(iArr[3], this.mExifByteOrder));
        }
        int i7 = this.mMimeType;
        if (i7 == 4) {
            byteOrderedDataOutputStream.writeUnsignedShort(i4);
            byteOrderedDataOutputStream.write(IDENTIFIER_EXIF_APP1);
        } else if (i7 == 13) {
            byteOrderedDataOutputStream.writeInt(i4);
            byteOrderedDataOutputStream.write(PNG_CHUNK_TYPE_EXIF);
        } else if (i7 == 14) {
            byteOrderedDataOutputStream.write(WEBP_CHUNK_TYPE_EXIF);
            byteOrderedDataOutputStream.writeInt(i4);
        }
        byteOrderedDataOutputStream.writeShort(this.mExifByteOrder == java.nio.ByteOrder.BIG_ENDIAN ? BYTE_ALIGN_MM : BYTE_ALIGN_II);
        byteOrderedDataOutputStream.setByteOrder(this.mExifByteOrder);
        byteOrderedDataOutputStream.writeUnsignedShort(42);
        byteOrderedDataOutputStream.writeUnsignedInt(8L);
        for (int i8 = 0; i8 < EXIF_TAGS.length; i8++) {
            if (!this.mAttributes[i8].isEmpty()) {
                byteOrderedDataOutputStream.writeUnsignedShort(this.mAttributes[i8].size());
                int size2 = iArr[i8] + 2 + (this.mAttributes[i8].size() * 12) + 4;
                for (java.util.Map.Entry<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute> entry2 : this.mAttributes[i8].entrySet()) {
                    int i9 = sExifTagMapsForWriting[i8].get(entry2.getKey()).number;
                    androidx.exifinterface.media.ExifInterface.ExifAttribute value = entry2.getValue();
                    int size3 = value.size();
                    byteOrderedDataOutputStream.writeUnsignedShort(i9);
                    byteOrderedDataOutputStream.writeUnsignedShort(value.format);
                    byteOrderedDataOutputStream.writeInt(value.numberOfComponents);
                    if (size3 > 4) {
                        byteOrderedDataOutputStream.writeUnsignedInt(size2);
                        size2 += size3;
                    } else {
                        byteOrderedDataOutputStream.write(value.bytes);
                        if (size3 < 4) {
                            while (size3 < 4) {
                                byteOrderedDataOutputStream.writeByte(0);
                                size3++;
                            }
                        }
                    }
                }
                if (i8 != 0 || this.mAttributes[4].isEmpty()) {
                    byteOrderedDataOutputStream.writeUnsignedInt(0L);
                } else {
                    byteOrderedDataOutputStream.writeUnsignedInt(iArr[4]);
                }
                java.util.Iterator<java.util.Map.Entry<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute>> it2 = this.mAttributes[i8].entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = it2.next().getValue().bytes;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.mHasThumbnail) {
            byteOrderedDataOutputStream.write(getThumbnailBytes());
        }
        if (this.mMimeType == 14 && i4 % 2 == 1) {
            byteOrderedDataOutputStream.writeByte(0);
        }
        byteOrderedDataOutputStream.setByteOrder(java.nio.ByteOrder.BIG_ENDIAN);
        return i4;
    }

    public void flipHorizontally() {
        int i = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i = 2;
                break;
            case 2:
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 5;
                break;
            case 7:
                i = 8;
                break;
            case 8:
                i = 7;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, java.lang.Integer.toString(i));
    }

    public void flipVertically() {
        int i = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i = 4;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                break;
            case 5:
                i = 8;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 6;
                break;
            case 8:
                i = 5;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, java.lang.Integer.toString(i));
    }

    public double getAltitude(double d) {
        double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            return d;
        }
        return attributeDouble * (attributeInt != 1 ? 1 : -1);
    }

    @androidx.annotation.Nullable
    public java.lang.String getAttribute(@androidx.annotation.NonNull java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            if (!sTagSetForCompatibility.contains(str)) {
                return exifAttribute.getStringValue(this.mExifByteOrder);
            }
            if (str.equals(TAG_GPS_TIMESTAMP)) {
                int i = exifAttribute.format;
                if (i != 5 && i != 10) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("GPS Timestamp format is not rational. format=");
                    sb.append(exifAttribute.format);
                    return null;
                }
                androidx.exifinterface.media.ExifInterface.Rational[] rationalArr = (androidx.exifinterface.media.ExifInterface.Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 3) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Invalid GPS Timestamp array. array=");
                    sb2.append(java.util.Arrays.toString(rationalArr));
                    return null;
                }
                androidx.exifinterface.media.ExifInterface.Rational rational = rationalArr[0];
                androidx.exifinterface.media.ExifInterface.Rational rational2 = rationalArr[1];
                androidx.exifinterface.media.ExifInterface.Rational rational3 = rationalArr[2];
                return java.lang.String.format("%02d:%02d:%02d", java.lang.Integer.valueOf((int) (rational.numerator / rational.denominator)), java.lang.Integer.valueOf((int) (rational2.numerator / rational2.denominator)), java.lang.Integer.valueOf((int) (rational3.numerator / rational3.denominator)));
            }
            try {
                return java.lang.Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public byte[] getAttributeBytes(@androidx.annotation.NonNull java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            return exifAttribute.bytes;
        }
        return null;
    }

    public double getAttributeDouble(@androidx.annotation.NonNull java.lang.String str, double d) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute == null) {
            return d;
        }
        try {
            return exifAttribute.getDoubleValue(this.mExifByteOrder);
        } catch (java.lang.NumberFormatException unused) {
            return d;
        }
    }

    public int getAttributeInt(@androidx.annotation.NonNull java.lang.String str, int i) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute == null) {
            return i;
        }
        try {
            return exifAttribute.getIntValue(this.mExifByteOrder);
        } catch (java.lang.NumberFormatException unused) {
            return i;
        }
    }

    @androidx.annotation.Nullable
    public long[] getAttributeRange(@androidx.annotation.NonNull java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        if (this.mModified) {
            throw new java.lang.IllegalStateException("The underlying file has been modified since being parsed");
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            return new long[]{exifAttribute.bytesOffset, exifAttribute.bytes.length};
        }
        return null;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public long getDateTime() {
        return parseDateTime(getAttribute(TAG_DATETIME), getAttribute(TAG_SUBSEC_TIME));
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public long getDateTimeDigitized() {
        return parseDateTime(getAttribute(TAG_DATETIME_DIGITIZED), getAttribute(TAG_SUBSEC_TIME_DIGITIZED));
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public long getDateTimeOriginal() {
        return parseDateTime(getAttribute(TAG_DATETIME_ORIGINAL), getAttribute(TAG_SUBSEC_TIME_ORIGINAL));
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public long getGpsDateTime() {
        java.lang.String attribute = getAttribute(TAG_GPS_DATESTAMP);
        java.lang.String attribute2 = getAttribute(TAG_GPS_TIMESTAMP);
        if (attribute != null && attribute2 != null) {
            java.util.regex.Pattern pattern = sNonZeroTimePattern;
            if (pattern.matcher(attribute).matches() || pattern.matcher(attribute2).matches()) {
                try {
                    java.util.Date parse = sFormatter.parse(attribute + ' ' + attribute2, new java.text.ParsePosition(0));
                    if (parse == null) {
                        return -1L;
                    }
                    return parse.getTime();
                } catch (java.lang.IllegalArgumentException unused) {
                }
            }
        }
        return -1L;
    }

    @java.lang.Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    @androidx.annotation.Nullable
    public double[] getLatLong() {
        java.lang.String attribute = getAttribute(TAG_GPS_LATITUDE);
        java.lang.String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        java.lang.String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        java.lang.String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{convertRationalLatLonToDouble(attribute, attribute2), convertRationalLatLonToDouble(attribute3, attribute4)};
        } catch (java.lang.IllegalArgumentException unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Latitude/longitude values are not parsable. ");
            sb.append(java.lang.String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", attribute, attribute2, attribute3, attribute4));
            return null;
        }
    }

    public int getRotationDegrees() {
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @androidx.annotation.Nullable
    public byte[] getThumbnail() {
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    @androidx.annotation.Nullable
    public android.graphics.Bitmap getThumbnailBitmap() {
        if (!this.mHasThumbnail) {
            return null;
        }
        if (this.mThumbnailBytes == null) {
            this.mThumbnailBytes = getThumbnailBytes();
        }
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return android.graphics.BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
        }
        if (i == 1) {
            int length = this.mThumbnailBytes.length / 3;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                byte[] bArr = this.mThumbnailBytes;
                int i3 = i2 * 3;
                iArr[i2] = (bArr[i3] << 16) + 0 + (bArr[i3 + 1] << 8) + bArr[i3 + 2];
            }
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[4].get(TAG_IMAGE_LENGTH);
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[4].get(TAG_IMAGE_WIDTH);
            if (exifAttribute != null && exifAttribute2 != null) {
                return android.graphics.Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.mExifByteOrder), exifAttribute.getIntValue(this.mExifByteOrder), android.graphics.Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0057 A[Catch: all -> 0x008a, Exception -> 0x00a3, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x00a3, all -> 0x008a, blocks: (B:17:0x0057, B:20:0x0067, B:22:0x0073, B:27:0x007e, B:28:0x0083, B:29:0x0084, B:30:0x0089, B:31:0x008f, B:32:0x0094), top: B:15:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f A[Catch: all -> 0x008a, Exception -> 0x00a3, TryCatch #6 {Exception -> 0x00a3, all -> 0x008a, blocks: (B:17:0x0057, B:20:0x0067, B:22:0x0073, B:27:0x007e, B:28:0x0083, B:29:0x0084, B:30:0x0089, B:31:0x008f, B:32:0x0094), top: B:15:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getThumbnailBytes() {
        java.lang.Throwable th;
        java.io.FileDescriptor fileDescriptor;
        java.io.InputStream inputStream;
        java.lang.Throwable th2;
        java.io.InputStream inputStream2 = null;
        if (!this.mHasThumbnail) {
            return null;
        }
        byte[] bArr = this.mThumbnailBytes;
        if (bArr != null) {
            return bArr;
        }
        try {
            inputStream = this.mAssetInputStream;
        } catch (java.lang.Exception unused) {
            inputStream = null;
            fileDescriptor = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileDescriptor = null;
        }
        try {
            if (inputStream != null) {
                try {
                    if (!inputStream.markSupported()) {
                        closeQuietly(inputStream);
                        return null;
                    }
                    inputStream.reset();
                } catch (java.lang.Exception unused2) {
                    fileDescriptor = null;
                    closeQuietly(inputStream);
                    if (fileDescriptor != null) {
                    }
                    return null;
                } catch (java.lang.Throwable th4) {
                    inputStream2 = inputStream;
                    th = th4;
                    fileDescriptor = null;
                    closeQuietly(inputStream2);
                    if (fileDescriptor == null) {
                    }
                }
            } else {
                if (this.mFilename == null) {
                    java.io.FileDescriptor fileDescriptor2 = this.mSeekableFileDescriptor;
                    if (fileDescriptor2 != null) {
                        java.io.FileDescriptor dup = android.system.Os.dup(fileDescriptor2);
                        try {
                            android.system.Os.lseek(dup, 0L, android.system.OsConstants.SEEK_SET);
                            fileDescriptor = dup;
                            inputStream = new java.io.FileInputStream(dup);
                        } catch (java.lang.Exception unused3) {
                            fileDescriptor = dup;
                            inputStream = null;
                            closeQuietly(inputStream);
                            if (fileDescriptor != null) {
                                closeFileDescriptor(fileDescriptor);
                            }
                            return null;
                        } catch (java.lang.Throwable th5) {
                            th2 = th5;
                            fileDescriptor = dup;
                            th = th2;
                            closeQuietly(inputStream2);
                            if (fileDescriptor == null) {
                                throw th;
                            }
                            closeFileDescriptor(fileDescriptor);
                            throw th;
                        }
                    } else {
                        inputStream = null;
                        fileDescriptor = null;
                    }
                    if (inputStream != null) {
                        throw new java.io.FileNotFoundException();
                    }
                    if (inputStream.skip(this.mThumbnailOffset) != this.mThumbnailOffset) {
                        throw new java.io.IOException("Corrupted image");
                    }
                    byte[] bArr2 = new byte[this.mThumbnailLength];
                    if (inputStream.read(bArr2) != this.mThumbnailLength) {
                        throw new java.io.IOException("Corrupted image");
                    }
                    this.mThumbnailBytes = bArr2;
                    closeQuietly(inputStream);
                    if (fileDescriptor != null) {
                        closeFileDescriptor(fileDescriptor);
                    }
                    return bArr2;
                }
                inputStream = new java.io.FileInputStream(this.mFilename);
            }
            if (inputStream != null) {
            }
        } catch (java.lang.Exception unused4) {
            closeQuietly(inputStream);
            if (fileDescriptor != null) {
            }
            return null;
        } catch (java.lang.Throwable th6) {
            th2 = th6;
            inputStream2 = inputStream;
            th = th2;
            closeQuietly(inputStream2);
            if (fileDescriptor == null) {
            }
        }
        fileDescriptor = null;
    }

    @androidx.annotation.Nullable
    public long[] getThumbnailRange() {
        if (this.mModified) {
            throw new java.lang.IllegalStateException("The underlying file has been modified since being parsed");
        }
        if (!this.mHasThumbnail) {
            return null;
        }
        if (!this.mHasThumbnailStrips || this.mAreThumbnailStripsConsecutive) {
            return new long[]{this.mThumbnailOffset, this.mThumbnailLength};
        }
        return null;
    }

    public boolean hasAttribute(@androidx.annotation.NonNull java.lang.String str) {
        return getExifAttribute(str) != null;
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        return attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
    }

    public boolean isThumbnailCompressed() {
        if (!this.mHasThumbnail) {
            return false;
        }
        int i = this.mThumbnailCompression;
        return i == 6 || i == 7;
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, java.lang.Integer.toString(1));
    }

    public void rotate(int i) {
        if (i % 90 != 0) {
            throw new java.lang.IllegalArgumentException("degree should be a multiple of 90");
        }
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        java.util.List<java.lang.Integer> list = ROTATION_ORDER;
        if (list.contains(java.lang.Integer.valueOf(attributeInt))) {
            int indexOf = (list.indexOf(java.lang.Integer.valueOf(attributeInt)) + (i / 90)) % 4;
            r4 = list.get(indexOf + (indexOf < 0 ? 4 : 0)).intValue();
        } else {
            java.util.List<java.lang.Integer> list2 = FLIPPED_ROTATION_ORDER;
            if (list2.contains(java.lang.Integer.valueOf(attributeInt))) {
                int indexOf2 = (list2.indexOf(java.lang.Integer.valueOf(attributeInt)) + (i / 90)) % 4;
                r4 = list2.get(indexOf2 + (indexOf2 < 0 ? 4 : 0)).intValue();
            }
        }
        setAttribute(TAG_ORIENTATION, java.lang.Integer.toString(r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b3 A[Catch: all -> 0x0107, Exception -> 0x010a, TryCatch #13 {Exception -> 0x010a, all -> 0x0107, blocks: (B:22:0x00aa, B:24:0x00b3, B:25:0x00cd, B:62:0x00bb, B:64:0x00bf), top: B:21:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc A[Catch: all -> 0x00fb, Exception -> 0x00fd, TryCatch #11 {Exception -> 0x00fd, all -> 0x00fb, blocks: (B:30:0x00d7, B:32:0x00dc, B:37:0x00e4, B:40:0x00ec), top: B:29:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bb A[Catch: all -> 0x0107, Exception -> 0x010a, TryCatch #13 {Exception -> 0x010a, all -> 0x0107, blocks: (B:22:0x00aa, B:24:0x00b3, B:25:0x00cd, B:62:0x00bb, B:64:0x00bf), top: B:21:0x00aa }] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void saveAttributes() throws java.io.IOException {
        ?? r6;
        java.io.File file;
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2;
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.FileOutputStream fileOutputStream;
        java.io.BufferedInputStream bufferedInputStream;
        int i;
        if (!isSupportedFormatForSavingAttributes()) {
            throw new java.io.IOException("ExifInterface only supports saving attributes on JPEG, PNG, or WebP formats.");
        }
        if (this.mSeekableFileDescriptor == null && this.mFilename == null) {
            throw new java.io.IOException("ExifInterface does not support saving attributes for the current input.");
        }
        this.mModified = true;
        this.mThumbnailBytes = getThumbnail();
        java.io.InputStream inputStream = null;
        java.io.File file2 = this.mFilename != null ? new java.io.File(this.mFilename) : null;
        try {
            try {
                try {
                    try {
                        if (this.mFilename != null) {
                            file = new java.io.File(this.mFilename + com.baidu.mobads.sdk.internal.al.k);
                            if (!file2.renameTo(file)) {
                                throw new java.io.IOException("Couldn't rename to " + file.getAbsolutePath());
                            }
                            fileInputStream = null;
                        } else if (this.mSeekableFileDescriptor != null) {
                            file = java.io.File.createTempFile("temp", "tmp");
                            android.system.Os.lseek(this.mSeekableFileDescriptor, 0L, android.system.OsConstants.SEEK_SET);
                            fileInputStream = new java.io.FileInputStream(this.mSeekableFileDescriptor);
                            try {
                                r6 = new java.io.FileOutputStream(file);
                                try {
                                    copy(fileInputStream, r6);
                                    fileInputStream2 = r6;
                                    closeQuietly(fileInputStream);
                                    closeQuietly(fileInputStream2);
                                    java.io.FileInputStream fileInputStream3 = new java.io.FileInputStream(file);
                                    if (this.mFilename == null) {
                                        fileOutputStream = new java.io.FileOutputStream(this.mFilename);
                                    } else {
                                        java.io.FileDescriptor fileDescriptor = this.mSeekableFileDescriptor;
                                        if (fileDescriptor != null) {
                                            android.system.Os.lseek(fileDescriptor, 0L, android.system.OsConstants.SEEK_SET);
                                            fileOutputStream = new java.io.FileOutputStream(this.mSeekableFileDescriptor);
                                        } else {
                                            fileOutputStream = null;
                                        }
                                    }
                                    bufferedInputStream = new java.io.BufferedInputStream(fileInputStream3);
                                    bufferedOutputStream = new java.io.BufferedOutputStream(fileOutputStream);
                                    i = this.mMimeType;
                                    if (i != 4) {
                                        saveJpegAttributes(bufferedInputStream, bufferedOutputStream);
                                    } else if (i == 13) {
                                        savePngAttributes(bufferedInputStream, bufferedOutputStream);
                                    } else if (i == 14) {
                                        saveWebpAttributes(bufferedInputStream, bufferedOutputStream);
                                    }
                                    closeQuietly(bufferedInputStream);
                                    closeQuietly(bufferedOutputStream);
                                    file.delete();
                                    this.mThumbnailBytes = null;
                                    return;
                                } catch (java.lang.Exception e) {
                                    e = e;
                                    inputStream = fileInputStream;
                                    r6 = r6;
                                    try {
                                        throw new java.io.IOException("Failed to copy original file to temp file", e);
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        closeQuietly(inputStream);
                                        closeQuietly(r6);
                                        throw th;
                                    }
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    inputStream = fileInputStream;
                                    closeQuietly(inputStream);
                                    closeQuietly(r6);
                                    throw th;
                                }
                            } catch (java.lang.Exception e2) {
                                e = e2;
                                r6 = 0;
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                r6 = 0;
                            }
                        } else {
                            file = null;
                            fileInputStream = null;
                        }
                        i = this.mMimeType;
                        if (i != 4) {
                        }
                        closeQuietly(bufferedInputStream);
                        closeQuietly(bufferedOutputStream);
                        file.delete();
                        this.mThumbnailBytes = null;
                        return;
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        inputStream = bufferedInputStream;
                        try {
                            if (this.mFilename == null || file.renameTo(file2)) {
                                throw new java.io.IOException("Failed to save new file", e);
                            }
                            throw new java.io.IOException("Couldn't restore original file: " + file2.getAbsolutePath());
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            closeQuietly(inputStream);
                            closeQuietly(bufferedOutputStream);
                            file.delete();
                            throw th;
                        }
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        inputStream = bufferedInputStream;
                        closeQuietly(inputStream);
                        closeQuietly(bufferedOutputStream);
                        file.delete();
                        throw th;
                    }
                    bufferedOutputStream = new java.io.BufferedOutputStream(fileOutputStream);
                } catch (java.lang.Exception e4) {
                    e = e4;
                    bufferedOutputStream = null;
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    bufferedOutputStream = null;
                }
                java.io.FileInputStream fileInputStream32 = new java.io.FileInputStream(file);
                if (this.mFilename == null) {
                }
                bufferedInputStream = new java.io.BufferedInputStream(fileInputStream32);
            } catch (java.lang.Exception e5) {
                e = e5;
                bufferedOutputStream = null;
            } catch (java.lang.Throwable th7) {
                th = th7;
                bufferedOutputStream = null;
            }
            fileInputStream2 = fileInputStream;
            closeQuietly(fileInputStream);
            closeQuietly(fileInputStream2);
        } catch (java.lang.Exception e6) {
            e = e6;
            r6 = 0;
        } catch (java.lang.Throwable th8) {
            th = th8;
            r6 = 0;
        }
    }

    public void setAltitude(double d) {
        java.lang.String str = d >= 0.0d ? "0" : "1";
        setAttribute(TAG_GPS_ALTITUDE, new androidx.exifinterface.media.ExifInterface.Rational(java.lang.Math.abs(d)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, str);
    }

    public void setAttribute(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        androidx.exifinterface.media.ExifInterface.ExifTag exifTag;
        int i;
        java.lang.String str3 = str;
        java.lang.String str4 = str2;
        if (str3 == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        if (TAG_ISO_SPEED_RATINGS.equals(str3)) {
            str3 = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        int i2 = 2;
        int i3 = 1;
        if (str4 != null && sTagSetForCompatibility.contains(str3)) {
            if (str3.equals(TAG_GPS_TIMESTAMP)) {
                java.util.regex.Matcher matcher = sGpsTimestampPattern.matcher(str4);
                if (!matcher.find()) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Invalid value for ");
                    sb.append(str3);
                    sb.append(" : ");
                    sb.append(str4);
                    return;
                }
                str4 = java.lang.Integer.parseInt(matcher.group(1)) + "/1," + java.lang.Integer.parseInt(matcher.group(2)) + "/1," + java.lang.Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    str4 = new androidx.exifinterface.media.ExifInterface.Rational(java.lang.Double.parseDouble(str2)).toString();
                } catch (java.lang.NumberFormatException unused) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Invalid value for ");
                    sb2.append(str3);
                    sb2.append(" : ");
                    sb2.append(str4);
                    return;
                }
            }
        }
        int i4 = 0;
        while (i4 < EXIF_TAGS.length) {
            if ((i4 != 4 || this.mHasThumbnail) && (exifTag = sExifTagMapsForWriting[i4].get(str3)) != null) {
                if (str4 != null) {
                    android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat = guessDataFormat(str4);
                    if (exifTag.primaryFormat == ((java.lang.Integer) guessDataFormat.first).intValue() || exifTag.primaryFormat == ((java.lang.Integer) guessDataFormat.second).intValue()) {
                        i = exifTag.primaryFormat;
                    } else {
                        int i5 = exifTag.secondaryFormat;
                        if (i5 == -1 || !(i5 == ((java.lang.Integer) guessDataFormat.first).intValue() || exifTag.secondaryFormat == ((java.lang.Integer) guessDataFormat.second).intValue())) {
                            int i6 = exifTag.primaryFormat;
                            if (i6 == i3 || i6 == 7 || i6 == i2) {
                                i = i6;
                            } else if (DEBUG) {
                                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                                sb3.append("Given tag (");
                                sb3.append(str3);
                                sb3.append(") value didn't match with one of expected formats: ");
                                java.lang.String[] strArr = IFD_FORMAT_NAMES;
                                sb3.append(strArr[exifTag.primaryFormat]);
                                sb3.append(exifTag.secondaryFormat == -1 ? "" : ", " + strArr[exifTag.secondaryFormat]);
                                sb3.append(" (guess: ");
                                sb3.append(strArr[((java.lang.Integer) guessDataFormat.first).intValue()]);
                                sb3.append(((java.lang.Integer) guessDataFormat.second).intValue() != -1 ? ", " + strArr[((java.lang.Integer) guessDataFormat.second).intValue()] : "");
                                sb3.append(")");
                            }
                        } else {
                            i = exifTag.secondaryFormat;
                        }
                    }
                    switch (i) {
                        case 1:
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createByte(str4));
                            break;
                        case 2:
                        case 7:
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createString(str4));
                            break;
                        case 3:
                            java.lang.String[] split = str4.split(",", -1);
                            int[] iArr = new int[split.length];
                            for (int i7 = 0; i7 < split.length; i7++) {
                                iArr[i7] = java.lang.Integer.parseInt(split[i7]);
                            }
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(iArr, this.mExifByteOrder));
                            break;
                        case 4:
                            java.lang.String[] split2 = str4.split(",", -1);
                            long[] jArr = new long[split2.length];
                            for (int i8 = 0; i8 < split2.length; i8++) {
                                jArr[i8] = java.lang.Long.parseLong(split2[i8]);
                            }
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(jArr, this.mExifByteOrder));
                            break;
                        case 5:
                            java.lang.String[] split3 = str4.split(",", -1);
                            androidx.exifinterface.media.ExifInterface.Rational[] rationalArr = new androidx.exifinterface.media.ExifInterface.Rational[split3.length];
                            for (int i9 = 0; i9 < split3.length; i9++) {
                                java.lang.String[] split4 = split3[i9].split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, -1);
                                rationalArr[i9] = new androidx.exifinterface.media.ExifInterface.Rational((long) java.lang.Double.parseDouble(split4[0]), (long) java.lang.Double.parseDouble(split4[1]));
                            }
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createURational(rationalArr, this.mExifByteOrder));
                            break;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            if (DEBUG) {
                                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                                sb4.append("Data format isn't one of expected formats: ");
                                sb4.append(i);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            java.lang.String[] split5 = str4.split(",", -1);
                            int[] iArr2 = new int[split5.length];
                            for (int i10 = 0; i10 < split5.length; i10++) {
                                iArr2[i10] = java.lang.Integer.parseInt(split5[i10]);
                            }
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createSLong(iArr2, this.mExifByteOrder));
                            break;
                        case 10:
                            java.lang.String[] split6 = str4.split(",", -1);
                            androidx.exifinterface.media.ExifInterface.Rational[] rationalArr2 = new androidx.exifinterface.media.ExifInterface.Rational[split6.length];
                            int i11 = 0;
                            while (i11 < split6.length) {
                                java.lang.String[] split7 = split6[i11].split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, -1);
                                rationalArr2[i11] = new androidx.exifinterface.media.ExifInterface.Rational((long) java.lang.Double.parseDouble(split7[0]), (long) java.lang.Double.parseDouble(split7[i3]));
                                i11++;
                                i3 = 1;
                            }
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createSRational(rationalArr2, this.mExifByteOrder));
                            break;
                        case 12:
                            java.lang.String[] split8 = str4.split(",", -1);
                            double[] dArr = new double[split8.length];
                            for (int i12 = 0; i12 < split8.length; i12++) {
                                dArr[i12] = java.lang.Double.parseDouble(split8[i12]);
                            }
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createDouble(dArr, this.mExifByteOrder));
                            break;
                    }
                } else {
                    this.mAttributes[i4].remove(str3);
                }
            }
            i4++;
            i2 = 2;
            i3 = 1;
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public void setDateTime(long j) {
        setAttribute(TAG_DATETIME, sFormatter.format(new java.util.Date(j)));
        setAttribute(TAG_SUBSEC_TIME, java.lang.Long.toString(j % 1000));
    }

    public void setGpsInfo(android.location.Location location) {
        if (location == null) {
            return;
        }
        setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
        setLatLong(location.getLatitude(), location.getLongitude());
        setAltitude(location.getAltitude());
        setAttribute(TAG_GPS_SPEED_REF, "K");
        setAttribute(TAG_GPS_SPEED, new androidx.exifinterface.media.ExifInterface.Rational((location.getSpeed() * java.util.concurrent.TimeUnit.HOURS.toSeconds(1L)) / 1000.0f).toString());
        java.lang.String[] split = sFormatter.format(new java.util.Date(location.getTime())).split("\\s+", -1);
        setAttribute(TAG_GPS_DATESTAMP, split[0]);
        setAttribute(TAG_GPS_TIMESTAMP, split[1]);
    }

    public void setLatLong(double d, double d2) {
        if (d < -90.0d || d > 90.0d || java.lang.Double.isNaN(d)) {
            throw new java.lang.IllegalArgumentException("Latitude value " + d + " is not valid.");
        }
        if (d2 < -180.0d || d2 > 180.0d || java.lang.Double.isNaN(d2)) {
            throw new java.lang.IllegalArgumentException("Longitude value " + d2 + " is not valid.");
        }
        setAttribute(TAG_GPS_LATITUDE_REF, d >= 0.0d ? "N" : LATITUDE_SOUTH);
        setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(java.lang.Math.abs(d)));
        setAttribute(TAG_GPS_LONGITUDE_REF, d2 >= 0.0d ? LONGITUDE_EAST : LONGITUDE_WEST);
        setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(java.lang.Math.abs(d2)));
    }
}
