package futuristicbio.biometrics;

public class RealScan_JNI {
    
    public boolean WINDOW = true;
    
    public static class RSDeviceInfo {
    //  int deviceType;
        public int deviceType;
    //  char productName[16];
        public String productName;
    //  char deviceID[16];
        public String deviceID;
    //  char firmwareVersion[16];
        public String firmwareVersion;
    //  char hardwareVersion[16];
        public String hardwareVersion;
    //  int reserved[32];
        public int reserved[];  
    }
    
    public static class RSImageInfo {
        public byte pbyImgBuf[];
        public int imageWidth;
        public int imageHeight;
    }
    
    public static class RSLFDInfo {
        public boolean  isActivated;
        public float    th1;
        public float    th2;
        public float    th3;
        public float    th4;
    }
    
    public static class RSOverlayCross {
//      POINT       centerPos;
        public int  centerPos_x;
        public int  centerPos_y;
//      int         rangeX;
        public int  rangeX;
//      int         rangeY;
        public int  rangeY;
//      COLORREF    color;
        public long color;
//      int         width;
        public int  width;
//      int         reserved[16];
        public int  reserved[];
    }
    
    public static class RSOverlayLine {
//      POINT       startPos;
        public int  startPos_x;
        public int  startPos_y;
//      POINT       endPos;
        public int  endPos_x;
        public int  endPos_y;
//      COLORREF    color;
        public long color;
//      int         width;
        public int  width;
//      int         reserved[16];
        public int  reserved[];
    }
    
    public static class RSOverlayQuadrangle {
//      POINT       pos[4];
        public int  pos_x[] = new int[4];
        public int  pos_y[] = new int[4];
//      COLORREF    color;
        public long color;
//      int         width;
        public int  width;
//      int         reserved[16];
        public int  reserved[];
    }
    
    public static class RSOverlayText {
        int         pos_x;
        int         pos_y;
        int         alignment;
        String      text;
        int         fontSize;
        String      fontName;
        long        color;
        int         reserved[];
    }
    
    public static class RSPoint {
        int x;
        int y;
    }
    
    public static class RSSDKInfo {
//      char product[16];
        public String product;
//      char version[16];
        public String version;
//      char buildDate[16];
        public String buildDate;
//      int reserved[16];
        public int reserved[];
    }
    
    public static class RSSlapInfo {
        public int fingerType;
        public int fingerPosition_x0;
        public int fingerPosition_x1;
        public int fingerPosition_x2;
        public int fingerPosition_x3;
        public int fingerPosition_y0;
        public int fingerPosition_y1;
        public int fingerPosition_y2;
        public int fingerPosition_y3;
        public int imageQuality;
        public int rotation;
        public int reserved[];
    }
    
    public static class RSRect {
        public int startX;
        public int startY;
        public int width;
        public int height;
    }
    
    public static class RSLFDInfo2 {
        public int nResult;
        public int nScore;
    }
    /*
    public static class RSLFDResult {
        public int nNumofFinger;      
        public RSLFDInfo2[]  sLFDInfo = new RSLFDInfo2[RS_LFD_MAX_INFO];
//        public RSLFDInfo2[] sLFDInfo;
    }
*/
    public static class RSLFDResult {
        public int nNumofFinger;      
        public int nResult[] = new int[RS_LFD_MAX_INFO];
        public int nScore[] = new int[RS_LFD_MAX_INFO];        
//        public RSLFDInfo2[] sLFDInfo;
    }
    
    
    public static final int RS_SUCCESS  = 0;
            
    //
    // Generic errors
    //
    public static final int RS_ERR_SDK_UNINITIALIZED            = -10;
    public static final int RS_ERR_SDK_ALREADY_INITIALIZED      = -11;
    public static final int RS_ERR_INSUFFICIENT_HARDWARE        = -12;
    public static final int RS_ERR_INVALID_PARAM                = -13;
    public static final int RS_ERR_MEM_FULL                     = -14;
    public static final int RS_ERR_NOT_YET_SUPPORTED            = -15;
    public static final int RS_ERR_CANNOT_OPEN_FILE             = -16;
    public static final int RS_ERR_CANNOT_READ_FILE             = -17;
    public static final int RS_ERR_CANNOT_WRITE_FILE            = -18;

