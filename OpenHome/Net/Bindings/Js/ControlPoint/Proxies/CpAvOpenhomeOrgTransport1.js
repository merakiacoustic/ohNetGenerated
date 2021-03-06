 

/**
* Service Proxy for CpProxyAvOpenhomeOrgTransport1
* @module ohnet
* @class Transport
*/
    
var CpProxyAvOpenhomeOrgTransport1 = function(udn){ 

    this.url = window.location.protocol + "//" + window.location.host + "/" + udn + "/av.openhome.org-Transport-1/control";  // upnp control url
    this.domain = "av-openhome-org";
    this.type = "Transport";
    this.version = "1";
    this.serviceName = "av.openhome.org-Transport-1";
    this.subscriptionId = "";  // Subscription identifier unique to each Subscription Manager 
    this.udn = udn;   // device name
    
    // Collection of service properties
    this.serviceProperties = {};
    this.serviceProperties["Modes"] = new ohnet.serviceproperty("Modes","string");
    this.serviceProperties["CanSkipNext"] = new ohnet.serviceproperty("CanSkipNext","bool");
    this.serviceProperties["CanSkipPrevious"] = new ohnet.serviceproperty("CanSkipPrevious","bool");
    this.serviceProperties["CanRepeat"] = new ohnet.serviceproperty("CanRepeat","bool");
    this.serviceProperties["CanShuffle"] = new ohnet.serviceproperty("CanShuffle","bool");
    this.serviceProperties["StreamId"] = new ohnet.serviceproperty("StreamId","int");
    this.serviceProperties["CanSeek"] = new ohnet.serviceproperty("CanSeek","bool");
    this.serviceProperties["CanPause"] = new ohnet.serviceproperty("CanPause","bool");
    this.serviceProperties["TransportState"] = new ohnet.serviceproperty("TransportState","string");
    this.serviceProperties["Repeat"] = new ohnet.serviceproperty("Repeat","bool");
    this.serviceProperties["Shuffle"] = new ohnet.serviceproperty("Shuffle","bool");

                                                            
    this.TransportStateAllowedValues = [];
    this.TransportStateAllowedValues.push("Playing");
    this.TransportStateAllowedValues.push("Paused");
    this.TransportStateAllowedValues.push("Stopped");
    this.TransportStateAllowedValues.push("Buffering");
    this.TransportStateAllowedValues.push("Waiting");
            
}



/**
* Subscribes the service to the subscription manager to listen for property change events
* @method Subscribe
* @param {Function} serviceAddedFunction The function that executes once the subscription is successful
*/
CpProxyAvOpenhomeOrgTransport1.prototype.subscribe = function (serviceAddedFunction) {
    ohnet.subscriptionmanager.addService(this,serviceAddedFunction);
}


/**
* Unsubscribes the service from the subscription manager to stop listening for property change events
* @method Unsubscribe
*/
CpProxyAvOpenhomeOrgTransport1.prototype.unsubscribe = function () {
    ohnet.subscriptionmanager.removeService(this.subscriptionId);
}


    

/**
* Adds a listener to handle "Modes" property change events
* @method Modes_Changed
* @param {Function} stateChangedFunction The handler for state changes
*/
CpProxyAvOpenhomeOrgTransport1.prototype.Modes_Changed = function (stateChangedFunction) {
    this.serviceProperties.Modes.addListener(function (state) 
    { 
        stateChangedFunction(ohnet.soaprequest.readStringParameter(state)); 
    });
}
    

/**
* Adds a listener to handle "CanSkipNext" property change events
* @method CanSkipNext_Changed
* @param {Function} stateChangedFunction The handler for state changes
*/
CpProxyAvOpenhomeOrgTransport1.prototype.CanSkipNext_Changed = function (stateChangedFunction) {
    this.serviceProperties.CanSkipNext.addListener(function (state) 
    { 
        stateChangedFunction(ohnet.soaprequest.readBoolParameter(state)); 
    });
}
    

/**
* Adds a listener to handle "CanSkipPrevious" property change events
* @method CanSkipPrevious_Changed
* @param {Function} stateChangedFunction The handler for state changes
*/
CpProxyAvOpenhomeOrgTransport1.prototype.CanSkipPrevious_Changed = function (stateChangedFunction) {
    this.serviceProperties.CanSkipPrevious.addListener(function (state) 
    { 
        stateChangedFunction(ohnet.soaprequest.readBoolParameter(state)); 
    });
}
    

