package com.aituNet.aituNet;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class PostRequest {

    private int id;
    private String name;
    private Date date;
    private String text;
    private String email;
}
