package com.github.gserv.serv.commons.restclient;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;


import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @title：使用spring的restTemplate替代httpclient工具
 * @author：456
 * @date： 2016-07-01
 */
public class RestClientBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestClientBuilder.class);

    private static RestTemplate restTemplate;

    /** 连接超时时间，由bean factory设置，缺省为5秒钟 */
    private static int                        defaultConnectionTimeout            = 50*1000;
    
    /** 回应超时时间, 由bean factory设置，缺省为30秒钟 */
    private static int                        defaultSoTimeout                    = 50*1000;
    /** 闲置连接超时时间, 由bean factory设置，缺省为60秒钟 */
    private static int                        defaultIdleConnTimeout              = 60*1000;

    //DefaultMaxPerRoute是根据连接到的主机对MaxTotal的一个细分；比如：
    //MaxtTotal=400 DefaultMaxPerRoute=200 
    //而我只连接到http://sishuok.com时，到这个主机的并发最多只有200；而不是400；
    //而我连接到http://sishuok.com 和 http://qq.com时，到每个主机的并发最多只有200；
    //即加起来是400（但不能超过400）；所以起作用的设置是DefaultMaxPerRoute。
    private static int                        defaultMaxPerRoute               = 800;
    /**连接池最大连接数*/
    private static int                        defaultMaxTotalConn                 = 800;

    /** 默认等待HttpConnectionManager返回连接超时（只有在达到最大连接数时起作用）：1秒*/
//    private static final long          defaultHttpConnectionManagerTimeout = 3 * 1000;
     
    static {
    
    	//-------------------兼容无效证书https----------------------
    	
    	SSLContext ctx = null;
 		
    	try {
 			ctx = SSLContext.getInstance("TLS");
 			ctx.init(null, new TrustManager[] { new TrustAnyTrustManager() }, null);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		
    	HttpClientBuilder builder = HttpClientBuilder.create();
 		
 		SSLConnectionSocketFactory sslConnectionFactory = new SSLConnectionSocketFactory(ctx,
 				NoopHostnameVerifier.INSTANCE);
 		
 		builder.setSSLSocketFactory(sslConnectionFactory);
  
 		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create()
 				.register("http", PlainConnectionSocketFactory.INSTANCE)
 				.register("https", sslConnectionFactory).build();
    	
    	//--------------------兼容无效证书https-------------------------
 		
        // 长连接保持30秒
        PoolingHttpClientConnectionManager pollingConnectionManager = new PoolingHttpClientConnectionManager(registry);
        // 总连接数
        pollingConnectionManager.setMaxTotal(defaultMaxTotalConn);
        // 同路由的并发数
        pollingConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        
        
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        
        httpClientBuilder.setConnectionManager(pollingConnectionManager);
        // 重试次数，默认是3次，没有开启
        //httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(2, true));
        
        //当前是禁用掉重试次数
        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        
        // 保持长连接配置，需要在头添加Keep-Alive
        httpClientBuilder.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE);

        
        
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36"));
        headers.add(new BasicHeader("Accept-Encoding", ""));
        headers.add(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6"));
        headers.add(new BasicHeader("Connection", "keep-alive"));

        httpClientBuilder.setDefaultHeaders(headers);
        
        httpClientBuilder.disableContentCompression();//禁止自动解压缩
        
        HttpClient httpClient = httpClientBuilder.build();

        // httpClient连接配置，底层是配置RequestConfig
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        // 连接超时
        clientHttpRequestFactory.setConnectTimeout(defaultConnectionTimeout);
        // 数据读取超时时间，即SocketTimeout
        clientHttpRequestFactory.setReadTimeout(defaultSoTimeout);
        // 连接不够用的等待时间，不宜过长，必须设置，比如连接不够用时，时间过长将是灾难性的
        clientHttpRequestFactory.setConnectionRequestTimeout(200);
        // 缓冲请求数据，默认值是true。通过POST或者PUT大量发送数据时，建议将此属性更改为false，以免耗尽内存。
        // clientHttpRequestFactory.setBufferRequestBody(false);

        // 添加内容转换器
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new MyFormHttpMessageConverter());
        messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        messageConverters.add(new ByteArrayHttpMessageConverter());

        restTemplate = new RestTemplate(messageConverters);
        restTemplate.setRequestFactory(clientHttpRequestFactory);
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());


        LOGGER.info("RestClient初始化完成");
        
    }

    private RestClientBuilder() {

    }

    public static RestTemplate build() {
        return restTemplate;
    }

    
	private static class TrustAnyTrustManager implements X509TrustManager {
		
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}
		
		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}
	
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}

	}
	
    
}

