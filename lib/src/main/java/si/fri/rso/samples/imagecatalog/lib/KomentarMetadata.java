package si.fri.rso.samples.imagecatalog.lib;

import java.time.Instant;

public class KomentarMetadata {

    private Integer id;
    private String vsebina;
    private String image_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVsebina() {
        return vsebina;
    }

    public void setVsebina(String vsebina) {
        this.vsebina = vsebina;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }
}
