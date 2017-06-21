Sample-app-BMA220-accelerometer for Android Things(TM) Dev. Prev 41 on the Raspberry Pi 3
----------------------------------------------------------------------------------------------

Sample app to show how to use the Android Things user-space driver:

This sample app apk contains the driver in an arr.
The driver app is an aar file in the app/libs folder.  If you want the latest driver version please
visit and download the above driver and then copy the bma220-debug.aar file over to the libs folder.

----------------------------------------------------------------------------------------------
Prerequisties

Raspberry Pi 3 board with Android Things Dev. Prev. 4

other boards ... to do


-----------------------------------------------------------------------------------------------

Wiring:
Please see schematic  .... to do

-----------------------------------------------------------------------------------------------

Install and Build from the command line:

./gradlew build


Use:
adb connect Android.local

adb logcat|grep Bma220Activity

adb install -r app/build/outputs/apk/app-debug.apk

adb shell am start uk.ty.androidthings.bma220exampleproject/.Bma220Activity

adb logcat|grep Bma220Activity


------------------------------------------------------------------------------------------
Install from Android Studio

to do.




