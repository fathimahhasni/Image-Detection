package com.example.hp.androidbootstrap;

import android.Manifest;
<<<<<<< HEAD
<<<<<<< HEAD
import android.content.ComponentName;
=======
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
=======
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;

import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
<<<<<<< HEAD
<<<<<<< HEAD
import android.support.v4.content.IntentCompat;
=======
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
=======
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.FocusFinder;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.cloudinary.Transformation;
import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.ErrorInfo;
import com.cloudinary.android.callback.UploadCallback;
import com.cloudinary.android.preprocess.BitmapDecoder;
import com.cloudinary.android.preprocess.BitmapEncoder;
import com.cloudinary.android.preprocess.DimensionsValidator;
import com.cloudinary.android.preprocess.ImagePreprocessChain;
import com.cloudinary.android.preprocess.Limit;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Parameter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback{

    private Camera cam;
    private final String TAG = "MYTAG";
    private SurfaceView cameraPreview;
    private ImageView imgBtn;
    private ImageView imgBtn2;
    private volatile Bitmap picture;
    private Camera.PictureCallback cp;
    private File photoFile;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private TextView progressView;
    static  final  int CAMERA_REQUEST_CODE=1;
    static  final  int STORAGE_REQUEST_CODE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TypefaceProvider.getRegisteredIconSets();
        askPermissions(Manifest.permission.CAMERA,CAMERA_REQUEST_CODE);
        askPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,STORAGE_REQUEST_CODE);
<<<<<<< HEAD
<<<<<<< HEAD
        cam = Camera.open();
=======
        cam = Camera.open(0);
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
=======
        cam = Camera.open(0);
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
        cam.setDisplayOrientation(getCameraDisplayOrientation(0));
        cameraPreview = (SurfaceView) findViewById(R.id.surfaceView);
        cameraPreview.getHolder().addCallback(this);
        imgBtn = (ImageView) findViewById(R.id.processBtn);
        imgBtn2=(ImageView)findViewById(R.id.processBtn2);
        progressView = (TextView) findViewById(R.id.progressView);
        sp=getSharedPreferences("MYSP",MODE_MULTI_PROCESS);

<<<<<<< HEAD
<<<<<<< HEAD
        final Camera.Parameters params = cam.getParameters();
=======
        Camera.Parameters params = cam.getParameters();
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
=======
        Camera.Parameters params = cam.getParameters();
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
        params.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        cam.setParameters(params);

        edit=sp.edit();
        Map config=new HashMap();
        config.put("cloud_name","rahulseetharaman");
        config.put("api_key","577464834935689");
        config.put("api_secret","qcgYMhf9gSDYtL-ClgiNaMkAO48");
        MediaManager.init(this,config);

        imgBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GalleryLoader.class));
            }
        });

        cp = new Camera.PictureCallback()
        {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                Log.d(TAG, "Gambar Diambil!");
                File picFileDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/Camera");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
                String currentTimeStamp = dateFormat.format(new Date());
                picture = BitmapFactory.decodeByteArray(data, 0, data.length);
                if (picture == null)
                    Log.d(TAG, "On picture taken picture is null");
                else
                    Log.d(TAG, "On picture taken Picture is not null");
                Log.d(TAG, picture.toString());
                photoFile = new File(picFileDir, "ImageLabel_" + currentTimeStamp + ".jpeg");
                try {
                    Log.d(TAG, photoFile.toString());
                    FileOutputStream fos = new FileOutputStream(photoFile);
                    fos.write(data);
                    fos.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } catch (Exception e) {
                    Log.d("TAG", e.toString());
                }

                uploadToCloud();
            }


        };


        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
//                Camera cam = Camera.open();
//                Camera.Parameters p = cam.getParameters();
//                p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//                cam.setParameters(p);
//                cam.startPreview();
<<<<<<< HEAD
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
=======
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
                cam.takePicture(null, null, cp);
                if (picture != null) {
                    Log.d("What happened", "Picture not null");
                } else {
                    Log.d("What happened", "Bitmap is null");
                }
            }
        });

    }

    private void askPermissions(String permission,int requestCode)
    {
        if(ContextCompat.checkSelfPermission(this,permission) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{permission},requestCode);
        }
