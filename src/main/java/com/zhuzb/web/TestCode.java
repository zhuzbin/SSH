package com.zhuzb.web;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Desc：
 * User：ZhuZhiBin
 * Date：2018/5/24
 * Time：21:19
 */
public class TestCode {

    public static void main(String[] args) throws Exception {

        for(int i=0;i<100;i++){
            System.out.println(random(4));
        }
        Integer version = 0;
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');//纠错等级（分为L、M、H三个等级）
        qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符
        qrcode.setQrcodeVersion(version);//版本
        //生成二维码中要存储的信息
        //pageContext.request.contextPath
        String qrData = "https://m.zhongzairong.cn/worldCup/toRegisterPage.do?yqm=123456";
        //String qrData = "http://www.duanhan.re234234234111333312312312333333333333321313";//63
        System.out.println(qrData.length());
        //设置一下二维码的像素
        int width = 120;
        int height = 120;//12*(version-1);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //绘图
        Graphics2D gs = bufferedImage.createGraphics();
        gs.setBackground(Color.WHITE);
        gs.setColor(Color.BLACK);
        gs.clearRect(0, 0, width, height);//清除下画板内容

        //设置下偏移量,如果不加偏移量，有时会导致出错。
        int pixoff = 5;

        byte[] d = qrData.getBytes("gb2312");
        if(d.length > 0 && d.length <120){
            boolean[][] s = qrcode.calQrcode(d);
            for(int i=0;i<s.length;i++){
                for(int j=0;j<s.length;j++){
                    if(s[j][i]){
                        gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);
                    }
                }
            }
        }

        //进行扩大

        gs.dispose();
        bufferedImage.flush();
        width = width+55;
        height = height+55;
        Image image = bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = tag.getGraphics();
        g.drawImage(image, 0, 0, null); // 绘制缩小后的图
        g.dispose();
        //ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流
        ImageIO.write(tag, "png", new File("E:/qrcode.png"));
        overlapImage("E:\\123.jpg",tag);
    }

    public static final void overlapImage(String bigPath, BufferedImage small) {
        try {
            BufferedImage big = ImageIO.read(new File(bigPath));
            Graphics2D g = big.createGraphics();
            int x = 295;
            int y = 1020;
            //System.out.println(x+"============="+y);
            g.drawImage(small, x, y, small.getWidth(), small.getHeight(), null);
            g.dispose();
            ImageIO.write(big, "jpg", new File("E:/a1.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据字符长度生成二维码
     */
    public static int random(int len){
        return  (int)(Math.random()*len+1);
    }


}
