package com.liqy.searchapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import cn.bingoogolapple.qrcode.core.BGAQRCodeUtil;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

/**
 * 生成二维码属于耗时操作，一定要在子线程中操作
 */
public class GenerateActivity extends AppCompatActivity {

    ImageView mEnglishLogoIv,mChineseLogoIv,mEnglishIv,mChineseIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        initView();
        createQRCode();
    }

    /**
     * 初始化View
     */
    private void initView() {
        mChineseIv=(ImageView)findViewById(R.id.mChineseIv);
        mEnglishIv=(ImageView)findViewById(R.id.mEnglishIv);
        mChineseLogoIv=(ImageView)findViewById(R.id.mChineseLogoIv);
        mEnglishLogoIv=(ImageView)findViewById(R.id.mEnglishLogoIv);
    }


    /**
     * 创建二维码
     */
    private void createQRCode() {
        createChineseQRCode();
        createEnglishQRCode();
        createChineseQRCodeWithLogo();
        createEnglishQRCodeWithLogo();

    }

    /**
     * 创建英文+图片二维码
     */
    private void createEnglishQRCodeWithLogo() {
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... params) {

                //加载图片
                Bitmap logoBitmap = BitmapFactory.decodeResource(GenerateActivity.this.getResources(), R.mipmap.ic_launcher);

                /**
                 * 同步创建指定前景色、指定背景色、带logo的二维码图片。该方法是耗时操作，请在子线程中调用。
                 *
                 * @param content         要生成的二维码图片内容
                 * @param size            二维码图片宽高，单位为px
                 * @param foregroundColor 二维码图片的前景色
                 * @param backgroundColor 二维码图片的背景色
                 * @param logo            二维码图片的logo
                 */
                return QRCodeEncoder.syncEncodeQRCode("bingoogolapple", BGAQRCodeUtil.dp2px(GenerateActivity.this, 150), Color.BLACK, Color.WHITE,
                        logoBitmap);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null) {
                    mEnglishLogoIv.setImageBitmap(bitmap);
                } else {
                    Toast.makeText(GenerateActivity.this, "生成带logo的英文二维码失败", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }

    /**
     * 中文+图片二维码
     */
    private void createChineseQRCodeWithLogo() {
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... params) {
                Bitmap logoBitmap = BitmapFactory.decodeResource(GenerateActivity.this.getResources(), R.mipmap.ic_launcher);

                /**
                 * 同步创建指定前景色、白色背景色、带logo的二维码图片。该方法是耗时操作，请在子线程中调用。
                 *
                 * @param content         要生成的二维码图片内容
                 * @param size            二维码图片宽高，单位为px
                 * @param foregroundColor 二维码图片的前景色
                 * @param logo            二维码图片的logo
                 */
                return QRCodeEncoder.syncEncodeQRCode("王浩", BGAQRCodeUtil.dp2px(GenerateActivity.this, 150), Color.parseColor("#ff0000"), logoBitmap);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null) {
                    mChineseLogoIv.setImageBitmap(bitmap);
                } else {
                    Toast.makeText(GenerateActivity.this, "生成带logo的中文二维码失败", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }

    /**
     * 英文二维码
     */
    private void createEnglishQRCode() {
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... params) {
                /**
                 * 同步创建指定前景色、白色背景色的二维码图片。该方法是耗时操作，请在子线程中调用。
                 *
                 * @param content         要生成的二维码图片内容
                 * @param size            图片宽高，单位为px
                 * @param foregroundColor 二维码图片的前景色
                 */
                return QRCodeEncoder.syncEncodeQRCode("bingoogolapple", BGAQRCodeUtil.dp2px(GenerateActivity.this, 150), Color.parseColor("#ff0000"));
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null) {
                    mEnglishIv.setImageBitmap(bitmap);
                } else {
                    Toast.makeText(GenerateActivity.this, "生成英文二维码失败", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }

    /**
     * 中文二维码
     */
    private void createChineseQRCode() {
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... params) {

                /**
                 * 同步创建黑色前景色、白色背景色的二维码图片。该方法是耗时操作，请在子线程中调用。
                 *
                 * @param content 要生成的二维码图片内容
                 * @param size    图片宽高，单位为px
                 */
                return QRCodeEncoder.syncEncodeQRCode("王浩", BGAQRCodeUtil.dp2px(GenerateActivity.this, 150));
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null) {
                    mChineseIv.setImageBitmap(bitmap);
                } else {
                    Toast.makeText(GenerateActivity.this, "生成中文二维码失败", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }


}
