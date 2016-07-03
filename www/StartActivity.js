'use strict';

var exec = require('cordova/exec');




var StartActivity = 
{};

StartActivity.launchApp = function(appName, success, error) {


	exec(success, error, 'StartActivity', 'launchApp', [appName]);


}
StartActivity.launchSpecificApp = function(appName, success, error) {

	exec(success, error, "StartActivity", 'launchSpecificApp', [appName]);


}
StartActivity.launchAppForResults : function(appName, success, error) {


    	exec(success, error, 'StartActivity', 'launchAppForResults', [appName]);


}
StartActivity.recieveResults : function(appName, success, error) {


    	exec(success, error, 'StartActivity', 'recieveResults', []);


}



module.exports = StartActivity;
