<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/paho-mqtt/1.0.1/mqttws31.js"></script>
    <script>
        var client;
        var form = document.getElementById("tutorial");

        function doConnect() {
            client = new Paho.MQTT.Client("m13.cloudmqtt.com", 35456, "client");
            client.onConnect = onConnect;
            client.onMessageArrived = onMessageArrived;
            client.onConnectionLost = onConnectionLost;

            var options = {
                userName: "lzgnfwsn",
                password: "t5I3zShOEwyP",
                onSuccess: onConnect
            };

            client.connect(options);
        }

        function doSubscribe() {
            client.subscribe("/World");
        }

        function doSend() {
            message = new Messagin.Message("Hello");
            message.destunationName = "/World";
            client.send(message);
        }

        function doDisconnect() {
            client.disconnet();
        }

        //web Messaging API callbacks
        function onConnect() {
            var form = document.getElementById("example");
            form.connected.checked = true;
        }

        function onConnectionLost(responseObject) {
            var form = document.getElementById("example");
            form.connected.checked = false;
            if (responseObject.errorCode !== 0)
                alert(client.clientId + "\n" + responseObject.errorCode);
        }

        function onMessageArrived(message) {
            var form = document.getElementById("example");
            form.receiveMsg.value = message.palylodString;
        }
    </script>
</head>
<body>
<h1>Example Web Messaging web page.</h1>
<form id="example">
    <fieldset>
        <legend id="Connect">Connect</legend>
        Make a connection to the server, and set up a call back used if a message arrives foe this client.<br>
        <input type="button" value="Connect" onclick="doConnect(this.form)" name="Connect"/>
        <input type="checkbox" name="connected" disabled="disabled"/>
    </fieldset>

    <fieldset>
        <legend id="Subscribe">Subscribe</legend>
        Make a subscription to topic "/World".<br>
        <input type="button" value="Subscribe" onclick="doSubscribe(this.form)"/>
    </fieldset>

    <fieldset>
        <legend id="Send"> Send</legend>
        Create a Message object containing the word "Hello" and then publish it at the server.<br>
        <input type="button" value="Send" onclick="doSend(this.form)"/>
    </fieldset>

    <fieldset>
        <legned id="Receive"> Receive</legnedid>
            A copy of the published Message id receive in the callback we created earlier.
            <textarea name="receivMsg" rows="1" cols="40" disable="disable"></textarea>
    </fieldset>

    <fieldset>
        <legend id="Disconnect">Disconnect</legend>
        Now disconnect this client from the server.<br>
        <input type="button" value="Disconnect" onclick="doDisconnect()"/>
    </fieldset>
</form>
</body>
</html>