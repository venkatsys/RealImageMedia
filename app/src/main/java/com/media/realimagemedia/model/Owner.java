package com.media.realimagemedia.model;

/**
 * Created by Venkat on 03-03-2016.
 */
public class Owner
{
    private Integer user_id;
    private String display_name;
    private String user_type;
    private Integer accept_rate;
    private Integer reputation;
    private String link;
    private String profile_image;

    public void setUser_id(Integer paramInteger)
    {
        this.user_id = paramInteger;
    }

    public Integer getUser_id()
    {
        return this.user_id;
    }

    public void setDisplay_name(String paramString)
    {
        this.display_name = paramString;
    }

    public String getDisplay_name()
    {
        return this.display_name;
    }

    public void setUser_type(String paramString)
    {
        this.user_type = paramString;
    }

    public String getUser_type()
    {
        return this.user_type;
    }

    public void setAccept_rate(Integer paramInteger)
    {
        this.accept_rate = paramInteger;
    }

    public Integer getAccept_rate()
    {
        return this.accept_rate;
    }

    public void setReputation(Integer paramInteger)
    {
        this.reputation = paramInteger;
    }

    public Integer getReputation()
    {
        return this.reputation;
    }

    public void setLink(String paramString)
    {
        this.link = paramString;
    }

    public String getLink()
    {
        return this.link;
    }

    public void setProfile_image(String paramString)
    {
        this.profile_image = paramString;
    }

    public String getProfile_image()
    {
        return this.profile_image;
    }
}
