package com.design.vikas.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikas kumar on 6/15/2016.
 */

//model class generated using the org.jsonschema2pojo
public class ResponseDetailModel implements Parcelable {

    private String poster_path;
    private Boolean adult;
    private String overview;
    private String release_date;
    private List<Integer> genreIds = new ArrayList<Integer>();
    private Integer id;
    private String original_title;
    private String originalLanguage;
    private String title;
    private String backdropPath;
    private Double popularity;
    private Integer voteCount;
    private Boolean video;
    private Double vote_average;

    /**
     *
     * @return
     * The posterPath
     */
    public String getPosterPath() {
        return poster_path;
    }


    public void setPosterPath(String poster_path) {
        this.poster_path = poster_path;
    }

    /**
     *
     * @return
     * The adult
     */
    public Boolean getAdult() {
        return adult;
    }

    /**
     *
     * @param adult
     * The adult
     */
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    /**
     *
     * @return
     * The overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     *
     * @param overview
     * The overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     *
     * @return
     * The releaseDate
     */
    public String getReleaseDate() {
        return release_date;
    }

    /**
     *
     * @param releaseDate
     * The release_date
     */
    public void setReleaseDate(String releaseDate) {
        this.release_date = releaseDate;
    }

    /**
     *
     * @return
     * The genreIds
     */
    public List<Integer> getGenreIds() {
        return genreIds;
    }

    /**
     *
     * @param genreIds
     * The genre_ids
     */
    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The originalTitle
     */
    public String getOriginalTitle() {
        return original_title;
    }

    /**
     *
     * @param originalTitle
     * The original_title
     */
    public void setOriginalTitle(String originalTitle) {
        this.original_title = originalTitle;
    }

    /**
     *
     * @return
     * The originalLanguage
     */
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    /**
     *
     * @param originalLanguage
     * The original_language
     */
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The backdropPath
     */
    public String getBackdropPath() {
        return backdropPath;
    }

    /**
     *
     * @param backdropPath
     * The backdrop_path
     */
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    /**
     *
     * @return
     * The popularity
     */
    public Double getPopularity() {
        return popularity;
    }

    /**
     *
     * @param popularity
     * The popularity
     */
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    /**
     *
     * @return
     * The voteCount
     */
    public Integer getVoteCount() {
        return voteCount;
    }

    /**
     *
     * @param voteCount
     * The vote_count
     */
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    /**
     *
     * @return
     * The video
     */
    public Boolean getVideo() {
        return video;
    }

    /**
     *
     * @param video
     * The video
     */
    public void setVideo(Boolean video) {
        this.video = video;
    }

    /**
     *
     * @return
     * The voteAverage
     */
    public Double getVoteAverage() {
        return vote_average;
    }

    /**
     *
     * @param voteAverage
     * The vote_average
     */
    public void setVoteAverage(Double voteAverage) {
        this.vote_average = voteAverage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.poster_path);
        dest.writeValue(this.adult);
        dest.writeString(this.overview);
        dest.writeString(this.release_date);
        dest.writeList(this.genreIds);
        dest.writeValue(this.id);
        dest.writeString(this.original_title);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.title);
        dest.writeString(this.backdropPath);
        dest.writeValue(this.popularity);
        dest.writeValue(this.voteCount);
        dest.writeValue(this.video);
        dest.writeValue(this.vote_average);
    }

    public ResponseDetailModel() {
    }

    protected ResponseDetailModel(Parcel in) {
        this.poster_path = in.readString();
        this.adult = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.overview = in.readString();
        this.release_date = in.readString();
        this.genreIds = new ArrayList<Integer>();
        in.readList(this.genreIds, Integer.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.original_title = in.readString();
        this.originalLanguage = in.readString();
        this.title = in.readString();
        this.backdropPath = in.readString();
        this.popularity = (Double) in.readValue(Double.class.getClassLoader());
        this.voteCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.video = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.vote_average = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<ResponseDetailModel> CREATOR = new Parcelable.Creator<ResponseDetailModel>() {
        @Override
        public ResponseDetailModel createFromParcel(Parcel source) {
            return new ResponseDetailModel(source);
        }

        @Override
        public ResponseDetailModel[] newArray(int size) {
            return new ResponseDetailModel[size];
        }
    };
}
