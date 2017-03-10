package com.su.sdk;


import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Admin on 2016/8/6.
 */
public class ObdUtil {
    public ObdUtil() {
    }

    public static String ByteAarryList2String(ArrayList<Byte> var0) {
        byte[] var1 = new byte[var0.size()];

        for(int var2 = 0; var2 < -2 + var0.size(); ++var2) {
            var1[var2] = ((Byte)var0.get(var2 + 2)).byteValue();
        }

        return new String(var1);
    }

    /**
     * byte数组中取int数值，本方法适用于(低位在后，高位在前)的顺序。
     */
    public static int bytesToInt2(byte[] src, int offset) {
        int value;

        if(src.length>4){
            return -1;
        }else if(src.length<4){
            byte[] newSrc=new byte[4];
            for(int i=0;i<4;i++){
                if(i<src.length){
                    newSrc[i]=(byte)0;
                }else{
                    newSrc[i]=src[i-src.length];
                }
            }
            src=newSrc;

        }
        value = (int) ( ((src[offset] & 0xFF)<<24)
                |((src[offset+1] & 0xFF)<<16)
                |((src[offset+2] & 0xFF)<<8)
                |(src[offset+3] & 0xFF));
        return value;
    }

    public static int CalChecksum(byte[] var0) {
        int var1 = 0;

        int var3;
        for(int var2 = 0; var2 < var0.length; var2 = var3 + 1) {
            var3 = var2 + 1;
            var1 += 255 & var0[var2];
        }

        return var1 & 255;
    }

