var http = require('http');
var request = require('request');
var parse = require('parse-json-response');
var jsonfile = require('jsonfile');
var fs = require('fs');
var sleep = require('sleep');
var Stream = require('stream').Transform;

 var requestLoop = setInterval(function(){
  request({
      url: "http://pluton.datsi.fi.upm.es:8484/WeatherStation/properties/state",
      method: "GET",
      headers: {"Accept":"application/json"},
      timeout: 30000,
      followRedirect: true,
      maxRedirects: 1
  },function(error, response, body){
      if(!error && response.statusCode == 200){
          //console.log(body);
          var obj = JSON.parse(body);
          var file = '/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/states/weatherStation.json';
          jsonfile.writeFile(file, obj, function (err) {
            console.error(err)
          })
	      //console.log(obj);
      }else{
      //console.log(error);
      }
  });

  request({
        url: "http://pluton.datsi.fi.upm.es:8484/Dome/properties/state",
        method: "GET",
        headers: {"Accept":"application/json"},
        timeout: 30000,
        followRedirect: true,
        maxRedirects: 1
    },function(error, response, body){
        if(!error && response.statusCode == 200){
            //console.log(body);
            var obj = JSON.parse(body);
            var file = '/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/states/dome.json';
            jsonfile.writeFile(file, obj, function (err) {
              console.error(err)
            })
  	      //console.log(obj);
        }else{
        //console.log(error);
        }
    });

    request({
            url: "http://pluton.datsi.fi.upm.es:8484/Mount/properties/state",
            method: "GET",
            headers: {"Accept":"application/json"},
            timeout: 30000,
            followRedirect: true,
            maxRedirects: 1
        },function(error, response, body){
            if(!error && response.statusCode == 200){
                //console.log(body);
                var obj = JSON.parse(body);
                var file = '/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/states/mount.json';
                jsonfile.writeFile(file, obj, function (err) {
                  console.error(err)
                })
      	      //console.log(obj);
            }else{
            //console.log(error);
            }
    });
    request({
       url: "http://pluton.datsi.fi.upm.es:8484/Camera/properties/state",
       method: "GET",
       headers: {"Accept":"application/json"},
       timeout: 30000,
       followRedirect: true,
       maxRedirects: 1
       },function(error, response, body){
         if(!error && response.statusCode == 200){
           //console.log(body);
           var obj = JSON.parse(body);
           var file = '/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/states/cameraDMK.json';
           jsonfile.writeFile(file, obj, function (err) {
           console.error(err)
         })
         //console.log(obj);
         }else{
           //console.log(error);
         }
       });
    request({
       url: "http://pluton.datsi.fi.upm.es:8484/Camera_inside/properties/state",
       method: "GET",
       headers: {"Accept":"application/json"},
       timeout: 30000,
       followRedirect: true,
       maxRedirects: 1
       },function(error, response, body){
         if(!error && response.statusCode == 200){
           //console.log(body);
           var obj = JSON.parse(body);
           var file = '/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/states/cameraIN.json';
           jsonfile.writeFile(file, obj, function (err) {
           console.error(err)
         })
         //console.log(obj);
         }else{
           //console.log(error);
         }
       });

    request({
       url: "http://pluton.datsi.fi.upm.es:8484/Camera_outside/properties/state",
       method: "GET",
       headers: {"Accept":"application/json"},
       timeout: 30000,
       followRedirect: true,
       maxRedirects: 1
       },function(error, response, body){
         if(!error && response.statusCode == 200){
           //console.log(body);
           var obj = JSON.parse(body);
           var file = '/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/states/cameraOUT.json';
           jsonfile.writeFile(file, obj, function (err) {
           console.error(err)
         })
         //console.log(obj);
         }else{
           //console.log(error);
         }
       });

       request({
              url: "http://pluton.datsi.fi.upm.es:8484/WeatherStation/properties/temperature",
              method: "GET",
              headers: {"Accept":"application/json"},
              timeout: 30000,
              followRedirect: true,
              maxRedirects: 1
              },function(error, response, body){
                if(!error && response.statusCode == 200){
                  //console.log(body);
                  var obj = JSON.parse(body);
                  var file = '/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/alarms/WStemperature.json';
                  jsonfile.writeFile(file, obj, function (err) {
                  console.error(err)
                })
                //console.log(obj);
                }else{
                  //console.log(error);
                }
              });

            request({
              url: "http://pluton.datsi.fi.upm.es:8484/WeatherStation/properties/rainfall",
              method: "GET",
              headers: {"Accept":"application/json"},
              timeout: 30000,
              followRedirect: true,
              maxRedirects: 1
              },function(error, response, body){
                if(!error && response.statusCode == 200){
                  //console.log(body);
                  var obj = JSON.parse(body);
                  var file = '/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/alarms/WSrain.json';
                  jsonfile.writeFile(file, obj, function (err) {
                  console.error(err)
                })
                //console.log(obj);
                }else{
                  //console.log(error);
                }
              });

            request({
              url: "http://pluton.datsi.fi.upm.es:8484/WeatherStation/properties/windSpeed",
              method: "GET",
              headers: {"Accept":"application/json"},
              timeout: 30000,
              followRedirect: true,
              maxRedirects: 1
              },function(error, response, body){
                if(!error && response.statusCode == 200){
                  //console.log(body);
                  var obj = JSON.parse(body);
                  var file = '/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/alarms/WSwind.json';
                  jsonfile.writeFile(file, obj, function (err) {
                  console.error(err)
                })
                //console.log(obj);
                }else{
                  //console.log(error);
                }
              });
}, 30000);