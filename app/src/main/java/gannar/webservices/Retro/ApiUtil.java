package gannar.webservices.Retro;

public class ApiUtil
{
    private static final String BASE_URL = "https://evenement.azurewebsites.net/";

    public static RetrofitInterface getRetrofitClass()
    {
        return RetrofitApi.getRetrofit(BASE_URL).create(RetrofitInterface.class);
    }

}
