package com.aituNet.aituNet.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SendByAndSendToRequest {
    Integer sendBy;
    Integer sendTo;
}