    //
    // Device related errors
    //
    public static final int RS_ERR_NO_DEVICE                    = -100;
    public static final int RS_ERR_INVALID_DEVICE_INDEX         = -101;
    public static final int RS_ERR_INVALID_HANDLE               = -102;
    public static final int RS_ERR_CANNOT_INIT_DEVICE           = -103;
    public static final int RS_ERR_UNSUPPORTED_DEVICE           = -104;
    public static final int RS_ERR_CANNOT_GET_USB_DEVICE        = -105;
    public static final int RS_ERR_DEVICE_ALREADY_INITIALIZED   = -106;
    public static final int RS_ERR_CANNOT_OPEN_DEVICE           = -107;
    public static final int RS_ERR_CANNOT_WRITE_USB             = -108;
    public static final int RS_ERR_WRITE_USB_TIMEOUT            = -109;
    public static final int RS_ERR_CANNOT_READ_USB              = -110;
    public static final int RS_ERR_READ_USB_TIMEOUT             = -111;
    public static final int RS_ERR_INVALID_CAMERA_MODE          = -112;
    public static final int RS_ERR_UNSUPPORTED_WAV_FORMAT       = -113;
    public static final int RS_ERR_UNSUPPORTED_COMMAND          = -114;
    public static final int RS_ERR_SENSOR_DIRTY                 = -115;
    public static final int RS_ERR_FINGER_EXIST                 = -116;
    public static final int RS_ERR_TOO_STRONG_LIGHT             = -117;
    public static final int RS_ERR_INVALID_DEVICE_CONNECTION    = -124;

    //
    // Capture related errors
    //
    public static final int RS_ERR_INVALID_CAPTURE_MODE         = -200;
    public static final int RS_ERR_CAPTURE_DISABLED             = -201;
    public static final int RS_ERR_CAPTURE_TIMEOUT              = -202;
    public static final int RS_ERR_CAPTURE_ABORTED              = -203;
    public static final int RS_ERR_CAPTURE_CAMERA               = -204;
    public static final int RS_ERR_CAPTURE_NO_PREVIEW           = -205;
    public static final int RS_ERR_ROLL_PART_LIFT               = -206;
    public static final int RS_ERR_ROLL_DIRTY                   = -207;
    public static final int RS_ERR_ROLL_TOO_FAST                = -208;
    public static final int RS_ERR_ROLL_SHIFTED                 = -209;
    public static final int RS_ERR_ROLL_DRY                     = -210;
    public static final int RS_ERR_ROLL_WRONG_DIR               = -211;
    public static final int RS_ERR_CAPTURE_IS_RUNNING           = -212;
    public static final int RS_ERR_CAPTURE_IS_NOT_RUNNING       = -213;
    public static final int RS_ERR_ROLL_TOO_SHORT               = -214;
    public static final int RS_ERR_CANNOT_SEGMENT               = -215;
    public static final int RS_ERR_CANNOT_GET_QUALITY           = -216;
    public static final int RS_ERR_SEGMENT_FEWER_FINGER         = -217;
    public static final int RS_ERR_SEGMENT_WRONG_HAND           = -218;
    public static final int RS_ERR_CANNOT_EXTRACT_TEMPLATE      = -219;
    public static final int RS_ERR_NO_MATCH                     = -220;
    public static final int RS_ERR_ROLL_NO_FINGER               = -221;
    //
    // Viewer related errors
    //
    public static final int RS_ERR_CANNOT_SET_VIEW_WINDOW       = -300;
    public static final int RS_ERR_NO_MORE_OVERLAY              = -301;
    public static final int RS_ERR_INVALID_OVERLAY_HANDLE       = -302;
    public static final int RS_ERR_CANNOT_SHOW_OVERLAY          = -303;
    public static final int RS_ERR_CANNOT_SHOW_PREVIEW          = -304;

    //
    // IO related errors
    //
    public static final int RS_ERR_CANNOT_SET_KEYPAD_CALLBACK   = -400;
    public static final int RS_ERR_CANNOT_MAKE_LCD_DATA         = -401;
    public static final int RS_ERR_INVALID_LCD_DATA             = -402;

