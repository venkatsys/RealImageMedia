package com.media.realimagemedia.model;

/**
 * Created by Venkat on 03-03-2016.
 */
public class ItemElement
{
    private Integer answer_count;
    private Integer score;
    private Integer last_activity_date;
    private Integer bounty_closes_date;
    private String link;
    private Integer last_edit_date;
    private Integer question_id;
    private Integer view_count;
    private String[] tags;
    private Integer bounty_amount;
    private Integer creation_date;
    private Owner owner;
    private Boolean is_answered;
    private String title;

    public void setAnswer_count(Integer paramInteger)
    {
        this.answer_count = paramInteger;
    }

    public Integer getAnswer_count()
    {
        return this.answer_count;
    }

    public void setScore(Integer paramInteger)
    {
        this.score = paramInteger;
    }

    public Integer getScore()
    {
        return this.score;
    }

    public void setLast_activity_date(Integer paramInteger)
    {
        this.last_activity_date = paramInteger;
    }

    public Integer getLast_activity_date()
    {
        return this.last_activity_date;
    }

    public void setBounty_closes_date(Integer paramInteger)
    {
        this.bounty_closes_date = paramInteger;
    }

    public Integer getBounty_closes_date()
    {
        return this.bounty_closes_date;
    }

    public void setLink(String paramString)
    {
        this.link = paramString;
    }

    public String getLink()
    {
        return this.link;
    }

    public void setLast_edit_date(Integer paramInteger)
    {
        this.last_edit_date = paramInteger;
    }

    public Integer getLast_edit_date()
    {
        return this.last_edit_date;
    }

    public void setQuestion_id(Integer paramInteger)
    {
        this.question_id = paramInteger;
    }

    public Integer getQuestion_id()
    {
        return this.question_id;
    }

    public void setView_count(Integer paramInteger)
    {
        this.view_count = paramInteger;
    }

    public Integer getView_count()
    {
        return this.view_count;
    }

    public void setTags(String[] paramArrayOfString)
    {
        this.tags = paramArrayOfString;
    }

    public String[] getTags()
    {
        return this.tags;
    }

    public void setBounty_amount(Integer paramInteger)
    {
        this.bounty_amount = paramInteger;
    }

    public Integer getBounty_amount()
    {
        return this.bounty_amount;
    }

    public void setCreation_date(Integer paramInteger)
    {
        this.creation_date = paramInteger;
    }

    public Integer getCreation_date()
    {
        return this.creation_date;
    }

    public void setOwner(Owner paramOwner)
    {
        this.owner = paramOwner;
    }

    public Owner getOwner()
    {
        return this.owner;
    }

    public void setIs_answered(Boolean paramBoolean)
    {
        this.is_answered = paramBoolean;
    }

    public Boolean getIs_answered()
    {
        return this.is_answered;
    }

    public void setTitle(String paramString)
    {
        this.title = paramString;
    }

    public String getTitle()
    {
        return this.title;
    }
}
