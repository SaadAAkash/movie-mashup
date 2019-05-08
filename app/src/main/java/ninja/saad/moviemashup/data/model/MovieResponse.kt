package ninja.saad.moviemashup.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class MovieResponse(
    @JsonProperty("page") val page: Int?,
    @JsonProperty("total_pages") val totalPages: Int?,
    @JsonProperty("results") val results: List<Movie>?)