    public static int ErrorCode2ErrorSystem(String var0) {
        byte var6;
        if(var0.length() != 5) {
            var6 = -1;
            return var6;
        } else {
            String var1 = var0.substring(0, 1);
            String var2 = var0.substring(1, 5);
            int var3 = 0;
            char[] var4 = var2.toCharArray();

            for(int var5 = 0; var5 < var4.length; ++var5) {
                var3 = (var3 << 4) + -48 + var4[var5];
            }

            if(var1.equals("P")) {
                if(var3 >= 1) {
                    var6 = 0;
                    if(var3 <= 896) {
                        return var6;
                    }
                }

                if(var3 == 897) {
                    return 10;
                }

                if(var3 >= 898) {
                    var6 = 0;
                    if(var3 <= 1177) {
                        return var6;
                    }
                }

                if(var3 >= 1280) {
                    var6 = 0;
                    if(var3 <= 1283) {
                        return var6;
                    }
                }

                if(var3 >= 1284) {
                    var6 = 0;
                    if(var3 <= 1298) {
                        return var6;
                    }
                }

                if(var3 == 1299) {
                    return 3;
                }

                if(var3 >= 1300 && var3 <= 1303) {
                    return 11;
                }

                if(var3 >= 1304) {
                    var6 = 0;
                    if(var3 <= 1321) {
                        return var6;
                    }
                }

                if(var3 >= 1328 && var3 <= 1337) {
                    return 5;
                }

                if(var3 >= 1338) {
                    var6 = 0;
                    if(var3 <= 1353) {
                        return var6;
                    }
                }

                if(var3 >= 1360 && var3 <= 1364) {
                    return 4;
                }

                if(var3 >= 1365 && var3 <= 1369) {
                    return 1;
                }

                if(var3 >= 1376 && var3 <= 1379) {
                    return 11;
                }

                if(var3 >= 1380) {
                    var6 = 0;
                    if(var3 <= 1553) {
                        return var6;
                    }
                }

                if(var3 == 1554) {
                    return 2;
                }

                if(var3 >= 1555) {
                    var6 = 0;
                    if(var3 <= 1568) {
                        return var6;
                    }
                }

                if(var3 == 1569) {
                    return 10;
                }

                if(var3 >= 1570) {
                    var6 = 0;
                    if(var3 <= 1588) {
                        return var6;
                    }
                }

                if(var3 >= 1589 && var3 <= 1591) {
                    return 4;
                }

                if(var3 >= 1592) {
                    var6 = 0;
                    if(var3 <= 1603) {
                        return var6;
                    }
                }

                if(var3 == 1604) {
                    return 11;
                }

                if(var3 >= 1605 && var3 <= 1607) {
                    return 5;
                }

                if(var3 >= 1608 && var3 <= 1616) {
                    return 10;
                }

                if(var3 >= 1617) {
                    var6 = 0;
                    if(var3 <= 1693) {
                        return var6;
                    }
                }

                if(var3 >= 1792 && var3 <= 2049) {
                    return 2;
                }

                if(var3 == 2050) {
                    return 10;
                }

                if(var3 >= 2051 && var3 <= 2463) {
                    return 2;
                }

                if(var3 >= 2560 && var3 <= 2574) {
                    return 11;
                }

                var6 = 0;
                if(var3 == 2575) {
                    return var6;
                }

                if(var3 >= 2576 && var3 <= 2579) {
                    return 11;
                }

                if(var3 >= 2580 && var3 <= 2582) {
                    return 11;
                }

                if(var3 >= 2583) {
                    var6 = 0;
                    if(var3 <= 2590) {
                        return var6;
                    }
                }

                if(var3 == 2591) {
                    return 11;
                }

                if(var3 >= 2592) {
                    var6 = 0;
                    if(var3 <= 2693) {
                        return var6;
                    }
                }

                if(var3 >= 2694 && var3 <= 2703) {
                    return 11;
                }

                if(var3 >= 2704) {
                    var6 = 0;
                    if(var3 <= 2806) {
                        return var6;
                    }
                }

                if(var3 >= 2807 && var3 <= 2811) {
                    return 11;
                }

                if(var3 >= 2816 && var3 <= 2829) {
                    return 2;
                }

                if(var3 >= 4097) {
                    var6 = 0;
                    if(var3 <= 5273) {
                        return var6;
                    }
                }

                if(var3 >= 5888 && var3 <= 6399) {
                    return 2;
                }

                if(var3 >= 8192) {
                    var6 = 0;
                    if(var3 <= 9309) {
                        return var6;
                    }
                }

                if(var3 >= 9472) {
                    var6 = 0;
                    if(var3 <= 9476) {
                        return var6;
                    }
                }

                if(var3 >= 9478) {
                    var6 = 0;
                    if(var3 <= 9492) {
                        return var6;
                    }
                }

                if(var3 >= 9493 && var3 <= 9497) {
                    return 5;
                }

                if(var3 >= 9498) {
                    var6 = 0;
                    if(var3 <= 9503) {
                        return var6;
                    }
                }

                if(var3 >= 9504 && var3 <= 9513 || var3 == 9569) {
                    return 5;
                }

                if(var3 >= 9514 && var3 <= 9593) {
                    var6 = 0;
                    if(var3 != 9569) {
                        return var6;
                    }
                }

                if(var3 >= 9594 && var3 <= 9596) {
                    return 5;
                }

                if(var3 >= 9597) {
                    var6 = 0;
                    if(var3 <= 9744) {
                        return var6;
                    }
                }

                if(var3 >= 9745 && var3 <= 9747) {
                    return 5;
                }

                if(var3 >= 9748) {
                    var6 = 0;
                    if(var3 <= 9831) {
                        return var6;
                    }
                }

                if(var3 == 9832) {
                    return 10;
                }

                if(var3 >= 9833) {
                    var6 = 0;
                    if(var3 <= 9865) {
                        return var6;
                    }
                }

                if(var3 >= 9984 && var3 <= 10288) {
                    return 2;
                }

                if(var3 >= 10752) {
                    var6 = 0;
                    if(var3 <= 10769) {
                        return var6;
                    }
                }

                if(var3 >= 13312) {
                    var6 = 0;
                    if(var3 <= 13463) {
                        return var6;
                    }
                }
            } else if(var1.equals("C")) {
                if(var3 >= 1 && var3 <= 4) {
                    return 3;
                }

                if(var3 >= 16 && var3 <= 30) {
                    return 6;
                }

                if(var3 >= 32 && var3 <= 34 || var3 >= 48 && var3 <= 62) {
                    return 3;
                }

                if(var3 == 35) {
                    return 10;
                }

                if(var3 >= 64 && var3 <= 74) {
                    return 1;
                }

                if(var3 >= 81 && var3 <= 85 || var3 == 121) {
                    return 4;
                }

                if(var3 >= 97 && var3 <= 100 || var3 >= 105 && var3 <= 108) {
                    return 8;
                }

                if(var3 == 113 || var3 == 114 || var3 == 117) {
                    return 1;
                }

                if(var3 == 115 || var3 == 116) {
                    return 2;
                }

                if(var3 == 118) {
                    return 3;
                }

                if(var3 >= 119 && var3 <= 120) {
                    return 7;
                }

                if(var3 >= 129 || var3 <= 134) {
                    return 10;
                }

                if(var3 >= 137 && var3 <= 138) {
                    return 3;
                }
            } else {
                if(var1.equals("B")) {
                    return 3;
                }

                if(var1.equals("U")) {
                    return 11;
                }
            }

            return -1;
        }
    }

