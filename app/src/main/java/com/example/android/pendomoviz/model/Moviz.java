package com.example.android.pendomoviz.model;

        import android.os.Parcel;
        import android.os.Parcelable;

        import com.google.gson.annotations.SerializedName;

        import java.util.ArrayList;
        import java.util.List;

public class Moviz implements Parcelable{

    public static final String IMAGE_URL_BASE_PATH = "https://image.tmdb.org/t/p/w500";

    @SerializedName("vote_count")
    private String voteCount;
    @SerializedName("id")
    private int id;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_average")
    private Double voteAverage;
    @SerializedName("title")
    private String title;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("genre_ids")
    private List<Integer> genreIds;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;



    public Moviz(String voteCount, int id, boolean video, double voteAverage, String title, double popularity, String posterPath, String originalLanguage,
                 String originalTitle, List<Integer> genreIds, String backdropPath, boolean adult, String overview, String releaseDate) {

        this.voteCount = voteCount;
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.genreIds = genreIds;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;

    }

    //constructor used for parcel


    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount){
        this.voteCount = voteCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public boolean isVideo() {
        return video;
    }

    public  void setVideo(boolean video){
        this.video = video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {

       return IMAGE_URL_BASE_PATH + posterPath ;
       // return  posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getBackdropPath() {
        return IMAGE_URL_BASE_PATH +  backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Moviz(Parcel parcel){

        voteCount = parcel.readString();
        id = parcel.readInt();
        video = (Boolean) parcel.readValue(null);
        voteAverage = parcel.readDouble();
        title = parcel.readString();
        popularity = parcel.readDouble();
        posterPath = parcel.readString();
        originalLanguage = parcel.readString();
        originalTitle = parcel.readString();
        genreIds = new ArrayList();
        parcel.readList(this.genreIds, Integer.class.getClassLoader());
        backdropPath = parcel.readString();
        adult = (Boolean) parcel.readValue(null);
        overview = parcel.readString();
        releaseDate = parcel.readString();

        //read and set saved values from parcel
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(voteCount);
        dest.writeInt(id);
        dest.writeValue(video);
        dest.writeDouble(voteAverage);
        dest.writeString(title);
        dest.writeDouble(popularity);
        dest.writeString(posterPath);
        dest.writeString(originalLanguage);
        dest.writeString(originalTitle);
        dest.writeList(genreIds);
        dest.writeString(backdropPath);
        dest.writeValue(adult);
        dest.writeString(overview);
        dest.writeString(releaseDate);
    }




    public static final  Parcelable.Creator<Moviz> CREATOR = new Parcelable.Creator<Moviz>(){

        @Override
        public Moviz createFromParcel(Parcel source) {
            return new Moviz(source);
        }

        @Override
        public Moviz[] newArray(int size) {
            return new Moviz[0];
        }
    };
}
