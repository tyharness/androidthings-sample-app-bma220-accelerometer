Sample-app-BMA220-accelerometer for Android Things(TM) Dev. Prev 41 on the Raspberry Pi 3
----------------------------------------------------------------------------------------------

Sample app to show how to use the Android Things user-space driver:

https://github.com/tyharness/androidthings-example-driver-bma220-accelerometer


This sample app apk already contains the driver. The driver app is an aar file in the app/libs folder.  If you want the latest driver version please visit and download the above driver and then copy the bma220-debug.aar file over to the libs folder.

Please note this software is a demo only and no where near production ready -- Use with caution.

----------------------------------------------------------------------------------------------
Prerequisties

Raspberry Pi 3 board with Android Things Dev. Prev. 4

other boards ... to do

Bosch BMA220 - Triple Axis Accelerometer BMA220(Tiny) SKU:SEN0168

https://www.dfrobot.com/wiki/index.php/Triple_Axis_Accelerometer_BMA220(Tiny)_SKU:SEN0168


-----------------------------------------------------------------------------------------------

Wiring:
Please see schematic  .... to do

-----------------------------------------------------------------------------------------------

Install and Build from the command line:

./gradlew build


Use:
adb connect Android.local

adb install -r app/build/outputs/apk/app-debug.apk

adb shell am start uk.ty.androidthings.bma220exampleproject/.Bma220Activity

adb logcat|grep Bma220Activity


------------------------------------------------------------------------------------------
Install from Android Studio

to do.




