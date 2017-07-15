Sample-app-BMA220-accelerometer for Android Things(TM) Dev. Prev 41 on the Raspberry Pi 3
----------------------------------------------------------------------------------------------

T Harness last updated readme 15/7/17

Please note this software is a demo only and no where near production ready -- Use with caution.


Sample app to show how to use the Android Things user-space driver:

https://github.com/tyharness/androidthings-example-driver-bma220-accelerometer

This sample app apk already contains the driver and works straight out of the box without additional driver installation. The driver app is an aar file contained in the app/libs folder.  If you want or prefer to install the latest driver version please visit and download the above driver and then copy the bma220-debug.aar file over to the libs folder and rebuild this sample app.


----------------------------------------------------------------------------------------------
Prerequisites

Raspberry Pi 3 board with Android Things Dev. Prev. 41

other boards ... to do

Bosch BMA220 - Triple Axis Accelerometer BMA220(Tiny) SKU:SEN0168

https://www.dfrobot.com/wiki/index.php/Triple_Axis_Accelerometer_BMA220(Tiny)_SKU:SEN0168


-----------------------------------------------------------------------------------------------

Wiring:

Please see schematic  .... to do

BMA220(Tiny) 3.3V--- 3.3V  rpi pin

BMA220(Tiny) GND --- GND   rpi pin

BMA220(Tiny) SDA --- SDA   rpi pin

BMA220(Tiny) SCK --- SCK   rpi pin

-----------------------------------------------------------------------------------------------

Build

./gradlew build

-----------------------------------------------------------------------------------------------
Connecting to the device with ADB

Just check which app is running in the foreground, you may need to uninstall previously installed apks that 
automatically launch on boot and use the i2c pins.

adb connect Android.local

adb shell dumpsys|grep top-activity

Proc # 0: fore  T/A/T  trm: 0 649:com.android.iotlauncher/1000 (top-activity)

If the iotlauncher is not the top-activity then check the running app is compatible.  Uninstall incompatible apps or start with a fresh image dev-prev 41 available at:

https://developer.android.com/

Please note we (you and I) are required to comply with Google's T&Cs:

https://developer.android.com/things/terms.html


----------------------------------------------------------------------------------------------
Installation

Install from the command line:

adb install -r app/build/outputs/apk/app-debug.apk

adb logcat -c

adb shell am start uk.ty.androidthings.bma220exampleproject/.Bma220Activity

adb logcat|grep Bma220Activity

------------------------------------------------------------------------------------------
Install from Android Studio

to do.

----------------------------------------------------------------------------------------------
Uninstall

adb uninstall uk.ty.androidthings.bma220exampleproject



