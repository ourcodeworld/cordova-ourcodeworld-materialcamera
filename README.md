# cordova-ourcodeworld-materialcamera
A cordova wrapper for the [Android Library Material Camera](https://github.com/afollestad/material-camera).

<img src="https://raw.githubusercontent.com/afollestad/material-camera/master/art/showcase1.png" width="800px" />

# Installation

Add the plugin using the following command in a terminal:

```bash
cordova plugin add https://github.com/ourcodeworld/cordova-ourcodeworld-materialcamera.git
```

After the installation you will be able to use the `OurCodeWorld.MaterialCamera` object in the Window.


# Documentation

[Visit the official documentation of the plugin here](http://docs.ourcodeworld.com/projects/cordova-our-code-world-material-camera)

# Examples

The videoRecorder and camera object contains a lot of options, [please read the docs](http://docs.ourcodeworld.com/projects/cordova-our-code-world-material-camera).

## Take picture

```javascript
OurCodeWorld.MaterialCamera.camera
    .qualityProfile("QUALITY_1080P")
    .setLanguage("de")
    .defaultToFrontFacing(true)
    // Or save the output path:
    //.saveDir("/storage/emulated/0/")
    .allowRetry(true)
    .startCamera({
        success: function(Data){
            console.info(Data);
            //{ mode:"camera"
            //outputFile: "file:///storage/emulated/0/Android/data/com.ourcodeworld.sandbox/cache/IMG_20170201_125644.jpg"
            //status: "success"}
        },
        error: function(err){
            console.error(Data);
        },
        none: function(){
            console.log("The user started the camera, but didn't do anything :) ");
        }
    });
```

## Video

```javascript
OurCodeWorld.MaterialCamera.videoRecorder
    .setLanguage("en")
    .defaultToFrontFacing(true)
    .allowRetry(true)
    .autoRecordWithDelayMs(5000)
    .countdownMillis(20000)
    .startVideoRecorder({
        success: function(Data){
            console.info(Data);
            //{ mode:"video"
            //outputFile: "file:///storage/emulated/0/Android/data/com.yourapp.appname/cache/VID_20170201_125241.mp4"
            //status: "success"}
        },
        error: function(err){
            console.error(Data);
        },
        none: function(){
            console.log("The user started the camera, but didn't do anything :) ");
        }
    });
```

---

# [LICENSE](/LICENSE.md)

###### Copyright 2016 Aidan Follestad

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.