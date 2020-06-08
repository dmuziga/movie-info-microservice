package rw.rwandamovie.movieinfoservice.models;

public class MovieSummary {
    private String id;
    private String title;
    private String overview12;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview12;
    }

    public void setOverview(String overview) {
        this.overview12 = overview;
    }
}
