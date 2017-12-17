package httpclientdemo;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpclientTest {
	
	public static void main(String[] args) {
		try {
			// 创建httpClient请求客户端
			HttpClient httpclient = new DefaultHttpClient();
			
			// 创建一个get请求
			HttpGet httpget = new HttpGet("http://127.0.0.1:8080/javaweb.demo.one/HelloWorldServlet");

			// 通过请求对象获取响应对象
			HttpResponse response = httpclient.execute(httpget);
			
			// 判断网络连接状态码是否正常(0--200都数正常)
			String result = "";
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// 获取响应体内容
				result = EntityUtils.toString(response.getEntity(), "utf-8");
			}
			System.out.println(result);
			
			// 获取所有的响应头
			Header[] allHeaders = response.getAllHeaders();
			for (Header header : allHeaders) {
				System.out.println(header);
			}
			
			// 获取响应状态码
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println(statusCode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
