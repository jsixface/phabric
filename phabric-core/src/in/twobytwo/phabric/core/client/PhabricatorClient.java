package in.twobytwo.phabric.core.client;

import com.google.gson.Gson;

import in.twobytwo.phabric.core.model.PhUser;

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
//		OkHttpClient client = new OkHttpClient();
		Gson gson = new Gson();
//		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//		RequestBody body = RequestBody.create(mediaType, "api.token=" + apiToken);
//		Request request = new Request.Builder().url(remoteUrl + KW_API + "/user.whoami").post(body)
//				.addHeader("content-type", "application/x-www-form-urlencoded").build();
//		try {
//			Response response = client.newCall(request).execute();
//			if (!response.isSuccessful()) {
//				System.out.println("response unsuccessful.");
//				return null;
//			}
//			Type restype = new TypeToken<PhResponse<PhUser>>() {
//			}.getType();
//			PhResponse<PhUser> phresp = gson.fromJson(response.body().charStream(), restype);
//			if (phresp == null || phresp.getErrorCode() != null) {
//				return null;
//			} else
//				return phresp.getPayload();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return null;

	}

}
