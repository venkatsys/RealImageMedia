package com.media.realimagemedia.model;

/**
 * Created by Venkat on 03-03-2016.
 */
public class StackoverflowData {
    private Integer quota_remaining;
    private Integer quota_max;
    private Boolean has_more;
    private ItemElement[] items;

    public void setQuota_remaining(Integer paramInteger) {
        this.quota_remaining = paramInteger;
    }

    public Integer getQuota_remaining() {
        return this.quota_remaining;
    }

    public void setQuota_max(Integer paramInteger) {
        this.quota_max = paramInteger;
    }

    public Integer getQuota_max() {
        return this.quota_max;
    }

    public void setHas_more(Boolean paramBoolean) {
        this.has_more = paramBoolean;
    }

    public Boolean getHas_more() {
        return this.has_more;
    }

    public void setItems(ItemElement[] paramArrayOfItemElement) {
        this.items = paramArrayOfItemElement;
    }

    public ItemElement[] getItems() {
        return this.items;
    }
}
