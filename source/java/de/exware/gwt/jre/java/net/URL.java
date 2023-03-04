package java.net;

public class URL
{
    private String url;
    
    public URL(String url)
    {
        this.url = url;
    }
    
    public String toExternalForm()
    {
        return url;
    }
}
