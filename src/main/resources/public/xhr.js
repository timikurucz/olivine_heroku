'use strict';

var xhrRequests = (function() {
  var host = 'https://calorie-app-java.herokuapp.com';

  function createRequest(requestType, endPoint, dataToSend, cb)  {
    var xhr = new XMLHttpRequest();
    xhr.open(requestType, endPoint);
    xhr.setRequestHeader('content-type', 'application/json; charset=utf-8');
    xhr.onload = function () {
      if (cb !== undefined) {
        var response = JSON.parse(xhr.response);
        cb(response);
      }
    };
    xhr.send(dataToSend);
  }
  return {
    createRequest:createRequest
  };
}());