    public static int GetCRC16(byte[] var0, int var1) {
        int var2 = '\uffff';
        if(var1 == 0) {
            return 0;
        } else {
            for(int var3 = 0; var3 < var1; ++var3) {
                var2 ^= 255 & var0[var3];

                for(int var4 = 0; var4 < 8; ++var4) {
                    if((var2 & 1) != 0) {
                        var2 = '?' ^ var2 >> 1;
                    } else {
                        var2 >>= 1;
                    }
                }
            }

            return var2;
        }
    }

    public static int GetUpdateCRC16(byte[] var0, int var1) {
        int var2 = 0;

        int var4;
        for(int var3 = 0; var3 < var1; var3 = var4) {
            var4 = var3 + 1;
            var2 = UpdateCRC16(var2, 255 & var0[var3]);
        }

        return '\uffff' & UpdateCRC16(UpdateCRC16(var2, 0), 0);
    }

    private static int UpdateCRC16(int var0, int var1) {
        int var2 = var0;
        int var3 = var1 | 256;

        do {
            var2 <<= 1;
            var3 <<= 1;
            if((var3 & 256) != 0) {
                ++var2;
            }

            if((var2 & 65536) != 0) {
                var2 ^= 4129;
            }
        } while((var3 & 65536) == 0);

        return '\uffff' & var2;
    }

    public static String bcd2Str(byte[] var0) {
        StringBuffer var1 = new StringBuffer(2 * var0.length);

        for(int var2 = 0; var2 < var0.length; ++var2) {
            var1.append((byte)((240 & var0[var2]) >> 4));
            var1.append((byte)(15 & var0[var2]));
        }

        return var1.toString().substring(0, 1).equalsIgnoreCase("0")?var1.toString().substring(1):var1.toString();
    }

    public static final int byte2Int(byte var0) {
        return var0 & 255;
    }

    private static long bytes2long(byte[] var0, int var1) {
        long var2 = 0L;

        for(int var4 = 0; var4 < 8; ++var4) {
            var2 = var2 << 8 | (long)(255 & var0[var4 + var1]);
        }

        return var2;
    }

    public static final String bytesToHexString(byte[] var0) {
        StringBuffer var1 = new StringBuffer(var0.length);

        for(int var2 = 0; var2 < var0.length; ++var2) {
            String var3 = Integer.toHexString(255 & var0[var2]);
            if(var3.length() < 2) {
                var1.append(0);
            }

            var1.append(var3.toUpperCase());
        }

        return var1.toString();
    }

    public static byte[] getByteArray(String var0) {
        return (new BigInteger(var0, 16)).toByteArray();
    }

    public static String getHexArrayForCom(byte[] var0) {
        String var1 = "";

        for(int var2 = 0; var2 < var0.length; ++var2) {
            var1 = var1 + Integer.toString(256 + (255 & var0[var2]), 16).substring(1) + " ";
        }

        return var1;
    }

    public static String getHexString(byte[] var0) {
        String var1 = "";

        for(int var2 = 0; var2 < var0.length; ++var2) {
            var1 = var1 + Integer.toString(256 + (255 & var0[var2]), 16).substring(1);
        }

        return var1;
    }