/**
* Adds a listener to handle "CanRepeat" property change events
* @method CanRepeat_Changed
* @param {Function} stateChangedFunction The handler for state changes
*/
CpProxyAvOpenhomeOrgTransport1.prototype.CanRepeat_Changed = function (stateChangedFunction) {
    this.serviceProperties.CanRepeat.addListener(function (state) 
    { 
        stateChangedFunction(ohnet.soaprequest.readBoolParameter(state)); 
    });
}
    

/**
* Adds a listener to handle "CanShuffle" property change events
* @method CanShuffle_Changed
* @param {Function} stateChangedFunction The handler for state changes
*/
CpProxyAvOpenhomeOrgTransport1.prototype.CanShuffle_Changed = function (stateChangedFunction) {
    this.serviceProperties.CanShuffle.addListener(function (state) 
    { 
        stateChangedFunction(ohnet.soaprequest.readBoolParameter(state)); 
    });
}
    

/**
* Adds a listener to handle "StreamId" property change events
* @method StreamId_Changed
* @param {Function} stateChangedFunction The handler for state changes
*/
CpProxyAvOpenhomeOrgTransport1.prototype.StreamId_Changed = function (stateChangedFunction) {
    this.serviceProperties.StreamId.addListener(function (state) 
    { 
        stateChangedFunction(ohnet.soaprequest.readIntParameter(state)); 
    });
}
    

/**
* Adds a listener to handle "CanSeek" property change events
* @method CanSeek_Changed
* @param {Function} stateChangedFunction The handler for state changes
*/
CpProxyAvOpenhomeOrgTransport1.prototype.CanSeek_Changed = function (stateChangedFunction) {
    this.serviceProperties.CanSeek.addListener(function (state) 
    { 
        stateChangedFunction(ohnet.soaprequest.readBoolParameter(state)); 
    });
}
    

/**
* Adds a listener to handle "CanPause" property change events
* @method CanPause_Changed
* @param {Function} stateChangedFunction The handler for state changes
*/
CpProxyAvOpenhomeOrgTransport1.prototype.CanPause_Changed = function (stateChangedFunction) {
    this.serviceProperties.CanPause.addListener(function (state) 
    { 
        stateChangedFunction(ohnet.soaprequest.readBoolParameter(state)); 
    });
}
    

/**
* Adds a listener to handle "TransportState" property change events
* @method TransportState_Changed
* @param {Function} stateChangedFunction The handler for state changes
*/
CpProxyAvOpenhomeOrgTransport1.prototype.TransportState_Changed = function (stateChangedFunction) {
    this.serviceProperties.TransportState.addListener(function (state) 
    { 
        stateChangedFunction(ohnet.soaprequest.readStringParameter(state)); 
    });
}
    

/**
* Adds a listener to handle "Repeat" property change events
* @method Repeat_Changed
* @param {Function} stateChangedFunction The handler for state changes
*/
CpProxyAvOpenhomeOrgTransport1.prototype.Repeat_Changed = function (stateChangedFunction) {
    this.serviceProperties.Repeat.addListener(function (state) 
    { 
        stateChangedFunction(ohnet.soaprequest.readBoolParameter(state)); 
    });
}
    

/**
* Adds a listener to handle "Shuffle" property change events
* @method Shuffle_Changed
* @param {Function} stateChangedFunction The handler for state changes
*/
CpProxyAvOpenhomeOrgTransport1.prototype.Shuffle_Changed = function (stateChangedFunction) {
    this.serviceProperties.Shuffle.addListener(function (state) 
    { 
        stateChangedFunction(ohnet.soaprequest.readBoolParameter(state)); 
    });
}


