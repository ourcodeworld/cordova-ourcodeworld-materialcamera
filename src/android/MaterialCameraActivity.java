package com.ourcodeworld.plugins.materialcamera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.afollestad.materialcamera.MaterialCamera;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

public class MaterialCameraActivity extends Activity {

    private final static int CAMERA_RQ = 6969;
    private boolean firstTime = true;
    private static String GLOBAL_MODE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(firstTime == true){
            super.onCreate(savedInstanceState);
            Bundle extras = getIntent().getExtras();

            try{
                String action = extras.getString("action");
                String configuration_string = extras.getString("configuration");
                JSONObject configuration = new JSONObject(configuration_string);

                GLOBAL_MODE = action;

                if(action.equals("camera")){
                    startCamera(configuration);
                }else if(action.equals("video")){
                    startVideo(configuration);
                }

                firstTime = false;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void startCamera(JSONObject configuration){
        MaterialCamera cm = new MaterialCamera(this);

        try{
            if(configuration.has("language")){
                String lg_code = configuration.getString("language");

                int lbl_retry = getIdentifierResource("label_retry_" + lg_code);
                int lbl_confirm = getIdentifierResource("label_confirm_" + lg_code);

                if(lbl_retry != 0 && lbl_confirm != 0){
                    cm.labelRetry(lbl_retry);
                    cm.labelConfirm(lbl_confirm);
                }
            }

            if(configuration.has("defaultToFrontFacing")){
                boolean _defaultToFrontFacing = configuration.getBoolean("defaultToFrontFacing");
                cm.defaultToFrontFacing(_defaultToFrontFacing);
            }

            if(configuration.has("allowRetry")){
                boolean _allowRetry = configuration.getBoolean("allowRetry");
                cm.allowRetry(_allowRetry);
            }

            if(configuration.has("autoSubmit")){
                boolean _autoSubmit = configuration.getBoolean("autoSubmit");
                cm.allowRetry(_autoSubmit);
            }

            if(configuration.has("saveDir")){
                String _saveDir = configuration.getString("saveDir");
                cm.saveDir(_saveDir);
            }

            if(configuration.has("retryExits")){
                boolean _retryExits = configuration.getBoolean("retryExits");
                cm.retryExits(_retryExits);
            }

            if(configuration.has("maxAllowedFileSize")){
                long _maxAllowedFileSize = configuration.getLong("maxAllowedFileSize");
                cm.maxAllowedFileSize(_maxAllowedFileSize);
            }

            if(configuration.has("qualityProfile")){
                String temp_qualityProfile = configuration.getString("qualityProfile");

                if(temp_qualityProfile.equals("QUALITY_HIGH")){
                    cm.qualityProfile(MaterialCamera.QUALITY_HIGH);

                }else if(temp_qualityProfile.equals("QUALITY_LOW")){
                    cm.qualityProfile(MaterialCamera.QUALITY_LOW);

                }else if(temp_qualityProfile.equals("QUALITY_480P")){
                    cm.qualityProfile(MaterialCamera.QUALITY_480P);

                }else if(temp_qualityProfile.equals("QUALITY_720P")){
                    cm.qualityProfile(MaterialCamera.QUALITY_720P);

                }else if(temp_qualityProfile.equals("QUALITY_1080P")){
                    cm.qualityProfile(MaterialCamera.QUALITY_1080P);
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Start camera
        cm.stillShot()
          .start(CAMERA_RQ);
    }

    public void startVideo(JSONObject configuration){
        MaterialCamera cm = new MaterialCamera(this);

        try{



            if(configuration.has("language")){
                String lg_code = configuration.getString("language");

                int lbl_retry = getIdentifierResource("label_retry_" + lg_code);
                int lbl_confirm = getIdentifierResource("label_confirm_" + lg_code);

                if(lbl_retry != 0 && lbl_confirm != 0){
                    cm.labelRetry(lbl_retry);
                    cm.labelConfirm(lbl_confirm);
                }
            }

            if(configuration.has("defaultToFrontFacing")){
                boolean _defaultToFrontFacing = configuration.getBoolean("defaultToFrontFacing");
                cm.defaultToFrontFacing(_defaultToFrontFacing);
            }

            if(configuration.has("allowRetry")){
                boolean _allowRetry = configuration.getBoolean("allowRetry");
                cm.allowRetry(_allowRetry);
            }

            if(configuration.has("countdownMillis")){
                long _countdownMillis = configuration.getLong("countdownMillis");
                cm.countdownMillis(_countdownMillis);
            }

            if(configuration.has("autoSubmit")){
                boolean _autoSubmit = configuration.getBoolean("autoSubmit");
                cm.allowRetry(_autoSubmit);
            }

            if(configuration.has("saveDir")){
                String _saveDir = configuration.getString("saveDir");
                cm.saveDir(_saveDir);
            }

            if(configuration.has("retryExits")){
                boolean _retryExits = configuration.getBoolean("retryExits");
                cm.retryExits(_retryExits);
            }

            if(configuration.has("maxAllowedFileSize")){
                long _maxAllowedFileSize = configuration.getLong("maxAllowedFileSize");
                cm.maxAllowedFileSize(_maxAllowedFileSize);
            }

            if(configuration.has("qualityProfile")){
                String temp_qualityProfile = configuration.getString("qualityProfile");

                if(temp_qualityProfile.equals("QUALITY_HIGH")){
                    cm.qualityProfile(MaterialCamera.QUALITY_HIGH);

                }else if(temp_qualityProfile.equals("QUALITY_LOW")){
                    cm.qualityProfile(MaterialCamera.QUALITY_LOW);

                }else if(temp_qualityProfile.equals("QUALITY_480P")){
                    cm.qualityProfile(MaterialCamera.QUALITY_480P);

                }else if(temp_qualityProfile.equals("QUALITY_720P")){
                    cm.qualityProfile(MaterialCamera.QUALITY_720P);

                }else if(temp_qualityProfile.equals("QUALITY_1080P")){
                    cm.qualityProfile(MaterialCamera.QUALITY_1080P);
                }
            }

            if(configuration.has("showPortraitWarning")){
                boolean _showPortraitWarning = configuration.getBoolean("showPortraitWarning");
                cm.showPortraitWarning(_showPortraitWarning);
            }

            if(configuration.has("restartTimerOnRetry")){
                boolean _restartTimerOnRetry = configuration.getBoolean("restartTimerOnRetry");
                cm.restartTimerOnRetry(_restartTimerOnRetry);
            }

            if(configuration.has("autoRecordWithDelaySec")){
                int _autoRecordWithDelaySec = configuration.getInt("autoRecordWithDelaySec");
                cm.autoRecordWithDelaySec(_autoRecordWithDelaySec);
            }

            if(configuration.has("autoRecordWithDelayMs")){
                long _autoRecordWithDelayMs = configuration.getLong("autoRecordWithDelayMs");
                cm.autoRecordWithDelayMs(_autoRecordWithDelayMs);
            }

            if(configuration.has("audioDisabled")){
                boolean _audioDisabled = configuration.getBoolean("audioDisabled");
                cm.audioDisabled(_audioDisabled);
            }

            if(configuration.has("continueTimerInPlayback")){
                boolean _continueTimerInPlayback = configuration.getBoolean("continueTimerInPlayback");
                cm.continueTimerInPlayback(_continueTimerInPlayback);
            }

            if(configuration.has("videoEncodingBitRate")){
                int _videoEncodingBitRate = configuration.getInt("videoEncodingBitRate");
                cm.videoEncodingBitRate(_videoEncodingBitRate);
            }

            if(configuration.has("audioEncodingBitRate")){
                int _audioEncodingBitRate = configuration.getInt("audioEncodingBitRate");
                cm.audioEncodingBitRate(_audioEncodingBitRate);
            }

            if(configuration.has("videoFrameRate")){
                int _videoFrameRate = configuration.getInt("videoFrameRate");
                cm.videoFrameRate(_videoFrameRate);
            }

            if(configuration.has("videoPreferredHeight")){
                int _videoPreferredHeight = configuration.getInt("videoPreferredHeight");
                cm.videoPreferredHeight(_videoPreferredHeight);
            }

            if(configuration.has("videoPreferredAspect")){
                float _videoPreferredAspect = BigDecimal.valueOf(configuration.getDouble("videoPreferredAspect")).floatValue();
                cm.videoPreferredAspect(_videoPreferredAspect);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Start video recorder
        cm.start(CAMERA_RQ);
    }

    private int getIdentifierResource(String name) {
        return this.getResources().getIdentifier(
               name, "string", this.getPackageName());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try{
            JSONObject response = new JSONObject();
            response.put("mode", GLOBAL_MODE);

            // Received recording or error from MaterialCamera
            if (requestCode == CAMERA_RQ) {

                if (resultCode == RESULT_OK) {
                    response.put("outputFile", data.getDataString());
                    response.put("status", "success");
                } else if(data != null) {
                    Exception e = (Exception) data.getSerializableExtra(MaterialCamera.ERROR_EXTRA);
                    e.printStackTrace();

                    response.put("message", e.getMessage());
                    response.put("status", "error");

                } else {
                    response.put("status", "none");

                }
            }

            // Send information
            Intent intent = new Intent();
            intent.putExtra("information", response.toString());
            setResult(Activity.RESULT_OK, intent);
            finish();
        }catch(JSONException e){

        }
    }
}