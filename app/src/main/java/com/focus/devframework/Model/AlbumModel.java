package com.focus.devframework.Model;

/**
 * Created by focus on 16/8/22.
 */
public class AlbumModel {

    /**
     * name : 不丹当地音乐
     * artist : 不丹
     * cover : http://192.168.36.163:8082/music/album/cover/1adsfa_1468835501838.jpeg
     * releaseTime : 2016-05-01
     * recordCompany :
     * id : 57ba6491568762c85579ac04
     */

    private String name;
    private String artist;
    private String cover;
    private String releaseTime;
    private String recordCompany;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getRecordCompany() {
        return recordCompany;
    }

    public void setRecordCompany(String recordCompany) {
        this.recordCompany = recordCompany;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