/**
* A service action to PlayAs
* @method PlayAs
* @param {String} Mode An action parameter
* @param {String} Command An action parameter
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.PlayAs = function(Mode, Command, successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("PlayAs", this.url, this.domain, this.type, this.version);     
    request.writeStringParameter("Mode", Mode);
    request.writeStringParameter("Command", Command);
    request.send(function(result){
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to Play
* @method Play
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.Play = function(successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("Play", this.url, this.domain, this.type, this.version);     
    request.send(function(result){
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to Pause
* @method Pause
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.Pause = function(successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("Pause", this.url, this.domain, this.type, this.version);     
    request.send(function(result){
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to Stop
* @method Stop
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.Stop = function(successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("Stop", this.url, this.domain, this.type, this.version);     
    request.send(function(result){
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to SkipNext
* @method SkipNext
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.SkipNext = function(successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("SkipNext", this.url, this.domain, this.type, this.version);     
    request.send(function(result){
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to SkipPrevious
* @method SkipPrevious
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.SkipPrevious = function(successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("SkipPrevious", this.url, this.domain, this.type, this.version);     
    request.send(function(result){
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to SetRepeat
* @method SetRepeat
* @param {Boolean} Repeat An action parameter
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.SetRepeat = function(Repeat, successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("SetRepeat", this.url, this.domain, this.type, this.version);     
    request.writeBoolParameter("Repeat", Repeat);
    request.send(function(result){
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to SetShuffle
* @method SetShuffle
* @param {Boolean} Shuffle An action parameter
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.SetShuffle = function(Shuffle, successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("SetShuffle", this.url, this.domain, this.type, this.version);     
    request.writeBoolParameter("Shuffle", Shuffle);
    request.send(function(result){
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to SeekSecondAbsolute
* @method SeekSecondAbsolute
* @param {Int} StreamId An action parameter
* @param {Int} SecondAbsolute An action parameter
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.SeekSecondAbsolute = function(StreamId, SecondAbsolute, successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("SeekSecondAbsolute", this.url, this.domain, this.type, this.version);     
    request.writeIntParameter("StreamId", StreamId);
    request.writeIntParameter("SecondAbsolute", SecondAbsolute);
    request.send(function(result){
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to SeekSecondRelative
* @method SeekSecondRelative
* @param {Int} StreamId An action parameter
* @param {Int} SecondRelative An action parameter
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.SeekSecondRelative = function(StreamId, SecondRelative, successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("SeekSecondRelative", this.url, this.domain, this.type, this.version);     
    request.writeIntParameter("StreamId", StreamId);
    request.writeIntParameter("SecondRelative", SecondRelative);
    request.send(function(result){
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to TransportState
* @method TransportState
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.TransportState = function(successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("TransportState", this.url, this.domain, this.type, this.version);     
    request.send(function(result){
        result["State"] = ohnet.soaprequest.readStringParameter(result["State"]); 
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to Modes
* @method Modes
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.Modes = function(successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("Modes", this.url, this.domain, this.type, this.version);     
    request.send(function(result){
        result["Modes"] = ohnet.soaprequest.readStringParameter(result["Modes"]); 
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to ModeInfo
* @method ModeInfo
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.ModeInfo = function(successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("ModeInfo", this.url, this.domain, this.type, this.version);     
    request.send(function(result){
        result["CanSkipNext"] = ohnet.soaprequest.readBoolParameter(result["CanSkipNext"]); 
        result["CanSkipPrevious"] = ohnet.soaprequest.readBoolParameter(result["CanSkipPrevious"]); 
        result["CanRepeat"] = ohnet.soaprequest.readBoolParameter(result["CanRepeat"]); 
        result["CanShuffle"] = ohnet.soaprequest.readBoolParameter(result["CanShuffle"]); 
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to StreamInfo
* @method StreamInfo
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.StreamInfo = function(successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("StreamInfo", this.url, this.domain, this.type, this.version);     
    request.send(function(result){
        result["StreamId"] = ohnet.soaprequest.readIntParameter(result["StreamId"]); 
        result["CanSeek"] = ohnet.soaprequest.readBoolParameter(result["CanSeek"]); 
        result["CanPause"] = ohnet.soaprequest.readBoolParameter(result["CanPause"]); 
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to StreamId
* @method StreamId
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.StreamId = function(successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("StreamId", this.url, this.domain, this.type, this.version);     
    request.send(function(result){
        result["StreamId"] = ohnet.soaprequest.readIntParameter(result["StreamId"]); 
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to Repeat
* @method Repeat
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.Repeat = function(successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("Repeat", this.url, this.domain, this.type, this.version);     
    request.send(function(result){
        result["Repeat"] = ohnet.soaprequest.readBoolParameter(result["Repeat"]); 
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}


/**
* A service action to Shuffle
* @method Shuffle
* @param {Function} successFunction The function that is executed when the action has completed successfully
* @param {Function} errorFunction The function that is executed when the action has cause an error
*/
CpProxyAvOpenhomeOrgTransport1.prototype.Shuffle = function(successFunction, errorFunction){ 
    var request = new ohnet.soaprequest("Shuffle", this.url, this.domain, this.type, this.version);     
    request.send(function(result){
        result["Shuffle"] = ohnet.soaprequest.readBoolParameter(result["Shuffle"]); 
    
        if (successFunction){
            successFunction(result);
        }
    }, function(message, transport) {
        if (errorFunction) {errorFunction(message, transport);}
    });
}