    //
    // Warning
    //
    public static final int RS_WRN_FAKE_FINGER              = 133;
    
    //
    // Device type
    //
    public static final int DEVICE_REALSCAN_10          = 0x00;
    public static final int RS_DEVICE_REALSCAN_10F      = 0x01;
    public static final int RS_DEVICE_REALSCAN_D        = 0x10;
    public static final int RS_DEVICE_REALSCAN_DF       = 0x11;
    public static final int RS_DEVICE_REALSCAN_F        = 0x20; 
    public static final int RS_DEVICE_REALSCAN_G10      = 0x30; 
    public static final int RS_DEVICE_REALSCAN_G10F     = 0x31; 
    public static final int RS_DEVICE_REALSCAN_G1       = 0x32;
    public static final int RS_DEVICE_UNKNOWN           = 0xFF;

    //
    // Initialization Mode
    //
    public static final int RS_INIT_HIDE_INIDLG         = 0x01;
    public static final int RS_INIT_SHOW_INIDLG         = 0x02;
    public static final int RS_INIT_FULL                = 0x04;   

    //
    // Capture mode
    //
    public static final int RS_CAPTURE_DISABLED                 = 0x00;
    public static final int RS_CAPTURE_ROLL_FINGER              = 0x01;
    public static final int RS_CAPTURE_FLAT_SINGLE_FINGER       = 0x02;
    public static final int RS_CAPTURE_FLAT_TWO_FINGERS         = 0x03;
    public static final int RS_CAPTURE_FLAT_LEFT_FOUR_FINGERS   = 0x04;
    public static final int RS_CAPTURE_FLAT_RIGHT_FOUR_FINGERS  = 0x05;
    public static final int RS_CAPTURE_FLAT_LEFT_PALM           = 0x06;
    public static final int RS_CAPTURE_FLAT_RIGHT_PALM          = 0x07;
    public static final int RS_CAPTURE_FLAT_SINGLE_FINGER_EX    = 0x09;
    public static final int RS_CAPTURE_FLAT_TWO_FINGERS_EX      = 0x08;
    public static final int RS_CAPTURE_FLAT_LEFT_SIDE_PALM      = 0x10;
    public static final int RS_CAPTURE_FLAT_RIGHT_SIDE_PALM     = 0x11;
    public static final int RS_CAPTURE_FLAT_LEFT_WRITERS_PALM   = 0x12;
    public static final int RS_CAPTURE_FLAT_RIGHT_WRITERS_PALM  = 0x13;
    public static final int RS_CAPTURE_ROLL_FINGER_EX           = 0x30; 
    
        public static final int RS_CAPTURE_FLAT_MANUAL_INI      = 0xfe;
        public static final int RS_CAPTURE_FLAT_MANUAL          = 0xff;
        
        //
    // Capture Direction
    //
        public static final int RS_CAPTURE_DIRECTION_DEFAULT            = 0x00;
        public static final int RS_CAPTURE_DIRECTION_LEFT               = 0x01;
        public static final int RS_CAPTURE_DIRECTION_RIGHT              = 0x02;

    //
    // Options for capturing flat fingers
    //
    public static final int RS_AUTO_SENSITIVITY_NORMAL      = 0x00;
    public static final int RS_AUTO_SENSITIVITY_HIGH        = 0x01;
    public static final int RS_AUTO_SENSITIVITY_HIGHER      = 0x02;
    public static final int RS_AUTO_SENSITIVITY_DISABLED    = 0x03;

    //
    // Roll direction
    //
    public static final int RS_ROLL_DIR_L2R     = 0x00;
    public static final int RS_ROLL_DIR_R2L     = 0x01;
    public static final int RS_ROLL_DIR_AUTO    = 0x02;
    public static final int RS_ROLL_DIR_AUTO_M  = 0x03;

    //
    // Roll profile
    //
    public static final int RS_ROLL_PROFILE_LOW     = 0x01;
    public static final int RS_ROLL_PROFILE_NORMAL  = 0x02;
    public static final int RS_ROLL_PROFILE_HIGH    = 0x03;

