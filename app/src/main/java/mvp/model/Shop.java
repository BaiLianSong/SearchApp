package mvp.model;

/**
 * 第一步：创建Bean类
 * Copyright 星期四 YourCompany.
 */
public class Shop {
    public String _id;
    public int id;
    public String name;
    public int month_sales;
    public String month_sales_tip;
    public float wm_poi_score;
    public double delivery_score;
    public double quality_score;
    public double pack_score;
    public double food_score;
    public String delivery_time_tip;
    public String third_category;
    public String pic_url;
    public String shopping_time_start;
    public String shopping_time_end;
    public int min_price;
    public String min_price_tip;
    public int shipping_fee;
    public String shipping_fee_tip;
    public String bulletin;
    public String address;
    public String call_center;
    public String distance;
    public String average_price_tip;
    public int comment_number;
    public String lng;
    public String lat;
    public int __v;
    public String created_at;

    @Override
    public String toString() {
        return "Shop{" +
                "_id='" + _id + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", month_sales=" + month_sales +
                ", month_sales_tip='" + month_sales_tip + '\'' +
                ", wm_poi_score=" + wm_poi_score +
                ", delivery_score=" + delivery_score +
                ", quality_score=" + quality_score +
                ", pack_score=" + pack_score +
                ", food_score=" + food_score +
                ", delivery_time_tip='" + delivery_time_tip + '\'' +
                ", third_category='" + third_category + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", shopping_time_start='" + shopping_time_start + '\'' +
                ", shopping_time_end='" + shopping_time_end + '\'' +
                ", min_price=" + min_price +
                ", min_price_tip='" + min_price_tip + '\'' +
                ", shipping_fee=" + shipping_fee +
                ", shipping_fee_tip='" + shipping_fee_tip + '\'' +
                ", bulletin='" + bulletin + '\'' +
                ", address='" + address + '\'' +
                ", call_center='" + call_center + '\'' +
                ", distance='" + distance + '\'' +
                ", average_price_tip='" + average_price_tip + '\'' +
                ", comment_number=" + comment_number +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", __v=" + __v +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
