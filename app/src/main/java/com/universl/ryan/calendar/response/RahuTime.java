package com.universl.ryan.calendar.response;

import com.google.gson.annotations.SerializedName;

public class RahuTime {
    @SerializedName("id")
    private String id;

    @SerializedName("day")
    private String day;

    @SerializedName("date")
    private String date;

    @SerializedName("sun_raise_time")
    private String sun_raise_time;

    @SerializedName("sun_fall_time")
    private String sun_fall_time;

    @SerializedName("day_rahu_start_time")
    private String day_rahu_start_time;

    @SerializedName("day_rahu_end_time")
    private String day_rahu_end_time;

    @SerializedName("night_rahu_start_time")
    private String night_rahu_start_time;

    @SerializedName("night_rahu_end_time")
    private String night_rahu_end_time;

    @SerializedName("suba_dishawa")
    private String suba_dishawa;

    @SerializedName("maru_dishawa")
    private String maru_dishawa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSun_raise_time() {
        return sun_raise_time;
    }

    public void setSun_raise_time(String sun_raise_time) {
        this.sun_raise_time = sun_raise_time;
    }

    public String getSun_fall_time() {
        return sun_fall_time;
    }

    public void setSun_fall_time(String sun_fall_time) {
        this.sun_fall_time = sun_fall_time;
    }

    public String getDay_rahu_start_time() {
        return day_rahu_start_time;
    }

    public void setDay_rahu_start_time(String day_rahu_start_time) {
        this.day_rahu_start_time = day_rahu_start_time;
    }

    public String getDay_rahu_end_time() {
        return day_rahu_end_time;
    }

    public void setDay_rahu_end_time(String day_rahu_end_time) {
        this.day_rahu_end_time = day_rahu_end_time;
    }

    public String getNight_rahu_start_time() {
        return night_rahu_start_time;
    }

    public void setNight_rahu_start_time(String night_rahu_start_time) {
        this.night_rahu_start_time = night_rahu_start_time;
    }

    public String getNight_rahu_end_time() {
        return night_rahu_end_time;
    }

    public void setNight_rahu_end_time(String night_rahu_end_time) {
        this.night_rahu_end_time = night_rahu_end_time;
    }

    public String getSuba_dishawa() {
        return suba_dishawa;
    }

    public void setSuba_dishawa(String suba_dishawa) {
        this.suba_dishawa = suba_dishawa;
    }

    public String getMaru_dishawa() {
        return maru_dishawa;
    }

    public void setMaru_dishawa(String maru_dishawa) {
        this.maru_dishawa = maru_dishawa;
    }

    public RahuTime() {
    }

    public RahuTime(String day_rahu_start_time, String day_rahu_end_time, String night_rahu_start_time, String night_rahu_end_time) {
        this.day_rahu_start_time = day_rahu_start_time;
        this.day_rahu_end_time = day_rahu_end_time;
        this.night_rahu_start_time = night_rahu_start_time;
        this.night_rahu_end_time = night_rahu_end_time;
    }

    public RahuTime(String id, String day, String date, String sun_raise_time, String sun_fall_time, String day_rahu_start_time, String day_rahu_end_time, String night_rahu_start_time, String night_rahu_end_time, String suba_dishawa, String maru_dishawa) {
        this.id = id;
        this.day = day;
        this.date = date;
        this.sun_raise_time = sun_raise_time;
        this.sun_fall_time = sun_fall_time;
        this.day_rahu_start_time = day_rahu_start_time;
        this.day_rahu_end_time = day_rahu_end_time;
        this.night_rahu_start_time = night_rahu_start_time;
        this.night_rahu_end_time = night_rahu_end_time;
        this.suba_dishawa = suba_dishawa;
        this.maru_dishawa = maru_dishawa;
    }
}