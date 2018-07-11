package com.liqy.searchapp;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * 没有权限APP 直接Crash
 */
public class QRCodeActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks , QRCodeView.Delegate{

    //定义静态常量
    private static final int REQUEST_CODE_QRCODE_PERMISSIONS = 1;

    private ZXingView mZXingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        Button permission=(Button)findViewById(R.id.btn_permission);

        permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //在每次打开扫码时都要执行
                requestCodeQRCodePermissions();
            }
        });

        Button btn_scan=(Button)findViewById(R.id.btn_scan);
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mZXingView.startCamera(); // 打开后置摄像头开始预览，但是并未开始识别
//        mZXingView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT); // 打开前置摄像头开始预览，但是并未开始识别
                mZXingView.startSpotAndShowRect(); // 显示扫描框，并且延迟0.5秒后开始识别
            }
        });

        mZXingView=(ZXingView)findViewById(R.id.zxingview);
        mZXingView.setDelegate(this);//注册接口

    }

    @Override
    protected void onStart() {
        super.onStart();
      //此处点击按钮启动
    }

    @Override
    protected void onStop() {
        super.onStop();
        mZXingView.stopCamera(); // 关闭摄像头预览，并且隐藏扫描框

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mZXingView.onDestroy(); // 销毁二维码扫描控件

    }

    /**
     * Activity 回调方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //TODO 暂时不需要处理 当选择本地图片才会使用
    }

    /**
     * 重写此方法权限回调方法
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //使用第三方类库的方法回调处理
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);

    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

    }

    /**
     * 执行权限请求
     */
    @AfterPermissionGranted(REQUEST_CODE_QRCODE_PERMISSIONS)
    private void requestCodeQRCodePermissions(){

        //权限数组 摄像头 存储卡（自己配置的权限在清单文件中）
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE};

        if (!EasyPermissions.hasPermissions(this, perms)) {//判断是否拥有权限，没有请求
            EasyPermissions.requestPermissions(this, "扫描二维码需要打开相机和散光灯的权限", REQUEST_CODE_QRCODE_PERMISSIONS, perms);
        }

    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Log.i("ScanQRCode", "result:" + result);
        //TODO 处理扫码结果

        Toast.makeText(QRCodeActivity.this,result,Toast.LENGTH_SHORT).show();

        mZXingView.startSpot(); // 延迟0.5秒后开始识别

    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e("ScanQRCode", "打开相机出错");

    }
}