    public static byte[] hexStringToByte(String var0) {
        int var1 = var0.length() / 2;
        byte[] var2 = new byte[var1];
        char[] var3 = var0.toCharArray();

        for(int var4 = 0; var4 < var1; ++var4) {
            int var5 = var4 * 2;
            var2[var4] = (byte)(toByte(var3[var5]) << 4 | toByte(var3[var5 + 1]));
        }

        return var2;
    }


    /**
     * 10进制转16进制
     * @param n
     * @return
     */
    public static String intToHex(int n){
        char[] ch = new char[20];
        int nIndex = 0;
        while ( true ){
            int m = n/16;
            int k = n%16;
            if ( k == 15 )
                ch[nIndex] = 'F';
            else if ( k == 14 )
                ch[nIndex] = 'E';
            else if ( k == 13 )
                ch[nIndex] = 'D';
            else if ( k == 12 )
                ch[nIndex] = 'C';
            else if ( k == 11 )
                ch[nIndex] = 'B';
            else if ( k == 10 )
                ch[nIndex] = 'A';
            else
                ch[nIndex] = (char)('0' + k);
            nIndex++;
            if ( m == 0 )
                break;
            n = m;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(ch, 0, nIndex);
        sb.reverse();
        String strHex = new String("0x");
        strHex += sb.toString();
        return strHex;
    }

    public static byte[] int2Byte(int var0) {
        byte[] var1 = new byte[4];

        for(int var2 = 0; var2 < 4; ++var2) {
            var1[var2] = (byte)(255 & var0 >> 8 * (3 - var2));
        }

        return var1;
    }

    public static int int2bcd(byte var0) {
        int var1 = var0 & 255;
        return 16 * (var1 / 10) + var1 % 10;
    }

    public static String intToString(int var0) {
        return (new Integer(var0)).toString();
    }

    private static byte[] long2bytes(long var0) {
        byte[] var2 = new byte[8];

        for(int var3 = 0; var3 < 8; ++var3) {
            var2[var3] = (byte)((int)(var0 >>> 56 - var3 * 8));
        }

        return var2;
    }



    public static byte[] str2Bcd(String var0) {
        int var1 = var0.length();
        if(var1 % 2 != 0) {
            var0 = "0" + var0;
            var1 = var0.length();
        }

        byte[] var10000 = new byte[var1];
        if(var1 >= 2) {
            var1 /= 2;
        }

        byte[] var3 = new byte[var1];
        byte[] var4 = var0.getBytes();

        for(int var5 = 0; var5 < var0.length() / 2; ++var5) {
            int var6;
            if(var4[var5 * 2] >= 48 && var4[var5 * 2] <= 57) {
                var6 = -48 + var4[var5 * 2];
            } else if(var4[var5 * 2] >= 97 && var4[var5 * 2] <= 122) {
                var6 = 10 + -97 + var4[var5 * 2];
            } else {
                var6 = 10 + -65 + var4[var5 * 2];
            }

            int var7;
            if(var4[1 + var5 * 2] >= 48 && var4[1 + var5 * 2] <= 57) {
                var7 = -48 + var4[1 + var5 * 2];
            } else if(var4[1 + var5 * 2] >= 97 && var4[1 + var5 * 2] <= 122) {
                var7 = 10 + -97 + var4[1 + var5 * 2];
            } else {
                var7 = 10 + -65 + var4[1 + var5 * 2];
            }

            var3[var5] = (byte)(var7 + (var6 << 4));
        }

        return var3;
    }

    public static int stringToInt(String var0) {
        return Integer.valueOf(var0).intValue();
    }

    public static byte[] subBytes(byte[] var0, int var1, int var2) {
        byte[] var3 = new byte[var2];

        for(int var4 = var1; var4 < var1 + var2; ++var4) {
            var3[var4 - var1] = var0[var4];
        }

        return var3;
    }

    private static byte toByte(char var0) {
        return (byte)"0123456789ABCDEF".indexOf(var0);
    }
}
