package org.agorava.instagram.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.agorava.instagram.model.InstagramProfile;
import org.agorava.instagram.model.Pagination;

import java.util.List;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramProfileListHolder {

    private final List<InstagramProfile> list;
    private final Pagination pagination;

    @JsonCreator
    public InstagramProfileListHolder(@JsonProperty("data") List<InstagramProfile> list
            , @JsonProperty("pagination") @JsonDeserialize(using = InstagramPaginationDeserializer.class) Pagination pagination) {
        this.list = list;
        this.pagination = pagination;
    }

    public List<InstagramProfile> getList() {
        return list;
    }

    public Pagination getPagination() {
        return pagination;
    }
}
