package com.zhuzb.web.taglib;

import com.swetake.util.Qrcode;
import org.omg.CORBA.OBJ_ADAPTER;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.nio.Buffer;
import java.util.List;
import java.util.*;

/**
 * Created by admin on 2018/6/14.
 */
public class QrCode {
    public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<2;i++){
            //sb.append("12345678901234567890123456789012345678901234567890");
        }
        //sb.append("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
        //字符串长度119
        //deawScan(sb.toString(),123+"");
/*        for(int zz=0;zz<=120;zz++){
            sb.append(0+"");
            deawScan(sb.toString(),zz+"");
        }*/
/*        String str = "11111111111111";
        int i = subFile(str.length());
        deawScan(str,i+"",i-1);
        str = "11111111111111111111111111";
        i = subFile(str.length());
        deawScan(str,i+"",i-1);
        str = "111111111111111111111111111111111111111111";
        i = subFile(str.length());
        deawScan(str,i+"",i-1);
        str = "11111111111111111111111111111111111111111111111111111111111111";
        i = subFile(str.length());
        deawScan(str,i+"",i-1);
        str = "111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        i = subFile(str.length());
        deawScan(str,i+"",i-1);
        str = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        i = subFile(str.length());
        deawScan(str,i+"",i-1);
        str = "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        i = subFile(str.length());
        deawScan(str,i+"",i-1);*/
/*        String str = "12345678901234567890123456789012345678901234567890123456789012345234565689789564132156465897465432156489789";
        deawScan(str,123+"");*/

        String str = "111111111111111111111111111111111111111111";
        //Image img = ImageIO.read(new File("E:\\image\\logo.png"));
        BufferedImage imgs = ImageIO.read(new FileInputStream("E:\\image\\logo.png"));
        BufferedImage image = createQrCode(str,300,imgs);
        //最后生成图片
        createImg(image,"zzzz");
    }

    /**
     *  生成二维码
     * @param width 二维码的宽度(可以为null，默认为)
     * @param str  生成二维码的地址
     */
    public static BufferedImage createQrCode(String str,Integer width){
        try{
            int i = subFile(str.length());//根据字符串分档
            //image的宽高(长高一样)
            int imgHeight = 94+16*(i-1);
            if(width == null||width<=0){
                width = imgHeight;
            }
            int type = getType(imgHeight,width);//根据需要长度判断是扩大还是缩小
            BufferedImage image = deawScan(str,imgHeight,imgHeight);//生成二维码
            if(type != 0){//对二维码原图进行修改
                image = changeScan(image,type,width);
            }
            return image;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  生成带底图的二维码
     * @param str 二维码字符串
     * @param width 二维码的宽度
     * @param bottomImage 底图的bufferedImage
     * @param x x轴坐标
     * @param y y轴坐标
     * @return
     */
    public static BufferedImage createQrCode(String str,Integer width,BufferedImage bottomImage,Integer x,Integer y){
        try{
            BufferedImage small = createQrCode(str,width);
            Graphics2D g = bottomImage.createGraphics();
            g.drawImage(small, x, y, small.getWidth(), small.getHeight(), null);
            g.dispose();
            return bottomImage;
        }catch (Exception e){
            e.printStackTrace();
        }
        return bottomImage;
    }

    /**
     *  生成带logo的二维码
     * @param str 二维码字符串
     * @param width 二维码的宽度
     * @param logoBufferedImage logo的bufferedImage
     * @return
     */
    public static BufferedImage createQrCode(String str,Integer width,BufferedImage logoBufferedImage){
        BufferedImage image = createQrCode(str,width);
        try{
            //计算logo放入的位置
            int x = image.getWidth()/2-logoBufferedImage.getWidth()/2;
            int y = image.getHeight()/2-logoBufferedImage.getHeight()/2;
            Graphics2D g = image.createGraphics();
            g.drawImage(logoBufferedImage, x, y, logoBufferedImage.getWidth(), logoBufferedImage.getHeight(), null);
            g.dispose();
            return image;
        }catch (Exception e){
            e.printStackTrace();
        }
        return image;
    }

    /**
     *  判断二维码的长度
     * @param width 原始的宽度
     * @param changeWidth 需要改变的宽度
     * @return
     */
    public static int getType(int width,int changeWidth){
        if(width < changeWidth){
            return 1;
        }else if(width > changeWidth){
            return 2;
        }else{
            return 0;
        }
    }

    public static BufferedImage deawScan(String qrData,int width,int height) throws Exception{
        Integer version = 0;
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');//纠错等级（分为L、M、H三个等级）
        qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符
        qrcode.setQrcodeVersion(version);//版本

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //绘图
        Graphics2D gs = bufferedImage.createGraphics();
        gs.setBackground(Color.WHITE);
        gs.setColor(Color.BLACK);
        gs.clearRect(0, 0, width, height);//清除下画板内容

        //设置下偏移量,如果不加偏移量，有时会导致出错。
        int pixoff = 5;

        byte[] d = qrData.toString().getBytes("gb2312");
        if(d.length > 0 && d.length <120){
            boolean[][] s = qrcode.calQrcode(d);
            for(int i=0;i<s.length;i++){
                for(int j=0;j<s.length;j++){
                    if(s[j][i]){
                        gs.fillRect(j*4+pixoff, i*4+pixoff, 4, 4);
                    }
                }
            }
        }
        gs.dispose();
        bufferedImage.flush();
        //最后生成图片
        //createImg(bufferedImage,"bbbbb");
        return bufferedImage;
    }

    //根据字符串判断二维码的长度
    public int str(String str){
        return 0;
    }

    /**
     *  最后生成图片
     * @param image 生成图片的BufferImage
     * @param name 生成图片的名称
     */
    public static void createImg(BufferedImage image,String name){
        try {
            ImageIO.write(image, "png", new File("E:/image/" + name + ".png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  返回二维码扩大的倍数
     * @param len
     * @return 字符串的长度
     */
    public static int subFile(int len){
        if(len>=1&&len<=14){
            return 1;
        }else if(len>=15&&len<=26){
            return 2;
        }else if(len>=27&&len<=42){
            return 3;
        }else if(len>=43&&len<=62){
            return 4;
        }else if(len>=63&&len<=84){
            return 5;
        }else if(len>=85&&len<=106){
            return 6;
        }else if(len>=107&&len<=119){
            return 7;
        }else {
            return 0;
        }
    }

    /**
     * 改变二维码的长度
     * @param bufferedImage 原图
     * @param changeType  是扩大还是缩小 1:扩大 2：缩小
     * @param len   改变的长度
     * @return  返回修改后的图
     */
    public static BufferedImage changeScan(BufferedImage bufferedImage,int changeType,int len){
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        Image image = bufferedImage.getScaledInstance(len, len, Image.SCALE_DEFAULT);
        BufferedImage tag = null;
        if(changeType == 1){
            tag = new BufferedImage(len, len, BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制扩大后的图
            g.dispose();
        }else if(changeType == 2){
            tag = new BufferedImage(len, len, BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
        }
        return tag;
    }
}