    //
    // Text alignment
    //
    public static final int RS_TEXT_ALIGN_LEFT      = 0x00;
    public static final int RS_TEXT_ALIGN_CENTER    = 0x01;
    public static final int RS_TEXT_ALIGN_RIGHT     = 0x02;

    //
    // Beeper pattern
    //
    public static final int RS_BEEP_PATTERN_NONE    = 0;
    public static final int RS_BEEP_PATTERN_1       = 1;    // 1 short beep
    public static final int RS_BEEP_PATTERN_2       = 2;    // 2 short beeps

    //
    // Keypad code
    //
    public static final int RS_REALSCAN10_NO_KEY    = 0x00;
    public static final int RS_REALSCAN10_PLAY_KEY  = 0x20;
    public static final int RS_REALSCAN10_STOP_KEY  = 0x40;
    public static final int RS_REALSCAN10_ALL_KEYS  = 0x7F;

    public static final int RS_REALSCAND_NO_KEY     = 0x00;
    public static final int RS_REALSCAND_KEY_0      = 0x20;
    public static final int RS_REALSCAND_ALL_KEYS   = 0x7F;

    public static final int RS_REALSCANF_NO_KEY     = 0x00; 
    public static final int RS_REALSCANF_UP_KEY     = 0x01; 
    public static final int RS_REALSCANF_DOWN_KEY   = 0x02; 
    public static final int RS_REALSCANF_LEFT_KEY   = 0x04; 
    public static final int RS_REALSCANF_RIGHT_KEY  = 0x08; 
    public static final int RS_REALSCANF_PLAY_KEY   = 0x20; 
    public static final int RS_REALSCANF_STOP_KEY   = 0x40; 
    public static final int RS_REALSCANF_FOOTSWITCH = 0x80; 
    public static final int RS_REALSCANF_ALL_KEYS   = 0xFF; 
    public static final int RS_REALSCANG10_NO_KEY   = 0x00; 
    public static final int RS_REALSCANG10_PLAY_KEY = 0x20; 
    public static final int RS_REALSCANG10_STOP_KEY = 0x40; 
    public static final int RS_REALSCANG10_ALL_KEYS = 0x7F; 
    //
    // Finger Index
    //
    public static final int RS_FINGER_ALL       = 0x00;
    public static final int RS_FINGER_LEFT_LITTLE   = 0x01;
    public static final int RS_FINGER_LEFT_RING = 0x02;
    public static final int RS_FINGER_LEFT_MIDDLE   = 0x03;
    public static final int RS_FINGER_LEFT_INDEX    = 0x04;
    public static final int RS_FINGER_LEFT_THUMB    = 0x05;
    public static final int RS_FINGER_RIGHT_THUMB   = 0x06;
    public static final int RS_FINGER_RIGHT_INDEX   = 0x07;
    public static final int RS_FINGER_RIGHT_MIDDLE  = 0x08;
    public static final int RS_FINGER_RIGHT_RING    = 0x09;
    public static final int RS_FINGER_RIGHT_LITTLE  = 0x0A;
    public static final int RS_FINGER_TWO_THUMB = 0x0B;
    public static final int RS_FINGER_LEFT_FOUR = 0x0C;
    public static final int RS_FINGER_RIGHT_FOUR    = 0x0D;
    public static final int RS_FINGER_TWO_LEFT1 = 0x0E;
    public static final int RS_FINGER_TWO_LEFT2 = 0x0F;
    public static final int RS_FINGER_TWO_RIGHT2    = 0x10;
    public static final int RS_FINGER_TWO_RIGHT1    = 0x11; 
    public static final int RS_PALM_LEFT        = 0x12; 
    public static final int RS_PALM_RIGHT       = 0x13; 

