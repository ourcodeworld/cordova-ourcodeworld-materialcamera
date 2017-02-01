module.exports = (function(){
    var className = "MaterialCameraCordova";
    
    /**
     * Camera handler
     */
    var cameraInstance = {
        _configuration: {},
        _setConfigurationProperty : function(identifier, value){
            this._configuration[identifier] = value;

            return this;
        },
        allowRetry: function(value){
            return this._setConfigurationProperty("allowRetry", value);
        },
        autoSubmit: function(){
            return this._setConfigurationProperty("autoSubmit", value);
        },
        defaultToFrontFacing: function(value){
            return this._setConfigurationProperty("defaultToFrontFacing", value);
        },
        retryExits: function(value){
            return this._setConfigurationProperty("retryExits", value);
        },
        saveDir: function(directory){
            return this._setConfigurationProperty("saveDir", directory);
        },
        maxAllowedFileSize: function(value){
            return this._setConfigurationProperty("maxAllowedFileSize", value);
        },
        qualityProfile: function(value){
            return this._setConfigurationProperty("qualityProfile", value);
        },
        setLanguage: function(value){
            return this._setConfigurationProperty("language", value);
        },
        startCamera: function(callbacks){
            var config = this._configuration;
            
            cordova.exec(function(response){
                var converted_response = JSON.parse(response);
                
                switch(converted_response.status){
                    case "success":
                        if(callbacks.hasOwnProperty("success")){
                            callbacks.success(converted_response);
                        }
                    break;
                    case "error":
                        if(callbacks.hasOwnProperty("error")){
                            callbacks.error(converted_response);
                        }
                    break;
                    default:
                        if(callbacks.hasOwnProperty("none")){
                            callbacks.none(converted_response);
                        }
                    break;
                }
            }, function(data){
                console.log("Fatal error Material Camera photo mode ", data);
            }, className, "camera", [JSON.stringify(config)]);
        }
    };

    /**
     * Video recorder handler
     */
    var videoInstance = {
        _configuration: {},
                _setConfigurationProperty : function(identifier, value){
            this._configuration[identifier] = value;

            return this;
        },
        allowRetry: function(value){
            return this._setConfigurationProperty("allowRetry", value);
        },
        autoSubmit: function(){
            return this._setConfigurationProperty("autoSubmit", value);
        },
        defaultToFrontFacing: function(value){
            return this._setConfigurationProperty("defaultToFrontFacing", value);
        },
        retryExits: function(value){
            return this._setConfigurationProperty("retryExits", value);
        },
        saveDir: function(directory){
            return this._setConfigurationProperty("saveDir", directory);
        },
        maxAllowedFileSize: function(value){
            return this._setConfigurationProperty("maxAllowedFileSize", value);
        },
        qualityProfile: function(value){
            return this._setConfigurationProperty("qualityProfile", value);
        },
        showPortraitWarning: function(value){
            return this._setConfigurationProperty("showPortraitWarning", value);
        }, 
        restartTimerOnRetry: function(value){
            return this._setConfigurationProperty("restartTimerOnRetry", value);
        }, 
        autoRecordWithDelaySec: function(value){
            return this._setConfigurationProperty("autoRecordWithDelaySec", value);
        }, 
        autoRecordWithDelayMs: function(value){
            return this._setConfigurationProperty("autoRecordWithDelayMs", value);
        }, 
        audioDisabled: function(value){
            return this._setConfigurationProperty("audioDisabled", value);
        }, 
        continueTimerInPlayback: function(value){
            return this._setConfigurationProperty("continueTimerInPlayback", value);
        }, 
        videoEncodingBitRate: function(value){
            return this._setConfigurationProperty("videoEncodingBitRate", value);
        },
        audioEncodingBitRate: function(value){
            return this._setConfigurationProperty("audioEncodingBitRate", value);
        },
        videoFrameRate: function(value){
            return this._setConfigurationProperty("videoFrameRate", value);
        },
        videoPreferredHeight: function(value){
            return this._setConfigurationProperty("videoPreferredHeight", value);
        },
        videoPreferredAspect: function(value){
            return this._setConfigurationProperty("videoPreferredAspect", value);
        },
        setLanguage: function(value){
            return this._setConfigurationProperty("language", value);
        },
        startVideoRecorder: function(callbacks){
            var config = this._configuration;
            
            cordova.exec(function(response){
                var converted_response = JSON.parse(response);
                
                switch(converted_response.status){
                    case "success":
                        if(callbacks.hasOwnProperty("success")){
                            callbacks.success(converted_response);
                        }
                    break;
                    case "error":
                        if(callbacks.hasOwnProperty("error")){
                            callbacks.error(converted_response);
                        }
                    break;
                    default:
                        if(callbacks.hasOwnProperty("none")){
                            callbacks.none(converted_response);
                        }
                    break;
                }
            }, function(data){
                console.log("Fatal error Material Camera video mode ", data);
            }, className, "video", [JSON.stringify(config)]);
        }
    };

    return {
        camera: cameraInstance,
        videoRecorder : videoInstance
    };
})();
