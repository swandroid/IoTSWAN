package interdroid.swan.sensors.impl;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.HashMap;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Roshan Bharath Das on 27/11/15.
 */
public class ServerConnection {

    Gson gson;
    RestAdapter eventResultsAdapter;
    private ServerCallbackInterface serverCallbackInterface;
    String serverStorage;
    String serverUrl;
    String serverHttpMethod;
    String serverHttpAuthorization;
    String serverHttpHeader;
    String serverHttpBody;
    HashMap<String, String> headers;

    public interface GenericAPIInterface {
        @GET("")
        void getData();

        @POST("")
        void postData();
    }
    public class MyRetrofitInterceptor implements RequestInterceptor {

        @Override
        public void intercept(RequestFacade req) {
            // TODO: Iterate hash map
                // get every pair
                //req.addHeader(key1, value1);
//            }

            // TODO: Authorization
//            req.addHeader("Authorization", string);

        }
    }

    ServerConnection(Bundle httpConfig){

        //httpConfig.getString("");

        // TODO
        // 1. Parse bundle
        // 2. Parse header value string to a HashMap<String, String> of (keyHeaderX, valueHeaderX) pairs

        // 3. get server url,
        serverUrl = httpConfig.getString("server_url");
        gson = new GsonBuilder().create();

        eventResultsAdapter = new RestAdapter.Builder()
                .setRequestInterceptor(new MyRetrofitInterceptor())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .setEndpoint(serverUrl)
                .build();

        GenericAPIInterface service = eventResultsAdapter.create(GenericAPIInterface.class);

        //TODO: method
        if (serverHttpMethod.equals("GET")){
            service.getData();
        } else if (serverHttpMethod.equals("POST")){
            service.postData();
        }
    }


    public void postMethod(String content){

        eventResultsAdapter.create(ServerAPI.class).postInfo(content, new Callback<String>(){
            @Override
            public void success(String result, Response response) {

             serverCallbackInterface.execute(result,response);
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error);
            }
        });


    }





    public void postFormMethod(String key, String field1){

        eventResultsAdapter.create(ServerAPI.class).postFormInfo(key, field1, new Callback<String>(){
            @Override
            public void success(String result, Response response) {

                //serverCallbackInterface.execute(result,response);
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error);
            }
        });


    }




    public void putMethod(String content){

        eventResultsAdapter.create(ServerAPI.class).putInfo(content, new Callback<String>() {
            @Override
            public void success(String result, Response response) {

                serverCallbackInterface.execute(result, response);
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error);
            }
        });


    }


    public void getMethod(){

        eventResultsAdapter.create(ServerAPI.class).getInfo(new Callback<String>(){
            @Override
            public void success(String result, Response response) {
                serverCallbackInterface.execute(result,response);
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error);
            }
        });
    }




}