        //
        // Finger Mask
        //
        // bit-wise finger marks
        //
        //   1111 1001 1111
        //
        //   left      right
        //   hand      hand
        //       thumbs
        //
        public static final int  RS_FINGER_M_ALL        = 0xF9F;
        public static final int  RS_FINGER_M_LEFT_LITTLE    = 0x800;
        public static final int  RS_FINGER_M_LEFT_RING      = 0x400;
        public static final int  RS_FINGER_M_LEFT_MIDDLE    = 0x200;
        public static final int  RS_FINGER_M_LEFT_INDEX     = 0x100;
        public static final int  RS_FINGER_M_LEFT_THUMB     = 0x080;
        public static final int  RS_FINGER_M_RIGHT_THUMB    = 0x010;
        public static final int  RS_FINGER_M_RIGHT_INDEX    = 0x008;
        public static final int  RS_FINGER_M_RIGHT_MIDDLE   = 0x004;
        public static final int  RS_FINGER_M_RIGHT_RING     = 0x002;
        public static final int  RS_FINGER_M_RIGHT_LITTLE   = 0x001;
        public static final int  RS_FINGER_M_TWO_THUMB      = 0x090;
        public static final int  RS_FINGER_M_LEFT_FOUR      = 0xF00;
        public static final int  RS_FINGER_M_RIGHT_FOUR     = 0x00F;
        public static final int  RS_FINGER_M_TWO_LEFT1      = 0xC00;
        public static final int  RS_FINGER_M_TWO_LEFT2      = 0x300;
        public static final int  RS_FINGER_M_TWO_RIGHT2     = 0x00C;
        public static final int  RS_FINGER_M_TWO_RIGHT1     = 0x003;


    //
    // Finger position for segmentation
    //
    public static final int RS_FGP_UNKNOWN              = 0;
    public static final int RS_FGP_RIGHT_THUMB          = 1;
    public static final int RS_FGP_RIGHT_INDEX          = 2;
    public static final int RS_FGP_RIGHT_MIDDLE         = 3;
    public static final int RS_FGP_RIGHT_RING           = 4;
    public static final int RS_FGP_RIGHT_LITTLE         = 5;
    public static final int RS_FGP_LEFT_THUMB           = 6;
    public static final int RS_FGP_LEFT_INDEX           = 7;
    public static final int RS_FGP_LEFT_MIDDLE          = 8;
    public static final int RS_FGP_LEFT_RING            = 9;
    public static final int RS_FGP_LEFT_LITTLE          = 10;
    public static final int RS_FGP_PLAIN_RIGHT_THUMB    = 11;
    public static final int RS_FGP_PLAIN_LEFT_THUMB     = 12;
    public static final int RS_FGP_PLAIN_RIGHT_FOUR     = 13;
    public static final int RS_FGP_PLAIN_LEFT_FOUR      = 14;
    public static final int RS_FGP_PLAIN_TWO_THUMBS     = 15;
    public static final int RS_FGP_EJI_OR_TIP           = 16;

    //
    // LED for RealScan-10
    //
    public static final int RS_LED_MODE_ALL             = 0x00;
    public static final int RS_LED_MODE_LEFT_FINGER4    = 0x01;
    public static final int RS_LED_MODE_RIGHT_FINGER4   = 0x02;
    public static final int RS_LED_MODE_TWO_THUMB       = 0x03;
    public static final int RS_LED_MODE_ROLL            = 0x04;
    public static final int RS_LED_POWER                = 0x05;

    //
    // LED Colors
    //
    public static final int RS_LED_OFF              = 0x00;
    public static final int RS_LED_GREEN            = 0x01;
    public static final int RS_LED_RED              = 0x02;
    public static final int RS_LED_YELLOW           = 0x03;

    //
    // LED Status for G1 
    //
    public static final int RS_LED_STATUS_OFF       = 0x00;
    public static final int RS_LED_STATUS_ON        = 0x01;
    public static final int RS_LED_STATUS_BLINK     = 0x02;

    //
    // Slap type
    //
    public static final int RS_SLAP_LEFT_FOUR           = 1;
    public static final int RS_SLAP_RIGHT_FOUR          = 2;
    public static final int RS_SLAP_FOUR_FINGER         = 3;
    public static final int RS_SLAP_TWO_THUMB           = 4;
    public static final int RS_SLAP_TWO_FINGER          = 5;
    public static final int RS_SLAP_ONE_FINGER          = 6;
    public static final int RS_SLAP_ONE_FINGER_ROLL     = 7;

