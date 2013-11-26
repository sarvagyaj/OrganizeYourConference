package edu.sjsu.oauth;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import edu.sjsu.conference.domain.User;
import edu.sjsu.conference.util.ClassConstant;

public class LinkedInHelper {
	

	public static User getUserDetails(String code) {
		HttpClient client = new DefaultHttpClient();
		User user = new User();
		try {
			HttpPost post = new HttpPost(
					"https://www.linkedin.com/uas/oauth2/accessToken");
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("grant_type",
					"authorization_code"));
			nameValuePairs.add(new BasicNameValuePair("redirect_uri",
					"http://"+ClassConstant.REDIRECT_URI+"/organize-your-conference/linkedin"));
			nameValuePairs.add(new BasicNameValuePair("client_id",
					"9xb4aca5h8ka"));
			nameValuePairs.add(new BasicNameValuePair("client_secret",
					"ZzaMXyNBkZYw3M6Z"));
			nameValuePairs.add(new BasicNameValuePair("code", code));

			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = client.execute(post);

			if (response != null
					&& response.getStatusLine().getStatusCode() == 200) {
				String json = EntityUtils.toString(response.getEntity());
				JSONObject jsobObj = new JSONObject(json);
				String accessToken = jsobObj.getString("access_token");

				HttpGet get = new HttpGet(
						"https://api.linkedin.com/v1/people/~:(id,first-name,last-name,industry,email-address,headline,location:(name))?format=json&oauth2_access_token="
								+ accessToken);
				HttpResponse response_get = client.execute(get);

				if (response_get != null
						&& response_get.getStatusLine().getStatusCode() == 200) {
					String userJson = EntityUtils.toString(response_get
							.getEntity());
					JSONObject jsonUserObj = new JSONObject(userJson);

					user.setEmailId(jsonUserObj.getString("emailAddress"));
					user.setFirstName(jsonUserObj.getString("firstName"));
					user.setLastName(jsonUserObj.getString("lastName"));
					user.setPosition(jsonUserObj.getString("headline"));
					user.setLocation(jsonUserObj.getJSONObject("location")
							.getString("name"));
					return user;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
