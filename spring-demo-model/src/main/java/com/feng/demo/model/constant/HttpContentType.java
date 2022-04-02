package com.feng.demo.model.constant;

/**
 * @author fengyadong
 * @date 2022/4/2 10:32 上午
 * @Description MIME 规定返回数据的 content-type
 * @see https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
 */
public class HttpContentType {

    public static final String TEXT = "text/plain";

    public static final String HTML = "text/html";

    public static final String JSON = "application/json";

    // 下载可以使用这个
    public static final String BIN = "application/octet-stream";

    public static final String PDF = "application/pdf";


    private HttpContentType() {
    }

}