    //
    // Security level
    //
    public static final int RS_SECURITY_1_TO_100        = 0x01; 
    public static final int RS_SECURITY_1_TO_1000       = 0x02;
    public static final int RS_SECURITY_1_TO_10000      = 0x03;
    public static final int RS_SECURITY_1_TO_100000     = 0x04;
    public static final int RS_SECURITY_1_TO_1000000    = 0x05;
    public static final int RS_SECURITY_1_TO_10000000   = 0x06;
    public static final int RS_SECURITY_1_TO_100000000  = 0x07;

    //
    // Contrast enhancement
    //
    public static final int RS_CONTRAST_ENHANCEMENT_DEFVALUE = 0;
    public static final int RS_CONTRAST_ENHANCEMENT_MAXVALUE = 40;

    //
    // Self test type
    //
     public static final int RS_SELFTEST_ILLUMINATION       = 1;
     public static final int RS_SELFTEST_DIRT               = 2;
         
    //
    // LCD Display
    //
    public static final int RS_LCD_WIDTH_MAX            = 320;
    public static final int RS_LCD_HEIGHT_MAX           = 240;
    public static final int RS_LCD_DATA_SIZE_MAX        = 153600; 

    //
    // LFD Level for G1 
    //
    public static final int RS_LFD_OFF                  = 0;
    public static final int RS_LFD_LEVEL_1              = 1;
    public static final int RS_LFD_LEVEL_2              = 2;
    public static final int RS_LFD_LEVEL_3              = 3;
    public static final int RS_LFD_LEVEL_4              = 4;
    public static final int RS_LFD_LEVEL_5              = 5;
    public static final int RS_LFD_LEVEL_6              = 6;
    
    
    public static final int RS_LFD_LIVE              = 0;
    public static final int RS_LFD_FAKE              = 1;    
    public static final int RS_LFD_MAX_INFO          = 4;
    

    //
    //JNI APIs
    //
    native static int RS_GetLastError(); // get error code 
    native static int RS_JNI_Init(RealScan_JNI jni); // JNI Init
    
    //
    // Device APIs
    //
    native static int RS_InitSDK( String configFileName, int option ); // return numOfDevice
    native static int RS_InitDevice( int deviceIndex ); // return deviceHandle
    native static int RS_ExitDevice( int deviceHandle );
    native static int RS_ExitAllDevices( );
    native static int RS_GetDeviceInfo( int deviceHandle, RSDeviceInfo deviceInfo);
    native static int RS_UpgradeFirmware( int deviceHandle, byte[] firmware, int firmwareSize );

    //
    // Capture APIs
    //
    native static int RS_SetCaptureMode( int deviceHandle, int captureMode, int captureOption, boolean withModeLED );
    native static int[] RS_GetCaptureMode( int deviceHandle ); //return captureMode, captureOption  

    native static int RS_SetRollFingerOption( int deviceHandle, int rollDirection, int rollTime, int rollProfile );
    native static int[] RS_GetRollFingerOption( int deviceHandle ); //return rollDirection, rollTime, rollProfile

    native static int[] RS_GetImageSize( int deviceHandle ); //return imageWidth, imageHeight

    native static int RS_StartCapture( int deviceHandle, boolean autoCapture, int timeout );
    native static int RS_AbortCapture( int deviceHandle );
    native static int RS_RegisterCaptureDataCallback( int deviceHandle, Object provider, String method );
    native static int RS_RegisterPreviewCallback( int deviceHandle, Object provider, String method );
    native static int RS_RegisterAdvPreviewCallback( int deviceHandle, Object provider, String method );

