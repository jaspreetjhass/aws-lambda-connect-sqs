package com.springbank.handlers;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;

public class MessagePushHandler extends SpringBootRequestHandler<SQSEvent, String> {

}
