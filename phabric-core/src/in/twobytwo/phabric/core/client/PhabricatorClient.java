package in.twobytwo.phabric.core.client;

import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import in.twobytwo.phabric.core.model.PhResponse;
import in.twobytwo.phabric.core.model.PhUser;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PhabricatorClient {
	private String remoteUrl;
	private String apiToken;
	private static final String KW_API = "/api";

	public PhabricatorClient(String remoteUrl, String apiToken) {
		while (remoteUrl != null && remoteUrl.endsWith("/")) {
			remoteUrl = remoteUrl.substring(0, remoteUrl.length() - 2);
		}
		this.remoteUrl = remoteUrl;
		this.apiToken = apiToken;
	}

	public PhUser whoAmI() {
		OkHttpClient client = new OkHttpClient();
		Gson gson = new Gson();
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "api.token=" + apiToken);

		Request request = new Request.Builder() //
				.url(remoteUrl + KW_API + "/user.whoami") //
				.post(body) //
				.addHeader("content-type", "application/x-www-form-urlencoded") //
				.build();
		try {
			Response response = client.newCall(request).execute();
			if (!response.isSuccessful()) {
				System.out.println("response unsuccessful.");
				return null;
			}
			Type restype = new TypeToken<PhResponse<PhUser>>() {
			}.getType();
			String output = response.body().string();
			System.out.println(output);
			PhResponse<PhUser> phresp = gson.fromJson(output, restype);
			if (phresp == null || phresp.getError_code() != null) {
				return null;
			} else
				return phresp.getResult();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}