    native static int RS_TakeImageData( int deviceHandle, int timeout, RSImageInfo imageInfo );
    native static int[] RS_TakeImageDataSegment( int deviceHandle, int timeout, RSImageInfo imageInfo, int captureResult, int slapType, int numOfFinger, RSSlapInfo[] slapInfo, RSImageInfo[] fingerImageInfo ); // return captureResult, numOfFinger
    native static int RS_TakeImageDataEx( int deviceHandle, int timeout, int fingerIndex, boolean withLED, RSImageInfo imageInfo );
    native static int RS_TakeCurrentImageData( int deviceHandle, int timeout, RSImageInfo imageInfo );
    native static int[] RS_TakeCurrentImageDataSegment( int deviceHandle, int timeout, RSImageInfo imageInfo, int captureResult, int slapType, int numOfFinger, RSSlapInfo[] slapInfo, RSImageInfo[] fingerImageInfo ); // return captureResult, numOfFinger
    native static int RS_TakeCurrentImageDataEx( int deviceHandle, int timeout, int fingerIndex, boolean withLED, RSImageInfo imageInfo );
    native static int[] RS_TakeImageDataSegmentWithSize( int deviceHandle, int timeout, RSImageInfo imageData, int captureResult, int slapType, int numOfFinger, RSSlapInfo[] slapInfo, RSImageInfo[] fingerImageInfo, int nCropWidth, int nCropHeight ); // return captureResult, numOfFinger
    native static int[] RS_TakeCurrentImageDataSegmentWithSize( int deviceHandle, int timeout, RSImageInfo imageData, int captureResult, int slapType, int numOfFinger, RSSlapInfo[] slapInfo, RSImageInfo[] fingerImageInfo, int nCropWidth, int nCropHeight); // return captureResult, numOfFinger


    native static int RS_Segment( RSImageInfo imageInfo, int slapType, int numOfFinger, RSSlapInfo[] slapInfo, RSImageInfo[] segmentImageInfo ); // return numOfFinger
    native static int RS_SegmentMask( RSImageInfo imageInfo, int fingerMask, int numOfFinger, RSSlapInfo[] slapInfo, RSImageInfo[] segmentImageInfo ); // return numOfFinger
    native static int RS_SegmentImages( RSImageInfo imageInfo, int slapType, int numOfFinger, RSSlapInfo[] slapInfo, String outFilename ); // return numOfFinger
    native static int RS_SegmentWithSize( RSImageInfo imageInfo, int slapType, int numOfFinger, RSSlapInfo[] slapInfo, RSImageInfo[] segmentImageInfo, int nCropWidth, int nCropHeight);
    native static int RS_GetQualityScore( byte[] imageData, int imageWidth, int imageHeight ); // return nistQuality
    native static int RS_SequenceCheck( int numOfFinger, RSImageInfo fingerImage, byte[] slapImageData, int slapImageWidth, int slapImageHeight, int slapType, int fingerSequenceInSlap, int securityLevel ); // return fingerSequenceInSlap
    native static int RS_SetSegRotateOption( boolean isRotating );

    native static int RS_Calibrate( int deviceHandle );
    native static int RS_SetAutomaticCalibrate( int deviceHandle, boolean automatic );
    native static boolean RS_GetAutomaticCalibrate( int deviceHandle ); // return automatic

    native static int RS_SetAutomaticContrast( int deviceHandle, boolean automatic );
    native static boolean RS_GetAutomaticContrast( int deviceHandle ); // return automatic

    native static int RS_SetManualContrast( int deviceHandle, int contrastLevel );
    native static int RS_GetManualContrast( int deviceHandle ); // return contrastLevel

    native static int RS_SetAdvancedContrastEnhancement( int deviceHandle, boolean enabled );
    native static boolean RS_GetAdvancedContrastEnhancement( int deviceHandle ); // return enabled

    native static int RS_SetPostProcessing( int deviceHandle, boolean contrastEnhancement, boolean noiseReduction );
    native static boolean[] RS_GetPostProcessing( int deviceHandle ); // return contrastEnhancement, noiseReduction

    native static int RS_SetPostProcessingEx( int deviceHandle, boolean contrastEnhancement, boolean noiseReduction, int reductionLevel );
    native static int[] RS_GetPostProcessingEx( int deviceHandle ); // return contrastEnhancement, noiseReduction, reductionLevel

    native static int RS_SelfTest( int deviceHandle, int testType );

    native static int RS_SetLFDLevel( int deviceHandle, int LFDLevel );
    native static int RS_GetLFDLevel( int deviceHandle ); // return LFDLevel
    native static int RS_SetLFDStatus( int deviceHandle, boolean isActivated, float th1, float th2, float th3, float th4 );
    native static int RS_GetLFDStatus( int deviceHandle, RSLFDInfo LFDInfo );
    native static int RS_GetLFDResult(int deviceHandle, RSLFDResult sLFDResult);

    native static int RS_SetMinimumFinger( int deviceHandle, int minFingerCount );
    
