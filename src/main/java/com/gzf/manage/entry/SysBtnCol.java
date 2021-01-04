package com.gzf.manage.entry;

public class SysBtnCol extends BaseEntry{
    private Integer id;

    private String sysName;

    private String btnName;

    private String btnSize;

    private String btnLogo;

    private String backgroundColor;

    private String triggerEvent;

    private String notes;

    private String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    public String getBtnName() {
        return btnName;
    }

    public void setBtnName(String btnName) {
        this.btnName = btnName == null ? null : btnName.trim();
    }

    public String getBtnSize() {
        return btnSize;
    }

    public void setBtnSize(String btnSize) {
        this.btnSize = btnSize == null ? null : btnSize.trim();
    }

    public String getBtnLogo() {
        return btnLogo;
    }

    public void setBtnLogo(String btnLogo) {
        this.btnLogo = btnLogo == null ? null : btnLogo.trim();
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor == null ? null : backgroundColor.trim();
    }

    public String getTriggerEvent() {
        return triggerEvent;
    }

    public void setTriggerEvent(String triggerEvent) {
        this.triggerEvent = triggerEvent == null ? null : triggerEvent.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }
}