<<<<<<< HEAD
<<<<<<< HEAD
        else {}
=======
=======
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
        else
        {
            Toast.makeText(this,"Izin Akses Kamera Diberikan",Toast.LENGTH_SHORT).show();
        }
<<<<<<< HEAD
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
=======
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            cam.setPreviewDisplay(holder);
            cam.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (holder.getSurface() == null)
            return;
        try {
            cam.stopPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cam.setPreviewDisplay(holder);
            cam.startPreview();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (holder.getSurface() == null)
            return;
        if (cam != null) {
            cam.stopPreview();
            holder.removeCallback(this);
        }
    }

    public int getCameraDisplayOrientation(int id) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();

        Camera.getCameraInfo(id, cameraInfo);

        int rotation = getWindowManager().getDefaultDisplay().getRotation();

        int degrees = 0; // k

        switch (rotation) {
            case Surface.ROTATION_0:
                degrees = 0;
                break;
            case Surface.ROTATION_90:
                degrees = 90;
                break;
            case Surface.ROTATION_180:
                degrees = 180;
                break;
            case Surface.ROTATION_270:
                degrees = 270;
                break;

        }

        int result;

        if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            // cameraType=CAMERATYPE.FRONT;

            result = (cameraInfo.orientation + degrees) % 360;
            result = (360 - result) % 360; // compensate the mirror

        } else { // back-facing

            result = (cameraInfo.orientation - degrees + 360) % 360;

        }
        // displayRotate=result;
        return result;

    }

    public String searchGoogle(String cloudURL)
    {
        String searchURL = "http://www.google.com/searchbyimage?image_url=" + cloudURL;
        Connection connect=Jsoup.connect(searchURL);
        connect.userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21");
        connect.timeout(30000);
        try
        {
            Document document=connect.get();
            Element div=document.getElementsByClass("r5a77d").get(0);
            final String answer=div.getElementsByTag("a").get(0).text();
            return answer;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "nothing";
    }

    public void uploadToCloud()
    {
        Transformation tr=new Transformation();
        tr.crop("fit").width(100).angle(90);
        String requestId = MediaManager.get().upload(photoFile.getPath()).preprocess(new ImagePreprocessChain()
                .loadWith(new BitmapDecoder(1000, 1000))
                .addStep(new Limit(1000, 1000))
                .addStep(new DimensionsValidator(10,10,1000,1000))
                .saveWith(new BitmapEncoder(BitmapEncoder.Format.WEBP, 80))).callback(new UploadCallback() {
            @Override
            public void onStart(String requestId) {

            }

            @Override
            public void onProgress(String requestId, long bytes, long totalBytes) {

            }

            @Override
            public void onSuccess(String requestId, Map resultData) {
                String cloudURL=resultData.get("url").toString();
                progressView.setText(cloudURL);
                if(cloudURL!=null)
                new Scraper().execute(cloudURL);
                else{
                    Log.d("MYTAG","URL is null");
                }
            }

            @Override
            public void onError(String requestId, ErrorInfo error) {
                Log.d("MYTAG",error.getDescription());
            }

            @Override
            public void onReschedule(String requestId, ErrorInfo error) {

            }
        }).dispatch(getApplicationContext());
        Log.d("MYTAG",requestId);

    }

    private class Scraper extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... strings) {
            Log.d("MYTAG","In async task");
            return searchGoogle(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("MYTAG",s);
            progressView.setText(s);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

                if(grantResults.length>0 && grantResults[0]!=PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this,"Requires permission "+permissions[0],Toast.LENGTH_SHORT).show();
                    finish();
                }
        
    }
<<<<<<< HEAD
<<<<<<< HEAD

    @Override
    public void onBackPressed() {
//        android.os.Process.killProcess(android.os.Process.myPid());
        Intent intent = new Intent();
        cam.stopPreview();
        cam.release();
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
=======
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
=======
>>>>>>> e2cbae9bf3b4e1190b61d9cd03470bcaf2817fbf
}