    native static int RS_SetManualCaptureMode( int deviceHandle, int imageX, int imageY, int imageWidth, int imageHeight, int captureOption, boolean isFlat );
    native static int[] RS_GetManualCaptureMode( int deviceHandle ); // return imageX, imageY, imageWidth, imageHeight, captureOption
    
    native static int RS_SetCaptureModeWithDir(int deviceHandle, int captureMode, int captureDirection, int captureOption, boolean withModeLED);
    native static int[] RS_GetCaptureModeWithDir(int deviceHandle); // return captureMode, captureDirection, captureOption

    //
    // VIEW APIs
    //
    native static int RS_SetViewWindow( int deviceHandle, Object obj, RSRect rect, boolean bAutoContrast ); // caution!!! don't use this in Linux
    native static int RS_StopViewWindow( int deviceHandle ); // caution!!! don't use this in Linux
    native static int RS_SetViewWindow2( int deviceHandle, Object obj, RSRect rect, boolean bAutoContrast ); // caution!!! don't use this in Linux

    native static int RS_AddOverlayText( int deviceHandle, RSOverlayText text ); // return overlayhandle // caution!!! don't use this in Linux
    native static int RS_AddOverlayCross( int deviceHandle, RSOverlayCross cross ); // return overlayhandle // caution!!! don't use this in Linux
    native static int RS_AddOverlayLine( int deviceHandle, RSOverlayLine line ); // return overlayhandle  // caution!!! don't use this in Linux
    native static int RS_AddOverlayQuadrangle( int deviceHandle, RSOverlayQuadrangle quadrangle ); // return overlayhandle  // caution!!! don't use this in Linux
    native static int RS_ShowOverlay( int overlayHandle, boolean show ); // caution!!! don't use this in Linux
    native static int RS_ShowAllOverlay( int deviceHandle, boolean show ); // caution!!! don't use this in Linux
    native static int RS_RemoveOverlay( int deviceHandle ); // caution!!! don't use this in Linux
    native static int RS_RemoveAllOverlay( int deviceHandle ); // caution!!! don't use this in Linux

    //
    // I/O
    //
    native static int RS_SetActiveKey( int deviceHandle, int keyMask );
    native static int RS_GetKeyStatus( int deviceHandle ); // return keyMask
//  REALSCANSDK_API int __stdcall RS_RegisterKeypadCallback( int deviceHandle, RSKeypadCallback callback ); // Using JNI DLL
    native static int RS_RegisterKeypadCallback( int deviceHandle, boolean setting );

    native static int RS_Beep( int deviceHandle, int beepPattern );
    native static int RS_SetCaptureBeep( int deviceHandle, int startingBeep, int successBeep, int failBeep );

    native static int RS_SetFingerLED( int deviceHandle, int fingerIndex, int ledColor );
    native static int RS_SetModeLED( int deviceHandle, int ledIndex, boolean isOn );
    native static int RS_SetStatusLED( int deviceHandle, int ledCode );

    native static int RS_PlayWav( int deviceHandle, String  wavFile);

    native static int RS_DisplayLCD( int deviceHandle, byte[] data, int dataLen, int sx, int sy, int width, int height );
    native static int RS_MakeLCDData( byte[] inputRData, byte[] inputGData, byte[] inputBData, int inputWidth, int inputHeight, byte[] outputData );
    native static int RS_ResetLCD( int deviceHandle );

    //
    // Misc.
    //
    native static int RS_GetSDKInfo( RSSDKInfo sdkInfo );
    native static String RS_GetErrString( int errorCode ); // caution!!! don't use this in Linux
    native static String RS_GetCaptureStatusString( int statusCode );
    native static void RS_FreeImageData( byte[] imageData );
    native static int RS_SaveBitmap( byte[] pixelData, int imageWidth, int imageHeight, String filename );
    native static int RS_SaveBitmapMem( byte[] pixelData, int imageWidth, int imageHeight, byte[] imageBuffer );
    
    RealScanTest frame = null;

    static {
        System.loadLibrary("RS_JNI");
    }
    
    public RealScan_JNI(RealScanTest frm, boolean isWindowsPlatfrom) {
        frame = frm;
        WINDOW = isWindowsPlatfrom;
    }
}
