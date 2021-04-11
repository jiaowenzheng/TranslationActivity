package com.translation.mqtt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hivemq.client.mqtt.datatypes.MqttQos
import com.hivemq.client.mqtt.mqtt3.Mqtt3BlockingClient
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client
import java.nio.charset.StandardCharsets
import java.util.*
import java.util.function.Consumer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createClient()
    }

    private fun createClient(){
        //创建阻塞式client
        val client = Mqtt5Client.builder()
            .identifier(UUID.randomUUID().toString())
            .serverHost("broker.hivemq.com")
            .automaticReconnectWithDefaultConfig()
            .buildBlocking()

        //链接 并发送一个消息
        client.connect()

        client.toAsync()
            .subscribeWith()
            .topicFilter("test/topic")
            .qos(MqttQos.AT_LEAST_ONCE)
            .callback(Consumer {
               println(" topic = ${it.topic} message=${String(it.payloadAsBytes,StandardCharsets.UTF_8)}")
            })
            .send()
    }

}