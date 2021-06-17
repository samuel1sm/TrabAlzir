package io.javabrains.springsecurityjwt.dto;

import java.util.List;

public class RetornoDTO {
    private List<GetImagesDTO> chaves;

    public RetornoDTO(List<GetImagesDTO> chaves) {
        this.chaves = chaves;
    }

    public List<GetImagesDTO> getChaves() {
        return chaves;
    }

    public void setChaves(List<GetImagesDTO> chaves) {
        this.chaves = chaves;
    }
}
