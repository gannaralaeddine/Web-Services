package gannar.webservices.Retro;

import java.util.List;

import gannar.webservices.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitInterface
{

    //Get all users
    @GET("api/Users1")
    public Call <List<User>> getUsers();

    //Get user by id
    @GET("api/Users1/{Id}")
    public Call <User> getUserById(@Path("Id") int id);

    //Delete user by id
    @DELETE("api/Users1/{Id}")
    public Call <User> deleteUserById(@Path("Id") int id);

    //Add user instance
    @POST("api/Users1")
    public Call <User> addUser(@Body User user);

    //Add user fields
    @POST("api/Users1")
    public Call <User> addUser(@Field("Email") String email,
                                    @Field("FName") String firstName,
                                    @Field("LName") String lastName,
                                    @Field("PhoneNumber") String phoneNumber,
                                    @Field("Age") String age,
                                    @Field("Country") String country);

    //Update user
    @PUT("api/Users1/{Id}")
    public Call <User> updateUser(@Path("Id") int id,
                                  @Field("Email") String email,
                                  @Field("FName") String firstName,
                                  @Field("LName") String lastName,
                                  @Field("PhoneNumber") String phoneNumber,
                                  @Field("Age") String age,
                                  @Field("Country") String country);

    //Update user
    @PUT("api/Users1/{Id}")
    public Call <User> updateUser(@Path("Id") int id, @Body User user);
}
