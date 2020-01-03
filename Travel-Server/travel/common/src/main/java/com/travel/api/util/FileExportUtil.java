package com.travel.api.util;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-03-26.
 */
public class FileExportUtil {
    //A4纸的高
    private static final int A4_HEIGHT = 2480;
    //A4纸的宽
    private static final int A4_WIDTH = 3508;
    //A4纸高的一半
    private static final int A4_HALF_HEIGHT = 1240;
    /**
     * @Description:图片拼接 （注意：必须两张图片长宽一致哦）
     * @author:liuyc
     * @time:2016年5月27日 下午5:52:24
     * @param images 要拼接的文件列表
     * @param type  1横向拼接， 2 纵向拼接
     */
    public static BufferedImage mergeImage(BufferedImage[] images, int type) {
        int len = images.length;
        if (len < 1) {
            throw new RuntimeException("图片数量小于1");
        }
        int[][] ImageArrays = new int[len][];
        for (int i = 0; i < len; i++) {
            int width = images[i].getWidth();
            int height = images[i].getHeight();
            ImageArrays[i] = new int[width * height];
            ImageArrays[i] = images[i].getRGB(0, 0, width, height, ImageArrays[i], 0, width);
        }
        int newHeight = 0;
        int newWidth = 0;
        for (int i = 0; i < images.length; i++) {
            // 横向
            if (type == 1) {
                newHeight = newHeight > images[i].getHeight() ? newHeight : images[i].getHeight();
                newWidth += images[i].getWidth();
            } else if (type == 2) {// 纵向
                newWidth = newWidth > images[i].getWidth() ? newWidth : images[i].getWidth();
                newHeight += images[i].getHeight();
            }
        }
        if (type == 1 && newWidth < 1) {
            return null;
        }
        if (type == 2 && newHeight < 1) {
            return null;
        }

        // 生成新图片
        try {
            BufferedImage ImageNew = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            int height_i = 0;
            int width_i = 0;
            for (int i = 0; i < images.length; i++) {
                if (type == 1) {
                    ImageNew.setRGB(width_i, 0, images[i].getWidth(), newHeight, ImageArrays[i], 0,
                            images[i].getWidth());
                    width_i += images[i].getWidth();
                } else if (type == 2) {
                    ImageNew.setRGB(0, height_i, newWidth, images[i].getHeight(), ImageArrays[i], 0, newWidth);
                    height_i += images[i].getHeight();
                }
            }
           return ImageNew;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将原图放大成指定大小的图片，不足的地方有空白图片补齐
     * @param img
     * @param maxHeight
     * @param maxWidth
     * @return
     */
    public static final BufferedImage imageFormate(BufferedImage img, int maxHeight, int maxWidth) throws IOException {
        //获取空白的原图
//        Image bi =ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\spring_cloud\\001.png"));
        Image bi =ImageIO.read(new File("/img/001.png"));
        //获取图像的高度，宽度
        int height=img.getHeight(null);
        int width =img.getWidth(null);
        int h = 0;
        int w = 0;
        //获取当前图片与最大图片的差，并补齐
//        if (maxHeight > height){
//            h = maxHeight - height;
//            BufferedImage tag = new BufferedImage(width, h, BufferedImage.TYPE_INT_RGB);
//            //补齐
//            tag.getGraphics().drawImage(bi, 0, 0,width, h, null);
//            BufferedImage[] images = new BufferedImage[2];
//            images[0] = img;
//            images[1] = tag;
//            img = mergeImage(images, 2);
//        }
        if (maxWidth > width){
            w = maxWidth - width;
            BufferedImage tag = new BufferedImage(w, maxHeight, BufferedImage.TYPE_INT_RGB);
            //补齐
            tag.getGraphics().drawImage(bi, 0, 0,w, maxHeight, null);
            BufferedImage[] images = new BufferedImage[2];
            images[0] = img;
            images[1] = tag;
            img = mergeImage(images, 1);
        }
        return img;
    }


    /**
     * 图片压缩   设定长的那边是宽 短的那边是高
     * @param bi  图片链接地址
     * @param appointHeight 指定图片的高
     * @param appointWidth  指定图片的宽
     * @return
     * @throws IOException
     */
    public static BufferedImage cutDown(Image bi, int appointHeight, int appointWidth) throws IOException {
        //获取图像的高度，宽度
        int height=bi.getHeight(null);
        int width =bi.getWidth(null);
        appointHeight = appointHeight == 0 ? height : appointHeight;
        appointWidth = appointWidth == 0 ? width : appointWidth;
        BufferedImage tag = null;
        if (height > appointHeight || width > appointWidth){
            //获取压缩比
            double ratio = getRatio(height, width, appointHeight, appointWidth);
            //构建图片流
            tag = new BufferedImage((int) (width / ratio), appointHeight, BufferedImage.TYPE_INT_RGB);
            //绘制改变尺寸后的图
            tag.getGraphics().drawImage(bi, 0, 0, (int) (width / ratio),appointHeight,null);
        } else if (height <= appointHeight && width <= appointWidth){
            //获取扩张比
            double ratio = getRideRatio(height, width, appointHeight, appointWidth);
            //构建图片流
            tag = new BufferedImage((int) (width * ratio), appointHeight, BufferedImage.TYPE_INT_RGB);
            //绘制改变尺寸后的图
            tag.getGraphics().drawImage(bi, 0, 0, (int) (width * ratio),appointHeight,null);
        }
        //校验
//        tag = new BufferedImage(appointWidth, appointHeight, BufferedImage.TYPE_INT_RGB);
////            //绘制改变尺寸后的图
//            tag.getGraphics().drawImage(bi, 0, 0, appointWidth,appointHeight,null);
        return tag;
    }

    /**
     * 旋转
     *
     * @param degree
     *            旋转角度
     * @throws Exception
     */
    private static BufferedImage spin(int degree, BufferedImage bi) throws Exception {
        int swidth = 0; // 旋转后的宽度
        int sheight = 0; // 旋转后的高度
        int x; // 原点横坐标
        int y; // 原点纵坐标

        // 处理角度--确定旋转弧度
        degree = degree % 360;
        if (degree < 0)
            degree = 360 + degree;// 将角度转换到0-360度之间
        double theta = Math.toRadians(degree);// 将角度转为弧度

        // 确定旋转后的宽和高
        if (degree == 180 || degree == 0 || degree == 360) {
            swidth = bi.getWidth();
            sheight = bi.getHeight();
        } else if (degree == 90 || degree == 270) {
            sheight = bi.getWidth();
            swidth = bi.getHeight();
        } else {
            swidth = (int) (Math.sqrt(bi.getWidth() * bi.getWidth()
                    + bi.getHeight() * bi.getHeight()));
            sheight = (int) (Math.sqrt(bi.getWidth() * bi.getWidth()
                    + bi.getHeight() * bi.getHeight()));
        }

        x = (swidth / 2) - (bi.getWidth() / 2);// 确定原点坐标
        y = (sheight / 2) - (bi.getHeight() / 2);

        BufferedImage spinImage = new BufferedImage(swidth, sheight,
                bi.getType());
        // 设置图片背景颜色
        Graphics2D gs = (Graphics2D) spinImage.getGraphics();
        gs.setColor(Color.white);
        gs.fillRect(0, 0, swidth, sheight);// 以给定颜色绘制旋转后图片的背景

        AffineTransform at = new AffineTransform();
        at.rotate(theta, swidth / 2, sheight / 2);// 旋转图象
        at.translate(x, y);
        AffineTransformOp op = new AffineTransformOp(at,
                AffineTransformOp.TYPE_BICUBIC);
        return op.filter(bi, spinImage);
    }

    /**
     * 合成图片
     * @param urls
     * @return
     * @throws Exception
     */
//    public static BufferedImage getNewImg(List<String> urls)throws Exception {
//        int total = urls.size();
//        BufferedImage[] imgs = new BufferedImage[total];
//        int maxh = 0;
//        int maxw = 0;
//        int appointHeight = 0;
//        int appointWidth = 0;
//        int constant = 0;
//        //判断图片数量的奇偶性
//        boolean evenNumbers = isEvenNumbers(total);
//        appointHeight = A4_HALF_HEIGHT;
//        if (evenNumbers){
//            //偶数
//            appointWidth = A4_WIDTH / (total / 2);
//        } else {
//            //奇数
//            int i = (total + 1) / 2;
//            int j = (total - 1) / 2;
//            constant = j - i;
//        }
//        //补齐图片
//        for (int i = 0; i < imgs.length; i++){
//            //如果是奇数
//            if (!evenNumbers && i > (imgs.length + 1) / 2){
//                appointWidth = appointWidth + constant;
//            }
//            BufferedImage image = cutDown(urls.get(i), appointHeight, appointWidth);
//            image = imageFormate(image, maxh, maxw);
//            imgs[i] = image;
//        }
//        BufferedImage image = imgs[0];
//        for(int i = 0; i < imgs.length - 1; i++){
//            BufferedImage img = imgs[i + 1];
//            BufferedImage[] temp = new BufferedImage[2];
//            temp[0] = image;
//            temp[1] = img;
//            image = mergeImage(imgs, 2);
//        }
//        return image;
//    }

    public static BufferedImage getNewImg(List<String> urls)throws Exception {
        int total = urls.size();
        BufferedImage[] imgs = new BufferedImage[total];
        List<BufferedImage> upImgs = new ArrayList<>();
        List<BufferedImage> downImgs = new ArrayList<>();
        int appointHeight = 0;
        int appointWidth = 0;
        int constant = 0;
        appointHeight = A4_HALF_HEIGHT;
        //图片张数是否为偶数
        boolean evenNumbers = isEvenNumbers(total);
        if (evenNumbers){
            //偶数
            appointWidth = A4_WIDTH / (total / 2);
        } else {
            //奇数
            int i = (total + 1) / 2;
            int j = (total - 1) / 2;
            appointWidth = A4_WIDTH / i;
            constant = A4_WIDTH / j - A4_WIDTH / i;
        }
        for (int i = 0; i < total; i++){
            int maxWidh = appointWidth;
            if (!evenNumbers && i >= (imgs.length + 1) / 2){
                maxWidh = appointWidth + constant;
            }
            //字节流转图片对象
            Image bi =ImageIO.read(new URL(urls.get(i)));
            BufferedImage image = cutDown(bi, appointHeight, maxWidh);
//            if (image.getWidth() < image.getHeight()){
//                image = spin(90, image);
//            }

//            FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\spring_cloud\\img.jpg");
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);
//            encoder.encode(image);
//            fos.flush();
//            fos.close();


            //如果是偶数个
            if (evenNumbers){
                if (i < total / 2){
                    upImgs.add(image);
                } else {
                    downImgs.add(image);
                }
            } else {
                //奇数个
                if (i < (total + 1) / 2){
                    upImgs.add(image);
                } else {
                    downImgs.add(image);
                }
            }
        }
        //把所有的图片合成上半部分和下半部分两张
        BufferedImage upImg = upImgs.get(0);
        for(int i = 0; i < upImgs.size() - 1; i++){
            BufferedImage img = upImgs.get(i + 1);
            BufferedImage[] temp = new BufferedImage[2];
            temp[0] = upImg;
            temp[1] = img;
            upImg = mergeImage(temp, 1);
        }
        BufferedImage downImg = downImgs.get(0);
        for(int i = 0; i < downImgs.size() - 1; i++){
            BufferedImage img = downImgs.get(i + 1);
            BufferedImage[] temp = new BufferedImage[2];
            temp[0] = downImg;
            temp[1] = img;
            downImg = mergeImage(temp, 1);
        }
        BufferedImage[] temp = new BufferedImage[2];
        //上下两张图片合并
        temp[0] = imageFormate(upImg, A4_HALF_HEIGHT, A4_WIDTH);
        temp[1] = imageFormate(downImg, A4_HALF_HEIGHT, A4_WIDTH);;
        return mergeImage(temp, 2);
    }

    /**
     * 判断一个数字是否为偶数
     * @param num
     * @return
     */
    private static boolean isEvenNumbers(int num){
        return num % 2 == 0;
    }

    /**
     * 获取压缩比
     * @param height
     * @param width
     * @param appointHeight
     * @param appointWidth
     * @return
     */
    private static double getRatio(double height, double width, double appointHeight, double appointWidth){
        double ratio = 1;
        if (height > width){
            if (height > appointHeight){
                ratio = height / appointHeight;
            }
        } else {
            if (width > appointWidth){
                ratio = width / appointWidth;
            }
        }
        return ratio;
    }
    /**
     * 获取扩张比
     * @param height
     * @param width
     * @param appointHeight
     * @param appointWidth
     * @return
     */
    private static double getRideRatio(double height, double width, double appointHeight, double appointWidth){
        double ratio = 1;
        if (height < width){
            if (width < appointWidth){
                ratio = appointWidth / width;
            }
        } else {
            if (height < appointHeight){
                ratio = appointHeight / height;
            }
        }
        return ratio;
    }


}
