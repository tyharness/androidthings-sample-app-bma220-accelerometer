package uk.ty.androidthings.bma220exampleproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;




import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.io.IOException;

import uk.tyharness.things.contrib.driver.bma220.*;


public class Bma220Activity  extends Activity implements SensorEventListener {
    private static final String TAG = Bma220Activity.class.getSimpleName();
    

    private bma220AccelerometerDriver mAccelerometerDriver;
    private SensorManager mSensorManager;

    private bma220 bma220device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Log.d(TAG, "onCreate");
        
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorManager.registerDynamicSensorCallback(new SensorManager.DynamicSensorCallback() {
            @Override
            public void onDynamicSensorConnected(Sensor sensor) {
                if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    Log.i(TAG, "Accelerometer sensor connected");
                    
                  
                    mSensorManager.registerListener(Bma220Activity.this, sensor,
                            SensorManager.SENSOR_DELAY_NORMAL);
                }
            }
        });
        try {
            //mAccelerometerDriver = new bma220AccelerometerDriver(BoardDefaults.getI2CPort());
            //use the boardsvariant class to accomadte multiple devices.
            mAccelerometerDriver = new bma220AccelerometerDriver( "I2C1");//Raspberry Pi 3 only
            mAccelerometerDriver.register();
            Log.i(TAG, "Accelerometer driver registered");
            
         
          
            //what is the state of the registers
            Log.i(TAG, "_00_REG_ChipID : "   + Integer.toHexString(mAccelerometerDriver._getChipID() ));           
            Log.i(TAG, "_02_REG_ChipREV :  " + Integer.toHexString(mAccelerometerDriver._getChipREV() ));
            
            Log.i(TAG, "_0A_REG : "        + Integer.toHexString(mAccelerometerDriver._get_A_REG() ));
            Log.i(TAG, "_0C_REG : "        + Integer.toHexString(mAccelerometerDriver._get_C_REG() ));
            Log.i(TAG, "_0E_REG : "        + Integer.toHexString(mAccelerometerDriver._get_E_REG() ));
            Log.i(TAG, "_10_REG : "        + Integer.toHexString(mAccelerometerDriver._get_10_REG() ));   
            
            Log.i(TAG, "_12_REG : "        + Integer.toHexString(mAccelerometerDriver._getOrientation() ));
            Log.i(TAG, "_14_REG : "        + Integer.toHexString(mAccelerometerDriver._getTapDetection() ));
         
            Log.i(TAG, "_16_REG : "        + Integer.toHexString(mAccelerometerDriver._get_16_REG() ));
            Log.i(TAG, "_18_REG : "        + Integer.toHexString(mAccelerometerDriver._get_18_REG() ));
            Log.i(TAG, "_1A_REG : "        + Integer.toHexString(mAccelerometerDriver._get_1A_REG() ));
            
            Log.i(TAG, "_1C_REG : "        + Integer.toHexString(  mAccelerometerDriver._getLatching() ));           
            Log.i(TAG, "_1E_REG : "        + Integer.toHexString(mAccelerometerDriver._getChipREV() ));
            Log.i(TAG, "_20_FILTER_REG : " + Integer.toHexString(  mAccelerometerDriver._getFilterAndBandwidth()  ));
            Log.i(TAG, "_22_Range REG : "  + Integer.toHexString(  mAccelerometerDriver._getRangeMode() )); 
            
            
            
           
            
        } catch (IOException e) {
            Log.e(TAG, "Error initializing accelerometer driver: ", e);
        }
        
        
        
        
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        
        if (mAccelerometerDriver != null) {
            mSensorManager.unregisterListener(this);
            mAccelerometerDriver.unregister();
            try {
                mAccelerometerDriver.close();
            } catch (IOException e) {
                Log.e(TAG, "Error closing accelerometer driver: ", e);
            } finally {
                mAccelerometerDriver = null;
            }
        }
        
        
        
    }
    
@Override
    public void onSensorChanged(SensorEvent event) {
  
  if (mAccelerometerDriver._getAccelerationState() == true){
  
        Log.i(TAG, "Acceleration XYZ[m/s^2] " +
                event.values[0] + ", " + event.values[1] + ", " + event.values[2]);
        
         }
      
        
        
        
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.i(TAG, "Accelerometer accuracy changed: " + accuracy);
    }    
    
    
    
    
}
